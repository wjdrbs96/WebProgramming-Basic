<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1>
<% 
      for (int i = 1; i <= 9; ++i) { 
    	  out.println("<tr>");
        for (int j = 2; j <=9; ++j) {
        	out.print("    ");
            out.print("<td>");
            out.print(j + "x" + i + "=" + i*j);
            out.println("</td>");
        }
        out.println("</tr>");
      }
%>
</table> 

</body>
</html>