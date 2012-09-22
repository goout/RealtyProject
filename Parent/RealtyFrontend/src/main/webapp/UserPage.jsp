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

    <title><fmt:message key="str"/></title>

</head>

<c:set var="commandForPage" value="userPage" scope="request"/>


<body>

<%--<br>--%>
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

                <li><fmt:message key="button.logout" var="Out"/>
                    <input type="button" value="${Out}" onclick="location.href='RealtyServlet?command=LogOut'"/></li>
                <li>
                    <form id="form5" action="RealtyServlet">
                        <fmt:message key="button.add" var="Add"/>
                        <input type="button" value="${Add}" onclick="location.href='RealtyServlet?command=adress'"/>
                    </form>
                </li>
                <li>
                    <div id="head">

                        <h2><fmt:message key="user.subhead"/></h2>
                    </div>
                </li>
                <li>
                    <c:set var="adm" value="${admin}"/>
                    <c:choose>
                        <c:when test="${adm == true}">
                            <fmt:message key="admin" var="admin"/>
                            <input type="button" value="${admin}"
                                   onclick="location.href='RealtyServlet?command=allUser'"/>
                        </c:when>
                        <c:otherwise>
                            <fmt:message key="admin" var="admin"/>
                            <input type="button" value="${admin}" style="display:none;"
                                   onclick="location.href='RealtyServlet?command=allUser'"/>
                        </c:otherwise>
                    </c:choose>


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

                            <h2><fmt:message key="user.subhead"/></h2>
                        </div>



         <%--               <script>


                            <%
                  String sort = (String)request.getAttribute("sort");
                  String category = (String)request.getAttribute("category");

                  if(sort!=null){ %>

                   document.frmRadio.choice[1].checked

                 <%}

                            %>

                        </script>--%>




                        <script type="text/javascript">




                            function selectRadio() {

                            <% String str= (String)request.getAttribute("category");%>
                                var category ="<%=str%>";


                               /* alert(category);*/

                                for (index=0; index < document.frmRadio.choice.length; index++) {
                                    if (document.frmRadio.choice[index].checked) {
                                        var radioValue = document.frmRadio.choice[index].value;
                                        break;
                                    }
                                }

                                /* alert(radioValue);*/

                                if (radioValue==2){

                                    switch (category) {
                                        case "All":
                                            location.href = 'RealtyServlet?command=allUser'

                                            break
                                        case "Purchase":
                                            location.href = 'RealtyServlet?categoryf=Purchase&command=allUser'

                                            break
                                        case "Sale":
                                            location.href = 'RealtyServlet?categoryf=Sale&command=allUser'

                                            break
                                        case "Rent":
                                            location.href = 'RealtyServlet?categoryf=Rent&command=allUser'

                                            break
                                        default:
                                            location.href = 'RealtyServlet?command=allUser'
                                            break
                                    }
                                }

                                if(radioValue==1){
                                    switch (category) {
                                        case "All":
                                            location.href = 'RealtyServlet?sort=inc&command=allUser'

                                            break
                                        case "Purchase":
                                            location.href = 'RealtyServlet?sort=inc&categoryf=Purchase&command=allUser'

                                            break
                                        case "Sale":
                                            location.href = 'RealtyServlet?sort=inc&categoryf=Sale&command=allUser'

                                            break
                                        case "Rent":
                                            location.href = 'RealtyServlet?sort=inc&categoryf=Rent&command=allUser'

                                            break
                                        default:
                                            location.href = 'RealtyServlet?sort=inc&command=allUser'
                                            break
                                    }






                                }


                            }







                            function selectDropdown() {

                                var value = document.getElementById("categoryf").value;



                                for (index=0; index < document.frmRadio.choice.length; index++) {
                                    if (document.frmRadio.choice[index].checked) {
                                        var radioValue = document.frmRadio.choice[index].value;
                                        break;
                                    }
                                }

                               /* alert(radioValue);*/

                                if (radioValue==2){

                                switch (value) {
                                    case "All":
                                        location.href = 'RealtyServlet?command=allUser'

                                        break
                                    case "Purchase":
                                        location.href = 'RealtyServlet?categoryf=Purchase&command=allUser'

                                        break
                                    case "Sale":
                                        location.href = 'RealtyServlet?categoryf=Sale&command=allUser'

                                        break
                                    case "Rent":
                                        location.href = 'RealtyServlet?categoryf=Rent&command=allUser'

                                        break
                                    default:
                                        location.href = 'RealtyServlet?command=allUser'
                                        break
                                }
                                }

                                if(radioValue==1){
                                    switch (value) {
                                        case "All":
                                            location.href = 'RealtyServlet?sort=inc&command=allUser'

                                            break
                                        case "Purchase":
                                            location.href = 'RealtyServlet?sort=inc&categoryf=Purchase&command=allUser'

                                            break
                                        case "Sale":
                                            location.href = 'RealtyServlet?sort=inc&categoryf=Sale&command=allUser'

                                            break
                                        case "Rent":
                                            location.href = 'RealtyServlet?sort=inc&categoryf=Rent&command=allUser'

                                            break
                                        default:
                                            location.href = 'RealtyServlet?sort=inc&command=allUser'
                                            break
                                    }






                                }


                            }


                        </script>

                          <table  align="center">
                            <tr>
                            <td><fmt:message key="category"/>:
                                <select name="categoryf" id="categoryf" style="width:130px" onchange="selectDropdown()">
                               <%-- <option &lt;%&ndash;disabled&ndash;%&gt; value="All">Change category...</option>--%>
                                <option value="All"  <c:if test="${category == 'All'}">selected</c:if>   >All</option>
                                <option value="Purchase"  <c:if test="${category == 'Purchase'}">selected</c:if> >Purchase</option>
                                <option value="Sale" <c:if test="${category == 'Sale'}">selected</c:if> >Sale</option>
                                <option value="Rent" <c:if test="${category == 'Rent'}">selected</c:if>>Rent</option>
                            </select> </td>


                                <td>    <form name="frmRadio" method="post">
                                    <input name="choice" value="1" type="radio" onchange="selectRadio()" <c:if test="${sort == 'inc'}">CHECKED</c:if> /><fmt:message key="increase"/>
                                    <input name="choice" value="2" type="radio" onchange="selectRadio()" <c:if test="${sort == null}">CHECKED</c:if> /><fmt:message key="decrease"/>

                                </form>      </td>


                         <%--   <td><fmt:message key="increase" var="inc"/>
                                <input name="gr1" type="radio" value="${inc}"/><fmt:message key="increase"/></td>

                            <td><fmt:message key="decrease" var="dec"/>
                                <input name="gr1" type="radio" value="${dec}" checked=""/><fmt:message key="decrease"/></td>--%>

                            </tr>
                          </table>

                        <div id="content">


                            <div id="table" style="width:1000px; height:600px; overflow:auto;">
                                <br/>

                                <form id="form3" action="RealtyServlet">

                                    <c:forEach items="${allAdvertsUsrDto}" var="adv">


                                        <table cellpadding=2 border="1" cellspacing=0 width=700 align="center">
                                            <col width="140">
                                            <col width="140">
                                            <col width="140">
                                            <col width="210">
                                            <col width="70">
                                            <tr>


                                                <td><c:out value="${adv.addedDate}"/></td>
                                                <td><c:out value="${adv.userName}"/></td>
                                                <td><c:out value="${adv.category}"/></td>
                                                <td></td>
                                                <td><c:out value="${adv.coast}"/>$</td>
                                            </tr>
                                            <tr>
                                                <td colspan="4"><c:out value="${adv.description}"/></td>
                                                <td><a
                                                        href="<c:url value='RealtyServlet?advertId=${adv.advertId}&command=advertPage' />">Details</a>
                                                </td>
                                                </td>
                                            </tr>
                                        </table>
                                        <br/>
                                    </c:forEach>

                                </form>

                                <br/> <br/> <br/>


                            </div>

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