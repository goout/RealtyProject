<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
  
Test Page<br/>
<c:out value="This 222 is JSTL"/>  
  
<html>

<head>
</head>

<body>

<c:out value="The numbers are: " /><br>
<c:forEach var="num" begin="1" end="5" step="1">
<c:out value="${num}" />
<br>
</c:forEach>

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
							<c:forEach items="${allusers}" var="usr">

					<tr>

						<td>${usr.userId}</td>

						<td>${usr.name}</td>

						<td>${usr.password}</td>

						<td>${usr.phoneNumber}</td>

                        <td width="100"><a href="RealtyServlet?delUserId=${usr.id}&command=delUser" >Delete</a></td>  
					</tr>
				</c:forEach>
			</table>


			<br /> <br /> <br />
			<fieldset>
				<legend>
					<b>Add User</b>
				</legend>
				<form id="form1" action="RealtyServlet">
					<table>
						<tr>
							<td>Name:
							<td>
							<td><input type="text" size="30" name="userName" id="1"></td>
						</tr>
						<tr>
							<td>Password:
							<td>
							<td><input type="text" size="30" name="password" id="2"></td>
						</tr>
						<tr>
							<td>Phone:
							<td>
							<td><input type="text" size="30" name="phoneNumber" id="3"></td>
						</tr>

					</table>
					<br /> <input type="submit" value="Add" /> <input type="hidden"
						name="command" value="addUser" />
				</form>
			</fieldset>



		</div>

	</div>

	<div id="footer"></div>


</body>
</html>