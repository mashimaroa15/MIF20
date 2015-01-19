/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import net.atlanticbb.tantlinger.shef.HTMLEditorPane;
import net.atlanticbb.tantlinger.ui.text.SourceCodeEditor;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jsoup.Jsoup;

/**
 *
 * @author Blandine
 */
public class CreationRegles extends javax.swing.JFrame {

    //modèle et nombre de lignes dans la table des conditions
    public DefaultTableModel  modelCondition = new DefaultTableModel();
    public DefaultTableModel  modelAction = new DefaultTableModel();
    public DefaultTableModel  modelRegle = new DefaultTableModel();
    public DefaultTableModel  modelEvenement = new DefaultTableModel();
    
    public int idCondition=0;
    public int idAction=0;
    public int idRegle=0;
    public int idSequence=0;
    public int idEvenement=0;
    public int idComposantAjoute=0;
    public ArrayList<Element> lesActions=new ArrayList();
    public ArrayList<Element> lesConditions=new ArrayList();
    public ArrayList<Element> lesEvenements=new ArrayList();
    private ArrayList<Element> lesRegles=new ArrayList();
    public ArrayList<Element> lesSequences=new ArrayList();
    public ArrayList<Element> lesComposants=new ArrayList();
    private String nom;
    private String type;
    private String objet;
    private String valeur;
    private String description;
    private String evenement;
    private String condition;
    private String action;
    private String evenementFin = "événement de fin";
    public String messager="messager";
    public String agentAnime="agentAnime";   
    public String personnageMiseEnValeur;
    public String personnageMessage;
    public String cheminEtInterface;
    private String declencherActions;
    private String alorsDeclencher;
    public String siValeurEgaleA;
    public String siChoixEgaleA;
    public String siDernierChoixEgaleA = "dernier choix ";
    private String si;
    public String en;
    public String superieureA;
    public String inferieureA;
    public String duree;
    public String stringValeur;
    public String commencantPar;
    public String contenant;
    public String terminantPar;
    public String egaleA;
    public String stringVrai;
    public String stringFaux;
    public String valeurCompriseEntre;
    public String stringEt;
    public TreeMap<String, String> listeTypesEvenements=new TreeMap<String, String>();
    /*private String[] listeTypes={"actionPerformed","mouseDragged","mouseMoved","mousePressed","mouseClicked","mouseReleased","mouseEntered","mouseExited",
                                "keyTyped","keyReleased","keyPressed","focusGained","focusLost","menuCanceled","menuDeselected","menuSelected"};*/
    
    public HashMap listeCommentairesComposants=new HashMap(); //va contenir pour chaque id la description ajoutée par le concepteur (s'il y en a une)
    public boolean nouvelleAssistance=true;
    
    private boolean modifRegle=false;
    public boolean modifConditionProfil=false;
    public boolean modifConditionHistorique=false;
    public boolean modifConditionConsultation=false;
    public boolean modifConditionContexte=false;
    public boolean modifActionMiseEnValeur=false;
    public boolean modifActionAgentAnime=false;
    public boolean modifActionModifierProfil=false;
    public boolean modifActionPasaPas=false;
    public boolean modifActionPresentationGuidee=false;
    public boolean modifActionInterface=false;
    public boolean modifActionRessource=false;
    public boolean modifActionMessage=false;
    public boolean modifConditionCombinaison=false;
    public boolean modifConditionTraces=false;
    public boolean modifActionAjoutComposant=false;
    public boolean modifEvenementActionElem=false;
    public boolean modifEvenementTimerFin=false;
    public boolean modifEvenementTimerRelatif=false;
    public boolean modifEveSA=false;
    public int ligneModifRegle;
    public int ligneModifCondition;
    public int ligneModifAction;
    public int ligneModifEvenement;
    
    public String conditionProfil="profil";
    public String conditionHistorique="historique";
    public String conditionContexte="contexte";
    public String conditionTraces="traces";
    public String conditionConsultation="consultation";
    public String conditionCombinaison="combinaison";
    
    public String id_echelle;
    public String itemConditionProfil;
    public String itemConditionTraces;
    public String itemConditionHistorique;
    public String itemConditionContexte;
    public String itemConditionConsultation;
    public String itemConditionCombinaison;
    
    public String itemTypeActionMessage;
    public String itemTypeActionModificationProfil;
    public String itemTypeActionPasAPas;
    public String itemTypeActionActionInterface;
    public String itemTypeActionRessource;
    public String itemTypeActionAnimation;
    public String itemTypeActionMiseEnValeur;
    public String itemTypeActionMasquage;
    public String itemTypeActionAjoutComposant;
    public String itemTypeActionPresentationGuidee ="présentation guidée";
    
    public String stringTypeActionMessage = "message";
    public String stringTypeActionModificationProfil = "modificationdu profil de l'utilisateur";
    public String stringTypeActionPasAPas = "pas à pas";
    public String stringTypeActionPresentationGuidee = "presentation guidee";
    public String stringTypeActionActionInterface = "action sur l'interface";
    public String stringTypeActionRessource = "ressoure externe";
    public String stringTypeActionAnimation ="animation";
    public String stringTypeActionMiseEnValeur="mise en valeur";
    public String stringTypeActionMasquage = "masquage";
    public String stringTypeActionAjoutComposant = "ajout composant";
    
    public String stringDescriptionMettreEnValeurComposant;
    public String stringDescriptionEntourerComposant;
    public String stringDescriptionColorerComposant;
    public String stringDescriptionSymboleComposant;
    public String stringDescriptionAgentComposant;
    public String stringDescriptionEstomperComposant;
    public String stringDescriptionOcculterComposant;
    
    public String itemTypeComposantAjouteBouton;
    public String itemTypeComposantAjouteLabel;
    public String itemTypeComposantAjouteImage;
    
    public String stringTypeComposantAjouteBouton = "bouton";
    public String stringTypeComposantAjouteLabel = "label";
    public String stringTypeComposantAjouteImage = "image";
    
    public String attributTypeEve = "typeEve";
    public String attributSousTypeEve = "sous-typeEve";
    public String attributTypeAjoute = "typeAjoute";
    public String attributType = "type";
    public String attributSousType = "sous-type";
    public String attributCouleur = "couleur";
    public String attributTransparence = "transparence";
    public String attributArrondi = "arrondi";
    public String attributEpaisseur = "epaisseur";
    public String attributEloignement = "eloignement";
    public String attributId = "id";
    public String attributNom = "nom";
    public String attributValeur = "valeur";
    public String attributSymbole = "symbole";
    public String attributDirection = "direction";
    public String attributAgent = "agent";
    public String attributPersonnage = "personnage";
    public String attributComposant = "composant";
    public String attributAction = "action";
    public String attributCondition = "condition";
    public String attributTexte = "texte";
    public String attributSource = "source";
    public String attributTitre = "titre";
    public String attributOptions = "options";
    public String attributOption = "option";
    public String attributLabel = "label";
    public String attributDemande = "demande";
    public String attributOui = "oui";
    public String attributNon = "non";
    public String attributBilan = "bilan";
    public String attributVocal = "vocal";
    public String attributTextuel = "textuel";
    public String attributEvenement = "evenement";
    public String attributEvenements = "evenements";
    public String attributEvenement_declencheur = "evenement_declencheur";
    public String attributEvenement_de_fin = "evenement_de_fin";
    public String attributPropriete = "propriete";
    public String attributIdComp = "idComp";
    public String attributMetadonnees = "metadonnees";
    public String attributRegle = "regle";
    public String attributRegles = "regles";
    public String attributActions = "actions";
    public String attributConditions = "conditions";
    public String attributSequences = "sequences";
    public String attributSequence = "sequence";
    public String attributDuree = "duree";
    public String attributAlternatives = "alternatives";
    public String attributAlternative = "alternative";
    public String attributInfos_echelle = "infos_echelle";
    public String attributId_echelle = "id_echelle";
    public String attributModification = "modification";
    public String attributChemin = "chemin";
    public String attributNumerique = "numerique";
    public String attributTextuelle = "textuelle";
    public String attributBorne_inf = "borne_inf";
    public String attributBorne_sup = "borne_sup";
    public String attributApres = "apres";
    public String attributAvant = "avant";
    public String attributMessage = "message";
    public String attributIdentifiant = "identifiant";
    public String attributPense = "pense";
    public String attributAnimation = "animation";
    public String attributParole = "parole";
    public String attributPensee = "pensée";
    public String attributDéplacement = "déplacement";
    public String attributDeplacement = "deplacement";
    public String attributVitesse = "vitesse";
    public String attributSousAction = "sousaction";
    public String attributPosition_x = "position_x";
    public String attributPosition_y = "position_y";
    public String attributObjet = "objet";
    public String attributUnite = "unite";
    public String attributPortee = "portee";
    public String attributSeance = "seance";
    public String attributGlobale = "globale";
    public String attributDescriptionAjoutee = "descriptionAjoutee";
    public String attributForumle = "formule";
    public String attributHorizontal = "horizontal";
    public String attributVertical = "vertical";
    public String attributTaille = "taille";
    public String attributStyle = "style";
    public String attributFond = "fond";
    public String attributPolice = "police";
    public String attributPoliceOptions = "policeOptions";
    public String attributPoliceMessage = "policeMessage";
    public String attributIcone = "icone";
    public String attributInfobulle= "infobulle";
    public String attributHauteur = "hauteur";
    public String attributLargeur= "largeur";
    public String attributIdEve="idEve";
    public String attributLancementAssistance= "lancementAssistance";
    public String attributLancementRegle="lancementRegle";
    public String attributTimer = "timer";
    public String attributSousObjet = "sousObjet";
    
    public String titrePanelSousActionAnimation;
    public String itemDeplacementActionAnimation;
    public String itemParoleActionAnimation;
    public String itemPensseActionAnimation;
    public String itemAnimationActionAnimation;
    public String itemPositionVerticaleActionAnimation;
    public String itemPositionHorizontaleActionAnimation;
    public String itemTexteActionAnimation;
    public String itemVitesseActionAnimation;
    
    public String tooltipAfficherDetailsMiseEnValeur = "Afficher les détails de la mise en valeur";
    public String tooltipMasquerDetailsMiseEnValeur = "Masquer les détails de la mise en valeur";
    
    public boolean typeColorer=true;
    public boolean typeEntourer=false;
    public boolean typeSymbole=false;
    public boolean typeAgent=false;
    
    public String itemEstomper;
    public String itemOcculter;
    public String itemColorer;
    public String itemEntourer;
    public String itemSymbole;
    public String attributEstomper="estomper";
    public String attributOcculter="occulter";
    public String attributColorer="colorer";
    public String attributEntourer="entourer";
    
    public String fichierSymbole;
    
    public String itemOuvrirFichierActionRessource;
    public String itemOuvrirURLActionRessource;
    public String itemOuvrirAppliActionRessource;
    public String itemCheminActionRessource;
    
    public String itemPopupSynthese="pop-up + synthèse vocale";
    public String itemPopup="pop-up";
    public String itemSynthese="synthèse vocale";
    public String itemAgentAnime="agent animé";
    public String attributAgentAnime="agent animé";
    
    public String dernierDeclenchement;
    public String nombreDeclenchement;
    
    public String dureeTotaleConditionTraces;
    public String dureeDepuisConditionTraces;
    public String nbOccurrencesConditionTraces;
    public String nbEvenementsDepuisConditionTraces;
    public String presenceConditionTraces;
    
    public String stringParLaGauche = "par la gauche";
    public String stringParLaDroite = "par la droite";
    public String stringParLeHaut = "par le haut";
    public String stringParLeBas = "par le bas";
    public String itemParLaGauche;
    public String itemParLaDroite;
    public String itemParLeHaut;
    public String itemParLeBas;
    
    public String attributCentre = "centre";
    public String attributGauche = "gauche";
    public String attributDroite = "droite";
    public String attributBas = "bas";
    public String attributHaut = "haut";
    public String itemCentre;
    public String itemGauche;
    public String itemDroite;
    public String itemBas;
    public String itemHaut;
    
    public String itemCreerUnNouvelEvenement = "créer un nouvel événement...";
    public String itemLancementAssistance = "Lancement de l'assistance";
    public String itemLancementRegle = "Lancement par une autre règle";
    public String itemAucun = "Aucun";
    public String itemAucune = "Aucune";
    public String itemCreerUneNouvelleCondition = "créer une nouvelle condition...";
    public String itemCreerUneNouvelleAction = "créer une nouvelle action...";
    
    public String stringSurLeComposant="sur le composant";
    public String stringActionUtilisateur="action de l'utilisateur";
    public String stringTimerFixe="durée fixe";
    public String stringTimerRelatif="durée relative";
    public String stringEveSA="événement d'assistance";
    
    public String attributActionUtilisateur="action utilisateur";
    public String attributEveSA="evenement assistance";
    public String attributTimerFixe="timer fixe";
    public String attributTimerRelatif="timer relatif";    
    
    public String baliseprenom = "%prenom%";
    public String balisenom = "%nom%";
    private static String DIR_EXEMPLE = "Parametres/Exemple/";
    private static String DIR_MESSAGER = "Parametres/Assistants_epiphytes/MessagerAmeliore/";
    
    public String itemAvecPrenom;
    public String itemAvecNom;
    public String itemAvecElementProfil;
    
    public String attributAucuneAction="aucune action";
    public String attributAucuneRegle="aucune regle";
    public String attributAucuneRegleAction="aucune regle/action";
    
    public String stringAucuneAction="sans action délcenchée";
    public String stringAucuneRegle="sans regle déclenchée";
    public String stringAucuneRegleAction="sans regle ni action déclenchée";
    
    public String attributAbsenceEvenement="absence evenement";
    public String attributAucunClic = "aucun clic";
    public String attributAucunDeplacementSouris = "aucun mouvement";
    
    public String stringAbsenceEvenement="sans l'événement";
    public String stringAucunClic = "sans clic";
    public String stringAucunDeplacementSouris = "sans déplacement de la souris";
    public String srtingAucunDeplacementSouris = "sans mouvement de la souris";
    
    private final String ACTION_XML = "Action.xml";
    
    public int indexSousActionModifier;    
    
    public String exact;
    public String modifier;
    public String points;
    public String niveaux;
    public String id_echelleActionProfil;
    
    public Map listeProprietes= new HashMap();
    
    public String itemGuide;
    public String itemAutomatise;
    public String attributGuide="guidé";
    public String attributAutomatise="automatisé";
    
    public DefaultListModel listModel = new DefaultListModel();
    
    public String invoke;
    public String select;
    public String setFocus;
    public String setValue;
    public String toggle;
    
    public String valeurTextuelle;
    public String valeurNumerique;       
    public String estSelectionne;
    public String aLeFocus;      
    public String estEditable;       
    public String estActif;
    public String nbColonnes;
    public String nbLignes;
    public String valeurMax;
    public String valeurMin;
    public String estEtendu;
    public String estAuPremierPlan;
    
    public String messageTextuel="textuel";
    public String messageVocal="vocal";
    public String messageTextuelVocal="textuel_vocal";
    
    public String assistantMessager="messager";
    public String miseEnFormeAvancee;
    public HTMLEditorPane editor;
    
    public int parentheseOuverte=0;
    
    public boolean afficherDescriptionComplete=false;
    public boolean afficherDetailsMiseEnValeur=false;
    public boolean afficherDetailsMasquage=false;
    public boolean afficherDetailsMessage=false;
    public boolean afficherDetailsConsultation=false;
    
    public String stringComposant;
    public String toolTip1BtAfficherDescription;
    public String toolTip2BtAfficherDescription;
    
    public String itemSecondes;
    public String itemMinutes;
    public String itemHeures;
    public String itemJours;
    public String itemSeances;
    
    public String attributSecondes = "secondes";
    public String attributMinutes ="minutes";
    public String attributHeures = "heures";
    public String attributJours = "jours";
    public String attributSeances = "seances";
    
    public String stringPresenter = "Présenter ";
    private String stringCliquerSur;
    private String stringComposantIdentifiant;
    private String stringSelectionner;
    private String stringDeselectionner;
    private String stringPasserA;
    private String stringValeurDu;
    private String stringValeurDe;
    private String stringDonnerFocusA;
    private String stringDonnerFocusAu;
    
    public String stringIntitule;
    
    public String itemDeclenchement="déclenchement de";
    public String itemFin="fin de";
    public String attributDeclenchement="declenchement";
    public String attributFin="fin";
    
    /**
     * Creates new form CreationRegles
     */
    public CreationRegles() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        //les tables : séléction d'une ligne max à la fois
        TableRegles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableActions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableConditions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        this.setLayout(null);
        this.setBounds(150, 50, 1250, 750);
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/icone_editeur.png"));
        this.setIconImage(icon);
        LbTitre.setBounds(350, 0, 370, 30);
        LbNomLogiciel.setBounds(720, 0, 300, 30);
        
        BtRetour.setBounds(5, 5, 150, 24);
        BtSuivant.setBounds(this.getWidth()-170, 5, 150, 24);
        
        //__________________________________________________création d'une règle______________________________________________________________________
        PanelCreationRegle.setBounds(2, 200, this.getWidth()-22, 330);
        PanelCreationRegle.setLayout(null);
        LbRegle.setBounds(10, 5, 170, 24);
        TxtRegle.setBounds(150, 5, 60, 24);
        LbEvenementDeclencheur.setBounds(10, 35, 230, 24);
        CbEvenementDeclencheur.setBounds(10, 60, 200, 24);
        
        LbCondition.setBounds(240, 35, 300, 24);
        CbChoixConditionRegle.setBounds(240, 60, 200, 24);
        
        BtAjoutAlternativeRegle.setBounds(240, 130, 50, 24);
        BtSupprimeAlternativeRegle.setBounds(300, 130, 50, 24);
        
        LbActions.setBounds(570, 35, 300, 24);
        PanelActionsRegle.setBounds(570, 60, 410, 30);        
        PanelActionsRegle.setLayout(null);
        PanelActionsRegle.setBackground(PanelCreationRegle.getBackground());
        
        PanelAlternativesRegle.setBounds(240, 90, 760, 190);        
        PanelAlternativesRegle.setLayout(null);
        PanelAlternativesRegle.setBackground(PanelCreationRegle.getBackground());
        
        LbEvenementFin.setBounds(1000, 35, 230, 24);
        CbEvenementFin.setBounds(1000, 60, 200, 24);
        
        BtValiderRegle.setBounds(PanelCreationRegle.getWidth()-200, PanelCreationRegle.getHeight()-30, 90, 24);
        BtAnnulerRegle.setBounds(PanelCreationRegle.getWidth()-100, PanelCreationRegle.getHeight()-30, 90, 24);
        
        /*
        BtValiderRegle.setBounds(PanelCreationRegle.getWidth()/2-160, PanelCreationRegle.getHeight()-40, 150, 30);
        BtAnnulerRegle.setBounds(PanelCreationRegle.getWidth()/2+10, PanelCreationRegle.getHeight()-40, 150, 30);
         */
        
        //______________________________________la table règles_____________________________________________
        PanelRegles.setLayout(null);
        PanelRegles.setBounds(2, 35, this.getWidth()-22, 160);   //PanelRegles.setBounds(2, 55, 500, 160);
        LbRegles.setBounds((PanelRegles.getWidth()-150)/2, 0, 150, 30);        
        ScrollTableRegles.setBounds(10, 30, PanelRegles.getWidth()-15, PanelRegles.getHeight()-35); 
        
        /*BtAjoutRegle.setBounds(PanelRegles.getWidth()/2-200, PanelRegles.getHeight()-35, 120, 30);
        BtModifierRegle.setBounds(PanelRegles.getWidth()/2-60, PanelRegles.getHeight()-35, 120, 30);
        BtSupprRegle.setBounds(PanelRegles.getWidth()/2+80, PanelRegles.getHeight()-35, 120, 30);*/
        
        BtModifierRegle.setBounds(PanelRegles.getWidth()-80, 5, 30, 24);
        BtSupprRegle.setBounds(PanelRegles.getWidth()-40, 5, 30, 24);

        BtModifierRegle.setText("");
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/modifierPetite.png"));
        BtModifierRegle.setIcon(new ImageIcon(icon));
        BtSupprRegle.setText("");
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/poubelle3.png"));
        BtSupprRegle.setIcon(new ImageIcon(icon));
        
        //______________________________________la table événements
        PanelEvenements.setLayout(null);
        PanelEvenements.setBounds(2, this.getHeight()-210, 420, 160);   //PanelRegles.setBounds(2, 55, 500, 160);
        LbEvenement.setBounds(10, 0, 150, 30);        
        ScrollTableEvenements.setBounds(10, 30, PanelEvenements.getWidth()-15, PanelEvenements.getHeight()-35); 
        
        /*BtAjoutRegle.setBounds(PanelRegles.getWidth()/2-200, PanelRegles.getHeight()-35, 120, 30);
        BtModifierRegle.setBounds(PanelRegles.getWidth()/2-60, PanelRegles.getHeight()-35, 120, 30);
        BtSupprRegle.setBounds(PanelRegles.getWidth()/2+80, PanelRegles.getHeight()-35, 120, 30);*/
        
