package controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import dao.DbConnection;
import dao.SolicitudDao;
import dao.CocheDao;
import model.Solicitud;
import model.Coche;
import util.Utility;

public class SolicitudController extends HttpServlet {

    /*
    Directorio donde se guardaran los archivos fisicos.
    webapps/servidores/uploads
     */
    private static final String UPLOAD_DIR = "uploads";

    /**
     * 1. Guardar un registro de una solicitud para un servidor
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        // Recibimos los campos de tipo texto
        String nombreParam = request.getParameter("nombre");
        String emailParam = request.getParameter("email");
        String telefonoParam = request.getParameter("telefono");
        String direccionParam = request.getParameter("direccion");
        // Este parametro idServidor es el que viene en la URL del boton "Enviar"
        // servidor?action=enviar&id=${servidor.id}
        // Para insertarlo en la tabla Solicitud reservamos el idServidor (Foreign key)
        int idCocheParam = Integer.parseInt(request.getParameter("idCoche"));

     // Creamos el objeto que guardaremos
        Solicitud solicitud = new Solicitud(0);
        solicitud.setFecha(new Date());
        solicitud.setNombre(nombreParam);
        solicitud.setEmail(emailParam);
        solicitud.setTelefono(telefonoParam);
        solicitud.setDireccion(direccionParam);
        DbConnection conn = new DbConnection();
        CocheDao cocheDao = new CocheDao(conn);
        // Buscamos el objeto Servidor, por medio del parametro idServidor que viene del boton "Enviar"
        Coche srv = cocheDao.getById(idCocheParam);
        //Inyeccion del objeto Servidor en la solicitud (Foreign Key)
        solicitud.setCoche(srv);
        String msg="";
        SolicitudDao solicitudDao = new SolicitudDao(conn);
        solicitudDao.insert(solicitud);
        conn.disconnect();
        msg = "<b>" + solicitud.getNombre() + "</b> hemos recibido tus datos."
                + "<br> Revisaremos tu solicitud y nos pondremos en contacto contigo.<br><br>Gracias.";
        request.setAttribute("message", msg);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/mensaje_guest.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recibimos el parametro action, el cual servira para saber que accion GET se ejecutara
        String action = request.getParameter("action");
        // Recuperamos la session activa que viene junto con el request
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        String msg = "";
        switch (action) {
            case "solicitudes":
                if (session.getAttribute("usuario") == null) {
                    rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                } else {
                    this.verSolicitudes(request, response);
                }
                break;
            case "eliminar":
                if (session.getAttribute("usuario") == null) {
                    msg = "Acceso Denegado.";
                    request.setAttribute("message", msg);
                    rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                } else {
                    this.eliminarSolicitud(request, response);
                }
                break;
        }

    }

    /**
     * Metodo que se ejecuta, si el parametro action, es solicitudes
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void verSolicitudes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        String msg = null;
        List<Solicitud> lista = null;
        DbConnection conn = new DbConnection();
        SolicitudDao solicitudDao = new SolicitudDao(conn);
        lista = solicitudDao.getAll();
        conn.disconnect();

        request.setAttribute("message", msg);
        request.setAttribute("solicitudes", lista);
        rd = request.getRequestDispatcher("/solicitudes.jsp");
        rd.forward(request, response);
    }
    private void eliminarSolicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recibimos el id del servidor que vamos a eliminar
        int idSolicitudParam = Integer.parseInt(request.getParameter("idSolicitud"));
        DbConnection conn = new DbConnection();
        SolicitudDao solicitudDao = new SolicitudDao(conn);
        int respuesta = solicitudDao.delete(idSolicitudParam);
        String msg = "";
        if (respuesta == 1) { // Fue afectado un registro, esto significa que si se borro
            msg = "La solicitud fue eliminada correctamente.";
        } else {
            msg = "Ocurrio un error. La solicitud no fue eliminado.";
        }
        conn.disconnect();
        request.setAttribute("message", msg);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/mensaje_admin.jsp");
        rd.forward(request, response);
    }

}
