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

                    //resSet = conn.readTable(app);
                    resSet = conn.readTableAll();

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
                        <%= category %><br>
                        <%= category_id %><br>
                        <%= size %><br>
                        <%= descriptions %><br>




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

<%--<sql:query dataSource="${snapshot}" var="result">
    SELECT * from Employees;
</sql:query>--%>
<%--<%!
    //public static ResultSet resSet;

%>--%>

</body>
</html>


