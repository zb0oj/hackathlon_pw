
var currentStep = 0;
var stepCounter = 0;

$.ajax({
  url: surveyUrl,
  context: document.body
}).done(function(surveyQuestions) {
	var steps = $("div#steps");
	var questions = $('form#questions');
	var data = surveyQuestions[0];
	
	data.forEach(function(entry) {
		var stepToAppend = '<div class="step" data-step-id="'+stepCounter+'">Krok ' + (stepCounter+1) + '</div>';
		var questionToAppend = '';
		
		if(entry.type == "checkbox") {
			questionToAppend = '<div class="form-group question" data-question-id="'+entry.questionId+'"><label class="col-lg-2 control-label">' + entry.question + '</label>';
			entry.choices.forEach(function(choice) {
				questionToAppend += '<div class="col-lg-3"><label><input type="checkbox" name="optionsRadios" id="checkbox" value="checkbox" checked="">'+choice.value+'</label></div>';
			});
			questionToAppend += '</div>';
		}
		if(entry.type == "select") {
			questionToAppend = '<div class="form-group question" data-question-id="'+entry.questionId+'"><label for="select" class="col-lg-2 control-label">' + entry.question + '</label><div class="col-lg-10"><select class="form-control" id="select">';
			entry.choices.forEach(function(choice) {
				questionToAppend += '<option>'+choice.value+'</option>';
			});
			questionToAppend += '</select></div></div>';
		}
		
		if(entry.type == "radio") {
			questionToAppend = '<div class="form-group question" data-question-id="'+entry.questionId+'"><label class="col-lg-2 control-label">' + entry.question + '</label><div class="col-lg-10">';
			entry.choices.forEach(function(choice) {
				questionToAppend += '<div class="radio"><label><input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">'+choice.value+'</label></div>';
			});
			questionToAppend += '</div></div>';
		}
		
		if(entry.type == "yesno") {
			questionToAppend = '<div class="form-group question" data-question-id="'+entry.questionId+'"><div class="col-lg-10 col-lg-offset-2"><p>' + entry.question + '</p><button type="reset" class="btn btn-default">Tak</button>&nbsp;<button type="submit" class="btn btn-primary">Nie</button></div></div>';
		}
		
		if(entry.type == "tags") {
			questionToAppend = '<div class="form-group question" data-question-id="'+entry.questionId+'"><div class="col-lg-12"><div id="magicsuggest"></div></div></div>';
			initMagicsuggest(entry.question);
		}
		
		questions.append(questionToAppend);
		steps.append(stepToAppend);
		stepCounter++;
		
	});
	refreshFormState();
	initMagicsuggest();
	$('.step').click(function(e) {
		var button = $(this);
		goToStep(button.data('step-id'))
	});
});

function initMagicsuggest(p) {
	console.log(p);
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

function nextStep(e) {
	currentStep += 1;	
	refreshFormState();
}

function prevStep(e) {
	currentStep -= 1;	
	refreshFormState();
}

function goToStep(step) {
	currentStep = step;
	refreshFormState();	
}

function refreshFormState() {	
	$('.step').removeClass('current');
	$('.step').removeClass('done');
	$('.question').hide();
	$($('.step')[currentStep]).addClass('current');
	$($('.question')[currentStep]).show();
	
	if(currentStep+1 == stepCounter) {
		$('button.next').attr("disabled", true);
		$('button.next').addClass('hidden');
		$('button.save').removeClass('hidden');
	} else {
		$('button.next').attr("disabled", false);
		$('button.save').addClass('hidden');
		$('button.next').removeClass('disabled');
		$('button.next').removeClass('hidden');
	}
	
	if(currentStep == 0) {
		$('button.back').attr("disabled", true);
		$('button.back').addClass('disabled');
	} else {
		$('button.back').attr("disabled", false);
		$('button.back').removeClass('disabled');
	}
	
	for(i=0; i < currentStep; i++) {
		$($('.step')[i]).addClass('done');
	}
}