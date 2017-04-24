package bardzimashvili;

import bardzimashvili.db.Conn;
import bardzimashvili.db.Db;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

//import static bardzimashvili.Properties.TABLEAPP;

public class InputServlet extends HttpServlet implements Properties
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {

        try
        {
            Db db = new Db();
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


        /**
         * Took the values of variables
         */
        String title = "title";
        String name = "nameapp";
        String nameApp = req.getParameter("nameApp");
        String category = req.getParameter("category");
        String size = req.getParameter("size");
        String market = req.getParameter("market");
        String descriptions = req.getParameter("descriptions");

        Conn conn = new Conn();
        try
        {
            conn.writeTableApp(nameApp, market, descriptions, size);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


        /*req.setAttribute("title", title);
        req.setAttribute("title", name);
        req.setAttribute("nameApp", nameApp);
        req.setAttribute("category", category);
        req.setAttribute("size", size);
        req.setAttribute("market", market);
        req.setAttribute("descriptions", descriptions);*/


        try
        {
            ResultSet resSet;
            resSet = conn.readTable(TABLEAPP);

            while (resSet.next())
            {
                String nameAppDb = resSet.getString("nameApp");
                String categoryDb = resSet.getString("category");
                String sizeDb = resSet.getString("size");
                String marketDb = resSet.getString("market");
                String descriptionsDb = resSet.getString("descriptions");

                req.setAttribute("nameAppDb", nameAppDb);
                req.setAttribute("categoryDb", categoryDb);
                req.setAttribute("sizeDb", sizeDb);
                req.setAttribute("marketDb", marketDb);
                req.setAttribute("descriptionsDb", descriptionsDb);

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        req.getRequestDispatcher("allList.jsp").forward(req, resp);


        //req.getRequestDispatcher("allList.jsp").forward(req, resp);
    }
}
