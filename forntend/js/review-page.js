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
		
	});
	
	