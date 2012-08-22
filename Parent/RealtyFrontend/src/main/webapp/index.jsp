<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div id="head">

		<form id="form1" action="RealtyServlet">
		<input type="button" value="Sign in" onclick="location.href='Authentication.jsp'" />
		</form>



		<h1>Realty</h1>
		<h2>Guest Page</h2>
		<br />
	</div>

	<div id="content">




		<div id="table">
			<br />
			<form id="form3" action="RealtyServlet">
				<table border="2" frame="below" width="100%" bordercolor=red>
					<thead>
						<tr>
							<td width="100">AddedDate</td>

							<td width="100">Category</td>

                            <td width="100">City</td>

							<td width="100">District</td>

							<td width="100">Adress</td>

							<td width="30">Coast</td>

							<td width="200">Description</td>

						</tr>
					</thead>
					<c:forEach items="${alladverts}" var="adv">

						<tr>
							<TD><c:out value="${adv.addedDate}" /></TD>
							<TD><c:out value="${adv.category}" /></TD>
                            <TD><c:out value="${adv.city}" /></TD>
							<TD><c:out value="${adv.district}" /></TD>
							<TD><c:out value="${adv.adress}" /></TD>
							<TD><c:out value="${adv.coast}" /></TD>
							<TD><c:out value="${adv.description}" /></TD>
						</tr>
					</c:forEach>
				</table>
			</form>

			<br /> <br /> <br />




		</div>

	</div>





</body>
</html>