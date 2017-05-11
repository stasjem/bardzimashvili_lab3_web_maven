package bardzimashvili;

import bardzimashvili.db.Conn;
import bardzimashvili.db.DirAndFiles;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InputServletPartOne extends HttpServlet implements Properties
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {

        /**
         * Took the values of variables
         */
        String testId = req.getParameter("testId");
        String nameApp = req.getParameter("nameApp");
        String categoryId = req.getParameter("categoryId");
        String size = req.getParameter("size");
        String descriptions = req.getParameter("descriptions");

        //req.setAttribute("testId", testId);
        req.setAttribute("nameApp", nameApp);
        req.setAttribute("categoryId", categoryId);
        req.setAttribute("size", size);
        req.setAttribute("descriptions", descriptions);


       /* try
        {
            Conn conn = null;
            try
            {
                conn = new Conn();
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            conn.writeTableApp(nameApp, descriptions, size, categoryId);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }*/


        /*req.setAttribute("title", title);
        req.setAttribute("title", name);
        req.setAttribute("nameApp", nameApp);
        req.setAttribute("category", category);
        req.setAttribute("size", size);
        req.setAttribute("market", market);
        req.setAttribute("descriptions", descriptions);*/


        /*try
        {
            ResultSet resSet;
            Conn conn = new Conn();
            resSet = conn.readTable(TABLEAPP);


            while (resSet.next())
            {
                String idDb = resSet.getString("id");
                String nameAppDb = resSet.getString("name");
                String categoryDb = resSet.getString("category");
                String sizeDb = resSet.getString("size");
                String marketDb = resSet.getString("market");
                String descriptionsDb = resSet.getString("descriptions");

                req.setAttribute("idDb", idDb);
                req.setAttribute("nameAppDb", nameAppDb);
                req.setAttribute("categoryDb", categoryDb);
                req.setAttribute("sizeDb", sizeDb);
                req.setAttribute("marketDb", marketDb);
                req.setAttribute("descriptionsDb", descriptionsDb);

                req.getRequestDispatcher("allList.jsp").forward(req, resp);

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/


        req.getRequestDispatcher("formInputPart2.jsp").forward(req, resp);
    }
}
