$( document ).ready(function() {
	    var correctAnswer = $('.correct_answer').val();
	    $("#optionradio" + correctAnswer).attr("checked","checked");

	function getRootPath() 
	{ 
	 var pathName = window.location.pathname.substring(1); 
	 var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/')); 
	 return window.location.protocol + '//' + window.location.host + '/'+ webName + '/'; 
	} 

	

	$('#create').click(function() {		
		var jsTitle = $('#questionTitle').val();
		var jsOptionA = $('#optionA').val();
		var jsOptionB = $('#optionB').val();
		var jsOptionC = $('#optionC').val();	
	    var jsOptionD = $('#optionD').val();
	    var radios = document.getElementsByName("answer");
	    var jsanswer = "";
	    for (var i = 0; i < radios.length; i++) 
	    {
	        if (radios[i].checked) 
	            jsanswer = radios[i].value;
	    }

	    var titleSpan = $('#titleSpan');
	    var optionASpan = $('#optionASpan');
	    var optionBSpan = $('#optionBSpan');
	    var optionCSpan = $('#optionCSpan');
	    var optionDSpan = $('#optionDSpan');
	    var answerSpan = $('#answerSpan');
	    var iserror = 0;
	    
	    if (!jsTitle) {
	    	titleSpan.html("question title is required");
	    	iserror = 1;
	    } else {
	    	titleSpan.html("");
	    }
	    if (!jsOptionA) {
	    	optionASpan.html("option A is required");
	    	iserror = 1;
	    } else {
	    	optionASpan.html("");
	    }
	    if (!jsOptionB) {
	    	optionBSpan.html("option B is required");
	    	iserror = 1;
	    } else {
	    	optionBSpan.html("");
	    }
	    if (!jsOptionC) {
	    	optionCSpan.html("option C is required");
	    	iserror = 1;
	    } else {
	    	optionCSpan.html("");
	    }
	    if (!jsOptionD) {
	    	optionDSpan.html("option D is required");
	    	iserror = 1;
	    } else {
	    	optionDSpan.html("");
	    }
	    if (!jsanswer) {
	    	answerSpan.html("answer is required");
	    	iserror = 1;
	    } else {
	    	answerSpan.html("");
	    }
	    
	    if (iserror === 1) {
	        return false;
	    }
		if (confirm("Are you sure to save?")) {
	        document.getElementById("saveQuestionForm").submit();
	    }
		return false;
	});

	$('#cancel').click(function() {
		if (confirm("Are you sure to cancel?")) {
			location.href=getRootPath() + "question/list/1/?keyword=";
	    }
	    return false;
	});

});