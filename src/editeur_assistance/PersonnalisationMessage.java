/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

import java.awt.Color;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.util.Enumeration;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import org.jdom.Attribute;
import org.jdom.Element;

/**
 *
 * @author Blandine
 */
public class PersonnalisationMessage extends javax.swing.JFrame {

    public int largeur_brique=150;
    public int hauteur_brique=50;
    public Color couleur0=Color.red;
    public Color couleur1=Color.green;
    public Color couleur2=Color.yellow;
    public Color couleur3=Color.blue;
    public Color couleur_mortier=Color.pink;
    public Color couleur_brique=Color.white;
    public int taille_echelle=0;
    public String [] id_briqueCourante;

    public PersonnalisationMessage() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    
    public void chargerInterface()
    {
        this.setLayout(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/icone_editeur.png"));
        this.setIconImage(icon);
        //this.setBounds(100, 50, 3*largeur_brique+55, 710);
        this.setBounds(150, 50, 690, 750);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ChargerLangue();
        
        LbSelection.setBounds(20, 10, 300, 20);
        
        Mur.setBackground(Color.lightGray);
        ScrollMur.setBounds(10, this.getHeight()-(4*hauteur_brique+125), 3*largeur_brique+20, 4*hauteur_brique+25);
        Mur.setBounds(0, 0, ScrollMur.getWidth(), ScrollMur.getHeight());
        Mur.removeAll();
        construireMur();
        
        Arbre.setModel(null);
        Arbre.setBounds(0, 0, this.getHeight()-50, 4*hauteur_brique+25);
        ScrollArbre.setBounds(10, 40, ScrollMur.getWidth(), this.getHeight()/2);

        BtAnnuler.setBounds((this.getWidth()-100)/2-60, this.getHeight()-80, 100, 30);
        BtSuivant.setBounds((this.getWidth()-100)/2+60, this.getHeight()-80, 100, 30);
        BtSuivant.setEnabled(false);
    }
    
    private void ChargerLangue()
    {
        XMLFonctions.OuvrirXML(Main.Cste.fichierInterfaceEditeur);
        Element courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("Titre").getChild(Main.Cste.langue);
        Element courant2= (Element) XMLFonctions.racine.getChild("personnaliserMessage").getChild("Titre").getChild(Main.Cste.langue);
        this.setTitle(courant.getText()+courant2.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("personnaliserMessage").getChild("LbSelection").getChild(Main.Cste.langue);
        LbSelection.setText(courant.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnuler.setText(courant.getText());       
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("BtSuivant").getChild(Main.Cste.langue);
        BtSuivant.setText(courant.getText()); 
    }
    
    public void afficheSSCompo(DefaultMutableTreeNode Branche, Element composante)
    {
        for(int i=0; i<composante.getChildren().size(); i++)
        {
            Element sousCompo=(Element) composante.getChildren().get(i);
            if(sousCompo.getName().equals("sous_composante"))
            {
                DefaultMutableTreeNode ss = new DefaultMutableTreeNode(sousCompo.getAttributeValue("nom"));
                Branche.add(ss);
                Element valeur=(Element) sousCompo.getChild("valeur");
                if(valeur==null) //si c'est pas une feuille
                {
                    afficheSSCompo(ss, sousCompo);
                }
            }
        }
    }

    public void cliqueBrique(int compo)
    {
        //on change les couleurs
        Panel p=(Panel) Mur.getComponent(compo);
        if(p.getBackground()!=couleur_brique && p.getBackground()!=couleur3)
        {
            JButton bt=(JButton) p.getComponent(0);
            Color couleur=p.getBackground();
            p.setBackground(bt.getBackground());
            for(int i=0; i<Mur.getComponentCount(); i++)
            {
                Panel pp=(Panel) Mur.getComponent(i);
                if(pp.getComponentCount()!=0)
                {
                    JButton b=(JButton) pp.getComponent(0);
                    if(b.getBackground()!= bt.getBackground())
                    {
                        pp.setBackground(b.getBackground());
                        b.setBackground(bt.getBackground());
                    }
                }
            }
            bt.setBackground(couleur);
            bt.setFocusPainted(false);

            //on affiche l'abre de la brique
            DefaultMutableTreeNode root = new DefaultMutableTreeNode(bt.getText());

            XMLFonctions.OuvrirXML(Main.Cste.cheminStructuresProfils+Main.Cste.structureProfils);
            Element courant=XMLFonctions.racine;
            Element brique=(Element) courant.getChildren().get(bt.getMnemonic());
            Element arbre=(Element) brique.getChild("arbre_des_composantes");
            if(arbre!=null)
            {
                for(int i=0; i<arbre.getChildren().size(); i++)
                {
                    Element composante=(Element) arbre.getChildren().get(i);
                    DefaultMutableTreeNode Branche1 = new DefaultMutableTreeNode(composante.getAttributeValue("nom"));
                    root.add(Branche1);

                    //on affiche les sous composantes
                    Element valeur=(Element) composante.getChild("valeur");
                    if(valeur==null) //si c'est pas une feuille
                    {
                        afficheSSCompo(Branche1, composante);
                    }
                }
            }
            else
            {
                Element text=(Element) brique.getChild("texte");
                if(text!=null)
                {
                    DefaultMutableTreeNode Branchetext = new DefaultMutableTreeNode(text.getName());
                    root.add(Branchetext);
                }
            }

            DefaultTreeModel model = new DefaultTreeModel(root);
            Arbre.setModel(model);
            etendreArbre();
        }
        else
        {
            if(p.getBackground()==couleur3)
            {
                JOptionPane.showMessageDialog(null, "raté!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    public void construireMur()
    {
         XMLFonctions.OuvrirXML(Main.Cste.cheminStructuresProfils+Main.Cste.structureProfils);
         Element courant=XMLFonctions.racine;
         int pos=1;
         int fausse=0;
         for(int i=0; i<courant.getChildren().size(); i++)
         {
             
             Element brique=(Element) courant.getChildren().get(i);
             Attribute nom=(Attribute) brique.getAttribute("nom");
             Attribute type=(Attribute) brique.getAttribute("type");
             Panel p=new Panel();
             p.setLayout(null);
             
             if(type.getValue().toString().equals("0"))
                p.setBackground(couleur0);
             if(type.getValue().toString().equals("1"))
                p.setBackground(couleur1);
             if(type.getValue().toString().equals("2"))
                p.setBackground(couleur2);
             if(type.getValue().toString().equals("3"))
                p.setBackground(couleur3);
             JButton bt=new JButton(nom.getValue().toString());
             bt.setBounds(5, 5, largeur_brique-10, hauteur_brique-10);
             bt.setBackground(couleur_brique);
             bt.setName("brique");
             bt.addActionListener(new ActionBouton());
             bt.setMnemonic(i);
             p.add(bt);
             Mur.add(p);
             int t=i % 5;
             if(t==0 && i!=0)
             {
                 pos=pos+2;
                 fausse=fausse+2;
             }
             if(t<3)
             {
                 p.setBounds((5+(largeur_brique+5)*t), Mur.getHeight()-55*pos, largeur_brique, hauteur_brique);
             }
            else
             {
                 p.setBounds(((largeur_brique/2+5)+(largeur_brique+5)*(t-3)), Mur.getHeight()-(55*(pos+1)), largeur_brique, hauteur_brique);
             }
         }
         if ((courant.getChildren().size()%5)==0)
             fausse=fausse+2;
         else
             if((courant.getChildren().size()%5)>3)
                 fausse++;
         for(int j=0; j<fausse; j++)
         {
            Panel p=new Panel();            
            p.setBackground(couleur_mortier);
            if((j % 2 ) == 0)
            {
                 p.setBounds(5, Mur.getHeight()-(55*(j+2)), largeur_brique/2-5, hauteur_brique);
            }
            else
            {
                p.setBounds(5+largeur_brique/2+2*(largeur_brique+5),  Mur.getHeight()-(55*(j+1)), Mur.getWidth()-(5+largeur_brique/2+2*(largeur_brique+5))-5, hauteur_brique);
            }
            Mur.add(p);
         }

    }
    
    public void etendreArbre()
    {
        Enumeration e = ((DefaultMutableTreeNode) Arbre.getModel().getRoot()).preorderEnumeration();
        while (e.hasMoreElements()) 
        {
            Arbre.expandPath(new TreePath(((DefaultMutableTreeNode)e.nextElement()).getPath()));
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

        ScrollArbre = new javax.swing.JScrollPane();
        Arbre = new javax.swing.JTree();
        BtSuivant = new javax.swing.JButton();
        BtAnnuler = new javax.swing.JButton();
        ScrollMur = new javax.swing.JScrollPane();
        Mur = new java.awt.Panel();
        LbSelection = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Arbre.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                ArbreValueChanged(evt);
            }
        });
        ScrollArbre.setViewportView(Arbre);

        BtSuivant.setText("Suivant");
        BtSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSuivantActionPerformed(evt);
            }
        });

        BtAnnuler.setText("Annuler");
        BtAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerActionPerformed(evt);
            }
        });

