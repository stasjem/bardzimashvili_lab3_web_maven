package bardzimashvili;

import bardzimashvili.db.Conn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditServlet extends HttpServlet implements Properties
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        String id = req.getParameter("id");
        System.out.println(id);

        try
        {
            ResultSet resSet;
            Conn conn = new Conn();
            try
            {
                resSet = conn.readTableWhere(TABLEAPP, id);
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
                    System.out.println("idDh " + idDb);

                    req.getRequestDispatcher("editApp.jsp").forward(req, resp);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        /*String category = req.getParameter("category");
        String size = req.getParameter("size");
        String market = req.getParameter("market");
        String descriptions = req.getParameter("descriptions");*/

    }
}
