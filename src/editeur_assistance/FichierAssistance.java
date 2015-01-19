package editeur_assistance;

import java.io.FileOutputStream;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author Blandine
 */
public class FichierAssistance {
    public static Element racine = new Element("description");
    public static org.jdom.Document document = new Document(racine);   
    public static Element metadonnees = new Element("metadonnees");
    public static Element liste_regles = new Element("regles");
    public static Element liste_actions = new Element("actions");
    public static Element liste_conditions = new Element("conditions");
    public static Element liste_evenements = new Element("evenements");
    public static Element liste_sequences = new Element("sequences");

    public static void ouvrir(Element elem)
    {
        racine=elem;
        document=elem.getDocument();
        metadonnees=elem.getChild("metadonnees");
        liste_regles=elem.getChild("regles");
        liste_actions=elem.getChild("actions");
        liste_conditions=elem.getChild("conditions");
        liste_evenements=elem.getChild("evenements");
        liste_sequences=elem.getChild("sequences");
    }

    static void enregistre(String fichier, String chemin)
    {
        racine.removeContent();
        // on assemble le fichier de description de l'assistance souhaitée
        racine.addContent(metadonnees);
        racine.addContent(liste_regles);
        racine.addContent(liste_actions);
        racine.addContent(liste_conditions);
        racine.addContent(liste_evenements);
        racine.addContent(liste_sequences);
        
        try
        {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            sortie.output(document, new FileOutputStream(chemin+fichier));
        }
        catch (java.io.IOException e)
        {
            System.out.println("enregistre pas"+e.getMessage());
        }
    }

}
