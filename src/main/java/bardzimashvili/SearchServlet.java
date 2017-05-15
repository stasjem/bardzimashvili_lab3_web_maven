package bardzimashvili;

import bardzimashvili.db.Conn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchServlet extends HttpServlet implements Properties
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        String nameApp = req.getParameter("nameApp").trim();
        req.setAttribute("nameApp", nameApp);
        req.getRequestDispatcher("searchView.jsp").forward(req, resp);


        /*try
        {
            ResultSet resSet;
            Conn conn = new Conn();
            resSet = conn.searchTableWhere(nameApp);
            while (resSet.next())
            {
                String idDb = resSet.getString("id");
                String nameAppDb = resSet.getString("nameApp");
                //String categoryDb = resSet.getString("category");
                String sizeDb = resSet.getString("size");
                String descriptionsDb = resSet.getString("descriptions");
                //String category = resSet.getString("subcategory");
                String category = resSet.getString("category");
                //String category_id = resSet.getString("category_id");

                req.setAttribute("idDb", idDb);
                req.setAttribute("nameAppDb", nameAppDb);
                req.setAttribute("category", category);
                //req.setAttribute("category_id", category_id);
                req.setAttribute("sizeDb", sizeDb);

                req.setAttribute("descriptionsDb", descriptionsDb);
                //System.out.println("idDh " + idDb);

                req.getRequestDispatcher("searchView.jsp").forward(req, resp);
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
        catch (Exception e)
        {
            e.printStackTrace();
        }*/

    }

}
