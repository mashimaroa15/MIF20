/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import org.jdom.Element;

/**
 *
 * @author Blandine
 */
public class CreationEvenements extends javax.swing.JFrame {

    private String itemActionUtilisateur="action de l'utilisateur";
    private String itemTimerFin="durée";
    private String itemSequenceEvenements="séquence d'événements";
    private String itemEveSA="événement lié à l'assistance";
    
    private String itemDeclenchementAction = "aucun déclenchement d'action";
    private String itemDeclenchementRegle = "aucun déclenchement de règle";
    private String itemDeclenchementRegleAction = "aucun déclenchement d'action ou règle";
    private String itemAucuneAction = "aucune action";
    private String itemAucunClic = "aucun clic";
    private String itemAucunDeplacementSouris = "aucun mouvement de la souris";
    private String itemAbsenceEvenement = "absence de l'événement";
    
    public JComboBox CB=null;
    /**
     * Creates new form CreationEvenement
     */
    public CreationEvenements() {
        initComponents();
        
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(200, 100, 690, 655);
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/icone_editeur.png"));
        this.setIconImage(icon);
        this.setTitle("Editeur d'assistance - définition d'un événement");
        
        ToolTipManager.sharedInstance().registerComponent(Arbre);
        
        PanelCreationEvenement.setBounds(0, 0, 675, 610);
        PanelCreationEvenement.setLayout(null);
                
        LbNomEvenement.setBounds(15, 5, 150, 24);
        TxtNomEvenement.setBounds(155, 5, 60, 24);       
        LbChoixTypeEvenement.setBounds(290, 5, 130, 24);
        CbChoixTypeEvenement.setBounds(425, 5, 230, 24);
        
        //______________________action de l'utilisateur_______________________
        PanelActionElem.setBounds(5, 30, 660, 568); 
        PanelActionElem.setLayout(null);
        PanelActionElem.setVisible(false);
        
        LbTypeEvenement.setBounds(10, 10, 160, 24);
        CbTypeEvenement.setBounds(170, 10, 150, 24);
        LbComposant.setBounds(340, 10, 100, 24);
        TxtComposant.setBounds(450, 10, 60, 24);
        
        ScrollArbre.setBounds(5, 40, 620, 480);
        BtModifierDescriptionInterface.setBounds(630, 200, 30, 24);
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/modifierPetite.png"));
        BtModifierDescriptionInterface.setIcon(new ImageIcon(icon));
        BtModifierDescriptionInterface.setText("");
        BtAfficherDescriptionInterface.setBounds(630, 230, 30, 24);
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
        BtAfficherDescriptionInterface.setIcon(new ImageIcon(icon));
        BtAfficherDescriptionInterface.setText("");
        
        BtValiderActionElem.setBounds(PanelActionElem.getWidth()/2-130, PanelActionElem.getHeight()-35, 120, 30);
        BtAnnulerActionElem.setBounds(PanelActionElem.getWidth()/2+10, PanelActionElem.getHeight()-35, 120, 30);
        
        
        //______________________evenement de l'assistance_______________________
        PanelEveSA.setBounds(5, 30, 660, 568); 
        PanelEveSA.setLayout(null);
        PanelEveSA.setVisible(false);
        PanelEveSA.setBackground(PanelEveSA.getParent().getBackground());
        
        LbEvenementEveSA.setBounds(10, 10, 160, 24);
        CbEvenementEveSA.setBounds(170, 10, 150, 24);
        CbObjetEveSA.setBounds(340, 10, 60, 24);
        
        BtValiderEveSA.setBounds(PanelEveSA.getWidth()/2-130, PanelEveSA.getHeight()-35, 120, 30);
        BtAnnulerEveSA.setBounds(PanelEveSA.getWidth()/2+10, PanelEveSA.getHeight()-35, 120, 30);
        
        //______________________timer _______________________
        PanelTimerFin.setBounds(5, 30, 660, 568); 
        PanelTimerFin.setLayout(null);
        PanelTimerFin.setVisible(false);
        
        LbDureeTimerFin.setBounds(10, 10, 60, 24);
        SpinDureeTimerFin.setBounds(70, 10, 60, 24);
        CbUniteTimerFin.setBounds(140, 10, 100, 24);
        
        RbDepuisRegle.setBounds(10, 40, 320, 24);
        RbDepuisEve.setBounds(10, 70, 320, 24);
        CbDepuisEve.setBounds(330, 70, 260, 24);
        RbDepuisActionElem.setBounds(10, 100, 320, 24);
        CbDepuisActionElem.setBounds(330, 100, 260, 24);
        CbDepuisActionElemDonnee.setBounds(600, 100, 60, 24);
        RbDepuisEveSA.setBounds(10, 130, 320, 24);
        CbDepuisEveSA.setBounds(330, 130, 260, 24);
        
        
        BtValiderTimerFin.setBounds(PanelTimerFin.getWidth()/2-130, PanelTimerFin.getHeight()-35, 120, 30);
        BtAnnulerTimerFin.setBounds(PanelTimerFin.getWidth()/2+10, PanelTimerFin.getHeight()-35, 120, 30);

        //______________________séquence d'événéments_______________________
        PanelSequence.setBounds(5, 30, 660, 568); 
        PanelSequence.setLayout(null);
        PanelSequence.setVisible(false);
        
        CbSequenceEvenements.setBounds(190, 95, 150, 24);
        BtModifierSequence.setBounds(360, 95, 90, 24);
        BtCreerSequence.setBounds(460, 95, 90, 24);       
    }
    
