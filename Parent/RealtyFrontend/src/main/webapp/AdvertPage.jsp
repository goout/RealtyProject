<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="org.realty.Translations"/>
<c:set var="adv" value="${allAdvertsUsrAdrDto}"/>

<html lang="${language}">

<link href="style.css" rel="stylesheet" type="text/css">

<head>

    <title>teeest</title>


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
                <li><input type="button" value="Log out" onclick="location.href='RealtyServlet?command=LogOut'"/></li>
                <li>Registration</li>
                <li>
                    <div id="head">

                        <h2><fmt:message key="advert.subhead"/></h2>
                    </div>
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
                        <div id="head2">

                            <h2><fmt:message key="advert.subhead"/></h2>
                        </div>


                        <div id="content">


                            <div id="table" style="width:1000px; height:640px; overflow:auto;">
                                <br/>

                                <form id="form3" action="RealtyServlet">


                                    <table border=1 cellpadding=2 cellspacing=1 width=700 align="center">


                                        <TR>
                                            <TH>AddedDate</TH>
                                            <TD><c:out value="${adv.addedDate}"/></TD>
                                        <TR>
                                            <TH>Description</TH>
                                            <TD><c:out value="${adv.description}"/></TD>
                                        <TR>
                                            <TH>Category</TH>
                                            <TD><c:out value="${adv.category}"/></TD>
                                        <TR>
                                            <TH>City</TH>
                                            <TD><c:out value="${adv.cityName}"/></TD>
                                        <TR>
                                            <TH>District</TH>
                                            <TD><c:out value="${adv.districtName}"/></TD>
                                        <TR>
                                            <TH>Street</TH>
                                            <TD><c:out value="${adv.streetName}"/></TD>
                                        <TR>
                                            <TH>House</TH>
                                            <TD><c:out value="${adv.houseNum}"/></TD>
                                        <TR>
                                            <TH>Apartment</TH>
                                            <TD><c:out value="${adv.apartmentNum}"/></TD>
                                        <TR>
                                            <TH>Coast</TH>
                                            <TD><c:out value="${adv.coast}"/></TD>
                                        <TR>
                                            <TH>User</TH>
                                            <TD><c:out value="${adv.name}"/></TD>
                                        <TR>
                                        <TH>Phone</TH>
                                        <TD><c:out value="${adv.phoneNumber}"/></TD>


                                    </table>
                                    <br/>


                                </form>

                                <br/>


                                <c:forEach items="${allAdvertsUsrAdrDto.comments}" var="cmnt">


                                    <table border=1 cellpadding=2 cellspacing=1 width=600 align="center">
                                        <col width="140">
                                        <col width="140">
                                        <col width="140">
                                        <col width="210">
                                        <col width="70">
                                        <tr>


                                            <td><c:out value="${usr.name}"/></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td colspan="5"><c:out value="${cmnt.text}"/></td>
                                        </tr>
                                    </table>


                                </c:forEach>


                            </div>

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