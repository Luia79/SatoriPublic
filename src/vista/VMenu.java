/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

/**
 *
 * @author adrian
 */
public class VMenu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public VMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        itemSalir = new javax.swing.JMenuItem();
        menuDepartamento = new javax.swing.JMenu();
        itemAcademia = new javax.swing.JMenuItem();
        itemProfesores = new javax.swing.JMenuItem();
        itemHorario = new javax.swing.JMenuItem();
        itemLaboratorios = new javax.swing.JMenuItem();
        itemMaterias = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        itemAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(111, 114, 113));
        jLabel1.setFont(new java.awt.Font("Open Sans", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Espacio reservado para registrar asistencia");
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(98, 17, 50));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 10));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jMenuBar1.setBackground(new java.awt.Color(98, 17, 50));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(314, 40));

        menuArchivo.setForeground(new java.awt.Color(255, 255, 255));
        menuArchivo.setText("Archivo");
        menuArchivo.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N

        itemSalir.setBackground(new java.awt.Color(98, 17, 50));
        itemSalir.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        itemSalir.setForeground(new java.awt.Color(255, 255, 255));
        itemSalir.setText("Salir");
        menuArchivo.add(itemSalir);

        jMenuBar1.add(menuArchivo);

        menuDepartamento.setForeground(new java.awt.Color(255, 255, 255));
        menuDepartamento.setText("Departamentos");
        menuDepartamento.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N

        itemAcademia.setBackground(new java.awt.Color(98, 17, 50));
        itemAcademia.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        itemAcademia.setForeground(new java.awt.Color(255, 255, 255));
        itemAcademia.setText("Academias");
        menuDepartamento.add(itemAcademia);

        itemProfesores.setBackground(new java.awt.Color(98, 17, 50));
        itemProfesores.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        itemProfesores.setForeground(new java.awt.Color(255, 255, 255));
        itemProfesores.setText("Docentes");
        menuDepartamento.add(itemProfesores);

        itemHorario.setBackground(new java.awt.Color(98, 17, 50));
        itemHorario.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        itemHorario.setForeground(new java.awt.Color(255, 255, 255));
        itemHorario.setText("Horarios");
        menuDepartamento.add(itemHorario);

        itemLaboratorios.setBackground(new java.awt.Color(98, 17, 50));
        itemLaboratorios.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        itemLaboratorios.setForeground(new java.awt.Color(255, 255, 255));
        itemLaboratorios.setText("Laboratorios");
        menuDepartamento.add(itemLaboratorios);

        itemMaterias.setBackground(new java.awt.Color(98, 17, 50));
        itemMaterias.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        itemMaterias.setForeground(new java.awt.Color(255, 255, 255));
        itemMaterias.setText("Materias");
        menuDepartamento.add(itemMaterias);

        jMenuBar1.add(menuDepartamento);

        menuAyuda.setForeground(new java.awt.Color(255, 255, 255));
        menuAyuda.setText("Ayuda");
        menuAyuda.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N

        itemAcercaDe.setBackground(new java.awt.Color(98, 17, 50));
        itemAcercaDe.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        itemAcercaDe.setForeground(new java.awt.Color(255, 255, 255));
        itemAcercaDe.setText("Acerca de");
        menuAyuda.add(itemAcercaDe);

        jMenuBar1.add(menuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem itemAcademia;
    public javax.swing.JMenuItem itemAcercaDe;
    public javax.swing.JMenuItem itemHorario;
    public javax.swing.JMenuItem itemLaboratorios;
    public javax.swing.JMenuItem itemMaterias;
    public javax.swing.JMenuItem itemProfesores;
    public javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JMenu menuArchivo;
    public javax.swing.JMenu menuAyuda;
    public javax.swing.JMenu menuDepartamento;
    // End of variables declaration//GEN-END:variables
}
