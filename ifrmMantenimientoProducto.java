/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author USUARIO
 */
public class ifrmMantenimientoProducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form ifrmRegistrarColor
     */
    public ifrmMantenimientoProducto() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtidproducto = new javax.swing.JTextField();
        btncerrar = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxmaterial = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbxtalla = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtstock = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbxcategoria = new javax.swing.JComboBox<>();
        txtprecio = new javax.swing.JTextField();
        cbxcolor = new javax.swing.JComboBox<>();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldatos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        btnconsultar = new javax.swing.JButton();
        lblCantidadRegistros = new javax.swing.JLabel();
        btnimprimirpdf = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("MANTENIMIENTO PRODUCTO");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("MANTENIMIENTO PRODUCTO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("MATERIAL:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("ID PRODUCTO:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        jPanel1.add(txtidproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, 30));

        btncerrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncerrar.setText("CERRAR");
        jPanel1.add(btncerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 430, -1, 20));
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 180, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("DESCRIPCION");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("CATEGORIA:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        cbxmaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxmaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 190, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("COLOR:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        cbxtalla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxtalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 190, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("TALLA:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, -1, -1));
        jPanel1.add(txtstock, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 190, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("STOCK:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("PRECIO:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, -1));

        cbxcategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxcategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 190, 40));
        jPanel1.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 190, 30));

        cbxcolor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxcolor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 190, 40));

        btnactualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/actualizar 1.png"))); // NOI18N
        btnactualizar.setText("ACTUALIZAR");
        jPanel1.add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 120, 40));

        btneliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/eliminar 1.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 120, 40));

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
        jScrollPane1.setViewportView(tbldatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 640, 360));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("NOMBRE:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));
        jPanel1.add(txtdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 180, 30));

        btnconsultar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnconsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/consultar 1.png"))); // NOI18N
        btnconsultar.setText("CONSULTAR");
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });
        jPanel1.add(btnconsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 120, 40));

        lblCantidadRegistros.setText("jLabel5");
        jPanel1.add(lblCantidadRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, 100, 30));

        btnimprimirpdf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnimprimirpdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/print.jpg"))); // NOI18N
        btnimprimirpdf.setText("IMPRIMIR PDF");
        btnimprimirpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirpdfActionPerformed(evt);
            }
        });
        jPanel1.add(btnimprimirpdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 130, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btnimprimirpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirpdfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnimprimirpdfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnactualizar;
    public javax.swing.JButton btncerrar;
    public javax.swing.JButton btnconsultar;
    public javax.swing.JButton btneliminar;
    public javax.swing.JButton btnimprimirpdf;
    public javax.swing.JComboBox<String> cbxcategoria;
    public javax.swing.JComboBox<String> cbxcolor;
    public javax.swing.JComboBox<String> cbxmaterial;
    public javax.swing.JComboBox<String> cbxtalla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblCantidadRegistros;
    public javax.swing.JTable tbldatos;
    public javax.swing.JTextField txtdescripcion;
    public javax.swing.JTextField txtidproducto;
    public javax.swing.JTextField txtnombre;
    public javax.swing.JTextField txtprecio;
    public javax.swing.JTextField txtstock;
    // End of variables declaration//GEN-END:variables
}
