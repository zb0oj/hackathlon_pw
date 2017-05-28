$.ajax({
		url: reviewUrl + promotorId,
		cache: false,
		type: 'get',
		context: document.body
	}).done(function(promotor) {
		console.log(promotor);
		$('#name').html('<a href="profile.php?id='+promotor.authorId+'">'+promotor.authorName'</a>');
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

function saveRate() {
	objectToSave = {};
	objectToSave['id'] = promotorId;
	objectToSave['friendly'] = $('input[name=friendly]').val();
	objectToSave['rates'] = [];
	objectToSave['rates'][0] = {};
	objectToSave['rates'][0]['icon'] = "fa-exclamation-triangle"; 
	objectToSave['rates'][0]['rate'] = $('input[name=konstruktywnosc]').val();
	objectToSave['rates'][1] = {};
	objectToSave['rates'][1]['icon'] = "fa-comments"; 
	objectToSave['rates'][1]['rate'] = $('input[name=komunikatywnosc]').val();
	objectToSave['rates'][2] = {};
	objectToSave['rates'][2]['icon'] = "fa-thumbs-up"; 
	objectToSave['rates'][2]['rate'] = $('input[name=zaangazowanie]').val();
		
	$.ajax({
		url: saveReviewUrl,
		data:JSON.stringify(objectToSave),
		cache: false,
		type: 'post',
		dataType: 'json',
		context: document.body
	}).done(function() {
		$('.main').addClass('hidden');
		$('.thank-you').removeClass('hidden');
	}).error(function(e) {
		$('.main').addClass('hidden');
		$('.thank-you').removeClass('hidden');
	});

}