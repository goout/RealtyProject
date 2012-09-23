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

    <title><fmt:message key="auth.title"/></title>

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
                <li><fmt:message key="main" var="main"/>
                    <input type="button" value="${main}" onclick="location.href='RealtyServlet?command=indexGuest'"/></li>
                <li>
                    <form id="form" action="RealtyServlet">
                        <fmt:message key="button.signIn" var="SignIn"/>
                        <input type="button" value="${SignIn}" onclick="location.href='Authentication.jsp'"/>
                    </form>
                </li>
                <li>
              <h2><fmt:message key="registration.subhead"/></h2>

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
                            <h2><fmt:message key="registration.subhead"/></h2>



                        <div id="table" style="width:1000px; height:600px;">
                            <table    border="0" align="center">
                                <tr>
                                    <td>

                                        <fieldset>
                                            <legend>
                                                <b><fmt:message key="registration.label"/></b>
                                            </legend>
                                            <form id="form1" action="RealtyServlet">
                                                <table>
                                                    <tr>
                                                        <td><fmt:message key="user.label.name"/>:
                                                        <td>
                                                        <td><input type="text" size="30" name="userName" id="1"></td>
                                                    </tr>
                                                    <tr>
                                                        <td><fmt:message key="user.label.pass"/>:
                                                        <td>
                                                        <td><input type="text" size="30" name="password" id="2"></td>
                                                    </tr>
                                                    <tr>
                                                        <td><fmt:message key="user.label.phone"/>:
                                                        <td>
                                                        <td><input type="text" size="30" name="phoneNumber" id="3"></td>
                                                    </tr>


                                                </table>
                               <br/> <input type="submit" value=
                               <fmt:message key="registration.button"/>> <input type="hidden"
                               name="command" value="addUser"/>
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


<c:set var="commandForPage" value="indexGuest" scope="request"/>


<center>
    <div id="niz">
        <span class="cop"></span>
    </div>
</center>


</body>
</html>