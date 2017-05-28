

function diffFormatter(value) {
	width = value * 2 * 10;
	return '<div class="progress"><div class="progress-bar progress-bar-success" style="width: '+width+'%"></div></div>'
}

function rateFormatter(value) {
	val = '';
	if(value)
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
	i=0;
	tags = '';
	shortTags = '';
	if(value)
	value.forEach(function(entry) {
		tags += entry.tagName + ' ';
		shortTags += (i<2)?entry.tagName+' ':'';
		i++;
	});
	return '<span data-toggle="tooltip" data-placement="bottom" data-html="true" title="'+tags+'" style="font-size: 9px;"><i class="fa fa-question-circle" style="font-size: 12px;" ></i> '+shortTags+'</span>';
}

function relatesTagFormatter2(value) {
	tags = '<div style="line-height: 21px;">';
	if(value)
	value.forEach(function(entry) {
		tags +=  '<a href="search.php?query='+entry.tagName+'" class="btn btn-default btn-xs">'+entry.tagName+'</a>&nbsp;';
	});
	tags += '</div>';
	return tags;
}

function authorNameFormatter(value) {
	id = value.id;
	name = value.name;
	return '<a target="_BLANK" href="profile.php?id=' + id + '">' + name + '</a>';
}

function actionsFormatter(v) {
	return '<a class="btn btn-default btn-xs" href="#">Podejmij</a>';
}
 
 function ratesSorter(a, b) {
	sumA = 0;
	sumB = 0;
	if(a)
	a.forEach(function(entry) {
		sumA += entry.frequency;
	});
	if(b)
	b.forEach(function(entry) {
		sumB += entry.frequency;
	});	 
    if (sumA < sumB) return 1;
    if (sumA > sumB) return -1;
	$('[data-toggle="tooltip"]').tooltip();
    return 0;
}