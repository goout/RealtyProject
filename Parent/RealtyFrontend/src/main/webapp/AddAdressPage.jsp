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

    <title><fmt:message key="adress.title"/></title>

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
                                            <form id="form1" name="doublecombo" action="RealtyServlet">
                                                <table>
                                                        <tr>
                                                        <td><fmt:message key="adress.label.city"/>:
                                                        <td><select name="city" id="1" style="width:110px" onchange="ChanGeValue()">
                                                        <%--<option value="select">Change City...</option>--%>
                                                    <%--     <c:forEach items="${cityList}" var="city">
                                                        <option value="<c:out value="${city.cityId}"/>"><c:out value="${city.cityName}"/></option>
                                                        </c:forEach>--%>
                                                            <option value="12">25</option>
                                                            <option value="14">24</option>
                                                            <option value="2">45</option>
                                                        </select></td>
                                                    </tr>


                                                    <tr>
                                                        <td><fmt:message key="adress.label.district"/>:
                                                        <td><select name="district" id="2"  style="width:130px">  <!--onchange="ChanGeValue()"-->
                                                           <%-- <option value="select">Change District...</option>--%>
                                                        <%--<c:forEach items="${cityList.districts}" var="cDistr">--%>
                                                            <option value="1">2</option>
                                                        <%--</c:forEach>--%>
                                                        </select></td>
                                                    </tr>

                                                    <tr>

                                                   <%--     <td><fmt:message key="adress.label.street"/>:
                                                        <td><select name="street" id="3" style="width:130px">
                                                            <option value="select">Change Street...</option>
                                                        <c:forEach items="${cityList.districts.streets}" var="cDS">
                                                            <option value="<c:out value="${cDS.streetId}"/>"><c:out value="${cDS.streetName}"/></option>
                                                        </c:forEach>
                                                        </select></td>--%>

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
                                                <script>

                                                    var temp=document.doublecombo.district
                                                    function ChanGeValue(){
                                                        var sel = document.doublecombo.city;
                                                        var opt = sel.options[sel.selectedIndex].value;
                                                        /*var txt = sel.options[sel.selectedIndex].text;*/
                                                        temp.options[sel.selectedIndex].selected=true
                                                    }
                                                </script>
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