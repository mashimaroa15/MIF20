/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import org.jdom.Element;

/**
 *
 * @author Blandine
 */
public class ModificationInterface extends javax.swing.JFrame {

    private String[] listeTypesComposants;
    private Element racineDescripiton;
    public HashMap traductionTypesComposants;
    
    private Set listeComposantsImportants=new HashSet();    //contient la liste des éléments à mettre en couleur dans l'arbre
    private String tooltip1BtAide;
    private String tooltip2BtAide;
    
    public String typeBouton;
    public String stringBouton="bouton";
    public String typeBoutonRadio;
    public String stringBoutonRadio="bouton radio";
    public String typeSaisie;
    public String stringSaisie="zone de saisie";
    public String typeCase;
    public String stringCase="case à cocher";
    public String typeComboBox;
    public String stringComboBox="liste déroulante";
    public String typeItem;
    public String stringItem="item";
    public String typePanel;
    public String stringPanel="panel";
    public String typeMenu;
    public String stringMenu="menu";
    public String typeLabel;
    public String stringLabel="label";
    public String typeArbre;
    public String stringArbre="arbre";
    public String typeFenetre;
    public String stringFenetre="fenetre";
    public String typeTable;
    public String stringTable="table";
    public String typeListe;
    public String stringListe="liste";
    public String typeSlider;
    public String stringSlider="slider";
    public String typeLien;
    public String stringLien="lien";
    public String typeImage;
    public String stringImage="image";
    public String typeComposant;
    public String stringComposant="composant";
    
    public String stringFixeTexte;
    public String stringFixeTitre;
    public String stringFixeSource;
    public String stringFixeValeur;
    public String stringFixeLien;
    
    public String stringArticleLe;
    public String stringArticleLa;
    public String stringArticleL;
    
    /**
     * Creates new form ModificationInterface
     */
    public ModificationInterface() {
        initComponents();
        
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setBounds(150, 50, 690, 750);
    }
    
