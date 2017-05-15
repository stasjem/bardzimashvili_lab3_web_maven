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
            <table border="1" align="left" valign="top">

                <%
                    Conn conn = new Conn();
                    String nameApp = (String) request.getAttribute("nameApp");
                    ResultSet resSet;

                    //resSet = conn.readTable(app);
                    resSet = conn.searchTableWhere(nameApp);

                    while (resSet.next())
                    {
                        int id = resSet.getInt("id");
                        String name = resSet.getString("nameApp");
                        String descriptions = resSet.getString("descriptions");
                        String size = resSet.getString("size");
                        String category = resSet.getString("subcategory");
                        String category_id = resSet.getString("category_id");
                %>


                <tr>
                    <td>
                        <a href="EditServlet?id=<%= id %>"><%= name %>
                        </a>
                        <br>
                        Subcategory: <%= category %><br>
                        Category: <%= category %><br>
                        Size: <%= size %><br>
                        Descriptions: <%= descriptions %><br>


                            <%--Subcategory: <%= request.getAttribute("category") %><br>
                            Category: <%= request.getAttribute("category") %><br>
                            Size: <%= request.getAttribute("sizeDb") %><br>
                            Descriptions: <%= request.getAttribute("descriptionsDb") %><br>
--%>



                        <%--<%
                            Conn conn1 = new Conn();
                            String subcategory = "subcategory";
                            String subcategoryId = "subcategoryId";
                            ResultSet resSet1;

                            //resSet = conn.readTableWhere(subcategory, category, subcategoryId);
                            resSet1 = conn1.readTableCategoryWhere(category);

                            while (resSet1.next())
                            {
                                /*int id1 = resSet.getInt("id");*/
                                /*String name1 = resSet.getString("name");*/
                                String category1 = resSet.getString("category");
                        %>
                        <%= category1 %>
                        <% } %>--%>


                        <br>
                        <br>
                        <%--<%= request.getAttribute("testId") %>--%>


                    </td>
                    <% } %>
                </tr>

            </table>

        </td>
    </tr>
</table>
</body>
</html>
