var magicsuggest;
function initMagicsuggest() {
	var queryArray = initialQuery.split(',');
	if(queryArray.length == 1 && queryArray[0] == "") {
		queryArray = [];
	}
    magicsuggest = $('#magicsuggest').magicSuggest({
		data: tagUrl,
		method: 'post',
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
		type: 'post',
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

