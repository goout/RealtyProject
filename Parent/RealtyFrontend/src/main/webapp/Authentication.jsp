<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<h1>Realty</h1>
<h2>Authentication Page</h2>
</head>
<body>

<fieldset>
				<legend>
					<b>Sign in</b>
				</legend>
				<form id="form1" action="RealtyServlet">
					<table>
						<tr>
							<td>Name:
							<td>
							<td><input type="text" size="30" name="name" id="1"></td>
						</tr>
						<tr>
							<td>Password:
							<td>
							<td><input type="text" size="30" name="passwordt" id="2"></td>
						</tr>
			

					</table>
					<br /> <input type="submit" value="Sign in" /> <input type="hidden"
						name="command" value="signIn" />
				</form>
			</fieldset>



</body>
</html>