var btable;
var magicsuggest;
function initMagicsuggest() {
	var queryArray = initialQuery.split(',');
	if(queryArray.length == 1 && queryArray[0] == "") {
		queryArray = [];
	}
    magicsuggest = $('#magicsuggest').magicSuggest({
		data: tagUrl,
		method: 'post',
		displayField: 'tagName',
		valueField: 'tagName',
		placeholder: 'Wpisz swoje zainteresowania',
		value: queryArray,
		renderer: function(data){
			return data.tagName;
		}
    });
	$(magicsuggest).on('selectionchange', function(e,m){
	  updateTable();
	  console.log('lorem');
	});
}

 
initMagicsuggest();
initTable();
$('[data-toggle="tooltip"]').tooltip();

function initTable() {
	console.log(magicsuggest.getValue());
	$.ajax({
		url: searchUrl,
		data:JSON.stringify({
			"tags": magicsuggest.getValue()
		}),
		cache: false,
		type: 'post',
		dataType: 'json',
		//contentType: "application/json",
		//async: false,
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


function updateTable() {
	console.log(magicsuggest.getValue());
	$.ajax({
		url: searchUrl,
		data:JSON.stringify({
			"tags": magicsuggest.getValue()
		}),
		cache: false,
		type: 'post',
		dataType: 'json',
		//contentType: "application/json",
		//async: false,
		context: document.body
	}).done(function(prace) {
		btable.load(prace);
	});
}