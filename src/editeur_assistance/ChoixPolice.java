/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.border.TitledBorder;
import org.jdom.Element;

/**
 *
 * @author Blandine
 */
public class ChoixPolice extends javax.swing.JDialog {
   
    private static String[] Polices = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    private static String[] Styles = {"Plain", "Bold", "Italic", "Bold Italic"};
    private static String[] Tailles = {"10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72"};
    public String police;
    public int taille;
    public int style;
    public Color couleur;
    public JButton bt;
    
    public ChoixPolice() {
        initComponents();
    }   
    
    public void chargerInterface()
    {
        this.setLayout(null);
        this.setBounds(200, 200, 700, 250);
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/icone_editeur.png"));
        this.setIconImage(icon);
        
        LbPolice.setBounds(20,20, 100, 30);
        CbPolice.setBounds(80, 20, 250, 30);
        chargerCbPolice();
        
        LbStyle.setBounds(20, 60, 100, 30);
        CbStyle.setBounds(80, 60, 120, 30);
        chargerCbStyle();
        
        LbTaille.setBounds(220, 60, 50, 30);
        CbTaille.setBounds(260, 60, 70, 30);
        chargerCbTaille();
        
        LbCouleur.setBounds(20, 100, 300, 30); 
        BtCouleur.setBounds(80, 100, 70, 30); 
        
        PanelApercu.setBounds(400, 20, 220, 100);
        PanelApercu.setLayout(null);
        TxtTest.setBounds(10, 30, 200, 50);
        TxtTest.setText("Test");
        
        BtRetour.setBounds((this.getWidth()-100)/2-75, this.getHeight()-80, 100, 30);
        BtSuivant.setBounds((this.getWidth()-100)/2+75, this.getHeight()-80, 100, 30);
        
        chargerLangue();
    }
    
    private void chargerLangue()
    {
        XMLFonctions.OuvrirXML(Main.Cste.fichierInterfaceEditeur);
        Element courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("Titre").getChild(Main.Cste.langue);
        Element courant2= (Element) XMLFonctions.racine.getChild("ChoixPolice").getChild("Titre").getChild(Main.Cste.langue);
        this.setTitle(courant.getText()+courant2.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("ChoixPolice").getChild("LbPolice").getChild(Main.Cste.langue);
        LbPolice.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ChoixPolice").getChild("LbStyle").getChild(Main.Cste.langue);
        LbStyle.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ChoixPolice").getChild("LbCouleur").getChild(Main.Cste.langue);
        LbCouleur.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ChoixPolice").getChild("PanelApercu").getChild(Main.Cste.langue);
        TitledBorder title = BorderFactory.createTitledBorder(courant.getText());
        PanelApercu.setBorder(title);
        
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("BtRetour").getChild(Main.Cste.langue);
        BtRetour.setText(courant.getText());       
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("BtSuivant").getChild(Main.Cste.langue);
        BtSuivant.setText(courant.getText());       
    }
    
    public void chargerChoix(JButton b)
    {
        police=b.getFont().getName();
        taille =b.getFont().getSize();
        style=b.getFont().getStyle();
        couleur=b.getForeground();
        bt=b;
        
        CbPolice.setSelectedItem(police);
        CbTaille.setSelectedItem(String.valueOf(taille));
        CbStyle.setSelectedIndex(style);
        BtCouleur.setBackground(b.getForeground());
    }
    
    public void chargerChoix(String p, int t, int s, Color c, JButton b)
    {
        police=p;
        taille =t;
        style=s;
        couleur=c;
        bt=b;
        
        CbPolice.setSelectedItem(police);
        CbTaille.setSelectedItem(String.valueOf(taille));
        CbStyle.setSelectedIndex(style);
        BtCouleur.setBackground(c);
    }
    
    private void chargerCbPolice()
    {
        CbPolice.removeAllItems();
        for(int i=0; i<Polices.length; i++)
        {
            CbPolice.addItem(Polices[i]);
        }
    }
    
    private void chargerCbStyle()
    {
        CbStyle.removeAllItems();
        for(int i=0; i<Styles.length; i++)
        {
            CbStyle.addItem(Styles[i]);
        }
    }
    
    private void chargerCbTaille()
    {
        CbTaille.removeAllItems();
        for(int i=0; i<Tailles.length; i++)
        {
            CbTaille.addItem(Tailles[i]);
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

        BtRetour = new javax.swing.JButton();
        BtSuivant = new javax.swing.JButton();
        LbStyle = new javax.swing.JLabel();
        LbPolice = new javax.swing.JLabel();
        LbCouleur = new javax.swing.JLabel();
        LbTaille = new javax.swing.JLabel();
        PanelApercu = new javax.swing.JPanel();
        TxtTest = new javax.swing.JTextField();
        CbPolice = new javax.swing.JComboBox();
        CbStyle = new javax.swing.JComboBox();
        CbTaille = new javax.swing.JComboBox();
        BtCouleur = new javax.swing.JButton();

        BtRetour.setText("Retour");
        BtRetour.setToolTipText("Retour à la définition des règles d'assistance");
        BtRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRetourActionPerformed(evt);
            }
        });

