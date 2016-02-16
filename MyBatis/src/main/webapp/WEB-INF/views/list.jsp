<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>NO</td>
			<td>WRITER</td>
			<td>CONTENT</td>
			<td>DELETE</td>
		<tr>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.mId}</td>
					<td>${dto.mWriter}</td>
					<td>${dto.mContent}</td>
					<td><a href="delete?mId=${dto.mId}">X</a></td>
				<tr>
			</c:forEach>
	</table>
<br>

<a href="writeForm">Write</a>

</body>
</html>