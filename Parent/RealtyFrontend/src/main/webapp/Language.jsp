<head>


</head>
<body>

<form>
    <select id="language" action="RealtyServlet"
            name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        <option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
    </select>

    <input type="hidden" name="command" value="${commandForPage}"/>



  </form>
</body>
</html>