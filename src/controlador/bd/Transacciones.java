package controlador.bd;

import modelo.Usuario;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import modelo.Academia;

/**
 *
 * @author adrian
 */
public class Transacciones {
    
    public boolean insertarAcademia(Academia academia){
    
        if(ConexionBD.iniciarConeccionBD()){
            try {
              String procedimineto = "{CALL insertarAcademia(?)}";
              PreparedStatement st = ConexionBD.conexion.prepareCall(procedimineto);
              st.setString(1, academia.getNombre());
              st.execute();
              return true;
            } catch (SQLException e) {
                System.err.println("Error"+e.getMessage());
                return false;
            }//Cierra catch
            
        }//Cierra if
    return false;
    }//Cierra insertarAcademia
    
    
    public boolean validarSesion(Usuario usuario){
    
        try {
            
            //si tuvieramos base de datos, aquí ejecutariamos la consulta
            
            //validamos
            return (usuario.getNombreUsuario().equals("admin") && usuario.getContrasena().equals("202cb962ac59075b964b07152d234b70"));
                        
        } catch (Exception e) {
            System.out.println("Error al validar la sesión");
            return false;
        }
        
    } //close vaidarSesion
    
    
}
