<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 30.01.19
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>Welcome, please login:</h1>

    <form action="/WebApp_war_exploded/login" method="post">
        login-name: <input type="text" name="loginname" width="30" />
        pasword: <input type="password" name="password" width="10"/>
        <input type="submit" value="Login"/>
    </form>

    <p style="color:red;"> ${errorMessage}</p>

</body>
</html>
