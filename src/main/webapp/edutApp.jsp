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


