
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
 
