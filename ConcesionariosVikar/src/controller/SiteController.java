package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DbConnection;
import dao.CocheDao;
import model.Coche;

public class SiteController extends HttpServlet {
    /**
     * Controller que sirve para mostrar la pagina principal de la aplicacion. Se encarga de mandar al index.jsp
     * un objeto de tipo List con las 3 ultimos coches
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;        
        DbConnection conn = new DbConnection();
        CocheDao cocheDao = new CocheDao(conn);
        List<Coche> lista = cocheDao.getUltimos();
        conn.disconnect();
        request.setAttribute("ultimos", lista);
        rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

}
