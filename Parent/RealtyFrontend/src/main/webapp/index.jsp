<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="org.realty.Translations"/>

<html lang="${language}">

<link href="style.css" rel="stylesheet" type="text/css">


<head>

    <title><fmt:message key="str"/></title>

</head>

<body>

<br>
<table width="1000" height="0" border="1" align="center" cellpadding="5" cellspacing="0"
       style="color:#dcdcdc;  background-color:#FFFFFf">
    <tr>
        <td>

            <div id="kn">
                <li><img src="images/logo2.jpg"></li>
                <li>
                    <jsp:include page="Language.jsp" flush="true"/>
                </li>
                <li></li>
                <li></li>
                <li></li>
                <li>
                    <form id="form1" action="RealtyServlet">
                        <fmt:message key="button.signIn" var="SignIn"/>
                        <input type="button" value="${SignIn}" onclick="location.href='Authentication.jsp'"/>
                    </form>
                </li>
                <li>
                    <form id="form5" action="RealtyServlet">
                        <fmt:message key="button.registration" var="Registration"/>
                        <input type="button" value="${Registration}" onclick="location.href='RegistrationPage.jsp'"/>
                    </form>
                </li>
                <li>
                <h2><fmt:message key="index.subhead"/></h2>
               </li>
            </div>

        </td>
</table>

<table width="1000" height="0" border="0" cellpadding="5" cellspacing="0" align="center"
       style="background-color:#ffffff">
    <tr>
        <td>


            <table width="1000" height="0" border="0" cellpadding="5" style="background-color:#98FB98">
                <tr>
                    <td>

                            <h2><fmt:message key="index.subhead"/></h2>


                            <div id="table" style="width:1000px; height:600px; overflow:auto;">
                                <br/>

                                <form id="form3" action="RealtyServlet">

                                    <c:forEach items="${allAdvertsDto}" var="adv">


                                        <table  border=1 cellpadding=2 cellspacing=0 width=700 align="center">
                                            <col width="175">
                                            <col width="135">
                                            <col width="275">
                                            <col width="125">
                                            <tr>


                                                <td><c:out value="${adv.addedDate}"/></td>
                                                <td><c:out value="${adv.category}"/></td>
                                                <td></td>
                                                <td><c:out value="${adv.coast}"/>$</td>
                                            </tr>
                                            <tr>
                                                <td colspan="4"><c:out value="${adv.description}"/></td>
                                            </tr>
                                        </table>
                                        <br/>
                                    </c:forEach>

                                </form>

                                <br/> <br/> <br/>


                            </div>




                    </td>
            </table>
        </td>
</table>


<c:set var="commandForPage" value="indexGuest" scope="request"/>


<center>
    <div id="niz">
        <span class="cop"></span>
    </div>
</center>


</body>
</html>