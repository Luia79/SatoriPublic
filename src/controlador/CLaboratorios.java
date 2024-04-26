package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Laboratorio;
import vista.VLaboratorios;

/**
 *
 * @author adrian
 */
public class CLaboratorios implements ActionListener {

    VLaboratorios vLaboratorios;
    Laboratorio laboratorio;
    private int contador;
    private int idFilaTemporal;
    
    DefaultTableModel modelo;

    public CLaboratorios(VLaboratorios laboratorios) {
        this.vLaboratorios = laboratorios;
        
        this.vLaboratorios.btnNuevo.addActionListener(this);
        this.vLaboratorios.btnBuscar.addActionListener(this);
        this.vLaboratorios.btnInsertar.addActionListener(this);
        this.vLaboratorios.btnModificar.addActionListener(this);
        this.vLaboratorios.btnEliminar.addActionListener(this);
        
        this.contador = 1;
        this.idFilaTemporal = -1; 
    }

    public void iniciarLaboratorios() {
        this.vLaboratorios.setLocationRelativeTo(null);
        this.vLaboratorios.setTitle("Laboratorios");
        this.vLaboratorios.setResizable(false);
        
        //iniciamos la tabla
        iniciarTabla();
        
        this.vLaboratorios.pack();  //redimensión de contenedores
        this.vLaboratorios.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vLaboratorios.btnNuevo) {
            limpiarCampos();
        } else if (e.getSource() == this.vLaboratorios.btnBuscar) {
            buscar();            
        } else if (e.getSource() == this.vLaboratorios.btnInsertar) {
            insertar();
        } else if (e.getSource() == this.vLaboratorios.btnModificar) {
            this.modificar();
        } else if (e.getSource() == this.vLaboratorios.btnEliminar) {
            this.borrar();
        }
    
    }
    
    private void limpiarCampos() {
        this.idFilaTemporal = -1;
        this.vLaboratorios.txtNumero.setText("");
        this.vLaboratorios.txtNombre.setText("");
    }
    
    private void insertar() {
        this.laboratorio = new Laboratorio();

        //recogemos los datos
        int id = Integer.parseInt(this.vLaboratorios.txtNumero.getText());
        String nombre = this.vLaboratorios.txtNombre.getText();

        //asignamos al objeto
        this.laboratorio.setIdLaboratorio(id);
        this.laboratorio.setNombre(nombre);

        this.modelo.addRow(new Object[]{
            this.laboratorio.getIdLaboratorio(),
            this.laboratorio.getNombre()
        });

        this.vLaboratorios.tblRegistros.setModel(this.modelo);

        this.contador++;
    }
    
    private void buscar() {
        int idBuscar = Integer.parseInt(this.vLaboratorios.txtBuscar.getText());

        int filas = this.modelo.getRowCount();

        for (int i = 0; i < filas; i++) {

            int idModelo = Integer.parseInt(modelo.getValueAt(i, 0).toString());

            if (idModelo == idBuscar) {       
                this.idFilaTemporal = i;
                this.vLaboratorios.txtNumero.setText(modelo.getValueAt(i, 0).toString());
                this.vLaboratorios.txtNombre.setText(modelo.getValueAt(i, 1).toString());
                break;
            }
        }
    }
    
    private void borrar(){
        this.modelo.removeRow(this.idFilaTemporal);
        this.vLaboratorios.tblRegistros.setModel(this.modelo);
    }
    
    private void modificar(){
        this.laboratorio = new Laboratorio();

        //recogemos los datos        
        int numero = Integer.parseInt(this.vLaboratorios.txtNumero.getText());
        String nombre = this.vLaboratorios.txtNombre.getText();

        //asignamos al objeto        
        this.laboratorio.setIdLaboratorio(numero);
        this.laboratorio.setNombre(nombre);
        
        this.modelo.setValueAt(this.laboratorio.getIdLaboratorio(), this.idFilaTemporal, 0);
        this.modelo.setValueAt(this.laboratorio.getNombre(), this.idFilaTemporal, 1);
        
        this.vLaboratorios.tblRegistros.setModel(this.modelo);
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

        // Agregamos unos datos de prueba
        // Agregar filas al modelo
        this.modelo.addRow(new Object[]{this.contador, "Aplicaciones 1"});
        this.contador++;

        this.modelo.addRow(new Object[]{this.contador, "Aplicaciones 2"});
        this.contador++;

        //asinamos el modelo a la tabla
        this.vLaboratorios.tblRegistros.setModel(this.modelo);
    } // termina iniciarTabla
    

}
