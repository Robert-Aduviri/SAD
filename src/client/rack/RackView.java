/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.rack;

import client.warehouse.*;
import application.condition.ConditionApplication;
import application.rack.RackApplication;
import application.spot.SpotApplication;
import application.warehouse.WarehouseApplication;
import entity.Almacen;
import entity.Condicion;
import entity.Ubicacion;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import util.EntityState;
import util.EntityType;
import util.InstanceFactory;

/**
 *
 * @author LUIS
 */
public class RackView extends javax.swing.JInternalFrame {
    WarehouseApplication warehouseApplication=InstanceFactory.Instance.getInstance("warehouseApplication", WarehouseApplication.class);
    ConditionApplication conditionApplication=InstanceFactory.Instance.getInstance("conditionApplication", ConditionApplication.class);
    RackApplication rackApplication=InstanceFactory.Instance.getInstance("rackApplication", RackApplication.class);
    SpotApplication spotApplication=InstanceFactory.Instance.getInstance("spotApplication", SpotApplication.class);
    /**
     * Creates new form WarehouseForm
     */
    
    int idRack;
    public RackView() {
        initComponents();
        clearGrid();
        //fillTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) usersGrid.getModel();
        ArrayList<Almacen> warehouses = warehouseApplication.queryAll();
        for (Almacen a : warehouses) {
            
            Condicion con = EntityType.getCondition(a.getCondicion().getId());
            model.addRow(new Object[]{
                a.getId().toString(),
                a.getDescripcion(),
                a.getCapacidad().toString(),
                con.getNombre(),
                a.getEstado().toString()
            });
        }

    }
    public void fillTable(int id) {
        DefaultTableModel model = (DefaultTableModel) usersGrid.getModel();
        ArrayList<Ubicacion> ubicaciones = spotApplication.querySpotsByRack(id);

        for (Ubicacion u : ubicaciones) {
            String estado = "Desconocido";
            if (u.getEstado()==0) estado= "Inactivo";
            else
                if (u.getEstado()==1) estado= "Libre";
            else
                    if (u.getEstado()==2) estado= "Ocupado";
            model.addRow(new Object[]{
                Integer.toString(u.getId()),
                u.getFila().toString(),
                u.getColumna().toString(),
                u.getLado(),
                estado
            });
            
        }

    }
    
    public void clearGrid() {
        DefaultTableModel model = (DefaultTableModel) usersGrid.getModel();
        model.setRowCount(0);
    }
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        activoBtn = new javax.swing.JButton();
        inactivoBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        WarehouseGrid = new javax.swing.JScrollPane();
        usersGrid = new javax.swing.JTable();
        almacenTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Rack");

        activoBtn.setText("Activo");
        activoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activoBtnActionPerformed(evt);
            }
        });

        inactivoBtn.setText("Inactivo");
        inactivoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inactivoBtnMouseClicked(evt);
            }
        });
        inactivoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactivoBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Rack:");

        jLabel2.setText("Almacen:");

        searchBtn.setText("Buscar");
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked(evt);
            }
        });

        usersGrid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Fila", "Columna", "Lado", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        WarehouseGrid.setViewportView(usersGrid);
        if (usersGrid.getColumnModel().getColumnCount() > 0) {
            usersGrid.getColumnModel().getColumn(0).setResizable(false);
            usersGrid.getColumnModel().getColumn(1).setResizable(false);
            usersGrid.getColumnModel().getColumn(2).setResizable(false);
            usersGrid.getColumnModel().getColumn(3).setResizable(false);
            usersGrid.getColumnModel().getColumn(4).setResizable(false);
        }

        almacenTxt.setEnabled(false);

        jLabel4.setText("Ubicaciones:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(WarehouseGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(almacenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(activoBtn)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchBtn)
                                    .addComponent(inactivoBtn))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(almacenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(activoBtn)
                        .addComponent(inactivoBtn))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(WarehouseGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void activoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activoBtnActionPerformed
        // TODO add your handling code here:
        int sr = usersGrid.getSelectedRow();
        String idString = usersGrid.getModel().getValueAt(sr, 0).toString();
        int idSpot = Integer.parseInt(idString);
        spotApplication.updateSpotOccupancy(idSpot,EntityState.Spots.LIBRE.ordinal());
       
        clearGrid();
        fillTable(idRack);        
        
    }//GEN-LAST:event_activoBtnActionPerformed

    private void inactivoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inactivoBtnMouseClicked
        // TODO add your handling code here:
        int sr = usersGrid.getSelectedRow();
        String idString = usersGrid.getModel().getValueAt(sr, 0).toString();
        int idSpot = Integer.parseInt(idString);
        spotApplication.updateSpotOccupancy(idSpot,EntityState.Spots.INACTIVO.ordinal());
       
        clearGrid();
        fillTable(idRack);    
    }//GEN-LAST:event_inactivoBtnMouseClicked

    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        // TODO add your handling code here:
        clearGrid();
        int idS;
        if (idTxt.getText().equals(""))
            idS=0;
        else idS=Integer.parseInt(idTxt.getText());
        idRack=idS;
        fillTable(idS);
        almacenTxt.setText(rackApplication.queryById(idS).getAlmacen().getId().toString());
    }//GEN-LAST:event_searchBtnMouseClicked

    private void inactivoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inactivoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inactivoBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane WarehouseGrid;
    private javax.swing.JButton activoBtn;
    private javax.swing.JTextField almacenTxt;
    private javax.swing.JTextField idTxt;
    private javax.swing.JButton inactivoBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTable usersGrid;
    // End of variables declaration//GEN-END:variables
}