        BtAjoutEvenement.setBounds(PanelEvenements.getWidth()-120, 5, 30, 24);
        BtModifierEvenement.setBounds(PanelEvenements.getWidth()-80, 5, 30, 24);
        BtSupprEvenement.setBounds(PanelEvenements.getWidth()-40, 5, 30, 24);
        
        BtAjoutEvenement.setText("");
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusPetit.png"));
        BtAjoutEvenement.setIcon(new ImageIcon(icon));
        BtModifierEvenement.setText("");
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/modifierPetite.png"));
        BtModifierEvenement.setIcon(new ImageIcon(icon));
        BtSupprEvenement.setText("");
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/poubelle3.png"));
        BtSupprEvenement.setIcon(new ImageIcon(icon));
        
        //___________________________________________________création d'une condition__________________________________________________________________        
        //____________________________________________la table condition___________________________
        PanelConditions.setLayout(null);  
        PanelConditions.setBounds(425, this.getHeight()-210, 400, 160);
        LbConditions.setBounds(10, 0, 250, 30);
        ScrollTableConditions.setBounds(10, 30, PanelConditions.getWidth()-15, PanelConditions.getHeight()-35);
        
        BtAjoutCondition.setBounds(PanelConditions.getWidth()-120, 5, 30, 24);
        BtModifierCondition.setBounds(PanelConditions.getWidth()-80, 5, 30, 24);
        BtSupprCondition.setBounds(PanelConditions.getWidth()-40, 5, 30, 24);
        
        BtAjoutCondition.setText("");
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusPetit.png"));
        BtAjoutCondition.setIcon(new ImageIcon(icon));
        BtModifierCondition.setText("");
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/modifierPetite.png"));
        BtModifierCondition.setIcon(new ImageIcon(icon));
        BtSupprCondition.setText("");
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/poubelle3.png"));
        BtSupprCondition.setIcon(new ImageIcon(icon));
        
        //____________________________________________________ creation d'une action d'assistance ______________________________________________________________       
        //_________________________________________la table action_____________________________________________       
        PanelActions.setLayout(null);
        PanelActions.setBounds(828, this.getHeight()-210, 400, 160);
        LbAssistance.setBounds(10, 0, 140, 30);
        ScrollTableActions.setBounds(10, 30, PanelActions.getWidth()-15, PanelActions.getHeight()-35);
        
        BtAjoutAction.setBounds(PanelActions.getWidth()-120, 5, 30, 24);
        BtModifierAction.setBounds(PanelActions.getWidth()-80, 5, 30, 24);
        BtSupprAction.setBounds(PanelActions.getWidth()-40, 5, 30, 24);
        
