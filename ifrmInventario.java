/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author USUARIO
 */
public class ifrmInventario extends javax.swing.JInternalFrame {

    /**
     * Creates new form ifrmInventario
     */
    public ifrmInventario() {
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldatos = new javax.swing.JTable();
        btnimprimirpdf = new javax.swing.JButton();
        cbxcriterio = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        btncerrar = new javax.swing.JButton();
        btnmostrartodos = new javax.swing.JButton();
        txtparametro = new javax.swing.JTextField();
        lblCantidadRegistros = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("INVENTARIO");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbldatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbldatos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 740, 330));

        btnimprimirpdf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnimprimirpdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/print.jpg"))); // NOI18N
        btnimprimirpdf.setText("IMPRIMIR PDF");
        jPanel1.add(btnimprimirpdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, 40));

        cbxcriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "POR NOMBRE", "POR STOCK >=", "POR PRECIO >=", "POR TALLA" }));
        jPanel1.add(cbxcriterio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 180, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("INVENTARIO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("PARÁMETRO DE BÚSQUEDA:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("CRITERIO:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        btnbuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/buscar 1.png"))); // NOI18N
        btnbuscar.setText("BUSCAR");
        jPanel1.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, 40));

        btncerrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncerrar.setText("CERRAR");
        jPanel1.add(btncerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 500, -1, 20));

        btnmostrartodos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnmostrartodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/mostrar todos 1.png"))); // NOI18N
        btnmostrartodos.setText("MOSTRAR TODOS");
        jPanel1.add(btnmostrartodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 40));
        jPanel1.add(txtparametro, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 270, 40));

        lblCantidadRegistros.setText("jlabel");
        jPanel1.add(lblCantidadRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, 170, 20));

        jLabel2.setText("Ingrese un criterio y un parámetro de búsqueda");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 960, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnbuscar;
    public javax.swing.JButton btncerrar;
    public javax.swing.JButton btnimprimirpdf;
    public javax.swing.JButton btnmostrartodos;
    public javax.swing.JComboBox<String> cbxcriterio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblCantidadRegistros;
    public javax.swing.JTable tbldatos;
    public javax.swing.JTextField txtparametro;
    // End of variables declaration//GEN-END:variables
}