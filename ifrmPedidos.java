/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author Lenovo
 */
public class ifrmPedidos extends javax.swing.JInternalFrame {

    /**
     * Creates new form ifrmPedidos
     */
    public ifrmPedidos() {
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
        txtmonto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnactualizar = new javax.swing.JButton();
        btnimprimirpdf = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldatos = new javax.swing.JTable();
        btnconsultar = new javax.swing.JButton();
        btnregistrar = new javax.swing.JButton();
        btncerrar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        lblCantidadRegistros = new javax.swing.JLabel();
        txtidpedido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dchfecha = new com.toedter.calendar.JDateChooser();
        cbxempleado = new javax.swing.JComboBox<>();
        cbxproducto = new javax.swing.JComboBox<>();
        cbxcliente = new javax.swing.JComboBox<>();
        txtcantidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnprocesar = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("PEDIDOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("NOMBRE CLIENTE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("ID VENTA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));
        jPanel1.add(txtmonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 190, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("NOMBRE EMPLEADO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("MONTO TOTAL:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, -1, -1));

        btnactualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/actualizar 1.png"))); // NOI18N
        btnactualizar.setText("ACTUALIZAR");
        jPanel1.add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 120, 40));

        btnimprimirpdf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnimprimirpdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/print.jpg"))); // NOI18N
        btnimprimirpdf.setText("IMPRIMIR PDF");
        btnimprimirpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirpdfActionPerformed(evt);
            }
        });
        jPanel1.add(btnimprimirpdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 130, 40));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 660, 410));

        btnconsultar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnconsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/consultar 1.png"))); // NOI18N
        btnconsultar.setText("CONSULTAR");
        jPanel1.add(btnconsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 120, 40));

        btnregistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/registrar 1.png"))); // NOI18N
        btnregistrar.setText("REGISTRAR");
        jPanel1.add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 120, 40));

        btncerrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncerrar.setText("CERRAR");
        btncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btncerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 470, -1, 20));

        btneliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/eliminar 1.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 120, 40));

        lblCantidadRegistros.setText("jLabel8");
        jPanel1.add(lblCantidadRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, -1, -1));
        jPanel1.add(txtidpedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 190, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("CANTIDAD PRODUCTO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));

        dchfecha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FECHA DE VENCIMIENTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.add(dchfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 200, 60));

        cbxempleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 190, 30));

        cbxproducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 190, 30));

        cbxcliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 190, 30));
        jPanel1.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 190, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("NOMBRE PRODUCTO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        btnprocesar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnprocesar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/registrar 1.png"))); // NOI18N
        btnprocesar.setText("PROCESAR");
        btnprocesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocesarActionPerformed(evt);
            }
        });
        jPanel1.add(btnprocesar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1070, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnimprimirpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirpdfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnimprimirpdfActionPerformed

    private void btncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncerrarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnprocesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocesarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnprocesarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnactualizar;
    public javax.swing.JButton btncerrar;
    public javax.swing.JButton btnconsultar;
    public javax.swing.JButton btneliminar;
    public javax.swing.JButton btnimprimirpdf;
    public javax.swing.JButton btnprocesar;
    public javax.swing.JButton btnregistrar;
    public javax.swing.JComboBox<String> cbxcliente;
    public javax.swing.JComboBox<String> cbxempleado;
    public javax.swing.JComboBox<String> cbxproducto;
    public com.toedter.calendar.JDateChooser dchfecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblCantidadRegistros;
    public javax.swing.JTable tbldatos;
    public javax.swing.JTextField txtcantidad;
    public javax.swing.JTextField txtidpedido;
    public javax.swing.JTextField txtmonto;
    // End of variables declaration//GEN-END:variables
}
