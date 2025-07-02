<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
request.setCharacterEncoding("UTF-8");
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
연락처 등록
</div>
<form name="frm" action="insert" method="post">
<input type="hidden" id="GUBUN" value="insert" >
<div class="wrapper">
<table>
	<tr>
		<th>연락처번호(자동발생)</th>
		<td><input name="id" readonly value="" disabled></td>
	</tr>
	<tr>
		<th>연락처성명 (최대 5자)</th>
		<td><input type="text" name="name" maxlength="5"></td>
	</tr>
	<tr>
		<th>연락처전화 (010-XXXX-XXXX)</th>
		<td><input type="text" name="phoneNumber" maxlength="13"></td>
	</tr>
	<tr>
		<th>우편번호 (최대 5자)</th>
		<td><input type="text" name="zipNumber" maxlength="5"></td>
	</tr>
	<tr>
		<th>이메일 주소</th>
		<td><input type="text" name="email" maxlength="100"></td>
	</tr>
	<tr>
		<td colspan="2">
		<button class="btn" type="submit" onclick="fn_submit(); return false;">등 록</button>
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