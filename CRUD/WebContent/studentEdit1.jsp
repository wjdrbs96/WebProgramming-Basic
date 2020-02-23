<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, lecture1.*" %>
<%
if (request.getMethod().equals("POST")) {
    Student student = new Student();
    request.setCharacterEncoding("UTF-8");
    
    String s = request.getParameter("id");
    int id = Integer.parseInt(s);
    student.setId(id);
    
    String name = request.getParameter("name");    
    student.setName(name);
    
    String studentNumber = request.getParameter("studentNumber");
    student.setStudentNumber(studentNumber);

    s = request.getParameter("departmentId");
    int departmentId = Integer.parseInt(s);
    student.setDepartmentId(departmentId);

    s = request.getParameter("year");
    int year = Integer.parseInt(s);
    student.setYear(year);
    
    StudentDAO2.update(student);
    response.sendRedirect("studentList5.jsp");
    return;
}

// 필요 코드 작성
    
    String s = request.getParameter("id");
    int id = Integer.parseInt(s);
    Student student = StudentDAO2.findById(id);
    
    List<Department> departments = DepartmentDAO1.findAll();
    
   
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

<h1>학생 수정</h1>

<form method="post">
  <table class="table table-bordered table-condensed">
    <tr>
      <td>ID</td>
      <td>
          <%= student.getId() %>
      </td>
    </tr>
    <tr>
      <td>이름</td>
      <td>
          <input type="text" name="name" value="<%= student.getName() %>" />
      </td>
    </tr>
    <tr>
      <td>학번</td>
      <td>
          <input type="text" name="studentNumber" class="form-control" value="<%= student.getStudentNumber() %>" />
      </td>
    </tr>    
    <tr>
      <td>학과ID</td>
      <td>
          <select name="departmentId" class="form-control">
            <% for (Department department : departments) { %>
              <% int _id = department.getId(); %>
              <% String _name = department.getDepartmentName(); %>
              <% String _selected = (_id == student.getDepartmentId() ? "selected" : ""); %>
              <option value="<%= _id %>" <%= _selected %> >
                <%= _name %>
              </option>
            <% } %>
          </select>
      </td>
    </tr>
    <tr>
      <td>학년</td>
      <td>
          <input type="text" name="year" class="form-control" value="<%= student.getYear() %>" />
      </td>
    </tr>
  </table>
  <button type="submit" class="btn btn-primary">저장</button>
  <a href="studentDelete1.jsp?id=<%= student.getId() %>" class="btn btn-warning" 
     onclick="confirm('삭제하시겠습니까?')">삭제</a>
  <a href="javascript:window.history.back()" class="btn btn-info">돌아가기</a>
</form>

</div>
</body>
</html>
      