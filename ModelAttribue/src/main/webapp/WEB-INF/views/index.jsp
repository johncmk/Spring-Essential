<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
		String context = request.getContextPath();
	%>
	
	<form action="<%=context%>/studentView" method="post">
		NAME: <input type="text" name="name" > <br>
		AGE: <input type="text" name="age" > <br>
		CLASS.NUM: <input type="text" name="classNum" > <br>
		GRADE.NUM: <input type="text" name="gradeNum" > <br>
		<input type="submit" value="Send">
	</form>

</body>
</html>