$.ajax({
  url: surveyUrl,
  context: document.body
}).done(function(surveyQuestions) {
	var steps = $("div#steps");
	var questions = $('div#questions');
	var data = surveyQuestions[0];
	
	data.forEach(function(entry) {
		console.log(entry);
	});
	
});
