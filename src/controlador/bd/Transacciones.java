package controlador.bd;

import java.util.List;
import modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.ArrayList;
import modelo.Academia;
import modelo.Laboratorio;

/**
 *
 * @author adrian
 */
public class Transacciones {
    
    public boolean insertarAcademia(Academia academia){
    
        if(ConexionBD.iniciarConeccionBD()){
            try {
              String procedimineto = "{CALL insertarAcademia(?)}";
              CallableStatement st = ConexionBD.conexion.prepareCall(procedimineto);
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
    
    public boolean actualizarAcademia(Academia academia){
    
        if(ConexionBD.iniciarConeccionBD()){
            try {
              String procedimineto = "{CALL actualizarAcademia(?,?)}";
                CallableStatement st = ConexionBD.conexion.prepareCall(procedimineto);
              st.setInt(1, academia.getIdAcademia());//parametro de id
              st.setString(2, academia.getNombre());//parametro de nombre
              st.execute();
              return true;
            } catch (SQLException e) {
                System.err.println("Error"+e.getMessage());
                return false;
            }//Cierra catch
            
        }//Cierra if
    return false;
    }//Cierra actualizarAcademia
    
    public boolean insertarLaboratorio(Laboratorio laboratorio){
        if(ConexionBD.iniciarConeccionBD()){
            try {
              String procedimineto = "{CALL insertarLaboratorio(?)}";
              CallableStatement st = ConexionBD.conexion.prepareCall(procedimineto);
              st.setString(1, laboratorio.getNombre());
              st.execute();
              return true;
            } catch (SQLException e) {
                System.err.println("Error"+e.getMessage());
                return false;
            }//Cierra catch
            
        }//Cierra if
    return false;
    }//Cierra insertarAcademia
    
    public boolean actualizarLaboratorio(Laboratorio laboratorio){
    
        if(ConexionBD.iniciarConeccionBD()){
            try {
              String procedimineto = "{CALL actualizarLaboratorio(?,?)}";
              CallableStatement st = ConexionBD.conexion.prepareCall(procedimineto);
              st.setInt(1, laboratorio.getIdLaboratorio());//parametro de id
              st.setString(2, laboratorio.getNombre());//parametro de nombre
              st.execute();
              return true;
            } catch (SQLException e) {
                System.err.println("Error"+e.getMessage());
                return false;
            }//Cierra catch
            
        }//Cierra if
    return false;
    }//Cierra actualizarAcademia
    
    public List<Object[]> seleccionar(Academia academia){
        List<Object[]> resultado = null;
        //------------------------------------------------
        if(ConexionBD.iniciarConeccionBD()){
            try {
              String procedimineto = "{CALL seleccionarAcademia(?)}";
              CallableStatement st = ConexionBD.conexion.prepareCall(procedimineto);
              st.setInt(1, academia.getIdAcademia());//parametro de id
              ResultSet rst = st.executeQuery();
              int canCol = rst.getMetaData().getColumnCount();
              resultado = new ArrayList();
              while(rst.next()){
                  Object[] registro = new Object[canCol];
                  for (int i = 0; i < canCol; i++) {
                      registro[i] = rst.getObject(i+1);
                  }//Cierrra for
                  resultado.add(registro);
              }//Cierra while
             
              return resultado;
            } catch (SQLException e) {
                System.err.println("Error"+e.getMessage());
                return resultado;
            }//Cierra catch
            
        }//Cierra if
        //------------------------------------------------
        
        return resultado;
    }
    
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
