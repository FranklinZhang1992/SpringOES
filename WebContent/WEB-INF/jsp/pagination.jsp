<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--<a href="javascript:jumpfirst();">First</a>
    <a href="javascript:jumpbackward(${pageNumber});">Before</a>
    <a href="javascript:jumpforward(${pageNumber}, ${totalPage});">Next</a>
    <a href="javascript:jumplast(${totalPage});">Last</a>-->
    <a href="#" class="first">First</a>&nbsp;
    <a href="#" class="before" pageNumber="${pageNumber}">Before</a>&nbsp;
    <a href="#" class="next" pageNumber="${pageNumber}" totalPages="${totalPage}">Next</a>&nbsp;
    <a href="#" class="last" totalpages="${totalPage}">Last</a>