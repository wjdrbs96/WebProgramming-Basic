<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, lecture1.*" %>
<%
String s = request.getParameter("id");
int id = Integer.parseInt(s);
StudentDAO2.delete(id);
response.sendRedirect("studentList5.jsp");
%>

