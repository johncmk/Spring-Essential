<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	write.jsp
	<br />

	<form action="write" method="post">
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td>�ۼ���</td>
				<td><input type="text" name="mWriter" size="50"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="mContent" size="150"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="�Է�">
					&nbsp;&nbsp; <a href="list">��Ϻ���</a></td>
			</tr>
		</table>
	</form>
</body>
</html>