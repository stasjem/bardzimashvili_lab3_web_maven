<%@ page import="bardzimashvili.db.Conn" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--<%= request.setAttribute() %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="80%" align="center" valign="top">
    <tr>
        <jsp:include page="menu.jsp"/>

        <td valign="top">
            Current time<br><br>


            <%-- <br>
             <%= request.getAttribute("id") %>
             <br>
             <%= request.getAttribute("name") %>
             <br>
             <%= request.getAttribute("phone") %>--%>

            <table border="1" align="left" valign="top">

                <%
                    Conn conn = new Conn();
                    String app = "app";
                    ResultSet resSet;

                    resSet = conn.readTable(app);

                    while (resSet.next())
                    {
                        int id = resSet.getInt("id");
                        String name = resSet.getString("nameApp");
                        String category = resSet.getString("category");
                %>


                <tr>
                    <td>
                        <a href="EditServlet?id=<%= id %>"><%= name %>
                        </a>
                        <br>
                        <%= category %>
                        <br>
                        <br>
                        <%= request.getAttribute("testId") %>


                    </td>
                    <% } %>
                </tr>

            </table>

        </td>
    </tr>
</table>

<%--<sql:query dataSource="${snapshot}" var="result">
    SELECT * from Employees;
</sql:query>--%>
<%--<%!
    //public static ResultSet resSet;

%>--%>

</body>
</html>


