<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="lecture3.form02.*" %>
<%
String userid = "";
String studentNumber = "";
String name = "";
int departmentId = 0;
int year = 0;
String 에러메시지 = null;
request.setCharacterEncoding("UTF-8");
if (request.getMethod().equals("POST")) {
    userid = request.getParameter("userid");
    studentNumber = request.getParameter("studentNumber");
    name =  request.getParameter("name");
    String s = request.getParameter("departmentId");
    departmentId = Integer.parseInt(s);
    String k = request.getParameter("year");
    year = Integer.parseInt(k);
    
    if (userid == null || userid.length() == 0) {
    	에러메시지 = "사용자 아이디를 입력하세요";
    }
    else if (studentNumber == null || studentNumber.length() == 0) {
    	에러메시지 = "학번을 입력하세요";
    }
    else if (name == null || name.length() == 0) {
    	 에러메시지 = "이름을 입력하세요";
    }
    else {
        Student st = new Student(userid, studentNumber, name, departmentId, year);
        session.setAttribute("Student",st);   // setAttribute에 key인 Student와 st객체에 담긴 정보를 서버 메모리에 저장함
        response.sendRedirect("student_success.jsp");
        return;
    }
}
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
      input.form-control, select.form-control { width: 200px; }
  </style>
</head>
<body>

<div class="container">
<h1>회원가입</h1>
<hr />

<form method="post">
  <div class="form-group">
    <label>사용자 아이디</label>
    <input type="text" class="form-control" name="userid" value="<%= userid %>" />
  </div>
  <div class="form-group">
    <label>학번</label>
    <input type="text" class="form-control" name="studentNumber" value="<%= studentNumber %>" />
  </div>
  <div class="form-group">
    <label>이름</label>
    <input type="text" class="form-control" name="name" value="<%= name %>" />
  </div>
  <div class="form-group">
    <label>학과</label>
    <select class="form-control" name="departmentId">
      <option value="1" <%= departmentId == 1 ? "selected" : "" %>>소프트웨어공학과</option>
      <option value="2" <%= departmentId == 2 ? "selected" : "" %>>컴퓨터공학과</option>
      <option value="3" <%= departmentId == 3 ? "selected" : "" %>>정보통신공학과</option>
      <option value="4" <%= departmentId == 4 ? "selected" : "" %>>글로컬IT공학과</option>
    </select>
  </div>
   <div class="form-group">
    <label>학년</label>
    <input type="text" class="form-control" name="year" value="<%= year %>" />
  </div>
  <button type="submit" class="btn btn-primary">
    <i class="glyphicon glyphicon-ok"></i> 회원가입
  </button>
</form>

<hr />

<% if (에러메시지 != null) { %>
  <div class="alert alert-danger">
    로그인 실패: <%= 에러메시지 %>
  </div>
<% } %>
</div>
</body>
</html>