        ScrollMur.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollMur.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        ScrollMur.setPreferredSize(new java.awt.Dimension(74, 322));

        javax.swing.GroupLayout MurLayout = new javax.swing.GroupLayout(Mur);
        Mur.setLayout(MurLayout);
        MurLayout.setHorizontalGroup(
            MurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 711, Short.MAX_VALUE)
        );
        MurLayout.setVerticalGroup(
            MurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        ScrollMur.setViewportView(Mur);

        LbSelection.setText("Selectionner un élément du profil de l'utilisateur :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollMur, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(BtAnnuler)
                            .addGap(145, 145, 145)
                            .addComponent(BtSuivant)
                            .addGap(228, 228, 228))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(ScrollArbre, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)))
                    .addComponent(LbSelection)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(LbSelection)
                .addGap(45, 45, 45)
                .addComponent(ScrollArbre, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(ScrollMur, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtSuivant)
                    .addComponent(BtAnnuler))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BtAnnulerActionPerformed

    private void BtSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSuivantActionPerformed
        Main.CreationRegles.ajouterBaliseMessage("%"+Arbre.getSelectionPath()+"%");
        this.setVisible(false);
    }//GEN-LAST:event_BtSuivantActionPerformed

    private void ArbreValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_ArbreValueChanged
        if (!Arbre.isSelectionEmpty()) 
            {
                BtSuivant.setEnabled(true);                
            } else // il n'y a pas de selection dans l'arbre
            {
                BtSuivant.setEnabled(false);
            }
    }//GEN-LAST:event_ArbreValueChanged

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
            java.util.logging.Logger.getLogger(PersonnalisationMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonnalisationMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonnalisationMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonnalisationMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PersonnalisationMessage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree Arbre;
    private javax.swing.JButton BtAnnuler;
    private javax.swing.JButton BtSuivant;
    private javax.swing.JLabel LbSelection;
    private java.awt.Panel Mur;
    private javax.swing.JScrollPane ScrollArbre;
    private javax.swing.JScrollPane ScrollMur;
    // End of variables declaration//GEN-END:variables
}
