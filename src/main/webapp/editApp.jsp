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

            <form action='InputServlet' method="post">
                Name app<br>
                <input type='text' size='40' name="nameApp" value="<%= request.getAttribute("nameAppDb") %>"><br>
                Category<br>
                <input type='text' size='40' name="category" value="<%= request.getAttribute("categoryDb") %>"><br>
                40<br>
                <input type='text' size='40' name="size" value="<%= request.getAttribute("sizeDb") %>"><br>
                Google Play<br>
                <input type='text' size='40' name="market" value=" <%= request.getAttribute("marketDb") %>"><br>
                Descriptions new app<br>
                <input type='text' size='40' name="descriptions" value="<%= request.getAttribute("descriptionsDb") %>"><br>
                <input type='submit' value="Output data">
            </form>

            <%-- <br>
             <%= request.getAttribute("id") %>
             <br>
             <%= request.getAttribute("name") %>
             <br>
             <%= request.getAttribute("phone") %>--%>
            <br><%--<a href=""--%>
            <%= request.getAttribute("nameAppDb") %>
            <br>
            <%= request.getAttribute("categoryDb") %>
            <br>
            <%= request.getAttribute("sizeDb") %>
            <br>
            <%= request.getAttribute("marketDb") %>
            <br>
            <%= request.getAttribute("descriptionsDb") %>
        </td>
    </tr>
</table>
</body>
</html>

