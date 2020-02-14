<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, lecture1.*" %>
<%
int id = 3;
User user = UserDAO4.findById(id);
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
      table.table { width: 500px; }
      table td:nth-child(1) { background-color: #eee; }
  </style>
</head>
<body>

<div class="container">

<h1>학생</h1>

<table class="table table-bordered table-condensed">
  <tr>
    <td>ID</td>
    <td><%= user.getId() %></td>
  </tr>
  <tr>
    <td>유저아이디</td>
    <td><%= user.getUserid() %></td>
  </tr>
  <tr>
    <td>학과ID</td>
    <td><%= user.getDepartmentId() %></td>
  </tr>
  <tr>
    <td>이름</td>
    <td><%= user.getName() %></td>
  </tr>
</table>

</div>
</body>
</html>
