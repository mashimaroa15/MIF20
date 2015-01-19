/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.jdom.Element;

/**
 *
 * @author Blandine
 */
public class EcranAccueil extends javax.swing.JFrame {

    private String itemAppliJava="Application Java";
    private String itemAppliWindows="Exécutable Windows";
    private String itemAppliWeb="Application web";
    
    public String appliJava="Application Java";
    public String appliWindows="Application Windows";
    public String appliWeb="Application web";
    
    public String itemNouvelleDescription = "Nouvelle description...";
    public String itemNouveauLogiciel = "__Ajouter un logiciel__";
    public String itemNouveauSA = "__Nouveau système d'assistance__";
    public String itemAucune = "Aucune";
    
    public String chemin="";
    /**
     * Creates new form EcranAccueil
     */
    public EcranAccueil() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(200, 200, 690, 500);
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/icone_editeur.png"));
        this.setIconImage(icon);
        
        LbChoixLogiciel.setBounds(280, 0, 260, 50);
               
        int x1=230;
        int x2=420;
        int d=20;
        
        LbLogiciel.setBounds(x1, d+30, 180, 24);
        CbChoixLogiciel.setBounds(x2, d+30, 230, 24);
        
        LbNomSA.setBounds(x1, d+60, 180, 24);
        CbNomSA.setBounds(x2, d+60, 230, 24);
        
        LbType.setBounds(x1, d+90, 180, 24);
        CbType.setBounds(x2, d+90, 230, 24);
        
        LbDescription.setBounds(x1, d+120, 180, 24);
        CbDescription.setBounds(x2, d+120, 230, 24);
        
        LbStructure.setBounds(x1, d+150, 180, 24);
        CbStructure.setBounds(x2, d+150, 230, 24);
        
        PanelApercu.setBounds(220, 220, 450, 170);
        PanelApercu.setLayout(null);
        
        int col1=10;
        int col2=190;
        int col3=230;
        int hesp=27;
        int h=24;
        int debut = 12;
        
        
        LbDateCrea.setBounds(col1, debut, col2, h);
        TxtDateCrea.setBounds(col2+10, debut, col3, h);
        
        LbCreateur.setBounds(col1, debut+hesp, col2, h);
        TxtCreateur.setBounds(col2+10, debut+hesp, col3, h);      
        
        LbPublic.setBounds(col1, debut+hesp*2, col2, h);
        TxtPublic.setBounds(col2+10, debut+hesp*2, col3, h);
        
        LbCommentaires.setBounds(col1, debut+hesp*3, col2, h);
        ScrollTxtCommentaires.setBounds(col2+10, debut+hesp*3, col3, 70);
        TxtCommentaires.setLineWrap(true);
        TxtCommentaires.setWrapStyleWord(true);
        
        PanelDrapeau.setBounds(615, 5, 50, 30);
        PanelDrapeau.removeAll();
        
        Image icone=getToolkit().getImage(this.getClass().getResource("/images/drapeau_en.gif"));
        JLabel j = new JLabel(new ImageIcon(icone));
        j.setBounds(0, 0, PanelDrapeau.getWidth(), PanelDrapeau.getHeight());
        
        PanelDrapeau.add(j);
        PanelDrapeau.setBackground(PanelDrapeau.getParent().getBackground());
        PanelDrapeau.repaint();
        
        PanelImage.setBounds(10, 10, 190, 300);       
        icone=getToolkit().getImage(this.getClass().getResource("/images/editeur.png"));
        j = new JLabel( new ImageIcon(icone));
        j.setBounds(0, 0, PanelImage.getWidth(), PanelImage.getHeight());
        PanelImage.add(j);
        PanelImage.setBackground(PanelImage.getParent().getBackground());
        
        
        LbDescriptionEditeur.setBounds(5, 300, 210, 120);

