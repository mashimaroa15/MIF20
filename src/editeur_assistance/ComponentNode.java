/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*package editeur_assistance;


import java.awt.Component;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.swing.tree.DefaultMutableTreeNode;

public class ComponentNode extends DefaultMutableTreeNode
{
    public Component component = null;
    private String name;

    public ComponentNode(String name) {
        super();
        this.setUserObject(this);
        this.name = name;
    }

    public ComponentNode(Component component) 
    {
        super();
        this.setUserObject(this);
        this.component = component;
        if (component instanceof Accessible) {
	    AccessibleContext ac = ((Accessible) component).getAccessibleContext();
	    if ((ac != null) 
		&& (ac.getAccessibleRole() == AccessibleRole.UNKNOWN)) {
                name = '!' + ac.getAccessibleName();
	    } else {
		if (ac != null) {
		    name = '*' + ac.getAccessibleName();
		} else {
		    name = component.getName();
		}
	    }
        } else {
	    name = component.getName();
        }
        name = name + " (" + component.getClass().toString() + ")";
    }

    public String toString() {
        return name;
    }
}*/
