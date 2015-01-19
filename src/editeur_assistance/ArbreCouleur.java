/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

import java.awt.Color;
import java.awt.Component;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author Blandine
 */
class ArbreCouleur extends DefaultTreeCellRenderer {
    Set listeComposantsImportants=new HashSet();

    @Override
    public Component getTreeCellRendererComponent(JTree tree,Object value,boolean sel,boolean expanded, boolean leaf,int row,boolean hasFocus)
    {

        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row,hasFocus);
        if (listeComposantsImportants.contains(value.toString()))
        {
            setBackgroundNonSelectionColor(new Color(232, 232, 253));   //new Color(204, 218, 244)
        }
        else
        {
            setBackgroundNonSelectionColor(Color.white);
        }

        return this;
    }
}
