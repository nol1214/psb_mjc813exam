<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>MJC 813 교실</title>
</head>
<%
request.setCharacterEncoding("UTF-8");
String val = (String)request.getParameter("val");
%>
<body>
    <h1>명지대 813호</h1>
    <hr/>
    <div>받은값 : <%= val%></div>
</body>
</html>