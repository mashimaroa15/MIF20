/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.io.File;
import javax.swing.JComboBox;
import org.jdom.Element;

/**
 *
 * @author Blandine
 */
public class FonctionsUtiles {

    public static void CBlister(File repertoire, JComboBox CB, String ext) 
    {
        CB.removeAllItems();
        String[] listefichiers;
        int i;
        listefichiers = repertoire.list();
        if(listefichiers!=null)
        {
            for (i = 0; i < listefichiers.length; i++) 
            {
                if(listefichiers[i].toString().endsWith(ext))
                    CB.addItem((String) listefichiers[i].toString());
            }
        }
    }
    
    public static void CBlister(File repertoire, List list, String ext) 
    {
        list.removeAll();
        String[] listefichiers;
        int i;
        listefichiers = repertoire.list();
        for (i = 0; i < listefichiers.length; i++) 
        {
            if(listefichiers[i].toString().endsWith(ext))
                list.add((String) listefichiers[i].toString());
        }
    }
    
    public static Element NoeudParAttr(Element pere, String attr, int val)
    {
        Element courant = (Element) pere.getChildren().get(0);
        Element elem;
        for (int i = 0; i < pere.getChildren().size(); i++) {
            elem = (Element) pere.getChildren().get(i);
            int n = Integer.parseInt(elem.getAttribute(attr).getValue());
            if (n == val) {
                courant = (Element) pere.getChildren().get(i);
            }
        }
        return courant;
    }
    
    public static Element NoeudParAttr(Element pere, String attr, String val)
    {
        Element courant = null;
        Element elem;
        for (int i = 0; i < pere.getChildren().size(); i++) 
        {
            elem = (Element) pere.getChildren().get(i);
            if (elem.getAttribute(attr).getValue().equals(val))
            {
                courant = (Element) pere.getChildren().get(i);
            }
        }
        return courant;
    }
    
    public static Element NoeudParAttrDansFichier(Element pere, String attr, String val)
    {
        Element courant = null;
        Element elem;
        for (int i = 0; i < pere.getChildren().size(); i++) 
        {
            elem = (Element) pere.getChildren().get(i);
            if (elem.getAttribute(attr).getValue().equals(val))
            {
                courant = (Element) pere.getChildren().get(i);
            }
            Element e=NoeudParAttrDansFichier(elem, attr, val);
            if(e!=null)
                return e;
        }
        return courant;
    }
    
    public static void ChargerNiveaux(Element pere, JComboBox CB)
    {
        int i;
        Element courant;
        for (i = 0; i < pere.getChildren().size(); i++) {
            courant = (Element) pere.getChildren().get(i);
            CB.addItem(courant.getValue());
        }
    }
    
    public static Element noeudEchelleParId(String id)
    {
        XMLFonctions.OuvrirXML(Main.Cste.fichierEchelles);
        return NoeudParAttr(XMLFonctions.racine, "id", Integer.valueOf(id));
    }
    
    public static boolean echelleEstNumerique(Element echelle)
    {       
        return echelle.getAttributeValue("type").equals("numerique");
    }

    public static Color StringToColor(String c)
    {
        //sun.swing.PrintColorUIResource[r=51,g=51,b=51] ou java.awt.Color[r=0,g=0,b=255]
        String rouge=c.substring(c.indexOf("r=")+2, c.indexOf(",g"));
        String vert=c.substring(c.indexOf("g=")+2, c.indexOf(",b"));
        String bleu=c.substring(c.indexOf("b=")+2, c.indexOf("]"));
        Color col=new Color(Integer.parseInt(rouge), Integer.parseInt(vert), Integer.parseInt(bleu));
        return col;
    }
    
    public static Color StringToColor(String c, int transp)
    {
        //sun.swing.PrintColorUIResource[r=51,g=51,b=51] ou java.awt.Color[r=0,g=0,b=255]
        String rouge=c.substring(c.indexOf("r=")+2, c.indexOf(",g"));
        String vert=c.substring(c.indexOf("g=")+2, c.indexOf(",b"));
        String bleu=c.substring(c.indexOf("b=")+2, c.indexOf("]"));
        Color col=new Color(Integer.parseInt(rouge), Integer.parseInt(vert), Integer.parseInt(bleu), transp);
        return col;
    }
    
    public static Font StringToFont(String c)
    {
        c=c.substring(c.indexOf(",")+1, c.length()-1);
        String nom=c.substring(c.indexOf("=")+1, c.indexOf(","));
        c=c.substring(c.indexOf(",")+1, c.length());
        String s=c.substring(c.indexOf("=")+1, c.indexOf(","));
        c=c.substring(c.indexOf(",")+1, c.length());
        int style=0;
        if(s.equals("bold"))    style=1;
        if(s.equals("italic"))  style=2;
        if(s.equals("bold italic")) style=3;
        int taille=Integer.parseInt(c.substring(c.indexOf("=")+1, c.length()));
        return new Font(nom, style, taille);
    }
}