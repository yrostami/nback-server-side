<%@ page import="yrostami.service.DataBase" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Boolean authenticated = (Boolean) session.getAttribute("Authenticated");

    if (authenticated == null || authenticated.equals(Boolean.FALSE))
        response.sendRedirect("/");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>آزمون حافظه</title>

    <link href="resources/css/loginPage.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="mainPane">
        <h3 >
            خوش آمدید
        </h3>

        <label class="label">
            نتایج ثبت شده تا به الان:
            <% out.print(DataBase.getResultsCount()); %>
        </label>

        <label class="label">
            برای دریافت فایل روی دکمه زیر کلیک کنید.
        </label>

        <div class="buttonContainer">
            <a target="_blank" href="/resultsfile"><button class="button">دریافت فایل نتایج</button></a>
        </div>

        <div class="buttonContainer mini" >
            <a target="_self" href="/logout"><button class="button">خروج</button></a>
        </div>

    </div>
</body>
</html>
