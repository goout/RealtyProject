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

		<h1>Realty</h1>
		<h2>Comment Page</h2>
		<br />
	</div>

	<div id="content">

		<div id="menu">
			<br />
			<ul id="menu">

				<li><a href="/RealtyFrontend/RealtyServlet"><span>User</span></a></li>

				<li><a href="RealtyServlet?command=allAdvert"><span>Advert</span></a></li>

				<li><a href="#"><span>Comment</span></a></li>

			</ul>

		</div>


		<div id="table">
			<br />

			<table border="2" frame="below" width="100%" bordercolor=red>
				<thead>
					<tr>
						<td width="100">CommentId</td>

						<td width="100">Text</td>

						<td width="100">UserId</td>

						<td width="100">AdvertId</td>

						<td width="50"></td>
					</tr>
				</thead>
				<c:forEach items="${allcomments}" var="cmnt">

					<tr>
						<TD><c:out value="${cmnt.commentId}" /></TD>
						<TD><c:out value="${cmnt.text}" /></TD>
						<TD><c:out value="${cmnt.userId}" /></TD>
						<TD><c:out value="${cmnt.advertId}" /></TD>
						<td width="100"><a
							href="<c:url value='RealtyServlet?delCommentId=${cmnt.commentId}&command=delComment' />">Del</a></td>
					</tr>
				</c:forEach>
			</table>


			<br /> <br /> <br />
			<fieldset>
				<legend>
					<b>Add Comment</b>
				</legend>
				<form id="form1" action="RealtyServlet">
					<table>
						<tr>
							<td>Text:
							<td>
							<td><input type="text" size="30" name="text" id="1"></td>
						</tr>


						<tr>
						<td>UserId:</td>
							<td><select name="userId" id="userId">
									<option value="select">Change UserId...</option>
									<c:forEach var="usr" items="${allusers}">
										<option value="<c:out value="${usr.userId}"/>"><c:out value="${usr.name}"/></option>
									</c:forEach>
							</select></td>
						</tr>

						<tr>
							<td>AdvertId:</td>
							<td><select name="advertId" id="advertId">
									<option value="select">Change AdvertId...</option>
									<c:forEach var="adv" items="${alladverts}">
										<option value="<c:out value="${adv.advertId}"/>"><c:out value="${adv.description}"/></option>
									</c:forEach>
							</select></td>
							
							
						</tr>


					</table>
					<br /> <input type="submit" value="Add" /> <input type="hidden"
						name="command" value="addComment" />
				</form>
			</fieldset>



		</div>

	</div>

	<br>



	<div id="footer"></div>


</body>
</html>