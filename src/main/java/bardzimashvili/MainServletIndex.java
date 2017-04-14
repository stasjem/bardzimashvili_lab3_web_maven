package bardzimashvili;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


//@WebServlet("/")
public class MainServletIndex extends HttpServlet
{
    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doGet(req, resp);
    }
    */


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        Db db = new Db();
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


        PrintWriter printWriter = resp.getWriter();
        printWriter.println("hello");
        printWriter.close();
    }

    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        req.setAttribute("name", "hello");

        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }*/
}
