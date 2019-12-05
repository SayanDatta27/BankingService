<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<form action="withdrawBalance" method="post" modelAttribute="account">
			<tr>
				<td>AccountNo</td>
				<td><input type="text" name="accountNo"></td>
			</tr>
			<tr>
				<td>Withdraw Amount</td>
				<td><input type="text" name="amount"></td>
			</tr>
			<tr>
				<td>Pin No</td>
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
				
				<th>Account Balance</th>
			</tr>
			<tr>
				
				<td>${accBal}</td>
			</tr>
		</table>
	</div>
</body>
</html>