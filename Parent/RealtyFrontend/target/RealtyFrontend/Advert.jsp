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
		<input type="button" value="Log out" onclick="location.href='RealtyServlet?command=LogOut'" />


		<h1>Realty</h1>
		<h2>Advert Page</h2>
		<br />
	</div>

	<div id="content">

		<div id="menu">
			<br />
			<ul id="menu">

				<li><a href="RealtyServlet?command=allUser"><span>User</span></a></li>

				<li><a href="#"><span>Advert</span></a></li>

				<li><a href="RealtyServlet?command=allComment"><span>Comment</span></a></li>

			</ul>

		</div>


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

						<td width="50">AdvertId</td>

						<td width="50">UserId</td>

						<td width="50"></td>
					</tr>
				</thead>

				<c:forEach items="${alladvertsusers}" var="adv">
                    <c:if test="${adv.userId==null }">
					<tr>
						<TD><c:out value="${adv.addedDate}" /></TD>
						<TD><c:out value="${adv.category}" /></TD>
                        <TD><c:out value="${adv.city}" /></TD>
						<TD><c:out value="${adv.district}" /></TD>
						<TD><c:out value="${adv.adress}" /></TD>
						<TD><c:out value="${adv.coast}" /></TD>
						<TD><c:out value="${adv.description}" /></TD>
						<TD><c:out value="${adv.advertId}" /></TD>
						<TD><c:out value="${adv.advertUserId}" /></TD>
						<td width="100"><a
							href="<c:url value='RealtyServlet?delAdvertId=${adv.advertId}&command=delAdvert' />">Del</a></td>

					
					</tr>
                    </c:if>
				</c:forEach>

			</table>
</form>

			<br /> <br /> <br />
			<fieldset>
				<legend>
					<b>Add Advert</b>
				</legend>
				<form id="form1" action="RealtyServlet">
					<table>
						<tr>
							<td>Category:
							<td>
							<td><input type="text" size="30" name="category" id="1"></td>
						</tr>
                        <tr>
                            <td>City:
                            <td>
                            <td><input type="text" size="30" name="city" id="2"></td>
                        </tr>
                        <tr>
							<td>District:
							<td>
							<td><input type="text" size="30" name="district" id="3"></td>
						</tr>
						<tr>
							<td>Adress:
							<td>
							<td><input type="text" size="30" name="adress" id="4"></td>
						</tr>
						<tr>
							<td>Coast:
							<td>
							<td><input type="text" size="30" name="coast" id="5"></td>
						</tr>

						<tr>
							<td>Description:
							<td>
							<td><input type="text" size="90" name="description" id="6"></td>
						</tr>

						<tr>
							<td>UserName:</td>
							<td><select name="userId" id="userId">


									<c:forEach var="usr" items="${alladvertsusers}">
                                        <c:if test="${usr.userId!=null }">
										<option value="<c:out value="${usr.userId}"/>"><c:out value="${usr.name}"/></option>
                                        </c:if>
                                    </c:forEach>

							</select></td>


						</tr>

					</table>
					<br /> <input type="submit" value="Add" /> <input type="hidden"
						name="command" value="addAdvert" />

				</form>

			</fieldset>
			


		</div>

	</div>

	<br>




</body>
</html>