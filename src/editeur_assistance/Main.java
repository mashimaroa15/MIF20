/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

/**
 *
 * @author Blandine
 */
public class Main {

    public static EcranAccueil EcranAccueil=new EcranAccueil();
    public static CreationRegles CreationRegles=new CreationRegles();
    public static CreationEvenements CreationEvenements=new CreationEvenements();
    public static CreationConditions CreationConditions=new CreationConditions();
    public static CreationActions CreationActions=new CreationActions();
    public static FichierAssistance FichierAssistance=new FichierAssistance();
    public static SauveAssistance SauveAssistance=new SauveAssistance();
    public static PersonnalisationMessage PersonnalisationMessage=new PersonnalisationMessage();
    public static ChoixPolice ChoixPolice=new ChoixPolice();
    public static ApercuMiseEnValeur ApercuMiseEnValeur = new ApercuMiseEnValeur();
    public static CreationSequence CreationSequence = new CreationSequence();
    public static ModificationInterface ModificationInterface = new ModificationInterface();
    public static DescriptionInterfaceWeb DescriptionInterfaceWeb = new DescriptionInterfaceWeb();
    public static PersonnalisationEtapes PersonnalisationPasAPas = new PersonnalisationEtapes();
    public static MiseEnValeurPasAPas MiseEnValeurPasAPas = new MiseEnValeurPasAPas();
    public static Constantes Cste=new Constantes();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        EcranAccueil.chargerInterface();
        EcranAccueil.setVisible(true);
        
        //System.out.println("toto");
         /* String.valueOf(compteur));
        int n=Integer.parseInt(elem.getAttribute(attr).getValue());*/
    }
}
