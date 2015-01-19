/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

/**
 *
 * @author Blandine
 */
public class Constantes {
    public String langue="fr";  //fr ou en
    
    public String CheminParametres="Parametres/";

    public String fichierEnregistrement=CheminParametres+"enregistrement.xml";
    public String fichierInterfaceEditeur=CheminParametres+"interfaceEditeur.xml";
    public String fichierComposantsInterface=CheminParametres+"composantsInterface.xml";
    public String fichierEchelles=CheminParametres+"echelles.xml";
    public String fichierAnimations=CheminParametres+"animations.xml";
    
    public String cheminEnregistreurs=CheminParametres+"Enregistreurs/";        
    public String cheminDescriptions=CheminParametres+"Descriptions_assistance/";
    public String cheminStructuresProfils=CheminParametres+"Structures_profils/";
    public String cheminAssistants_epiphytes=CheminParametres+"Assistants_epiphytes/";        
    public String cheminSymboles=cheminAssistants_epiphytes+"Valorisateur/Symboles/";
    public String cheminPersonnages = cheminAssistants_epiphytes+"MsAgents/agentsAnimes/";
    
    public String jarMessager=cheminAssistants_epiphytes+"Messager/Messager.jar";
    public String jarValorisateur=cheminAssistants_epiphytes+"Valorisateur/valorisateur.jar";
    public String jarMessagerInteractif=cheminAssistants_epiphytes+"MessagerInteractif/MessagerInteractif.jar";
    public String jarMsAgents=cheminAssistants_epiphytes+"MsAgents/MSAgents.jar";
    public String jarAnimationAgent=cheminAssistants_epiphytes+"AnimationAgent/animationAgent.jar";
    public String jarAjoutComposant=cheminAssistants_epiphytes+"AjoutComposant/AjoutComposant.jar";
    
    public String exeDescriptionInterfaceJava = CheminParametres+"Description_interface/DescriptionInterfaceJava.exe";
    public String exeDescriptionInterfaceWindows = CheminParametres+"Description_interface/DescriptionInterfaceWindows.exe";
    
    public String structureProfils=""; //"CollegeMarieCurie.str"
    public String logiciel="";
    public String nomSA="";
    public String descriptionInterface="";
}
