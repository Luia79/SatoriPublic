package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Docente;
import vista.VDocentes;

/**
 *
 * @author adrian
 */
public class CDocentes implements ActionListener {

    VDocentes vDocentes;
    Docente docente;

    private int contador;
    private int idFilaTemporal;

    DefaultTableModel modelo;

    public CDocentes(VDocentes docentes) {
        this.vDocentes = docentes;

        this.vDocentes.btnNuevo.addActionListener(this);
        this.vDocentes.btnBuscar.addActionListener(this);
        this.vDocentes.btnInsertar.addActionListener(this);
        this.vDocentes.btnModificar.addActionListener(this);
        this.vDocentes.btnEliminar.addActionListener(this);

        this.contador = 1;
        this.idFilaTemporal = -1;
    }

    public void iniciarDocentes() {
        this.vDocentes.setLocationRelativeTo(null);
        this.vDocentes.setTitle("Docentes");
        this.vDocentes.setResizable(false);

        //iniciamos la tabla
        iniciarTabla();
        iniciarBox();

        this.vDocentes.pack();  //redimensión de contenedores
        this.vDocentes.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vDocentes.btnNuevo) {
            limpiarCampos();
        } else if (e.getSource() == this.vDocentes.btnBuscar) {
            buscar();
        } else if (e.getSource() == this.vDocentes.btnInsertar) {
            insertar();
        } else if (e.getSource() == this.vDocentes.btnModificar) {
            this.modificar();
        } else if (e.getSource() == this.vDocentes.btnEliminar) {
            this.borrar();
        }
    }
    
    private void limpiarCampos() {
        this.idFilaTemporal = -1;
        
        this.vDocentes.txtNumeroEmpleado.setText("");
        this.vDocentes.txtNombres.setText("");
        this.vDocentes.txtApellidoPaterno.setText("");
        this.vDocentes.txtApellidoMaterno.setText("");
        this.vDocentes.boxAcademia.setSelectedIndex(0);
    }
    
    private void insertar() {
        this.docente = new Docente();

        //recogemos los datos
        int id = Integer.parseInt(this.vDocentes.txtNumeroEmpleado.getText());
        String nombre = this.vDocentes.txtNombres.getText();
        String apellidoPaterno = this.vDocentes.txtApellidoPaterno.getText();
        String apellidoMaterno = this.vDocentes.txtApellidoMaterno.getText();                       
        String academia = this.vDocentes.boxAcademia.getSelectedItem().toString();

        //asignamos al objeto
        this.docente.setIdEmpleado(id);
        this.docente.setNombres(nombre);
        this.docente.setApellidoPaterno(apellidoPaterno);
        this.docente.setApellidoMaterno(apellidoMaterno);
        this.docente.setAcademia(academia);

        this.modelo.addRow(new Object[]{
            this.docente.getIdEmpleado(),
            this.docente.getNombres(),
            this.docente.getApellidoPaterno(),
            this.docente.getApellidoMaterno(),
            this.docente.getAcademia(),
        });

        this.vDocentes.tblRegistros.setModel(this.modelo);

        this.contador++;
    }
    
    private void buscar() {
        int idBuscar = Integer.parseInt(this.vDocentes.txtBuscar.getText());

        int filas = this.modelo.getRowCount();

        for (int i = 0; i < filas; i++) {

            int idModelo = Integer.parseInt(modelo.getValueAt(i, 0).toString());

            if (idModelo == idBuscar) {       
                this.idFilaTemporal = i;
                this.vDocentes.txtNumeroEmpleado.setText(idModelo+"");                
                this.vDocentes.txtNombres.setText(modelo.getValueAt(i, 1).toString());  
                this.vDocentes.txtApellidoPaterno.setText(modelo.getValueAt(i, 2).toString());  
                this.vDocentes.txtApellidoMaterno.setText(modelo.getValueAt(i, 3).toString());  
                this.vDocentes.boxAcademia.setSelectedItem(modelo.getValueAt(i, 4).toString());  
                break;
            }
        }
    }
    
    private void borrar(){
        this.modelo.removeRow(this.idFilaTemporal);
        this.vDocentes.tblRegistros.setModel(this.modelo);
    }
    
    private void modificar(){
        this.docente = new Docente();

        //recogemos los datos        
        //recogemos los datos
        int id = Integer.parseInt(this.vDocentes.txtNumeroEmpleado.getText());
        String nombre = this.vDocentes.txtNombres.getText();
        String apellidoPaterno = this.vDocentes.txtApellidoPaterno.getText();
        String apellidoMaterno = this.vDocentes.txtApellidoMaterno.getText();                       
        String academia = this.vDocentes.boxAcademia.getSelectedItem().toString();

        //asignamos al objeto        
        //asignamos al objeto
        this.docente.setIdEmpleado(id);
        this.docente.setNombres(nombre);
        this.docente.setApellidoPaterno(apellidoPaterno);
        this.docente.setApellidoMaterno(apellidoMaterno);
        this.docente.setAcademia(academia);
        
        this.modelo.setValueAt(this.docente.getIdEmpleado(), this.idFilaTemporal, 0);
        this.modelo.setValueAt(this.docente.getNombres(), this.idFilaTemporal, 1);
        this.modelo.setValueAt(this.docente.getApellidoPaterno(), this.idFilaTemporal, 2);
        this.modelo.setValueAt(this.docente.getApellidoMaterno(), this.idFilaTemporal, 3);
        this.modelo.setValueAt(this.docente.getAcademia(), this.idFilaTemporal, 4);
        
        this.vDocentes.tblRegistros.setModel(this.modelo);
    }
    
    private void iniciarTabla() {                
        
        this.modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que todas las celdas sean no editables
            }
        };                
        
        // Agregamos columnas al modelo
        this.modelo.addColumn("Número");
        this.modelo.addColumn("Nombre");
        this.modelo.addColumn("Ap. Paterno");
        this.modelo.addColumn("Ap. Materno");
        this.modelo.addColumn("Academia");

        // Agregamos unos datos de prueba
        // Agregar filas al modelo
        this.modelo.addRow(new Object[]{
            this.contador, 
            "José Adrian",
            "García",
            "López",
            "ISC"
        });
        this.contador++;

        this.modelo.addRow(new Object[]{
            this.contador, 
            "Marcos",            
            "López",
            "Osorio",
            "IGE"
        });
        this.contador++;

        //asinamos el modelo a la tabla
        this.vDocentes.tblRegistros.setModel(this.modelo);
    } // termina iniciarTabla
    
    private void iniciarBox(){
        this.vDocentes.boxAcademia.removeAllItems();
        this.vDocentes.boxAcademia.addItem("ISC");
        this.vDocentes.boxAcademia.addItem("IGE");
        this.vDocentes.boxAcademia.addItem("ID");
        this.vDocentes.boxAcademia.addItem("LG");
        this.vDocentes.boxAcademia.addItem("LCP");
    }

}
