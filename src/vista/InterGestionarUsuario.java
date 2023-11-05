package vista;

import conexion.Conexion;
import controlador.Ctrl_Cliente;
import controlador.Ctrl_Usuario;
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
import modelo.Cliente;
import modelo.Usuario;

/**
 *
 * @author ediso
 */
public class InterGestionarUsuario extends javax.swing.JInternalFrame {

    private int idUsuario = 0;

    public InterGestionarUsuario() {
        initComponents();
        
        this.setTitle("Gestionar Usuarios- Sistema Biker");
        //Cargar tabla
        this.CargarTablaUsuarios();

          }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_usuarios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_password = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_usuario = new javax.swing.JTextField();
        jButton_eliminar = new javax.swing.JButton();
        jButton_actualizar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menú - Administrador de Usuarios");
        jPanel2.add(jLabel1);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 30));

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
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 120, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_usuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_usuarios.setEnabled(false);
        jTable_usuarios.setFillsViewportHeight(true);
        jTable_usuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable_usuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 270));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombres:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 90, -1));

        txt_nombre.setBackground(new java.awt.Color(0, 102, 102));
        txt_nombre.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 180, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 90, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Apellido:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 90, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Telefono:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 90, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Usuario:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 90, -1));

        txt_password.setBackground(new java.awt.Color(0, 102, 102));
        txt_password.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 130, -1));

        txt_apellido.setBackground(new java.awt.Color(0, 102, 102));
        txt_apellido.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        txt_apellido.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 180, -1));

        txt_telefono.setBackground(new java.awt.Color(0, 102, 102));
        txt_telefono.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 330, 100, -1));

        txt_usuario.setBackground(new java.awt.Color(0, 102, 102));
        txt_usuario.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        txt_usuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 130, -1));

        jButton_eliminar.setBackground(new java.awt.Color(0, 102, 102));
        jButton_eliminar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jButton_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Eliminar.png"))); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 120, 50));

        jButton_actualizar.setBackground(new java.awt.Color(0, 102, 102));
        jButton_actualizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jButton_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Guardar.png"))); // NOI18N
        jButton_actualizar.setText("Guardar");
        jButton_actualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 120, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo4.jpg"))); // NOI18N
        jLabel7.setText(" ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 890, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        Usuario usuario = new Usuario();
        Ctrl_Usuario controlUsuario = new Ctrl_Usuario();

        if (idUsuario == 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un Usuario!");
        } else {
            if (txt_nombre.getText().isEmpty() || txt_apellido.getText().isEmpty() || txt_usuario.getText().isEmpty()
                    || txt_password.getText().isEmpty() || txt_telefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "¡Completa todos los campos!");

            } else {
                usuario.setNombre(txt_nombre.getText().trim());
                usuario.setApellido(txt_apellido.getText().trim());
                usuario.setUsuario(txt_usuario.getText().trim());
                usuario.setPassword(txt_password.getText().trim());
                usuario.setTelefono(txt_telefono.getText().trim());
                usuario.setEstado("Activo");
                
                if(controlUsuario.actualizar(usuario, idUsuario)){
                    JOptionPane.showMessageDialog(null, "¡Actualizacion Exitosa!");
                    this.Limpiar();
                    this.CargarTablaUsuarios();
                    idUsuario = 0;
                    
                }else{
                    JOptionPane.showMessageDialog(null, "¡Error al Actualizar usuario!");
                }
            }
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed

        Ctrl_Usuario controlUsuario = new Ctrl_Usuario();
        if (idUsuario == 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un usuario!");
        } else {
            if (!controlUsuario.eliminar(idUsuario)) {
                JOptionPane.showMessageDialog(null, "¡Usuario Eliminado!");
                this.CargarTablaUsuarios();
                this.Limpiar();
                idUsuario = 0;
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al eliminar usuario!");
                this.Limpiar();
            }
        }
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_usuarios;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables

    /*
     * *****************************************************
     * metodo para limpiar
     * *****************************************************
     */
    private void Limpiar() {
        txt_nombre.setText("");
        txt_password.setText("");
        txt_apellido.setText("");
        txt_telefono.setText("");
        txt_usuario.setText("");
    }


    /*
     * *****************************************************
     * metodo para mostrar todos los clientes registrados
     * *****************************************************
     */
    private void CargarTablaUsuarios() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select * from USUARIOS";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarUsuario.jTable_usuarios = new JTable(model);
            InterGestionarUsuario.jScrollPane1.setViewportView(InterGestionarUsuario.jTable_usuarios);

            model.addColumn("N°");//ID
            model.addColumn("NOMBRES");
            model.addColumn("APELLIDOS");
            model.addColumn("USUARIOS");
            model.addColumn("PASSWORD");
            model.addColumn("TELEFONO");
            model.addColumn("ESTADO");

            while (rs.next()) {
                Object fila[] = new Object[7];
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla usuarios: " + e);
        }
        //evento para obtener campo al cual el usuario da click
        //y obtener la interfaz que mostrara la informacion general
        jTable_usuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_usuarios.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idUsuario = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosUsuarioSeleccionado(idUsuario);//metodo
                }
            }
        });
    }


    /*
     * **************************************************
     * Metodo que envia datos seleccionados
     * **************************************************
     */
    private void EnviarDatosUsuarioSeleccionado(int idUsuario) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select * from USUARIOS where ID_USUARIO = '" + idUsuario + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txt_nombre.setText(rs.getString("NOMBRES"));
                txt_apellido.setText(rs.getString("APELLIDOS"));
                txt_usuario.setText(rs.getString("USUARIOS"));
                txt_password.setText(rs.getString("PASSWORD"));
                txt_telefono.setText(rs.getString("TELEFONO"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar usuario: " + e);
        }
    }

}