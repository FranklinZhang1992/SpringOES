$(function() {

  var listtable = function(pagenumber, keyword, field, method, pagesize) {
    $('.style-table').empty();
    $.ajax( {
      type : "get",
      url : contextURL + "/question/listb",
      dataType : "json",
      async : false,
      data : {
        "pagenumber" : pagenumber,
        "keyword" : keyword,
        "field" : field,
        "method" : method,
        "pagesize" : pagesize
      },
      success : function(obj) {
        if (obj.totalCount === 0) {
          $("ul li").remove();
          $(".style-table").append(
              "<tr><td style='text-align: center'>" + "No Result !"
                  + "</td></tr>");
          return false;
        }
        $.each(obj.data, function(i, item) {
          var title = item.title.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
          $(".style-table").append(
              "<tr questionId=" + item.id + "><td class='table-rowa'>"
                  + item.qId + "</td><td class='table-rowb' title=\"" + title + "\">" + title
                  + "</td><td class='table-rowc'>" + item.answer
                  + "</td><td class='table-rowd'>" + item.lastUpdatedTime
                  + "</td><td class='table-rowe'>" + "&nbsp;"
                  + "<a class='edit' questionId=" + item.id
                  + ">Edit</a>&nbsp;&nbsp;&nbsp;"
                  + "<a class='delete' questionId=" + item.id
                  + ">Delete</a></td></tr>");
        });
        $('.totalpage').text(obj.pageCount);
        initpage(pagenumber, obj.pageCount, obj.pageSize);
      }
    }).done(function() {
      
    }).fail(function() {
      alert("fail");
    });
  };

  $('.menu-text:eq(1)').click(function() {
    var url = contextURL + "/exam/list/1?type=NAME&keyword=";
    window.location.href = url;
    return false;
  });

  $('.href-create').click(function() {
    var url = contextURL + "/question/create";
    window.location.href = url;
    return false;
  });

  var initpage = function(pagenumber, totalpage, pagesize) {
    var pn;
    $("li").remove();
    $("ul").append("<li value=first>|&lt;</li>");
    $("ul").append("<li value=previous>&lt;</li>");
    var i;
    if (totalpage <= 5) {
      for (i = 1; i <= totalpage; i++) {
        $("ul").append("<li value=" + i + ">" + i + "</li>");
      }
      pn = pagenumber + 1;
    } else {
      if (pagenumber > 3) {
        if (totalpage - pagenumber < 3) {
          for (i = totalpage - 4; i <= totalpage; i++) {
            $("ul").append("<li value=" + i + ">" + i + "</li>");
          }
          pn = 6 - (totalpage - pagenumber);
        } else {
          for (i = pagenumber - 2; i <= pagenumber + 2; i++) {
            $("ul").append("<li value=" + i + ">" + i + "</li>");
          }
          pn = 4;
        }
      } else {
        for (i = 1; i <= 5; i++) {
          $("ul").append("<li value=" + i + ">" + i + "</li>");
        }
        pn = pagenumber + 1;
      }
    }
    $("ul").append("<li value=next>&gt;</li>");
    $("ul").append("<li value=last>&gt;|</li>");

    if (pagenumber === 1) {
      $('li:eq(0)').attr("class", "li-unable");
      $('li:eq(1)').attr("class", "li-unable");
    }
    if (pagenumber === totalpage) {
      var loc = $('li:last').index() - 1;
      $('li:eq(' + loc + ')').attr("class", "li-unable");
      $('li:last').attr("class", "li-unable");
    }
    $('li:eq(' + pn + ')').attr("class", "li-able");

    return false;
  };


  $('.foot-right ul').on('click', 'li', function() {
    var str = $('.li-able').val();
    var pagenumber = parseInt(str, 10);
    str = $('.totalpage').text();
    var totalpage = parseInt(str, 10);
    str = $('.page-size').val();
    var pagesize = parseInt(str, 10);
    var keyword = $('.style-text').val();
    var str = $(this).attr("value");
    var pageno = parseInt(str, 10);
    if (pagenumber === 1 && (str === 'first' || str === 'previous')) {
      return false;
    }
    if (pagenumber === totalpage && (str === 'next' || str === 'last')) {
      return false;
    }
    if (str === 'first') {
      pageno = 1;
    }
    if (str === 'previous') {
      pageno = pagenumber - 1;
    }
    if (str === 'next') {
      pageno = pagenumber + 1;
    }
    if (str === 'last') {
      pageno = totalpage;
    }
    var method = $('.table-header').attr("method");
    var field = $('.table-header').attr("field");
    listtable(pageno, keyword, field, method, pagesize);
    initpage(pageno, totalpage, pagesize);
    return false;
  });

  $('.style-table').on('click', '.delete', function() {
    var questionid = $(this).attr('questionid');
    if (confirm("Are you sure to delete?")) {
      var keyword = $('.style-text').val();
      var str = $('.page-size').val();
      var pagesize = parseInt(str, 10);
      str = $('.li-able').val();
      var pagenumber = parseInt(str, 10);
      var url = contextURL + "/question/deleteb/?questionid=" + questionid;
      $.get(url,function(data,status){
      });
      var method = $('.table-header').attr("method");
      var field = $('.table-header').attr("field");
      listtable(pagenumber, keyword, field, method, pagesize);
      $('tr[questionId=' + questionid + ']').css({'display' : 'none'});
      return false;
    }
    return false;
  });
  
  $('.style-table').on('click', '.edit', function() {
    var questionid = $(this).attr('questionid');
    var url = contextURL + "/question/update/" + questionid;
    window.location.href = url;
    return false;
  });
  
  str = $('.totalpage').text();
  var totalpage = parseInt(str, 10);
  initpage(1, totalpage, 10);
  var method = $('.table-header').attr("method");
  var field = $('.table-header').attr("field");
  listtable(1, "", field, method, 10);

  $('.buttonb').click(function() {
    var keyword = $('.style-text').val();
    var str = $('.txt-page').val();
    var pageno = parseInt(str, 10);
    var zh = /^[1-9]+[0-9]*]*$/;
    str = $('.page-size').val();
    var pagesize = parseInt(str, 10);
    str = $('.totalpage').text();
    var totalpage = parseInt(str, 10);
    var method = $('.table-header').attr("method");
    var field = $('.table-header').attr("field");
    if (pageno < 1 || pageno > totalpage) {
      return false;
    }
    if (zh.test(pageno)) {
      $('.txt-page').attr("value", "");
      listtable(pageno, keyword, field, method, pagesize);
      initpage(pageno, totalpage, pagesize);
    } else {
      return false;
    }
    return false;
  });

  $('.menu-text:eq(0)').click(function() {
    var keyword = $('.style-text').val();
    var str = $('.page-size').val();
    var pagesize = parseInt(str, 10);
    var method = $('.table-header').attr("method");
    var field = $('.table-header').attr("field");
    listtable(1, keyword, field, method, pagesize);
    return false;
  });

  $('.buttona').click(function() {
    var keyword = $('.style-text').val();
    var str = $('.page-size').val();
    var pagesize = parseInt(str, 10);
    str = $('.totalpage').text();
    var totalpage = parseInt(str, 10);
    var method = $('.table-header').attr("method");
    var field = $('.table-header').attr("field");
    listtable(1, keyword, field, method, pagesize);

  });

  $('.page-size').change(function() {
    var str = $(this).val();
    var pagesize = parseInt(str, 10);
    var keyword = $('.style-text').val();
    str = $('.totalpage').text();
    var totalpage = parseInt(str, 10);
    var method = $('.table-header').attr("method");
    var field = $('.table-header').attr("field");
    listtable(1, keyword, field, method, pagesize);
  });
  
  var urlasc = contextURL + "/static/images/sort-asc.png";
  var urlascactive = contextURL + "/static/images/sort-asc-active.png";
  var urldesc = contextURL + "/static/images/sort-desc.png";
  var urldescactive = contextURL + "/static/images/sort-desc-active.png";
  
  $('.table-id').click(function() {
    var str = $('.page-size').val();
    var pagesize = parseInt(str, 10);
    var keyword = $('.style-text').val();
    str = $('.li-able').val();
    var pagenumber = parseInt(str, 10);
    var src = $('.img-id').attr("src");
    var method = $('.table-header').attr("method");
    $('.table-header').attr("field", "id");
    if(method === "ASC"){
      $('.img-id').attr("src", urldescactive);
      $('.table-id').css({"color":"#3FEC3F"});
      $('.img-time').attr("src", urlasc);
      $('.table-time').css({"color" : "white"});
      $('.table-header').attr("method", "DESC");
      listtable(1, keyword, "id", "DESC", pagesize);
      return false;
    } else {
      $('.img-id').attr("src", urlascactive);
      $('.table-id').css({"color":"#3FEC3F"});
      $('.img-time').attr("src", urlasc);
      $('.table-time').css({"color" : "white"});
      $('.table-header').attr("method", "ASC");
      listtable(1, keyword, "id", "ASC", pagesize);
      return false;
    }
  });
  
  $('.table-time').click(function() {
    var str = $('.page-size').val();
    var pagesize = parseInt(str, 10);
    var keyword = $('.style-text').val();
    str = $('.li-able').val();
    var pagenumber = parseInt(str, 10);
    var src = $('.img-time').attr("src");
    var method = $('.table-header').attr("method");
    $('.table-header').attr("field", "last_updated_time");
    if(method === "ASC"){
      $('.img-time').attr("src", urldescactive);
      $('.table-time').css({"color":"#3FEC3F"});
      $('.img-id').attr("src", urlasc);
      $('.table-id').css({"color" : "white"});
      $('.table-header').attr("method", "DESC");
      listtable(1, keyword, "last_updated_time", "DESC", pagesize);
      return false;
    } else {
      $('.img-time').attr("src", urlascactive);
      $('.table-time').css({"color":"#3FEC3F"});
      $('.img-id').attr("src", urlasc);
      $('.table-id').css({"color" : "white"});
      $('.table-header').attr("method", "ASC");
      listtable(1, keyword, "last_updated_time", "ASC", pagesize);
      return false;
    }
  });
});