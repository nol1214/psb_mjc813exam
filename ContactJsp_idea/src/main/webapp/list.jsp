<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.mjc813.contactjsp.DTO.ContactDto" %>
<%
request.setCharacterEncoding("UTF-8");
ArrayList<ContactDto>list = new ArrayList<ContactDto>();
list = (ArrayList<ContactDto>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<link rel="stylesheet" href="style.css?ver=1">
</head>
<body>
<%@ include file="topmenu.jsp" %>
<section>
<div class="title">
연락처관리 프로그램
</div>
<div class="wrapper">
<table style="width:900px">
<tr>
	<th>ID</th>
	<th>성명</th>
	<th>전화번호</th>
	<th>우편번호</th>
	<th>이메일</th>
	<th>삭제</th>
</tr>
<%
// 8번 라인의 list 배열 객체를 for 반복 문으로 출력함
for(int i=0; i<list.size(); i++){
%>
<tr>
	<td><a href="modify?id=<%=list.get(i).getId() %>"><%=list.get(i).getId() %></a></td>
	<td><%=list.get(i).getName() %></td>
	<td><%=list.get(i).getPhoneNumber() %></td>
	<td><%=list.get(i).getZipNumber() %></td>
	<td><%=list.get(i).getEmail() %></td>
	<td><a href="delete?id=<%=list.get(i).getId() %>">Delete</a></td>
</tr>
<%}%>
</table>
</div>
</section>
<%@ include file="footer.jsp" %>
</body>
</html>