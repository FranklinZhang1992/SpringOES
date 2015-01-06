<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/oes.tld" prefix="oes"%>
<%@include file="filter.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

  <%
      String baseURL = request.getContextPath();
  %>
<link rel="stylesheet" type="text/css" href="<%=baseURL %>/static/styles/mystyle.css" />
<link rel="stylesheet" type="text/css" href="<%=baseURL %>/static/styles/common.css" />

</head>
<body>
<div id="container">

  <div id="header">
    <oes:block name="header"/>
  </div>

  <div id="menu">
    <oes:block name="menu"/>
  </div>

  <div id="content">
    <div id="subcontainer">
      <div id="bread">
        <a href="<%=baseURL %>/exam/list/1?type=NAME&keyword=">Exam Management</a> → Edit Exam
      </div>
    </div>
    <form name="edit_exam_form" id="editExamForm" method="post" action="<%=baseURL %>/exam/saveUpdate">
    <div class="subpage">
      <div class="subpage-leftb">
        Exam Name:
      </div>
      <div class="subpage-right">
        <input type="text" title="${exam.name}" class="style-inputtext" name="name" id="examName" value="${exam.name}" />
      </div>
    </div>
    <div class="div-middle"><span class="onError" id="nameSpan">${error.nameError}</span></div>
    <div class="subpageh">
      <div class="subpage-lefthb">
        Exam Description:
      </div>
      <div class="subpage-righth">
        <textarea class="style-titletext" title="${exam.description}" name="description" id="examDescription">${exam.description}</textarea>
      </div>
    </div>
    <div class="subpagef">
      <div class="subpage-leftf">
      </div>
      <div class="subpage-rightf">
        <input type="button" class="picButton" id="edit" value="Submit" />
        <input type="button" class="picButton" id="cancel" value="Cancel" />
      </div>
    </div>
    <input type="hidden" name="id" value="${exam.id}" />
    </form>
  </div>

  <div id="footer"><oes:block name="footer"/>
  </div>

</div>
</body>
<script type="text/javascript" src="<%=baseURL %>/static/js/lib/jquery-1.6.4.js"></script>
<script type="text/javascript" src="<%=baseURL %>/static/js/edit_exam.js"></script>
<script language="javascript" type="text/javascript">

</script>
</html>