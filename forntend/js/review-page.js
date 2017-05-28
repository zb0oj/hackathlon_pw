$.ajax({
		url: reviewUrl + promotorId,
		cache: false,
		type: 'get',
		context: document.body
	}).done(function(promotor) {
		$('#name').html(promotor.authorName);
		$('#department').html(promotor.department);
		$('#mail').html(promotor.mail);
		$('#roomInfo').html(promotor.roomInfo);
		$('#title').html(promotor.title);
		$('#stage').html(promotor.stage);
		$('#profile').load(promotor.photo, function(response, status, xhr) {
			if (status != "error") {
				photo = '<img src="'+promotor.photo+'" alt="" />';
				$('#profile').html(photo);
			}
		});
		
	});
	
var friendlySaved = false;	
	
function setFriendly(value) {
	if(friendlySaved) {
		return;
	}
	$('.progbar progress-bar').removeClass('hidden');
	if(value == -3) {
		$('div#friendly-3').removeClass('hidden');
		$('div#friendly-2').removeClass('hidden');
		$('div#friendly-1').removeClass('hidden');
		$('div#friendly1').addClass('hidden');
		$('div#friendly2').addClass('hidden');
		$('div#friendly3').addClass('hidden');
	}
	if(value == -2) {
		$('div#friendly-3').addClass('hidden');
		$('div#friendly-2').removeClass('hidden');
		$('div#friendly-1').removeClass('hidden');
		$('div#friendly1').addClass('hidden');
		$('div#friendly2').addClass('hidden');
		$('div#friendly3').addClass('hidden');
	}
	if(value == -1) {
		$('div#friendly-3').addClass('hidden');
		$('div#friendly-2').addClass('hidden');
		$('div#friendly-1').removeClass('hidden');
		$('div#friendly1').addClass('hidden');
		$('div#friendly2').addClass('hidden');
		$('div#friendly3').addClass('hidden');
	}
	if(value == 1) {
		$('div#friendly-3').addClass('hidden');
		$('div#friendly-2').addClass('hidden');
		$('div#friendly-1').addClass('hidden');
		$('div#friendly1').removeClass('hidden');
		$('div#friendly2').addClass('hidden');
		$('div#friendly3').addClass('hidden');
	}
	if(value == 2) {
		$('div#friendly-3').addClass('hidden');
		$('div#friendly-2').addClass('hidden');
		$('div#friendly-1').addClass('hidden');
		$('div#friendly1').removeClass('hidden');
		$('div#friendly2').removeClass('hidden');
		$('div#friendly3').addClass('hidden');
	}
	if(value == 3) {
		$('div#friendly-3').addClass('hidden');
		$('div#friendly-2').addClass('hidden');
		$('div#friendly-1').addClass('hidden');
		$('div#friendly1').removeClass('hidden');
		$('div#friendly2').removeClass('hidden');
		$('div#friendly3').removeClass('hidden');
	}
}

function saveFriendly(value) {
	$('input[name=friendly]').val(value);
	friendlySaved = true;
} 	

function setStar(field, value) {
	$('#'+field+', #'+field+'2, #'+field+'3, #'+field+'4, #'+field+'5').removeClass('fa-star').addClass('fa-star-o');
	for(i=1; i<=value; i++) {
		$('#'+field+i).removeClass('fa-star-o');
		$('#'+field+i).addClass('fa-star');
	}
	$('input[name='+field+']').val(value);
}