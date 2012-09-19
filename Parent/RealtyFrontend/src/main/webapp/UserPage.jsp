<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="org.realty.Translations" />



<html lang="${language}">

<link href="style.css" rel="stylesheet" type="text/css">

<head>

    <title><fmt:message key="str" /></title>

</head>

<c:set var="commandForPage" value="userPage" scope="request"/>

<body>

<br>
<table width="1000" height="0" border="1" align="center" cellpadding="5" cellspacing="0" style="color:#dcdcdc;  background-color:#FFFFFf"><tr><td>

    <div id="kn">
        <li><img src="images/logo2.jpg"></li>
        <li><jsp:include page="Language.jsp" flush="true" /></li>
        <li></li>
        <li></li>

        <li><fmt:message key="button.logout" var="Out"/>
            <input type="button" value="${Out}" onclick="location.href='RealtyServlet?command=LogOut'"/></li>
        <li><form id="form5" action="RealtyServlet">
            <fmt:message key="button.add" var="Add" />
            <input type="button" value="${Add}" onclick="location.href='RealtyServlet?command=adress'" />
        </form></li>
        <li>  <div id="head">

            <h2><fmt:message key="user.subhead"/></h2>
        </div></li>
        <li>
            <c:set var="adm" value="${admin}"/>
                <c:choose>
                <c:when test="${adm == true}">
                    <fmt:message key="admin" var="admin" />
                    <input type="button" value="${admin}" onclick="location.href='RealtyServlet?command=allUser'" />
                </c:when>
                <c:otherwise>
                    <fmt:message key="admin" var="admin" />
                    <input type="button" value="${admin}" style="display:none;" onclick="location.href='RealtyServlet?command=allUser'" />
                </c:otherwise>
            </c:choose>


        </li>
    </div>

</td></table>

<table width="1000" height="0" border="0" cellpadding="5" cellspacing="0" align="center"  style="background-color:#ffffff"><tr><td>



    <table width="1000" height="0" border="0" cellpadding="5"  style="background-color:#98FB98"><tr><td>
        <div id="head2">

            <h2><fmt:message key="user.subhead"/></h2>
        </div>


        <div id="content">




            <div id="table" style="width:1000px; height:600px; overflow:auto;">
                <br />
                <form id="form3" action="RealtyServlet">

                    <c:forEach items="${allAdvertsUsrDto}" var="adv">



                        <table cellpadding=2 border="1" cellspacing=0 width=700 align="center" >
                            <col width="140">
                            <col width="140">
                            <col width="140">
                            <col width="210">
                            <col width="70">
                            <tr>


                                <td><c:out value="${adv.addedDate}" /></td>
                                <td><c:out value="${adv.userName}" /></td>
                                <td><c:out value="${adv.category}" /></td>
                                <td></td>
                                <td><c:out value="${adv.coast}" />$</td>
                            </tr>
                            <tr>
                                <td colspan="4" ><c:out value="${adv.description}" /></td>
                                <td ><a
                                        href="<c:url value='RealtyServlet?advertId=${adv.advertId}&command=advertPage' />">Details</a></td></td>
                            </tr>
                        </table>
                        <br />
                    </c:forEach>

                </form>

                <br /> <br /> <br />





            </div>

        </div>


    </td></table>
</td></table>






<center><div id="niz">
    <span class="cop"></span>
</div></center>







</body>
</html>