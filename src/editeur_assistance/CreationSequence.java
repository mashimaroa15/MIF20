/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.jdom.Element;

/**
 *
 * @author Blandine
 */
public class CreationSequence extends javax.swing.JFrame {

    public boolean pasAPas=false; 
    public boolean creer=false; 
    public DefaultListModel listModel = new DefaultListModel();
    public Element sequence;
    /**
     * Creates new form CreationSequence
     */
    public CreationSequence() {
        initComponents();

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setBounds(150, 50, 690, 750);
        
        ToolTipManager.sharedInstance().registerComponent(Arbre);
        
        this.setLayout(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/icone_editeur.png"));
        this.setIconImage(icon);
        
        LbId.setBounds(10, 10, 170, 24);
        TxtId.setBounds(170, 10, 60, 24);
        
        LbNom.setBounds(265, 10, 150, 24);
        TxtNom.setBounds(400, 10, 260, 24);
        
        BtHaut.setBounds(10, 145, 50, 35);
        BtBas.setBounds(70, 145, 50, 35);
        BtSupprimer.setBounds(130, 145, 50, 35);
        BtModifier.setBounds(190, 145, 50, 35);
        BtAjouter.setBounds(250, 145, 50, 35);
        BtEnregistrer.setBounds(410, 145, 100, 35);
        
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/fleche_haut.png"));
        BtHaut.setIcon(new ImageIcon(icon));
        BtHaut.setText("");
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/fleche_bas.png"));
        BtBas.setIcon(new ImageIcon(icon));
        BtBas.setText("");
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/croix-rouge.png"));
        BtSupprimer.setIcon(new ImageIcon(icon));
        BtSupprimer.setText("");
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/modifier.png"));
        BtModifier.setIcon(new ImageIcon(icon));
        BtModifier.setText("");
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plus.png"));
        BtAjouter.setIcon(new ImageIcon(icon));
        BtAjouter.setText("");
        
        PanelEvenement.setBounds(0, 190, this.getWidth(), 250);
        PanelEvenement.setLayout(null);
        
        LbComposant.setBounds(275, 10, 100, 24);
        TxtComposant.setBounds(395, 10, 60, 24); 
        
        BtValiderEvenement.setBounds(570, 10, 60, 24); 
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/check.png"));
        BtValiderEvenement.setIcon(new ImageIcon(icon));
        BtValiderEvenement.setText("");
        
        PanelValeurActionInterface.setBounds(20, 40, PanelEvenement.getWidth()-20, 30);
        PanelValeurActionInterface.setLayout(null);
        
        LbValeurActionInterface.setBounds(0, 0, 200, 24);
        TxtValeurActionInterface.setBounds(110, 0, 300, 24);
        
        PanelEtatActionInterface.setBounds(20, 40, PanelEvenement.getWidth()-20, 30);
        PanelEtatActionInterface.setLayout(null);
        
        LbEvenement.setBounds(20, 10, 120, 24);
        CbEvenement.setBounds(105, 10, 150, 24);
        
        LbEtatActionInterface.setBounds(0, 0, 200, 24);
        RbOnActionInterface.setBounds(110, 0, 100, 24);
        RbOffActionInterface.setBounds(220, 0, 100, 24);
        
        ScrollArbre.setBounds(10, 70, 625, 180);
        
        BtModifierDescriptionInterface.setBounds(640, 150, 30, 24);
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/modifierPetite.png"));
        BtModifierDescriptionInterface.setIcon(new ImageIcon(icon));
        BtModifierDescriptionInterface.setText("");
        BtAfficherDescriptionInterface.setBounds(640, 180, 30, 24);
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
        BtAfficherDescriptionInterface.setIcon(new ImageIcon(icon));
        BtAfficherDescriptionInterface.setText("");
        
        PanelOptions.setBounds(10, 440, this.getWidth()-35, 230);
        PanelOptions.setLayout(null);
        
        LbIgnorer.setBounds(10, 15, 230, 75);
        ScrollTypesIgnores.setBounds(240, 15, 250, 75);
        LbNbToleres.setBounds(10, 94, 440, 24);
        SpinNbToleres.setBounds(450, 94, 60, 24);
        
        CheckDureeMaxTotale.setBounds(10, 119, 220, 24);
        SpinDureeMaxTotale.setBounds(240, 119, 60, 24);
        CbDureeMaxTotale.setBounds(310, 119, 100, 24);
        CheckDureeMinTotale.setBounds(10, 146, 220, 24);
        SpinDureeMinTotale.setBounds(240, 146, 60, 24);
        CbDureeMinTotale.setBounds(310, 146, 100, 24);
        CheckDureeMaxEntre.setBounds(10, 173, 350, 24);
        SpinDureeMaxEntre.setBounds(380, 173, 60, 24);
        CbDureeMaxEntre.setBounds(450, 173, 100, 24);
        CheckDureeMinEntre.setBounds(10, 200, 350, 24);
        SpinDureeMinEntre.setBounds(380, 200, 60, 24);
        CbDureeMinEntre.setBounds(450, 200, 100, 24);
        BtRetour.setBounds(this.getWidth()/2-170, this.getHeight()-80, 150, 30);
        BtSuivant.setBounds(this.getWidth()/2, this.getHeight()-80, 150, 30);
    }
    
    public void ChargerInterface()
    {        
        ChargerLangue(); 
        if(sequence==null || creer)
        {            
            sequence=new Element("sequence");
            sequence.setAttribute("id", "S"+Main.CreationRegles.idSequence);
            sequence.setAttribute("nom", "");
            if(pasAPas)
                sequence.setAttribute("type", "actions");
            else
                sequence.setAttribute("type", "evenements");
        }
        
        TxtId.setText(sequence.getAttributeValue("id"));
        TxtNom.setText(sequence.getAttributeValue("nom"));
               
        ScrollListeEvenements.setBounds(10, 40, 655, 100);
        
        if(!pasAPas)
        {
            ChargerListeEvenements(listModel, ListeEvenements, sequence);
        }
        else
        {
            Main.CreationRegles.ChargerListeActionPasaPas(ListeEvenements, sequence);
        }
     
        PanelEvenementSetEnabled(false);
        
        if(!pasAPas)
            Main.CreationRegles.chargerCbTypeEvenements(CbEvenement, "");
        else
            Main.CreationRegles.ChargerCbActionActionInterface(CbEvenement, "");
              
        TxtComposant.setText("");                     
        PanelValeurActionInterface.setVisible(false);       
        TxtValeurActionInterface.setText("");              
        PanelEtatActionInterface.setVisible(false);       
        RbOnActionInterface.setSelected(true);       
               
        Arbre.setCellRenderer(new ArbreInfoBulles());
        Main.CreationRegles.chargerArbreComposants(Arbre, Main.CreationRegles.afficherDescriptionComplete);
        Main.CreationRegles.etendreArbre(Arbre);
               
        PanelOptions.setVisible(!pasAPas);             
        chargerTypesIgnores();
                
        CheckDureeMaxTotale.setSelected(false);       
        SpinDureeMaxTotale.setEnabled(false);        
        CbDureeMaxTotale.setEnabled(false);
        Main.CreationRegles.chargerCbUniteTemps(CbDureeMaxTotale);
                
        CheckDureeMinTotale.setSelected(false);        
        SpinDureeMinTotale.setEnabled(false);       
        CbDureeMinTotale.setEnabled(false);
        Main.CreationRegles.chargerCbUniteTemps(CbDureeMinTotale);
                
        CheckDureeMaxEntre.setSelected(false);       
        SpinDureeMaxEntre.setEnabled(false);        
        CbDureeMaxEntre.setEnabled(false);
        Main.CreationRegles.chargerCbUniteTemps(CbDureeMaxEntre);              
        CheckDureeMinEntre.setSelected(false);        
        SpinDureeMinEntre.setEnabled(false);       
        CbDureeMinEntre.setEnabled(false);
        Main.CreationRegles.chargerCbUniteTemps(CbDureeMinEntre);               
    }
    
    private void ChargerLangue()
    {
        XMLFonctions.OuvrirXML(Main.Cste.fichierInterfaceEditeur);
        Element courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("Titre").getChild(Main.Cste.langue);
        Element courant2= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("Titre").getChild(Main.Cste.langue);
        this.setTitle(courant.getText()+courant2.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("LbId").getChild(Main.Cste.langue);
        LbId.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("LbNom").getChild(Main.Cste.langue);
        LbNom.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("LbEvenement").getChild(Main.Cste.langue);
        LbEvenement.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("LbComposant").getChild(Main.Cste.langue);
        LbComposant.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("LbValeurActionInterface").getChild(Main.Cste.langue);
        LbValeurActionInterface.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("LbEtatActionInterface").getChild(Main.Cste.langue);
        LbEtatActionInterface.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("RbOnActionInterface").getChild(Main.Cste.langue);
        RbOnActionInterface.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("RbOffActionInterface").getChild(Main.Cste.langue);
        RbOffActionInterface.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("LbIgnorer").getChild(Main.Cste.langue);
        LbIgnorer.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("LbNbToleres").getChild(Main.Cste.langue);
        LbNbToleres.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("CheckDureeMaxTotale").getChild(Main.Cste.langue);
        CheckDureeMaxTotale.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("CheckDureeMinTotale").getChild(Main.Cste.langue);
        CheckDureeMinTotale.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("CheckDureeMaxEntre").getChild(Main.Cste.langue);
        CheckDureeMaxEntre.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("CheckDureeMinEntre").getChild(Main.Cste.langue);
        CheckDureeMinEntre.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("BtEnregistrer").getChild(Main.Cste.langue);
        BtEnregistrer.setText(courant.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("tooltipBtEnregistrer").getChild(Main.Cste.langue);
        BtEnregistrer.setToolTipText(courant.getText());       
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("BtHaut").getChild(Main.Cste.langue);
        BtHaut.setToolTipText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("BtBas").getChild(Main.Cste.langue);
        BtBas.setToolTipText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("BtSupprimer").getChild(Main.Cste.langue);
        BtSupprimer.setToolTipText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("BtModifier").getChild(Main.Cste.langue);
        BtModifier.setToolTipText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("creationSequence").getChild("BtAjouter").getChild(Main.Cste.langue);
        BtAjouter.setToolTipText(courant.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("tootltipBtModifierDescriptionInterface").getChild(Main.Cste.langue);
        BtModifierDescriptionInterface.setToolTipText(courant.getText());              
        BtAfficherDescriptionInterface.setToolTipText(Main.CreationRegles.toolTip1BtAfficherDescription);
        
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtRetour.setText(courant.getText());       
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("BtValider").getChild(Main.Cste.langue);
        BtSuivant.setText(courant.getText());
    }
    
    private void chargerTypesIgnores()
    {
        PanelTypesIgnores.removeAll();
        PanelTypesIgnores.setLayout(new BoxLayout(PanelTypesIgnores, BoxLayout.PAGE_AXIS));
        Iterator it=Main.CreationRegles.listeTypesEvenements.values().iterator();
        while (it.hasNext())
        {
            String nom = (String) it.next();
            JCheckBox Check = new JCheckBox(nom);
            PanelTypesIgnores.add(Check);
            Check.setBackground(PanelTypesIgnores.getBackground());
            if(!nom.equals("clic"))
            {
                Check.setSelected(true);
            }
        }
    }
    
    private boolean typeAppartientFils(Element noeud, String t)
    {
        for(int i=0; i<noeud.getChildren().size(); i++)
        {
            Element fils = (Element) noeud.getChildren().get(i);
            if(fils.getText().equals(t))
                return true;
        }
        return false;
    }
    
    public void ouvrirOptions()
    {
        Element options= sequence.getChild("options");
        if(options!=null)
        {
            Element ignores = options.getChild("evenements_ignores");
            for(int i=0; i<PanelTypesIgnores.getComponentCount(); i++)
            {
                JCheckBox check = (JCheckBox) PanelTypesIgnores.getComponent(i);
                check.setSelected(typeAppartientFils(ignores, check.getText()));
            }
            
            Element nbIntrus = options.getChild("intrus");
            SpinNbToleres.setValue(Integer.parseInt(nbIntrus.getAttributeValue("nb")));
            
            Element dureeTotale = options.getChild("dureeTotale");
            if(dureeTotale.getAttribute("max")!=null)
            {
                CheckDureeMaxTotale.setSelected(true);
                SpinDureeMaxTotale.setValue(Integer.parseInt(dureeTotale.getAttributeValue("max")));
                CbDureeMaxTotale.setSelectedItem(dureeTotale.getAttributeValue("max_unite"));
            }
            else
            {
                CheckDureeMaxTotale.setSelected(false);
            }
            
            if(dureeTotale.getAttribute("min")!=null)
            {
                CheckDureeMinTotale.setSelected(true);
                SpinDureeMinTotale.setValue(Integer.parseInt(dureeTotale.getAttributeValue("min")));
                CbDureeMinTotale.setSelectedItem(dureeTotale.getAttributeValue("min_unite"));
            }
            else
            {
                CheckDureeMinTotale.setSelected(false);
            }
            
            Element dureeEntre = options.getChild("dureeTotale");
            if(dureeEntre.getAttribute("max")!=null)
            {
                CheckDureeMaxEntre.setSelected(true);
                SpinDureeMaxEntre.setValue(Integer.parseInt(dureeEntre.getAttributeValue("max")));
                CbDureeMaxEntre.setSelectedItem(dureeEntre.getAttributeValue("max_unite"));
            }
            else
            {
                CheckDureeMaxTotale.setSelected(false);
            }
            
            if(dureeEntre.getAttribute("min")!=null)
            {
                CheckDureeMinEntre.setSelected(true);
                SpinDureeMinEntre.setValue(Integer.parseInt(dureeEntre.getAttributeValue("min")));
                CbDureeMinEntre.setSelectedItem(dureeEntre.getAttributeValue("min_unite"));
            }
            else
            {
                CheckDureeMinEntre.setSelected(false);
            }
        }
    }
    
    private void sauverOptions()
    {
        sequence.removeChild("options");
        Element options = new Element("options");
        sequence.addContent(options);
        
        Element ignores = new Element("evenements_ignores");
        for(int i=0; i<PanelTypesIgnores.getComponentCount(); i++)
        {
            JCheckBox check = (JCheckBox) PanelTypesIgnores.getComponent(i);
            if(check.isSelected())
            {
                Element type = new Element("type");
                type.setText(check.getText());
                ignores.addContent(type);
            }
        }
        
        Element nbIntrus = new Element("intrus");
        nbIntrus.setAttribute("nb", SpinNbToleres.getValue().toString());
        options.addContent(nbIntrus);
        
        Element dureeTotale = new Element("dureeTotale");
        if(CheckDureeMaxTotale.isSelected())
        {
            dureeTotale.setAttribute("max", SpinDureeMaxTotale.getValue().toString());
            dureeTotale.setAttribute("max_unite", CbDureeMaxTotale.getSelectedItem().toString());
        }
        if(CheckDureeMinTotale.isSelected())
        {
            dureeTotale.setAttribute("min", SpinDureeMinTotale.getValue().toString());
            dureeTotale.setAttribute("min_unite", CbDureeMinTotale.getSelectedItem().toString());
        }
        options.addContent(dureeTotale);        
        
        Element dureeEntre = new Element("dureeEntre");  
        if(CheckDureeMaxEntre.isSelected())
        {
            dureeEntre.setAttribute("max", SpinDureeMinEntre.getValue().toString());
            dureeEntre.setAttribute("max_unite", CbDureeMaxEntre.getSelectedItem().toString());
        }
        if(CheckDureeMinEntre.isSelected())
        {
            dureeEntre.setAttribute("min", SpinDureeMaxEntre.getValue().toString());
            dureeEntre.setAttribute("min_unite", CbDureeMinEntre.getSelectedItem().toString());
        }
        options.addContent(dureeEntre);
        
        options.addContent(ignores);
    }
    
    private String ligneEvenement(Element eve)
    {
        if(eve.getName().equals("evenement") && !eve.getAttributeValue("idComp").isEmpty())
            {
                Element composant=Main.CreationRegles.elementParId(Main.CreationRegles.lesComposants, eve.getAttributeValue("idComp"));
                if(eve.getAttributeValue("type").equals("mouseClicked"))
                {
                    if(composant.getAttribute("descriptionAjoutee")==null)
                    {
                        return "Clic sur le composant d'identifiant "+eve.getAttributeValue("idComp");
                    }
                    else
                    {
                        return "Clic sur "+composant.getAttributeValue("descriptionAjoutee");
                    }
                }
                else if(eve.getAttributeValue("type").equals("mouseEntered"))
                {
                    if (composant.getAttribute("descriptionAjoutee") == null) 
                    {
                        return "Passage de la souris sur le composant d'identifiant " + eve.getAttributeValue("idComp");
                    } 
                    else 
                    {
                        return "Passage de la souris sur " + composant.getAttributeValue("descriptionAjoutee");
                    }
                }
                else if(eve.getAttributeValue("type").equals("keyPressed"))
                {  
                    String val="";
                    if(eve.getAttribute("valeur")!=null)
                    {
                        val="de "+eve.getAttributeValue("valeur")+" ";
                    }
                    if(composant.getAttribute("descriptionAjoutee")==null)
                    {
                        return "Saisie "+val+"dans le composant d'identifiant " + eve.getAttributeValue("idComp");
                    }
                    else
                    {
                        return "Saisie "+val+"dans "+ composant.getAttributeValue("descriptionAjoutee");
                    }
                }
                else if(eve.getAttributeValue("type").equals("focusGained"))
                {                    
                    if(composant.getAttribute("descriptionAjoutee")==null)
                    {
                        return "Prise de focus du composant d'identifiant "+eve.getAttributeValue("idComp");
                    }
                    else
                    {
                        return "Prise de focus de "+composant.getAttributeValue("descriptionAjoutee");
                    }
                }
            }
        return "";
    }
    
    public void ChargerListeEvenements(DefaultListModel model, JList list, Element sequence)
    {
        for(int i=0; i<sequence.getChildren().size(); i++)
        {
            Element eve=(Element) sequence.getChildren().get(i);
            if(eve.getName().equals("evenement"))
                model.addElement(ligneEvenement(eve));
        }
        listModel=model;
        list.setModel(model);
    }
    
    private void PanelEvenementSetEnabled(boolean bool)
    {
        CbEvenement.setEnabled(bool);
        BtValiderEvenement.setEnabled(bool);
        Arbre.setEnabled(bool);
    }
    
    private void interpreterEnregistrement()
    {
        XMLFonctions.OuvrirXML(Main.Cste.fichierEnregistrement);
        Element racine = XMLFonctions.racine;
        int i=0;
        Element evePrecedent=null;
        if(racine.getChildren().size()>0)
            evePrecedent=(Element) racine.getChildren().get(0);
        while(i<racine.getChildren().size())
        {
            Element eve=(Element) racine.getChildren().get(i);
            
            if(eve.getAttributeValue("type").equals("mouseClicked"))    //on essaie de mieux interpreter les clics
            {
                Element composant= Main.CreationRegles.elementParId(Main.CreationRegles.lesComposants, eve.getAttributeValue("idComp"));
                if(composant.getAttribute("typeAjoute")!=null)
                {
                    if(composant.getAttributeValue("typeAjoute").equals("bouton radio") || composant.getAttributeValue("typeAjoute").equals("case à cocher") ||composant.getAttributeValue("typeAjoute").equals("item"))
                    {
                        eve.setAttribute("propriete", "etat");
                        eve.setAttribute("valeur", "On");
                    }
                    else
                    {
                        eve.setAttribute("propriete", "clic");
                    }
                    
                    eve.removeAttribute("type");
                }
                
                i++;
            }           
            else if(eve.getAttributeValue("type").equals("keyPressed") || eve.getAttributeValue("type").equals("keypress"))
            {
                if(evePrecedent!=null)
                {                    
                    if(evePrecedent.getAttributeValue("idComp").equals(eve.getAttributeValue("idComp"))  && evePrecedent.getAttributeValue("propriete").equals("valeur"))
                    { 
                        evePrecedent.setAttribute("valeur", evePrecedent.getAttributeValue("valeur")+eve.getAttributeValue("valeur"));
                        racine.removeContent(eve);
                        eve=evePrecedent;
                    }
                    else if(evePrecedent.getAttributeValue("idComp").equals(eve.getAttributeValue("idComp"))  && evePrecedent.getAttributeValue("propriete").equals("clic"))
                    {
                        racine.removeContent(evePrecedent);
                        eve.setAttribute("propriete", "valeur");                
                        eve.removeAttribute("type");
                    }
                    else
                    {
                        eve.setAttribute("propriete", "valeur");                
                        eve.removeAttribute("type");
                        i++;
                    }
                }
                else
                {
                    eve.setAttribute("propriete", "valeur");                
                    eve.removeAttribute("type");
                    i++;
                }                                
            } 
            else
            {
                racine.removeContent(eve);
            }
            
            evePrecedent=eve;
        }
        
        XMLFonctions.enregistre(Main.Cste.fichierEnregistrement);
    }
    
    private void inclureEnregistrement()
    {
        if(pasAPas)
            interpreterEnregistrement();
        
        XMLFonctions.OuvrirXML(Main.Cste.fichierEnregistrement);
        Element racine = XMLFonctions.racine;
        for(int i=0; i<racine.getChildren().size(); i++)
        {
            Element eve=(Element) racine.getChildren().get(i);
            sequence.addContent((Element) eve.clone());
            System.out.println(eve.getAttributeValue("type"));
        }
        
        if(pasAPas)
            Main.CreationRegles.ChargerListeActionPasaPas(ListeEvenements, sequence);
        else
            ChargerListeEvenements(listModel, ListeEvenements, sequence);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupOnOff = new javax.swing.ButtonGroup();
        LbId = new javax.swing.JLabel();
        BtEnregistrer = new javax.swing.JButton();
        ScrollListeEvenements = new javax.swing.JScrollPane();
        ListeEvenements = new javax.swing.JList();
        BtHaut = new javax.swing.JButton();
        BtBas = new javax.swing.JButton();
        BtSupprimer = new javax.swing.JButton();
        BtModifier = new javax.swing.JButton();
        BtAjouter = new javax.swing.JButton();
        PanelEvenement = new javax.swing.JPanel();
        LbEvenement = new javax.swing.JLabel();
        CbEvenement = new javax.swing.JComboBox();
        BtValiderEvenement = new javax.swing.JButton();
        ScrollArbre = new javax.swing.JScrollPane();
        Arbre = new javax.swing.JTree();
        LbComposant = new javax.swing.JLabel();
        TxtComposant = new javax.swing.JTextField();
        BtModifierDescriptionInterface = new javax.swing.JButton();
        BtAfficherDescriptionInterface = new javax.swing.JButton();
        PanelValeurActionInterface = new javax.swing.JPanel();
        TxtValeurActionInterface = new javax.swing.JTextField();
        LbValeurActionInterface = new javax.swing.JLabel();
        PanelEtatActionInterface = new javax.swing.JPanel();
        LbEtatActionInterface = new javax.swing.JLabel();
        RbOnActionInterface = new javax.swing.JRadioButton();
        RbOffActionInterface = new javax.swing.JRadioButton();
        PanelOptions = new javax.swing.JPanel();
        LbIgnorer = new javax.swing.JLabel();
        LbNbToleres = new javax.swing.JLabel();
        CheckDureeMaxTotale = new javax.swing.JCheckBox();
        CheckDureeMinTotale = new javax.swing.JCheckBox();
        CheckDureeMaxEntre = new javax.swing.JCheckBox();
        CheckDureeMinEntre = new javax.swing.JCheckBox();
        SpinDureeMaxTotale = new javax.swing.JSpinner();
        SpinDureeMinTotale = new javax.swing.JSpinner();
        SpinDureeMaxEntre = new javax.swing.JSpinner();
        SpinDureeMinEntre = new javax.swing.JSpinner();
        SpinNbToleres = new javax.swing.JSpinner();
        CbDureeMaxTotale = new javax.swing.JComboBox();
        CbDureeMinTotale = new javax.swing.JComboBox();
        CbDureeMaxEntre = new javax.swing.JComboBox();
        CbDureeMinEntre = new javax.swing.JComboBox();
        ScrollTypesIgnores = new javax.swing.JScrollPane();
        PanelTypesIgnores = new javax.swing.JPanel();
        BtRetour = new javax.swing.JButton();
        BtSuivant = new javax.swing.JButton();
        TxtId = new javax.swing.JTextField();
        LbNom = new javax.swing.JLabel();
        TxtNom = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(825, 750));

        LbId.setText("Identifiant de la séquence");

        BtEnregistrer.setText("Enregistrer");
        BtEnregistrer.setToolTipText("Enregistrer une nouvelle séquence d'événements");
        BtEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEnregistrerActionPerformed(evt);
            }
        });

        ListeEvenements.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "item1", "item2", "item3" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        ListeEvenements.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListeEvenements.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListeEvenementsValueChanged(evt);
            }
        });
        ScrollListeEvenements.setViewportView(ListeEvenements);

        BtHaut.setText("H");
        BtHaut.setToolTipText("Monter l'événement sélectionné");
        BtHaut.setEnabled(false);
        BtHaut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtHautActionPerformed(evt);
            }
        });

        BtBas.setText("B");
        BtBas.setToolTipText("Baisser l'événement sélectionné");
        BtBas.setEnabled(false);
        BtBas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBasActionPerformed(evt);
            }
        });

        BtSupprimer.setText("S");
        BtSupprimer.setToolTipText("Supprimer l'événement sélectionné");
        BtSupprimer.setEnabled(false);
        BtSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSupprimerActionPerformed(evt);
            }
        });

        BtModifier.setText("M");
        BtModifier.setToolTipText("Modifier l'événement sélectionné");
        BtModifier.setEnabled(false);
        BtModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierActionPerformed(evt);
            }
        });

        BtAjouter.setText("A");
        BtAjouter.setToolTipText("Monter un événement à la séquence");
        BtAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAjouterActionPerformed(evt);
            }
        });

        PanelEvenement.setEnabled(false);

        LbEvenement.setText("Evénement");

        CbEvenement.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbEvenement.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbEvenementItemStateChanged(evt);
            }
        });

        BtValiderEvenement.setText("V");
        BtValiderEvenement.setToolTipText("Valider l'événement");
        BtValiderEvenement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderEvenementActionPerformed(evt);
            }
        });

        Arbre.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                ArbreValueChanged(evt);
            }
        });
        ScrollArbre.setViewportView(Arbre);

        LbComposant.setText("sur le composant");

        TxtComposant.setText(" ");
        TxtComposant.setEnabled(false);

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

        LbValeurActionInterface.setText("Attribuer la valeur");

        javax.swing.GroupLayout PanelValeurActionInterfaceLayout = new javax.swing.GroupLayout(PanelValeurActionInterface);
        PanelValeurActionInterface.setLayout(PanelValeurActionInterfaceLayout);
        PanelValeurActionInterfaceLayout.setHorizontalGroup(
            PanelValeurActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelValeurActionInterfaceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbValeurActionInterface)
                .addGap(31, 31, 31)
                .addComponent(TxtValeurActionInterface, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
        );
        PanelValeurActionInterfaceLayout.setVerticalGroup(
            PanelValeurActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelValeurActionInterfaceLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(PanelValeurActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbValeurActionInterface)
                    .addComponent(TxtValeurActionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LbEtatActionInterface.setText("Passer à l'état");

        GroupOnOff.add(RbOnActionInterface);
        RbOnActionInterface.setSelected(true);
        RbOnActionInterface.setText("coché/on");
        RbOnActionInterface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbOnActionInterfaceActionPerformed(evt);
            }
        });

        GroupOnOff.add(RbOffActionInterface);
        RbOffActionInterface.setText("décoché/off");

        javax.swing.GroupLayout PanelEtatActionInterfaceLayout = new javax.swing.GroupLayout(PanelEtatActionInterface);
        PanelEtatActionInterface.setLayout(PanelEtatActionInterfaceLayout);
        PanelEtatActionInterfaceLayout.setHorizontalGroup(
            PanelEtatActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEtatActionInterfaceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbEtatActionInterface)
                .addGap(38, 38, 38)
                .addComponent(RbOnActionInterface)
                .addGap(18, 18, 18)
                .addComponent(RbOffActionInterface)
                .addContainerGap(186, Short.MAX_VALUE))
        );
        PanelEtatActionInterfaceLayout.setVerticalGroup(
            PanelEtatActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEtatActionInterfaceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEtatActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbEtatActionInterface)
                    .addComponent(RbOnActionInterface)
                    .addComponent(RbOffActionInterface))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelEvenementLayout = new javax.swing.GroupLayout(PanelEvenement);
        PanelEvenement.setLayout(PanelEvenementLayout);
        PanelEvenementLayout.setHorizontalGroup(
            PanelEvenementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEvenementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEvenementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollArbre)
                    .addGroup(PanelEvenementLayout.createSequentialGroup()
                        .addComponent(LbEvenement)
                        .addGap(42, 42, 42)
                        .addComponent(CbEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(LbComposant)
                        .addGap(18, 18, 18)
                        .addComponent(TxtComposant, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelEvenementLayout.createSequentialGroup()
                        .addComponent(PanelValeurActionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(PanelEtatActionInterface, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEvenementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtValiderEvenement)
                    .addGroup(PanelEvenementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BtAfficherDescriptionInterface, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtModifierDescriptionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelEvenementLayout.setVerticalGroup(
            PanelEvenementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEvenementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEvenementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbEvenement)
                    .addComponent(CbEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtValiderEvenement)
                    .addComponent(LbComposant)
                    .addComponent(TxtComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(PanelEvenementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEvenementLayout.createSequentialGroup()
                        .addComponent(BtModifierDescriptionInterface)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtAfficherDescriptionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelEvenementLayout.createSequentialGroup()
                        .addGroup(PanelEvenementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelValeurActionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelEtatActionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(ScrollArbre, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        PanelOptions.setBorder(javax.swing.BorderFactory.createTitledBorder("Options"));

        LbIgnorer.setText("Ignorer les événements intrus de types");

        LbNbToleres.setText("Nombre d'événements intrus tolorés entre deux événements de la séquence");

        CheckDureeMaxTotale.setText("Durée maximale de la séquence");
        CheckDureeMaxTotale.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckDureeMaxTotaleItemStateChanged(evt);
            }
        });

        CheckDureeMinTotale.setText("Durée minimale de la séquence");
        CheckDureeMinTotale.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckDureeMinTotaleItemStateChanged(evt);
            }
        });

        CheckDureeMaxEntre.setText("Durée maximale entre deux événements de la séquence");
        CheckDureeMaxEntre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckDureeMaxEntreItemStateChanged(evt);
            }
        });

        CheckDureeMinEntre.setText("Durée minimale entre deux événements de la séquence");
        CheckDureeMinEntre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckDureeMinEntreItemStateChanged(evt);
            }
        });

        SpinDureeMaxTotale.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(60), Integer.valueOf(0), null, Integer.valueOf(1)));

        SpinDureeMinTotale.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(10), Integer.valueOf(0), null, Integer.valueOf(1)));

        SpinDureeMaxEntre.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(10), Integer.valueOf(0), null, Integer.valueOf(1)));

        SpinDureeMinEntre.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(5), Integer.valueOf(0), null, Integer.valueOf(1)));

        SpinNbToleres.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        CbDureeMaxTotale.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CbDureeMinTotale.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CbDureeMaxEntre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CbDureeMinEntre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        PanelTypesIgnores.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelTypesIgnoresLayout = new javax.swing.GroupLayout(PanelTypesIgnores);
        PanelTypesIgnores.setLayout(PanelTypesIgnoresLayout);
        PanelTypesIgnoresLayout.setHorizontalGroup(
            PanelTypesIgnoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
        );
        PanelTypesIgnoresLayout.setVerticalGroup(
            PanelTypesIgnoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        ScrollTypesIgnores.setViewportView(PanelTypesIgnores);

        javax.swing.GroupLayout PanelOptionsLayout = new javax.swing.GroupLayout(PanelOptions);
        PanelOptions.setLayout(PanelOptionsLayout);
        PanelOptionsLayout.setHorizontalGroup(
            PanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelOptionsLayout.createSequentialGroup()
                        .addComponent(CheckDureeMinEntre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SpinDureeMinEntre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelOptionsLayout.createSequentialGroup()
                        .addComponent(CheckDureeMaxEntre)
                        .addGap(26, 26, 26)
                        .addComponent(SpinDureeMaxEntre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelOptionsLayout.createSequentialGroup()
                        .addGroup(PanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LbNbToleres)
                            .addGroup(PanelOptionsLayout.createSequentialGroup()
                                .addGroup(PanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CheckDureeMaxTotale)
                                    .addComponent(CheckDureeMinTotale))
                                .addGap(144, 144, 144)
                                .addGroup(PanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SpinDureeMinTotale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SpinDureeMaxTotale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SpinNbToleres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelOptionsLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(PanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CbDureeMinTotale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CbDureeMaxTotale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CbDureeMaxEntre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CbDureeMinEntre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(PanelOptionsLayout.createSequentialGroup()
                        .addComponent(LbIgnorer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ScrollTypesIgnores, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(256, Short.MAX_VALUE))
        );
        PanelOptionsLayout.setVerticalGroup(
            PanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOptionsLayout.createSequentialGroup()
                .addGroup(PanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelOptionsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LbIgnorer))
                    .addComponent(ScrollTypesIgnores, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(PanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbNbToleres)
                    .addComponent(SpinNbToleres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckDureeMaxTotale)
                    .addComponent(SpinDureeMaxTotale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbDureeMaxTotale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckDureeMinTotale)
                    .addComponent(SpinDureeMinTotale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbDureeMinTotale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckDureeMaxEntre)
                    .addComponent(SpinDureeMaxEntre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbDureeMaxEntre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(PanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckDureeMinEntre)
                    .addComponent(SpinDureeMinEntre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbDureeMinEntre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        BtRetour.setText("Annuler");
        BtRetour.setToolTipText("Annuler  et revenir à la définition de règles d'assistance");
        BtRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRetourActionPerformed(evt);
            }
        });

        BtSuivant.setText("Valider");
        BtSuivant.setToolTipText("Valider cette séquence d'événements");
        BtSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSuivantActionPerformed(evt);
            }
        });

        TxtId.setText("S3");
        TxtId.setEnabled(false);

        LbNom.setText("Nom de la séquence");

        TxtNom.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelEvenement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(BtRetour)
                        .addGap(18, 18, 18)
                        .addComponent(BtSuivant)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollListeEvenements)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LbId)
                                .addGap(27, 27, 27)
                                .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(LbNom)
                                .addGap(18, 18, 18)
                                .addComponent(TxtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtHaut, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtBas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtEnregistrer)
                                .addGap(13, 13, 13)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbId)
                    .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbNom)
                    .addComponent(TxtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ScrollListeEvenements, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtHaut)
                    .addComponent(BtBas)
                    .addComponent(BtSupprimer)
                    .addComponent(BtModifier)
                    .addComponent(BtAjouter)
                    .addComponent(BtEnregistrer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtRetour)
                    .addComponent(BtSuivant))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ArbreValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_ArbreValueChanged
       if (!Arbre.isSelectionEmpty()) {
            if (!Arbre.isRowSelected(0)) {
                String compo = Arbre.getSelectionPath().getLastPathComponent().toString();
                String id=Main.CreationRegles.noeudGetId(compo);
                TxtComposant.setText(id);
                Element comp= Main.CreationRegles.elementParId(Main.CreationRegles.lesComposants, id);
                if(pasAPas)
                {
                    if(comp.getAttribute("typeAjoute")!=null)
                        Main.CreationRegles.ChargerCbActionActionInterface(CbEvenement, comp.getAttributeValue("typeAjoute"));
                    else
                        Main.CreationRegles.ChargerCbActionActionInterface(CbEvenement, ""); 
                }
                else
                {
                    if(comp.getAttribute("typeAjoute")!=null)
                        Main.CreationRegles.chargerCbTypeEvenements(CbEvenement, comp.getAttributeValue("typeAjoute"));
                    else
                        Main.CreationRegles.chargerCbTypeEvenements(CbEvenement, "");
                }
            }
        }
    }//GEN-LAST:event_ArbreValueChanged

    private void BtRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRetourActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BtRetourActionPerformed

    private void BtSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSuivantActionPerformed
        if(TxtNom.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Vous devez donner un nom à cette séquence", "Information", JOptionPane.INFORMATION_MESSAGE);
            TxtNom.requestFocus();
        }
        else
        {
            sequence.setAttribute("nom", TxtNom.getText());
            if(!pasAPas)
            {
                sauverOptions();
            }
            if(creer)
            {
                Main.CreationRegles.lesSequences.add(sequence);
                Main.CreationRegles.idSequence++;
            }
            else
            {
                Main.CreationRegles.remplacerSequence(sequence);
            }

            if(pasAPas)
            {
                Main.CreationRegles.RechargerListeActionPasaPas(sequence);           
            }
            else
            {
                Main.CreationActions.RechargerCbSequenceEvenements(sequence);
            }
            this.setVisible(false);
        }
    }//GEN-LAST:event_BtSuivantActionPerformed

    private void ListeEvenementsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListeEvenementsValueChanged
        BtHaut.setEnabled(ListeEvenements.getSelectedIndex()>=1);
        BtBas.setEnabled(ListeEvenements.getSelectedIndex()>=0 && ListeEvenements.getSelectedIndex()<ListeEvenements.getModel().getSize()-1);
        BtModifier.setEnabled(ListeEvenements.getSelectedIndex()>=0);
        BtSupprimer.setEnabled(ListeEvenements.getSelectedIndex()>=0);
    }//GEN-LAST:event_ListeEvenementsValueChanged

    private void BtAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAjouterActionPerformed
        ListeEvenements.clearSelection();
        PanelEvenementSetEnabled(true);
        ListeEvenements.setEnabled(false);
        BtValiderEvenement.setMnemonic(0); //on indique qu'on créer un nouvel événement
    }//GEN-LAST:event_BtAjouterActionPerformed

    private void BtHautActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtHautActionPerformed
        int indice=ListeEvenements.getSelectedIndex();
        if(indice>0)
        {
            DefaultListModel model =new DefaultListModel();
            listModel=(DefaultListModel) ListeEvenements.getModel();
            
            Element eve=(Element)sequence.getChildren().get(indice);
            sequence.removeContent(eve);
            sequence.addContent(indice-1, eve);
            
            for(int i =0; i<indice-1; i++)
            {
                model.add(i, listModel.get(i));
            }

            model.add(indice-1, listModel.get(indice));
            model.add(indice, listModel.get(indice-1));

            for(int i = indice+1; i<listModel.getSize(); i++)
            {
                model.add(i, listModel.get(i));
            }
            listModel=model;
            ListeEvenements.setModel(listModel);
            ListeEvenements.setSelectedIndex(indice-1);
        }
    }//GEN-LAST:event_BtHautActionPerformed

    private void BtBasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBasActionPerformed
        int indice=ListeEvenements.getSelectedIndex();
        if(indice<listModel.getSize()-1)
        {
            DefaultListModel model =new DefaultListModel();
            listModel=(DefaultListModel) ListeEvenements.getModel();
            
            Element eve=(Element)sequence.getChildren().get(indice);
            sequence.removeContent(eve);
            sequence.addContent(indice, eve);
            
            for(int i =0; i<indice; i++)
            {
                model.add(i, listModel.get(i));
            }

            model.add(indice, listModel.get(indice + 1));
            model.add(indice + 1, listModel.get(indice));
        

            for(int i = indice+2; i<listModel.getSize(); i++)
            {
                model.add(i, listModel.get(i));
            }
            listModel=model;
            ListeEvenements.setModel(listModel);
            ListeEvenements.setSelectedIndex(indice+1);
        }
    }//GEN-LAST:event_BtBasActionPerformed

    private void BtModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierActionPerformed
        PanelEvenementSetEnabled(true);
        BtValiderEvenement.setMnemonic(1); //on indique qu'on modifie un événement de la séquence
        ListeEvenements.setEnabled(false);
        Element eve=(Element) sequence.getChildren().get(ListeEvenements.getSelectedIndex());
        TxtComposant.setText(eve.getAttributeValue("idComp"));
    }//GEN-LAST:event_BtModifierActionPerformed

    private void BtSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSupprimerActionPerformed
        DefaultListModel model =new DefaultListModel();
        listModel=(DefaultListModel) ListeEvenements.getModel();
        
        int indice=ListeEvenements.getSelectedIndex();
        
        Element eve=(Element)sequence.getChildren().get(indice);
        sequence.removeContent(eve);
               
        for (int i = 0; i < indice; i++) 
        {
            model.add(i, listModel.get(i));
        }

        for (int i = indice + 1; i < listModel.getSize(); i++) {
            model.add(i-1, listModel.get(i));
        }
        listModel = model;
        ListeEvenements.setModel(listModel);
    }//GEN-LAST:event_BtSupprimerActionPerformed

    private void BtModifierDescriptionInterfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierDescriptionInterfaceActionPerformed
        Main.ModificationInterface.chargerInterface();
        Main.ModificationInterface.setVisible(true);
    }//GEN-LAST:event_BtModifierDescriptionInterfaceActionPerformed

    private void BtAfficherDescriptionInterfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAfficherDescriptionInterfaceActionPerformed
        Main.CreationRegles.affichageDescription(BtAfficherDescriptionInterface, Arbre);
    }//GEN-LAST:event_BtAfficherDescriptionInterfaceActionPerformed

    private void BtValiderEvenementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderEvenementActionPerformed
        if(TxtComposant.getText().isEmpty())
        {
           JOptionPane.showMessageDialog(null,"Vous devez sélectionner un composant", "Information", JOptionPane.INFORMATION_MESSAGE); 
        }
        else if(CbEvenement.getSelectedIndex()<0)
        {
            JOptionPane.showMessageDialog(null,"Vous devez sélectionner un type d'événement", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            if(BtValiderEvenement.getMnemonic()==0) //si c'est un nouvel événement
            {
                Element evenement = new Element("evenement");
                evenement.setAttribute("idComp", TxtComposant.getText());
                if(pasAPas)
                {
                    if(CbEvenement.getSelectedItem().toString().equals(Main.CreationRegles.invoke) || CbEvenement.getSelectedItem().toString().equals(Main.CreationRegles.select))
                    {
                        evenement.setAttribute("propriete", "clic");
                    }
                    else if(CbEvenement.getSelectedItem().toString().equals(Main.CreationRegles.setFocus))
                    {
                        evenement.setAttribute("propriete", "focus");
                    }
                    else if(CbEvenement.getSelectedItem().toString().equals(Main.CreationRegles.setValue))
                    {
                        evenement.setAttribute("propriete", "valeur");
                        evenement.setAttribute("valeur", TxtValeurActionInterface.getText());
                    }
                    else if(CbEvenement.getSelectedItem().toString().equals(Main.CreationRegles.toggle))
                    {
                        evenement.setAttribute("propriete", "etat");
                        if(RbOnActionInterface.isSelected())
                            evenement.setAttribute("valeur", "On");
                        else
                            evenement.setAttribute("valeur", "Off");
                    }                    
                    listModel.addElement(Main.CreationRegles.ligneActionPasAPas(evenement));
                }
                else
                {
                    evenement.setAttribute("type", Main.CreationRegles.cleParValeur(Main.CreationRegles.listeTypesEvenements, CbEvenement.getSelectedItem().toString()));
                    listModel.addElement(ligneEvenement(evenement));
                }
                sequence.addContent(evenement);
                ListeEvenements.setModel(listModel);                
            }
            else //si c'est un événement qu'on modifie
            {
                Element evenement = (Element) sequence.getChildren().get(ListeEvenements.getSelectedIndex());
                evenement.setAttribute("idComp", TxtComposant.getText());
                if(pasAPas)
                {
                    evenement.setAttribute("propriete", CbEvenement.getSelectedItem().toString());
                    Main.CreationRegles.ChargerListeActionPasaPas(ListeEvenements, sequence);
                }
                else
                {
                    evenement.setAttribute("type", Main.CreationRegles.cleParValeur(Main.CreationRegles.listeTypesEvenements, CbEvenement.getSelectedItem().toString()));
                    ChargerListeEvenements(listModel, ListeEvenements, sequence);
                }
                
            }
            TxtComposant.setText("");
            Arbre.setSelectionRow(-1);
            ListeEvenements.setEnabled(true);
            PanelEvenementSetEnabled(false);
        }
    }//GEN-LAST:event_BtValiderEvenementActionPerformed

    private void RbOnActionInterfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbOnActionInterfaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbOnActionInterfaceActionPerformed

    private void CbEvenementItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbEvenementItemStateChanged
        if(CbEvenement.getSelectedIndex()>=0)
        {
            if(CbEvenement.getSelectedItem().equals(Main.CreationRegles.setValue))
            {
                PanelEtatActionInterface.setVisible(false);
                PanelValeurActionInterface.setVisible(true);
            }
            else if(CbEvenement.getSelectedItem().equals(Main.CreationRegles.toggle))
            {
                PanelEtatActionInterface.setVisible(true);
                PanelValeurActionInterface.setVisible(false);
            }
            else
            {
                PanelEtatActionInterface.setVisible(false);
                PanelValeurActionInterface.setVisible(false);
            }
        }
    }//GEN-LAST:event_CbEvenementItemStateChanged

    private void CheckDureeMaxTotaleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckDureeMaxTotaleItemStateChanged
        SpinDureeMaxTotale.setEnabled(CheckDureeMaxTotale.isSelected());
        CbDureeMaxTotale.setEnabled(CheckDureeMaxTotale.isSelected());
    }//GEN-LAST:event_CheckDureeMaxTotaleItemStateChanged

    private void CheckDureeMinTotaleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckDureeMinTotaleItemStateChanged
        SpinDureeMinTotale.setEnabled(CheckDureeMinTotale.isSelected());
        CbDureeMinTotale.setEnabled(CheckDureeMinTotale.isSelected());
    }//GEN-LAST:event_CheckDureeMinTotaleItemStateChanged

    private void CheckDureeMaxEntreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckDureeMaxEntreItemStateChanged
        SpinDureeMaxEntre.setEnabled(CheckDureeMaxEntre.isSelected());
        CbDureeMaxEntre.setEnabled(CheckDureeMaxEntre.isSelected());
    }//GEN-LAST:event_CheckDureeMaxEntreItemStateChanged

    private void CheckDureeMinEntreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckDureeMinEntreItemStateChanged
        SpinDureeMinEntre.setEnabled(CheckDureeMinEntre.isSelected());
        CbDureeMinEntre.setEnabled(CheckDureeMinEntre.isSelected());
    }//GEN-LAST:event_CheckDureeMinEntreItemStateChanged

    private void BtEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEnregistrerActionPerformed
        //On lance l'enregistreur adapté et on attend qu'il ait teminé
        String enregistreur="enregistreurWindows.exe";
        if(Main.SauveAssistance.type.equals(Main.EcranAccueil.appliJava))
            enregistreur="enregistreurJava.exe";
        else if(Main.SauveAssistance.type.equals(Main.EcranAccueil.appliWeb))
            enregistreur="enregistreurWeb.exe";
        Runtime runtime = Runtime.getRuntime();
        
        Process p;
        try 
        {
            p = runtime.exec(new String[] { Main.Cste.cheminEnregistreurs+enregistreur, Main.CreationRegles.cheminEtInterface, Main.Cste.fichierEnregistrement } );
            try 
            {            
                p.waitFor();
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(CreationSequence.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(CreationSequence.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        inclureEnregistrement();
    }//GEN-LAST:event_BtEnregistrerActionPerformed

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
            java.util.logging.Logger.getLogger(CreationSequence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreationSequence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreationSequence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreationSequence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CreationSequence().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree Arbre;
    private javax.swing.JButton BtAfficherDescriptionInterface;
    private javax.swing.JButton BtAjouter;
    private javax.swing.JButton BtBas;
    private javax.swing.JButton BtEnregistrer;
    private javax.swing.JButton BtHaut;
    private javax.swing.JButton BtModifier;
    private javax.swing.JButton BtModifierDescriptionInterface;
    private javax.swing.JButton BtRetour;
    private javax.swing.JButton BtSuivant;
    private javax.swing.JButton BtSupprimer;
    private javax.swing.JButton BtValiderEvenement;
    private javax.swing.JComboBox CbDureeMaxEntre;
    private javax.swing.JComboBox CbDureeMaxTotale;
    private javax.swing.JComboBox CbDureeMinEntre;
    private javax.swing.JComboBox CbDureeMinTotale;
    private javax.swing.JComboBox CbEvenement;
    private javax.swing.JCheckBox CheckDureeMaxEntre;
    private javax.swing.JCheckBox CheckDureeMaxTotale;
    private javax.swing.JCheckBox CheckDureeMinEntre;
    private javax.swing.JCheckBox CheckDureeMinTotale;
    private javax.swing.ButtonGroup GroupOnOff;
    private javax.swing.JLabel LbComposant;
    private javax.swing.JLabel LbEtatActionInterface;
    private javax.swing.JLabel LbEvenement;
    private javax.swing.JLabel LbId;
    private javax.swing.JLabel LbIgnorer;
    private javax.swing.JLabel LbNbToleres;
    private javax.swing.JLabel LbNom;
    private javax.swing.JLabel LbValeurActionInterface;
    private javax.swing.JList ListeEvenements;
    private javax.swing.JPanel PanelEtatActionInterface;
    private javax.swing.JPanel PanelEvenement;
    private javax.swing.JPanel PanelOptions;
    private javax.swing.JPanel PanelTypesIgnores;
    private javax.swing.JPanel PanelValeurActionInterface;
    private javax.swing.JRadioButton RbOffActionInterface;
    private javax.swing.JRadioButton RbOnActionInterface;
    private javax.swing.JScrollPane ScrollArbre;
    private javax.swing.JScrollPane ScrollListeEvenements;
    private javax.swing.JScrollPane ScrollTypesIgnores;
    private javax.swing.JSpinner SpinDureeMaxEntre;
    private javax.swing.JSpinner SpinDureeMaxTotale;
    private javax.swing.JSpinner SpinDureeMinEntre;
    private javax.swing.JSpinner SpinDureeMinTotale;
    private javax.swing.JSpinner SpinNbToleres;
    private javax.swing.JTextField TxtComposant;
    private javax.swing.JTextField TxtId;
    private javax.swing.JTextField TxtNom;
    private javax.swing.JTextField TxtValeurActionInterface;
    // End of variables declaration//GEN-END:variables
}
