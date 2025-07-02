<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.mjc813.contactjsp.DTO.ContactDto" %>
<%
request.setCharacterEncoding("UTF-8");
ArrayList<ContactDto>list = new ArrayList<ContactDto>();
list = (ArrayList<ContactDto>)request.getAttribute("list");
		
int id = list.get(0).getId();
String name = list.get(0).getName();
String phoneNumber = list.get(0).getPhoneNumber();
String zipNumber = list.get(0).getZipNumber();
String email = list.get(0).getEmail();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<script src="script.js"></script>
<link rel="stylesheet" href="style.css?ver=1">
</head>
<body>
<%@ include file="topmenu.jsp" %>
<section>
<div class="title">
연락처 정보 수정
</div>
<form name="frm" action="update" method="post">
<input type="hidden" id="GUBUN" value="update" >
<div class="wrapper">
<table>
	<tr>
		<th>ID (자동발생)</th>
		<!-- 10번 라인의 custno 변수값을 출력 -->
		<td><input name="id" value="<%=id %>" readonly value="1"></td>
	</tr>
	<tr>
		<th>연락처성명 (최대 5자)</th>
		<!-- 11번 라인의 name 변수값을 출력 -->
		<td><input type="text" name="name" value="<%=name%>" maxlength="5"></td>
	</tr>
	<tr>
		<th>연락처전화 (010-XXXX-XXXX)</th>
		<!-- 12번 라인의 phoneNumber 변수값을 출력 -->
		<td><input type="text" name="phoneNumber" value="<%=phoneNumber%>" maxlength="13"></td>
	</tr>
	<tr>
		<th>우편번호 (최대 5자)</th>
		<!-- 13번 라인의 zipNumber 변수값을 출력 -->
		<td><input type="text" name="zipNumber" value="<%=zipNumber%>" maxlength="5"></td>
	</tr>
	<tr>
		<th>이메일주소</th>
		<!-- 14번 라인의 email 변수값을 출력 -->
		<td><input type="text" name="email" value="<%=email%>" maxlength="100"></td>
	</tr>
	<tr>
		<td colspan="2">
		<button class="btn" type="submit" onclick="fn_submit(); return false;">수 정</button>
		<button class="btn" type="button" onclick="location='list'">조 회</button>
		</td>
	</tr>
</table>
</div>
</form>
</section>
<%@ include file="footer.jsp" %>
</body>
</html>