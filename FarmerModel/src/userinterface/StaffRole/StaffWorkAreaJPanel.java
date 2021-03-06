
package userinterface.StaffRole;

import userinterface.CustomerRole.*;
import Business.EcoSystem;
import Business.Enterprise.*;
import Business.Enterprise.USFDEnterprise;
import Business.Network.Network;
import Business.Organization.*;
import Business.Produce.Produce;
import Business.Produce.ProduceDirectory;
import Business.ProduceReview.ProduceReview;
import Business.ProduceReview.ProduceReviewDirectory;
import Business.RawMaterialReview.RawMaterialReview;
import Business.RawMaterialReview.RawMaterialReviewDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import sun.applet.AppletViewer;
import static userinterface.WarehouseManagerRole.WarehouseWorkAreaJPanel.flag;

/**
 *
 * @author Ajay Mohandas
 */
public class StaffWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private StaffOrganization organization;
    private USFDEnterprise enterprise;
    private UserAccount userAccount;
    private ProduceDirectory produceDirectory;
    private ProduceReviewDirectory prDirectory;
    private RawMaterialReviewDirectory rmrDirectory;
    

    /**
     * Creates new form StaffWorkAreaJPanel
     */
    private EcoSystem business;
 
    public StaffWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, StaffOrganization organization, Enterprise enterprise,EcoSystem business,ProduceDirectory produceDirectory,ProduceReviewDirectory prDirectory,RawMaterialReviewDirectory rmrDirectory ) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = (USFDEnterprise)enterprise;
        this.userAccount = account;
        this.business = business;
        this.produceDirectory = produceDirectory;
        this.prDirectory = prDirectory;
        this.rmrDirectory = rmrDirectory;
        
        valueLabel.setText(enterprise.getName());
        populateCustomerRequestTable();
        populateProduceTable();
        populateCustomerReviewTable();
        populateSupplierReviewTable();
       if (flag == true)
        {  
            sendToFarmerJButton.setEnabled(true);
            sendToWarehouseJButton.setEnabled(false);
            flag = false;
        }
        

    }
    
     public void populateSupplierReviewTable(){
        DefaultTableModel model = (DefaultTableModel)supplierReviewTable.getModel();
        
        model.setRowCount(0);
        
        for(RawMaterialReview review : rmrDirectory.getRawMaterialReviewList()){
            Object[] row = new Object[6];
            row[0] = review;
            row[1] = review.getSupplierName();
            row[2] = review.getProduceQuality();
            row[3] = review.getProduceShelfLife();
            row[4] = review.getAdditionalReviews();
            
            model.addRow(row);
        }
        
    }

    
    public void populateCustomerReviewTable(){
        DefaultTableModel model = (DefaultTableModel)customerReviewTable.getModel();
        
        model.setRowCount(0);
        
        for(ProduceReview review : prDirectory.getProduceReviewList()){
            Object[] row = new Object[6];
            row[0] = review;
            row[1] = review.getFarmerName();
            row[2] = review.getProduceQuality();
            row[3] = review.getProduceShelfLife();
            row[4] = review.getAdditionalReviews();
            
            model.addRow(row);
        }
        
    }

    public void populateCustomerRequestTable(){
     DefaultTableModel model = (DefaultTableModel)workRequestJTable1.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            row[4] = request.getCropQty();
            row[5] = request.getRawMaterialQty();
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        supplierReviewTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        customerReviewTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lineBtn = new javax.swing.JButton();
        barBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        produceTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        sendToFarmerJButton = new javax.swing.JButton();
        sendToWarehouseJButton = new javax.swing.JButton();
        sendToSupp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        customerReviewTable1 = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        supplierReviewTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        supplierReviewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Raw Material", "Supplier Name", "Quality Review", "Shelf Life Review", "Additional Review"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(supplierReviewTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 574, 730, 90));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Customer Reviews");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 691, -1, -1));

        customerReviewTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        customerReviewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Crop Name", "Farmer Name", "Quality Review", "Shelf Life Review", "Additional Review"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(customerReviewTable);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 720, 730, 100));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Farmer Reviews");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 546, -1, -1));

        lineBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lineBtn.setText("Line Chart");
        lineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineBtnActionPerformed(evt);
            }
        });
        jPanel1.add(lineBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(836, 446, -1, -1));

        barBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        barBtn.setText("Bar Chart");
        barBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barBtnActionPerformed(evt);
            }
        });
        jPanel1.add(barBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(836, 493, 113, -1));

        workRequestJTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        workRequestJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Sender", "Receiver", "Status", "Crop Quantity", "Raw Material Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                workRequestJTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(workRequestJTable1);
        if (workRequestJTable1.getColumnModel().getColumnCount() > 0) {
            workRequestJTable1.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable1.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable1.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable1.getColumnModel().getColumn(3).setResizable(false);
            workRequestJTable1.getColumnModel().getColumn(4).setResizable(false);
            workRequestJTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 174, 969, 96));

        produceTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        produceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Crop Name", "Quantity", "Price", "Farmer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(produceTable);
        if (produceTable.getColumnModel().getColumnCount() > 0) {
            produceTable.getColumnModel().getColumn(0).setResizable(false);
            produceTable.getColumnModel().getColumn(1).setResizable(false);
            produceTable.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 399, 730, 110));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Produce Inventory");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 370, -1, -1));

        sendToFarmerJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sendToFarmerJButton.setText("Send to Farmer");
        sendToFarmerJButton.setEnabled(false);
        sendToFarmerJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToFarmerJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(sendToFarmerJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 283, 225, -1));

        sendToWarehouseJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sendToWarehouseJButton.setText("Send to Warehouse Manager");
        sendToWarehouseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToWarehouseJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(sendToWarehouseJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(662, 283, -1, -1));

        sendToSupp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sendToSupp.setText("Send to Supplier");
        sendToSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToSuppActionPerformed(evt);
            }
        });
        jPanel1.add(sendToSupp, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 283, 199, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Customer/Farmer Requests");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 145, -1, -1));
        jPanel1.add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 105, 158, 26));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        jPanel1.add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 105, 127, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Groups-Meeting-Light-icon.png"))); // NOI18N
        jLabel6.setText("Staff");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 13, 248, 61));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Crop Demand");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(836, 417, 113, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1210, 820));

        customerReviewTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Crop Name", "Farmer Name", "Quality Review", "Shelf Life Review", "Additional Review"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(customerReviewTable1);

        add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 730, 210));
    }// </editor-fold>//GEN-END:initComponents

    private void sendToFarmerJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToFarmerJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable1.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a row before proceeding");
        }
        
        ProduceRequest request = (ProduceRequest)workRequestJTable1.getValueAt(selectedRow, 0);
        request.setStatus("Request sent to the Farmer ");
        populateCustomerRequestTable();
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof FarmerOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
        }
        
    }//GEN-LAST:event_sendToFarmerJButtonActionPerformed

    private void sendToWarehouseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToWarehouseJButtonActionPerformed
        // TODO add your handling code here:
      int selectedRow = workRequestJTable1.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a row before proceeding");
        }
        
        ProduceRequest request = (ProduceRequest)workRequestJTable1.getValueAt(selectedRow, 0);
        request.setStatus("sent to Warehouse Manager");
        populateCustomerRequestTable();
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof WarehouseOrganization){
                org = organization;
                break;
            }
            else if (organization instanceof WarehouseOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
        }
        
        
         sendToWarehouseJButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    source.setEnabled(false);
                    source.setBackground(Color.GREEN);
            }
    });
    }//GEN-LAST:event_sendToWarehouseJButtonActionPerformed
    
    private void sendToSupplierJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToSupplierJButtonActionPerformed
        int selectedRow = workRequestJTable1.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        ProduceRequest request = (ProduceRequest)workRequestJTable1.getValueAt(selectedRow, 0);
        request.setStatus("sent to Manufacturer.Supplier ");
        populateCustomerRequestTable();
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof ManufacturerSupplierOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
        }
        
    }//GEN-LAST:event_sendToSupplierJButtonActionPerformed

    private void sendToSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToSuppActionPerformed
         int selectedRow = workRequestJTable1.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a row before proceeding");
        }
        
        ProduceRequest request = (ProduceRequest)workRequestJTable1.getValueAt(selectedRow, 0);
        request.setStatus("Request sent to Supplier ");
        populateCustomerRequestTable();
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        
        Organization org = null;
        for (Network network: business.getNetworkList()){
               
            for (Enterprise e: network.getEnterpriseDirectory().getEnterpriseList())
            {   
                
                if (e instanceof ManufacturerEnterprise)
                {
                   for (Organization organization : e.getOrganizationDirectory().getOrganizationList()){
            
            if (organization instanceof ManufacturerSupplierOrganization){
                org = organization;
                System.out.println(org);
                break;
            }
        }
            if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            } 
                }
                
            }
        }
        
    }//GEN-LAST:event_sendToSuppActionPerformed

    private void workRequestJTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workRequestJTable1MouseClicked
       disableWarehouseButton();
    }//GEN-LAST:event_workRequestJTable1MouseClicked

    private void barBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barBtnActionPerformed
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         int j= 0;
        
         for (j=0;j<workRequestJTable1.getRowCount();j++)
        {
            if (!(Integer.parseInt(String.valueOf(workRequestJTable1.getModel().getValueAt(j,4))) == 0))
            {
                String tempName = workRequestJTable1.getModel().getValueAt(j,0).toString();
            dataset.setValue(Integer.parseInt(String.valueOf(workRequestJTable1.getModel().getValueAt(j,4))), "CROPS", tempName);
            //System.out.println(dataset);
        }
        }
        
      
        JFreeChart chart = ChartFactory.createBarChart3D("DEMAND ANALYSIS REPORT","CROPS", "QUANTITY", dataset, PlotOrientation.VERTICAL, false, true, false);
        
        CategoryPlot barchart = chart.getCategoryPlot();
        barchart.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("Bar chart" , chart);
        frame.setVisible(true);
        frame.setSize(500,500);
        
        
    }//GEN-LAST:event_barBtnActionPerformed

    private void lineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineBtnActionPerformed
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           
         int j= 0;
        
         for (j=0;j<workRequestJTable1.getRowCount();j++)
        {
            if (!(Integer.parseInt(String.valueOf(workRequestJTable1.getModel().getValueAt(j,4))) == 0))
            {   String tempName = workRequestJTable1.getModel().getValueAt(j,0).toString();
            dataset.setValue(Integer.parseInt(String.valueOf(workRequestJTable1.getModel().getValueAt(j,4))), "CROPS", tempName);
            //System.out.println(dataset);
        }
        }
        
      
        JFreeChart chart = ChartFactory.createLineChart3D("DEMAND ANALYSIS REPORT","CROPS", "QUANTITY", dataset, PlotOrientation.VERTICAL, false, true, false);
        
        CategoryPlot barchart = chart.getCategoryPlot();
        barchart.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("Bar chart" , chart);
        frame.setVisible(true);
        frame.setSize(500,500);
    }//GEN-LAST:event_lineBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton barBtn;
    private javax.swing.JTable customerReviewTable;
    private javax.swing.JTable customerReviewTable1;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton lineBtn;
    private javax.swing.JTable produceTable;
    private javax.swing.JButton sendToFarmerJButton;
    private javax.swing.JButton sendToSupp;
    private javax.swing.JButton sendToWarehouseJButton;
    private javax.swing.JTable supplierReviewTable;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable1;
    // End of variables declaration//GEN-END:variables

    private void populateProduceTable() {
        DefaultTableModel model = (DefaultTableModel)produceTable.getModel();
        
        model.setRowCount(0);
        
        for(Produce produce : produceDirectory.getProduceList()){
            Object[] row = new Object[5];
            row[0] = produce;
            row[1] = produce.getCropQuantity();
            row[2] = produce.getCropPrice();
            row[3] = produce.getFarmerName();
            model.addRow(row);
            
        }
        checkforProduce();
    }
    
             

    private void checkforProduce() {
        
        int i = 1;
        
        for (int j = 0; j < produceTable.getRowCount(); j++) {
           int tempQuantity = Integer.parseInt((String.valueOf(produceTable.getModel().getValueAt(j, i)))) ;
            if(tempQuantity == 0){
                  int delay = 4000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null,"Send produce request for" + "to farmer");
               
      }
  };
                Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
                
                 break;
            }
        }
    }

    private void disableWarehouseButton() {
        int selectedRow = workRequestJTable1.getSelectedRow();
        String requestedCrop = workRequestJTable1.getModel().getValueAt(selectedRow, 0).toString();
        int i = 0;
        String tempName = null;
        for(int j = 0;j < produceTable.getRowCount(); j++) {
            tempName = produceTable.getModel().getValueAt(j, i).toString();
             //System.out.println(tempName);
                if(!(tempName.equals(requestedCrop))){
               continue; 
                }
                else {sendToWarehouseJButton.setEnabled(true);}
        }
        }
    
    
}
