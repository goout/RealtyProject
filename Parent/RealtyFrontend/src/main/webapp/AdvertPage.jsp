<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="org.realty.Translations" />
<c:set var="adv" value="${allAdvertsUsrAdrDto}"/>

<html lang="${language}">

<link href="style.css" rel="stylesheet" type="text/css">

<head>

    <title><fmt:message key="advert.title" /></title>

</head>

<body>

<br>
<table width="1000" height="0" border="1" align="center" cellpadding="5" cellspacing="0" style="color:#dcdcdc;  background-color:#FFFFFf"><tr><td>

    <div id="kn">
        <li><img src="images/logo2.jpg"></li>
        <li><jsp:include page="Language.jsp" flush="true" /></li>
        <li></li>
        <li></li>
        <li></li>
        <li>  <input type="button" value="Log out" onclick="location.href='RealtyServlet?command=LogOut'" /></li>
        <li>Registration</li>
        <li>  <div id="head">

            <h2><fmt:message key="advert.subhead"/></h2>
        </div></li>
    </div>

</td></table>

<table width="1000" height="0" border="0" cellpadding="5" cellspacing="0" align="center"  style="background-color:#ffffff"><tr><td>



    <table width="1000" height="0" border="0" cellpadding="5"  style="background-color:#98FB98"><tr><td>
        <div id="head2">

            <h2><fmt:message key="advert.subhead"/></h2>
        </div>


        <div id="content">


            <div id="table" style="width:1000px; height:640px; overflow:auto;">
                <br />
                <form id="form3" action="RealtyServlet">


                        <table border=1 cellpadding=2 cellspacing=1 width=700 align="center" >
                            <tr>
                                <td width="100">AddedDate</td>

                                <td width="100">Category</td>

                                <td width="100">City</td>

                                <td width="100">District</td>

                                <td width="100">Street</td>

                                <td width="30">House</td>

                                <td width="200">Apartment</td>

                                <td width="50">Coast</td>

                                <td width="50">User</td>

                                <td width="50">Description</td>
                            </tr>
                            </thead>
                            </br>
                            </br>
                            </br>

                                    <tr>
                                        <TD><c:out value="${adv.addedDate}" /></TD>
                                        <TD><c:out value="${adv.category}" /></TD>
                                        <TD><c:out value="${adv.cityName}" /></TD>
                                        <TD><c:out value="${adv.districtName}" /></TD>
                                        <TD><c:out value="${adv.streetName}" /></TD>
                                        <TD><c:out value="${adv.houseNum}" /></TD>
                                        <TD><c:out value="${adv.apartmentNum}" /></TD>
                                        <TD><c:out value="${adv.coast}" /></TD>
                                        <TD><c:out value="${adv.name}" /></TD>
                                        <TD><c:out value="${adv.description}" /></TD>





                                    </tr>


                        </table>
                        <br />


                </form>

                <br /> <br /> <br />




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