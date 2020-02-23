<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, lecture1.*" %>
<%
if (request.getMethod().equals("POST")) {
	request.setCharacterEncoding("UTF-8");
    // 필요 코드 작성
    Student student = new Student();
    String number = request.getParameter("studentNumber");
    student.setStudentNumber(number);
    
    String name = request.getParameter("name");
    student.setName(name);
    
    String departmentid = request.getParameter("departmentId");
    int id = Integer.parseInt(departmentid);
    student.setDepartmentId(id);
    
    String year = request.getParameter("year");
    int y = Integer.parseInt(year);
    student.setYear(y);    
  
    
    
    StudentDAO4.insert(student);
    response.sendRedirect("studentList5.jsp");
    return;
}
List<Department> departments = DepartmentDAO.findAll();
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

<h1>학생 등록</h1>

<form method="post">
  <table class="table table-bordered table-condensed">
    <tr>
      <td>이름</td>
      <td>
          <input type="text" name="name" class="form-control" />
      </td>
    </tr>
    <tr>
      <td>학번</td>
      <td>
          <input type="text" name="studentNumber" class="form-control" />
      </td>
    </tr>
    <tr>
      <td>학과</td>
      <td>
        <select name="departmentId" class="form-control">
          <% for (Department department : departments) { %>
            <% int id = department.getId(); %>
            <% String name = department.getDepartmentName(); %>
            <option value="<%= id %>">
              <%= name %>
            </option>
          <% } %>
        </select>
      </td>
    </tr>
    <tr>
      <td>학년</td>
      <td>
          <input type="text" name="year" class="form-control" />
      </td>
    </tr>
  </table>
  
  <button type="submit" class="btn btn-primary">저장</button>
  <a href="javascript:window.history.back()" class="btn btn-info">돌아가기</a>
</form>

</div>
</body>
</html>
      