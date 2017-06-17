<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<%
  Boolean authenticated = (Boolean)session.getAttribute("Authenticated");
  if (authenticated != null && authenticated)
    response.sendRedirect("/login");
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>ورود</title>

  <link href="resources/css/loginPage.css" rel="stylesheet" type="text/css"/>
  <link href="resources/css/phoenixIcons.css" rel="stylesheet" type="text/css"/>

  <script type="text/javascript" src="resources/js/login.js"></script>
</head>
<body>
<div id="browserMsg"></div>
<div class="main login-form" >
  <div id="header">
    <div class="icon-container">
      <div>
        <i class="demo-icon icon-login"></i>
      </div>
    </div>
    <div id="header-title">
      ورود
    </div>
  </div>

  <div id="content">
    <form action="/login" method="post" onsubmit="return submit()">
    <div>
      <label class="label">
        &rsaquo; نام کاربری:
      </label>
      <input class="textinput" id="username" name="username" type="text" maxlength="50"
             placeholder="نام کاربری را وارد کنید."/>
      <label class="label">
        &rsaquo; گذرواژه:
      </label>
      <input class="textinput" id="password" name="password" type="password" maxlength="50"
             placeholder="گذرواژه را وارد کنید."/>
    </div>
    <br/>
    <div class="buttonContainer">
      <input type="submit" id="button" class="button" value="ورود"/>
    </div>
    <label class="label errorMessage" id="failMsg">
      <%
          if (request.getAttribute("msg") != null)
            out.println(request.getAttribute("msg"));
      %>
    </label>
    </form>
  </div>
  <br/>
  <div id="footer">
    تمامی حقوق این سایت محفوظ می باشد. &copy;
  </div>
</div>
</body>
</html>