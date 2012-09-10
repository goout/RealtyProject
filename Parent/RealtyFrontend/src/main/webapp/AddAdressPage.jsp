
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="org.realty.Translations"/>

<c:set var="adr" value="${adressDto}"/>


<html lang="${language}">

<link href="style.css" rel="stylesheet" type="text/css">

<head>

    <title><fmt:message key="adress.title"/></title>

</head>

<c:set var="commandForPage" value="adress" scope="request"/>

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

                        <h2><fmt:message key="adress.subhead"/></h2>
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

                            <h2><fmt:message key="adress.subhead"/></h2>
                        </div>


                        <div id="content">


                            <table width="350" border="0" align="center">
                                <tr>
                                    <td>

                                        <fieldset>
                                            <legend>
                                                <b><fmt:message key="adress.subhead"/></b>
                                            </legend>
                                            <form id="form1" action="RealtyServlet">
                                                <table>
                                                    <tr>
                                                        <td><fmt:message key="adress.label.city"/>:
                                                        <td><select name="city" id="1" style="width:110px">
                                                            <option value="select">Change City...</option>
                                                            <option value="1"><c:out value="${adr.cityName}"/></option>
                                                        </select></td>
                                                    </tr>


                                                    <tr>
                                                        <td><fmt:message key="adress.label.district"/>:
                                                        <td><select name="district" id="2"  style="width:130px">  <!--onchange="ChanGeValue()"-->
                                                            <option value="select">Change District...</option>
                                                            <option value="5"><c:out value="${adr.districtName}"/></option>
                                                        </select></td>
                                                    </tr>

                                                    <tr>

                                                        <td><fmt:message key="adress.label.street"/>:
                                                        <td><select name="street" id="3" style="width:130px">
                                                            <option value="select">Change Street...</option>
                                                            <c:forEach items="${adressDto.streets}" var="str">
                                                                <option value="<c:out value="${str.streetId}"/>"><c:out value="${str.streetName}"/></option>
                                                            </c:forEach>
                                                        </select></td>

                                                    </tr>


                                                    <tr>
                                                        <td><fmt:message key="adress.label.home" />:

                                                        <td><input type="text" size="10" name="homeNum" id="4"></td>

                                                    </tr>



                                                    <tr>
                                                        <td><fmt:message key="adress.label.apartment" />:

                                                        <td><input type="text" size="10" name="apartmentNum" id="5"></td>


                                                    </tr>



                                                </table>
                                                <br/> <input type="submit" value=
                                            <fmt:message key="button.add"/>> <input type="hidden"
                                                                                    name="command" value="addAdress"/>
                                            </form>


                                            <!--     <script>

                                                var temp=document.doublecombo.street
                                                function ChanGeValue(){
                                                    var sel = document.doublecombo.district;
                                                    var opt = sel.options[sel.selectedIndex].value;

                                                    temp.options[sel.selectedIndex].selected=true
                                                }
                                            </script>   -->

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