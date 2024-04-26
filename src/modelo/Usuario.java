package modelo;

/**
 *
 * @author adrian
 */
public class Usuario {
       
    private int id;
    private String nombreUsuario;
    private String contrasena;  
    
    //inician los metodos setter

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
        
    //inician los metodos getter

    public int getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }
                
} //close class
