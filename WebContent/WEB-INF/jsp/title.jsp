<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@page import="com.augmentum.oes.modle.User"%>
<STYLE type="text/css">

.on-title{ height:25px; font-size:30px; line-height:25px; color:#FFFFFF; font-weight:bold;}

</STYLE>

<%
    String baseURL = request.getContextPath();
%>
<div class="headcontainer">
  <div class="headleft">Online Exam System</div>
  <div class="headright">Welcome ${user.userName}&nbsp;,<a href="<%=baseURL %>">Logout</a></div>
</div>
