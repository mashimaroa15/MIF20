package editeur_assistance;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Blandine
 */
public class ActionBouton implements ActionListener{

    public void actionPerformed(ActionEvent ae) {    
        JButton bt=new JButton();
        
        if(ae.getSource().getClass()==bt.getClass()) //c'est un bouton
        {
            bt = (JButton) ae.getSource();
            if (bt.getName().equals("brique")) 
            {
                Main.PersonnalisationMessage.cliqueBrique(bt.getMnemonic());
            } 
        }
    }
}

