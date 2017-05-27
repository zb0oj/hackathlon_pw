var magicsuggest;
function initMagicsuggest() {
	var queryArray = initialQuery.split(',');
	if(queryArray.length == 1 && queryArray[0] == "") {
		queryArray = [];
	}
    magicsuggest = $('#magicsuggest').magicSuggest({
		data: tagUrl,
		method: 'get',
		displayField: 'tag',
		valueField: 'tag',
		placeholder: 'Wpisz swoje zainteresowania',
		value: queryArray,
		renderer: function(data){
			return data.tag;
		}
    });
	$(magicsuggest).on('selectionchange', function(e,m){
	  initTable();
	});
}


function diffFormatter(value) {
	width = value * 2 * 10;
	return '<div class="progress"><div class="progress-bar progress-bar-success" style="width: '+width+'%"></div></div>'
}

function rateFormatter(value) {
	val = '';
	value.forEach(function(entry) {
		color = 'red';
		if(entry.frequency > 3.0) {
			color = 'orange';
		}
		if (entry.frequency > 4.0) {
			color = 'green';
		}
		val += '<span data-toggle="tooltip" data-placement="bottom" data-html="true" title="'+entry.title+'" class="'+color+'"><i class="fa '+entry.icon+'" aria-hidden="true"></i> <span class="rate">'+entry.frequency+'</span> </span>&nbsp';
	});
	return val;
}

function relatesTagFormatter(value) {
	tags = '';
	value.forEach(function(entry) {
		tags += entry.tagName + ' ';
	});
	return '<a class="" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" data-html="true" title="'+tags+'"><i class="fa fa-question-circle" ></i></a>';
}

function authorNameFormatter(value) {
	id = value.id;
	name = value.name;
	return '<a target="_BLANK" href="profile.php?id=' + id + '">' + name + '</a>';
}
 
 function ratesSorter(a, b) {
	sumA = 0;
	sumB = 0;
	a.forEach(function(entry) {
		sumA += entry.frequency;
	});
	b.forEach(function(entry) {
		sumB += entry.frequency;
	});	 
    if (sumA < sumB) return 1;
    if (sumA > sumB) return -1;
	$('[data-toggle="tooltip"]').tooltip();
    return 0;
}
 
initMagicsuggest();
initTable();
$('[data-toggle="tooltip"]').tooltip();

function initTable() {
	$.ajax({
		url: searchUrl,
		data: {
			"tags": magicsuggest.getValue()
		},
		cache: false,
		type: 'get',
		context: document.body
	}).done(function(prace) {
		$('#table').bootstrapTable({
			data: prace
		}).on('all.bs.table', function (e, name, args) {
			$('[data-toggle="tooltip"]').tooltip();
		});
		$('[data-toggle="tooltip"]').tooltip();
		$('body').removeClass('loading');
		$('div.container').removeClass('hidden');
	});
}

