/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

import java.awt.Image;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.jdom.Element;

/**
 *
 * @author Blandine
 */
public class SauveAssistance extends javax.swing.JFrame {

    public String commentaires="";
    public String nom="";
    public String publicVise="";
    public String createur="";
    public String date="";
    public String type="";
    
    public SauveAssistance() {
        initComponents();
    }
    
    public void chargerInterface()
    {
        TxtNom.setText(nom);
        TxtType.setText(type);
        TxtCommentaires.setText(commentaires);
        TxtPublic.setText(publicVise);
        TxtCreateur.setText(createur);
        
        TxtLogiciel.setText(Main.Cste.logiciel);
        TxtDescription.setText(Main.Cste.descriptionInterface);
         
        TxtStructure.setText(Main.Cste.structureProfils);
     
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        if(date.isEmpty())
            TxtDateCrea.setText(format.format(new Date()));
        else
            TxtDateCrea.setText(date);
        TxtDateModif.setText(format.format(new Date()));    //la date de dernière modification est toujours la date du jour
        
        this.setLayout(null);
        this.setBounds(200, 200, 650, 500);
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/icone_editeur.png"));
        this.setIconImage(icon);
        
        int col1=50;
        int col2=280;
        int hesp=30;
        int h=24;
        int h2=20;
        LbNom.setBounds(col1, h2, col2, h);
        TxtNom.setBounds(col2, h2, 300, h);
        
        LbLogiciel.setBounds(col1, hesp+h2, col2, h);
        TxtLogiciel.setBounds(col2, hesp+h2, 300, h);
        
        LbType.setBounds(col1, 2*hesp+h2, col2, h);
        TxtType.setBounds(col2, 2*hesp+h2, 300, h);
        
        LbDateCrea.setBounds(col1, 3*hesp+h2, col2, h);
        TxtDateCrea.setBounds(col2, 3*hesp+h2, 300, h);
        
        LbDateModif.setBounds(col1, 4*hesp+h2, col2, h);
        TxtDateModif.setBounds(col2, 4*hesp+h2, 300, h);
        
        LbCreateur.setBounds(col1, 5*hesp+h2, col2, h);
        TxtCreateur.setBounds(col2, 5*hesp+h2, 300, h);
        
        LbStatut.setBounds(col1, 6*hesp+h2, col2, h);
        RBPublic.setBounds(col2, 6*hesp+h2, 150, h);
        RBPrive.setBounds(col2+150, 6*hesp+h2, 150, h);
        
        LbStructure.setBounds(col1, 7*hesp+h2, col2, h);
        TxtStructure.setBounds(col2, 7*hesp+h2, 300, h);
        
        LbDescription.setBounds(col1, 8*hesp+h2, col2, h);
        TxtDescription.setBounds(col2, 8*hesp+h2, 300, h);
        
        LbPublic.setBounds(col1, 9*hesp+h2, col2, h);
        TxtPublic.setBounds(col2, 9*hesp+h2, 300, h);
        
        LbCommentaires.setBounds(col1, 10*hesp+h2, 200, h);
        TxtCommentaires.setBounds(col2, 10*hesp+h2, 300, 90);
        
        
        BtRetour.setBounds((this.getWidth()-100)/2-75, this.getHeight()-80, 100, 30);
        BtSuivant.setBounds((this.getWidth()-100)/2+75, this.getHeight()-80, 100, 30);
        
        chargerLangue();
    }
    
