<html>
<head>
<style>
.error {
	color: red;
	font-weight: bold
}
</style>
</head>
<body>
	<div align="center">
		<form action="accountDetails" method="post">
			<table>
				<tr>
					<td>AccountNo</td>
					<td><input type="text" name="accountNo"></td>
					<td><input type="submit" value="click"></td>
					<td><a href="Index">||Home||</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div align="center" class="error">${errorMessge }</div>
	<br>
	<br>
	<div align="center">
		<table>
			<tr>
				<th>AccountNo</th>
				<th>AccountBalance</th>
				<th>AccountType</th>
				<th>PinNo</th>
				<th>AccountStatus</th>
			</tr>
			<tr>
				<td>${account.accountNo }</td>
				<td>${account.accountBalance }</td>
				<td>${account.accountType }</td>
				<td>${account.pinNumber}</td>
				<td>${account.accountStatus }</td>	
			</tr>
		</table>
	</div>
</body>
</html>