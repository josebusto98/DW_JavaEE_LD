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

public class BusquedaController extends HttpServlet {
    /**
     * Metodo POST para hacer la busqueda de coches solicitados por el usuario.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recibimos la cadena de busqueda del usuario
        String q = request.getParameter("query");               
        List<Coche> lista = null;
        DbConnection conn = new DbConnection();
        // Con nuestro objeto DAO, hacemos la busqueda de coches
        CocheDao cocheDao = new CocheDao(conn);
        lista = cocheDao.getByQuery(q);
        conn.disconnect();
        RequestDispatcher rd;
        request.setAttribute("coche", lista);
        rd = request.getRequestDispatcher("/coche.jsp");
        rd.forward(request, response);
    }

}
