<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="/WEB-INF/oes.tld" prefix="oes"%> 
<%@include file="filter.jsp"%>
<!DOCTYPE html>

<%@page import="com.augmentum.oes.modle.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
        Question Management
      </div>
      <div id="title-search">
        Question Title:
        <input type="text" class="style-text" name="title" id="title" value="${keyword}" onkeydown="keyDown(event)" />
        <input type="button" class="picButton" id="dosearch" value="Search"/>
      </div>
      <div id="title-create"><input type="button" class="picButton" onclick="window.location.href='<%=baseURL %>/question/create'" value="Create Question"/>
      </div>
    </div>
    <table class="style-table">
      <tr>
        <th class="style-tha">Question Title</th>
        <th class="style-thb">Answers</th>
        <th class="style-th">Operations</th>
      </tr>
        <c:forEach var="question" items="${table}">
          <tr questionId="${question.id}">
            <td title="<c:out value="${question.title}"></c:out>" class="style-tha"><c:out value="${question.title}"></c:out></td>
            <td class="style-thb"><c:out value="${question.answer}"></c:out></td>
            <td class="style-th">
              <a href="<%=baseURL%>/question/update/${question.id}">Edit</a>&nbsp;
              <a href="#" class="delete" questionId="${question.id}" pageNumber="${pageNumber}">Delete</a>
            </td>
          </tr>
        </c:forEach>
      </table>
      <div class="foot-pagination">
        <div class="foot-pagination-left">
          <oes:block name="dropmenu"/>
        </div>
        <div class="foot-pagination-right">
          <oes:block name="paginater"/>
        </div>
      </div>
    </div>
  <div id="footer"><oes:block name="footer"/>
  </div>
</div>
</body>

<script type="text/javascript" src="<%=baseURL %>/static/js/lib/jquery-1.11.1.js"></script>
<script type="text/javascript" src="<%=baseURL %>/static/js/question_list.js"></script>
<script type="text/javascript">
  function changeselect() {
    var selectedPage = document.getElementById("selectPage").value;
    var keyword = "${keyword}";
    location.href="<%=baseURL%>/question/list/"+ selectedPage + "/?keyword=" + keyword;
  }

</script>

</html>