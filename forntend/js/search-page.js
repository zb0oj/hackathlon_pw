
function initMagicsuggest() {
    $('#magicsuggest').magicSuggest({
		data: 'https://private-d82ca-hackathlon.apiary-mock.com/search',
		method: 'get',
		displayField: 'tag',
		placeholder: 'Wpisz swoje zainteresowania',
		renderer: function(data){
			return data.tag;
		}
    });
}

initMagicsuggest();
$('[data-toggle="tooltip"]').tooltip();

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
    return 0;
}
 
$.ajax({
  url: searchUrl,
  data: {
	  "tagsId": [1, 2, 3]
  },
  type: 'get',
  context: document.body
}).done(function(prace) {
	$('#table').bootstrapTable({
		data: prace
	});
$('[data-toggle="tooltip"]').tooltip();
});

