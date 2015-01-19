/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import net.atlanticbb.tantlinger.shef.HTMLEditorPane;
import org.jdom.Element;

/**
 *
 * @author Blandine
 */
public class CreationActions extends javax.swing.JFrame {

    public ListeSousActions listeSousActions;
    public JComboBox CB=null;
    public Element elementMiseEnValeurEtape;
    public String[] choixMessagesAvantEtapePasaPas;
    public String[] choixMessagesApresEtapePasaPas;
    public String[] choixMessagesAvantEtapePresentationGuidee;
    
    public String TitreMessageEtapes="Information";
    public String MessageAvantEtapesPasAPas="on va faire un pas à pas.";
    public String MessageAvantEtapesPresentationGuidee="on va faire une présentation guidée.";
    public String MessageAvantEtapesDemande="etes-vous d'accord pour commencer ?";
    public String MessageAvantEtapesDemandeOui="commencer";
    public String MessageAvantEtapesDemandeNon="quitter";
    public Font policeMessageEtape=new Font("Calibri", Font.PLAIN, 36);
    public Font policeOptionsEtape=new Font("Calibri", Font.PLAIN, 20);
    public Color couleurPoliceMessageEtape=Color.black;
    public Color couleurFondMessageEtape=Color.white;
    public String MessageApresPasaPas="Le pas à pas est maintenant terminé.";
    public String MessageApresPresentationGuidee="La présentation guidée est maintenant terminée.";
    public String MessageApresEtapeDemandeOk="continuer";
    public String MessageAvantEtapePasaPas="Nous allons maintenant";
    public String MessageAvantEtapePresentationGuidee="Voici";
    public String MessageApresEtapePasaPas="Nous avons terminé l'étape";
    public String MessageApresEtapeOk="continuer";
    public String MessageAvantEtapeDemande="etes-vous d'accord ?";
    public String MessageAvantEtapeDemandeOui="continuer";
    public String MessageAvantEtapeDemandeNon="quitter";
    /**
     * Creates new form CreationsActions
     */
    public CreationActions() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(200, 100, 690, 655);
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/icone_editeur.png"));
        this.setIconImage(icon);
        this.setTitle("Editeur d'assistance - définition d'une action d'assistance");
        
        ToolTipManager.sharedInstance().registerComponent(ArbreActionInterface);
        ToolTipManager.sharedInstance().registerComponent(ArbreActionMiseEnValeur);
        
        //____________________________________________________ creation d'une action d'assistance ______________________________________________________________
        PanelCreationAction.setBounds(0, 0, 675, 610);
        PanelCreationAction.setLayout(null);
        LbNomAction.setBounds(15, 5, 150, 24);
        TxtNomAction.setBounds(155, 5, 60, 24);
        LbChoixTypeAction.setBounds(315, 5, 100, 24);
        CbChoixTypeAction.setBounds(425, 5, 230, 24);
        
        //____________________________________________________ Action Présenation guidée ______________________________________________________________        
        PanelCreationActionPresentationGuidee.setBounds(5, 30, 650, 578);
        PanelCreationActionPresentationGuidee.setLayout(null);
        LbEtapesActionPresentationGuidee.setBounds(10, 5, 170, 24);
        CbEtapesActionPresentationGuidee.setBounds(190, 5, 150, 24);
        BtModifierEtapesActionPresentationGuidee.setBounds(360, 5, 90, 24);
        BtCreerEtapesActionPresentationGuidee.setBounds(460, 5, 90, 24);
        
        ScrollListeActionPresentationGuidee.setBounds(10, 35, 640, 130);
        LbOptionActionPresentationGuidee.setBounds(10, 170, 250, 24);
        CheckMessageAvantActionPresentationGuidee.setBounds(10, 195, 380, 24);
        CheckMessageAvantAutorisationActionPresentationGuidee.setBounds(390, 195, 300, 24);
        CheckMessageApresActionPresentationGuidee.setBounds(10, 220, 380, 24);
        
        LbOptionEtapesActionPresentationGuidee.setBounds(10, 275, 300, 24);
        PanelAutomatiserActionPresentationGuidee.setBounds(10, 300, 640, 75);
        PanelAutomatiserActionPresentationGuidee.setLayout(null);
        CheckExpliquerEtapeActionPresentationGuidee.setBounds(0, 0, 270, 24);
        CheckExpliquerEtapeAutorisationActionPresentationGuidee.setBounds(270, 0, 440, 24);
        CheckTimerActionPresentationGuidee.setBounds(0, 30, 210, 24);
        SpinTimerActionPresentationGuidee.setBounds(210, 30, 60, 24);
        LbSecondesActionPresentationGuidee.setBounds(280, 30, 60, 24);
        
        BtPersonnaliserMessagesPresentationGuidee.setBounds(115, 500, 185, 30);
        BtMiseEnValeurPresentationGuidee.setBounds(315, 500, 185, 30);
        BtValiderActionPresentationGuidee.setBounds(120, PanelCreationActionPresentationGuidee.getHeight()-35, 120, 30);
        BtApercuActionPresentationGuidee.setBounds(250, PanelCreationActionPresentationGuidee.getHeight()-35, 120, 30);
        BtAnnulerActionPresentationGuidee.setBounds(380, PanelCreationActionPresentationGuidee.getHeight()-35, 120, 30);
        
        //____________________________________________________ Action Pas à Pas ______________________________________________________________        
        PanelCreationActionPasaPas.setBounds(5, 30, 650, 578);
        PanelCreationActionPasaPas.setLayout(null);
        LbTypeActionPasaPas.setBounds(10, 5, 150, 24);
        CbTypeActionPasaPas.setBounds(150, 5, 160, 24);
        LbEtapesActionPasaPas.setBounds(20, 35, 170, 24);
        CbEtapesActionPasaPas.setBounds(190, 35, 150, 24);
        BtModifierEtapesActionPasaPas.setBounds(360, 35, 90, 24);
        BtCreerEtapesActionPasaPas.setBounds(460, 35, 90, 24);
        
        ScrollListeActionPasaPas.setBounds(10, 65, 640, 130);
        LbOptionActionPasaPas.setBounds(10, 200, 250, 24);
        CheckMessageAvantActionPasaPas.setBounds(10, 225, 300, 24);
        CheckMessageAvantAutorisationActionPasaPas.setBounds(350, 225, 300, 24);
        CheckMessageApresActionPasaPas.setBounds(10, 250, 300, 24);
        CheckMessageApresBilanActionPasaPas.setBounds(350, 250, 300, 24);       
        CheckProgressionActionPasaPas.setBounds(10, 275, 300, 24);
        
        LbOptionEtapesActionPasaPas.setBounds(10, 305, 300, 24);
        CheckMiseEnValeurActionPasaPas.setBounds(10, 330, 300, 24);
        PanelGuiderActionPasaPas.setBounds(10, 355, 600, 24);
        PanelGuiderActionPasaPas.setLayout(null);
        CheckInterventionActionPasaPas.setBounds(0, 0, 300, 24);
        PanelAutomatiserActionPasaPas.setBounds(10, 355, 600, 75);
        PanelAutomatiserActionPasaPas.setLayout(null);
        CheckExpliquerEtapeActionPasaPas.setBounds(0, 0, 300, 24);
        CheckExpliquerEtapeAutorisationActionPasaPas.setBounds(340, 0, 300, 24);
        
        CheckExpliquerEtapeTermineeActionPasaPas.setBounds(0, 25, 300, 24);
        CheckTimerActionPasaPas.setBounds(0, 50, 210, 24);
        SpinTimerActionPasaPas.setBounds(210, 50, 60, 24);
        LbSecondesActionPasaPas.setBounds(280, 50, 60, 24);
        
        BtPersonnaliserMessagesPasAPas.setBounds(115, 500, 185, 30);
        BtMiseEnValeurPasAPas.setBounds(315, 500, 185, 30);
        BtValiderActionPasaPas.setBounds(120, PanelCreationActionPasaPas.getHeight()-35, 120, 30);
        BtApercuActionPasaPas.setBounds(250, PanelCreationActionPasaPas.getHeight()-35, 120, 30);
        BtAnnulerActionPasaPas.setBounds(380, PanelCreationActionPasaPas.getHeight()-35, 120, 30); 
        
        //______________________________________________________________ Action de proposition d'une ressource externe______________________________________________________       
        PanelCreationActionRessource.setBounds(5, 30, 650, 578);
        PanelCreationActionRessource.setLayout(null);
        LbTypeActionRessource.setBounds(10, 5, 150, 24);
        CbTypeActionRessource.setBounds(150, 5, 160, 24);
        LbCheminActionRessource.setBounds(10, 35, 150, 24);
        TxtCheminActionRessource.setBounds(150, 35, 395, 24);
        BtCheminActionRessource.setBounds(550, 35, 100, 24);
        
        
        BtValiderActionRessource.setBounds(120, PanelCreationActionRessource.getHeight()-35, 120, 30);
        BtApercuActionRessource.setBounds(250, PanelCreationActionRessource.getHeight()-35, 120, 30);
        BtAnnulerActionRessource.setBounds(380, PanelCreationActionRessource.getHeight()-35, 120, 30);
        
        //______________________________________________________________ Action sur l'interface______________________________________________________       
        PanelCreationActionInterface.setBounds(5, 30, 660, 578);
        PanelCreationActionInterface.setLayout(null);
        ScrollArbreActionInterface.setBounds(5, 35, 620, 320); 
        ArbreActionInterface.setBounds(0, 0, ScrollArbreActionInterface.getWidth(), ScrollArbreActionInterface.getHeight());        
        BtModifierDescriptionInterfaceActionInterface.setBounds(630, 170, 30, 24);
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/modifierPetite.png"));
        BtModifierDescriptionInterfaceActionInterface.setIcon(new ImageIcon(icon));
        BtModifierDescriptionInterfaceActionInterface.setText("");
        BtAfficherDescriptionInterfaceActionInterface.setBounds(630, 200, 30, 24);
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
        BtAfficherDescriptionInterfaceActionInterface.setIcon(new ImageIcon(icon));
        BtAfficherDescriptionInterfaceActionInterface.setText("");      
        LbActionActionInterface.setBounds(10, 360, 200, 24);
        CbActionActionInterface.setBounds(220, 360, 200, 24);     
        PanelEtatActionInterface.setBounds(10, 400, 450, 50);
        PanelEtatActionInterface.setLayout(null);       
        LbEtatActionInterface.setBounds(0, 0, 200, 24);
        RbOnActionInterface.setBounds(110, 0, 100, 24);       
        RbOffActionInterface.setBounds(220, 0, 100, 24);        
        PanelValeurActionInterface.setBounds(10, 400, 450, 50);
        PanelValeurActionInterface.setLayout(null);       
        LbValeurActionInterface.setBounds(0, 0, 200, 24);
        TxtValeurActionInterface.setBounds(110, 0, 300, 24);
 
        BtValiderActionInterface.setBounds(120, PanelCreationActionInterface.getHeight()-35, 120, 30);
        BtApercuActionInterface.setBounds(250, PanelCreationActionInterface.getHeight()-35, 120, 30);
        BtAnnulerActionInterface.setBounds(380, PanelCreationActionInterface.getHeight()-35, 120, 30);
        
        
        //____________________________________________________Action ajout composant______________________________________________________________        
        PanelCreationActionAjoutComposant.setBounds(5, 30, 660, 578);
        PanelCreationActionAjoutComposant.setLayout(null);
        LbIdActionAjoutComposant.setBounds(10, 5, 150, 24);
        TxtIdActionAjoutComposant.setBounds(150, 5, 60, 24);
        
        ScrollArbreActionAjoutComposant.setBounds(5, 35, 620, 230); 
        ArbreActionAjoutComposant.setBounds(0, 0, ArbreActionAjoutComposant.getWidth(), ArbreActionAjoutComposant.getHeight());
        BtModifierDescriptionInterfaceActionAjoutComposant.setBounds(630, 170, 30, 24);
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/modifierPetite.png"));
        BtModifierDescriptionInterfaceActionAjoutComposant.setIcon(new ImageIcon(icon));
        BtModifierDescriptionInterfaceActionAjoutComposant.setText("");
        BtAfficherDescriptionInterfaceActionAjoutComposant.setBounds(630, 200, 30, 24);
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
        BtAfficherDescriptionInterfaceActionAjoutComposant.setIcon(new ImageIcon(icon));
        BtAfficherDescriptionInterfaceActionAjoutComposant.setText("");
        
        LbTypeActionAjoutComposant.setBounds(10, 270, 190, 24);
        CbTypeActionAjoutComposant.setBounds(200, 270, 120, 24);
        BtAfficherDetailsActionAjoutComposant.setBounds(350, 270, 30, 24);
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
        BtAfficherDetailsActionAjoutComposant.setIcon(new ImageIcon(icon));
        BtAfficherDetailsActionAjoutComposant.setText("");
        
        PanelBoutonActionAjoutComposant.setBounds(10, 295, 650, 100);
        PanelBoutonActionAjoutComposant.setLayout(null);
        CheckTexteBoutonActionAjoutComposant.setBounds(0, 10, 120, 24);
        TxtTexteBoutonActionAjoutComposant.setBounds(120, 10, 100, 24);
        CheckInfoBulleBoutonActionAjoutComposant.setBounds(260, 10, 140, 24);
        TxtInfoBulleBoutonActionAjoutComposant.setBounds(400, 10, 240, 24);       
        CheckIconeBoutonActionAjoutComposant.setBounds(0, 40, 120, 60);
        BtIconeBoutonActionAjoutComposant.setBounds(120, 40, 60, 60);
        BtIconeBoutonActionAjoutComposant.setText("");
        
        PanelLabelActionAjoutComposant.setBounds(10, 295, 600, 100);
        PanelLabelActionAjoutComposant.setLayout(null);
        PanelLabelActionAjoutComposant.setBounds(10, 295, 650, 100);
        PanelLabelActionAjoutComposant.setLayout(null);
        LbTexteLabelActionAjoutComposant.setBounds(0, 10, 120, 24);
        TxtTexteLabelActionAjoutComposant.setBounds(120, 10, 100, 24);       
        CheckIconeLabelActionAjoutComposant.setBounds(0, 40, 120, 60);
        BtIconeLabelActionAjoutComposant.setBounds(120, 40, 60, 60);
        BtIconeLabelActionAjoutComposant.setText("");
        
        PanelImageActionAjoutComposant.setBounds(10, 295, 600, 100);
        PanelImageActionAjoutComposant.setLayout(null);
        LbIconeImageActionAjoutComposant.setBounds(0, 10, 120, 24);
        BtIconeImageActionAjoutComposant.setBounds(120, 10, 60, 60);
        BtIconeImageActionAjoutComposant.setText("");
        
        PanelDetailsActionAjoutComposant.setBounds(5, 400, 650, 140);
        PanelDetailsActionAjoutComposant.setLayout(null);
        LbDirectionActionAjoutComposant.setBounds(10, 15, 80, 24);
        CbDirectionActionAjoutComposant.setBounds(80, 15, 160, 24);
        LbLargeurActionAjoutComposant.setBounds(10, 45, 70, 24);
        SpinLargeurActionAjoutComposant.setBounds(80, 45, 80, 24);
        LbHauteurActionAjoutComposant.setBounds(200, 45, 70, 24);
        SpinHauteurActionAjoutComposant.setBounds(270, 45, 80, 24);
        
        PanelPoliceActionAjoutComposant.setBounds(10, 75, 200, 50);
        PanelPoliceActionAjoutComposant.setLayout(null);
        LbPoliceActionAjoutComposant.setBounds(0, 10, 70, 30);
        BtPoliceActionAjoutComposant.setBounds(70, 10, 70, 30);
        
        BtValiderActionAjoutComposant.setBounds(120, PanelCreationActionAjoutComposant.getHeight()-35, 120, 30);
        BtApercuActionAjoutComposant.setBounds(250, PanelCreationActionAjoutComposant.getHeight()-35, 120, 30);
        BtAnnulerActionAjoutComposant.setBounds(380, PanelCreationActionAjoutComposant.getHeight()-35, 120, 30);
        
        
        //____________________________________________________Action Mise en valeur & masquage______________________________________________________________        
        PanelCreationActionMiseEnValeur.setBounds(5, 30, 660, 578);
        PanelCreationActionMiseEnValeur.setLayout(null);
        LbIdActionMiseEnValeur.setBounds(10, 5, 150, 24);
        TxtIdActionMiseEnValeur.setBounds(150, 5, 60, 24);
        
        ScrollArbreActionMiseEnValeur.setBounds(5, 35, 620, 260); 
        ArbreActionMiseEnValeur.setBounds(0, 0, ArbreActionMiseEnValeur.getWidth(), ArbreActionMiseEnValeur.getHeight());
        BtModifierDescriptionInterfaceActionMiseEnValeur.setBounds(630, 170, 30, 24);
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/modifierPetite.png"));
        BtModifierDescriptionInterfaceActionMiseEnValeur.setIcon(new ImageIcon(icon));
        BtModifierDescriptionInterfaceActionMiseEnValeur.setText("");
        BtAfficherDescriptionInterfaceActionMiseEnValeur.setBounds(630, 200, 30, 24);
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
        BtAfficherDescriptionInterfaceActionMiseEnValeur.setIcon(new ImageIcon(icon));
        BtAfficherDescriptionInterfaceActionMiseEnValeur.setText("");
        
        //_________________________________masquage_____________________________________________
        PanelActionMasquage.setBounds(0, 300, 650, 210);
        PanelActionMasquage.setLayout(null);
        LbTypeActionMasquage.setBounds(10, 0, 150, 24);
        CbTypeActionMasquage.setBounds(200, 0, 120, 24);
        BtAfficherDetailsActionMasquage.setBounds(330, 0, 30, 24);
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
        BtAfficherDetailsActionMasquage.setIcon(new ImageIcon(icon));
        BtAfficherDetailsActionMasquage.setText("");
        PanelEstomperActionMasquage.setBounds(10, 30, 640, 180);
        PanelEstomperActionMasquage.setLayout(null);
        LbCouleurActionMasquage.setBounds(10, 20, 150, 24);
        RbChoixCouleurActionMasquage.setBounds(155, 20, 60, 24);
        BtCouleurActionMasquage.setBounds(220, 20, 40, 24);
        RbCouelruPereActionMasquage.setBounds(280, 20, 180, 24);
        
        PanelTransparenceActionMasquage.setBounds(10, 50, 280, 24);
        PanelTransparenceActionMasquage.setLayout(null);
        LbTransparenceActionMasquage.setBounds(0, 0, 180, 24);
        SpinTransparenceActionMasquage.setBounds(150, 0, 45, 24);
        
        //_________________________________mise en valeur_______________________________________
        PanelActionMiseEnValeur.setBounds(0, 300, 650, 240);
        PanelActionMiseEnValeur.setLayout(null);
        LbTypeActionMiseEnValeur.setBounds(10, 0, 150, 24);
        CbTypeActionMiseEnValeur.setBounds(200, 0, 120, 24);
        BtAfficherDetailsActionMiseEnValeur.setBounds(350, 0, 30, 24);
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
        BtAfficherDetailsActionMiseEnValeur.setIcon(new ImageIcon(icon));
        BtAfficherDetailsActionMiseEnValeur.setText("");
        BtAfficherDetailsActionMiseEnValeur.setVisible(false);
        
        PanelColorerActionMiseEnValeur.setBounds(10, 30, 640, 210);
        PanelColorerActionMiseEnValeur.setLayout(null);
        LbCouleurActionMiseEnValeur.setBounds(10, 20, 150, 24);
        BtCouleurActionMiseEnValeur.setBounds(160, 20, 40, 24);
        LbTransparenceActionMiseEnValeur.setBounds(10, 50, 150, 24);
        SpinTransparenceActionMiseEnValeur.setBounds(160, 50, 45, 24);
        CheckDureeActionMiseEnValeurColorer.setBounds(10, 170, 150, 24);
        SpinDureeActionMiseEnValeurColorer.setBounds(160, 170, 45, 24);
        LbUniteActionMiseEnValeurColorer.setBounds(210, 170, 70, 24);
        
        PanelEntourerActionMiseEnValeur.setBounds(10, 30, 640, 210);
        PanelEntourerActionMiseEnValeur.setLayout(null);
        LbEntourerCouleurActionMiseEnValeur.setBounds(10, 20, 150, 24);
        BtEntourerCouleurActionMiseEnValeur.setBounds(160, 20, 40, 24);
        LbArrondiActionMiseEnValeur.setBounds(10, 50, 150, 24);
        SpinArrondiActionMiseEnValeur.setBounds(160, 50, 45, 24);
        LbEloignementActionMiseEnValeur.setBounds(10, 90, 150, 24);
        SpinEloignementActionMiseEnValeur.setBounds(160, 90, 45, 24);
        LbEpaisseurActionMiseEnValeur.setBounds(10, 130, 150, 24);
        SpinEpaisseurActionMiseEnValeur.setBounds(160, 130, 45, 24);
        CheckDureeActionMiseEnValeurEntourer.setBounds(10, 170, 150, 24);
        SpinDureeActionMiseEnValeurEntourer.setBounds(160, 170, 45, 24);
        LbUniteActionMiseEnValeurEntourer.setBounds(210, 170, 70, 24);
        
        PanelSymboleActionMiseEnValeur.setBounds(10, 30, 640, 210);
        PanelSymboleActionMiseEnValeur.setLayout(null);
        LbDirectionActionMiseEnValeur.setBounds(10, 20, 150, 24);
        CbDirectionActionMiseEnValeur.setBounds(90, 20, 120, 24);
        LbSymboleActionMiseEnValeur.setBounds(10, 50, 150, 110);
        BtModifierSymboleActionMiseEnValeur.setBounds(90, 50, 120, 110);
        BtModifierSymboleActionMiseEnValeur.setText("");
        CheckDureeActionMiseEnValeurSymbole.setBounds(10, 170, 150, 24);
        SpinDureeActionMiseEnValeurSymbole.setBounds(160, 170, 45, 24);
        LbUniteActionMiseEnValeurSymbole.setBounds(210, 170, 70, 24);
        
        PanelAgentActionMiseEnValeur.setBounds(10, 30, 640, 210);
        PanelAgentActionMiseEnValeur.setLayout(null);        
        LbDirectionActionMiseEnValeurAgent.setBounds(10, 20, 150, 24);
        CbDirectionActionMiseEnValeurAgent.setBounds(90, 20, 120, 24);
        LbSymboleActionMiseEnValeurAgent.setBounds(10, 50, 150, 110);
        BtModifierAgentActionMiseEnValeur.setBounds(90, 50, 120, 110);
        BtModifierAgentActionMiseEnValeur.setText("");        
        CheckDureeActionMiseEnValeurAgent.setBounds(10, 170, 150, 24);
        SpinDureeActionMiseEnValeurAgent.setBounds(160, 170, 45, 24);
        LbUniteActionMiseEnValeurAgent.setBounds(210, 170, 70, 24);
        
        BtValiderActionMiseEnValeur.setBounds(120, PanelCreationActionMiseEnValeur.getHeight()-35, 120, 30);
        BtApercuActionMiseEnValeur.setBounds(250, PanelCreationActionMiseEnValeur.getHeight()-35, 120, 30);
        BtAnnulerActionMiseEnValeur.setBounds(380, PanelCreationActionMiseEnValeur.getHeight()-35, 120, 30);
        
        //____________________________________________________Action Animation ______________________________________________________________       
        PanelCreationActionAgentAnime.setBounds(5, 30, 650, 578);
        PanelCreationActionAgentAnime.setLayout(null);        
        LbPersoActionAgentAnime.setBounds(10, 35, 150, 24);
        CbPersoActionAgentAnime.setBounds(150, 35, 140, 24);
        PanelPersoActionAgentAnime.setBounds(350, 5, 150, 150);
        PanelPersoActionAgentAnime.setLayout(null);
        LbImagePersoActionAgentAnime.setBounds(0, 0, PanelPersoActionAgentAnime.getWidth(), PanelPersoActionAgentAnime.getHeight());
        PanelPersoActionAgentAnime.setBackground(PanelPersoActionAgentAnime.getParent().getBackground());
        LbListeActionAgentAnime.setBounds(10, 120, 155, 24);
        ScrollListActionAgenAnime.setBounds(10, 160, 180, 250);
        BtAjouterSSActionAgentAnime.setBounds(10, 410, 180, 30);
        PanelSSActionAgentAnime.setBounds(200, 155, 450, 290);
        PanelSSActionAgentAnime.setLayout(null);
        LbTypeSSActionAnimation.setBounds(20, 20, 150, 24);
        CbTypeSSActionAnimation.setBounds(170, 20, 160, 24);
        LbHorizontaleSSActionAnimation.setBounds(20, 50, 150, 24);
        TxtHorizontaleSSActionAnimation.setBounds(170, 50, 160, 24);
        LbVerticaleSSActionAnimation.setBounds(20, 80, 150, 24);
        TxtVerticaleSSActionAnimation.setBounds(170, 80, 160, 24);
        
        SAjLabel3.setBounds(20, 50, 150, 24);
        SAjTextField3.setBounds(170, 50, 160, 24);
        SAjLabel4.setBounds(20, 50, 150, 24);
        SAjComboBoxIdentifiant.setBounds(170, 50, 160, 24);
        
        BtValiderSSActionAnimation.setBounds(PanelSSActionAgentAnime.getWidth()/2-150, PanelSSActionAgentAnime.getHeight()-35, 140, 24);
        BtModifierSSActionAnimation.setBounds(PanelSSActionAgentAnime.getWidth()/2-150, PanelSSActionAgentAnime.getHeight()-35, 140, 24);
        BtAnnulerSSActionAnimation.setBounds(PanelSSActionAgentAnime.getWidth()/2+10, PanelSSActionAgentAnime.getHeight()-35, 140, 24);
        
        BtValiderActionAgentAnime.setBounds(120, PanelCreationActionAgentAnime.getHeight()-35, 120, 30);
        BtApercuActionAgentAnime.setBounds(250, PanelCreationActionAgentAnime.getHeight()-35, 120, 30);
        BtAnnulerActionAgentAnime.setBounds(380, PanelCreationActionAgentAnime.getHeight()-35, 120, 30);
        
        //____________________________________________________Action Modifier le profil utilisateur______________________________________________________________        
        PanelCreationActionModifierProfil.setLayout(null);
        PanelCreationActionModifierProfil.setBounds(5, 30, 650, 578);
        LbSelectionActionModifierProfil.setBounds(10, 5, 600, 24);
        ScrollArbreActionProfil.setBounds(10, 30, 630, 320); 
        ArbreActionProfil.setBounds(0, 0, ScrollArbreActionProfil.getWidth(), ScrollArbreActionProfil.getHeight());
        LbElementActionModifierProfil.setBounds(10, 360, 150, 24);
        TxtElementActionModifierProfil.setBounds(160, 360, 480, 24);
        LbTypeActionModifierProfil.setBounds(10, 390, 150, 24);
        CbTypeActionModifierProfil.setBounds(160, 390, 250, 24);
        PanelModifierActionModifierProfil.setBounds(10, 420, 500, 30);
        PanelModifierActionModifierProfil.setLayout(null);
        LbActionActionModifierProfil.setBounds(0, 0, 150, 24);
        SpinModifierActionModifierProfil.setBounds(150, 0, 60, 24);
        LbPointActionModifierProfil.setBounds(220, 0, 90, 24);
        PanelExacteActionModifierProfil.setBounds(10, 420, 500, 30);
        PanelExacteActionModifierProfil.setLayout(null);
        LbExacteActionModifierProfil.setBounds(0, 0, 150, 24);
        CbNiveauxActionModifierProfil.setBounds(150, 0, 150, 24);
        SpinExacteActionModifierProfil.setBounds(150, 0, 60, 24);
        LbSourceActionModifierProfil.setBounds(10, 450, 150, 24);
        TxtSourceActionModifierProfil.setBounds(160, 450, 150, 24);
        
        BtAnnulerActionProfil.setBounds(PanelCreationActionModifierProfil.getWidth()/2+10, PanelCreationActionModifierProfil.getHeight()-35, 120, 30);
        BtValiderActionProfil.setBounds(PanelCreationActionModifierProfil.getWidth()/2-130, PanelCreationActionModifierProfil.getHeight()-35, 120, 30);
        
        //____________________________________________________Action Message ___________________________________________________________________________________       
        PanelCreationActionMessage.setLayout(null);
        PanelCreationActionMessage.setBounds(5, 30, 650, 578);
        PanelContenuActionMessage.setBounds(0, 0, 650, 31);
        PanelContenuActionMessage.setLayout(null);
        LbContenuActionMessage.setBounds(10, 5, 200, 24);
        Main.CreationRegles.editor = new HTMLEditorPane();
        Main.CreationRegles.editor.setBackground(PanelCreationActionMessage.getBackground());
        PanelCreationActionMessage.add(Main.CreationRegles.editor);        
        Main.CreationRegles.editor.setBounds(5, 5, 640, 145);
        PanelPersoContenu1ActionMessage.setBounds(0, 128, 650, 26);
        PanelPersoContenu1ActionMessage.setLayout(null);
        PanelCouleurFondActionMessage.setBounds(10, 2, 180, 24);
        PanelCouleurFondActionMessage.setLayout(null);
         LbCouleurFondActionMessage.setBounds(0, 0, 120, 24);
        BtCouleurFondActionMessage.setBounds(120, 0, 40, 24);
        LbPersoActionMessage.setBounds(240, 2, 120, 24);
        CbPersoActionMessage.setBounds(360, 2, 200, 24);
        BtInclureActionMessage.setBounds(570, 2, 75, 24);             
        LbTypeActionMessage.setBounds(10, 185, 190, 24);
        CheckEcritActionMessage.setBounds(200, 185, 80, 24);
        CheckOralActionMessage.setBounds(290, 185, 80, 24);
        CheckDifferentActionMessage.setBounds(5, 220, 190, 30);
        ScrollDifferentActionMessage.setBounds(200, 220, 430, 30);
        TxtDifferentActionMessage.setBounds(0, 0, ScrollDifferentActionMessage.getWidth()-5, ScrollDifferentActionMessage.getHeight()-10);
        LbPersoDifferentActionMessage.setBounds(240, 255, 120, 24);
        CbPersoDifferentActionMessage.setBounds(360, 255, 200, 24);
        BtInclureDifferentActionMessage.setBounds(570, 255, 75, 24);
        BtAfficherDetailsActionMessage.setBounds(460, 300, 30, 24);
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
        BtAfficherDetailsActionMessage.setIcon(new ImageIcon(icon));
        BtAfficherDetailsActionMessage.setText("");
        BtAfficherDetailsActionMessage.setVisible(false);
        LbModeActionMessage.setBounds(10, 300, 190, 24);

        CbModeActionMessage.setBounds(200, 300, 250, 24);
        PanelDetailsPopupActionMessage.setBounds(10, 330, 630, 210);
        PanelDetailsPopupActionMessage.setLayout(null);
        LbPositionPopupActionMessage.setBounds(10, 15, 80, 24);
        BtRbPositionSourisPopupActionMessage.setBounds(80, 15, 200, 24);
        RbPositionEcranPopupActionMessage.setBounds(80, 40, 150, 24);
        LbPositionHorizontalePopupActionMessage.setBounds(240, 40, 95, 24);
        CbPositionHorizontalePopupActionMessage.setBounds(340, 40, 75, 24);
        LbPositionVerticalePopupActionMessage.setBounds(445, 40, 95, 24);
        CbPositionVerticalePopupActionMessage.setBounds(540, 40, 75, 24);        
        RbPositionCoordonneesPopupActionMessage.setBounds(80, 65, 150, 24);
        LbXPopupActionMessage.setBounds(240, 65, 95, 24);
        SpinXPopupActionMessage.setBounds(340, 65, 75, 24);
        LbYPopupActionMessage.setBounds(445, 65, 95, 24);
        SpinYPopupActionMessage.setBounds(540, 65, 75, 24);        
        LbTitreFenetrePopupActionMessage.setBounds(10, 95, 80, 24);
        TxtTitreFenetreActionMessage.setBounds(80, 95, 300, 24);
        LbTailleFenetrePopupActionMessage.setBounds(10, 125, 80, 24);
        BtTailleAutomatiquePopupActionMessage.setBounds(80, 125, 200, 24);
        BtTailleManuellePopupActionMessage.setBounds(80, 150, 100, 24);
        LbHauteurFenetrePopupActionMessage.setBounds(240, 150, 95, 24);
        SpinHauteurFenetrePopupActionMessage.setBounds(340, 150, 75, 24);
        LbLargeurFenetrePopupActionMessage.setBounds(445, 150, 95, 24);
        SpinLargeurFenetrePopupActionMessage.setBounds(540, 150, 75, 24);
        CheckMiseEnFormeActionMessage.setBounds(10, 180, 180, 24);
        
        PanelDetailsAgentActionMessage.setBounds(10, 330, 630, 210);
        PanelDetailsAgentActionMessage.setLayout(null);
        LbPositionAgentActionMessage.setBounds(10, 15, 80, 24);
        BtRbPositionSourisAgentActionMessage.setBounds(80, 15, 200, 24);
        RbPositionEcranAgentActionMessage.setBounds(80, 40, 150, 24);
        LbPositionHorizontaleAgentActionMessage.setBounds(240, 40, 95, 24);
        CbPositionHorizontaleAgentActionMessage.setBounds(340, 40, 75, 24);
        LbPositionVerticaleAgentActionMessage.setBounds(445, 40, 95, 24);
        CbPositionVerticaleAgentActionMessage.setBounds(540, 40, 75, 24);        
        RbPositionCoordonneesAgentActionMessage.setBounds(80, 65, 150, 24);
        LbXAgentActionMessage.setBounds(240, 65, 95, 24);
        SpinXAgentActionMessage.setBounds(340, 65, 75, 24);
        LbYAgentActionMessage.setBounds(445, 65, 95, 24);
        SpinYAgentActionMessage.setBounds(540, 65, 75, 24);
        LbAgentActionMessage.setBounds(10, 95, 80, 110);
        BtModifierAgentActionMessage.setBounds(90, 95, 110, 110);
        
        BtValiderActionMessage.setBounds(120, PanelCreationActionMessage.getHeight()-35, 120, 30);
        BtApercuActionMessage.setBounds(250, PanelCreationActionMessage.getHeight()-35, 120, 30);
        BtAnnulerActionMessage.setBounds(380, PanelCreationActionMessage.getHeight()-35, 120, 30);
    }
    
    public void chargerInterface()
    {
       chargerLangue();
       
       //____________________________________________________ creation d'une action d'assistance ______________________________________________________________        
        CbChoixTypeAction.removeAllItems();
        CbChoixTypeAction.addItem("");
        CbChoixTypeAction.addItem(Main.CreationRegles.itemTypeActionMessage);
        CbChoixTypeAction.addItem(Main.CreationRegles.itemTypeActionMiseEnValeur);                
        CbChoixTypeAction.addItem(Main.CreationRegles.itemTypeActionAnimation);      
        CbChoixTypeAction.addItem(Main.CreationRegles.itemTypeActionRessource);             
        CbChoixTypeAction.addItem(Main.CreationRegles.itemTypeActionAjoutComposant);
        CbChoixTypeAction.addItem(Main.CreationRegles.itemTypeActionMasquage);
       
        //tmp : pour lexpe on retire certines possibilités
        /*
        CbChoixTypeAction.addItem(Main.CreationRegles.itemTypeActionActionInterface);
        CbChoixTypeAction.addItem(Main.CreationRegles.itemTypeActionPasAPas);
        CbChoixTypeAction.addItem(Main.CreationRegles.itemTypeActionPresentationGuidee);*/
        
        if(!Main.Cste.structureProfils.isEmpty())
        {
            CbChoixTypeAction.addItem(Main.CreationRegles.itemTypeActionModificationProfil);
        }
        CbChoixTypeAction.setEnabled(true);
       
        //____________________________________________________ Action Présentation guidée ______________________________________________________________
        PanelCreationActionPresentationGuidee.setVisible(false);        
                
        ListeActionPasaPas.setModel(Main.CreationRegles.listModel);
                
        CheckMessageAvantAutorisationActionPresentationGuidee.setEnabled(CheckMessageAvantActionPresentationGuidee.isSelected());
        CheckExpliquerEtapeAutorisationActionPresentationGuidee.setEnabled(CheckExpliquerEtapeActionPresentationGuidee.isSelected());        
        BtPersonnaliserMessagesPresentationGuidee.setEnabled(CheckMessageAvantActionPresentationGuidee.isSelected() || CheckMessageApresActionPresentationGuidee.isSelected() || CheckExpliquerEtapeActionPresentationGuidee.isSelected());       
        SpinTimerActionPresentationGuidee.setEnabled(CheckTimerActionPresentationGuidee.isSelected());
        
        Main.CreationRegles.chargerCbSequence(CbEtapesActionPresentationGuidee, Main.CreationRegles.attributActions);
        
        //____________________________________________________ Action Pas à Pas ______________________________________________________________
        PanelCreationActionPasaPas.setVisible(false);
        CbTypeActionPasaPas.removeAllItems();
        CbTypeActionPasaPas.addItem(Main.CreationRegles.itemGuide);
        CbTypeActionPasaPas.addItem(Main.CreationRegles.itemAutomatise);        
                
        Main.CreationRegles.listModel = new DefaultListModel();
        ListeActionPasaPas.setModel(Main.CreationRegles.listModel);
                
        CheckMessageAvantAutorisationActionPasaPas.setEnabled(CheckMessageAvantActionPasaPas.isSelected());
        CheckMessageApresBilanActionPasaPas.setEnabled(CheckMessageApresActionPasaPas.isSelected());        
        PanelAutomatiserActionPasaPas.setVisible(false);
        CheckExpliquerEtapeAutorisationActionPasaPas.setEnabled(CheckExpliquerEtapeActionPasaPas.isSelected());        
        BtPersonnaliserMessagesPasAPas.setEnabled(CheckMessageAvantActionPasaPas.isSelected() || CheckMessageApresActionPasaPas.isSelected() || CheckExpliquerEtapeActionPasaPas.isSelected() || CheckExpliquerEtapeTermineeActionPasaPas.isSelected());       
        BtMiseEnValeurPasAPas.setEnabled(CheckMiseEnValeurActionPasaPas.isSelected());
        
        //Main.CreationActions.creerListeMessagesPasAPas(sequence);
        creerElementMiseEnValeurEtape();
        Main.CreationRegles.chargerCbSequence(CbEtapesActionPasaPas, Main.CreationRegles.attributActions);

        //______________________________________________________________ Action de proposition d'une ressource externe______________________________________________________
        PanelCreationActionRessource.setVisible(false);               
        CbTypeActionRessource.removeAllItems();
        CbTypeActionRessource.addItem(Main.CreationRegles.itemOuvrirFichierActionRessource);
        CbTypeActionRessource.addItem(Main.CreationRegles.itemOuvrirURLActionRessource);
        CbTypeActionRessource.addItem(Main.CreationRegles.itemOuvrirAppliActionRessource);

        //______________________________________________________________ Action sur l'interface______________________________________________________
        PanelCreationActionInterface.setVisible(false);
        LbComposantActionInterface.setBounds(10, 5, 150, 24);
        TxtComposantActionInterface.setBounds(150, 5, 60, 24);
        ArbreActionInterface.setCellRenderer(new ArbreInfoBulles());
        Main.CreationRegles.chargerArbreComposants(ArbreActionInterface, Main.CreationRegles.afficherDescriptionComplete);
        Main.CreationRegles.etendreArbre(ArbreActionInterface);
        CbActionActionInterface.removeAllItems();
        Main.CreationRegles.ChargerCbActionActionInterface(CbActionActionInterface, "");
        PanelEtatActionInterface.setVisible(false);
        RbOnActionInterface.setSelected(true);
        PanelValeurActionInterface.setVisible(false);
        TxtValeurActionInterface.setText("");
        
        Main.CreationRegles.chargerArbreComposants(ArbreActionInterface, Main.CreationRegles.afficherDescriptionComplete);
        Main.CreationRegles.etendreArbre(ArbreActionInterface);
        
        //____________________________________________________Action ajout composant______________________________________________________________
        PanelCreationActionAjoutComposant.setVisible(false);       
        ArbreActionAjoutComposant.setCellRenderer(new ArbreInfoBulles());
        Main.CreationRegles.chargerArbreComposants(ArbreActionAjoutComposant, Main.CreationRegles.afficherDescriptionComplete);
        Main.CreationRegles.etendreArbre(ArbreActionAjoutComposant);
        
        CbTypeActionAjoutComposant.removeAllItems();
        CbTypeActionAjoutComposant.addItem(Main.CreationRegles.itemTypeComposantAjouteBouton);
        CbTypeActionAjoutComposant.addItem(Main.CreationRegles.itemTypeComposantAjouteLabel);
        CbTypeActionAjoutComposant.addItem(Main.CreationRegles.itemTypeComposantAjouteImage);
        
        PanelBoutonActionAjoutComposant.setVisible(true);
        CheckTexteBoutonActionAjoutComposant.setSelected(true);
        CheckInfoBulleBoutonActionAjoutComposant.setSelected(true);
        CheckIconeBoutonActionAjoutComposant.setSelected(false);
        TxtTexteBoutonActionAjoutComposant.setEnabled(CheckTexteBoutonActionAjoutComposant.isSelected());
        TxtInfoBulleBoutonActionAjoutComposant.setEnabled(CheckInfoBulleBoutonActionAjoutComposant.isSelected());
        BtIconeBoutonActionAjoutComposant.setEnabled(CheckIconeBoutonActionAjoutComposant.isSelected());
        ImageIcon im = new ImageIcon(Main.Cste.cheminSymboles+"aide.png");
        BtIconeBoutonActionAjoutComposant.setIcon(im);
        BtIconeBoutonActionAjoutComposant.setToolTipText("aide.png");
        
        PanelLabelActionAjoutComposant.setVisible(false);
        CheckIconeLabelActionAjoutComposant.setSelected(false);
        BtIconeLabelActionAjoutComposant.setEnabled(CheckIconeLabelActionAjoutComposant.isSelected());
        BtIconeLabelActionAjoutComposant.setIcon(im);
        BtIconeLabelActionAjoutComposant.setToolTipText("aide.png");
        
        PanelImageActionAjoutComposant.setVisible(false);
        BtIconeImageActionAjoutComposant.setIcon(im);
        BtIconeImageActionAjoutComposant.setToolTipText("aide.png");
       
        //____________________________________________________Action Mise en valeur & masquage______________________________________________________________
        PanelCreationActionMiseEnValeur.setVisible(false);       
        ArbreActionMiseEnValeur.setCellRenderer(new ArbreInfoBulles());
        Main.CreationRegles.chargerArbreComposants(ArbreActionMiseEnValeur, Main.CreationRegles.afficherDescriptionComplete);
        Main.CreationRegles.etendreArbre(ArbreActionMiseEnValeur);
        
        //_________________________________masquage_____________________________________________
        CbTypeActionMasquage.removeAllItems();
        CbTypeActionMasquage.addItem(Main.CreationRegles.itemEstomper);
        CbTypeActionMasquage.addItem(Main.CreationRegles.itemOcculter);
        BtAfficherDetailsActionMasquage.setToolTipText("Afficher les détails du masquage");         
        PanelEstomperActionMasquage.setVisible(false);
        chargerCBCoordonnees(CbPositionHorizontalePopupActionMessage);
        chargerCBCoordonneesH(CbPositionVerticalePopupActionMessage);
        chargerCBCoordonnees(CbPositionHorizontaleAgentActionMessage);
        chargerCBCoordonneesH(CbPositionVerticaleAgentActionMessage);
        
         //_________________________________mise en valeur_______________________________________
        CbTypeActionMiseEnValeur.removeAllItems();
        CbTypeActionMiseEnValeur.addItem("");
        CbTypeActionMiseEnValeur.addItem(Main.CreationRegles.itemColorer);
        CbTypeActionMiseEnValeur.addItem(Main.CreationRegles.itemEntourer);
        CbTypeActionMiseEnValeur.addItem(Main.CreationRegles.itemSymbole);
        CbTypeActionMiseEnValeur.addItem(Main.CreationRegles.itemAgentAnime);
         
        BtCouleurActionMiseEnValeur.setBackground(Color.red);
        SpinDureeActionMiseEnValeurEntourer.setEnabled(CheckDureeActionMiseEnValeurEntourer.isSelected());
        SpinDureeActionMiseEnValeurColorer.setEnabled(CheckDureeActionMiseEnValeurEntourer.isSelected());
        SpinDureeActionMiseEnValeurSymbole.setEnabled(CheckDureeActionMiseEnValeurEntourer.isSelected());
        SpinDureeActionMiseEnValeurAgent.setEnabled(CheckDureeActionMiseEnValeurEntourer.isSelected());
        
        CbDirectionActionMiseEnValeur.removeAllItems();      
        CbDirectionActionMiseEnValeur.addItem(Main.CreationRegles.itemParLaGauche);
        CbDirectionActionMiseEnValeur.addItem(Main.CreationRegles.itemParLaDroite);
        CbDirectionActionMiseEnValeur.addItem(Main.CreationRegles.itemParLeHaut);
        CbDirectionActionMiseEnValeur.addItem(Main.CreationRegles.itemParLeBas);        
        im = new ImageIcon(Main.Cste.cheminSymboles+"attention8.png");        
        BtModifierSymboleActionMiseEnValeur.setIcon(im);
        Main.CreationRegles.fichierSymbole="attention8.png";
        
        
        CbDirectionActionMiseEnValeurAgent.removeAllItems();      
        CbDirectionActionMiseEnValeurAgent.addItem(Main.CreationRegles.itemParLaGauche);
        CbDirectionActionMiseEnValeurAgent.addItem(Main.CreationRegles.itemParLaDroite);
        CbDirectionActionMiseEnValeurAgent.addItem(Main.CreationRegles.itemParLeHaut);
        CbDirectionActionMiseEnValeurAgent.addItem(Main.CreationRegles.itemParLeBas);        
        im = new ImageIcon(this.getClass().getResource("/imagesAgentsAnimes/Genie.gif"));       
        BtModifierAgentActionMiseEnValeur.setIcon(im);
        Main.CreationRegles.personnageMiseEnValeur="Genie";
  
        Main.CreationRegles.chargerArbreComposants(ArbreActionMiseEnValeur, Main.CreationRegles.afficherDescriptionComplete);
        Main.CreationRegles.etendreArbre(ArbreActionMiseEnValeur);
        
        //____________________________________________________Action Animation ______________________________________________________________
        CbTypeSSActionAnimation.removeAllItems();
        CbTypeSSActionAnimation.addItem(Main.CreationRegles.itemDeplacementActionAnimation);
        CbTypeSSActionAnimation.addItem(Main.CreationRegles.itemParoleActionAnimation);
        CbTypeSSActionAnimation.addItem(Main.CreationRegles.itemPensseActionAnimation);
        CbTypeSSActionAnimation.addItem(Main.CreationRegles.itemAnimationActionAnimation);
        
        PanelCreationActionAgentAnime.setVisible(false);              
        listeSousActions=new ListeSousActions();
        viderPanelSousAction();
        hidePanelSousAction();
        initialiserListe();
        Main.CreationRegles.indexSousActionModifier=-1;

        //____________________________________________________Action Modifier le profil utilisateur______________________________________________________________
        
        PanelCreationActionModifierProfil.setVisible(false);
        TxtElementActionModifierProfil.setText("");
        PanelModifierActionModifierProfil.setVisible(false);
        PanelExacteActionModifierProfil.setVisible(false);
        TxtSourceActionModifierProfil.setText("");
        
        if(!Main.Cste.structureProfils.isEmpty())
        {
            construireMurActionProfil();
            CbTypeActionModifierProfil.removeAllItems();
            CbTypeActionModifierProfil.addItem(Main.CreationRegles.exact);
            CbTypeActionModifierProfil.addItem(Main.CreationRegles.modifier);
            LbPointActionModifierProfil.setText(Main.CreationRegles.points);        
        }
         
        //____________________________________________________Action Message ___________________________________________________________________________________
        PanelCreationActionMessage.setVisible(false);
        PanelCouleurFondActionMessage.setVisible(false);      
        BtCouleurFondActionMessage.setBackground(Color.white);        
        chargerCbPersoActionMessage();      
        CbPersoDifferentActionMessage.removeAllItems();
        CbPersoDifferentActionMessage.addItem("");
        CbPersoDifferentActionMessage.addItem(Main.CreationRegles.itemAvecPrenom);
        CbPersoDifferentActionMessage.addItem(Main.CreationRegles.itemAvecNom);
        CbPersoDifferentActionMessage.addItem(Main.CreationRegles.itemAvecElementProfil);   
        chargerCbModeActionMessage();
        PanelDetailsPopupActionMessage.setVisible(false);        
        PanelDetailsAgentActionMessage.setVisible(false);
        
        im = new ImageIcon(this.getClass().getResource("/imagesAgentsAnimes/Genie.gif"));       
        BtModifierAgentActionMessage.setText("");
        BtModifierAgentActionMessage.setIcon(im);
        Main.CreationRegles.personnageMessage="Genie";         
        
        //__________________________________________________________Action ajout composant___________________________________________________
        PanelDetailsActionAjoutComposant.setVisible(false);
        CbDirectionActionAjoutComposant.removeAllItems();      
        CbDirectionActionAjoutComposant.addItem(Main.CreationRegles.itemParLaGauche);
        CbDirectionActionAjoutComposant.addItem(Main.CreationRegles.itemParLaDroite);
        CbDirectionActionAjoutComposant.addItem(Main.CreationRegles.itemParLeHaut);
        CbDirectionActionAjoutComposant.addItem(Main.CreationRegles.itemParLeBas);

        
        TxtNomAction.setText("A"+Main.CreationRegles.idAction);
    }
    
    private void chargerLangue()
    {
        XMLFonctions.OuvrirXML(Main.Cste.fichierInterfaceEditeur);
        Element courant;
        
        //____________________________________________________________________la création d'actions______________________________________________________________
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbNomAction").getChild(Main.Cste.langue);
        LbNomAction.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbChoixTypeAction").getChild(Main.Cste.langue);
        LbChoixTypeAction.setText(courant.getText());
        
        //______________________________________action de type message________________________________
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbContenuActionMessage").getChild(Main.Cste.langue);
        LbContenuActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbCouleurFondActionMessage").getChild(Main.Cste.langue);
        LbCouleurFondActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbPersoActionMessage").getChild(Main.Cste.langue);
        LbPersoActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtInclure").getChild(Main.Cste.langue);
        BtInclureActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbTypeActionMessage").getChild(Main.Cste.langue);
        LbTypeActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("CheckEcritActionMessage").getChild(Main.Cste.langue);
        CheckEcritActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("CheckOralActionMessage").getChild(Main.Cste.langue);
        CheckOralActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("CheckDifferentActionMessage").getChild(Main.Cste.langue);
        CheckDifferentActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbPersoActionMessage").getChild(Main.Cste.langue);
        LbPersoDifferentActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtInclure").getChild(Main.Cste.langue);
        BtInclureDifferentActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbModeActionMessage").getChild(Main.Cste.langue);
        LbModeActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbPositionPopupActionMessage").getChild(Main.Cste.langue);
        LbPositionPopupActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbPositionPopupActionMessage").getChild(Main.Cste.langue);
        LbPositionAgentActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtRbPositionSourisPopupActionMessage").getChild(Main.Cste.langue);
        BtRbPositionSourisPopupActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtRbPositionSourisPopupActionMessage").getChild(Main.Cste.langue);
        BtRbPositionSourisAgentActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("RbPositionEcranPopupActionMessage").getChild(Main.Cste.langue);
        RbPositionEcranPopupActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("RbPositionEcranPopupActionMessage").getChild(Main.Cste.langue);
        RbPositionEcranAgentActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("RbPositionCoordonneesPopupActionMessage").getChild(Main.Cste.langue);
        RbPositionCoordonneesPopupActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("RbPositionCoordonneesPopupActionMessage").getChild(Main.Cste.langue);
        RbPositionCoordonneesAgentActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbPositionHorizontalePopupActionMessage").getChild(Main.Cste.langue);
        LbPositionHorizontalePopupActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbPositionHorizontalePopupActionMessage").getChild(Main.Cste.langue);
        LbXPopupActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbPositionHorizontalePopupActionMessage").getChild(Main.Cste.langue);
        LbPositionHorizontaleAgentActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbPositionHorizontalePopupActionMessage").getChild(Main.Cste.langue);
        LbXAgentActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbPositionVerticalePopupActionMessage").getChild(Main.Cste.langue);
        LbPositionVerticalePopupActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbPositionVerticalePopupActionMessage").getChild(Main.Cste.langue);
        LbYPopupActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbPositionVerticalePopupActionMessage").getChild(Main.Cste.langue);
        LbPositionVerticaleAgentActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbPositionVerticalePopupActionMessage").getChild(Main.Cste.langue);
        LbYAgentActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbAgentActionMessage").getChild(Main.Cste.langue);
        LbAgentActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("PanelDetailsPopupActionMessage").getChild(Main.Cste.langue);
        TitledBorder t = new TitledBorder(courant.getText());
        PanelDetailsPopupActionMessage.setBorder(t);
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("PanelDetailsPopupActionMessage").getChild(Main.Cste.langue);
        t = new TitledBorder(courant.getText());
        PanelDetailsAgentActionMessage.setBorder(t);
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbTitreFenetrePopupActionMessage").getChild(Main.Cste.langue);
        LbTitreFenetrePopupActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbTailleFenetrePopupActionMessage").getChild(Main.Cste.langue);
        LbTailleFenetrePopupActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtTailleAutomatiquePopupActionMessage").getChild(Main.Cste.langue);
        BtTailleAutomatiquePopupActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtTailleManuellePopupActionMessage").getChild(Main.Cste.langue);
        BtTailleManuellePopupActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbHauteurFenetrePopupActionMessage").getChild(Main.Cste.langue);
        LbHauteurFenetrePopupActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("CheckMiseEnFormeActionMessage").getChild(Main.Cste.langue);
        CheckMiseEnFormeActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtValider").getChild(Main.Cste.langue);
        BtValiderActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtApercu").getChild(Main.Cste.langue);
        BtApercuActionMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnulerActionMessage.setText(courant.getText());
        
        //___________________________action de type mise en valeur______________________
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbIdActionMiseEnValeur").getChild(Main.Cste.langue);
        LbIdActionMiseEnValeur.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbTypeActionMiseEnValeur").getChild(Main.Cste.langue);
        LbTypeActionMiseEnValeur.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbEntourerCouleurActionMiseEnValeur").getChild(Main.Cste.langue);
        LbEntourerCouleurActionMiseEnValeur.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbArrondiActionMiseEnValeur").getChild(Main.Cste.langue);
        LbArrondiActionMiseEnValeur.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbEloignementActionMiseEnValeur").getChild(Main.Cste.langue);
        LbEloignementActionMiseEnValeur.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbEpaisseurActionMiseEnValeur").getChild(Main.Cste.langue);
        LbEpaisseurActionMiseEnValeur.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbDirection").getChild(Main.Cste.langue);
        LbDirectionActionMiseEnValeur.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbSymbole").getChild(Main.Cste.langue);
        LbSymboleActionMiseEnValeur.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbCouleurActionMiseEnValeur").getChild(Main.Cste.langue);
        LbCouleurActionMiseEnValeur.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbCouleurActionMiseEnValeur").getChild(Main.Cste.langue);
        LbCouleurActionMasquage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbTransparenceActionMiseEnValeur").getChild(Main.Cste.langue);
        LbTransparenceActionMiseEnValeur.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbTransparenceActionMiseEnValeur").getChild(Main.Cste.langue);
        LbTransparenceActionMasquage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbDirection").getChild(Main.Cste.langue);
        LbDirectionActionMiseEnValeurAgent.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbSymboleActionMiseEnValeurAgent").getChild(Main.Cste.langue);
        LbSymboleActionMiseEnValeurAgent.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbTypeActionMasquage").getChild(Main.Cste.langue);
        LbTypeActionMasquage.setText(courant.getText());
        BtAfficherDescriptionInterfaceActionMiseEnValeur.setToolTipText(Main.CreationRegles.toolTip1BtAfficherDescription);
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("tootltipBtModifierDescriptionInterface").getChild(Main.Cste.langue);
        BtModifierDescriptionInterfaceActionMiseEnValeur.setToolTipText(courant.getText());        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("PanelDetailsPopupActionMessage").getChild(Main.Cste.langue);
        t = new TitledBorder(courant.getText());
        PanelEntourerActionMiseEnValeur.setBorder(t);
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("PanelDetailsPopupActionMessage").getChild(Main.Cste.langue);
        t = new TitledBorder(courant.getText());
        PanelSymboleActionMiseEnValeur.setBorder(t);
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("PanelDetailsPopupActionMessage").getChild(Main.Cste.langue);
        t = new TitledBorder(courant.getText());
        PanelColorerActionMiseEnValeur.setBorder(t);
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("PanelDetailsPopupActionMessage").getChild(Main.Cste.langue);
        t = new TitledBorder(courant.getText());
        PanelAgentActionMiseEnValeur.setBorder(t);
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("PanelDetailsPopupActionMessage").getChild(Main.Cste.langue);
        t = new TitledBorder(courant.getText());
        PanelEstomperActionMasquage.setBorder(t);
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtValider").getChild(Main.Cste.langue);
        BtValiderActionMiseEnValeur.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtApercu").getChild(Main.Cste.langue);
        BtApercuActionMiseEnValeur.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnulerActionMiseEnValeur.setText(courant.getText());
        
        //________________________________action d'animation d'agent____________________________________________________________
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbPersoActionAgentAnime").getChild(Main.Cste.langue);
        LbPersoActionAgentAnime.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbListeActionAgentAnime").getChild(Main.Cste.langue);
        LbListeActionAgentAnime.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAjouterSSActionAgentAnime").getChild(Main.Cste.langue);
        BtAjouterSSActionAgentAnime.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("SAjLabelType").getChild(Main.Cste.langue);
        LbTypeSSActionAnimation.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("SAjLabel1").getChild(Main.Cste.langue);
        LbHorizontaleSSActionAnimation.setText(courant.getText());
        Main.CreationRegles.itemPositionHorizontaleActionAnimation = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("SAjLabel2").getChild(Main.Cste.langue);
        LbVerticaleSSActionAnimation.setText(courant.getText());
        Main.CreationRegles.itemPositionVerticaleActionAnimation = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtValider").getChild(Main.Cste.langue);
        BtValiderSSActionAnimation.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnulerSSActionAnimation.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtModifier").getChild(Main.Cste.langue);
        BtModifierSSActionAnimation.setText(courant.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtValider").getChild(Main.Cste.langue);
        BtValiderActionAgentAnime.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtApercu").getChild(Main.Cste.langue);
        BtApercuActionAgentAnime.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnulerActionAgentAnime.setText(courant.getText());
        
        //________________________________action automatisée sur l'interface_________________________________________________________
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbIdActionMiseEnValeur").getChild(Main.Cste.langue);
        LbComposantActionInterface.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbActionActionInterface").getChild(Main.Cste.langue);
        LbActionActionInterface.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbEtatActionInterface").getChild(Main.Cste.langue);
        LbEtatActionInterface.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("RbOnActionInterface").getChild(Main.Cste.langue);
        RbOnActionInterface.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("RbOffActionInterface").getChild(Main.Cste.langue);
        RbOffActionInterface.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbValeurActionInterface").getChild(Main.Cste.langue);
        LbValeurActionInterface.setText(courant.getText());
        
        BtAfficherDescriptionInterfaceActionInterface.setToolTipText(Main.CreationRegles.toolTip1BtAfficherDescription);
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("tootltipBtModifierDescriptionInterface").getChild(Main.Cste.langue);
        BtModifierDescriptionInterfaceActionInterface.setToolTipText(courant.getText());
        
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtValider").getChild(Main.Cste.langue);
        BtValiderActionInterface.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtApercu").getChild(Main.Cste.langue);
        BtApercuActionInterface.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnulerActionInterface.setText(courant.getText());
        
        
        //________________________________action de modification du profil de l'utilisateur____________________________________________________________
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbSelectionActionModifierProfil").getChild(Main.Cste.langue);
        LbSelectionActionModifierProfil.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbElementActionModifierProfil").getChild(Main.Cste.langue);
        LbElementActionModifierProfil.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbTypeActionModifierProfil").getChild(Main.Cste.langue);
        LbTypeActionModifierProfil.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbActionActionModifierProfil").getChild(Main.Cste.langue);
        LbActionActionModifierProfil.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbPointActionModifierProfil").getChild(Main.Cste.langue);
        LbPointActionModifierProfil.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbExacteActionModifierProfil").getChild(Main.Cste.langue);
        LbExacteActionModifierProfil.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbSourceActionModifierProfil").getChild(Main.Cste.langue);
        LbSourceActionModifierProfil.setText(courant.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtValider").getChild(Main.Cste.langue);
        BtValiderActionProfil.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnulerActionProfil.setText(courant.getText());
        
        //________________________________action de lancement de ressource externe____________________________________________________________
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbTypeActionRessource").getChild(Main.Cste.langue);
        LbTypeActionRessource.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbCheminActionRessource").getChild(Main.Cste.langue);
        LbCheminActionRessource.setText(courant.getText());
        Main.CreationRegles.itemCheminActionRessource = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtCheminActionRessource").getChild(Main.Cste.langue);
        BtCheminActionRessource.setText(courant.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtValider").getChild(Main.Cste.langue);
        BtValiderActionRessource.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtApercu").getChild(Main.Cste.langue);
        BtApercuActionRessource.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnulerActionRessource.setText(courant.getText());
        
        //_______________________________action ajout composant_____________________
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtValider").getChild(Main.Cste.langue);
        BtValiderActionAjoutComposant.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtApercu").getChild(Main.Cste.langue);
        BtApercuActionAjoutComposant.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnulerActionAjoutComposant.setText(courant.getText());
        
        //_______________________________action pas à pas___________________________
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbTypeActionPasaPas").getChild(Main.Cste.langue);
        LbTypeActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbEtapesActionPasaPas").getChild(Main.Cste.langue);
        LbEtapesActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtModifierEtapesActionPasaPas").getChild(Main.Cste.langue);
        BtModifierEtapesActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtCreerEtapesActionPasaPas").getChild(Main.Cste.langue);
        BtCreerEtapesActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbOptionActionPasaPas").getChild(Main.Cste.langue);
        LbOptionActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("CheckMessageAvantActionPasaPas").getChild(Main.Cste.langue);
        CheckMessageAvantActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("CheckMessageApresActionPasaPas").getChild(Main.Cste.langue);
        CheckMessageApresActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("CheckProgressionActionPasaPas").getChild(Main.Cste.langue);
        CheckProgressionActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("CheckMessageAvantAutorisationActionPasaPas").getChild(Main.Cste.langue);
        CheckMessageAvantAutorisationActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("CheckMessageApresBilanActionPasaPas").getChild(Main.Cste.langue);
        CheckMessageApresBilanActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbOptionEtapesActionPasaPas").getChild(Main.Cste.langue);
        LbOptionEtapesActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("CheckMiseEnValeurActionPasaPas").getChild(Main.Cste.langue);
        CheckMiseEnValeurActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("CheckInterventionActionPasaPas").getChild(Main.Cste.langue);
        CheckInterventionActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("CheckExpliquerEtapeActionPasaPas").getChild(Main.Cste.langue);
        CheckExpliquerEtapeActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("CheckExpliquerEtapeTermineeActionPasaPas").getChild(Main.Cste.langue);
        CheckExpliquerEtapeTermineeActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("CheckTimerActionPasaPas").getChild(Main.Cste.langue);
        CheckTimerActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("CheckMessageAvantAutorisationActionPasaPas").getChild(Main.Cste.langue);
        CheckExpliquerEtapeAutorisationActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbSecondesActionPasaPas").getChild(Main.Cste.langue);
        LbSecondesActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtPersonnaliserMessagesPasAPas").getChild(Main.Cste.langue);
        BtPersonnaliserMessagesPasAPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtMiseEnValeurPasAPas").getChild(Main.Cste.langue);
        BtMiseEnValeurPasAPas.setText(courant.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtValider").getChild(Main.Cste.langue);
        BtValiderActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtApercu").getChild(Main.Cste.langue);
        BtApercuActionPasaPas.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnulerActionPasaPas.setText(courant.getText());
    }
    
    private void valider(Element act, int ligne)
    {
        Main.CreationRegles.rechargerCbSelectionAction();

        CbChoixTypeAction.setSelectedIndex(0);
        CbChoixTypeAction.setEnabled(true);
                
        if(CB!=null)
        {
            CB.setSelectedItem(act.getAttributeValue(Main.CreationRegles.attributId));
            CB=null;
        }
        Main.CreationRegles.setEnabled(true);
        afficherDescriptionAction(act, ligne);
        this.setVisible(false);
    }
    
    private void annuler()
    {
        CbChoixTypeAction.setSelectedIndex(0);
        CbChoixTypeAction.setEnabled(true);
        if(CB!=null)
        {
            CB.setSelectedIndex(-1);
            CB=null;
        }
        this.setVisible(false);
    }
    
    public void creerElementMiseEnValeurEtape()
    {
        elementMiseEnValeurEtape=new Element("miseEnValeur");
        Element compo = new Element(Main.CreationRegles.attributComposant);
        compo.setAttribute(Main.CreationRegles.attributType, "entourer");
        compo.setAttribute(Main.CreationRegles.attributCouleur, Color.blue.toString());
        compo.setAttribute(Main.CreationRegles.attributArrondi, "15");
        compo.setAttribute(Main.CreationRegles.attributEloignement, "5");
        compo.setAttribute(Main.CreationRegles.attributEpaisseur, "4");
        elementMiseEnValeurEtape.addContent(compo);
    }
    
    public void creerListeMessagesPasAPas(Element sequence)
    {
        choixMessagesAvantEtapePasaPas=new String[sequence.getChildren().size()];
        for(int i=0; i<sequence.getChildren().size(); i++)
        {
            String descr=ListeActionPasaPas.getModel().getElementAt(i).toString();
            choixMessagesAvantEtapePasaPas[i]=MessageAvantEtapePasaPas+" "+descr.substring(0,1).toLowerCase()+descr.substring(1);
        }
        
        choixMessagesApresEtapePasaPas=new String[sequence.getChildren().size()];
        for(int i=0; i<sequence.getChildren().size(); i++)
        {
            choixMessagesApresEtapePasaPas[i]=MessageApresEtapePasaPas+" '"+ListeActionPasaPas.getModel().getElementAt(i).toString()+"'";
        }
    }
    
    public void creerListeMessagesPresentationGuidee(Element sequence)
    {
        choixMessagesAvantEtapePresentationGuidee=new String[sequence.getChildren().size()];
        for(int i=0; i<sequence.getChildren().size(); i++)
        {
            String descr=ListeActionPresentationGuidee.getModel().getElementAt(i).toString();
            descr=descr.substring(Main.CreationRegles.stringPresenter.length());
            choixMessagesAvantEtapePresentationGuidee[i]=MessageAvantEtapePresentationGuidee+" "+descr;
        }
    }
    
    private void construireMurActionProfil()
    {
         XMLFonctions.OuvrirXML(Main.Cste.cheminStructuresProfils+Main.Cste.structureProfils);
         Element courant=XMLFonctions.racine;
         DefaultMutableTreeNode root=new DefaultMutableTreeNode("profil");
         for(int i=0; i<courant.getChildren().size(); i++)
         {   
             Element brique=(Element) courant.getChildren().get(i);
             
             root=Main.CreationRegles.ouvrirBrique(brique,root);
         }
         DefaultTreeModel m = new DefaultTreeModel(root);
         ArbreActionProfil.setModel(m);
         etendreArbreActionProfil();
    }
    
    private void etendreArbreActionProfil()
    {
        Enumeration e = ((DefaultMutableTreeNode) ArbreActionProfil.getModel().getRoot()).preorderEnumeration();
        while (e.hasMoreElements()) 
        {
            ArbreActionProfil.expandPath(new TreePath(((DefaultMutableTreeNode)e.nextElement()).getPath()));
        }
    }
    
    private void chargerCBCoordonnees(JComboBox cb)
    {
        cb.removeAllItems();
        cb.addItem(Main.CreationRegles.itemCentre);
        cb.addItem(Main.CreationRegles.itemGauche);
        cb.addItem(Main.CreationRegles.itemDroite);
    }
    
    private void chargerCBCoordonneesH(JComboBox cb)
    {
        cb.removeAllItems();
        cb.addItem(Main.CreationRegles.itemCentre);
        cb.addItem(Main.CreationRegles.itemHaut);
        cb.addItem(Main.CreationRegles.itemBas);
    }
    
    public class ListeSousActions{
        private ArrayList<SousAction> liste;
        
        public ListeSousActions(){
            liste=new ArrayList<SousAction>();
        }
        public ArrayList<SousAction> getListe(){
            return liste;
        }
        
        public void ajouterSousAction(SousAction _SousAction){
            liste.add(_SousAction);
        }
    }
    
    public abstract class SousAction{
        protected String type;
        
        public String getType(){
            return type;
        }
        
        public abstract Element creerSousAction();
        
    }
    
    public class Deplacement extends SousAction{
        private String position_x;
        private String position_y;
        private String vitesse;
        
        public Deplacement(){
            type=Main.CreationRegles.attributDéplacement;
        }
        
        public void initialiserSousAction(String _position_x, String _position_y, String _vitesse){
            position_x=_position_x;
            position_y=_position_y;
            vitesse=_vitesse;
        }
        
        public String getPosition_x(){
            return position_x;
        }
        
        public String getPosition_y(){
            return position_y;
        }
        
        public String getVitesse(){
            return vitesse;
        }
        
        public Element creerSousAction(){
            Element elem=new Element(Main.CreationRegles.attributSousAction);
            elem.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributDeplacement);
            elem.setAttribute(Main.CreationRegles.attributPosition_x, position_x);
            elem.setAttribute(Main.CreationRegles.attributPosition_y, position_y);
            elem.setAttribute(Main.CreationRegles.attributVitesse, vitesse);
            return elem;
        }
    }
            
    public class Parole extends SousAction{
        private String vitesse;
        private String texte;
        
        public Parole()
        {
            type=Main.CreationRegles.attributParole;
        }
        
        public void initialiserSousAction(String _texte){
            vitesse="100";
            texte=_texte;
        }
                
        public String getVitesse(){
            return vitesse;
        }
        
        public String getTexte(){
            return texte;
        }
        
        public Element creerSousAction(){
            Element elem=new Element(Main.CreationRegles.attributSousAction);
            elem.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributParole);
            elem.setAttribute(Main.CreationRegles.attributVitesse, vitesse);
            Element elemTexte=new Element(Main.CreationRegles.attributTexte);
            elemTexte.setText(texte);
            elem.addContent(elemTexte);
            return elem;
        }
    }
        
    public class Pensee extends SousAction{
        private String texte;
        
        public Pensee()
        {
            type=Main.CreationRegles.attributPensee;
        }
        
        public void initialiserSousAction(String _texte){
            texte=_texte;
        }
                
        public String getTexte(){
            return texte;
        }
        
        public Element creerSousAction(){
            Element elem=new Element(Main.CreationRegles.attributSousAction);
            elem.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributPense);
            Element elemTexte=new Element(Main.CreationRegles.attributTexte);
            elemTexte.setText(texte);
            elem.addContent(elemTexte);
            return elem;
        }
    }
        
    public class Animation extends SousAction{
        private String identifiant;
        
        public Animation(){
            type=Main.CreationRegles.attributAnimation;
        }
        
        public void initialiserSousAction(String _identifiant){
            identifiant=_identifiant;
        }
                
        public String getIdentifiant(){
            return identifiant;
        }
        
        public Element creerSousAction(){
            Element elem=new Element(Main.CreationRegles.attributSousAction);
            elem.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributAnimation);
            elem.setAttribute(Main.CreationRegles.attributIdentifiant, identifiant);
            return elem;
        }
    }
    
    private Element creerElementMessagePresentationGuidee()
    {
        Element mes=new Element(Main.CreationRegles.attributMessage);
        mes.setAttribute(Main.CreationRegles.attributSousType, Main.CreationRegles.attributTextuel);
        Element textuel = new Element(Main.CreationRegles.attributTextuel);
        
        Element texte = new Element(Main.CreationRegles.attributTexte);
        
        /*Element policeMessage=new Element(Main.CreationRegles.attributPoliceMessage);
        policeMessage.setAttribute(Main.CreationRegles.attributNom, policeMessageEtape.getFontName());
        policeMessage.setAttribute(Main.CreationRegles.attributStyle, String.valueOf(policeMessageEtape.getStyle()));
        policeMessage.setAttribute(Main.CreationRegles.attributTaille, String.valueOf(policeMessageEtape.getSize()));
*/
        
        Element options=new Element(Main.CreationRegles.attributOptions);
        options.setAttribute(Main.CreationRegles.attributTitre, TitreMessageEtapes);
        
        textuel.addContent(texte);
        textuel.addContent(options);
        
        mes.addContent(textuel);

        return mes;
    }
    
    private Element creerElementMessagePasAPas()
    {
        Element mes=new Element(Main.CreationRegles.attributMessage);
        Element texte = new Element(Main.CreationRegles.attributTexte);
        Element titre=new Element(Main.CreationRegles.attributTitre);
        titre.setText(TitreMessageEtapes);
        Element policeMessage=new Element(Main.CreationRegles.attributPoliceMessage);
        policeMessage.setAttribute(Main.CreationRegles.attributNom, policeMessageEtape.getFontName());
        policeMessage.setAttribute(Main.CreationRegles.attributStyle, String.valueOf(policeMessageEtape.getStyle()));
        policeMessage.setAttribute(Main.CreationRegles.attributTaille, String.valueOf(policeMessageEtape.getSize()));
        Element policeOptions=new Element(Main.CreationRegles.attributPoliceOptions);
        policeOptions.setAttribute(Main.CreationRegles.attributNom, policeOptionsEtape.getFontName());
        policeOptions.setAttribute(Main.CreationRegles.attributStyle, String.valueOf(policeOptionsEtape.getStyle()));
        policeOptions.setAttribute(Main.CreationRegles.attributTaille, String.valueOf(policeOptionsEtape.getSize()));
        Element couleur=new Element(Main.CreationRegles.attributCouleur);
        couleur.setAttribute(Main.CreationRegles.attributPolice, couleurPoliceMessageEtape.toString());
        couleur.setAttribute(Main.CreationRegles.attributFond, couleurFondMessageEtape.toString());
        Element options=new Element(Main.CreationRegles.attributOptions);
        mes.addContent(texte);
        mes.addContent(titre);
        mes.addContent(policeMessage);
        mes.addContent(policeOptions);
        mes.addContent(couleur);
        mes.addContent(options);
        return mes;
    }
    
    public void afficherDescriptionAction(Element act, int i)
    {
        Main.CreationRegles.TableActions.setValueAt(act.getAttributeValue(Main.CreationRegles.attributId), i, 0);

        if(act.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.stringTypeActionPasAPas))
        {
            Main.CreationRegles.TableActions.setValueAt(Main.CreationRegles.itemTypeActionPasAPas, i, 1);
            Main.CreationRegles.TableActions.setValueAt(Main.CreationRegles.stringTypeActionPasAPas+" "+act.getAttributeValue("typeAuto"), i, 2);
        }
        else if(act.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.stringTypeActionPresentationGuidee))
        {
            Main.CreationRegles.TableActions.setValueAt(Main.CreationRegles.itemTypeActionPresentationGuidee, i, 1);
        }
        else if(act.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.stringTypeActionActionInterface))
        {
            Main.CreationRegles.TableActions.setValueAt(Main.CreationRegles.itemTypeActionActionInterface, i, 1);
            Element ssact=act.getChild(Main.CreationRegles.attributEvenement);
            if(ssact.getAttributeValue(Main.CreationRegles.attributPropriete).toString().equals("clic"))
            {
                Main.CreationRegles.TableActions.setValueAt(Main.CreationRegles.invoke, i, 2);
            }
            else if(ssact.getAttributeValue(Main.CreationRegles.attributPropriete).toString().equals("focus"))
            {
                Main.CreationRegles.TableActions.setValueAt(Main.CreationRegles.setFocus, i, 2);
            }
            else if(ssact.getAttributeValue(Main.CreationRegles.attributPropriete).toString().equals(Main.CreationRegles.attributValeur))
            {
                Main.CreationRegles.TableActions.setValueAt(Main.CreationRegles.setValue, i, 2);
            }
            else if(ssact.getAttributeValue(Main.CreationRegles.attributPropriete).toString().equals("etat"))
            {
                Main.CreationRegles.TableActions.setValueAt(Main.CreationRegles.toggle, i, 2);
            }
        }
        else if(act.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.stringTypeActionMessage))
        {
            Main.CreationRegles.TableActions.setValueAt(Main.CreationRegles.itemTypeActionMessage, i, 1);
            if(act.getAttributeValue(Main.CreationRegles.attributSousType).equals(Main.CreationRegles.messageTextuel) || act.getAttributeValue(Main.CreationRegles.attributSousType).equals(Main.CreationRegles.messageTextuelVocal))
            {
                Main.CreationRegles.TableActions.setValueAt("Message = " + Main.CreationRegles.HTMLStringToString(act.getChild(Main.CreationRegles.messageTextuel).getChild(Main.CreationRegles.attributTexte).getText()), i, 2);
            }
            else
            {
                Main.CreationRegles.TableActions.setValueAt("Message = "+act.getChild(Main.CreationRegles.messageVocal).getChild(Main.CreationRegles.attributTexte).getText(), i, 2);
            }
        }
        else if(act.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.stringTypeActionMiseEnValeur))
        {
            Main.CreationRegles.TableActions.setValueAt(Main.CreationRegles.itemTypeActionMiseEnValeur, i, 1);
            String descr = Main.CreationRegles.stringDescriptionMettreEnValeurComposant;
            if (act.getChild(Main.CreationRegles.attributComposant).getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.itemEntourer)) 
            {
                descr = Main.CreationRegles.stringDescriptionEntourerComposant;
            } 
            else if (act.getChild(Main.CreationRegles.attributComposant).getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.itemColorer)) 
            {
                descr = Main.CreationRegles.stringDescriptionColorerComposant;
            } 
            else if (act.getChild(Main.CreationRegles.attributComposant).getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.itemSymbole)) 
            {
                descr = Main.CreationRegles.stringDescriptionSymboleComposant;
            } 
            else if (act.getChild(Main.CreationRegles.attributComposant).getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.attributAgentAnime)) 
            {
                descr = Main.CreationRegles.stringDescriptionAgentComposant;
            }
            descr = descr + act.getChild(Main.CreationRegles.attributComposant).getAttributeValue(Main.CreationRegles.attributId);
            Main.CreationRegles.TableActions.setValueAt(descr, i, 2);
        }
        else if(act.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.stringTypeActionMasquage))
        {
            Main.CreationRegles.TableActions.setValueAt(Main.CreationRegles.itemTypeActionMasquage, i, 1);
            String descr;
            if (act.getChild(Main.CreationRegles.attributComposant).getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.itemEstomper)) 
            {
                descr = Main.CreationRegles.stringDescriptionEstomperComposant;
            }  
            else 
            {
                descr = Main.CreationRegles.stringDescriptionOcculterComposant;
            }
            descr = descr + act.getChild(Main.CreationRegles.attributComposant).getAttributeValue(Main.CreationRegles.attributId);
            Main.CreationRegles.TableActions.setValueAt(descr, i, 2);
        }
        else if(act.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.stringTypeActionModificationProfil))
        {
            Main.CreationRegles.TableActions.setValueAt(Main.CreationRegles.itemTypeActionModificationProfil, i, 1);
            String descr;
            Element echelle=FonctionsUtiles.noeudEchelleParId(act.getChild(Main.CreationRegles.attributModification).getAttributeValue(Main.CreationRegles.attributId_echelle));
            if(act.getChild(Main.CreationRegles.attributModification).getAttributeValue(Main.CreationRegles.attributType).equals("ajout"))
            {
                descr="Attribuer la valeur ";
                if(!FonctionsUtiles.echelleEstNumerique(echelle))
                {
                    descr=descr+act.getChild(Main.CreationRegles.attributModification).getAttributeValue(Main.CreationRegles.attributValeur);
                }
                else
                {
                    descr=descr+act.getChild(Main.CreationRegles.attributModification).getAttributeValue(Main.CreationRegles.attributValeur);
                }
                descr=descr+" à l'élément "+ act.getChild(Main.CreationRegles.attributModification).getAttributeValue(Main.CreationRegles.attributChemin) +" du profil de l'utilisateur";
                Main.CreationRegles.TableActions.setValueAt(descr, i, 2);
            }
            else
            {
                descr="Modifier de "+act.getChild(Main.CreationRegles.attributModification).getAttributeValue(Main.CreationRegles.attributValeur);
                if(!FonctionsUtiles.echelleEstNumerique(echelle))
                {
                    descr=descr+" niveau(x)";
                }
                else
                {
                    descr=descr+" point(s)";
                }
                descr=descr+" la valeur de l'élément "+ act.getChild(Main.CreationRegles.attributModification).getAttributeValue(Main.CreationRegles.attributChemin) +" du profil de l'utilisateur";
                Main.CreationRegles.TableActions.setValueAt(descr, i, 2);
            }
        } 
        else if(act.getAttributeValue(Main.CreationRegles.attributType).equals("URL") || act.getAttributeValue(Main.CreationRegles.attributType).equals("fichier") 
                ||act.getAttributeValue(Main.CreationRegles.attributType).equals("application"))
        {
            Main.CreationRegles.TableActions.setValueAt(act.getAttributeValue(Main.CreationRegles.attributType), i, 1);
            Main.CreationRegles.TableActions.setValueAt(act.getAttributeValue(Main.CreationRegles.attributChemin), i, 2);
        }
        else if(act.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.stringTypeActionAnimation))
        {
            Main.CreationRegles.TableActions.setValueAt(Main.CreationRegles.itemTypeActionAnimation, i, 1);
            String descr = "";
            if (!act.getAttributeValue(Main.CreationRegles.attributPersonnage).isEmpty()) {
                descr = act.getAttributeValue(Main.CreationRegles.attributPersonnage) + " : ";
            }
            for (int j = 0; j < act.getChildren().size(); j++) {
                Element sousact = (Element) act.getChildren().get(j);
                descr = descr + sousact.getAttributeValue(Main.CreationRegles.attributType) + ", ";
            }
            descr = descr.substring(0, descr.length() - 2);
            Main.CreationRegles.TableActions.setValueAt(descr, i, 2);
        }
        else if(act.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.stringTypeActionAjoutComposant))
        {
            Element compo = act.getChild(Main.CreationRegles.attributComposant);
            Main.CreationRegles.TableActions.setValueAt(Main.CreationRegles.itemTypeActionAjoutComposant, i, 1);
            Main.CreationRegles.TableActions.setValueAt("ajouter un "+compo.getAttributeValue(Main.CreationRegles.attributType)+" près du composant "+compo.getAttributeValue(Main.CreationRegles.attributId), i, 2);
        }
    }
    
    private Element creerActionAgentAnime() {
        SousAction _SousAction;
        Element elem = new Element(Main.CreationRegles.attributAction);
        elem.setAttribute(Main.CreationRegles.attributId, TxtNomAction.getText());
        elem.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.stringTypeActionAnimation);        
        elem.setAttribute(Main.CreationRegles.attributAgent, "DoubleAgent.Control");
        
        if(CbPersoActionAgentAnime.getSelectedItem().toString().equals(" "))       
            elem.setAttribute(Main.CreationRegles.attributPersonnage, "");
        else
            elem.setAttribute(Main.CreationRegles.attributPersonnage, CbPersoActionAgentAnime.getSelectedItem().toString());
        Iterator<SousAction> it = listeSousActions.getListe().iterator();
        while (it.hasNext()) {
            _SousAction = it.next();
            elem.addContent(_SousAction.creerSousAction());
        }
        return elem;
    }
    
    private Element creerActionAjoutComposant()
    {
        Element act=new Element(Main.CreationRegles.attributAction);
        act.setAttribute(Main.CreationRegles.attributId, TxtNomAction.getText());
        act.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.stringTypeActionAjoutComposant);
        act.setAttribute(Main.CreationRegles.attributNom, "C"+Main.CreationRegles.idComposantAjoute);
        
        Element compo = new Element(Main.CreationRegles.attributComposant);
        compo.setAttribute(Main.CreationRegles.attributId, TxtIdActionAjoutComposant.getText());
        String t = Main.CreationRegles.stringTypeComposantAjouteBouton;
        if(Main.CreationRegles.itemTypeComposantAjouteLabel.equals(CbTypeActionAjoutComposant.getSelectedItem().toString()))
            t=Main.CreationRegles.stringTypeComposantAjouteLabel;
        else if(Main.CreationRegles.itemTypeComposantAjouteImage.equals(CbTypeActionAjoutComposant.getSelectedItem().toString()))
            t=Main.CreationRegles.stringTypeComposantAjouteImage;
        compo.setAttribute(Main.CreationRegles.attributType, t);
        
        if(Main.CreationRegles.itemTypeComposantAjouteBouton.equals(CbTypeActionAjoutComposant.getSelectedItem().toString()))
        {
            if(CheckTexteBoutonActionAjoutComposant.isSelected())
                compo.setAttribute(Main.CreationRegles.attributTexte, TxtTexteBoutonActionAjoutComposant.getText());
            
            if(CheckInfoBulleBoutonActionAjoutComposant.isSelected())
                compo.setAttribute(Main.CreationRegles.attributInfobulle, TxtInfoBulleBoutonActionAjoutComposant.getText());
            
            if(CheckIconeBoutonActionAjoutComposant.isSelected())
                compo.setAttribute(Main.CreationRegles.attributIcone, BtIconeBoutonActionAjoutComposant.getToolTipText());
        }
        else if(Main.CreationRegles.itemTypeComposantAjouteLabel.equals(CbTypeActionAjoutComposant.getSelectedItem().toString()))
        {
            compo.setAttribute(Main.CreationRegles.attributTexte, TxtTexteLabelActionAjoutComposant.getText());
            
            if(CheckIconeLabelActionAjoutComposant.isSelected())
                compo.setAttribute(Main.CreationRegles.attributIcone, BtIconeLabelActionAjoutComposant.getToolTipText());
            
            
        }
        else if(Main.CreationRegles.itemTypeComposantAjouteImage.equals(CbTypeActionAjoutComposant.getSelectedItem().toString()))
        {
            compo.setAttribute(Main.CreationRegles.attributIcone, BtIconeImageActionAjoutComposant.getToolTipText());
        }
        
        if(PanelDetailsActionAjoutComposant.isVisible())
        {
            String d = Main.CreationRegles.stringParLaGauche;
            if(CbDirectionActionAjoutComposant.getSelectedItem().toString().equals(Main.CreationRegles.itemParLaDroite))
                d=Main.CreationRegles.stringParLaDroite;
            else if(CbDirectionActionAjoutComposant.getSelectedItem().toString().equals(Main.CreationRegles.itemParLeHaut))
                d=Main.CreationRegles.stringParLeHaut;
            else if(CbDirectionActionAjoutComposant.getSelectedItem().toString().equals(Main.CreationRegles.itemParLeBas))
                d=Main.CreationRegles.stringParLeBas;
            compo.setAttribute(Main.CreationRegles.attributDirection, d);

            compo.setAttribute(Main.CreationRegles.attributLargeur, SpinLargeurActionAjoutComposant.getValue().toString());
            compo.setAttribute(Main.CreationRegles.attributHauteur, SpinLargeurActionAjoutComposant.getValue().toString());
            
            if(PanelPoliceActionAjoutComposant.isVisible())
            {
                compo.setAttribute(Main.CreationRegles.attributPolice, BtPoliceActionAjoutComposant.getFont().toString());
                compo.setAttribute(Main.CreationRegles.attributCouleur, BtPoliceActionAjoutComposant.getForeground().toString());
            }
        }
        act.addContent(compo);
        
        return act;
    }
    
    private Element creerActionRessource() {
        Element elem = new Element(Main.CreationRegles.attributAction);
        elem.setAttribute(Main.CreationRegles.attributId, TxtNomAction.getText());
        
        String typeA="fichier";
        if(CbTypeActionRessource.getSelectedItem().toString().equals(Main.CreationRegles.itemOuvrirURLActionRessource))
            typeA="URL";
        else if(CbTypeActionRessource.getSelectedItem().toString().equals(Main.CreationRegles.itemOuvrirAppliActionRessource))
            typeA="application";
        elem.setAttribute(Main.CreationRegles.attributType, typeA);
        elem.setAttribute(Main.CreationRegles.attributChemin, TxtCheminActionRessource.getText());
        
        return elem;
    }
    
    private Element creerActionMessage()
    {
        Element act = new Element(Main.CreationRegles.attributAction);
        act.setAttribute(Main.CreationRegles.attributId, TxtNomAction.getText());
        
        String typeMessage=Main.CreationRegles.messageTextuel;       
        if(CheckEcritActionMessage.isSelected())
        {
            if(CheckOralActionMessage.isSelected())
            {
                typeMessage=Main.CreationRegles.messageTextuelVocal;
            }
        }
        else
        {
            if(CheckOralActionMessage.isSelected())
            {
                typeMessage=Main.CreationRegles.messageVocal;
            }
        }  
        act.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.stringTypeActionMessage);
        act.setAttribute(Main.CreationRegles.attributSousType, typeMessage);
        
        String assist="";
        
        if(!CbModeActionMessage.getSelectedItem().toString().isEmpty())
        {
            if(CbModeActionMessage.getSelectedItem().equals(Main.CreationRegles.itemAgentAnime))
                assist=Main.CreationRegles.attributAgentAnime;
            else
                assist=Main.CreationRegles.assistantMessager;
        }
        act.setAttribute("assistant", assist);
        
        if(typeMessage.equals(Main.CreationRegles.messageTextuel) || typeMessage.equals(Main.CreationRegles.messageTextuelVocal))
        {
            Element nt=new Element(Main.CreationRegles.attributTextuel);
            Element text= new Element (Main.CreationRegles.attributTexte);
            if(CheckMiseEnFormeActionMessage.isSelected())
                text.setText(Main.CreationRegles.stringToHTMLString(Main.CreationRegles.editor.getText()));
            else
            {
                text.setText(Main.CreationRegles.HTMLStringToString(Main.CreationRegles.editor.getText()));
                System.out.println("_"+text.getText()+"_");
            }
            //text.setText(Main.CreationRegles.stringToHTMLString(Main.CreationRegles.editor.getText()));
            nt.addContent(text);
            
            //si le concepteur a définit plus de détails sur la fenêtre
            if(PanelDetailsPopupActionMessage.isVisible())  //si le concepteur a spécifié des détails pour la fenetre popup
            {
                Element options= new Element(Main.CreationRegles.attributOptions);
                options.setAttribute(Main.CreationRegles.attributTitre, TxtTitreFenetreActionMessage.getText());
                Element po=new Element("position");
                String p;
                if(BtRbPositionSourisPopupActionMessage.isSelected())
                {
                    p="souris";
                }
                else if(RbPositionCoordonneesPopupActionMessage.isSelected())
                {
                    p="coordonnees";
                    Element e=new Element(p);
                    e.setAttribute("X", SpinXPopupActionMessage.getValue().toString());
                    e.setAttribute("Y", SpinYPopupActionMessage.getValue().toString());
                    po.addContent(e);
                }
                else
                {
                    p="ecran";
                    Element e=new Element(p);
                    
                    String c = Main.CreationRegles.attributCentre;
                    if(CbPositionHorizontalePopupActionMessage.getSelectedItem().equals(Main.CreationRegles.itemGauche))
                        c=Main.CreationRegles.attributGauche;
                    else if(CbPositionHorizontalePopupActionMessage.getSelectedItem().equals(Main.CreationRegles.itemDroite))
                        c=Main.CreationRegles.attributDroite;
                    e.setAttribute(Main.CreationRegles.attributHorizontal, c);
                    
                    c = Main.CreationRegles.attributCentre;
                    if(CbPositionVerticalePopupActionMessage.getSelectedItem().equals(Main.CreationRegles.itemHaut))
                        c=Main.CreationRegles.attributHaut;
                    else if(CbPositionVerticalePopupActionMessage.getSelectedItem().equals(Main.CreationRegles.itemBas))
                        c=Main.CreationRegles.attributBas;
                    e.setAttribute(Main.CreationRegles.attributVertical, c);
                    po.addContent(e);
                }
                po.setAttribute(Main.CreationRegles.attributType, p);
                options.addContent(po);
                Element taille=new Element(Main.CreationRegles.attributTaille);
                if(BtTailleAutomatiquePopupActionMessage.isSelected())
                {
                    taille.setAttribute(Main.CreationRegles.attributType, "automatique");
                }
                else
                {
                    taille.setAttribute(Main.CreationRegles.attributType, "manuel");
                    taille.setAttribute("hauteur", SpinHauteurFenetrePopupActionMessage.getValue().toString());
                    taille.setAttribute("largeur", SpinLargeurFenetrePopupActionMessage.getValue().toString());
                }
                options.addContent(taille);
                nt.addContent(options);
            }
            else if(PanelDetailsAgentActionMessage.isVisible())//si le concepteur a spécifié des détails pour l'agent animé
            {
                text.setText(Main.CreationRegles.HTMLStringToString(Main.CreationRegles.editor.getText()));
                Element options= new Element(Main.CreationRegles.attributOptions);
                Element po=new Element("position");
                String p;
                if(BtRbPositionSourisAgentActionMessage.isSelected())
                {
                    p="souris";
                }
                else if(RbPositionCoordonneesAgentActionMessage.isSelected())
                {
                    p="coordonnees";
                    Element e=new Element(p);
                    e.setAttribute("X", SpinXAgentActionMessage.getValue().toString());
                    e.setAttribute("Y", SpinYAgentActionMessage.getValue().toString());
                    po.addContent(e);
                }
                else
                {
                    p="ecran";
                    Element e=new Element(p);
                    String c = Main.CreationRegles.attributCentre;
                    if(CbPositionHorizontaleAgentActionMessage.getSelectedItem().equals(Main.CreationRegles.itemGauche))
                        c=Main.CreationRegles.attributGauche;
                    else if(CbPositionHorizontaleAgentActionMessage.getSelectedItem().equals(Main.CreationRegles.itemDroite))
                        c=Main.CreationRegles.attributDroite;
                    e.setAttribute(Main.CreationRegles.attributHorizontal, c);
                    
                    c = Main.CreationRegles.attributCentre;
                    if(CbPositionVerticaleAgentActionMessage.getSelectedItem().equals(Main.CreationRegles.itemHaut))
                        c=Main.CreationRegles.attributHaut;
                    else if(CbPositionVerticaleAgentActionMessage.getSelectedItem().equals(Main.CreationRegles.itemBas))
                        c=Main.CreationRegles.attributBas;
                    e.setAttribute(Main.CreationRegles.attributVertical, c);
                    po.addContent(e);
                }
                po.setAttribute(Main.CreationRegles.attributType, p);
                options.addContent(po);
                Element ag = new Element(Main.CreationRegles.attributAgent);
                ag.setAttribute(Main.CreationRegles.attributPersonnage, Main.CreationRegles.personnageMessage);
                options.addContent(ag);
                nt.addContent(options);
            }
            act.addContent(nt);
            
            if(typeMessage.equals(Main.CreationRegles.messageTextuelVocal))
            {
                Element vocal=new Element(Main.CreationRegles.attributVocal);
                Element texte=new Element(Main.CreationRegles.attributTexte);
                if(CheckDifferentActionMessage.isSelected())
                {
                    vocal.setAttribute("different", "vrai");
                    texte.setText(TxtDifferentActionMessage.getText());
                }
                else
                {
                    vocal.setAttribute("different", "faux");
                    texte.setText(Main.CreationRegles.editor.getText());
                }
                vocal.addContent(texte);
                act.addContent(vocal);
            }
        }
        else
        {
            Element vocal=new Element(Main.CreationRegles.attributVocal);
            Element texte = new Element(Main.CreationRegles.attributTexte);
            if (CheckDifferentActionMessage.isSelected()) 
            {
                vocal.setAttribute("different", "vrai");
                texte.setText(TxtDifferentActionMessage.getText());
            } 
            else 
            {
                vocal.setAttribute("different", "faux");
                texte.setText(Main.CreationRegles.editor.getText());
            }
            vocal.addContent(texte);
            act.addContent(vocal);
        }
        
        return act;
    }
    
    private Element creerActionModifierProfil()
    {
        //on cherche l'échelle de l'élément
        String chemin = ArbreActionProfil.getSelectionPath().toString().replace("profil, ", "");
        chemin = chemin.substring(1, chemin.length());
        if (chemin.contains(",")) 
        {
            chemin = chemin.substring(0, chemin.indexOf(","));
        } 
        else 
        {
            chemin = chemin.substring(0, chemin.length() - 1);
        }
        Element compo = Main.CreationRegles.briqueParNom(Main.Cste.cheminStructuresProfils + Main.Cste.structureProfils, chemin);
        compo = (Element) compo.getChild(Main.CreationRegles.attributInfos_echelle).getChildren().get(0);
        Main.CreationRegles.id_echelleActionProfil = compo.getAttributeValue(Main.CreationRegles.attributId);
        
        Element elem=new Element(Main.CreationRegles.attributAction);
        elem.setAttribute(Main.CreationRegles.attributId, TxtNomAction.getText());
        elem.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.stringTypeActionModificationProfil);
        
        Element noeud=new Element(Main.CreationRegles.attributModification);
        String typ;
        String val;
        Element echelle=FonctionsUtiles.noeudEchelleParId(Main.CreationRegles.id_echelleActionProfil);
        if(PanelExacteActionModifierProfil.isVisible())
        {
            typ="ajout";
            if(FonctionsUtiles.echelleEstNumerique(echelle))
            {
                val=SpinExacteActionModifierProfil.getValue().toString();
            }
            else
            {
                val=CbNiveauxActionModifierProfil.getSelectedItem().toString();
            }
        }
        else
        {
            typ=Main.CreationRegles.attributModification;
            val=SpinModifierActionModifierProfil.getValue().toString();
        }
        noeud.setAttribute(Main.CreationRegles.attributType, typ);
        
        noeud.setAttribute(Main.CreationRegles.attributChemin, TxtElementActionModifierProfil.getText());
        noeud.setAttribute(Main.CreationRegles.attributId_echelle, Main.CreationRegles.id_echelleActionProfil);
        noeud.setAttribute(Main.CreationRegles.attributSource, TxtSourceActionModifierProfil.getText());
        noeud.setAttribute(Main.CreationRegles.attributValeur, val);
        
        elem.addContent(noeud);

        return elem;
    }
    
    private Element creerActionInterface()
    {
        Element act=new Element(Main.CreationRegles.attributAction);
        act.setAttribute(Main.CreationRegles.attributId, TxtNomAction.getText());
        act.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.stringTypeActionActionInterface);
        act.setAttribute("typeAuto", Main.CreationRegles.attributAutomatise);
        
        Element ssact=new Element(Main.CreationRegles.attributEvenement);
        ssact.setAttribute(Main.CreationRegles.attributIdComp, TxtComposantActionInterface.getText());
        if(CbActionActionInterface.getSelectedItem().toString().equals(Main.CreationRegles.invoke) || CbActionActionInterface.getSelectedItem().toString().equals(Main.CreationRegles.select))
        {
            ssact.setAttribute(Main.CreationRegles.attributPropriete, "clic");
        }
        else if(CbActionActionInterface.getSelectedItem().toString().equals(Main.CreationRegles.setFocus))
        {
            ssact.setAttribute(Main.CreationRegles.attributPropriete, "focus");
        }
        else if(CbActionActionInterface.getSelectedItem().toString().equals(Main.CreationRegles.setValue))
        {
            ssact.setAttribute(Main.CreationRegles.attributPropriete, Main.CreationRegles.attributValeur);
            ssact.setAttribute(Main.CreationRegles.attributValeur, TxtValeurActionInterface.getText());
        }
        else if(CbActionActionInterface.getSelectedItem().toString().equals(Main.CreationRegles.toggle))
        {
            ssact.setAttribute(Main.CreationRegles.attributPropriete, "etat");
            if(RbOnActionInterface.isSelected())
                ssact.setAttribute(Main.CreationRegles.attributValeur, "On");
            else
                ssact.setAttribute(Main.CreationRegles.attributValeur, "Off");
        }
        
        act.addContent(ssact);
        
        return act;
    }
    
    private Element creerActionPasaPas()
    {
        Element act=new Element(Main.CreationRegles.attributAction);
        act.setAttribute(Main.CreationRegles.attributId, TxtNomAction.getText());
        act.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.stringTypeActionPasAPas);
        String t = Main.CreationRegles.attributAutomatise;
        if(CbTypeActionPasaPas.getSelectedItem().equals(Main.CreationRegles.itemGuide))
            t=Main.CreationRegles.attributGuide;
        act.setAttribute("typeAuto", t);
        act.setAttribute("listeEtapes", CbEtapesActionPasaPas.getSelectedItem().toString());
        
        //on ajoute les options générales du pas à pas
        if(CheckMessageAvantActionPasaPas.isSelected())
        {
            Element mes=creerElementMessagePasAPas();
            mes.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributAvant);
            mes.getChild(Main.CreationRegles.attributTexte).setText(MessageAvantEtapesPasAPas);

            if(CheckMessageAvantAutorisationActionPasaPas.isSelected())
            {
                mes.getChild(Main.CreationRegles.attributTexte).setText(MessageAvantEtapesPasAPas+"\n"+MessageAvantEtapesDemande);
                mes.setAttribute(Main.CreationRegles.attributDemande, Main.CreationRegles.attributOui);
                Element options=mes.getChild(Main.CreationRegles.attributOptions);
                Element option1=new Element(Main.CreationRegles.attributOption);
                option1.setAttribute(Main.CreationRegles.attributLabel, MessageAvantEtapesDemandeOui);
                Element option2=new Element(Main.CreationRegles.attributOption);
                option2.setAttribute(Main.CreationRegles.attributLabel, MessageAvantEtapesDemandeNon);
                options.addContent(option1);
                options.addContent(option2);
            }
            else
            {
                mes.setAttribute(Main.CreationRegles.attributDemande, Main.CreationRegles.attributNon);
                Element options=mes.getChild(Main.CreationRegles.attributOptions);
                Element option1=new Element(Main.CreationRegles.attributOption);
                option1.setAttribute(Main.CreationRegles.attributLabel, MessageAvantEtapesDemandeOui);
                options.addContent(option1);
            }
            act.addContent(mes);
        }
        
        if(CheckMessageApresActionPasaPas.isSelected())
        {
            Element mes=creerElementMessagePasAPas();
            mes.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributApres);
            
            Element options=mes.getChild(Main.CreationRegles.attributOptions);
            Element option1=new Element(Main.CreationRegles.attributOption);
            option1.setAttribute(Main.CreationRegles.attributLabel, MessageApresEtapeDemandeOk);
            options.addContent(option1);
            
            mes.getChild(Main.CreationRegles.attributTexte).setText(MessageApresPasaPas);

            if(CheckMessageApresBilanActionPasaPas.isSelected())
            {
                mes.setAttribute(Main.CreationRegles.attributBilan, Main.CreationRegles.attributOui);
            }
            else
            {
                mes.setAttribute(Main.CreationRegles.attributBilan, Main.CreationRegles.attributNon);
            }
            act.addContent(mes);
        }
        
        if(CheckProgressionActionPasaPas.isSelected())
        {
            Element mes=new Element(Main.CreationRegles.attributMessage);
            mes.setAttribute(Main.CreationRegles.attributType, "progression");
            act.addContent(mes);
        }
        
        boolean messAvant=false;
        boolean messApres=false;
        Element etapes=new Element("etapes");
        if(CheckExpliquerEtapeActionPasaPas.isSelected())
        {
            messAvant=true;
            Element mes= new Element(Main.CreationRegles.attributMessage);
            mes.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributAvant);
            if(CheckExpliquerEtapeAutorisationActionPasaPas.isSelected())
                mes.setAttribute(Main.CreationRegles.attributDemande, Main.CreationRegles.attributOui);
            else
                mes.setAttribute(Main.CreationRegles.attributDemande, Main.CreationRegles.attributNon); 
            etapes.addContent(mes);
        }
        
        if(CheckExpliquerEtapeTermineeActionPasaPas.isSelected())
        {
            messApres=true;
            Element mes= new Element(Main.CreationRegles.attributMessage);
            mes.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributApres);
            etapes.addContent(mes);
        }
        
        if(CheckTimerActionPasaPas.isSelected())
        {
            Element timer=new Element(Main.CreationRegles.attributTimer);
            timer.setAttribute("secondes", SpinTimerActionPasaPas.getValue().toString());
            etapes.addContent(timer);
        }
        
        if(CheckMiseEnValeurActionPasaPas.isSelected())
        {           
            etapes.addContent((Element) elementMiseEnValeurEtape.clone());
        }
        
        act.addContent(etapes);
        
        //on ajoute chaque étape du pas à pas
        Element noeud=(Element) Main.CreationRegles.elementParId(Main.CreationRegles.lesSequences, CbEtapesActionPasaPas.getSelectedItem().toString().substring(0, CbEtapesActionPasaPas.getSelectedItem().toString().indexOf("_")));
        for(int i=0; i<noeud.getChildren().size(); i++)
        {
            Element ssact= (Element) noeud.getChildren().get(i);
            ssact=(Element) ssact.clone();
            act.addContent(ssact);
            if(!ssact.getAttributeValue(Main.CreationRegles.attributIdComp).isEmpty())    //si c'est pas un sous action d'ouverture de fenetre
            {
                if(messAvant)
                {
                    Element mes=creerElementMessagePasAPas();
                    mes.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributAvant);
                    mes.getChild(Main.CreationRegles.attributTexte).setText(choixMessagesAvantEtapePasaPas[i]);
                    
                    if(CheckExpliquerEtapeAutorisationActionPasaPas.isSelected())
                    {
                        mes.getChild(Main.CreationRegles.attributTexte).setText(choixMessagesAvantEtapePasaPas[i]+"\n"+MessageAvantEtapeDemande);
                        mes.setAttribute(Main.CreationRegles.attributDemande, Main.CreationRegles.attributOui);
                        Element options=mes.getChild(Main.CreationRegles.attributOptions);
                        Element option1=new Element(Main.CreationRegles.attributOption);
                        option1.setAttribute(Main.CreationRegles.attributLabel, MessageAvantEtapeDemandeOui);
                        Element option2=new Element(Main.CreationRegles.attributOption);
                        option2.setAttribute(Main.CreationRegles.attributLabel, MessageAvantEtapeDemandeNon);
                        options.addContent(option1);
                        options.addContent(option2);
                    }
                    else
                    {
                        mes.setAttribute(Main.CreationRegles.attributDemande, Main.CreationRegles.attributNon);
                        Element options=mes.getChild(Main.CreationRegles.attributOptions);
                        Element option1=new Element(Main.CreationRegles.attributOption);
                        option1.setAttribute(Main.CreationRegles.attributLabel, MessageApresEtapeOk);
                        options.addContent(option1);
                    }                  
                    
                    ssact.addContent(mes);
                }
                
                if(messApres)
                {
                    Element mes=creerElementMessagePasAPas();
                    mes.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributApres);
                    mes.getChild(Main.CreationRegles.attributTexte).setText(choixMessagesApresEtapePasaPas[i]);
                    mes.setAttribute(Main.CreationRegles.attributDemande, Main.CreationRegles.attributNon);
                    Element options = mes.getChild(Main.CreationRegles.attributOptions);
                    Element option1 = new Element(Main.CreationRegles.attributOption);
                    option1.setAttribute(Main.CreationRegles.attributLabel, MessageApresEtapeOk);
                    options.addContent(option1);
                    ssact.addContent(mes);
                }
            }
        }
        
        return act;
    }
    
    private Element creerActionPresentationGuidee()
    {
        Element act=new Element(Main.CreationRegles.attributAction);
        act.setAttribute(Main.CreationRegles.attributId, TxtNomAction.getText());
        act.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.stringTypeActionPresentationGuidee);
        act.setAttribute("listeEtapes", CbEtapesActionPresentationGuidee.getSelectedItem().toString());
        
        //on ajoute les options générales de la présentation guidée
        if(CheckMessageAvantActionPresentationGuidee.isSelected())
        {
            Element mes=creerElementMessagePasAPas();
            mes.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributAvant);
            mes.getChild(Main.CreationRegles.attributTexte).setText(MessageAvantEtapesPresentationGuidee);

            if(CheckMessageAvantAutorisationActionPresentationGuidee.isSelected())
            {
                mes.getChild(Main.CreationRegles.attributTexte).setText(MessageAvantEtapesPresentationGuidee+"\n"+MessageAvantEtapesDemande);
                mes.setAttribute(Main.CreationRegles.attributDemande, Main.CreationRegles.attributOui);
                Element options=mes.getChild(Main.CreationRegles.attributOptions);
                Element option1=new Element(Main.CreationRegles.attributOption);
                option1.setAttribute(Main.CreationRegles.attributLabel, MessageAvantEtapesDemandeOui);
                Element option2=new Element(Main.CreationRegles.attributOption);
                option2.setAttribute(Main.CreationRegles.attributLabel, MessageAvantEtapesDemandeNon);
                options.addContent(option1);
                options.addContent(option2);
            }
            else
            {
                mes.setAttribute(Main.CreationRegles.attributDemande, Main.CreationRegles.attributNon);
                Element options=mes.getChild(Main.CreationRegles.attributOptions);
                Element option1=new Element(Main.CreationRegles.attributOption);
                option1.setAttribute(Main.CreationRegles.attributLabel, MessageAvantEtapesDemandeOui);
                options.addContent(option1);
            }
            act.addContent(mes);
        }
        
        if(CheckMessageApresActionPresentationGuidee.isSelected())
        {
            Element mes=creerElementMessagePasAPas();
            mes.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributApres);
            
            Element options=mes.getChild(Main.CreationRegles.attributOptions);
            Element option1=new Element(Main.CreationRegles.attributOption);
            option1.setAttribute(Main.CreationRegles.attributLabel, MessageApresEtapeDemandeOk);
            options.addContent(option1);
            
            mes.getChild(Main.CreationRegles.attributTexte).setText(MessageApresPresentationGuidee);
            act.addContent(mes);
        }
        
        boolean messAvant=false;
        Element etapes=new Element("etapes");
        if(CheckExpliquerEtapeActionPresentationGuidee.isSelected())
        {
            messAvant=true;
            Element mes= new Element(Main.CreationRegles.attributMessage);
            mes.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributAvant);
            if(CheckExpliquerEtapeAutorisationActionPresentationGuidee.isSelected())
                mes.setAttribute(Main.CreationRegles.attributDemande, Main.CreationRegles.attributOui);
            else
                mes.setAttribute(Main.CreationRegles.attributDemande, Main.CreationRegles.attributNon); 
            etapes.addContent(mes);
        }
        
        if(CheckTimerActionPresentationGuidee.isSelected())
        {
            Element timer=new Element(Main.CreationRegles.attributTimer);
            timer.setAttribute("secondes", SpinTimerActionPresentationGuidee.getValue().toString());
            etapes.addContent(timer);
        }
        
        etapes.addContent((Element) elementMiseEnValeurEtape.clone());
        
        act.addContent(etapes);
        
        //on ajoute chaque étape du pas à pas
        Element noeud=(Element) Main.CreationRegles.elementParId(Main.CreationRegles.lesSequences, CbEtapesActionPresentationGuidee.getSelectedItem().toString().substring(0, CbEtapesActionPresentationGuidee.getSelectedItem().toString().indexOf("_")));
        for(int i=0; i<noeud.getChildren().size(); i++)
        {
            Element ssact= (Element) noeud.getChildren().get(i);
            ssact=(Element) ssact.clone();
            act.addContent(ssact);
            if(!ssact.getAttributeValue(Main.CreationRegles.attributIdComp).isEmpty())    //si c'est pas un sous action d'ouverture de fenetre
            {
                if(messAvant)
                {                   
                    Element mes;
                    if(CheckExpliquerEtapeAutorisationActionPresentationGuidee.isSelected())
                    {
                        mes=creerElementMessagePasAPas();
                        mes.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributAvant);
                        mes.getChild(Main.CreationRegles.attributTexte).setText(choixMessagesAvantEtapePresentationGuidee[i]);
                        
                       
                        mes.setAttribute(Main.CreationRegles.attributDemande, Main.CreationRegles.attributOui);
                        Element options=mes.getChild(Main.CreationRegles.attributOptions);
                        Element option1=new Element(Main.CreationRegles.attributOption);
                        option1.setAttribute(Main.CreationRegles.attributLabel, MessageAvantEtapeDemandeOui);
                        Element option2=new Element(Main.CreationRegles.attributOption);
                        option2.setAttribute(Main.CreationRegles.attributLabel, MessageAvantEtapeDemandeNon);
                        options.addContent(option1);
                        options.addContent(option2);
                    }
                    else
                    {
                        mes=creerElementMessagePresentationGuidee();
                        mes.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributMessage);
                        String t = ajoutCouleurFond(choixMessagesAvantEtapePresentationGuidee[i], Integer.toHexString(couleurFondMessageEtape.getRGB()));
                        
                        mes.getChild(Main.CreationRegles.attributTextuel).getChild(Main.CreationRegles.attributTexte).setText(t); 
                        
                    }                                      
                    ssact.addContent(mes);
                }
            }
        }
        
        return act;
    }
    
    private Element creerActionMiseEnValeur()
    {
        Element act=new Element(Main.CreationRegles.attributAction);
        act.setAttribute(Main.CreationRegles.attributId, TxtNomAction.getText());
        if(CbChoixTypeAction.getSelectedItem().equals(Main.CreationRegles.itemTypeActionMiseEnValeur))
            act.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.stringTypeActionMiseEnValeur);
        else
            act.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.stringTypeActionMasquage);
        
        Element composant=new Element(Main.CreationRegles.attributComposant);
        composant.setAttribute(Main.CreationRegles.attributId, TxtIdActionMiseEnValeur.getText());        
        
        if(PanelActionMiseEnValeur.isVisible())
        {
            if(CbTypeActionMiseEnValeur.getSelectedItem().toString().isEmpty())
            {
                composant.setAttribute(Main.CreationRegles.attributType, "");
            }
            else if(Main.CreationRegles.typeColorer)
            {
                composant.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributColorer);
                if(Main.CreationRegles.afficherDetailsMiseEnValeur)
                {
                    composant.setAttribute(Main.CreationRegles.attributCouleur, BtCouleurActionMiseEnValeur.getBackground().toString());           
                    composant.setAttribute(Main.CreationRegles.attributTransparence, SpinTransparenceActionMiseEnValeur.getValue().toString());
                    if(CheckDureeActionMiseEnValeurColorer.isSelected())
                    {
                        int valTimer = Integer.parseInt(SpinDureeActionMiseEnValeurColorer.getValue().toString())*1000;
                        act.setAttribute(Main.CreationRegles.attributTimer, String.valueOf(valTimer));
                    }
                }
            }
            else if(Main.CreationRegles.typeEntourer)
            {
                composant.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributEntourer);
                if(Main.CreationRegles.afficherDetailsMiseEnValeur)
                {
                    composant.setAttribute(Main.CreationRegles.attributCouleur, BtEntourerCouleurActionMiseEnValeur.getBackground().toString());
                    composant.setAttribute(Main.CreationRegles.attributArrondi, SpinArrondiActionMiseEnValeur.getValue().toString());
                    composant.setAttribute(Main.CreationRegles.attributEloignement, SpinEloignementActionMiseEnValeur.getValue().toString());
                    composant.setAttribute(Main.CreationRegles.attributEpaisseur, SpinEpaisseurActionMiseEnValeur.getValue().toString());
                    
                    if(CheckDureeActionMiseEnValeurEntourer.isSelected())
                    {
                        int valTimer = Integer.parseInt(SpinDureeActionMiseEnValeurEntourer.getValue().toString())*1000;
                        act.setAttribute(Main.CreationRegles.attributTimer, String.valueOf(valTimer));
                    }
                }
            }
            else if(Main.CreationRegles.typeSymbole)
            {
                composant.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributSymbole);
                if(Main.CreationRegles.afficherDetailsMiseEnValeur)
                {
                    String dir=Main.CreationRegles.stringParLaGauche;
                    if(CbDirectionActionMiseEnValeur.getSelectedItem().equals(Main.CreationRegles.itemParLaDroite))
                        dir=Main.CreationRegles.stringParLaDroite;
                    else if(CbDirectionActionMiseEnValeur.getSelectedItem().equals(Main.CreationRegles.itemParLeHaut))
                        dir=Main.CreationRegles.stringParLeHaut;
                    else if(CbDirectionActionMiseEnValeur.getSelectedItem().equals(Main.CreationRegles.itemParLeBas))
                        dir=Main.CreationRegles.stringParLeBas;
                    composant.setAttribute(Main.CreationRegles.attributDirection, dir);
                    composant.setAttribute(Main.CreationRegles.attributSymbole, Main.CreationRegles.fichierSymbole);
                    
                    if(CheckDureeActionMiseEnValeurSymbole.isSelected())
                    {
                        int valTimer = Integer.parseInt(SpinDureeActionMiseEnValeurSymbole.getValue().toString())*1000;
                        act.setAttribute(Main.CreationRegles.attributTimer, String.valueOf(valTimer));
                    }
                }
            }
            else if(Main.CreationRegles.typeAgent)
            {
                composant.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.attributAgentAnime);
                if(Main.CreationRegles.afficherDetailsMiseEnValeur)
                {
                    String dir=Main.CreationRegles.stringParLaGauche;
                    if(CbDirectionActionMiseEnValeurAgent.getSelectedItem().equals(Main.CreationRegles.itemParLaDroite))
                        dir=Main.CreationRegles.stringParLaDroite;
                    else if(CbDirectionActionMiseEnValeurAgent.getSelectedItem().equals(Main.CreationRegles.itemParLeHaut))
                        dir=Main.CreationRegles.stringParLeHaut;
                    else if(CbDirectionActionMiseEnValeurAgent.getSelectedItem().equals(Main.CreationRegles.itemParLeBas))
                        dir=Main.CreationRegles.stringParLeBas;
                    composant.setAttribute(Main.CreationRegles.attributDirection, dir);
                    composant.setAttribute(Main.CreationRegles.attributPersonnage, Main.CreationRegles.personnageMiseEnValeur);
                    
                    if(CheckDureeActionMiseEnValeurAgent.isSelected())
                    {
                        int valTimer = Integer.parseInt(SpinDureeActionMiseEnValeurAgent.getValue().toString())*1000;
                        act.setAttribute(Main.CreationRegles.attributTimer, String.valueOf(valTimer));
                    }
                }
            }
        }
        else    //on est dans une action de type masquage
        {
            String c = Main.CreationRegles.attributEstomper;
            if(CbTypeActionMasquage.getSelectedItem().equals(Main.CreationRegles.itemOcculter))
                c=Main.CreationRegles.attributOcculter;
            composant.setAttribute(Main.CreationRegles.attributType, c);
            if(PanelEstomperActionMasquage.isVisible())
            {
                if(RbChoixCouleurActionMasquage.isSelected())
                    composant.setAttribute(Main.CreationRegles.attributCouleur, BtCouleurActionMasquage.getBackground().toString()); 
                else
                    composant.setAttribute(Main.CreationRegles.attributCouleur, "pere");

                if(PanelTransparenceActionMasquage.isVisible())
                {                
                    composant.setAttribute(Main.CreationRegles.attributTransparence, SpinTransparenceActionMasquage.getValue().toString());
                }
                else
                {
                    composant.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.itemOcculter);
                }
            }
        }
        
        act.addContent(composant);
        return act;
    }
    
    private void viderPanelSousAction(){
        LbHorizontaleSSActionAnimation.setText("");
        LbVerticaleSSActionAnimation.setText("");
        SAjLabel3.setText("");
        TxtHorizontaleSSActionAnimation.setText("");
        TxtVerticaleSSActionAnimation.setText("");
        SAjTextField3.setText("");
    }
    
    private void hidePanelSousAction(){
        PanelSSActionAgentAnime.setVisible(false);
    }
    
    private void reinitialiserFenetre(){
        listeSousActions.getListe().clear();
        TxtNomAction.setText("");
        CbPersoActionAgentAnime.setSelectedIndex(0);
        viderPanelSousAction();
        hidePanelSousAction();
        initialiserListe();
    }
    
    public Boolean verifierSousActionAnimations(String _animation){
        Boolean _return=true;
        String ag=CbPersoActionAgentAnime.getSelectedItem().toString();
        if(" ".equals(ag))
            ag="";
        //XMLFonctions.OuvrirXML(this.getClass().getResource("/ressources/animations.xml").getFile());
        XMLFonctions.OuvrirXML(Main.Cste.fichierAnimations);
        Element element= (Element) XMLFonctions.racine;
        List listeNoeudsAgents=element.getChildren(Main.CreationRegles.attributAgent);
        Iterator<Element> it1 = listeNoeudsAgents.iterator();
        while (it1.hasNext()) {
            Element noeudAgent=it1.next();
            String noeudAgentString=noeudAgent.getAttributeValue(Main.CreationRegles.attributPersonnage);
            if(ag.equals(noeudAgentString)){
                List listeNoeudsAnimations=noeudAgent.getChildren(Main.CreationRegles.attributAnimation);
                Iterator<Element> it2 = listeNoeudsAnimations.iterator();
                while (it2.hasNext()) {
                     Element noeudAnimation=it2.next();
                     String noeudAnimationString=noeudAnimation.getText();
                     if(noeudAnimationString.equals(_animation))_return=false;
                }
            }
        }
        return _return;
    }
    
    private void affichageSousActionAjout(){
        BtValiderSSActionAnimation.setVisible(true);
        BtModifierSSActionAnimation.setVisible(false);
    }
    
    private void affichageSousActionModification(){
        BtValiderSSActionAnimation.setVisible(false);
        BtModifierSSActionAnimation.setVisible(true); 
    }
    
    // fonctions d'affichage des sous actions
    private void affichageDeplacementPanelSousAction(Boolean modification){
        if(CbTypeSSActionAnimation.getSelectedIndex()!=0)
            CbTypeSSActionAnimation.setSelectedIndex(0);
        else
        {
            SAjComboBoxIdentifiant.setVisible(false);
            TxtHorizontaleSSActionAnimation.setVisible(true);
            TxtHorizontaleSSActionAnimation.setText("0");
            TxtVerticaleSSActionAnimation.setVisible(true);
            TxtVerticaleSSActionAnimation.setText("0");
            SAjTextField3.setVisible(false);
            LbHorizontaleSSActionAnimation.setVisible(true);
            LbHorizontaleSSActionAnimation.setText(Main.CreationRegles.itemPositionHorizontaleActionAnimation);
            LbVerticaleSSActionAnimation.setVisible(true);
            LbVerticaleSSActionAnimation.setText(Main.CreationRegles.itemPositionVerticaleActionAnimation);
            SAjLabel3.setVisible(false);
            SAjLabel4.setVisible(false);
        }
        if(modification)
        {
            affichageSousActionModification();
        }
        else
        {
            affichageSousActionAjout();
        }
    }
    
    private void setBorderTitle(JPanel panel, String titre)
    {
        TitledBorder t = new TitledBorder(titre);
        panel.setBorder(t);
    }
    
    public void modifActionAgentAnime(Element act)
    {
        Main.CreationActions.chargerInterface();
        Main.CreationRegles.modifActionAgentAnime=true;
        
        CbChoixTypeAction.setSelectedItem(Main.CreationRegles.itemTypeActionAnimation);
        CbChoixTypeAction.setEnabled(false);
        TxtNomAction.setText(act.getAttributeValue(Main.CreationRegles.attributId));
        
        if(act.getAttributeValue(Main.CreationRegles.attributPersonnage).isEmpty())
            CbPersoActionAgentAnime.setSelectedItem(" ");
        else
            CbPersoActionAgentAnime.setSelectedItem(act.getAttributeValue(Main.CreationRegles.attributPersonnage));
        
        //on initialise toutes les sous-actions
        for(int i=0; i<act.getChildren().size(); i++)
        {
            Element sousact=(Element) act.getChildren().get(i);
            String typ = sousact.getAttributeValue(Main.CreationRegles.attributType);
            if (Main.CreationRegles.attributDeplacement.equals(typ)) 
            {
                Deplacement deplacement = new Deplacement();
                deplacement.initialiserSousAction(sousact.getAttributeValue(Main.CreationRegles.attributPosition_x), sousact.getAttributeValue(Main.CreationRegles.attributPosition_y), "");
                listeSousActions.ajouterSousAction(deplacement);
            } else if (Main.CreationRegles.attributAnimation.equals(typ)) 
            {
                Animation animation = new Animation();
                animation.initialiserSousAction(sousact.getAttributeValue(Main.CreationRegles.attributIdentifiant));
                listeSousActions.ajouterSousAction(animation);
            } else if (Main.CreationRegles.attributPense.equals(typ)) 
            {
                Pensee pensee = new Pensee();
                pensee.initialiserSousAction(sousact.getChildText(Main.CreationRegles.attributTexte));
                listeSousActions.ajouterSousAction(pensee);
            } else if (Main.CreationRegles.attributParole.equals(typ)) 
            {
                Parole parole = new Parole();
                parole.initialiserSousAction(sousact.getChildText(Main.CreationRegles.attributTexte));
                listeSousActions.ajouterSousAction(parole);
            }
        }
        viderPanelSousAction();
        hidePanelSousAction();
        initialiserListe();
        
        Main.CreationActions.setVisible(true);
    }
    
    public void modifActionInterface(Element act)
    { 
        Main.CreationActions.chargerInterface();
        Main.CreationRegles.modifActionInterface=true;
        CbChoixTypeAction.setSelectedItem(Main.CreationRegles.itemTypeActionActionInterface);
        CbChoixTypeAction.setEnabled(false); 
        
        TxtNomAction.setText(act.getAttributeValue(Main.CreationRegles.attributId));
        Element ssact=act.getChild(Main.CreationRegles.attributEvenement);
        TxtComposantActionInterface.setText(ssact.getAttributeValue(Main.CreationRegles.attributIdComp));
        if(ssact.getAttributeValue(Main.CreationRegles.attributPropriete).toString().equals("clic"))
        {
            CbActionActionInterface.setSelectedItem(Main.CreationRegles.invoke);
        }
        else if(ssact.getAttributeValue(Main.CreationRegles.attributPropriete).toString().equals("focus"))
        {
            CbActionActionInterface.setSelectedItem(Main.CreationRegles.setFocus);
        }
        else if(ssact.getAttributeValue(Main.CreationRegles.attributPropriete).toString().equals(Main.CreationRegles.attributValeur))
        {
            CbActionActionInterface.setSelectedItem(Main.CreationRegles.setValue);
            TxtValeurActionInterface.setText(ssact.getAttributeValue(Main.CreationRegles.attributValeur));
        }
        else if(ssact.getAttributeValue(Main.CreationRegles.attributPropriete).toString().equals("etat"))
        {
            CbActionActionInterface.setSelectedItem(Main.CreationRegles.toggle);
            RbOnActionInterface.setSelected(ssact.getAttributeValue(Main.CreationRegles.attributValeur).equals("On"));
            RbOffActionInterface.setSelected(ssact.getAttributeValue(Main.CreationRegles.attributValeur).equals("Off"));
        }
        Main.CreationActions.setVisible(true);
    }
    
    public void modifActionPasAPas(Element act)
    {
        Main.CreationActions.chargerInterface();
        ouvrirElementMiseEnValeurEtape(act);
        ouvrirListeMessagesPasAPas(act);
        Main.CreationRegles.modifActionPasaPas=true;
        CbChoixTypeAction.setSelectedItem(Main.CreationRegles.itemTypeActionPasAPas);
        CbChoixTypeAction.setEnabled(false);
        
        TxtNomAction.setText(act.getAttributeValue(Main.CreationRegles.attributId));
        String t=Main.CreationRegles.itemAutomatise;
        if(act.getAttributeValue("typeAuto").equals(Main.CreationRegles.attributGuide))
            t=Main.CreationRegles.itemGuide;
        CbTypeActionPasaPas.setSelectedItem(t);
        CbEtapesActionPasaPas.setSelectedItem(act.getAttributeValue("listeEtapes"));
        
        CheckMessageAvantActionPasaPas.setSelected(false);
        CheckMessageAvantAutorisationActionPasaPas.setSelected(false);
        CheckMessageApresActionPasaPas.setSelected(false);
        CheckMessageApresBilanActionPasaPas.setSelected(false);
        CheckProgressionActionPasaPas.setSelected(false);
        for(int i=0; i<act.getChildren(Main.CreationRegles.attributMessage).size(); i++)
        {
            Element mes=(Element) act.getChildren(Main.CreationRegles.attributMessage).get(i);
            if(mes.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.attributAvant))
            {
                CheckMessageAvantActionPasaPas.setSelected(true);
                CheckMessageAvantAutorisationActionPasaPas.setSelected(mes.getAttributeValue(Main.CreationRegles.attributDemande).equals(Main.CreationRegles.attributOui));
            }
            
            if(mes.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.attributApres))
            {
                CheckMessageApresActionPasaPas.setSelected(true);
                CheckMessageApresBilanActionPasaPas.setSelected(mes.getAttributeValue(Main.CreationRegles.attributBilan).equals(Main.CreationRegles.attributOui));
            }
            
            if(mes.getAttributeValue(Main.CreationRegles.attributType).equals("progression"))
            {
                CheckProgressionActionPasaPas.setSelected(true);
            }
        }
        
        Element etapes=act.getChild("etapes");
        if(etapes!=null)
        {
            CheckMiseEnValeurActionPasaPas.setSelected(etapes.getChild("miseEnValeur")!=null);
            
            CheckExpliquerEtapeActionPasaPas.setSelected(false);
            CheckExpliquerEtapeAutorisationActionPasaPas.setSelected(false);
            CheckExpliquerEtapeTermineeActionPasaPas.setSelected(false);
            
            for(int i=0; i<etapes.getChildren(Main.CreationRegles.attributMessage).size(); i++)
            {
                Element mes=(Element) etapes.getChildren(Main.CreationRegles.attributMessage).get(i);
                if(mes.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.attributAvant))
                {
                    CheckExpliquerEtapeActionPasaPas.setSelected(true);
                    CheckExpliquerEtapeAutorisationActionPasaPas.setSelected(mes.getAttributeValue(Main.CreationRegles.attributDemande).equals(Main.CreationRegles.attributOui));
                }
                if(mes.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.attributApres))
                {
                    CheckExpliquerEtapeTermineeActionPasaPas.setSelected(true);
                }
            }
            
            Element timer=etapes.getChild("timer");
            if(timer!=null)
            {
                CheckTimerActionPasaPas.setSelected(true);
                SpinTimerActionPasaPas.setValue(Integer.parseInt(timer.getAttributeValue("secondes")));
            }
            else
            {
                CheckTimerActionPasaPas.setSelected(false);
            }
            
        }
        Main.CreationActions.setVisible(true);
    }
    
    public void modifActionPresentationGuidee(Element act)
    {
        Main.CreationActions.chargerInterface();
        ouvrirListeMessagesPresentationGuidee(act);
        
        Main.CreationRegles.modifActionPresentationGuidee=true;
        CbChoixTypeAction.setSelectedItem(Main.CreationRegles.itemTypeActionPresentationGuidee);
        CbChoixTypeAction.setEnabled(false);
        
        TxtNomAction.setText(act.getAttributeValue(Main.CreationRegles.attributId));
        CbEtapesActionPresentationGuidee.setSelectedItem(act.getAttributeValue("listeEtapes"));
        
        CheckMessageAvantActionPresentationGuidee.setSelected(false);
        CheckMessageAvantAutorisationActionPresentationGuidee.setSelected(false);
        CheckMessageApresActionPresentationGuidee.setSelected(false);
        for(int i=0; i<act.getChildren(Main.CreationRegles.attributMessage).size(); i++)
        {
            Element mes=(Element) act.getChildren(Main.CreationRegles.attributMessage).get(i);
            if(mes.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.attributAvant))
            {
                CheckMessageAvantActionPresentationGuidee.setSelected(true);
                CheckMessageAvantAutorisationActionPresentationGuidee.setSelected(mes.getAttributeValue(Main.CreationRegles.attributDemande).equals(Main.CreationRegles.attributOui));
            }
            if(mes.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.attributApres))
            {
                CheckMessageApresActionPresentationGuidee.setSelected(true);
            }
        }
        
        Element etapes=act.getChild("etapes");
        if(etapes!=null)
        {
            CheckExpliquerEtapeActionPresentationGuidee.setSelected(false);
            CheckExpliquerEtapeAutorisationActionPresentationGuidee.setSelected(false);
            
            for(int i=0; i<etapes.getChildren(Main.CreationRegles.attributMessage).size(); i++)
            {
                Element mes=(Element) etapes.getChildren(Main.CreationRegles.attributMessage).get(i);
                if(mes.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.attributAvant))
                {
                    CheckExpliquerEtapeActionPresentationGuidee.setSelected(true);
                    CheckExpliquerEtapeAutorisationActionPresentationGuidee.setSelected(mes.getAttributeValue(Main.CreationRegles.attributDemande).equals(Main.CreationRegles.attributOui));
                }
            }
            
            Element timer=etapes.getChild("timer");
            if(timer!=null)
            {
                CheckTimerActionPresentationGuidee.setSelected(true);
                SpinTimerActionPresentationGuidee.setValue(Integer.parseInt(timer.getAttributeValue("secondes")));
            }
            else
            {
                CheckTimerActionPresentationGuidee.setSelected(false);
            }
            
        }
        Main.CreationActions.setVisible(true);
    }
    
    public void modifActionModifierProfil(Element act)
    {
        Main.CreationActions.chargerInterface();
        Main.CreationRegles.modifActionModifierProfil = true;

        CbChoixTypeAction.setSelectedItem(Main.CreationRegles.itemTypeActionModificationProfil);
        CbChoixTypeAction.setEnabled(false);
        
        TxtNomAction.setText(act.getAttributeValue(Main.CreationRegles.attributId));
        String chemin=act.getChild(Main.CreationRegles.attributModification).getAttributeValue(Main.CreationRegles.attributChemin);
        TxtElementActionModifierProfil.setText(chemin);
        
        chemin="[profil, "+chemin.substring(1);
        for(int i=0; i<ArbreActionProfil.getRowCount(); i++)
        {
           ArbreActionProfil.setSelectionRow(i);
           if(ArbreActionProfil.getSelectionPath().toString().equals(chemin))
               break;
        }
        
        Element echelle = FonctionsUtiles.noeudEchelleParId(act.getChild(Main.CreationRegles.attributModification).getAttributeValue(Main.CreationRegles.attributId_echelle));
        if(act.getChild(Main.CreationRegles.attributModification).getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.attributModification))
        {
            PanelExacteActionModifierProfil.setVisible(false);
            PanelModifierActionModifierProfil.setVisible(true);
            CbTypeActionModifierProfil.setSelectedItem(Main.CreationRegles.modifier);
            SpinModifierActionModifierProfil.setValue(Integer.parseInt(act.getChild(Main.CreationRegles.attributModification).getAttributeValue(Main.CreationRegles.attributValeur)));
            if(FonctionsUtiles.echelleEstNumerique(echelle))
            {
                LbPointActionModifierProfil.setText(Main.CreationRegles.points);
            }
            else
            {
                LbPointActionModifierProfil.setText(Main.CreationRegles.niveaux);
            }
        }
        else    //si on ajoute une évaluation dans le profil
        {
            
            PanelExacteActionModifierProfil.setVisible(true);
            PanelModifierActionModifierProfil.setVisible(false);
            CbTypeActionModifierProfil.setSelectedItem(Main.CreationRegles.exact);
            if(FonctionsUtiles.echelleEstNumerique(echelle))
            {
                
                SpinExacteActionModifierProfil.setValue(Integer.parseInt(act.getChild(Main.CreationRegles.attributModification).getAttributeValue(Main.CreationRegles.attributValeur)));
            }
            else
            {
                CbNiveauxActionModifierProfil.setSelectedItem(act.getChild(Main.CreationRegles.attributModification).getAttributeValue(Main.CreationRegles.attributValeur));
            }
        }
        TxtSourceActionModifierProfil.setText(act.getChild(Main.CreationRegles.attributModification).getAttributeValue(Main.CreationRegles.attributSource));
        Main.CreationActions.setVisible(true);
    }
    
    public void modifActionRessource(Element action)
    {
        Main.CreationActions.chargerInterface();
        Main.CreationRegles.modifActionRessource=true;
        
        CbChoixTypeAction.setSelectedItem(Main.CreationRegles.itemTypeActionRessource);
        CbChoixTypeAction.setEnabled(false);
        
        TxtNomAction.setText(action.getAttributeValue(Main.CreationRegles.attributId));
        
        if(action.getAttributeValue(Main.CreationRegles.attributType).equals("fichier"))
            CbTypeActionRessource.setSelectedItem(Main.CreationRegles.itemOuvrirFichierActionRessource);
        else if(action.getAttributeValue(Main.CreationRegles.attributType).equals("URL"))
            CbTypeActionRessource.setSelectedItem(Main.CreationRegles.itemOuvrirURLActionRessource);
        else
            CbTypeActionRessource.setSelectedItem(Main.CreationRegles.itemOuvrirAppliActionRessource);
      
        TxtCheminActionRessource.setText(action.getAttributeValue(Main.CreationRegles.attributChemin));
        Main.CreationActions.setVisible(true);
    }
    
    public void modifierActionAjoutComposant(Element action)
    {
        Main.CreationActions.chargerInterface();
        Main.CreationRegles.modifActionAjoutComposant=true;
        
        CbChoixTypeAction.setSelectedItem(Main.CreationRegles.itemTypeActionAjoutComposant);
        CbChoixTypeAction.setEnabled(false);
        
        TxtNomAction.setText(action.getAttributeValue(Main.CreationRegles.attributId));
        Element compo = action.getChild(Main.CreationRegles.attributComposant);
        
        TxtIdActionAjoutComposant.setText(compo.getAttributeValue(Main.CreationRegles.attributId));
        
        if(compo.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.stringTypeComposantAjouteBouton))
        {
            CbTypeActionAjoutComposant.setSelectedItem(Main.CreationRegles.itemTypeComposantAjouteBouton);
            if(compo.getAttribute(Main.CreationRegles.attributTexte)!=null)
            {
                CheckTexteBoutonActionAjoutComposant.setSelected(true);
                TxtTexteBoutonActionAjoutComposant.setText(compo.getAttributeValue(Main.CreationRegles.attributTexte));
            }
            
            if(compo.getAttribute(Main.CreationRegles.attributInfobulle)!=null)
            {
                CheckInfoBulleBoutonActionAjoutComposant.setSelected(true);
                TxtInfoBulleBoutonActionAjoutComposant.setText(compo.getAttributeValue(Main.CreationRegles.attributInfobulle));
            }
            
            if(compo.getAttribute(Main.CreationRegles.attributIcone)!=null)
            {
                CheckIconeBoutonActionAjoutComposant.setSelected(true);
                ImageIcon im = new ImageIcon(Main.Cste.cheminSymboles+compo.getAttributeValue(Main.CreationRegles.attributIcone));
                BtIconeBoutonActionAjoutComposant.setIcon(im);
                BtIconeBoutonActionAjoutComposant.setToolTipText(compo.getAttributeValue(Main.CreationRegles.attributIcone));
            }           
        }
        else if(compo.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.stringTypeComposantAjouteLabel))
        {
            CbTypeActionAjoutComposant.setSelectedItem(Main.CreationRegles.itemTypeComposantAjouteLabel);
            
            if(compo.getAttribute(Main.CreationRegles.attributTexte)!=null)
            {
                TxtTexteLabelActionAjoutComposant.setText(compo.getAttributeValue(Main.CreationRegles.attributTexte));
            }
            
            if(compo.getAttribute(Main.CreationRegles.attributIcone)!=null)
            {
                CheckIconeLabelActionAjoutComposant.setSelected(true);
                ImageIcon im = new ImageIcon(Main.Cste.cheminSymboles+compo.getAttributeValue(Main.CreationRegles.attributIcone));
                BtIconeLabelActionAjoutComposant.setIcon(im);
                BtIconeLabelActionAjoutComposant.setToolTipText(compo.getAttributeValue(Main.CreationRegles.attributIcone));
            }
        }
        else if(compo.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.stringTypeComposantAjouteImage))
        {
            CbTypeActionAjoutComposant.setSelectedItem(Main.CreationRegles.itemTypeComposantAjouteImage); 
            
            if(compo.getAttribute(Main.CreationRegles.attributIcone)!=null)
            {
                ImageIcon im = new ImageIcon(Main.Cste.cheminSymboles+compo.getAttributeValue(Main.CreationRegles.attributIcone));
                BtIconeImageActionAjoutComposant.setIcon(im);
                BtIconeImageActionAjoutComposant.setToolTipText(compo.getAttributeValue(Main.CreationRegles.attributIcone));
            }
        }
        
        Boolean bool = true;
        if(compo.getAttribute(Main.CreationRegles.attributDirection)!=null)
        {
            CbDirectionActionAjoutComposant.setSelectedItem(compo.getAttributeValue(Main.CreationRegles.attributDirection));
            bool=false;
        }
        if(compo.getAttribute(Main.CreationRegles.attributLargeur)!=null)
        {
            bool=false;
            SpinLargeurActionAjoutComposant.setValue(Integer.parseInt(compo.getAttributeValue(Main.CreationRegles.attributLargeur)));
        }
        if(compo.getAttribute(Main.CreationRegles.attributHauteur)!=null)
        {
            bool=false;
            SpinHauteurActionAjoutComposant.setValue(Integer.parseInt(compo.getAttributeValue(Main.CreationRegles.attributHauteur)));
        }
        if(compo.getAttribute(Main.CreationRegles.attributCouleur)!=null)
        {
            bool=false;
            BtPoliceActionAjoutComposant.setForeground(FonctionsUtiles.StringToColor(compo.getAttributeValue(Main.CreationRegles.attributCouleur)));
        }
        if(compo.getAttribute(Main.CreationRegles.attributPolice)!=null)
        {
            bool=false;
            BtPoliceActionAjoutComposant.setFont(FonctionsUtiles.StringToFont(compo.getAttributeValue(Main.CreationRegles.attributPolice)));
        }

        afficherDetailsActionAjoutComposant(bool);
        
        Main.CreationActions.setVisible(true);
    }
        
    public void modifActionMessage(Element action)
    {
        Main.CreationActions.chargerInterface();
        Main.CreationRegles.modifActionMessage=true;
        
        CbChoixTypeAction.setSelectedItem(Main.CreationRegles.itemTypeActionMessage);
        CbChoixTypeAction.setEnabled(false);
        
        TxtNomAction.setText(action.getAttributeValue(Main.CreationRegles.attributId));
        String sst=action.getAttributeValue(Main.CreationRegles.attributSousType);
        
        if(sst.equals(Main.CreationRegles.messageTextuel) || sst.equals(Main.CreationRegles.messageTextuelVocal))
        {
            CheckEcritActionMessage.setSelected(true);
            CheckOralActionMessage.setSelected(sst.equals(Main.CreationRegles.messageTextuelVocal));
            Element noeud_textuel=action.getChild(Main.CreationRegles.attributTextuel);
            Main.CreationRegles.editor.setText(noeud_textuel.getChildText(Main.CreationRegles.attributTexte));
            if(sst.equals(Main.CreationRegles.messageTextuelVocal))
            {
                CheckDifferentActionMessage.setEnabled(true);
                Element noeud_vocal=action.getChild(Main.CreationRegles.attributVocal);
                if(noeud_vocal.getAttributeValue("different").equals("vrai"))
                {
                    CheckDifferentActionMessage.setSelected(true);
                    TxtDifferentActionMessage.setEnabled(true);
                    CbPersoDifferentActionMessage.setEnabled(true);
                    TxtDifferentActionMessage.setText(noeud_vocal.getChildText(Main.CreationRegles.attributTexte));
                }
                else
                {
                    CheckDifferentActionMessage.setSelected(false);
                    TxtDifferentActionMessage.setEnabled(false);
                    CbPersoDifferentActionMessage.setEnabled(false);
                    TxtDifferentActionMessage.setText("");
                }
            }
           
            Element options=noeud_textuel.getChild(Main.CreationRegles.attributOptions);
            chargerCbModeActionMessage();
            
            if(action.getAttributeValue("assistant").equals(Main.CreationRegles.messager))
            {
                if(sst.equals(Main.CreationRegles.messageTextuelVocal))
                {
                    CbModeActionMessage.setSelectedItem(Main.CreationRegles.itemPopupSynthese);
                }
                else
                {
                    CbModeActionMessage.setSelectedItem(Main.CreationRegles.itemPopup);
                }
                
                //on regarde s'il y a une mise en forme avancée
                CheckMiseEnFormeActionMessage.setSelected(!noeud_textuel.getChildText(Main.CreationRegles.attributTexte).equals(Main.CreationRegles.HTMLStringToString(noeud_textuel.getChildText(Main.CreationRegles.attributTexte))));
                PanelContenuActionMessage.setVisible(!CheckMiseEnFormeActionMessage.isSelected());
                PanelCouleurFondActionMessage.setVisible(CheckMiseEnFormeActionMessage.isSelected());
                if(noeud_textuel.getChildText(Main.CreationRegles.attributTexte).contains("bgcolor="))    //s'il y a une couleur de fond
                {
                    BtCouleurFondActionMessage.setBackground(Main.CreationRegles.couleurDeFondHTML(noeud_textuel.getChildText(Main.CreationRegles.attributTexte)));
                }
                
                if(options!=null)
                { 
                    PanelDetailsPopupActionMessage.setVisible(true);
                    if(options.getAttribute(Main.CreationRegles.attributTitre)!=null)
                        TxtTitreFenetreActionMessage.setText(options.getAttributeValue(Main.CreationRegles.attributTitre));
                    Element noeud_taille=options.getChild(Main.CreationRegles.attributTaille);
                    if(noeud_taille.getAttributeValue(Main.CreationRegles.attributType).equals("manuel"))
                    {
                        BtTailleManuellePopupActionMessage.setSelected(true);
                        SpinHauteurFenetrePopupActionMessage.setEnabled(true);
                        SpinLargeurFenetrePopupActionMessage.setEnabled(true);
                        SpinHauteurFenetrePopupActionMessage.setValue(Integer.parseInt(noeud_taille.getAttributeValue("hauteur")));
                        SpinLargeurFenetrePopupActionMessage.setValue(Integer.parseInt(noeud_taille.getAttributeValue("largeur")));
                    }
                    else
                    {
                        BtTailleAutomatiquePopupActionMessage.setSelected(true);
                        SpinHauteurFenetrePopupActionMessage.setEnabled(false);
                        SpinLargeurFenetrePopupActionMessage.setEnabled(false);
                    }

                    Element noeud_pos=options.getChild("position");
                    if(noeud_pos.getAttributeValue(Main.CreationRegles.attributType).endsWith("ecran"))
                    {
                        RbPositionEcranPopupActionMessage.setSelected(true);
                        CbPositionHorizontalePopupActionMessage.setEnabled(true);
                        CbPositionVerticalePopupActionMessage.setEnabled(true);
                        CbPositionHorizontalePopupActionMessage.setSelectedItem(noeud_pos.getChild("ecran").getAttributeValue(Main.CreationRegles.attributHorizontal));
                        CbPositionVerticalePopupActionMessage.setSelectedItem(noeud_pos.getChild("ecran").getAttributeValue(Main.CreationRegles.attributVertical));
                        SpinXPopupActionMessage.setEnabled(false);
                        SpinYPopupActionMessage.setEnabled(false);
                    }
                    else if(noeud_pos.getAttributeValue(Main.CreationRegles.attributType).endsWith("coordonnees"))
                    {                   
                        RbPositionCoordonneesPopupActionMessage.setSelected(true);
                        SpinXPopupActionMessage.setEnabled(true);
                        SpinYPopupActionMessage.setEnabled(true);
                        SpinXPopupActionMessage.setValue(Integer.parseInt(noeud_pos.getChild("coordonnees").getAttributeValue("X")));
                        SpinYPopupActionMessage.setValue(Integer.parseInt(noeud_pos.getChild("coordonnees").getAttributeValue("Y")));
                        CbPositionHorizontalePopupActionMessage.setEnabled(false);
                        CbPositionVerticalePopupActionMessage.setEnabled(false);
                    }
                    else
                    {
                        BtRbPositionSourisPopupActionMessage.setSelected(true);
                        CbPositionHorizontalePopupActionMessage.setEnabled(false);
                        CbPositionVerticalePopupActionMessage.setEnabled(false);
                        SpinXPopupActionMessage.setEnabled(false);
                        SpinYPopupActionMessage.setEnabled(false);
                    }
                }
            }
            else if(action.getAttributeValue("assistant").equals(Main.CreationRegles.attributAgentAnime))
            {
                CbModeActionMessage.setSelectedItem(Main.CreationRegles.itemAgentAnime);
                if(options!=null)
                {                
                    Element noeud_pos=options.getChild("position");
                    if(noeud_pos.getAttributeValue(Main.CreationRegles.attributType).endsWith("ecran"))
                    {
                        RbPositionEcranAgentActionMessage.setSelected(true);
                        CbPositionHorizontaleAgentActionMessage.setEnabled(true);
                        CbPositionVerticaleAgentActionMessage.setEnabled(true);
                        CbPositionHorizontaleAgentActionMessage.setSelectedItem(noeud_pos.getChild("ecran").getAttributeValue(Main.CreationRegles.attributHorizontal));
                        CbPositionVerticaleAgentActionMessage.setSelectedItem(noeud_pos.getChild("ecran").getAttributeValue(Main.CreationRegles.attributVertical));
                        SpinXAgentActionMessage.setEnabled(false);
                        SpinYAgentActionMessage.setEnabled(false);
                    }
                    else if(noeud_pos.getAttributeValue(Main.CreationRegles.attributType).endsWith("coordonnees"))
                    {                   
                        RbPositionCoordonneesPopupActionMessage.setSelected(true);
                        SpinXAgentActionMessage.setEnabled(true);
                        SpinYAgentActionMessage.setEnabled(true);
                        SpinXAgentActionMessage.setValue(Integer.parseInt(noeud_pos.getChild("coordonnees").getAttributeValue("X")));
                        SpinYAgentActionMessage.setValue(Integer.parseInt(noeud_pos.getChild("coordonnees").getAttributeValue("Y")));
                        CbPositionHorizontaleAgentActionMessage.setEnabled(false);
                        CbPositionVerticaleAgentActionMessage.setEnabled(false);
                    }
                    else
                    {
                        BtRbPositionSourisAgentActionMessage.setSelected(true);
                        CbPositionHorizontaleAgentActionMessage.setEnabled(false);
                        CbPositionVerticaleAgentActionMessage.setEnabled(false);
                        SpinXAgentActionMessage.setEnabled(false);
                        SpinYAgentActionMessage.setEnabled(false);
                    }

                    Element noeud_agent=options.getChild(Main.CreationRegles.attributAgent);
                    ImageIcon im = new ImageIcon(this.getClass().getResource("/imagesAgentsAnimes/"+noeud_agent.getAttributeValue(Main.CreationRegles.attributPersonnage)+".gif"));
                    BtModifierAgentActionMessage.setText("");
                    BtModifierAgentActionMessage.setIcon(im);
                    Main.CreationRegles.personnageMessage=noeud_agent.getAttributeValue(Main.CreationRegles.attributPersonnage);
                }
            }
            else
            {
                CbModeActionMessage.setSelectedItem("");
            }      
        }
        else
        {
            CheckDifferentActionMessage.setEnabled(false);
            TxtDifferentActionMessage.setText("");
            CheckEcritActionMessage.setSelected(false);
            CheckOralActionMessage.setSelected(true);
            Element noeud_vocal=action.getChild(Main.CreationRegles.attributVocal);
            Main.CreationRegles.editor.setText(noeud_vocal.getChildText(Main.CreationRegles.attributTexte));
        }
        Main.CreationActions.setVisible(true);
    }
    
    public void modifActionMasquage(Element action)
    {
        Main.CreationActions.chargerInterface();
        Main.CreationRegles.modifActionMiseEnValeur=true;
        
        CbChoixTypeAction.setSelectedItem(Main.CreationRegles.itemTypeActionMasquage);
        CbChoixTypeAction.setEnabled(false);
        
        TxtNomAction.setText(action.getAttributeValue(Main.CreationRegles.attributId));
        Element composant=action.getChild(Main.CreationRegles.attributComposant);
        TxtIdActionMiseEnValeur.setText(composant.getAttributeValue(Main.CreationRegles.attributId));
        CbTypeActionMasquage.setSelectedItem(composant.getAttributeValue(Main.CreationRegles.attributType));                
        
        if(composant.getAttribute(Main.CreationRegles.attributCouleur)!=null && !composant.getAttributeValue(Main.CreationRegles.attributCouleur).isEmpty())
        {
            if(composant.getAttributeValue(Main.CreationRegles.attributCouleur).equals("pere"))
            {
                    RbCouelruPereActionMasquage.setSelected(true);
            }
            else
            {
                RbChoixCouleurActionMasquage.setSelected(true);
                BtCouleurActionMasquage.setBackground(FonctionsUtiles.StringToColor(composant.getAttributeValue(Main.CreationRegles.attributCouleur)));
            }
            
            PanelEstomperActionMasquage.setVisible(true);
            Main.CreationRegles.afficherDetailsMasquage=true;
            BtAfficherDetailsActionMasquage.setToolTipText("Masquer les détails du masquage");
            Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/moins.png"));
            BtAfficherDetailsActionMasquage.setIcon(new ImageIcon(icon));
        }
        else
        {
            PanelEstomperActionMasquage.setVisible(false);
            Main.CreationRegles.afficherDetailsMasquage=false;
            BtAfficherDetailsActionMasquage.setToolTipText("Afficher les détails du masquage");
            Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
            BtAfficherDetailsActionMasquage.setIcon(new ImageIcon(icon));
        }
        
        if(composant.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.itemEstomper))
        {
            if(composant.getAttribute(Main.CreationRegles.attributTransparence)!=null && !composant.getAttributeValue(Main.CreationRegles.attributTransparence).isEmpty())
            {               
                SpinTransparenceActionMasquage.setValue(Integer.parseInt(composant.getAttributeValue(Main.CreationRegles.attributTransparence)));
            }
        }
        Main.CreationActions.setVisible(true);
    }
    
    public void modifActionMiseEnValeur(Element action)
    {
        Main.CreationActions.chargerInterface();
        Main.CreationRegles.modifActionMiseEnValeur=true;
        
        CbChoixTypeAction.setSelectedItem(Main.CreationRegles.itemTypeActionMiseEnValeur);
        CbChoixTypeAction.setEnabled(false);
        
        TxtNomAction.setText(action.getAttributeValue(Main.CreationRegles.attributId));
        Element composant=action.getChild(Main.CreationRegles.attributComposant);
        TxtIdActionMiseEnValeur.setText(composant.getAttributeValue(Main.CreationRegles.attributId));
        CbTypeActionMiseEnValeur.setSelectedItem(composant.getAttributeValue(Main.CreationRegles.attributType));
        
        if(composant.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.itemEntourer))
        {
            if(composant.getAttributeValue(Main.CreationRegles.attributCouleur)!=null)
                BtEntourerCouleurActionMiseEnValeur.setBackground(FonctionsUtiles.StringToColor(composant.getAttributeValue(Main.CreationRegles.attributCouleur)));
            if(composant.getAttribute(Main.CreationRegles.attributArrondi)!=null)
                SpinArrondiActionMiseEnValeur.setValue(Integer.parseInt(composant.getAttributeValue(Main.CreationRegles.attributArrondi)));
            if(composant.getAttribute(Main.CreationRegles.attributEloignement)!=null)
                SpinEloignementActionMiseEnValeur.setValue(Integer.parseInt(composant.getAttributeValue(Main.CreationRegles.attributEloignement)));
            if(composant.getAttribute(Main.CreationRegles.attributEpaisseur)!=null)
                SpinEpaisseurActionMiseEnValeur.setValue(Integer.parseInt(composant.getAttributeValue(Main.CreationRegles.attributEpaisseur)));
            if(action.getAttribute(Main.CreationRegles.attributTimer)!=null)
            { 
                int valTimer = Integer.parseInt(action.getAttributeValue(Main.CreationRegles.attributTimer))/1000;
                SpinDureeActionMiseEnValeurEntourer.setValue(valTimer);
            }
            CheckDureeActionMiseEnValeurEntourer.setSelected(action.getAttribute(Main.CreationRegles.attributTimer)!=null);
                
        }        
        else if(composant.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.itemSymbole))
        {
            if(composant.getAttribute(Main.CreationRegles.attributSymbole)!=null)
            {
                ImageIcon im = new ImageIcon(Main.Cste.cheminSymboles+composant.getAttributeValue(Main.CreationRegles.attributSymbole));
                BtModifierSymboleActionMiseEnValeur.setText("");
                BtModifierSymboleActionMiseEnValeur.setIcon(im);
                //Main.CreationRegles.fichierSymbole=System.getProperty("user.dir")+"/"+Main.Cste.cheminSymboles+composant.getAttributeValue(Main.CreationRegles.attributSymbole);
                Main.CreationRegles.fichierSymbole=composant.getAttributeValue(Main.CreationRegles.attributSymbole);
            }
            
            if(composant.getAttribute(Main.CreationRegles.attributDirection)!=null)
                CbDirectionActionMiseEnValeur.setSelectedItem(composant.getAttributeValue(Main.CreationRegles.attributDirection));
            
            if(action.getAttribute(Main.CreationRegles.attributTimer)!=null)
            { 
                int valTimer = Integer.parseInt(action.getAttributeValue(Main.CreationRegles.attributTimer))/1000;
                SpinDureeActionMiseEnValeurSymbole.setValue(valTimer);
            }
            CheckDureeActionMiseEnValeurSymbole.setSelected(action.getAttribute(Main.CreationRegles.attributTimer)!=null);
            
        }        
        else if(composant.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.attributAgentAnime))
        {
            if(composant.getAttribute(Main.CreationRegles.attributPersonnage)!=null)
            {
                ImageIcon im = new ImageIcon(this.getClass().getResource("/imagesAgentsAnimes/"+composant.getAttributeValue(Main.CreationRegles.attributPersonnage)+".gif"));
                BtModifierAgentActionMiseEnValeur.setText("");
                BtModifierAgentActionMiseEnValeur.setIcon(im);
                Main.CreationRegles.personnageMiseEnValeur=composant.getAttributeValue(Main.CreationRegles.attributPersonnage);
            }
            
            if(composant.getAttribute(Main.CreationRegles.attributDirection)!=null)
                CbDirectionActionMiseEnValeurAgent.setSelectedItem(composant.getAttributeValue(Main.CreationRegles.attributDirection));
            
            if(action.getAttribute(Main.CreationRegles.attributTimer)!=null)
            {  
                int valTimer = Integer.parseInt(action.getAttributeValue(Main.CreationRegles.attributTimer))/1000;
                SpinDureeActionMiseEnValeurAgent.setValue(valTimer);
            }
            CheckDureeActionMiseEnValeurAgent.setSelected(action.getAttribute(Main.CreationRegles.attributTimer)!=null);
            
        }        
        else if(composant.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.itemColorer))
        {
            if(composant.getAttribute(Main.CreationRegles.attributCouleur)!=null)
                BtCouleurActionMiseEnValeur.setBackground(FonctionsUtiles.StringToColor(composant.getAttributeValue(Main.CreationRegles.attributCouleur)));
            
            if(composant.getAttribute(Main.CreationRegles.attributTransparence)!=null)
                SpinTransparenceActionMiseEnValeur.setValue(Integer.parseInt(composant.getAttributeValue(Main.CreationRegles.attributTransparence)));
            
            if(action.getAttribute(Main.CreationRegles.attributTimer)!=null)
            { 
                int valTimer = Integer.parseInt(action.getAttributeValue(Main.CreationRegles.attributTimer))/1000;
                SpinDureeActionMiseEnValeurColorer.setValue(valTimer);
            }
            CheckDureeActionMiseEnValeurColorer.setSelected(action.getAttribute(Main.CreationRegles.attributTimer)!=null);
        }  
        
        if(composant.getAttributes().size()>2)
        {
            BtAfficherDetailsActionMiseEnValeur.setToolTipText(Main.CreationRegles.tooltipMasquerDetailsMiseEnValeur);
            Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/moins.png"));
            BtAfficherDetailsActionMiseEnValeur.setIcon(new ImageIcon(icon));
            BtAfficherDetailsActionMiseEnValeur.setText("");
            
            if(CbTypeActionMiseEnValeur.getSelectedItem().equals(Main.CreationRegles.itemEntourer))
            {
               PanelEntourerActionMiseEnValeur.setVisible(true); 
            }
            else if(CbTypeActionMiseEnValeur.getSelectedItem().equals(Main.CreationRegles.itemColorer))
            {
               PanelColorerActionMiseEnValeur.setVisible(true); 
            }
            else if(CbTypeActionMiseEnValeur.getSelectedItem().equals(Main.CreationRegles.itemSymbole))
            {
               PanelSymboleActionMiseEnValeur.setVisible(true); 
            }
            else if(CbTypeActionMiseEnValeur.getSelectedItem().equals(Main.CreationRegles.itemAgentAnime))
            {
               PanelAgentActionMiseEnValeur.setVisible(true); 
            }
            Main.CreationRegles.afficherDetailsMiseEnValeur=true;
        }
        else
        {
            BtAfficherDetailsActionMiseEnValeur.setToolTipText(Main.CreationRegles.tooltipAfficherDetailsMiseEnValeur);
            Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
            BtAfficherDetailsActionMiseEnValeur.setIcon(new ImageIcon(icon));
            BtAfficherDetailsActionMiseEnValeur.setText("");
            
            PanelEntourerActionMiseEnValeur.setVisible(false);
            PanelColorerActionMiseEnValeur.setVisible(false);
            PanelSymboleActionMiseEnValeur.setVisible(false);
            PanelAgentActionMiseEnValeur.setVisible(false);
            
            Main.CreationRegles.afficherDetailsMiseEnValeur=false;
        }
        Main.CreationActions.setVisible(true);
    }
    
    private void affichageAnimationPanelSousAction(Boolean modification){
        if(CbTypeSSActionAnimation.getSelectedIndex()!=3)CbTypeSSActionAnimation.setSelectedIndex(3);
        else{
        SAjComboBoxIdentifiant.setVisible(true);
        TxtHorizontaleSSActionAnimation.setVisible(false);
        TxtVerticaleSSActionAnimation.setVisible(false);
        SAjTextField3.setVisible(false);
        LbHorizontaleSSActionAnimation.setVisible(false);
        LbVerticaleSSActionAnimation.setVisible(false);
        SAjLabel3.setVisible(false);
        SAjLabel4.setText(Main.CreationRegles.attributIdentifiant);
        SAjLabel4.setVisible(true);
        chargerAnimations();
        }
        if(modification){
            affichageSousActionModification();
        }else{
            affichageSousActionAjout();
        }
    }
    
    public String ajoutCouleurFond(String texte, String code)
    {
        String html=Main.CreationRegles.stringToHTMLString(texte);
        if(html.contains("bgcolor=\"#"))
            html=html.substring(0, html.indexOf("bgcolor=\"#"))+html.substring(html.indexOf("bgcolor=\"#")+17);
        html=html.replace("<body", "<body bgcolor=\"#"+code.substring(2) +"\"");
        return html;
    }
    
    private void ouvrirElementMiseEnValeurEtape(Element action)
    {
        elementMiseEnValeurEtape=action.getChild("etapes").getChild("miseEnValeur");
    }
    
    private void ouvrirListeMessagesPresentationGuidee(Element action)
    {
        choixMessagesAvantEtapePresentationGuidee=new String[action.getChildren(Main.CreationRegles.attributEvenement).size()];
        for(int i=0; i<action.getChildren(Main.CreationRegles.attributEvenement).size(); i++)
        {
            Element etape=(Element) action.getChildren(Main.CreationRegles.attributEvenement).get(i);
            String mes="";
            if(etape.getChild(Main.CreationRegles.attributMessage)!=null)
            {
                Element m=(Element) etape.getChild(Main.CreationRegles.attributMessage);
                if(m.getChild(Main.CreationRegles.attributTexte)!=null)
                    mes=m.getChildText(Main.CreationRegles.attributTexte);
                else
                    mes=m.getChild(Main.CreationRegles.attributTextuel).getChildText(Main.CreationRegles.attributTexte); 
            }
            choixMessagesAvantEtapePresentationGuidee[i]=mes;
        }
    }
    
    private void ouvrirListeMessagesPasAPas(Element action)
    {
        choixMessagesAvantEtapePasaPas=new String[action.getChildren(Main.CreationRegles.attributEvenement).size()];
        choixMessagesApresEtapePasaPas=new String[action.getChildren(Main.CreationRegles.attributEvenement).size()];
        for(int i=0; i<action.getChildren(Main.CreationRegles.attributEvenement).size(); i++)
        {
            Element etape=(Element) action.getChildren(Main.CreationRegles.attributEvenement).get(i);
            String mes="";
            String mes2="";
            for(int j=0; j<etape.getChildren().size(); j++)
            {
                Element m=(Element) etape.getChildren().get(j);
                if(m.getName().equals(Main.CreationRegles.attributMessage) && m.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.attributAvant))
                    mes=m.getChildText(Main.CreationRegles.attributTexte);
                
                if(m.getName().equals(Main.CreationRegles.attributMessage) && m.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.attributApres))
                    mes2=m.getChildText(Main.CreationRegles.attributTexte);
            }
            choixMessagesAvantEtapePasaPas[i]=mes;
            choixMessagesApresEtapePasaPas[i]=mes2;
        }
    }
    
    public void chargerAnimations(){//charge la liste des animations du personnage selectionné dans le selecteur
        SAjComboBoxIdentifiant.removeAllItems();
        SAjComboBoxIdentifiant.addItem("");
        String ag=CbPersoActionAgentAnime.getSelectedItem().toString();
        if(" ".equals(ag))
            ag="";
        //XMLFonctions.OuvrirXML(this.getClass().getResource("/ressources/animations.xml").getFile());
        XMLFonctions.OuvrirXML(Main.Cste.fichierAnimations);
        Element element= (Element) XMLFonctions.racine;
        List listeNoeudsAgents=element.getChildren(Main.CreationRegles.attributAgent);
        Iterator<Element> it1 = listeNoeudsAgents.iterator();
        while (it1.hasNext()) {
            Element noeudAgent=it1.next();
            String noeudAgentString=noeudAgent.getAttributeValue(Main.CreationRegles.attributPersonnage);
            if(ag.equals(noeudAgentString)){
                List listeNoeudsAnimations=noeudAgent.getChildren(Main.CreationRegles.attributAnimation);
                Iterator<Element> it2 = listeNoeudsAnimations.iterator();
                while (it2.hasNext()) {
                     Element noeudAnimation=it2.next();
                     String noeudAnimationString=noeudAnimation.getText();
                     SAjComboBoxIdentifiant.addItem(noeudAnimationString.toLowerCase());
                }
            }
        }
    }
    
    private void showPanelSousAction(){
        PanelSSActionAgentAnime.setVisible(true);
        ListActionAgentAnime.clearSelection();
    }
    
    private void selectionDansListe(int i){ // charge les données de la sous action selectionnée dans le cadre
        SousAction _SousAction=listeSousActions.getListe().get(i);
        String typeSousAction=_SousAction.getType();
        showPanelSousAction();
        if(Main.CreationRegles.attributDéplacement.equals(typeSousAction)){
            Deplacement _SousActionDeplacement=(Deplacement) _SousAction;
            affichageDeplacementPanelSousAction(true);
            TxtHorizontaleSSActionAnimation.setText(_SousActionDeplacement.getPosition_x());
            TxtVerticaleSSActionAnimation.setText(_SousActionDeplacement.getPosition_y());
            SAjTextField3.setText(_SousActionDeplacement.getVitesse());
        }else if(Main.CreationRegles.attributAnimation.equals(typeSousAction)){
            Animation _SousActionAnimation=(Animation) _SousAction;
            affichageAnimationPanelSousAction(true);
            Integer j=0;
            while(j<SAjComboBoxIdentifiant.getItemCount() && !SAjComboBoxIdentifiant.getSelectedItem().toString().equals(_SousActionAnimation.getIdentifiant())){
                SAjComboBoxIdentifiant.setSelectedIndex(j);
                j++;
            }
            if(j>=SAjComboBoxIdentifiant.getItemCount())SAjComboBoxIdentifiant.setSelectedIndex(0);
        }else if(Main.CreationRegles.attributPensee.equals(typeSousAction)){
            Pensee _SousActionPensee=(Pensee) _SousAction;
            affichagePenseePanelSousAction(true);
            TxtHorizontaleSSActionAnimation.setText(_SousActionPensee.getTexte());
        }else if(Main.CreationRegles.attributParole.equals(typeSousAction)){
            Parole _SousActionParole=(Parole) _SousAction;
            affichageParolePanelSousAction(true);
            TxtHorizontaleSSActionAnimation.setText(_SousActionParole.getVitesse());
            TxtVerticaleSSActionAnimation.setText(_SousActionParole.getTexte());
        }
    }
    
    private void affichageParolePanelSousAction(Boolean modification){
        if(CbTypeSSActionAnimation.getSelectedIndex()!=1)
            CbTypeSSActionAnimation.setSelectedIndex(1);
        else
        {
            SAjComboBoxIdentifiant.setVisible(false);
            TxtHorizontaleSSActionAnimation.setVisible(false);
            TxtVerticaleSSActionAnimation.setVisible(true);
            SAjTextField3.setVisible(false);
            LbHorizontaleSSActionAnimation.setVisible(false);
            LbHorizontaleSSActionAnimation.setText(Main.CreationRegles.itemVitesseActionAnimation);
            LbVerticaleSSActionAnimation.setVisible(true);
            LbVerticaleSSActionAnimation.setText(Main.CreationRegles.itemTexteActionAnimation);
            SAjLabel3.setVisible(false);
            SAjLabel4.setVisible(false);
        }
        if(modification){
            affichageSousActionModification();
        }else{
            affichageSousActionAjout();
        }
    }
    
    private void affichagePenseePanelSousAction(Boolean modification){
        if(CbTypeSSActionAnimation.getSelectedIndex()!=2)CbTypeSSActionAnimation.setSelectedIndex(2);
        else{
        SAjComboBoxIdentifiant.setVisible(false);
        TxtHorizontaleSSActionAnimation.setVisible(true);
        TxtVerticaleSSActionAnimation.setVisible(false);
        SAjTextField3.setVisible(false);
        LbHorizontaleSSActionAnimation.setVisible(true);
        LbHorizontaleSSActionAnimation.setText(Main.CreationRegles.attributTexte);
        LbVerticaleSSActionAnimation.setVisible(false);
        SAjLabel3.setVisible(false);
        SAjLabel4.setVisible(false);
        }
        if(modification){
            affichageSousActionModification();
        }else{
            affichageSousActionAjout();
        }
    }
    
    public void initialiserListe(){// rafraichit l'affichage de la liste des sous actions
        SousAction _SousAction;
        final List<String> list = new ArrayList<String>();      
        Iterator<SousAction> it= listeSousActions.getListe().iterator();
        while(it.hasNext()){
            _SousAction = it.next();
            list.add(_SousAction.getType());
        }
        
        ListActionAgentAnime.setModel(new javax.swing.AbstractListModel() {
            Object[] strings = list.toArray();
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
    }
    
    private void actionCbEtapesActionPresentationGuidee()
    {
        if(CbEtapesActionPresentationGuidee.getSelectedIndex()>=0)
        {
            if(CbEtapesActionPresentationGuidee.getSelectedItem().toString().isEmpty())
            {
                Main.CreationRegles.listModel = new DefaultListModel();
                ListeActionPasaPas.setModel(Main.CreationRegles.listModel);
            }
            else
            {
                String idSeq = CbEtapesActionPresentationGuidee.getSelectedItem().toString().substring(0, CbEtapesActionPresentationGuidee.getSelectedItem().toString().indexOf("_"));
                Element sequence = Main.CreationRegles.elementParId(Main.CreationRegles.lesSequences, idSeq);
                Main.CreationRegles.ChargerListeActionPresentationGuidee(ListeActionPresentationGuidee, sequence);
            }
        }
    }
    
    private void actionCbEtapesActionPasaPas()
    {
        if(CbEtapesActionPasaPas.getSelectedIndex()>=0)
        {
            if(CbEtapesActionPasaPas.getSelectedItem().toString().isEmpty())
            {
                Main.CreationRegles.listModel = new DefaultListModel();
                ListeActionPasaPas.setModel(Main.CreationRegles.listModel);
            }
            else
            {
                String idSeq = CbEtapesActionPasaPas.getSelectedItem().toString().substring(0, CbEtapesActionPasaPas.getSelectedItem().toString().indexOf("_"));
                Element sequence = Main.CreationRegles.elementParId(Main.CreationRegles.lesSequences, idSeq);
                Main.CreationRegles.ChargerListeActionPasaPas(ListeActionPasaPas, sequence);
            }
        }
    }
    
    public void RechargerCbSequenceEvenements(Element sequence)
    {
        Main.CreationRegles.chargerCbSequence(CbEtapesActionPasaPas, Main.CreationRegles.attributEvenements);
        CbEtapesActionPasaPas.setSelectedItem(sequence.getAttributeValue(Main.CreationRegles.attributId)+"_"+sequence.getAttributeValue(Main.CreationRegles.attributNom));
    }
    
    private void changerChoixActionModifProfil()
    {
        PanelExacteActionModifierProfil.setVisible(CbTypeActionModifierProfil.getSelectedItem().toString().equals(Main.CreationRegles.exact));
        PanelModifierActionModifierProfil.setVisible(!CbTypeActionModifierProfil.getSelectedItem().toString().equals(Main.CreationRegles.exact));
        if (!ArbreActionProfil.isSelectionEmpty()) 
        {
            if(!ArbreActionProfil.getSelectionPath().toString().equals("[profil]"))
            {
                //on cherche l'échelle de l'élément
                String chemin = ArbreActionProfil.getSelectionPath().toString().replace("profil, ", "");
                chemin = chemin.substring(1, chemin.length());
                if (chemin.contains(",")) {
                    chemin = chemin.substring(0, chemin.indexOf(","));
                } else {
                    chemin = chemin.substring(0, chemin.length() - 1);
                }
                Element compo = Main.CreationRegles.briqueParNom(Main.Cste.cheminStructuresProfils + Main.Cste.structureProfils, chemin);
                compo = (Element) compo.getChild(Main.CreationRegles.attributInfos_echelle).getChildren().get(0);

                Main.CreationRegles.id_echelleActionProfil = compo.getAttributeValue(Main.CreationRegles.attributId);   
                TxtElementActionModifierProfil.setText(chemin);
                
                Element echelle=FonctionsUtiles.noeudEchelleParId(Main.CreationRegles.id_echelleActionProfil);
                if(PanelModifierActionModifierProfil.isVisible())
                {
                    if(FonctionsUtiles.echelleEstNumerique(echelle))
                    {
                        String borne_sup=echelle.getChild(Main.CreationRegles.attributNumerique).getAttributeValue(Main.CreationRegles.attributBorne_sup);
                        String borne_inf=echelle.getChild(Main.CreationRegles.attributNumerique).getAttributeValue(Main.CreationRegles.attributBorne_inf);
                        int max=Integer.parseInt(borne_sup)-Integer.parseInt(borne_inf);
                        SpinnerModel sm = new SpinnerNumberModel(0, -max, max, 1);
                        SpinModifierActionModifierProfil.setModel(sm);
                        LbPointActionModifierProfil.setText(Main.CreationRegles.points);
                    }
                    else
                    {
                        int max=echelle.getChild(Main.CreationRegles.attributTextuel).getChildren().size();
                        SpinnerModel sm = new SpinnerNumberModel(0, -max, max, 1);
                        SpinModifierActionModifierProfil.setModel(sm);
                        LbPointActionModifierProfil.setText(Main.CreationRegles.niveaux);
                    }
                }
                else
                {
                    if(FonctionsUtiles.echelleEstNumerique(echelle))
                    {
                        CbNiveauxActionModifierProfil.setVisible(false);
                        SpinExacteActionModifierProfil.setVisible(true);
                        int min=Integer.parseInt(echelle.getChild(Main.CreationRegles.attributNumerique).getAttributeValue(Main.CreationRegles.attributBorne_inf));
                        int max=Integer.parseInt(echelle.getChild(Main.CreationRegles.attributNumerique).getAttributeValue(Main.CreationRegles.attributBorne_sup));
                        SpinnerModel sm = new SpinnerNumberModel(0, min, max, 1);
                        SpinExacteActionModifierProfil.setModel(sm);
                    }
                    else
                    {
                        CbNiveauxActionModifierProfil.setVisible(true);
                        SpinExacteActionModifierProfil.setVisible(false);
                        CbNiveauxActionModifierProfil.removeAllItems();
                        for(int i=0; i<echelle.getChild(Main.CreationRegles.attributTextuel).getChildren().size(); i++)
                        {
                            Element val=(Element) echelle.getChild(Main.CreationRegles.attributTextuel).getChildren().get(i);
                            CbNiveauxActionModifierProfil.addItem(val.getText());
                        }

                    }
                }
            }
        }
    }
    
    private void chargerCbModeActionMessage()
    {
        CbModeActionMessage.removeAllItems();
        CbModeActionMessage.addItem("");
        if(CheckEcritActionMessage.isSelected())
        {
           if(CheckOralActionMessage.isSelected())
            {
                CbModeActionMessage.addItem(Main.CreationRegles.itemPopupSynthese);
                CbModeActionMessage.addItem(Main.CreationRegles.itemAgentAnime);
            }
            else
            {
                CbModeActionMessage.addItem(Main.CreationRegles.itemPopup);
                CbModeActionMessage.addItem(Main.CreationRegles.itemAgentAnime);
            } 
        }
        else
        {
            if(CheckOralActionMessage.isSelected())
            {
                CbModeActionMessage.addItem(Main.CreationRegles.itemSynthese);
            }
        }
    }
    
    private void resetActionMessage()
    {
        
        //Main.CreationRegles.editor = new HTMLEditorPane();
        Main.CreationRegles.editor.setText("");
        BtCouleurFondActionMessage.setBackground(Color.white);
        System.out.println(Main.CreationRegles.editor.getText());
        
        CheckEcritActionMessage.setSelected(true);
        CheckOralActionMessage.setSelected(false);
        
        PanelContenuActionMessage.setVisible(true);
        PanelCouleurFondActionMessage.setVisible(false);
        CbModeActionMessage.setSelectedIndex(0);
        CheckDifferentActionMessage.setSelected(false);
        CheckDifferentActionMessage.setEnabled(false);
        TxtDifferentActionMessage.setText("");
        TxtDifferentActionMessage.setEnabled(false);
        CbPersoDifferentActionMessage.setEnabled(false);
        
        TxtNomAction.setText("A"+Main.CreationRegles.idAction);
    }
    
    private void chargerCbPersoActionMessage()
    {
        CbPersoActionMessage.removeAllItems();
        CbPersoActionMessage.addItem("");
        CbPersoActionMessage.addItem(Main.CreationRegles.itemAvecPrenom);
        CbPersoActionMessage.addItem(Main.CreationRegles.itemAvecNom);
        CbPersoActionMessage.addItem(Main.CreationRegles.itemAvecElementProfil);
    }
    
    private void afficherDetailsActionAjoutComposant(boolean bool)
    {
        if (bool) 
        {
            BtAfficherDetailsActionAjoutComposant.setToolTipText("Afficher les détails");
            Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
            BtAfficherDetailsActionAjoutComposant.setIcon(new ImageIcon(icon));
            BtAfficherDetailsActionAjoutComposant.setText("");
        } 
        else 
        {
            BtAfficherDetailsActionAjoutComposant.setToolTipText("Masquer les détails");
            Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/moins.png"));
            BtAfficherDetailsActionAjoutComposant.setIcon(new ImageIcon(icon));
            BtAfficherDetailsActionAjoutComposant.setText("");
        }

        PanelDetailsActionAjoutComposant.setVisible(!bool);
        PanelPoliceActionAjoutComposant.setVisible(!bool && ! CbTypeActionAjoutComposant.getSelectedItem().toString().equals(Main.CreationRegles.itemTypeComposantAjouteImage));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        actionMessage = new javax.swing.ButtonGroup();
        ActionMessage2 = new javax.swing.ButtonGroup();
        ActionMessage3 = new javax.swing.ButtonGroup();
        PanelCreationAction = new javax.swing.JPanel();
        LbChoixTypeAction = new javax.swing.JLabel();
        CbChoixTypeAction = new javax.swing.JComboBox();
        PanelCreationActionMiseEnValeur = new javax.swing.JPanel();
        ScrollArbreActionMiseEnValeur = new javax.swing.JScrollPane();
        ArbreActionMiseEnValeur = new javax.swing.JTree();
        LbIdActionMiseEnValeur = new javax.swing.JLabel();
        TxtIdActionMiseEnValeur = new javax.swing.JTextField();
        PanelActionMiseEnValeur = new javax.swing.JPanel();
        LbTypeActionMiseEnValeur = new javax.swing.JLabel();
        CbTypeActionMiseEnValeur = new javax.swing.JComboBox();
        PanelAgentActionMiseEnValeur = new javax.swing.JPanel();
        LbSymboleActionMiseEnValeurAgent = new javax.swing.JLabel();
        BtModifierAgentActionMiseEnValeur = new javax.swing.JButton();
        LbDirectionActionMiseEnValeurAgent = new javax.swing.JLabel();
        CbDirectionActionMiseEnValeurAgent = new javax.swing.JComboBox();
        SpinDureeActionMiseEnValeurAgent = new javax.swing.JSpinner();
        CheckDureeActionMiseEnValeurAgent = new javax.swing.JCheckBox();
        LbUniteActionMiseEnValeurAgent = new javax.swing.JLabel();
        PanelEntourerActionMiseEnValeur = new javax.swing.JPanel();
        LbEntourerCouleurActionMiseEnValeur = new javax.swing.JLabel();
        BtEntourerCouleurActionMiseEnValeur = new javax.swing.JButton();
        LbArrondiActionMiseEnValeur = new javax.swing.JLabel();
        SpinArrondiActionMiseEnValeur = new javax.swing.JSpinner();
        LbEloignementActionMiseEnValeur = new javax.swing.JLabel();
        SpinEloignementActionMiseEnValeur = new javax.swing.JSpinner();
        LbEpaisseurActionMiseEnValeur = new javax.swing.JLabel();
        SpinEpaisseurActionMiseEnValeur = new javax.swing.JSpinner();
        SpinDureeActionMiseEnValeurEntourer = new javax.swing.JSpinner();
        LbUniteActionMiseEnValeurEntourer = new javax.swing.JLabel();
        CheckDureeActionMiseEnValeurEntourer = new javax.swing.JCheckBox();
        PanelColorerActionMiseEnValeur = new javax.swing.JPanel();
        LbCouleurActionMiseEnValeur = new javax.swing.JLabel();
        LbTransparenceActionMiseEnValeur = new javax.swing.JLabel();
        BtCouleurActionMiseEnValeur = new javax.swing.JButton();
        SpinTransparenceActionMiseEnValeur = new javax.swing.JSpinner();
        SpinDureeActionMiseEnValeurColorer = new javax.swing.JSpinner();
        LbUniteActionMiseEnValeurColorer = new javax.swing.JLabel();
        CheckDureeActionMiseEnValeurColorer = new javax.swing.JCheckBox();
        PanelSymboleActionMiseEnValeur = new javax.swing.JPanel();
        LbSymboleActionMiseEnValeur = new javax.swing.JLabel();
        BtModifierSymboleActionMiseEnValeur = new javax.swing.JButton();
        LbDirectionActionMiseEnValeur = new javax.swing.JLabel();
        CbDirectionActionMiseEnValeur = new javax.swing.JComboBox();
        CheckDureeActionMiseEnValeurSymbole = new javax.swing.JCheckBox();
        SpinDureeActionMiseEnValeurSymbole = new javax.swing.JSpinner();
        LbUniteActionMiseEnValeurSymbole = new javax.swing.JLabel();
        BtAfficherDetailsActionMiseEnValeur = new javax.swing.JButton();
        PanelActionMasquage = new javax.swing.JPanel();
        LbTypeActionMasquage = new javax.swing.JLabel();
        CbTypeActionMasquage = new javax.swing.JComboBox();
        PanelEstomperActionMasquage = new javax.swing.JPanel();
        LbCouleurActionMasquage = new javax.swing.JLabel();
        BtCouleurActionMasquage = new javax.swing.JButton();
        RbChoixCouleurActionMasquage = new javax.swing.JRadioButton();
        RbCouelruPereActionMasquage = new javax.swing.JRadioButton();
        PanelTransparenceActionMasquage = new javax.swing.JPanel();
        LbTransparenceActionMasquage = new javax.swing.JLabel();
        SpinTransparenceActionMasquage = new javax.swing.JSpinner();
        BtAfficherDetailsActionMasquage = new javax.swing.JButton();
        BtModifierDescriptionInterfaceActionMiseEnValeur = new javax.swing.JButton();
        BtAfficherDescriptionInterfaceActionMiseEnValeur = new javax.swing.JButton();
        BtAnnulerActionMiseEnValeur = new javax.swing.JButton();
        BtApercuActionMiseEnValeur = new javax.swing.JButton();
        BtValiderActionMiseEnValeur = new javax.swing.JButton();
        PanelCreationActionAgentAnime = new javax.swing.JPanel();
        BtApercuActionAgentAnime = new javax.swing.JButton();
        BtValiderActionAgentAnime = new javax.swing.JButton();
        BtAnnulerActionAgentAnime = new javax.swing.JButton();
        LbPersoActionAgentAnime = new javax.swing.JLabel();
        CbPersoActionAgentAnime = new javax.swing.JComboBox();
        PanelPersoActionAgentAnime = new javax.swing.JPanel();
        LbImagePersoActionAgentAnime = new javax.swing.JLabel();
        LbListeActionAgentAnime = new javax.swing.JLabel();
        ScrollListActionAgenAnime = new javax.swing.JScrollPane();
        ListActionAgentAnime = new javax.swing.JList();
        BtAjouterSSActionAgentAnime = new javax.swing.JButton();
        PanelSSActionAgentAnime = new javax.swing.JPanel();
        BtAnnulerSSActionAnimation = new javax.swing.JButton();
        BtModifierSSActionAnimation = new javax.swing.JButton();
        BtValiderSSActionAnimation = new javax.swing.JButton();
        LbTypeSSActionAnimation = new javax.swing.JLabel();
        TxtVerticaleSSActionAnimation = new javax.swing.JTextField();
        SAjTextField3 = new javax.swing.JTextField();
        TxtHorizontaleSSActionAnimation = new javax.swing.JTextField();
        LbHorizontaleSSActionAnimation = new javax.swing.JLabel();
        SAjLabel4 = new javax.swing.JLabel();
        SAjLabel3 = new javax.swing.JLabel();
        CbTypeSSActionAnimation = new javax.swing.JComboBox();
        LbVerticaleSSActionAnimation = new javax.swing.JLabel();
        SAjComboBoxIdentifiant = new javax.swing.JComboBox();
        PanelCreationActionModifierProfil = new javax.swing.JPanel();
        ScrollArbreActionProfil = new javax.swing.JScrollPane();
        ArbreActionProfil = new javax.swing.JTree();
        LbSelectionActionModifierProfil = new javax.swing.JLabel();
        LbElementActionModifierProfil = new javax.swing.JLabel();
        TxtElementActionModifierProfil = new javax.swing.JTextField();
        LbTypeActionModifierProfil = new javax.swing.JLabel();
        CbTypeActionModifierProfil = new javax.swing.JComboBox();
        PanelModifierActionModifierProfil = new javax.swing.JPanel();
        LbPointActionModifierProfil = new javax.swing.JLabel();
        SpinModifierActionModifierProfil = new javax.swing.JSpinner();
        LbActionActionModifierProfil = new javax.swing.JLabel();
        PanelExacteActionModifierProfil = new javax.swing.JPanel();
        SpinExacteActionModifierProfil = new javax.swing.JSpinner();
        CbNiveauxActionModifierProfil = new javax.swing.JComboBox();
        LbExacteActionModifierProfil = new javax.swing.JLabel();
        LbSourceActionModifierProfil = new javax.swing.JLabel();
        TxtSourceActionModifierProfil = new javax.swing.JTextField();
        BtAnnulerActionProfil = new javax.swing.JButton();
        BtValiderActionProfil = new javax.swing.JButton();
        PanelCreationActionPasaPas = new javax.swing.JPanel();
        BtAnnulerActionPasaPas = new javax.swing.JButton();
        BtValiderActionPasaPas = new javax.swing.JButton();
        BtApercuActionPasaPas = new javax.swing.JButton();
        LbTypeActionPasaPas = new javax.swing.JLabel();
        CbTypeActionPasaPas = new javax.swing.JComboBox();
        LbEtapesActionPasaPas = new javax.swing.JLabel();
        CbEtapesActionPasaPas = new javax.swing.JComboBox();
        BtCreerEtapesActionPasaPas = new javax.swing.JButton();
        ScrollListeActionPasaPas = new javax.swing.JScrollPane();
        ListeActionPasaPas = new javax.swing.JList();
        LbOptionActionPasaPas = new javax.swing.JLabel();
        CheckMessageAvantActionPasaPas = new javax.swing.JCheckBox();
        CheckMessageAvantAutorisationActionPasaPas = new javax.swing.JCheckBox();
        CheckMessageApresActionPasaPas = new javax.swing.JCheckBox();
        CheckMessageApresBilanActionPasaPas = new javax.swing.JCheckBox();
        CheckProgressionActionPasaPas = new javax.swing.JCheckBox();
        LbOptionEtapesActionPasaPas = new javax.swing.JLabel();
        CheckMiseEnValeurActionPasaPas = new javax.swing.JCheckBox();
        PanelGuiderActionPasaPas = new javax.swing.JPanel();
        CheckInterventionActionPasaPas = new javax.swing.JCheckBox();
        PanelAutomatiserActionPasaPas = new javax.swing.JPanel();
        CheckExpliquerEtapeActionPasaPas = new javax.swing.JCheckBox();
        CheckExpliquerEtapeAutorisationActionPasaPas = new javax.swing.JCheckBox();
        CheckExpliquerEtapeTermineeActionPasaPas = new javax.swing.JCheckBox();
        CheckTimerActionPasaPas = new javax.swing.JCheckBox();
        SpinTimerActionPasaPas = new javax.swing.JSpinner();
        LbSecondesActionPasaPas = new javax.swing.JLabel();
        BtModifierEtapesActionPasaPas = new javax.swing.JButton();
        BtPersonnaliserMessagesPasAPas = new javax.swing.JButton();
        BtMiseEnValeurPasAPas = new javax.swing.JButton();
        PanelCreationActionInterface = new javax.swing.JPanel();
        ScrollArbreActionInterface = new javax.swing.JScrollPane();
        ArbreActionInterface = new javax.swing.JTree();
        LbComposantActionInterface = new javax.swing.JLabel();
        TxtComposantActionInterface = new javax.swing.JTextField();
        BtAnnulerActionInterface = new javax.swing.JButton();
        BtValiderActionInterface = new javax.swing.JButton();
        BtApercuActionInterface = new javax.swing.JButton();
        LbActionActionInterface = new javax.swing.JLabel();
        CbActionActionInterface = new javax.swing.JComboBox();
        PanelEtatActionInterface = new javax.swing.JPanel();
        LbEtatActionInterface = new javax.swing.JLabel();
        RbOnActionInterface = new javax.swing.JRadioButton();
        RbOffActionInterface = new javax.swing.JRadioButton();
        PanelValeurActionInterface = new javax.swing.JPanel();
        TxtValeurActionInterface = new javax.swing.JTextField();
        LbValeurActionInterface = new javax.swing.JLabel();
        BtAfficherDescriptionInterfaceActionInterface = new javax.swing.JButton();
        BtModifierDescriptionInterfaceActionInterface = new javax.swing.JButton();
        TxtNomAction = new javax.swing.JTextField();
        LbNomAction = new javax.swing.JLabel();
        PanelCreationActionMessage = new javax.swing.JPanel();
        LbTypeActionMessage = new javax.swing.JLabel();
        CheckEcritActionMessage = new javax.swing.JCheckBox();
        CheckOralActionMessage = new javax.swing.JCheckBox();
        CheckDifferentActionMessage = new javax.swing.JCheckBox();
        ScrollDifferentActionMessage = new javax.swing.JScrollPane();
        TxtDifferentActionMessage = new javax.swing.JTextArea();
        CbModeActionMessage = new javax.swing.JComboBox();
        BtAfficherDetailsActionMessage = new javax.swing.JButton();
        BtApercuActionMessage = new javax.swing.JButton();
        BtValiderActionMessage = new javax.swing.JButton();
        BtAnnulerActionMessage = new javax.swing.JButton();
        PanelDetailsPopupActionMessage = new javax.swing.JPanel();
        CbPositionVerticalePopupActionMessage = new javax.swing.JComboBox();
        LbPositionHorizontalePopupActionMessage = new javax.swing.JLabel();
        RbPositionEcranPopupActionMessage = new javax.swing.JRadioButton();
        LbPositionVerticalePopupActionMessage = new javax.swing.JLabel();
        CbPositionHorizontalePopupActionMessage = new javax.swing.JComboBox();
        RbPositionCoordonneesPopupActionMessage = new javax.swing.JRadioButton();
        LbXPopupActionMessage = new javax.swing.JLabel();
        LbPositionPopupActionMessage = new javax.swing.JLabel();
        BtRbPositionSourisPopupActionMessage = new javax.swing.JRadioButton();
        SpinYPopupActionMessage = new javax.swing.JSpinner();
        SpinXPopupActionMessage = new javax.swing.JSpinner();
        LbYPopupActionMessage = new javax.swing.JLabel();
        LbLargeurFenetrePopupActionMessage = new javax.swing.JLabel();
        SpinLargeurFenetrePopupActionMessage = new javax.swing.JSpinner();
        SpinHauteurFenetrePopupActionMessage = new javax.swing.JSpinner();
        LbHauteurFenetrePopupActionMessage = new javax.swing.JLabel();
        BtTailleManuellePopupActionMessage = new javax.swing.JRadioButton();
        BtTailleAutomatiquePopupActionMessage = new javax.swing.JRadioButton();
        LbTailleFenetrePopupActionMessage = new javax.swing.JLabel();
        LbTitreFenetrePopupActionMessage = new javax.swing.JLabel();
        TxtTitreFenetreActionMessage = new javax.swing.JTextField();
        CheckMiseEnFormeActionMessage = new javax.swing.JCheckBox();
        PanelDetailsAgentActionMessage = new javax.swing.JPanel();
        CbPositionVerticaleAgentActionMessage = new javax.swing.JComboBox();
        LbPositionHorizontaleAgentActionMessage = new javax.swing.JLabel();
        RbPositionEcranAgentActionMessage = new javax.swing.JRadioButton();
        LbPositionVerticaleAgentActionMessage = new javax.swing.JLabel();
        CbPositionHorizontaleAgentActionMessage = new javax.swing.JComboBox();
        RbPositionCoordonneesAgentActionMessage = new javax.swing.JRadioButton();
        LbXAgentActionMessage = new javax.swing.JLabel();
        LbPositionAgentActionMessage = new javax.swing.JLabel();
        BtRbPositionSourisAgentActionMessage = new javax.swing.JRadioButton();
        SpinYAgentActionMessage = new javax.swing.JSpinner();
        SpinXAgentActionMessage = new javax.swing.JSpinner();
        LbYAgentActionMessage = new javax.swing.JLabel();
        BtModifierAgentActionMessage = new javax.swing.JButton();
        LbAgentActionMessage = new javax.swing.JLabel();
        PanelPersoContenu1ActionMessage = new javax.swing.JPanel();
        CbPersoActionMessage = new javax.swing.JComboBox();
        BtInclureActionMessage = new javax.swing.JButton();
        LbPersoActionMessage = new javax.swing.JLabel();
        PanelCouleurFondActionMessage = new javax.swing.JPanel();
        LbCouleurFondActionMessage = new javax.swing.JLabel();
        BtCouleurFondActionMessage = new javax.swing.JButton();
        CbPersoDifferentActionMessage = new javax.swing.JComboBox();
        BtInclureDifferentActionMessage = new javax.swing.JButton();
        LbPersoDifferentActionMessage = new javax.swing.JLabel();
        PanelContenuActionMessage = new javax.swing.JPanel();
        LbContenuActionMessage = new javax.swing.JLabel();
        LbModeActionMessage = new javax.swing.JLabel();
        PanelCreationActionRessource = new javax.swing.JPanel();
        BtAnnulerActionRessource = new javax.swing.JButton();
        BtApercuActionRessource = new javax.swing.JButton();
        BtValiderActionRessource = new javax.swing.JButton();
        LbTypeActionRessource = new javax.swing.JLabel();
        CbTypeActionRessource = new javax.swing.JComboBox();
        LbCheminActionRessource = new javax.swing.JLabel();
        TxtCheminActionRessource = new javax.swing.JTextField();
        BtCheminActionRessource = new javax.swing.JButton();
        PanelCreationActionAjoutComposant = new javax.swing.JPanel();
        ScrollArbreActionAjoutComposant = new javax.swing.JScrollPane();
        ArbreActionAjoutComposant = new javax.swing.JTree();
        LbIdActionAjoutComposant = new javax.swing.JLabel();
        TxtIdActionAjoutComposant = new javax.swing.JTextField();
        BtAnnulerActionAjoutComposant = new javax.swing.JButton();
        BtValiderActionAjoutComposant = new javax.swing.JButton();
        BtApercuActionAjoutComposant = new javax.swing.JButton();
        BtModifierDescriptionInterfaceActionAjoutComposant = new javax.swing.JButton();
        BtAfficherDescriptionInterfaceActionAjoutComposant = new javax.swing.JButton();
        PanelDetailsActionAjoutComposant = new javax.swing.JPanel();
        LbDirectionActionAjoutComposant = new javax.swing.JLabel();
        CbDirectionActionAjoutComposant = new javax.swing.JComboBox();
        LbLargeurActionAjoutComposant = new javax.swing.JLabel();
        LbHauteurActionAjoutComposant = new javax.swing.JLabel();
        SpinLargeurActionAjoutComposant = new javax.swing.JSpinner();
        SpinHauteurActionAjoutComposant = new javax.swing.JSpinner();
        PanelPoliceActionAjoutComposant = new javax.swing.JPanel();
        LbPoliceActionAjoutComposant = new javax.swing.JLabel();
        BtPoliceActionAjoutComposant = new javax.swing.JButton();
        LbTypeActionAjoutComposant = new javax.swing.JLabel();
        CbTypeActionAjoutComposant = new javax.swing.JComboBox();
        BtAfficherDetailsActionAjoutComposant = new javax.swing.JButton();
        PanelBoutonActionAjoutComposant = new javax.swing.JPanel();
        TxtTexteBoutonActionAjoutComposant = new javax.swing.JTextField();
        CheckTexteBoutonActionAjoutComposant = new javax.swing.JCheckBox();
        CheckIconeBoutonActionAjoutComposant = new javax.swing.JCheckBox();
        CheckInfoBulleBoutonActionAjoutComposant = new javax.swing.JCheckBox();
        TxtInfoBulleBoutonActionAjoutComposant = new javax.swing.JTextField();
        BtIconeBoutonActionAjoutComposant = new javax.swing.JButton();
        PanelLabelActionAjoutComposant = new javax.swing.JPanel();
        TxtTexteLabelActionAjoutComposant = new javax.swing.JTextField();
        CheckIconeLabelActionAjoutComposant = new javax.swing.JCheckBox();
        BtIconeLabelActionAjoutComposant = new javax.swing.JButton();
        LbTexteLabelActionAjoutComposant = new javax.swing.JLabel();
        PanelImageActionAjoutComposant = new javax.swing.JPanel();
        LbIconeImageActionAjoutComposant = new javax.swing.JLabel();
        BtIconeImageActionAjoutComposant = new javax.swing.JButton();
        PanelCreationActionPresentationGuidee = new javax.swing.JPanel();
        BtAnnulerActionPresentationGuidee = new javax.swing.JButton();
        BtValiderActionPresentationGuidee = new javax.swing.JButton();
        BtApercuActionPresentationGuidee = new javax.swing.JButton();
        LbEtapesActionPresentationGuidee = new javax.swing.JLabel();
        CbEtapesActionPresentationGuidee = new javax.swing.JComboBox();
        BtCreerEtapesActionPresentationGuidee = new javax.swing.JButton();
        ScrollListeActionPresentationGuidee = new javax.swing.JScrollPane();
        ListeActionPresentationGuidee = new javax.swing.JList();
        LbOptionActionPresentationGuidee = new javax.swing.JLabel();
        CheckMessageAvantActionPresentationGuidee = new javax.swing.JCheckBox();
        CheckMessageAvantAutorisationActionPresentationGuidee = new javax.swing.JCheckBox();
        CheckMessageApresActionPresentationGuidee = new javax.swing.JCheckBox();
        LbOptionEtapesActionPresentationGuidee = new javax.swing.JLabel();
        PanelAutomatiserActionPresentationGuidee = new javax.swing.JPanel();
        CheckExpliquerEtapeActionPresentationGuidee = new javax.swing.JCheckBox();
        CheckExpliquerEtapeAutorisationActionPresentationGuidee = new javax.swing.JCheckBox();
        CheckTimerActionPresentationGuidee = new javax.swing.JCheckBox();
        SpinTimerActionPresentationGuidee = new javax.swing.JSpinner();
        LbSecondesActionPresentationGuidee = new javax.swing.JLabel();
        BtModifierEtapesActionPresentationGuidee = new javax.swing.JButton();
        BtPersonnaliserMessagesPresentationGuidee = new javax.swing.JButton();
        BtMiseEnValeurPresentationGuidee = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PanelCreationAction.setBackground(new java.awt.Color(255, 225, 196));

        LbChoixTypeAction.setText("Type d'action");

        CbChoixTypeAction.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbChoixTypeAction.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbChoixTypeActionItemStateChanged(evt);
            }
        });
        CbChoixTypeAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbChoixTypeActionActionPerformed(evt);
            }
        });

        PanelCreationActionMiseEnValeur.setBackground(new java.awt.Color(255, 225, 196));
        PanelCreationActionMiseEnValeur.setPreferredSize(new java.awt.Dimension(340, 594));

        ArbreActionMiseEnValeur.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                ArbreActionMiseEnValeurValueChanged(evt);
            }
        });
        ScrollArbreActionMiseEnValeur.setViewportView(ArbreActionMiseEnValeur);

        LbIdActionMiseEnValeur.setText("Composant concerné");

        TxtIdActionMiseEnValeur.setEditable(false);
        TxtIdActionMiseEnValeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdActionMiseEnValeurActionPerformed(evt);
            }
        });

        PanelActionMiseEnValeur.setBackground(new java.awt.Color(255, 225, 196));

        LbTypeActionMiseEnValeur.setText("Type de mise en valeur :");

        CbTypeActionMiseEnValeur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbTypeActionMiseEnValeur.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbTypeActionMiseEnValeurItemStateChanged(evt);
            }
        });

        PanelAgentActionMiseEnValeur.setBackground(new java.awt.Color(255, 225, 196));
        PanelAgentActionMiseEnValeur.setBorder(javax.swing.BorderFactory.createTitledBorder("Plus de détails"));

        LbSymboleActionMiseEnValeurAgent.setText("Personnage :");

        BtModifierAgentActionMiseEnValeur.setBackground(new java.awt.Color(255, 225, 196));
        BtModifierAgentActionMiseEnValeur.setMnemonic('t');
        BtModifierAgentActionMiseEnValeur.setText("Modifier");
        BtModifierAgentActionMiseEnValeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierAgentActionMiseEnValeurActionPerformed(evt);
            }
        });

        LbDirectionActionMiseEnValeurAgent.setText("Direction :");

        CbDirectionActionMiseEnValeurAgent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        SpinDureeActionMiseEnValeurAgent.setModel(new javax.swing.SpinnerNumberModel(30, 0, 2000, 1));
        SpinDureeActionMiseEnValeurAgent.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinDureeActionMiseEnValeurAgentStateChanged(evt);
            }
        });

        CheckDureeActionMiseEnValeurAgent.setBackground(new java.awt.Color(255, 225, 196));
        CheckDureeActionMiseEnValeurAgent.setText("Durée d'affichage");
        CheckDureeActionMiseEnValeurAgent.setToolTipText("");
        CheckDureeActionMiseEnValeurAgent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckDureeActionMiseEnValeurAgentItemStateChanged(evt);
            }
        });

        LbUniteActionMiseEnValeurAgent.setText("secondes");

        javax.swing.GroupLayout PanelAgentActionMiseEnValeurLayout = new javax.swing.GroupLayout(PanelAgentActionMiseEnValeur);
        PanelAgentActionMiseEnValeur.setLayout(PanelAgentActionMiseEnValeurLayout);
        PanelAgentActionMiseEnValeurLayout.setHorizontalGroup(
            PanelAgentActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAgentActionMiseEnValeurLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbDirectionActionMiseEnValeurAgent, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CbDirectionActionMiseEnValeurAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LbSymboleActionMiseEnValeurAgent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtModifierAgentActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(PanelAgentActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelAgentActionMiseEnValeurLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(CheckDureeActionMiseEnValeurAgent)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(SpinDureeActionMiseEnValeurAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(LbUniteActionMiseEnValeurAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        PanelAgentActionMiseEnValeurLayout.setVerticalGroup(
            PanelAgentActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAgentActionMiseEnValeurLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(PanelAgentActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbSymboleActionMiseEnValeurAgent)
                    .addComponent(BtModifierAgentActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbDirectionActionMiseEnValeurAgent)
                    .addComponent(CbDirectionActionMiseEnValeurAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(PanelAgentActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelAgentActionMiseEnValeurLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(PanelAgentActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SpinDureeActionMiseEnValeurAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LbUniteActionMiseEnValeurAgent)
                        .addComponent(CheckDureeActionMiseEnValeurAgent))
                    .addContainerGap(50, Short.MAX_VALUE)))
        );

        PanelEntourerActionMiseEnValeur.setBackground(new java.awt.Color(255, 225, 196));
        PanelEntourerActionMiseEnValeur.setBorder(javax.swing.BorderFactory.createTitledBorder("Plus de détails"));

        LbEntourerCouleurActionMiseEnValeur.setText("Couleur du trait");

        BtEntourerCouleurActionMiseEnValeur.setBackground(new java.awt.Color(255, 51, 51));
        BtEntourerCouleurActionMiseEnValeur.setText(" ");
        BtEntourerCouleurActionMiseEnValeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEntourerCouleurActionMiseEnValeurActionPerformed(evt);
            }
        });

        LbArrondiActionMiseEnValeur.setText("Arrondi");

        SpinArrondiActionMiseEnValeur.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));
        SpinArrondiActionMiseEnValeur.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinArrondiActionMiseEnValeurStateChanged(evt);
            }
        });
        SpinArrondiActionMiseEnValeur.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                SpinArrondiActionMiseEnValeurPropertyChange(evt);
            }
        });

        LbEloignementActionMiseEnValeur.setText("Distance trait/composant");

        SpinEloignementActionMiseEnValeur.setModel(new javax.swing.SpinnerNumberModel(0, -20, 20, 1));
        SpinEloignementActionMiseEnValeur.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinEloignementActionMiseEnValeurStateChanged(evt);
            }
        });

        LbEpaisseurActionMiseEnValeur.setText("Epaisseur du trait");

        SpinEpaisseurActionMiseEnValeur.setModel(new javax.swing.SpinnerNumberModel(5, 1, 10, 1));
        SpinEpaisseurActionMiseEnValeur.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinEpaisseurActionMiseEnValeurStateChanged(evt);
            }
        });

        SpinDureeActionMiseEnValeurEntourer.setModel(new javax.swing.SpinnerNumberModel(30, 0, 2000, 1));
        SpinDureeActionMiseEnValeurEntourer.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinDureeActionMiseEnValeurEntourerStateChanged(evt);
            }
        });

        LbUniteActionMiseEnValeurEntourer.setText("secondes");

        CheckDureeActionMiseEnValeurEntourer.setBackground(new java.awt.Color(255, 225, 196));
        CheckDureeActionMiseEnValeurEntourer.setText("Durée d'affichage");
        CheckDureeActionMiseEnValeurEntourer.setToolTipText("");
        CheckDureeActionMiseEnValeurEntourer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckDureeActionMiseEnValeurEntourerItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout PanelEntourerActionMiseEnValeurLayout = new javax.swing.GroupLayout(PanelEntourerActionMiseEnValeur);
        PanelEntourerActionMiseEnValeur.setLayout(PanelEntourerActionMiseEnValeurLayout);
        PanelEntourerActionMiseEnValeurLayout.setHorizontalGroup(
            PanelEntourerActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEntourerActionMiseEnValeurLayout.createSequentialGroup()
                .addGroup(PanelEntourerActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEntourerActionMiseEnValeurLayout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(SpinEpaisseurActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelEntourerActionMiseEnValeurLayout.createSequentialGroup()
                        .addComponent(LbEntourerCouleurActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtEntourerCouleurActionMiseEnValeur))
                    .addGroup(PanelEntourerActionMiseEnValeurLayout.createSequentialGroup()
                        .addGroup(PanelEntourerActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelEntourerActionMiseEnValeurLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(LbArrondiActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SpinArrondiActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LbEloignementActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEntourerActionMiseEnValeurLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(CheckDureeActionMiseEnValeurEntourer)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelEntourerActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelEntourerActionMiseEnValeurLayout.createSequentialGroup()
                                .addComponent(SpinEloignementActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LbEpaisseurActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelEntourerActionMiseEnValeurLayout.createSequentialGroup()
                                .addComponent(SpinDureeActionMiseEnValeurEntourer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LbUniteActionMiseEnValeurEntourer, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelEntourerActionMiseEnValeurLayout.setVerticalGroup(
            PanelEntourerActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEntourerActionMiseEnValeurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEntourerActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbEntourerCouleurActionMiseEnValeur)
                    .addComponent(BtEntourerCouleurActionMiseEnValeur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEntourerActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpinArrondiActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbArrondiActionMiseEnValeur)
                    .addComponent(LbEloignementActionMiseEnValeur)
                    .addComponent(SpinEloignementActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbEpaisseurActionMiseEnValeur))
                .addGap(22, 22, 22)
                .addGroup(PanelEntourerActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpinDureeActionMiseEnValeurEntourer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbUniteActionMiseEnValeurEntourer)
                    .addComponent(CheckDureeActionMiseEnValeurEntourer))
                .addGap(33, 33, 33)
                .addComponent(SpinEpaisseurActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelColorerActionMiseEnValeur.setBackground(new java.awt.Color(255, 225, 196));
        PanelColorerActionMiseEnValeur.setBorder(javax.swing.BorderFactory.createTitledBorder("Plus de détails"));

        LbCouleurActionMiseEnValeur.setText("Couleur du composant");

        LbTransparenceActionMiseEnValeur.setText("Transparence");

        BtCouleurActionMiseEnValeur.setBackground(new java.awt.Color(102, 255, 102));
        BtCouleurActionMiseEnValeur.setText(" ");
        BtCouleurActionMiseEnValeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCouleurActionMiseEnValeurActionPerformed(evt);
            }
        });

        SpinTransparenceActionMiseEnValeur.setModel(new javax.swing.SpinnerNumberModel(60, 0, 255, 1));

        SpinDureeActionMiseEnValeurColorer.setModel(new javax.swing.SpinnerNumberModel(30, 0, 2000, 1));
        SpinDureeActionMiseEnValeurColorer.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinDureeActionMiseEnValeurColorerStateChanged(evt);
            }
        });

        LbUniteActionMiseEnValeurColorer.setText("secondes");

        CheckDureeActionMiseEnValeurColorer.setBackground(new java.awt.Color(255, 225, 196));
        CheckDureeActionMiseEnValeurColorer.setText("Durée d'affichage");
        CheckDureeActionMiseEnValeurColorer.setToolTipText("");
        CheckDureeActionMiseEnValeurColorer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckDureeActionMiseEnValeurColorerItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout PanelColorerActionMiseEnValeurLayout = new javax.swing.GroupLayout(PanelColorerActionMiseEnValeur);
        PanelColorerActionMiseEnValeur.setLayout(PanelColorerActionMiseEnValeurLayout);
        PanelColorerActionMiseEnValeurLayout.setHorizontalGroup(
            PanelColorerActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelColorerActionMiseEnValeurLayout.createSequentialGroup()
                .addGroup(PanelColorerActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelColorerActionMiseEnValeurLayout.createSequentialGroup()
                        .addComponent(LbTransparenceActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(PanelColorerActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtCouleurActionMiseEnValeur)
                            .addComponent(SpinTransparenceActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(LbCouleurActionMiseEnValeur)
                    .addGroup(PanelColorerActionMiseEnValeurLayout.createSequentialGroup()
                        .addComponent(CheckDureeActionMiseEnValeurColorer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SpinDureeActionMiseEnValeurColorer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LbUniteActionMiseEnValeurColorer, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        PanelColorerActionMiseEnValeurLayout.setVerticalGroup(
            PanelColorerActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelColorerActionMiseEnValeurLayout.createSequentialGroup()
                .addGroup(PanelColorerActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbCouleurActionMiseEnValeur)
                    .addComponent(BtCouleurActionMiseEnValeur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelColorerActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTransparenceActionMiseEnValeur)
                    .addComponent(SpinTransparenceActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelColorerActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpinDureeActionMiseEnValeurColorer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbUniteActionMiseEnValeurColorer)
                    .addComponent(CheckDureeActionMiseEnValeurColorer))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelSymboleActionMiseEnValeur.setBackground(new java.awt.Color(255, 225, 196));
        PanelSymboleActionMiseEnValeur.setBorder(javax.swing.BorderFactory.createTitledBorder("Plus de détails"));

        LbSymboleActionMiseEnValeur.setText("Symbole");

        BtModifierSymboleActionMiseEnValeur.setBackground(new java.awt.Color(255, 225, 196));
        BtModifierSymboleActionMiseEnValeur.setMnemonic('t');
        BtModifierSymboleActionMiseEnValeur.setText("Modifier");
        BtModifierSymboleActionMiseEnValeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierSymboleActionMiseEnValeurActionPerformed(evt);
            }
        });

        LbDirectionActionMiseEnValeur.setText("Direction");

        CbDirectionActionMiseEnValeur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CheckDureeActionMiseEnValeurSymbole.setBackground(new java.awt.Color(255, 225, 196));
        CheckDureeActionMiseEnValeurSymbole.setText("Durée d'affichage");
        CheckDureeActionMiseEnValeurSymbole.setToolTipText("");
        CheckDureeActionMiseEnValeurSymbole.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckDureeActionMiseEnValeurSymboleItemStateChanged(evt);
            }
        });

        SpinDureeActionMiseEnValeurSymbole.setModel(new javax.swing.SpinnerNumberModel(30, 0, 2000, 1));
        SpinDureeActionMiseEnValeurSymbole.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinDureeActionMiseEnValeurSymboleStateChanged(evt);
            }
        });

        LbUniteActionMiseEnValeurSymbole.setText("secondes");

        javax.swing.GroupLayout PanelSymboleActionMiseEnValeurLayout = new javax.swing.GroupLayout(PanelSymboleActionMiseEnValeur);
        PanelSymboleActionMiseEnValeur.setLayout(PanelSymboleActionMiseEnValeurLayout);
        PanelSymboleActionMiseEnValeurLayout.setHorizontalGroup(
            PanelSymboleActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSymboleActionMiseEnValeurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSymboleActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSymboleActionMiseEnValeurLayout.createSequentialGroup()
                        .addComponent(LbDirectionActionMiseEnValeur)
                        .addGap(18, 18, 18)
                        .addComponent(CbDirectionActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LbSymboleActionMiseEnValeur)
                        .addGap(18, 18, 18)
                        .addComponent(BtModifierSymboleActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSymboleActionMiseEnValeurLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CheckDureeActionMiseEnValeurSymbole)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SpinDureeActionMiseEnValeurSymbole, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LbUniteActionMiseEnValeurSymbole, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelSymboleActionMiseEnValeurLayout.setVerticalGroup(
            PanelSymboleActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSymboleActionMiseEnValeurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSymboleActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbSymboleActionMiseEnValeur)
                    .addComponent(BtModifierSymboleActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbDirectionActionMiseEnValeur)
                    .addComponent(CbDirectionActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(PanelSymboleActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpinDureeActionMiseEnValeurSymbole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbUniteActionMiseEnValeurSymbole)
                    .addComponent(CheckDureeActionMiseEnValeurSymbole))
                .addContainerGap())
        );

        BtAfficherDetailsActionMiseEnValeur.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        BtAfficherDetailsActionMiseEnValeur.setText("+");
        BtAfficherDetailsActionMiseEnValeur.setToolTipText("Afficher plus de détails");
        BtAfficherDetailsActionMiseEnValeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAfficherDetailsActionMiseEnValeurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelActionMiseEnValeurLayout = new javax.swing.GroupLayout(PanelActionMiseEnValeur);
        PanelActionMiseEnValeur.setLayout(PanelActionMiseEnValeurLayout);
        PanelActionMiseEnValeurLayout.setHorizontalGroup(
            PanelActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelActionMiseEnValeurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelActionMiseEnValeurLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PanelAgentActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelActionMiseEnValeurLayout.createSequentialGroup()
                        .addGroup(PanelActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelActionMiseEnValeurLayout.createSequentialGroup()
                                .addComponent(LbTypeActionMiseEnValeur)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CbTypeActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(BtAfficherDetailsActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PanelEntourerActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelSymboleActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelColorerActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelActionMiseEnValeurLayout.setVerticalGroup(
            PanelActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelActionMiseEnValeurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbTypeActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbTypeActionMiseEnValeur)
                    .addComponent(BtAfficherDetailsActionMiseEnValeur, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelEntourerActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelSymboleActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelColorerActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelAgentActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelActionMasquage.setBackground(new java.awt.Color(255, 225, 196));

        LbTypeActionMasquage.setText("Type de masquage");

        CbTypeActionMasquage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbTypeActionMasquage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbTypeActionMasquageItemStateChanged(evt);
            }
        });

        PanelEstomperActionMasquage.setBackground(new java.awt.Color(255, 225, 196));
        PanelEstomperActionMasquage.setBorder(javax.swing.BorderFactory.createTitledBorder("Plus de détails"));

        LbCouleurActionMasquage.setText("Couleur du composant");

        BtCouleurActionMasquage.setBackground(new java.awt.Color(102, 255, 102));
        BtCouleurActionMasquage.setText(" ");
        BtCouleurActionMasquage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCouleurActionMasquageActionPerformed(evt);
            }
        });

        RbChoixCouleurActionMasquage.setBackground(new java.awt.Color(255, 225, 196));
        RbChoixCouleurActionMasquage.setText("choix");

        RbCouelruPereActionMasquage.setBackground(new java.awt.Color(255, 225, 196));
        RbCouelruPereActionMasquage.setText("couleur du conteneur");

        PanelTransparenceActionMasquage.setBackground(new java.awt.Color(255, 224, 196));

        LbTransparenceActionMasquage.setText("Transparence");

        SpinTransparenceActionMasquage.setModel(new javax.swing.SpinnerNumberModel(60, 0, 255, 1));

        javax.swing.GroupLayout PanelTransparenceActionMasquageLayout = new javax.swing.GroupLayout(PanelTransparenceActionMasquage);
        PanelTransparenceActionMasquage.setLayout(PanelTransparenceActionMasquageLayout);
        PanelTransparenceActionMasquageLayout.setHorizontalGroup(
            PanelTransparenceActionMasquageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTransparenceActionMasquageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbTransparenceActionMasquage, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SpinTransparenceActionMasquage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        PanelTransparenceActionMasquageLayout.setVerticalGroup(
            PanelTransparenceActionMasquageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTransparenceActionMasquageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTransparenceActionMasquageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTransparenceActionMasquage)
                    .addComponent(SpinTransparenceActionMasquage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelEstomperActionMasquageLayout = new javax.swing.GroupLayout(PanelEstomperActionMasquage);
        PanelEstomperActionMasquage.setLayout(PanelEstomperActionMasquageLayout);
        PanelEstomperActionMasquageLayout.setHorizontalGroup(
            PanelEstomperActionMasquageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEstomperActionMasquageLayout.createSequentialGroup()
                .addGroup(PanelEstomperActionMasquageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEstomperActionMasquageLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(PanelTransparenceActionMasquage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelEstomperActionMasquageLayout.createSequentialGroup()
                        .addComponent(LbCouleurActionMasquage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RbChoixCouleurActionMasquage)
                        .addGap(2, 2, 2)
                        .addComponent(BtCouleurActionMasquage)
                        .addGap(18, 18, 18)
                        .addComponent(RbCouelruPereActionMasquage)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelEstomperActionMasquageLayout.setVerticalGroup(
            PanelEstomperActionMasquageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEstomperActionMasquageLayout.createSequentialGroup()
                .addGroup(PanelEstomperActionMasquageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbCouleurActionMasquage)
                    .addComponent(BtCouleurActionMasquage)
                    .addComponent(RbChoixCouleurActionMasquage)
                    .addComponent(RbCouelruPereActionMasquage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTransparenceActionMasquage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        BtAfficherDetailsActionMasquage.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        BtAfficherDetailsActionMasquage.setText("+");
        BtAfficherDetailsActionMasquage.setToolTipText("Afficher plus de détails");
        BtAfficherDetailsActionMasquage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAfficherDetailsActionMasquageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelActionMasquageLayout = new javax.swing.GroupLayout(PanelActionMasquage);
        PanelActionMasquage.setLayout(PanelActionMasquageLayout);
        PanelActionMasquageLayout.setHorizontalGroup(
            PanelActionMasquageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelActionMasquageLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LbTypeActionMasquage)
                .addGap(32, 32, 32)
                .addComponent(CbTypeActionMasquage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtAfficherDetailsActionMasquage, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PanelActionMasquageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelEstomperActionMasquage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelActionMasquageLayout.setVerticalGroup(
            PanelActionMasquageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelActionMasquageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelActionMasquageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTypeActionMasquage)
                    .addComponent(CbTypeActionMasquage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAfficherDetailsActionMasquage, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelEstomperActionMasquage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        BtModifierDescriptionInterfaceActionMiseEnValeur.setText("...");
        BtModifierDescriptionInterfaceActionMiseEnValeur.setToolTipText("Modifier la description de l'interface");
        BtModifierDescriptionInterfaceActionMiseEnValeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierDescriptionInterfaceActionMiseEnValeurActionPerformed(evt);
            }
        });

        BtAfficherDescriptionInterfaceActionMiseEnValeur.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        BtAfficherDescriptionInterfaceActionMiseEnValeur.setText("+");
        BtAfficherDescriptionInterfaceActionMiseEnValeur.setToolTipText("Afficher la totalité de la description de l'interface");
        BtAfficherDescriptionInterfaceActionMiseEnValeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAfficherDescriptionInterfaceActionMiseEnValeurActionPerformed(evt);
            }
        });

        BtAnnulerActionMiseEnValeur.setText("Annuler");
        BtAnnulerActionMiseEnValeur.setToolTipText("Retour à la définition des règles d'assistance");
        BtAnnulerActionMiseEnValeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerActionMiseEnValeurActionPerformed(evt);
            }
        });

        BtApercuActionMiseEnValeur.setText("Aperçu");
        BtApercuActionMiseEnValeur.setToolTipText("Voir un aperçu de la mise en valeur définie sur des composants exemples");
        BtApercuActionMiseEnValeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtApercuActionMiseEnValeurActionPerformed(evt);
            }
        });

        BtValiderActionMiseEnValeur.setText("Valider");
        BtValiderActionMiseEnValeur.setToolTipText("Valider l'action et revenir à la définition des règles d'assistance");
        BtValiderActionMiseEnValeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderActionMiseEnValeurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCreationActionMiseEnValeurLayout = new javax.swing.GroupLayout(PanelCreationActionMiseEnValeur);
        PanelCreationActionMiseEnValeur.setLayout(PanelCreationActionMiseEnValeurLayout);
        PanelCreationActionMiseEnValeurLayout.setHorizontalGroup(
            PanelCreationActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationActionMiseEnValeurLayout.createSequentialGroup()
                .addGroup(PanelCreationActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationActionMiseEnValeurLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelCreationActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCreationActionMiseEnValeurLayout.createSequentialGroup()
                                .addComponent(LbIdActionMiseEnValeur)
                                .addGap(29, 29, 29)
                                .addComponent(TxtIdActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelCreationActionMiseEnValeurLayout.createSequentialGroup()
                                .addComponent(ScrollArbreActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(PanelCreationActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BtAfficherDescriptionInterfaceActionMiseEnValeur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtModifierDescriptionInterfaceActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelCreationActionMiseEnValeurLayout.createSequentialGroup()
                                .addComponent(PanelActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(PanelActionMasquage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelCreationActionMiseEnValeurLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(BtValiderActionMiseEnValeur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtApercuActionMiseEnValeur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtAnnulerActionMiseEnValeur)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelCreationActionMiseEnValeurLayout.setVerticalGroup(
            PanelCreationActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationActionMiseEnValeurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelCreationActionMiseEnValeurLayout.createSequentialGroup()
                        .addGroup(PanelCreationActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbIdActionMiseEnValeur)
                            .addComponent(TxtIdActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScrollArbreActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCreationActionMiseEnValeurLayout.createSequentialGroup()
                        .addComponent(BtModifierDescriptionInterfaceActionMiseEnValeur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtAfficherDescriptionInterfaceActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PanelCreationActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationActionMiseEnValeurLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(PanelActionMasquage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCreationActionMiseEnValeurLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(PanelActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelCreationActionMiseEnValeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtAnnulerActionMiseEnValeur)
                    .addComponent(BtApercuActionMiseEnValeur)
                    .addComponent(BtValiderActionMiseEnValeur))
                .addContainerGap())
        );

        PanelCreationActionAgentAnime.setBackground(new java.awt.Color(255, 225, 196));

        BtApercuActionAgentAnime.setText("Aperçu");
        BtApercuActionAgentAnime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtApercuActionAgentAnimeActionPerformed(evt);
            }
        });

        BtValiderActionAgentAnime.setText("Valider");
        BtValiderActionAgentAnime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderActionAgentAnimeActionPerformed(evt);
            }
        });

        BtAnnulerActionAgentAnime.setText("Annuler");
        BtAnnulerActionAgentAnime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerActionAgentAnimeActionPerformed(evt);
            }
        });

        LbPersoActionAgentAnime.setText("Personnage");

        CbPersoActionAgentAnime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Al", "Alien", "Audie", "Becky", "Ben", "Birdie", "Blanche", "Cami", "Cathie", "Charlie", "Check", "Claude", "Cupid", "Debbie", "Electra", "E-man", "E-woman", "Felini", "Gar", "Genie", "Gourdy", "Hanz", "Isabella", "James", "Leo", "Max", "Merlin", "Milton", "Oscar", "Peedy", "Phony", "Pigeon", "Pikachu", "Plany", "Robby", "Sam", "Santa", "Vrgirl", "Wabbit", "Wartnose" }));
        CbPersoActionAgentAnime.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbPersoActionAgentAnimeItemStateChanged(evt);
            }
        });

        PanelPersoActionAgentAnime.setBackground(new java.awt.Color(153, 255, 153));
        PanelPersoActionAgentAnime.setMaximumSize(new java.awt.Dimension(100, 100));
        PanelPersoActionAgentAnime.setMinimumSize(new java.awt.Dimension(100, 100));

        LbImagePersoActionAgentAnime.setBackground(new java.awt.Color(255, 225, 196));
        LbImagePersoActionAgentAnime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbImagePersoActionAgentAnime.setMaximumSize(new java.awt.Dimension(59, 59));
        LbImagePersoActionAgentAnime.setMinimumSize(new java.awt.Dimension(59, 59));
        LbImagePersoActionAgentAnime.setPreferredSize(new java.awt.Dimension(59, 59));

        javax.swing.GroupLayout PanelPersoActionAgentAnimeLayout = new javax.swing.GroupLayout(PanelPersoActionAgentAnime);
        PanelPersoActionAgentAnime.setLayout(PanelPersoActionAgentAnimeLayout);
        PanelPersoActionAgentAnimeLayout.setHorizontalGroup(
            PanelPersoActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LbImagePersoActionAgentAnime, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        PanelPersoActionAgentAnimeLayout.setVerticalGroup(
            PanelPersoActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LbImagePersoActionAgentAnime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        LbListeActionAgentAnime.setText("Sous-actions");

        ListActionAgentAnime.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListActionAgentAnime.setToolTipText("");
        ListActionAgentAnime.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ListActionAgentAnime.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListActionAgentAnimeValueChanged(evt);
            }
        });
        ScrollListActionAgenAnime.setViewportView(ListActionAgentAnime);

        BtAjouterSSActionAgentAnime.setText("Ajouter");
        BtAjouterSSActionAgentAnime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtAjouterSSActionAgentAnimeMousePressed(evt);
            }
        });
        BtAjouterSSActionAgentAnime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAjouterSSActionAgentAnimeActionPerformed(evt);
            }
        });

        PanelSSActionAgentAnime.setBackground(new java.awt.Color(255, 225, 196));
        PanelSSActionAgentAnime.setBorder(javax.swing.BorderFactory.createTitledBorder("Création d'un sous-action"));
        PanelSSActionAgentAnime.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelSSActionAgentAnime.setMaximumSize(new java.awt.Dimension(481, 273));
        PanelSSActionAgentAnime.setMinimumSize(new java.awt.Dimension(481, 273));

        BtAnnulerSSActionAnimation.setText("Annuler");
        BtAnnulerSSActionAnimation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerSSActionAnimationActionPerformed(evt);
            }
        });

        BtModifierSSActionAnimation.setText("Modifier");
        BtModifierSSActionAnimation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierSSActionAnimationActionPerformed(evt);
            }
        });

        BtValiderSSActionAnimation.setText("Ajouter");
        BtValiderSSActionAnimation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderSSActionAnimationActionPerformed(evt);
            }
        });

        LbTypeSSActionAnimation.setText("Type d'action");

        TxtVerticaleSSActionAnimation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtVerticaleSSActionAnimationActionPerformed(evt);
            }
        });

        SAjTextField3.setPreferredSize(new java.awt.Dimension(162, 20));
        SAjTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAjTextField3ActionPerformed(evt);
            }
        });

        TxtHorizontaleSSActionAnimation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtHorizontaleSSActionAnimationActionPerformed(evt);
            }
        });

        LbHorizontaleSSActionAnimation.setText("Position horizontale :");

        SAjLabel4.setText("Animation :");

        SAjLabel3.setText("Texte :");

        CbTypeSSActionAnimation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "déplacement", "parole", "pensée", "animation" }));
        CbTypeSSActionAnimation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbTypeSSActionAnimationItemStateChanged(evt);
            }
        });
        CbTypeSSActionAnimation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbTypeSSActionAnimationActionPerformed(evt);
            }
        });

        LbVerticaleSSActionAnimation.setText("Position verticale :");

        SAjComboBoxIdentifiant.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", " " }));
        SAjComboBoxIdentifiant.setMaximumSize(new java.awt.Dimension(162, 20));
        SAjComboBoxIdentifiant.setMinimumSize(new java.awt.Dimension(162, 20));
        SAjComboBoxIdentifiant.setPreferredSize(new java.awt.Dimension(162, 20));

        javax.swing.GroupLayout PanelSSActionAgentAnimeLayout = new javax.swing.GroupLayout(PanelSSActionAgentAnime);
        PanelSSActionAgentAnime.setLayout(PanelSSActionAgentAnimeLayout);
        PanelSSActionAgentAnimeLayout.setHorizontalGroup(
            PanelSSActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSSActionAgentAnimeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSSActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSSActionAgentAnimeLayout.createSequentialGroup()
                        .addGroup(PanelSSActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelSSActionAgentAnimeLayout.createSequentialGroup()
                                .addGroup(PanelSSActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(LbVerticaleSSActionAnimation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LbTypeSSActionAnimation, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LbHorizontaleSSActionAnimation, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelSSActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CbTypeSSActionAnimation, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TxtHorizontaleSSActionAnimation, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TxtVerticaleSSActionAnimation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelSSActionAgentAnimeLayout.createSequentialGroup()
                                .addGroup(PanelSSActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SAjLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SAjLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(33, 33, 33)
                                .addGroup(PanelSSActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SAjTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SAjComboBoxIdentifiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSSActionAgentAnimeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtValiderSSActionAnimation, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtModifierSSActionAnimation, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtAnnulerSSActionAnimation, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))))
        );
        PanelSSActionAgentAnimeLayout.setVerticalGroup(
            PanelSSActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSSActionAgentAnimeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSSActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTypeSSActionAnimation)
                    .addComponent(CbTypeSSActionAnimation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(PanelSSActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbHorizontaleSSActionAnimation)
                    .addComponent(TxtHorizontaleSSActionAnimation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelSSActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbVerticaleSSActionAnimation)
                    .addComponent(TxtVerticaleSSActionAnimation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelSSActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SAjLabel3)
                    .addComponent(SAjTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelSSActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SAjLabel4)
                    .addComponent(SAjComboBoxIdentifiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelSSActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtAnnulerSSActionAnimation)
                    .addComponent(BtModifierSSActionAnimation)
                    .addComponent(BtValiderSSActionAnimation))
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelCreationActionAgentAnimeLayout = new javax.swing.GroupLayout(PanelCreationActionAgentAnime);
        PanelCreationActionAgentAnime.setLayout(PanelCreationActionAgentAnimeLayout);
        PanelCreationActionAgentAnimeLayout.setHorizontalGroup(
            PanelCreationActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationActionAgentAnimeLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(LbPersoActionAgentAnime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CbPersoActionAgentAnime, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(PanelPersoActionAgentAnime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
            .addGroup(PanelCreationActionAgentAnimeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbListeActionAgentAnime, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAjouterSSActionAgentAnime, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScrollListActionAgenAnime, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(PanelSSActionAgentAnime, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreationActionAgentAnimeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtValiderActionAgentAnime, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtApercuActionAgentAnime, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtAnnulerActionAgentAnime, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        PanelCreationActionAgentAnimeLayout.setVerticalGroup(
            PanelCreationActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreationActionAgentAnimeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbPersoActionAgentAnime)
                    .addComponent(CbPersoActionAgentAnime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelPersoActionAgentAnime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreationActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelCreationActionAgentAnimeLayout.createSequentialGroup()
                        .addComponent(LbListeActionAgentAnime)
                        .addGap(8, 8, 8)
                        .addComponent(ScrollListActionAgenAnime, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtAjouterSSActionAgentAnime))
                    .addComponent(PanelSSActionAgentAnime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreationActionAgentAnimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtApercuActionAgentAnime)
                    .addComponent(BtValiderActionAgentAnime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtAnnulerActionAgentAnime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        PanelCreationActionModifierProfil.setBackground(new java.awt.Color(255, 225, 196));

        ArbreActionProfil.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                ArbreActionProfilValueChanged(evt);
            }
        });
        ScrollArbreActionProfil.setViewportView(ArbreActionProfil);

        LbSelectionActionModifierProfil.setText("Sélectionnez un élément dans l'arbre ci-dessous");

        LbElementActionModifierProfil.setText("Element à modifier :");

        TxtElementActionModifierProfil.setEditable(false);

        LbTypeActionModifierProfil.setText("Type de modification :");

        CbTypeActionModifierProfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbTypeActionModifierProfil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbTypeActionModifierProfilItemStateChanged(evt);
            }
        });

        PanelModifierActionModifierProfil.setBackground(new java.awt.Color(255, 225, 196));

        LbPointActionModifierProfil.setText("Points");

        LbActionActionModifierProfil.setText("Modifier la valeur de :");

        javax.swing.GroupLayout PanelModifierActionModifierProfilLayout = new javax.swing.GroupLayout(PanelModifierActionModifierProfil);
        PanelModifierActionModifierProfil.setLayout(PanelModifierActionModifierProfilLayout);
        PanelModifierActionModifierProfilLayout.setHorizontalGroup(
            PanelModifierActionModifierProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelModifierActionModifierProfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbActionActionModifierProfil)
                .addGap(28, 28, 28)
                .addComponent(SpinModifierActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LbPointActionModifierProfil))
        );
        PanelModifierActionModifierProfilLayout.setVerticalGroup(
            PanelModifierActionModifierProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelModifierActionModifierProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(SpinModifierActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(LbPointActionModifierProfil)
                .addComponent(LbActionActionModifierProfil))
        );

        PanelExacteActionModifierProfil.setBackground(new java.awt.Color(255, 225, 196));

        CbNiveauxActionModifierProfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        LbExacteActionModifierProfil.setText("Affecter la valeur à :");

        javax.swing.GroupLayout PanelExacteActionModifierProfilLayout = new javax.swing.GroupLayout(PanelExacteActionModifierProfil);
        PanelExacteActionModifierProfil.setLayout(PanelExacteActionModifierProfilLayout);
        PanelExacteActionModifierProfilLayout.setHorizontalGroup(
            PanelExacteActionModifierProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelExacteActionModifierProfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbExacteActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CbNiveauxActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SpinExacteActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234))
        );
        PanelExacteActionModifierProfilLayout.setVerticalGroup(
            PanelExacteActionModifierProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelExacteActionModifierProfilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelExacteActionModifierProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelExacteActionModifierProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SpinExacteActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CbNiveauxActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LbExacteActionModifierProfil))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LbSourceActionModifierProfil.setText("Préciser la source :");

        BtAnnulerActionProfil.setText("Annuler");
        BtAnnulerActionProfil.setToolTipText("Retour à la définition des règles d'assistance");
        BtAnnulerActionProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerActionProfilActionPerformed(evt);
            }
        });

        BtValiderActionProfil.setText("Valider");
        BtValiderActionProfil.setToolTipText("Valider l'action et revenir à la définition des règles d'assistance");
        BtValiderActionProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderActionProfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCreationActionModifierProfilLayout = new javax.swing.GroupLayout(PanelCreationActionModifierProfil);
        PanelCreationActionModifierProfil.setLayout(PanelCreationActionModifierProfilLayout);
        PanelCreationActionModifierProfilLayout.setHorizontalGroup(
            PanelCreationActionModifierProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationActionModifierProfilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationActionModifierProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelModifierActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelExacteActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelCreationActionModifierProfilLayout.createSequentialGroup()
                        .addComponent(LbSourceActionModifierProfil)
                        .addGap(18, 18, 18)
                        .addComponent(TxtSourceActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCreationActionModifierProfilLayout.createSequentialGroup()
                        .addComponent(BtValiderActionProfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtAnnulerActionProfil))
                    .addGroup(PanelCreationActionModifierProfilLayout.createSequentialGroup()
                        .addGroup(PanelCreationActionModifierProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(LbElementActionModifierProfil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LbSelectionActionModifierProfil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ScrollArbreActionProfil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(TxtElementActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCreationActionModifierProfilLayout.createSequentialGroup()
                        .addComponent(LbTypeActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CbTypeActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelCreationActionModifierProfilLayout.setVerticalGroup(
            PanelCreationActionModifierProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationActionModifierProfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbSelectionActionModifierProfil)
                .addGap(12, 12, 12)
                .addComponent(ScrollArbreActionProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelCreationActionModifierProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbElementActionModifierProfil)
                    .addComponent(TxtElementActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreationActionModifierProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTypeActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbTypeActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelModifierActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelExacteActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelCreationActionModifierProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbSourceActionModifierProfil)
                    .addComponent(TxtSourceActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCreationActionModifierProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtAnnulerActionProfil)
                    .addComponent(BtValiderActionProfil))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelCreationActionPasaPas.setBackground(new java.awt.Color(255, 225, 196));

        BtAnnulerActionPasaPas.setText("Annuler");
        BtAnnulerActionPasaPas.setToolTipText("Retour à la définition des règles d'assistance");
        BtAnnulerActionPasaPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerActionPasaPasActionPerformed(evt);
            }
        });

        BtValiderActionPasaPas.setText("Valider");
        BtValiderActionPasaPas.setToolTipText("Valider l'action et revenir à la définition des règles d'assistance");
        BtValiderActionPasaPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderActionPasaPasActionPerformed(evt);
            }
        });

        BtApercuActionPasaPas.setText("Aperçu");
        BtApercuActionPasaPas.setToolTipText("Voir un aperçu de la mise en valeur définie sur des composants exemples");
        BtApercuActionPasaPas.setEnabled(false);
        BtApercuActionPasaPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtApercuActionPasaPasActionPerformed(evt);
            }
        });

        LbTypeActionPasaPas.setText("Type de pas à pas :");

        CbTypeActionPasaPas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbTypeActionPasaPas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbTypeActionPasaPasItemStateChanged(evt);
            }
        });

        LbEtapesActionPasaPas.setText("Liste des étapes :");

        CbEtapesActionPasaPas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbEtapesActionPasaPas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbEtapesActionPasaPasItemStateChanged(evt);
            }
        });

        BtCreerEtapesActionPasaPas.setText("Creer");
        BtCreerEtapesActionPasaPas.setToolTipText("Créer une nouvelle liste d'étapes");
        BtCreerEtapesActionPasaPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCreerEtapesActionPasaPasActionPerformed(evt);
            }
        });

        ListeActionPasaPas.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "item1", "item2", "item3" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        ListeActionPasaPas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ScrollListeActionPasaPas.setViewportView(ListeActionPasaPas);

        LbOptionActionPasaPas.setText("Options générales :");

        CheckMessageAvantActionPasaPas.setBackground(new java.awt.Color(255, 225, 196));
        CheckMessageAvantActionPasaPas.setText("Afficher un message avant le début du pas à pas");
        CheckMessageAvantActionPasaPas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckMessageAvantActionPasaPasItemStateChanged(evt);
            }
        });
        CheckMessageAvantActionPasaPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckMessageAvantActionPasaPasActionPerformed(evt);
            }
        });

        CheckMessageAvantAutorisationActionPasaPas.setBackground(new java.awt.Color(255, 225, 196));
        CheckMessageAvantAutorisationActionPasaPas.setText("Demander l'autorisation à l'utilisateur");

        CheckMessageApresActionPasaPas.setBackground(new java.awt.Color(255, 225, 196));
        CheckMessageApresActionPasaPas.setText("Afficher un message à la fin du pas à pas");
        CheckMessageApresActionPasaPas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckMessageApresActionPasaPasItemStateChanged(evt);
            }
        });

        CheckMessageApresBilanActionPasaPas.setBackground(new java.awt.Color(255, 225, 196));
        CheckMessageApresBilanActionPasaPas.setText("Afficher le bilan");

        CheckProgressionActionPasaPas.setBackground(new java.awt.Color(255, 225, 196));
        CheckProgressionActionPasaPas.setText("Afficher la progression tout au long du pas à pas");

        LbOptionEtapesActionPasaPas.setText("Options des étapes du pas à pas :");

        CheckMiseEnValeurActionPasaPas.setBackground(new java.awt.Color(255, 225, 196));
        CheckMiseEnValeurActionPasaPas.setText("Mettre en valeur le composant concerné");
        CheckMiseEnValeurActionPasaPas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckMiseEnValeurActionPasaPasItemStateChanged(evt);
            }
        });

        PanelGuiderActionPasaPas.setBackground(new java.awt.Color(255, 225, 196));

        CheckInterventionActionPasaPas.setBackground(new java.awt.Color(255, 225, 196));
        CheckInterventionActionPasaPas.setSelected(true);
        CheckInterventionActionPasaPas.setText("Demander l'intervention de l'utilisateur");
        CheckInterventionActionPasaPas.setEnabled(false);
        CheckInterventionActionPasaPas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckInterventionActionPasaPasItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout PanelGuiderActionPasaPasLayout = new javax.swing.GroupLayout(PanelGuiderActionPasaPas);
        PanelGuiderActionPasaPas.setLayout(PanelGuiderActionPasaPasLayout);
        PanelGuiderActionPasaPasLayout.setHorizontalGroup(
            PanelGuiderActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGuiderActionPasaPasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CheckInterventionActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelGuiderActionPasaPasLayout.setVerticalGroup(
            PanelGuiderActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGuiderActionPasaPasLayout.createSequentialGroup()
                .addComponent(CheckInterventionActionPasaPas)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        PanelAutomatiserActionPasaPas.setBackground(new java.awt.Color(255, 225, 196));

        CheckExpliquerEtapeActionPasaPas.setBackground(new java.awt.Color(255, 225, 196));
        CheckExpliquerEtapeActionPasaPas.setText("Expliquer l'étape à venir");
        CheckExpliquerEtapeActionPasaPas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckExpliquerEtapeActionPasaPasItemStateChanged(evt);
            }
        });

        CheckExpliquerEtapeAutorisationActionPasaPas.setBackground(new java.awt.Color(255, 225, 196));
        CheckExpliquerEtapeAutorisationActionPasaPas.setText("Demander l'autorisation à l'utilisateur");

        CheckExpliquerEtapeTermineeActionPasaPas.setBackground(new java.awt.Color(255, 225, 196));
        CheckExpliquerEtapeTermineeActionPasaPas.setText("Expliquer l'étape qui se termine");
        CheckExpliquerEtapeTermineeActionPasaPas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckExpliquerEtapeTermineeActionPasaPasItemStateChanged(evt);
            }
        });
        CheckExpliquerEtapeTermineeActionPasaPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckExpliquerEtapeTermineeActionPasaPasActionPerformed(evt);
            }
        });

        CheckTimerActionPasaPas.setBackground(new java.awt.Color(255, 225, 196));
        CheckTimerActionPasaPas.setText("Timer entre deux étapes :");
        CheckTimerActionPasaPas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckTimerActionPasaPasItemStateChanged(evt);
            }
        });
        CheckTimerActionPasaPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckTimerActionPasaPasActionPerformed(evt);
            }
        });

        SpinTimerActionPasaPas.setModel(new javax.swing.SpinnerNumberModel(10, 0, 600, 1));

        LbSecondesActionPasaPas.setText("secondes");

        javax.swing.GroupLayout PanelAutomatiserActionPasaPasLayout = new javax.swing.GroupLayout(PanelAutomatiserActionPasaPas);
        PanelAutomatiserActionPasaPas.setLayout(PanelAutomatiserActionPasaPasLayout);
        PanelAutomatiserActionPasaPasLayout.setHorizontalGroup(
            PanelAutomatiserActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAutomatiserActionPasaPasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAutomatiserActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAutomatiserActionPasaPasLayout.createSequentialGroup()
                        .addComponent(CheckExpliquerEtapeActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CheckExpliquerEtapeAutorisationActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelAutomatiserActionPasaPasLayout.createSequentialGroup()
                        .addGroup(PanelAutomatiserActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CheckExpliquerEtapeTermineeActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelAutomatiserActionPasaPasLayout.createSequentialGroup()
                                .addComponent(CheckTimerActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SpinTimerActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LbSecondesActionPasaPas)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelAutomatiserActionPasaPasLayout.setVerticalGroup(
            PanelAutomatiserActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAutomatiserActionPasaPasLayout.createSequentialGroup()
                .addGroup(PanelAutomatiserActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckExpliquerEtapeActionPasaPas)
                    .addComponent(CheckExpliquerEtapeAutorisationActionPasaPas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckExpliquerEtapeTermineeActionPasaPas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelAutomatiserActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckTimerActionPasaPas)
                    .addComponent(SpinTimerActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbSecondesActionPasaPas))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        BtModifierEtapesActionPasaPas.setText("Modifier");
        BtModifierEtapesActionPasaPas.setToolTipText("Modifier la liste des étapes");
        BtModifierEtapesActionPasaPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierEtapesActionPasaPasActionPerformed(evt);
            }
        });

        BtPersonnaliserMessagesPasAPas.setText("Modifier les messages");
        BtPersonnaliserMessagesPasAPas.setToolTipText("Personnaliser le contenu et la mise en forme des messages du pas à pas");
        BtPersonnaliserMessagesPasAPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPersonnaliserMessagesPasAPasActionPerformed(evt);
            }
        });

        BtMiseEnValeurPasAPas.setText("Modifier la mise en valeur");
        BtMiseEnValeurPasAPas.setToolTipText("Modifier la mise en valeur des composants");
        BtMiseEnValeurPasAPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtMiseEnValeurPasAPasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCreationActionPasaPasLayout = new javax.swing.GroupLayout(PanelCreationActionPasaPas);
        PanelCreationActionPasaPas.setLayout(PanelCreationActionPasaPasLayout);
        PanelCreationActionPasaPasLayout.setHorizontalGroup(
            PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationActionPasaPasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationActionPasaPasLayout.createSequentialGroup()
                        .addComponent(PanelGuiderActionPasaPas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(PanelCreationActionPasaPasLayout.createSequentialGroup()
                        .addGroup(PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCreationActionPasaPasLayout.createSequentialGroup()
                                .addComponent(LbTypeActionPasaPas)
                                .addGap(35, 35, 35)
                                .addGroup(PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CbTypeActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CbEtapesActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelCreationActionPasaPasLayout.createSequentialGroup()
                                .addComponent(BtValiderActionPasaPas)
                                .addGap(48, 48, 48)
                                .addComponent(BtApercuActionPasaPas))
                            .addComponent(LbEtapesActionPasaPas)
                            .addGroup(PanelCreationActionPasaPasLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CheckMessageApresActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CheckMessageAvantActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CheckProgressionActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCreationActionPasaPasLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CheckMessageAvantAutorisationActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtAnnulerActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CheckMessageApresBilanActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
                            .addGroup(PanelCreationActionPasaPasLayout.createSequentialGroup()
                                .addComponent(BtModifierEtapesActionPasaPas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtCreerEtapesActionPasaPas)
                                .addContainerGap())))
                    .addGroup(PanelCreationActionPasaPasLayout.createSequentialGroup()
                        .addGroup(PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelAutomatiserActionPasaPas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelCreationActionPasaPasLayout.createSequentialGroup()
                                .addGroup(PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LbOptionActionPasaPas)
                                    .addComponent(LbOptionEtapesActionPasaPas)
                                    .addGroup(PanelCreationActionPasaPasLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(CheckMiseEnValeurActionPasaPas)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(0, 26, 26))
                    .addGroup(PanelCreationActionPasaPasLayout.createSequentialGroup()
                        .addComponent(BtPersonnaliserMessagesPasAPas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtMiseEnValeurPasAPas)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelCreationActionPasaPasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ScrollListeActionPasaPas, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        PanelCreationActionPasaPasLayout.setVerticalGroup(
            PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationActionPasaPasLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTypeActionPasaPas)
                    .addComponent(CbTypeActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbEtapesActionPasaPas)
                    .addComponent(CbEtapesActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtModifierEtapesActionPasaPas)
                    .addComponent(BtCreerEtapesActionPasaPas))
                .addGap(62, 62, 62)
                .addComponent(LbOptionActionPasaPas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckMessageAvantActionPasaPas)
                    .addComponent(CheckMessageAvantAutorisationActionPasaPas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckMessageApresActionPasaPas)
                    .addComponent(CheckMessageApresBilanActionPasaPas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckProgressionActionPasaPas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LbOptionEtapesActionPasaPas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckMiseEnValeurActionPasaPas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelGuiderActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationActionPasaPasLayout.createSequentialGroup()
                        .addComponent(PanelAutomatiserActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreationActionPasaPasLayout.createSequentialGroup()
                        .addGroup(PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtPersonnaliserMessagesPasAPas)
                            .addComponent(BtMiseEnValeurPasAPas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtValiderActionPasaPas)
                    .addComponent(BtApercuActionPasaPas)
                    .addComponent(BtAnnulerActionPasaPas))
                .addContainerGap())
            .addGroup(PanelCreationActionPasaPasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelCreationActionPasaPasLayout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(ScrollListeActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(349, Short.MAX_VALUE)))
        );

        PanelCreationActionInterface.setBackground(new java.awt.Color(255, 225, 196));

        ArbreActionInterface.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                ArbreActionInterfaceValueChanged(evt);
            }
        });
        ScrollArbreActionInterface.setViewportView(ArbreActionInterface);

        LbComposantActionInterface.setText("Composant concerné");

        TxtComposantActionInterface.setEditable(false);

        BtAnnulerActionInterface.setText("Annuler");
        BtAnnulerActionInterface.setToolTipText("Retour à la définition des règles d'assistance");
        BtAnnulerActionInterface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerActionInterfaceActionPerformed(evt);
            }
        });

        BtValiderActionInterface.setText("Valider");
        BtValiderActionInterface.setToolTipText("Valider l'action et revenir à la définition des règles d'assistance");
        BtValiderActionInterface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderActionInterfaceActionPerformed(evt);
            }
        });

        BtApercuActionInterface.setText("Apercu");
        BtApercuActionInterface.setToolTipText("Retour à la définition des règles d'assistance");
        BtApercuActionInterface.setEnabled(false);

        LbActionActionInterface.setText("Action à réaliser sur le composant");

        CbActionActionInterface.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbActionActionInterface.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbActionActionInterfaceItemStateChanged(evt);
            }
        });

        PanelEtatActionInterface.setBackground(new java.awt.Color(255, 225, 196));

        LbEtatActionInterface.setText("Passer à l'état");

        RbOnActionInterface.setBackground(new java.awt.Color(255, 225, 196));
        RbOnActionInterface.setText("coché/on");
        RbOnActionInterface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbOnActionInterfaceActionPerformed(evt);
            }
        });

        RbOffActionInterface.setBackground(new java.awt.Color(255, 225, 196));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelEtatActionInterfaceLayout.setVerticalGroup(
            PanelEtatActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEtatActionInterfaceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEtatActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbEtatActionInterface)
                    .addComponent(RbOnActionInterface)
                    .addComponent(RbOffActionInterface))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        PanelValeurActionInterface.setBackground(new java.awt.Color(255, 225, 196));

        LbValeurActionInterface.setText("Attribuer la valeur");

        javax.swing.GroupLayout PanelValeurActionInterfaceLayout = new javax.swing.GroupLayout(PanelValeurActionInterface);
        PanelValeurActionInterface.setLayout(PanelValeurActionInterfaceLayout);
        PanelValeurActionInterfaceLayout.setHorizontalGroup(
            PanelValeurActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelValeurActionInterfaceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbValeurActionInterface)
                .addGap(31, 31, 31)
                .addComponent(TxtValeurActionInterface))
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

        BtAfficherDescriptionInterfaceActionInterface.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        BtAfficherDescriptionInterfaceActionInterface.setText("+");
        BtAfficherDescriptionInterfaceActionInterface.setToolTipText("Afficher la totalité de la description de l'interface");
        BtAfficherDescriptionInterfaceActionInterface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAfficherDescriptionInterfaceActionInterfaceActionPerformed(evt);
            }
        });

        BtModifierDescriptionInterfaceActionInterface.setText("...");
        BtModifierDescriptionInterfaceActionInterface.setToolTipText("Modifier la description de l'interface");
        BtModifierDescriptionInterfaceActionInterface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierDescriptionInterfaceActionInterfaceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCreationActionInterfaceLayout = new javax.swing.GroupLayout(PanelCreationActionInterface);
        PanelCreationActionInterface.setLayout(PanelCreationActionInterfaceLayout);
        PanelCreationActionInterfaceLayout.setHorizontalGroup(
            PanelCreationActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationActionInterfaceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationActionInterfaceLayout.createSequentialGroup()
                        .addComponent(LbComposantActionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtComposantActionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreationActionInterfaceLayout.createSequentialGroup()
                        .addGroup(PanelCreationActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ScrollArbreActionInterface, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelCreationActionInterfaceLayout.createSequentialGroup()
                                .addComponent(BtValiderActionInterface)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtApercuActionInterface)))
                        .addGroup(PanelCreationActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCreationActionInterfaceLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtAnnulerActionInterface))
                            .addGroup(PanelCreationActionInterfaceLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(PanelCreationActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BtAfficherDescriptionInterfaceActionInterface, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtModifierDescriptionInterfaceActionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(54, 54, 54))
                    .addGroup(PanelCreationActionInterfaceLayout.createSequentialGroup()
                        .addComponent(LbActionActionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CbActionActionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreationActionInterfaceLayout.createSequentialGroup()
                        .addGroup(PanelCreationActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PanelValeurActionInterface, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanelEtatActionInterface, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        PanelCreationActionInterfaceLayout.setVerticalGroup(
            PanelCreationActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationActionInterfaceLayout.createSequentialGroup()
                .addGroup(PanelCreationActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationActionInterfaceLayout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addGroup(PanelCreationActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbComposantActionInterface)
                            .addComponent(TxtComposantActionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ScrollArbreActionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(PanelCreationActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbActionActionInterface)
                            .addComponent(CbActionActionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelCreationActionInterfaceLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(BtModifierDescriptionInterfaceActionInterface)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtAfficherDescriptionInterfaceActionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(PanelEtatActionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelValeurActionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(PanelCreationActionInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtAnnulerActionInterface)
                    .addComponent(BtValiderActionInterface)
                    .addComponent(BtApercuActionInterface)))
        );

        TxtNomAction.setText(" ");
        TxtNomAction.setEnabled(false);

        LbNomAction.setText("Nom de l'action");

        PanelCreationActionMessage.setBackground(new java.awt.Color(255, 225, 196));

        LbTypeActionMessage.setText("Type de message");

        CheckEcritActionMessage.setBackground(new java.awt.Color(255, 225, 196));
        CheckEcritActionMessage.setSelected(true);
        CheckEcritActionMessage.setText("Ecrit");
        CheckEcritActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckEcritActionMessageActionPerformed(evt);
            }
        });

        CheckOralActionMessage.setBackground(new java.awt.Color(255, 225, 196));
        CheckOralActionMessage.setText("Oral");
        CheckOralActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckOralActionMessageActionPerformed(evt);
            }
        });
        CheckOralActionMessage.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CheckOralActionMessagePropertyChange(evt);
            }
        });

        CheckDifferentActionMessage.setBackground(new java.awt.Color(255, 225, 196));
        CheckDifferentActionMessage.setText("Message oral différent");
        CheckDifferentActionMessage.setEnabled(false);
        CheckDifferentActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckDifferentActionMessageActionPerformed(evt);
            }
        });
        CheckDifferentActionMessage.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CheckDifferentActionMessagePropertyChange(evt);
            }
        });

        ScrollDifferentActionMessage.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollDifferentActionMessage.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        TxtDifferentActionMessage.setColumns(20);
        TxtDifferentActionMessage.setRows(5);
        TxtDifferentActionMessage.setEnabled(false);
        TxtDifferentActionMessage.setPreferredSize(new java.awt.Dimension(164, 40));
        ScrollDifferentActionMessage.setViewportView(TxtDifferentActionMessage);

        CbModeActionMessage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbModeActionMessage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbModeActionMessageItemStateChanged(evt);
            }
        });

        BtAfficherDetailsActionMessage.setText("...");
        BtAfficherDetailsActionMessage.setToolTipText("Afficher les détails du message");
        BtAfficherDetailsActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAfficherDetailsActionMessageActionPerformed(evt);
            }
        });

        BtApercuActionMessage.setText("Aperçu");
        BtApercuActionMessage.setToolTipText("Voir un aperçu de la mise en valeur définie sur des composants exemples");
        BtApercuActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtApercuActionMessageActionPerformed(evt);
            }
        });

        BtValiderActionMessage.setText("Valider");
        BtValiderActionMessage.setToolTipText("Valider l'action et revenir à la définition des règles d'assistance");
        BtValiderActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderActionMessageActionPerformed(evt);
            }
        });

        BtAnnulerActionMessage.setText("Annuler");
        BtAnnulerActionMessage.setToolTipText("Retour à la définition des règles d'assistance");
        BtAnnulerActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerActionMessageActionPerformed(evt);
            }
        });

        PanelDetailsPopupActionMessage.setBackground(new java.awt.Color(255, 225, 196));
        PanelDetailsPopupActionMessage.setBorder(javax.swing.BorderFactory.createTitledBorder("Plus de détails"));

        CbPositionVerticalePopupActionMessage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "centre", "bas", "haut" }));
        CbPositionVerticalePopupActionMessage.setMinimumSize(new java.awt.Dimension(0, 22));
        CbPositionVerticalePopupActionMessage.setPreferredSize(new java.awt.Dimension(70, 22));

        LbPositionHorizontalePopupActionMessage.setText("horizontalement");

        RbPositionEcranPopupActionMessage.setBackground(new java.awt.Color(255, 225, 196));
        actionMessage.add(RbPositionEcranPopupActionMessage);
        RbPositionEcranPopupActionMessage.setSelected(true);
        RbPositionEcranPopupActionMessage.setText("Par rapport à l'écran");
        RbPositionEcranPopupActionMessage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RbPositionEcranPopupActionMessageItemStateChanged(evt);
            }
        });
        RbPositionEcranPopupActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbPositionEcranPopupActionMessageActionPerformed(evt);
            }
        });

        LbPositionVerticalePopupActionMessage.setText("verticalement");

        CbPositionHorizontalePopupActionMessage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "centre", "gauche", "droite" }));
        CbPositionHorizontalePopupActionMessage.setMinimumSize(new java.awt.Dimension(0, 22));
        CbPositionHorizontalePopupActionMessage.setPreferredSize(new java.awt.Dimension(70, 22));

        RbPositionCoordonneesPopupActionMessage.setBackground(new java.awt.Color(255, 225, 196));
        actionMessage.add(RbPositionCoordonneesPopupActionMessage);
        RbPositionCoordonneesPopupActionMessage.setText("Coordonnées");
        RbPositionCoordonneesPopupActionMessage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RbPositionCoordonneesPopupActionMessageItemStateChanged(evt);
            }
        });
        RbPositionCoordonneesPopupActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbPositionCoordonneesPopupActionMessageActionPerformed(evt);
            }
        });

        LbXPopupActionMessage.setText("horizontalement");

        LbPositionPopupActionMessage.setText("Position");

        BtRbPositionSourisPopupActionMessage.setBackground(new java.awt.Color(255, 225, 196));
        actionMessage.add(BtRbPositionSourisPopupActionMessage);
        BtRbPositionSourisPopupActionMessage.setText("A l'emplacement de la souris");
        BtRbPositionSourisPopupActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRbPositionSourisPopupActionMessageActionPerformed(evt);
            }
        });

        SpinYPopupActionMessage.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        SpinYPopupActionMessage.setToolTipText("En pixels par rapport au coin haut gauche de l'écran");
        SpinYPopupActionMessage.setEnabled(false);
        SpinYPopupActionMessage.setMinimumSize(new java.awt.Dimension(0, 22));
        SpinYPopupActionMessage.setPreferredSize(new java.awt.Dimension(70, 22));

        SpinXPopupActionMessage.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        SpinXPopupActionMessage.setToolTipText("En pixels par rapport au coin haut gauche de l'écran");
        SpinXPopupActionMessage.setEnabled(false);
        SpinXPopupActionMessage.setMinimumSize(new java.awt.Dimension(0, 22));
        SpinXPopupActionMessage.setPreferredSize(new java.awt.Dimension(70, 22));

        LbYPopupActionMessage.setText("verticalement");

        LbLargeurFenetrePopupActionMessage.setText("largeur");

        SpinLargeurFenetrePopupActionMessage.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        SpinLargeurFenetrePopupActionMessage.setToolTipText("Largeur en pixels");
        SpinLargeurFenetrePopupActionMessage.setEnabled(false);
        SpinLargeurFenetrePopupActionMessage.setMinimumSize(new java.awt.Dimension(0, 22));
        SpinLargeurFenetrePopupActionMessage.setPreferredSize(new java.awt.Dimension(70, 22));

        SpinHauteurFenetrePopupActionMessage.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        SpinHauteurFenetrePopupActionMessage.setToolTipText("Hauteur en pixels");
        SpinHauteurFenetrePopupActionMessage.setEnabled(false);
        SpinHauteurFenetrePopupActionMessage.setMinimumSize(new java.awt.Dimension(0, 22));
        SpinHauteurFenetrePopupActionMessage.setPreferredSize(new java.awt.Dimension(70, 22));

        LbHauteurFenetrePopupActionMessage.setText("hauteur");

        BtTailleManuellePopupActionMessage.setBackground(new java.awt.Color(255, 225, 196));
        ActionMessage3.add(BtTailleManuellePopupActionMessage);
        BtTailleManuellePopupActionMessage.setText("Manuelle");
        BtTailleManuellePopupActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtTailleManuellePopupActionMessageActionPerformed(evt);
            }
        });

        BtTailleAutomatiquePopupActionMessage.setBackground(new java.awt.Color(255, 225, 196));
        ActionMessage3.add(BtTailleAutomatiquePopupActionMessage);
        BtTailleAutomatiquePopupActionMessage.setSelected(true);
        BtTailleAutomatiquePopupActionMessage.setText("Automatique");
        BtTailleAutomatiquePopupActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtTailleAutomatiquePopupActionMessageActionPerformed(evt);
            }
        });

        LbTailleFenetrePopupActionMessage.setText("Taille");

        LbTitreFenetrePopupActionMessage.setText("Titre");

        TxtTitreFenetreActionMessage.setText("Aide");
        TxtTitreFenetreActionMessage.setPreferredSize(new java.awt.Dimension(100, 22));
        TxtTitreFenetreActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTitreFenetreActionMessageActionPerformed(evt);
            }
        });

        CheckMiseEnFormeActionMessage.setBackground(new java.awt.Color(255, 225, 196));
        CheckMiseEnFormeActionMessage.setText("Mise en forme avancée");
        CheckMiseEnFormeActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckMiseEnFormeActionMessageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelDetailsPopupActionMessageLayout = new javax.swing.GroupLayout(PanelDetailsPopupActionMessage);
        PanelDetailsPopupActionMessage.setLayout(PanelDetailsPopupActionMessageLayout);
        PanelDetailsPopupActionMessageLayout.setHorizontalGroup(
            PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDetailsPopupActionMessageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDetailsPopupActionMessageLayout.createSequentialGroup()
                        .addGroup(PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LbTitreFenetrePopupActionMessage)
                            .addComponent(LbTailleFenetrePopupActionMessage))
                        .addGroup(PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelDetailsPopupActionMessageLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtTailleAutomatiquePopupActionMessage)
                                    .addGroup(PanelDetailsPopupActionMessageLayout.createSequentialGroup()
                                        .addComponent(BtTailleManuellePopupActionMessage)
                                        .addGap(33, 33, 33)
                                        .addComponent(LbHauteurFenetrePopupActionMessage)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SpinHauteurFenetrePopupActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(LbLargeurFenetrePopupActionMessage)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SpinLargeurFenetrePopupActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(PanelDetailsPopupActionMessageLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(TxtTitreFenetreActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(PanelDetailsPopupActionMessageLayout.createSequentialGroup()
                        .addGroup(PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelDetailsPopupActionMessageLayout.createSequentialGroup()
                                .addComponent(LbPositionPopupActionMessage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelDetailsPopupActionMessageLayout.createSequentialGroup()
                                        .addGroup(PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RbPositionEcranPopupActionMessage)
                                            .addComponent(RbPositionCoordonneesPopupActionMessage))
                                        .addGap(18, 18, 18)
                                        .addGroup(PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LbPositionHorizontalePopupActionMessage)
                                            .addComponent(LbXPopupActionMessage))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(SpinXPopupActionMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(CbPositionHorizontalePopupActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(PanelDetailsPopupActionMessageLayout.createSequentialGroup()
                                                .addComponent(LbYPopupActionMessage)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(SpinYPopupActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(PanelDetailsPopupActionMessageLayout.createSequentialGroup()
                                                .addComponent(LbPositionVerticalePopupActionMessage)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CbPositionVerticalePopupActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(BtRbPositionSourisPopupActionMessage)))
                            .addComponent(CheckMiseEnFormeActionMessage))
                        .addGap(0, 12, Short.MAX_VALUE))))
        );
        PanelDetailsPopupActionMessageLayout.setVerticalGroup(
            PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDetailsPopupActionMessageLayout.createSequentialGroup()
                .addGroup(PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbPositionPopupActionMessage)
                    .addComponent(BtRbPositionSourisPopupActionMessage))
                .addGap(0, 0, 0)
                .addGroup(PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbPositionEcranPopupActionMessage)
                    .addComponent(LbPositionHorizontalePopupActionMessage)
                    .addComponent(CbPositionHorizontalePopupActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbPositionVerticalePopupActionMessage)
                    .addComponent(CbPositionVerticalePopupActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbPositionCoordonneesPopupActionMessage)
                    .addComponent(LbXPopupActionMessage)
                    .addComponent(SpinXPopupActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbYPopupActionMessage)
                    .addComponent(SpinYPopupActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTitreFenetrePopupActionMessage)
                    .addComponent(TxtTitreFenetreActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTailleFenetrePopupActionMessage)
                    .addComponent(BtTailleAutomatiquePopupActionMessage))
                .addGroup(PanelDetailsPopupActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtTailleManuellePopupActionMessage)
                    .addComponent(LbHauteurFenetrePopupActionMessage)
                    .addComponent(SpinHauteurFenetrePopupActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbLargeurFenetrePopupActionMessage)
                    .addComponent(SpinLargeurFenetrePopupActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                .addComponent(CheckMiseEnFormeActionMessage))
        );

        PanelDetailsAgentActionMessage.setBackground(new java.awt.Color(255, 225, 196));
        PanelDetailsAgentActionMessage.setBorder(javax.swing.BorderFactory.createTitledBorder("Plus de détails"));

        CbPositionVerticaleAgentActionMessage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "centre", "bas", "haut" }));
        CbPositionVerticaleAgentActionMessage.setMinimumSize(new java.awt.Dimension(0, 22));
        CbPositionVerticaleAgentActionMessage.setPreferredSize(new java.awt.Dimension(70, 22));

        LbPositionHorizontaleAgentActionMessage.setText("horizontalement");

        RbPositionEcranAgentActionMessage.setBackground(new java.awt.Color(255, 225, 196));
        ActionMessage2.add(RbPositionEcranAgentActionMessage);
        RbPositionEcranAgentActionMessage.setSelected(true);
        RbPositionEcranAgentActionMessage.setText("Par rapport à l'écran");
        RbPositionEcranAgentActionMessage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RbPositionEcranAgentActionMessageItemStateChanged(evt);
            }
        });
        RbPositionEcranAgentActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbPositionEcranAgentActionMessageActionPerformed(evt);
            }
        });

        LbPositionVerticaleAgentActionMessage.setText("verticalement");

        CbPositionHorizontaleAgentActionMessage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "centre", "gauche", "droite" }));
        CbPositionHorizontaleAgentActionMessage.setMinimumSize(new java.awt.Dimension(0, 22));
        CbPositionHorizontaleAgentActionMessage.setPreferredSize(new java.awt.Dimension(70, 22));

        RbPositionCoordonneesAgentActionMessage.setBackground(new java.awt.Color(255, 225, 196));
        ActionMessage2.add(RbPositionCoordonneesAgentActionMessage);
        RbPositionCoordonneesAgentActionMessage.setText("Coordonnées");
        RbPositionCoordonneesAgentActionMessage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RbPositionCoordonneesAgentActionMessageItemStateChanged(evt);
            }
        });
        RbPositionCoordonneesAgentActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbPositionCoordonneesAgentActionMessageActionPerformed(evt);
            }
        });

        LbXAgentActionMessage.setText("horizontalement");

        LbPositionAgentActionMessage.setText("Position");

        BtRbPositionSourisAgentActionMessage.setBackground(new java.awt.Color(255, 225, 196));
        ActionMessage2.add(BtRbPositionSourisAgentActionMessage);
        BtRbPositionSourisAgentActionMessage.setText("A l'emplacement de la souris");
        BtRbPositionSourisAgentActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRbPositionSourisAgentActionMessageActionPerformed(evt);
            }
        });

        SpinYAgentActionMessage.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        SpinYAgentActionMessage.setToolTipText("En pixels par rapport au coin haut gauche de l'écran");
        SpinYAgentActionMessage.setEnabled(false);
        SpinYAgentActionMessage.setMinimumSize(new java.awt.Dimension(0, 22));
        SpinYAgentActionMessage.setPreferredSize(new java.awt.Dimension(70, 22));

        SpinXAgentActionMessage.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        SpinXAgentActionMessage.setToolTipText("En pixels par rapport au coin haut gauche de l'écran");
        SpinXAgentActionMessage.setEnabled(false);
        SpinXAgentActionMessage.setMinimumSize(new java.awt.Dimension(0, 22));
        SpinXAgentActionMessage.setPreferredSize(new java.awt.Dimension(70, 22));

        LbYAgentActionMessage.setText("verticalement");

        BtModifierAgentActionMessage.setBackground(new java.awt.Color(255, 225, 196));
        BtModifierAgentActionMessage.setMnemonic('t');
        BtModifierAgentActionMessage.setText("Modifier");
        BtModifierAgentActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierAgentActionMessageActionPerformed(evt);
            }
        });

        LbAgentActionMessage.setText("Personnage");

        javax.swing.GroupLayout PanelDetailsAgentActionMessageLayout = new javax.swing.GroupLayout(PanelDetailsAgentActionMessage);
        PanelDetailsAgentActionMessage.setLayout(PanelDetailsAgentActionMessageLayout);
        PanelDetailsAgentActionMessageLayout.setHorizontalGroup(
            PanelDetailsAgentActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDetailsAgentActionMessageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDetailsAgentActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDetailsAgentActionMessageLayout.createSequentialGroup()
                        .addComponent(LbPositionAgentActionMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelDetailsAgentActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelDetailsAgentActionMessageLayout.createSequentialGroup()
                                .addGroup(PanelDetailsAgentActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RbPositionEcranAgentActionMessage)
                                    .addComponent(RbPositionCoordonneesAgentActionMessage))
                                .addGap(18, 18, 18)
                                .addGroup(PanelDetailsAgentActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LbPositionHorizontaleAgentActionMessage)
                                    .addComponent(LbXAgentActionMessage))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelDetailsAgentActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SpinXAgentActionMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CbPositionHorizontaleAgentActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelDetailsAgentActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelDetailsAgentActionMessageLayout.createSequentialGroup()
                                        .addComponent(LbYAgentActionMessage)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SpinYAgentActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelDetailsAgentActionMessageLayout.createSequentialGroup()
                                        .addComponent(LbPositionVerticaleAgentActionMessage)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CbPositionVerticaleAgentActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(BtRbPositionSourisAgentActionMessage)))
                    .addGroup(PanelDetailsAgentActionMessageLayout.createSequentialGroup()
                        .addComponent(LbAgentActionMessage)
                        .addGap(18, 18, 18)
                        .addComponent(BtModifierAgentActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelDetailsAgentActionMessageLayout.setVerticalGroup(
            PanelDetailsAgentActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDetailsAgentActionMessageLayout.createSequentialGroup()
                .addGroup(PanelDetailsAgentActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbPositionAgentActionMessage)
                    .addComponent(BtRbPositionSourisAgentActionMessage))
                .addGap(0, 0, 0)
                .addGroup(PanelDetailsAgentActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbPositionEcranAgentActionMessage)
                    .addComponent(LbPositionHorizontaleAgentActionMessage)
                    .addComponent(CbPositionHorizontaleAgentActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbPositionVerticaleAgentActionMessage)
                    .addComponent(CbPositionVerticaleAgentActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(PanelDetailsAgentActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbPositionCoordonneesAgentActionMessage)
                    .addComponent(LbXAgentActionMessage)
                    .addComponent(SpinXAgentActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbYAgentActionMessage)
                    .addComponent(SpinYAgentActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDetailsAgentActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbAgentActionMessage)
                    .addComponent(BtModifierAgentActionMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        PanelPersoContenu1ActionMessage.setBackground(new java.awt.Color(255, 225, 196));
        PanelPersoContenu1ActionMessage.setEnabled(false);
        PanelPersoContenu1ActionMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelPersoContenu1ActionMessageMouseEntered(evt);
            }
        });

        CbPersoActionMessage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbPersoActionMessage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbPersoActionMessageItemStateChanged(evt);
            }
        });

        BtInclureActionMessage.setText("Inclure");
        BtInclureActionMessage.setEnabled(false);
        BtInclureActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtInclureActionMessageActionPerformed(evt);
            }
        });

        LbPersoActionMessage.setText("Personnaliser avec");

        PanelCouleurFondActionMessage.setBackground(new java.awt.Color(255, 225, 196));

        LbCouleurFondActionMessage.setText("Couleur de fond");

        BtCouleurFondActionMessage.setText("...");
        BtCouleurFondActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCouleurFondActionMessageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCouleurFondActionMessageLayout = new javax.swing.GroupLayout(PanelCouleurFondActionMessage);
        PanelCouleurFondActionMessage.setLayout(PanelCouleurFondActionMessageLayout);
        PanelCouleurFondActionMessageLayout.setHorizontalGroup(
            PanelCouleurFondActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCouleurFondActionMessageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbCouleurFondActionMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtCouleurFondActionMessage)
                .addGap(23, 23, 23))
        );
        PanelCouleurFondActionMessageLayout.setVerticalGroup(
            PanelCouleurFondActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCouleurFondActionMessageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelCouleurFondActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbCouleurFondActionMessage)
                    .addComponent(BtCouleurFondActionMessage))
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelPersoContenu1ActionMessageLayout = new javax.swing.GroupLayout(PanelPersoContenu1ActionMessage);
        PanelPersoContenu1ActionMessage.setLayout(PanelPersoContenu1ActionMessageLayout);
        PanelPersoContenu1ActionMessageLayout.setHorizontalGroup(
            PanelPersoContenu1ActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPersoContenu1ActionMessageLayout.createSequentialGroup()
                .addComponent(PanelCouleurFondActionMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(LbPersoActionMessage)
                .addGap(18, 18, 18)
                .addComponent(CbPersoActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtInclureActionMessage))
        );
        PanelPersoContenu1ActionMessageLayout.setVerticalGroup(
            PanelPersoContenu1ActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPersoContenu1ActionMessageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelPersoContenu1ActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelCouleurFondActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelPersoContenu1ActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LbPersoActionMessage)
                        .addComponent(CbPersoActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtInclureActionMessage))))
        );

        CbPersoDifferentActionMessage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbPersoDifferentActionMessage.setEnabled(false);
        CbPersoDifferentActionMessage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbPersoDifferentActionMessageItemStateChanged(evt);
            }
        });
        CbPersoDifferentActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPersoDifferentActionMessageActionPerformed(evt);
            }
        });

        BtInclureDifferentActionMessage.setText("Inclure");
        BtInclureDifferentActionMessage.setEnabled(false);
        BtInclureDifferentActionMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtInclureDifferentActionMessageActionPerformed(evt);
            }
        });

        LbPersoDifferentActionMessage.setText("Personnaliser avec");

        PanelContenuActionMessage.setBackground(new java.awt.Color(255, 225, 196));
        PanelContenuActionMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelContenuActionMessageMouseEntered(evt);
            }
        });

        LbContenuActionMessage.setText("Contenu du message");

        javax.swing.GroupLayout PanelContenuActionMessageLayout = new javax.swing.GroupLayout(PanelContenuActionMessage);
        PanelContenuActionMessage.setLayout(PanelContenuActionMessageLayout);
        PanelContenuActionMessageLayout.setHorizontalGroup(
            PanelContenuActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
            .addGroup(PanelContenuActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelContenuActionMessageLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LbContenuActionMessage)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PanelContenuActionMessageLayout.setVerticalGroup(
            PanelContenuActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(PanelContenuActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelContenuActionMessageLayout.createSequentialGroup()
                    .addGap(0, 17, Short.MAX_VALUE)
                    .addComponent(LbContenuActionMessage)
                    .addGap(0, 17, Short.MAX_VALUE)))
        );

        LbModeActionMessage.setText("Mode de transmission");

        javax.swing.GroupLayout PanelCreationActionMessageLayout = new javax.swing.GroupLayout(PanelCreationActionMessage);
        PanelCreationActionMessage.setLayout(PanelCreationActionMessageLayout);
        PanelCreationActionMessageLayout.setHorizontalGroup(
            PanelCreationActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreationActionMessageLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(PanelCreationActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelDetailsAgentActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelCreationActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PanelDetailsPopupActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PanelCreationActionMessageLayout.createSequentialGroup()
                            .addComponent(LbTypeActionMessage)
                            .addGap(26, 26, 26)
                            .addComponent(CheckEcritActionMessage)
                            .addGap(18, 18, 18)
                            .addComponent(CheckOralActionMessage))
                        .addComponent(CheckDifferentActionMessage)
                        .addGroup(PanelCreationActionMessageLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(LbModeActionMessage)
                            .addGap(29, 29, 29)
                            .addComponent(CbModeActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BtAfficherDetailsActionMessage))
                        .addComponent(ScrollDifferentActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PanelCreationActionMessageLayout.createSequentialGroup()
                            .addGap(96, 96, 96)
                            .addComponent(BtValiderActionMessage)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BtApercuActionMessage)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BtAnnulerActionMessage))
                        .addGroup(PanelCreationActionMessageLayout.createSequentialGroup()
                            .addComponent(LbPersoDifferentActionMessage)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(CbPersoDifferentActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(BtInclureDifferentActionMessage))
                        .addComponent(PanelContenuActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PanelPersoContenu1ActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        PanelCreationActionMessageLayout.setVerticalGroup(
            PanelCreationActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationActionMessageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelContenuActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPersoContenu1ActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCreationActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTypeActionMessage)
                    .addComponent(CheckEcritActionMessage)
                    .addComponent(CheckOralActionMessage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckDifferentActionMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollDifferentActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreationActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbPersoDifferentActionMessage)
                    .addComponent(CbPersoDifferentActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtInclureDifferentActionMessage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreationActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CbModeActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtAfficherDetailsActionMessage))
                    .addComponent(LbModeActionMessage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDetailsPopupActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDetailsAgentActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreationActionMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtValiderActionMessage)
                    .addComponent(BtApercuActionMessage)
                    .addComponent(BtAnnulerActionMessage))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelCreationActionRessource.setBackground(new java.awt.Color(255, 225, 196));

        BtAnnulerActionRessource.setText("Annuler");
        BtAnnulerActionRessource.setToolTipText("Retour à la définition des règles d'assistance");
        BtAnnulerActionRessource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerActionRessourceActionPerformed(evt);
            }
        });

        BtApercuActionRessource.setText("Apercu");
        BtApercuActionRessource.setToolTipText("Retour à la définition des règles d'assistance");
        BtApercuActionRessource.setEnabled(false);

        BtValiderActionRessource.setText("Valider");
        BtValiderActionRessource.setToolTipText("Valider l'action et revenir à la définition des règles d'assistance");
        BtValiderActionRessource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderActionRessourceActionPerformed(evt);
            }
        });

        LbTypeActionRessource.setText("Type");

        CbTypeActionRessource.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbTypeActionRessource.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbTypeActionRessourceItemStateChanged(evt);
            }
        });

        LbCheminActionRessource.setText("Chemin");

        TxtCheminActionRessource.setText("jTextField1");

        BtCheminActionRessource.setText("Parcourir...");
        BtCheminActionRessource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCheminActionRessourceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCreationActionRessourceLayout = new javax.swing.GroupLayout(PanelCreationActionRessource);
        PanelCreationActionRessource.setLayout(PanelCreationActionRessourceLayout);
        PanelCreationActionRessourceLayout.setHorizontalGroup(
            PanelCreationActionRessourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationActionRessourceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationActionRessourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationActionRessourceLayout.createSequentialGroup()
                        .addComponent(LbTypeActionRessource)
                        .addGap(39, 39, 39)
                        .addComponent(CbTypeActionRessource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LbCheminActionRessource)
                    .addComponent(TxtCheminActionRessource, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCheminActionRessource)
                    .addGroup(PanelCreationActionRessourceLayout.createSequentialGroup()
                        .addComponent(BtValiderActionRessource)
                        .addGap(18, 18, 18)
                        .addComponent(BtApercuActionRessource)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtAnnulerActionRessource)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelCreationActionRessourceLayout.setVerticalGroup(
            PanelCreationActionRessourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreationActionRessourceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationActionRessourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTypeActionRessource)
                    .addComponent(CbTypeActionRessource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LbCheminActionRessource)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtCheminActionRessource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtCheminActionRessource)
                .addGap(72, 72, 72)
                .addGroup(PanelCreationActionRessourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtValiderActionRessource)
                    .addComponent(BtApercuActionRessource)
                    .addComponent(BtAnnulerActionRessource))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        PanelCreationActionAjoutComposant.setBackground(new java.awt.Color(255, 225, 196));
        PanelCreationActionAjoutComposant.setPreferredSize(new java.awt.Dimension(340, 594));

        ArbreActionAjoutComposant.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                ArbreActionAjoutComposantValueChanged(evt);
            }
        });
        ScrollArbreActionAjoutComposant.setViewportView(ArbreActionAjoutComposant);

        LbIdActionAjoutComposant.setText("Composant concerné");

        TxtIdActionAjoutComposant.setEditable(false);
        TxtIdActionAjoutComposant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdActionAjoutComposantActionPerformed(evt);
            }
        });

        BtAnnulerActionAjoutComposant.setText("Annuler");
        BtAnnulerActionAjoutComposant.setToolTipText("Retour à la définition des règles d'assistance");
        BtAnnulerActionAjoutComposant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerActionAjoutComposantActionPerformed(evt);
            }
        });

        BtValiderActionAjoutComposant.setText("Valider");
        BtValiderActionAjoutComposant.setToolTipText("Valider l'action et revenir à la définition des règles d'assistance");
        BtValiderActionAjoutComposant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderActionAjoutComposantActionPerformed(evt);
            }
        });

        BtApercuActionAjoutComposant.setText("Aperçu");
        BtApercuActionAjoutComposant.setToolTipText("Voir un aperçu de la mise en valeur définie sur des composants exemples");
        BtApercuActionAjoutComposant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtApercuActionAjoutComposantActionPerformed(evt);
            }
        });

        BtModifierDescriptionInterfaceActionAjoutComposant.setText("...");
        BtModifierDescriptionInterfaceActionAjoutComposant.setToolTipText("Modifier la description de l'interface");
        BtModifierDescriptionInterfaceActionAjoutComposant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierDescriptionInterfaceActionAjoutComposantActionPerformed(evt);
            }
        });

        BtAfficherDescriptionInterfaceActionAjoutComposant.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        BtAfficherDescriptionInterfaceActionAjoutComposant.setText("+");
        BtAfficherDescriptionInterfaceActionAjoutComposant.setToolTipText("Afficher la totalité de la description de l'interface");
        BtAfficherDescriptionInterfaceActionAjoutComposant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAfficherDescriptionInterfaceActionAjoutComposantActionPerformed(evt);
            }
        });

        PanelDetailsActionAjoutComposant.setBackground(new java.awt.Color(255, 225, 196));
        PanelDetailsActionAjoutComposant.setBorder(javax.swing.BorderFactory.createTitledBorder("Plus de détails"));

        LbDirectionActionAjoutComposant.setText("Direction");

        CbDirectionActionAjoutComposant.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        LbLargeurActionAjoutComposant.setText("Largeur");

        LbHauteurActionAjoutComposant.setText("Hauteur");

        SpinLargeurActionAjoutComposant.setModel(new javax.swing.SpinnerNumberModel(100, 10, 500, 1));

        SpinHauteurActionAjoutComposant.setModel(new javax.swing.SpinnerNumberModel(24, 10, 240, 1));

        PanelPoliceActionAjoutComposant.setBackground(new java.awt.Color(255, 225, 196));

        LbPoliceActionAjoutComposant.setText("Police");

        BtPoliceActionAjoutComposant.setBackground(new java.awt.Color(255, 255, 255));
        BtPoliceActionAjoutComposant.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        BtPoliceActionAjoutComposant.setText("abc");
        BtPoliceActionAjoutComposant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPoliceActionAjoutComposantActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPoliceActionAjoutComposantLayout = new javax.swing.GroupLayout(PanelPoliceActionAjoutComposant);
        PanelPoliceActionAjoutComposant.setLayout(PanelPoliceActionAjoutComposantLayout);
        PanelPoliceActionAjoutComposantLayout.setHorizontalGroup(
            PanelPoliceActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPoliceActionAjoutComposantLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbPoliceActionAjoutComposant)
                .addGap(45, 45, 45)
                .addComponent(BtPoliceActionAjoutComposant)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPoliceActionAjoutComposantLayout.setVerticalGroup(
            PanelPoliceActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPoliceActionAjoutComposantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPoliceActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbPoliceActionAjoutComposant)
                    .addComponent(BtPoliceActionAjoutComposant))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelDetailsActionAjoutComposantLayout = new javax.swing.GroupLayout(PanelDetailsActionAjoutComposant);
        PanelDetailsActionAjoutComposant.setLayout(PanelDetailsActionAjoutComposantLayout);
        PanelDetailsActionAjoutComposantLayout.setHorizontalGroup(
            PanelDetailsActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDetailsActionAjoutComposantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDetailsActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDetailsActionAjoutComposantLayout.createSequentialGroup()
                        .addComponent(LbDirectionActionAjoutComposant)
                        .addGap(18, 18, 18)
                        .addGroup(PanelDetailsActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelDetailsActionAjoutComposantLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(LbLargeurActionAjoutComposant)
                                .addGap(48, 48, 48)
                                .addComponent(SpinLargeurActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(LbHauteurActionAjoutComposant)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SpinHauteurActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelDetailsActionAjoutComposantLayout.createSequentialGroup()
                                .addComponent(CbDirectionActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(35, 35, 35))
                    .addGroup(PanelDetailsActionAjoutComposantLayout.createSequentialGroup()
                        .addComponent(PanelPoliceActionAjoutComposant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        PanelDetailsActionAjoutComposantLayout.setVerticalGroup(
            PanelDetailsActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDetailsActionAjoutComposantLayout.createSequentialGroup()
                .addGroup(PanelDetailsActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbDirectionActionAjoutComposant)
                    .addComponent(CbDirectionActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelDetailsActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbLargeurActionAjoutComposant)
                    .addComponent(LbHauteurActionAjoutComposant)
                    .addComponent(SpinLargeurActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpinHauteurActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPoliceActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        LbTypeActionAjoutComposant.setText("Type de composant à ajouter");

        CbTypeActionAjoutComposant.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbTypeActionAjoutComposant.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbTypeActionAjoutComposantItemStateChanged(evt);
            }
        });

        BtAfficherDetailsActionAjoutComposant.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        BtAfficherDetailsActionAjoutComposant.setText("+");
        BtAfficherDetailsActionAjoutComposant.setToolTipText("Afficher plus de détails");
        BtAfficherDetailsActionAjoutComposant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAfficherDetailsActionAjoutComposantActionPerformed(evt);
            }
        });

        PanelBoutonActionAjoutComposant.setBackground(new java.awt.Color(255, 225, 196));

        TxtTexteBoutonActionAjoutComposant.setText("Aide");

        CheckTexteBoutonActionAjoutComposant.setBackground(new java.awt.Color(255, 225, 196));
        CheckTexteBoutonActionAjoutComposant.setText("Texte du bouton");
        CheckTexteBoutonActionAjoutComposant.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckTexteBoutonActionAjoutComposantItemStateChanged(evt);
            }
        });
        CheckTexteBoutonActionAjoutComposant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckTexteBoutonActionAjoutComposantActionPerformed(evt);
            }
        });

        CheckIconeBoutonActionAjoutComposant.setBackground(new java.awt.Color(255, 225, 196));
        CheckIconeBoutonActionAjoutComposant.setText("Icone du bouton");
        CheckIconeBoutonActionAjoutComposant.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckIconeBoutonActionAjoutComposantItemStateChanged(evt);
            }
        });

        CheckInfoBulleBoutonActionAjoutComposant.setBackground(new java.awt.Color(255, 225, 196));
        CheckInfoBulleBoutonActionAjoutComposant.setText("Infobulle du bouton");
        CheckInfoBulleBoutonActionAjoutComposant.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckInfoBulleBoutonActionAjoutComposantItemStateChanged(evt);
            }
        });

        TxtInfoBulleBoutonActionAjoutComposant.setText("Aide");

        BtIconeBoutonActionAjoutComposant.setBackground(new java.awt.Color(255, 225, 196));
        BtIconeBoutonActionAjoutComposant.setMnemonic('t');
        BtIconeBoutonActionAjoutComposant.setText("Modifier");
        BtIconeBoutonActionAjoutComposant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIconeBoutonActionAjoutComposantActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBoutonActionAjoutComposantLayout = new javax.swing.GroupLayout(PanelBoutonActionAjoutComposant);
        PanelBoutonActionAjoutComposant.setLayout(PanelBoutonActionAjoutComposantLayout);
        PanelBoutonActionAjoutComposantLayout.setHorizontalGroup(
            PanelBoutonActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBoutonActionAjoutComposantLayout.createSequentialGroup()
                .addGroup(PanelBoutonActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtTexteBoutonActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckTexteBoutonActionAjoutComposant)
                    .addGroup(PanelBoutonActionAjoutComposantLayout.createSequentialGroup()
                        .addComponent(CheckIconeBoutonActionAjoutComposant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtIconeBoutonActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CheckInfoBulleBoutonActionAjoutComposant)
                    .addComponent(TxtInfoBulleBoutonActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );
        PanelBoutonActionAjoutComposantLayout.setVerticalGroup(
            PanelBoutonActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBoutonActionAjoutComposantLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CheckTexteBoutonActionAjoutComposant)
                .addGroup(PanelBoutonActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBoutonActionAjoutComposantLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(TxtTexteBoutonActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CheckIconeBoutonActionAjoutComposant)
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBoutonActionAjoutComposantLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtIconeBoutonActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckInfoBulleBoutonActionAjoutComposant)
                .addGap(6, 6, 6)
                .addComponent(TxtInfoBulleBoutonActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelLabelActionAjoutComposant.setBackground(new java.awt.Color(255, 225, 196));

        TxtTexteLabelActionAjoutComposant.setText("Aide");

        CheckIconeLabelActionAjoutComposant.setBackground(new java.awt.Color(255, 225, 196));
        CheckIconeLabelActionAjoutComposant.setText("Icone du texte");
        CheckIconeLabelActionAjoutComposant.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckIconeLabelActionAjoutComposantItemStateChanged(evt);
            }
        });

        BtIconeLabelActionAjoutComposant.setBackground(new java.awt.Color(255, 225, 196));
        BtIconeLabelActionAjoutComposant.setMnemonic('t');
        BtIconeLabelActionAjoutComposant.setText("Modifier");
        BtIconeLabelActionAjoutComposant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIconeLabelActionAjoutComposantActionPerformed(evt);
            }
        });

        LbTexteLabelActionAjoutComposant.setText("Texte");

        javax.swing.GroupLayout PanelLabelActionAjoutComposantLayout = new javax.swing.GroupLayout(PanelLabelActionAjoutComposant);
        PanelLabelActionAjoutComposant.setLayout(PanelLabelActionAjoutComposantLayout);
        PanelLabelActionAjoutComposantLayout.setHorizontalGroup(
            PanelLabelActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLabelActionAjoutComposantLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(PanelLabelActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbTexteLabelActionAjoutComposant)
                    .addComponent(TxtTexteLabelActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelLabelActionAjoutComposantLayout.createSequentialGroup()
                        .addComponent(CheckIconeLabelActionAjoutComposant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtIconeLabelActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        PanelLabelActionAjoutComposantLayout.setVerticalGroup(
            PanelLabelActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLabelActionAjoutComposantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLabelActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLabelActionAjoutComposantLayout.createSequentialGroup()
                        .addComponent(LbTexteLabelActionAjoutComposant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtTexteLabelActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CheckIconeLabelActionAjoutComposant)
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLabelActionAjoutComposantLayout.createSequentialGroup()
                        .addGap(0, 67, Short.MAX_VALUE)
                        .addComponent(BtIconeLabelActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(109, 109, 109))
        );

        PanelImageActionAjoutComposant.setBackground(new java.awt.Color(255, 225, 196));

        LbIconeImageActionAjoutComposant.setText("Image");

        BtIconeImageActionAjoutComposant.setBackground(new java.awt.Color(255, 225, 196));
        BtIconeImageActionAjoutComposant.setMnemonic('t');
        BtIconeImageActionAjoutComposant.setText("Modifier");
        BtIconeImageActionAjoutComposant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIconeImageActionAjoutComposantActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelImageActionAjoutComposantLayout = new javax.swing.GroupLayout(PanelImageActionAjoutComposant);
        PanelImageActionAjoutComposant.setLayout(PanelImageActionAjoutComposantLayout);
        PanelImageActionAjoutComposantLayout.setHorizontalGroup(
            PanelImageActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelImageActionAjoutComposantLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(BtIconeImageActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(PanelImageActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelImageActionAjoutComposantLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(LbIconeImageActionAjoutComposant)
                    .addContainerGap(139, Short.MAX_VALUE)))
        );
        PanelImageActionAjoutComposantLayout.setVerticalGroup(
            PanelImageActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelImageActionAjoutComposantLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtIconeImageActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
            .addGroup(PanelImageActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelImageActionAjoutComposantLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(LbIconeImageActionAjoutComposant)
                    .addContainerGap(114, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout PanelCreationActionAjoutComposantLayout = new javax.swing.GroupLayout(PanelCreationActionAjoutComposant);
        PanelCreationActionAjoutComposant.setLayout(PanelCreationActionAjoutComposantLayout);
        PanelCreationActionAjoutComposantLayout.setHorizontalGroup(
            PanelCreationActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationActionAjoutComposantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationActionAjoutComposantLayout.createSequentialGroup()
                        .addComponent(LbIdActionAjoutComposant)
                        .addGap(29, 29, 29)
                        .addComponent(TxtIdActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCreationActionAjoutComposantLayout.createSequentialGroup()
                        .addComponent(ScrollArbreActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(PanelCreationActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtAfficherDescriptionInterfaceActionAjoutComposant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtModifierDescriptionInterfaceActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelCreationActionAjoutComposantLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(PanelCreationActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelCreationActionAjoutComposantLayout.createSequentialGroup()
                                .addComponent(LbTypeActionAjoutComposant)
                                .addGap(26, 26, 26)
                                .addComponent(CbTypeActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtAfficherDetailsActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelCreationActionAjoutComposantLayout.createSequentialGroup()
                                .addComponent(PanelBoutonActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PanelLabelActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PanelImageActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PanelDetailsActionAjoutComposant, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelCreationActionAjoutComposantLayout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(BtValiderActionAjoutComposant)
                                .addGap(18, 18, 18)
                                .addComponent(BtApercuActionAjoutComposant)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtAnnulerActionAjoutComposant)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelCreationActionAjoutComposantLayout.setVerticalGroup(
            PanelCreationActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationActionAjoutComposantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelCreationActionAjoutComposantLayout.createSequentialGroup()
                        .addGroup(PanelCreationActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbIdActionAjoutComposant)
                            .addComponent(TxtIdActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScrollArbreActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCreationActionAjoutComposantLayout.createSequentialGroup()
                        .addComponent(BtModifierDescriptionInterfaceActionAjoutComposant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtAfficherDescriptionInterfaceActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCreationActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTypeActionAjoutComposant)
                    .addComponent(CbTypeActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAfficherDetailsActionAjoutComposant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCreationActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelLabelActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelBoutonActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelImageActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelDetailsActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelCreationActionAjoutComposantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtValiderActionAjoutComposant)
                    .addComponent(BtApercuActionAjoutComposant)
                    .addComponent(BtAnnulerActionAjoutComposant))
                .addContainerGap())
        );

        PanelCreationActionPresentationGuidee.setBackground(new java.awt.Color(255, 225, 196));

        BtAnnulerActionPresentationGuidee.setText("Annuler");
        BtAnnulerActionPresentationGuidee.setToolTipText("Retour à la définition des règles d'assistance");
        BtAnnulerActionPresentationGuidee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerActionPresentationGuideeActionPerformed(evt);
            }
        });

        BtValiderActionPresentationGuidee.setText("Valider");
        BtValiderActionPresentationGuidee.setToolTipText("Valider l'action et revenir à la définition des règles d'assistance");
        BtValiderActionPresentationGuidee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderActionPresentationGuideeActionPerformed(evt);
            }
        });

        BtApercuActionPresentationGuidee.setText("Aperçu");
        BtApercuActionPresentationGuidee.setToolTipText("Voir un aperçu de la mise en valeur définie sur des composants exemples");
        BtApercuActionPresentationGuidee.setEnabled(false);
        BtApercuActionPresentationGuidee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtApercuActionPresentationGuideeActionPerformed(evt);
            }
        });

        LbEtapesActionPresentationGuidee.setText("Liste des étapes :");

        CbEtapesActionPresentationGuidee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbEtapesActionPresentationGuidee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbEtapesActionPresentationGuideeItemStateChanged(evt);
            }
        });

        BtCreerEtapesActionPresentationGuidee.setText("Creer");
        BtCreerEtapesActionPresentationGuidee.setToolTipText("Créer une nouvelle liste d'étapes");
        BtCreerEtapesActionPresentationGuidee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCreerEtapesActionPresentationGuideeActionPerformed(evt);
            }
        });

        ListeActionPresentationGuidee.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "item1", "item2", "item3" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        ListeActionPresentationGuidee.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ScrollListeActionPresentationGuidee.setViewportView(ListeActionPresentationGuidee);

        LbOptionActionPresentationGuidee.setText("Options générales :");

        CheckMessageAvantActionPresentationGuidee.setBackground(new java.awt.Color(255, 225, 196));
        CheckMessageAvantActionPresentationGuidee.setText("Afficher un message avant le début de la présentation guidée");
        CheckMessageAvantActionPresentationGuidee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckMessageAvantActionPresentationGuideeItemStateChanged(evt);
            }
        });
        CheckMessageAvantActionPresentationGuidee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckMessageAvantActionPresentationGuideeActionPerformed(evt);
            }
        });

        CheckMessageAvantAutorisationActionPresentationGuidee.setBackground(new java.awt.Color(255, 225, 196));
        CheckMessageAvantAutorisationActionPresentationGuidee.setText("Demander l'autorisation à l'utilisateur");

        CheckMessageApresActionPresentationGuidee.setBackground(new java.awt.Color(255, 225, 196));
        CheckMessageApresActionPresentationGuidee.setText("Afficher un message à la fin de la présentation guidée");
        CheckMessageApresActionPresentationGuidee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckMessageApresActionPresentationGuideeItemStateChanged(evt);
            }
        });

        LbOptionEtapesActionPresentationGuidee.setText("Options des étapes du pas à pas :");

        PanelAutomatiserActionPresentationGuidee.setBackground(new java.awt.Color(255, 225, 196));

        CheckExpliquerEtapeActionPresentationGuidee.setBackground(new java.awt.Color(255, 225, 196));
        CheckExpliquerEtapeActionPresentationGuidee.setText("Expliquer l'étape à venir");
        CheckExpliquerEtapeActionPresentationGuidee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckExpliquerEtapeActionPresentationGuideeItemStateChanged(evt);
            }
        });

        CheckExpliquerEtapeAutorisationActionPresentationGuidee.setBackground(new java.awt.Color(255, 225, 196));
        CheckExpliquerEtapeAutorisationActionPresentationGuidee.setText("Demander à l'utilisateur avant de passer à l'étape suivante");

        CheckTimerActionPresentationGuidee.setBackground(new java.awt.Color(255, 225, 196));
        CheckTimerActionPresentationGuidee.setText("Timer entre deux étapes :");
        CheckTimerActionPresentationGuidee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckTimerActionPresentationGuideeItemStateChanged(evt);
            }
        });
        CheckTimerActionPresentationGuidee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckTimerActionPresentationGuideeActionPerformed(evt);
            }
        });

        SpinTimerActionPresentationGuidee.setModel(new javax.swing.SpinnerNumberModel(10, 0, 600, 1));

        LbSecondesActionPresentationGuidee.setText("secondes");

        javax.swing.GroupLayout PanelAutomatiserActionPresentationGuideeLayout = new javax.swing.GroupLayout(PanelAutomatiserActionPresentationGuidee);
        PanelAutomatiserActionPresentationGuidee.setLayout(PanelAutomatiserActionPresentationGuideeLayout);
        PanelAutomatiserActionPresentationGuideeLayout.setHorizontalGroup(
            PanelAutomatiserActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAutomatiserActionPresentationGuideeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAutomatiserActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAutomatiserActionPresentationGuideeLayout.createSequentialGroup()
                        .addComponent(CheckExpliquerEtapeActionPresentationGuidee, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CheckExpliquerEtapeAutorisationActionPresentationGuidee, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelAutomatiserActionPresentationGuideeLayout.createSequentialGroup()
                        .addComponent(CheckTimerActionPresentationGuidee, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SpinTimerActionPresentationGuidee, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LbSecondesActionPresentationGuidee)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelAutomatiserActionPresentationGuideeLayout.setVerticalGroup(
            PanelAutomatiserActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAutomatiserActionPresentationGuideeLayout.createSequentialGroup()
                .addGroup(PanelAutomatiserActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckExpliquerEtapeActionPresentationGuidee)
                    .addComponent(CheckExpliquerEtapeAutorisationActionPresentationGuidee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelAutomatiserActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckTimerActionPresentationGuidee)
                    .addComponent(SpinTimerActionPresentationGuidee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbSecondesActionPresentationGuidee))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        BtModifierEtapesActionPresentationGuidee.setText("Modifier");
        BtModifierEtapesActionPresentationGuidee.setToolTipText("Modifier la liste des étapes");
        BtModifierEtapesActionPresentationGuidee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierEtapesActionPresentationGuideeActionPerformed(evt);
            }
        });

        BtPersonnaliserMessagesPresentationGuidee.setText("Modifier les messages");
        BtPersonnaliserMessagesPresentationGuidee.setToolTipText("Personnaliser le contenu et la mise en forme des messages du pas à pas");
        BtPersonnaliserMessagesPresentationGuidee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPersonnaliserMessagesPresentationGuideeActionPerformed(evt);
            }
        });

        BtMiseEnValeurPresentationGuidee.setText("Modifier la mise en valeur");
        BtMiseEnValeurPresentationGuidee.setToolTipText("Modifier la mise en valeur des composants");
        BtMiseEnValeurPresentationGuidee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtMiseEnValeurPresentationGuideeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCreationActionPresentationGuideeLayout = new javax.swing.GroupLayout(PanelCreationActionPresentationGuidee);
        PanelCreationActionPresentationGuidee.setLayout(PanelCreationActionPresentationGuideeLayout);
        PanelCreationActionPresentationGuideeLayout.setHorizontalGroup(
            PanelCreationActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationActionPresentationGuideeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationActionPresentationGuideeLayout.createSequentialGroup()
                        .addGroup(PanelCreationActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCreationActionPresentationGuideeLayout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(CbEtapesActionPresentationGuidee, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelCreationActionPresentationGuideeLayout.createSequentialGroup()
                                .addComponent(BtValiderActionPresentationGuidee)
                                .addGap(48, 48, 48)
                                .addComponent(BtApercuActionPresentationGuidee))
                            .addComponent(LbEtapesActionPresentationGuidee)
                            .addGroup(PanelCreationActionPresentationGuideeLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(PanelCreationActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CheckMessageApresActionPresentationGuidee, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CheckMessageAvantActionPresentationGuidee, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelCreationActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCreationActionPresentationGuideeLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(PanelCreationActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CheckMessageAvantAutorisationActionPresentationGuidee, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtAnnulerActionPresentationGuidee, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
                            .addGroup(PanelCreationActionPresentationGuideeLayout.createSequentialGroup()
                                .addComponent(BtModifierEtapesActionPresentationGuidee)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtCreerEtapesActionPresentationGuidee)
                                .addContainerGap())))
                    .addGroup(PanelCreationActionPresentationGuideeLayout.createSequentialGroup()
                        .addGroup(PanelCreationActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelAutomatiserActionPresentationGuidee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelCreationActionPresentationGuideeLayout.createSequentialGroup()
                                .addGroup(PanelCreationActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LbOptionActionPresentationGuidee)
                                    .addComponent(LbOptionEtapesActionPresentationGuidee))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(0, 26, 26))
                    .addGroup(PanelCreationActionPresentationGuideeLayout.createSequentialGroup()
                        .addComponent(BtPersonnaliserMessagesPresentationGuidee)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtMiseEnValeurPresentationGuidee)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(PanelCreationActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelCreationActionPresentationGuideeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ScrollListeActionPresentationGuidee, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        PanelCreationActionPresentationGuideeLayout.setVerticalGroup(
            PanelCreationActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationActionPresentationGuideeLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(PanelCreationActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbEtapesActionPresentationGuidee)
                    .addComponent(CbEtapesActionPresentationGuidee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtModifierEtapesActionPresentationGuidee)
                    .addComponent(BtCreerEtapesActionPresentationGuidee))
                .addGap(62, 62, 62)
                .addComponent(LbOptionActionPresentationGuidee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreationActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckMessageAvantActionPresentationGuidee)
                    .addComponent(CheckMessageAvantAutorisationActionPresentationGuidee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckMessageApresActionPresentationGuidee)
                .addGap(28, 28, 28)
                .addComponent(LbOptionEtapesActionPresentationGuidee)
                .addGap(31, 31, 31)
                .addComponent(PanelAutomatiserActionPresentationGuidee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(PanelCreationActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtPersonnaliserMessagesPresentationGuidee)
                    .addComponent(BtMiseEnValeurPresentationGuidee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCreationActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtValiderActionPresentationGuidee)
                    .addComponent(BtApercuActionPresentationGuidee)
                    .addComponent(BtAnnulerActionPresentationGuidee))
                .addContainerGap())
            .addGroup(PanelCreationActionPresentationGuideeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelCreationActionPresentationGuideeLayout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(ScrollListeActionPresentationGuidee, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(349, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout PanelCreationActionLayout = new javax.swing.GroupLayout(PanelCreationAction);
        PanelCreationAction.setLayout(PanelCreationActionLayout);
        PanelCreationActionLayout.setHorizontalGroup(
            PanelCreationActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationActionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationActionLayout.createSequentialGroup()
                        .addComponent(LbNomAction)
                        .addGap(29, 29, 29)
                        .addComponent(TxtNomAction, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCreationActionLayout.createSequentialGroup()
                        .addComponent(LbChoixTypeAction, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(CbChoixTypeAction, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelCreationActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(PanelCreationActionAgentAnime, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelCreationActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationActionLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(PanelCreationActionRessource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreationActionLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(PanelCreationActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)))
                .addComponent(PanelCreationActionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(PanelCreationActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelCreationActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(PanelCreationActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(PanelCreationActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreationActionLayout.createSequentialGroup()
                    .addContainerGap(799, Short.MAX_VALUE)
                    .addComponent(PanelCreationActionPresentationGuidee, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(501, 501, 501)))
        );
        PanelCreationActionLayout.setVerticalGroup(
            PanelCreationActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationActionLayout.createSequentialGroup()
                .addGroup(PanelCreationActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationActionLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(PanelCreationActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelCreationActionInterface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelCreationActionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelCreationActionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelCreationActionModifierProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCreationActionLayout.createSequentialGroup()
                        .addGroup(PanelCreationActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbNomAction)
                            .addComponent(TxtNomAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelCreationActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCreationActionLayout.createSequentialGroup()
                                .addComponent(PanelCreationActionRessource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PanelCreationActionAjoutComposant, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelCreationActionLayout.createSequentialGroup()
                                .addGroup(PanelCreationActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LbChoixTypeAction)
                                    .addComponent(CbChoixTypeAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addComponent(PanelCreationActionMiseEnValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelCreationActionLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(PanelCreationActionAgentAnime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCreationActionLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(PanelCreationActionPasaPas, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelCreationActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelCreationActionLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(PanelCreationActionPresentationGuidee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(97, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelCreationAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelCreationAction, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CbChoixTypeActionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbChoixTypeActionItemStateChanged
        if (CbChoixTypeAction.getItemCount() > 1) {
            PanelCreationActionModifierProfil.setVisible(false);
            PanelCreationActionAgentAnime.setVisible(false);
            PanelCreationActionMiseEnValeur.setVisible(false);
            PanelCreationActionPasaPas.setVisible(false);
            PanelCreationActionPresentationGuidee.setVisible(false);
            PanelCreationActionInterface.setVisible(false);
            PanelCreationActionMessage.setVisible(false);
            PanelCreationActionRessource.setVisible(false);
            PanelCreationActionAjoutComposant.setVisible(false);

            if (CbChoixTypeAction.getSelectedItem().equals(Main.CreationRegles.itemTypeActionModificationProfil)) {
                PanelCreationActionModifierProfil.setVisible(true);
            } else if (CbChoixTypeAction.getSelectedItem().equals(Main.CreationRegles.itemTypeActionPasAPas)) {
                PanelCreationActionPasaPas.setVisible(true);
            } else if (CbChoixTypeAction.getSelectedItem().equals(Main.CreationRegles.itemTypeActionActionInterface)) {
                PanelCreationActionInterface.setVisible(true);
                TxtComposantActionInterface.setText("");
            } else if (CbChoixTypeAction.getSelectedItem().equals(Main.CreationRegles.itemTypeActionMiseEnValeur)) {
                PanelCreationActionMiseEnValeur.setVisible(true);
                PanelActionMiseEnValeur.setVisible(true);
                PanelActionMasquage.setVisible(false);
            } else if (CbChoixTypeAction.getSelectedItem().equals(Main.CreationRegles.itemTypeActionMasquage)) {
                PanelCreationActionMiseEnValeur.setVisible(true);
                PanelActionMiseEnValeur.setVisible(false);
                PanelActionMasquage.setVisible(true);
                Main.CreationRegles.typeColorer = false;
                Main.CreationRegles.typeEntourer = false;
                Main.CreationRegles.typeSymbole = false;
                Main.CreationRegles.typeAgent = false;
            } else if (CbChoixTypeAction.getSelectedItem().equals(Main.CreationRegles.itemTypeActionAjoutComposant)) {
                PanelCreationActionAjoutComposant.setVisible(true);
            } else if (CbChoixTypeAction.getSelectedItem().equals(Main.CreationRegles.itemTypeActionMessage)) {
                PanelCreationActionMessage.setVisible(true);
            } else if (CbChoixTypeAction.getSelectedItem().equals(Main.CreationRegles.itemTypeActionRessource)) {
                PanelCreationActionRessource.setVisible(true);
            } 
            else if (CbChoixTypeAction.getSelectedItem().equals(Main.CreationRegles.itemTypeActionAnimation)) 
            {
                PanelCreationActionAgentAnime.setVisible(true);
            } 
            else if (CbChoixTypeAction.getSelectedItem().equals(Main.CreationRegles.itemTypeActionPresentationGuidee)) 
            {
                PanelCreationActionPresentationGuidee.setVisible(true);
            }
            else 
            {
                Main.CreationRegles.typeColorer = false;
                Main.CreationRegles.typeEntourer = false;
                Main.CreationRegles.typeSymbole = false;
                Main.CreationRegles.typeAgent = false;
            }
        }
    }//GEN-LAST:event_CbChoixTypeActionItemStateChanged

    private void CbChoixTypeActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbChoixTypeActionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbChoixTypeActionActionPerformed

    private void ArbreActionMiseEnValeurValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_ArbreActionMiseEnValeurValueChanged
        if (!ArbreActionMiseEnValeur.isSelectionEmpty()) {
            if (!ArbreActionMiseEnValeur.isRowSelected(0)) {
                String compo = ArbreActionMiseEnValeur.getSelectionPath().getLastPathComponent().toString();
                TxtIdActionMiseEnValeur.setText(Main.CreationRegles.noeudGetId(compo));
            }
        }
    }//GEN-LAST:event_ArbreActionMiseEnValeurValueChanged

    private void TxtIdActionMiseEnValeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdActionMiseEnValeurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdActionMiseEnValeurActionPerformed

    private void BtAnnulerActionMiseEnValeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerActionMiseEnValeurActionPerformed
        Main.CreationRegles.modifActionMiseEnValeur = false;
        annuler();
    }//GEN-LAST:event_BtAnnulerActionMiseEnValeurActionPerformed

    private void BtValiderActionMiseEnValeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderActionMiseEnValeurActionPerformed
        if (!TxtIdActionMiseEnValeur.getText().isEmpty()) {
            int ligne;
            if (Main.CreationRegles.modifActionMiseEnValeur) 
            {
                ligne = Main.CreationRegles.ligneModifAction;
            } 
            else 
            {
                Main.CreationRegles.idAction++;
                ligne = Main.CreationRegles.lesActions.size();
                Main.CreationRegles.modelAction.addRow(new Object[]{"", "", "", ""});
            }

            Element act, actvieux;
            act=creerActionMiseEnValeur();
            if (Main.CreationRegles.modifActionMiseEnValeur) 
            {
                ligne = Main.CreationRegles.ligneModifAction;
                String idact = Main.CreationRegles.TableActions.getValueAt(ligne, 0).toString();
                actvieux = Main.CreationRegles.elementParId(Main.CreationRegles.lesActions, idact);
                
                Main.CreationRegles.lesActions.add(Main.CreationRegles.lesActions.indexOf(actvieux), act);
                Main.CreationRegles.lesActions.remove(actvieux);
                Main.CreationRegles.modifActionMiseEnValeur = false;
            } 
            else 
            {
                Main.CreationRegles.lesActions.add(act);
            }
            
            Main.CreationRegles.modifActionMiseEnValeur = false;
            valider(act, ligne);
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Vous devez sélectionner un composant dans l'arbre", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtValiderActionMiseEnValeurActionPerformed

    private void BtApercuActionMiseEnValeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtApercuActionMiseEnValeurActionPerformed
        Element act = creerActionMiseEnValeur();
        Element composant = act.getChild(Main.CreationRegles.attributComposant);

        if (!PanelActionMasquage.isVisible()) {
            if (CbTypeActionMiseEnValeur.getSelectedItem().toString().isEmpty()) {
                composant.setAttribute(Main.CreationRegles.attributType, Main.CreationRegles.itemEntourer);
                composant.setAttribute(Main.CreationRegles.attributCouleur, BtEntourerCouleurActionMiseEnValeur.getBackground().toString());
                composant.setAttribute(Main.CreationRegles.attributArrondi, SpinArrondiActionMiseEnValeur.getValue().toString());
                composant.setAttribute(Main.CreationRegles.attributEloignement, SpinEloignementActionMiseEnValeur.getValue().toString());
                composant.setAttribute(Main.CreationRegles.attributEpaisseur, SpinEpaisseurActionMiseEnValeur.getValue().toString());
            } else {
                if (composant.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.itemEntourer)) {
                    if (composant.getAttribute(Main.CreationRegles.attributCouleur) == null || composant.getAttributeValue(Main.CreationRegles.attributCouleur).isEmpty()) {
                        composant.setAttribute(Main.CreationRegles.attributCouleur, BtEntourerCouleurActionMiseEnValeur.getBackground().toString());
                    }
                    if (composant.getAttribute(Main.CreationRegles.attributArrondi) == null || composant.getAttributeValue(Main.CreationRegles.attributArrondi).isEmpty()) {
                        composant.setAttribute(Main.CreationRegles.attributArrondi, SpinArrondiActionMiseEnValeur.getValue().toString());
                    }
                    if (composant.getAttribute(Main.CreationRegles.attributEloignement) == null || composant.getAttributeValue(Main.CreationRegles.attributEloignement).isEmpty()) {
                        composant.setAttribute(Main.CreationRegles.attributEloignement, SpinEloignementActionMiseEnValeur.getValue().toString());
                    }
                    if (composant.getAttribute(Main.CreationRegles.attributEpaisseur) == null || composant.getAttributeValue(Main.CreationRegles.attributEpaisseur).isEmpty()) {
                        composant.setAttribute(Main.CreationRegles.attributEpaisseur, SpinEpaisseurActionMiseEnValeur.getValue().toString());
                    }
                } else if (composant.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.itemColorer)) {
                    if (composant.getAttribute(Main.CreationRegles.attributCouleur) == null || composant.getAttributeValue(Main.CreationRegles.attributCouleur).isEmpty()) {
                        composant.setAttribute(Main.CreationRegles.attributCouleur, BtCouleurActionMiseEnValeur.getBackground().toString());
                    }
                    if (composant.getAttribute(Main.CreationRegles.attributTransparence) == null || composant.getAttributeValue(Main.CreationRegles.attributTransparence).isEmpty()) {
                        composant.setAttribute(Main.CreationRegles.attributTransparence, SpinTransparenceActionMiseEnValeur.getValue().toString());
                    }
                } else if (composant.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.itemSymbole)) {
                    if (composant.getAttribute(Main.CreationRegles.attributSymbole) == null || composant.getAttributeValue(Main.CreationRegles.attributSymbole).isEmpty()) {
                        composant.setAttribute(Main.CreationRegles.attributSymbole, "fleche1.png");
                    }
                    if (composant.getAttribute(Main.CreationRegles.attributDirection) == null || composant.getAttributeValue(Main.CreationRegles.attributDirection).isEmpty()) {
                        composant.setAttribute(Main.CreationRegles.attributDirection, CbDirectionActionMiseEnValeur.getSelectedItem().toString());
                    }
                } else if (composant.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.attributAgentAnime)) {
                    if (composant.getAttribute(Main.CreationRegles.attributPersonnage) == null || composant.getAttributeValue(Main.CreationRegles.attributPersonnage).isEmpty()) {
                        composant.setAttribute(Main.CreationRegles.attributPersonnage, "Merlin");
                    }
                    if (composant.getAttribute(Main.CreationRegles.attributDirection) == null || composant.getAttributeValue(Main.CreationRegles.attributDirection).isEmpty()) {
                        composant.setAttribute(Main.CreationRegles.attributDirection, CbDirectionActionMiseEnValeurAgent.getSelectedItem().toString());
                    }
                }
            }

            if (!CbTypeActionMiseEnValeur.getSelectedItem().toString().equals(Main.CreationRegles.itemAgentAnime)) {
                if (act.getAttributeValue(Main.CreationRegles.attributType).equals(Main.CreationRegles.itemTypeActionMasquage)) {
                    if (act.getChild(Main.CreationRegles.attributComposant).getAttributeValue(Main.CreationRegles.attributCouleur).equals("pere")) {
                        act.getChild(Main.CreationRegles.attributComposant).setAttribute(Main.CreationRegles.attributCouleur, new Color(240, 240, 240).toString());
                    }
                }
                Main.ApercuMiseEnValeur.apercuValorisateur(act);
            } 
            else 
            {
                Main.ApercuMiseEnValeur.apercuMsAgents(act);
            }
        } 
        else 
        {
            if (composant.getAttribute(Main.CreationRegles.attributCouleur) == null || composant.getAttributeValue(Main.CreationRegles.attributCouleur).isEmpty()) {
                composant.setAttribute(Main.CreationRegles.attributCouleur, BtCouleurActionMasquage.getBackground().toString());
            }

            if (CbTypeActionMasquage.getSelectedItem().toString().equals(Main.CreationRegles.itemEstomper) && (composant.getAttribute(Main.CreationRegles.attributTransparence) == null || composant.getAttributeValue(Main.CreationRegles.attributTransparence).isEmpty())) {
                composant.setAttribute(Main.CreationRegles.attributTransparence, SpinTransparenceActionMasquage.getValue().toString());
            }

            Main.ApercuMiseEnValeur.apercuValorisateur(act);
        }
    }//GEN-LAST:event_BtApercuActionMiseEnValeurActionPerformed

    private void BtModifierAgentActionMiseEnValeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierAgentActionMiseEnValeurActionPerformed
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir") + "/" + Main.Cste.cheminPersonnages);
        chooser.setApproveButtonText("Choisir"); //intitulé du bouton
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            ImageIcon im = new ImageIcon(chooser.getSelectedFile().getAbsolutePath());
            BtModifierAgentActionMiseEnValeur.setIcon(im);
            Main.CreationRegles.personnageMiseEnValeur = chooser.getSelectedFile().getName().substring(0, chooser.getSelectedFile().getName().length() - 4);
            this.repaint();
        }
    }//GEN-LAST:event_BtModifierAgentActionMiseEnValeurActionPerformed

    private void BtEntourerCouleurActionMiseEnValeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEntourerCouleurActionMiseEnValeurActionPerformed
        BtEntourerCouleurActionMiseEnValeur.setBackground(JColorChooser.showDialog(null, "Choisir une couleur", BtEntourerCouleurActionMiseEnValeur.getBackground()));
        this.repaint();
    }//GEN-LAST:event_BtEntourerCouleurActionMiseEnValeurActionPerformed

    private void SpinArrondiActionMiseEnValeurStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinArrondiActionMiseEnValeurStateChanged
        this.repaint();
    }//GEN-LAST:event_SpinArrondiActionMiseEnValeurStateChanged

    private void SpinArrondiActionMiseEnValeurPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_SpinArrondiActionMiseEnValeurPropertyChange

   }//GEN-LAST:event_SpinArrondiActionMiseEnValeurPropertyChange

    private void SpinEloignementActionMiseEnValeurStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinEloignementActionMiseEnValeurStateChanged
        this.repaint();
    }//GEN-LAST:event_SpinEloignementActionMiseEnValeurStateChanged

    private void SpinEpaisseurActionMiseEnValeurStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinEpaisseurActionMiseEnValeurStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_SpinEpaisseurActionMiseEnValeurStateChanged

    private void BtCouleurActionMiseEnValeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCouleurActionMiseEnValeurActionPerformed
        BtCouleurActionMiseEnValeur.setBackground(JColorChooser.showDialog(null, "Choisir une couleur", BtCouleurActionMiseEnValeur.getBackground()));
        this.repaint();
    }//GEN-LAST:event_BtCouleurActionMiseEnValeurActionPerformed

    private void CbTypeActionMiseEnValeurItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbTypeActionMiseEnValeurItemStateChanged
        if (CbTypeActionMiseEnValeur.getItemCount() > 0) {
            BtAfficherDetailsActionMiseEnValeur.setVisible(true);
            Main.CreationRegles.typeColorer = false;
            Main.CreationRegles.typeEntourer = false;
            Main.CreationRegles.typeSymbole = false;
            Main.CreationRegles.typeAgent = false;

            if (CbTypeActionMiseEnValeur.getSelectedItem().toString().equals(Main.CreationRegles.itemColorer)) {
                Main.CreationRegles.typeColorer = true;
            } else if (CbTypeActionMiseEnValeur.getSelectedItem().toString().equals(Main.CreationRegles.itemEntourer)) {
                Main.CreationRegles.typeEntourer = true;
            } else if (CbTypeActionMiseEnValeur.getSelectedItem().toString().equals(Main.CreationRegles.itemSymbole)) {
                Main.CreationRegles.typeSymbole = true;
            } else if (CbTypeActionMiseEnValeur.getSelectedItem().toString().equals(Main.CreationRegles.itemAgentAnime)) {
                Main.CreationRegles.typeAgent = true;
            } else {
                BtAfficherDetailsActionMiseEnValeur.setVisible(false);
            }

            PanelColorerActionMiseEnValeur.setVisible(Main.CreationRegles.typeColorer && Main.CreationRegles.afficherDetailsMiseEnValeur);
            PanelEntourerActionMiseEnValeur.setVisible(Main.CreationRegles.typeEntourer && Main.CreationRegles.afficherDetailsMiseEnValeur);
            PanelSymboleActionMiseEnValeur.setVisible(Main.CreationRegles.typeSymbole && Main.CreationRegles.afficherDetailsMiseEnValeur);
            PanelAgentActionMiseEnValeur.setVisible(Main.CreationRegles.typeAgent && Main.CreationRegles.afficherDetailsMiseEnValeur);
            this.repaint();
        }
    }//GEN-LAST:event_CbTypeActionMiseEnValeurItemStateChanged

    private void BtAfficherDetailsActionMiseEnValeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAfficherDetailsActionMiseEnValeurActionPerformed
        if (Main.CreationRegles.afficherDetailsMiseEnValeur) {
            BtAfficherDetailsActionMiseEnValeur.setToolTipText(Main.CreationRegles.tooltipAfficherDetailsMiseEnValeur);
            Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
            BtAfficherDetailsActionMiseEnValeur.setIcon(new ImageIcon(icon));
            BtAfficherDetailsActionMiseEnValeur.setText("");

            PanelEntourerActionMiseEnValeur.setVisible(false);
            PanelColorerActionMiseEnValeur.setVisible(false);
            PanelSymboleActionMiseEnValeur.setVisible(false);
            PanelAgentActionMiseEnValeur.setVisible(false);
        } else {
            BtAfficherDetailsActionMiseEnValeur.setToolTipText(Main.CreationRegles.tooltipMasquerDetailsMiseEnValeur);
            Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/moins.png"));
            BtAfficherDetailsActionMiseEnValeur.setIcon(new ImageIcon(icon));
            BtAfficherDetailsActionMiseEnValeur.setText("");

            if (CbTypeActionMiseEnValeur.getSelectedItem().equals(Main.CreationRegles.itemEntourer)) {
                PanelEntourerActionMiseEnValeur.setVisible(true);
            } else if (CbTypeActionMiseEnValeur.getSelectedItem().equals(Main.CreationRegles.itemColorer)) {
                PanelColorerActionMiseEnValeur.setVisible(true);
            } else if (CbTypeActionMiseEnValeur.getSelectedItem().equals(Main.CreationRegles.itemSymbole)) {
                PanelSymboleActionMiseEnValeur.setVisible(true);
            } else if (CbTypeActionMiseEnValeur.getSelectedItem().equals(Main.CreationRegles.itemAgentAnime)) {
                PanelAgentActionMiseEnValeur.setVisible(true);
            }

        }

        Main.CreationRegles.afficherDetailsMiseEnValeur = !Main.CreationRegles.afficherDetailsMiseEnValeur;
    }//GEN-LAST:event_BtAfficherDetailsActionMiseEnValeurActionPerformed

    private void BtModifierSymboleActionMiseEnValeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierSymboleActionMiseEnValeurActionPerformed
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir") + "/" + Main.Cste.cheminSymboles);
        chooser.setApproveButtonText("Choisir"); //intitulé du bouton
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            ImageIcon im = new ImageIcon(chooser.getSelectedFile().getAbsolutePath());
            BtModifierSymboleActionMiseEnValeur.setIcon(im);
            Main.CreationRegles.fichierSymbole = chooser.getSelectedFile().getName();
            this.repaint();
        }
    }//GEN-LAST:event_BtModifierSymboleActionMiseEnValeurActionPerformed

    private void CbTypeActionMasquageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbTypeActionMasquageItemStateChanged
        if (CbTypeActionMasquage.getSelectedIndex() >= 0) {
            PanelTransparenceActionMasquage.setVisible(CbTypeActionMasquage.getSelectedItem().equals(Main.CreationRegles.itemEstomper));
        }
    }//GEN-LAST:event_CbTypeActionMasquageItemStateChanged

    private void BtCouleurActionMasquageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCouleurActionMasquageActionPerformed
        BtCouleurActionMasquage.setBackground(JColorChooser.showDialog(null, "Choisir une couleur", BtCouleurActionMiseEnValeur.getBackground()));
        this.repaint();
    }//GEN-LAST:event_BtCouleurActionMasquageActionPerformed

    private void BtAfficherDetailsActionMasquageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAfficherDetailsActionMasquageActionPerformed
        if (Main.CreationRegles.afficherDetailsMasquage) {
            BtAfficherDetailsActionMasquage.setToolTipText("Afficher les détails du masquage");
            Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
            BtAfficherDetailsActionMasquage.setIcon(new ImageIcon(icon));
            BtAfficherDetailsActionMasquage.setText("");

            PanelEstomperActionMasquage.setVisible(false);
        } else {
            BtAfficherDetailsActionMasquage.setToolTipText("Masquer les détails du masquage");
            Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/moins.png"));
            BtAfficherDetailsActionMasquage.setIcon(new ImageIcon(icon));
            BtAfficherDetailsActionMasquage.setText("");

            PanelEstomperActionMasquage.setVisible(true);
        }

        Main.CreationRegles.afficherDetailsMasquage = !Main.CreationRegles.afficherDetailsMasquage;
    }//GEN-LAST:event_BtAfficherDetailsActionMasquageActionPerformed

    private void BtModifierDescriptionInterfaceActionMiseEnValeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierDescriptionInterfaceActionMiseEnValeurActionPerformed
        Main.ModificationInterface.chargerInterface();
        Main.ModificationInterface.setVisible(true);
    }//GEN-LAST:event_BtModifierDescriptionInterfaceActionMiseEnValeurActionPerformed

    private void BtAfficherDescriptionInterfaceActionMiseEnValeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAfficherDescriptionInterfaceActionMiseEnValeurActionPerformed
        Main.CreationRegles.affichageDescription(BtAfficherDescriptionInterfaceActionMiseEnValeur, ArbreActionMiseEnValeur);
    }//GEN-LAST:event_BtAfficherDescriptionInterfaceActionMiseEnValeurActionPerformed

    private void BtApercuActionAgentAnimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtApercuActionAgentAnimeActionPerformed
        Element act = creerActionAgentAnime();
        if (act.getAttributeValue(Main.CreationRegles.attributPersonnage).isEmpty()) {
            act.setAttribute(Main.CreationRegles.attributPersonnage, "Merlin");
        }
        XMLFonctions.creerXML(act);
        XMLFonctions.enregistre("Action.xml", "");
        try {
            Runtime.getRuntime().exec("java -jar " + Main.Cste.jarAnimationAgent);
        } catch (IOException ex) {
            Logger.getLogger(ApercuMiseEnValeur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtApercuActionAgentAnimeActionPerformed

    private void BtValiderActionAgentAnimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderActionAgentAnimeActionPerformed
        Main.CreationRegles.idAction++;
        int ligne;
        Element act = creerActionAgentAnime();
        if (Main.CreationRegles.modifActionAgentAnime) {
            ligne = Main.CreationRegles.ligneModifAction;
        } else {
            ligne = Main.CreationRegles.lesActions.size();
            Main.CreationRegles.modelAction.addRow(new Object[]{"", "", "", ""});
        }

        String descr = "";
        if (!act.getAttributeValue(Main.CreationRegles.attributPersonnage).isEmpty()) {
            descr = act.getAttributeValue(Main.CreationRegles.attributPersonnage) + " : ";
        }
        for (int i = 0; i < act.getChildren().size(); i++) {
            Element sousact = (Element) act.getChildren().get(i);
            descr = descr + sousact.getAttributeValue(Main.CreationRegles.attributType) + ", ";
        }
        descr = descr.substring(0, descr.length() - 2);
        Main.CreationRegles.TableActions.setValueAt(descr, ligne, 2);

        if (Main.CreationRegles.modifActionAgentAnime) {
            Element a = Main.CreationRegles.elementParId(Main.CreationRegles.lesActions, TxtNomAction.getText());
            Main.CreationRegles.lesActions.add(Main.CreationRegles.lesActions.indexOf(a), act);
            Main.CreationRegles.lesActions.remove(a);
            Main.CreationRegles.modifActionAgentAnime = false;
        } else {
            Main.CreationRegles.lesActions.add(act);
        }
        reinitialiserFenetre();
        TxtNomAction.setText("A" + Main.CreationRegles.idAction);
        valider(act, ligne);
    }//GEN-LAST:event_BtValiderActionAgentAnimeActionPerformed

    private void BtAnnulerActionAgentAnimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerActionAgentAnimeActionPerformed
        reinitialiserFenetre();
        Main.CreationRegles.modifActionAgentAnime = false;
        this.setVisible(false);
    }//GEN-LAST:event_BtAnnulerActionAgentAnimeActionPerformed

    private void CbPersoActionAgentAnimeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbPersoActionAgentAnimeItemStateChanged
        String nomPersonnage = CbPersoActionAgentAnime.getSelectedItem().toString();
        if (" ".equals(nomPersonnage)) {
            LbImagePersoActionAgentAnime.setIcon(null);
        } else {
            ImageIcon icon = new ImageIcon(this.getClass().getResource("/imagesAgentsAnimes/" + nomPersonnage + ".gif"));
            Image img = icon.getImage();
            Image newimg;
            if (icon.getIconWidth() >= icon.getIconHeight()) {
                newimg = img.getScaledInstance(PanelPersoActionAgentAnime.getWidth(), -1, java.awt.Image.SCALE_SMOOTH);
            } else {
                newimg = img.getScaledInstance(-1, PanelPersoActionAgentAnime.getHeight(), java.awt.Image.SCALE_SMOOTH);
            }
            ImageIcon newIcon = new ImageIcon(newimg);
            LbImagePersoActionAgentAnime.setIcon(newIcon);
        }

        viderPanelSousAction();
        hidePanelSousAction();
        SousAction sa;
        Animation a;
        Iterator<SousAction> it = listeSousActions.getListe().iterator();
        while (it.hasNext()) {
            sa = (SousAction) it.next();
            if (sa.getType().equals(Main.CreationRegles.attributAnimation)) {
                a = (Animation) sa;
                if (verifierSousActionAnimations(a.getIdentifiant())) {
                    it.remove();
                    initialiserListe();
                }
            }
        }
    }//GEN-LAST:event_CbPersoActionAgentAnimeItemStateChanged

    private void ListActionAgentAnimeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListActionAgentAnimeValueChanged
        
        int[] indice = ListActionAgentAnime.getSelectedIndices();
        if (indice != null && indice.length > 0) 
        {
            Main.CreationRegles.indexSousActionModifier = indice[0];
            selectionDansListe(indice[0]);
        }
        setBorderTitle(PanelSSActionAgentAnime, "Modification d'une sous-action");
    }//GEN-LAST:event_ListActionAgentAnimeValueChanged

    private void BtAjouterSSActionAgentAnimeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtAjouterSSActionAgentAnimeMousePressed

   }//GEN-LAST:event_BtAjouterSSActionAgentAnimeMousePressed

    private void BtAjouterSSActionAgentAnimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAjouterSSActionAgentAnimeActionPerformed
        
        viderPanelSousAction();
        showPanelSousAction();
        affichageDeplacementPanelSousAction(false);
        setBorderTitle(PanelSSActionAgentAnime, Main.CreationRegles.titrePanelSousActionAnimation);
    }//GEN-LAST:event_BtAjouterSSActionAgentAnimeActionPerformed

    private void TxtHorizontaleSSActionAnimationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtHorizontaleSSActionAnimationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtHorizontaleSSActionAnimationActionPerformed

    private void TxtVerticaleSSActionAnimationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtVerticaleSSActionAnimationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtVerticaleSSActionAnimationActionPerformed

    private void SAjTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAjTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SAjTextField3ActionPerformed

    private void CbTypeSSActionAnimationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbTypeSSActionAnimationItemStateChanged

        if (CbTypeSSActionAnimation.getSelectedIndex() >= 0) {
            setBorderTitle(PanelSSActionAgentAnime, Main.CreationRegles.titrePanelSousActionAnimation);

            String typ = CbTypeSSActionAnimation.getSelectedItem().toString();
            viderPanelSousAction();
            if (Main.CreationRegles.itemDeplacementActionAnimation.equals(typ)) {
                affichageDeplacementPanelSousAction(false);
            } else if (Main.CreationRegles.itemAnimationActionAnimation.equals(typ)) {
                affichageAnimationPanelSousAction(false);
            } else if (Main.CreationRegles.itemPensseActionAnimation.equals(typ)) {
                affichagePenseePanelSousAction(false);
            } else if (Main.CreationRegles.itemParoleActionAnimation.equals(typ)) {
                affichageParolePanelSousAction(false);
            }
        }
    }//GEN-LAST:event_CbTypeSSActionAnimationItemStateChanged

    private void CbTypeSSActionAnimationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbTypeSSActionAnimationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbTypeSSActionAnimationActionPerformed

    private void BtValiderSSActionAnimationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderSSActionAnimationActionPerformed
        String typ = CbTypeSSActionAnimation.getSelectedItem().toString();
        if (Main.CreationRegles.itemDeplacementActionAnimation.equals(typ)) {
            Deplacement deplacement = new Deplacement();
            deplacement.initialiserSousAction(TxtHorizontaleSSActionAnimation.getText(), TxtVerticaleSSActionAnimation.getText(), SAjTextField3.getText());
            listeSousActions.ajouterSousAction(deplacement);
        } else if (Main.CreationRegles.itemAnimationActionAnimation.equals(typ)) {
            Animation animation = new Animation();
            animation.initialiserSousAction(SAjComboBoxIdentifiant.getSelectedItem().toString());
            listeSousActions.ajouterSousAction(animation);
        } else if (Main.CreationRegles.itemPensseActionAnimation.equals(typ)) {
            Pensee pensee = new Pensee();
            pensee.initialiserSousAction(TxtHorizontaleSSActionAnimation.getText());
            listeSousActions.ajouterSousAction(pensee);
        } else if (Main.CreationRegles.itemParoleActionAnimation.equals(typ)) {
            Parole parole = new Parole();
            parole.initialiserSousAction(TxtVerticaleSSActionAnimation.getText());
            listeSousActions.ajouterSousAction(parole);
        }
        viderPanelSousAction();
        hidePanelSousAction();
        initialiserListe();
    }//GEN-LAST:event_BtValiderSSActionAnimationActionPerformed

    private void BtModifierSSActionAnimationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierSSActionAnimationActionPerformed
        SousAction _SousAction = listeSousActions.getListe().get(Main.CreationRegles.indexSousActionModifier);

        String typ = CbTypeSSActionAnimation.getSelectedItem().toString();
        if (Main.CreationRegles.attributDéplacement.equals(typ)) {
            Deplacement deplacement = (Deplacement) _SousAction;
            deplacement.initialiserSousAction(TxtHorizontaleSSActionAnimation.getText(), TxtVerticaleSSActionAnimation.getText(), SAjTextField3.getText());
        } else if (Main.CreationRegles.attributAnimation.equals(typ)) {
            Animation animation = (Animation) _SousAction;
            animation.initialiserSousAction(SAjComboBoxIdentifiant.getSelectedItem().toString());
        } else if (Main.CreationRegles.attributPensee.equals(typ)) {
            Pensee pensee = (Pensee) _SousAction;
            pensee.initialiserSousAction(TxtHorizontaleSSActionAnimation.getText());
        } else if (Main.CreationRegles.attributParole.equals(typ)) {
            Parole parole = (Parole) _SousAction;
            parole.initialiserSousAction(TxtVerticaleSSActionAnimation.getText());
        }
        viderPanelSousAction();
        hidePanelSousAction();
        initialiserListe();
    }//GEN-LAST:event_BtModifierSSActionAnimationActionPerformed

    private void BtAnnulerSSActionAnimationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerSSActionAnimationActionPerformed
        viderPanelSousAction();
        hidePanelSousAction();
    }//GEN-LAST:event_BtAnnulerSSActionAnimationActionPerformed

    private void ArbreActionProfilValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_ArbreActionProfilValueChanged
        changerChoixActionModifProfil();
    }//GEN-LAST:event_ArbreActionProfilValueChanged

    private void CbTypeActionModifierProfilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbTypeActionModifierProfilItemStateChanged
        if (CbTypeActionModifierProfil.getSelectedIndex() > -1 && !ArbreActionProfil.isSelectionEmpty()) {
            changerChoixActionModifProfil();
        }
    }//GEN-LAST:event_CbTypeActionModifierProfilItemStateChanged

    private void BtAnnulerActionProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerActionProfilActionPerformed
        Main.CreationRegles.modifActionModifierProfil = false;
        annuler();
    }//GEN-LAST:event_BtAnnulerActionProfilActionPerformed

    private void BtValiderActionProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderActionProfilActionPerformed
        int ligne;
        if (Main.CreationRegles.modifActionModifierProfil) {
            ligne = Main.CreationRegles.ligneModifAction;
        } else {
            Main.CreationRegles.idAction++;
            ligne = Main.CreationRegles.lesActions.size();
            Main.CreationRegles.modelAction.addRow(new Object[]{"", "", "", ""});
        }

        //on cherche l'échelle de l'élément
        String chemin = ArbreActionProfil.getSelectionPath().toString().replace("profil, ", "");
        chemin = chemin.substring(1, chemin.length());
        if (chemin.contains(",")) {
            chemin = chemin.substring(0, chemin.indexOf(","));
        } else {
            chemin = chemin.substring(0, chemin.length() - 1);
        }
        Element compo = Main.CreationRegles.briqueParNom(Main.Cste.cheminStructuresProfils + Main.Cste.structureProfils, chemin);
        compo = (Element) compo.getChild(Main.CreationRegles.attributInfos_echelle).getChildren().get(0);
        Main.CreationRegles.id_echelleActionProfil = compo.getAttributeValue(Main.CreationRegles.attributId);

        Element a = creerActionModifierProfil();
        
        if (Main.CreationRegles.modifActionModifierProfil) 
        {
            String idact = Main.CreationRegles.TableActions.getValueAt(ligne, 0).toString();
            Element act = Main.CreationRegles.elementParId(Main.CreationRegles.lesActions, idact);
            Main.CreationRegles.lesActions.add(Main.CreationRegles.lesActions.indexOf(act), a);
            Main.CreationRegles.lesActions.remove(act);
            Main.CreationRegles.modifActionModifierProfil = false;
        } 
        else 
        {
            Main.CreationRegles.lesActions.add(a);
        }
        TxtNomAction.setText("A" + Main.CreationRegles.idAction);
        valider(a, ligne);
    }//GEN-LAST:event_BtValiderActionProfilActionPerformed

    private void BtAnnulerActionPasaPasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerActionPasaPasActionPerformed
        Main.CreationRegles.modifActionPasaPas = false;
        annuler();
    }//GEN-LAST:event_BtAnnulerActionPasaPasActionPerformed

    private void BtValiderActionPasaPasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderActionPasaPasActionPerformed
        if (CbEtapesActionPasaPas.getSelectedIndex() >= 0) 
        {
            int ligne;
            if (Main.CreationRegles.modifActionPasaPas) {
                ligne = Main.CreationRegles.ligneModifAction;
            } else {
                Main.CreationRegles.idAction++;
                ligne = Main.CreationRegles.lesActions.size();
               Main.CreationRegles. modelAction.addRow(new Object[]{"", "", "", ""});
            }

            Element a = creerActionPasaPas();
            
            if (Main.CreationRegles.modifActionPasaPas) {
                String idact = Main.CreationRegles.TableActions.getValueAt(ligne, 0).toString();
                Element act = Main.CreationRegles.elementParId(Main.CreationRegles.lesActions, idact);
                Main.CreationRegles.lesActions.add(Main.CreationRegles.lesActions.indexOf(act), a);
                Main.CreationRegles.lesActions.remove(act);
                Main.CreationRegles.modifActionPasaPas = false;
            } else {
                Main.CreationRegles.lesActions.add(a);
            }
            Main.CreationRegles.modifActionPasaPas = false;
            valider(a, ligne);
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Vous devez sélectionner une liste des étapes", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtValiderActionPasaPasActionPerformed

    private void BtApercuActionPasaPasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtApercuActionPasaPasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtApercuActionPasaPasActionPerformed

    private void CbTypeActionPasaPasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbTypeActionPasaPasItemStateChanged
        if (CbTypeActionPasaPas.getSelectedIndex() >= 0) {
            if (CbTypeActionPasaPas.getSelectedItem().equals(Main.CreationRegles.itemGuide)) {
                PanelGuiderActionPasaPas.setVisible(true);
                PanelAutomatiserActionPasaPas.setVisible(false);
            } else {
                PanelGuiderActionPasaPas.setVisible(false);
                PanelAutomatiserActionPasaPas.setVisible(true);
            }
        }
    }//GEN-LAST:event_CbTypeActionPasaPasItemStateChanged

    private void CbEtapesActionPasaPasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbEtapesActionPasaPasItemStateChanged
        actionCbEtapesActionPasaPas();
    }//GEN-LAST:event_CbEtapesActionPasaPasItemStateChanged

    private void BtCreerEtapesActionPasaPasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCreerEtapesActionPasaPasActionPerformed
        Main.CreationSequence.pasAPas = true;
        Main.CreationSequence.creer = true;
        Main.CreationSequence.listModel = Main.CreationRegles.listModel;
        Main.CreationSequence.sequence = null;
        Main.CreationSequence.ChargerInterface();
        Main.CreationSequence.setVisible(true);
    }//GEN-LAST:event_BtCreerEtapesActionPasaPasActionPerformed

    private void CheckMessageAvantActionPasaPasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckMessageAvantActionPasaPasItemStateChanged
        if (CheckMessageAvantActionPasaPas.isSelected()) {
            CheckMessageAvantAutorisationActionPasaPas.setEnabled(true);
        } else {
            CheckMessageAvantAutorisationActionPasaPas.setSelected(false);
            CheckMessageAvantAutorisationActionPasaPas.setEnabled(false);
        }

        BtPersonnaliserMessagesPasAPas.setEnabled(CheckMessageAvantActionPasaPas.isSelected() || CheckMessageApresActionPasaPas.isSelected() || CheckExpliquerEtapeActionPasaPas.isSelected() || CheckExpliquerEtapeTermineeActionPasaPas.isSelected());
    }//GEN-LAST:event_CheckMessageAvantActionPasaPasItemStateChanged

    private void CheckMessageAvantActionPasaPasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckMessageAvantActionPasaPasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckMessageAvantActionPasaPasActionPerformed

    private void CheckMessageApresActionPasaPasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckMessageApresActionPasaPasItemStateChanged
        if (CheckMessageApresActionPasaPas.isSelected()) {
            CheckMessageApresBilanActionPasaPas.setEnabled(true);
        } else {
            CheckMessageApresBilanActionPasaPas.setSelected(false);
            CheckMessageApresBilanActionPasaPas.setEnabled(false);
        }

        BtPersonnaliserMessagesPasAPas.setEnabled(CheckMessageAvantActionPasaPas.isSelected() || CheckMessageApresActionPasaPas.isSelected() || CheckExpliquerEtapeActionPasaPas.isSelected() || CheckExpliquerEtapeTermineeActionPasaPas.isSelected());
    }//GEN-LAST:event_CheckMessageApresActionPasaPasItemStateChanged

    private void CheckMiseEnValeurActionPasaPasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckMiseEnValeurActionPasaPasItemStateChanged
        BtMiseEnValeurPasAPas.setEnabled(CheckMiseEnValeurActionPasaPas.isSelected());
    }//GEN-LAST:event_CheckMiseEnValeurActionPasaPasItemStateChanged

    private void CheckInterventionActionPasaPasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckInterventionActionPasaPasItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckInterventionActionPasaPasItemStateChanged

    private void CheckExpliquerEtapeActionPasaPasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckExpliquerEtapeActionPasaPasItemStateChanged
        if (CheckExpliquerEtapeActionPasaPas.isSelected()) {
            CheckExpliquerEtapeAutorisationActionPasaPas.setEnabled(true);
        } else {
            CheckExpliquerEtapeAutorisationActionPasaPas.setSelected(false);
            CheckExpliquerEtapeAutorisationActionPasaPas.setEnabled(false);
        }

        BtPersonnaliserMessagesPasAPas.setEnabled(CheckMessageAvantActionPasaPas.isSelected() || CheckMessageApresActionPasaPas.isSelected() || CheckExpliquerEtapeActionPasaPas.isSelected() || CheckExpliquerEtapeTermineeActionPasaPas.isSelected());
    }//GEN-LAST:event_CheckExpliquerEtapeActionPasaPasItemStateChanged

    private void CheckExpliquerEtapeTermineeActionPasaPasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckExpliquerEtapeTermineeActionPasaPasItemStateChanged
        BtPersonnaliserMessagesPasAPas.setEnabled(CheckMessageAvantActionPasaPas.isSelected() || CheckMessageApresActionPasaPas.isSelected() || CheckExpliquerEtapeActionPasaPas.isSelected() || CheckExpliquerEtapeTermineeActionPasaPas.isSelected());
    }//GEN-LAST:event_CheckExpliquerEtapeTermineeActionPasaPasItemStateChanged

    private void CheckExpliquerEtapeTermineeActionPasaPasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckExpliquerEtapeTermineeActionPasaPasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckExpliquerEtapeTermineeActionPasaPasActionPerformed

    private void CheckTimerActionPasaPasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckTimerActionPasaPasItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckTimerActionPasaPasItemStateChanged

    private void CheckTimerActionPasaPasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckTimerActionPasaPasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckTimerActionPasaPasActionPerformed

    private void BtModifierEtapesActionPasaPasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierEtapesActionPasaPasActionPerformed
        if (CbEtapesActionPasaPas.getSelectedIndex() >= 0) {
            Main.CreationSequence.pasAPas = true;
            Main.CreationSequence.creer = false;
            Main.CreationSequence.listModel = Main.CreationRegles.listModel;
            Main.CreationSequence.sequence = Main.CreationRegles.elementParId(Main.CreationRegles.lesSequences, CbEtapesActionPasaPas.getSelectedItem().toString().substring(0, CbEtapesActionPasaPas.getSelectedItem().toString().indexOf("_")));
            Main.CreationSequence.ChargerInterface();
            Main.CreationSequence.setVisible(true);
        }
    }//GEN-LAST:event_BtModifierEtapesActionPasaPasActionPerformed

    private void BtPersonnaliserMessagesPasAPasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPersonnaliserMessagesPasAPasActionPerformed
        Main.PersonnalisationPasAPas.messageAvant = CheckMessageAvantActionPasaPas.isSelected();
        Main.PersonnalisationPasAPas.demandeMessageAvant = CheckMessageAvantAutorisationActionPasaPas.isSelected();
        Main.PersonnalisationPasAPas.messageApres = CheckMessageApresActionPasaPas.isSelected();
        Main.PersonnalisationPasAPas.modeAutomatise = PanelAutomatiserActionPasaPas.isVisible();
        if (PanelAutomatiserActionPasaPas.isVisible()) 
        {
            Main.PersonnalisationPasAPas.choixMessagesAvantEtape = choixMessagesAvantEtapePasaPas;
            Main.PersonnalisationPasAPas.choixMessagesApresEtape = choixMessagesApresEtapePasaPas;
            Main.PersonnalisationPasAPas.messageAvantEtape = CheckExpliquerEtapeActionPasaPas.isSelected();
            Main.PersonnalisationPasAPas.demandeMessageAvantEtape = CheckExpliquerEtapeAutorisationActionPasaPas.isSelected();
            Main.PersonnalisationPasAPas.messageApresEtape = CheckExpliquerEtapeTermineeActionPasaPas.isSelected();
        }
        
        Main.PersonnalisationPasAPas.sequence = (Element) Main.CreationRegles.elementParId(Main.CreationRegles.lesSequences, CbEtapesActionPasaPas.getSelectedItem().toString().substring(0, CbEtapesActionPasaPas.getSelectedItem().toString().indexOf("_"))).clone();
        Main.PersonnalisationPasAPas.chargerInterface();
        Main.PersonnalisationPasAPas.setVisible(true);
    }//GEN-LAST:event_BtPersonnaliserMessagesPasAPasActionPerformed

    private void BtMiseEnValeurPasAPasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtMiseEnValeurPasAPasActionPerformed
        Main.MiseEnValeurPasAPas.elementMiseEnValeur = elementMiseEnValeurEtape;
        Main.MiseEnValeurPasAPas.chargerInterface();
        Main.MiseEnValeurPasAPas.setVisible(true);
    }//GEN-LAST:event_BtMiseEnValeurPasAPasActionPerformed

    private void ArbreActionInterfaceValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_ArbreActionInterfaceValueChanged
        if (!ArbreActionInterface.isSelectionEmpty()) {
            if (!ArbreActionInterface.isRowSelected(0)) {
                String compo = ArbreActionInterface.getSelectionPath().getLastPathComponent().toString();
                String id = Main.CreationRegles.noeudGetId(compo);
                TxtComposantActionInterface.setText(id);
                Element comp = Main.CreationRegles.elementParId(Main.CreationRegles.lesComposants, id);
                if (comp.getAttribute(Main.CreationRegles.attributTypeAjoute) != null) {
                    Main.CreationRegles.ChargerCbActionActionInterface(CbActionActionInterface, comp.getAttributeValue(Main.CreationRegles.attributTypeAjoute));
                } else {
                    Main.CreationRegles.ChargerCbActionActionInterface(CbActionActionInterface, "");
                }
            }
        }
    }//GEN-LAST:event_ArbreActionInterfaceValueChanged

    private void BtAnnulerActionInterfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerActionInterfaceActionPerformed
        annuler();
    }//GEN-LAST:event_BtAnnulerActionInterfaceActionPerformed

    private void BtValiderActionInterfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderActionInterfaceActionPerformed
        if (!TxtComposantActionInterface.getText().isEmpty()) 
        {
            if (CbActionActionInterface.getSelectedIndex() >= 0) 
            {
                int ligne;
                if (Main.CreationRegles.modifActionInterface) {
                    ligne = Main.CreationRegles.ligneModifAction;
                } else {
                    Main.CreationRegles.idAction++;
                    ligne = Main.CreationRegles.lesActions.size();
                    Main.CreationRegles.modelAction.addRow(new Object[]{"", "", "", ""});
                }

                Element a = creerActionInterface();
                
                if (Main.CreationRegles.modifActionInterface) {
                    String idact = Main.CreationRegles.TableActions.getValueAt(ligne, 0).toString();
                    Element act = Main.CreationRegles.elementParId(Main.CreationRegles.lesActions, idact);
                    Main.CreationRegles.lesActions.add(Main.CreationRegles.lesActions.indexOf(act), a);
                    Main.CreationRegles.lesActions.remove(act);
                    Main.CreationRegles.modifActionInterface = false;
                } 
                else 
                {
                    Main.CreationRegles.lesActions.add(a);
                }
                Main.CreationRegles.modifActionInterface = false;
                valider(a, ligne);
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Vous devez choisir un type d'action à réaliser sur le composant", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vous devez sélectionner un composant dans l'arbre", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtValiderActionInterfaceActionPerformed

    private void CbActionActionInterfaceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbActionActionInterfaceItemStateChanged
        if (CbActionActionInterface.getSelectedIndex() >= 0) {
            if (CbActionActionInterface.getSelectedItem().equals(Main.CreationRegles.setValue)) {
                PanelEtatActionInterface.setVisible(false);
                PanelValeurActionInterface.setVisible(true);
            } else if (CbActionActionInterface.getSelectedItem().equals(Main.CreationRegles.toggle)) {
                PanelEtatActionInterface.setVisible(true);
                PanelValeurActionInterface.setVisible(false);
            } else {
                PanelEtatActionInterface.setVisible(false);
                PanelValeurActionInterface.setVisible(false);
            }
        }
    }//GEN-LAST:event_CbActionActionInterfaceItemStateChanged

    private void RbOnActionInterfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbOnActionInterfaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbOnActionInterfaceActionPerformed

    private void BtAfficherDescriptionInterfaceActionInterfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAfficherDescriptionInterfaceActionInterfaceActionPerformed
        Main.CreationRegles.affichageDescription(BtAfficherDescriptionInterfaceActionInterface, ArbreActionInterface);
    }//GEN-LAST:event_BtAfficherDescriptionInterfaceActionInterfaceActionPerformed

    private void BtModifierDescriptionInterfaceActionInterfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierDescriptionInterfaceActionInterfaceActionPerformed
        Main.ModificationInterface.chargerInterface();
        Main.ModificationInterface.setVisible(true);
    }//GEN-LAST:event_BtModifierDescriptionInterfaceActionInterfaceActionPerformed

    private void CheckEcritActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckEcritActionMessageActionPerformed
        CheckDifferentActionMessage.setEnabled(CheckOralActionMessage.isSelected() && CheckEcritActionMessage.isSelected());
        chargerCbModeActionMessage();
    }//GEN-LAST:event_CheckEcritActionMessageActionPerformed

    private void CheckOralActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckOralActionMessageActionPerformed
        CheckDifferentActionMessage.setEnabled(CheckOralActionMessage.isSelected() && CheckEcritActionMessage.isSelected());
        chargerCbModeActionMessage();
    }//GEN-LAST:event_CheckOralActionMessageActionPerformed

    private void CheckOralActionMessagePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CheckOralActionMessagePropertyChange

   }//GEN-LAST:event_CheckOralActionMessagePropertyChange

    private void CheckDifferentActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckDifferentActionMessageActionPerformed
        TxtDifferentActionMessage.setEnabled(CheckDifferentActionMessage.isSelected());
        CbPersoDifferentActionMessage.setEnabled(CheckDifferentActionMessage.isSelected());
    }//GEN-LAST:event_CheckDifferentActionMessageActionPerformed

    private void CheckDifferentActionMessagePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CheckDifferentActionMessagePropertyChange
        TxtDifferentActionMessage.setEnabled(CheckDifferentActionMessage.isSelected());
        CbPersoDifferentActionMessage.setEnabled(CheckDifferentActionMessage.isSelected());
    }//GEN-LAST:event_CheckDifferentActionMessagePropertyChange

    private void CbModeActionMessageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbModeActionMessageItemStateChanged
        if (CbModeActionMessage.getSelectedIndex() >= 0) {
            PanelDetailsAgentActionMessage.setVisible(false);
            PanelDetailsPopupActionMessage.setVisible(false);

            if (Main.CreationRegles.afficherDetailsMessage && CbModeActionMessage.getSelectedItem().equals(Main.CreationRegles.itemAgentAnime)) {
                PanelDetailsAgentActionMessage.setVisible(true);
            } else if (Main.CreationRegles.afficherDetailsMessage && (CbModeActionMessage.getSelectedItem().equals(Main.CreationRegles.itemPopup) || CbModeActionMessage.getSelectedItem().equals(Main.CreationRegles.itemPopupSynthese))) {
                PanelDetailsPopupActionMessage.setVisible(true);
            }

            BtAfficherDetailsActionMessage.setVisible(!CbModeActionMessage.getSelectedItem().toString().isEmpty());
        }
    }//GEN-LAST:event_CbModeActionMessageItemStateChanged

    private void BtAfficherDetailsActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAfficherDetailsActionMessageActionPerformed
        if (Main.CreationRegles.afficherDetailsMessage) {
            BtAfficherDetailsActionMessage.setToolTipText("Afficher les détails du message");
            Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
            BtAfficherDetailsActionMessage.setIcon(new ImageIcon(icon));
            BtAfficherDetailsActionMessage.setText("");
        } else {
            BtAfficherDetailsActionMessage.setToolTipText("Masquer les détails du message");
            Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/moins.png"));
            BtAfficherDetailsActionMessage.setIcon(new ImageIcon(icon));
            BtAfficherDetailsActionMessage.setText("");
        }

        Main.CreationRegles.afficherDetailsMessage = !Main.CreationRegles.afficherDetailsMessage;
        PanelDetailsAgentActionMessage.setVisible(Main.CreationRegles.afficherDetailsMessage && CbModeActionMessage.getSelectedItem().toString().equals(Main.CreationRegles.itemAgentAnime));
        PanelDetailsPopupActionMessage.setVisible(Main.CreationRegles.afficherDetailsMessage && (CbModeActionMessage.getSelectedItem().toString().equals(Main.CreationRegles.itemPopup) || CbModeActionMessage.getSelectedItem().toString().equals(Main.CreationRegles.itemPopupSynthese)));
    }//GEN-LAST:event_BtAfficherDetailsActionMessageActionPerformed

    private void BtApercuActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtApercuActionMessageActionPerformed
        if (!Main.CreationRegles.HTMLStringToString(Main.CreationRegles.editor.getText()).equals("")) {
            XMLFonctions.creerXML(creerActionMessage());
            XMLFonctions.enregistre("Action.xml", "");
            String assist = Main.Cste.jarMessager;
            if (CbModeActionMessage.getSelectedItem().equals(Main.CreationRegles.itemAgentAnime)) {
                assist = Main.Cste.jarMsAgents;
            }
            try {
                Runtime.getRuntime().exec("java -jar " + assist);
            } catch (IOException ex) {
                Logger.getLogger(ApercuMiseEnValeur.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vous devez saisir le contenu du message", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtApercuActionMessageActionPerformed

    private void BtValiderActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderActionMessageActionPerformed
        if (!Main.CreationRegles.HTMLStringToString(Main.CreationRegles.editor.getText()).equals("")) 
        {
            int ligne;
            if (Main.CreationRegles.modifActionMessage) {
                ligne = Main.CreationRegles.ligneModifAction;
            } else {
                Main.CreationRegles.idAction++;
                ligne = Main.CreationRegles.lesActions.size();
                Main.CreationRegles.modelAction.addRow(new Object[]{"", "", "", ""});
            }

            Element a = creerActionMessage();

            if (Main.CreationRegles.modifActionMessage) {
                String idact = Main.CreationRegles.TableActions.getValueAt(ligne, 0).toString();
                Element act = Main.CreationRegles.elementParId(Main.CreationRegles.lesActions, idact);
                Main.CreationRegles.lesActions.add(Main.CreationRegles.lesActions.indexOf(act), a);
                Main.CreationRegles.lesActions.remove(act);
                Main.CreationRegles.modifActionMessage = false;
            } 
            else 
            {
                Main.CreationRegles.lesActions.add(a);
            }
            Main.CreationRegles.modifActionMessage = false;
            resetActionMessage();
            valider(a, ligne);
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Vous devez saisir le contenu du message_"+Main.CreationRegles.editor.getText()+"_", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtValiderActionMessageActionPerformed

    private void BtAnnulerActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerActionMessageActionPerformed
        
        Main.CreationRegles.modifActionMessage = false;
        resetActionMessage();
        annuler();
    }//GEN-LAST:event_BtAnnulerActionMessageActionPerformed

    private void RbPositionEcranPopupActionMessageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RbPositionEcranPopupActionMessageItemStateChanged
        if (RbPositionEcranPopupActionMessage.isSelected()) {
            CbPositionHorizontalePopupActionMessage.setEnabled(true);
            CbPositionVerticalePopupActionMessage.setEnabled(true);
        } else {
            CbPositionHorizontalePopupActionMessage.setEnabled(false);
            CbPositionVerticalePopupActionMessage.setEnabled(false);
        }
    }//GEN-LAST:event_RbPositionEcranPopupActionMessageItemStateChanged

    private void RbPositionEcranPopupActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbPositionEcranPopupActionMessageActionPerformed
        SpinXPopupActionMessage.setEnabled(false);
        SpinYPopupActionMessage.setEnabled(false);
        CbPositionVerticalePopupActionMessage.setEnabled(true);
        CbPositionHorizontalePopupActionMessage.setEnabled(true);
    }//GEN-LAST:event_RbPositionEcranPopupActionMessageActionPerformed

    private void RbPositionCoordonneesPopupActionMessageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RbPositionCoordonneesPopupActionMessageItemStateChanged
        if (RbPositionCoordonneesPopupActionMessage.isSelected()) {
            SpinXPopupActionMessage.setEnabled(true);
            SpinYPopupActionMessage.setEnabled(true);
        } else {
            SpinXPopupActionMessage.setEnabled(false);
            SpinYPopupActionMessage.setEnabled(false);
        }
    }//GEN-LAST:event_RbPositionCoordonneesPopupActionMessageItemStateChanged

    private void RbPositionCoordonneesPopupActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbPositionCoordonneesPopupActionMessageActionPerformed
        SpinXPopupActionMessage.setEnabled(true);
        SpinYPopupActionMessage.setEnabled(true);
        CbPositionHorizontalePopupActionMessage.setEnabled(false);
        CbPositionVerticalePopupActionMessage.setEnabled(false);
    }//GEN-LAST:event_RbPositionCoordonneesPopupActionMessageActionPerformed

    private void BtRbPositionSourisPopupActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRbPositionSourisPopupActionMessageActionPerformed
        SpinXPopupActionMessage.setEnabled(false);
        SpinYPopupActionMessage.setEnabled(false);
        CbPositionHorizontalePopupActionMessage.setEnabled(false);
        CbPositionVerticalePopupActionMessage.setEnabled(false);
    }//GEN-LAST:event_BtRbPositionSourisPopupActionMessageActionPerformed

    private void BtTailleManuellePopupActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtTailleManuellePopupActionMessageActionPerformed
        SpinHauteurFenetrePopupActionMessage.setEnabled(true);
        SpinLargeurFenetrePopupActionMessage.setEnabled(true);
    }//GEN-LAST:event_BtTailleManuellePopupActionMessageActionPerformed

    private void BtTailleAutomatiquePopupActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtTailleAutomatiquePopupActionMessageActionPerformed
        SpinHauteurFenetrePopupActionMessage.setEnabled(false);
        SpinLargeurFenetrePopupActionMessage.setEnabled(false);
    }//GEN-LAST:event_BtTailleAutomatiquePopupActionMessageActionPerformed

    private void TxtTitreFenetreActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTitreFenetreActionMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtTitreFenetreActionMessageActionPerformed

    private void CheckMiseEnFormeActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckMiseEnFormeActionMessageActionPerformed
        PanelContenuActionMessage.setVisible(!CheckMiseEnFormeActionMessage.isSelected());
        PanelCouleurFondActionMessage.setVisible(CheckMiseEnFormeActionMessage.isSelected());
    }//GEN-LAST:event_CheckMiseEnFormeActionMessageActionPerformed

    private void RbPositionEcranAgentActionMessageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RbPositionEcranAgentActionMessageItemStateChanged
        if (RbPositionEcranAgentActionMessage.isSelected()) {
            CbPositionHorizontaleAgentActionMessage.setEnabled(true);
            CbPositionVerticaleAgentActionMessage.setEnabled(true);
        } else {
            CbPositionHorizontaleAgentActionMessage.setEnabled(false);
            CbPositionVerticaleAgentActionMessage.setEnabled(false);
        }
    }//GEN-LAST:event_RbPositionEcranAgentActionMessageItemStateChanged

    private void RbPositionEcranAgentActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbPositionEcranAgentActionMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbPositionEcranAgentActionMessageActionPerformed

    private void RbPositionCoordonneesAgentActionMessageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RbPositionCoordonneesAgentActionMessageItemStateChanged
        if (RbPositionCoordonneesAgentActionMessage.isSelected()) {
            SpinXAgentActionMessage.setEnabled(true);
            SpinYAgentActionMessage.setEnabled(true);
        } else {
            SpinXAgentActionMessage.setEnabled(false);
            SpinYAgentActionMessage.setEnabled(false);
        }
    }//GEN-LAST:event_RbPositionCoordonneesAgentActionMessageItemStateChanged

    private void RbPositionCoordonneesAgentActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbPositionCoordonneesAgentActionMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbPositionCoordonneesAgentActionMessageActionPerformed

    private void BtRbPositionSourisAgentActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRbPositionSourisAgentActionMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtRbPositionSourisAgentActionMessageActionPerformed

    private void BtModifierAgentActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierAgentActionMessageActionPerformed
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir") + "/" + Main.Cste.cheminPersonnages);
        chooser.setApproveButtonText("Choisir"); //intitulé du bouton
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            ImageIcon im = new ImageIcon(chooser.getSelectedFile().getAbsolutePath());
            BtModifierAgentActionMessage.setIcon(im);
            Main.CreationRegles.personnageMessage = chooser.getSelectedFile().getName().substring(0, chooser.getSelectedFile().getName().length() - 4);
            this.repaint();
        }
    }//GEN-LAST:event_BtModifierAgentActionMessageActionPerformed

    private void CbPersoActionMessageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbPersoActionMessageItemStateChanged
        if (CbPersoActionMessage.getSelectedIndex() >= 0) {
            BtInclureActionMessage.setEnabled(!CbPersoActionMessage.getSelectedItem().toString().isEmpty());

            if (CbPersoActionMessage.getSelectedItem().toString().equals(Main.CreationRegles.itemAvecElementProfil)) {
                Main.PersonnalisationMessage.chargerInterface();
                Main.PersonnalisationMessage.setVisible(true);
            }
        }
    }//GEN-LAST:event_CbPersoActionMessageItemStateChanged

    private void BtInclureActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtInclureActionMessageActionPerformed
        if (CbPersoActionMessage.getItemCount() >= 0) {
            if (CbPersoActionMessage.getSelectedItem().toString().equals(Main.CreationRegles.itemAvecPrenom)) {
                Main.CreationRegles.ajouteBalise(Main.CreationRegles.baliseprenom, Main.CreationRegles.editor);
            } else if (CbPersoActionMessage.getSelectedItem().toString().equals(Main.CreationRegles.itemAvecNom)) {
                Main.CreationRegles.ajouteBalise(Main.CreationRegles.balisenom, Main.CreationRegles.editor);
            } else {
                Main.CreationRegles.ajouteBalise(CbPersoActionMessage.getSelectedItem().toString(), Main.CreationRegles.editor);
                chargerCbPersoActionMessage();
            }
        }
    }//GEN-LAST:event_BtInclureActionMessageActionPerformed

    private void BtCouleurFondActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCouleurFondActionMessageActionPerformed
        BtCouleurFondActionMessage.setBackground(JColorChooser.showDialog(null, "Choisir une couleur", BtCouleurActionMiseEnValeur.getBackground()));
        this.repaint();
        Main.CreationRegles.ajoutCouleurFond(Integer.toHexString(BtCouleurFondActionMessage.getBackground().getRGB()));
    }//GEN-LAST:event_BtCouleurFondActionMessageActionPerformed

    private void PanelPersoContenu1ActionMessageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPersoContenu1ActionMessageMouseEntered
        PanelPersoContenu1ActionMessage.repaint();
    }//GEN-LAST:event_PanelPersoContenu1ActionMessageMouseEntered

    private void CbPersoDifferentActionMessageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbPersoDifferentActionMessageItemStateChanged
        if (CbPersoDifferentActionMessage.getSelectedIndex() >= 0) {
            BtInclureDifferentActionMessage.setEnabled(!CbPersoDifferentActionMessage.getSelectedItem().toString().isEmpty());
        }
    }//GEN-LAST:event_CbPersoDifferentActionMessageItemStateChanged

    private void CbPersoDifferentActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbPersoDifferentActionMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbPersoDifferentActionMessageActionPerformed

    private void BtInclureDifferentActionMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtInclureDifferentActionMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtInclureDifferentActionMessageActionPerformed

    private void PanelContenuActionMessageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelContenuActionMessageMouseEntered
        if (PanelContenuActionMessage.isVisible()) {
            PanelContenuActionMessage.repaint();
        }
    }//GEN-LAST:event_PanelContenuActionMessageMouseEntered

    private void BtAnnulerActionRessourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerActionRessourceActionPerformed
        CbTypeActionRessource.setSelectedIndex(0);
        TxtNomAction.setText("A" + Main.CreationRegles.idAction);
        CbChoixTypeAction.setSelectedIndex(0);
        annuler();
    }//GEN-LAST:event_BtAnnulerActionRessourceActionPerformed

    private void BtValiderActionRessourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderActionRessourceActionPerformed
        if (!TxtCheminActionRessource.getText().isEmpty()) 
        {
            int ligne;
            if (Main.CreationRegles.modifActionRessource)
            {
                ligne = Main.CreationRegles.ligneModifAction;
            }
            else 
            {
                Main.CreationRegles.idAction++;
                ligne = Main.CreationRegles.lesActions.size();
                Main.CreationRegles.modelAction.addRow(new Object[]{"", "", "", ""});
            }

            Element a = creerActionRessource();
            if (Main.CreationRegles.modifActionRessource) 
            {
                String idact = Main.CreationRegles.TableActions.getValueAt(ligne, 0).toString();
                Element act = Main.CreationRegles.elementParId(Main.CreationRegles.lesActions, idact);
                Main.CreationRegles.lesActions.add(Main.CreationRegles.lesActions.indexOf(act), a);
                Main.CreationRegles.lesActions.remove(act);
                Main.CreationRegles.modifActionRessource = false;
            } 
            else 
            {
                Main.CreationRegles.lesActions.add(a);
            }
            TxtNomAction.setText("A" + Main.CreationRegles.idAction);
            CbTypeActionRessource.setSelectedIndex(0);
            TxtNomAction.setText("A" + Main.CreationRegles.idAction);
            CbChoixTypeAction.setSelectedIndex(0);
            valider(a, ligne);
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Vous devez le chemin ou l'url", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtValiderActionRessourceActionPerformed

    private void CbTypeActionRessourceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbTypeActionRessourceItemStateChanged
        if (CbTypeActionRessource.getSelectedIndex() >= 0) {
            if (CbTypeActionRessource.getSelectedItem().equals(Main.CreationRegles.itemOuvrirAppliActionRessource)) {
                BtCheminActionRessource.setVisible(true);
                LbCheminActionRessource.setText(Main.CreationRegles.itemCheminActionRessource);
            } else if (CbTypeActionRessource.getSelectedItem().equals(Main.CreationRegles.itemOuvrirURLActionRessource)) {
                BtCheminActionRessource.setVisible(false);
                LbCheminActionRessource.setText("URL");
            } else {
                BtCheminActionRessource.setVisible(true);
                LbCheminActionRessource.setText(Main.CreationRegles.itemCheminActionRessource);
            }
            TxtCheminActionRessource.setText("");
        }
    }//GEN-LAST:event_CbTypeActionRessourceItemStateChanged

    private void BtCheminActionRessourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCheminActionRessourceActionPerformed
        JFileChooser chooser = new JFileChooser();
        if (CbTypeActionRessource.getSelectedItem().equals(Main.CreationRegles.itemOuvrirAppliActionRessource)) {
        }
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            TxtCheminActionRessource.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_BtCheminActionRessourceActionPerformed

    private void ArbreActionAjoutComposantValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_ArbreActionAjoutComposantValueChanged
        if (!ArbreActionAjoutComposant.isSelectionEmpty()) {
            if (!ArbreActionAjoutComposant.isRowSelected(0)) {
                String compo = ArbreActionAjoutComposant.getSelectionPath().getLastPathComponent().toString();
                TxtIdActionAjoutComposant.setText(Main.CreationRegles.noeudGetId(compo));
            }
        }
    }//GEN-LAST:event_ArbreActionAjoutComposantValueChanged

    private void TxtIdActionAjoutComposantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdActionAjoutComposantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdActionAjoutComposantActionPerformed

    private void BtAnnulerActionAjoutComposantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerActionAjoutComposantActionPerformed
        annuler();
    }//GEN-LAST:event_BtAnnulerActionAjoutComposantActionPerformed

    private void BtValiderActionAjoutComposantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderActionAjoutComposantActionPerformed
        if (!TxtIdActionAjoutComposant.getText().isEmpty()) 
        {
            if (CbTypeActionAjoutComposant.getSelectedIndex() >= 0) 
            {
                int ligne;
                if (Main.CreationRegles.modifActionAjoutComposant) {
                    ligne = Main.CreationRegles.ligneModifAction;
                } else {
                    Main.CreationRegles.idAction++;
                    ligne = Main.CreationRegles.lesActions.size();
                    Main.CreationRegles.modelAction.addRow(new Object[]{"", "", "", ""});
                }
                
                Element a = creerActionAjoutComposant();
                
                if (Main.CreationRegles.modifActionAjoutComposant) 
                {
                    String idact = Main.CreationRegles.TableActions.getValueAt(ligne, 0).toString();
                    Element act = Main.CreationRegles.elementParId(Main.CreationRegles.lesActions, idact);
                    Main.CreationRegles.lesActions.add(Main.CreationRegles.lesActions.indexOf(act), a);
                    Main.CreationRegles.lesActions.remove(act);
                }
                else 
                {
                    Main.CreationRegles.lesActions.add(a);
                }
                TxtNomAction.setText("A" + Main.CreationRegles.idAction);
                
                Main.CreationRegles.modifActionAjoutComposant = false;
                valider(a, ligne);
                Main.CreationRegles.idComposantAjoute++;               
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Vous devez choisir un type d'action à réaliser sur le composant", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Vous devez sélectionner un composant dans l'arbre", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtValiderActionAjoutComposantActionPerformed

    private void BtApercuActionAjoutComposantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtApercuActionAjoutComposantActionPerformed
        Main.ApercuMiseEnValeur.apercuAjoutComposant(creerActionAjoutComposant());
    }//GEN-LAST:event_BtApercuActionAjoutComposantActionPerformed

    private void BtModifierDescriptionInterfaceActionAjoutComposantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierDescriptionInterfaceActionAjoutComposantActionPerformed
        Main.ModificationInterface.chargerInterface();
        Main.ModificationInterface.setVisible(true);
    }//GEN-LAST:event_BtModifierDescriptionInterfaceActionAjoutComposantActionPerformed

    private void BtAfficherDescriptionInterfaceActionAjoutComposantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAfficherDescriptionInterfaceActionAjoutComposantActionPerformed
        Main.CreationRegles.affichageDescription(BtAfficherDescriptionInterfaceActionAjoutComposant, ArbreActionAjoutComposant);
    }//GEN-LAST:event_BtAfficherDescriptionInterfaceActionAjoutComposantActionPerformed

    private void CbTypeActionAjoutComposantItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbTypeActionAjoutComposantItemStateChanged
        if (CbTypeActionAjoutComposant.getSelectedIndex() >= 0) {
            PanelBoutonActionAjoutComposant.setVisible(false);
            PanelLabelActionAjoutComposant.setVisible(false);
            PanelImageActionAjoutComposant.setVisible(false);
            if (CbTypeActionAjoutComposant.getSelectedItem().toString().equals(Main.CreationRegles.itemTypeComposantAjouteBouton)) {
                PanelBoutonActionAjoutComposant.setVisible(true);
            } else if (CbTypeActionAjoutComposant.getSelectedItem().toString().equals(Main.CreationRegles.itemTypeComposantAjouteLabel)) {
                PanelLabelActionAjoutComposant.setVisible(true);
            } else if (CbTypeActionAjoutComposant.getSelectedItem().toString().equals(Main.CreationRegles.itemTypeComposantAjouteImage)) {
                PanelImageActionAjoutComposant.setVisible(true);
            }
        }
    }//GEN-LAST:event_CbTypeActionAjoutComposantItemStateChanged

    private void BtAfficherDetailsActionAjoutComposantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAfficherDetailsActionAjoutComposantActionPerformed
        afficherDetailsActionAjoutComposant(PanelDetailsActionAjoutComposant.isVisible());
    }//GEN-LAST:event_BtAfficherDetailsActionAjoutComposantActionPerformed

    private void CheckTexteBoutonActionAjoutComposantItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckTexteBoutonActionAjoutComposantItemStateChanged
        TxtTexteBoutonActionAjoutComposant.setEnabled(CheckTexteBoutonActionAjoutComposant.isSelected());
    }//GEN-LAST:event_CheckTexteBoutonActionAjoutComposantItemStateChanged

    private void CheckIconeBoutonActionAjoutComposantItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckIconeBoutonActionAjoutComposantItemStateChanged
        BtIconeBoutonActionAjoutComposant.setEnabled(CheckIconeBoutonActionAjoutComposant.isSelected());
    }//GEN-LAST:event_CheckIconeBoutonActionAjoutComposantItemStateChanged

    private void CheckInfoBulleBoutonActionAjoutComposantItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckInfoBulleBoutonActionAjoutComposantItemStateChanged
        TxtInfoBulleBoutonActionAjoutComposant.setEnabled(CheckInfoBulleBoutonActionAjoutComposant.isSelected());
    }//GEN-LAST:event_CheckInfoBulleBoutonActionAjoutComposantItemStateChanged

    private void BtIconeBoutonActionAjoutComposantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIconeBoutonActionAjoutComposantActionPerformed
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir") + "/" + Main.Cste.cheminSymboles);
        chooser.setApproveButtonText("Choisir"); //intitulé du bouton
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            ImageIcon im = new ImageIcon(chooser.getSelectedFile().getAbsolutePath());
            BtIconeBoutonActionAjoutComposant.setIcon(im);
            BtIconeBoutonActionAjoutComposant.setToolTipText(chooser.getSelectedFile().getName());
            this.repaint();
        }
    }//GEN-LAST:event_BtIconeBoutonActionAjoutComposantActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        annuler();
    }//GEN-LAST:event_formWindowClosing

    private void SpinDureeActionMiseEnValeurEntourerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinDureeActionMiseEnValeurEntourerStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_SpinDureeActionMiseEnValeurEntourerStateChanged

    private void CheckDureeActionMiseEnValeurEntourerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckDureeActionMiseEnValeurEntourerItemStateChanged
        SpinDureeActionMiseEnValeurEntourer.setEnabled(CheckDureeActionMiseEnValeurEntourer.isSelected());
    }//GEN-LAST:event_CheckDureeActionMiseEnValeurEntourerItemStateChanged

    private void SpinDureeActionMiseEnValeurColorerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinDureeActionMiseEnValeurColorerStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_SpinDureeActionMiseEnValeurColorerStateChanged

    private void CheckDureeActionMiseEnValeurColorerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckDureeActionMiseEnValeurColorerItemStateChanged
        SpinDureeActionMiseEnValeurColorer.setEnabled(CheckDureeActionMiseEnValeurColorer.isSelected());
    }//GEN-LAST:event_CheckDureeActionMiseEnValeurColorerItemStateChanged

    private void CheckDureeActionMiseEnValeurSymboleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckDureeActionMiseEnValeurSymboleItemStateChanged
        SpinDureeActionMiseEnValeurSymbole.setEnabled(CheckDureeActionMiseEnValeurSymbole.isSelected());
    }//GEN-LAST:event_CheckDureeActionMiseEnValeurSymboleItemStateChanged

    private void SpinDureeActionMiseEnValeurSymboleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinDureeActionMiseEnValeurSymboleStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_SpinDureeActionMiseEnValeurSymboleStateChanged

    private void SpinDureeActionMiseEnValeurAgentStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinDureeActionMiseEnValeurAgentStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_SpinDureeActionMiseEnValeurAgentStateChanged

    private void CheckDureeActionMiseEnValeurAgentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckDureeActionMiseEnValeurAgentItemStateChanged
        SpinDureeActionMiseEnValeurAgent.setEnabled(CheckDureeActionMiseEnValeurAgent.isSelected());
    }//GEN-LAST:event_CheckDureeActionMiseEnValeurAgentItemStateChanged

    private void CheckIconeLabelActionAjoutComposantItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckIconeLabelActionAjoutComposantItemStateChanged
        BtIconeLabelActionAjoutComposant.setEnabled(CheckIconeLabelActionAjoutComposant.isSelected());
    }//GEN-LAST:event_CheckIconeLabelActionAjoutComposantItemStateChanged

    private void BtIconeLabelActionAjoutComposantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIconeLabelActionAjoutComposantActionPerformed
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir") + "/" + Main.Cste.cheminSymboles);
        chooser.setApproveButtonText("Choisir"); //intitulé du bouton
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            ImageIcon im = new ImageIcon(chooser.getSelectedFile().getAbsolutePath());
            BtIconeLabelActionAjoutComposant.setIcon(im);
            BtIconeLabelActionAjoutComposant.setToolTipText(chooser.getSelectedFile().getName());
            this.repaint();
        }
    }//GEN-LAST:event_BtIconeLabelActionAjoutComposantActionPerformed

    private void CheckTexteBoutonActionAjoutComposantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckTexteBoutonActionAjoutComposantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckTexteBoutonActionAjoutComposantActionPerformed

    private void BtIconeImageActionAjoutComposantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIconeImageActionAjoutComposantActionPerformed
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir") + "/" + Main.Cste.cheminSymboles);
        chooser.setApproveButtonText("Choisir"); //intitulé du bouton
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            ImageIcon im = new ImageIcon(chooser.getSelectedFile().getAbsolutePath());
            BtIconeImageActionAjoutComposant.setIcon(im);
            BtIconeImageActionAjoutComposant.setToolTipText(chooser.getSelectedFile().getName());
            this.repaint();
        }
    }//GEN-LAST:event_BtIconeImageActionAjoutComposantActionPerformed

    private void BtPoliceActionAjoutComposantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPoliceActionAjoutComposantActionPerformed
        Main.ChoixPolice.chargerInterface();
        Main.ChoixPolice.chargerChoix(BtPoliceActionAjoutComposant);
        Main.ChoixPolice.setVisible(true);
    }//GEN-LAST:event_BtPoliceActionAjoutComposantActionPerformed

    private void BtAnnulerActionPresentationGuideeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerActionPresentationGuideeActionPerformed
        Main.CreationRegles.modifActionPresentationGuidee = false;
        annuler();
    }//GEN-LAST:event_BtAnnulerActionPresentationGuideeActionPerformed

    private void BtValiderActionPresentationGuideeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderActionPresentationGuideeActionPerformed
        if (CbEtapesActionPasaPas.getSelectedIndex() >= 0) 
        {
            int ligne;
            if (Main.CreationRegles.modifActionPresentationGuidee) {
                ligne = Main.CreationRegles.ligneModifAction;
            } else {
                Main.CreationRegles.idAction++;
                ligne = Main.CreationRegles.lesActions.size();
               Main.CreationRegles. modelAction.addRow(new Object[]{"", "", "", ""});
            }

            Element a = creerActionPresentationGuidee();
            
            if (Main.CreationRegles.modifActionPresentationGuidee) {
                String idact = Main.CreationRegles.TableActions.getValueAt(ligne, 0).toString();
                Element act = Main.CreationRegles.elementParId(Main.CreationRegles.lesActions, idact);
                Main.CreationRegles.lesActions.add(Main.CreationRegles.lesActions.indexOf(act), a);
                Main.CreationRegles.lesActions.remove(act);
            } else {
                Main.CreationRegles.lesActions.add(a);
            }
            Main.CreationRegles.modifActionPresentationGuidee = false;
            valider(a, ligne);
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Vous devez sélectionner une liste des étapes", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtValiderActionPresentationGuideeActionPerformed

    private void BtApercuActionPresentationGuideeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtApercuActionPresentationGuideeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtApercuActionPresentationGuideeActionPerformed

    private void CbEtapesActionPresentationGuideeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbEtapesActionPresentationGuideeItemStateChanged
        actionCbEtapesActionPresentationGuidee();
    }//GEN-LAST:event_CbEtapesActionPresentationGuideeItemStateChanged

    private void BtCreerEtapesActionPresentationGuideeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCreerEtapesActionPresentationGuideeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtCreerEtapesActionPresentationGuideeActionPerformed

    private void CheckMessageAvantActionPresentationGuideeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckMessageAvantActionPresentationGuideeItemStateChanged
        CheckMessageAvantAutorisationActionPresentationGuidee.setEnabled(CheckMessageAvantActionPresentationGuidee.isSelected());
        BtPersonnaliserMessagesPresentationGuidee.setEnabled(CheckMessageAvantActionPresentationGuidee.isSelected() || CheckMessageApresActionPresentationGuidee.isSelected() || CheckExpliquerEtapeActionPresentationGuidee.isSelected());
    }//GEN-LAST:event_CheckMessageAvantActionPresentationGuideeItemStateChanged

    private void CheckMessageAvantActionPresentationGuideeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckMessageAvantActionPresentationGuideeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckMessageAvantActionPresentationGuideeActionPerformed

    private void CheckMessageApresActionPresentationGuideeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckMessageApresActionPresentationGuideeItemStateChanged
        BtPersonnaliserMessagesPresentationGuidee.setEnabled(CheckMessageAvantActionPresentationGuidee.isSelected() || CheckMessageApresActionPresentationGuidee.isSelected() || CheckExpliquerEtapeActionPresentationGuidee.isSelected());
    }//GEN-LAST:event_CheckMessageApresActionPresentationGuideeItemStateChanged

    private void CheckExpliquerEtapeActionPresentationGuideeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckExpliquerEtapeActionPresentationGuideeItemStateChanged
        CheckExpliquerEtapeAutorisationActionPresentationGuidee.setEnabled(CheckExpliquerEtapeActionPresentationGuidee.isSelected());
        BtPersonnaliserMessagesPresentationGuidee.setEnabled(CheckMessageAvantActionPresentationGuidee.isSelected() || CheckMessageApresActionPresentationGuidee.isSelected() || CheckExpliquerEtapeActionPresentationGuidee.isSelected());
    }//GEN-LAST:event_CheckExpliquerEtapeActionPresentationGuideeItemStateChanged

    private void CheckTimerActionPresentationGuideeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckTimerActionPresentationGuideeItemStateChanged
        SpinTimerActionPresentationGuidee.setEnabled(CheckTimerActionPresentationGuidee.isSelected());
    }//GEN-LAST:event_CheckTimerActionPresentationGuideeItemStateChanged

    private void CheckTimerActionPresentationGuideeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckTimerActionPresentationGuideeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckTimerActionPresentationGuideeActionPerformed

    private void BtModifierEtapesActionPresentationGuideeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierEtapesActionPresentationGuideeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtModifierEtapesActionPresentationGuideeActionPerformed

    private void BtPersonnaliserMessagesPresentationGuideeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPersonnaliserMessagesPresentationGuideeActionPerformed
        Main.PersonnalisationPasAPas.messageAvant = CheckMessageAvantActionPresentationGuidee.isSelected();
        Main.PersonnalisationPasAPas.demandeMessageAvant = CheckMessageAvantAutorisationActionPresentationGuidee.isSelected();
        Main.PersonnalisationPasAPas.messageApres = CheckMessageApresActionPresentationGuidee.isSelected();
        Main.PersonnalisationPasAPas.modeAutomatise = true;
        Main.PersonnalisationPasAPas.choixMessagesAvantEtape = choixMessagesAvantEtapePresentationGuidee;
        Main.PersonnalisationPasAPas.choixMessagesApresEtape = null;
        Main.PersonnalisationPasAPas.messageAvantEtape = CheckExpliquerEtapeActionPresentationGuidee.isSelected();
        Main.PersonnalisationPasAPas.demandeMessageAvantEtape = CheckExpliquerEtapeAutorisationActionPresentationGuidee.isSelected();
        Main.PersonnalisationPasAPas.messageApresEtape = false;
        
        Main.PersonnalisationPasAPas.sequence = (Element) Main.CreationRegles.elementParId(Main.CreationRegles.lesSequences, CbEtapesActionPresentationGuidee.getSelectedItem().toString().substring(0, CbEtapesActionPresentationGuidee.getSelectedItem().toString().indexOf("_"))).clone();
        Main.PersonnalisationPasAPas.chargerInterface();
        Main.PersonnalisationPasAPas.setVisible(true);
    }//GEN-LAST:event_BtPersonnaliserMessagesPresentationGuideeActionPerformed

    private void BtMiseEnValeurPresentationGuideeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtMiseEnValeurPresentationGuideeActionPerformed
        Main.MiseEnValeurPasAPas.elementMiseEnValeur = elementMiseEnValeurEtape;
        Main.MiseEnValeurPasAPas.chargerInterface();
        Main.MiseEnValeurPasAPas.setVisible(true);
    }//GEN-LAST:event_BtMiseEnValeurPresentationGuideeActionPerformed

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
            java.util.logging.Logger.getLogger(CreationActions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreationActions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreationActions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreationActions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CreationActions().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ActionMessage2;
    private javax.swing.ButtonGroup ActionMessage3;
    private javax.swing.JTree ArbreActionAjoutComposant;
    private javax.swing.JTree ArbreActionInterface;
    private javax.swing.JTree ArbreActionMiseEnValeur;
    private javax.swing.JTree ArbreActionProfil;
    private javax.swing.JButton BtAfficherDescriptionInterfaceActionAjoutComposant;
    private javax.swing.JButton BtAfficherDescriptionInterfaceActionInterface;
    private javax.swing.JButton BtAfficherDescriptionInterfaceActionMiseEnValeur;
    private javax.swing.JButton BtAfficherDetailsActionAjoutComposant;
    private javax.swing.JButton BtAfficherDetailsActionMasquage;
    private javax.swing.JButton BtAfficherDetailsActionMessage;
    private javax.swing.JButton BtAfficherDetailsActionMiseEnValeur;
    private javax.swing.JButton BtAjouterSSActionAgentAnime;
    private javax.swing.JButton BtAnnulerActionAgentAnime;
    private javax.swing.JButton BtAnnulerActionAjoutComposant;
    private javax.swing.JButton BtAnnulerActionInterface;
    private javax.swing.JButton BtAnnulerActionMessage;
    private javax.swing.JButton BtAnnulerActionMiseEnValeur;
    private javax.swing.JButton BtAnnulerActionPasaPas;
    private javax.swing.JButton BtAnnulerActionPresentationGuidee;
    private javax.swing.JButton BtAnnulerActionProfil;
    private javax.swing.JButton BtAnnulerActionRessource;
    private javax.swing.JButton BtAnnulerSSActionAnimation;
    private javax.swing.JButton BtApercuActionAgentAnime;
    private javax.swing.JButton BtApercuActionAjoutComposant;
    private javax.swing.JButton BtApercuActionInterface;
    private javax.swing.JButton BtApercuActionMessage;
    private javax.swing.JButton BtApercuActionMiseEnValeur;
    private javax.swing.JButton BtApercuActionPasaPas;
    private javax.swing.JButton BtApercuActionPresentationGuidee;
    private javax.swing.JButton BtApercuActionRessource;
    private javax.swing.JButton BtCheminActionRessource;
    private javax.swing.JButton BtCouleurActionMasquage;
    private javax.swing.JButton BtCouleurActionMiseEnValeur;
    private javax.swing.JButton BtCouleurFondActionMessage;
    private javax.swing.JButton BtCreerEtapesActionPasaPas;
    private javax.swing.JButton BtCreerEtapesActionPresentationGuidee;
    private javax.swing.JButton BtEntourerCouleurActionMiseEnValeur;
    private javax.swing.JButton BtIconeBoutonActionAjoutComposant;
    private javax.swing.JButton BtIconeImageActionAjoutComposant;
    private javax.swing.JButton BtIconeLabelActionAjoutComposant;
    private javax.swing.JButton BtInclureActionMessage;
    private javax.swing.JButton BtInclureDifferentActionMessage;
    private javax.swing.JButton BtMiseEnValeurPasAPas;
    private javax.swing.JButton BtMiseEnValeurPresentationGuidee;
    private javax.swing.JButton BtModifierAgentActionMessage;
    private javax.swing.JButton BtModifierAgentActionMiseEnValeur;
    private javax.swing.JButton BtModifierDescriptionInterfaceActionAjoutComposant;
    private javax.swing.JButton BtModifierDescriptionInterfaceActionInterface;
    private javax.swing.JButton BtModifierDescriptionInterfaceActionMiseEnValeur;
    private javax.swing.JButton BtModifierEtapesActionPasaPas;
    private javax.swing.JButton BtModifierEtapesActionPresentationGuidee;
    private javax.swing.JButton BtModifierSSActionAnimation;
    private javax.swing.JButton BtModifierSymboleActionMiseEnValeur;
    private javax.swing.JButton BtPersonnaliserMessagesPasAPas;
    private javax.swing.JButton BtPersonnaliserMessagesPresentationGuidee;
    private javax.swing.JButton BtPoliceActionAjoutComposant;
    private javax.swing.JRadioButton BtRbPositionSourisAgentActionMessage;
    private javax.swing.JRadioButton BtRbPositionSourisPopupActionMessage;
    private javax.swing.JRadioButton BtTailleAutomatiquePopupActionMessage;
    private javax.swing.JRadioButton BtTailleManuellePopupActionMessage;
    private javax.swing.JButton BtValiderActionAgentAnime;
    private javax.swing.JButton BtValiderActionAjoutComposant;
    private javax.swing.JButton BtValiderActionInterface;
    private javax.swing.JButton BtValiderActionMessage;
    private javax.swing.JButton BtValiderActionMiseEnValeur;
    private javax.swing.JButton BtValiderActionPasaPas;
    private javax.swing.JButton BtValiderActionPresentationGuidee;
    private javax.swing.JButton BtValiderActionProfil;
    private javax.swing.JButton BtValiderActionRessource;
    private javax.swing.JButton BtValiderSSActionAnimation;
    private javax.swing.JComboBox CbActionActionInterface;
    private javax.swing.JComboBox CbChoixTypeAction;
    private javax.swing.JComboBox CbDirectionActionAjoutComposant;
    private javax.swing.JComboBox CbDirectionActionMiseEnValeur;
    private javax.swing.JComboBox CbDirectionActionMiseEnValeurAgent;
    private javax.swing.JComboBox CbEtapesActionPasaPas;
    private javax.swing.JComboBox CbEtapesActionPresentationGuidee;
    private javax.swing.JComboBox CbModeActionMessage;
    private javax.swing.JComboBox CbNiveauxActionModifierProfil;
    private javax.swing.JComboBox CbPersoActionAgentAnime;
    private javax.swing.JComboBox CbPersoActionMessage;
    private javax.swing.JComboBox CbPersoDifferentActionMessage;
    private javax.swing.JComboBox CbPositionHorizontaleAgentActionMessage;
    private javax.swing.JComboBox CbPositionHorizontalePopupActionMessage;
    private javax.swing.JComboBox CbPositionVerticaleAgentActionMessage;
    private javax.swing.JComboBox CbPositionVerticalePopupActionMessage;
    private javax.swing.JComboBox CbTypeActionAjoutComposant;
    private javax.swing.JComboBox CbTypeActionMasquage;
    private javax.swing.JComboBox CbTypeActionMiseEnValeur;
    private javax.swing.JComboBox CbTypeActionModifierProfil;
    private javax.swing.JComboBox CbTypeActionPasaPas;
    private javax.swing.JComboBox CbTypeActionRessource;
    private javax.swing.JComboBox CbTypeSSActionAnimation;
    private javax.swing.JCheckBox CheckDifferentActionMessage;
    private javax.swing.JCheckBox CheckDureeActionMiseEnValeurAgent;
    private javax.swing.JCheckBox CheckDureeActionMiseEnValeurColorer;
    private javax.swing.JCheckBox CheckDureeActionMiseEnValeurEntourer;
    private javax.swing.JCheckBox CheckDureeActionMiseEnValeurSymbole;
    private javax.swing.JCheckBox CheckEcritActionMessage;
    private javax.swing.JCheckBox CheckExpliquerEtapeActionPasaPas;
    private javax.swing.JCheckBox CheckExpliquerEtapeActionPresentationGuidee;
    private javax.swing.JCheckBox CheckExpliquerEtapeAutorisationActionPasaPas;
    private javax.swing.JCheckBox CheckExpliquerEtapeAutorisationActionPresentationGuidee;
    private javax.swing.JCheckBox CheckExpliquerEtapeTermineeActionPasaPas;
    private javax.swing.JCheckBox CheckIconeBoutonActionAjoutComposant;
    private javax.swing.JCheckBox CheckIconeLabelActionAjoutComposant;
    private javax.swing.JCheckBox CheckInfoBulleBoutonActionAjoutComposant;
    private javax.swing.JCheckBox CheckInterventionActionPasaPas;
    private javax.swing.JCheckBox CheckMessageApresActionPasaPas;
    private javax.swing.JCheckBox CheckMessageApresActionPresentationGuidee;
    private javax.swing.JCheckBox CheckMessageApresBilanActionPasaPas;
    private javax.swing.JCheckBox CheckMessageAvantActionPasaPas;
    private javax.swing.JCheckBox CheckMessageAvantActionPresentationGuidee;
    private javax.swing.JCheckBox CheckMessageAvantAutorisationActionPasaPas;
    private javax.swing.JCheckBox CheckMessageAvantAutorisationActionPresentationGuidee;
    private javax.swing.JCheckBox CheckMiseEnFormeActionMessage;
    private javax.swing.JCheckBox CheckMiseEnValeurActionPasaPas;
    private javax.swing.JCheckBox CheckOralActionMessage;
    private javax.swing.JCheckBox CheckProgressionActionPasaPas;
    private javax.swing.JCheckBox CheckTexteBoutonActionAjoutComposant;
    private javax.swing.JCheckBox CheckTimerActionPasaPas;
    private javax.swing.JCheckBox CheckTimerActionPresentationGuidee;
    private javax.swing.JLabel LbActionActionInterface;
    private javax.swing.JLabel LbActionActionModifierProfil;
    private javax.swing.JLabel LbAgentActionMessage;
    private javax.swing.JLabel LbArrondiActionMiseEnValeur;
    private javax.swing.JLabel LbCheminActionRessource;
    private javax.swing.JLabel LbChoixTypeAction;
    private javax.swing.JLabel LbComposantActionInterface;
    private javax.swing.JLabel LbContenuActionMessage;
    private javax.swing.JLabel LbCouleurActionMasquage;
    private javax.swing.JLabel LbCouleurActionMiseEnValeur;
    private javax.swing.JLabel LbCouleurFondActionMessage;
    private javax.swing.JLabel LbDirectionActionAjoutComposant;
    private javax.swing.JLabel LbDirectionActionMiseEnValeur;
    private javax.swing.JLabel LbDirectionActionMiseEnValeurAgent;
    private javax.swing.JLabel LbElementActionModifierProfil;
    private javax.swing.JLabel LbEloignementActionMiseEnValeur;
    private javax.swing.JLabel LbEntourerCouleurActionMiseEnValeur;
    private javax.swing.JLabel LbEpaisseurActionMiseEnValeur;
    private javax.swing.JLabel LbEtapesActionPasaPas;
    private javax.swing.JLabel LbEtapesActionPresentationGuidee;
    private javax.swing.JLabel LbEtatActionInterface;
    private javax.swing.JLabel LbExacteActionModifierProfil;
    private javax.swing.JLabel LbHauteurActionAjoutComposant;
    private javax.swing.JLabel LbHauteurFenetrePopupActionMessage;
    private javax.swing.JLabel LbHorizontaleSSActionAnimation;
    private javax.swing.JLabel LbIconeImageActionAjoutComposant;
    private javax.swing.JLabel LbIdActionAjoutComposant;
    private javax.swing.JLabel LbIdActionMiseEnValeur;
    private javax.swing.JLabel LbImagePersoActionAgentAnime;
    private javax.swing.JLabel LbLargeurActionAjoutComposant;
    private javax.swing.JLabel LbLargeurFenetrePopupActionMessage;
    private javax.swing.JLabel LbListeActionAgentAnime;
    private javax.swing.JLabel LbModeActionMessage;
    private javax.swing.JLabel LbNomAction;
    private javax.swing.JLabel LbOptionActionPasaPas;
    private javax.swing.JLabel LbOptionActionPresentationGuidee;
    private javax.swing.JLabel LbOptionEtapesActionPasaPas;
    private javax.swing.JLabel LbOptionEtapesActionPresentationGuidee;
    private javax.swing.JLabel LbPersoActionAgentAnime;
    private javax.swing.JLabel LbPersoActionMessage;
    private javax.swing.JLabel LbPersoDifferentActionMessage;
    private javax.swing.JLabel LbPointActionModifierProfil;
    private javax.swing.JLabel LbPoliceActionAjoutComposant;
    private javax.swing.JLabel LbPositionAgentActionMessage;
    private javax.swing.JLabel LbPositionHorizontaleAgentActionMessage;
    private javax.swing.JLabel LbPositionHorizontalePopupActionMessage;
    private javax.swing.JLabel LbPositionPopupActionMessage;
    private javax.swing.JLabel LbPositionVerticaleAgentActionMessage;
    private javax.swing.JLabel LbPositionVerticalePopupActionMessage;
    private javax.swing.JLabel LbSecondesActionPasaPas;
    private javax.swing.JLabel LbSecondesActionPresentationGuidee;
    private javax.swing.JLabel LbSelectionActionModifierProfil;
    private javax.swing.JLabel LbSourceActionModifierProfil;
    private javax.swing.JLabel LbSymboleActionMiseEnValeur;
    private javax.swing.JLabel LbSymboleActionMiseEnValeurAgent;
    private javax.swing.JLabel LbTailleFenetrePopupActionMessage;
    private javax.swing.JLabel LbTexteLabelActionAjoutComposant;
    private javax.swing.JLabel LbTitreFenetrePopupActionMessage;
    private javax.swing.JLabel LbTransparenceActionMasquage;
    private javax.swing.JLabel LbTransparenceActionMiseEnValeur;
    private javax.swing.JLabel LbTypeActionAjoutComposant;
    private javax.swing.JLabel LbTypeActionMasquage;
    private javax.swing.JLabel LbTypeActionMessage;
    private javax.swing.JLabel LbTypeActionMiseEnValeur;
    private javax.swing.JLabel LbTypeActionModifierProfil;
    private javax.swing.JLabel LbTypeActionPasaPas;
    private javax.swing.JLabel LbTypeActionRessource;
    private javax.swing.JLabel LbTypeSSActionAnimation;
    private javax.swing.JLabel LbUniteActionMiseEnValeurAgent;
    private javax.swing.JLabel LbUniteActionMiseEnValeurColorer;
    private javax.swing.JLabel LbUniteActionMiseEnValeurEntourer;
    private javax.swing.JLabel LbUniteActionMiseEnValeurSymbole;
    private javax.swing.JLabel LbValeurActionInterface;
    private javax.swing.JLabel LbVerticaleSSActionAnimation;
    private javax.swing.JLabel LbXAgentActionMessage;
    private javax.swing.JLabel LbXPopupActionMessage;
    private javax.swing.JLabel LbYAgentActionMessage;
    private javax.swing.JLabel LbYPopupActionMessage;
    private javax.swing.JList ListActionAgentAnime;
    private javax.swing.JList ListeActionPasaPas;
    private javax.swing.JList ListeActionPresentationGuidee;
    private javax.swing.JPanel PanelActionMasquage;
    private javax.swing.JPanel PanelActionMiseEnValeur;
    private javax.swing.JPanel PanelAgentActionMiseEnValeur;
    private javax.swing.JPanel PanelAutomatiserActionPasaPas;
    private javax.swing.JPanel PanelAutomatiserActionPresentationGuidee;
    private javax.swing.JPanel PanelBoutonActionAjoutComposant;
    private javax.swing.JPanel PanelColorerActionMiseEnValeur;
    private javax.swing.JPanel PanelContenuActionMessage;
    private javax.swing.JPanel PanelCouleurFondActionMessage;
    private javax.swing.JPanel PanelCreationAction;
    private javax.swing.JPanel PanelCreationActionAgentAnime;
    private javax.swing.JPanel PanelCreationActionAjoutComposant;
    private javax.swing.JPanel PanelCreationActionInterface;
    private javax.swing.JPanel PanelCreationActionMessage;
    private javax.swing.JPanel PanelCreationActionMiseEnValeur;
    private javax.swing.JPanel PanelCreationActionModifierProfil;
    private javax.swing.JPanel PanelCreationActionPasaPas;
    private javax.swing.JPanel PanelCreationActionPresentationGuidee;
    private javax.swing.JPanel PanelCreationActionRessource;
    private javax.swing.JPanel PanelDetailsActionAjoutComposant;
    private javax.swing.JPanel PanelDetailsAgentActionMessage;
    private javax.swing.JPanel PanelDetailsPopupActionMessage;
    private javax.swing.JPanel PanelEntourerActionMiseEnValeur;
    private javax.swing.JPanel PanelEstomperActionMasquage;
    private javax.swing.JPanel PanelEtatActionInterface;
    private javax.swing.JPanel PanelExacteActionModifierProfil;
    private javax.swing.JPanel PanelGuiderActionPasaPas;
    private javax.swing.JPanel PanelImageActionAjoutComposant;
    private javax.swing.JPanel PanelLabelActionAjoutComposant;
    private javax.swing.JPanel PanelModifierActionModifierProfil;
    private javax.swing.JPanel PanelPersoActionAgentAnime;
    private javax.swing.JPanel PanelPersoContenu1ActionMessage;
    private javax.swing.JPanel PanelPoliceActionAjoutComposant;
    private javax.swing.JPanel PanelSSActionAgentAnime;
    private javax.swing.JPanel PanelSymboleActionMiseEnValeur;
    private javax.swing.JPanel PanelTransparenceActionMasquage;
    private javax.swing.JPanel PanelValeurActionInterface;
    private javax.swing.JRadioButton RbChoixCouleurActionMasquage;
    private javax.swing.JRadioButton RbCouelruPereActionMasquage;
    private javax.swing.JRadioButton RbOffActionInterface;
    private javax.swing.JRadioButton RbOnActionInterface;
    private javax.swing.JRadioButton RbPositionCoordonneesAgentActionMessage;
    private javax.swing.JRadioButton RbPositionCoordonneesPopupActionMessage;
    private javax.swing.JRadioButton RbPositionEcranAgentActionMessage;
    private javax.swing.JRadioButton RbPositionEcranPopupActionMessage;
    private javax.swing.JComboBox SAjComboBoxIdentifiant;
    private javax.swing.JLabel SAjLabel3;
    private javax.swing.JLabel SAjLabel4;
    private javax.swing.JTextField SAjTextField3;
    private javax.swing.JScrollPane ScrollArbreActionAjoutComposant;
    private javax.swing.JScrollPane ScrollArbreActionInterface;
    private javax.swing.JScrollPane ScrollArbreActionMiseEnValeur;
    private javax.swing.JScrollPane ScrollArbreActionProfil;
    private javax.swing.JScrollPane ScrollDifferentActionMessage;
    private javax.swing.JScrollPane ScrollListActionAgenAnime;
    private javax.swing.JScrollPane ScrollListeActionPasaPas;
    private javax.swing.JScrollPane ScrollListeActionPresentationGuidee;
    private javax.swing.JSpinner SpinArrondiActionMiseEnValeur;
    private javax.swing.JSpinner SpinDureeActionMiseEnValeurAgent;
    private javax.swing.JSpinner SpinDureeActionMiseEnValeurColorer;
    private javax.swing.JSpinner SpinDureeActionMiseEnValeurEntourer;
    private javax.swing.JSpinner SpinDureeActionMiseEnValeurSymbole;
    private javax.swing.JSpinner SpinEloignementActionMiseEnValeur;
    private javax.swing.JSpinner SpinEpaisseurActionMiseEnValeur;
    private javax.swing.JSpinner SpinExacteActionModifierProfil;
    private javax.swing.JSpinner SpinHauteurActionAjoutComposant;
    private javax.swing.JSpinner SpinHauteurFenetrePopupActionMessage;
    private javax.swing.JSpinner SpinLargeurActionAjoutComposant;
    private javax.swing.JSpinner SpinLargeurFenetrePopupActionMessage;
    private javax.swing.JSpinner SpinModifierActionModifierProfil;
    private javax.swing.JSpinner SpinTimerActionPasaPas;
    private javax.swing.JSpinner SpinTimerActionPresentationGuidee;
    private javax.swing.JSpinner SpinTransparenceActionMasquage;
    private javax.swing.JSpinner SpinTransparenceActionMiseEnValeur;
    private javax.swing.JSpinner SpinXAgentActionMessage;
    private javax.swing.JSpinner SpinXPopupActionMessage;
    private javax.swing.JSpinner SpinYAgentActionMessage;
    private javax.swing.JSpinner SpinYPopupActionMessage;
    private javax.swing.JTextField TxtCheminActionRessource;
    private javax.swing.JTextField TxtComposantActionInterface;
    private javax.swing.JTextArea TxtDifferentActionMessage;
    private javax.swing.JTextField TxtElementActionModifierProfil;
    private javax.swing.JTextField TxtHorizontaleSSActionAnimation;
    private javax.swing.JTextField TxtIdActionAjoutComposant;
    private javax.swing.JTextField TxtIdActionMiseEnValeur;
    private javax.swing.JTextField TxtInfoBulleBoutonActionAjoutComposant;
    private javax.swing.JTextField TxtNomAction;
    private javax.swing.JTextField TxtSourceActionModifierProfil;
    private javax.swing.JTextField TxtTexteBoutonActionAjoutComposant;
    private javax.swing.JTextField TxtTexteLabelActionAjoutComposant;
    private javax.swing.JTextField TxtTitreFenetreActionMessage;
    private javax.swing.JTextField TxtValeurActionInterface;
    private javax.swing.JTextField TxtVerticaleSSActionAnimation;
    private javax.swing.ButtonGroup actionMessage;
    // End of variables declaration//GEN-END:variables
}
