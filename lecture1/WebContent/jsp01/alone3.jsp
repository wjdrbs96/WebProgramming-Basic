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
    out.println("<p>"+"��ũ��Ʈ ���ȿ��� ���尴ü�� �̿��� ��� :"+scriptlet+"/"+comment+"</p>");
%>
<p>������ ���1 : <%=declaration%></p>
<p>������ ���2 : <%=decMethod()%></p>
<p>��ũ��Ʈ ������ ��� : <%=scriptlet%></p>
<!-- HTML �ּ� -->
<!-- JSP �ּ� <%=comment%> -->
<%-- JSP�ּ� <%=comment%> --%>

 
</body>
</html>