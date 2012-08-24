<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="org.realty.Translations" />

<html lang="${language}">
<head>

    <title><fmt:message key="index.title" /></title>

</head>
<body>

<jsp:include page="Language.jsp" flush="true" />



<div id="head">

    <form id="form1" action="RealtyServlet">
        <fmt:message key="button.signIn" var="SignIn" />
        <input type="button" value="${SignIn}" onclick="location.href='Authentication.jsp'" />
    </form>



    <h1><fmt:message key="index.head"/></h1>
    <h2><fmt:message key="index.subhead"/></h2>
    <br />
</div>

<div id="content">




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

                </tr>
                </thead>
                <c:forEach items="${alladverts}" var="adv">

                    <tr>
                        <TD><c:out value="${adv.addedDate}" /></TD>
                        <TD><c:out value="${adv.category}" /></TD>
                        <TD><c:out value="${adv.city}" /></TD>
                        <TD><c:out value="${adv.district}" /></TD>
                        <TD><c:out value="${adv.adress}" /></TD>
                        <TD><c:out value="${adv.coast}" /></TD>
                        <TD><c:out value="${adv.description}" /></TD>
                    </tr>
                </c:forEach>
            </table>
        </form>

        <br /> <br /> <br />




    </div>

</div>





</body>
</html>