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

<%--<script>

    var cityArrayFromRequest = new Array();
    <%
List<City> cityList = (List) request.getAttribute("cityList");
for (int i = 0; i < cityList.size(); i++) { %>
    var i = <%=i%>;
    cityWithDistricts[i][0] =  <%=cityList.get(i).getCityName()%>;
    var districtWithStreets = new Array();
    <%
List<District> districts = cityList.get(i).getDistricts();
for (int j = 0; j < districts.size(); j++) { %>
    var j = <%=j%>;
    districtWithStreets[j][0] =  <%=districts.get(j).getDistrictName()%>;
    var streets = new Array();
    <%
List<Street> streets = districts.get(j).getStreets();
for (int m = 0; m < streets.size(); m++) {%>
    streets[<%=m%>] = <%=streets.get(m).getStreetName()%>;

    <% }  %>
    districtWithStreets[j][1] = streets;
    cityWithDistricts[i][1] = districtWithStreets;
    <%}%>
    cityArrayFromRequest[i] = cityWithDistricts;
    <%}%>
</script>--%>


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
                                    <%--            <td><select name="city" id="1" onchange="chanGe(combo.city.selectedIndex)"
                                                            style="width:110px">
                                                    <option value="select">Change City...</option>
                                                    <c:forEach items="${cityList}" var="city">
                                                        <option value="<c:out value="${city.cityId}"/>"><c:out
                                                                value="${city.cityName}"/></option>
                                                    </c:forEach>
                                                </select></td>--%>
                                                <td><select id="city" name="city" onchange="onChangeCity(city.selectedIndex)">

                                                    </select> </td>

                                            </tr>


                                            <tr>
                                                <td><fmt:message key="adress.label.district"/>:
                                                <td><select name="district" id="district" onchange="onChangeDistrict()" style="width:130px">


                                                </select></td>
                                            </tr>

                                            <tr>

                                                <td>Street:
                                                <td><select name="street" id="street" style="width:130px">


                                                </select></td>


                                            </tr>


                                        </table>
                                        <br/> <input type="submit" value=
                                    <fmt:message key="button.add"/>> <input type="hidden"
                                                                            name="command" value="addAdress"/>


                                        <script>


                                /*            var cityArrayFromRequest = new Array();
                                            var cityWithDistricts = new Array();
                                            <%
                                  List<City> cityList = (List) request.getAttribute("cityList");
                                  for (int i = 0; i < cityList.size(); i++) { %>
                                            var i = <%=i%>;
                                            cityWithDistricts[i][0] =  <%=cityList.get(i).getCityName()%>;
                                            var districtWithStreets = new Array();
                                            <%
                                  List<District> districts = cityList.get(i).getDistricts();
                                  for (int j = 0; j < districts.size(); j++) { %>
                                            var j = <%=j%>;
                                            districtWithStreets[j][0] =  <%=districts.get(j).getDistrictName()%>;
                                            var streets = new Array();
                                            <%
                                   List<Street> streets = districts.get(j).getStreets();
                                   for (int m = 0; m < streets.size(); m++) {%>
                                            streets[<%=m%>] = <%=streets.get(m).getStreetName()%>;

                                            <% }  %>
                                            districtWithStreets[j][1] = streets;
                                            cityWithDistricts[i][1] = districtWithStreets;
                                            <%}%>
                                            cityArrayFromRequest[i] = cityWithDistricts;
                                            <%}%>*/



                                            var indexCity;
                                            var indexDistrict;
                                            var cityArrayFromRequest = ['Minsk', 'Gomel','Grodno'];
                                            var complexArray = new Array();
                                            for (var i = 0; i < cityArrayFromRequest.length; i++) {
                                                 alert(cityArrayFromRequest[i]);
                                                var districtsFromCityArray = [

                                                    [cityArrayFromRequest[i] + 'distr1', [cityArrayFromRequest[i] + 'distr1' + 'Str1', cityArrayFromRequest[i] + 'distr1'+'Str2']],
                                                        [cityArrayFromRequest[i] + 'distr2', [cityArrayFromRequest[i] + 'distr2' + 'str']],
                                                        [cityArrayFromRequest[i] + 'distr3', [cityArrayFromRequest[i] + 'distr3' + 'str']]
                                            ];
                                                complexArray[i] = [cityArrayFromRequest[i], districtsFromCityArray];


                                                document.getElementById("city").options[i] = new Option(complexArray[i][0], complexArray[i][0]);
                                                var districts = complexArray[0][1];
                                                for (var idDistr = 0; idDistr < districts.length; idDistr++) {
                                                    document.getElementById("district").options[idDistr] = new Option(districts[idDistr][0], districts[idDistr][0]);
                                                }
                                                var streets = complexArray[0][1][0][1];
                                                for (var m = 0; m < streets.length; m++) {
                                                    document.getElementById("street").options[m] = new Option(streets[m], streets[m]);
                                                }
                                            }

                                            function onChangeCity(indexCity) {
                                                var comboStreets = document.getElementById("street");
                                                var comboDistricts = document.getElementById("district");
                                                comboDistricts.options.length=0;
                                                comboStreets.options.length=0;
                                                var districts = complexArray[indexCity][1];
                                                for (var k = 0; k < districts.length; k++) {
                                                    comboDistricts.options[k] = new Option(districts[k][0], districts[k][0]);
                                                }
                                                var streets = districts[0][1];
                                                for (var m = 0; m < streets.length; m++) {
                                                    comboStreets.options[m] = new Option(streets[m], streets[m]);
                                                }
                                            }

                                            function onChangeDistrict(indexCity) {
                                                var comboCity = document.getElementById("city");
                                                indexCity = comboCity.selectedIndex;
                                                var comboDistricts = document.getElementById("district");
                                                indexDistrict = comboDistricts.selectedIndex;
                                                var combo = document.getElementById("street");
                                                combo.options.length=0;
                                                var streets = complexArray[indexCity][1][indexDistrict][1];
                                                for (var m = 0; m < streets.length; m++) {
                                                    combo.options[m] = new Option(streets[m], streets[m]);
                                                }
                                            }
                                        </script>

                        <%--                <script>

                                            var index;
                                            var districtArray;
                                            function onChangeCity(index) {
                                                var combo = document.getElementById("combo");
                                            <%
                                              List<City> cityList = (List) request.getAttribute("cityList");
                                               for (int i=0; i<cityList.size(); i++) {%>
                                                if (index == '<%=i%>') {
                                                <%
                                                 List<District> districts = cityList.get(i).getDistricts();
                                                 for (int j=0; j<districts.size(); j++) { %>
                                                    /*districtListArray[<%= j %>] = "<%= districts.get(i).getDistrictName() %>";*/
                                                    combo.district.options[<%= j %>]
                                                            = new Option("<%= districts.get(j).getDistrictName() %>","<%= districts.get(j).getDistrictName() %>");
                                                <% } break; %>
                                                }
                                           <% } %>
                                            }

                                        </script>--%>






                          <%--              <script>

                                            var i;

                                            function chanGe(i) {
                                                var combo = document.getElementById("combo");
                                                combo.district.options.length=0;
                                                var districtList = '<c:out value="${cityList[i].districts}"/>';

                                                for (var i=0; i < districtList.length ;++i){

                                                    combo.district.options[i] = new Option(districtList[i],districtList[i]);
                                                }


                                            }

                                        </script>--%>


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