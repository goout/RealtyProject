<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="org.realty.Translations" />

<html lang="${language}">


<head>
    <title><fmt:message key="user.title" /></title>
</head>

<c:set var="commandForPage" value="allUser" scope="request"/>
<jsp:include page="Language.jsp" flush="true" />


<body>

<div id="head">

    <form id="form1" action="RealtyServlet">
        <input type="button" value="Log out" onclick="location.href='RealtyServlet?command=LogOut'" />


        <h1><fmt:message key="user.head" /></h1>
        <h2><fmt:message key="user.subhead" /></h2>
        <br />
</div>

<div id="content">

    <div id="menu">
        <br/>
        <ul id="menu">

            <li><a href="#"><span><fmt:message key="menu.user" /></span></a></li>

            <li><a href="RealtyServlet?command=allAdvert"><span><fmt:message key="menu.advert" /></span></a></li>

            <li><a href="RealtyServlet?command=allComment"><span><fmt:message key="menu.comment" /></span></a></li>

        </ul>

    </div>


    <div id="table">
        <br />




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



                </table>
                <br /> <input type="submit" value=<fmt:message key="button.add" /> /> <input type="hidden"
                                                                                             name="command" value="addUser" />
            </form>
        </fieldset>



    </div>

</div>

<div id="footer"></div>


</body>
</html>