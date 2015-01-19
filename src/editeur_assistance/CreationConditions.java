/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jdom.Element;

/**
 *
 * @author Blandine
 */
public class CreationConditions extends javax.swing.JFrame {

    public JComboBox CB=null;
    public boolean profilNonDispo=true;
    /**
     * Creates new form CreationCondition
     */
    public CreationConditions() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(200, 100, 690, 655);
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/icone_editeur.png"));
        this.setIconImage(icon);
        this.setTitle("Editeur d'assistance - définition d'une condition sur le déclenchement");
        ToolTipManager.sharedInstance().registerComponent(ArbreContrainteContexte);
        
        //___________________________________________________création d'une condition__________________________________________________________________        
        PanelCreationCondition.setBounds(0, 0, 675, 610);
        PanelCreationCondition.setLayout(null);
        
        LbNomCondition.setBounds(15, 5, 150, 24);
        TxtNomCondition.setBounds(155, 5, 60, 24);       
        LbChoixTypeCondition.setBounds(315, 5, 100, 24);
        CbChoixTypeCondition.setBounds(425, 5, 230, 24);
        
        //___________________________________________________condition sur les traces de l'utilisateur_________________________________
        PanelCreationConditionTraces.setBounds(5, 30, 660, 568); 
        PanelCreationConditionTraces.setLayout(null);
        PanelCreationConditionTraces.setVisible(false);
        
        LbObjetContrainteTraces.setBounds(10, 5, 220, 24);
        CbObjetContrainteTraces.setBounds(230, 5, 150, 24);
        CbQuandContrainteTraces.setBounds(230, 35, 300, 24);
        RbSeanceContrainteTraces.setBounds(10, 65, 140, 24);
        RbGlobalementContrainteTraces.setBounds(150, 65, 140, 24);
        
        PanelDernierContrainteTraces.setBounds(10, 95, 600, 50);
        PanelDernierContrainteTraces.setLayout(null);
        LbDepuisContrainteTraces.setBounds(10, 0, 120, 24);
        CbDepuisContrainteTraces.setBounds(160, 0, 180, 24);
        
        BtValiderConditionTraces.setBounds(PanelCreationConditionTraces.getWidth()/2-130, PanelCreationConditionTraces.getHeight()-35, 120, 30);
        BtAnnulerConditionTraces.setBounds(PanelCreationConditionTraces.getWidth()/2+10, PanelCreationConditionTraces.getHeight()-35, 120, 30);
        
        //___________________________________________________condition sur le profil _________________________________
        PanelCreationConditionProfil.setBounds(5, 30, 660, 568); 
        PanelCreationConditionProfil.setLayout(null);
        LbElementConditionProfil.setBounds(10, 5, 145, 24);
        TxtElementConditionProfil.setBounds(150, 5, 500, 24);
        ScrollArbreProfil.setBounds(10, 35, 640, 320); 
        ArbreProfil.setBounds(0, 0, ScrollArbreProfil.getWidth(), ScrollArbreProfil.getHeight());
        PanelDefContrainteProfil.setBounds(10, 380, PanelCreationConditionProfil.getWidth()-15, 170);
        PanelDefContrainteProfil.setLayout(null);
         
        BtValiderConditionProfil.setBounds(PanelCreationConditionProfil.getWidth()/2-130, PanelCreationConditionProfil.getHeight()-35, 120, 30);
        BtAnnulerConditionProfil.setBounds(PanelCreationConditionProfil.getWidth()/2+10, PanelCreationConditionProfil.getHeight()-35, 120, 30);
        
        //___________________________________________________condition sur l'historique _________________________________
        PanelCreationConditionHistorique.setBounds(5, 30, 660, 568);
        PanelCreationConditionHistorique.setLayout(null);
        LbObjetContrainteHistorique.setBounds(10, 5, 180, 24);
        CbObjetContrainteHistorique.setBounds(180, 5, 80, 24);
        
        PanelHistoriqueTemps.setBounds(0, 35, 500, 150);
        PanelHistoriqueTemps.setVisible(false);
        PanelHistoriqueTemps.setLayout(null);
        
        CbQuandContrainteHistorique.setBounds(180, 5, 200, 24);
        RbSeanceContrainteHistorique.setBounds(10, 35, 140, 24);
        RbGlobalementContrainteHistorique.setBounds(150, 35, 140, 24);
        
        PanelDernierContrainteHistorique.setBounds(10, 65, 600, 50);
        PanelDernierContrainteHistorique.setLayout(null);
        LbDepuisContrainteHistorique.setBounds(10, 0, 120, 24);
        CbDepuisContrainteHistorique.setBounds(160, 0, 180, 24);
                
        BtValiderContrainteHistorique.setBounds(PanelCreationConditionHistorique.getWidth()/2-130, PanelCreationConditionHistorique.getHeight()-35, 120, 30);
        BtAnnulerContrainteHistorique.setBounds(PanelCreationConditionHistorique.getWidth()/2+10, PanelCreationConditionHistorique.getHeight()-35, 120, 30); 
        
        //___________________________________________________condition sur le contexte _________________________________
        
        PanelCreationConditionContexte.setBounds(5, 30, 660, 568);
        PanelCreationConditionContexte.setLayout(null);
        LbElementContrainteContexte.setBounds(10, 5, 140, 24);
        TxtElementContrainteContexte.setBounds(150, 5, 500, 24);

        ScrollArbreContrainteContexte.setBounds(5, 35, 620, 320); 
        ArbreContrainteContexte.setBounds(0, 0, ScrollArbreContrainteContexte.getWidth(), ScrollArbreContrainteContexte.getHeight());
        BtModifierDescriptionInterfaceContrainteContexte.setBounds(630, 170, 30, 24);
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/modifierPetite.png"));
        BtModifierDescriptionInterfaceContrainteContexte.setIcon(new ImageIcon(icon));
        BtModifierDescriptionInterfaceContrainteContexte.setText("");
        BtAfficherDescriptionInterfaceContrainteContexte.setBounds(630, 200, 30, 24);
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
        BtAfficherDescriptionInterfaceContrainteContexte.setIcon(new ImageIcon(icon));
        BtAfficherDescriptionInterfaceContrainteContexte.setText("");
        
        
        LbProprieteContrainteContexte.setBounds(10, 360, 90, 24);
        CbProprieteContrainteContexte.setBounds(110, 360, 150, 24);
        LbTypeContrainteContexte.setBounds(380, 360, 60, 24);
        TxtTypeContrainteContexte.setBounds(450, 360, 150, 24);
        
        BtValiderContrainteContexte.setBounds(PanelCreationConditionContexte.getWidth()/2-130, PanelCreationConditionContexte.getHeight()-35, 120, 30);
        BtAnnulerContrainteContexte.setBounds(PanelCreationConditionContexte.getWidth()/2+10, PanelCreationConditionContexte.getHeight()-35, 120, 30);
           
        //___________________________________________________condition de consultation de l'utilisateur _________________________________
        PanelCreationConditionConsultation.setBounds(5, 30, 660, 568);
        PanelCreationConditionConsultation.setLayout(null); 
        LbMessageActionInteractive.setBounds(10, 5, 180, 24);
        ScrollMessageActionInteractive.setBounds(10, 35, 640, 100);
        LbAjoutActionInteractive.setBounds(240, 140, 120, 24);
        CbPersoConditionConsultation.setBounds(360, 140, 200, 24);
        BtInclureConditionConsultation.setBounds(570, 140, 75, 24);

        LbModeActionInteractive.setBounds(10, 170, 150, 24);
        CbModeActionInteractive.setBounds(160, 170, 150, 24);
        BtAfficherDetailsActionInteractive.setBounds(320, 170, 50, 24);
        
        LbBoutonActionInteractive.setBounds(10, 200, 150, 24);
        BtAjoutBoutonActionInteractive.setBounds(130, 200, 60, 24);
        BtSupprimerBoutonConditionConsultation.setBounds(200, 200, 60, 24);
        ScrollBoutonsActionInteractive.setBounds(10, 230, 380, 220);
        PanelBoutonsActionInteractive.setBounds(0, 0, ScrollBoutonsActionInteractive.getWidth(), ScrollBoutonsActionInteractive.getHeight());
        
        PanelDetailsConsultation.setBounds(10, 380, 650, 140);
        PanelDetailsConsultation.setLayout(null);
        
        LbTitreActionInteractive.setBounds(10, 15, 120, 24);
        TxtTitreActionInteractive.setBounds(130, 15, 180, 24);
        LbCouleurActionInteractive.setBounds(10, 45, 150, 24);
        BtCouleurActionInteractive.setBounds(130, 45, 60, 24);
        LbPoliceMessageActionInteractive.setBounds(10, 75, 150, 24);
        BtPoliceMessageActionInteractive.setBounds(130, 75, 60, 24);
        LbPoliceBoutonActionInteractive.setBounds(10, 105, 150, 24);
        BtPoliceBoutonActionInteractive.setBounds(130, 105, 60, 24);
                
        BtValiderActionInteractive.setBounds(120, PanelCreationConditionConsultation.getHeight()-35, 120, 30);
        BtApercuActionInteractive.setBounds(250, PanelCreationConditionConsultation.getHeight()-35, 120, 30);
        BtAnnulerActionInteractive.setBounds(380, PanelCreationConditionConsultation.getHeight()-35, 120, 30);
               
        //___________________________________________________combinaison de condition _________________________________       
        PanelCreationConditionCombinaison.setBounds(5, 30, 660, 568); 
        PanelCreationConditionCombinaison.setLayout(null);
        LbFormuleConditionCombinaison.setBounds(10, 10, 80, 24);
        TxtFormuleConditionCombinaison.setBounds(90, 10, 520, 24);
        
        LbOperateursConditionCombinaison.setBounds(10, 40, 180, 24);
        BtEtConditionCombinaison.setBounds(10, 70, 60, 24);
        BtOuConditionCombinaison.setBounds(80, 70, 60, 24);
        BtOuvreConditionCombinaison.setBounds(150, 70, 60, 24);
        BtFermeConditionCombinaison.setBounds(220, 70, 60, 24);
        BtNonConditionCombinaison.setBounds(290, 70, 60, 24);
        
        LbConditionsConditionCombinaison1.setBounds(10, 100, 240, 24);
        ScrollBoutonsConditionCombinaison.setBounds(10, 130, 640, 400);
        PanelBoutonsConditionCombinaison.setBounds(0, 0, 640, 430);
        PanelBoutonsConditionCombinaison.setLayout(null);
        
