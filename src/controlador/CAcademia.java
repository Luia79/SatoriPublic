package controlador;

import controlador.bd.Transacciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Academia;
import vista.VAcademia;

/**
 *
 * @author adrian
 */
public class CAcademia implements ActionListener {

    VAcademia vAcademia;
    Academia academia;
    private int contador;
    private int idFilaTemporal;

    DefaultTableModel modelo;

    public CAcademia(VAcademia academia) {
        this.vAcademia = academia;

        this.vAcademia.btnNuevo.addActionListener(this);
        this.vAcademia.btnBuscar.addActionListener(this);
        this.vAcademia.btnInsertar.addActionListener(this);
        this.vAcademia.btnModificar.addActionListener(this);
        this.vAcademia.btnEliminar.addActionListener(this);

        this.contador = 1;
        this.idFilaTemporal = -1;
    }

    public void iniciarAcademia() {
        this.vAcademia.setLocationRelativeTo(null);
        this.vAcademia.setTitle("Academias");
        this.vAcademia.setResizable(false);

        //iniciamos la tabla
        iniciarTabla();

        this.vAcademia.pack();  //redimensión de contenedores
        this.vAcademia.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.vAcademia.btnNuevo) {
            limpiarCampos();
        } else if (e.getSource() == this.vAcademia.btnBuscar) {
            buscar();
        } else if (e.getSource() == this.vAcademia.btnInsertar) {
            insertar();
            this.iniciarTabla();
        } else if (e.getSource() == this.vAcademia.btnModificar) {
            this.modificar();
            this.iniciarTabla();
        } else if (e.getSource() == this.vAcademia.btnEliminar) {
            this.borrar();
            this.iniciarTabla();
        }

    }

    private void limpiarCampos() {
        this.idFilaTemporal = -1;
        this.vAcademia.txtNombre.setText("");
    }

    private void insertar() {
        this.academia = new Academia();
        //recogemos los datos
        String nombre = this.vAcademia.txtNombre.getText();
        //asignamos al objeto
        this.academia.setNombre(nombre);
        //INSERTAR EN LA BD
        Transacciones t = new Transacciones();
        if (t.insertarAcademia(academia)) {
            JOptionPane.showMessageDialog(null, "Insertado correctamente",
                    "Exitoso", JOptionPane.DEFAULT_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "NO se inserto",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void buscar() {
        try {
            int idBuscar = Integer.parseInt(this.vAcademia.txtBuscar.getText());

        int filas = this.modelo.getRowCount();

        for (int i = 0; i < filas; i++) {

            int idModelo = Integer.parseInt(modelo.getValueAt(i, 0).toString());

            if (idModelo == idBuscar) {
                this.idFilaTemporal = i;
                this.vAcademia.txtNombre.setText(modelo.getValueAt(i, 1).toString());
                break;
            }
        }
        } catch (NumberFormatException e) {
            
            JOptionPane.showMessageDialog(null, "ID invalido",
                    "Error de formato", JOptionPane.ERROR_MESSAGE);
        }//Cerra catch

        
    }//Cierra buscar

    private void borrar() {
        this.modelo.removeRow(this.idFilaTemporal);
        this.vAcademia.tblRegistros.setModel(this.modelo);
    }

    private void modificar() {
        this.academia = new Academia();
        //recogemos los datos        
        String nombre = this.vAcademia.txtNombre.getText();
        String idTexto = this.vAcademia.txtBuscar.getText();
        int id = Integer.parseInt(idTexto);
        //asignamos al objeto 
        this.academia.setIdAcademia(id);
        this.academia.setNombre(nombre);

        Transacciones t = new Transacciones();
        if (t.actualizarAcademia(academia)) {
            JOptionPane.showMessageDialog(null, "Atualizado correctamente",
                    "Exitoso", JOptionPane.DEFAULT_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "NO se Atualizado",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }// Cierra metodo modificar academia

    private void iniciarTabla() {

        this.modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que todas las celdas sean no editables
            }
        };

        // Agregamos columnas al modelo
        this.modelo.addColumn("Clave");
        this.modelo.addColumn("Nombre");

        // Agregamos unos datos
        Transacciones t = new Transacciones();
        this.academia = new Academia();
        List<Object[]> resultados = t.seleccionar(this.academia);
        for (int i = 0; i < resultados.size(); i++) {
            this.modelo.addRow(resultados.get(i));
        }//Cierra for

        //asinamos el modelo a la tabla
        this.vAcademia.tblRegistros.setModel(this.modelo);

//        //objeto de transacciones temporal
//        Transacciones t = new Transacciones();
//        t.seleccionar(new Academia());
    } // termina iniciarTabla

}
