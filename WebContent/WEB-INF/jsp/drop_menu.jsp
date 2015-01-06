<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
    int totalPage = ((Integer) request.getAttribute("totalPage")).intValue();
    int pageNumber = ((Integer) request.getAttribute("pageNumber")).intValue();
%>
Total ${totalPage} Pages
Go to
          <select name="select_page" id="selectPage" onChange="changeselect()"> 
            <%
                 for (int i = 1; i <= totalPage; i++) {
             %>
                     <c:set var="pageNum" value="<%=i %>" scope="page">
                     </c:set>
                      
                     <%
                                               if (i == pageNumber) {
                                           %>
                     <option value="${pageNum}" selected>${pageNum}</option>
                     <%
                         } else {
                     %>
                       <option value="${pageNum}">${pageNum}</option>
                     <%
                         }
                         }
                     %>
          </select>
          Page