package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import model.Coche;

public class CocheDao {

    private DbConnection conn;

    public CocheDao(DbConnection conn) {
        this.conn = conn;
    }

    /**
     * Metodo para insertar un registro en la tabla Coche
     *
     * @param coche
     * @return Regresa el id generado por la base de datos
     * @throws Exception
     */
    public boolean insert(Coche srv) {

    	//Para dar formato a un String a tipo fecha.
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String sql = "insert into Coche values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, srv.getId());
            //En lugar de setDate usamos un String dándole formato
            preparedStatement.setString(2, format.format(srv.getFechaPublicacion()));
            preparedStatement.setString(3, srv.getMarca());
            preparedStatement.setString(4, srv.getModelo());
            preparedStatement.setString(5, srv.getColor());
            preparedStatement.setString(6, srv.getPrecio());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error CocheDao.insert: " + e.getMessage());
            return false;
        }
    }

    /**
     * Metodo que regresa una lista con los 3 ultimos servidores que seran
     * mostrados en la pagina principal
     *
     * @return
     * @throws Exception
     */
    public List<Coche> getUltimos() {

        try {
            String sql = "select * from Coche order by id desc limit 3";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Coche> list = new LinkedList<>();
            Coche srv;
            while (rs.next()) {
                srv = new Coche(rs.getInt("id"));
                srv.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                srv.setMarca(rs.getString("marca"));
                srv.setModelo(rs.getString("modelo"));
                srv.setColor(rs.getString("color"));
                srv.setPrecio(rs.getString("precio"));
                // Add car object to the list
                list.add(srv);
                System.out.println(list);
            }
            return list;

        } catch (SQLException e) {            
            System.out.println("Error CocheDao.getUltimos: " + e.getMessage());
            return null;
        }
    }

    /**
     * Metodo para buscar en la base de datos un registro de Coche por
     * medio del id
     *
     * @param idCoche
     * @return Objeto de tipo Coche. Si no lo encuentra, regresa null
     * @throws Exception
     */
    public Coche getById(int idCoche){
        try {
            String sql = "select * from Coche where id=? limit 1";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idCoche); // Set idServidor
            ResultSet rs = preparedStatement.executeQuery();
            Coche srv = new Coche(0);
            while (rs.next()) {
                // Create an object for the movie
            	srv.setId(rs.getInt("id"));
            	srv.setFechaPublicacion(rs.getDate("fechaPublicacion"));
            	srv.setMarca(rs.getString("marca"));
            	srv.setModelo(rs.getString("modelo"));
            	srv.setColor(rs.getString("color"));
            	srv.setPrecio(rs.getString("precio"));
            }
            return srv;

        } catch (SQLException e) {            
            System.out.println("Error CocheDao.getById: " + e.getMessage());
            return null;
        }
    }

    /**
     * Metodo que regresa una lista con todos los Coches.
     *
     * @return Lista de todos los objetos Coche
     * @throws Exception
     */
    public List<Coche> getAll(){

        try {
            String sql = "select * from Coche order by id desc";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Coche> list = new LinkedList<>();
            Coche srv;
            while (rs.next()) {
            	srv = new Coche(rs.getInt("id"));
                srv.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                srv.setMarca(rs.getString("marca"));
            	srv.setModelo(rs.getString("modelo"));
            	srv.setColor(rs.getString("color"));
            	srv.setPrecio(rs.getString("precio"));    
                // Add car object to the list
                list.add(srv);
            }
            return list;

        } catch (SQLException e) {            
            System.out.println("Error CocheDao.getAll: " + e.getMessage());
            return null;
        }
    }

    /**
     * Metodo para hacer busqueda de coches (la busqueda se hace por
     * modelo y marca)
     *
     * @param query
     * @return Lista de todos los objetos coches que fueron encontrados
     * @throws Exception
     */
    public List<Coche> getByQuery(String query){

        try {
            String sql = "select * from Coche where (modelo like ? or marca like ?) order by id desc";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, "%" + query + "%");
            preparedStatement.setString(2, "%" + query + "%");
            ResultSet rs = preparedStatement.executeQuery();
            List<Coche> list = new LinkedList<>();
            Coche srv;
            while (rs.next()) {
            	srv = new Coche(rs.getInt("id"));
            	srv.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                srv.setMarca(rs.getString("marca"));
            	srv.setModelo(rs.getString("modelo"));
            	srv.setColor(rs.getString("color"));
            	srv.setPrecio(rs.getString("precio"));                
                // Add car object to the list
                list.add(srv);
            }
            return list;

        } catch (SQLException e) {            
            System.out.println("Error CocheDao.getByQuery: " + e.getMessage());
            return null;
        }
    }
    
    
    /**
     * Metodo para eliminar un coche.
     * @param idCoche
     * @return No. de filas afectadas
     */
    public int delete(int idServidor) {
        try {
            String sql = "delete from Coche where id=?";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idServidor);
            int rows = preparedStatement.executeUpdate();
            return rows;

        } catch (SQLException e) {            
            System.out.println("Error CocheDao.eliminar: " + e.getMessage());
            return 0;
        }
    }

}
