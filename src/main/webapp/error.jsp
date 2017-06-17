<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Exception ex = (Exception) request.getAttribute("javax.servlet.error.exception");
    if(ex == null)
        response.sendRedirect("/");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>خطا</title>
    <link href="resources/css/loginPage.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="mainPane">
        <h3>خطا داخلی سرور:</h3>
        <br/>
        <label><% if(ex != null) out.print(ex.getClass().getName()); %></label>
        <br/>
        <label><% if(ex != null) out.print(ex.getMessage()); %></label>
    </div>
</body>
</html>