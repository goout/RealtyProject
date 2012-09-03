<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="org.realty.Translations" />

<html lang="${language}">



<head>
    <title><fmt:message key="advert.title" /></title>
</head>

<c:set var="commandForPage" value="allAdvert" scope="request"/>
<jsp:include page="Language.jsp" flush="true" />

<body>

<div id="head">

    <form id="form1" action="RealtyServlet">
        <input type="button" value="Log out" onclick="location.href='RealtyServlet?command=LogOut'" />


        <h1><fmt:message key="advert.head" /></h1>
        <h2><fmt:message key="advert.subhead" /></h2>
        <br />
</div>

<div id="content">


        <fieldset>
            <legend>
                <b><fmt:message key="advert.label.add" /></b>
            </legend>
            <form id="form1" action="RealtyServlet">
                <table>
                    <tr>
                        <td><fmt:message key="advert.label.category" />:
                        <td>
                        <td><input type="text" size="30" name="category" id="1"></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="advert.label.city" />:
                        <td>
                        <td><input type="text" size="30" name="city" id="2"></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="advert.label.district" />:
                        <td>
                        <td><input type="text" size="30" name="district" id="3"></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="advert.label.adress" />:
                        <td>
                        <td><input type="text" size="30" name="adress" id="4"></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="advert.label.coast" />:
                        <td>
                        <td><input type="text" size="30" name="coast" id="5"></td>
                    </tr>

                    <tr>
                        <td><fmt:message key="advert.label.description" />:
                        <td>
                        <td><input type="text" size="90" name="description" id="6"></td>
                    </tr>

                    <tr>
                        <td><fmt:message key="advert.label.user" />:</td>
                        <td><select name="userId" id="userId">


                            <c:forEach var="usr" items="${alladvertsusers}">
                                <c:if test="${usr.userId!=null }">
                                    <option value="<c:out value="${usr.userId}"/>"><c:out value="${usr.name}"/></option>
                                </c:if>
                            </c:forEach>

                        </select></td>


                    </tr>

                </table>
                <br /> <input type="submit" value=<fmt:message key="button.add" /> /> <input type="hidden"
                                                                                             name="command" value="addAdvert" />

            </form>

        </fieldset>



    </div>

</div>

<br>




</body>
</html>