    public void chargerInterface()
    {
        chargerLangue();
        TxtNomEvenement.setText("E" + Main.CreationRegles.idEvenement);
        
        TxtComposant.setText("");                                      
        Arbre.setCellRenderer(new ArbreInfoBulles());
        
        Main.CreationRegles.chargerArbreComposants(Arbre, Main.CreationRegles.afficherDescriptionComplete);
        Main.CreationRegles.etendreArbre(Arbre);
        Main.CreationRegles.chargerCbTypeEvenements(CbTypeEvenement, "");
        
        CbChoixTypeEvenement.removeAllItems();
        CbChoixTypeEvenement.addItem(itemActionUtilisateur);
        CbChoixTypeEvenement.addItem(itemEveSA);
        CbChoixTypeEvenement.addItem(itemTimerFin);
        //CbChoixTypeEvenement.addItem(itemSequenceEvenements);
        CbChoixTypeEvenement.setSelectedIndex(-1);
        
        Main.CreationRegles.chargerCbActionsEtRegles(CbObjetEveSA, false);
        
        CbEvenementEveSA.removeAllItems();
        CbEvenementEveSA.addItem(Main.CreationRegles.itemDeclenchement);
        CbEvenementEveSA.addItem(Main.CreationRegles.itemFin);
        CbEvenementEveSA.setSelectedIndex(-1);
        
        chargerCBEvenements(CbDepuisEve);
                
        CbDepuisActionElem.removeAllItems();
        CbDepuisActionElem.addItem(itemAucuneAction);
        CbDepuisActionElem.addItem(itemAucunClic);
        CbDepuisActionElem.addItem(itemAucunDeplacementSouris);
        CbDepuisActionElem.addItem(itemAbsenceEvenement);
        CbDepuisActionElem.setSelectedIndex(-1);
        
        
        chargerCBActionsElem(CbDepuisActionElemDonnee);
        
        CbDepuisEveSA.removeAllItems();
        CbDepuisEveSA.addItem(itemDeclenchementRegleAction);
        CbDepuisEveSA.addItem(itemDeclenchementRegle);
        CbDepuisEveSA.addItem(itemDeclenchementAction);
        CbDepuisEveSA.setSelectedIndex(-1);
        
        CbDepuisActionElem.setEnabled(RbDepuisActionElem.isSelected());
        CbDepuisActionElemDonnee.setEnabled(RbDepuisActionElem.isSelected() && CbDepuisActionElem.getSelectedIndex()>=0 && CbDepuisActionElem.getSelectedItem().toString().equals(itemAbsenceEvenement));
        CbDepuisEve.setEnabled(RbDepuisEve.isSelected());
        CbDepuisEveSA.setEnabled(RbDepuisEveSA.isSelected());
        
        Main.CreationRegles.chargerCbUniteTemps(CbUniteTimerFin);
        
        PanelActionElem.setVisible(false);
        PanelSequence.setVisible(false);
        PanelTimerFin.setVisible(false);
        PanelEveSA.setVisible(false);
    }
    
