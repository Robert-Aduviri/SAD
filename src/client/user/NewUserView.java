/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.user;

import application.profile.ProfileApplication;
import application.user.UserApplication;
import entity.Usuario;
import java.util.UUID;
import javax.swing.JOptionPane;
import util.EntityState;
import util.EntityType;
import util.InstanceFactory;
import util.Strings;
import util.Tools;

/**
 *
 * @author Nevermade
 */
public class NewUserView extends javax.swing.JDialog {
    UserApplication userApplication=InstanceFactory.Instance.getInstance("userApplication", UserApplication.class);
    ProfileApplication profileApplication=InstanceFactory.Instance.getInstance("profileApplication", ProfileApplication.class);
    /**
     * Creates new form NewUser
     */
    public NewUserView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();       
        //initialize user states combo
        stateCombo.setModel(new javax.swing.DefaultComboBoxModel(EntityState.getUsersState()));
        profileCombo.setModel(new javax.swing.DefaultComboBoxModel(EntityType.PROFILES_NAMES));
    }  
    public void clearFields(){
        nameTxt.setText("");
        firstNameTxt.setText("");
        secondNameTxt.setText("");
        emailTxt.setText("");      
        stateCombo.setSelectedIndex(0);
        passwordTxt.setText(""); 
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
        secondNameTxt = new javax.swing.JTextField();
        profileCombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        stateCombo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        autoGeneratePassBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        saveTxt = new javax.swing.JButton();
        nameTxt = new javax.swing.JTextField();
        cancelBtn = new javax.swing.JButton();
        firstNameTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Usuario");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del usuario"));

        profileCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Correo:");

        stateCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Estado:");

        jLabel6.setText("Contraseña:");

        jLabel1.setText("Nombres:");

        jLabel2.setText("Apellido Paterno:");

        autoGeneratePassBtn.setText("Generar");
        autoGeneratePassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoGeneratePassBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Apellido Materno:");

        saveTxt.setText("Guardar");
        saveTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTxtActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancelar");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Perfil:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(saveTxt)
                        .addGap(33, 33, 33)
                        .addComponent(cancelBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(passwordTxt)
                                .addGap(18, 18, 18)
                                .addComponent(autoGeneratePassBtn))
                            .addComponent(emailTxt)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(stateCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameTxt)
                                    .addComponent(secondNameTxt)
                                    .addComponent(firstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(profileCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(firstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(secondNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autoGeneratePassBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stateCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(profileCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveTxt)
                    .addComponent(cancelBtn))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        UserView.userView.refreshGrid();
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void saveTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTxtActionPerformed
        // TODO add your handling code here:
        Usuario user=new Usuario();
        user.setIdusuario(UUID.randomUUID().toString().replace("-", ""));
        user.setNombre(nameTxt.getText());
        user.setApellidoPaterno(firstNameTxt.getText());
        user.setApellidoMaterno(secondNameTxt.getText());
        user.setCorreo(emailTxt.getText());      
        user.setEstado(stateCombo.getSelectedIndex());
        user.setPassword(passwordTxt.getText());
        user.setPerfil(profileApplication.getProfileInstance(profileCombo.getSelectedItem().toString()));
        userApplication.createUser(user);
        JOptionPane.showMessageDialog(this, Strings.MESSAGE_NEW_USER_CREATED);
        clearFields();
    }//GEN-LAST:event_saveTxtActionPerformed
    
    private void autoGeneratePassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoGeneratePassBtnActionPerformed
        // TODO add your handling code here:
        passwordTxt.setText(Tools.generatePassword(10));
    }//GEN-LAST:event_autoGeneratePassBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton autoGeneratePassBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField firstNameTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField passwordTxt;
    private javax.swing.JComboBox profileCombo;
    private javax.swing.JButton saveTxt;
    private javax.swing.JTextField secondNameTxt;
    private javax.swing.JComboBox stateCombo;
    // End of variables declaration//GEN-END:variables
}