    public void chargerLangue()
    {
        XMLFonctions.OuvrirXML(Main.Cste.fichierInterfaceEditeur);
        Element courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("Titre").getChild(Main.Cste.langue);
        Element courant2= (Element) XMLFonctions.racine.getChild("SauveAsistance").getChild("Titre").getChild(Main.Cste.langue);
        this.setTitle(courant.getText()+courant2.getText());
 
        courant= (Element) XMLFonctions.racine.getChild("SauveAsistance").getChild("LbNom").getChild(Main.Cste.langue);
        LbNom.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("SauveAsistance").getChild("LbLogiciel").getChild(Main.Cste.langue);
        LbLogiciel.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("SauveAsistance").getChild("LbDateCrea").getChild(Main.Cste.langue);
        LbDateCrea.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("SauveAsistance").getChild("LbDateModif").getChild(Main.Cste.langue);
        LbDateModif.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("SauveAsistance").getChild("LbCreateur").getChild(Main.Cste.langue);
        LbCreateur.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("SauveAsistance").getChild("LbStatut").getChild(Main.Cste.langue);
        LbStatut.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("SauveAsistance").getChild("LbStructure").getChild(Main.Cste.langue);
        LbStructure.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("SauveAsistance").getChild("LbDescription").getChild(Main.Cste.langue);
        LbDescription.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("SauveAsistance").getChild("LbPublic").getChild(Main.Cste.langue);
        LbPublic.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("SauveAsistance").getChild("LbCommentaires").getChild(Main.Cste.langue);
        LbCommentaires.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("SauveAsistance").getChild("RBPublic").getChild(Main.Cste.langue);
        RBPublic.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("SauveAsistance").getChild("RBPrive").getChild(Main.Cste.langue);
        RBPrive.setText(courant.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("BtRetour").getChild(Main.Cste.langue);
        BtRetour.setText(courant.getText());
        BtSuivant.setText("Enregistrer");
    }
    
    private String idStructure(String structure)
    {
        if(structure.isEmpty())
            return "";
        XMLFonctions.OuvrirXML(Main.Cste.cheminStructuresProfils+structure);
        Element courant= (Element) XMLFonctions.racine;
        return courant.getAttributeValue("id");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TxtCommentaires = new java.awt.TextArea();
        TxtPublic = new javax.swing.JTextField();
        BtSuivant = new javax.swing.JButton();
        BtRetour = new javax.swing.JButton();
        RBPrive = new javax.swing.JRadioButton();
        RBPublic = new javax.swing.JRadioButton();
        TxtStructure = new javax.swing.JTextField();
        TxtCreateur = new javax.swing.JTextField();
        TxtDateModif = new javax.swing.JTextField();
        TxtDateCrea = new javax.swing.JTextField();
        TxtNom = new javax.swing.JTextField();
        LbCommentaires = new javax.swing.JLabel();
        LbPublic = new javax.swing.JLabel();
        LbStructure = new javax.swing.JLabel();
        LbStatut = new javax.swing.JLabel();
        LbCreateur = new javax.swing.JLabel();
        LbDateModif = new javax.swing.JLabel();
        LbDateCrea = new javax.swing.JLabel();
        LbNom = new javax.swing.JLabel();
        LbLogiciel = new javax.swing.JLabel();
        TxtLogiciel = new javax.swing.JTextField();
        LbDescription = new javax.swing.JLabel();
        TxtDescription = new javax.swing.JTextField();
        LbType = new javax.swing.JLabel();
        TxtType = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TxtPublic.setText("classe de 6eC");

        BtSuivant.setText("Enregistrer");
        BtSuivant.setToolTipText("Enregistrer la description de l'assistance");
        BtSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSuivantActionPerformed(evt);
            }
        });

        BtRetour.setText("Retour");
        BtRetour.setToolTipText("Revenir à la définition des règles d'assistance");
        BtRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRetourActionPerformed(evt);
            }
        });

        RBPrive.setText("Prive");

        RBPublic.setSelected(true);
        RBPublic.setText("Public");

        TxtStructure.setEditable(false);
        TxtStructure.setText("Strucutre");

        TxtCreateur.setText("Prof");
        TxtCreateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCreateurActionPerformed(evt);
            }
        });

        TxtDateModif.setEditable(false);
        TxtDateModif.setText("09/02/2011");

        TxtDateCrea.setEditable(false);
        TxtDateCrea.setText("09/01/2011");
        TxtDateCrea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDateCreaActionPerformed(evt);
            }
        });

        TxtNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNomActionPerformed(evt);
            }
        });

        LbCommentaires.setText("Commentaires");

        LbPublic.setText("Public visé");

        LbStructure.setText("Strucutre de profil associée");

        LbStatut.setText("Statut");

        LbCreateur.setText("Créateur");

        LbDateModif.setText("Date de dernière modification");

        LbDateCrea.setText("Date de création");

        LbNom.setText("Nom");

        LbLogiciel.setText("Logiciel");

        TxtLogiciel.setEditable(false);
        TxtLogiciel.setText("Protege");
        TxtLogiciel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtLogicielActionPerformed(evt);
            }
        });

        LbDescription.setText("Description technique associée");

        TxtDescription.setEditable(false);
        TxtDescription.setText("Description technique");

        LbType.setText("Type de logiciel");

        TxtType.setEditable(false);
        TxtType.setText("Java");
        TxtType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(BtRetour, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(BtSuivant, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LbNom)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LbDateCrea)
                                    .addComponent(LbCreateur)
                                    .addComponent(LbStatut)
                                    .addComponent(LbCommentaires))
                                .addGap(127, 127, 127)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtStructure, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(RBPublic)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                                        .addComponent(RBPrive)
                                        .addGap(61, 61, 61))
                                    .addComponent(TxtCreateur)
                                    .addComponent(TxtDateCrea)
                                    .addComponent(TxtDateModif)
                                    .addComponent(TxtNom)
                                    .addComponent(TxtLogiciel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TxtCommentaires, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TxtType, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(LbDateModif)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LbPublic)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(LbDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(LbStructure, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtPublic)
                                    .addComponent(TxtDescription))))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LbType)
                            .addComponent(LbLogiciel))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbNom)
                    .addComponent(TxtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbLogiciel)
                    .addComponent(TxtLogiciel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(LbType))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtDateCrea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbDateCrea))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbDateModif, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtDateModif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbCreateur)
                    .addComponent(TxtCreateur))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbStatut)
                    .addComponent(RBPrive)
                    .addComponent(RBPublic))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbStructure)
                    .addComponent(TxtStructure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbDescription)
                    .addComponent(TxtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbPublic)
                    .addComponent(TxtPublic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbCommentaires)
                    .addComponent(TxtCommentaires, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtRetour)
                    .addComponent(BtSuivant))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSuivantActionPerformed
        if (TxtNom.getText().length() != 0) 
        {
            //on sauvegarde les metadonnees
            Main.FichierAssistance.metadonnees.removeContent();
            
            //L'assistance
            Element courant = new Element("assistance");
            courant.setAttribute("nom", TxtNom.getText());
            courant.setAttribute("logiciel", TxtLogiciel.getText());
            courant.setAttribute("type", TxtType.getText());
            courant.setAttribute("interface", TxtDescription.getText());
            if (RBPublic.isSelected()) {
                courant.setAttribute("statut", "public");
            } else {
                courant.setAttribute("statut", "prive");
            }
            courant.setAttribute("public", TxtPublic.getText());
            Main.FichierAssistance.metadonnees.addContent(courant);
            
            //La création
            courant = new Element("creation");
            courant.setAttribute("date_creation", TxtDateCrea.getText());
            courant.setAttribute("date_modification", TxtDateModif.getText());
            courant.setAttribute("createur", TxtCreateur.getText());
            Main.FichierAssistance.metadonnees.addContent(courant);
            
            //La structure de profil associee
            courant = new Element("personnalisation");
            courant.setAttribute("structure_profil_statique", Main.Cste.structureProfils);
            courant.setAttribute("id_structure_profil_statique", idStructure(Main.Cste.structureProfils));
            Main.FichierAssistance.metadonnees.addContent(courant);
            
            //Les commentaires
            courant = new Element("commentaires");
            courant.setText(TxtCommentaires.getText());
            Main.FichierAssistance.metadonnees.addContent(courant);

            Main.FichierAssistance.enregistre(TxtNom.getText() + ".xml", Main.Cste.cheminDescriptions+Main.Cste.logiciel+"/");
            this.setVisible(false);
            Main.EcranAccueil.chargerInterface();
            Main.EcranAccueil.setVisible(true);
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "il faut remplir correctement", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtSuivantActionPerformed

    private void BtRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRetourActionPerformed
        Main.CreationRegles.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BtRetourActionPerformed

    private void TxtCreateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCreateurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCreateurActionPerformed

    private void TxtDateCreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDateCreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDateCreaActionPerformed

    private void TxtNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNomActionPerformed

    private void TxtLogicielActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtLogicielActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtLogicielActionPerformed

    private void TxtTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtTypeActionPerformed

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
            java.util.logging.Logger.getLogger(SauveAssistance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SauveAssistance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SauveAssistance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SauveAssistance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SauveAssistance().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtRetour;
    private javax.swing.JButton BtSuivant;
    private javax.swing.JLabel LbCommentaires;
    private javax.swing.JLabel LbCreateur;
    private javax.swing.JLabel LbDateCrea;
    private javax.swing.JLabel LbDateModif;
    private javax.swing.JLabel LbDescription;
    private javax.swing.JLabel LbLogiciel;
    private javax.swing.JLabel LbNom;
    private javax.swing.JLabel LbPublic;
    private javax.swing.JLabel LbStatut;
    private javax.swing.JLabel LbStructure;
    private javax.swing.JLabel LbType;
    private javax.swing.JRadioButton RBPrive;
    private javax.swing.JRadioButton RBPublic;
    private java.awt.TextArea TxtCommentaires;
    private javax.swing.JTextField TxtCreateur;
    private javax.swing.JTextField TxtDateCrea;
    private javax.swing.JTextField TxtDateModif;
    private javax.swing.JTextField TxtDescription;
    private javax.swing.JTextField TxtLogiciel;
    private javax.swing.JTextField TxtNom;
    private javax.swing.JTextField TxtPublic;
    private javax.swing.JTextField TxtStructure;
    private javax.swing.JTextField TxtType;
    // End of variables declaration//GEN-END:variables
}