    private void chargerLangue()
    {
        XMLFonctions.OuvrirXML(Main.Cste.fichierInterfaceEditeur);
        Element courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbComposant").getChild(Main.Cste.langue);
        LbComposant.setText(courant.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtModifierSequence").getChild(Main.Cste.langue);
        BtModifierSequence.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtCreerSequence").getChild(Main.Cste.langue);
        BtCreerSequence.setText(courant.getText());
        
        BtAfficherDescriptionInterface.setToolTipText(Main.CreationRegles.toolTip1BtAfficherDescription);
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("tootltipBtModifierDescriptionInterface").getChild(Main.Cste.langue);
        BtModifierDescriptionInterface.setToolTipText(courant.getText());
    }
    
    private void chargerCBEvenements(JComboBox cb)
    {
        cb.removeAllItems();
        for(int i=0; i<Main.CreationRegles.lesEvenements.size(); i++)
        {
            Element eve = Main.CreationRegles.lesEvenements.get(i);
            if(eve.getAttributeValue(Main.CreationRegles.attributTypeEve).equals(Main.CreationRegles.attributActionUtilisateur) || eve.getAttributeValue(Main.CreationRegles.attributTypeEve).equals(Main.CreationRegles.attributEveSA))
                cb.addItem(Main.CreationRegles.affichageEvenement(eve));
        }
        cb.setSelectedIndex(-1);
    }
    
    private void chargerCBActionsElem(JComboBox cb)
    {
        cb.removeAllItems();
        for(int i=0; i<Main.CreationRegles.lesEvenements.size(); i++)
        {
            Element eve = Main.CreationRegles.lesEvenements.get(i);
            if(eve.getAttributeValue(Main.CreationRegles.attributTypeEve).equals(Main.CreationRegles.attributActionUtilisateur))
                cb.addItem(Main.CreationRegles.affichageEvenement(eve));
        }
        cb.setSelectedIndex(-1);
    }
    
    private Element creerEvenementTimerFin()
    {
        Element eve = new Element("evenement");
        
        eve.setAttribute(Main.CreationRegles.attributId, TxtNomEvenement.getText());
        eve.setAttribute(Main.CreationRegles.attributTypeEve, Main.CreationRegles.attributTimerFixe);           
        eve.setAttribute(Main.CreationRegles.attributDuree, Main.CreationRegles.convertirUniteEnMillisecondes(SpinDureeTimerFin.getValue().toString(), CbUniteTimerFin.getSelectedItem().toString()));
        eve.setAttribute(Main.CreationRegles.attributUnite, CbUniteTimerFin.getSelectedItem().toString());
            
        return eve;
    }
    
    private Element creerEvenementTimerRelatif()
    {
        Element eve = new Element("evenement");
        
        eve.setAttribute(Main.CreationRegles.attributId, TxtNomEvenement.getText());
        eve.setAttribute(Main.CreationRegles.attributTypeEve, Main.CreationRegles.attributTimerRelatif);
        
        if(RbDepuisEve.isSelected())
        {
            eve.setAttribute(Main.CreationRegles.attributSousTypeEve, Main.CreationRegles.attributEvenement);
            eve.setAttribute(Main.CreationRegles.attributObjet, CbDepuisEve.getSelectedItem().toString().substring(0, CbDepuisEve.getSelectedItem().toString().indexOf(" :")));
        }
        else if (RbDepuisActionElem.isSelected())
        {
            eve.setAttribute(Main.CreationRegles.attributSousTypeEve, Main.CreationRegles.attributActionUtilisateur);
            String s=Main.CreationRegles.attributAucuneAction;
            if(CbDepuisActionElem.getSelectedItem().toString().equals(itemAucunDeplacementSouris))
                s=Main.CreationRegles.attributAucunDeplacementSouris;
            else if(CbDepuisActionElem.getSelectedItem().toString().equals(itemAucunClic))
                s=Main.CreationRegles.attributAucunClic;
            else if(CbDepuisActionElem.getSelectedItem().toString().equals(itemAbsenceEvenement))
                s=Main.CreationRegles.attributAbsenceEvenement;
            eve.setAttribute(Main.CreationRegles.attributObjet, s);
            if(CbDepuisActionElemDonnee.isEnabled())
                eve.setAttribute(Main.CreationRegles.attributSousObjet, CbDepuisActionElemDonnee.getSelectedItem().toString().substring(0, CbDepuisActionElemDonnee.getSelectedItem().toString().indexOf(" :")));
        }
        else if (RbDepuisEveSA.isSelected())
        {
            eve.setAttribute(Main.CreationRegles.attributSousTypeEve, Main.CreationRegles.attributEveSA);
            String s=Main.CreationRegles.attributAucuneAction;
            if(CbDepuisEveSA.getSelectedItem().toString().equals(itemDeclenchementRegle))
                s=Main.CreationRegles.attributAucuneRegle;
            else if(CbDepuisEveSA.getSelectedItem().toString().equals(itemDeclenchementRegleAction))
                s=Main.CreationRegles.attributAucuneRegleAction;
            eve.setAttribute(Main.CreationRegles.attributObjet, s);
        }
        
        eve.setAttribute(Main.CreationRegles.attributDuree, Main.CreationRegles.convertirUniteEnMillisecondes(SpinDureeTimerFin.getValue().toString(), CbUniteTimerFin.getSelectedItem().toString()));
        eve.setAttribute(Main.CreationRegles.attributUnite, CbUniteTimerFin.getSelectedItem().toString());
        
        return eve;
    }
    
    private Element creerEveSA()
    {
        Element eve = new Element("evenement");
        eve.setAttribute(Main.CreationRegles.attributTypeEve, Main.CreationRegles.attributEveSA);
        eve.setAttribute(Main.CreationRegles.attributId, TxtNomEvenement.getText());
        String t=Main.CreationRegles.attributDeclenchement;
        if(CbEvenementEveSA.getSelectedItem().toString().equals(Main.CreationRegles.itemFin))
            t=Main.CreationRegles.attributFin;
        eve.setAttribute(Main.CreationRegles.attributType, t);
        eve.setAttribute(Main.CreationRegles.attributObjet, CbObjetEveSA.getSelectedItem().toString());
        return eve;
    }
    
    private Element creerEvenementActionElem()
    {
        Element eve = new Element("evenement");
        eve.setAttribute(Main.CreationRegles.attributTypeEve, Main.CreationRegles.attributActionUtilisateur);
        eve.setAttribute(Main.CreationRegles.attributId, TxtNomEvenement.getText());
        eve.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.cleParValeur(Main.CreationRegles.listeTypesEvenements, CbTypeEvenement.getSelectedItem().toString()));
        eve.setAttribute(Main.CreationRegles.attributIdComp, TxtComposant.getText());
        return eve;
    }
    
