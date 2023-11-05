package vista;

import conexion.Conexion;
import controlador.Ctrl_RegistrarVenta;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.CabeceraVenta;

/**
 *
 * @author ediso
 */
public class InterGestionarVentas extends javax.swing.JInternalFrame {

    private int idCliente = 0;
    private int idVenta;

    public InterGestionarVentas() {
        initComponents();
        
        this.setTitle("Gestionar Ventas - Sistema Biker");
        //Cargar tabla
        this.CargarComboClientes();
        this.CargarTablaVentas();

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ventas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton_actualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_total_pagar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        jComboBox_cliente = new javax.swing.JComboBox<>();
        jComboBox_estado = new javax.swing.JComboBox<>();
        btnAtras = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_ventas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_ventas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 270));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menú - Administrador de Ventas");
        jPanel4.add(jLabel1);

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 30));

        jButton_actualizar.setBackground(new java.awt.Color(0, 102, 102));
        jButton_actualizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jButton_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Guardar.png"))); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, -1, 50));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Total Pagar:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 100, -1));

        txt_total_pagar.setBackground(new java.awt.Color(0, 102, 102));
        txt_total_pagar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        txt_total_pagar.setForeground(new java.awt.Color(255, 255, 255));
        txt_total_pagar.setEnabled(false);
        getContentPane().add(txt_total_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 170, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 50, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cliente:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 70, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Estado:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 90, -1));

        txt_fecha.setBackground(new java.awt.Color(0, 102, 102));
        txt_fecha.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        txt_fecha.setForeground(new java.awt.Color(255, 255, 255));
        txt_fecha.setEnabled(false);
        getContentPane().add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 120, -1));

        jComboBox_cliente.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox_cliente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jComboBox_cliente.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 170, -1));

        jComboBox_estado.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox_estado.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jComboBox_estado.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(jComboBox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 170, -1));

        btnAtras.setBackground(new java.awt.Color(0, 102, 102));
        btnAtras.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Atras.png"))); // NOI18N
        btnAtras.setText("Atrás");
        btnAtras.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 130, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo4.jpg"))); // NOI18N
        jLabel7.setText(" ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 890, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed

        CabeceraVenta cabeceraVenta = new CabeceraVenta();
        Ctrl_RegistrarVenta controlRegistrarVenta = new Ctrl_RegistrarVenta();
        String cliente, estado;
        cliente = jComboBox_cliente.getSelectedItem().toString().trim();
        estado = jComboBox_estado.getSelectedItem().toString().trim();

        //obtener el id del cliente
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select ID_CLIENTE, concat(NOMBRES, ' ', APELLIDOS) as cliente "
                    + "from CLIENTES where concat(NOMBRES, ' ', APELLIDOS) = '" + cliente + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                idCliente = rs.getInt("ID_CLIENTE");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error en cargar el id cliente: " + e);
        }

        //Actualizar datos
        if (!cliente.equalsIgnoreCase("Seleccione cliente:")) {
            cabeceraVenta.setIdCliente(idCliente);
            if (estado.equalsIgnoreCase("Activo")) {
                cabeceraVenta.setEstado(1);
            } else {
                cabeceraVenta.setEstado(0);
            }

            if (controlRegistrarVenta.actualizar(cabeceraVenta, idVenta)) {
                JOptionPane.showMessageDialog(null, "¡Registro Actualizado!");
                this.CargarTablaVentas();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro para actualizar datos");
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JComboBox<String> jComboBox_cliente;
    private javax.swing.JComboBox<String> jComboBox_estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_ventas;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables

    /*
     * *****************************************************
     * metodo para limpiar
     * *****************************************************
     */
    private void Limpiar() {
        this.txt_total_pagar.setText("");
        this.txt_fecha.setText("");
        this.jComboBox_cliente.setSelectedItem("Seleccione cliente:");
        this.jComboBox_estado.setSelectedItem("Activo");
        idCliente = 0;
    }


    /*
     * *****************************************************
     * metodo para mostrar todos los clientes registrados
     * *****************************************************
     */
    private void CargarTablaVentas() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT cv.ID_CAB_VENTA AS id, CONCAT(c.NOMBRES, ' ', c.APELLIDOS) AS cliente, cv.VALOR_A_PAGAR AS total, cv.FECH_VENTA AS fecha, cv.ESTADO FROM CAB_VENTAS AS cv INNER JOIN CLIENTES AS c ON cv.ID_CLIENTE = c.ID_CLIENTE;";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarVentas.jTable_ventas = new JTable(model);
            InterGestionarVentas.jScrollPane1.setViewportView(InterGestionarVentas.jTable_ventas);

            model.addColumn("N°");//ID
            model.addColumn("Cliente");
            model.addColumn("Total Pagar");
            model.addColumn("Fecha Venta");
            model.addColumn("estado");

            while (rs.next()) {
                Object fila[] = new Object[5];
                for (int i = 0; i < 5; i++) {
                    if (i == 4) {
                        String estado = String.valueOf(rs.getObject(i + 1));
                        if (estado.equalsIgnoreCase("1")) {
                            fila[i] = "Activo";
                        } else {
                            fila[i] = "Inactivo";
                        }
                    } else {
                        fila[i] = rs.getObject(i + 1);
                    }
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla de ventas: " + e);
        }
        //evento para obtener campo al cual el usuario da click
        //y obtener la interfaz que mostrara la informacion general
        jTable_ventas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_ventas.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idVenta = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosVentaSeleccionada(idVenta);//metodo
                }
            }
        });
    }


    /*
     * **************************************************
     * Metodo que envia datos seleccionados
     * **************************************************
     */
    private void EnviarDatosVentaSeleccionada(int idVenta) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT cv.ID_CAB_VENTA, cv.ID_CLIENTE, CONCAT(c.NOMBRES, ' ', c.APELLIDOS) AS cliente, cv.VALOR_A_PAGAR, cv.FECH_VENTA, cv.ESTADO FROM CAB_VENTAS cv INNER JOIN CLIENTES c ON cv.ID_CLIENTE = c.ID_CLIENTE WHERE cv.ID_CAB_VENTA = '" + idVenta + "';");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jComboBox_cliente.setSelectedItem(rs.getString("CLIENTE"));
                txt_total_pagar.setText(rs.getString("VALOR_A_PAGAR"));
                txt_fecha.setText(rs.getString("FECH_VENTA"));
                int estado = rs.getInt("ESTADO");
                if (estado == 1) {
                    jComboBox_estado.setSelectedItem("Activo");
                } else {
                    jComboBox_estado.setSelectedItem("Inactivo");
                }
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar venta: " + e);
        }
    }

    /*
    Metodo para cargar los clientes en el jComboBox
     */
    private void CargarComboClientes() {
        Connection cn = Conexion.conectar();
        String sql = "select * from CLIENTES";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_cliente.removeAllItems();
            jComboBox_cliente.addItem("Seleccione cliente:");
            while (rs.next()) {
                jComboBox_cliente.addItem(rs.getString("NOMBRES") + " " + rs.getString("APELLIDOS"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al cargar clientes, !" + e);
        }
    }

}