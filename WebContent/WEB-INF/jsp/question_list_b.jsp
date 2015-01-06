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
<link rel="stylesheet" type="text/css" href="<%=baseURL %>/static/styles/new.css" />
</head>
<body>
<div class="container">
  <div class="div-header">
    <div class="header-left">Online Exam System</div>
    <div class="header-right">Welcome ${user.userName},&nbsp;<a href="<%=baseURL %>">Logout</a></div>
  </div>
  <div class="div-container">
    <div class="div-left">
      <div class="menu-container">
        <div class="menu-select"><span class="menu-text">Question Management</span></div>
        <div class="div-menu"><span class="menu-text">Exam Management</span></div>
        <div class="div-menu"><span class="menu-text">My Profile</span></div>
      </div>
    </div>
    <div class="div-right">
      <div class="bread">
        <a href="<%=baseURL %>/question/">Exam Management</a> &nbsp; &gt; &nbsp; Exam List
      </div>
      <div class="div-middle">
        <div class="middle-left">
        Exam Name:
        <input type="text" class="style-text" name="title" value="${keyword}" />&nbsp;
        <input type="button" class="buttona" value="Search"/>
        </div>
        <div class="middle-right">
          <a href="#" class="href-create">Create Exam</a>
        </div>
      </div>
      <div class="content">
        <div class="table-header" field="last_updated_time" method="DESC">
          <div class="table-id">ID&nbsp;&nbsp;&nbsp;&nbsp;<img class="img-id" src="<%=baseURL %>/static/images/sort-asc.png"></img></div>
          <div class="table-title">Title</div>
          <div class="table-answer">Answer</div>
          <div class="table-time">Last Update Time&nbsp;&nbsp;&nbsp;&nbsp;<img class="img-time" src="<%=baseURL %>/static/images/sort-asc.png"></img></div>
          <div class="table-operation">Operation</div>
        </div>
        <div class="table-container">
          <table class="style-table">
            <tbody>
            </tbody>
          </table>
        </div>
        <div class="foot">
            <div class="foot-left">
              <span class="txt-a">Total <label class="totalpage"></label> Pages</span>
              <span class="txt-b">Page</span>
              <input type="text" class="txt-page" />&nbsp;
              <input type="button" class="buttonb" value="Goto" />
              <span class="txt-c">Page Size:</span>
              <oes:block name="pagesize"/>
            </div>
            <div class="foot-right">
              <ul></ul>
            </div>
          </div>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="<%=baseURL %>/static/js/lib/jquery-1.11.1.js"></script>
<script type="text/javascript" src="<%=baseURL %>/static/js/lib/jquery.json-2.4.min.js"></script>
<script type="text/javascript" src="<%=baseURL %>/static/js/new_question_list.js"></script>
<script type="text/javascript">
  var contextURL = '<%= baseURL%>';
</script>
</body>
</html>