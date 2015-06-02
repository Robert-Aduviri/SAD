/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.delivery;

import algorithm.AlgorithmExecution;
import algorithm.Solution;
import client.delivery.GoogleMaps;
import client.base.BaseView;
import util.Icons;

/**
 *
 * @author alulab14
 */
public class DeliveryView extends BaseView {
    private Solution solution = null;
    private AlgorithmExecution algorithmExecution = null;
    
    /**
     * Creates new form DispatchView
     */
    public DeliveryView() {        
        initComponents();
        super.initialize();
        Icons.setButton(btnProcess, Icons.ICONOS.APPLY.ordinal());
        Icons.setButton(btnExecuteAlgorithm, Icons.ICONOS.PLAY.ordinal());
        Icons.setButton(btnViewSolution, Icons.ICONOS.DELIVERY.ordinal());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProcess = new javax.swing.JButton();
        btnExecuteAlgorithm = new javax.swing.JButton();
        btnViewSolution = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtHours = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMinutes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);

        btnProcess.setText("Escoger Solución");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        btnExecuteAlgorithm.setText("Ejecutar Algoritmo");
        btnExecuteAlgorithm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecuteAlgorithmActionPerformed(evt);
            }
        });

        btnViewSolution.setText("Ver Solución");
        btnViewSolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSolutionActionPerformed(evt);
            }
        });

        jLabel1.setText("Tiempo máximo por ruta:");

        jLabel2.setText("horas");

        jLabel3.setText("minutos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnProcess)
                        .addGap(18, 18, 18)
                        .addComponent(btnExecuteAlgorithm)
                        .addGap(18, 18, 18)
                        .addComponent(btnViewSolution))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtHours, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProcess)
                    .addComponent(btnExecuteAlgorithm)
                    .addComponent(btnViewSolution))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        if(solution!=null && algorithmExecution!=null){
            algorithmExecution.processOrders(solution);
        }
    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnViewSolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSolutionActionPerformed
        if(solution!=null){
            GoogleMaps googleMaps = new GoogleMaps(solution);
        }
    }//GEN-LAST:event_btnViewSolutionActionPerformed

    private void btnExecuteAlgorithmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecuteAlgorithmActionPerformed
        algorithmExecution = new AlgorithmExecution();
        solution = algorithmExecution.start(60);
        /*try{
            double hours, minutes;
            if(txtHours.getText().isEmpty()) hours = 0;
            if(txtMinutes.getText().isEmpty()) minutes = 0;
            hours = Double.parseDouble(txtHours.getText());
            minutes = Double.parseDouble(txtMinutes.getText());
            solution = algorithmExecution.start(hours + minutes/60);
        }catch(Exception ex){
            ex.printStackTrace();
            //show message box
        } */       
    }//GEN-LAST:event_btnExecuteAlgorithmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExecuteAlgorithm;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnViewSolution;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtHours;
    private javax.swing.JTextField txtMinutes;
    // End of variables declaration//GEN-END:variables
}
