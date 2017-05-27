$.ajax({
		url: profileUrl + promotorId,
		cache: false,
		type: 'get',
		context: document.body
	}).done(function(promotor) {
		$('#name').html(promotor.name);
		$('#department').html(promotor.department);
		$('#mail').html(promotor.mail);
		$('#roomInfo').html(promotor.roomInfo);
		
		$('#profile').load(promotor.photo, function(response, status, xhr) {
			if (status != "error") {
				photo = '<img src="'+promotor.photo+'" alt="" />';
				$('#profile').html(photo);
			}
		});
		
		if(promotor.friendly > 0) {
			$('#friendlyMinus').css({width: 0});
			$('#friendlyPlus').css({width: promotor.friendly + '%'});
			$('#friendlyMinus').addClass('hidden');			
		} else {
			$('#friendlyPlus').css({width: 0});
			$('#friendlyMinus').css({width: -1*promotor.friendly + '%'});
			$('#friendlyPlus').addClass('hidden');			
		}
		
		promotor.rates.forEach(function(entry) {
			color = 'red';
			if(entry.frequency > 3.0) {
				color = 'orange';
			}
			if (entry.frequency > 4.0) {
				color = 'green';
			}
			rate = '<div class="col-sm-3" ><div class="char-title">'+entry.title+'</div><div class="char-review '+color+'"><i class="fa '+entry.icon+' fa-2" aria-hidden="true"></i><span>&nbsp;<span class="review">'+(entry.frequency)+'</span>/5</span></div></div>';
			$('#rates').append(rate);
			
		});
		
		var classes = [];
		
		promotor.relatedTags.forEach(function(entry){
			classes[classes.length] = {"id": entry.tagName, "value": entry.frequency};			
		});

		var svg = d3.select("svg"),
		width = +svg.attr("width"),
		height = +svg.attr("height");
    

		var format = d3.format(",d");
		var color = d3.scaleOrdinal(d3.schemeCategory20c);
		var pack = d3.pack()
			.size([width, height])
			.padding(1.5);

		var root = d3.hierarchy({
			children: classes
		})
			.sum(function(d) {
				return d.value;
			})
			.each(function(d) {
				if (id = d.data.id) {
					var id, i = id.lastIndexOf(".");
					d.id = id;
					d.package = id.slice(0, i);
					d.class = id.slice(i + 1);
				}
			});

		var node = svg.selectAll(".node")
			.data(pack(root).leaves())
			.enter().append("g")
			.attr("class", "node")
			.attr("transform", function(d) {
				return "translate(" + d.x + "," + d.y + ")";
			});

		node.append("circle")
			.attr("id", function(d) {
				return d.id;
			})
			.attr("r", function(d) {
				return d.r;
			})
			.style("fill", function(d) {
				return color(d.package);
			});

		node.append("clipPath")
			.attr("id", function(d) {
				return "clip-" + d.id;
			})
			.append("use")
			.attr("xlink:href", function(d) {
				return "#" + d.id;
			});

		node.append("text")
			.attr("clip-path", function(d) {
				return "url(#clip-" + d.id + ")";
			})
			.selectAll("tspan")
			.data(function(d) {
				return d.class.split(/(?=[A-Z][^A-Z])/g);
			})
			.enter().append("tspan")
			.style("cursor", "pointer")
			.attr("onclick", function(d, i, nodes) {
				return 'seeTag("'+d+'")';
			})
			.attr("x", 0)
			.attr("y", function(d, i, nodes) {
				return 13 + (i - nodes.length / 2 - 0.5) * 10;
			})
			.text(function(d) {
				return d;
			});

		node.append("title")
			.text(function(d) {
				return d.id + "\n" + format(d.value);
			});
		initTables();
	
	});
	
	
function initTables() {
	$.ajax({
		url: searchPromotorUrl + promotorId,
		cache: false,
		type: 'get',
		context: document.body
	}).done(function(prace) {
		$('#table').bootstrapTable({
			data: prace
		}).on('all.bs.table', function (e, name, args) {
			$('[data-toggle="tooltip"]').tooltip();
		});
		$.ajax({
			url: searchPromotorArchiveUrl + promotorId,
			cache: false,
			type: 'get',
			context: document.body
		}).done(function(prace) {
			$('#tableArchive').bootstrapTable({
				data: prace
			}).on('all.bs.table', function (e, name, args) {
				$('[data-toggle="tooltip"]').tooltip();
			});
			$('[data-toggle="tooltip"]').tooltip();
			$('body').removeClass('loading');
			$('div.container').removeClass('hidden');
		});
	});
}
	
function seeTag(value) {
	window.location.href = "search.php?query="+value;
}