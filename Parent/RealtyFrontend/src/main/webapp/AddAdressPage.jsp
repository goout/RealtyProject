<%@ page import="java.util.List" %>
<%@ page import="org.realty.entity.City" %>
<%@ page import="org.realty.entity.District" %>
<%@ page import="org.realty.entity.Street" %>
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
            <td><select id="city" name="city" onchange="onChangeCity(city.selectedIndex)">
            </select></td>
        </tr>


        <tr>
            <td><fmt:message key="adress.label.district"/>:
            <td><select name="district" id="district" onchange="onChangeDistrict()"
                        style="width:130px">
            </select></td>
        </tr>

        <tr>
            <td>Street:
            <td><select name="street" id="street" style="width:130px">
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


    <script>

        var cityArrayFromRequest = new Array();
        var cityWithDistricts = new Array();
        <%
List<City> cityList = (List) request.getAttribute("cityList");
for (int i = 0; i < cityList.size(); i++) { %>
        cityWithDistricts[<%= i %>] = new Array();
        cityWithDistricts[<%= i %>][0] = "<%=cityList.get(i).getCityName()%>";
        var districtWithStreets = new Array();
        <%
List<District> districts = cityList.get(i).getDistricts();
for (int j = 0; j < districts.size(); j++) { %>
        districtWithStreets[<%= j %>] = new Array();
        districtWithStreets[<%= j %>][0] = "<%=districts.get(j).getDistrictName()%>";
        var streets = new Array();
        <%
List<Street> streets = districts.get(j).getStreets();
for (int m = 0; m < streets.size(); m++) {%>
        streets[<%=m%>] = "<%=streets.get(m).getStreetName()%>";

        <% }  %>
        districtWithStreets[<%= j %>][1] = streets;
        cityWithDistricts[<%= i %>][1] = districtWithStreets;
        <%}%>
        cityArrayFromRequest[<%= i %>] = cityWithDistricts;
        <%}%>

    </script>



    <script>

        var cityArrayFromRequestid = new Array();
        var cityWithDistrictsid = new Array();
        <%
List<City> cityListid = (List) request.getAttribute("cityList");
for (int i = 0; i < cityListid.size(); i++) { %>
        cityWithDistrictsid[<%= i %>] = new Array();
        cityWithDistrictsid[<%= i %>][0] = "<%=cityListid.get(i).getCityId()%>";
        var districtWithStreetsid = new Array();
        <%
List<District> districtsid = cityListid.get(i).getDistricts();
for (int j = 0; j < districtsid.size(); j++) { %>
        districtWithStreetsid[<%= j %>] = new Array();
        districtWithStreetsid[<%= j %>][0] = "<%=districtsid.get(j).getDistrictId()%>";
        var streetsid = new Array();
        <%
List<Street> streetsid = districtsid.get(j).getStreets();
for (int m = 0; m < streetsid.size(); m++) {%>
        streetsid[<%=m%>] = "<%=streetsid.get(m).getStreetId()%>";

        <% }  %>
        districtWithStreetsid[<%= j %>][1] = streetsid;
        cityWithDistrictsid[<%= i %>][1] = districtWithStreetsid;
        <%}%>
        cityArrayFromRequestid[<%= i %>] = cityWithDistrictsid;
        <%}%>

    </script>



    <script>


        var indexCity;
        var indexDistrict;

        for (var i = 0; i < cityArrayFromRequest.length; i++) {

            document.getElementById("city").options[i] = new Option(cityArrayFromRequest[0][i][0], cityArrayFromRequestid[0][i][0]);

        }

            var districts = cityArrayFromRequest[0][0][1];
            var districtsid = cityArrayFromRequestid[0][0][1];

            for (var idDistr = 0; idDistr < districts.length; idDistr++) {
                document.getElementById("district").options[idDistr] = new Option(districts[idDistr][0], districtsid[idDistr][0]);
            }


            var streets = cityArrayFromRequest[0][0][1][0][1];
            var streetsid = cityArrayFromRequestid[0][0][1][0][1];
            for (var m = 0; m < streets.length; m++) {
                document.getElementById("street").options[m] = new Option(streets[m], streetsid[m]);
            }



        function onChangeCity(indexCity) {
            var comboStreets = document.getElementById("street");
            var comboDistricts = document.getElementById("district");
            comboDistricts.options.length = 0;
            comboStreets.options.length = 0;

            var districts = cityArrayFromRequest[0][indexCity][1];
            var districtsid = cityArrayFromRequestid[0][indexCity][1];
            for (var k = 0; k < districts.length; k++) {
                comboDistricts.options[k] = new Option(districts[k][0], districtsid[k][0]);
            }

            var streets = districts[0][1];
            var streetsid = districtsid[0][1];
            for (var m = 0; m < streets.length; m++) {
                comboStreets.options[m] = new Option(streets[m], streetsid[m]);
            }
        }

        function onChangeDistrict() {
            var comboCity = document.getElementById("city");
            indexCity = comboCity.selectedIndex;
            var comboDistricts = document.getElementById("district");
            indexDistrict = comboDistricts.selectedIndex;
            var combo = document.getElementById("street");
            combo.options.length = 0;
            var streets = cityArrayFromRequest[0][indexCity][1][indexDistrict][1];
            var streetsid = cityArrayFromRequestid[0][indexCity][1][indexDistrict][1];
            for (var m = 0; m < streets.length; m++) {
                combo.options[m] = new Option(streets[m], streetsid[m]);
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