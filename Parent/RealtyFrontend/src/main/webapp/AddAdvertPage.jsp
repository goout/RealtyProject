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

    <title><fmt:message key="addadvert"/></title>

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
                <li><fmt:message key="main" var="main"/>
                    <input type="button" value="${main}" onclick="location.href='RealtyServlet?command=indexGuest'"/></li>
                <li><fmt:message key="button.logout" var="Out"/>
                    <input type="button" value="${Out}" onclick="location.href='RealtyServlet?command=LogOut'"/></li>
                <li>
                    <div id="head">

                        <h2><fmt:message key="addadvert"/></h2>
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


                        <h2><fmt:message key="addadvert"/></h2>

                        <div id="table" style="width:1000px; height:600px; overflow:auto;">
                        <table border="0" align="center">
                            <tr>
                                <td>

                                    <fieldset>
                                        <legend>
                                            <b><fmt:message key="advert.label.add"/></b>
                                        </legend>
                                        <form id="form1" action="RealtyServlet" onsubmit="return validateForm()">
                                            <table border="0">
                                                <tr>
                                                    <td><fmt:message key="advert.label.category"/>:
                                                    <td><select name="category" id="category" style="width:130px">
                                                    <option value="Purchase">Purchase</option>
                                                    <option value="Sale">Sale</option>
                                                    <option value="Rent">Rent</option>
                                                </select>
                                                </td>
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




                                            <script>


                                                function validateForm()

                                                {   var max=2;
                                                    var max2=8;
                                                    var min=1;
                                                    var numericExpression = /^[0-9]+$/;
                                                    var x=document.forms["form1"]["rooms"].value;
                                                    var y=document.forms["form1"]["coast"].value;
                                                    if (x.match(numericExpression)&&min<=x.length&&x.length<=max)
                                                    {
                                                        if (y.match(numericExpression)&&min<=y.length&&y.length<=max2)
                                                        {
                                                            return true;
                                                        }   else {
                                                            alert("Coast must be not null and numeric (1..99999999)");
                                                            return false;
                                                        }
                                                    }   else {
                                                        alert("Rooms must be not null and numeric (1..99)");
                                                        return false;
                                                    }

                                                }


                                            </script>



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