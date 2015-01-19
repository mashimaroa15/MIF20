/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jdom.Element;

/**
 *
 * @author Blandine
 */
public class ApercuMiseEnValeur extends javax.swing.JFrame {

    public ApercuMiseEnValeur() {
        initComponents();       
    }
    
    public void chargerInterface()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(200, 200, 700, 250);
        this.setLayout(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/icone_editeur.png"));
        this.setIconImage(icon);
        BtExemple.setBounds((this.getWidth()-250)/2, 60, 250, 80);
        chargerLangue();
    }
    
    private void chargerLangue()
    {
        XMLFonctions.OuvrirXML(Main.Cste.fichierInterfaceEditeur);
        Element courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("Titre").getChild(Main.Cste.langue);
        Element courant2= (Element) XMLFonctions.racine.getChild("ApercuMiseEnValeur").getChild("Titre").getChild(Main.Cste.langue);
        this.setTitle(courant.getText()+courant2.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("ApercuMiseEnValeur").getChild("BtExemple").getChild(Main.Cste.langue);
        BtExemple.setText(courant.getText());
    }
    
    public void apercuAjoutComposant(Element action)
    {
        Main.ApercuMiseEnValeur.chargerInterface();
        Main.ApercuMiseEnValeur.setVisible(true);
        
        Element noeud_comp=action.getChild("composant");
        if(noeud_comp.getAttribute("icone")!=null)
            noeud_comp.setAttribute("icone", Main.Cste.cheminSymboles+noeud_comp.getAttributeValue("icone"));
        
        Element noeud_coor=new Element("coordonnees");
        noeud_coor.setAttribute("x", String.valueOf(BtExemple.getLocationOnScreen().x));
        noeud_coor.setAttribute("y", String.valueOf(BtExemple.getLocationOnScreen().y));
        noeud_coor.setAttribute("largeur", String.valueOf(BtExemple.getBounds().width));
        noeud_coor.setAttribute("hauteur", String.valueOf(BtExemple.getBounds().height));
        action.addContent(noeud_coor);
        XMLFonctions.creerXML(action);
        XMLFonctions.enregistre("Action.xml", "");
        try {
            Runtime.getRuntime().exec("java -jar " + Main.Cste.jarAjoutComposant);
        } catch (IOException ex) {
            Logger.getLogger(ApercuMiseEnValeur.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void apercuValorisateur(Element action)
    {
        Main.ApercuMiseEnValeur.chargerInterface();
        Main.ApercuMiseEnValeur.setVisible(true);
        if(action.getChild("composant").getAttribute("symbole")!=null)
            action.getChild("composant").setAttribute("symbole", Main.Cste.cheminSymboles+action.getChild("composant").getAttribute("symbole").getValue());
        //action.getChild("composant").setAttribute("symbole", "D:/These/Editeur_assistance/Parametres/Assistants_epiphytes/Valorisateur/Symboles/attention3.png");
        Element noeud_coor=new Element("coordonnees");
        noeud_coor.setAttribute("x", String.valueOf(BtExemple.getLocationOnScreen().x));
        noeud_coor.setAttribute("y", String.valueOf(BtExemple.getLocationOnScreen().y));
        noeud_coor.setAttribute("largeur", String.valueOf(BtExemple.getBounds().width));
        noeud_coor.setAttribute("hauteur", String.valueOf(BtExemple.getBounds().height));
        action.addContent(noeud_coor);
        XMLFonctions.creerXML(action);
        XMLFonctions.enregistre("Action.xml", "");
        try {
            Runtime.getRuntime().exec("java -jar " + Main.Cste.jarValorisateur);
        } catch (IOException ex) {
            Logger.getLogger(ApercuMiseEnValeur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void apercuMsAgents(Element action)
    {
        Main.ApercuMiseEnValeur.chargerInterface();
        Main.ApercuMiseEnValeur.setVisible(true);
        Element noeud_coor=new Element("coordonnees");
        noeud_coor.setAttribute("x", String.valueOf(BtExemple.getLocationOnScreen().x));
        noeud_coor.setAttribute("y", String.valueOf(BtExemple.getLocationOnScreen().y));
        noeud_coor.setAttribute("largeur", String.valueOf(BtExemple.getBounds().width));
        noeud_coor.setAttribute("hauteur", String.valueOf(BtExemple.getBounds().height));
        action.addContent(noeud_coor);
        XMLFonctions.creerXML(action);
        XMLFonctions.enregistre("Action.xml", "");
        try {
            Runtime.getRuntime().exec("java -jar " + Main.Cste.jarMsAgents);
        } catch (IOException ex) {
            Logger.getLogger(ApercuMiseEnValeur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtExemple = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        BtExemple.setText("Bouton exemple");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(BtExemple, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(361, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(BtExemple, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(ApercuMiseEnValeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApercuMiseEnValeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApercuMiseEnValeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApercuMiseEnValeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                //new ApercuMiseEnValeur().setVisible(true);
                
                ApercuMiseEnValeur c = new ApercuMiseEnValeur();
                c.chargerInterface();
                c.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtExemple;
    // End of variables declaration//GEN-END:variables
}
