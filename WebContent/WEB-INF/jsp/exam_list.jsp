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
        Exam Management
      </div>
      <div id="title-search">
        Question Title:
        <input type="text" class="style-text" name="title" id="title" value="${keyword}" />
        <input type="button" class="picButton" id="dosearch" value="Search"/>
      </div>
      <div id="title-create"><input type="button" class="picButton" onclick="window.location.href='<%=baseURL %>/exam/create'" value="Create Exam"/>
      </div>
    </div>
    <div class="choice">
        <input type="radio" name="search_type" id="searchNAME" value="NAME" />Search By Name:
        <input type="radio" name="search_type" id="searchDESCRIPTION" value="DESCRIPTION" />Search By Description:
    </div>
    <input type="hidden" class="type" value="${type}" />
    <table class="style-table">
      
      <tr>
        <th class="style-the">Name</th>
        <th class="style-thf">Description</th>
        <th class="style-the">Total</th>
        <th class="style-thg">Quantity</th>
        <th class="style-thf">Operation</th>
      </tr>
        <c:forEach var="exam" items="${table}">
          <tr>
            <td class="style-the" title="<c:out value="${exam.name}"></c:out>">
              <c:out value="${exam.name}"></c:out>
            </td>
            <td class="style-thf" title="<c:out value="${exam.description}"></c:out>">
              <c:out value="${exam.description}"></c:out>
            </td>
            <td class="style-the">
              <c:out value="${exam.totalScore}"></c:out>
            </td>
            <td class="style-thg">
              <c:out value="${exam.questionQuantity}"></c:out>
            </td>
            <td class="style-thf">
              <a href="<%=baseURL%>/exam/update/${exam.id}">Edit</a>&nbsp;
              
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
<script type="text/javascript" src="<%=baseURL %>/static/js/lib/jquery-1.6.4.js"></script>
<script type="text/javascript" src="<%=baseURL %>/static/js/exam_list.js"></script>
<script language="javascript" type="text/javascript">
  function changeselect() {
    var keyword = document.getElementById("title").value;
    var selectedPage = document.getElementById("selectPage").value;
    var radios = document.getElementsByName("search_type");
    for (var i = 0; i < radios.length; i++) 
    {
        if (radios[i].checked) 
            searchtype = radios[i].value;
    }
    location.href="<%=baseURL%>/exam/list/" + selectedPage + "/?type=" + searchtype + "&keyword=" + keyword;
  }
</script>
</html>