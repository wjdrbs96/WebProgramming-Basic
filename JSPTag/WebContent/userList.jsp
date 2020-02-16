<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, lecture1.*" %>
<%
int currentPage = 1;
int pageSize = 10;
List<User> list = UserDAO.findAll(currentPage,pageSize);
// 필요한 코드 작성
%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
      body { font-family: 굴림체; }
      thead th { background-color: #eee; }
      table.table { width: 700px; }
  </style>
</head>
<body>

<div class="container">
<h1>학생목록</h1>

<table class="table table-bordered table-condensed">
    <thead>
        <tr>
            <th>Id</th>
            <th>userId</th>
            <th>비밀번호</th>
            <th>이름</th>
            <th>이메일</th>
            <th>학과번호</th>
            <th>학과이름</th>
        </tr>
    </thead>
    <tbody>
        <% for (User user : list) { %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getUserid() %></td>
                <td><%= user.getPassword() %></td>
                <td><%= user.getName() %></td>
                <td><%= user.getEmail() %></td>
                <td><%= user.getDepartmentId() %></td>
                <td><%= user.getDepartmentName() %></td>
                
            </tr>
        <% } %>
    </tbody>
</table>
<% if (currentPage > 1) { %>
    <a class="btn btn-default" href="studentList2.jsp?pg=<%= currentPage-1 %>"> &lt; </a>
<% } %>
<% if (currentPage < pageSize) { %>
    <a class="btn btn-default" href="studentList2.jsp?pg=<%= currentPage+1 %>"> &gt; </a>
<% } %>
</div>
</body>
</html>