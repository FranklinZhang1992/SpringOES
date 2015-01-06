$( document ).ready(function() {
	var keyword = $('#title').val();
    var searchtype = $('.type').val();
    $("#title").attr("value", keyword);
    $("#search" + searchtype).attr("checked", "checked");	
	    
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

	
	

	$('.first').click(function() {
		var pagenumber = 1;
		var keyword = $('#title').val();
		var radios = document.getElementsByName("search_type");
	    for (var i = 0; i < radios.length; i++) 
	    {
	        if (radios[i].checked) 
	            searchtype = radios[i].value;
	    }
		var url = getRootPath() + "exam/list/" + 1 + "/?type=" + searchtype + "&keyword=" + keyword;
		$.get(url,function(data,status){
			window.location.href = url;
		});
		return false;
	});

	$('.last').click(function() {
		var totalpages = $(this).attr("totalpages");
		var keyword = $('#title').val();
		var radios = document.getElementsByName("search_type");
	    for (var i = 0; i < radios.length; i++) 
	    {
	        if (radios[i].checked) 
	            searchtype = radios[i].value;
	    }
		var url = getRootPath() + "exam/list/" + totalpages + "/?type=" + searchtype + "&keyword=" + keyword;
		$.get(url,function(data,status){
			window.location.href = url;
		});
		return false;
	});

	$('.before').click(function() {
		var pagenumber = $(this).attr("pageNumber");
		var keyword = $('#title').val();
		var page = parseInt(pagenumber, 10);
		var radios = document.getElementsByName("search_type");
	    for (var i = 0; i < radios.length; i++) 
	    {
	        if (radios[i].checked) 
	            searchtype = radios[i].value;
	    }
		page -= 1;
		if (page > 0) {
			var url = getRootPath() + "exam/list/" + page + "/?type=" + searchtype + "&keyword=" + keyword;
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
		var radios = document.getElementsByName("search_type");
	    for (var i = 0; i < radios.length; i++) 
	    {
	        if (radios[i].checked) 
	            searchtype = radios[i].value;
	    }
		page += 1;
		if (page <= totalpage) {
			var url = getRootPath() + "exam/list/" + page + "/?type=" + searchtype + "&keyword=" + keyword;
			$.get(url,function(data,status){
				window.location.href = url;
			});
		}
		return false;
	});

	$('#dosearch').click(function() {
		var keyword = $('#title').val();
		var radios = document.getElementsByName("search_type");
	    for (var i = 0; i < radios.length; i++) 
	    {
	        if (radios[i].checked) 
	            searchtype = radios[i].value;
	    }
	    var url = getRootPath() + "exam/list/" + 1 + "/?type=" + searchtype + "&keyword=" + keyword;
		$.get(url,function(data,status){
			window.location.href = url;
		});
		return false;
	});
	
});
