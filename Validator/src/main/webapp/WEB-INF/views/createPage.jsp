<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

This is createPage.jsp page
<br>

<form action="student/create">
	Name: <input type = "text" name = "name" value="${student.name }"><br>
	ID: <input type = "text" name = "id" value="${student.id }"><br>
	<input type="submit" value="Send" ><br>
</form>

</body>
</html>