    public void chargerInterface()
    {
        this.setLayout(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/icone_editeur.png"));
        this.setIconImage(icon);
        
        chargerLangue();
        Main.CreationRegles.chargerLangue();
        
        ScrollArbre.setBounds(10, 10, this.getWidth()-35, 400);        
        chargerArbre();
        etendreArbre();
        
        PanelComposant.setLayout(null);
        PanelComposant.setBounds(0, 420, this.getWidth()-35, 250);
        
        LbType.setBounds(10, 20, 150, 24);
        CbType.setBounds(160, 20, 150, 24);
        chargerCbType();
        BtAide.setBounds(320, 20, 40, 24);
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/interrogation.png"));
        BtAide.setIcon(new ImageIcon(icon));
        BtAide.setText("");
        BtAide.setMnemonic(0);
        BtAide.setToolTipText(tooltip1BtAide);
        
        LbDescription.setBounds(10, 50, 150, 24);
        TxtDescription.setBounds(160, 50, 485, 24);
        TxtDescription.setText("");        
        
        LbCommentaires.setBounds(10, 80, 150, 24);
        ScrollCommentaires.setBounds(160, 80, 485, 125);
        TxtCommentaires.setText("");
        
        BtSauver.setBounds((PanelComposant.getWidth()-150)/2, 210, 150, 30);
        
        PanelAide.setBounds(680, 10, 490, 690);
        PanelAide.setLayout(null);
        
        LbBouton.setBounds(10, 20, 200, 24);
        BtBouton.setBounds(210, 20, 100, 24);
        
        LbBoutonRadio.setBounds(10, 60, 200, 50);
        Rb1.setBounds(210, 60, 150, 20);
        Rb2.setBounds(210, 80, 150, 20);
        
        LbSaisie.setBounds(10, 120, 210, 24);
        TxtSaisie.setBounds(215, 120, 100, 24);
        ScrollSaisie.setBounds(320, 120, 160, 60);
        TxtSaisie2.setBounds(0, 0, 100, 80);
        
        LbCase.setBounds(10, 180, 200, 24);
        CheckCase.setBounds(210, 180, 230, 24);
        
        LbListe.setBounds(10, 220, 200, 35);
        CbListe.setBounds(210, 220, 230, 24);
        
        LbPanel.setBounds(10, 265, 450, 24);
        
        LbMenu.setBounds(10, 300, 200, 30);
        PanelMenu.setBounds(210, 300, 200, 130);
        Image icone=getToolkit().getImage(this.getClass().getResource("/images/menu.png"));
        JLabel j = new JLabel( new ImageIcon(icone));
        j.setBounds(0, 0, PanelMenu.getWidth(), PanelMenu.getHeight());
        PanelMenu.add(j);
        PanelMenu.setBackground(PanelMenu.getParent().getBackground());
        
        
        LbLabel.setBounds(10, 435, 450, 24);
        
        LbArbre.setBounds(10, 470, 200, 24);
        ScrollArbre1.setBounds(210, 470, 230, 100);
        
        LbSlider.setBounds(10, 580, 200, 24);
        Slider.setBounds(205, 580, 245, 24);
        
        LbLien.setBounds(10, 620, 250, 70);
        PanelLien.setBounds(260, 625, 200, 30);
        icone=getToolkit().getImage(this.getClass().getResource("/images/lien.png"));
        j = new JLabel( new ImageIcon(icone));
        j.setBounds(0, 0, PanelLien.getWidth(), PanelLien.getHeight());
        PanelLien.add(j);
        PanelLien.setBackground(PanelLien.getParent().getBackground());
        
        
        BtRetour.setBounds(this.getWidth()/2-170, this.getHeight()-80, 150, 30);
        BtSuivant.setBounds(this.getWidth()/2, this.getHeight()-80, 150, 30);

        enrichirDescription();
        creerListeComposantsImportants();
    }
    
    private void chargerLangue()
    {
        XMLFonctions.OuvrirXML(Main.Cste.fichierInterfaceEditeur);
        Element courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("Titre").getChild(Main.Cste.langue);
        Element courant2= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("Titre").getChild(Main.Cste.langue);
        this.setTitle(courant.getText()+courant2.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("LbType").getChild(Main.Cste.langue);
        LbType.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("LbDescription").getChild(Main.Cste.langue);
        LbDescription.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("LbCommentaires").getChild(Main.Cste.langue);
        LbCommentaires.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("BtSauver").getChild(Main.Cste.langue);
        BtSauver.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("tooltipBtSauver").getChild(Main.Cste.langue);
        BtSauver.setToolTipText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("PanelComposant").getChild(Main.Cste.langue);
        TitledBorder title = BorderFactory.createTitledBorder(courant.getText());
        PanelComposant.setBorder(title);
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("LbBouton").getChild(Main.Cste.langue);
        LbBouton.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("BtBouton").getChild(Main.Cste.langue);
        BtBouton.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("LbBoutonRadio").getChild(Main.Cste.langue);
        LbBoutonRadio.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("Rb1").getChild(Main.Cste.langue);
        Rb1.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("Rb2").getChild(Main.Cste.langue);
        Rb2.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("LbSaisie").getChild(Main.Cste.langue);
        LbSaisie.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("LbCase").getChild(Main.Cste.langue);
        LbCase.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("CheckCase").getChild(Main.Cste.langue);
        CheckCase.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("LbListe").getChild(Main.Cste.langue);
        LbListe.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("LbPanel").getChild(Main.Cste.langue);
        LbPanel.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("LbMenu").getChild(Main.Cste.langue);
        LbMenu.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("LbLabel").getChild(Main.Cste.langue);
        LbLabel.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("LbArbre").getChild(Main.Cste.langue);
        LbArbre.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("LbSlider").getChild(Main.Cste.langue);
        LbSlider.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("LbLien").getChild(Main.Cste.langue);
        LbLien.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("PanelAide").getChild(Main.Cste.langue);
        title = BorderFactory.createTitledBorder(courant.getText());
        PanelAide.setBorder(title);
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("feuille").getChild(Main.Cste.langue);
        String feuille=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("branche").getChild(Main.Cste.langue);
        String branche=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("arbre").getChild(Main.Cste.langue);
        String arbre=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("tooltip1BtAide").getChild(Main.Cste.langue);
        tooltip1BtAide = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("tooltip2BtAide").getChild(Main.Cste.langue);
        tooltip2BtAide = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("typeBouton").getChild(Main.Cste.langue);
        typeBouton = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("typeBoutonRadio").getChild(Main.Cste.langue);
        typeBoutonRadio = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("typeSaisie").getChild(Main.Cste.langue);
        typeSaisie = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("typeCase").getChild(Main.Cste.langue);
        typeCase = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("typeComboBox").getChild(Main.Cste.langue);
        typeComboBox = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("typeItem").getChild(Main.Cste.langue);
        typeItem = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("typePanel").getChild(Main.Cste.langue);
        typePanel= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("typeMenu").getChild(Main.Cste.langue);
        typeMenu= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("typeLabel").getChild(Main.Cste.langue);
        typeLabel= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("typeArbre").getChild(Main.Cste.langue);
        typeArbre= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("typeFenetre").getChild(Main.Cste.langue);
        typeFenetre= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("typeTable").getChild(Main.Cste.langue);
        typeTable= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("typeListe").getChild(Main.Cste.langue);
        typeListe= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("typeSlider").getChild(Main.Cste.langue);
        typeSlider= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("typeLien").getChild(Main.Cste.langue);
        typeLien= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("typeImage").getChild(Main.Cste.langue);
        typeImage= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("typeComposant").getChild(Main.Cste.langue);
        typeComposant= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("stringFixeTexte").getChild(Main.Cste.langue);
        stringFixeTexte= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("stringFixeTitre").getChild(Main.Cste.langue);
        stringFixeTitre= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("stringFixeSource").getChild(Main.Cste.langue);
        stringFixeSource= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("stringFixeValeur").getChild(Main.Cste.langue);
        stringFixeValeur= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("stringFixeLien").getChild(Main.Cste.langue);
        stringFixeLien= courant.getText();
        
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("stringArticleLe").getChild(Main.Cste.langue);
        stringArticleLe= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("stringArticleLa").getChild(Main.Cste.langue);
        stringArticleLa= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild("stringArticleL").getChild(Main.Cste.langue);
        stringArticleL= courant.getText();
        
        listeTypesComposants=new String[18];
        listeTypesComposants[0]="";
        listeTypesComposants[1]=typeBouton;
        listeTypesComposants[2]=typeBoutonRadio;
        listeTypesComposants[3]=typeSaisie;
        listeTypesComposants[4]=typeCase;
        listeTypesComposants[5]=typeComboBox;
        listeTypesComposants[6]=typeItem;
        listeTypesComposants[7]=typePanel;
        listeTypesComposants[8]=typeMenu;
        listeTypesComposants[9]=typeLabel;
        listeTypesComposants[10]=typeArbre;
        listeTypesComposants[11]=typeFenetre;
        listeTypesComposants[12]=typeTable;
        listeTypesComposants[13]=typeListe;
        listeTypesComposants[14]=typeSlider;
        listeTypesComposants[15]=typeLien;
        listeTypesComposants[16]=typeImage; 
        listeTypesComposants[17]=typeComposant;
        
        creerTraductionTypesComposants();
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(arbre);
        DefaultMutableTreeNode branche1 = new DefaultMutableTreeNode(branche+"1");
        DefaultMutableTreeNode branche2 = new DefaultMutableTreeNode(branche+"2");
        DefaultMutableTreeNode feuille0 = new DefaultMutableTreeNode(feuille);
        DefaultMutableTreeNode feuille11 = new DefaultMutableTreeNode(feuille+"1.1");
        DefaultMutableTreeNode feuille12 = new DefaultMutableTreeNode(feuille+"1.2");
        DefaultMutableTreeNode feuille21 = new DefaultMutableTreeNode(feuille+"2.1");
        DefaultMutableTreeNode feuille22 = new DefaultMutableTreeNode(feuille+"2.2");
        DefaultMutableTreeNode feuille23 = new DefaultMutableTreeNode(feuille+"2.3");
        root.add(branche1);
        branche1.add(feuille11);
        branche1.add(feuille12);
        root.add(branche2);
        branche2.add(feuille21);
        branche2.add(feuille22);
        branche2.add(feuille23);
        root.add(feuille0);
        DefaultTreeModel model = new DefaultTreeModel(root);
        Arbre1.setModel(model);
        
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtRetour.setText(courant.getText());       
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("BtTerminer").getChild(Main.Cste.langue);
        BtSuivant.setText(courant.getText());
    }
    
    private void creerTraductionTypesComposants()
    {
        traductionTypesComposants = new HashMap();
        traductionTypesComposants.put(stringBouton, typeBouton);
        traductionTypesComposants.put(stringBoutonRadio, typeBoutonRadio);
        traductionTypesComposants.put(stringSaisie, typeSaisie);
        traductionTypesComposants.put(stringCase, typeCase);
        traductionTypesComposants.put(stringComboBox, typeComboBox);
        traductionTypesComposants.put(stringItem, typeItem);
        traductionTypesComposants.put(stringPanel, typePanel);
        traductionTypesComposants.put(stringMenu, typeMenu);
        traductionTypesComposants.put(stringLabel, typeLabel);
        traductionTypesComposants.put(stringArbre, typeArbre);
        traductionTypesComposants.put(stringFenetre, typeFenetre);
        traductionTypesComposants.put(stringTable, typeTable);
        traductionTypesComposants.put(stringListe, typeListe);
        traductionTypesComposants.put(stringSlider, typeSlider);
        traductionTypesComposants.put(stringLien, typeLien);
        traductionTypesComposants.put(stringImage, typeImage);
        traductionTypesComposants.put(stringComposant, typeComposant);
    }
    
    public String traduireTypeComposant(String type)
    {
        if(traductionTypesComposants.containsKey(type))
            return (String) traductionTypesComposants.get(type);
        return "";
    }
    
    private void creerListeComposantsImportants()
    {
        XMLFonctions.OuvrirXML(Main.CreationRegles.cheminEtInterface);
        racineDescripiton= (Element) XMLFonctions.racine;
        for(int i=0; i<racineDescripiton.getChildren().size(); i++)
        {
            Element fenetre=(Element) racineDescripiton.getChildren().get(i);
            if(fenetre.getAttribute("typeAjoute")!=null || fenetre.getAttribute("descriptionAjoutee")!=null || fenetre.getAttribute("commentaires")!=null)
            {
                listeComposantsImportants.add(typeFenetre+" id="+fenetre.getAttributeValue("id")+" "+stringFixeTexte+"="+fenetre.getAttributeValue("texte")+" type="+fenetre.getAttributeValue("type"));
                ArbreCouleur a=new ArbreCouleur();
                a.listeComposantsImportants=listeComposantsImportants;
                Arbre.setCellRenderer(a);
            }
            creerListeComposantsImportants(fenetre);
        }
    }

    
    private void creerListeComposantsImportants(Element pere)
    {
        for(int i=0; i<pere.getChildren().size(); i++)
        {
                Element composant=(Element) pere.getChildren().get(i);
                if(composant.getAttribute("typeAjoute")!=null || composant.getAttribute("descriptionAjoutee")!=null || composant.getAttribute("commentaires")!=null)
                {                   
                    listeComposantsImportants.add(Main.CreationRegles.descriptionNoeudComposant(composant));
                    ArbreCouleur a=new ArbreCouleur();
                    a.listeComposantsImportants=listeComposantsImportants;
                    Arbre.setCellRenderer(a);               
            }
            creerListeComposantsImportants(composant);
        }
    }
    
    private void enrichirDescription()
    {
        XMLFonctions.OuvrirXML(Main.CreationRegles.cheminEtInterface);
        racineDescripiton= (Element) XMLFonctions.racine;
        for(int i=0; i<racineDescripiton.getChildren().size(); i++)
        {
            Element fenetre=(Element) racineDescripiton.getChildren().get(i);
            if(fenetre.getAttributeValue("typeAjoute")==null)
            {
                fenetre.setAttribute("typeAjoute", "fenêtre");
                fenetre.setAttribute("descriptionAjoutee", stringArticleLa+" "+typeFenetre+" "+fenetre.getAttributeValue("texte"));
                enrichirDescriptionComposants(fenetre);
            }
        }
        
        XMLFonctions.creerXML((Element) racineDescripiton.clone());
        XMLFonctions.enregistre(Main.CreationRegles.cheminEtInterface);
    }
    
    private void enrichirDescriptionComposants(Element pere)
    {
        for(int i=0; i<pere.getChildren().size(); i++)
        {
            Element composant=(Element) pere.getChildren().get(i);
            if(composant.getAttributeValue("typeAjoute")==null)
            {
                String typeAjoute=correspondanceTypes(composant.getAttributeValue("type"));
                if(!typeAjoute.isEmpty())
                {
                    composant.setAttribute("typeAjoute", typeAjoute);
                    composant = ajouterDescription(composant, typeAjoute);
                }
            }
            else
            {
                String typeAjoute=composant.getAttributeValue("typeAjoute");
                if(!typeAjoute.isEmpty())
                {
                    if(composant.getAttribute("descriptionAjoutee") == null)
                        composant = ajouterDescription(composant, typeAjoute);
                    
                }
            }
            
            enrichirDescriptionComposants(composant);
        }
    }
    
    private Element ajouterDescription(Element composant, String typeAjoute)
    {
        String texte="";
        if(composant.getAttribute("texte")!=null && !composant.getAttributeValue("texte").isEmpty())
            texte=composant.getAttributeValue("texte");
        else if(composant.getAttribute("titre")!=null && !composant.getAttributeValue("titre").isEmpty())
            texte=composant.getAttributeValue("titre");
       else if(composant.getAttribute("id_web")!=null && !composant.getAttributeValue("id_web").isEmpty())
            texte=composant.getAttributeValue("id_web");     
            
            
            
            
        if(typeAjoute.equals(stringBouton) || typeAjoute.equals(stringBoutonRadio) || typeAjoute.equals(stringPanel) || typeAjoute.equals(stringMenu) || typeAjoute.equals(stringSlider))
            composant.setAttribute("descriptionAjoutee", stringArticleLe+" "+typeAjoute+" "+texte); 
        else if(typeAjoute.equals(stringSaisie) || typeAjoute.equals(stringCase) || typeAjoute.equals(stringComboBox) || typeAjoute.equals(stringFenetre) || typeAjoute.equals(stringTable))
            composant.setAttribute("descriptionAjoutee", stringArticleLa+" "+typeAjoute+" "+texte);
        else if(typeAjoute.equals(stringItem) || typeAjoute.equals(stringArbre))
            composant.setAttribute("descriptionAjoutee", stringArticleL+typeAjoute+" "+texte);
        else if(typeAjoute.equals(stringLien))
        {
            String titre=" ";
            if(composant.getAttribute("titre")!=null)
                titre=" "+composant.getAttributeValue("titre");
            else if(composant.getAttribute("lien")!=null)
                titre = " "+composant.getAttributeValue("lien");
            composant.setAttribute("descriptionAjoutee", stringArticleLe+" "+typeAjoute+titre);
        }
        else if(typeAjoute.equals("image"))
            composant.setAttribute("descriptionAjoutee", stringArticleL+typeAjoute+" "+composant.getAttributeValue("titre"));
        
        return composant;
    }
    
    private String correspondanceTypes(String type)
    {
        String typeAjoute="";        
        //XMLFonctions.OuvrirXML(this.getClass().getResource("/ressources/composantsInterface.xml").getFile());
        XMLFonctions.OuvrirXML(Main.Cste.fichierComposantsInterface);
        Element racine= (Element) XMLFonctions.racine;
        
        for(int i=0; i<racine.getChildren().size(); i++)
        {
            Element elem=(Element) racine.getChildren().get(i);
            for(int j=0; j< elem.getChildren().size();j++)
            {
                Element ssElem = (Element) elem.getChildren().get(j);
                if(ssElem.getAttributeValue("nom").equals(type))
                    return elem.getAttributeValue("affichage");
            }
        }
        
        return typeAjoute;
    }
    
    private void chargerCbType(){
        CbType.removeAllItems();
        for(int i=0; i<listeTypesComposants.length; i++)
        {
            CbType.addItem(listeTypesComposants[i]);
        }
    }
    
    public void etendreArbre()
    {
        Enumeration e = ((DefaultMutableTreeNode) Arbre.getModel().getRoot()).preorderEnumeration();
        while (e.hasMoreElements()) {
            this.Arbre.expandPath(new TreePath(((DefaultMutableTreeNode)e.nextElement()).getPath()));
        }
    }  
    
    private void chargerArbre(){
        XMLFonctions.OuvrirXML(Main.CreationRegles.cheminEtInterface);
        
        Element racine=XMLFonctions.racine;
        Arbre.removeAll();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Interface");
        for(int i=0; i<racine.getChildren().size(); i++)
        {
            Element fenetre=(Element) racine.getChildren().get(i);
            DefaultMutableTreeNode fen = new DefaultMutableTreeNode(typeFenetre+" id="+fenetre.getAttributeValue("id")+" "+stringFixeTexte+"="+fenetre.getAttributeValue("texte")+" type="+fenetre.getAttributeValue("type"));
            root.add(fen);
            ajouterComposantArbre(fenetre, fen);           
        }
        DefaultTreeModel model = new DefaultTreeModel(root);
        Arbre.setModel(model);
        
    }
    
    private void ajouterComposantArbre(Element composant, DefaultMutableTreeNode noeud){
        for(int i=0; i<composant.getChildren().size(); i++)
        {
            Element fils=(Element) composant.getChildren().get(i);
            DefaultMutableTreeNode branche = new DefaultMutableTreeNode(Main.CreationRegles.descriptionNoeudComposant(fils));
            noeud.add(branche);
            if(!fils.getChildren().isEmpty())
            {
                ajouterComposantArbre(fils, branche);
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

        GroupExemple = new javax.swing.ButtonGroup();
        ScrollArbre = new javax.swing.JScrollPane();
        Arbre = new javax.swing.JTree();
        BtSuivant = new javax.swing.JButton();
        BtRetour = new javax.swing.JButton();
        PanelComposant = new javax.swing.JPanel();
        LbType = new javax.swing.JLabel();
        CbType = new javax.swing.JComboBox();
        LbDescription = new javax.swing.JLabel();
        TxtDescription = new javax.swing.JTextField();
        LbCommentaires = new javax.swing.JLabel();
        ScrollCommentaires = new javax.swing.JScrollPane();
        TxtCommentaires = new javax.swing.JTextPane();
        BtSauver = new javax.swing.JButton();
        BtAide = new javax.swing.JButton();
        PanelAide = new javax.swing.JPanel();
        LbBouton = new javax.swing.JLabel();
        BtBouton = new javax.swing.JButton();
        LbBoutonRadio = new javax.swing.JLabel();
        Rb1 = new javax.swing.JRadioButton();
        Rb2 = new javax.swing.JRadioButton();
        LbListe = new javax.swing.JLabel();
        LbSaisie = new javax.swing.JLabel();
        TxtSaisie = new javax.swing.JTextField();
        ScrollSaisie = new javax.swing.JScrollPane();
        TxtSaisie2 = new javax.swing.JTextArea();
        LbCase = new javax.swing.JLabel();
        CheckCase = new javax.swing.JCheckBox();
        CbListe = new javax.swing.JComboBox();
        LbPanel = new javax.swing.JLabel();
        LbMenu = new javax.swing.JLabel();
        LbLabel = new javax.swing.JLabel();
        LbArbre = new javax.swing.JLabel();
        ScrollArbre1 = new javax.swing.JScrollPane();
        Arbre1 = new javax.swing.JTree();
        LbSlider = new javax.swing.JLabel();
        Slider = new javax.swing.JSlider();
        LbLien = new javax.swing.JLabel();
        PanelLien = new javax.swing.JPanel();
        PanelMenu = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Arbre.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                ArbreValueChanged(evt);
            }
        });
        ScrollArbre.setViewportView(Arbre);

        BtSuivant.setText("Terminer");
        BtSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSuivantActionPerformed(evt);
            }
        });

        BtRetour.setText("Annuler");
        BtRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRetourActionPerformed(evt);
            }
        });

        PanelComposant.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Décrire un composant de l'interface", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        LbType.setText("Type ajouté");

        CbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        LbDescription.setText("Description ajoutée");

        TxtDescription.setText("le bouton suivant");

        LbCommentaires.setText("Commentaires");

        ScrollCommentaires.setViewportView(TxtCommentaires);

        BtSauver.setText("Sauver");
        BtSauver.setToolTipText("Enregistrer les modification faites à ce composant");
        BtSauver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSauverActionPerformed(evt);
            }
        });

        BtAide.setText("A");
        BtAide.setToolTipText("Afficher l'aide pour la reconnaissance des types de composants");
        BtAide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAideActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelComposantLayout = new javax.swing.GroupLayout(PanelComposant);
        PanelComposant.setLayout(PanelComposantLayout);
        PanelComposantLayout.setHorizontalGroup(
            PanelComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelComposantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelComposantLayout.createSequentialGroup()
                        .addComponent(LbType)
                        .addGap(33, 33, 33)
                        .addComponent(CbType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtAide, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(PanelComposantLayout.createSequentialGroup()
                        .addGroup(PanelComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LbDescription)
                            .addComponent(LbCommentaires))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelComposantLayout.createSequentialGroup()
                                .addComponent(BtSauver)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(ScrollCommentaires)
                            .addGroup(PanelComposantLayout.createSequentialGroup()
                                .addComponent(TxtDescription)
                                .addGap(19, 19, 19))))))
        );
        PanelComposantLayout.setVerticalGroup(
            PanelComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelComposantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbType)
                    .addComponent(CbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAide))
                .addGap(18, 18, 18)
                .addGroup(PanelComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbDescription)
                    .addComponent(TxtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbCommentaires)
                    .addComponent(ScrollCommentaires, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtSauver)
                .addContainerGap())
        );

        PanelAide.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aide pour reconnaître les types de composants", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        PanelAide.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        LbBouton.setText("Ceci est un bouton");

        BtBouton.setText("Bouton");

        LbBoutonRadio.setText("Ceci est un bouton radio");

        GroupExemple.add(Rb1);
        Rb1.setText("Bouton radio 1");

        GroupExemple.add(Rb2);
        Rb2.setText("Bouton radio 2");

        LbListe.setText("Ceci est une liste déroulante");

        LbSaisie.setText("Voici deux types de zones de saisie");

        TxtSaisie2.setColumns(20);
        TxtSaisie2.setRows(5);
        ScrollSaisie.setViewportView(TxtSaisie2);

        LbCase.setText("Ceci est une case à cocher");

        CheckCase.setText("Case à cocher");

        CbListe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        LbPanel.setText("Un panel est un conteneur, il n'est pas nécessairement matérialisé à l'interface");

        LbMenu.setText("Ceci illustre un menu, qui contient plusieurs items");

        LbLabel.setText("Ceci est un label : tous les textes affichés de l'interface sont des labels");

        LbArbre.setText("Ceci est un arbre");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Arbre");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Branche 1");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("feuille 1");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("feuille2");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Branche 2");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("feuille 3");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("feuille 4");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("feuille 5");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Branche 3");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("feuille 6");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("feuille 7");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        Arbre1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        ScrollArbre1.setViewportView(Arbre1);

        LbSlider.setText("Ceci est un slider");

        LbLien.setText("Ceci illustre un lien");

        PanelLien.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout PanelLienLayout = new javax.swing.GroupLayout(PanelLien);
        PanelLien.setLayout(PanelLienLayout);
        PanelLienLayout.setHorizontalGroup(
            PanelLienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );
        PanelLienLayout.setVerticalGroup(
            PanelLienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        PanelMenu.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelAideLayout = new javax.swing.GroupLayout(PanelAide);
        PanelAide.setLayout(PanelAideLayout);
        PanelAideLayout.setHorizontalGroup(
            PanelAideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAideLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAideLayout.createSequentialGroup()
                        .addGroup(PanelAideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelAideLayout.createSequentialGroup()
                                .addComponent(LbSlider)
                                .addGap(53, 53, 53)
                                .addComponent(Slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LbLien, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelAideLayout.createSequentialGroup()
                                .addComponent(LbSaisie)
                                .addGap(18, 18, 18)
                                .addComponent(TxtSaisie, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ScrollSaisie, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelAideLayout.createSequentialGroup()
                                .addComponent(LbCase)
                                .addGap(29, 29, 29)
                                .addComponent(CheckCase))
                            .addGroup(PanelAideLayout.createSequentialGroup()
                                .addComponent(LbListe)
                                .addGap(28, 28, 28)
                                .addComponent(CbListe, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelAideLayout.createSequentialGroup()
                        .addGroup(PanelAideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PanelLien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelAideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PanelAideLayout.createSequentialGroup()
                                    .addComponent(LbBouton)
                                    .addGap(50, 50, 50)
                                    .addComponent(BtBouton))
                                .addGroup(PanelAideLayout.createSequentialGroup()
                                    .addComponent(LbBoutonRadio)
                                    .addGap(70, 70, 70)
                                    .addGroup(PanelAideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Rb2)
                                        .addComponent(Rb1)))
                                .addComponent(LbPanel)
                                .addComponent(LbMenu)
                                .addComponent(LbLabel)
                                .addGroup(PanelAideLayout.createSequentialGroup()
                                    .addComponent(LbArbre)
                                    .addGap(124, 124, 124)
                                    .addComponent(ScrollArbre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(20, Short.MAX_VALUE))))
            .addGroup(PanelAideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAideLayout.createSequentialGroup()
                    .addContainerGap(324, Short.MAX_VALUE)
                    .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(59, 59, 59)))
        );
        PanelAideLayout.setVerticalGroup(
            PanelAideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAideLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(PanelAideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtBouton)
                    .addComponent(LbBouton))
                .addGroup(PanelAideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAideLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(LbBoutonRadio))
                    .addGroup(PanelAideLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Rb1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rb2)
                .addGroup(PanelAideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAideLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(LbSaisie))
                    .addGroup(PanelAideLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(PanelAideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollSaisie, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtSaisie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(PanelAideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbCase)
                    .addComponent(CheckCase))
                .addGap(26, 26, 26)
                .addGroup(PanelAideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbListe)
                    .addComponent(CbListe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LbPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LbMenu)
                .addGap(91, 91, 91)
                .addComponent(LbLabel)
                .addGap(12, 12, 12)
                .addGroup(PanelAideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbArbre)
                    .addComponent(ScrollArbre1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(PanelAideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbSlider)
                    .addComponent(Slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LbLien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelLien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelAideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAideLayout.createSequentialGroup()
                    .addContainerGap(340, Short.MAX_VALUE)
                    .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(246, 246, 246)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelComposant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(104, 104, 104)
                            .addComponent(BtRetour)
                            .addGap(18, 18, 18)
                            .addComponent(BtSuivant))
                        .addComponent(ScrollArbre, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(PanelAide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelAide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ScrollArbre, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanelComposant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtRetour)
                            .addComponent(BtSuivant))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ArbreValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_ArbreValueChanged
        if (!Arbre.isSelectionEmpty()) 
        {
            if (!Arbre.isRowSelected(0)) 
            {
                String compo = Arbre.getSelectionPath().getLastPathComponent().toString();
                String id = Main.CreationRegles.noeudGetId(compo);
                XMLFonctions.OuvrirXML(Main.CreationRegles.cheminEtInterface);
                Element racine=XMLFonctions.racine;
                Element noeud=FonctionsUtiles.NoeudParAttrDansFichier(racine, "id", id);
                
                if(noeud.getAttribute("typeAjoute")!=null)
                    CbType.setSelectedItem(traduireTypeComposant(noeud.getAttributeValue("typeAjoute")));
                else
                    CbType.setSelectedItem("");
                
                if(noeud.getAttribute("descriptionAjoutee")!=null)
                    TxtDescription.setText(noeud.getAttributeValue("descriptionAjoutee"));
                else
                    TxtDescription.setText(""); 
                
                if(noeud.getAttribute("commentaires")!=null)
                    TxtCommentaires.setText(noeud.getAttributeValue("commentaires"));
                else
                    TxtCommentaires.setText("");
            }
        }
    }//GEN-LAST:event_ArbreValueChanged

    private void BtSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSuivantActionPerformed
        Main.CreationRegles.creerListeCommentairesComposants();
        Main.CreationRegles.ouvrirComposants();
        this.setVisible(false);
    }//GEN-LAST:event_BtSuivantActionPerformed

    private void BtRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRetourActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BtRetourActionPerformed

    private void BtSauverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSauverActionPerformed
        if (!Arbre.isSelectionEmpty()) 
        {
            if (!Arbre.isRowSelected(0)) 
            {
                String compo = Arbre.getSelectionPath().getLastPathComponent().toString();
                String id = Main.CreationRegles.noeudGetId(compo);
                XMLFonctions.OuvrirXML(Main.CreationRegles.cheminEtInterface);
                Element racine=XMLFonctions.racine;
                Element noeud=FonctionsUtiles.NoeudParAttrDansFichier(racine, "id", id);

                noeud.setAttribute("typeAjoute", CbType.getSelectedItem().toString());
                noeud.setAttribute("descriptionAjoutee", TxtDescription.getText());
                noeud.setAttribute("commentaires", TxtCommentaires.getText()); 
                
                XMLFonctions.enregistre(Main.CreationRegles.cheminEtInterface);

                listeComposantsImportants.add(Arbre.getLastSelectedPathComponent().toString());
                ArbreCouleur a=new ArbreCouleur();
                a.listeComposantsImportants=listeComposantsImportants;
                Arbre.setCellRenderer(a);
            }
        }
    }//GEN-LAST:event_BtSauverActionPerformed

    private void BtAideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAideActionPerformed
        if(BtAide.getMnemonic()==0)
        {
            this.setBounds(150, 50, 1200, 750);
            BtAide.setMnemonic(1);
            BtAide.setToolTipText(tooltip2BtAide);
        }
        else
        {
            this.setBounds(150, 50, 690, 750);
            BtAide.setMnemonic(0);
            BtAide.setToolTipText(tooltip1BtAide);
        }
    }//GEN-LAST:event_BtAideActionPerformed

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
            java.util.logging.Logger.getLogger(ModificationInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificationInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificationInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificationInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                //new ModificationInterface().setVisible(true);
                
                ModificationInterface c = new ModificationInterface();
                c.chargerInterface();
                c.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree Arbre;
    private javax.swing.JTree Arbre1;
    private javax.swing.JButton BtAide;
    private javax.swing.JButton BtBouton;
    private javax.swing.JButton BtRetour;
    private javax.swing.JButton BtSauver;
    private javax.swing.JButton BtSuivant;
    private javax.swing.JComboBox CbListe;
    private javax.swing.JComboBox CbType;
    private javax.swing.JCheckBox CheckCase;
    private javax.swing.ButtonGroup GroupExemple;
    private javax.swing.JLabel LbArbre;
    private javax.swing.JLabel LbBouton;
    private javax.swing.JLabel LbBoutonRadio;
    private javax.swing.JLabel LbCase;
    private javax.swing.JLabel LbCommentaires;
    private javax.swing.JLabel LbDescription;
    private javax.swing.JLabel LbLabel;
    private javax.swing.JLabel LbLien;
    private javax.swing.JLabel LbListe;
    private javax.swing.JLabel LbMenu;
    private javax.swing.JLabel LbPanel;
    private javax.swing.JLabel LbSaisie;
    private javax.swing.JLabel LbSlider;
    private javax.swing.JLabel LbType;
    private javax.swing.JPanel PanelAide;
    private javax.swing.JPanel PanelComposant;
    private javax.swing.JPanel PanelLien;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JRadioButton Rb1;
    private javax.swing.JRadioButton Rb2;
    private javax.swing.JScrollPane ScrollArbre;
    private javax.swing.JScrollPane ScrollArbre1;
    private javax.swing.JScrollPane ScrollCommentaires;
    private javax.swing.JScrollPane ScrollSaisie;
    private javax.swing.JSlider Slider;
    private javax.swing.JTextPane TxtCommentaires;
    private javax.swing.JTextField TxtDescription;
    private javax.swing.JTextField TxtSaisie;
    private javax.swing.JTextArea TxtSaisie2;
    // End of variables declaration//GEN-END:variables
}
