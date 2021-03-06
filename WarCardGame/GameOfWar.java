/*
 * 
 */

package WarCardGame;

/**
 *
 * @author Shannon Ploppa
 */
public class GameOfWar extends javax.swing.JFrame {
    private War myWar;
    private long randomSeed = 14567;
    private int numberOfDecks = 1;
    private int numberOfJokerPairs = 1;
    private int warSize = 3;
    private boolean jokersPerDeckCheck = false;
   
    /**
     * Creates new form GameOfWar
     */
    public GameOfWar() {
        initComponents();
        myWar = new War(randomSeed, numberOfDecks);
        p1TextArea.setText("Ready for war");
        p2TextArea.setText("Ready for war");
        gameStatusLabel.setText("");
        p1CardsLeftLabel.setText("Cards left: " + myWar.getP1Size());
        p2CardsLeftLabel.setText("Cards left: " + myWar.getP2Size());  
        handStatusLabel.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        p2TextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        p1TextArea = new javax.swing.JTextArea();
        p2Label = new javax.swing.JLabel();
        p1Label = new javax.swing.JLabel();
        p2CardsLeftLabel = new javax.swing.JLabel();
        playHandButton = new javax.swing.JButton();
        handStatusLabel = new javax.swing.JLabel();
        gameStatusLabel = new javax.swing.JLabel();
        p1CardsLeftLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game of War");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p2TextArea.setEditable(false);
        p2TextArea.setColumns(20);
        p2TextArea.setRows(5);
        jScrollPane1.setViewportView(p2TextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 270, 230));

        p1TextArea.setEditable(false);
        p1TextArea.setColumns(20);
        p1TextArea.setRows(5);
        jScrollPane2.setViewportView(p1TextArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 270, 230));

        p2Label.setText("Player 2");
        getContentPane().add(p2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        p1Label.setText("Player 1");
        getContentPane().add(p1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        p2CardsLeftLabel.setText("Cards Left: ");
        p2CardsLeftLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p2CardsLeftLabel.setFocusable(false);
        getContentPane().add(p2CardsLeftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, -1, -1));

        playHandButton.setText("Play Hand");
        playHandButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playHandButtonActionPerformed(evt);
            }
        });
        getContentPane().add(playHandButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, -1));

        handStatusLabel.setText("Hand Status");
        getContentPane().add(handStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, -1, -1));

        gameStatusLabel.setText("Game Status");
        getContentPane().add(gameStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, -1, -1));

        p1CardsLeftLabel.setText("Cards Left: ");
        p1CardsLeftLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p1CardsLeftLabel.setFocusable(false);
        getContentPane().add(p1CardsLeftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 70, 490));

        jMenu1.setText("Play War");

        jMenuItem1.setText("New Game");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Change Settings");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Quit War");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playHandButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playHandButtonActionPerformed
       if (myWar.hasWinner()) {
           newGame();
       } else {
          playHand(); 
       }
           
    }//GEN-LAST:event_playHandButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        newGame();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        endWar();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       OptionsDialog oDialog = new OptionsDialog(this, true);
       oDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void setRandomSeed(long seed) {
        randomSeed = seed;
    }
    
    public void setNumberOfDecks(int number){
        numberOfDecks = number;
    }
    
    public void setNumberOfJokerPairs(int number) {
        numberOfJokerPairs = number;
    }
    
    public void setWarSize(int numberOfCards){
        warSize = numberOfCards;
    }
    public void setJokerPairsPerDeck(boolean checkedPerDeck){
        jokersPerDeckCheck = checkedPerDeck;
    }
    
    public String getRandomSeed() {
        return Long.toString(randomSeed);    
    }
    
    public String getNumberOfDecks() {
        return Integer.toString(numberOfDecks);
    }
    
    public String getNumberOfJokerPairs() {
        return Integer.toString(numberOfJokerPairs);
    }
    
    public String getPlayWarSize() {
        return Integer.toString(warSize);
    }
    public boolean getJokerPairsPerDeck() {
        return jokersPerDeckCheck;
    }
    
    public void playHand() {
        myWar.clearHand();
        myWar.playHand();
        p1TextArea.setText(myWar.getP1Results());
        p2TextArea.setText(myWar.getP2Results());
        handStatusLabel.setText(myWar.getHandResult());
        p1CardsLeftLabel.setText( "Cards left: " + myWar.getP1Size());
        p2CardsLeftLabel.setText("Cards left: " + myWar.getP2Size());  
        gameStatusLabel.setText(myWar.getGameResult());
    }
    
    public void newGame() {
        myWar = new War(
                randomSeed, 
                numberOfDecks,
                (jokersPerDeckCheck ? numberOfJokerPairs  * numberOfDecks : numberOfJokerPairs),
                warSize);
        p1TextArea.setText("Ready for war");
        p2TextArea.setText("Ready for war");
        handStatusLabel.setText("");
        p1CardsLeftLabel.setText("Cards left: " + myWar.getP1Size());
        p2CardsLeftLabel.setText("Cards left: " + myWar.getP2Size());  
        handStatusLabel.setText(""); 
    }
    
    public void endWar() {
        this.dispose(); 
    }
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
            java.util.logging.Logger.getLogger(GameOfWar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameOfWar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameOfWar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameOfWar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameOfWar().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gameStatusLabel;
    private javax.swing.JLabel handStatusLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel p1CardsLeftLabel;
    private javax.swing.JLabel p1Label;
    private javax.swing.JTextArea p1TextArea;
    private javax.swing.JLabel p2CardsLeftLabel;
    private javax.swing.JLabel p2Label;
    private javax.swing.JTextArea p2TextArea;
    private javax.swing.JButton playHandButton;
    // End of variables declaration//GEN-END:variables
}
