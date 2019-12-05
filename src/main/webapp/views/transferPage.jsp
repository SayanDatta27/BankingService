<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw</title>
</head>
<body>
	<div align="center">
		<h2>Withdraw</h2>
		<table>
			<form action="transferBalance" method="post" modelAttribute="account">
			<tr>
				<td>Account No From</td>
				<td><input type="text" name="accountNoFrom"></td>
			</tr>
			<tr>
			<td>Account No to</td>
				<td><input type="text" name="accountNoTo"></td>
			</tr>
			<tr>
			<td>Transfer Amount</td>
			<td><input type="text" name="amount"></td>
			</tr>
			<tr>
			<td>Pin Number</td>
			<td><input type="password" name="pinNumber"></td>
			</tr>
			<tr>
				<td><input type="submit" value="click"></input></td>
				<td><a href="Index">||Home||</a></td>
			</tr>
			</form>
			</table>
			</div>
			<div align="center" class="error">${errorMessge }</div>
	<br>
	<br>
	<div align="center">
		<table>
			<tr>
				<td>${accBal}</td>
				</tr>
			</form>
			</table>
			</div>
</body>
</html>