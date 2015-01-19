/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import org.jdom.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Blandine
 */
public class DescriptionInterfaceWeb extends javax.swing.JFrame {

    private Element racineInterface=new Element("Interface");
    private DefaultMutableTreeNode root = new DefaultMutableTreeNode("Interface");
    private int id=0;
    private WebDriver driver;
    private HashMap lesComposants = new HashMap<WebElement, String>();
    /**
     * Creates new form DescriptionInterfaceWeb
     */
    public DescriptionInterfaceWeb() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/icone_editeur.png"));
        this.setIconImage(icon);
        this.setBounds(150, 50, 690, 750);
        this.setTitle("Editeur d'assistance - description de l'interface");
        this.setLayout(null);
        LbURL.setBounds(10, 15, 30, 24);
        TxtURL.setBounds(40, 15, 450, 24);
        BtLancer.setBounds(495, 15, 80, 24);
        BtURL.setBounds(580, 15, 80, 24);
        ScrollArbre.setBounds(10, 55, 650, 610);
        BtRetour.setBounds(this.getWidth()/2-170, this.getHeight()-80, 150, 30);
        BtSuivant.setBounds(this.getWidth()/2, this.getHeight()-80, 150, 30);
    }
    
    public void chargerInterface()
    {        
        Arbre.removeAll();       
        DefaultTreeModel model = new DefaultTreeModel(root);
        Arbre.setModel(model);
    }
    
    public void etendreArbre()
    {
        Enumeration e = ((DefaultMutableTreeNode) Arbre.getModel().getRoot()).preorderEnumeration();
        while (e.hasMoreElements()) {
            this.Arbre.expandPath(new TreePath(((DefaultMutableTreeNode)e.nextElement()).getPath()));
        }
    }
    
    private String getXPath(WebElement e)
    {
        if(e.getTagName().equals("body"))
        {
            lesComposants.put(e, "/html/" + e.getTagName());
            return "/html/" + e.getTagName();
        }
        
        if(lesComposants.containsKey(e))
        {
            return (String) lesComposants.get(e);
        }
        
        String xpath="";       
        List<WebElement> results = e.findElements(By.xpath("parent::*"));
        if(!results.isEmpty())
        {
            WebElement pere = results.get(0);
            String debutXpath;
            if(lesComposants.containsKey(pere))
            {
                debutXpath=(String) lesComposants.get(pere);
            }
            else
            {
                debutXpath=getXPath(pere);
                lesComposants.put(pere, debutXpath);
            }
            xpath=debutXpath + "/" + e.getTagName(); 
            
            //int index=indexInParent(e);
            int index=index(e);
            if(index>1)    //si c'est 1 ça veut dire que c'est inutile de préciser l'index
                xpath=xpath+"["+index+"]";
            
            lesComposants.put(e, xpath);           
            
            return xpath;
        }
        
        return xpath;
    }
    
    private int index(WebElement e)
    {
        int index = 1;
         //WebElement pere = e.findElement(By.xpath("parent::*"));
        List<WebElement> results = e.findElements(By.xpath("parent::*"));
        if(!results.isEmpty())
        {  
            WebElement pere = results.get(0);
            List<WebElement> jumeaux = pere.findElements(By.xpath("./"+e.getTagName()));
            
            for(int i=1; i<jumeaux.size()+1; i++)
            {   
                WebElement frere = pere.findElement(By.xpath("./"+e.getTagName()+"["+i+"]"));
                if(e.equals(frere))
                {
                    index=i;
                }               
            }
        }
        
        
        return index;
    }
    
    private int indexInParent(WebElement e)
    {
        int index=0;
        int nbFilsMemeType=0;
        
        //WebElement pere = e.findElement(By.xpath("parent::*"));
        List<WebElement> results = e.findElements(By.xpath("parent::*"));
        if(!results.isEmpty())
        {  
            WebElement pere = results.get(0);
            List<WebElement> freres = pere.findElements(By.xpath(".//*"));

            for(int i=0; i<freres.size(); i++)
            {   
                WebElement frere = freres.get(i);
                if(e.equals(frere))
                {
                    nbFilsMemeType++;
                    index=nbFilsMemeType;
                }               
                else
                {
                    if(e.getTagName().equals(frere.getTagName()))
                        nbFilsMemeType++;
                }
            }
        }
        return index;      
    }
    
    private void creerDescriptionInterface(String URL)
    {  
        lesComposants = new HashMap<WebElement, String>();
        Element fenetre=new Element("fenetre");
        fenetre.setAttribute("id", String.valueOf(id));
        fenetre.setAttribute("url", URL);
        id++;
        List<WebElement> results;
        
        //on cherche les composants input
        results = driver.findElements(By.tagName("input"));
        for(int i=0; i<results.size(); i++)
        {
            WebElement e = results.get(i);
            if(!e.getAttribute("type").equals("hidden")) //on ne considère pas les champs cachés
            {
                Element composant = new Element("composant");
                composant.setAttribute("id", String.valueOf(id));
                id++;
                composant.setAttribute("type", e.getAttribute("type"));
                if (e.getAttribute("type").equals("radio")) 
                {
                    composant.setAttribute("typeAjoute", "bouton radio");
                } 
                else if (e.getAttribute("type").equals("submit")) 
                {
                    composant.setAttribute("typeAjoute", "bouton");
                } 
                else if (e.getAttribute("type").equals("checkbox")) 
                {
                    composant.setAttribute("typeAjoute", "case à cocher");
                } 
                else if (e.getAttribute("type").equals("text")) 
                {
                    composant.setAttribute("typeAjoute", "zone de saisie");
                } 
                else if (e.getAttribute("type").equals("password")) 
                {
                    composant.setAttribute("typeAjoute", "zone de saisie");
                }

                if(!e.getAttribute("id").isEmpty())
                    composant.setAttribute("id_web", e.getAttribute("id"));
                composant.setAttribute("texte", e.getText());
                if(!e.getAttribute("title").equals(e.getText()))
                    composant.setAttribute("titre", e.getAttribute("title"));
                composant.setAttribute("valeur", e.getAttribute("value"));                              
                composant.setAttribute("xpath", getXPath(e));
                fenetre.addContent(composant);
            }
        }
        
        //on cherhce les listes déroulantes
        results = driver.findElements(By.tagName("select"));
        for (int i=0; i<results.size(); i++) 
        {
            WebElement e = results.get(i);
            Element composant = new Element("composant");
            composant.setAttribute("id", String.valueOf(id));
            id++;
            
            if(!e.getAttribute("id").isEmpty())
                composant.setAttribute("id_web", e.getAttribute("id"));
            composant.setAttribute("typeAjoute", "liste déroulante");
            composant.setAttribute("texte", e.getText());
            composant.setAttribute("valeur", e.getAttribute("value"));            
            composant.setAttribute("xpath", getXPath(e));
            fenetre.addContent(composant);
        }
        
        
        //on cherhce les items listes déroulantes
        results = driver.findElements(By.tagName("option"));
        for (int i=0; i<results.size(); i++) 
        {
            WebElement e = results.get(i);
            Element composant = new Element("composant");
            composant.setAttribute("id", String.valueOf(id));
            id++;
            
            if(!e.getAttribute("id").isEmpty())
                composant.setAttribute("id_web", e.getAttribute("id"));
            composant.setAttribute("typeAjoute", "item");
            composant.setAttribute("texte", e.getText());
            composant.setAttribute("valeur", e.getAttribute("value"));
            
            composant.setAttribute("xpath", getXPath(e));
            fenetre.addContent(composant);
        }
        
        //on cherche les liens
        results = driver.findElements(By.tagName("a"));
        for (int i=0; i<results.size(); i++) 
        {
            WebElement e = results.get(i);
            Element composant = new Element("composant");
            composant.setAttribute("id", String.valueOf(id));
            id++;
            
            if(!e.getAttribute("id").isEmpty())
                composant.setAttribute("id_web", e.getAttribute("id"));
            composant.setAttribute("typeAjoute", "lien");
            composant.setAttribute("texte", e.getText());
            if(!e.getAttribute("title").equals(e.getText()))
                composant.setAttribute("titre", e.getAttribute("title"));          
            composant.setAttribute("xpath", getXPath(e));
            if(e.getAttribute("href")!=null)
                composant.setAttribute("lien", e.getAttribute("href"));
            fenetre.addContent(composant);
        }
        
        
        //on cherche les images
        results = driver.findElements(By.tagName("img"));
        for(int i=0; i<results.size(); i++)
        {
            WebElement e = results.get(i);
            Element composant = new Element("composant");
            composant.setAttribute("id", String.valueOf(id));
            id++;
            if(!e.getAttribute("id").isEmpty())
                composant.setAttribute("id_web", e.getAttribute("id"));
            composant.setAttribute("typeAjoute", "image");
            if(!e.getAttribute("alt").isEmpty())
            composant.setAttribute("alt", e.getAttribute("alt"));
            if(!e.getText().isEmpty())
                composant.setAttribute("texte", e.getText());
            composant.setAttribute("xpath", getXPath(e));
            composant.setAttribute("titre", e.getAttribute("title"));
            composant.setAttribute("source", e.getAttribute("src"));
            
            fenetre.addContent(composant);
        }
        
        //on cherche les autres éléments pouvant contenir un label
        results = driver.findElements(By.xpath(".//*"));
        for (int i=0; i<results.size(); i++) 
        {
            WebElement e = results.get(i);
            
            if (!e.getText().isEmpty() && !e.getText().equals(" ") && !e.getText().contains("\n")) 
            {
                if(!e.getTagName().equals("option") && !e.getTagName().equals("input") && !e.getTagName().equals("img") && !e.getTagName().equals("a"))
                {
                    if(!labelIdentiquePere(e) && !identiqueAutretype(e))
                    {
                        Element composant = new Element("composant");
                        composant.setAttribute("id", String.valueOf(id));
                        id++;
                        composant.setAttribute("typeAjoute", "label");
                        composant.setAttribute("texte", e.getText());
                        composant.setAttribute("xpath", getXPath(e));
                        fenetre.addContent(composant);
                        
                        //System.out.println(e.getText()+"_______________________");
                    }
                }
            }
        }
        
        racineInterface.addContent(fenetre); 
        afficherFenetre(fenetre);
    }
    
    private boolean identiqueAutretype(WebElement label)
    {
        boolean bool = false;
        List<WebElement> results;
        
        results = label.findElements(By.tagName("input"));
        for(int i=0; i<results.size(); i++)
        {
            WebElement e = results.get(i);
            if(e.getText().equals(label.getText()))
                return true;
        }
        
        results = label.findElements(By.tagName("select"));
        for(int i=0; i<results.size(); i++)
        {
            WebElement e = results.get(i);
            if(e.getText().equals(label.getText()))
                return true;
        }
        
        results = label.findElements(By.tagName("option"));
        for(int i=0; i<results.size(); i++)
        {
            WebElement e = results.get(i);
            if(e.getText().equals(label.getText()))
                return true;
        }
        
        results = label.findElements(By.tagName("a"));
        for(int i=0; i<results.size(); i++)
        {
            WebElement e = results.get(i);
            if(e.getText().equals(label.getText()))
                return true;
        }
        
        results = label.findElements(By.tagName("img"));
        for(int i=0; i<results.size(); i++)
        {
            WebElement e = results.get(i);
            if(e.getText().equals(label.getText()))
                return true;
        }
        
        return bool;
    }
    
    private boolean labelIdentiquePere(WebElement label)
    {
        boolean bool = false;
        List<WebElement> results = label.findElements(By.xpath("parent::*"));
        if(!results.isEmpty())
        {
            WebElement pere = results.get(0);
            if(pere!=null && pere.getText().equals(label.getText()))
                bool = true;
        }
        
        return bool;
    }
    
    private void afficherFenetre(Element fenetre)
    {
        String noeud="fenetre "+"id="+fenetre.getAttributeValue("id")+" URL="+fenetre.getAttributeValue("url");
        DefaultMutableTreeNode fen = new DefaultMutableTreeNode(noeud);
        root.add(fen);
        for(int i=0;i<fenetre.getChildren().size(); i++)
        {
            Element composant= (Element) fenetre.getChildren().get(i);
            String texte=" ";
            if(composant.getAttribute("texte")!=null)
            {
                texte=" texte='"+composant.getAttributeValue("texte")+"'";
            }
            String titre=" ";
            if(composant.getAttribute("titre")!=null)
            {
                titre=" titre='"+composant.getAttributeValue("titre")+"'";
            }
            String source=" ";
            if(composant.getAttribute("source")!=null)
            {
                source=" source='"+composant.getAttributeValue("source")+"'";
            }
            String valeur=" ";
            if(composant.getAttribute("valeur")!=null)
            {
                source=" valeur='"+composant.getAttributeValue("valeur")+"'";
            }
            String lien=" ";
            if(composant.getAttribute("lien")!=null)
            {
                source=" lien='"+composant.getAttributeValue("lien")+"'";
            }
            
            noeud="composant "+"id="+composant.getAttributeValue("id")+" type="+composant.getAttributeValue("typeAjoute") +texte+titre+lien+source+valeur;
            DefaultMutableTreeNode comp = new DefaultMutableTreeNode(noeud);
            fen.add(comp);
        }
        DefaultTreeModel model = new DefaultTreeModel(root);
        Arbre.setModel(model);
        etendreArbre();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollArbre = new javax.swing.JScrollPane();
        Arbre = new javax.swing.JTree();
        BtSuivant = new javax.swing.JButton();
        BtRetour = new javax.swing.JButton();
        LbURL = new javax.swing.JLabel();
        TxtURL = new javax.swing.JTextField();
        BtURL = new javax.swing.JButton();
        BtLancer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Arbre.setToolTipText("");
        Arbre.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                ArbreValueChanged(evt);
            }
        });
        ScrollArbre.setViewportView(Arbre);

        BtSuivant.setText("Sauver");
        BtSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSuivantActionPerformed(evt);
            }
        });

        BtRetour.setText("Retour");
        BtRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRetourActionPerformed(evt);
            }
        });

        LbURL.setText("URL");

        BtURL.setText("Ajouter");
        BtURL.setToolTipText("Ajouter cette URL dans le fichier de description de l'interface de l'application-cible");
        BtURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtURLActionPerformed(evt);
            }
        });

        BtLancer.setText("Lancer");
        BtLancer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtLancerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LbURL)
                        .addGap(18, 18, 18)
                        .addComponent(TxtURL, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtRetour)
                        .addGap(18, 18, 18)
                        .addComponent(BtSuivant)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtLancer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtURL)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ScrollArbre, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbURL)
                    .addComponent(TxtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtLancer)
                    .addComponent(BtURL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 523, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtRetour)
                    .addComponent(BtSuivant))
                .addGap(21, 21, 21))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(ScrollArbre, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ArbreValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_ArbreValueChanged

    }//GEN-LAST:event_ArbreValueChanged

    private void BtSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSuivantActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(Main.EcranAccueil.chemin));
        int returnVal = chooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
            XMLFonctions.creerXML(racineInterface);
            XMLFonctions.enregistre(chooser.getSelectedFile().getPath());
            String fichier=chooser.getSelectedFile().getPath();
            driver.close();
            Main.CreationRegles.cheminEtInterface=fichier.substring(fichier.indexOf("Parametres"));            
            Main.ModificationInterface.chargerInterface();
            Main.ModificationInterface.setVisible(true);
            this.setVisible(false);           
        }        
    }//GEN-LAST:event_BtSuivantActionPerformed

    private void BtRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRetourActionPerformed
        driver.close();
        this.setVisible(false);
    }//GEN-LAST:event_BtRetourActionPerformed

    private void BtURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtURLActionPerformed
        
        creerDescriptionInterface(TxtURL.getText());
        TxtURL.setText("");
    }//GEN-LAST:event_BtURLActionPerformed

    private void BtLancerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLancerActionPerformed
        driver = new FirefoxDriver();
        driver.get(TxtURL.getText());
    }//GEN-LAST:event_BtLancerActionPerformed

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
            java.util.logging.Logger.getLogger(DescriptionInterfaceWeb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DescriptionInterfaceWeb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DescriptionInterfaceWeb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DescriptionInterfaceWeb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DescriptionInterfaceWeb().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree Arbre;
    private javax.swing.JButton BtLancer;
    private javax.swing.JButton BtRetour;
    private javax.swing.JButton BtSuivant;
    private javax.swing.JButton BtURL;
    private javax.swing.JLabel LbURL;
    private javax.swing.JScrollPane ScrollArbre;
    private javax.swing.JTextField TxtURL;
    // End of variables declaration//GEN-END:variables
}
