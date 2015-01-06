<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%
    String baseURL = request.getContextPath();
  %>

<table class="style-tablem">
  <tr>
    <th>Menu</th>
  </tr>
  <tr>
    <td><a href="<%=baseURL %>/question/list/1/?keyword=">Question Management</a></td>
  </tr>
  <tr>
    <td><a href="<%=baseURL %>/exam/list/1?type=NAME&keyword=">Exam Management</a></td>
  </tr>
  <tr>
    <td><a href="myProfile.jsp">My Profile</a></td>
  </tr>
  <tr>
    <td><a href="<%=baseURL %>/question/">Question Management</a></td>
  </tr>
</table>
