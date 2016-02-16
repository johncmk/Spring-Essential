<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	This is list.jsp <br>

	<table width="500" cellpadding="0" border="1">
		<tr>
			<td>No.</td>
			<td>Name</td>
			<td>Title</td>
			<td>Date</td>
			<td>Hit</td>
		</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.bId }</td>
				<td>${dto.bName }</td>
				<td>
					<c:forEach begin="1" end="${dto.bIndent }">-</c:forEach>
					<a href="content_view?bId=${dto.bId}">${dto.bTitle }</a>
				</td>
				<td>${dto.bDate }</td>
				<td>${dto.bHit }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<a href="write_view">Write</a>
			</td>
		</tr>
	</table>
</body>
</html>