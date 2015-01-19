/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author Blandine
 */
public class ArbreInfoBulles extends DefaultTreeCellRenderer {

    public ArbreInfoBulles() {}    
    
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) 
        {

        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        
        String id=Main.CreationRegles.noeudGetId(value.toString());
        

        if (Main.CreationRegles.listeCommentairesComposants.containsKey(id)) 
        {
            setToolTipText((String) Main.CreationRegles.listeCommentairesComposants.get(id));
        } 
        else 
        {
            setToolTipText(null);
        }

        return this;
    }
    
    
    
}
