/*
 * 
 */

package WarCardGame;

import javax.swing.JOptionPane;

/**
 *
 * @author Shannon Ploppa
 */
public class OptionsDialog extends javax.swing.JDialog {
    /**
     * Creates new form OptionsDialog
     */
    java.awt.Frame parent;
    
    
    public OptionsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        GameOfWar war = (GameOfWar)parent;
        randomSeedTextField.setText(war.getRandomSeed());
        deckCountComboBox.setSelectedItem((Object)war.getNumberOfDecks());
        warSizeComboBox.setSelectedItem((Object)war.getPlayWarSize());
        jokerPairsComboBox.setSelectedItem((Object)war.getNumberOfJokerPairs());
        perDeckCheckBox1.setSelected(war.getJokerPairsPerDeck());
    }
    
    public void setNewOptions () throws NumberFormatException{
        // validate RandomSeed
        long rLong;
        try {
            rLong = Long.parseLong(randomSeedTextField.getText());
        } catch(NumberFormatException e) {
            throw e;
        }

         GameOfWar war = (GameOfWar)parent;
         war.setRandomSeed(Long.parseLong(randomSeedTextField.getText()));
         war.setNumberOfDecks(Integer.parseInt((String)deckCountComboBox.getSelectedItem())); 
         war.setNumberOfJokerPairs(Integer.parseInt((String)jokerPairsComboBox.getSelectedItem()));
         war.setWarSize(Integer.parseInt((String)warSizeComboBox.getSelectedItem()));
         war.setJokerPairsPerDeck(perDeckCheckBox1.isSelected());
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
        randomSeedTextField = new javax.swing.JTextField();
        RandomLabel = new javax.swing.JLabel();
        deckCountComboBox = new javax.swing.JComboBox();
        deckCountLabel = new javax.swing.JLabel();
        jokerPairsComboBox = new javax.swing.JComboBox();
        jokerPairsLabel = new javax.swing.JLabel();
        perDeckCheckBox1 = new javax.swing.JCheckBox();
        warSizeComboBox = new javax.swing.JComboBox();
        warSizeLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        randomSeedTextField.setAutoscrolls(false);
        randomSeedTextField.setPreferredSize(new java.awt.Dimension(60, 25));
        getContentPane().add(randomSeedTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        RandomLabel.setText("Random Seed");
        getContentPane().add(RandomLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        deckCountComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
        getContentPane().add(deckCountComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        deckCountLabel.setText("Number of Standard Decks");
        getContentPane().add(deckCountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, 20));

        jokerPairsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4" }));
        getContentPane().add(jokerPairsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jokerPairsLabel.setText("Number of Joker Pairs");
        getContentPane().add(jokerPairsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        perDeckCheckBox1.setText("Per Deck");
        getContentPane().add(perDeckCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        warSizeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        getContentPane().add(warSizeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        warSizeLabel.setText("Size of War");
        getContentPane().add(warSizeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 330, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        try{
            setNewOptions();
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Not a number: " + randomSeedTextField.getText());
            randomSeedTextField.requestFocus();
            randomSeedTextField.selectAll();
            return;
        }
        this.dispose();
       
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OptionsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptionsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptionsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptionsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OptionsDialog dialog = new OptionsDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RandomLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox deckCountComboBox;
    private javax.swing.JLabel deckCountLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox jokerPairsComboBox;
    private javax.swing.JLabel jokerPairsLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox perDeckCheckBox1;
    private javax.swing.JTextField randomSeedTextField;
    private javax.swing.JComboBox warSizeComboBox;
    private javax.swing.JLabel warSizeLabel;
    // End of variables declaration//GEN-END:variables
}
