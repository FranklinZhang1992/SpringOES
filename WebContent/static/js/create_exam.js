$(function() {
	function getRootPath() 
	{ 
	 var pathName = window.location.pathname.substring(1); 
	 var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/')); 
	 return window.location.protocol + '//' + window.location.host + '/'+ webName + '/'; 
	} 

	$("#create").click(function() {
		var zh = /^[1-9]+[0-9]*]*$/;
		var xi =  /^(?:0\.\d+|[01](?:\.0)?)$/;
		var jsName = $('#examName').val();
	    var jsSingleQuestionScore = $('#singleQuestionScore').val();
	    var jsQuestionQuantity = $('#questionQuantity').val();
	    var jsDuration = $('#duration').val();
	    var jsPassStandard = $('#passStandard').val();
	    
	    var nameSpan = $('#nameSpan');
	    var singleQuestionScoreSpan = $('#singleQuestionScoreSpan');
	    var questionQuantitySpan = $('#questionQuantitySpan');
	    var durationSpan = $('#durationSpan');
	    var passStandardSpan = $('#passStandardSpan');
	    var iserror = 0;


	    if (!jsName) {
	    	nameSpan.html("Exam Name is required");
	        iserror = 1;
	    } else {
	    	nameSpan.html("");
	    }
	    if (!jsSingleQuestionScore) {
	    	singleQuestionScoreSpan.html("Single Question Score is required");
	        iserror = 1;
	    } else {
	    	singleQuestionScoreSpan.html("");
	    }
	    if (!jsQuestionQuantity) {
	    	questionQuantitySpan.html("Question Quantity is required");
	        iserror = 1;
	    } else {
	    	questionQuantitySpan.html("");
	    }
	    if (!jsDuration) {
	    	durationSpan.html("Duration is required");
	        iserror = 1;
	    }  else {
	    	durationSpan.html("");
	    }
	    if (!jsPassStandard) {
	    	passStandardSpan.html("Pass Standard is required");
	        iserror = 1;
	    } else {
	    	passStandardSpan.html("");
	    }
	    
	    if (!zh.test(jsSingleQuestionScore)) {
	    	singleQuestionScoreSpan.html("Single Question Score must be integer");
	        iserror = 1;
	    } else {
	    	singleQuestionScoreSpan.html("");
	    }
	    if (!zh.test(jsQuestionQuantity)) {
	    	questionQuantitySpan.html("Question Quantity must be integer");
	        iserror = 1;
	    } else {
	    	questionQuantitySpan.html("");
	    }
	    if (!zh.test(jsDuration)) {
	    	durationSpan.html("Duration must be integer");
	        iserror = 1;
	    } else {
	    	durationSpan.html("");
	    }
	    if (!xi.test(jsPassStandard)) {
	    	passStandardSpan.html("Pass Standard must be double");
	        iserror = 1;
	    } else {
	    	passStandardSpan.html("");
	    }

	    if (iserror === 1) {
	        return false;
	    }
	    if (confirm("Are you sure to create?")) {
	        document.getElementById("createExamForm").submit();
	    }
	    return false;
	});

	$('#cancel').click(function() {
		if (confirm("Are you sure to cancel?")) {
			location.href=getRootPath() + "exam/list/1/?type=NAME&keyword=";
	    }
		return false;
	});
});


