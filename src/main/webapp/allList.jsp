<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%= request.setAttribute() %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="80%" align="center">
    <tr>
        <jsp:include page="menu.jsp"/>

        <td>
            Current time
            <br>
            <%= request.getAttribute("id") %>
            <br>
            <%= request.getAttribute("name") %>
            <br>
            <%= request.getAttribute("phone") %>
            <br>
            <%= request.getAttribute("nameApp") %>
        </td>
    </tr>
</table>
</body>
</html>


