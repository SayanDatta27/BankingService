<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit</title>
</head>
<body>
	<div align="center">
		<h2>Deposit</h2>
		<table>
			<form action="depositBalance" method="post" modelAttribute="account">
			<tr>
				<td>AccountNo</td>
				<td><input type="text" name="accountNo"></td>
			</tr>
			<tr>
				<td>Deposit Amount</td>
				<td><input type="text" name="amount"></td>
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
				
				<th>Account Balance</th>
			</tr>
			<tr>
				
				<td>${accBalance}</td>
			</tr>
		</table>
	</div>
</body>
</html>