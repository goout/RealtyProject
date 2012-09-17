<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="org.realty.Translations"/>
<c:set var="adv" value="${advDTO}"/>

<html lang="${language}">

<link href="style.css" rel="stylesheet" type="text/css">

<head>

    <title><fmt:message key="advert.title"/></title>

</head>

<c:set var="commandForPage" value="advert" scope="request"/>

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
                <li></li>
                <li><fmt:message key="button.logout" var="Out"/>
                    <input type="button" value="${Out}" onclick="location.href='RealtyServlet?command=LogOut'"/></li>
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


            <table width="1000" height="600" border="0" cellpadding="5" style="background-color:#98FB98">
                <tr>
                    <td>


                        <h2><fmt:message key="advert.subhead"/></h2>


                        <table height="590" border="0" align="center">
                            <tr>
                                <td>

                                    <fieldset>
                                        <legend>
                                            <b><fmt:message key="advert.label.add"/></b>
                                        </legend>
                                        <form id="form1" action="RealtyServlet">
                                            <table border="0">
                                                <tr>
                                                    <td><fmt:message key="advert.label.category"/>:
                                                    <td><input type="text" size="30" name="category" id="1"></td>
                                                </tr>

                                                <tr>
                                                    <td><fmt:message key="rooms"/>
                                                    <td><input type="text" size="30" name="rooms" id="7"></td>
                                                </tr>

                                                <tr>

                                                </tr>
                                                <tr>
                                                    <td><fmt:message key="advert.label.coast"/>:
                                                    <td><input type="text" size="30" name="coast" id="5"></td>
                                                </tr>

                                                <td><fmt:message key="advert.label.description"/>:
                                                <td>
                                                <select name="userId" id="userId"
                                                        style="visibility:hidden;">


                                                    <option value="<c:out value="${adv.userId}"/>"><c:out
                                                            value="${adv.userId}"/></option>


                                                </select>

                                                <select name="adressId" id="adressId"
                                                        style="visibility:hidden;">
                                                    <option value="<c:out value="${adv.adressId}"/>"><c:out
                                                            value="${adv.adressId}"/></option>
                                                </select>


                                               </td>
                                                <tr>

                                                    <td COLSPAN=2><textarea rows="10" cols="35" name="description"
                                                    id="6"></textarea>
                                                    </td>

                                                </tr>




                                            </table>
                                            <br/> <input type="submit" value=
                                                <fmt:message key="button.add"/>> <input type="hidden"
                                                                                         name="command"
                                                                                         value="addAdvert"/>

                                        </form>

                                    </fieldset>


                                </td>
                        </table>

                        <br>

                        </div>


                    </td>
            </table>
        </td>
</table>





<center>
    <div id="niz">
        <span class="cop"></span>
    </div>
</center>


</body>
</html>