        BtValiderConditionCombinaison.setBounds(PanelCreationConditionCombinaison.getWidth()/2-130, PanelCreationConditionCombinaison.getHeight()-35, 120, 30);
        BtAnnulerConditionCombinaison.setBounds(PanelCreationConditionCombinaison.getWidth()/2+10, PanelCreationConditionCombinaison.getHeight()-35, 120, 30);
    }
    
    public void chargerInterface()
    {
        chargerLangue();
        
        //___________________________________________________création d'une condition__________________________________________________________________                
        CbChoixTypeCondition.removeAllItems();
        CbChoixTypeCondition.addItem("");
        CbChoixTypeCondition.addItem(Main.CreationRegles.itemConditionConsultation);
        if(!Main.Cste.structureProfils.isEmpty())
            CbChoixTypeCondition.addItem(Main.CreationRegles.itemConditionProfil);
        CbChoixTypeCondition.addItem(Main.CreationRegles.itemConditionHistorique);
        //CbChoixTypeCondition.addItem(Main.CreationRegles.itemConditionTraces);
        CbChoixTypeCondition.addItem(Main.CreationRegles.itemConditionContexte);
        
        CbChoixTypeCondition.addItem(Main.CreationRegles.itemConditionCombinaison);       
        
        //___________________________________________________condition sur les traces de l'utilisateur_________________________________
        Main.CreationRegles.chargerCbSequence(CbObjetContrainteTraces, Main.CreationRegles.attributEvenements);       
        CbQuandContrainteTraces.removeAllItems();

        CbQuandContrainteTraces.addItem(Main.CreationRegles.presenceConditionTraces);
        CbQuandContrainteTraces.addItem(Main.CreationRegles.dureeTotaleConditionTraces);
        CbQuandContrainteTraces.addItem(Main.CreationRegles.dureeDepuisConditionTraces);
        CbQuandContrainteTraces.addItem(Main.CreationRegles.nbOccurrencesConditionTraces);
        CbQuandContrainteTraces.addItem(Main.CreationRegles.nbEvenementsDepuisConditionTraces);
             
        RbSeanceContrainteTraces.setSelected(true);       
        Main.CreationRegles.chargerCbUniteTemps(CbDepuisContrainteTraces);
        
        //___________________________________________________condition sur le profil _________________________________       
        PanelCreationConditionProfil.setVisible(false); 
        if(!Main.Cste.structureProfils.isEmpty())
            Main.CreationRegles.construireMur(ArbreProfil);
             
        //___________________________________________________condition sur l'historique _________________________________
        
        PanelCreationConditionHistorique.setVisible(false);        
        Main.CreationRegles.chargerCbActionsEtReglesEtConsultations(CbObjetContrainteHistorique);
        
        CbQuandContrainteHistorique.removeAllItems();
        CbQuandContrainteHistorique.addItem(Main.CreationRegles.dernierDeclenchement);
        CbQuandContrainteHistorique.addItem(Main.CreationRegles.nombreDeclenchement);        
        
        RbSeanceContrainteHistorique.setSelected(true); 
        Main.CreationRegles.chargerCbUniteTemps(CbDepuisContrainteHistorique);

        //___________________________________________________condition sur le contexte _________________________________
        
        PanelCreationConditionContexte.setVisible(false);
               
        Main.CreationRegles.chargerArbreComposants(ArbreContrainteContexte, Main.CreationRegles.afficherDescriptionComplete);
        Main.CreationRegles.etendreArbre(ArbreContrainteContexte);
        ArbreContrainteContexte.setCellRenderer(new ArbreInfoBulles());
        
        ChargerCbProprieteContrainteContexte("");
        TxtElementContrainteContexte.setText("");
        
        //___________________________________________________condition de consultation de l'utilisateur _________________________________
        PanelCreationConditionConsultation.setVisible(false);         
        resetConditionConsultation();

        //___________________________________________________combinaison de condition _________________________________
        PanelCreationConditionCombinaison.setVisible(false);
        resetConditionCombinaison();
        
        TxtNomCondition.setText("C" + Main.CreationRegles.idCondition);
    }
    
    private void chargerLangue()
    {
        //___________________________________________________la création de conditions______________________________________________________
        XMLFonctions.OuvrirXML(Main.Cste.fichierInterfaceEditeur);
        Element courant=(Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbNomCondition").getChild(Main.Cste.langue);
        LbNomCondition.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbChoixTypeCondition").getChild(Main.Cste.langue);
        LbChoixTypeCondition.setText(courant.getText());
        
        //_____________________________________conditions sur le profil de l'utilisateur__________________________________
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnulerConditionProfil.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtValider").getChild(Main.Cste.langue);
        BtValiderConditionProfil.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbElementConditionProfil").getChild(Main.Cste.langue);
        LbElementConditionProfil.setText(courant.getText());
        
        //_____________________________________conditions sur l'historique__________________________________
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnulerContrainteHistorique.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtValider").getChild(Main.Cste.langue);
        BtValiderContrainteHistorique.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbObjetContrainteHistorique").getChild(Main.Cste.langue);
        LbObjetContrainteHistorique.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("RbSeanceContrainteHistorique").getChild(Main.Cste.langue);
        RbSeanceContrainteHistorique.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("RbGlobalementContrainteHistorique").getChild(Main.Cste.langue);
        RbGlobalementContrainteHistorique.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbDepuisContrainteHistorique").getChild(Main.Cste.langue);
        LbDepuisContrainteHistorique.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbDepuisContrainteHistorique").getChild(Main.Cste.langue);
        LbDepuisContrainteHistorique.setText(courant.getText());

        //_____________________________________conditions sur les traces__________________________________
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnulerConditionTraces.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtValider").getChild(Main.Cste.langue);
        BtValiderConditionTraces.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbDepuisContrainteHistorique").getChild(Main.Cste.langue);
        LbDepuisContrainteTraces.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("RbSeanceContrainteHistorique").getChild(Main.Cste.langue);
        RbSeanceContrainteTraces.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("RbGlobalementContrainteHistorique").getChild(Main.Cste.langue);
        RbGlobalementContrainteTraces.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbObjetContrainteTraces").getChild(Main.Cste.langue);
        LbObjetContrainteTraces.setText(courant.getText());
        
        //_____________________________________conditions sur l'état de l'application__________________________________
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnulerContrainteContexte.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtValider").getChild(Main.Cste.langue);
        BtValiderContrainteContexte.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbElementConditionProfil").getChild(Main.Cste.langue);
        LbElementContrainteContexte.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbProprieteContrainteContexte").getChild(Main.Cste.langue);
        LbProprieteContrainteContexte.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbTypeContrainteContexte").getChild(Main.Cste.langue);
        LbTypeContrainteContexte.setText(courant.getText());
        BtAfficherDescriptionInterfaceContrainteContexte.setToolTipText(Main.CreationRegles.toolTip1BtAfficherDescription);
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("tootltipBtModifierDescriptionInterface").getChild(Main.Cste.langue);
        BtModifierDescriptionInterfaceContrainteContexte.setToolTipText(courant.getText());
        
        //_____________________________________conditions de consultation de l'utilisateur__________________________________
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnulerActionInteractive.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtValider").getChild(Main.Cste.langue);
        BtValiderActionInteractive.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtApercu").getChild(Main.Cste.langue);
        BtApercuActionInteractive.setText(courant.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbMessageActionInteractive").getChild(Main.Cste.langue);
        LbMessageActionInteractive.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbAjoutActionInteractive").getChild(Main.Cste.langue);
        LbAjoutActionInteractive.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbTitreActionInteractive").getChild(Main.Cste.langue);
        LbTitreActionInteractive.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbCouleurActionInteractive").getChild(Main.Cste.langue);
        LbCouleurActionInteractive.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbPoliceMessageActionInteractive").getChild(Main.Cste.langue);
        LbPoliceMessageActionInteractive.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbPoliceBoutonActionInteractive").getChild(Main.Cste.langue);
        LbPoliceBoutonActionInteractive.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbBoutonActionInteractive").getChild(Main.Cste.langue);
        LbBoutonActionInteractive.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtInclureConditionConsultation").getChild(Main.Cste.langue);
        BtInclureConditionConsultation.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAjoutBoutonActionInteractive").getChild(Main.Cste.langue);
        BtInclureConditionConsultation.setToolTipText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtSupprimerBoutonConditionConsultation").getChild(Main.Cste.langue);
        BtSupprimerBoutonConditionConsultation.setToolTipText(courant.getText());
                
        //_____________________________________combinaisons de conditions__________________________________
              
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnulerConditionCombinaison.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtValider").getChild(Main.Cste.langue);
        BtValiderConditionCombinaison.setText(courant.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbFormuleConditionCombinaison").getChild(Main.Cste.langue);
        LbFormuleConditionCombinaison.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbOperateursConditionCombinaison").getChild(Main.Cste.langue);
        LbOperateursConditionCombinaison.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtEtConditionCombinaison").getChild(Main.Cste.langue);
        BtEtConditionCombinaison.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtOuConditionCombinaison").getChild(Main.Cste.langue);
        BtOuConditionCombinaison.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtNonConditionCombinaison").getChild(Main.Cste.langue);
        BtNonConditionCombinaison.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbConditionsConditionCombinaison1").getChild(Main.Cste.langue);
        LbConditionsConditionCombinaison1.setText(courant.getText());
    }
    
    private void clicBoutonConditionCombinaison(JButton bt)
    {
        Element cond=Main.CreationRegles.conditionParId(bt.getText());
        
        if(cond.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.conditionProfil))
        {
            Element noeud = (Element) cond.getChildren().get(0);
            if(noeud.getName().equals(Main.CreationRegles.attributTextuelle))
            {
                cliquerChoixValeurConditionTextuelle(bt);
            }
            else
            {
                cliquerChoixValeurConditionNumerique(bt);               
            }
        }
        else if(cond.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.conditionContexte))
        {
            if(cond.getAttributeValue(Main.CreationRegles.attributSousType).equals("nombre"))
            {
                cliquerChoixValeurConditionNumerique(bt);
            }
            else if(cond.getAttributeValue(Main.CreationRegles.attributSousType).equals("booléen"))
            {
                cliquerChoixValeurConditionTextuelle(bt);
            }
            else if(cond.getAttributeValue(Main.CreationRegles.attributSousType).equals(Main.CreationRegles.attributTexte))
            {
                cliquerChoixValeurConditionTexteLibre(bt);
            }
        }
        else if(cond.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.conditionHistorique))
        {
            if(cond.getAttributeValue(Main.CreationRegles.attributSousType).equals(Main.CreationRegles.dernierDeclenchement))
            {
                cliquerChoixValeurConditionDuree(bt);
            }
            else
            {
                cliquerChoixValeurConditionNumerique(bt);
            }
        }        
        else if(cond.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.conditionConsultation))
        {
            cliquerChoixValeurConditionTextuelle(bt);
        }
        else if(cond.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.conditionTraces))
        {

        }
        else if(cond.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.conditionCombinaison))
        {
            cliquerChoixValeurConditionTextuelle(bt);
        }
        
        //on ne peut plus utiliser les autres bouton sasn passer par un opérateur logique
        setEnableBoutonConditionCombinaison(false);
        BtEtConditionCombinaison.setEnabled(true);
        BtOuConditionCombinaison.setEnabled(true);                
    }
    
    private void setEnableBoutonConditionCombinaison(boolean b)
    {
        for (int i =0; i< PanelBoutonsConditionCombinaison.getComponentCount(); i++)
        {
            Panel p = (Panel) PanelBoutonsConditionCombinaison.getComponent(i);
            JButton bt = (JButton) p.getComponent(0);
            bt.setEnabled(b);
        }
    }
    
    private void chargerConditionCombinaison()
    {
        for(int i=0; i< Main.CreationRegles.lesConditions.size(); i++)
        {
            Element cond = Main.CreationRegles.lesConditions.get(i);
            Panel p = new Panel();
            p.setBounds(0, i*30, PanelBoutonsConditionCombinaison.getWidth(), 30);
            p.setLayout(null);
            JButton bt = new JButton(cond.getAttributeValue(Main.CreationRegles.attributId));
            bt.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                { clicBoutonConditionCombinaison((JButton) e.getSource());}
            });
            bt.setBounds(10, 0, 50, 25);
            p.add(bt);
            Panel pp =new Panel();
            pp.setBounds(80, 0, PanelBoutonsConditionCombinaison.getWidth()-80, 30);
            creerPanelCondition(pp, cond);
            p.add(pp);
            PanelBoutonsConditionCombinaison.add(p);
        }
    }
    
    private void afficherChoixValeurConditionNumerique(Panel p, int min, int max)
    {
        SpinnerModel model = new SpinnerNumberModel(min, min, max, 1);
        SpinnerModel model2 = new SpinnerNumberModel(max, min, max, 1);

        JLabel lb = new JLabel(Main.CreationRegles.valeurCompriseEntre);
        lb.setBounds(0, 0, 140, 24);
        p.add(lb);

        JSpinner spin = new JSpinner(model);
        spin.addChangeListener(new ChangeListener()
            {
                public void stateChanged(ChangeEvent e) 
                { modificationInf((JSpinner) e.getSource());}
            });
        spin.setBounds(140, 0, 60, 24);
        p.add(spin);

        JLabel lb2 = new JLabel(Main.CreationRegles.stringEt);
        lb2.setBounds(220, 0, 25, 24);
        p.add(lb2);

        JSpinner spin2 = new JSpinner(model2);
        spin2.addChangeListener(new ChangeListener()
            {
                public void stateChanged(ChangeEvent e) 
                { modificationSup((JSpinner) e.getSource());}
            });
        spin2.setBounds(260, 0, 60, 24);
        p.add(spin2);
    }
    
    private void modificationInf(JSpinner jinf)
    {
        Panel p= (Panel) jinf.getParent();
        JSpinner jsup = (JSpinner) p.getComponent(3);
        if(Integer.parseInt(jsup.getValue().toString())< Integer.parseInt(jinf.getValue().toString()))
        {
            jsup.setValue(jinf.getValue());
        }
    }
    
    private void modificationSup(JSpinner jsup)
    {
        Panel p= (Panel) jsup.getParent();
        JSpinner jinf = (JSpinner) p.getComponent(1);
        if(Integer.parseInt(jinf.getValue().toString())> Integer.parseInt(jsup.getValue().toString()))
        {
            jinf.setValue(jsup.getValue());
        }
    }
    
    private void cliquerChoixValeurConditionNumerique(JButton bt)
    {
        String min, max;
        Panel pp = (Panel) bt.getParent();
        Panel p = (Panel) pp.getComponent(1);
        
        JSpinner jinf, jsup;
        
        jinf = (JSpinner) p.getComponent(1);
        jsup = (JSpinner) p.getComponent(3);
        
        min=jinf.getValue().toString();
        max=jsup.getValue().toString();
        
        TxtFormuleConditionCombinaison.setText(TxtFormuleConditionCombinaison.getText()+bt.getText()+"("+min+"..."+max+")");
    }
    
    private void cliquerChoixValeurConditionTextuelle(JButton bt)
    {
        Panel pp = (Panel) bt.getParent();
        Panel p = (Panel) pp.getComponent(1);

        JComboBox cb = (JComboBox) p.getComponent(1);
        cb.setBounds(100, 0, 160, 24);
        
        TxtFormuleConditionCombinaison.setText(TxtFormuleConditionCombinaison.getText()+bt.getText()+"("+cb.getSelectedItem().toString()+")");
    }
    
    private void cliquerChoixValeurConditionTexteLibre(JButton bt)
    {
        Panel pp = (Panel) bt.getParent();
        Panel p = (Panel) pp.getComponent(1);
        
        JComboBox cb = (JComboBox) p.getComponent(1);
        JTextField txt = (JTextField) p.getComponent(2);
        
        TxtFormuleConditionCombinaison.setText(TxtFormuleConditionCombinaison.getText()+bt.getText()+"(" + cb.getSelectedItem().toString()+"\""+ txt.getText() +"\""+")");
    }
    
    private void cliquerChoixValeurConditionDuree(JButton bt)
    {
        Panel pp = (Panel) bt.getParent();
        Panel p = (Panel) pp.getComponent(1);
        JComboBox cb = (JComboBox) p.getComponent(1);
        JSpinner spin = (JSpinner) p.getComponent(2);
        String symb;
        if(cb.getSelectedItem().equals("supérieure à"))
            symb=">";
        else
            symb="<";
        
        TxtFormuleConditionCombinaison.setText(TxtFormuleConditionCombinaison.getText()+bt.getText()+"("+symb+spin.getValue().toString()+")");
    }
    
    private void afficherChoixValeurConditionTextuelle(Panel p, String[] tab, String label)
    {
        JLabel lb = new JLabel(label);
        lb.setBounds(0, 0, 100, 24);
        p.add(lb);

        JComboBox cb = new JComboBox();
        cb.setBounds(100, 0, 160, 24);
        for(int i=0; i<tab.length; i++)
        {
            cb.addItem(tab[i]);
        }
        p.add(cb);
    }
    
    private void afficherChoixValeurConditionTexteLibre(Panel p)
    {
        JLabel lb = new JLabel(Main.CreationRegles.stringValeur);
        lb.setBounds(0, 0, 50, 24);
        p.add(lb);

        JComboBox cb = new JComboBox();
        cb.setBounds(50, 0, 130, 24);
        cb.addItem(Main.CreationRegles.egaleA);
        cb.addItem(Main.CreationRegles.contenant);
        cb.addItem(Main.CreationRegles.commencantPar);
        cb.addItem(Main.CreationRegles.terminantPar);
        p.add(cb);
        
        JTextField txt = new JTextField();
        txt.setBounds(190, 0, 360, 24);
        p.add(txt);
    }
    
    private void afficherChoixValeurConditionDuree(Panel p, String unite)
    {
        JLabel lb = new JLabel(Main.CreationRegles.duree);
        lb.setBounds(0, 0, 50, 24);
        p.add(lb);

        JComboBox cb = new JComboBox();
        cb.setBounds(50, 0, 130, 24);
        cb.addItem(Main.CreationRegles.superieureA);
        cb.addItem(Main.CreationRegles.inferieureA);
        p.add(cb);
        
        SpinnerModel model = new SpinnerNumberModel(1, 0, 200, 1);
        JSpinner spin = new JSpinner(model);
        spin.setBounds(190, 0, 60, 24);
        p.add(spin);
        
        JLabel txt = new JLabel(Main.CreationRegles.en+unite);
        txt.setBounds(260, 0, 160, 24);
        p.add(txt);
    }
    
    private void creerPanelCondition(Panel p, Element cond)
    {
        p.setLayout(null);
        if(cond.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.conditionProfil))
        {
            Element noeud = (Element) cond.getChildren().get(0);
            if(noeud.getName().equals(Main.CreationRegles.attributTextuelle))
            {
                String[] tab= new String[noeud.getChildren().size()];
                for(int i=0; i<noeud.getChildren().size(); i++)
                {
                    Element val = (Element) noeud.getChildren().get(i);
                    tab[i]= val.getText();
                }
                afficherChoixValeurConditionTextuelle(p, tab, Main.CreationRegles.siValeurEgaleA);
            }
            else
            {
                int min = Integer.parseInt(noeud.getAttributeValue(Main.CreationRegles.attributBorne_inf));
                int max = Integer.parseInt(noeud.getAttributeValue(Main.CreationRegles.attributBorne_sup));
                afficherChoixValeurConditionNumerique(p, min, max);               
            }
        }
        else if(cond.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.conditionContexte))
        {
            if(cond.getAttributeValue(Main.CreationRegles.attributSousType).equals("nombre"))
            {
                afficherChoixValeurConditionNumerique(p, 0, 1000);
            }
            else if(cond.getAttributeValue(Main.CreationRegles.attributSousType).equals("booléen"))
            {
                String[] tab= new String[2];
                tab[0]=Main.CreationRegles.stringVrai;
                tab[1]=Main.CreationRegles.stringFaux;
                afficherChoixValeurConditionTextuelle(p, tab, Main.CreationRegles.siValeurEgaleA);
            }
            else if(cond.getAttributeValue(Main.CreationRegles.attributSousType).equals(Main.CreationRegles.attributTexte))
            {
                afficherChoixValeurConditionTexteLibre(p);
            }
        }
        else if(cond.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.conditionHistorique))
        {
            if(cond.getAttributeValue(Main.CreationRegles.attributSousType).equals(Main.CreationRegles.dernierDeclenchement))
            {
                afficherChoixValeurConditionDuree(p, cond.getAttributeValue(Main.CreationRegles.attributUnite));
            }
            else
            {
                afficherChoixValeurConditionNumerique(p, 0, 15);
            }
        }        
        else if(cond.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.conditionConsultation))
        {
            Element noeud = (Element) cond.getChild(Main.CreationRegles.attributOptions);
            String[] tab = new String[noeud.getChildren().size()];
            for (int i = 0; i < noeud.getChildren().size(); i++) 
            {
                Element val = (Element) noeud.getChildren().get(i);
                tab[i] = val.getAttributeValue(Main.CreationRegles.attributLabel);
            }
            afficherChoixValeurConditionTextuelle(p, tab, Main.CreationRegles.siChoixEgaleA);
        }
        else if(cond.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.conditionTraces))
        {

        }
        else if(cond.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.conditionCombinaison))
        {
            String[] tab= new String[2];
            tab[0]=Main.CreationRegles.stringVrai;
            tab[1]=Main.CreationRegles.stringFaux;
            afficherChoixValeurConditionTextuelle(p, tab, Main.CreationRegles.siValeurEgaleA);
        }
    }
    
    public void changerTypeCondition(String item)
    {
        CbChoixTypeCondition.setSelectedItem(item);
        CbChoixTypeCondition.setEnabled(false);
    }
    
    private void ChargerCbProprieteContrainteContexte(String type)
    {
        Main.CreationRegles.creerListeProprietes();
        CbProprieteContrainteContexte.removeAllItems();
        if(type.isEmpty())
        {            
            Iterator it=Main.CreationRegles.listeProprietes.keySet().iterator();
            while (it.hasNext())
            {
                String s = (String) it.next();
                CbProprieteContrainteContexte.addItem(s);
            }
        }
        else if(type.equals(Main.ModificationInterface.stringBouton))
        {
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.aLeFocus);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.estActif);
        }
        else if(type.equals(Main.ModificationInterface.stringBoutonRadio))
        {
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.estSelectionne);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.aLeFocus);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.estActif);
        }
        else if(type.equals(Main.ModificationInterface.stringComboBox))
        {
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.estSelectionne);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.estEditable);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.aLeFocus);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.estActif);
        }
        else if(type.equals(Main.ModificationInterface.stringItem))
        {
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.estSelectionne);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.aLeFocus);
        }
        else if(type.equals(Main.ModificationInterface.stringPanel) || type.equals(Main.ModificationInterface.stringLabel))
        {

        }
        else if(type.equals(Main.ModificationInterface.stringSlider))
        {            
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.valeurNumerique);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.valeurMax);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.valeurMin);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.aLeFocus);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.estActif);
        }
        else if(type.equals(Main.ModificationInterface.stringSaisie))
        {            
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.valeurTextuelle);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.estEditable);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.aLeFocus);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.estActif);
        }
        else if(type.equals(Main.ModificationInterface.stringArbre))
        {            
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.estEtendu);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.aLeFocus);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.estActif);
        }
        else if(type.equals(Main.ModificationInterface.stringFenetre))
        {            
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.estAuPremierPlan);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.aLeFocus);
        }
        else if(type.equals(Main.ModificationInterface.stringTable))
        {            
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.nbColonnes);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.nbLignes);
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.aLeFocus);
        }
        else
        {
            CbProprieteContrainteContexte.addItem(Main.CreationRegles.setFocus);
        }
    }
    
    public Element creerConditionProfil()
    {
        Element cond= new Element(Main.CreationRegles.attributCondition);
        cond.setAttribute(Main.CreationRegles.attributId, TxtNomCondition.getText());
        cond.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.conditionProfil);
        
        Element SE = FonctionsUtiles.noeudEchelleParId(Main.CreationRegles.id_echelle);
        String type_echelle = ((Element) SE.getChildren().get(0)).getName().toString();
        
        if (type_echelle.equals(Main.CreationRegles.attributNumerique)) 
        {   
            Element num=SE.getChild(Main.CreationRegles.attributNumerique);
            Element intervalle = new Element(Main.CreationRegles.attributNumerique);
            intervalle.setAttribute(Main.CreationRegles.attributChemin, TxtElementConditionProfil.getText());
            intervalle.setAttribute(Main.CreationRegles.attributBorne_inf, num.getAttributeValue(Main.CreationRegles.attributBorne_inf));
            intervalle.setAttribute(Main.CreationRegles.attributBorne_sup, num.getAttributeValue(Main.CreationRegles.attributBorne_sup));
            cond.addContent(intervalle);
        } 
        else 
        {
            Element textuelle = new Element(Main.CreationRegles.attributTextuelle);
            textuelle.setAttribute(Main.CreationRegles.attributChemin, TxtElementConditionProfil.getText());
     
            Element critere=SE.getChild(Main.CreationRegles.attributTextuel);
            for (int k = 0; k < critere.getChildren().size(); k++) 
            {
                Element val= (Element) critere.getChildren().get(k);
                Element e = new Element(Main.CreationRegles.attributValeur);
                e.setText(val.getText());
                textuelle.addContent(e);
            }
            cond.addContent(textuelle);
        }
        
        return cond;
    }
    
    private Element creerConditionHistorique()
    {
        Element cond= new Element(Main.CreationRegles.attributCondition);
        cond.setAttribute(Main.CreationRegles.attributId, TxtNomCondition.getText());
        cond.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.conditionHistorique);
        cond.setAttribute(Main.CreationRegles.attributObjet, CbObjetContrainteHistorique.getSelectedItem().toString());
        
        
        if(PanelHistoriqueTemps.isVisible())
        {
            cond.setAttribute(Main.CreationRegles.attributSousType, CbQuandContrainteHistorique.getSelectedItem().toString());
            if (RbSeanceContrainteHistorique.isSelected()) 
            {
                cond.setAttribute(Main.CreationRegles.attributPortee, Main.CreationRegles.attributSeance);
            } 
            else 
            {
                cond.setAttribute(Main.CreationRegles.attributPortee, Main.CreationRegles.attributGlobale);
            }
        }
        else
            cond.setAttribute(Main.CreationRegles.attributSousType, Main.CreationRegles.conditionConsultation);
        
        if(PanelDernierContrainteHistorique.isVisible())
           cond.setAttribute(Main.CreationRegles.attributUnite, CbDepuisContrainteHistorique.getSelectedItem().toString()); 
        return cond;
    }
    
    private Element creerConditionConsultation(boolean b)
    {
        Element cond= new Element(Main.CreationRegles.attributCondition);
        cond.setAttribute(Main.CreationRegles.attributId, TxtNomCondition.getText());
        cond.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.conditionConsultation);
        
        Element texte=new Element(Main.CreationRegles.attributTexte);
        texte.setText(TxtMessageActionInteractive.getText());
        cond.addContent(texte);
        
        if(PanelDetailsConsultation.isVisible() || b)
        {
            Element titre=new Element(Main.CreationRegles.attributTitre);
            titre.setText(TxtTitreActionInteractive.getText());
            cond.addContent(titre);

            Element policeMessage=new Element(Main.CreationRegles.attributPoliceMessage);
            policeMessage.setAttribute(Main.CreationRegles.attributNom, BtPoliceMessageActionInteractive.getFont().getName());
            policeMessage.setAttribute(Main.CreationRegles.attributStyle, String.valueOf(BtPoliceMessageActionInteractive.getFont().getStyle()));
            policeMessage.setAttribute(Main.CreationRegles.attributTaille, String.valueOf(BtPoliceMessageActionInteractive.getFont().getSize()));
            cond.addContent(policeMessage);

            Element policeOptions=new Element(Main.CreationRegles.attributPoliceOptions);
            policeOptions.setAttribute(Main.CreationRegles.attributNom, BtPoliceBoutonActionInteractive.getFont().getName());
            policeOptions.setAttribute(Main.CreationRegles.attributStyle, String.valueOf(BtPoliceBoutonActionInteractive.getFont().getStyle()));
            policeOptions.setAttribute(Main.CreationRegles.attributTaille, String.valueOf(BtPoliceBoutonActionInteractive.getFont().getSize()));
            cond.addContent(policeOptions);

            Element couleur=new Element(Main.CreationRegles.attributCouleur);
            couleur.setAttribute(Main.CreationRegles.attributPolice, BtPoliceMessageActionInteractive.getForeground().toString());
            couleur.setAttribute(Main.CreationRegles.attributFond, BtCouleurActionInteractive.getBackground().toString());       
            cond.addContent(couleur);
        }
        
        Element options=new Element(Main.CreationRegles.attributOptions);
        for(int i=0; i<PanelBoutonsActionInteractive.getComponentCount(); i++)
        {
            Element option=new Element (Main.CreationRegles.attributOption);
            Panel p = (Panel) PanelBoutonsActionInteractive.getComponent(i);
            JTextField txt = (JTextField) p.getComponent(1);
            option.setAttribute(Main.CreationRegles.attributLabel, txt.getText());
            options.addContent(option);
            
        }
        cond.addContent(options);
        
        return cond;
    }
    
    private Element creerConditionTraces()
    {
        Element cond= new Element(Main.CreationRegles.attributCondition);
        cond.setAttribute(Main.CreationRegles.attributId, TxtNomCondition.getText());
        cond.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.conditionTraces);
        cond.setAttribute(Main.CreationRegles.attributObjet, CbObjetContrainteTraces.getSelectedItem().toString());
        cond.setAttribute(Main.CreationRegles.attributSousType, CbQuandContrainteTraces.getSelectedItem().toString());
        if (RbSeanceContrainteTraces.isSelected()) 
        {
            cond.setAttribute(Main.CreationRegles.attributPortee, Main.CreationRegles.attributSeance);
        } 
        else 
        {
            cond.setAttribute(Main.CreationRegles.attributPortee, Main.CreationRegles.attributGlobale);
        }
        
        if(PanelDernierContrainteTraces.isVisible())
           cond.setAttribute(Main.CreationRegles.attributUnite, CbDepuisContrainteTraces.getSelectedItem().toString()); 
        return cond;
    }
    
    private Element creerConditionContexte()
    {
        Element cond= new Element(Main.CreationRegles.attributCondition);
        cond.setAttribute(Main.CreationRegles.attributId, TxtNomCondition.getText());
        cond.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.conditionContexte);
        cond.setAttribute(Main.CreationRegles.attributIdComp, TxtElementContrainteContexte.getText());
        cond.setAttribute(Main.CreationRegles.attributPropriete, CbProprieteContrainteContexte.getSelectedItem().toString());
        cond.setAttribute(Main.CreationRegles.attributSousType, TxtTypeContrainteContexte.getText());
        return cond;
    }
    
    private void SupprimerBoutonConditionConsultation()
    {
        PanelBoutonsActionInteractive.remove(BtAjoutBoutonActionInteractive.getMnemonic()-1);
        BtAjoutBoutonActionInteractive.setMnemonic(BtAjoutBoutonActionInteractive.getMnemonic()-1);
        if(BtAjoutBoutonActionInteractive.getMnemonic()==1)
        {
            BtSupprimerBoutonConditionConsultation.setEnabled(false);
        }
        BtAjoutBoutonActionInteractive.setEnabled(true);
    }
    
    private void AjoutBoutonConditionConsultation()
    {
        Panel p=new Panel();
        PanelBoutonsActionInteractive.add(p);
        p.setBackground(p.getParent().getBackground());
        p.setLayout(null);
        p.setBounds(20, BtAjoutBoutonActionInteractive.getMnemonic()*30, PanelBoutonsActionInteractive.getWidth()-15, 30);
        Label lb=new Label(Main.CreationRegles.stringIntitule);
        lb.setBounds(40, 0, 50, 24);
        p.add(lb);
        JTextField txt=new JTextField("Option "+String.valueOf(BtAjoutBoutonActionInteractive.getMnemonic()+1));
        txt.setBounds(100, 0, 120, 24);
        p.add(txt);
        
        BtAjoutBoutonActionInteractive.setMnemonic(BtAjoutBoutonActionInteractive.getMnemonic()+1);
        if(BtAjoutBoutonActionInteractive.getMnemonic()==5)
        {
            BtAjoutBoutonActionInteractive.setEnabled(false);
        }
        if(BtAjoutBoutonActionInteractive.getMnemonic()>1)
            BtSupprimerBoutonConditionConsultation.setEnabled(true);
    }
    
    private Element creerConditionCombinaison()
    {
        Element cond= new Element(Main.CreationRegles.attributCondition);
        cond.setAttribute(Main.CreationRegles.attributId, TxtNomCondition.getText());
        cond.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.conditionCombinaison);       
        cond.setAttribute(Main.CreationRegles.attributForumle, TxtFormuleConditionCombinaison.getText());
      
        return cond;
    }
    
    public void modifConditionTraces(Element condition)
    {
        this.chargerInterface();
        Main.CreationRegles.modifConditionTraces=true;
        TxtNomCondition.setText(condition.getAttributeValue(Main.CreationRegles.attributId));
        CbObjetContrainteTraces.setSelectedItem(condition.getAttributeValue(Main.CreationRegles.attributObjet));
        CbQuandContrainteTraces.setSelectedItem(condition.getAttributeValue(Main.CreationRegles.attributSousType));
        if(condition.getAttributeValue(Main.CreationRegles.attributPortee).equals(Main.CreationRegles.attributSeance))
        {
            RbSeanceContrainteTraces.setSelected(true);
        }
        else
        {
            RbGlobalementContrainteTraces.setSelected(true);
        }
        if(condition.getAttribute(Main.CreationRegles.attributUnite)!=null)
        {
            CbDepuisContrainteTraces.setSelectedItem(condition.getAttributeValue(Main.CreationRegles.attributUnite));
        }
        ouvrir();
    }
    
    public void modifConditionHistorique(Element condition)
    {
        this.chargerInterface();
        Main.CreationRegles.modifConditionHistorique=true;
        TxtNomCondition.setText(condition.getAttributeValue(Main.CreationRegles.attributId));
        CbObjetContrainteHistorique.setSelectedItem(condition.getAttributeValue(Main.CreationRegles.attributObjet));
        
        if(!condition.getAttributeValue(Main.CreationRegles.attributSousType).equals(Main.CreationRegles.conditionConsultation))
        {
            CbQuandContrainteHistorique.setSelectedItem(condition.getAttributeValue(Main.CreationRegles.attributSousType));
            if(condition.getAttributeValue(Main.CreationRegles.attributPortee).equals(Main.CreationRegles.attributSeance))
            {
                RbSeanceContrainteHistorique.setSelected(true);
            }
            else
            {
                RbGlobalementContrainteHistorique.setSelected(true);
            }

            if(condition.getAttribute(Main.CreationRegles.attributUnite)!=null)
            {
                CbDepuisContrainteHistorique.setSelectedItem(condition.getAttributeValue(Main.CreationRegles.attributUnite));
            }
        }
        ouvrir();
    }
    
    private void resetConditionCombinaison()
    {
        TxtFormuleConditionCombinaison.setText("");
        BtEtConditionCombinaison.setEnabled(false);
        BtOuConditionCombinaison.setEnabled(false);
        BtOuvreConditionCombinaison.setEnabled(true);
        BtFermeConditionCombinaison.setEnabled(false);
        BtNonConditionCombinaison.setEnabled(true);
        Main.CreationRegles.parentheseOuverte=0;
        setEnableBoutonConditionCombinaison(true);
    }
    
    public void modifConditionCombinaison(Element condition)
    {
        this.chargerInterface();
        Main.CreationRegles.modifConditionCombinaison=true;
        TxtNomCondition.setText(condition.getAttributeValue(Main.CreationRegles.attributId));
        resetConditionCombinaison();
        setEnableBoutonConditionCombinaison(false);
        BtEtConditionCombinaison.setEnabled(true);
        BtOuConditionCombinaison.setEnabled(true);
        TxtFormuleConditionCombinaison.setText(condition.getAttributeValue(Main.CreationRegles.attributForumle));
        ouvrir();
    }
    
    public void modifConditionConsultation(Element condition)
    {
        this.chargerInterface();
        Main.CreationRegles.modifConditionConsultation=true;
        TxtNomCondition.setText(condition.getAttributeValue(Main.CreationRegles.attributId));
        TxtMessageActionInteractive.setText(condition.getChildText(Main.CreationRegles.attributTexte));
        
        boolean bool = true;
        
        if(condition.getChild(Main.CreationRegles.attributTitre)!=null)
        {           
            TxtTitreActionInteractive.setText(condition.getChildText(Main.CreationRegles.attributTitre));
            bool=false;
        }
        
        if(condition.getChild(Main.CreationRegles.attributCouleur)!=null)
        {
            BtCouleurActionInteractive.setBackground(FonctionsUtiles.StringToColor(condition.getChild(Main.CreationRegles.attributCouleur).getAttributeValue(Main.CreationRegles.attributFond)));
            bool=false;
        }
        
        if(condition.getChild(Main.CreationRegles.attributPoliceMessage)!=null)
        {       
            Font f= new Font(condition.getChild(Main.CreationRegles.attributPoliceMessage).getAttributeValue(Main.CreationRegles.attributNom), 
            Integer.parseInt(condition.getChild(Main.CreationRegles.attributPoliceMessage).getAttributeValue(Main.CreationRegles.attributStyle)) , 
            Integer.parseInt(condition.getChild(Main.CreationRegles.attributPoliceMessage).getAttributeValue(Main.CreationRegles.attributTaille)));
        
            BtPoliceMessageActionInteractive.setFont(f);
            
            if(condition.getChild(Main.CreationRegles.attributCouleur)!=null)
            {
                BtPoliceMessageActionInteractive.setForeground(FonctionsUtiles.StringToColor(condition.getChild(Main.CreationRegles.attributCouleur).getAttributeValue(Main.CreationRegles.attributPolice)));               
            }
            bool=false;
        }
        
        afficherDetailsConsultation(bool);
        
        if(condition.getChild(Main.CreationRegles.attributPoliceOptions)!=null)
        {
            BtPoliceBoutonActionInteractive.setFont(new Font(condition.getChild(Main.CreationRegles.attributPoliceOptions).getAttributeValue(Main.CreationRegles.attributNom), 
            Integer.parseInt(condition.getChild(Main.CreationRegles.attributPoliceOptions).getAttributeValue(Main.CreationRegles.attributStyle)) , 
            Integer.parseInt(condition.getChild(Main.CreationRegles.attributPoliceOptions).getAttributeValue(Main.CreationRegles.attributTaille))));
        }
        
        PanelBoutonsActionInteractive.removeAll();
        BtAjoutBoutonActionInteractive.setMnemonic(0);
        for(int i=0; i<condition.getChild(Main.CreationRegles.attributOptions).getChildren().size(); i++)
        {
            Element option = (Element) condition.getChild(Main.CreationRegles.attributOptions).getChildren().get(i);
            AjoutBoutonConditionConsultation();
            Panel p =  (Panel) PanelBoutonsActionInteractive.getComponent(i);
            JTextField txt = (JTextField) p.getComponent(1);
            txt.setText(option.getAttributeValue(Main.CreationRegles.attributLabel));
        }
        ouvrir();
    }
    
    public void modifConditionContexte(Element condition)
    {
        this.chargerInterface();
        Main.CreationRegles.modifConditionContexte=true;
        TxtNomCondition.setText(condition.getAttributeValue(Main.CreationRegles.attributId));
        TxtElementContrainteContexte.setText(condition.getAttributeValue(Main.CreationRegles.attributIdComp));
        CbProprieteContrainteContexte.setSelectedItem(condition.getAttributeValue(Main.CreationRegles.attributPropriete));
        ouvrir();
    }
    
    public void modifConditionProfil(Element condition)
    {
        this.chargerInterface();
        Main.CreationRegles.modifConditionProfil=true;
        Element noeud=(Element) condition.getChildren().get(0);
        String chemin=noeud.getAttributeValue(Main.CreationRegles.attributChemin);
        chemin="[profil, "+chemin.substring(1);
        for(int i=0; i<ArbreProfil.getRowCount(); i++)
        {
           ArbreProfil.setSelectionRow(i);
           if(ArbreProfil.getSelectionPath().toString().equals(chemin))
               break;
        }

        TxtNomCondition.setText(condition.getAttributeValue(Main.CreationRegles.attributId));  
        ouvrir();
    }
    
    private void valider(Element cond)
    {
        Main.CreationRegles.chargerCbChoixConditionRegle();

        if(CB!=null)
        {
            CB.setSelectedItem(cond.getAttributeValue(Main.CreationRegles.attributId));
            CB=null;
        }
        Main.CreationRegles.setEnabled(true);
        this.setVisible(false);
    }
    
    private void annuler()
    {
        if(CB!=null)
        {
            CB.setSelectedItem(Main.CreationRegles.itemAucune);
            CB=null;
        }
        CbChoixTypeCondition.setEnabled(true);
        this.setVisible(false);
    }
    
    private void ouvrir()
    {
        this.setVisible(true);
    }
    
    private void afficherDetailsConsultation(boolean bool)
    {
        if (bool) {
            BtAfficherDetailsActionInteractive.setToolTipText(Main.CreationRegles.tooltipAfficherDetailsMiseEnValeur);
            Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
            BtAfficherDetailsActionInteractive.setIcon(new ImageIcon(icon));
            BtAfficherDetailsActionInteractive.setText("");

            PanelDetailsConsultation.setVisible(false);

        } else {
            BtAfficherDetailsActionInteractive.setToolTipText(Main.CreationRegles.tooltipMasquerDetailsMiseEnValeur);
            Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/moins.png"));
            BtAfficherDetailsActionInteractive.setIcon(new ImageIcon(icon));
            BtAfficherDetailsActionInteractive.setText("");
            PanelDetailsConsultation.setVisible(true);
        }

        Main.CreationRegles.afficherDetailsConsultation = !Main.CreationRegles.afficherDetailsConsultation;
    }
    
    private void resetConditionConsultation()
    {
        TxtTitreActionInteractive.setText("information"); 
        TxtMessageActionInteractive.setText("");
        BtCouleurActionInteractive.setBackground(TxtMessageActionInteractive.getBackground());
        BtCouleurActionInteractive.setBackground(Color.WHITE);        
        BtAjoutBoutonActionInteractive.setMnemonic(0);
        PanelBoutonsActionInteractive.removeAll();
        AjoutBoutonConditionConsultation();
        
        BtAfficherDetailsActionInteractive.setToolTipText(Main.CreationRegles.tooltipAfficherDetailsMiseEnValeur);
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
        BtAfficherDetailsActionInteractive.setIcon(new ImageIcon(icon));
        BtAfficherDetailsActionInteractive.setText("");

        PanelDetailsConsultation.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupContrainteHistorique = new javax.swing.ButtonGroup();
        PanelCreationCondition = new javax.swing.JPanel();
        LbNomCondition = new javax.swing.JLabel();
        TxtNomCondition = new javax.swing.JTextField();
        LbChoixTypeCondition = new javax.swing.JLabel();
        CbChoixTypeCondition = new javax.swing.JComboBox();
        PanelCreationConditionProfil = new javax.swing.JPanel();
        BtAnnulerConditionProfil = new javax.swing.JButton();
        LbElementConditionProfil = new javax.swing.JLabel();
        PanelDefContrainteProfil = new javax.swing.JPanel();
        ScrollArbreProfil = new javax.swing.JScrollPane();
        ArbreProfil = new javax.swing.JTree();
        BtValiderConditionProfil = new javax.swing.JButton();
        TxtElementConditionProfil = new javax.swing.JTextField();
        PanelCreationConditionHistorique = new javax.swing.JPanel();
        LbObjetContrainteHistorique = new javax.swing.JLabel();
        CbObjetContrainteHistorique = new javax.swing.JComboBox();
        BtAnnulerContrainteHistorique = new javax.swing.JButton();
        BtValiderContrainteHistorique = new javax.swing.JButton();
        PanelHistoriqueTemps = new javax.swing.JPanel();
        RbGlobalementContrainteHistorique = new javax.swing.JRadioButton();
        CbQuandContrainteHistorique = new javax.swing.JComboBox();
        RbSeanceContrainteHistorique = new javax.swing.JRadioButton();
        PanelDernierContrainteHistorique = new javax.swing.JPanel();
        LbDepuisContrainteHistorique = new javax.swing.JLabel();
        CbDepuisContrainteHistorique = new javax.swing.JComboBox();
        PanelCreationConditionContexte = new javax.swing.JPanel();
        LbElementContrainteContexte = new javax.swing.JLabel();
        TxtElementContrainteContexte = new javax.swing.JTextField();
        ScrollArbreContrainteContexte = new javax.swing.JScrollPane();
        ArbreContrainteContexte = new javax.swing.JTree();
        LbProprieteContrainteContexte = new javax.swing.JLabel();
        CbProprieteContrainteContexte = new javax.swing.JComboBox();
        LbTypeContrainteContexte = new javax.swing.JLabel();
        TxtTypeContrainteContexte = new javax.swing.JTextField();
        BtValiderContrainteContexte = new javax.swing.JButton();
        BtAnnulerContrainteContexte = new javax.swing.JButton();
        BtModifierDescriptionInterfaceContrainteContexte = new javax.swing.JButton();
        BtAfficherDescriptionInterfaceContrainteContexte = new javax.swing.JButton();
        PanelCreationConditionConsultation = new javax.swing.JPanel();
        LbMessageActionInteractive = new javax.swing.JLabel();
        ScrollMessageActionInteractive = new javax.swing.JScrollPane();
        TxtMessageActionInteractive = new javax.swing.JTextArea();
        LbAjoutActionInteractive = new javax.swing.JLabel();
        LbBoutonActionInteractive = new javax.swing.JLabel();
        ScrollBoutonsActionInteractive = new javax.swing.JScrollPane();
        PanelBoutonsActionInteractive = new javax.swing.JPanel();
        BtApercuActionInteractive = new javax.swing.JButton();
        BtValiderActionInteractive = new javax.swing.JButton();
        BtAnnulerActionInteractive = new javax.swing.JButton();
        BtAjoutBoutonActionInteractive = new javax.swing.JButton();
        CbPersoConditionConsultation = new javax.swing.JComboBox();
        BtInclureConditionConsultation = new javax.swing.JButton();
        BtSupprimerBoutonConditionConsultation = new javax.swing.JButton();
        PanelDetailsConsultation = new javax.swing.JPanel();
        LbPoliceMessageActionInteractive = new javax.swing.JLabel();
        BtCouleurActionInteractive = new javax.swing.JButton();
        LbTitreActionInteractive = new javax.swing.JLabel();
        LbCouleurActionInteractive = new javax.swing.JLabel();
        TxtTitreActionInteractive = new javax.swing.JTextField();
        LbPoliceBoutonActionInteractive = new javax.swing.JLabel();
        BtPoliceBoutonActionInteractive = new javax.swing.JButton();
        BtPoliceMessageActionInteractive = new javax.swing.JButton();
        LbModeActionInteractive = new javax.swing.JLabel();
        CbModeActionInteractive = new javax.swing.JComboBox();
        BtAfficherDetailsActionInteractive = new javax.swing.JButton();
        PanelCreationConditionCombinaison = new javax.swing.JPanel();
        LbFormuleConditionCombinaison = new javax.swing.JLabel();
        TxtFormuleConditionCombinaison = new javax.swing.JTextField();
        BtValiderConditionCombinaison = new javax.swing.JButton();
        LbOperateursConditionCombinaison = new javax.swing.JLabel();
        BtEtConditionCombinaison = new javax.swing.JButton();
        BtOuConditionCombinaison = new javax.swing.JButton();
        BtOuvreConditionCombinaison = new javax.swing.JButton();
        BtFermeConditionCombinaison = new javax.swing.JButton();
        BtNonConditionCombinaison = new javax.swing.JButton();
        ScrollBoutonsConditionCombinaison = new javax.swing.JScrollPane();
        PanelBoutonsConditionCombinaison = new javax.swing.JPanel();
        LbConditionsConditionCombinaison1 = new javax.swing.JLabel();
        BtAnnulerConditionCombinaison = new javax.swing.JButton();
        PanelCreationConditionTraces = new javax.swing.JPanel();
        BtValiderConditionTraces = new javax.swing.JButton();
        BtAnnulerConditionTraces = new javax.swing.JButton();
        LbObjetContrainteTraces = new javax.swing.JLabel();
        CbObjetContrainteTraces = new javax.swing.JComboBox();
        CbQuandContrainteTraces = new javax.swing.JComboBox();
        RbSeanceContrainteTraces = new javax.swing.JRadioButton();
        RbGlobalementContrainteTraces = new javax.swing.JRadioButton();
        PanelDernierContrainteTraces = new javax.swing.JPanel();
        LbDepuisContrainteTraces = new javax.swing.JLabel();
        CbDepuisContrainteTraces = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PanelCreationCondition.setBackground(new java.awt.Color(255, 255, 204));

        LbNomCondition.setText("Nom de la condition");

        TxtNomCondition.setEnabled(false);

        LbChoixTypeCondition.setText("Type de condition");

        CbChoixTypeCondition.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbChoixTypeCondition.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbChoixTypeConditionItemStateChanged(evt);
            }
        });

        PanelCreationConditionProfil.setBackground(new java.awt.Color(255, 255, 204));

        BtAnnulerConditionProfil.setText("Annuler");
        BtAnnulerConditionProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerConditionProfilActionPerformed(evt);
            }
        });

        LbElementConditionProfil.setText("Elément concerné");

        PanelDefContrainteProfil.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout PanelDefContrainteProfilLayout = new javax.swing.GroupLayout(PanelDefContrainteProfil);
        PanelDefContrainteProfil.setLayout(PanelDefContrainteProfilLayout);
        PanelDefContrainteProfilLayout.setHorizontalGroup(
            PanelDefContrainteProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );
        PanelDefContrainteProfilLayout.setVerticalGroup(
            PanelDefContrainteProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        ArbreProfil.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                ArbreProfilValueChanged(evt);
            }
        });
        ScrollArbreProfil.setViewportView(ArbreProfil);

        BtValiderConditionProfil.setText("Valider");
        BtValiderConditionProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderConditionProfilActionPerformed(evt);
            }
        });

        TxtElementConditionProfil.setEnabled(false);

        javax.swing.GroupLayout PanelCreationConditionProfilLayout = new javax.swing.GroupLayout(PanelCreationConditionProfil);
        PanelCreationConditionProfil.setLayout(PanelCreationConditionProfilLayout);
        PanelCreationConditionProfilLayout.setHorizontalGroup(
            PanelCreationConditionProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationConditionProfilLayout.createSequentialGroup()
                .addGroup(PanelCreationConditionProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelCreationConditionProfilLayout.createSequentialGroup()
                        .addComponent(LbElementConditionProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtElementConditionProfil))
                    .addGroup(PanelCreationConditionProfilLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelCreationConditionProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelCreationConditionProfilLayout.createSequentialGroup()
                                .addComponent(BtValiderConditionProfil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtAnnulerConditionProfil))
                            .addComponent(ScrollArbreProfil))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDefContrainteProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelCreationConditionProfilLayout.setVerticalGroup(
            PanelCreationConditionProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationConditionProfilLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelCreationConditionProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbElementConditionProfil)
                    .addComponent(TxtElementConditionProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelCreationConditionProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationConditionProfilLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(PanelDefContrainteProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCreationConditionProfilLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScrollArbreProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(PanelCreationConditionProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtValiderConditionProfil)
                            .addComponent(BtAnnulerConditionProfil)))))
        );

        PanelCreationConditionHistorique.setBackground(new java.awt.Color(255, 255, 204));

        LbObjetContrainteHistorique.setText("Règle ou action concernée");

        CbObjetContrainteHistorique.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbObjetContrainteHistorique.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbObjetContrainteHistoriqueItemStateChanged(evt);
            }
        });

        BtAnnulerContrainteHistorique.setText("Annuler");
        BtAnnulerContrainteHistorique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerContrainteHistoriqueActionPerformed(evt);
            }
        });

        BtValiderContrainteHistorique.setText("Valider");
        BtValiderContrainteHistorique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderContrainteHistoriqueActionPerformed(evt);
            }
        });

        PanelHistoriqueTemps.setBackground(new java.awt.Color(255, 255, 204));

        RbGlobalementContrainteHistorique.setBackground(new java.awt.Color(255, 255, 204));
        GroupContrainteHistorique.add(RbGlobalementContrainteHistorique);
        RbGlobalementContrainteHistorique.setText("Globalement");

        CbQuandContrainteHistorique.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbQuandContrainteHistorique.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbQuandContrainteHistoriqueItemStateChanged(evt);
            }
        });

        RbSeanceContrainteHistorique.setBackground(new java.awt.Color(255, 255, 204));
        GroupContrainteHistorique.add(RbSeanceContrainteHistorique);
        RbSeanceContrainteHistorique.setText("Dans la séance");

        PanelDernierContrainteHistorique.setBackground(new java.awt.Color(255, 255, 204));

        LbDepuisContrainteHistorique.setText("Unité de temps");

        CbDepuisContrainteHistorique.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout PanelDernierContrainteHistoriqueLayout = new javax.swing.GroupLayout(PanelDernierContrainteHistorique);
        PanelDernierContrainteHistorique.setLayout(PanelDernierContrainteHistoriqueLayout);
        PanelDernierContrainteHistoriqueLayout.setHorizontalGroup(
            PanelDernierContrainteHistoriqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDernierContrainteHistoriqueLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(CbDepuisContrainteHistorique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(PanelDernierContrainteHistoriqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelDernierContrainteHistoriqueLayout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(LbDepuisContrainteHistorique, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE)))
        );
        PanelDernierContrainteHistoriqueLayout.setVerticalGroup(
            PanelDernierContrainteHistoriqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDernierContrainteHistoriqueLayout.createSequentialGroup()
                .addComponent(CbDepuisContrainteHistorique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
            .addGroup(PanelDernierContrainteHistoriqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelDernierContrainteHistoriqueLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(LbDepuisContrainteHistorique)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout PanelHistoriqueTempsLayout = new javax.swing.GroupLayout(PanelHistoriqueTemps);
        PanelHistoriqueTemps.setLayout(PanelHistoriqueTempsLayout);
        PanelHistoriqueTempsLayout.setHorizontalGroup(
            PanelHistoriqueTempsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(PanelHistoriqueTempsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelHistoriqueTempsLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(PanelHistoriqueTempsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CbQuandContrainteHistorique, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RbSeanceContrainteHistorique)
                        .addComponent(RbGlobalementContrainteHistorique)
                        .addComponent(PanelDernierContrainteHistorique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(41, 41, 41)))
        );
        PanelHistoriqueTempsLayout.setVerticalGroup(
            PanelHistoriqueTempsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
            .addGroup(PanelHistoriqueTempsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelHistoriqueTempsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(CbQuandContrainteHistorique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(RbSeanceContrainteHistorique)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(RbGlobalementContrainteHistorique)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(PanelDernierContrainteHistorique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout PanelCreationConditionHistoriqueLayout = new javax.swing.GroupLayout(PanelCreationConditionHistorique);
        PanelCreationConditionHistorique.setLayout(PanelCreationConditionHistoriqueLayout);
        PanelCreationConditionHistoriqueLayout.setHorizontalGroup(
            PanelCreationConditionHistoriqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationConditionHistoriqueLayout.createSequentialGroup()
                .addGroup(PanelCreationConditionHistoriqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbObjetContrainteHistorique, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbObjetContrainteHistorique, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelCreationConditionHistoriqueLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtValiderContrainteHistorique, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtAnnulerContrainteHistorique))
                    .addComponent(PanelHistoriqueTemps, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelCreationConditionHistoriqueLayout.setVerticalGroup(
            PanelCreationConditionHistoriqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationConditionHistoriqueLayout.createSequentialGroup()
                .addComponent(LbObjetContrainteHistorique)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CbObjetContrainteHistorique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelHistoriqueTemps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCreationConditionHistoriqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtValiderContrainteHistorique)
                    .addComponent(BtAnnulerContrainteHistorique))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelCreationConditionContexte.setBackground(new java.awt.Color(255, 255, 204));

        LbElementContrainteContexte.setText("Composant concerné");

        TxtElementContrainteContexte.setEnabled(false);
        TxtElementContrainteContexte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtElementContrainteContexteActionPerformed(evt);
            }
        });

        ArbreContrainteContexte.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                ArbreContrainteContexteValueChanged(evt);
            }
        });
        ScrollArbreContrainteContexte.setViewportView(ArbreContrainteContexte);

        LbProprieteContrainteContexte.setText("Propriété :");

        CbProprieteContrainteContexte.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbProprieteContrainteContexte.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbProprieteContrainteContexteItemStateChanged(evt);
            }
        });

        LbTypeContrainteContexte.setText("Type :");

        TxtTypeContrainteContexte.setEnabled(false);
        TxtTypeContrainteContexte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTypeContrainteContexteActionPerformed(evt);
            }
        });

        BtValiderContrainteContexte.setText("Valider");
        BtValiderContrainteContexte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderContrainteContexteActionPerformed(evt);
            }
        });

        BtAnnulerContrainteContexte.setText("Annuler");
        BtAnnulerContrainteContexte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerContrainteContexteActionPerformed(evt);
            }
        });

        BtModifierDescriptionInterfaceContrainteContexte.setText("...");
        BtModifierDescriptionInterfaceContrainteContexte.setToolTipText("Modifier la description de l'interface");
        BtModifierDescriptionInterfaceContrainteContexte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierDescriptionInterfaceContrainteContexteActionPerformed(evt);
            }
        });

        BtAfficherDescriptionInterfaceContrainteContexte.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        BtAfficherDescriptionInterfaceContrainteContexte.setText("+");
        BtAfficherDescriptionInterfaceContrainteContexte.setToolTipText("Afficher la totalité de la description de l'interface");
        BtAfficherDescriptionInterfaceContrainteContexte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAfficherDescriptionInterfaceContrainteContexteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCreationConditionContexteLayout = new javax.swing.GroupLayout(PanelCreationConditionContexte);
        PanelCreationConditionContexte.setLayout(PanelCreationConditionContexteLayout);
        PanelCreationConditionContexteLayout.setHorizontalGroup(
            PanelCreationConditionContexteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationConditionContexteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationConditionContexteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationConditionContexteLayout.createSequentialGroup()
                        .addComponent(LbElementContrainteContexte, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtElementContrainteContexte, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelCreationConditionContexteLayout.createSequentialGroup()
                        .addGroup(PanelCreationConditionContexteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCreationConditionContexteLayout.createSequentialGroup()
                                .addGroup(PanelCreationConditionContexteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ScrollArbreContrainteContexte, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelCreationConditionContexteLayout.createSequentialGroup()
                                        .addComponent(LbTypeContrainteContexte)
                                        .addGap(33, 33, 33)
                                        .addComponent(TxtTypeContrainteContexte)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelCreationConditionContexteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BtAfficherDescriptionInterfaceContrainteContexte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtModifierDescriptionInterfaceContrainteContexte, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelCreationConditionContexteLayout.createSequentialGroup()
                                .addGroup(PanelCreationConditionContexteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtValiderContrainteContexte)
                                    .addComponent(LbProprieteContrainteContexte))
                                .addGap(18, 18, 18)
                                .addGroup(PanelCreationConditionContexteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtAnnulerContrainteContexte)
                                    .addComponent(CbProprieteContrainteContexte, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        PanelCreationConditionContexteLayout.setVerticalGroup(
            PanelCreationConditionContexteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationConditionContexteLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(PanelCreationConditionContexteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbElementContrainteContexte)
                    .addComponent(TxtElementContrainteContexte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCreationConditionContexteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollArbreContrainteContexte, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelCreationConditionContexteLayout.createSequentialGroup()
                        .addComponent(BtModifierDescriptionInterfaceContrainteContexte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtAfficherDescriptionInterfaceContrainteContexte, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreationConditionContexteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbProprieteContrainteContexte)
                    .addComponent(CbProprieteContrainteContexte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreationConditionContexteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTypeContrainteContexte)
                    .addComponent(TxtTypeContrainteContexte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(PanelCreationConditionContexteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtValiderContrainteContexte)
                    .addComponent(BtAnnulerContrainteContexte))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelCreationConditionConsultation.setBackground(new java.awt.Color(255, 255, 204));

        LbMessageActionInteractive.setText("Message");

        TxtMessageActionInteractive.setColumns(20);
        TxtMessageActionInteractive.setRows(5);
        ScrollMessageActionInteractive.setViewportView(TxtMessageActionInteractive);

        LbAjoutActionInteractive.setText("Personnaliser avec");

        LbBoutonActionInteractive.setText("Boutons de réponse");

        ScrollBoutonsActionInteractive.setBackground(new java.awt.Color(255, 255, 204));
        ScrollBoutonsActionInteractive.setBorder(null);

        PanelBoutonsActionInteractive.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout PanelBoutonsActionInteractiveLayout = new javax.swing.GroupLayout(PanelBoutonsActionInteractive);
        PanelBoutonsActionInteractive.setLayout(PanelBoutonsActionInteractiveLayout);
        PanelBoutonsActionInteractiveLayout.setHorizontalGroup(
            PanelBoutonsActionInteractiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
        );
        PanelBoutonsActionInteractiveLayout.setVerticalGroup(
            PanelBoutonsActionInteractiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );

        ScrollBoutonsActionInteractive.setViewportView(PanelBoutonsActionInteractive);

        BtApercuActionInteractive.setText("Aperçu");
        BtApercuActionInteractive.setToolTipText("Voir un aperçu de la mise en valeur définie sur des composants exemples");
        BtApercuActionInteractive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtApercuActionInteractiveActionPerformed(evt);
            }
        });

        BtValiderActionInteractive.setText("Valider");
        BtValiderActionInteractive.setToolTipText("Valider l'action et revenir à la définition des règles d'assistance");
        BtValiderActionInteractive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderActionInteractiveActionPerformed(evt);
            }
        });

        BtAnnulerActionInteractive.setText("Annuler");
        BtAnnulerActionInteractive.setToolTipText("Retour à la définition des règles d'assistance");
        BtAnnulerActionInteractive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerActionInteractiveActionPerformed(evt);
            }
        });

        BtAjoutBoutonActionInteractive.setText("+");
        BtAjoutBoutonActionInteractive.setToolTipText("Ajouter un bouton de réponse");
        BtAjoutBoutonActionInteractive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAjoutBoutonActionInteractiveActionPerformed(evt);
            }
        });

        CbPersoConditionConsultation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BtInclureConditionConsultation.setText("Inclure");

        BtSupprimerBoutonConditionConsultation.setText("-");
        BtSupprimerBoutonConditionConsultation.setToolTipText("Supprimer un bouton de réponse");
        BtSupprimerBoutonConditionConsultation.setEnabled(false);
        BtSupprimerBoutonConditionConsultation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSupprimerBoutonConditionConsultationActionPerformed(evt);
            }
        });

        PanelDetailsConsultation.setBackground(new java.awt.Color(255, 255, 204));
        PanelDetailsConsultation.setBorder(javax.swing.BorderFactory.createTitledBorder("Plus de détails"));

        LbPoliceMessageActionInteractive.setText("Police du message");

        BtCouleurActionInteractive.setText("...");
        BtCouleurActionInteractive.setToolTipText("Modifier la couleur de fond du message");
        BtCouleurActionInteractive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCouleurActionInteractiveActionPerformed(evt);
            }
        });

        LbTitreActionInteractive.setText("Titre de la fenêtre");

        LbCouleurActionInteractive.setText("Couleur de fond");

        LbPoliceBoutonActionInteractive.setText("Police des boutons");

        BtPoliceBoutonActionInteractive.setText("abc");
        BtPoliceBoutonActionInteractive.setToolTipText("Modifier la police des boutons");
        BtPoliceBoutonActionInteractive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPoliceBoutonActionInteractiveActionPerformed(evt);
            }
        });

        BtPoliceMessageActionInteractive.setText("abc");
        BtPoliceMessageActionInteractive.setToolTipText("Modifier la police du message");
        BtPoliceMessageActionInteractive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPoliceMessageActionInteractiveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelDetailsConsultationLayout = new javax.swing.GroupLayout(PanelDetailsConsultation);
        PanelDetailsConsultation.setLayout(PanelDetailsConsultationLayout);
        PanelDetailsConsultationLayout.setHorizontalGroup(
            PanelDetailsConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(PanelDetailsConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelDetailsConsultationLayout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(PanelDetailsConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelDetailsConsultationLayout.createSequentialGroup()
                            .addComponent(LbCouleurActionInteractive)
                            .addGap(18, 18, 18)
                            .addComponent(BtCouleurActionInteractive))
                        .addGroup(PanelDetailsConsultationLayout.createSequentialGroup()
                            .addComponent(LbPoliceMessageActionInteractive)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(BtPoliceMessageActionInteractive))
                        .addGroup(PanelDetailsConsultationLayout.createSequentialGroup()
                            .addComponent(LbPoliceBoutonActionInteractive)
                            .addGap(18, 18, 18)
                            .addComponent(BtPoliceBoutonActionInteractive))
                        .addGroup(PanelDetailsConsultationLayout.createSequentialGroup()
                            .addComponent(LbTitreActionInteractive, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(66, 66, 66)
                            .addComponent(TxtTitreActionInteractive, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        PanelDetailsConsultationLayout.setVerticalGroup(
            PanelDetailsConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
            .addGroup(PanelDetailsConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDetailsConsultationLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelDetailsConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LbTitreActionInteractive)
                        .addComponent(TxtTitreActionInteractive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(PanelDetailsConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LbCouleurActionInteractive)
                        .addComponent(BtCouleurActionInteractive))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(PanelDetailsConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LbPoliceMessageActionInteractive)
                        .addComponent(BtPoliceMessageActionInteractive))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(PanelDetailsConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LbPoliceBoutonActionInteractive)
                        .addComponent(BtPoliceBoutonActionInteractive))
                    .addContainerGap()))
        );

        LbModeActionInteractive.setText("Mode de transmission");

        CbModeActionInteractive.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "popup" }));
        CbModeActionInteractive.setEnabled(false);

        BtAfficherDetailsActionInteractive.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        BtAfficherDetailsActionInteractive.setText("+");
        BtAfficherDetailsActionInteractive.setToolTipText("Afficher plus de détails");
        BtAfficherDetailsActionInteractive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAfficherDetailsActionInteractiveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCreationConditionConsultationLayout = new javax.swing.GroupLayout(PanelCreationConditionConsultation);
        PanelCreationConditionConsultation.setLayout(PanelCreationConditionConsultationLayout);
        PanelCreationConditionConsultationLayout.setHorizontalGroup(
            PanelCreationConditionConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationConditionConsultationLayout.createSequentialGroup()
                .addGroup(PanelCreationConditionConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbMessageActionInteractive)
                    .addComponent(ScrollMessageActionInteractive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelCreationConditionConsultationLayout.createSequentialGroup()
                        .addComponent(LbAjoutActionInteractive, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbPersoConditionConsultation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtInclureConditionConsultation, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelCreationConditionConsultationLayout.createSequentialGroup()
                .addGroup(PanelCreationConditionConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationConditionConsultationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelDetailsConsultation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelCreationConditionConsultationLayout.createSequentialGroup()
                        .addGroup(PanelCreationConditionConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCreationConditionConsultationLayout.createSequentialGroup()
                                .addComponent(LbBoutonActionInteractive)
                                .addGap(18, 18, 18)
                                .addComponent(BtAjoutBoutonActionInteractive)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtSupprimerBoutonConditionConsultation))
                            .addComponent(ScrollBoutonsActionInteractive, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelCreationConditionConsultationLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(BtValiderActionInteractive, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtApercuActionInteractive, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtAnnulerActionInteractive, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelCreationConditionConsultationLayout.createSequentialGroup()
                                .addComponent(LbModeActionInteractive)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CbModeActionInteractive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtAfficherDetailsActionInteractive, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelCreationConditionConsultationLayout.setVerticalGroup(
            PanelCreationConditionConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationConditionConsultationLayout.createSequentialGroup()
                .addComponent(LbMessageActionInteractive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollMessageActionInteractive, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreationConditionConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbAjoutActionInteractive)
                    .addComponent(CbPersoConditionConsultation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtInclureConditionConsultation))
                .addGap(16, 16, 16)
                .addGroup(PanelCreationConditionConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbModeActionInteractive)
                    .addComponent(CbModeActionInteractive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAfficherDetailsActionInteractive, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreationConditionConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbBoutonActionInteractive)
                    .addComponent(BtAjoutBoutonActionInteractive)
                    .addComponent(BtSupprimerBoutonConditionConsultation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollBoutonsActionInteractive, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelDetailsConsultation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCreationConditionConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtValiderActionInteractive)
                    .addComponent(BtAnnulerActionInteractive)
                    .addComponent(BtApercuActionInteractive))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelCreationConditionCombinaison.setBackground(new java.awt.Color(255, 255, 204));

        LbFormuleConditionCombinaison.setText("Formule");

        TxtFormuleConditionCombinaison.setEditable(false);
        TxtFormuleConditionCombinaison.setText(" ");

        BtValiderConditionCombinaison.setText("Valider");
        BtValiderConditionCombinaison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderConditionCombinaisonActionPerformed(evt);
            }
        });

        LbOperateursConditionCombinaison.setText("Les opérateurs logiques");

        BtEtConditionCombinaison.setText("Et");
        BtEtConditionCombinaison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEtConditionCombinaisonActionPerformed(evt);
            }
        });

        BtOuConditionCombinaison.setText("Ou");
        BtOuConditionCombinaison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtOuConditionCombinaisonActionPerformed(evt);
            }
        });

        BtOuvreConditionCombinaison.setText("(");
        BtOuvreConditionCombinaison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtOuvreConditionCombinaisonActionPerformed(evt);
            }
        });

        BtFermeConditionCombinaison.setText(")");
        BtFermeConditionCombinaison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtFermeConditionCombinaisonActionPerformed(evt);
            }
        });

        BtNonConditionCombinaison.setText("non");
        BtNonConditionCombinaison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtNonConditionCombinaisonActionPerformed(evt);
            }
        });

        ScrollBoutonsConditionCombinaison.setBorder(null);

        PanelBoutonsConditionCombinaison.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout PanelBoutonsConditionCombinaisonLayout = new javax.swing.GroupLayout(PanelBoutonsConditionCombinaison);
        PanelBoutonsConditionCombinaison.setLayout(PanelBoutonsConditionCombinaisonLayout);
        PanelBoutonsConditionCombinaisonLayout.setHorizontalGroup(
            PanelBoutonsConditionCombinaisonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );
        PanelBoutonsConditionCombinaisonLayout.setVerticalGroup(
            PanelBoutonsConditionCombinaisonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        ScrollBoutonsConditionCombinaison.setViewportView(PanelBoutonsConditionCombinaison);

        LbConditionsConditionCombinaison1.setText("Les conditions existantes");

        BtAnnulerConditionCombinaison.setText("Annuler");
        BtAnnulerConditionCombinaison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerConditionCombinaisonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCreationConditionCombinaisonLayout = new javax.swing.GroupLayout(PanelCreationConditionCombinaison);
        PanelCreationConditionCombinaison.setLayout(PanelCreationConditionCombinaisonLayout);
        PanelCreationConditionCombinaisonLayout.setHorizontalGroup(
            PanelCreationConditionCombinaisonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationConditionCombinaisonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationConditionCombinaisonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreationConditionCombinaisonLayout.createSequentialGroup()
                        .addGap(0, 161, Short.MAX_VALUE)
                        .addGroup(PanelCreationConditionCombinaisonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCreationConditionCombinaisonLayout.createSequentialGroup()
                                .addComponent(LbFormuleConditionCombinaison, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(TxtFormuleConditionCombinaison, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LbOperateursConditionCombinaison)
                            .addGroup(PanelCreationConditionCombinaisonLayout.createSequentialGroup()
                                .addComponent(BtEtConditionCombinaison)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtOuConditionCombinaison)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtOuvreConditionCombinaison)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtFermeConditionCombinaison)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtNonConditionCombinaison))))
                    .addGroup(PanelCreationConditionCombinaisonLayout.createSequentialGroup()
                        .addGroup(PanelCreationConditionCombinaisonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtValiderConditionCombinaison)
                            .addComponent(LbConditionsConditionCombinaison1))
                        .addGroup(PanelCreationConditionCombinaisonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCreationConditionCombinaisonLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(ScrollBoutonsConditionCombinaison, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelCreationConditionCombinaisonLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(BtAnnulerConditionCombinaison)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PanelCreationConditionCombinaisonLayout.setVerticalGroup(
            PanelCreationConditionCombinaisonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationConditionCombinaisonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationConditionCombinaisonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbFormuleConditionCombinaison)
                    .addComponent(TxtFormuleConditionCombinaison, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LbOperateursConditionCombinaison)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreationConditionCombinaisonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtEtConditionCombinaison)
                    .addComponent(BtOuConditionCombinaison)
                    .addComponent(BtOuvreConditionCombinaison)
                    .addComponent(BtFermeConditionCombinaison)
                    .addComponent(BtNonConditionCombinaison))
                .addGroup(PanelCreationConditionCombinaisonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationConditionCombinaisonLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(LbConditionsConditionCombinaison1))
                    .addGroup(PanelCreationConditionCombinaisonLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(ScrollBoutonsConditionCombinaison, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelCreationConditionCombinaisonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtValiderConditionCombinaison)
                    .addComponent(BtAnnulerConditionCombinaison))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelCreationConditionTraces.setBackground(new java.awt.Color(255, 255, 204));

        BtValiderConditionTraces.setText("Valider");
        BtValiderConditionTraces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderConditionTracesActionPerformed(evt);
            }
        });

        BtAnnulerConditionTraces.setText("Annuler");
        BtAnnulerConditionTraces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerConditionTracesActionPerformed(evt);
            }
        });

        LbObjetContrainteTraces.setText("Séquence d'événements concernée");

        CbObjetContrainteTraces.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CbQuandContrainteTraces.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbQuandContrainteTraces.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbQuandContrainteTracesItemStateChanged(evt);
            }
        });

        RbSeanceContrainteTraces.setBackground(new java.awt.Color(255, 255, 204));
        RbSeanceContrainteTraces.setText("Dans la séance");

        RbGlobalementContrainteTraces.setBackground(new java.awt.Color(255, 255, 204));
        RbGlobalementContrainteTraces.setText("Globalement");

        PanelDernierContrainteTraces.setBackground(new java.awt.Color(255, 255, 204));

        LbDepuisContrainteTraces.setText("Unité de temps");

        CbDepuisContrainteTraces.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout PanelDernierContrainteTracesLayout = new javax.swing.GroupLayout(PanelDernierContrainteTraces);
        PanelDernierContrainteTraces.setLayout(PanelDernierContrainteTracesLayout);
        PanelDernierContrainteTracesLayout.setHorizontalGroup(
            PanelDernierContrainteTracesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDernierContrainteTracesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbDepuisContrainteTraces, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(CbDepuisContrainteTraces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelDernierContrainteTracesLayout.setVerticalGroup(
            PanelDernierContrainteTracesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDernierContrainteTracesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDernierContrainteTracesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDernierContrainteTracesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CbDepuisContrainteTraces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelDernierContrainteTracesLayout.createSequentialGroup()
                        .addComponent(LbDepuisContrainteTraces)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout PanelCreationConditionTracesLayout = new javax.swing.GroupLayout(PanelCreationConditionTraces);
        PanelCreationConditionTraces.setLayout(PanelCreationConditionTracesLayout);
        PanelCreationConditionTracesLayout.setHorizontalGroup(
            PanelCreationConditionTracesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationConditionTracesLayout.createSequentialGroup()
                .addGroup(PanelCreationConditionTracesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationConditionTracesLayout.createSequentialGroup()
                        .addComponent(LbObjetContrainteTraces, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CbObjetContrainteTraces, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCreationConditionTracesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelCreationConditionTracesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelDernierContrainteTraces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelCreationConditionTracesLayout.createSequentialGroup()
                                .addComponent(BtValiderConditionTraces)
                                .addGap(31, 31, 31)
                                .addComponent(BtAnnulerConditionTraces))
                            .addGroup(PanelCreationConditionTracesLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(RbSeanceContrainteTraces)
                                .addGap(18, 18, 18)
                                .addComponent(RbGlobalementContrainteTraces))
                            .addComponent(CbQuandContrainteTraces, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelCreationConditionTracesLayout.setVerticalGroup(
            PanelCreationConditionTracesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreationConditionTracesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationConditionTracesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbObjetContrainteTraces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbObjetContrainteTraces))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CbQuandContrainteTraces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(PanelCreationConditionTracesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbSeanceContrainteTraces)
                    .addComponent(RbGlobalementContrainteTraces))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDernierContrainteTraces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreationConditionTracesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtAnnulerConditionTraces)
                    .addComponent(BtValiderConditionTraces))
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelCreationConditionLayout = new javax.swing.GroupLayout(PanelCreationCondition);
        PanelCreationCondition.setLayout(PanelCreationConditionLayout);
        PanelCreationConditionLayout.setHorizontalGroup(
            PanelCreationConditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationConditionLayout.createSequentialGroup()
                .addGroup(PanelCreationConditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationConditionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelCreationConditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCreationConditionLayout.createSequentialGroup()
                                .addComponent(PanelCreationConditionHistorique, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82))
                            .addComponent(PanelCreationConditionConsultation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelCreationConditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCreationConditionLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(PanelCreationConditionContexte, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelCreationConditionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PanelCreationConditionProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelCreationConditionLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(LbNomCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtNomCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LbChoixTypeCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CbChoixTypeCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PanelCreationConditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationConditionLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(PanelCreationConditionTraces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 109, Short.MAX_VALUE))
                    .addGroup(PanelCreationConditionLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(PanelCreationConditionCombinaison, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelCreationConditionLayout.setVerticalGroup(
            PanelCreationConditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationConditionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationConditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationConditionLayout.createSequentialGroup()
                        .addGroup(PanelCreationConditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbChoixTypeCondition)
                            .addComponent(CbChoixTypeCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNomCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LbNomCondition))
                        .addGroup(PanelCreationConditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCreationConditionLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(PanelCreationConditionContexte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PanelCreationConditionProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelCreationConditionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PanelCreationConditionHistorique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PanelCreationConditionConsultation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelCreationConditionLayout.createSequentialGroup()
                        .addComponent(PanelCreationConditionCombinaison, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(PanelCreationConditionTraces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelCreationCondition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelCreationCondition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CbChoixTypeConditionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbChoixTypeConditionItemStateChanged
        if (CbChoixTypeCondition.getSelectedIndex() >= 0) {
            PanelCreationConditionProfil.setVisible(false);
            PanelCreationConditionHistorique.setVisible(false);
            PanelCreationConditionContexte.setVisible(false);
            PanelCreationConditionConsultation.setVisible(false);
            PanelCreationConditionCombinaison.setVisible(false);
            PanelCreationConditionTraces.setVisible(false);

            //TxtNomCondition.setText("C" + Main.CreationRegles.idCondition);
            
            if (CbChoixTypeCondition.getSelectedItem().toString().equals(Main.CreationRegles.itemConditionProfil)) 
            {
                if(Main.Cste.structureProfils.isEmpty())
                {
                    if(profilNonDispo)
                    {
                        JOptionPane.showMessageDialog(null, "Non disponible pour ce système d'assistance", "Information", JOptionPane.INFORMATION_MESSAGE);
                        profilNonDispo=false;
                    }
                    else
                        profilNonDispo=true;
                }
                else
                    PanelCreationConditionProfil.setVisible(true);
            } 
            else if (CbChoixTypeCondition.getSelectedItem().toString().equals(Main.CreationRegles.itemConditionHistorique)) 
            {
                PanelCreationConditionHistorique.setVisible(true);
            } 
            else if (CbChoixTypeCondition.getSelectedItem().toString().equals(Main.CreationRegles.itemConditionContexte)) 
            {
                PanelCreationConditionContexte.setVisible(true);
            } 
            else if (CbChoixTypeCondition.getSelectedItem().toString().equals(Main.CreationRegles.itemConditionConsultation)) 
            {
                PanelCreationConditionConsultation.setVisible(true);
            } 
            else if (CbChoixTypeCondition.getSelectedItem().toString().equals(Main.CreationRegles.itemConditionCombinaison)) 
            {
                PanelCreationConditionCombinaison.setVisible(true);
                chargerConditionCombinaison();
            }
            else if (CbChoixTypeCondition.getSelectedItem().toString().equals(Main.CreationRegles.itemConditionTraces)) 
            {
                PanelCreationConditionTraces.setVisible(true);
            }
        }
    }//GEN-LAST:event_CbChoixTypeConditionItemStateChanged

    private void BtAnnulerConditionProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerConditionProfilActionPerformed
        PanelCreationConditionProfil.setVisible(false);
        PanelDefContrainteProfil.setVisible(false);
        CbChoixTypeCondition.setSelectedItem("");
        CbChoixTypeCondition.setEnabled(true);
        Main.CreationRegles.modifConditionProfil = false;
        annuler();
    }//GEN-LAST:event_BtAnnulerConditionProfilActionPerformed

    private void ArbreProfilValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_ArbreProfilValueChanged
        if (!ArbreProfil.isSelectionEmpty()) {
            if (!ArbreProfil.getSelectionPath().toString().equals("[profil]")) {

                TxtElementConditionProfil.setText(ArbreProfil.getSelectionPath().toString().replace("profil, ", ""));

                //on cherche l'échelle de l'élément
                String chemin = ArbreProfil.getSelectionPath().toString().replace("profil, ", "");
                chemin = chemin.substring(1, chemin.length());
                if (chemin.contains(",")) {
                    chemin = chemin.substring(0, chemin.indexOf(","));
                } else {
                    chemin = chemin.substring(0, chemin.length() - 1);
                }

                Element compo = Main.CreationRegles.briqueParNom(Main.Cste.cheminStructuresProfils + Main.Cste.structureProfils, chemin);
                compo = (Element) compo.getChild(Main.CreationRegles.attributInfos_echelle).getChildren().get(0);
                Main.CreationRegles.id_echelle = compo.getAttributeValue(Main.CreationRegles.attributId);
            }
        }
    }//GEN-LAST:event_ArbreProfilValueChanged

    private void BtValiderConditionProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderConditionProfilActionPerformed
        if(!TxtElementConditionProfil.getText().isEmpty())
        {
            int ligne;
            if (!Main.CreationRegles.modifConditionProfil) 
            {
                ligne = Main.CreationRegles.lesConditions.size();
                Main.CreationRegles.modelCondition.addRow(new Object[]{"", "", "", ""});
            } else {
                ligne = Main.CreationRegles.ligneModifCondition;
            }

            Element cond = creerConditionProfil();
            Main.CreationRegles.afficherCondition(cond, ligne);

            if (!Main.CreationRegles.modifConditionProfil) {
                //on incrémente l'identifiant des conditions
                Main.CreationRegles.idCondition++;
                Main.CreationRegles.lesConditions.add(cond);
            } else {
                Element condi = Main.CreationRegles.conditionParId(TxtNomCondition.getText());
                Main.CreationRegles.lesConditions.add(Main.CreationRegles.lesConditions.indexOf(condi), cond);
                Main.CreationRegles.lesConditions.remove(condi);
                Main.CreationRegles.modifConditionProfil = false;
                CbChoixTypeCondition.setEnabled(true);
            }
            TxtNomCondition.setText("C" + Main.CreationRegles.idCondition);

            PanelCreationConditionProfil.setVisible(false);
            PanelDefContrainteProfil.setVisible(false);
            CbChoixTypeCondition.setSelectedItem("");
            CbChoixTypeCondition.setEnabled(true);
            Main.CreationRegles.modifConditionProfil = false;

            valider(cond);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Vous devez sélectionner un élément dans le profil de l'utilisateur", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtValiderConditionProfilActionPerformed

    private void CbQuandContrainteHistoriqueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbQuandContrainteHistoriqueItemStateChanged
        if (CbQuandContrainteHistorique.getSelectedIndex() >= 0) {
            PanelDernierContrainteHistorique.setVisible(CbQuandContrainteHistorique.getSelectedItem().equals(Main.CreationRegles.dernierDeclenchement));
        }
    }//GEN-LAST:event_CbQuandContrainteHistoriqueItemStateChanged

    private void BtAnnulerContrainteHistoriqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerContrainteHistoriqueActionPerformed
        PanelCreationConditionHistorique.setVisible(false);
        CbChoixTypeCondition.setSelectedIndex(-1);
        CbChoixTypeCondition.setEnabled(true);
        Main.CreationRegles.modifConditionHistorique = false;
        annuler();
    }//GEN-LAST:event_BtAnnulerContrainteHistoriqueActionPerformed

    private void BtValiderContrainteHistoriqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderContrainteHistoriqueActionPerformed
        if (CbObjetContrainteHistorique.getSelectedIndex() >= 0) 
        {
            int ligne;
            if (Main.CreationRegles.modifConditionHistorique) 
            {
                ligne = Main.CreationRegles.ligneModifCondition;
            }
            else 
            {
                ligne = Main.CreationRegles.lesConditions.size();
                Main.CreationRegles.modelCondition.addRow(new Object[]{"", "", "", ""});
            }

            Element cond = creerConditionHistorique();
            Main.CreationRegles.afficherCondition(cond, ligne);

            if (Main.CreationRegles.modifConditionHistorique) 
            {
                Element condi = Main.CreationRegles.conditionParId(TxtNomCondition.getText());
                Main.CreationRegles.lesConditions.add(Main.CreationRegles.lesConditions.indexOf(condi), cond);
                Main.CreationRegles.lesConditions.remove(condi);
                Main.CreationRegles.modifConditionHistorique = false;
                CbChoixTypeCondition.setEnabled(true);
            } 
            else 
            {
                Main.CreationRegles.lesConditions.add(cond);
                Main.CreationRegles.idCondition++;
            }

            TxtNomCondition.setText("C" + Main.CreationRegles.idCondition);
            PanelCreationConditionHistorique.setVisible(false);
            CbChoixTypeCondition.setSelectedIndex(-1);
            CbChoixTypeCondition.setEnabled(true);
            
            valider(cond);
        }
    }//GEN-LAST:event_BtValiderContrainteHistoriqueActionPerformed

    private void TxtElementContrainteContexteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtElementContrainteContexteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtElementContrainteContexteActionPerformed

    private void ArbreContrainteContexteValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_ArbreContrainteContexteValueChanged
        if (!ArbreContrainteContexte.isSelectionEmpty()) {
            if (!ArbreContrainteContexte.isRowSelected(0)) {
                String compo = ArbreContrainteContexte.getSelectionPath().getLastPathComponent().toString();
                String id = Main.CreationRegles.noeudGetId(compo);
                TxtElementContrainteContexte.setText(id);
                Element comp = Main.CreationRegles.elementParId(Main.CreationRegles.lesComposants, id);

                if (comp.getAttribute(Main.CreationRegles.attributTypeAjoute) != null) {
                    ChargerCbProprieteContrainteContexte(comp.getAttributeValue(Main.CreationRegles.attributTypeAjoute));
                } else {
                    ChargerCbProprieteContrainteContexte("");
                }
            }
        }
    }//GEN-LAST:event_ArbreContrainteContexteValueChanged

    private void CbProprieteContrainteContexteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbProprieteContrainteContexteItemStateChanged
        if (CbProprieteContrainteContexte.getSelectedIndex() >= 0) {
            TxtTypeContrainteContexte.setText((String) Main.CreationRegles.listeProprietes.get((String) CbProprieteContrainteContexte.getSelectedItem()));
        }
    }//GEN-LAST:event_CbProprieteContrainteContexteItemStateChanged

    private void TxtTypeContrainteContexteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTypeContrainteContexteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtTypeContrainteContexteActionPerformed

    private void BtValiderContrainteContexteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderContrainteContexteActionPerformed
        if (!TxtElementContrainteContexte.getText().isEmpty()) 
        {
            int ligne;
            if (Main.CreationRegles.modifConditionContexte) {
                ligne = Main.CreationRegles.ligneModifCondition;
            } else {
                ligne = Main.CreationRegles.lesConditions.size();
                Main.CreationRegles.modelCondition.addRow(new Object[]{"", "", "", ""});
            }

            Element cond = creerConditionContexte();
            Main.CreationRegles.afficherCondition(cond, ligne);

            if (Main.CreationRegles.modifConditionContexte) {
                Element condi = Main.CreationRegles.conditionParId(TxtNomCondition.getText());
                Main.CreationRegles.lesConditions.add(Main.CreationRegles.lesConditions.indexOf(condi), cond);
                Main.CreationRegles.lesConditions.remove(condi);
                Main.CreationRegles.modifConditionContexte = false;
                CbChoixTypeCondition.setEnabled(true);
            } else {
                Main.CreationRegles.lesConditions.add(cond);
                Main.CreationRegles.idCondition++;
            }

            TxtNomCondition.setText("C" + Main.CreationRegles.idCondition);
            PanelCreationConditionContexte.setVisible(false);
            CbChoixTypeCondition.setSelectedIndex(-1);
            CbChoixTypeCondition.setEnabled(true);
            
            valider(cond);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Vous devez sélectionner un composant", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtValiderContrainteContexteActionPerformed

    private void BtAnnulerContrainteContexteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerContrainteContexteActionPerformed
        PanelCreationConditionContexte.setVisible(false);
        CbChoixTypeCondition.setSelectedIndex(-1);
        CbChoixTypeCondition.setEnabled(true);
        Main.CreationRegles.modifConditionContexte = false;
        annuler();
    }//GEN-LAST:event_BtAnnulerContrainteContexteActionPerformed

    private void BtModifierDescriptionInterfaceContrainteContexteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierDescriptionInterfaceContrainteContexteActionPerformed
        Main.ModificationInterface.chargerInterface();
        Main.ModificationInterface.setVisible(true);
    }//GEN-LAST:event_BtModifierDescriptionInterfaceContrainteContexteActionPerformed

    private void BtAfficherDescriptionInterfaceContrainteContexteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAfficherDescriptionInterfaceContrainteContexteActionPerformed
        Main.CreationRegles.affichageDescription(BtAfficherDescriptionInterfaceContrainteContexte, ArbreContrainteContexte);
    }//GEN-LAST:event_BtAfficherDescriptionInterfaceContrainteContexteActionPerformed

    private void BtCouleurActionInteractiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCouleurActionInteractiveActionPerformed
        BtCouleurActionInteractive.setBackground(JColorChooser.showDialog(this, "Choisir une couleur", BtCouleurActionInteractive.getBackground()));
        this.repaint();
    }//GEN-LAST:event_BtCouleurActionInteractiveActionPerformed

    private void BtPoliceMessageActionInteractiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPoliceMessageActionInteractiveActionPerformed
        Main.ChoixPolice.chargerInterface();
        Main.ChoixPolice.chargerChoix(BtPoliceMessageActionInteractive);
        Main.ChoixPolice.setVisible(true);
    }//GEN-LAST:event_BtPoliceMessageActionInteractiveActionPerformed

    private void BtPoliceBoutonActionInteractiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPoliceBoutonActionInteractiveActionPerformed
        Main.ChoixPolice.chargerInterface();
        Main.ChoixPolice.chargerChoix(BtPoliceBoutonActionInteractive);
        Main.ChoixPolice.setVisible(true);
    }//GEN-LAST:event_BtPoliceBoutonActionInteractiveActionPerformed

    private void BtApercuActionInteractiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtApercuActionInteractiveActionPerformed
        if (TxtMessageActionInteractive.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vous devez saisir le contenu du message", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            XMLFonctions.creerXML(creerConditionConsultation(true));
            XMLFonctions.enregistre("Action.xml", "");
            try {
                Runtime.getRuntime().exec("java -jar " + Main.Cste.jarMessagerInteractif);
            } catch (IOException ex) {
                Logger.getLogger(ApercuMiseEnValeur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BtApercuActionInteractiveActionPerformed

    private void BtValiderActionInteractiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderActionInteractiveActionPerformed
        if (TxtMessageActionInteractive.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "Vous devez saisir le contenu du message", "Information", JOptionPane.INFORMATION_MESSAGE);
        } 
        else 
        {
            int ligne;
            if (Main.CreationRegles.modifConditionConsultation) 
            {
                ligne = Main.CreationRegles.ligneModifCondition;
                System.out.println("on modifie");
            } 
            else 
            {
                ligne = Main.CreationRegles.lesConditions.size();
                Main.CreationRegles.modelCondition.addRow(new Object[]{"", "", "", ""});
            }

            Element cond = creerConditionConsultation(false);
            Main.CreationRegles.afficherCondition(cond, ligne);

            if (Main.CreationRegles.modifConditionConsultation) {
                Element condi = Main.CreationRegles.conditionParId(TxtNomCondition.getText());
                Main.CreationRegles.lesConditions.add(Main.CreationRegles.lesConditions.indexOf(condi), cond);
                Main.CreationRegles.lesConditions.remove(condi);
                Main.CreationRegles.modifConditionConsultation = false;
                CbChoixTypeCondition.setEnabled(true);
            } else {
                Main.CreationRegles.lesConditions.add(cond);
                Main.CreationRegles.idCondition++;
            }

            PanelCreationConditionConsultation.setVisible(false);
            CbChoixTypeCondition.setSelectedIndex(-1);
            CbChoixTypeCondition.setEnabled(true);
            
            valider(cond);
            resetConditionConsultation();
        }
    }//GEN-LAST:event_BtValiderActionInteractiveActionPerformed

    private void BtAnnulerActionInteractiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerActionInteractiveActionPerformed
        PanelCreationConditionConsultation.setVisible(false);
        CbChoixTypeCondition.setSelectedIndex(-1);
        CbChoixTypeCondition.setEnabled(true);
        Main.CreationRegles.modifConditionConsultation = false;
        annuler();
    }//GEN-LAST:event_BtAnnulerActionInteractiveActionPerformed

    private void BtAjoutBoutonActionInteractiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAjoutBoutonActionInteractiveActionPerformed
        AjoutBoutonConditionConsultation();
    }//GEN-LAST:event_BtAjoutBoutonActionInteractiveActionPerformed

    private void BtSupprimerBoutonConditionConsultationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSupprimerBoutonConditionConsultationActionPerformed
        SupprimerBoutonConditionConsultation();
    }//GEN-LAST:event_BtSupprimerBoutonConditionConsultationActionPerformed

    private void BtValiderConditionCombinaisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderConditionCombinaisonActionPerformed
        if (Main.CreationRegles.verifierFormule(TxtFormuleConditionCombinaison.getText())) 
        {
            int ligne;
            if (!Main.CreationRegles.modifConditionCombinaison) {
                ligne = Main.CreationRegles.lesConditions.size();
                Main.CreationRegles.modelCondition.addRow(new Object[]{"", "", "", ""});
            } else {
                ligne = Main.CreationRegles.ligneModifCondition;
            }

            Element cond = creerConditionCombinaison();
            Main.CreationRegles.afficherCondition(cond, ligne);

            if (!Main.CreationRegles.modifConditionCombinaison) {
                //on incrémente l'identifiant des conditions
                Main.CreationRegles.idCondition++;
                Main.CreationRegles.lesConditions.add(cond);
            } else {
                Element condi = Main.CreationRegles.conditionParId(TxtNomCondition.getText());
                Main.CreationRegles.lesConditions.add(Main.CreationRegles.lesConditions.indexOf(condi), cond);
                Main.CreationRegles.lesConditions.remove(condi);
                Main.CreationRegles.modifConditionProfil = false;
                CbChoixTypeCondition.setEnabled(true);
            }
            TxtNomCondition.setText("C" + Main.CreationRegles.idCondition);

            PanelCreationConditionCombinaison.setVisible(false);
            PanelDefContrainteProfil.setVisible(false);
            CbChoixTypeCondition.setSelectedItem("");
            CbChoixTypeCondition.setEnabled(true);
            Main.CreationRegles.modifConditionCombinaison = false;
            resetConditionCombinaison();
            
            valider(cond);
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "La formule n'est pas valide", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtValiderConditionCombinaisonActionPerformed

    private void BtEtConditionCombinaisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEtConditionCombinaisonActionPerformed
        TxtFormuleConditionCombinaison.setText(TxtFormuleConditionCombinaison.getText() + "||");
        //on ne peut plus ajouter tout de suite un autre outil
        BtEtConditionCombinaison.setEnabled(false);
        BtOuConditionCombinaison.setEnabled(false);
        BtOuvreConditionCombinaison.setEnabled(true);
        BtFermeConditionCombinaison.setEnabled(false);
        BtNonConditionCombinaison.setEnabled(true);

        //mais on peut utiliser une condition
        setEnableBoutonConditionCombinaison(true);
    }//GEN-LAST:event_BtEtConditionCombinaisonActionPerformed

    private void BtOuConditionCombinaisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtOuConditionCombinaisonActionPerformed
        TxtFormuleConditionCombinaison.setText(TxtFormuleConditionCombinaison.getText() + "||");
        //on ne peut plus ajouter tout de suite un autre outil
        BtEtConditionCombinaison.setEnabled(false);
        BtOuConditionCombinaison.setEnabled(false);
        BtOuvreConditionCombinaison.setEnabled(true);
        BtFermeConditionCombinaison.setEnabled(false);
        BtNonConditionCombinaison.setEnabled(true);

        //mais on peut utiliser une condition
        setEnableBoutonConditionCombinaison(true);
    }//GEN-LAST:event_BtOuConditionCombinaisonActionPerformed

    private void BtOuvreConditionCombinaisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtOuvreConditionCombinaisonActionPerformed
        TxtFormuleConditionCombinaison.setText(TxtFormuleConditionCombinaison.getText() + "(");
        Main.CreationRegles.parentheseOuverte++;
        if (Main.CreationRegles.parentheseOuverte > 0) {
            BtFermeConditionCombinaison.setEnabled(true);
        }
    }//GEN-LAST:event_BtOuvreConditionCombinaisonActionPerformed

    private void BtFermeConditionCombinaisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtFermeConditionCombinaisonActionPerformed
        TxtFormuleConditionCombinaison.setText(TxtFormuleConditionCombinaison.getText() + ")");
        Main.CreationRegles.parentheseOuverte--;
        BtFermeConditionCombinaison.setEnabled(Main.CreationRegles.parentheseOuverte > 0);
    }//GEN-LAST:event_BtFermeConditionCombinaisonActionPerformed

    private void BtNonConditionCombinaisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtNonConditionCombinaisonActionPerformed
        TxtFormuleConditionCombinaison.setText(TxtFormuleConditionCombinaison.getText() + "!");
        //on ne peut plus ajouter tout de suite un autre outil
        BtEtConditionCombinaison.setEnabled(false);
        BtOuConditionCombinaison.setEnabled(false);
        BtOuvreConditionCombinaison.setEnabled(true);
        BtFermeConditionCombinaison.setEnabled(false);
        BtNonConditionCombinaison.setEnabled(true);

        //mais on peut utiliser une condition
        setEnableBoutonConditionCombinaison(true);
    }//GEN-LAST:event_BtNonConditionCombinaisonActionPerformed

    private void BtAnnulerConditionCombinaisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerConditionCombinaisonActionPerformed
        PanelCreationConditionCombinaison.setVisible(false);
        PanelDefContrainteProfil.setVisible(false);
        CbChoixTypeCondition.setSelectedItem("");
        CbChoixTypeCondition.setEnabled(true);
        Main.CreationRegles.modifConditionCombinaison = false;
        resetConditionCombinaison();
        annuler();
    }//GEN-LAST:event_BtAnnulerConditionCombinaisonActionPerformed

    private void BtValiderConditionTracesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderConditionTracesActionPerformed
        if (CbObjetContrainteTraces.getSelectedIndex() >= 0) 
        {
            int ligne;
            if (Main.CreationRegles.modifConditionTraces) {
                ligne = Main.CreationRegles.ligneModifCondition;
            } else {
                ligne = Main.CreationRegles.lesConditions.size();
                Main.CreationRegles.modelCondition.addRow(new Object[]{"", "", "", ""});
            }

            Element cond = creerConditionTraces();
            Main.CreationRegles.afficherCondition(cond, ligne);

            if (Main.CreationRegles.modifConditionTraces) {
                Element condi = Main.CreationRegles.conditionParId(TxtNomCondition.getText());
                Main.CreationRegles.lesConditions.add(Main.CreationRegles.lesConditions.indexOf(condi), cond);
                Main.CreationRegles.lesConditions.remove(condi);
                Main.CreationRegles.modifConditionTraces = false;
                CbChoixTypeCondition.setEnabled(true);
            } else {
                Main.CreationRegles.lesConditions.add(cond);
                Main.CreationRegles.idCondition++;
            }

            TxtNomCondition.setText("C" + Main.CreationRegles.idCondition);
            PanelCreationConditionTraces.setVisible(false);
            CbChoixTypeCondition.setSelectedIndex(-1);
            CbChoixTypeCondition.setEnabled(true);
            
            valider(cond);
        }
    }//GEN-LAST:event_BtValiderConditionTracesActionPerformed

    private void BtAnnulerConditionTracesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerConditionTracesActionPerformed
        PanelCreationConditionTraces.setVisible(false);
        Main.CreationRegles.modifConditionTraces = false;
        annuler();
    }//GEN-LAST:event_BtAnnulerConditionTracesActionPerformed

    private void CbQuandContrainteTracesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbQuandContrainteTracesItemStateChanged
        if (CbQuandContrainteTraces.getSelectedIndex() >= 0) {
            PanelDernierContrainteTraces.setVisible(CbQuandContrainteTraces.getSelectedItem().equals(Main.CreationRegles.dureeTotaleConditionTraces) 
                    || CbQuandContrainteTraces.getSelectedItem().equals(Main.CreationRegles.dureeDepuisConditionTraces));
        }
    }//GEN-LAST:event_CbQuandContrainteTracesItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        annuler();
    }//GEN-LAST:event_formWindowClosing

    private void CbObjetContrainteHistoriqueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbObjetContrainteHistoriqueItemStateChanged
        if(CbObjetContrainteHistorique.getSelectedIndex()>0)
        {
            PanelHistoriqueTemps.setVisible(!CbObjetContrainteHistorique.getSelectedItem().toString().startsWith("C"));               
        }
    }//GEN-LAST:event_CbObjetContrainteHistoriqueItemStateChanged

    private void BtAfficherDetailsActionInteractiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAfficherDetailsActionInteractiveActionPerformed
        afficherDetailsConsultation(Main.CreationRegles.afficherDetailsConsultation);
    }//GEN-LAST:event_BtAfficherDetailsActionInteractiveActionPerformed

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
            java.util.logging.Logger.getLogger(CreationConditions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreationConditions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreationConditions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreationConditions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CreationConditions().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree ArbreContrainteContexte;
    private javax.swing.JTree ArbreProfil;
    private javax.swing.JButton BtAfficherDescriptionInterfaceContrainteContexte;
    private javax.swing.JButton BtAfficherDetailsActionInteractive;
    private javax.swing.JButton BtAjoutBoutonActionInteractive;
    private javax.swing.JButton BtAnnulerActionInteractive;
    private javax.swing.JButton BtAnnulerConditionCombinaison;
    private javax.swing.JButton BtAnnulerConditionProfil;
    private javax.swing.JButton BtAnnulerConditionTraces;
    private javax.swing.JButton BtAnnulerContrainteContexte;
    private javax.swing.JButton BtAnnulerContrainteHistorique;
    private javax.swing.JButton BtApercuActionInteractive;
    private javax.swing.JButton BtCouleurActionInteractive;
    private javax.swing.JButton BtEtConditionCombinaison;
    private javax.swing.JButton BtFermeConditionCombinaison;
    private javax.swing.JButton BtInclureConditionConsultation;
    private javax.swing.JButton BtModifierDescriptionInterfaceContrainteContexte;
    private javax.swing.JButton BtNonConditionCombinaison;
    private javax.swing.JButton BtOuConditionCombinaison;
    private javax.swing.JButton BtOuvreConditionCombinaison;
    private javax.swing.JButton BtPoliceBoutonActionInteractive;
    private javax.swing.JButton BtPoliceMessageActionInteractive;
    private javax.swing.JButton BtSupprimerBoutonConditionConsultation;
    private javax.swing.JButton BtValiderActionInteractive;
    private javax.swing.JButton BtValiderConditionCombinaison;
    private javax.swing.JButton BtValiderConditionProfil;
    private javax.swing.JButton BtValiderConditionTraces;
    private javax.swing.JButton BtValiderContrainteContexte;
    private javax.swing.JButton BtValiderContrainteHistorique;
    private javax.swing.JComboBox CbChoixTypeCondition;
    private javax.swing.JComboBox CbDepuisContrainteHistorique;
    private javax.swing.JComboBox CbDepuisContrainteTraces;
    private javax.swing.JComboBox CbModeActionInteractive;
    private javax.swing.JComboBox CbObjetContrainteHistorique;
    private javax.swing.JComboBox CbObjetContrainteTraces;
    private javax.swing.JComboBox CbPersoConditionConsultation;
    private javax.swing.JComboBox CbProprieteContrainteContexte;
    private javax.swing.JComboBox CbQuandContrainteHistorique;
    private javax.swing.JComboBox CbQuandContrainteTraces;
    private javax.swing.ButtonGroup GroupContrainteHistorique;
    private javax.swing.JLabel LbAjoutActionInteractive;
    private javax.swing.JLabel LbBoutonActionInteractive;
    private javax.swing.JLabel LbChoixTypeCondition;
    private javax.swing.JLabel LbConditionsConditionCombinaison1;
    private javax.swing.JLabel LbCouleurActionInteractive;
    private javax.swing.JLabel LbDepuisContrainteHistorique;
    private javax.swing.JLabel LbDepuisContrainteTraces;
    private javax.swing.JLabel LbElementConditionProfil;
    private javax.swing.JLabel LbElementContrainteContexte;
    private javax.swing.JLabel LbFormuleConditionCombinaison;
    private javax.swing.JLabel LbMessageActionInteractive;
    private javax.swing.JLabel LbModeActionInteractive;
    private javax.swing.JLabel LbNomCondition;
    private javax.swing.JLabel LbObjetContrainteHistorique;
    private javax.swing.JLabel LbObjetContrainteTraces;
    private javax.swing.JLabel LbOperateursConditionCombinaison;
    private javax.swing.JLabel LbPoliceBoutonActionInteractive;
    private javax.swing.JLabel LbPoliceMessageActionInteractive;
    private javax.swing.JLabel LbProprieteContrainteContexte;
    private javax.swing.JLabel LbTitreActionInteractive;
    private javax.swing.JLabel LbTypeContrainteContexte;
    private javax.swing.JPanel PanelBoutonsActionInteractive;
    private javax.swing.JPanel PanelBoutonsConditionCombinaison;
    private javax.swing.JPanel PanelCreationCondition;
    private javax.swing.JPanel PanelCreationConditionCombinaison;
    private javax.swing.JPanel PanelCreationConditionConsultation;
    private javax.swing.JPanel PanelCreationConditionContexte;
    private javax.swing.JPanel PanelCreationConditionHistorique;
    private javax.swing.JPanel PanelCreationConditionProfil;
    private javax.swing.JPanel PanelCreationConditionTraces;
    private javax.swing.JPanel PanelDefContrainteProfil;
    private javax.swing.JPanel PanelDernierContrainteHistorique;
    private javax.swing.JPanel PanelDernierContrainteTraces;
    private javax.swing.JPanel PanelDetailsConsultation;
    private javax.swing.JPanel PanelHistoriqueTemps;
    private javax.swing.JRadioButton RbGlobalementContrainteHistorique;
    private javax.swing.JRadioButton RbGlobalementContrainteTraces;
    private javax.swing.JRadioButton RbSeanceContrainteHistorique;
    private javax.swing.JRadioButton RbSeanceContrainteTraces;
    private javax.swing.JScrollPane ScrollArbreContrainteContexte;
    private javax.swing.JScrollPane ScrollArbreProfil;
    private javax.swing.JScrollPane ScrollBoutonsActionInteractive;
    private javax.swing.JScrollPane ScrollBoutonsConditionCombinaison;
    private javax.swing.JScrollPane ScrollMessageActionInteractive;
    private javax.swing.JTextField TxtElementConditionProfil;
    private javax.swing.JTextField TxtElementContrainteContexte;
    private javax.swing.JTextField TxtFormuleConditionCombinaison;
    private javax.swing.JTextArea TxtMessageActionInteractive;
    private javax.swing.JTextField TxtNomCondition;
    private javax.swing.JTextField TxtTitreActionInteractive;
    private javax.swing.JTextField TxtTypeContrainteContexte;
    // End of variables declaration//GEN-END:variables
}
