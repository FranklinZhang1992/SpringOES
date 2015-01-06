<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <jsp:include page="title.jsp"></jsp:include>
  </div>

  <div id="menu">
    <jsp:include page="menu.jsp"></jsp:include>
  </div>

  <div id="content">
    
  </div>

  <div id="footer">Copyright Augmentum
  </div>

</div>
</body>
</html>