package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import vista.VAcademia;
import vista.VDocentes;
import vista.VLaboratorios;
import vista.VMaterias;
import vista.VMenu;

/**
 *
 * @author adrian
 */
public class CMenu implements ActionListener {

    VMenu menu;

    public CMenu(VMenu menu) {

        this.menu = menu;

        //Agregamos los eventos a cada item
        this.menu.itemAcademia.addActionListener(this);
        this.menu.itemHorario.addActionListener(this);
        this.menu.itemLaboratorios.addActionListener(this);
        this.menu.itemMaterias.addActionListener(this);
        this.menu.itemProfesores.addActionListener(this);
        this.menu.itemAcercaDe.addActionListener(this);
        this.menu.itemSalir.addActionListener(this);
    }

    public void iniciarMenu() {
        this.menu.setLocationRelativeTo(null);
        this.menu.setTitle("Menú");
        this.menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.menu.pack();  //redimensión de contenedores

        //bloqueo temporal
        bloqueoTemporal();

        this.menu.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.menu.itemAcademia) {
            VAcademia dialog = new VAcademia(this.menu, true);
            CAcademia cAcademia = new CAcademia(dialog);
            cAcademia.iniciarAcademia();

        } else if (e.getSource() == this.menu.itemHorario) {
            //hacer

        } else if (e.getSource() == this.menu.itemLaboratorios) {
            VLaboratorios dialog = new VLaboratorios(this.menu, true);
            CLaboratorios cAcademia = new CLaboratorios(dialog);
            cAcademia.iniciarLaboratorios();

        } else if (e.getSource() == this.menu.itemMaterias) {
            VMaterias dialog = new VMaterias(this.menu, true);
            CMaterias cAcademia = new CMaterias(dialog);
            cAcademia.iniciarMaterias();

        } else if (e.getSource() == this.menu.itemProfesores) {
            VDocentes dialog = new VDocentes(this.menu, true);
            CDocentes cAcademia = new CDocentes(dialog);
            cAcademia.iniciarDocentes();

        } else if (e.getSource() == this.menu.itemAcercaDe) {
            //hacer

        } else if (e.getSource() == this.menu.itemSalir) {
            System.exit(0);

        } //close if

    } //close actionPerformed

    private void bloqueoTemporal() {
        this.menu.menuAyuda.setEnabled(false);
        this.menu.itemHorario.setEnabled(false);
        this.menu.itemMaterias.setEnabled(false);
    }

} //close class
