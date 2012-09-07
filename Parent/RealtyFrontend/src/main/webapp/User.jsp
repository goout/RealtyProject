<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="org.realty.Translations" />

<html lang="${language}">

<link href="style.css" rel="stylesheet" type="text/css">

<head>

    <title><fmt:message key="user.title" /></title>

</head>
<c:set var="commandForPage" value="allUser" scope="request"/>


<body>

<br>
<table width="1000" height="0" border="1" align="center" cellpadding="5" cellspacing="0" style="color:#dcdcdc;  background-color:#FFFFFf"><tr><td>

    <div id="kn">
        <li><img src="images/logo2.jpg"></li>
        <li><jsp:include page="Language.jsp" flush="true" /></li>
        <li><a href="#"><span><fmt:message key="menu.user" /></span></a></li>
        <li><a href="RealtyServlet?command=allAdvert"><span><fmt:message key="menu.advert" /></span></a></li>
        <li><a href="RealtyServlet?command=allComment"><span><fmt:message key="menu.comment" /></span></a></li>
        <li>  <input type="button" value="Log out" onclick="location.href='RealtyServlet?command=LogOut'" /></li>
        <li></li>
        <li>  <div id="head">

            <h2><fmt:message key="user.subhead"/></h2>
        </div></li>
    </div>

</td></table>

<table width="1000" height="0" border="0" cellpadding="5" cellspacing="0" align="center"  style="background-color:#ffffff"><tr><td>



    <table width="1000" height="0" border="0" cellpadding="5"  style="background-color:#98FB98"><tr><td>
        <div id="head2">

            <h2><fmt:message key="user.subhead"/></h2>
        </div>


        <div id="content">




            <div id="table" style="width:1000px; height:640px; overflow:auto;">
                <br />
                <div id="table">
                    <br />

                    <table border="2" frame="below" width="100%" bordercolor=red>
                        <thead>
                        <tr>
                            <td width="100">UserId</td>

                            <td width="300">Name</td>

                            <td width="250">Password</td>

                            <td width="100">Phone</td>

                            <td width="50">Admin</td>

                            <td width="100"></td>
                        </tr>
                        </thead>
                        <c:forEach var="usr" items="${allusers}">
                            <tr>
                                <TD><c:out value="${usr.userId}" /></TD>
                                <TD><c:out value="${usr.name}" /></TD>
                                <TD><c:out value="${usr.password}" /></TD>
                                <TD><c:out value="${usr.phoneNumber}" /></TD>
                                <TD><c:out value="${usr.admin}" /></TD>
                                <td width="100"><a
                                        href="<c:url value='RealtyServlet?delUserId=${usr.userId}&command=delUser' />">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>


                    <br /> <br /> <br />
                    <fieldset>
                        <legend>
                            <b><fmt:message key="user.label.add" /></b>
                        </legend>
                        <form id="form1" action="RealtyServlet">
                            <table>
                                <tr>
                                    <td><fmt:message key="user.label.name" />:
                                    <td>
                                    <td><input type="text" size="30" name="userName" id="1"></td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="user.label.pass" />:
                                    <td>
                                    <td><input type="text" size="30" name="password" id="2"></td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="user.label.phone" />:
                                    <td>
                                    <td><input type="text" size="30" name="phoneNumber" id="3"></td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="user.label.admin" />:</td>
                                    <td><select name="isAdmin" id="isAdmin">
                                        <option value="1">Yes</option>
                                        <option value="0">No</option>
                                    </select></td>
                                </tr>


                            </table>
                            <br /> <input type="submit" value=<fmt:message key="button.add" /> /> <input type="hidden"
                                                                                                         name="command" value="addUser" />
                        </form>
                    </fieldset>





            </div>

        </div>


    </td></table>
</td></table>




<c:set var="commandForPage" value="indexGuest" scope="request"/>


<center><div id="niz">
    <span class="cop"></span>
</div></center>







</body>
</html>