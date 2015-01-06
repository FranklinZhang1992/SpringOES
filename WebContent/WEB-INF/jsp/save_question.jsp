<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
        <a href="<%=baseURL %>/question/list/1/?keyword=">Question Management</a> → Edit Question
      </div>
    </div>
    <form name="save_question_form" id="saveQuestionForm" method="post" action="<%=baseURL %>/question/save">
    <div class="subpageh">
      <div class="subpage-lefth">
        <p class="style-title-text">Question Title:</p>
      </div>
      <div class="subpage-righth">
        <textarea class="style-titletext" title="${question.title}" name="title" id="questionTitle">${question.title}</textarea>
      </div>
    </div>
    <div class="div-middle"><span class="onError" id="titleSpan">${error.titleError}</span></div>
    <div class="subpage">
      <div class="subpage-left">
        <input type="radio" name="answer" value="A" id="optionradioA" />A:
      </div>
      <div class="subpage-right">
        <input type="text" class="style-inputtext" title="${question.optionA}" name="optionA" id="optionA" value="${question.optionA}" />
      </div>
    </div>
    <div class="div-middle"><span class="onError" id="optionASpan">${error.optionAError}</span></div>
    <div class="subpage">
      <div class="subpage-left">
        <input type="radio" name="answer" id="optionradioB" value="B" />B:
      </div>
      <div class="subpage-right">
        <input type="text" class="style-inputtext" title="${question.optionB}" name="optionB" id="optionB" value="${question.optionB}" />
      </div>
    </div>
    <div class="div-middle"><span class="onError" id="optionBSpan">${error.optionBError}</span></div>
    <div class="subpage">
      <div class="subpage-left">
        <input type="radio" name="answer" id="optionradioC" value="C" />C:
      </div>
      <div class="subpage-right">
        <input type="text" class="style-inputtext" title="${question.optionC}" name="optionC" id="optionC" value="${question.optionC}" />
      </div>
    </div>
    <div class="div-middle"><span class="onError" id="optionCSpan">${error.optionCError}</span></div>
    <div class="subpage">
      <div class="subpage-left">
        <input type="radio" name="answer" id="optionradioD" value="D" />D:
      </div>
      <div class="subpage-right">
        <input type="text" class="style-inputtext" title="${question.optionD}" name="optionD" id="optionD" value="${question.optionD}" />
      </div>
    </div>
    <div class="div-middle"><span class="onError" id="optionDSpan">${error.optionDError}</span></div>
    <div class="subpagef">
      <div class="subpage-leftf">
        <span class="onError" id="answerSpan">${error.answerError}</span>
      </div>
      <div class="subpage-rightf">
        <input type="button" class="picButton" id="create" value="Submit" />
        <input type="button" class="picButton" id="cancel" value="Cancel" />
        <input type="hidden" name="id" value="${question.id}" />
        <input type="hidden" class="correct_answer" value="${question.answer}" />
      </div>
    </div>
    </form>
  </div>
  <div id="footer"><oes:block name="footer"/>
  </div>
</div>
</body>
<script type="text/javascript" src="<%=baseURL %>/static/js/lib/jquery-1.6.4.js"></script>
<script type="text/javascript" src="<%=baseURL %>/static/js/save_question.js"></script>
<script language="javascript" type="text/javascript">

</script>
</html>