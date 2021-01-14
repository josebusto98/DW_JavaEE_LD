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

public class CocheController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recibimos el parametro de accion, para ver que solicito el cliente.
        String action = request.getParameter("action");
        if ("ver".equals(action)) {
            this.verDetalle(request, response);
        } else if ("lista".equals(action)) {
            this.verTodas(request, response);
        } else if ("enviar".equals(action)) {
            this.mostrarFormulario(request, response);
        }
    }

    /**
     * Metodo que sirve para guardar un coche.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recibimos parametros del formulario
        Coche c = new Coche(0);
        String marcaParam = request.getParameter("marca");
        c.setMarca(marcaParam);
        String modeloParam = request.getParameter("modelo");
        c.setModelo(modeloParam);
        String colorParam = request.getParameter("color");
        c.setColor(colorParam);
        String precioParam = request.getParameter("precio");
        c.setPrecio(precioParam);
        
        //Imprimimos el objeto en consola (método toString)
        System.out.println(c);
        
        // Procesamos los datos a guardar en BD
        DbConnection conn = new DbConnection();
        CocheDao cocheDao = new CocheDao(conn);
        boolean status = cocheDao.insert(c);

        // Preparamos un mensaje para el usuario
        String msg = "";
        if (status) {
            msg = "El coche fue guardado correctamente.";
        } else {
            msg = "Ocurrio un error. El coche no fue guardado.";
        }
        conn.disconnect();
        RequestDispatcher rd;
        // Compartimos la variable msg, para poder accederla desde la vista con Expression Language
        request.setAttribute("message", msg);
        // Enviarmos respuesta a la vista mensaje.jsp
        rd = request.getRequestDispatcher("/mensaje_admin.jsp");
        rd.forward(request, response);
    }

    /**
     * Metodo para ver los detalles completos de un coche.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void verDetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recibimos id del servidor a consultar
        int idCoche = Integer.parseInt(request.getParameter("id"));
        DbConnection conn = new DbConnection();
        CocheDao cocheDao = new CocheDao(conn);
        Coche c = cocheDao.getById(idCoche);
        conn.disconnect();

        // Compartimos la variable srv para acceder desde la vista con Expression Language
        request.setAttribute("coche", c);
        RequestDispatcher rd;

        // Enviarmos respuesta a la vista detalle.jsp
        rd = request.getRequestDispatcher("/detalle.jsp");
        rd.forward(request, response);
    }

    /**
     * Metodo para buscar todos los coches registrados.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void verTodas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DbConnection conn = new DbConnection();
        CocheDao cocheDao = new CocheDao(conn);
        List<Coche> lista = cocheDao.getAll();
        conn.disconnect();
        // Compartimos la variable lista, para poder accederla desde la vista
        request.setAttribute("coche", lista);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/coche.jsp");
        rd.forward(request, response);
    }

    protected void mostrarFormulario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        int idCoche = Integer.parseInt(request.getParameter("id"));      
        Coche c = null;
        DbConnection conn = new DbConnection();
        CocheDao cocheDao = new CocheDao(conn);
        c = cocheDao.getById(idCoche);
        conn.disconnect();        
        request.setAttribute("coche", c);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/frm.jsp");
        rd.forward(request, response);
    }

}
