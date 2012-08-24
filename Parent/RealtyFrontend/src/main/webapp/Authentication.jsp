<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="org.realty.Translations" />

<html lang="${language}">
<head>

<title><fmt:message key="auth.title" /></title>

</head>

<jsp:include page="Language.jsp" flush="true" />

<h1><fmt:message key="auth.head" /></h1>
<h2><fmt:message key="auth.subhead" /></h2>

<body>



<fieldset>
				<legend>
					<b><fmt:message key="auth.label.signIn" /></b>
				</legend>
				<form id="form1" action="RealtyServlet">
					<table>
						<tr>
							<td><fmt:message key="auth.label.name" />:
							<td>
							<td><input type="text" size="30" name="name" id="1"></td>
						</tr>
						<tr>
							<td><fmt:message key="auth.label.pass" />:
							<td>
							<td><input type="PASSWORD" size="30" name="passwordt" id="2"></td>
						</tr>
			

					</table>
					<br /> <input type="submit" value=<fmt:message key="auth.label.signIn" /> /> <input type="hidden"
						name="command" value="signIn" />
				</form>
			</fieldset>



</body>
</html>