/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.client;

import application.client.ClientApplication;
import application.local.LocalApplication;
import client.personal.NewPersonalView;
import entity.Cliente;
import entity.Local;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import util.EntityState;
import util.EntityState.Clients;
import util.EntityState.Locals;
import util.InstanceFactory;
import util.Strings;

/**
 *
 * @author Alonso
 */
public class ClientView extends javax.swing.JInternalFrame implements MouseListener {
    ClientApplication clientApplication=InstanceFactory.Instance.getInstance("clientApplication", ClientApplication.class);
    LocalApplication localApplication=InstanceFactory.Instance.getInstance("localApplication", LocalApplication.class);
    ArrayList<Cliente> clients;
    public static ClientView clientView;
    /**
     * Creates new form ClientView
     */
    public ClientView() {
        initComponents();
        setupListeners();
        fillClientsTable();
        clientView = this;
        tblClients.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                btnDelete.setEnabled(true);
                btnLocal.setEnabled(true);
            }
        });
    }
    
    private void setupListeners() {
        addMouseListener(this);
        jScrollPane1.addMouseListener(this);
        tblClients.addMouseListener(this);
    }
    
    private void clearClientsTable(){
        DefaultTableModel model = (DefaultTableModel) tblClients.getModel();
        model.setRowCount(0);
    }
    
    public void fillClientsTable(){
        clearClientsTable();
        DefaultTableModel model = (DefaultTableModel) tblClients.getModel();
        clients = (ArrayList<Cliente>)clientApplication.queryAll();
        for(Cliente client : clients){
            model.addRow(new Object[]{
                client.getId(),
                client.getNombre(),
                client.getRuc(),
            });
        }
    }
    
    private void loadFromFile(String csvFile){
        BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
        try {
            Cliente client;
            Local local;
            br = new BufferedReader(new FileReader(csvFile));
            // Leo la cantidad de clientes que hay en el archivo
            line = br.readLine();
            String[] line_split = line.split(cvsSplitBy);
            int clientsNum = Integer.parseInt(line_split[0]);
            int localsNum;
            for(int i=0;i<clientsNum;i++){
                //Leo un cliente y lo inserto
                line = br.readLine();
                line_split = line.split(cvsSplitBy);
                
                client = new Cliente();
                client.setNombre(line_split[0]);
                client.setRuc(line_split[1]);
                client.setEstado(Clients.ACTIVO.ordinal());
                clientApplication.insert(client);
                
                //System.out.println(line_split[0]+" - "+line_split[1]+" - "+line_split[2]);
                //Leo sus locales y los inserto
                localsNum = Integer.parseInt(line_split[2]);
                for(int j=0;j<localsNum;j++){
                    line = br.readLine();
                    line_split = line.split(cvsSplitBy);
                    
                    local = new Local();
                    local.setLatitud(Double.parseDouble(line_split[0]));
                    local.setLongitud(Double.parseDouble(line_split[1]));
                    local.setNombre(line_split[2]);
                    local.setDescripcion(line_split[3]);
                    local.setDireccion(line_split[4]);
                    local.setCliente(client);
                    local.setEstado(Locals.ACTIVO.ordinal());
                    localApplication.insert(local);
                    
                    //System.out.println(line_split[0]+" - "+line_split[1]+" - "+line_split[2]+" - "+line_split[3]+" - "+line_split[4]);
                    
                }
            }
	} catch (FileNotFoundException e) {
            e.printStackTrace();
	} catch (IOException e) {
            e.printStackTrace();
	} finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally{
                    fillClientsTable();
                }
            }
	}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fileTextField = new javax.swing.JTextField();
        btnFile = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClients = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnLocal = new javax.swing.JButton();

        setClosable(true);
        setTitle("Clientes");

        jLabel1.setText("Ingresar Clientes desde un archivo:");

        fileTextField.setEditable(false);

        btnFile.setText("Seleccionar Archivo");
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });

        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tblClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Ruc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblClients);
        if (tblClients.getColumnModel().getColumnCount() > 0) {
            tblClients.getColumnModel().getColumn(0).setResizable(false);
            tblClients.getColumnModel().getColumn(1).setResizable(false);
            tblClients.getColumnModel().getColumn(2).setResizable(false);
        }

        btnDelete.setText("Eliminar");
        btnDelete.setEnabled(false);
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDeleteMousePressed(evt);
            }
        });

        btnLocal.setText("Ver locales");
        btnLocal.setEnabled(false);
        btnLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLocalMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFile, javax.swing.GroupLayout.PREFERRED_SIZE, 115, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(btnLocal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFile))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnDelete)
                    .addComponent(btnLocal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Seleccione un archivo");
        fc.showOpenDialog(this);
        File file = fc.getSelectedFile();
        if (!fc.getSelectedFile().getName().endsWith(".csv")) {
          JOptionPane.showMessageDialog(this, "El archivo seleccionado no es un archivo CSV.");
        }
        else{
            fileTextField.setText(file.getAbsolutePath());
            loadFromFile(file.getAbsolutePath());
        }
    }//GEN-LAST:event_btnFileActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        NewClientView newClientView = new NewClientView((JFrame)SwingUtilities.getWindowAncestor(this),true);
        newClientView.setVisible(true);   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnDeleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMousePressed
        System.out.println(tblClients.getSelectedRow());
        JOptionPane.setDefaultLocale(new Locale("es", "ES"));
        int response = JOptionPane.showConfirmDialog(this, Strings.MESSAGE_DELETE_CLIENT,Strings.MESSAGE_DELETE_CLIENT_TITLE,JOptionPane.WARNING_MESSAGE);
        if(JOptionPane.OK_OPTION == response){
            clientApplication.delete(clients.get(tblClients.getSelectedRow()).getId());
            fillClientsTable();
        }
        
    }//GEN-LAST:event_btnDeleteMousePressed

    private void btnLocalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLocalMousePressed
        //tblClients.getSelectedRow();
        //System.out.println(clients.get(tblClients.getSelectedRow()));
        Cliente client = clients.get(tblClients.getSelectedRow());
        LocalsView localsView = new LocalsView((JFrame)SwingUtilities.getWindowAncestor(this),true, client);
        localsView.setVisible(true);
    }//GEN-LAST:event_btnLocalMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFile;
    private javax.swing.JButton btnLocal;
    private javax.swing.JTextField fileTextField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClients;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }
}
