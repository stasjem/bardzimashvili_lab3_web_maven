package bardzimashvili;

import bardzimashvili.db.Conn;
import bardzimashvili.db.Db;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.Exception;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AllListServlet extends HttpServlet implements Properties
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        /*Db db = new Db();
        try
        {
            db.db();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }*/


        String title = "title";
        String name = "nameapp";
        String nameApp = req.getParameter("nameApp");
        //req.setAttribute("name", value);
        req.setAttribute("title", title);
        req.setAttribute("name", name);
        req.setAttribute("nameApp", nameApp);
        req.getRequestDispatcher("allList.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        Db db = new Db();
        Conn conn = new Conn();
        try
        {
            db.db();

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        try
        {
            ResultSet resSet;
            resSet = conn.readTable(TABLEAPP);


            while (resSet.next())
            {
                int id = resSet.getInt("id");
                String name = resSet.getString("name");
                String phone = resSet.getString("phone");

                String nameApp = resSet.getString("nameApp");;
                System.out.println("ID = " + id);
                System.out.println("name = " + name);
                System.out.println("phone = " + phone);
                System.out.println();

                req.setAttribute("id", id);
                req.setAttribute("name", name);
                req.setAttribute("phone", phone);
                req.setAttribute("nameApp", nameApp);
                req.getRequestDispatcher("allList.jsp").forward(req, resp);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        /*String title = "title";
        String name = "nameapp";
        String nameApp = req.getParameter("nameApp");
        //req.setAttribute("name", value);
        req.setAttribute("title", title);
        req.setAttribute("title", name);
        req.setAttribute("nameApp", nameApp);*/
        //req.getRequestDispatcher("allList.jsp").forward(req, resp);
    }
}