    public void modifEveSA(Element eve)
    {
        CbChoixTypeEvenement.setSelectedItem(itemEveSA);
        TxtNomEvenement.setText(eve.getAttributeValue(Main.CreationRegles.attributId));
        String s = Main.CreationRegles.itemDeclenchement;
        if(eve.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.attributFin))
            s=Main.CreationRegles.itemFin;
        CbEvenementEveSA.setSelectedItem(s);
        CbObjetEveSA.setSelectedItem(eve.getAttributeValue(Main.CreationRegles.attributObjet));
        this.setVisible(true);
    }
    
    public void modifEvenementActionElem(Element eve)
    {
        CbChoixTypeEvenement.setSelectedItem(itemActionUtilisateur);
        TxtNomEvenement.setText(eve.getAttributeValue(Main.CreationRegles.attributId));
        TxtNomEvenement.setText(eve.getAttributeValue(Main.CreationRegles.attributId));
        TxtComposant.setText(eve.getAttributeValue(Main.CreationRegles.attributIdComp));
        CbTypeEvenement.setSelectedItem(Main.CreationRegles.listeTypesEvenements.get(eve.getAttributeValue(Main.CreationRegles.attributType)));
        this.setVisible(true);
    }
    
    public void modifEvenementTimerRelatif(Element eve)
    {
        CbChoixTypeEvenement.setSelectedItem(itemTimerFin);
        TxtNomEvenement.setText(eve.getAttributeValue(Main.CreationRegles.attributId));
        if(eve.getAttributeValue(Main.CreationRegles.attributSousTypeEve).equals(Main.CreationRegles.attributEveSA))
        {
            RbDepuisEveSA.setSelected(true);
            if(eve.getAttributeValue(Main.CreationRegles.attributObjet).equals(Main.CreationRegles.attributAucuneAction))
                CbDepuisEveSA.setSelectedItem(itemDeclenchementAction);
            else if(eve.getAttributeValue(Main.CreationRegles.attributObjet).equals(Main.CreationRegles.attributAucuneRegle))
                CbDepuisEveSA.setSelectedItem(itemDeclenchementRegle);
            else
                CbDepuisEveSA.setSelectedItem(itemDeclenchementRegleAction);
        }
        else if(eve.getAttributeValue(Main.CreationRegles.attributSousTypeEve).equals(Main.CreationRegles.attributEvenement))
        {
            RbDepuisEve.setSelected(true);
            Element e = Main.CreationRegles.evenementParId(eve.getAttributeValue(Main.CreationRegles.attributObjet));
            CbDepuisEve.setSelectedItem(Main.CreationRegles.affichageEvenement(e));
        }
        else if(eve.getAttributeValue(Main.CreationRegles.attributSousTypeEve).equals(Main.CreationRegles.attributActionUtilisateur))
        {
            RbDepuisActionElem.setSelected(true);
            if(eve.getAttributeValue(Main.CreationRegles.attributObjet).equals(Main.CreationRegles.attributAucuneAction))
                CbDepuisActionElem.setSelectedItem(itemAucuneAction);
            else if(eve.getAttributeValue(Main.CreationRegles.attributObjet).equals(Main.CreationRegles.attributAucunClic))
                CbDepuisActionElem.setSelectedItem(itemAucunClic);
            else if(eve.getAttributeValue(Main.CreationRegles.attributObjet).equals(Main.CreationRegles.attributAucunDeplacementSouris))
                CbDepuisActionElem.setSelectedItem(itemAucunDeplacementSouris);
            else
                CbDepuisActionElem.setSelectedItem(itemAbsenceEvenement);
            if(eve.getAttribute(Main.CreationRegles.attributSousObjet)!=null)
            {
                Element e = Main.CreationRegles.evenementParId(eve.getAttributeValue(Main.CreationRegles.attributSousObjet));
                CbDepuisActionElemDonnee.setSelectedItem(Main.CreationRegles.affichageEvenement(e));
            }
        }
        this.setVisible(true);
    }
    
    public void modifEvenementTimerFin(Element eve)
    {
        CbChoixTypeEvenement.setSelectedItem(itemTimerFin);
        TxtNomEvenement.setText(eve.getAttributeValue(Main.CreationRegles.attributId));
        if(eve.getAttributeValue(Main.CreationRegles.attributTypeEve).equals(Main.CreationRegles.attributTimerFixe))
        {
            RbDepuisRegle.setSelected(true); 
            int v = Integer.parseInt(Main.CreationRegles.convertirMillisecondesEnUnite(eve.getAttributeValue(Main.CreationRegles.attributDuree), eve.getAttributeValue(Main.CreationRegles.attributUnite)));
            SpinDureeTimerFin.setValue(v);
            CbUniteTimerFin.setSelectedItem(eve.getAttributeValue(Main.CreationRegles.attributUnite));
        }
        this.setVisible(true);
    }
    
    private void annuler()
    {
        if(CB!=null)
        {
            CB.setSelectedItem(Main.CreationRegles.itemLancementAssistance);
            CB.setSelectedItem(Main.CreationRegles.itemAucun);
            CB=null;
        }
        
        CbChoixTypeEvenement.setSelectedIndex(-1);
        Main.CreationEvenements.setVisible(false);
    }
    
    private void valider(Element eve, int ligne)
    {
        Main.CreationRegles.afficherEvenement(eve, ligne);
            
        TxtNomEvenement.setText("E" + Main.CreationRegles.idEvenement);
        PanelActionElem.setVisible(false);
        CbChoixTypeEvenement.setSelectedIndex(-1);
        CbChoixTypeEvenement.setEnabled(true);

        Main.CreationRegles.chargerEvenementDeclencheur();
        Main.CreationRegles.chargerEvenementFin();

        if(CB!=null)
        {
            CB.setSelectedItem(eve.getAttributeValue(Main.CreationRegles.attributId));
            CB=null;
        }
        this.setVisible(false);
    }
    
    private void validerEvenement(Element eve, boolean modif)
    {         
        int ligne;
        if (modif) 
        {
            ligne = Main.CreationRegles.ligneModifEvenement;
            Element e = Main.CreationRegles.evenementParId(TxtNomEvenement.getText());
            Main.CreationRegles.lesEvenements.add(Main.CreationRegles.lesEvenements.indexOf(e), eve);
            Main.CreationRegles.lesEvenements.remove(e);
            Main.CreationRegles.modifEvenementActionElem = false;
            Main.CreationRegles.modifEvenementTimerFin = false;
            Main.CreationRegles.modifEvenementTimerRelatif = false;
        } 
        else 
        {
            ligne = Main.CreationRegles.lesEvenements.size();
            Main.CreationRegles.modelEvenement.addRow(new Object[]{"", "", ""});
            Main.CreationRegles.lesEvenements.add(eve);
            Main.CreationRegles.idEvenement++;
        }
        valider(eve, ligne);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Group = new javax.swing.ButtonGroup();
        PanelCreationEvenement = new javax.swing.JPanel();
        LbNomEvenement = new javax.swing.JLabel();
        TxtNomEvenement = new javax.swing.JTextField();
        LbChoixTypeEvenement = new javax.swing.JLabel();
        CbChoixTypeEvenement = new javax.swing.JComboBox();
        PanelActionElem = new javax.swing.JPanel();
        ScrollArbre = new javax.swing.JScrollPane();
        Arbre = new javax.swing.JTree();
        BtModifierDescriptionInterface = new javax.swing.JButton();
        BtAfficherDescriptionInterface = new javax.swing.JButton();
        CbTypeEvenement = new javax.swing.JComboBox();
        LbComposant = new javax.swing.JLabel();
        TxtComposant = new javax.swing.JTextField();
        BtValiderActionElem = new javax.swing.JButton();
        BtAnnulerActionElem = new javax.swing.JButton();
        LbTypeEvenement = new javax.swing.JLabel();
        PanelSequence = new javax.swing.JPanel();
        CbSequenceEvenements = new javax.swing.JComboBox();
        BtModifierSequence = new javax.swing.JButton();
        BtCreerSequence = new javax.swing.JButton();
        PanelTimerFin = new javax.swing.JPanel();
        BtValiderTimerFin = new javax.swing.JButton();
        BtAnnulerTimerFin = new javax.swing.JButton();
        LbDureeTimerFin = new javax.swing.JLabel();
        SpinDureeTimerFin = new javax.swing.JSpinner();
        CbUniteTimerFin = new javax.swing.JComboBox();
        RbDepuisRegle = new javax.swing.JRadioButton();
        RbDepuisEve = new javax.swing.JRadioButton();
        RbDepuisActionElem = new javax.swing.JRadioButton();
        CbDepuisActionElem = new javax.swing.JComboBox();
        CbDepuisEve = new javax.swing.JComboBox();
        RbDepuisEveSA = new javax.swing.JRadioButton();
        CbDepuisEveSA = new javax.swing.JComboBox();
        CbDepuisActionElemDonnee = new javax.swing.JComboBox();
        PanelEveSA = new javax.swing.JPanel();
        BtValiderEveSA = new javax.swing.JButton();
        BtAnnulerEveSA = new javax.swing.JButton();
        LbEvenementEveSA = new javax.swing.JLabel();
        CbEvenementEveSA = new javax.swing.JComboBox();
        CbObjetEveSA = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PanelCreationEvenement.setBackground(new java.awt.Color(232, 249, 217));

        LbNomEvenement.setText("Nom de l'événément");

        TxtNomEvenement.setEnabled(false);

        LbChoixTypeEvenement.setText("Type d'événement");

        CbChoixTypeEvenement.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbChoixTypeEvenement.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbChoixTypeEvenementItemStateChanged(evt);
            }
        });

        PanelActionElem.setBackground(new java.awt.Color(232, 249, 217));

        Arbre.setToolTipText("");
        Arbre.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                ArbreValueChanged(evt);
            }
        });
        ScrollArbre.setViewportView(Arbre);

        BtModifierDescriptionInterface.setText("...");
        BtModifierDescriptionInterface.setToolTipText("Modifier la description de l'interface");
        BtModifierDescriptionInterface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierDescriptionInterfaceActionPerformed(evt);
            }
        });

        BtAfficherDescriptionInterface.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        BtAfficherDescriptionInterface.setText("+");
        BtAfficherDescriptionInterface.setToolTipText("Afficher la totalité de la description de l'interface");
        BtAfficherDescriptionInterface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAfficherDescriptionInterfaceActionPerformed(evt);
            }
        });

        CbTypeEvenement.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        LbComposant.setText("sur le composant");

        TxtComposant.setText(" ");
        TxtComposant.setEnabled(false);

        BtValiderActionElem.setText("Valider");
        BtValiderActionElem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderActionElemActionPerformed(evt);
            }
        });

        BtAnnulerActionElem.setText("Annuler");
        BtAnnulerActionElem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerActionElemActionPerformed(evt);
            }
        });

        LbTypeEvenement.setText("Action de l'utilisateur");

        javax.swing.GroupLayout PanelActionElemLayout = new javax.swing.GroupLayout(PanelActionElem);
        PanelActionElem.setLayout(PanelActionElemLayout);
        PanelActionElemLayout.setHorizontalGroup(
            PanelActionElemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelActionElemLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(PanelActionElemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelActionElemLayout.createSequentialGroup()
                        .addGroup(PanelActionElemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollArbre, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelActionElemLayout.createSequentialGroup()
                                .addGroup(PanelActionElemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LbComposant, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LbTypeEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelActionElemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CbTypeEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtComposant, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(32, 32, 32)
                        .addGroup(PanelActionElemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtModifierDescriptionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtAfficherDescriptionInterface)))
                    .addGroup(PanelActionElemLayout.createSequentialGroup()
                        .addComponent(BtValiderActionElem)
                        .addGap(31, 31, 31)
                        .addComponent(BtAnnulerActionElem)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        PanelActionElemLayout.setVerticalGroup(
            PanelActionElemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelActionElemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelActionElemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CbTypeEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbTypeEvenement, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelActionElemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelActionElemLayout.createSequentialGroup()
                        .addComponent(BtModifierDescriptionInterface)
                        .addGap(18, 18, 18)
                        .addComponent(BtAfficherDescriptionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelActionElemLayout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addGroup(PanelActionElemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbComposant)
                            .addComponent(TxtComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ScrollArbre, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelActionElemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtAnnulerActionElem)
                    .addComponent(BtValiderActionElem))
                .addContainerGap())
        );

        PanelSequence.setBackground(new java.awt.Color(232, 249, 217));

        CbSequenceEvenements.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BtModifierSequence.setText("Modifier");
        BtModifierSequence.setToolTipText("Modifier la séquence d'événements");
        BtModifierSequence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierSequenceActionPerformed(evt);
            }
        });

        BtCreerSequence.setText("Creer");
        BtCreerSequence.setToolTipText("Créer une nouvelle séquence d'événements");
        BtCreerSequence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCreerSequenceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSequenceLayout = new javax.swing.GroupLayout(PanelSequence);
        PanelSequence.setLayout(PanelSequenceLayout);
        PanelSequenceLayout.setHorizontalGroup(
            PanelSequenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSequenceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CbSequenceEvenements, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtModifierSequence)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtCreerSequence)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        PanelSequenceLayout.setVerticalGroup(
            PanelSequenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSequenceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSequenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbSequenceEvenements, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtModifierSequence)
                    .addComponent(BtCreerSequence))
                .addContainerGap(184, Short.MAX_VALUE))
        );

        PanelTimerFin.setBackground(new java.awt.Color(232, 249, 217));

        BtValiderTimerFin.setText("Valider");
        BtValiderTimerFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderTimerFinActionPerformed(evt);
            }
        });

        BtAnnulerTimerFin.setText("Annuler");
        BtAnnulerTimerFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerTimerFinActionPerformed(evt);
            }
        });

        LbDureeTimerFin.setText("Durée");

        SpinDureeTimerFin.setModel(new javax.swing.SpinnerNumberModel(30, 0, 500, 1));

        CbUniteTimerFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        RbDepuisRegle.setBackground(new java.awt.Color(232, 249, 217));
        Group.add(RbDepuisRegle);
        RbDepuisRegle.setSelected(true);
        RbDepuisRegle.setText("Depuis le déclenchement de la règle en cours");

        RbDepuisEve.setBackground(new java.awt.Color(232, 249, 217));
        Group.add(RbDepuisEve);
        RbDepuisEve.setText("Depuis un événement");
        RbDepuisEve.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RbDepuisEveItemStateChanged(evt);
            }
        });

        RbDepuisActionElem.setBackground(new java.awt.Color(232, 249, 217));
        Group.add(RbDepuisActionElem);
        RbDepuisActionElem.setText("relatif à une absence d'action de l'utilisateur");
        RbDepuisActionElem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RbDepuisActionElemItemStateChanged(evt);
            }
        });

        CbDepuisActionElem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbDepuisActionElem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbDepuisActionElemItemStateChanged(evt);
            }
        });

        CbDepuisEve.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbDepuisEve.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbDepuisEveItemStateChanged(evt);
            }
        });

        RbDepuisEveSA.setBackground(new java.awt.Color(232, 249, 217));
        Group.add(RbDepuisEveSA);
        RbDepuisEveSA.setText("relatif à une absence d'événement lié à l'assistance");
        RbDepuisEveSA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RbDepuisEveSAItemStateChanged(evt);
            }
        });

        CbDepuisEveSA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbDepuisEveSA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbDepuisEveSAItemStateChanged(evt);
            }
        });

        CbDepuisActionElemDonnee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbDepuisActionElemDonnee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbDepuisActionElemDonneeItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout PanelTimerFinLayout = new javax.swing.GroupLayout(PanelTimerFin);
        PanelTimerFin.setLayout(PanelTimerFinLayout);
        PanelTimerFinLayout.setHorizontalGroup(
            PanelTimerFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimerFinLayout.createSequentialGroup()
                .addGroup(PanelTimerFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTimerFinLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(PanelTimerFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelTimerFinLayout.createSequentialGroup()
                                .addComponent(BtValiderTimerFin)
                                .addGap(31, 31, 31)
                                .addComponent(BtAnnulerTimerFin))
                            .addGroup(PanelTimerFinLayout.createSequentialGroup()
                                .addComponent(LbDureeTimerFin)
                                .addGap(30, 30, 30)
                                .addComponent(SpinDureeTimerFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CbUniteTimerFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelTimerFinLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RbDepuisRegle))
                    .addGroup(PanelTimerFinLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RbDepuisEve)
                        .addGap(144, 144, 144)
                        .addComponent(CbDepuisEve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTimerFinLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RbDepuisActionElem)
                        .addGap(18, 18, 18)
                        .addComponent(CbDepuisActionElem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CbDepuisActionElemDonnee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTimerFinLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RbDepuisEveSA)
                        .addGap(18, 18, 18)
                        .addComponent(CbDepuisEveSA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        PanelTimerFinLayout.setVerticalGroup(
            PanelTimerFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTimerFinLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(PanelTimerFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbDureeTimerFin)
                    .addComponent(SpinDureeTimerFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbUniteTimerFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(RbDepuisRegle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelTimerFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbDepuisEve)
                    .addComponent(CbDepuisEve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelTimerFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbDepuisActionElem)
                    .addComponent(CbDepuisActionElem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbDepuisActionElemDonnee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelTimerFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbDepuisEveSA)
                    .addComponent(CbDepuisEveSA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(PanelTimerFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtAnnulerTimerFin)
                    .addComponent(BtValiderTimerFin))
                .addContainerGap())
        );

        BtValiderEveSA.setText("Valider");
        BtValiderEveSA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderEveSAActionPerformed(evt);
            }
        });

        BtAnnulerEveSA.setText("Annuler");
        BtAnnulerEveSA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerEveSAActionPerformed(evt);
            }
        });

        LbEvenementEveSA.setText("Evénement");

        CbEvenementEveSA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CbObjetEveSA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout PanelEveSALayout = new javax.swing.GroupLayout(PanelEveSA);
        PanelEveSA.setLayout(PanelEveSALayout);
        PanelEveSALayout.setHorizontalGroup(
            PanelEveSALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEveSALayout.createSequentialGroup()
                .addGroup(PanelEveSALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEveSALayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(BtValiderEveSA)
                        .addGap(31, 31, 31)
                        .addComponent(BtAnnulerEveSA))
                    .addGroup(PanelEveSALayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LbEvenementEveSA)
                        .addGap(27, 27, 27)
                        .addComponent(CbEvenementEveSA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CbObjetEveSA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        PanelEveSALayout.setVerticalGroup(
            PanelEveSALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEveSALayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(PanelEveSALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbEvenementEveSA)
                    .addComponent(CbEvenementEveSA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbObjetEveSA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(PanelEveSALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtAnnulerEveSA)
                    .addComponent(BtValiderEveSA))
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelCreationEvenementLayout = new javax.swing.GroupLayout(PanelCreationEvenement);
        PanelCreationEvenement.setLayout(PanelCreationEvenementLayout);
        PanelCreationEvenementLayout.setHorizontalGroup(
            PanelCreationEvenementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationEvenementLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(LbNomEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtNomEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LbChoixTypeEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CbChoixTypeEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(PanelCreationEvenementLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(PanelCreationEvenementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationEvenementLayout.createSequentialGroup()
                        .addComponent(PanelEveSA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(PanelCreationEvenementLayout.createSequentialGroup()
                        .addComponent(PanelActionElem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(PanelTimerFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelSequence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        PanelCreationEvenementLayout.setVerticalGroup(
            PanelCreationEvenementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationEvenementLayout.createSequentialGroup()
                .addGroup(PanelCreationEvenementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationEvenementLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelCreationEvenementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbChoixTypeEvenement)
                            .addComponent(CbChoixTypeEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNomEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LbNomEvenement))
                        .addGap(35, 35, 35)
                        .addGroup(PanelCreationEvenementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PanelActionElem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanelTimerFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PanelCreationEvenementLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(PanelSequence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addComponent(PanelEveSA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1335, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelCreationEvenement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelCreationEvenement, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ArbreValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_ArbreValueChanged
        if (!Arbre.isSelectionEmpty()) {
            if (!Arbre.isRowSelected(0)) {
                String compo = Arbre.getSelectionPath().getLastPathComponent().toString();
                String id = Main.CreationRegles.noeudGetId(compo);
                TxtComposant.setText(id);
                Element comp = Main.CreationRegles.elementParId(Main.CreationRegles.lesComposants, id);
                if (comp.getAttribute(Main.CreationRegles.attributTypeAjoute) != null) {
                    Main.CreationRegles.chargerCbTypeEvenements(CbTypeEvenement, comp.getAttributeValue(Main.CreationRegles.attributTypeAjoute));
                } else {
                    Main.CreationRegles.chargerCbTypeEvenements(CbTypeEvenement, "");
                }
            }
        }
    }//GEN-LAST:event_ArbreValueChanged

    private void BtModifierDescriptionInterfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierDescriptionInterfaceActionPerformed
        Main.ModificationInterface.chargerInterface();
        Main.ModificationInterface.setVisible(true);
    }//GEN-LAST:event_BtModifierDescriptionInterfaceActionPerformed

    private void BtAfficherDescriptionInterfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAfficherDescriptionInterfaceActionPerformed
        Main.CreationRegles.affichageDescription(BtAfficherDescriptionInterface, Arbre);
    }//GEN-LAST:event_BtAfficherDescriptionInterfaceActionPerformed

    private void BtModifierSequenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierSequenceActionPerformed
        if (CbSequenceEvenements.getSelectedIndex() >= 0) {
            Main.CreationSequence.pasAPas = false;
            Main.CreationSequence.creer = false;
            Main.CreationSequence.listModel = Main.CreationRegles.listModel;
            Main.CreationSequence.sequence = (Element) Main.CreationRegles.elementParId(Main.CreationRegles.lesSequences, CbSequenceEvenements.getSelectedItem().toString().substring(0, CbSequenceEvenements.getSelectedItem().toString().indexOf("_"))).clone();
            Main.CreationSequence.ChargerInterface();
            Main.CreationSequence.ouvrirOptions();
            Main.CreationSequence.setVisible(true);
        }
    }//GEN-LAST:event_BtModifierSequenceActionPerformed

    private void BtCreerSequenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCreerSequenceActionPerformed
        Main.CreationSequence.pasAPas = false;
        Main.CreationSequence.creer = true;
        Main.CreationSequence.listModel = Main.CreationRegles.listModel;
        Main.CreationSequence.sequence = null;
        Main.CreationSequence.ChargerInterface();
        Main.CreationSequence.setVisible(true);
    }//GEN-LAST:event_BtCreerSequenceActionPerformed

    private void CbChoixTypeEvenementItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbChoixTypeEvenementItemStateChanged
        if (CbChoixTypeEvenement.getSelectedIndex() >= 0) {
            PanelActionElem.setVisible(false);
            PanelSequence.setVisible(false);
            PanelTimerFin.setVisible(false);
            PanelEveSA.setVisible(false);

            if (CbChoixTypeEvenement.getSelectedItem().toString().equals(itemActionUtilisateur)) 
            {
                PanelActionElem.setVisible(true);
            } 
            else if (CbChoixTypeEvenement.getSelectedItem().toString().equals(itemSequenceEvenements)) 
            {
                PanelSequence.setVisible(true);
            }
            else if (CbChoixTypeEvenement.getSelectedItem().toString().equals(itemTimerFin)) 
            {
                PanelTimerFin.setVisible(true);
            }
            else if (CbChoixTypeEvenement.getSelectedItem().toString().equals(itemEveSA)) 
            {
                PanelEveSA.setVisible(true);
            }
        }
    }//GEN-LAST:event_CbChoixTypeEvenementItemStateChanged

    private void BtValiderActionElemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderActionElemActionPerformed
        if (TxtComposant.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "Vous devez sélectionner un composant", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(CbTypeEvenement.getSelectedIndex()<0)
        {
            JOptionPane.showMessageDialog(null, "Vous devez choisir un type d'action élémentaire de l'utilisateur", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            Element eve = creerEvenementActionElem();
            validerEvenement(eve, Main.CreationRegles.modifEvenementActionElem);
        }
    }//GEN-LAST:event_BtValiderActionElemActionPerformed

    private void BtAnnulerActionElemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerActionElemActionPerformed
        Main.CreationRegles.modifConditionTraces = false;
        annuler();
    }//GEN-LAST:event_BtAnnulerActionElemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        annuler();
    }//GEN-LAST:event_formWindowClosing

    private void BtValiderTimerFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderTimerFinActionPerformed
        if(RbDepuisRegle.isSelected())
        {
            Element eve = creerEvenementTimerFin();
            validerEvenement(eve, Main.CreationRegles.modifEvenementTimerFin);
        }
        else
        {           
            Element eve = creerEvenementTimerRelatif();
            validerEvenement(eve, Main.CreationRegles.modifEvenementTimerRelatif);
        }
    }//GEN-LAST:event_BtValiderTimerFinActionPerformed

    private void BtAnnulerTimerFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerTimerFinActionPerformed
        Main.CreationRegles.modifEvenementTimerFin = false;
        annuler();
    }//GEN-LAST:event_BtAnnulerTimerFinActionPerformed

    private void BtValiderEveSAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderEveSAActionPerformed
        if (CbEvenementEveSA.getSelectedIndex()<0) 
        {
            JOptionPane.showMessageDialog(null, "vous devez choisir un type d'événement", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (CbObjetEveSA.getSelectedIndex()<0) 
        {
            JOptionPane.showMessageDialog(null, "vous devez choisir une règle ou action", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            Element eve = creerEveSA();
            validerEvenement(eve, Main.CreationRegles.modifEveSA);
        }
    }//GEN-LAST:event_BtValiderEveSAActionPerformed

    private void BtAnnulerEveSAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerEveSAActionPerformed
        Main.CreationRegles.modifEveSA = false;
        annuler();
    }//GEN-LAST:event_BtAnnulerEveSAActionPerformed

    private void RbDepuisActionElemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RbDepuisActionElemItemStateChanged
        CbDepuisActionElem.setEnabled(RbDepuisActionElem.isSelected());
        CbDepuisActionElemDonnee.setEnabled(RbDepuisActionElem.isSelected() && CbDepuisActionElem.getSelectedIndex()>=0 && CbDepuisActionElem.getSelectedItem().toString().equals(itemAbsenceEvenement));
    }//GEN-LAST:event_RbDepuisActionElemItemStateChanged

    private void RbDepuisEveItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RbDepuisEveItemStateChanged
        CbDepuisEve.setEnabled(RbDepuisEve.isSelected());
    }//GEN-LAST:event_RbDepuisEveItemStateChanged

    private void CbDepuisEveItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbDepuisEveItemStateChanged

    }//GEN-LAST:event_CbDepuisEveItemStateChanged

    private void RbDepuisEveSAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RbDepuisEveSAItemStateChanged
        CbDepuisEveSA.setEnabled(RbDepuisEveSA.isSelected());
    }//GEN-LAST:event_RbDepuisEveSAItemStateChanged

    private void CbDepuisEveSAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbDepuisEveSAItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_CbDepuisEveSAItemStateChanged

    private void CbDepuisActionElemDonneeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbDepuisActionElemDonneeItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_CbDepuisActionElemDonneeItemStateChanged

    private void CbDepuisActionElemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbDepuisActionElemItemStateChanged
        CbDepuisActionElemDonnee.setEnabled(RbDepuisActionElem.isSelected() && CbDepuisActionElem.getSelectedIndex()>=0 && CbDepuisActionElem.getSelectedItem().toString().equals(itemAbsenceEvenement));
    }//GEN-LAST:event_CbDepuisActionElemItemStateChanged

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
            java.util.logging.Logger.getLogger(CreationEvenements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreationEvenements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreationEvenements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreationEvenements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CreationEvenements().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree Arbre;
    private javax.swing.JButton BtAfficherDescriptionInterface;
    private javax.swing.JButton BtAnnulerActionElem;
    private javax.swing.JButton BtAnnulerEveSA;
    private javax.swing.JButton BtAnnulerTimerFin;
    private javax.swing.JButton BtCreerSequence;
    private javax.swing.JButton BtModifierDescriptionInterface;
    private javax.swing.JButton BtModifierSequence;
    private javax.swing.JButton BtValiderActionElem;
    private javax.swing.JButton BtValiderEveSA;
    private javax.swing.JButton BtValiderTimerFin;
    private javax.swing.JComboBox CbChoixTypeEvenement;
    private javax.swing.JComboBox CbDepuisActionElem;
    private javax.swing.JComboBox CbDepuisActionElemDonnee;
    private javax.swing.JComboBox CbDepuisEve;
    private javax.swing.JComboBox CbDepuisEveSA;
    private javax.swing.JComboBox CbEvenementEveSA;
    private javax.swing.JComboBox CbObjetEveSA;
    private javax.swing.JComboBox CbSequenceEvenements;
    private javax.swing.JComboBox CbTypeEvenement;
    private javax.swing.JComboBox CbUniteTimerFin;
    private javax.swing.ButtonGroup Group;
    private javax.swing.JLabel LbChoixTypeEvenement;
    private javax.swing.JLabel LbComposant;
    private javax.swing.JLabel LbDureeTimerFin;
    private javax.swing.JLabel LbEvenementEveSA;
    private javax.swing.JLabel LbNomEvenement;
    private javax.swing.JLabel LbTypeEvenement;
    private javax.swing.JPanel PanelActionElem;
    private javax.swing.JPanel PanelCreationEvenement;
    private javax.swing.JPanel PanelEveSA;
    private javax.swing.JPanel PanelSequence;
    private javax.swing.JPanel PanelTimerFin;
    private javax.swing.JRadioButton RbDepuisActionElem;
    private javax.swing.JRadioButton RbDepuisEve;
    private javax.swing.JRadioButton RbDepuisEveSA;
    private javax.swing.JRadioButton RbDepuisRegle;
    private javax.swing.JScrollPane ScrollArbre;
    private javax.swing.JSpinner SpinDureeTimerFin;
    private javax.swing.JTextField TxtComposant;
    private javax.swing.JTextField TxtNomEvenement;
    // End of variables declaration//GEN-END:variables
}
