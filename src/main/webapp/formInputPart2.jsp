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
                Name app: <br><%= request.getAttribute("nameApp") %>
                <%--<input type='text' size='40' name="nameApp" value="Name app">--%><br>
                Category<br>
                <input type='text' size='40' name="category" value="category"><br>
                40<br>
                <input type='text' size='40' name="size" value="size"><br>
                Google Play<br>
                <input type='text' size='40' name="market" value="market"><br>
                Descriptions new app<br>
                <input type='text' size='40' name="descriptions" value="descriptions"><br>
                <input type='submit' value="Output data">
            </form>
        </td>
    </tr>
</table>
</body>
</html>
