<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<b>List of all the Student</b>

	<table border="0" width="50%">
		<tr>
			<th>RollNumber</th>
			<th>Name</th>
			<th>Address</th>
		</tr>
	<jsp:useBean id="user" class="com.java.JdbcConn"/>
	<c:set var="sd" value="${user.getStudent()}"/>
		<c:forEach items="${sd}" var="v">

			<tr>
				<%-- <td><c:out value="helloworld"></c:out></td> --%>
				<td><c:out value="${v.getPassword()}"></c:out></td>
				<td><c:out value="${v.getName()}"></c:out></td>
				<td><c:out value="${v.getUserName()}"></c:out></td>
			</tr>

		</c:forEach>

	</table>


	<a href="log.html">Click here for log in page</a>

</body>
</html>