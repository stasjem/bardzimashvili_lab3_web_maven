<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <%= request.getAttribute("title") %>
            <br>
            <%= request.getAttribute("name") %>
            <br>
            <%= request.getAttribute("nameApp") %>
        </td>
    </tr>
</table>
</body>
</html>


