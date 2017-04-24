package bardzimashvili;

import bardzimashvili.db.Db;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class InputServlet extends HttpServlet
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


        String title = "title";
        String name = "nameapp";
        String nameApp = req.getParameter("nameApp");
        //req.setAttribute("name", value);
        req.setAttribute("title", title);
        req.setAttribute("title", name);
        req.setAttribute("nameApp", nameApp);
        req.getRequestDispatcher("allList.jsp").forward(req, resp);
    }
}