        BtSuivant.setText("Suivant");
        BtSuivant.setToolTipText("Définir une action d'assistance");
        BtSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSuivantActionPerformed(evt);
            }
        });

        LbStyle.setText("Style");

        LbPolice.setText("Police");

        LbCouleur.setText("Couleur");

        LbTaille.setText("Taille");

        PanelApercu.setBorder(javax.swing.BorderFactory.createTitledBorder("Aperçu"));

        TxtTest.setText("Test");

        javax.swing.GroupLayout PanelApercuLayout = new javax.swing.GroupLayout(PanelApercu);
        PanelApercu.setLayout(PanelApercuLayout);
        PanelApercuLayout.setHorizontalGroup(
            PanelApercuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelApercuLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(TxtTest, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        PanelApercuLayout.setVerticalGroup(
            PanelApercuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelApercuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CbPolice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbPolice.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbPoliceItemStateChanged(evt);
            }
        });

        CbStyle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbStyle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbStyleItemStateChanged(evt);
            }
        });

        CbTaille.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbTaille.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbTailleItemStateChanged(evt);
            }
        });

        BtCouleur.setText("...");
        BtCouleur.setToolTipText("Modifier la couleur de fond du message");
        BtCouleur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCouleurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LbCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtCouleur)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LbPolice, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(LbStyle, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(CbPolice, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(CbStyle, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(LbTaille, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CbTaille, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                                .addComponent(PanelApercu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(BtRetour)
                        .addGap(27, 27, 27)
                        .addComponent(BtSuivant)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelApercu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbPolice)
                            .addComponent(CbPolice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbStyle)
                            .addComponent(LbTaille)
                            .addComponent(CbStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbTaille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbCouleur)
                            .addComponent(BtCouleur))))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtRetour)
                    .addComponent(BtSuivant))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRetourActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BtRetourActionPerformed

    private void BtSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSuivantActionPerformed
        this.setVisible(false);
        Main.CreationRegles.modifierPoliceBouton(bt, new Font(police, style, taille), couleur);
    }//GEN-LAST:event_BtSuivantActionPerformed

    private void CbStyleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbStyleItemStateChanged
        if(CbStyle.getSelectedIndex()>=0)
        {
            style=CbStyle.getSelectedIndex();
            Font f=new java.awt.Font(police, style, taille);
            TxtTest.setFont(f);
        }
    }//GEN-LAST:event_CbStyleItemStateChanged

    private void CbTailleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbTailleItemStateChanged
        if(CbTaille.getSelectedIndex()>=0)
        {
            taille=Integer.parseInt((String) CbTaille.getSelectedItem());
            Font f=new java.awt.Font(police, style, taille);
            TxtTest.setFont(f);
        }
    }//GEN-LAST:event_CbTailleItemStateChanged

    private void CbPoliceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbPoliceItemStateChanged
        if(CbPolice.getSelectedIndex()>=0)
        {
            police=(String) CbPolice.getSelectedItem();
            Font f=new java.awt.Font(police, style, taille);
            TxtTest.setFont(f);
        }
    }//GEN-LAST:event_CbPoliceItemStateChanged

    private void BtCouleurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCouleurActionPerformed
        BtCouleur.setBackground(JColorChooser.showDialog(null, "Choisir une couleur", BtCouleur.getBackground()));
        couleur=BtCouleur.getBackground();
        TxtTest.setForeground(couleur);
        this.repaint();
    }//GEN-LAST:event_BtCouleurActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChoixPolice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChoixPolice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChoixPolice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChoixPolice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                //new ChoixPolice().setVisible(true);
                ChoixPolice c = new ChoixPolice();
                c.chargerInterface();
                c.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCouleur;
    private javax.swing.JButton BtRetour;
    private javax.swing.JButton BtSuivant;
    private javax.swing.JComboBox CbPolice;
    private javax.swing.JComboBox CbStyle;
    private javax.swing.JComboBox CbTaille;
    private javax.swing.JLabel LbCouleur;
    private javax.swing.JLabel LbPolice;
    private javax.swing.JLabel LbStyle;
    private javax.swing.JLabel LbTaille;
    private javax.swing.JPanel PanelApercu;
    private javax.swing.JTextField TxtTest;
    // End of variables declaration//GEN-END:variables

}
