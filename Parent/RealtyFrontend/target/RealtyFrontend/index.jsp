<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<head>
</head>

<body>

	<div id="head">

		<h1>Realty</h1>
		<h2>User Page</h2>
		<br />
	</div>

	<div id="content">

		<div id="menu">
<br/>
			<ul id="menu">

				<li><a href="#"><span>User</span></a></li>

				<li><a href="Advert.jsp"><span>Advert</span></a></li>

				<li><a href="#"><span>Comment</span></a></li>

			</ul>

		</div>


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
						<TD><c:out value="${usr.userId}" /></TD>
						<TD><c:out value="${usr.name}" /></TD>
						<TD><c:out value="${usr.password}" /></TD>
						<TD><c:out value="${usr.phoneNumber}" /></TD>
						<td width="100"><a
							href="<c:url value='RealtyServlet?delUserId=${usr.userId}&command=delUser' />">Delete</a></td>
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