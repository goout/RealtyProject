<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="org.realty.Translations"/>

<c:set var="cmnt" value="${cmnT}"/>

<html lang="${language}">

<link href="style.css" rel="stylesheet" type="text/css">

<head>

    <title><fmt:message key="comm.title"/></title>

</head>

<c:set var="commandForPage" value="commentPage" scope="request"/>
<jsp:include page="Language.jsp" flush="true"/>


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
                <li><input type="button" value="Log out" onclick="location.href='RealtyServlet?command=LogOut'"/></li>
                <li>
                    <div id="head">

                        <h2><fmt:message key="comm.subhead"/></h2>
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

                            <h2><fmt:message key="auth.subhead"/></h2>
                        </div>


                        <div id="content">


                            <table width="600" border="0" align="center">
                                <tr>
                                    <td>

                                        <fieldset>
                                            <legend>
                                                <b><fmt:message key="comm.label.add"/></b>
                                            </legend>
                                            <form id="form1" action="RealtyServlet">
                                                <table>
                                                    <tr>
                                                        <td><fmt:message key="comm.label.txt"/>:
                                                        <td>
                                                        <td><textarea rows="5" cols="20"  name="text" id="1"></textarea></td>
                                                    </tr>


                                                    <tr>
                                                        <td><select name="userId" id="userId" style="visibility:hidden;">

                                                            <option value="<c:out value="${cmnt.userId}"/>"><c:out value="${cmnt.userId}"/></option>

                                                        </select></td>
                                                    </tr>

                                                    <tr>

                                                        <td><select name="advertId" id="advertId" style="visibility:hidden;">


                                                            <option value="<c:out value="${cmnt.advertId}"/>"><c:out value="${cmnt.advertId}"/></option>

                                                        </select></td>


                                                    </tr>


                                                </table>
                                                <br/> <input type="submit" value=
                                            <fmt:message key="button.add"/>> <input type="hidden"
                                                                                    name="command" value="addComment"/>
                                            </form>
                                        </fieldset>


                                    </td>
                            </table>

                            <br>


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