        BtSuivant.setBounds((this.getWidth()-300)/2, this.getHeight()-90, 300, 30);
    }

    public void chargerInterface()
    {                       
        chargerLangue();
        CbType.removeAllItems();
        CbType.addItem(itemAppliJava);
        CbType.addItem(itemAppliWindows);
        CbType.addItem(itemAppliWeb);
        chargerCbStructure();
        chargerCbChoixLogiciel(CbChoixLogiciel); 
        if(!Main.Cste.logiciel.isEmpty())
        {
            CbChoixLogiciel.setSelectedItem(Main.Cste.logiciel);
            if(!Main.Cste.nomSA.isEmpty())
            {
                CbNomSA.setSelectedItem(Main.Cste.nomSA);
            }
        }
    }
    
    public void chargerLangue()
    {
        Image icone=getToolkit().getImage(this.getClass().getResource("/images/drapeau_en.gif"));
        if (Main.Cste.langue.equals("en"))
            icone=getToolkit().getImage(this.getClass().getResource("/images/drapeau_fr.gif"));
        
        PanelDrapeau.removeAll();
        JLabel j = new JLabel(new ImageIcon(icone));
        j.setBounds(0, 0, PanelDrapeau.getWidth(), PanelDrapeau.getHeight());
        
        PanelDrapeau.add(j);
        PanelDrapeau.setBackground(PanelDrapeau.getParent().getBackground());
        PanelDrapeau.repaint();
        
        XMLFonctions.OuvrirXML(Main.Cste.fichierInterfaceEditeur);
        Element courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("Titre").getChild(Main.Cste.langue);
        Element courant2= (Element) XMLFonctions.racine.getChild("Accueil").getChild("Titre").getChild(Main.Cste.langue);
        this.setTitle(courant.getText()+courant2.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("chargerAssistance").getChild("LbChoixLogiciel").getChild(Main.Cste.langue);
        LbChoixLogiciel.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("chargerAssistance").getChild("LbNom").getChild(Main.Cste.langue);
        LbNomSA.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("chargerAssistance").getChild("LbLogiciel").getChild(Main.Cste.langue);
        LbLogiciel.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("chargerAssistance").getChild("LbType").getChild(Main.Cste.langue);
        LbType.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("chargerAssistance").getChild("LbDateCrea").getChild(Main.Cste.langue);
        LbDateCrea.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("chargerAssistance").getChild("LbCreateur").getChild(Main.Cste.langue);
        LbCreateur.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("chargerAssistance").getChild("LbStructure").getChild(Main.Cste.langue);
        LbStructure.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("chargerAssistance").getChild("LbDescription").getChild(Main.Cste.langue);
        LbDescription.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("chargerAssistance").getChild("LbPublic").getChild(Main.Cste.langue);
        LbPublic.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("chargerAssistance").getChild("LbCommentaires").getChild(Main.Cste.langue);
        LbCommentaires.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("Accueil").getChild("LbDescription").getChild(Main.Cste.langue);
        LbDescriptionEditeur.setText(courant.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("Accueil").getChild("BtSuivant").getChild(Main.Cste.langue);
        BtSuivant.setText(courant.getText());
    }
    
    private void chargerCbChoixLogiciel(JComboBox cb)
    {
        File repertoire = new File(Main.Cste.cheminDescriptions);
        FonctionsUtiles.CBlister(repertoire, cb, "");
        cb.addItem(itemNouveauLogiciel);
    }
    
    private void chargerListe()
    {
        File repertoire = new File(Main.Cste.cheminDescriptions+"/"+CbChoixLogiciel.getSelectedItem().toString());
        FonctionsUtiles.CBlister(repertoire, CbNomSA, ".xml");
        CbNomSA.addItem(itemNouveauSA);
    }
    
    private void nouveauSA(boolean bool)
    {
        CbNomSA.setEditable(bool);
        CbType.setEnabled(bool);
        CbDescription.setEnabled(bool);
        CbStructure.setEnabled(bool);
        if(!bool)
        {
            chargerSA();  
            chargerCbDescription(CbChoixLogiciel.getSelectedItem().toString());
        } 
        else
        {
            CbStructure.setSelectedItem(itemAucune);
            viderPanelApercu();
        }
    }
    
    private void viderPanelApercu()
    {
        TxtDateCrea.setText("");
        TxtCreateur.setText("");
        TxtPublic.setText("");
        TxtCommentaires.setText("");
    }
    
    private void chargerCbDescription(String appli){
        File repertoire = new File(Main.Cste.cheminDescriptions+"/"+appli);
        FonctionsUtiles.CBlister(repertoire, CbDescription, ".interface");
        CbDescription.addItem(itemNouvelleDescription);        
    }
    
    public void  entourerComposant(Component c) 
    {
        Graphics g;
        Rectangle b;

	if (c != null) 
        {
            b = c.getBounds();
	    Container parent = c.getParent();
            g = parent.getGraphics();
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3, BasicStroke.JOIN_ROUND, BasicStroke.CAP_BUTT));
            g2.setColor(Color.blue);
            g2.drawRoundRect(b.x-2, b.y-2, b.width+4, b.height+4, 0, 0);
        }
    }
    
    private void chargerCbStructure(){
        File repertoire = new File(Main.Cste.cheminStructuresProfils);
        FonctionsUtiles.CBlister(repertoire, CbStructure, ".str");
        CbStructure.insertItemAt(itemAucune, 0);
    }
    
    private void chargerSA()
    {CbStructure.setEnabled(true);
        if(CbNomSA.getSelectedIndex()>=0 &&!CbNomSA.isEditable())
        {
            XMLFonctions.OuvrirXML(Main.Cste.cheminDescriptions+CbChoixLogiciel.getSelectedItem().toString()+"/"+CbNomSA.getSelectedItem());
            Element metadonnees = (Element) XMLFonctions.racine.getChild("metadonnees");

            String item = itemAppliWindows;
            if(metadonnees.getChild("assistance").getAttributeValue("type").equals(appliJava))
                item=itemAppliJava;
            else if(metadonnees.getChild("assistance").getAttributeValue("type").equals(appliWeb))
                item=itemAppliWeb;
            CbType.setSelectedItem(item);
            TxtDateCrea.setText(metadonnees.getChild("creation").getAttributeValue("date_creation"));
            TxtCreateur.setText(metadonnees.getChild("creation").getAttributeValue("createur"));
            CbDescription.setSelectedItem(metadonnees.getChild("assistance").getAttributeValue("interface"));
            if(metadonnees.getChild("personnalisation").getAttributeValue("structure_profil_statique").isEmpty())
            {
                CbStructure.setSelectedItem(itemAucune);
            }
            else
                CbStructure.setSelectedItem(metadonnees.getChild("personnalisation").getAttributeValue("structure_profil_statique"));

            TxtPublic.setText(metadonnees.getChild("assistance").getAttributeValue("public"));
            TxtCommentaires.setText(metadonnees.getChildText("commentaires"));
        }
        else
            viderPanelApercu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelApercu = new javax.swing.JPanel();
        TxtDateCrea = new javax.swing.JTextField();
        LbPublic = new javax.swing.JLabel();
        LbCommentaires = new javax.swing.JLabel();
        LbCreateur = new javax.swing.JLabel();
        TxtCreateur = new javax.swing.JTextField();
        TxtPublic = new javax.swing.JTextField();
        LbDateCrea = new javax.swing.JLabel();
        ScrollTxtCommentaires = new javax.swing.JScrollPane();
        TxtCommentaires = new javax.swing.JTextArea();
        LbChoixLogiciel = new javax.swing.JLabel();
        CbChoixLogiciel = new javax.swing.JComboBox();
        BtSuivant = new javax.swing.JButton();
        LbLogiciel = new javax.swing.JLabel();
        LbNomSA = new javax.swing.JLabel();
        LbType = new javax.swing.JLabel();
        LbDescription = new javax.swing.JLabel();
        LbStructure = new javax.swing.JLabel();
        CbNomSA = new javax.swing.JComboBox();
        CbType = new javax.swing.JComboBox();
        CbDescription = new javax.swing.JComboBox();
        LbDescriptionEditeur = new javax.swing.JLabel();
        PanelImage = new javax.swing.JPanel();
        PanelDrapeau = new javax.swing.JPanel();
        CbStructure = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PanelApercu.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations"));

        TxtDateCrea.setEditable(false);
        TxtDateCrea.setText("09/01/2011");

        LbPublic.setText("Public visé");

        LbCommentaires.setText("Commentaires");

        LbCreateur.setText("Créateur");

        TxtCreateur.setText("Prof");

        TxtPublic.setText("classe de 6eC");

        LbDateCrea.setText("Date de création");

        ScrollTxtCommentaires.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollTxtCommentaires.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        TxtCommentaires.setColumns(20);
        TxtCommentaires.setRows(5);
        TxtCommentaires.setWrapStyleWord(true);
        ScrollTxtCommentaires.setViewportView(TxtCommentaires);

        javax.swing.GroupLayout PanelApercuLayout = new javax.swing.GroupLayout(PanelApercu);
        PanelApercu.setLayout(PanelApercuLayout);
        PanelApercuLayout.setHorizontalGroup(
            PanelApercuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelApercuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelApercuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbDateCrea)
                    .addComponent(LbCreateur)
                    .addComponent(LbPublic)
                    .addComponent(LbCommentaires))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelApercuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelApercuLayout.createSequentialGroup()
                        .addComponent(TxtPublic, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                        .addGap(141, 141, 141))
                    .addGroup(PanelApercuLayout.createSequentialGroup()
                        .addComponent(TxtDateCrea, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelApercuLayout.createSequentialGroup()
                        .addGroup(PanelApercuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ScrollTxtCommentaires)
                            .addComponent(TxtCreateur))
                        .addGap(90, 90, 90))))
        );
        PanelApercuLayout.setVerticalGroup(
            PanelApercuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelApercuLayout.createSequentialGroup()
                .addGroup(PanelApercuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbDateCrea)
                    .addComponent(TxtDateCrea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelApercuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbCreateur)
                    .addComponent(TxtCreateur))
                .addGap(18, 18, 18)
                .addGroup(PanelApercuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbPublic)
                    .addComponent(TxtPublic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelApercuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbCommentaires)
                    .addComponent(ScrollTxtCommentaires, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        LbChoixLogiciel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LbChoixLogiciel.setText("Définition d'un système d'assistance");

        CbChoixLogiciel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbChoixLogiciel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbChoixLogicielItemStateChanged(evt);
            }
        });

        BtSuivant.setText("Définir les règles d'assistance");
        BtSuivant.setToolTipText("Créer ou modifier les règles d'assistance");
        BtSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSuivantActionPerformed(evt);
            }
        });

        LbLogiciel.setText("Logiciel");

        LbNomSA.setText("System d'assistance");

        LbType.setText("Type de logiciel");

        LbDescription.setText("Description technique associée");

        LbStructure.setText("Strucutre de profil associée");

        CbNomSA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbNomSA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbNomSAItemStateChanged(evt);
            }
        });

        CbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbTypeItemStateChanged(evt);
            }
        });

        CbDescription.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbDescription.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbDescriptionItemStateChanged(evt);
            }
        });

        LbDescriptionEditeur.setText("L'étidteur vous permet de spécifier ");

        PanelImage.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout PanelImageLayout = new javax.swing.GroupLayout(PanelImage);
        PanelImage.setLayout(PanelImageLayout);
        PanelImageLayout.setHorizontalGroup(
            PanelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );
        PanelImageLayout.setVerticalGroup(
            PanelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );

        PanelDrapeau.setBackground(new java.awt.Color(255, 204, 204));
        PanelDrapeau.setToolTipText("blabla");
        PanelDrapeau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelDrapeauMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelDrapeauLayout = new javax.swing.GroupLayout(PanelDrapeau);
        PanelDrapeau.setLayout(PanelDrapeauLayout);
        PanelDrapeauLayout.setHorizontalGroup(
            PanelDrapeauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );
        PanelDrapeauLayout.setVerticalGroup(
            PanelDrapeauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        CbStructure.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbStructure.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbStructureItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbDescriptionEditeur, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(PanelImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(LbLogiciel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CbChoixLogiciel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(LbNomSA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CbNomSA, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(LbType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CbType, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LbDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CbDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(LbStructure, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CbStructure, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelApercu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LbChoixLogiciel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelDrapeau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
            .addGroup(layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(BtSuivant, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LbChoixLogiciel)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(PanelDrapeau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LbLogiciel)
                            .addComponent(CbChoixLogiciel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbNomSA)
                            .addComponent(CbNomSA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbType)
                            .addComponent(CbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LbDescription))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LbStructure)
                            .addComponent(CbStructure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(PanelApercu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(LbDescriptionEditeur)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtSuivant)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CbChoixLogicielItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbChoixLogicielItemStateChanged
        if (CbChoixLogiciel.getItemCount() > 0) 
        {
            if(CbChoixLogiciel.getSelectedItem().equals(itemNouveauLogiciel) || CbChoixLogiciel.isEditable())
            {
                CbChoixLogiciel.setEditable(true);
                CbNomSA.setSelectedItem(itemNouveauSA);
                CbDescription.removeAllItems();
                CbDescription.setSelectedIndex(-1);
                CbDescription.addItem("");
                CbDescription.addItem(itemNouvelleDescription);
                JComboBox cb = new JComboBox();
                chargerCbChoixLogiciel(cb);
                cb.setSelectedItem(itemNouveauLogiciel);
                CbChoixLogiciel.setEditable(CbChoixLogiciel.getSelectedIndex()==cb.getSelectedIndex());
                viderPanelApercu();
            }
            else
            {
                chargerListe();           
                chargerSA();
                CbChoixLogiciel.setEditable(false);
            }
        }
    }//GEN-LAST:event_CbChoixLogicielItemStateChanged

    private void BtSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSuivantActionPerformed
       if(CbChoixLogiciel.getSelectedItem().equals(itemNouveauLogiciel) || CbChoixLogiciel.getSelectedItem().toString().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Vous devez indiquer le nom du logiciel cible", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(CbNomSA.getSelectedItem().equals(itemNouveauSA) || CbNomSA.getSelectedItem().toString().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Vous devez indiquer le nom du logiciel cible", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(CbDescription.getSelectedIndex()<0 || CbDescription.getSelectedItem().equals(itemNouvelleDescription) || CbDescription.getSelectedItem().toString().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Vous devez choisir une description technique pour le logiciel cible", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            Main.SauveAssistance.type = CbType.getSelectedItem().toString();
            Main.Cste.logiciel = CbChoixLogiciel.getSelectedItem().toString();
            Main.Cste.nomSA = CbNomSA.getSelectedItem().toString();
            Main.Cste.descriptionInterface = CbDescription.getSelectedItem().toString();

            File f1=new File(Main.Cste.cheminDescriptions + CbChoixLogiciel.getSelectedItem().toString() + "/" + CbNomSA.getSelectedItem());
            if(f1.exists())
            {
                XMLFonctions.OuvrirXML(Main.Cste.cheminDescriptions + CbChoixLogiciel.getSelectedItem().toString() + "/" + CbNomSA.getSelectedItem());
                Main.CreationRegles.ouvrirDescriptionAssistance((Element) XMLFonctions.racine);
            }
            else
            {
                Main.CreationRegles.chargerInterface();
            }


            Main.CreationRegles.ouvrirComposants();
            Main.CreationRegles.setVisible(true);
            Main.EcranAccueil.setVisible(false);
            
            Main.SauveAssistance.commentaires=TxtCommentaires.getText();
            Main.SauveAssistance.createur=TxtCreateur.getText();
            Main.SauveAssistance.date=TxtDateCrea.getText();
            
            if(CbNomSA.getSelectedItem().toString().endsWith(".xml"))
                Main.SauveAssistance.nom=CbNomSA.getSelectedItem().toString().substring(0, CbNomSA.getSelectedItem().toString().indexOf(".xml"));
            else
                Main.SauveAssistance.nom=CbNomSA.getSelectedItem().toString();
            Main.SauveAssistance.publicVise=TxtPublic.getText();
        }
    }//GEN-LAST:event_BtSuivantActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void CbNomSAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbNomSAItemStateChanged
        if(CbNomSA.getSelectedIndex()>=0)
        {
            nouveauSA(CbNomSA.getSelectedItem().equals(itemNouveauSA));
        }
    }//GEN-LAST:event_CbNomSAItemStateChanged

    private void CbTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbTypeItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_CbTypeItemStateChanged

    private void CbDescriptionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbDescriptionItemStateChanged
        if(CbDescription.getSelectedIndex()>=0 && CbDescription.getSelectedItem().equals(itemNouvelleDescription))
        {
            String nomDescription="";  //va contenir le nom du fichier de description que choisira l'utilisateur
            Process p;
            if(CbChoixLogiciel.isEditable())    //si c'est un nouveu logiciel
            {            
                if(!CbChoixLogiciel.getSelectedItem().toString().equals("") && !CbChoixLogiciel.getSelectedItem().toString().equals(itemNouveauLogiciel) )
                {               
                    File f1=new File(Main.Cste.cheminDescriptions+CbChoixLogiciel.getSelectedItem().toString());
                    if(!f1.exists())
                    { 
                        //on crée le répertoire du nom du logiciel, il contiendra les futures descriptions de l'assistance souhaitée et la description de l'interface
                        f1.mkdir();
                        chemin=System.getProperty("user.dir" )+"/"+Main.Cste.cheminDescriptions+CbChoixLogiciel.getSelectedItem().toString();
                        Runtime runtime = Runtime.getRuntime();
                        if(CbType.getSelectedItem().equals(itemAppliJava)) //Si c'est une application Java
                        {
                            try 
                            {
                                p=runtime.exec(new String[] { Main.Cste.exeDescriptionInterfaceJava, chemin } );
                                try 
                                {
                                    p.waitFor();
                                    BufferedReader is;  // reader for output of process
                                    is = new BufferedReader(new InputStreamReader(p.getInputStream()));
                                    nomDescription = is.readLine();
                                } 
                                catch (InterruptedException ex) 
                                {
                                    Logger.getLogger(EcranAccueil.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } 
                            catch (IOException ex) 
                            {
                                Logger.getLogger(EcranAccueil.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else if(CbType.getSelectedItem().equals(itemAppliWindows))   //Sinon c'est une application Windows
                        {
                        try 
                            {
                                p=runtime.exec(new String[] { Main.Cste.exeDescriptionInterfaceWindows, chemin } );
                                try 
                                {
                                    p.waitFor();
                                    BufferedReader is;  // reader for output of process
                                    is = new BufferedReader(new InputStreamReader(p.getInputStream()));
                                    nomDescription = is.readLine();
                                } 
                                catch (InterruptedException ex) 
                                {
                                    Logger.getLogger(EcranAccueil.class.getName()).log(Level.SEVERE, null, ex);
                                }



                            } catch (IOException ex) {
                                Logger.getLogger(EcranAccueil.class.getName()).log(Level.SEVERE, null, ex);
                            }


                        }
                        else    //sinon c'est une application web
                        {
                            Main.DescriptionInterfaceWeb.chargerInterface();
                            Main.DescriptionInterfaceWeb.setVisible(true);
                        }
                        chargerCbDescription(CbChoixLogiciel.getSelectedItem().toString());
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Vous devez préciser le nom du logiciel","Attention",2, null);
                    CbChoixLogiciel.requestFocus();
                }
            }
            else    //c'est un logiciel existant
            {
                File f1=new File(Main.Cste.cheminDescriptions+CbChoixLogiciel.getSelectedItem().toString());
                if(!f1.exists())
                { 
                    //on crée le répertoire du nom du logiciel, il contiendra les futures descriptions de l'assistance souhaitée et la description de l'interface
                    f1.mkdir();
                }
                chemin=System.getProperty("user.dir" )+"/"+Main.Cste.cheminDescriptions+CbChoixLogiciel.getSelectedItem().toString();
                Runtime runtime = Runtime.getRuntime();
                if(CbType.getSelectedItem().equals(itemAppliJava)) //Si c'est une application Java
                {
                    try 
                    {
                        p=runtime.exec(new String[] { Main.Cste.exeDescriptionInterfaceJava, chemin } );
                        try {
                            p.waitFor();
                            BufferedReader is;  // reader for output of process
                            is = new BufferedReader(new InputStreamReader(p.getInputStream()));
                            nomDescription = is.readLine();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(EcranAccueil.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(EcranAccueil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else  if(CbType.getSelectedItem().equals(itemAppliWindows))  //Sinon c'est une application Windows
                {
                    try 
                    {
                        p=runtime.exec(new String[] { Main.Cste.exeDescriptionInterfaceWindows, chemin } );
                        try 
                        {
                            p.waitFor();
                            BufferedReader is;  // reader for output of process
                            is = new BufferedReader(new InputStreamReader(p.getInputStream()));
                            nomDescription = is.readLine();
                        } 
                        catch (InterruptedException ex) 
                        {
                            Logger.getLogger(EcranAccueil.class.getName()).log(Level.SEVERE, null, ex);
                        }  

                    } catch (IOException ex) {
                        Logger.getLogger(EcranAccueil.class.getName()).log(Level.SEVERE, null, ex);
                    } 


                }
                else    //sinon c'est une application web
                {
                    Main.DescriptionInterfaceWeb.chargerInterface();
                    Main.DescriptionInterfaceWeb.setVisible(true);
                }                               
            }


            if(!CbType.getSelectedItem().equals(itemAppliWeb) && nomDescription!=null && !nomDescription.isEmpty())
            {
                Main.CreationRegles.cheminEtInterface=nomDescription.substring(nomDescription.indexOf("Parametres"));               
                chargerCbDescription(CbChoixLogiciel.getSelectedItem().toString());
                CbDescription.setSelectedItem(nomDescription.substring(nomDescription.lastIndexOf("\\")+1));
                Main.ModificationInterface.chargerInterface();
                Main.ModificationInterface.setVisible(true);
            }
            else
                CbDescription.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_CbDescriptionItemStateChanged

    private void PanelDrapeauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelDrapeauMouseClicked
        if (Main.Cste.langue.equals("en")) {
            Main.Cste.langue = "fr";
        } else {
            Main.Cste.langue = "en";
        }

        chargerLangue();
    }//GEN-LAST:event_PanelDrapeauMouseClicked

    private void CbStructureItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbStructureItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_CbStructureItemStateChanged

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
            java.util.logging.Logger.getLogger(EcranAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EcranAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EcranAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EcranAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new EcranAccueil().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtSuivant;
    private javax.swing.JComboBox CbChoixLogiciel;
    private javax.swing.JComboBox CbDescription;
    private javax.swing.JComboBox CbNomSA;
    private javax.swing.JComboBox CbStructure;
    private javax.swing.JComboBox CbType;
    private javax.swing.JLabel LbChoixLogiciel;
    private javax.swing.JLabel LbCommentaires;
    private javax.swing.JLabel LbCreateur;
    private javax.swing.JLabel LbDateCrea;
    private javax.swing.JLabel LbDescription;
    private javax.swing.JLabel LbDescriptionEditeur;
    private javax.swing.JLabel LbLogiciel;
    private javax.swing.JLabel LbNomSA;
    private javax.swing.JLabel LbPublic;
    private javax.swing.JLabel LbStructure;
    private javax.swing.JLabel LbType;
    private javax.swing.JPanel PanelApercu;
    private javax.swing.JPanel PanelDrapeau;
    private javax.swing.JPanel PanelImage;
    private javax.swing.JScrollPane ScrollTxtCommentaires;
    private javax.swing.JTextArea TxtCommentaires;
    private javax.swing.JTextField TxtCreateur;
    private javax.swing.JTextField TxtDateCrea;
    private javax.swing.JTextField TxtPublic;
    // End of variables declaration//GEN-END:variables
}
