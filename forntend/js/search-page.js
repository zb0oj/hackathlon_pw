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
		placeholder: 'Wpisz wyszukiwaną frazę',
		value: queryArray,
		renderer: function(data){
			return data.tagName;
		}
    });
	$(magicsuggest).on('selectionchange', function(e,m){
	  updateTable();
	});
}

 
initMagicsuggest();
initTable();
$('[data-toggle="tooltip"]').tooltip();

function initTable() {
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
		btable = $('#table').bootstrapTable({
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
		if(btable) {
			$('.well').html('<table id="table" class="table table-striped table-hover table-condensed"><thead><tr><th data-field="title" data-sortable="true">Tytuł pracy</th><th data-field="difficulity" data-sortable="true" data-formatter="diffFormatter">Poziom trudności</th><th data-field="author" data-formatter="authorNameFormatter" data-sortable="true">Promotor</th><th data-field="author.department" data-sortable="true">Wydział</th><th data-field="author.relatedTags" data-formatter="relatesTagFormatter">Powiązania</th><th data-field="author.relatedTags" data-formatter="actionsFormatter">Akcje</th></tr></thead></table>');
			btable = $('#table').bootstrapTable({
				data: prace
			}).on('all.bs.table', function (e, name, args) {
				$('[data-toggle="tooltip"]').tooltip();
			});
		}
	});
}