<%@ page import="bardzimashvili.db.Conn" %>
<%@ page import="java.sql.ResultSet" %>
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
                <input type='text' size='40' name="nameApp" value="Name app"><br><br>
                Category<br>
                <select>

                    <%
                        Conn conn = new Conn();
                        String app = "category";
                        ResultSet resSet;

                        resSet = conn.readTable(app);

                        while (resSet.next())
                        {
                            int id = resSet.getInt("id");
                            String name = resSet.getString("name");
                            //String category = resSet.getString("category");
                    %>


                    <option name="category" value="<%= id %>"><%= name %></option>

                    <%--<input type='text' size='40' name="category" value="category">--%>

                    <% } %>
                </select>


                <br><br>
                40<br>
                <input type='text' size='5' name="size" value="40">Mb<br><br>
                <input type='hidden' name="testId" value="45">

                Descriptions new app<br>
                <input type='text' size='40' name="descriptions" value="descriptions"><br>
                <input type='submit' value="Output data">
            </form>
        </td>
    </tr>
</table>
</body>
</html>
