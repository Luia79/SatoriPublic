package principal;

import com.jtattoo.plaf.aero.AeroLookAndFeel;
import controlador.CLogin;
import controlador.bd.ConexionBD;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import vista.VLogin;



/**
 *
 * @author José Adrian García López
 */
public class Satori {
    
    public static void main(String[] args) {
        
        
        
       
        
        
        try {
            UIManager.setLookAndFeel(new AeroLookAndFeel());              

        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Error de LookAndFeel");
        }
        
        
            
            
   
            //ConexionBD.iniciarConeccionBD();
            
            //evaluar la conexion 
        if (ConexionBD.iniciarConeccionBD()) {
            JOptionPane.showMessageDialog(null, "Conectado a la BD");
            
            VLogin login = new VLogin();
            CLogin cLogin = new CLogin(login);
            cLogin.iniciarLogin();
           
        } else {
            JOptionPane.showMessageDialog(null, "No ha conectado a la BD", 
                    "Error de conección", JOptionPane.ERROR_MESSAGE);
        }

    } // close main

} // close class
