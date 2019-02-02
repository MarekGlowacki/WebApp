<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 30.01.19
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Web App Page</title>
  </head>
  <body>

  <H1>Hello World </H1>
  <p>Body text. This is not my first JSP page.</p>
  <p>Ciułała!</p>

  <%
    Date date = new Date();
    out.println("<h2>" + date.toString() + "</h2>");
  %>

  </body>
</html>
