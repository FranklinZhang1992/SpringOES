$(function() {
	document.onkeydown = function(e) {
		var ev = document.all ? window.event : e;
		if (ev.keyCode == 13) {
			return $('#dosearch').click();
		}
	}
	
	function getRootPath() 
	{ 
	 var pathName = window.location.pathname.substring(1); 
	 var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/')); 
	 return window.location.protocol + '//' + window.location.host + '/'+ webName + '/'; 
	} 

	$('.delete').click(function() {
		var pagenumber = $(this).attr("pageNumber");
		var questionid = $(this).attr("questionId");
		var keyword = $('#title').val();
		if (confirm("Are you sure to delete?")) {
			var url = getRootPath() + "question/delete/"+ pagenumber + "/" + questionid + "?keyword=" + keyword;
			//var url = getRootPath() + "question/delete/" + questionid; 
			$.get(url,function(data,status){
				//$('tr[questionId=' + questionid + ']' ).css({'display': 'none'});
				window.location.href = url;
			});
			


	    }
		return false;
	});

	$('.first').click(function() {
		var pagenumber = 1;
		var keyword = $('#title').val();
		var url = getRootPath() + "question/list/"+ pagenumber + "/?keyword=" + keyword;
		$.get(url,function(data,status){
			window.location.href = url;
		});
		return false;
	});

	$('.last').click(function() {
		var totalpages = $(this).attr("totalpages");
		var keyword = $('#title').val();
		var url = getRootPath() + "question/list/"+ totalpages + "/?keyword=" + keyword;
		$.get(url,function(data,status){
			window.location.href = url;
		});
		return false;
	});

	$('.before').click(function() {
		var pagenumber = $(this).attr("pageNumber");
		var keyword = $('#title').val();
		var page = parseInt(pagenumber, 10);
		page -= 1;
		if (page > 0) {
			var url = getRootPath() + "question/list/"+ page + "/?keyword=" + keyword;
			$.get(url,function(data,status){
				window.location.href = url;
			});
		}
		return false;
	});

	$('.next').click(function() {
		var pagenumber = $(this).attr("pageNumber");
		var keyword = $('#title').val();
		var totalpages = $(this).attr("totalpages");
		var pagenumber = $(this).attr("pageNumber");
		var page = parseInt(pagenumber, 10);
		var totalpage = parseInt(totalpages, 10);
		page += 1;
		if (page <= totalpage) {
			var url = getRootPath() + "question/list/"+ page + "/?keyword=" + keyword;
			$.get(url,function(data,status){
				window.location.href = url;
			});
		}
		return false;
	});

	$('#dosearch').click(function searchmethod() {
		var keyword = $('#title').val();
		var url = getRootPath() + "question/list/"+ 1 + "/?keyword=" + keyword;
		$.get(url,function(data,status){
			window.location.href = url;
		});
		return false;
	});
});

