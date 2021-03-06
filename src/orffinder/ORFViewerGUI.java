package orffinder;

import java.util.ArrayList;
import javax.swing.JOptionPane;





/**
 *
 * @author Jasper de Meijer & Tim van de Kerkhof
 */
public class ORFViewerGUI extends javax.swing.JDialog {

    /**
     * Creates new form ORFViewerGUI
     */
    
    //Start of variable declaration (seperate of gui variables)
    FileHandler f = new FileHandler();
    ORFPredictor o = new ORFPredictor();
    DataExporter e = new DataExporter();
    DataImporter i = new DataImporter();
    //End of variable eclaration
    
    /**
     *
     * @param parent
     * @param modal
     */
    public ORFViewerGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        btnOpen = new javax.swing.JButton();
        btnFileChooser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtFilePath = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtORFSequence = new javax.swing.JTextField();
        drpHeader = new javax.swing.JComboBox<>();
        drpReadingFrame = new javax.swing.JComboBox<>();
        drpORF = new javax.swing.JComboBox<>();
        javax.swing.JButton btnVisualizeORF = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnImport = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAaSequence = new javax.swing.JTextField();
        btnVisualizeSeq = new javax.swing.JButton();
        btnPickHeader = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtProjectName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnOpen.setText("Open");
        btnOpen.setToolTipText("");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnFileChooser.setText("Browse");
        btnFileChooser.setActionCommand("Visualize");
        btnFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileChooserActionPerformed(evt);
            }
        });

        jLabel1.setText("File Path:");

        jScrollPane1.setViewportView(txtFilePath);

        jScrollPane2.setViewportView(jScrollPane1);

        txtORFSequence.setEditable(false);
        jScrollPane6.setViewportView(txtORFSequence);

        drpReadingFrame.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "-1", "-2", "-3" }));

        btnVisualizeORF.setText("Visualize ORF");
        btnVisualizeORF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizeORFActionPerformed(evt);
            }
        });

        jLabel2.setText("DNA:");

        jLabel3.setText("AA:");

        btnImport.setText("Import project");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        btnExport.setText("Export project");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        txtAaSequence.setEditable(false);
        jScrollPane5.setViewportView(txtAaSequence);

        btnVisualizeSeq.setText("Visualize seq");
        btnVisualizeSeq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizeSeqActionPerformed(evt);
            }
        });

        btnPickHeader.setText("Pick header");
        btnPickHeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPickHeaderActionPerformed(evt);
            }
        });

        jLabel4.setText("Select a reading frame:");

        jLabel5.setText("Select an open reading frame:");

        txtProjectName.setText("DEFAULT");

        jLabel6.setText("Project name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)
                                    .addComponent(txtProjectName))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43))
                            .addComponent(jScrollPane5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnPickHeader, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(drpHeader, javax.swing.GroupLayout.Alignment.LEADING, 0, 225, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(drpReadingFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(drpORF, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVisualizeORF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVisualizeSeq))
                            .addComponent(jLabel5))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnImport)
                    .addComponent(btnExport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPickHeader)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(drpORF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(drpReadingFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(drpHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVisualizeORF)
                    .addComponent(btnVisualizeSeq))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * 
     * @param evt 
     * Action listener for btn "open". When this button is pressed the logic is called
     * to read the file, predict ORF's en fill the header dropdown menu.
     */
    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
       
        drpHeader.removeAll();
        ArrayList<String> fileContents = new ArrayList();
        fileContents = f.readFile(txtFilePath.getText());
        o.predictORF(fileContents);
        for(String s : o.getHeaderList()){
            drpHeader.addItem(s);
        }
    }//GEN-LAST:event_btnOpenActionPerformed
    
    /**
     * 
     * @param evt 
     * even listener for the btn Visualize ORF. 
     * When this button is pressed the selected ORF will be shown in the DNA text area.
     * The DNA sequence will be translated to an AA sequence and this will be shown in the AA text area.
     */
    private void btnVisualizeORFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizeORFActionPerformed
        // TODO add your handling code here:
        try{
            txtORFSequence.setText(o.getORFs().get(drpORF.getSelectedIndex()));

            String aminoAcid = "";
            String aminoSeq = "";
            String codon = "";
            String seq = txtORFSequence.getText();
            SequenceTranscriptor translate = new SequenceTranscriptor();

            for (int i=0; i< seq.length() -2; i+=3){
                codon = seq.substring(i, i+3);
                aminoAcid = translate.getAminoAcidSequence(codon);
                aminoSeq += aminoAcid;
            }

            txtAaSequence.setText(aminoSeq);
        }catch(ArrayIndexOutOfBoundsException ex){
             JOptionPane.showMessageDialog(null, "First pick a header!", "Error Message",
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnVisualizeORFActionPerformed
    /**
     * 
     * @param evt 
     * even listener for the btn Visualize seq. 
     * When this button is pressed the sequence of the selected header will be shown in the DNA text area.
     * The DNA sequence will be translated to an AA sequence and this will be shown in the AA text area.
     */
    private void btnVisualizeSeqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizeSeqActionPerformed
        try {
            txtORFSequence.setText(o.getSequenceList().get(drpORF.getSelectedIndex()));
            String aminoAcid = "";
            String aminoSeq = "";
            String codon = "";
            String seq = txtORFSequence.getText();
            SequenceTranscriptor translate = new SequenceTranscriptor();

            for (int i=0; i< seq.length() -2; i+=3){
                codon = seq.substring(i, i+3);
                aminoAcid = translate.getAminoAcidSequence(codon);
                aminoSeq += aminoAcid;
            }

            txtAaSequence.setText(aminoSeq);
        }catch(ArrayIndexOutOfBoundsException ex){
             JOptionPane.showMessageDialog(null, "First pick a header!", "Error Message",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVisualizeSeqActionPerformed
    /**
     * 
     * @param evt 
     * Calls upon the method to open a Jfilechooser.
     * When a file is chosen the filepath will be shown in the filepath text area.
     */
    private void btnFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileChooserActionPerformed
        // TODO add your handling code here:
        txtFilePath.setText(f.openFile());
    }//GEN-LAST:event_btnFileChooserActionPerformed
    
    /**
     * 
     * @param evt 
     * Event listener for btn pick a header.
     * This will pick a header and determine the ORF's of the corresponding DNA sequence.
     * The ORF's will be added to the ORF dropdown menu.
     */
    private void btnPickHeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPickHeaderActionPerformed
        // TODO add your handling code here:
        try{
            drpORF.removeAllItems();
            o.visualizeORF(drpReadingFrame.getSelectedIndex()+1, drpHeader.getSelectedIndex());
            for(int i = 0; i < o.getORFs().size(); i++){
                drpORF.addItem(Integer.toString(i+1)); 
            }
        }catch(ArrayIndexOutOfBoundsException ex){
             JOptionPane.showMessageDialog(null, "First select a header from the dropdown menu!", "Error Message",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPickHeaderActionPerformed
    /**
     * 
     * @param evt 
     * event listener for the btn Import.
     * Will import data from the database based on a given project namen.
     */
    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        // TODO add your handling code here:
        ArrayList<String> importedData = new ArrayList();
        importedData = i.importData(txtProjectName.getText());
        o.predictORF(importedData);
        for(String s : o.getHeaderList()){
            drpHeader.addItem(s);
        }
    }//GEN-LAST:event_btnImportActionPerformed
    /**
     * 
     * @param evt 
     * Event listener for btn Export.
     * Will trigger the data export to the database. 
     * It will ask for a project name as a reference. 
     */
    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        try {
            e.exportSequence(e.getSeqID()+1, o.getSequenceList().get(drpHeader.getSelectedIndex()), 
                    txtProjectName.getText(), "Not_Implemented", drpHeader.getSelectedItem().toString());
            for(String s : o.getORFs()){
                e.exportORF(e.getORFID()+1, s, drpReadingFrame.getSelectedItem().toString(), e.getSeqID());
            }
            JOptionPane.showMessageDialog(null, "Export completed!", "Notification",
                    JOptionPane.ERROR_MESSAGE);
        } catch(ArrayIndexOutOfBoundsException ex){
             JOptionPane.showMessageDialog(null, "There is nothing to export!", "Error Message",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExportActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnFileChooser;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnPickHeader;
    private javax.swing.JButton btnVisualizeSeq;
    private javax.swing.JComboBox<String> drpHeader;
    private javax.swing.JComboBox<String> drpORF;
    private javax.swing.JComboBox<String> drpReadingFrame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField txtAaSequence;
    private javax.swing.JTextField txtFilePath;
    private javax.swing.JTextField txtORFSequence;
    private javax.swing.JTextField txtProjectName;
    // End of variables declaration//GEN-END:variables
}
