<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="org.realty.Translations" />

<html lang="${language}">

<head>
    <title><fmt:message key="comm.title" /></title>
</head>

<c:set var="commandForPage" value="allComment" scope="request"/>
<jsp:include page="Language.jsp" flush="true" />

<body>

	<div id="head">
		<form id="form1" action="RealtyServlet">
		<input type="button" value="Log out" onclick="location.href='RealtyServlet?command=LogOut'" />


		<h1><fmt:message key="comm.head" /></h1>
		<h2><fmt:message key="comm.subhead" /></h2>
		<br />
	</div>

	<div id="content">

		<div id="menu">
			<br />
			<ul id="menu">

				<li><a href="RealtyServlet?command=allUser"><span><fmt:message key="menu.user" /></span></a></li>

				<li><a href="RealtyServlet?command=allAdvert"><span><fmt:message key="menu.advert" /></span></a></li>

				<li><a href="#"><span><fmt:message key="menu.comment" /></span></a></li>

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
				<c:forEach items="${allCommentsUserAdverts}" var="cmnt">
                    <c:if test="${cmnt.userId==null&&cmnt.advertId==null }">
					<tr>
						<TD><c:out value="${cmnt.commentId}" /></TD>
						<TD><c:out value="${cmnt.text}" /></TD>
						<TD><c:out value="${cmnt.commentUserId}" /></TD>
						<TD><c:out value="${cmnt.commentAdvertId}" /></TD>
						<td width="100"><a
							href="<c:url value='RealtyServlet?delCommentId=${cmnt.commentId}&command=delComment' />">Del</a></td>
					</tr>
                    </c:if>
				</c:forEach>
			</table>


			<br /> <br /> <br />
			<fieldset>
				<legend>
					<b><fmt:message key="comm.label.add" /></b>
				</legend>
				<form id="form1" action="RealtyServlet">
					<table>
						<tr>
							<td><fmt:message key="comm.label.txt" />:
							<td>
							<td><input type="text" size="30" name="text" id="1"></td>
						</tr>


						<tr>
						<td><fmt:message key="comm.label.usrId" />:</td>
							<td><select name="userId" id="userId">
								    <c:forEach var="usr" items="${allCommentsUserAdverts}">
                                        <c:if test="${usr.userId!=null }">
										<option value="<c:out value="${usr.userId}"/>"><c:out value="${usr.name}"/></option>
                                        </c:if>
                                    </c:forEach>
							</select></td>
						</tr>

						<tr>
							<td><fmt:message key="comm.label.advId" />:</td>
							<td><select name="advertId" id="advertId">
									<option value="select">Change AdvertId...</option>
									<c:forEach var="adv" items="${allCommentsUserAdverts}">
                                        <c:if test="${adv.advertId!=null }">
										<option value="<c:out value="${adv.advertId}"/>"><c:out value="${adv.description}"/></option>
                                        </c:if>
                                    </c:forEach>
							</select></td>
							
							
						</tr>


					</table>
					<br /> <input type="submit" value=<fmt:message key="button.add" /> /> <input type="hidden"
						name="command" value="addComment" />
				</form>
			</fieldset>



		</div>

	</div>

	<br>



	<div id="footer"></div>


</body>
</html>