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

    <title><fmt:message key="advert.title"/></title>

</head>
<c:set var="commandForPage" value="allAdvert" scope="request"/>


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
                <li><a href="RealtyServlet?command=allUser"><span><fmt:message key="menu.user"/></span></a></li>
                <li><a href="#"><span><fmt:message key="menu.advert"/></span></a></li>
                <li><a href="RealtyServlet?command=allComment"><span><fmt:message key="menu.comment"/></span></a></li>
                <li><fmt:message key="button.logout" var="Out"/>
                    <input type="button" value="${Out}" onclick="location.href='RealtyServlet?command=LogOut'"/></li>
                <li><fmt:message key="main" var="main"/>
                    <input type="button" value="${main}" onclick="location.href='RealtyServlet?command=indexGuest'"/></li>
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


                            <div id="table" style="width:1000px; height:600px; overflow:auto;">

                                <form id="form3" action="RealtyServlet">
                                    <table border="2" frame="below" width="100%" bordercolor=red>
                                        <thead>
                                        <tr>
                                            <td width="100">AddedDate</td>

                                            <td width="100">Category</td>


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
                                                    <TD><c:out value="${adv.addedDate}"/></TD>
                                                    <TD><c:out value="${adv.category}"/></TD>

                                                    <TD><c:out value="${adv.coast}"/></TD>
                                                    <TD><c:out value="${adv.description}"/></TD>
                                                    <TD><c:out value="${adv.advertId}"/></TD>
                                                    <TD><c:out value="${adv.advertUserId}"/></TD>

                                                    <td width="100"><a
                                                            href="<c:url value='RealtyServlet?delAdvertId=${adv.advertId}&command=delAdvert' />">Del</a>
                                                    </td>


                                                </tr>
                                            </c:if>
                                        </c:forEach>

                                    </table>
                                </form>

                                <br/> <br/> <br/>

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