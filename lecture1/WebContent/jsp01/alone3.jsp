<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
 
</head>
<body>
<%! String declaration = "Declaration";%>
<%! public String decMethod(){
        return declaration;    
    }    
%>
<%
    String scriptlet = "Scriptlet";
    String comment = "comment";
    out.println("<p>"+"스크립트 릿안에서 내장객체를 이용한 출력 :"+scriptlet+"/"+comment+"</p>");
%>
<p>선언문의 출력1 : <%=declaration%></p>
<p>선언문의 출력2 : <%=decMethod()%></p>
<p>스크립트 선언문의 출력 : <%=scriptlet%></p>
<!-- HTML 주석 -->
<!-- JSP 주석 <%=comment%> -->
<%-- JSP주석 <%=comment%> --%>

 
</body>
</html>