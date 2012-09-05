<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="org.realty.Translations"/>

<c:set var="list2" value="${list2}"/>
<c:set var="list3" value="${list3}"/>

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
                                            <form id="form1" name="combo" action="RealtyServlet">
                                                <table>
                                                    <tr>
                                                        <td><fmt:message key="adress.label.city"/>:
                                                        <td><select name="city" id="1" onchange="chanGe()"
                                                                    style="width:110px">
                                                            <option value="select">Change City...</option>
                                                            <c:forEach items="${cityList}" var="city">
                                                                <option value="<c:out value="${city.cityId}"/>"><c:out
                                                                        value="${city.cityName}"/></option>
                                                            </c:forEach>
                                                        </select></td>
                                                    </tr>


                                                    <tr>
                                                        <td><fmt:message key="adress.label.district"/>:
                                                        <td><select name="district" id="2" style="width:130px">
                                                            <option value="select">Change District...</option>

                                                        </select></td>
                                                    </tr>

                                                    <tr>

                                                        <td>Street:
                                                        <td><select name="street" id="3" style="width:130px">
                                                            <option value="select">Change Street...</option>

                                                            <option value=1>2</option>

                                                        </select></td>


                                                    </tr>


                                                </table>
                                                <br/> <input type="submit" value=
                                            <fmt:message key="button.add"/>> <input type="hidden"
                                                                                    name="command" value="addAdress"/>

                                                <script>

                                                    var group = new Array()
                                                    group[0] = new Option("Second List", "0")


                                                    var temp = document.combo.district

                                                    function chanGe() {

                                                        var sel = document.combo.city;
                                                        var opt = sel.options[sel.selectedIndex].value;
                                                        var txt = sel.options[sel.selectedIndex].text;

                                                        group[group.length] = new Option(txt, opt);

                                                        for (m = temp.options.length - 1; m > 0; m--)
                                                            temp.options[m] = null
                                                        for (i = 0; i < group.length; i++) {
                                                            temp.options[i] = new Option(group[i].text, group[i].value)
                                                        }
                                                        temp.options[0].selected = true
                                                    }

                                                </script>


                                            </form>


                                        </fieldset>


                                    </td>
                            </table>


                            <table width="350" border="0" align="center">
                                <tr>
                                    <td>

                                        <fieldset>
                                            <legend>
                                                <b>TEST</b>
                                            </legend>
                                            <form id="combo2" name="combo2" action="RealtyServlet">
                                                <table>
                                                    <tr>
                                                        <td>LIST1:

                                                        <td><select name="list1" onchange="chanGe2(combo2.list1.selectedIndex)"
                                                                    style="width:110px">
                                                            <c:set value="0" var="i"/>
                                                            <c:forEach items="${list1}" var="testArray">
                                                                <option value="<c:out value="${list1[i]}"/>"><c:out
                                                                        value="${list1[i]}"/></option>
                                                                <c:set value="${i+1}" var="i"/>
                                                            </c:forEach>


                                                        </select></td>
                                                    </tr>


                                                    <tr>
                                                        <td>LIST2 OR LIST3:
                                                        <td><select name="list2" style="width:130px">


                                                        </select></td>
                                                    </tr>


                                                </table>
                                                <br/>

                                                <script>

                                                    var i;
                                                    function chanGe2(i) {

                                                        var list2 = '<c:out value="${list2}"/>';
                                                        var list3 = '<c:out value="${list3}"/>';
                                                        var combo2 = document.getElementById("combo2");
                                                        combo2.list2.options.length=0;
                                                        switch(i)
                                                        {
                                                            case 0:

                                                                for (var i=0; i < list2.length ;++i){


                                                                    combo2.list2.options[i] = new Option(list2[i],list2[i]);
                                                                }



                                                                break;
                                                            case 1:
                                                                for (var i=0; i < list3.length ;++i){


                                                                    combo2.list2.options[i] = new Option(list3[i],list3[i]);
                                                                }


                                                        }



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