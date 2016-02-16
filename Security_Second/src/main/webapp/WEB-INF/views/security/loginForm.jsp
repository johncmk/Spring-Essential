<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>Login Form</h1>


<c:url value="j_spring_security_check" var="loginUrl"/>

<form action="${loginUrl}" method="post">
	<c:if test="${param.ng != null}">
		<p>
			LOGIN NG!<br>
			<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != NULL }">
				MSG: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message }"/>
			</c:if>
		</p>
	</c:if>
	ID:<input type="text" name="j_username"> <br>
	PW:<input type="text" name="j_password"> <br>
	<input type="submit" value="LOGIN">
</form>

</body>
</html>