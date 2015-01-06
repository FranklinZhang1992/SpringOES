
$('#delete').click(function() {
		//alert($(this).attr('title'));
	    //alert($(this).attr('coords'));
		alert($(this)).attr('questionId');
	});

$('.search').click(function() {
	var keyword = "${keyword}"
	$(this).attr('value', keyword);
});
/*$(function(){
	var keyword = "keyword";
    //alert("ss");

    
    //$("#text").val(keyword);
    //$("#text").attr("value", keyword);
});*/

function getRootPath() 
{ 
 var pathName = window.location.pathname.substring(1); 
 var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/')); 
 return window.location.protocol + '//' + window.location.host + '/'+ webName + '/'; 
 alert (getRootPath());
} 


$('#btn').click(function() {
	

	var keyword = "111";
	location.href=getRootPath() + "question/list/" + 1 + "/?keyword=" + keyword;
});