        BtAjoutAction.setText("");
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusPetit.png"));
        BtAjoutAction.setIcon(new ImageIcon(icon));
        BtModifierAction.setText("");
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/modifierPetite.png"));
        BtModifierAction.setIcon(new ImageIcon(icon));
        BtSupprAction.setText("");
        icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/poubelle3.png"));
        BtSupprAction.setIcon(new ImageIcon(icon));
    }
    
    public void chargerInterface()
    {        
        idCondition=0;
        idAction=0;
        idRegle=0;
               
        lesEvenements=new ArrayList();
        lesActions=new ArrayList();
        lesConditions=new ArrayList();
        lesRegles=new ArrayList();
        modifRegle=false;
        modifConditionProfil=false;
        modifConditionHistorique=false;
        modifActionMiseEnValeur=false;
        modifActionMessage=false;
        modifActionAgentAnime=false;
        modifActionModifierProfil=false; 
        
        cheminEtInterface=Main.Cste.cheminDescriptions+Main.Cste.logiciel+"/"+Main.Cste.descriptionInterface;
        
        chargerLangue();
        creerListeTypesEvenements();
        
        LbNomLogiciel.setText(Main.Cste.logiciel);
        
        Main.ModificationInterface.chargerInterface();
        Main.CreationEvenements.chargerInterface();
        
        ouvrirComposants();
       
        //__________________________________________________création d'une règle______________________________________________________________________        
        TxtRegle.setText("R"+idRegle);  
        
        creerListeCommentairesComposants();        
        chargerCbChoixConditionRegle();      
 
        //______________________________________la table règles_____________________________________________               
        modelRegle = new DefaultTableModel();
        modelRegle.addColumn(nom);
        modelRegle.addColumn(evenement);
        modelRegle.addColumn(condition);
        modelRegle.addColumn(action);
        modelRegle.addColumn(evenementFin);
        
        TableRegles.setModel(modelRegle);
        TableRegles.getTableHeader().setReorderingAllowed(false);
        
        TableRegles.getColumn(nom).setMinWidth(40);
        TableRegles.getColumn(nom).setMaxWidth(40);
        TableRegles.getColumn(evenement).setMinWidth(240);
        TableRegles.getColumn(evenement).setMaxWidth(240);
        TableRegles.getColumn(condition).setMinWidth(60);
        TableRegles.getColumn(condition).setMaxWidth(60);
        TableRegles.getColumn(evenementFin).setMinWidth(240);
        TableRegles.getColumn(evenementFin).setMaxWidth(240);
        
        //___________________________________________________création d'un évévenement__________________________________________________________________                           
        //____________________________________________la table condition___________________________
        modelEvenement = new DefaultTableModel();
        modelEvenement.addColumn(nom);
        modelEvenement.addColumn(type);
        modelEvenement.addColumn(description);
        TableEvenements.setModel(modelEvenement);
        TableEvenements.getTableHeader().setReorderingAllowed(false);

        TableEvenements.getColumn(nom).setMinWidth(40);
        TableEvenements.getColumn(nom).setMaxWidth(40);
        TableEvenements.getColumn(type).setMinWidth(120);
        TableEvenements.getColumn(type).setMaxWidth(120);
 
        //___________________________________________________création d'une condition__________________________________________________________________                           
        //____________________________________________la table condition___________________________
        modelCondition = new DefaultTableModel();
        modelCondition.addColumn(nom);
        modelCondition.addColumn(type);
        modelCondition.addColumn(objet);
        modelCondition.addColumn(valeur);
        TableConditions.setModel(modelCondition);
        TableConditions.getTableHeader().setReorderingAllowed(false);

        TableConditions.getColumn(nom).setMinWidth(40);
        TableConditions.getColumn(nom).setMaxWidth(40);
        TableConditions.getColumn(type).setMinWidth(80);
        TableConditions.getColumn(type).setMaxWidth(80);


        //____________________________________________________ creation d'une action d'assistance ______________________________________________________________                
        //_________________________________________la table action_____________________________________________ 
        modelAction = new DefaultTableModel();
        modelAction.addColumn(nom);
        modelAction.addColumn(type);
        modelAction.addColumn(description);
        TableActions.setModel(modelAction);
        TableActions.getTableHeader().setReorderingAllowed(false);

        TableActions.getColumn(nom).setMinWidth(40);
        TableActions.getColumn(nom).setMaxWidth(40);
        TableActions.getColumn(type).setMinWidth(100);
        TableActions.getColumn(type).setMaxWidth(100);
        
        chargerCbChoixConditionRegle();
        chargerEvenementDeclencheur();
        chargerEvenementFin();
    }
    
    public void chargerLangue(){
        XMLFonctions.OuvrirXML(Main.Cste.fichierInterfaceEditeur);
        Element courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("Titre").getChild(Main.Cste.langue);
        Element courant2= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("Titre").getChild(Main.Cste.langue);
        this.setTitle(courant.getText()+courant2.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbTitre").getChild(Main.Cste.langue);
        LbTitre.setText(courant.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("nom").getChild(Main.Cste.langue);
        nom= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("type").getChild(Main.Cste.langue);
        type= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("objet").getChild(Main.Cste.langue);
        objet= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("valeur").getChild(Main.Cste.langue);
        valeur= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("description").getChild(Main.Cste.langue);
        description= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("evenement").getChild(Main.Cste.langue);
        evenement= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("condition").getChild(Main.Cste.langue);
        condition= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("action").getChild(Main.Cste.langue);
        action= courant.getText();    
        
        courant= (Element) XMLFonctions.racine.getChild("ActionModifierProfil").getChild("exact").getChild(Main.Cste.langue);
        exact= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ActionModifierProfil").getChild("modifier").getChild(Main.Cste.langue);
        modifier= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ActionModifierProfil").getChild("points").getChild(Main.Cste.langue);
        points= courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("ActionModifierProfil").getChild("niveaux").getChild(Main.Cste.langue);
        niveaux= courant.getText();
        
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("tooltip1BtAfficherDescriptionInterface").getChild(Main.Cste.langue);
        toolTip1BtAfficherDescription = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("tooltip2BtAfficherDescriptionInterface").getChild(Main.Cste.langue);
        toolTip2BtAfficherDescription = courant.getText();
        
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("itemSecondes").getChild(Main.Cste.langue);
        itemSecondes = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("itemMinutes").getChild(Main.Cste.langue);
        itemMinutes = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("itemHeures").getChild(Main.Cste.langue);
        itemHeures = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("itemJours").getChild(Main.Cste.langue);
        itemJours = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("itemSeances").getChild(Main.Cste.langue);
        itemSeances = courant.getText();
        
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("stringCliquerSur").getChild(Main.Cste.langue);
        stringCliquerSur = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("stringComposantIdentifiant").getChild(Main.Cste.langue);
        stringComposantIdentifiant = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("stringSelectionner").getChild(Main.Cste.langue);
        stringSelectionner = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("stringDeselectionner").getChild(Main.Cste.langue);
        stringDeselectionner = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("stringPasserA").getChild(Main.Cste.langue);
        stringPasserA = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("stringValeurDu").getChild(Main.Cste.langue);
        stringValeurDu = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("stringValeurDe").getChild(Main.Cste.langue);
        stringValeurDe = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("stringDonnerFocusA").getChild(Main.Cste.langue);
        stringDonnerFocusA = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("stringDonnerFocusAu").getChild(Main.Cste.langue);
        stringDonnerFocusAu = courant.getText();
        
        courant= (Element) XMLFonctions.racine.getChild("ModificationInterface").getChild(attributComposant).getChild(Main.Cste.langue);
        stringComposant = courant.getText();
        
        //___________________________________________________le table des regles______________________________________________________
        /*courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAjout").getChild(Main.Cste.langue);
        BtAjoutRegle.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtModif").getChild(Main.Cste.langue);
        BtModifierRegle.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtSuppr").getChild(Main.Cste.langue);
        BtSupprRegle.setText(courant.getText());*/
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbRegles").getChild(Main.Cste.langue);
        LbRegles.setText(courant.getText());
        
        //___________________________________________________le table des conditions______________________________________________________
        /*courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAjout").getChild(Main.Cste.langue);
        BtAjoutCondition.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtModif").getChild(Main.Cste.langue);
        BtModifierCondition.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtSuppr").getChild(Main.Cste.langue);
        BtSupprCondition.setText(courant.getText());*/
        
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbConditions").getChild(Main.Cste.langue);
        LbConditions.setText(courant.getText());
        
        //___________________________________________________le table des actions______________________________________________________
        /*courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAjout").getChild(Main.Cste.langue);
        BtAjoutAction.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtModif").getChild(Main.Cste.langue);
        BtModifierAction.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtSuppr").getChild(Main.Cste.langue);
        BtSupprAction.setText(courant.getText());*/
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbAssistance").getChild(Main.Cste.langue);
        LbAssistance.setText(courant.getText()); 
        
        
        //___________________________________________________la création de règles______________________________________________________
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnulerRegle.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("BtValider").getChild(Main.Cste.langue);
        BtValiderRegle.setText(courant.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbRegle").getChild(Main.Cste.langue);
        LbRegle.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("LbCondition").getChild(Main.Cste.langue);
        LbCondition.setText(courant.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("evenement").getChild(Main.Cste.langue);
        LbEvenementDeclencheur.setText(courant.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("declencher").getChild(Main.Cste.langue);
        declencherActions=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("alorsDeclencher").getChild(Main.Cste.langue);
        alorsDeclencher=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("siValeurEgaleA").getChild(Main.Cste.langue);
        siValeurEgaleA=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("siChoixEgaleA").getChild(Main.Cste.langue);
        siChoixEgaleA=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("si").getChild(Main.Cste.langue);
        si=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("en").getChild(Main.Cste.langue);
        en=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("superieureA").getChild(Main.Cste.langue);
        superieureA=courant.getText();        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("inferieureA").getChild(Main.Cste.langue);
        inferieureA=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("duree").getChild(Main.Cste.langue);
        duree=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("stringValeur").getChild(Main.Cste.langue);
        stringValeur=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("contenant").getChild(Main.Cste.langue);
        contenant=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("commencantPar").getChild(Main.Cste.langue);
        commencantPar=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("egaleA").getChild(Main.Cste.langue);
        egaleA=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("terminantPar").getChild(Main.Cste.langue);
        terminantPar=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("stringVrai").getChild(Main.Cste.langue);
        stringVrai=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("stringFaux").getChild(Main.Cste.langue);
        stringFaux=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("stringEt").getChild(Main.Cste.langue);
        stringEt=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("valeurCompriseEntre").getChild(Main.Cste.langue);
        valeurCompriseEntre=courant.getText();
        
        
        //___________________________________________________la création de conditions______________________________________________________
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemConditionProfil").getChild(Main.Cste.langue);
        itemConditionProfil=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemConditionTraces").getChild(Main.Cste.langue);
        itemConditionTraces=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemConditionHistorique").getChild(Main.Cste.langue);
        itemConditionHistorique=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemConditionContexte").getChild(Main.Cste.langue);
        itemConditionContexte=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemConditionConsultation").getChild(Main.Cste.langue);
        itemConditionConsultation=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemConditionCombinaison").getChild(Main.Cste.langue);
        itemConditionCombinaison=courant.getText();
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("dernierDeclenchement").getChild(Main.Cste.langue);
        dernierDeclenchement=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("nombreDeclenchement").getChild(Main.Cste.langue);
        nombreDeclenchement=courant.getText();

        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("dureeTotaleConditionTraces").getChild(Main.Cste.langue);
        dureeTotaleConditionTraces=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("dureeDepuisConditionTraces").getChild(Main.Cste.langue);
        dureeDepuisConditionTraces=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("nbOccurrencesConditionTraces").getChild(Main.Cste.langue);
        nbOccurrencesConditionTraces=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("nbEvenementsDepuisConditionTraces").getChild(Main.Cste.langue);
        nbEvenementsDepuisConditionTraces=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("presenceConditionTraces").getChild(Main.Cste.langue);
        presenceConditionTraces=courant.getText();

        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("valeurTextuelle").getChild(Main.Cste.langue);
        valeurTextuelle=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("valeurNumerique").getChild(Main.Cste.langue);
        valeurNumerique=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("estSelectionne").getChild(Main.Cste.langue);
        estSelectionne=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("aLeFocus").getChild(Main.Cste.langue);
        aLeFocus=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("estEditable").getChild(Main.Cste.langue);
        estEditable=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("estActif").getChild(Main.Cste.langue);
        estActif=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("nbColonnes").getChild(Main.Cste.langue);
        nbColonnes=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("nbLignes").getChild(Main.Cste.langue);
        nbLignes=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("valeurMax").getChild(Main.Cste.langue);
        valeurMax=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("valeurMin").getChild(Main.Cste.langue);
        valeurMin=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("estEtendu").getChild(Main.Cste.langue);
        estEtendu=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("estAuPremierPlan").getChild(Main.Cste.langue);
        estAuPremierPlan=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("invoke").getChild(Main.Cste.langue);
        invoke=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("select").getChild(Main.Cste.langue);
        select=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("setFocus").getChild(Main.Cste.langue);
        setFocus=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("toggle").getChild(Main.Cste.langue);
        toggle=courant.getText();
        
        
        //____________________________________________________________________la création d'actions______________________________________________________________       
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemTypeActionMessage").getChild(Main.Cste.langue);
        itemTypeActionMessage = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemTypeActionModificationProfil").getChild(Main.Cste.langue);
        itemTypeActionModificationProfil = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemTypeActionActionInterface").getChild(Main.Cste.langue);
        itemTypeActionActionInterface = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemTypeActionPasAPas").getChild(Main.Cste.langue);
        itemTypeActionPasAPas = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemTypeActionActionRessource").getChild(Main.Cste.langue);
        itemTypeActionRessource = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemTypeActionActionAnimation").getChild(Main.Cste.langue);
        itemTypeActionAnimation = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemTypeActionMiseEnValeur").getChild(Main.Cste.langue);
        itemTypeActionMiseEnValeur = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemTypeActionMasquage").getChild(Main.Cste.langue);
        itemTypeActionMasquage = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemTypeActionAjoutComposant").getChild(Main.Cste.langue);
        itemTypeActionAjoutComposant = courant.getText();
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("stringDescriptionMettreEnValeurComposant").getChild(Main.Cste.langue);
        stringDescriptionMettreEnValeurComposant = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("stringDescriptionEntourerComposant").getChild(Main.Cste.langue);
        stringDescriptionEntourerComposant = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("stringDescriptionColorerComposant").getChild(Main.Cste.langue);
        stringDescriptionColorerComposant = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("stringDescriptionSymboleComposant").getChild(Main.Cste.langue);
        stringDescriptionSymboleComposant = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("stringDescriptionAgentComposant").getChild(Main.Cste.langue);
        stringDescriptionAgentComposant = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("stringDescriptionEstomperComposant").getChild(Main.Cste.langue);
        stringDescriptionEstomperComposant = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("stringDescriptionOcculterComposant").getChild(Main.Cste.langue);
        stringDescriptionOcculterComposant = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemParLaGauche").getChild(Main.Cste.langue);
        itemParLaGauche = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemParLaDroite").getChild(Main.Cste.langue);
        itemParLaDroite = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemParLeHaut").getChild(Main.Cste.langue);
        itemParLeHaut = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemParLeBas").getChild(Main.Cste.langue);
        itemParLeBas = courant.getText();
        
        
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemCentre").getChild(Main.Cste.langue);
        itemCentre=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemGauche").getChild(Main.Cste.langue);
        itemGauche=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemDroite").getChild(Main.Cste.langue);
        itemDroite=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemHaut").getChild(Main.Cste.langue);
        itemHaut=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemBas").getChild(Main.Cste.langue);
        itemBas=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemPopupSynthese").getChild(Main.Cste.langue);
        itemPopupSynthese=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemPopup").getChild(Main.Cste.langue);
        itemPopup=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemSynthese").getChild(Main.Cste.langue);
        itemSynthese=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemAgentAnime").getChild(Main.Cste.langue);
        itemAgentAnime=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemAvecPrenom").getChild(Main.Cste.langue);
        itemAvecPrenom=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemAvecNom").getChild(Main.Cste.langue);
        itemAvecNom=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemAvecElementProfil").getChild(Main.Cste.langue);
        itemAvecElementProfil=courant.getText();
        
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("tooltipAfficherDetailsMiseEnValeur").getChild(Main.Cste.langue);
        tooltipAfficherDetailsMiseEnValeur=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("tooltipMasquerDetailsMiseEnValeur").getChild(Main.Cste.langue);
        tooltipMasquerDetailsMiseEnValeur=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemEstomper").getChild(Main.Cste.langue);
        itemEstomper=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemOcculter").getChild(Main.Cste.langue);
        itemOcculter=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemColorer").getChild(Main.Cste.langue);
        itemColorer=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemEntourer").getChild(Main.Cste.langue);
        itemEntourer=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemSymbole").getChild(Main.Cste.langue);
        itemSymbole=courant.getText();
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("titrePanelSousActionAnimation").getChild(Main.Cste.langue);
        titrePanelSousActionAnimation = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemVitesseActionAnimation").getChild(Main.Cste.langue);
        itemVitesseActionAnimation = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemTexteActionAnimation").getChild(Main.Cste.langue);
        itemTexteActionAnimation = courant.getText();
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemDeplacementActionAnimation").getChild(Main.Cste.langue);
        itemDeplacementActionAnimation = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemParoleActionAnimation").getChild(Main.Cste.langue);
        itemParoleActionAnimation = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemPensseActionAnimation").getChild(Main.Cste.langue);
        itemPensseActionAnimation = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemAnimationActionAnimation").getChild(Main.Cste.langue);
        itemAnimationActionAnimation = courant.getText();
        
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemOuvrirFichierActionRessource").getChild(Main.Cste.langue);
        itemOuvrirFichierActionRessource = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemOuvrirURLActionRessource").getChild(Main.Cste.langue);
        itemOuvrirURLActionRessource = courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemOuvrirAppliActionRessource").getChild(Main.Cste.langue);
        itemOuvrirAppliActionRessource = courant.getText();

        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemTypeComposantAjouteBouton").getChild(Main.Cste.langue);
        itemTypeComposantAjouteBouton=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemTypeComposantAjouteLabel").getChild(Main.Cste.langue);
        itemTypeComposantAjouteLabel=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemTypeComposantAjouteImage").getChild(Main.Cste.langue);
        itemTypeComposantAjouteImage=courant.getText();

        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemGuide").getChild(Main.Cste.langue);
        itemGuide=courant.getText();
        courant= (Element) XMLFonctions.racine.getChild("CreationRegles").getChild("itemAutomatise").getChild(Main.Cste.langue);
        itemAutomatise=courant.getText();
        
        
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("BtRetour").getChild(Main.Cste.langue);
        BtRetour.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("BtSuivant").getChild(Main.Cste.langue);
        BtSuivant.setText(courant.getText()); 
    }
    
    public void chargerEvenementDeclencheur()
    {
        String ancien= CbEvenementDeclencheur.getSelectedItem().toString();
        CbEvenementDeclencheur.removeAllItems();
        CbEvenementDeclencheur.addItem(itemCreerUnNouvelEvenement);
        CbEvenementDeclencheur.addItem(itemLancementAssistance);
        CbEvenementDeclencheur.addItem(itemLancementRegle);
        for(int i=0; i<lesEvenements.size(); i++)
        {
            Element eve = lesEvenements.get(i);
            CbEvenementDeclencheur.addItem(eve.getAttributeValue(attributId));
        }
        CbEvenementDeclencheur.setSelectedItem(itemLancementAssistance);
        CbEvenementDeclencheur.setSelectedItem(ancien);
    }
    
    public void chargerEvenementFin()
    {
        String ancien= CbEvenementFin.getSelectedItem().toString();
        CbEvenementFin.removeAllItems();
        CbEvenementFin.addItem(itemCreerUnNouvelEvenement);
        CbEvenementFin.addItem(itemAucun);
        for(int i=0; i<lesEvenements.size(); i++)
        {
            Element eve = lesEvenements.get(i);
            CbEvenementFin.addItem(eve.getAttributeValue(attributId));
        }
        CbEvenementFin.setSelectedItem(itemAucun);
        CbEvenementFin.setSelectedItem(ancien);
    }
    
    public void chargerCbActionsEtRegles(JComboBox cb, boolean b)
    {
        cb.removeAllItems();
        if(b)
            cb.addItem(itemCreerUneNouvelleAction);
        for(int i=0; i<lesActions.size(); i++)
        {
            Element a = lesActions.get(i);
            cb.addItem(a.getAttributeValue("id"));
        }
        for(int i=0; i<lesRegles.size(); i++)
        {
            Element r = lesRegles.get(i);
            cb.addItem(r.getAttributeValue("id"));
        }
        cb.setSelectedIndex(-1);
        
        if(b)
            cb.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    CBSelectionActionItemStateChanged((JComboBox) e.getSource());
                }
            });
    }
    
    public void chargerCbActionsEtReglesEtConsultations(JComboBox cb)
    {
        cb.removeAllItems();
        for(int i=0; i<lesActions.size(); i++)
        {
            Element a = lesActions.get(i);
            cb.addItem(a.getAttributeValue("id"));
        }
        for(int i=0; i<lesRegles.size(); i++)
        {
            Element r = lesRegles.get(i);
            cb.addItem(r.getAttributeValue("id"));
        }
        for(int i=0; i<lesConditions.size(); i++)
        {
            Element c = lesConditions.get(i);
            if(c.getAttributeValue(attributType).equals(conditionConsultation))
                cb.addItem(c.getAttributeValue("id"));
        }
        cb.setSelectedIndex(-1);

    }
    
    private void CBSelectionActionItemStateChanged(JComboBox cb)
    {
        if(cb.getSelectedIndex()>=0)
        {
            if(cb.getSelectedItem().toString().equals(itemCreerUneNouvelleAction))
            {
                Main.CreationActions.CB = cb;
                Main.CreationActions.chargerInterface();
                Main.CreationActions.setVisible(true);
            }
        }
    }
    
    public void rechargerCbSelectionAction()
    {
        //on recharge les CB de chxoi d'action car une action a été créée
       if(PanelActionsRegle.isVisible()) 
       {
           Panel ppp = (Panel) PanelActionsRegle.getComponent(0);
           Panel pp = (Panel) ppp.getComponent(1);
           Panel p = (Panel) pp.getComponent(1);
           for(int i=2; i<p.getComponentCount(); i++)
           {
               JComboBox cb = (JComboBox) p.getComponent(i);
               String item="";
               if(cb.getSelectedIndex()>=0)
                    item = cb.getSelectedItem().toString();
               chargerCbActionsEtRegles(cb, true);
               cb.setSelectedItem(item);
           }
       }
       else
       {
           for(int i =0; i<PanelAlternativesRegle.getComponentCount(); i++)
           {
                Panel ppp = (Panel) PanelAlternativesRegle.getComponent(i);
                Panel pp= (Panel) ppp.getComponent(1);
                Panel p = (Panel) pp.getComponent(1);
                
                for(int j=2; j<p.getComponentCount(); j++)
                {
                    JComboBox cb = (JComboBox) p.getComponent(j);
                    String item="";
                    if(cb.getSelectedIndex()>=0)
                            item = cb.getSelectedItem().toString();
                    chargerCbActionsEtRegles(cb, true);
                    cb.setSelectedItem(item);
                }
           }
       }
    }
    
    public String cleParValeur(TreeMap<String, String> tmap, String valeur)
    {
        Iterator<String> iter = tmap.keySet().iterator();
        while (iter.hasNext()) 
        {
            String cle = (String) iter.next();
            if (tmap.get(cle).equals(valeur)) 
            {
                return cle;
            }
        }
        return "";
    }
    
    private void creerListeTypesEvenements()
    {
        listeTypesEvenements.clear();
        listeTypesEvenements.put("mouseClicked", "clic");
        listeTypesEvenements.put("mouseEntered", "passage de la souris");
        listeTypesEvenements.put("keyPressed", "saisie");
        listeTypesEvenements.put("focusGained", "gain de focus");
        listeTypesEvenements.put("focusLost", "perte de focus");
    }
    
    public void creerListeProprietes()
    {
        listeProprietes.clear();
        listeProprietes.put(" "," ");
        listeProprietes.put(valeurTextuelle,attributTexte);
        listeProprietes.put(valeurNumerique,"nombre");       
        listeProprietes.put(estSelectionne,"booléen");
        listeProprietes.put(aLeFocus,"booléen");      
        listeProprietes.put(estEditable,"booléen");       
        listeProprietes.put(estActif,"booléen");
        listeProprietes.put(nbColonnes,"nombre");
        listeProprietes.put(nbLignes,"nombre");
        listeProprietes.put(valeurMax,"nombre");
        listeProprietes.put(valeurMin,"nombre");
        listeProprietes.put(estEtendu,"booléen");
        listeProprietes.put(estAuPremierPlan,"booléen");
    }
    
    public void ChargerCbActionActionInterface(JComboBox Cb, String type)
    {
        Cb.removeAllItems();
        if(type.isEmpty())
        {            
            Cb.addItem(invoke);
            Cb.addItem(select);            
            Cb.addItem(setValue);
            Cb.addItem(toggle);
            Cb.addItem(setFocus);
        }
        else if(type.equals(Main.ModificationInterface.stringBouton))
        {
            Cb.addItem(invoke);
            Cb.addItem(setFocus);
        }
        else if(type.equals(Main.ModificationInterface.stringBoutonRadio))
        {
            Cb.addItem(toggle);
        }
        else if(type.equals(Main.ModificationInterface.stringItem))
        {
            Cb.addItem(select);
        }
        else if(type.equals(Main.ModificationInterface.stringPanel) || type.equals(Main.ModificationInterface.stringLabel))
        {

        }
        else if(type.equals(Main.ModificationInterface.stringSlider) || type.equals(Main.ModificationInterface.stringSaisie))
        {            
            Cb.addItem(setValue);
            Cb.addItem(setFocus);
        }
        else if(type.equals(Main.ModificationInterface.stringLien))
        {            
            Cb.addItem(invoke);
        }
        else if(type.equals(Main.ModificationInterface.stringCase))
        {            
            Cb.addItem(toggle);
            Cb.addItem(setFocus);
        }
        else
        {
            Cb.addItem(setFocus);
        }
    }
    
    public void selectionnerLigneArbreParString(JTree arbre, String ligne)
    {
        TreeModel model = arbre.getModel(); 
        DefaultMutableTreeNode pere = (DefaultMutableTreeNode) model.getRoot();
        for(int i=0; i<pere.getChildCount(); i++)
        {
            DefaultMutableTreeNode fils= (DefaultMutableTreeNode) pere.getChildAt(i);
            if(fils.toString().equals(ligne))
                arbre.setSelectionRow(i);
        }
    }
    
    public String lignePresentationGuidee(Element eve)
    {
        if(!eve.getAttributeValue(attributIdComp).isEmpty())
        {
            Element composant=elementParId(lesComposants, eve.getAttributeValue(attributIdComp));
            if(composant.getAttribute(attributDescriptionAjoutee)==null)
            {
                return stringPresenter + stringComposantIdentifiant+eve.getAttributeValue(attributIdComp);
            }
            else
            {
                return stringPresenter + composant.getAttributeValue(attributDescriptionAjoutee);
            }
        }
        return "";
    }
    
    public String ligneActionPasAPas(Element eve)
    {
        if(!eve.getAttributeValue(attributIdComp).isEmpty())
            {
                Element composant=elementParId(lesComposants, eve.getAttributeValue(attributIdComp));
                if(eve.getAttributeValue(attributPropriete).equals("clic"))
                {
                    if(composant.getAttribute(attributDescriptionAjoutee)==null)
                    {
                        return stringCliquerSur + stringComposantIdentifiant+eve.getAttributeValue(attributIdComp);
                    }
                    else
                    {
                        return stringCliquerSur + composant.getAttributeValue(attributDescriptionAjoutee);
                    }
                }
                else if(eve.getAttributeValue(attributPropriete).equals("etat"))
                {
                    if(eve.getAttributeValue(attributValeur).equals("On"))
                    {                       
                        if (composant.getAttribute(attributDescriptionAjoutee) == null) 
                        {
                            return stringSelectionner + stringComposantIdentifiant+eve.getAttributeValue(attributIdComp);
                        } 
                        else 
                        {
                            return stringSelectionner + composant.getAttributeValue(attributDescriptionAjoutee);
                        }
                    }
                    else
                    {
                        if (composant.getAttribute(attributDescriptionAjoutee) == null) 
                        {
                            return stringDeselectionner + stringComposantIdentifiant+eve.getAttributeValue(attributIdComp);
                        } 
                        else 
                        {
                            return stringDeselectionner + composant.getAttributeValue(attributDescriptionAjoutee);
                        }
                    }
                }
                else if(eve.getAttributeValue(attributPropriete).equals(attributValeur))
                {                   
                    if(composant.getAttribute(attributDescriptionAjoutee)==null)
                    {
                        return stringPasserA + eve.getAttributeValue(attributValeur)+ stringValeurDu + stringComposantIdentifiant + eve.getAttributeValue(attributIdComp);
                    }
                    else
                    {
                        return stringPasserA + eve.getAttributeValue(attributValeur)+ stringValeurDe +composant.getAttributeValue(attributDescriptionAjoutee);
                    }
                }
                else if(eve.getAttributeValue(attributPropriete).equals("focus"))
                {                    
                    if(composant.getAttribute(attributDescriptionAjoutee)==null)
                    {
                        return stringDonnerFocusAu + stringComposantIdentifiant + eve.getAttributeValue(attributIdComp);
                    }
                    else
                    {
                        return stringDonnerFocusA +composant.getAttributeValue(attributDescriptionAjoutee);
                    }
                }
            }
        return "";
    }
    
    public void ChargerListeActionPresentationGuidee(JList list, Element sequence)
    {
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < sequence.getChildren().size(); i++) 
        {
            Element eve = (Element) sequence.getChildren().get(i);
            model.addElement(lignePresentationGuidee(eve));
        }
        listModel = model;
        list.setModel(model);
        
        Main.CreationActions.creerListeMessagesPresentationGuidee(sequence);
        Main.CreationActions.creerElementMiseEnValeurEtape();
    }
    
    public void ChargerListeActionPasaPas(JList list, Element sequence)
    {
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < sequence.getChildren().size(); i++) 
        {
            Element eve = (Element) sequence.getChildren().get(i);
            model.addElement(ligneActionPasAPas(eve));
        }
        listModel = model;
        list.setModel(model);
        
        Main.CreationActions.creerListeMessagesPasAPas(sequence);
        Main.CreationActions.creerElementMiseEnValeurEtape();
    }
    
    public void RechargerListeActionPasaPas(Element sequence)
    {
        /*
        ChargerListeActionPasaPas(ListeActionPasaPas, sequence);
        CbEtapesActionPasaPas.setSelectedItem(sequence.getAttributeValue(attributId)+"_"+sequence.getAttributeValue(attributNom));
        */
    }
    
    public void etendreArbre(JTree arbre)
    {
        Enumeration e = ((DefaultMutableTreeNode) arbre.getModel().getRoot()).preorderEnumeration();
        while (e.hasMoreElements()) {
            arbre.expandPath(new TreePath(((DefaultMutableTreeNode)e.nextElement()).getPath()));
        }
    }
    
    public void creerListeCommentairesComposants()
    {
       listeCommentairesComposants=new HashMap();
       //XMLFonctions.OuvrirXML(Main.Cste.cheminDescriptions+"/"+Main.Cste.logiciel+"/"+Main.Cste.descriptionInterface);
       XMLFonctions.OuvrirXML(Main.CreationRegles.cheminEtInterface);
       Element racine=XMLFonctions.racine;
       for(int i=0; i<racine.getChildren().size(); i++)
       {
           Element fenetre=(Element) racine.getChildren().get(i);
           if(fenetre.getAttributeValue("commentaires")!=null)
           {
               listeCommentairesComposants.put(fenetre.getAttributeValue(attributId), fenetre.getAttributeValue("commentaires"));
           }
           creerListeCommentairesComposants(fenetre);
       }
    }
    
    public void creerListeCommentairesComposants(Element elem)
    {
       for(int i=0; i<elem.getChildren().size(); i++)
       {
           Element compo=(Element) elem.getChildren().get(i);
           if(compo.getAttributeValue("commentaires")!=null)
           {
               listeCommentairesComposants.put(compo.getAttributeValue(attributId), compo.getAttributeValue("commentaires"));
           }
           creerListeCommentairesComposants(compo);
       }
    }
    
    public String descriptionNoeudComposant(Element composant)
    {
                String texte=" ";
                if(composant.getAttribute(attributTexte)!=null)
                {
                    texte=" "+Main.ModificationInterface.stringFixeTexte+"='"+composant.getAttributeValue(attributTexte)+"'";
                }
                String titre=" ";
                if(composant.getAttribute(attributTitre)!=null)
                {
                    titre=" "+Main.ModificationInterface.stringFixeTitre+"='"+composant.getAttributeValue(attributTitre)+"'";
                }
                String source=" ";
                if(composant.getAttribute(attributSource)!=null)
                {
                    source=" "+Main.ModificationInterface.stringFixeSource+"='"+composant.getAttributeValue(attributSource)+"'";
                }
                String val=" ";
                if(composant.getAttribute(attributValeur)!=null)
                {
                    source=" "+Main.ModificationInterface.stringFixeValeur+"='"+composant.getAttributeValue(attributValeur)+"'";
                }
                String lien=" ";
                if(composant.getAttribute("lien")!=null)
                {
                    source=" "+Main.ModificationInterface.stringFixeLien+"='"+composant.getAttributeValue("lien")+"'";
                }

                return stringComposant+" id="+composant.getAttributeValue(attributId)+" type="+Main.ModificationInterface.traduireTypeComposant(composant.getAttributeValue(attributTypeAjoute)) +texte+titre+lien+source+val;
                
    }
    
    public String noeudGetId(String noeud)
    {
        if(noeud==null || !noeud.contains("id="))
            return "";
        String id=noeud.substring(noeud.indexOf("id=")+3);
        id=id.substring(0, id.indexOf(" "));
        return id;
    }
    
    public String ligneDescriptionComposant(boolean descriptionComplete, Element composant)
    {
        if(descriptionComplete || composant.getAttribute(attributTypeAjoute)==null)
        {
            return Main.ModificationInterface.traduireTypeComposant(composant.getName())+" id="+composant.getAttributeValue(attributId)+" "+Main.ModificationInterface.stringFixeTexte+"='"+composant.getAttributeValue(attributTexte)+"' type="+composant.getAttributeValue(attributType);
        }
        else
        {
            return Main.ModificationInterface.traduireTypeComposant(composant.getAttributeValue(attributTypeAjoute)) + " id=" + composant.getAttributeValue(attributId) +" "+Main.ModificationInterface.stringFixeTexte+"='"+ composant.getAttributeValue(attributTexte) + "' (" + composant.getAttributeValue(attributDescriptionAjoutee) + ")"; 
        }
    }
    
    private DefaultMutableTreeNode chargerComposantsAjoutes(DefaultMutableTreeNode root)
    {
        for(int i=0; i<lesActions.size(); i++)
        {
            Element act = lesActions.get(i);
            if(act.getAttributeValue(attributType).equals(stringTypeActionAjoutComposant))
            {
                DefaultMutableTreeNode fen = new DefaultMutableTreeNode("Composant ajouté "+"id="+act.getAttributeValue(attributNom)+" ");
                root.add(fen);
            }
        }
        return root;
    }
    
    public void chargerArbreComposants(JTree arbre, boolean descriptionComplete)
    {
        XMLFonctions.OuvrirXML(Main.Cste.cheminDescriptions+"/"+Main.Cste.logiciel+"/"+Main.Cste.descriptionInterface);
        Element racine=XMLFonctions.racine;
        arbre.removeAll();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Interface");
        root = chargerComposantsAjoutes(root);
        for(int i=0; i<racine.getChildren().size(); i++)
        {
            Element fenetre=(Element) racine.getChildren().get(i);
            if(descriptionComplete || fenetre.getAttribute(attributTypeAjoute)!=null)
            {
                DefaultMutableTreeNode fen = new DefaultMutableTreeNode(ligneDescriptionComposant(descriptionComplete, fenetre));
                root.add(fen);
                ajouterComposantArbre(fenetre, fen, descriptionComplete);
            }
            else  //on ne va pas afficher ce composant, mais il peut avoir des fils qui sont à afficher
            {
                ajouterComposantArbre(fenetre, root, descriptionComplete);
            }
                       
        }
        DefaultTreeModel model = new DefaultTreeModel(root);
        arbre.setModel(model);
    }  
    
    private void ajouterComposantArbre(Element composant, DefaultMutableTreeNode noeud, Boolean descriptionComplete){
        for(int i=0; i<composant.getChildren().size(); i++)
        {           
            Element fils=(Element) composant.getChildren().get(i);
            if(descriptionComplete || (fils.getAttribute(attributTypeAjoute)!=null && !fils.getAttributeValue(attributTypeAjoute).equals("panel")))
            {
                DefaultMutableTreeNode branche = new DefaultMutableTreeNode(ligneDescriptionComposant(descriptionComplete, fils));
                noeud.add(branche);
                if(!fils.getChildren().isEmpty())
                {
                    ajouterComposantArbre(fils, branche, descriptionComplete);
                }
            }
            else if(!fils.getChildren().isEmpty())  //on ne va pas afficher ce composant, mais il peut avoir des fils qui sont à afficher
            {
                ajouterComposantArbre(fils, noeud, descriptionComplete);
            }
        }           
    }
    
    public void construireMur(JTree arbre)
    {
         XMLFonctions.OuvrirXML(Main.Cste.cheminStructuresProfils+Main.Cste.structureProfils);
         Element courant=XMLFonctions.racine;
         DefaultMutableTreeNode root=new DefaultMutableTreeNode("profil");
         for(int i=0; i<courant.getChildren().size(); i++)
         {   
             Element brique=(Element) courant.getChildren().get(i);
             
             root=ouvrirBrique(brique,root);
         }
         DefaultTreeModel m = new DefaultTreeModel(root);
         arbre.setModel(m);
         etendreArbre(arbre);
    }
    
    public DefaultMutableTreeNode ouvrirBrique(Element brique, DefaultMutableTreeNode r)
    {
        //on affiche l'abre de la brique
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(brique.getAttributeValue(attributNom));
        r.add(root);
        Element arbre = (Element) brique.getChild("arbre_des_composantes");
        if (arbre != null) 
        {
            for (int i = 0; i < arbre.getChildren().size(); i++) 
            {                
                Element composante = (Element) arbre.getChildren().get(i);
                DefaultMutableTreeNode Branche1 = new DefaultMutableTreeNode(composante.getAttributeValue(attributNom));
                root.add(Branche1);

                //on affiche les sous composantes
                Element valeu = (Element) composante.getChild(attributValeur);
                if (valeu == null) //si c'est pas une feuille
                {
                    afficheSSCompo(Branche1, composante);
                }
            }
            
        }
        return r;
    } 
    
    public void afficheSSCompo(DefaultMutableTreeNode Branche, Element composante)
    {
        for(int i=0; i<composante.getChildren().size(); i++)
        {
            Element sousCompo=(Element) composante.getChildren().get(i);
            if(sousCompo.getName().equals("sous_composante"))
            {
                DefaultMutableTreeNode ss = new DefaultMutableTreeNode(sousCompo.getAttributeValue(attributNom));
                Branche.add(ss);
                Element val=(Element) sousCompo.getChild(attributValeur);
                if(val==null) //si c'est pas une feuille
                {
                    afficheSSCompo(ss, sousCompo);
                }
            }
        }
    }
    
    public void chargerCbTypeEvenements(JComboBox Cb, String type){
        creerListeTypesEvenements();
        Cb.removeAllItems();
        if(type.isEmpty())
        {
            /*Iterator it=listeTypesEvenements.values().iterator();
            while (it.hasNext())
            {
                Cb.addItem((String) it.next());
            }*/
            Cb.addItem("clic");
            Cb.addItem("passage de la souris");
            Cb.addItem("saisie");
            Cb.addItem("gain de focus");
            Cb.addItem("perte de focus");
        }
        else if(type.equals(attributLabel))
        {
            Cb.addItem("clic");
            Cb.addItem("passage de la souris");
        }
        else if(type.equals("zone de saisie"))
        {
            Cb.addItem("clic");
            Cb.addItem("passage de la souris");
            Cb.addItem("saisie");
            Cb.addItem("gain de focus");
            Cb.addItem("perte de focus");
        }
        else
        {
            Cb.addItem("clic");
            Cb.addItem("passage de la souris");
            Cb.addItem("gain de focus");
            Cb.addItem("perte de focus");
        }
    }
    
    public void chargerCbSequence(JComboBox Cb, String type)
    {       
        Cb.removeAllItems();
        for(int i=0; i<lesSequences.size(); i++)
        {
            Element sequence= (Element) lesSequences.get(i);
            if(sequence.getAttributeValue(attributType).equals(type))
                Cb.addItem(sequence.getAttributeValue(attributId)+"_"+sequence.getAttributeValue(attributNom));
        }
    }
    
    private void supprimerPanelAlternative()
    {
        PanelAlternativesRegle.remove(PanelAlternativesRegle.getComponentCount()-1);
        BtAjoutAlternativeRegle.setEnabled(true); 
        BtSupprimeAlternativeRegle.setEnabled(PanelAlternativesRegle.getComponentCount()>1);
        
        PanelAlternativesRegle.setBounds(240, 90, 760, PanelAlternativesRegle.getComponentCount()*40);
        BtAjoutAlternativeRegle.setBounds(240, 90+PanelAlternativesRegle.getComponentCount()*40, 50, 24);
        BtSupprimeAlternativeRegle.setBounds(300, 90+PanelAlternativesRegle.getComponentCount()*40, 50, 24);
    }
    
    private void ajouterPanelSansConditionRegle()
    {
        PanelActionsRegle.removeAll();
        
        Panel pTotal = new Panel();
        pTotal.setLayout(null);
        pTotal.setBounds(0, 0, PanelActionsRegle.getWidth(), 25);
        PanelActionsRegle.add(pTotal);
         
        Panel pValeur = new Panel();
        pValeur.setBounds(0, 0, 1, 1);
        pTotal.add(pValeur);
                
        Panel pAction = new Panel();
        pTotal.add(pAction);
                        
        pAction.setBackground(PanelActionsRegle.getBackground());
        pAction.setLayout(null);
        pAction.setBounds(0, 0, PanelActionsRegle.getWidth(), 25);

        JLabel lb2 = new JLabel(declencherActions);
        lb2.setBounds(0, 0, 70, 24);
        pAction.add(lb2);

        Panel ppA = new Panel();
        ppA.setBounds(70, 0, PanelActionsRegle.getWidth()-70, 25);
        ppA.setBackground(PanelActionsRegle.getBackground());
        pAction.add(ppA);
        creerPanelSelectionActions(ppA); 
    }
    
    private void ajouterPanelAlternativeRegle(String nomCond)
    {
        if(nomCond.isEmpty())
        {
            PanelAlternativesRegle.removeAll();
        }
        else
        {                        
            Panel pTotal = new Panel();
            pTotal.setLayout(null);           
            pTotal.setBounds(0, PanelAlternativesRegle.getComponentCount()*40, PanelAlternativesRegle.getWidth(), 35);
            PanelAlternativesRegle.add(pTotal, PanelAlternativesRegle.getComponentCount());
            
            PanelAlternativesRegle.setBounds(240, 90, 760, PanelAlternativesRegle.getComponentCount()*40);            
            BtAjoutAlternativeRegle.setBounds(240, 90+PanelAlternativesRegle.getComponentCount()*40, 50, 24);
            BtSupprimeAlternativeRegle.setBounds(300, 90+PanelAlternativesRegle.getComponentCount()*40, 50, 24);
            
            //on crée le panel pour définir la valeur de la condition
            Element cond = conditionParId(nomCond);
            Panel pValeur = new Panel();
            pTotal.add(pValeur);
            pValeur.setBackground(PanelAlternativesRegle.getBackground());
            pValeur.setLayout(null);
            pValeur.setBounds(0, 0, 330, 25);
            
            JLabel lb = new JLabel(si);
            lb.setBounds(0, 0, 20, 24);
            pValeur.add(lb);
            
            Panel ppV = new Panel();
            ppV.setBounds(20, 0, PanelAlternativesRegle.getWidth()-30, 25);
            creerPanelCondition(ppV, cond);
            pValeur.add(ppV);
            ppV.revalidate();
            
            
            //et on crée le panel pour définir les actions à déclencher
            Panel pAction = new Panel();
            pTotal.add(pAction);
            pAction.setBackground(PanelAlternativesRegle.getBackground());
            pAction.setLayout(null);
            pAction.setBounds(330, 0, 430, 25);
            
            JLabel lb2 = new JLabel(alorsDeclencher);
            lb2.setBounds(0, 0, 70, 24);
            pAction.add(lb2);
            
            Panel ppA = new Panel();
            ppA.setBounds(70, 0, PanelAlternativesRegle.getWidth()-100, 25);
            ppA.setBackground(PanelAlternativesRegle.getBackground());           
            pAction.add(ppA);
            creerPanelSelectionActions(ppA);
            BtSupprimeAlternativeRegle.setEnabled(PanelAlternativesRegle.getComponentCount()>1);

            if(PanelAlternativesRegle.getComponentCount()==5)
                BtAjoutAlternativeRegle.setEnabled(false);
        }
    }
    
    private void creerPanelSelectionActions(Panel p)
    {
        p.setLayout(null);
        JButton btPlus = new JButton("+");
        p.add(btPlus, 0);
        JButton btMoins = new JButton("-");
        p.add(btMoins, 1);
        
        btPlus.setBounds(0, 0, 50, 24);
        btMoins.setBounds(60, 0, 50, 24);
        
        ajouterSelectionAction(p, 0);
    }
    
    private void ajouterSelectionAction(final Panel p, int position)
    {
        JButton btPlus = (JButton) p.getComponent(0);
        JButton btMoins = (JButton) p.getComponent(1);
        btPlus.setBounds(65+position*55, 0, 50, 24);
        btMoins.setBounds(125+position*55, 0, 50, 24);
        
        for(int i=0; i<btPlus.getActionListeners().length; i++)
            btPlus.removeActionListener(btPlus.getActionListeners()[i]);
        
        btPlus.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a){
                    ajouterSelectionAction(p, p.getComponentCount()-2);
            }
        });
        
        for(int i=0; i<btMoins.getActionListeners().length; i++)
            btMoins.removeActionListener(btMoins.getActionListeners()[i]);        
        btMoins.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a){
                    supprimerSelectionAction(p);
            }
        });
        
        WideComboBox cb = new WideComboBox();
        cb.setBounds(55*position, 0, 50, 25);
        cb.setBackground(PanelActions.getBackground());
        chargerCbActionsEtRegles(cb, true);

        p.add(cb);
        cb.repaint();
        cb.validate();
        cb.revalidate();
        
        btPlus.setEnabled(p.getComponentCount()<6);
        btMoins.setEnabled(p.getComponentCount()>3);
    }
    
    private void supprimerSelectionAction(final Panel p)
    {
        p.remove(p.getComponentCount()-1);
        
        JButton btPlus = (JButton) p.getComponent(0);
        JButton btMoins = (JButton) p.getComponent(1);
        btPlus.setBounds(btPlus.getLocation().x-55, 0, 50, 24);
        btMoins.setBounds(btMoins.getLocation().x-55, 0, 50, 24);
        
        for(int i=0; i<btPlus.getActionListeners().length; i++)
            btPlus.removeActionListener(btPlus.getActionListeners()[i]);
        
        btPlus.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a){
                    ajouterSelectionAction(p, p.getComponentCount()-2);
            }
        });
        
        for(int i=0; i<btMoins.getActionListeners().length; i++)
            btMoins.removeActionListener(btMoins.getActionListeners()[i]);        
        btMoins.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a){
                    supprimerSelectionAction(p);
            }
        });
        
        btPlus.setEnabled(p.getComponentCount()<6);
        btMoins.setEnabled(p.getComponentCount()>3);
        
        p.repaint();
    }
    
    public String getDescriptionFormat(String[] s) {
        String chaine = "les fichiers (";
        for (int i = 0; i < s.length; i++) {
            chaine += "*." + s[i];
            if (i < s.length - 1) {
                chaine += ",";
            }
        }
        chaine += ")";
        return chaine;
    }
    
    public void chargerCbChoixConditionRegle()
    {
        CbChoixConditionRegle.removeAllItems();
        CbChoixConditionRegle.addItem(itemCreerUneNouvelleCondition);
        CbChoixConditionRegle.addItem(itemAucune);
        for(int i=0; i<lesConditions.size(); i++)
        {
            CbChoixConditionRegle.addItem(TableConditions.getValueAt(i, 0));
        }
        CbChoixConditionRegle.setSelectedItem(itemAucune);
    }
    
    private void creerPanelCondition(Panel p, Element cond)
    {
        p.setLayout(null);
        if(cond.getAttributeValue(attributType).equals(conditionProfil))
        {
            Element noeud = (Element) cond.getChildren().get(0);
            if(noeud.getName().equals(attributTextuelle))
            {
                String[] tab= new String[noeud.getChildren().size()];
                for(int i=0; i<noeud.getChildren().size(); i++)
                {
                    Element val = (Element) noeud.getChildren().get(i);
                    tab[i]= val.getText();
                }
                afficherChoixValeurConditionTextuelle(p, tab, siValeurEgaleA);
            }
            else
            {
                int min = Integer.parseInt(noeud.getAttributeValue(attributBorne_inf));
                int max = Integer.parseInt(noeud.getAttributeValue(attributBorne_sup));
                afficherChoixValeurConditionNumerique(p, min, max);               
            }
        }
        else if(cond.getAttributeValue(attributType).equals(conditionContexte))
        {
            if(cond.getAttributeValue(attributSousType).equals("nombre"))
            {
                afficherChoixValeurConditionNumerique(p, 0, 1000);
            }
            else if(cond.getAttributeValue(attributSousType).equals("booléen"))
            {
                String[] tab= new String[2];
                tab[0]=stringVrai;
                tab[1]=stringFaux;
                afficherChoixValeurConditionTextuelle(p, tab, siValeurEgaleA);
            }
            else if(cond.getAttributeValue(attributSousType).equals(attributTexte))
            {
                afficherChoixValeurConditionTexteLibre(p);
            }
        }
        else if(cond.getAttributeValue(attributType).equals(conditionHistorique))
        {
            if(cond.getAttributeValue(attributSousType).equals(dernierDeclenchement))
            {
                afficherChoixValeurConditionDuree(p, cond.getAttributeValue(attributUnite));
            }
            else if(cond.getAttributeValue(attributSousType).equals(conditionConsultation))
            {
                Element c = conditionParId(cond.getAttributeValue(attributObjet));
                Element noeud = (Element) c.getChild(attributOptions);
                String[] tab = new String[noeud.getChildren().size()];
                for (int i = 0; i < noeud.getChildren().size(); i++) 
                {
                    Element val = (Element) noeud.getChildren().get(i);
                    tab[i] = val.getAttributeValue(attributLabel);
                }
                afficherChoixValeurConditionTextuelle(p, tab, siDernierChoixEgaleA);
            }
            else
            {
                afficherChoixValeurConditionNumerique(p, 0, 15);
            }
        }        
        else if(cond.getAttributeValue(attributType).equals(conditionConsultation))
        {
            Element noeud = (Element) cond.getChild(attributOptions);
            String[] tab = new String[noeud.getChildren().size()];
            for (int i = 0; i < noeud.getChildren().size(); i++) 
            {
                Element val = (Element) noeud.getChildren().get(i);
                tab[i] = val.getAttributeValue(attributLabel);
            }
            afficherChoixValeurConditionTextuelle(p, tab, siChoixEgaleA);
        }
        else if(cond.getAttributeValue(attributType).equals(conditionTraces))
        {

        }
        else if(cond.getAttributeValue(attributType).equals(conditionCombinaison))
        {
            String[] tab= new String[2];
            tab[0]=stringVrai;
            tab[1]=stringFaux;
            afficherChoixValeurConditionTextuelle(p, tab, siValeurEgaleA);
        }
    }
    
    private void afficherChoixValeurConditionDuree(Panel p, String unite)
    {
        JLabel lb = new JLabel(duree);
        lb.setBounds(0, 0, 40, 24);
        p.add(lb);

        JComboBox cb = new JComboBox();
        cb.setBounds(40, 0, 100, 24);
        cb.addItem(superieureA);
        cb.addItem(inferieureA);
        p.add(cb);
        
        SpinnerModel model = new SpinnerNumberModel(1, 0, 200, 1);
        JSpinner spin = new JSpinner(model);
        spin.setBounds(150, 0, 40, 24);
        p.add(spin);
        
        JLabel txt = new JLabel(en+unite);
        txt.setBounds(200, 0, 160, 24);
        p.add(txt);
    }
    
    private void afficherChoixValeurConditionTexteLibre(Panel p)
    {
        JLabel lb = new JLabel(stringValeur);
        lb.setBounds(0, 0, 40, 24);
        p.add(lb);

        JComboBox cb = new JComboBox();
        cb.setBounds(40, 0, 125, 24);
        cb.addItem(egaleA);
        cb.addItem(contenant);
        cb.addItem(commencantPar);
        cb.addItem(terminantPar);
        p.add(cb);
        
        JTextField txt = new JTextField();
        txt.setBounds(170, 0, 120, 24);
        p.add(txt);
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
    
    private void afficherChoixValeurConditionNumerique(Panel p, int min, int max)
    {
        SpinnerModel model = new SpinnerNumberModel(min, min, max, 1);
        SpinnerModel model2 = new SpinnerNumberModel(max, min, max, 1);

        JLabel lb = new JLabel(valeurCompriseEntre);
        lb.setBounds(0, 0, 140, 24);
        p.add(lb);

        JSpinner spin = new JSpinner(model);
        spin.addChangeListener(new ChangeListener()
            {
                public void stateChanged(ChangeEvent e) 
                { modificationInf((JSpinner) e.getSource());}
            });
        spin.setBounds(140, 0, 50, 24);
        p.add(spin);

        JLabel lb2 = new JLabel(stringEt);
        lb2.setBounds(200, 0, 25, 24);
        p.add(lb2);

        JSpinner spin2 = new JSpinner(model2);
        spin2.addChangeListener(new ChangeListener()
            {
                public void stateChanged(ChangeEvent e) 
                { modificationSup((JSpinner) e.getSource());}
            });
        spin2.setBounds(230, 0, 50, 24);
        p.add(spin2);
    }
    
    private void sauverChoixValeurConditionDuree(Panel p, Element alter)
    {
        JComboBox cb = (JComboBox) p.getComponent(1);
        JSpinner spin = (JSpinner) p.getComponent(2);
        
        alter.setAttribute(attributType, cb.getSelectedItem().toString());
        alter.setAttribute(attributValeur, spin.getValue().toString());
    }
        
    private void sauverChoixValeurConditionTextuelle(Panel p, Element alter)
    {
        JComboBox cb = (JComboBox) p.getComponent(1);
        alter.setAttribute(attributValeur, cb.getSelectedItem().toString());
    }
    
    private void sauverChoixValeurConditionNumerique(Panel p, Element alter)
    {
        String min, max;
        
        JSpinner jinf, jsup;
        p.setBackground(Color.red);
        
        jinf = (JSpinner) p.getComponent(1);
        jsup = (JSpinner) p.getComponent(3);
        
        min=jinf.getValue().toString();
        max=jsup.getValue().toString();
        
        alter.setAttribute(attributBorne_inf, min);
        alter.setAttribute(attributBorne_sup, max);
    }
    
    private void sauverChoixValeurConditionTexteLibre(Panel p, Element alter)
    {
        JComboBox cb = (JComboBox) p.getComponent(1);
        JTextField txt = (JTextField) p.getComponent(2);
        
        alter.setAttribute(attributType, cb.getSelectedItem().toString());
        alter.setAttribute(attributTexte, txt.getText());
    }
    
    private void sauverAlternativeRegle(Panel p, Element alter)
    {
        Element cond=conditionParId(CbChoixConditionRegle.getSelectedItem().toString());
        
        if(cond==null)
        {
            
        }
        else if(cond.getAttributeValue(attributType).equals(conditionProfil))
        {
            Element noeud = (Element) cond.getChildren().get(0);
            if(noeud.getName().equals(attributTextuelle))
            {
                sauverChoixValeurConditionTextuelle(p, alter);
            }
            else
            {
                sauverChoixValeurConditionNumerique(p, alter);               
            }
        }
        else if(cond.getAttributeValue(attributType).equals(conditionContexte))
        {
            if(cond.getAttributeValue(attributSousType).equals("nombre"))
            {
                sauverChoixValeurConditionNumerique(p, alter);
            }
            else if(cond.getAttributeValue(attributSousType).equals("booléen"))
            {
                sauverChoixValeurConditionTextuelle(p, alter);
            }
            else if(cond.getAttributeValue(attributSousType).equals(attributTexte))
            {
                sauverChoixValeurConditionTexteLibre(p, alter);
            }
        }
        else if(cond.getAttributeValue(attributType).equals(conditionHistorique))
        {
            if(cond.getAttributeValue(attributSousType).equals(dernierDeclenchement))
            {
                sauverChoixValeurConditionDuree(p, alter);
            }
            else
            {
                sauverChoixValeurConditionNumerique(p, alter);
            }
        }        
        else if(cond.getAttributeValue(attributType).equals(conditionConsultation))
        {
            sauverChoixValeurConditionTextuelle(p, alter);
        }
        else if(cond.getAttributeValue(attributType).equals(conditionTraces))
        {

        }
        else if(cond.getAttributeValue(attributType).equals(conditionCombinaison))
        {
            sauverChoixValeurConditionTextuelle(p, alter);
        }
    }
    
    public String convertirUniteEnMillisecondes(String val, String unite)
    {
        int v = Integer.parseInt(val)*1000;
        if(unite.equals(attributMinutes) || unite.equals(itemMinutes))
            v=v*60;
        else if(unite.equals(attributHeures) || unite.equals(itemHeures))
            v=v*(60*60);
        else if(unite.equals(attributJours) || unite.equals(itemJours))
            v=v*(60*60*24);
        return String.valueOf(v);
    }
    
    public String convertirMillisecondesEnUnite(String val, String unite)
    {
        int v = Integer.parseInt(val)/1000;
        if(unite.equals(attributMinutes) || unite.equals(itemMinutes))
            v=v/60;
        else if(unite.equals(attributHeures) || unite.equals(itemHeures))
            v=v/(60*60);
        else if(unite.equals(attributJours) || unite.equals(itemJours))
            v=v/(60*60*24);

        return String.valueOf(v);
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
    
    public void ouvrirDescriptionAssistance(Element pere)
    {  
        String nomLogiciel=pere.getChild(attributMetadonnees).getChild("assistance").getAttributeValue("logiciel");
        String descriptionInterface=pere.getChild(attributMetadonnees).getChild("assistance").getAttributeValue("interface");
        cheminEtInterface=Main.Cste.cheminDescriptions+nomLogiciel+"/"+descriptionInterface;
        Main.Cste.structureProfils=pere.getChild(attributMetadonnees).getChild("personnalisation").getAttributeValue("structure_profil_statique");
        
        chargerInterface();
        
        ouvrirEvenements(pere.getChild(attributEvenements));
        ouvrirConditions(pere.getChild(attributConditions));
        ouvrirActions(pere.getChild(attributActions));
        ouvrirRegles(pere.getChild(attributRegles));
        ouvrirSequences(pere.getChild(attributSequences));
        
        reafficherConditions();
        
        chargerCbChoixConditionRegle();
        chargerEvenementDeclencheur();
        chargerEvenementFin();
        //chargerCbActionsEtRegles(CbObjetContrainteHistorique);
        
        Main.SauveAssistance.commentaires=pere.getChild(attributMetadonnees).getChild("commentaires").getText();
        Main.SauveAssistance.createur=pere.getChild(attributMetadonnees).getChild("creation").getAttributeValue("createur");
        Main.SauveAssistance.date=pere.getChild(attributMetadonnees).getChild("creation").getAttributeValue("date_creation");
        Main.SauveAssistance.nom=pere.getChild(attributMetadonnees).getChild("assistance").getAttributeValue(attributNom);
        Main.SauveAssistance.publicVise=pere.getChild(attributMetadonnees).getChild("assistance").getAttributeValue("public");
    }
    
    private void afficherRegle(Element regle, int ligne)
    {
        TableRegles.setValueAt(regle.getAttributeValue(attributId), ligne, 0);
        if(regle.getChild(attributEvenement_declencheur).getAttribute(attributIdEve)!=null)
        {
            String idEve = regle.getChild(attributEvenement_declencheur).getAttributeValue(attributIdEve);
            TableRegles.setValueAt(idEve +" : "+regle.getChild(attributEvenement_declencheur).getAttributeValue(attributType)+" "+stringSurLeComposant+" "+regle.getChild(attributEvenement_declencheur).getAttributeValue(attributIdComp), ligne, 1);
        }
        else if(regle.getChild(attributEvenement_declencheur).getAttributeValue(attributType).equals(attributLancementAssistance))
        {
            TableRegles.setValueAt(itemLancementAssistance, ligne, 1);
        }
        else if(regle.getChild(attributEvenement_declencheur).getAttributeValue(attributType).equals(attributLancementRegle))
        {
            TableRegles.setValueAt(itemLancementRegle, ligne, 1);
        }
                

        TableRegles.setValueAt(regle.getChild(attributAlternatives).getAttributeValue(attributCondition), ligne, 2);
        afficherActionsParRegle(regle, ligne);
        
        if(regle.getChild(attributEvenement_de_fin)!=null)
        {
            if(regle.getChild(attributEvenement_de_fin).getAttribute(attributIdEve)!=null)
            {
                String idEve = regle.getChild(attributEvenement_de_fin).getAttributeValue(attributIdEve);
                Element eveFin = evenementParId(idEve);
                TableRegles.setValueAt(affichageEvenement(eveFin), ligne, 4);
                //TableRegles.setValueAt(idEve +" : "+regle.getChild(attributEvenement_de_fin).getAttributeValue(attributType)+" "+stringSurLeComposant+" "+regle.getChild(attributEvenement_de_fin).getAttributeValue(attributIdComp), ligne, 4);
            }
        }
    }
    
    private void ouvrirRegles(Element noeudRegles)
    {
        lesRegles=new ArrayList();
        int maxId=-1;
        for(int i=0; i< noeudRegles.getChildren().size(); i++) //on parcourt les regles existantes
        { 
            Element regle=(Element) noeudRegles.getChildren().get(i);
            lesRegles.add((Element) regle.clone());
            modelRegle.addRow(new Object[]{"", "", "", "", ""}); 
            int idtmp=Integer.parseInt(regle.getAttributeValue(attributId).substring(1));
            if(idtmp>maxId) 
                maxId=idtmp;
            afficherRegle(regle, i);
        }
        idRegle=maxId+1;
        TxtRegle.setText("R"+idRegle);
        
    }
    
    public void creationApercuAction(Element e) {
        Format format = Format.getPrettyFormat();
        XMLOutputter xmloutputter = new XMLOutputter(format);
        String s = xmloutputter.outputString(e);  
        String os = System.getProperty("os.name").toLowerCase();
        String command;
        if(os.contains("windows")) { 
            command = "cmd /c start /min " + DIR_MESSAGER + "Messager.jar";
        } else {
            command = "java -jar " + DIR_MESSAGER + "Messager.jar &";
        }
        
        File f = new File(ACTION_XML);
        if (f.exists()) { f.delete(); }
        try {
            FileOutputStream fop = new FileOutputStream(new File(ACTION_XML));
            String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE action SYSTEM \"DTD.dtd\">" + s;
            try {
                fop.write(content.getBytes());
                fop.flush();
                fop.close();
            } catch (IOException ex) {}
        } catch (FileNotFoundException ex) {}
        try 
        {
            Process p = Runtime.getRuntime().exec(command);
            try 
            {
                p.waitFor();
            } 
            catch (InterruptedException ex) {}
        }
        catch (IOException ex) {}
    }
    
    public void ouvrirComposants()
    {
        lesComposants=new ArrayList();
        XMLFonctions.OuvrirXML(Main.CreationRegles.cheminEtInterface);
        Element racine=XMLFonctions.racine;
        for(int i=0; i<racine.getChildren().size(); i++)
        {
            Element comp=(Element) racine.getChildren().get(i);
            lesComposants.add((Element) comp.clone());
            ouvrirComposantsBis(comp);
        }
        //blandine
        for(int i=0; i<lesActions.size(); i++)
        {
            Element act = lesActions.get(i);
            if(act.getAttributeValue(attributType).equals(stringTypeActionAjoutComposant))
            {
                Element comp = new Element(attributComposant);
                comp.setAttribute(attributId, act.getAttributeValue(attributNom));
                comp.setAttribute(attributTypeAjoute, act.getChild(attributComposant).getAttributeValue(attributType));
                lesComposants.add((Element) comp.clone());
            }
        }
    }
    
    private void ouvrirComposantsBis(Element pere)
    {
        for(int i=0; i<pere.getChildren().size(); i++)
        {
            Element comp=(Element) pere.getChildren().get(i);
            lesComposants.add((Element) comp.clone());
            ouvrirComposantsBis(comp);
        }
    }
    
    private void ouvrirSequences(Element noeudSequences)
    {
        lesSequences=new ArrayList();
        int maxId=-1;
        for(int i=0; i<noeudSequences.getChildren().size(); i++)  //on parcourt les séquences d'événements existantes
        {
            Element seq=(Element) noeudSequences.getChildren().get(i);
            lesSequences.add((Element) seq.clone());
            int idtmp=Integer.parseInt(seq.getAttributeValue(attributId).substring(1));
            if(idtmp>maxId) maxId=idtmp;
        }
        idSequence=maxId+1;
        //chargerCbSequence(CbObjetContrainteTraces, attributEvenements);
    }
    
    private void ouvrirActions(Element noeudActions)
    {
        lesActions=new ArrayList();
        int maxId=-1;
        int maxCompoAjoute = -1;
        for(int i=0; i<noeudActions.getChildren().size(); i++)  //on parcourt les actions existantes
        {
            Element act=(Element) noeudActions.getChildren().get(i);
            lesActions.add((Element) act.clone());
            modelAction.addRow(new Object[]{"", "", "", ""});
            int idtmp=Integer.parseInt(act.getAttributeValue(attributId).substring(1));
            if(idtmp>maxId) maxId=idtmp;
             
            if(act.getAttributeValue(attributType).equals(stringTypeActionAjoutComposant))
            {
                int idCompTmp = Integer.parseInt(act.getAttributeValue(attributNom).substring(1));
                if(idCompTmp>maxCompoAjoute) maxCompoAjoute=idCompTmp;
            }
            
            Main.CreationActions.afficherDescriptionAction(act, i);
        }
        
        idAction=maxId+1;
        idComposantAjoute=maxCompoAjoute+1;
    }
    
    public ArrayList<String> lireContenu(String texte, String code) {
        ArrayList<String> listAlt = new ArrayList<String>();
        int lengthHTML = texte.length();
        int i = 0;
        while (i <= lengthHTML) {
            int indexA = texte.indexOf(code + "=\"", i);
            if (indexA > 0) {
                int indexB = texte.indexOf("\"", indexA + 5);
                listAlt.add(texte.substring(indexA + 5, indexB));
                i = indexB;
            } else {
                break;
            }
        }
        return listAlt;
    }
    
    public void afficherEvenement(Element eve, int i)
    {
        TableEvenements.setValueAt(eve.getAttributeValue(attributId), i, 0);
        if(eve.getAttributeValue(attributTypeEve).equals(attributTimerFixe))
        {
            TableEvenements.setValueAt(stringTimerFixe, i, 1);
            TableEvenements.setValueAt(convertirMillisecondesEnUnite(eve.getAttributeValue(attributDuree),eve.getAttributeValue(attributUnite)) +" "+eve.getAttributeValue(attributUnite), i, 2);
            
        }
        else if(eve.getAttributeValue(attributTypeEve).equals(attributEveSA))
        {
            TableEvenements.setValueAt(stringEveSA, i, 1);
            String s = itemDeclenchement;
            if(eve.getAttributeValue(attributType).equals(attributFin))
                s=itemFin;
            TableEvenements.setValueAt(s+" "+eve.getAttributeValue(attributObjet), i, 2);
        }
        else if(eve.getAttributeValue(attributTypeEve).equals(attributTimerRelatif))
        {
            String descr="";
            if(eve.getAttributeValue(attributSousTypeEve).equals(attributEvenement))
            {
                TableEvenements.setValueAt("attente après un événement", i, 1);
                descr="après "+eve.getAttributeValue(attributObjet);
            }
            else if(eve.getAttributeValue(attributSousTypeEve).equals(attributActionUtilisateur))
            {
                TableEvenements.setValueAt("absence d'action de l'utilisateur", i, 1);
                if(eve.getAttributeValue(attributObjet).equals(attributAucuneAction))
                    descr= stringAucuneAction;
                else if(eve.getAttributeValue(attributObjet).equals(attributAucunClic))
                    descr= stringAucunClic;
                else if(eve.getAttributeValue(attributObjet).equals(attributAucunDeplacementSouris))
                    descr= stringAucunDeplacementSouris;
                else if(eve.getAttributeValue(attributObjet).equals(attributAbsenceEvenement))
                    descr= stringAbsenceEvenement + " "+eve.getAttributeValue(attributSousObjet);
            }
            else if(eve.getAttributeValue(attributSousTypeEve).equals(attributEveSA))
            {
                TableEvenements.setValueAt("absence d'événement d'assistance", i, 1);
                if(eve.getAttributeValue(attributObjet).equals(attributAucuneAction))
                    descr= stringAucuneAction;
                else if(eve.getAttributeValue(attributObjet).equals(attributAucuneRegle))
                    descr= stringAucuneRegle;
                else if(eve.getAttributeValue(attributObjet).equals(attributAucuneRegleAction))
                    descr= stringAucuneRegleAction;
            }
            
            String s = convertirMillisecondesEnUnite(eve.getAttributeValue(attributDuree), eve.getAttributeValue(attributUnite));
            TableEvenements.setValueAt(s+" "+eve.getAttributeValue(attributUnite)+" "+descr, i, 2);
        }
        else
        {
            TableEvenements.setValueAt(stringActionUtilisateur, i, 1);
            TableEvenements.setValueAt(listeTypesEvenements.get(eve.getAttributeValue(attributType))+" "+stringSurLeComposant+" "+eve.getAttributeValue(attributIdComp), i, 2);    
        }
        
    }
    
    public String affichageEvenement(Element eve)
    {
        int i = lesEvenements.indexOf(eve);
        return TableEvenements.getValueAt(i, 0)+" : "+TableEvenements.getValueAt(i, 2); 
    }
    
    public void afficherCondition(Element cond, int i)
    {
        TableConditions.setValueAt(cond.getAttributeValue(attributId), i, 0);
            
            if (cond.getAttributeValue(attributType).equals(conditionProfil)) //si c'est une contrainte sur le profil de l'utilisateur
            {
                TableConditions.setValueAt(conditionProfil, i, 1);
                Element elem = (Element) cond.getChildren().get(0);
                TableConditions.setValueAt(elem.getAttributeValue(attributChemin), i, 2);
                if (elem.getName().equals(attributNumerique)) {
                    TableConditions.setValueAt("[" + elem.getAttributeValue(attributBorne_inf) + "..." + elem.getAttributeValue(attributBorne_sup) + "]", i, 3);
                } else {
                    String lobjet = "";
                    for (int j = 0; j < elem.getChildren().size(); j++) {
                        Element val = (Element) elem.getChildren().get(j);
                        lobjet = lobjet + val.getText() + "/ ";
                    }
                    lobjet = lobjet.substring(0, lobjet.length() - 2);
                    TableConditions.setValueAt(lobjet, i, 3);
                }
            }           
            else if (cond.getAttributeValue(attributType).equals(conditionHistorique))     //Si c'est une contrainte sur l'historique de l'assistance
            {
                TableConditions.setValueAt(conditionHistorique, i, 1);
                if(cond.getAttributeValue(attributSousType).equals(dernierDeclenchement))
                {               
                    TableConditions.setValueAt(cond.getAttributeValue(attributObjet)+" : dernier déclenchement", i, 2);
                    TableConditions.setValueAt("durée en " + cond.getAttributeValue(attributUnite), i, 3);
                }
                if(cond.getAttributeValue(attributSousType).equals(conditionConsultation))
                {               
                    TableConditions.setValueAt(cond.getAttributeValue(attributObjet)+" : dernière réponse", i, 2);
                    
                    Element c = conditionParId(cond.getAttributeValue(attributObjet));
                    if(c!=null)
                    {
                        Element elem = (Element) c.getChild(attributOptions);
                        String lobjet = "";
                        for (int j = 0; j < elem.getChildren().size(); j++) 
                        {
                            Element val = (Element) elem.getChildren().get(j);
                            lobjet = lobjet + val.getAttributeValue(attributLabel) + "/ ";
                        }
                        lobjet = lobjet.substring(0, lobjet.length() - 2);
                        TableConditions.setValueAt(lobjet, i, 3);
                    }
                }
                else
                {
                    TableConditions.setValueAt(cond.getAttributeValue(attributObjet)+" : nombre de déclenchements", i, 2);
                    TableConditions.setValueAt("nombre", i, 3);
                }              
            }
            else if (cond.getAttributeValue(attributType).equals(conditionTraces))     //Si c'est une contrainte sur l'historique de l'assistance
            {
                TableConditions.setValueAt(conditionTraces, i, 1);
                TableConditions.setValueAt(cond.getAttributeValue(attributObjet)+" : "+ cond.getAttributeValue(attributSousType), i, 2);
                if(cond.getAttributeValue(attributSousType).equals(dureeTotaleConditionTraces) || cond.getAttributeValue(attributSousType).equals(dureeDepuisConditionTraces))
                {                                  
                    TableConditions.setValueAt("durée en " + cond.getAttributeValue(attributUnite), i, 3);
                }
                else if(cond.getAttributeValue(attributSousType).equals(nbOccurrencesConditionTraces) || cond.getAttributeValue(attributSousType).equals(nbEvenementsDepuisConditionTraces))
                {
                    TableConditions.setValueAt("nombre", i, 3);
                } 
                else
                {
                    TableConditions.setValueAt("booléan", i, 3);
                }
            }
            else if(cond.getAttributeValue(attributType).equals(conditionContexte))     //Si c'est une contrainte sur le contexte
            {
                TableConditions.setValueAt(conditionContexte, i, 1);
                String idComp=cond.getAttributeValue(attributIdComp);
                String prop=cond.getAttributeValue(attributPropriete);
                TableConditions.setValueAt("composant "+idComp+" "+prop, i, 2);
                TableConditions.setValueAt(cond.getAttributeValue(attributSousType), i, 3);
            }
            else if(cond.getAttributeValue(attributType).equals(conditionConsultation))     //Si c'est une consultation de l'utilisateur
            {
                TableConditions.setValueAt(conditionConsultation, i, 1);
                TableConditions.setValueAt("Message = "+cond.getChildText(attributTexte), i, 2);
                Element elem = (Element) cond.getChild(attributOptions);
                String lobjet = "";
                    for (int j = 0; j < elem.getChildren().size(); j++) 
                    {
                        Element val = (Element) elem.getChildren().get(j);
                        lobjet = lobjet + val.getAttributeValue(attributLabel) + "/ ";
                    }
                    lobjet = lobjet.substring(0, lobjet.length() - 2);
                    TableConditions.setValueAt(lobjet, i, 3);
            }
            else if(cond.getAttributeValue(attributType).equals(conditionCombinaison))     //Si c'est une combinaison de conditions
            {
                TableConditions.setValueAt(conditionCombinaison, i, 1);
                TableConditions.setValueAt("Formule = "+cond.getAttributeValue(attributForumle), i, 2);
                TableConditions.setValueAt("Vrai/ Faux", i, 3);
            }
    }
    
    private void ouvrirEvenements(Element noeudEvenements)
    {
        lesEvenements = new ArrayList();
        int maxId=-1;
        if(noeudEvenements!=null)
        for (int i = 0; i < noeudEvenements.getChildren().size(); i++) //on parcourt les evenements existants
        {
            Element eve = (Element) noeudEvenements.getChildren().get(i);
            lesEvenements.add((Element) eve.clone());
            modelEvenement.addRow(new Object[]{"", "", "", ""});            
            int idtmp=Integer.parseInt(eve.getAttributeValue(attributId).substring(1));
            if(idtmp>maxId) 
                maxId=idtmp;
            afficherEvenement(eve, i);
            
        }
        idEvenement = maxId+1;
    }
    
    private void ouvrirConditions(Element noeudConditions)
    {
        lesConditions = new ArrayList();
        int maxId=-1;
        for (int i = 0; i < noeudConditions.getChildren().size(); i++) //on parcourt les conditions existantes
        {
            Element cond = (Element) noeudConditions.getChildren().get(i);
            lesConditions.add((Element) cond.clone());
            modelCondition.addRow(new Object[]{"", "", "", ""});            
            int idtmp=Integer.parseInt(cond.getAttributeValue(attributId).substring(1));
            if(idtmp>maxId) 
                maxId=idtmp;
            afficherCondition(cond, i);
            
        }
        idCondition = maxId+1;
        chargerCbChoixConditionRegle();
    }
    
    public void sauveSequences(){
        Main.FichierAssistance.liste_sequences.removeContent();
        for(int i=0; i<lesSequences.size(); i++)
        {
           Main.FichierAssistance.liste_sequences.addContent(lesSequences.get(i)); 
        }
    }
    
    public void sauveActions(){
        Main.FichierAssistance.liste_actions.removeContent();
        for(int i=0; i<lesActions.size(); i++)
        {
           Main.FichierAssistance.liste_actions.addContent(lesActions.get(i)); 
        }
    }
    
    private void sauveRegles(){
        FichierAssistance.liste_regles.removeContent();
        for(int i=0; i<lesRegles.size(); i++)
        {
           Main.FichierAssistance.liste_regles.addContent(lesRegles.get(i)); 
        }
    }
    
    public void sauveEvenements()
    {
        Main.FichierAssistance.liste_evenements.removeContent();
        for(int i=0; i<lesEvenements.size(); i++)
        {
           Main.FichierAssistance.liste_evenements.addContent(lesEvenements.get(i)); 
        }
        
    }
    
    public void sauveConditions()
    {
        Main.FichierAssistance.liste_conditions.removeContent();
        for(int i=0; i<lesConditions.size(); i++)
        {
           Main.FichierAssistance.liste_conditions.addContent(lesConditions.get(i)); 
        }
        
    }
    
    private String actionsDansRegle(Element actions)
    {
        String act="";

        return act;
    }
    
    private String remplacerConditions(String formule)
    {
        if(!formule.isEmpty())
        {
            String cond;
            //on remplace toutes les conditions par true
            for(int i=0; i<lesConditions.size(); i++)
            {
               cond=TableConditions.getValueAt(i, 0).toString();
               while(formule.contains(cond))
               {
                   String f = formule.substring(formule.indexOf(cond));
                   String condVal = f.substring(0, f.indexOf(")")+1);
                   formule=formule.replace(condVal, "true");
               }
            }
        }
        return formule;
    }
    
    public boolean verifierFormule(String formule){
        ScriptEngineManager factory = new ScriptEngineManager();
	ScriptEngine engine = factory.getEngineByName("JavaScript");
        //on remplace chaque condition par true
        String expression=remplacerConditions(formule);
        try 
        {
            //on vérifie que la formule est bien une formule logique
            engine.eval(expression);
            return true;
        } catch (ScriptException ex) {}
        return false;
    }
    
    private Element creerRegle()
    {
        Element regle=new Element(attributRegle);
        regle.setAttribute(attributId, TxtRegle.getText());
        
        Element fils=new Element(attributMetadonnees);
        regle.addContent(fils);
        
        fils=new Element(attributEvenement_declencheur);
        if(CbEvenementDeclencheur.getSelectedItem().toString().equals(itemLancementAssistance))
        {
            fils.setAttribute(attributType, attributLancementAssistance);
            fils.setAttribute(attributIdComp, "");
        }
        else if(CbEvenementDeclencheur.getSelectedItem().toString().equals(itemLancementRegle))
        {
            fils.setAttribute(attributType, attributLancementRegle);
            fils.setAttribute(attributIdComp, TxtRegle.getText());
        }
        else
        {
            Element eve = evenementParId(CbEvenementDeclencheur.getSelectedItem().toString());
            fils = evenementDansRegle(fils, eve);
        }

        regle.addContent(fils);
        
        fils=new Element(attributAlternatives);
        if(CbChoixConditionRegle.getSelectedItem().toString().equals(itemAucune))
            fils.setAttribute(attributCondition, "");
        else
            fils.setAttribute(attributCondition, CbChoixConditionRegle.getSelectedItem().toString());        
        ajoutActionSelectionnees(fils);
        regle.addContent(fils);
        
        
        if(!CbEvenementFin.getSelectedItem().toString().equals(itemAucun))
        {
            Element ef = new Element(attributEvenement_de_fin);
            ef.setAttribute(attributIdEve, CbEvenementFin.getSelectedItem().toString());
            Element eve = evenementParId(CbEvenementFin.getSelectedItem().toString());
            ef = evenementDansRegle(ef, eve);
            regle.addContent(ef);
        }        
        return regle;
    }
    
    private Element evenementDansRegle(Element eveRegle, Element eve)
    {
        eveRegle.setAttribute(attributIdEve, eve.getAttributeValue(attributId));
        if(eve.getAttributeValue(attributTypeEve).equals(attributActionUtilisateur))
        {
            eveRegle.setAttribute(attributType, eve.getAttributeValue(attributType));
            eveRegle.setAttribute(attributIdComp, eve.getAttributeValue(attributIdComp));
        }
        else if(eve.getAttributeValue(attributTypeEve).equals(attributTimerRelatif))
        {
            if(eve.getAttributeValue(attributSousTypeEve).equals(attributActionUtilisateur))
            {
                eveRegle.setAttribute(attributType, "AU");
                eveRegle.setAttribute(attributIdComp, eve.getAttributeValue(attributObjet));
                
            }
            else if(eve.getAttributeValue(attributSousTypeEve).equals(attributEveSA))
            {
                eveRegle.setAttribute(attributType, "SA");
                eveRegle.setAttribute(attributIdComp, eve.getAttributeValue(attributObjet));
                
            }
            else if(eve.getAttributeValue(attributSousTypeEve).equals(attributAbsenceEvenement))
            {
                eveRegle.setAttribute(attributType, "AU");
                eveRegle.setAttribute(attributIdComp, eve.getAttributeValue(attributObjet)+":"+eve.getAttributeValue(attributSousObjet));
                
            }
            else if(eve.getAttributeValue(attributSousTypeEve).equals(attributEvenement))
            {
                Element e = evenementParId(eve.getAttributeValue(attributObjet));
                eveRegle.setAttribute(attributType, e.getAttributeValue(attributType));
                eveRegle.setAttribute(attributIdComp, e.getAttributeValue(attributIdComp));               
            }
            eveRegle.setAttribute(attributDuree, eve.getAttributeValue(attributDuree));
        }
        else if(eve.getAttributeValue(attributTypeEve).equals(attributEveSA))
        {
            eveRegle.setAttribute(attributType, eve.getAttributeValue(attributType));
            eveRegle.setAttribute(attributIdComp, eve.getAttributeValue(attributObjet));
        }
        return eveRegle;
    }
    
    private void ajoutActionSelectionnees(Element alternatives)
    {
        if(CbChoixConditionRegle.getSelectedItem().equals(itemAucune))
        {
            Element alter = new Element(attributAlternative);
            alternatives.addContent(alter);
            Panel pTotal = (Panel) PanelActionsRegle.getComponent(0);
            Panel pAct = (Panel) pTotal.getComponent(1);
            Panel pCheck = (Panel) pAct.getComponent(1);
            ajoutNoeudsActionSelectionnees(pCheck, alter);
        }
        else
        {
            for(int i =0; i<PanelAlternativesRegle.getComponentCount(); i++)
            {
                Element alter = new Element(attributAlternative);
                alternatives.addContent(alter);
                Panel pTotal = (Panel) PanelAlternativesRegle.getComponent(i);

                Panel pVal= (Panel) pTotal.getComponent(0);
                Panel pValeur= (Panel) pVal.getComponent(1);
                sauverAlternativeRegle(pValeur, alter);

                Panel pAct= (Panel) pTotal.getComponent(1);
                Panel pCheck = (Panel) pAct.getComponent(1);
                ajoutNoeudsActionSelectionnees(pCheck, alter);
            }
        }
    }
    
    private void ajoutNoeudsActionSelectionnees(Panel p, Element alter)
    {
        for(int i=0; i< p.getComponentCount()-2; i++)
        {
            JComboBox cb = (JComboBox) p.getComponent(i+2);           
            if(cb.getSelectedIndex()>-1)
            {  
                Element act =new Element(attributAction);
                act.setAttribute(attributId, cb.getSelectedItem().toString());
                alter.addContent(act);
            }
        }   
    }
    
    private void reafficherRegles()
    {
        modelRegle = new DefaultTableModel();
        modelRegle.addColumn(nom);
        modelRegle.addColumn(evenement);
        modelRegle.addColumn(condition);
        modelRegle.addColumn(action);
        modelRegle.addColumn(evenementFin);

        TableRegles.setModel(modelRegle);
        TableRegles.getTableHeader().setReorderingAllowed(false);
        
        TableRegles.getColumn(nom).setMinWidth(40);
        TableRegles.getColumn(nom).setMaxWidth(40);
        TableRegles.getColumn(evenement).setMinWidth(240);
        TableRegles.getColumn(evenement).setMaxWidth(240);
        TableRegles.getColumn(condition).setMinWidth(60);
        TableRegles.getColumn(condition).setMaxWidth(60);
        TableRegles.getColumn(evenementFin).setMinWidth(240);
        TableRegles.getColumn(evenementFin).setMaxWidth(240);
        
        for(int i=0; i< lesRegles.size(); i++) //on parcourt les regles existantes
        { 
            Element regle=(Element) lesRegles.get(i);

            modelRegle.addRow(new Object[]{"", "", "", "", ""});            
            afficherRegle(regle, i);
        }
    }
    
    private void reafficherEvenements()
    {
        modelEvenement = new DefaultTableModel();
        modelEvenement.addColumn(nom);
        modelEvenement.addColumn(type);
        modelEvenement.addColumn(description);
        
        TableEvenements.setModel(modelEvenement);
        TableEvenements.getTableHeader().setReorderingAllowed(false);

        TableEvenements.getColumn(nom).setMinWidth(40);
        TableEvenements.getColumn(nom).setMaxWidth(40);
        TableEvenements.getColumn(type).setMinWidth(120);
        TableEvenements.getColumn(type).setMaxWidth(120);
        
        for(int i=0; i< lesEvenements.size(); i++) //on parcourt les conditions existantes
        {
           Element eve=(Element) lesEvenements.get(i);
           modelEvenement.addRow(new Object[]{"", "", ""});
           afficherEvenement(eve, i);           
        }
    }
    
    private void reafficherConditions()
    {
        modelCondition = new DefaultTableModel();
        modelCondition.addColumn(nom);
        modelCondition.addColumn(type);
        modelCondition.addColumn(objet);
        modelCondition.addColumn(valeur);
        
        TableConditions.setModel(modelCondition);
        TableConditions.getTableHeader().setReorderingAllowed(false);

        TableConditions.getColumn(nom).setMinWidth(40);
        TableConditions.getColumn(nom).setMaxWidth(40);
        TableConditions.getColumn(type).setMinWidth(80);
        TableConditions.getColumn(type).setMaxWidth(80);
        
        for(int i=0; i< lesConditions.size(); i++) //on parcourt les conditions existantes
        {
           Element cond=(Element) lesConditions.get(i);
           modelCondition.addRow(new Object[]{"", "", "", ""});
           afficherCondition(cond, i);           
        }
    }

    public String traitementContenuSrc(SourceCodeEditor src) {
        String html = src.getText();
        html = html.trim();
        return html;
    }
    
    private void reafficherActions()
    {
        modelAction = new DefaultTableModel();
        modelAction.addColumn(nom);
        modelAction.addColumn(type);
        modelAction.addColumn(description);
        
        TableActions.setModel(modelAction);
        TableActions.getTableHeader().setReorderingAllowed(false);

        TableActions.getColumn(nom).setMinWidth(40);
        TableActions.getColumn(nom).setMaxWidth(40);
        TableActions.getColumn(type).setMinWidth(100);
        TableActions.getColumn(type).setMaxWidth(100);
        
        for(int i=0; i<lesActions.size(); i++)
        {
            Element act =(Element) lesActions.get(i);          
            modelAction.addRow(new Object[]{"", "", "", ""});            
            TableActions.setValueAt(act.getAttributeValue(attributId), i, 0);
            
            TableActions.setValueAt(act.getAttributeValue(attributType), i, 1);            
            Main.CreationActions.afficherDescriptionAction(act, i);
        }
    }
    
    
    
    public String idSansEspace(String id)
    {
        if(id.endsWith(" "))
            return id.substring(0, id.length()-1);
        else
            return id;
    }
    
    public String traitementContenuWys(String texte) {
        String html = texte.replaceAll("<[^img][^>]*>", "");
        ArrayList<String> listAlt = lireContenu(html, "alt");
        Iterator it = listAlt.iterator();
        while (it.hasNext()) {
            html = html.replaceFirst("<img [^>]*alt[^>]*>", "-Image Description:. " + (String) it.next() + " .Fin description-");
        }
        html = html.replaceAll("<[^>]*>", "");
        html = html.trim();
        return html;
    }
    
    public static boolean copier(File source, File destination) {
        boolean resultat = false;

        // Declaration des flux 
        java.io.FileInputStream sourceFile = null;
        java.io.FileOutputStream destinationFile = null;
        try {
            // Création du fichier : 
            destination.createNewFile();
            // Ouverture des flux 
            sourceFile = new java.io.FileInputStream(source);
            destinationFile = new java.io.FileOutputStream(destination);
            // Lecture par segment de 0.5Mo 
            byte buffer[] = new byte[512 * 1024];
            int nbLecture;
            while ((nbLecture = sourceFile.read(buffer)) != -1) {
                destinationFile.write(buffer, 0, nbLecture);
            }

            // Copie réussie 
            resultat = true;
        } catch (java.io.FileNotFoundException f) {
        } catch (java.io.IOException e) {
        } finally {
            // Quoi qu'il arrive, on ferme les flux 
            try {
                sourceFile.close();
            } catch (Exception e) {
            }
            try {
                destinationFile.close();
            } catch (Exception e) {
            }
        }
        return (resultat);
    }
    
    public String chemin(String file) {
        File choix = new File(file);
        String nomFichier = choix.getPath();
        String chemin_final = "";
        int indexDossier = nomFichier.lastIndexOf("\\");
        if (indexDossier != -1) {
            String nomF = nomFichier.substring(indexDossier + 1, nomFichier.length());
            chemin_final = DIR_EXEMPLE + "" + nomF;
        }
        return chemin_final;
    }
    
    public String traitementContenuWysIMG(String texte) {
        texte = texte.replaceAll("&#160;", "");
        String code = "src";
        String os = System.getProperty("os.name").toLowerCase();
        int i = 0;
        int lengthHTML = texte.length();
        while (i <= lengthHTML) {
            int indexA = texte.indexOf(code + "=\"", i);
            if (indexA > 0) {
                int indexB = texte.indexOf("\"", indexA + 5);
                String file = texte.substring(indexA + 5, indexB);
                String cheminFile = "";

                //Cas où l'os est windows 
                if (os.contains("windows")) {
                    String file_temp = file.substring(8, file.length());
                    cheminFile = chemin(file);
                    String nom_image = cheminFile.substring(cheminFile.lastIndexOf("/") + 1, cheminFile.length());
                    texte = texte.replace(file, nom_image);
                    File fichier_source = new File(file_temp);
                    File temp = new File("");
                    File fichier_destination = new File(temp.getAbsolutePath() + "/" + DIR_EXEMPLE + "" + nom_image);
                    if (!fichier_destination.exists()) {
                        copier(fichier_source, fichier_destination);
                    }
                } //Cas où l'os est linux ou mac
                else {
                    String file_temp = file.substring(7, file.length());
                    String nom_image = file_temp.substring(file_temp.lastIndexOf("/") + 1, file_temp.length());
                    texte = texte.replace(file, nom_image);
                    File fichier_source = new File(file_temp);
                    File temp = new File("");
                    File fichier_destination = new File(temp.getAbsolutePath() + "/" + DIR_EXEMPLE + "" + nom_image);

                    if (!fichier_destination.exists()) {
                        copier(fichier_source, fichier_destination);
                    }
                }
                if (file.length() > cheminFile.length()) {
                    i = indexB - (file.length() - cheminFile.length());
                } else if (file.length() < cheminFile.length()) {
                    i = indexB + (file.length() - cheminFile.length());
                } else {
                    i = indexB;
                }
            } else {
                break;
            }
        }
        return texte;
    }

    public Element elementParId(ArrayList<Element> liste, String id)
    {
        Element elem;
        for(int i=0; i<liste.size(); i++)
        {
            elem=liste.get(i);
            if(elem.getAttributeValue(attributId).equals(id))
                return elem;
        }
        return null;
    }
    
    private void afficherActionsParRegle(Element regle, int i)
    {
        Element alternatives=regle.getChild(attributAlternatives);
        String act="";
        for(int j=0; j<alternatives.getChildren().size(); j++)
        {
            Element alt=(Element) alternatives.getChildren().get(j);
            for(int k=0; k<alt.getChildren().size(); k++)
            {
                Element a=(Element) alt.getChildren().get(k);
                act=act+a.getAttributeValue(attributId)+", ";
            }
            if(act.length()>2)
                act=act.substring(0, act.length()-2)+" ou ";
        }
        if(act.endsWith(" ou "))
            act=act.substring(0, act.length()-3);
        TableRegles.setValueAt(act, i, 3);
    }
    
    public Element evenementParId(String id)
    {
        Element elem;
        for (int i=0; i<lesEvenements.size(); i++)
        {
            elem=lesEvenements.get(i);
            if(elem.getAttributeValue(attributId).equals(id))
                return elem;
        }
        return null;
    }
    
    public Element conditionParId(String id)
    {
        Element elem;
        for (int i=0; i<lesConditions.size(); i++)
        {
            elem=lesConditions.get(i);
            if(elem.getAttributeValue(attributId).equals(id))
                return elem;
        }
        return null;
    }
    
    private boolean evenementEstUtilise(String id)
    {
        Element regle;
        for(int i=0; i<lesRegles.size(); i++)   //on parcourt toutes les règles pour voir si l'action est utilisée
        {
            regle=lesRegles.get(i);
            Element e = regle.getChild(attributEvenement_declencheur);
            if(e.getAttribute(attributIdEve)!=null)
            {
                if(e.getAttributeValue(attributIdEve).equals(id))
                    return true;
            }
            e = regle.getChild(attributEvenement_de_fin);
            if(e!=null)
            {
                if(e.getAttribute(attributIdEve)!=null)
                {
                    if(e.getAttributeValue(attributIdEve).equals(id))
                        return true;
                }
            }
        }
        return false;
    }
    
    private boolean actionEstUtilisee(String id)
    {
        Element regle;
        for(int i=0; i<lesRegles.size(); i++)   //on parcourt toutes les règles pour voir si l'action est utilisée
        {
            regle=lesRegles.get(i);
            for(int j=0; j<regle.getChild(attributAlternatives).getChildren().size(); j++)
            {
                Element alt=(Element) regle.getChild(attributAlternatives).getChildren().get(j);
                for(int k=0; k<alt.getChildren().size(); k++)
                {
                    Element act = (Element) alt.getChildren().get(k);
                    if(id.equals(act.getAttributeValue(attributId)))
                        return true;
                }
            }
        }
        return false;
    }
    
    private boolean conditionEstUtilisee(String id)
    {
        Element regle;
        for(int i=0; i<lesRegles.size(); i++)   //on parcourt toutes les règles pour voir si la condition est utilisée
        {
            regle=lesRegles.get(i);
            if(regle.getChild(attributAlternatives).getAttributeValue(attributCondition).equals(id))
                return true;
        }
        return false;
    } 
    
    public void ajoutCouleurFond(String code)
    {
        String html=stringToHTMLString(editor.getText());
        if(html.contains("bgcolor=\"#"))    //on supprime l'ancienne couleur
        {
            html=html.substring(0, html.indexOf("bgcolor=\"#"))+html.substring(html.indexOf("bgcolor=\"#")+17);
        }
        html=html.replace("<body", "<body bgcolor=\"#"+code.substring(2) +"\"");
        editor.setText(html);
    }
    
    private void resetRegle()
    {
        modifRegle = false;
        TxtRegle.setText("R"+idRegle);
        CbEvenementDeclencheur.setSelectedItem(itemLancementAssistance);
        CbChoixConditionRegle.setSelectedItem(itemAucune);
        ajouterPanelSansConditionRegle();
        CbEvenementFin.setSelectedItem(itemAucun);
    }
    
    public Color couleurDeFondHTML(String html)
    {
        String code=html.substring(html.indexOf("bgcolor=\"#")+10, html.indexOf("bgcolor=\"#")+16);
        return new Color(Integer.parseInt(code, 16));
    }
    
    public String HTMLStringToString(String html) 
    {
        return Jsoup.parse(html).text();
    }
    
    //permet de transformer un string "classique" en string contenant du html valide
    public String stringToHTMLString(String html) {
        if (!html.contains("<body")) 
        {
            if (html.contains("<html")) 
            {
                if (html.contains("<head")) {
                    html = html.replace("</head>", "</head><body>");
                } else {
                    html = html.replace("<html>", "<html><body>");
                }
                html = html.replace("</html>", "</body></html>");
            } 
            else 
            {
                if (html.contains("<head")) 
                {
                    html = html.replace("</head>", "</head><body>");
                } 
                else 
                {
                    html = "<body>" + html + "</body>";
                }
                html = html + "</body>";
            }
        }
        
        if (!html.contains("<head")) {
            if (html.contains("<html")) {
                html = html.replace("<html>", "<html><head></head>");
            } else {
                html = "<head></head>" + html;
            }
        }
        
        if (!html.contains("<html")) 
        {
            html = "<html>" + html + "</html>";
        }        
        return html;
        
    }
    
    public void remplacerSequence(Element sequence)
    {
        Element seq=(Element) elementParId(lesSequences, sequence.getAttributeValue(attributId));
        int indice=lesSequences.indexOf(seq);
        lesSequences.remove(indice);
        lesSequences.add(indice, sequence);
    }
    
    private void modifRegle(int nbLigne)
    {
        modifRegle=true;
        chargerCbChoixConditionRegle();
        
        //on remplit tous les champs avec les info sur la règles qu'on veut modifier
        TxtRegle.setText((String)(TableRegles.getValueAt(nbLigne, 0)));
        Element regle=elementParId(lesRegles, (String)(TableRegles.getValueAt(nbLigne, 0)));
        
        if(regle.getChild(attributEvenement_declencheur).getAttribute(attributIdEve)!=null)
        {
            CbEvenementDeclencheur.setSelectedItem(regle.getChild(attributEvenement_declencheur).getAttributeValue(attributIdEve));
        }
        else if(regle.getChild(attributEvenement_declencheur).getAttributeValue(attributType).equals(attributLancementAssistance))
        {
            CbEvenementDeclencheur.setSelectedItem(itemLancementAssistance);
        }
        else if(regle.getChild(attributEvenement_declencheur).getAttributeValue(attributType).equals(attributLancementRegle))
        {
            CbEvenementDeclencheur.setSelectedItem(itemLancementRegle);
        }
        
        Element alternatives=(Element) regle.getChild(attributAlternatives);
        CbChoixConditionRegle.setSelectedItem(alternatives.getAttributeValue(attributCondition));
        PanelAlternativesRegle.removeAll(); 
        
        if(alternatives.getAttributeValue(attributCondition).equals(""))
        {
            ajouterPanelSansConditionRegle();
            Element alter=(Element) alternatives.getChildren().get(0);
            CbChoixConditionRegle.setSelectedItem(itemAucune);
            ouvrirAlternative(alter, "");
        }
        else
        {
            for(int i=0; i<alternatives.getChildren().size(); i++)
            {
                ajouterPanelAlternativeRegle(CbChoixConditionRegle.getSelectedItem().toString());
                Element alter=(Element) alternatives.getChildren().get(i);
                ouvrirAlternative(alter, CbChoixConditionRegle.getSelectedItem().toString());
            }
        } 
        
        if(regle.getChild(attributEvenement_de_fin)!=null)
        {
            CbEvenementFin.setSelectedItem(regle.getChild(attributEvenement_de_fin).getAttributeValue(attributIdEve));
        }
        else if(regle.getChild(attributEvenement_declencheur).getAttributeValue(attributType).equals(attributLancementAssistance))
        {
            CbEvenementFin.setSelectedItem(itemAucun);
        }
    }
    
    private void creationNouvelleCondition(JComboBox cb)
    {
        Main.CreationConditions.CB = cb;
        Main.CreationConditions.chargerInterface();
        Main.CreationConditions.setVisible(true);
    }
    
    private void creationNouvelEvenement(JComboBox cb)
    {
        Main.CreationEvenements.CB = cb;
        Main.CreationEvenements.chargerInterface();
        Main.CreationEvenements.setVisible(true);
    }
    
    private void ouvrirChoixValeurConditionNumerique(Element alter)
    {
        Panel ppp = (Panel) PanelAlternativesRegle.getComponent(PanelAlternativesRegle.getComponentCount()-1);
        Panel pp = (Panel) ppp.getComponent(0);
        Panel p = (Panel) pp.getComponent(1);
        
        JSpinner jinf, jsup;
        
        jinf = (JSpinner) p.getComponent(1);
        jsup = (JSpinner) p.getComponent(3);
        
        jinf.setValue(Integer.parseInt(alter.getAttributeValue(attributBorne_inf)));
        jsup.setValue(Integer.parseInt(alter.getAttributeValue(attributBorne_sup)));
    }
    
    private void ouvrirChoixValeurConditionTextuelle(Element alter)
    {
        Panel ppp = (Panel) PanelAlternativesRegle.getComponent(PanelAlternativesRegle.getComponentCount()-1);
        Panel pp = (Panel) ppp.getComponent(0);
        Panel p = (Panel) pp.getComponent(1);

        JComboBox cb = (JComboBox) p.getComponent(1);
        cb.setSelectedItem(alter.getAttributeValue(attributValeur));
    }
    
    private void ouvrirChoixValeurConditionTexteLibre(Element alter)
    {
        Panel ppp = (Panel) PanelAlternativesRegle.getComponent(PanelAlternativesRegle.getComponentCount()-1);
        Panel pp = (Panel) ppp.getComponent(0);
        Panel p = (Panel) pp.getComponent(1);
        
        JComboBox cb = (JComboBox) p.getComponent(1);
        cb.setSelectedItem(alter.getAttributeValue(attributType));
        JTextField txt = (JTextField) p.getComponent(2);
        txt.setText(alter.getAttributeValue(attributTexte));
        
    }
    
    private void ouvrirChoixValeurConditionDuree(Element alter)
    {
        Panel ppp = (Panel) PanelAlternativesRegle.getComponent(PanelAlternativesRegle.getComponentCount()-1);
        Panel pp = (Panel) ppp.getComponent(0);
        Panel p = (Panel) pp.getComponent(1);
        
        JComboBox cb = (JComboBox) p.getComponent(1);
        cb.setSelectedItem(alter.getAttributeValue(attributType));
        JSpinner spin = (JSpinner) p.getComponent(2);
        spin.setValue(Integer.parseInt(alter.getAttributeValue(attributValeur)));
    }
    
    private void ouvrirActionsSelectionnes(Element alter)
    {
        Panel p;
        if(CbChoixConditionRegle.getSelectedItem().toString().equals(itemAucune))
        {
            Panel ppp = (Panel) PanelActionsRegle.getComponent(0);
            Panel pp = (Panel) ppp.getComponent(1);
            p = (Panel) pp.getComponent(1);
        }
        else
        {
            Panel ppp = (Panel) PanelAlternativesRegle.getComponent(PanelAlternativesRegle.getComponentCount()-1);
            Panel pp = (Panel) ppp.getComponent(1);
            p = (Panel) pp.getComponent(1);
        }

        for(int i=0; i<alter.getChildren().size(); i++)
        {
            Element act = (Element) alter.getChildren().get(i);
            if(i>0)
            {
                ajouterSelectionAction(p, i);
            }

            JComboBox cb = (JComboBox) p.getComponent(i+2);
            cb.setSelectedItem(act.getAttributeValue(attributId));
        }
    }
    
    
    private void ouvrirAlternative(Element alter, String condition)
    {
        Element cond=conditionParId(condition);
        
        //on ouvre les infos liées à la valeur de la condition
        if(cond==null)
        {
            
        }
        else if(cond.getAttributeValue(attributType).equals(conditionProfil))
        {
            Element noeud = (Element) cond.getChildren().get(0);
            if(noeud.getName().equals(attributTextuelle))
            {
                ouvrirChoixValeurConditionTextuelle(alter);
            }
            else
            {
                ouvrirChoixValeurConditionNumerique(alter);               
            }
        }
        else if(cond.getAttributeValue(attributType).equals(conditionContexte))
        {
            if(cond.getAttributeValue(attributSousType).equals("nombre"))
            {
                ouvrirChoixValeurConditionNumerique(alter);
            }
            else if(cond.getAttributeValue(attributSousType).equals("booléen"))
            {
                ouvrirChoixValeurConditionTextuelle(alter);
            }
            else if(cond.getAttributeValue(attributSousType).equals(attributTexte))
            {
                ouvrirChoixValeurConditionTexteLibre(alter);
            }
        }
        else if(cond.getAttributeValue(attributType).equals(conditionHistorique))
        {
            if(cond.getAttributeValue(attributSousType).equals(dernierDeclenchement))
            {
                ouvrirChoixValeurConditionDuree(alter);
            }
            else
            {
                ouvrirChoixValeurConditionNumerique(alter);
            }
        }        
        else if(cond.getAttributeValue(attributType).equals(conditionConsultation))
        {
            ouvrirChoixValeurConditionTextuelle(alter);
        }
        else if(cond.getAttributeValue(attributType).equals(conditionTraces))
        {

        }
        else if(cond.getAttributeValue(attributType).equals(conditionCombinaison))
        {
            ouvrirChoixValeurConditionTextuelle(alter);
        }
        
        //on séléctionne les actions choisies
        ouvrirActionsSelectionnes(alter);
    }
    
    private void copieVideo(JTextField jtext) {
        String chemin_temp;
        chemin_temp = jtext.getText();
        String chemin_source = chemin_temp;
        String nom_video = chemin_temp;
        nom_video = nom_video.replace("\\", "/");
        nom_video = nom_video.substring(nom_video.lastIndexOf("/") + 1, nom_video.length());
        File temp = new File("");
        String chemin_destination = temp.getAbsolutePath().concat("/" + DIR_EXEMPLE + "" + nom_video);
        File fichier_source = new File(chemin_source);
        File fichier_destination = new File(chemin_destination);
        if (!fichier_destination.exists()) {
            copier(fichier_source, fichier_destination);
        }
    }
    
    
    
    public void chargerCbUniteTemps(JComboBox Cb)
    {
        Cb.removeAllItems();
        Cb.addItem(itemSecondes);
        Cb.addItem(itemMinutes);
        Cb.addItem(itemHeures);
    }
        
    public void ajouterBaliseMessage(String b)
    {
        /*
        CbPersoActionMessage.addItem(b);
        CbPersoActionMessage.setSelectedItem(b);
        */
    }
    
    public void modifierPoliceBouton(JButton bt, Font f, Color c)
    {
        bt.setForeground(c);
        bt.setFont(f);
        /*if(bt.equals(BtPoliceMessageActionInteractive))
        {
            TxtMessageActionInteractive.setFont(f);
            TxtMessageActionInteractive.setForeground(c);
        }*/
    }
    
    public void affichageDescription(JButton Bt, JTree arbre)
    {
        if(afficherDescriptionComplete)
        {
            Bt.setToolTipText(toolTip1BtAfficherDescription);
            Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/plusVert.png"));
            Bt.setIcon(new ImageIcon(icon));
            Bt.setText("");
        }  
        else
        {            
            Bt.setToolTipText(toolTip2BtAfficherDescription);
            Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/moins.png"));
            Bt.setIcon(new ImageIcon(icon));
            Bt.setText("");
        }
        
        afficherDescriptionComplete=!afficherDescriptionComplete;
        chargerArbreComposants(arbre, afficherDescriptionComplete);
        etendreArbre(arbre);
    }
    
    public void ajouteBalise(String balise, HTMLEditorPane txt) {
        txt.setText(txt.getText()+balise);
    }
    
    private boolean appartient(String[] tab, String val)
    {
        for(int i=0; i<tab.length; i++)
        {
            if(val.equals(tab[i]))
                return true;
        }
        return false;
    }
    
    public String[] formatFichierVideoSon(String type) {
        XMLFonctions.OuvrirXML(DIR_EXEMPLE + "formatFichier.xml");
        Element noeud = (Element) XMLFonctions.racine;
        Element format = noeud.getChild(type);
        List l = format.getChildren();
        String[] s = new String[l.size()];
        Iterator i = l.iterator();
        int cpt = 0;
        while (i.hasNext()) {
            Element e = (Element) i.next();
            s[cpt] = e.getValue();
            cpt++;
        }

        return s;
    }       
    
    public Element briqueParNom(String fichier, String nom)
    {
        Element courant;
        XMLFonctions.OuvrirXML(fichier);
        Element struct=XMLFonctions.racine;
        for(int i=0; i<struct.getChildren().size(); i++)
        {
            courant=(Element) struct.getChildren().get(i);  //on parcourt tous les noeuds de la structures qui doivent être des briques
            if(courant.getName().equals("brique"))
            {
                if(courant.getAttributeValue(attributNom).equals(nom))    //si c'est la brique qu'on cherchait on la renvoie
                    return courant;
            }
        }
        return null;    //si on arrive ici c'est qu'on a pas trouvé la brique dans la profil
    }
    
    private Element composanteParNom(Element pere, String nom)
    {
        Element courant;
        for(int i=0; i<pere.getChildren().size(); i++)
        {
            courant=(Element) pere.getChildren().get(i);    //on parcourt toutes les composantes ou sous-composantes de l'élément
            if(courant.getName().equals("composante") || courant.getName().equals("sous_composante"))
            {
                if(courant.getAttributeValue(attributNom).equals(nom))
                    return courant; //si c'est la composante qu'on cherchait on la renvoie
            }
        }
        return null;    //si on arrive ici c'est qu'on a pas trouvé la composante dans la brique
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupContrainteHistorique = new javax.swing.ButtonGroup();
        GroupPositionActionMessageAgent = new javax.swing.ButtonGroup();
        GroupTailleActionMessagePopup = new javax.swing.ButtonGroup();
        GroupContrainteContexte = new javax.swing.ButtonGroup();
        LbBorneSupContrainteContexte1 = new javax.swing.JLabel();
        GroupEtatActionInterface = new javax.swing.ButtonGroup();
        GroupActionMasquage = new javax.swing.ButtonGroup();
        GroupPositionActionMessagePopup = new javax.swing.ButtonGroup();
        GroupEvenementDelencheur = new javax.swing.ButtonGroup();
        GroupConditionTraces = new javax.swing.ButtonGroup();
        LbTitre = new javax.swing.JLabel();
        BtRetour = new javax.swing.JButton();
        BtSuivant = new javax.swing.JButton();
        PanelConditions = new javax.swing.JPanel();
        ScrollTableConditions = new javax.swing.JScrollPane();
        TableConditions = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;   //Disallow the editing of any cell
            }
        }
        ;
        LbConditions = new javax.swing.JLabel();
        BtAjoutCondition = new javax.swing.JButton();
        BtModifierCondition = new javax.swing.JButton();
        BtSupprCondition = new javax.swing.JButton();
        PanelActions = new javax.swing.JPanel();
        BtAjoutAction = new javax.swing.JButton();
        BtModifierAction = new javax.swing.JButton();
        BtSupprAction = new javax.swing.JButton();
        LbAssistance = new javax.swing.JLabel();
        ScrollTableActions = new javax.swing.JScrollPane();
        TableActions = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;   //Disallow the editing of any cell
            }
        }
        ;
        PanelRegles = new javax.swing.JPanel();
        BtModifierRegle = new javax.swing.JButton();
        BtSupprRegle = new javax.swing.JButton();
        ScrollTableRegles = new javax.swing.JScrollPane();
        TableRegles = new javax.swing.JTable()
        {public boolean isCellEditable(int rowIndex, int colIndex) {
            return false;   //Disallow the editing of any cell
        }};
        LbRegles = new javax.swing.JLabel();
        PanelCreationRegle = new javax.swing.JPanel();
        BtAnnulerRegle = new javax.swing.JButton();
        BtValiderRegle = new javax.swing.JButton();
        TxtRegle = new javax.swing.JTextField();
        LbRegle = new javax.swing.JLabel();
        LbCondition = new javax.swing.JLabel();
        CbChoixConditionRegle = new javax.swing.JComboBox();
        PanelActionsRegle = new javax.swing.JPanel();
        BtAjoutAlternativeRegle = new javax.swing.JButton();
        LbEvenementDeclencheur = new javax.swing.JLabel();
        CbEvenementDeclencheur = new javax.swing.JComboBox();
        LbEvenementFin = new javax.swing.JLabel();
        CbEvenementFin = new javax.swing.JComboBox();
        BtSupprimeAlternativeRegle = new javax.swing.JButton();
        LbActions = new javax.swing.JLabel();
        PanelAlternativesRegle = new javax.swing.JPanel();
        LbNomLogiciel = new javax.swing.JLabel();
        PanelEvenements = new javax.swing.JPanel();
        LbEvenement = new javax.swing.JLabel();
        BtAjoutEvenement = new javax.swing.JButton();
        BtModifierEvenement = new javax.swing.JButton();
        BtSupprEvenement = new javax.swing.JButton();
        ScrollTableEvenements = new javax.swing.JScrollPane();
        TableEvenements = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;   //Disallow the editing of any cell
            }
        }
        ;

        LbBorneSupContrainteContexte1.setText("Borne supérieure :");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        LbTitre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LbTitre.setText("Création d'un système d'assistance pour");

        BtRetour.setText("Retour");
        BtRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRetourActionPerformed(evt);
            }
        });

        BtSuivant.setText("Sauver");
        BtSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSuivantActionPerformed(evt);
            }
        });

        PanelConditions.setBackground(new java.awt.Color(255, 255, 204));
        PanelConditions.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TableConditions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nom", "Type", "Objet", "Valeur"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollTableConditions.setViewportView(TableConditions);

        LbConditions.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        LbConditions.setText("Les conditions pour personnaliser et contextualiser l'assistance");

        BtAjoutCondition.setText("Nouveau...");
        BtAjoutCondition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAjoutConditionActionPerformed(evt);
            }
        });

        BtModifierCondition.setText("Modifier...");
        BtModifierCondition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierConditionActionPerformed(evt);
            }
        });

        BtSupprCondition.setText("Supprimer");
        BtSupprCondition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSupprConditionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelConditionsLayout = new javax.swing.GroupLayout(PanelConditions);
        PanelConditions.setLayout(PanelConditionsLayout);
        PanelConditionsLayout.setHorizontalGroup(
            PanelConditionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelConditionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelConditionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelConditionsLayout.createSequentialGroup()
                        .addComponent(LbConditions, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtAjoutCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtModifierCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtSupprCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ScrollTableConditions, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        PanelConditionsLayout.setVerticalGroup(
            PanelConditionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelConditionsLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(PanelConditionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbConditions)
                    .addComponent(BtSupprCondition)
                    .addComponent(BtModifierCondition)
                    .addComponent(BtAjoutCondition))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollTableConditions, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        PanelActions.setBackground(new java.awt.Color(255, 225, 196));
        PanelActions.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BtAjoutAction.setText("Nouveau...");
        BtAjoutAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAjoutActionActionPerformed(evt);
            }
        });

        BtModifierAction.setText("Modifier...");
        BtModifierAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierActionActionPerformed(evt);
            }
        });

        BtSupprAction.setText("Supprimer");
        BtSupprAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSupprActionActionPerformed(evt);
            }
        });

        LbAssistance.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        LbAssistance.setText("Les actions d'assistance");

        TableActions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nom", "Type", "Assistant", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollTableActions.setViewportView(TableActions);

        javax.swing.GroupLayout PanelActionsLayout = new javax.swing.GroupLayout(PanelActions);
        PanelActions.setLayout(PanelActionsLayout);
        PanelActionsLayout.setHorizontalGroup(
            PanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelActionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelActionsLayout.createSequentialGroup()
                        .addComponent(LbAssistance, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtAjoutAction, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtModifierAction, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtSupprAction, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelActionsLayout.createSequentialGroup()
                        .addComponent(ScrollTableActions, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        PanelActionsLayout.setVerticalGroup(
            PanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelActionsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbAssistance)
                    .addComponent(BtAjoutAction)
                    .addComponent(BtModifierAction)
                    .addComponent(BtSupprAction))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollTableActions, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelRegles.setBackground(new java.awt.Color(230, 236, 249));
        PanelRegles.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BtModifierRegle.setText("Modifier...");
        BtModifierRegle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierRegleActionPerformed(evt);
            }
        });

        BtSupprRegle.setText("Supprimer");
        BtSupprRegle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSupprRegleActionPerformed(evt);
            }
        });

        TableRegles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nom", "Evenement déclencheur", "Conditions", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollTableRegles.setViewportView(TableRegles);

        LbRegles.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        LbRegles.setText("Les règles qui définissent l'assistance souhaitée");

        javax.swing.GroupLayout PanelReglesLayout = new javax.swing.GroupLayout(PanelRegles);
        PanelRegles.setLayout(PanelReglesLayout);
        PanelReglesLayout.setHorizontalGroup(
            PanelReglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelReglesLayout.createSequentialGroup()
                .addGroup(PanelReglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelReglesLayout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(LbRegles, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(233, 233, 233)
                        .addComponent(BtModifierRegle, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(BtSupprRegle, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelReglesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ScrollTableRegles)))
                .addContainerGap())
        );
        PanelReglesLayout.setVerticalGroup(
            PanelReglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelReglesLayout.createSequentialGroup()
                .addGroup(PanelReglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbRegles)
                    .addComponent(BtModifierRegle)
                    .addComponent(BtSupprRegle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ScrollTableRegles, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );

        PanelCreationRegle.setBackground(new java.awt.Color(230, 236, 249));
        PanelCreationRegle.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BtAnnulerRegle.setText("Annuler les choix");
        BtAnnulerRegle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerRegleActionPerformed(evt);
            }
        });

        BtValiderRegle.setText("Valider la règle");
        BtValiderRegle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderRegleActionPerformed(evt);
            }
        });

        TxtRegle.setText("jTextField1");
        TxtRegle.setEnabled(false);

        LbRegle.setText("Nom de la règle :");

        LbCondition.setText("Condition sur le déclenchement");

        CbChoixConditionRegle.setBackground(new java.awt.Color(255, 255, 204));
        CbChoixConditionRegle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbChoixConditionRegle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbChoixConditionRegleItemStateChanged(evt);
            }
        });

        PanelActionsRegle.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout PanelActionsRegleLayout = new javax.swing.GroupLayout(PanelActionsRegle);
        PanelActionsRegle.setLayout(PanelActionsRegleLayout);
        PanelActionsRegleLayout.setHorizontalGroup(
            PanelActionsRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );
        PanelActionsRegleLayout.setVerticalGroup(
            PanelActionsRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        BtAjoutAlternativeRegle.setText("+");
        BtAjoutAlternativeRegle.setToolTipText("Ajouter une alternative à la règle");
        BtAjoutAlternativeRegle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAjoutAlternativeRegleActionPerformed(evt);
            }
        });

        LbEvenementDeclencheur.setText("Evénement déclencheur");

        CbEvenementDeclencheur.setBackground(new java.awt.Color(232, 249, 217));
        CbEvenementDeclencheur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbEvenementDeclencheur.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbEvenementDeclencheurItemStateChanged(evt);
            }
        });

        LbEvenementFin.setText("Evénement de fin");

        CbEvenementFin.setBackground(new java.awt.Color(232, 249, 217));
        CbEvenementFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbEvenementFin.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbEvenementFinItemStateChanged(evt);
            }
        });

        BtSupprimeAlternativeRegle.setText("-");
        BtSupprimeAlternativeRegle.setToolTipText("Supprimer une alternative à la règle");
        BtSupprimeAlternativeRegle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSupprimeAlternativeRegleActionPerformed(evt);
            }
        });

        LbActions.setText("Action(s) d'assistance");

        PanelAlternativesRegle.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout PanelAlternativesRegleLayout = new javax.swing.GroupLayout(PanelAlternativesRegle);
        PanelAlternativesRegle.setLayout(PanelAlternativesRegleLayout);
        PanelAlternativesRegleLayout.setHorizontalGroup(
            PanelAlternativesRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelAlternativesRegleLayout.setVerticalGroup(
            PanelAlternativesRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelCreationRegleLayout = new javax.swing.GroupLayout(PanelCreationRegle);
        PanelCreationRegle.setLayout(PanelCreationRegleLayout);
        PanelCreationRegleLayout.setHorizontalGroup(
            PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationRegleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationRegleLayout.createSequentialGroup()
                        .addComponent(LbRegle, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtRegle, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreationRegleLayout.createSequentialGroup()
                        .addGroup(PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCreationRegleLayout.createSequentialGroup()
                                .addGroup(PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LbEvenementDeclencheur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CbEvenementDeclencheur, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(56, 56, 56)
                                .addGroup(PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelCreationRegleLayout.createSequentialGroup()
                                        .addGroup(PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LbCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CbChoixConditionRegle, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(PanelCreationRegleLayout.createSequentialGroup()
                                                .addComponent(LbActions, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(PanelActionsRegle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(PanelAlternativesRegle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(PanelCreationRegleLayout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(BtAjoutAlternativeRegle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtSupprimeAlternativeRegle)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCreationRegleLayout.createSequentialGroup()
                                .addGroup(PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LbEvenementFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CbEvenementFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreationRegleLayout.createSequentialGroup()
                                .addComponent(BtValiderRegle, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtAnnulerRegle, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))))))
        );
        PanelCreationRegleLayout.setVerticalGroup(
            PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCreationRegleLayout.createSequentialGroup()
                .addGroup(PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationRegleLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(CbEvenementFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCreationRegleLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbRegle)
                            .addComponent(TxtRegle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LbEvenementFin)
                            .addComponent(LbEvenementDeclencheur, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CbEvenementDeclencheur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCreationRegleLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbCondition)
                            .addComponent(LbActions))
                        .addGroup(PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCreationRegleLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CbChoixConditionRegle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCreationRegleLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(PanelActionsRegle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCreationRegleLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtValiderRegle)
                            .addComponent(BtAnnulerRegle))
                        .addGap(49, 49, 49))
                    .addGroup(PanelCreationRegleLayout.createSequentialGroup()
                        .addComponent(PanelAlternativesRegle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addGroup(PanelCreationRegleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtSupprimeAlternativeRegle)
                            .addComponent(BtAjoutAlternativeRegle))
                        .addGap(0, 59, Short.MAX_VALUE))))
        );

        LbNomLogiciel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LbNomLogiciel.setText("machin");

        PanelEvenements.setBackground(new java.awt.Color(232, 249, 217));
        PanelEvenements.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        LbEvenement.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        LbEvenement.setText("Evénements");

        BtAjoutEvenement.setText("Nouveau...");
        BtAjoutEvenement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAjoutEvenementActionPerformed(evt);
            }
        });

        BtModifierEvenement.setText("Modifier...");
        BtModifierEvenement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModifierEvenementActionPerformed(evt);
            }
        });

        BtSupprEvenement.setText("Supprimer");
        BtSupprEvenement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSupprEvenementActionPerformed(evt);
            }
        });

        TableEvenements.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Nom", "Type", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollTableEvenements.setViewportView(TableEvenements);
        TableEvenements.getColumnModel().getColumn(0).setResizable(false);
        TableEvenements.getColumnModel().getColumn(1).setResizable(false);
        TableEvenements.getColumnModel().getColumn(2).setResizable(false);

        javax.swing.GroupLayout PanelEvenementsLayout = new javax.swing.GroupLayout(PanelEvenements);
        PanelEvenements.setLayout(PanelEvenementsLayout);
        PanelEvenementsLayout.setHorizontalGroup(
            PanelEvenementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEvenementsLayout.createSequentialGroup()
                .addGroup(PanelEvenementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEvenementsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LbEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(BtAjoutEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtModifierEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtSupprEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelEvenementsLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(ScrollTableEvenements, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelEvenementsLayout.setVerticalGroup(
            PanelEvenementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEvenementsLayout.createSequentialGroup()
                .addGroup(PanelEvenementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbEvenement)
                    .addGroup(PanelEvenementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtAjoutEvenement)
                        .addComponent(BtModifierEvenement)
                        .addComponent(BtSupprEvenement)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(ScrollTableEvenements, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelRegles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtRetour)
                                .addGap(141, 141, 141)
                                .addComponent(LbTitre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LbNomLogiciel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtSuivant))
                            .addComponent(PanelCreationRegle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(PanelEvenements, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelConditions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanelActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTitre)
                    .addComponent(LbNomLogiciel)
                    .addComponent(BtSuivant)
                    .addComponent(BtRetour))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelRegles, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelCreationRegle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelConditions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelEvenements, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtAjoutConditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAjoutConditionActionPerformed
        Main.CreationConditions.chargerInterface();
        Main.CreationConditions.setVisible(true);
   }//GEN-LAST:event_BtAjoutConditionActionPerformed

    private void BtModifierConditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierConditionActionPerformed
        if(TableConditions.getSelectedRow()>=0)
        {           
            String idc=TableConditions.getValueAt(TableConditions.getSelectedRow(), 0).toString();
            ligneModifCondition=TableConditions.getSelectedRow();          
            if(TableConditions.getValueAt(TableConditions.getSelectedRow(), 1).toString().equals(conditionProfil)) //si c'est une condition sur le profil
            {
                //on ouvre la contrainte sur profil qu'on souhaite modifier
                Element cond=conditionParId(idc);
                Main.CreationConditions.modifConditionProfil(cond);
                Main.CreationConditions.changerTypeCondition(itemConditionProfil);
            }
            else if(TableConditions.getValueAt(TableConditions.getSelectedRow(), 1).toString().equals(conditionTraces))
            {
               //on ouvre la condition sur l'histtorique qu'on souhaite modifier
                Element cond=conditionParId(idc);
                Main.CreationConditions.modifConditionTraces(cond);
                Main.CreationConditions.changerTypeCondition(itemConditionTraces);
            }
            else if(TableConditions.getValueAt(TableConditions.getSelectedRow(), 1).toString().equals(conditionHistorique))
            {
               //on ouvre la condition sur l'histtorique qu'on souhaite modifier
                Element cond=conditionParId(idc);
                Main.CreationConditions.modifConditionHistorique(cond);
                Main.CreationConditions.changerTypeCondition(itemConditionHistorique);
            }
            else if(TableConditions.getValueAt(TableConditions.getSelectedRow(), 1).toString().equals(conditionContexte))
            {
               //on ouvre la contrainte sur le contexte qu'on souhaite modifier
                Element cond=conditionParId(idc);
                Main.CreationConditions.modifConditionContexte(cond);
                Main.CreationConditions.changerTypeCondition(itemConditionContexte);
            }
            else if(TableConditions.getValueAt(TableConditions.getSelectedRow(), 1).toString().equals(conditionConsultation))
            {
               //on ouvre la contrainte sur le contexte qu'on souhaite modifier               
                Element cond=conditionParId(idc);
                Main.CreationConditions.modifConditionConsultation(cond);
                Main.CreationConditions.changerTypeCondition(itemConditionConsultation);
            }
            else if(TableConditions.getValueAt(TableConditions.getSelectedRow(), 1).toString().equals(conditionCombinaison))
            {
               //on ouvre la contrainte sur le contexte qu'on souhaite modifier
                Element cond=conditionParId(idc);
                Main.CreationConditions.modifConditionCombinaison(cond); 
                Main.CreationConditions.changerTypeCondition(itemConditionCombinaison);
            }
            else
            {
                System.out.println("on ne sait pas encore modifier des conditions sur "+TableConditions.getValueAt(TableConditions.getSelectedRow(), 1).toString());
            } 
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Vous devez sélectionner une condition", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
   }//GEN-LAST:event_BtModifierConditionActionPerformed

    private void BtRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRetourActionPerformed
        /*if(nouvelleAssistance)
            Main.ChoixLogiciel.setVisible(true);
        else
            Main.ChargerAssistance.setVisible(true);*/
        Main.EcranAccueil.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BtRetourActionPerformed

    private void BtSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSuivantActionPerformed
        sauveConditions();
        sauveActions();
        sauveRegles();
        sauveEvenements();
        sauveSequences();
        Main.SauveAssistance.chargerInterface();
        Main.SauveAssistance.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BtSuivantActionPerformed

    private void BtAjoutActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAjoutActionActionPerformed
        Main.CreationActions.chargerInterface();
        Main.CreationActions.setVisible(true);
    }//GEN-LAST:event_BtAjoutActionActionPerformed

    private void BtModifierActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierActionActionPerformed
        if(TableActions.getSelectedRow()>=0)
        {
            String ida=TableActions.getValueAt(TableActions.getSelectedRow(), 0).toString();
            ligneModifAction=TableActions.getSelectedRow(); 
            Element act=elementParId(lesActions,ida);
            if(TableActions.getValueAt(ligneModifAction, 1).equals(itemTypeActionMiseEnValeur))
            {
                Main.CreationActions.modifActionMiseEnValeur(act);
            }
            else if(TableActions.getValueAt(ligneModifAction, 1).equals(itemTypeActionMasquage))
            {
                Main.CreationActions.modifActionMasquage(act);
            }
            else if(TableActions.getValueAt(ligneModifAction, 1).equals(itemTypeActionAnimation))
            {
                Main.CreationActions.modifActionAgentAnime(act);
            }
            else if(TableActions.getValueAt(ligneModifAction, 1).equals(itemTypeActionModificationProfil))
            {
                Main.CreationActions.modifActionModifierProfil(act);
            }
            else if(TableActions.getValueAt(ligneModifAction, 1).equals(itemTypeActionPasAPas))
            {
                Main.CreationActions.modifActionPasAPas(act);
            }
            else if(TableActions.getValueAt(ligneModifAction, 1).equals(itemTypeActionPresentationGuidee))
            {
                Main.CreationActions.modifActionPresentationGuidee(act);
            }
            else if(TableActions.getValueAt(ligneModifAction, 1).equals(itemTypeActionActionInterface))
            {
                Main.CreationActions.modifActionInterface(act);
            }
            else if(TableActions.getValueAt(ligneModifAction, 1).equals(itemTypeActionMessage))
            {
                Main.CreationActions.modifActionMessage(act);
            }
            else if(TableActions.getValueAt(ligneModifAction, 1).equals("URL") || TableActions.getValueAt(ligneModifAction, 1).equals("fichier") || TableActions.getValueAt(ligneModifAction, 1).equals("application"))
            {
                Main.CreationActions.modifActionRessource(act);
            }
            else if(TableActions.getValueAt(ligneModifAction, 1).equals(itemTypeActionAjoutComposant))
            {
                Main.CreationActions.modifierActionAjoutComposant(act);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Vous devez sélectionner une action", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtModifierActionActionPerformed

    private void BtAnnulerRegleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerRegleActionPerformed
        resetRegle();        
    }//GEN-LAST:event_BtAnnulerRegleActionPerformed

    private void BtValiderRegleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderRegleActionPerformed
        int ligne = lesRegles.size();
        Element re = creerRegle();
        if (!modifRegle) //si on valide une nouvelle regle
        {
            lesRegles.add(re);
            modelRegle.addRow(new Object[]{"", "", "", "", ""});
            afficherActionsParRegle(re, ligne);                              
            afficherRegle(re, ligne);

            idRegle++; 
        }
        else    //on est en train de modifier une règle existante
        {   
            ligne = ligneModifRegle;                      
            Element rr = elementParId(lesRegles, TxtRegle.getText());
            lesRegles.add(lesRegles.indexOf(rr), re);
            lesRegles.remove(rr);
            modifRegle=false;
        }
        afficherRegle(re, ligne);
        resetRegle();
    }//GEN-LAST:event_BtValiderRegleActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        sauveConditions();
        sauveActions();
        sauveRegles();
        Main.SauveAssistance.chargerInterface();
        Main.SauveAssistance.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void BtModifierRegleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierRegleActionPerformed
        if(TableRegles.getSelectedRow()>=0)
        {
            ligneModifRegle=TableRegles.getSelectedRow();
            modifRegle(ligneModifRegle);
        }
        else    //aucune ligne n'est sélectionnée
        {
            JOptionPane.showMessageDialog(null,"Vous devez sélectionner une règle", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtModifierRegleActionPerformed

    private void BtSupprRegleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSupprRegleActionPerformed
        if(TableRegles.getSelectedRow()>=0)
        {
            //on supprime la regle sélectionnée
            Element regle=elementParId(lesRegles,(String) TableRegles.getValueAt(TableRegles.getSelectedRow(), 0));
            lesRegles.remove(regle);
            reafficherRegles();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Vous devez sélectionner une règle", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtSupprRegleActionPerformed

    private void BtSupprConditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSupprConditionActionPerformed
        if(TableConditions.getSelectedRow()>=0)
        {
            String id=(String) TableConditions.getValueAt(TableConditions.getSelectedRow(), 0);
            if(conditionEstUtilisee(id))
            {
                JOptionPane.showMessageDialog(null,"Vous ne pouvez pas supprimer une condition utilisée dans une règle d'assistance", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else    //si la condition n'est utilisée dans aucune règles d'assistance, on peut la supprimer
            {
                Element cond=conditionParId ((String) TableConditions.getValueAt(TableConditions.getSelectedRow(), 0));
                lesConditions.remove(cond);
                reafficherConditions();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Vous devez sélectionner une condition", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtSupprConditionActionPerformed

    private void BtSupprActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSupprActionActionPerformed
        if(TableActions.getSelectedRow()>=0)
        {
            String id=(String) TableActions.getValueAt(TableActions.getSelectedRow(), 0);
            if(actionEstUtilisee(id))
            {
                JOptionPane.showMessageDialog(null,"Vous ne pouvez pas supprimer une action utilisée dans une règle d'assistance", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else    //si l'action n'est utilisée dans aucune règles d'assistance, on peut la supprimer
            {
                Element act=elementParId(lesActions,(String) TableActions.getValueAt(TableActions.getSelectedRow(), 0));
                lesActions.remove(act);
                reafficherActions();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Vous devez sélectionner une action", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtSupprActionActionPerformed

    private void CbChoixConditionRegleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbChoixConditionRegleItemStateChanged
        if(CbChoixConditionRegle.getSelectedIndex()>=0)
        {
            if(CbChoixConditionRegle.getSelectedItem().toString().equals(itemCreerUneNouvelleCondition))
            {
                if(CbChoixConditionRegle.getItemCount()>1)
                    creationNouvelleCondition(CbChoixConditionRegle);
            }
            else if(CbChoixConditionRegle.getSelectedItem().toString().equals(itemAucune))
            {
                PanelActionsRegle.setVisible(true);
                PanelAlternativesRegle.setVisible(false);
                BtAjoutAlternativeRegle.setVisible(false);
                BtSupprimeAlternativeRegle.setVisible(false); 
                ajouterPanelSansConditionRegle();
            }
            else
            {
                PanelActionsRegle.setVisible(false);                              
                BtSupprimeAlternativeRegle.setVisible(true);
                BtSupprimeAlternativeRegle.setEnabled(false);
                BtAjoutAlternativeRegle.setVisible(true);
                BtAjoutAlternativeRegle.setEnabled(true);
                PanelAlternativesRegle.removeAll();
                ajouterPanelAlternativeRegle(CbChoixConditionRegle.getSelectedItem().toString()); 
                PanelAlternativesRegle.setVisible(true);
            }
        }
    }//GEN-LAST:event_CbChoixConditionRegleItemStateChanged

    private void BtAjoutAlternativeRegleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAjoutAlternativeRegleActionPerformed
        ajouterPanelAlternativeRegle(CbChoixConditionRegle.getSelectedItem().toString());
    }//GEN-LAST:event_BtAjoutAlternativeRegleActionPerformed

    private void BtSupprimeAlternativeRegleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSupprimeAlternativeRegleActionPerformed
        supprimerPanelAlternative();
    }//GEN-LAST:event_BtSupprimeAlternativeRegleActionPerformed

    private void BtAjoutEvenementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAjoutEvenementActionPerformed
        Main.CreationEvenements.chargerInterface();
        Main.CreationEvenements.setVisible(true);
    }//GEN-LAST:event_BtAjoutEvenementActionPerformed

    private void BtModifierEvenementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModifierEvenementActionPerformed
        if(TableEvenements.getSelectedRow()>=0)
        {           
            String idE=TableEvenements.getValueAt(TableEvenements.getSelectedRow(), 0).toString();
            ligneModifEvenement=TableEvenements.getSelectedRow(); 
            //on ouvre la contrainte sur profil qu'on souhaite modifier
            Element eve=evenementParId(idE);
            if(TableEvenements.getValueAt(TableEvenements.getSelectedRow(), 1).toString().equals(stringTimerFixe))
            {
                Main.CreationEvenements.chargerInterface();
                modifEvenementTimerFin = true;
                Main.CreationEvenements.modifEvenementTimerFin(eve);
            }
            else if(TableEvenements.getValueAt(TableEvenements.getSelectedRow(), 1).toString().equals(stringActionUtilisateur))
            {
                modifEvenementActionElem = true;
                Main.CreationEvenements.modifEvenementActionElem(eve);
            }
            else if(TableEvenements.getValueAt(TableEvenements.getSelectedRow(), 1).toString().equals(stringEveSA))
            {
                Main.CreationEvenements.chargerInterface();
                modifEveSA = true;
                Main.CreationEvenements.modifEveSA(eve);
            }
            else if(eve.getAttributeValue(attributTypeEve).equals(attributTimerRelatif))
            {
                Main.CreationEvenements.chargerInterface();
                modifEvenementTimerRelatif = true;
                Main.CreationEvenements.modifEvenementTimerRelatif(eve);
            }
            else
            {
                System.out.println("on ne sait pas encore modifier des evenements "+TableEvenements.getValueAt(TableEvenements.getSelectedRow(), 1).toString());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Vous devez sélectionner un événement", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtModifierEvenementActionPerformed

    private void BtSupprEvenementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSupprEvenementActionPerformed
        if(TableEvenements.getSelectedRow()>=0)
        {
            String id=(String) TableEvenements.getValueAt(TableEvenements.getSelectedRow(), 0);
            if(evenementEstUtilise(id))
            {
                JOptionPane.showMessageDialog(null,"Vous ne pouvez pas supprimer un événément utilisé dans une règle d'assistance", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else    //si la condition n'est utilisée dans aucune règles d'assistance, on peut la supprimer
            {
                Element eve=evenementParId((String) TableEvenements.getValueAt(TableEvenements.getSelectedRow(), 0));
                lesEvenements.remove(eve);
                reafficherEvenements();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Vous devez sélectionner une condition", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtSupprEvenementActionPerformed

    private void CbEvenementDeclencheurItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbEvenementDeclencheurItemStateChanged
        if(CbEvenementDeclencheur.getSelectedIndex()>=0 && CbEvenementDeclencheur.getItemCount()>2)
        {
            if(CbEvenementDeclencheur.getSelectedItem().toString().equals(itemCreerUnNouvelEvenement))
            {
                creationNouvelEvenement(CbEvenementDeclencheur);
            }
        }
    }//GEN-LAST:event_CbEvenementDeclencheurItemStateChanged

    private void CbEvenementFinItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbEvenementFinItemStateChanged
        if(CbEvenementFin.getSelectedIndex()>=0 && CbEvenementFin.getItemCount()>1)
        {
            if(CbEvenementFin.getSelectedItem().toString().equals(itemCreerUnNouvelEvenement))
            {
                creationNouvelEvenement(CbEvenementFin);
            }
        }
    }//GEN-LAST:event_CbEvenementFinItemStateChanged
    
       
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
            java.util.logging.Logger.getLogger(CreationRegles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreationRegles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreationRegles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreationRegles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>       
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CreationRegles().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAjoutAction;
    private javax.swing.JButton BtAjoutAlternativeRegle;
    private javax.swing.JButton BtAjoutCondition;
    private javax.swing.JButton BtAjoutEvenement;
    private javax.swing.JButton BtAnnulerRegle;
    private javax.swing.JButton BtModifierAction;
    private javax.swing.JButton BtModifierCondition;
    private javax.swing.JButton BtModifierEvenement;
    private javax.swing.JButton BtModifierRegle;
    private javax.swing.JButton BtRetour;
    private javax.swing.JButton BtSuivant;
    private javax.swing.JButton BtSupprAction;
    private javax.swing.JButton BtSupprCondition;
    private javax.swing.JButton BtSupprEvenement;
    private javax.swing.JButton BtSupprRegle;
    private javax.swing.JButton BtSupprimeAlternativeRegle;
    private javax.swing.JButton BtValiderRegle;
    private javax.swing.JComboBox CbChoixConditionRegle;
    private javax.swing.JComboBox CbEvenementDeclencheur;
    private javax.swing.JComboBox CbEvenementFin;
    private javax.swing.ButtonGroup GroupActionMasquage;
    private javax.swing.ButtonGroup GroupConditionTraces;
    private javax.swing.ButtonGroup GroupContrainteContexte;
    private javax.swing.ButtonGroup GroupContrainteHistorique;
    private javax.swing.ButtonGroup GroupEtatActionInterface;
    private javax.swing.ButtonGroup GroupEvenementDelencheur;
    private javax.swing.ButtonGroup GroupPositionActionMessageAgent;
    private javax.swing.ButtonGroup GroupPositionActionMessagePopup;
    private javax.swing.ButtonGroup GroupTailleActionMessagePopup;
    private javax.swing.JLabel LbActions;
    private javax.swing.JLabel LbAssistance;
    private javax.swing.JLabel LbBorneSupContrainteContexte1;
    private javax.swing.JLabel LbCondition;
    private javax.swing.JLabel LbConditions;
    private javax.swing.JLabel LbEvenement;
    private javax.swing.JLabel LbEvenementDeclencheur;
    private javax.swing.JLabel LbEvenementFin;
    private javax.swing.JLabel LbNomLogiciel;
    private javax.swing.JLabel LbRegle;
    private javax.swing.JLabel LbRegles;
    private javax.swing.JLabel LbTitre;
    private javax.swing.JPanel PanelActions;
    private javax.swing.JPanel PanelActionsRegle;
    private javax.swing.JPanel PanelAlternativesRegle;
    private javax.swing.JPanel PanelConditions;
    private javax.swing.JPanel PanelCreationRegle;
    private javax.swing.JPanel PanelEvenements;
    private javax.swing.JPanel PanelRegles;
    private javax.swing.JScrollPane ScrollTableActions;
    private javax.swing.JScrollPane ScrollTableConditions;
    private javax.swing.JScrollPane ScrollTableEvenements;
    private javax.swing.JScrollPane ScrollTableRegles;
    public javax.swing.JTable TableActions;
    public javax.swing.JTable TableConditions;
    public javax.swing.JTable TableEvenements;
    public javax.swing.JTable TableRegles;
    private javax.swing.JTextField TxtRegle;
    // End of variables declaration//GEN-END:variables
}
