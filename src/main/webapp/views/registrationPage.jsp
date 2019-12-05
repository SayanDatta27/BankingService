<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div align="center">
		<h2>Enter Bank Details Here</h2>
		<table>
			<form:form action="registerAccount" method="post" modelAttribute="account">
				<tr>
					<td>Account Type</td>
					<td><form:input path="accountType" size="30" /></td>
					<td><form:errors path="accountType" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Account Balance</td>
					<td><form:input path="accountBalance" size="30" /></td>
					<td><form:errors path="accountBalance" cssClass="error" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></input></td>
				</tr>
			</form:form>
		</table>
	</div>
</body>
</html>