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
            <form action='InputServlet' method="post">
                Name app<br>
                <input type='text' size='40'><br>
                <input type='submit' value="Clic">
            </form>
        </td>
    </tr>
</table>
</body>
</html>
