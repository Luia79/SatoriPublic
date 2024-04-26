package controlador;

import vista.VMaterias;

/**
 *
 * @author adrian
 */
public class CMaterias {
    VMaterias materias;

    public CMaterias(VMaterias materias) {
        this.materias = materias;
    }
    
    public void iniciarMaterias() {
        this.materias.setLocationRelativeTo(null);
        this.materias.setTitle("Materias");
        this.materias.setResizable(false);
        this.materias.pack();  //redimensión de contenedores
        this.materias.setVisible(true);
    }
    
    
}
