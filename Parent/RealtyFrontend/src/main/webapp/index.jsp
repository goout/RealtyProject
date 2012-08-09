<html>
<head>
<meta http-equiv="Page-Enter" content="BlendTrans(Duration=2.0)">
<link rel="stylesheet" type="text/css" href="style/styl2e.css" />



</head>
<body>

	<div id="head">

		<h1>Realty</h1>
		<h2>User Page</h2>
		<br />
	</div>

	<div id="content">


		<div id="table">
			<br />

			<table border="2" frame="below" width="100%" bordercolor=red>
				<thead>
					<tr>
						<td width="100">UserId</td>

						<td width="300">Name</td>

						<td width="250">Password</td>

						<td width="100">Phone</td>

						<td width="100"></td>
					</tr>
				</thead>
			
			</table>


			<br /> <br /> <br />
			<fieldset>
				<legend>
					<b>Add User</b>
				</legend>
				<form id="form1" action="AirportServlet">
					<table>
						<tr>
							<td>Name:
							<td>
							<td><input type="text" size="30" name="airportName" id="1"></td>
						</tr>
						<tr>
							<td>Password:
							<td>
							<td><input type="text" size="30" name="airportCity" id="2"></td>
						</tr>
						<tr>
							<td>Phone:
							<td>
							<td><input type="text" size="30" name="employeeCount" id="3"></td>
						</tr>

					</table>
					<br /> <input type="submit" value="Add" /> <input type="hidden"
						name="command" value="addAirport" />
				</form>
			</fieldset>



		</div>

	</div>

	<div id="footer"></div>


</body>
</html>