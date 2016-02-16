<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

This is index.jsp<br>

<h1>post Method</h1>
<form action="student" method="post">
	Student ID: <input type="text" name="id" > <br>
	<input type="submit" value="Submit" />
</form>


<br>
<hr>
<br>
<h1>POST method</h1>
<form action="student" method="post">
	Student ID: <input type="text" name="id"> <br>
	Student PW: <input type="text" name="id"> <br>
	<input type="submit" value="login">
</form>


</body>
</html>