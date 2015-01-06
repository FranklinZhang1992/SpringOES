$(function() {
	function getRootPath() 
	{ 
	 var pathName = window.location.pathname.substring(1); 
	 var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/')); 
	 return window.location.protocol + '//' + window.location.host + '/'+ webName + '/'; 
	} 

	$("#edit").click(function() {
		var jsName = $('#examName').val();
		var nameSpan = $('#nameSpan');
		var iserror = 0;
		if (!jsName) {
			nameSpan.html("Exam Name is required");
			iserror = 1;
		} else {
			nameSpan.html("");
		}
		if (iserror === 1) {
			return false;
		}
		
	    if (confirm("Are you sure to create?")) {
	        document.getElementById("editExamForm").submit();
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
