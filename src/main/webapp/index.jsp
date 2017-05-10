<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="bardzimashvili.db.DirAndFiles" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% new DirAndFiles(); %>
<html>
<head>
    <title>Title</title>
    <%--<link href="styles.css" rel="stylesheet" type="text/css">--%>
    <%--<style type="text/css"
    <source>
        style.css
    </style>--%>
</head>
<body>
<table border="1" width="80%" align="center">
    <tr>
        <jsp:include page="menu.jsp"/>

    <td>
        Current time
        <br>
        <% response.setIntHeader("Refresh", 1); %>
        <%= new SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(new Date()) %>
    </td>
    </tr>
</table>

<%--<%
    PrintWriter printWriter =response.getWriter();
    printWriter.print("hello");
%>--%>
</body>
</html>


