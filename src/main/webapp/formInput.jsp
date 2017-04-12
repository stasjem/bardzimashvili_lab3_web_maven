
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
            <form action='inputPost.jsp'>
                <input type='text' size='40'><br>
                <input type='submit'>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
