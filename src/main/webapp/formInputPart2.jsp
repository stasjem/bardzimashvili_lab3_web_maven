<%@ page import="bardzimashvili.db.Conn" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.io.PrintWriter" %>
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
            <form action="InputServlet" method="post">
                <input type="hidden" name="nameApp" value="<%= request.getAttribute("nameApp") %>">

                Name app: <%= request.getAttribute("nameApp") %><br>
                Category: <%= request.getAttribute("category") %>
                <%--<input type='text' size='40' name="category" value="category">--%><br>
                Size: <%= request.getAttribute("size") %>
                <%--<input type='text' size='40' name="size" value="size">--%><br>
                <%--<input type='text' size='40' name="market" value="market">--%>
                Descriptions new app: <%= request.getAttribute("size") %><br>

                SubcategoryId:
                <select name="subcategoryId">
                    <%
                        Conn conn = new Conn();
                        String app = "subcategory";
                        String categoryId = (String)request.getAttribute("categoryId");
                        ResultSet resSet;

                        resSet = conn.readTableWhere(app, categoryId);


                        /*PrintWriter printWriter = response.getWriter();
                        printWriter.print(resSet);*/


                        while (resSet.next())
                        {
                            int id = resSet.getInt("id");
                            String name = resSet.getString("name");
                    %>


                    <option value="<%= id %>"><%= name %></option>
                    <% } %>
                </select><br>

                Descriptions<br>
                <%= request.getAttribute("descriptions") %>
                <%--<input type='text' size='40' name="descriptions" value="descriptions">--%><br>
                <input type='submit' value="Output data">
            </form>
        </td>
    </tr>
</table>
</body>
</html>
