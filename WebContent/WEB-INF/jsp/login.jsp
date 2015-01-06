<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" errorPage="" %> 
<%
     String contextURL = request.getContextPath();
     String staticResourceBaseURL = contextURL;
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Interface</title>

  <%
      String baseURL = request.getContextPath();
  %>
  <link rel="stylesheet" type="text/css" href="<%=baseURL%>/static/styles/common.css" />
<STYLE type="text/css">
body {
	background-color: #F3BD5C;
	background-image:url(<%=baseURL%>/static/images/background.jpg);
	background-repeat: no-repeat;
	background-attachment:fixed;
	background-position:50% 50%;
}

.login-table {
	margin: 0 auto;
	margin-top: 270px;
}

.onLoad {
	height: 25px;
	line-height: 25px;
	font-weight: bold;
}

.onError {
	height: 25px;
	line-height: 25px;
	color: #F00;
	font-weight: bold;
}

.onTitle {
	height: 25px;
	font-size: 30px;
	line-height: 25px;
	font-weight: bold;
}

.picButton {
    width: 150px;
    text-align: center;
    line-height: 100%;
    padding-top: 0.5em;
    padding-right: 2em;
    padding-bottom: 0.55em;
    padding-left: 2em;
    font-family: Arial, sans-serif;
    font-size: 14px;
    font-style: normal;
    font-variant: normal;
    font-weight: normal;
    text-decoration: none;
    margin-top: 0px;
    margin-right: 2px;
    margin-bottom: 0px;
    margin-left: 2px;
    vertical-align: text-bottom;
    display: inline-block;
    cursor: pointer;
    zoom: 1;
    outline-width: medium;
    outline-color: invert;
    font-size-adjust: none;
    font-stretch: normal;
    border-top-left-radius: 0.5em;
    border-top-right-radius: 0.5em;
    border-bottom-left-radius: 0.5em;
    border-bottom-right-radius: 0.5em;
    box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.2);
    text-shadow: 0px 1px 1px rgba(0, 0, 0, 0.3);
    color: #fefee9;
    border-top-color: #da7c0c;
    border-right-color: #da7c0c;
    border-bottom-color: #da7c0c;
    border-left-color: #da7c0c;
    border-top-width: 1px;
    border-right-width: 1px;
    border-bottom-width: 1px;
    border-left-width: 1px;
    border-top-style: solid;
    border-right-style: solid;
    border-bottom-style: solid;
    border-left-style: solid;
    background-attachment: scroll;
    background-repeat: repeat;
    background-position-x: 0%;
    background-position-y: 0%;
    background-size: auto;
    background-origin: padding-box;
    background-color: #f78d1d;
}
</STYLE>

<script language="javascript" type="text/javascript">

  function submitform() {
    document.getElementById("loginForm").submit();
    }

	function keyDown(e) {
		var ev = window.event || e; 

		if (ev.keyCode == 13) {
			ev.returnValue = false;
			ev.cancel = true;
			document.getElementById("loginForm").submit();
		}
	}
</script>
</head>
<body>

<form name="loginForm" id="loginForm" method="post" action="<%=baseURL%>/login">
<table class="login-table">
  <tr>
    <td colspan=2 align="left"><P class="onTitle">Online Exam System</P></td>
    <td></td>
  </tr>
  <tr>
    <td colspan=2 align="left" class="onError">${error.error}</td>
    <td></td>
  </tr>
  <tr>
    <td class="onLoad">User Name :</td>
    <td><input type="text" name="userName" width=160px; maxlength=10 id="userName" onkeydown="keyDown(event)" /></td>
    <td class="onError">${error.userNameError}</td>
  </tr>
  <tr>
    <td class="onLoad">Password :</td>
    <td><input type="password" name="password" width=160px; maxlength=10 id="password" onkeydown="keyDown(event)" /></td>
    <td class="onError">${error.passwordError}</td>
  </tr>
  <tr>
    <td></td>
    <td align="left"><input type="button" class="picButton" onclick="submitform()" value="Submit"></input></td>
  </tr>
</table>
<%
    session.removeAttribute("error");
%>
</form>
</body>
</html>