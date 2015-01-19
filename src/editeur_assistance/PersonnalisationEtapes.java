/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editeur_assistance;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;
import org.jdom.Element;

/**
 *
 * @author Blandine
 */
public class PersonnalisationEtapes extends javax.swing.JFrame {

    public Element sequence;
    public Boolean modeAutomatise=true;
    public Boolean messageAvant=true;
    public Boolean demandeMessageAvant=true;
    public Boolean messageApres=true;
    
    public Boolean messageAvantEtape=true;
    public Boolean demandeMessageAvantEtape=true;
    public Boolean messageApresEtape=true;
    
    public String[] choixMessagesAvantEtape;
    public String[] choixMessagesApresEtape;
    
    private int indice=-1;
    
    /**
     * Creates new form PersonnalisationPasAPas
     */
    public PersonnalisationEtapes() {
        initComponents();
        
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setBounds(150, 50, 690, 750);
    }
    
    public void chargerInterface()
    {
        this.setLayout(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/icone_editeur.png"));
        this.setIconImage(icon);
        
        ChargerLangue();
        
        CheckMessageAvant.setBounds(10, 10, 250, 40);
        CheckMessageAvant.setSelected(messageAvant);
        ScrollMessageAvant.setBounds(265, 10, 400, 40);
        TxtMessageAvant.setEnabled(messageAvant);
        if(messageAvant)
        {
            TxtMessageAvant.setText(Main.CreationActions.MessageAvantEtapesPasAPas);
        }
        else
        {
            TxtMessageAvant.setText("");
        }
        
        CheckDemandeMessageAvant.setBounds(10, 60, 250, 24);
        CheckDemandeMessageAvant.setSelected(demandeMessageAvant);
        TxtDemandeMessageAvant.setBounds(265, 60, 400, 24);
        TxtDemandeMessageAvant.setEnabled(demandeMessageAvant);
        if(demandeMessageAvant)
        {
            TxtDemandeMessageAvant.setText(Main.CreationActions.MessageAvantEtapesDemande);
        }
        else
        {
            TxtDemandeMessageAvant.setText("");
        }
        
        CheckMessageApres.setBounds(10, 90, 250, 40);
        CheckMessageApres.setSelected(messageApres);
        ScrollMessageApres.setBounds(265, 90, 400, 40);
        TxtMessageApres.setEnabled(messageApres);
        if(messageApres)
        {
            TxtMessageApres.setText(Main.CreationActions.MessageApresPasaPas);
        }
        else
        {
            TxtMessageApres.setText("");
        }
        
        LbEtapes.setBounds(10, 140, 250, 24);
        ScrollListe.setBounds(10, 170, 655, 130);
        Main.CreationRegles.ChargerListeActionPasaPas(Liste, sequence);
        
        PanelModeAutomatise.setBounds(0, 300, this.getWidth()-30, 140);
        PanelModeAutomatise.setLayout(null);
        PanelModeAutomatise.setVisible(modeAutomatise);
        
        CheckMessageAvantEtape.setBounds(10, 10, 250, 40);
        CheckMessageAvantEtape.setSelected(messageAvantEtape);
        ScrollMessageAvantEtape.setBounds(265, 10, 400, 40);
        TxtMessageAvantEtape.setText("");
        
        CheckDemandeMessageAvantEtape.setBounds(10, 60, 250, 24);
        CheckDemandeMessageAvantEtape.setSelected(demandeMessageAvantEtape);
        TxtDemandeMessageAvantEtape.setBounds(265, 60, 400, 24);
        TxtDemandeMessageAvantEtape.setText("");
        
        CheckMessageApresEtape.setBounds(10, 90, 255, 40);
        CheckMessageApresEtape.setSelected(messageApresEtape);
        ScrollMessageApresEtape.setBounds(265, 90, 400, 40);
        TxtMessageApresEtape.setText("");
        
        
        PanelMiseEnForme.setBounds(10, 450, this.getWidth()-30, 140);
        PanelMiseEnForme.setLayout(null);
        
        LbCouleur.setBounds(10, 20, 250, 30);
        BtCouleur.setBounds(260, 20, 80, 30);
        BtCouleur.setBackground(Main.CreationActions.couleurFondMessageEtape);
        LbPoliceMessage.setBounds(10, 60, 250, 30);
        BtPoliceMessage.setBounds(260, 60, 80, 30);
        BtPoliceMessage.setForeground(Main.CreationActions.couleurPoliceMessageEtape);
        BtPoliceMessage.setFont(Main.CreationActions.policeMessageEtape);
        LbPoliceBouton.setBounds(10, 100, 250, 30);
        BtPoliceBouton.setBounds(260, 100, 80, 30);
        BtPoliceBouton.setFont(Main.CreationActions.policeOptionsEtape);
        
        BtValider.setBounds(120, this.getHeight()-80, 120, 30);
        BtApercu.setBounds(250, this.getHeight()-80, 120, 30);
        BtAnnuler.setBounds(380, this.getHeight()-80, 120, 30); 
    }
    
    private void ChargerLangue()
    {
        XMLFonctions.OuvrirXML(Main.Cste.fichierInterfaceEditeur);
        Element courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("Titre").getChild(Main.Cste.langue);
        Element courant2= (Element) XMLFonctions.racine.getChild("personnalisationPasAPas").getChild("Titre").getChild(Main.Cste.langue);
        this.setTitle(courant.getText()+courant2.getText());
        
        courant= (Element) XMLFonctions.racine.getChild("personnalisationPasAPas").getChild("CheckMessageAvant").getChild(Main.Cste.langue);
        CheckMessageAvant.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("personnalisationPasAPas").getChild("CheckDemandeMessageAvant").getChild(Main.Cste.langue);
        CheckDemandeMessageAvant.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("personnalisationPasAPas").getChild("CheckMessageApres").getChild(Main.Cste.langue);
        CheckMessageApres.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("personnalisationPasAPas").getChild("LbEtapes").getChild(Main.Cste.langue);
        LbEtapes.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("personnalisationPasAPas").getChild("CheckMessageAvantEtape").getChild(Main.Cste.langue);
        CheckMessageAvantEtape.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("personnalisationPasAPas").getChild("CheckDemandeMessageAvantEtape").getChild(Main.Cste.langue);
        CheckDemandeMessageAvantEtape.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("personnalisationPasAPas").getChild("LbCouleur").getChild(Main.Cste.langue);
        LbCouleur.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("personnalisationPasAPas").getChild("LbPoliceMessage").getChild(Main.Cste.langue);
        LbPoliceMessage.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("personnalisationPasAPas").getChild("LbPoliceBouton").getChild(Main.Cste.langue);
        LbPoliceBouton.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("personnalisationPasAPas").getChild("PanelMiseEnForme").getChild(Main.Cste.langue);
        TitledBorder title = BorderFactory.createTitledBorder(courant.getText());
        PanelMiseEnForme.setBorder(title);
        courant= (Element) XMLFonctions.racine.getChild("personnalisationPasAPas").getChild("BtValider").getChild(Main.Cste.langue);
        BtValider.setToolTipText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("personnalisationPasAPas").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnuler.setToolTipText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("personnalisationPasAPas").getChild("BtApercu").getChild(Main.Cste.langue);
        BtApercu.setToolTipText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("personnalisationPasAPas").getChild("BtCouleur").getChild(Main.Cste.langue);
        BtCouleur.setToolTipText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("personnalisationPasAPas").getChild("BtPoliceMessage").getChild(Main.Cste.langue);
        BtPoliceMessage.setToolTipText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("personnalisationPasAPas").getChild("BtPoliceBouton").getChild(Main.Cste.langue);
        BtPoliceBouton.setToolTipText(courant.getText());
        
        
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("BtValider").getChild(Main.Cste.langue);
        BtValider.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("BtAnnuler").getChild(Main.Cste.langue);
        BtAnnuler.setText(courant.getText());
        courant= (Element) XMLFonctions.racine.getChild("Communs").getChild("BtApercu").getChild(Main.Cste.langue);
        BtApercu.setText(courant.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CheckMessageAvant = new javax.swing.JCheckBox();
        CheckDemandeMessageAvant = new javax.swing.JCheckBox();
        CheckMessageApres = new javax.swing.JCheckBox();
        ScrollMessageAvant = new javax.swing.JScrollPane();
        TxtMessageAvant = new javax.swing.JTextArea();
        ScrollMessageApres = new javax.swing.JScrollPane();
        TxtMessageApres = new javax.swing.JTextArea();
        TxtDemandeMessageAvant = new javax.swing.JTextField();
        ScrollListe = new javax.swing.JScrollPane();
        Liste = new javax.swing.JList();
        LbEtapes = new javax.swing.JLabel();
        PanelModeAutomatise = new javax.swing.JPanel();
        TxtDemandeMessageAvantEtape = new javax.swing.JTextField();
        ScrollMessageApresEtape = new javax.swing.JScrollPane();
        TxtMessageApresEtape = new javax.swing.JTextArea();
        ScrollMessageAvantEtape = new javax.swing.JScrollPane();
        TxtMessageAvantEtape = new javax.swing.JTextArea();
        CheckMessageAvantEtape = new javax.swing.JCheckBox();
        CheckDemandeMessageAvantEtape = new javax.swing.JCheckBox();
        CheckMessageApresEtape = new javax.swing.JCheckBox();
        BtAnnuler = new javax.swing.JButton();
        BtApercu = new javax.swing.JButton();
        BtValider = new javax.swing.JButton();
        PanelMiseEnForme = new javax.swing.JPanel();
        LbCouleur = new javax.swing.JLabel();
        BtPoliceBouton = new javax.swing.JButton();
        LbPoliceBouton = new javax.swing.JLabel();
        BtPoliceMessage = new javax.swing.JButton();
        LbPoliceMessage = new javax.swing.JLabel();
        BtCouleur = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CheckMessageAvant.setText("Message avant le début du pas à pas");
        CheckMessageAvant.setEnabled(false);
        CheckMessageAvant.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckMessageAvantItemStateChanged(evt);
            }
        });
        CheckMessageAvant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckMessageAvantActionPerformed(evt);
            }
        });

        CheckDemandeMessageAvant.setText("Demander l'autorisation à l'utilisateur");
        CheckDemandeMessageAvant.setEnabled(false);

        CheckMessageApres.setText("Message à la fin du pas à pas");
        CheckMessageApres.setEnabled(false);
        CheckMessageApres.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckMessageApresItemStateChanged(evt);
            }
        });

        TxtMessageAvant.setColumns(20);
        TxtMessageAvant.setRows(5);
        ScrollMessageAvant.setViewportView(TxtMessageAvant);

        TxtMessageApres.setColumns(20);
        TxtMessageApres.setRows(5);
        ScrollMessageApres.setViewportView(TxtMessageApres);

        Liste.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "item1", "item2", "item3" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        Liste.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Liste.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListeValueChanged(evt);
            }
        });
        ScrollListe.setViewportView(Liste);

        LbEtapes.setText("Liste des étapes :");

        TxtDemandeMessageAvantEtape.setText("jTextField1");

        TxtMessageApresEtape.setColumns(20);
        TxtMessageApresEtape.setRows(5);
        ScrollMessageApresEtape.setViewportView(TxtMessageApresEtape);

        TxtMessageAvantEtape.setColumns(20);
        TxtMessageAvantEtape.setRows(5);
        ScrollMessageAvantEtape.setViewportView(TxtMessageAvantEtape);

        CheckMessageAvantEtape.setText("Message avant l'étape séléctionnée");
        CheckMessageAvantEtape.setEnabled(false);
        CheckMessageAvantEtape.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckMessageAvantEtapeItemStateChanged(evt);
            }
        });
        CheckMessageAvantEtape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckMessageAvantEtapeActionPerformed(evt);
            }
        });

        CheckDemandeMessageAvantEtape.setText("Demander l'autorisation à l'utilisateur");
        CheckDemandeMessageAvantEtape.setEnabled(false);

        CheckMessageApresEtape.setText("Message à la fin de l'étape séléctionnée");
        CheckMessageApresEtape.setEnabled(false);
        CheckMessageApresEtape.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckMessageApresEtapeItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout PanelModeAutomatiseLayout = new javax.swing.GroupLayout(PanelModeAutomatise);
        PanelModeAutomatise.setLayout(PanelModeAutomatiseLayout);
        PanelModeAutomatiseLayout.setHorizontalGroup(
            PanelModeAutomatiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
            .addGroup(PanelModeAutomatiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelModeAutomatiseLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(PanelModeAutomatiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelModeAutomatiseLayout.createSequentialGroup()
                            .addComponent(CheckMessageAvantEtape, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(ScrollMessageAvantEtape))
                        .addGroup(PanelModeAutomatiseLayout.createSequentialGroup()
                            .addGroup(PanelModeAutomatiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CheckMessageApresEtape)
                                .addComponent(CheckDemandeMessageAvantEtape))
                            .addGap(36, 36, 36)
                            .addGroup(PanelModeAutomatiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ScrollMessageApresEtape, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                .addComponent(TxtDemandeMessageAvantEtape))))
                    .addGap(12, 12, 12)))
        );
        PanelModeAutomatiseLayout.setVerticalGroup(
            PanelModeAutomatiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
            .addGroup(PanelModeAutomatiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelModeAutomatiseLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(PanelModeAutomatiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelModeAutomatiseLayout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(CheckMessageAvantEtape))
                        .addComponent(ScrollMessageAvantEtape, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelModeAutomatiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelModeAutomatiseLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(PanelModeAutomatiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CheckDemandeMessageAvantEtape)
                                .addComponent(TxtDemandeMessageAvantEtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(29, 29, 29)
                            .addComponent(CheckMessageApresEtape))
                        .addGroup(PanelModeAutomatiseLayout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addComponent(ScrollMessageApresEtape, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        BtAnnuler.setText("Annuler");
        BtAnnuler.setToolTipText("Retour à la définition des règles d'assistance");
        BtAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnnulerActionPerformed(evt);
            }
        });

        BtApercu.setText("Aperçu");
        BtApercu.setToolTipText("Voir un aperçu de la mise en valeur définie sur des composants exemples");
        BtApercu.setEnabled(false);
        BtApercu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtApercuActionPerformed(evt);
            }
        });

        BtValider.setText("Valider");
        BtValider.setToolTipText("Valider l'action et revenir à la définition des règles d'assistance");
        BtValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtValiderActionPerformed(evt);
            }
        });

        PanelMiseEnForme.setBorder(javax.swing.BorderFactory.createTitledBorder("Options de mise en forme"));

        LbCouleur.setText("Couleur de fond des messages");

        BtPoliceBouton.setText("abc");
        BtPoliceBouton.setToolTipText("Modifier la police des boutons");
        BtPoliceBouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPoliceBoutonActionPerformed(evt);
            }
        });

        LbPoliceBouton.setText("Police des boutons");

        BtPoliceMessage.setText("abc");
        BtPoliceMessage.setToolTipText("Modifier la police du message");
        BtPoliceMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPoliceMessageActionPerformed(evt);
            }
        });

        LbPoliceMessage.setText("Police des messages");

        BtCouleur.setText("...");
        BtCouleur.setToolTipText("Modifier la couleur de fond du message");
        BtCouleur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCouleurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMiseEnFormeLayout = new javax.swing.GroupLayout(PanelMiseEnForme);
        PanelMiseEnForme.setLayout(PanelMiseEnFormeLayout);
        PanelMiseEnFormeLayout.setHorizontalGroup(
            PanelMiseEnFormeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(PanelMiseEnFormeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelMiseEnFormeLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addGroup(PanelMiseEnFormeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(PanelMiseEnFormeLayout.createSequentialGroup()
                            .addComponent(LbPoliceBouton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtPoliceBouton))
                        .addGroup(PanelMiseEnFormeLayout.createSequentialGroup()
                            .addComponent(LbPoliceMessage)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtPoliceMessage))
                        .addGroup(PanelMiseEnFormeLayout.createSequentialGroup()
                            .addComponent(LbCouleur)
                            .addGap(18, 18, 18)
                            .addComponent(BtCouleur)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        PanelMiseEnFormeLayout.setVerticalGroup(
            PanelMiseEnFormeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(PanelMiseEnFormeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelMiseEnFormeLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addGroup(PanelMiseEnFormeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LbCouleur)
                        .addComponent(BtCouleur))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(PanelMiseEnFormeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LbPoliceMessage)
                        .addComponent(BtPoliceMessage))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(PanelMiseEnFormeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LbPoliceBouton)
                        .addComponent(BtPoliceBouton))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelModeAutomatise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CheckMessageAvant)
                                .addGap(36, 36, 36)
                                .addComponent(ScrollMessageAvant))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CheckMessageApres)
                                    .addComponent(CheckDemandeMessageAvant))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ScrollMessageApres, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                    .addComponent(TxtDemandeMessageAvant)))
                            .addComponent(ScrollListe, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LbEtapes)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(BtValider)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtApercu)
                        .addGap(18, 18, 18)
                        .addComponent(BtAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelMiseEnForme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(CheckMessageAvant))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ScrollMessageAvant, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CheckDemandeMessageAvant)
                            .addComponent(TxtDemandeMessageAvant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(CheckMessageApres))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(ScrollMessageApres, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(LbEtapes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollListe, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelModeAutomatise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelMiseEnForme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtValider)
                    .addComponent(BtApercu)
                    .addComponent(BtAnnuler))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CheckMessageAvantItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckMessageAvantItemStateChanged

    }//GEN-LAST:event_CheckMessageAvantItemStateChanged

    private void CheckMessageAvantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckMessageAvantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckMessageAvantActionPerformed

    private void CheckMessageApresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckMessageApresItemStateChanged

    }//GEN-LAST:event_CheckMessageApresItemStateChanged

    private void CheckMessageApresEtapeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckMessageApresEtapeItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckMessageApresEtapeItemStateChanged

    private void CheckMessageAvantEtapeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckMessageAvantEtapeItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckMessageAvantEtapeItemStateChanged

    private void CheckMessageAvantEtapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckMessageAvantEtapeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckMessageAvantEtapeActionPerformed

    private void BtAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnnulerActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BtAnnulerActionPerformed

    private void BtApercuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtApercuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtApercuActionPerformed

    private void BtValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtValiderActionPerformed
        if(messageAvant)
            Main.CreationActions.MessageAvantEtapesPasAPas=TxtMessageAvant.getText();
        if(demandeMessageAvant)
            Main.CreationActions.MessageAvantEtapesDemande=TxtDemandeMessageAvant.getText();
        if(messageApres)
            Main.CreationActions.MessageApresPasaPas=TxtMessageApres.getText();
        
        if(messageAvant)
        {
            if(Liste.getSelectedIndex()>=0)
            {
                if(messageAvantEtape)
                {
                    if(indice!=-1)
                        choixMessagesAvantEtape[indice]=TxtMessageAvantEtape.getText();
                    TxtMessageAvantEtape.setText(choixMessagesAvantEtape[Liste.getSelectedIndex()]);
                }
            }
            Main.CreationActions.choixMessagesAvantEtapePasaPas=choixMessagesAvantEtape;
        }
        if(demandeMessageAvant)
            Main.CreationActions.MessageAvantEtapeDemande=TxtDemandeMessageAvantEtape.getText();
        if(messageApres)
        {
            if(Liste.getSelectedIndex()>=0)
            {
                if(messageApresEtape)
                {
                    if(indice!=-1)
                        choixMessagesApresEtape[indice]=TxtMessageApresEtape.getText();
                    TxtMessageApresEtape.setText(choixMessagesApresEtape[Liste.getSelectedIndex()]);
                }
            }
            Main.CreationActions.choixMessagesApresEtapePasaPas=choixMessagesApresEtape;
        }
        
        Main.CreationActions.couleurFondMessageEtape=BtCouleur.getBackground();
        Main.CreationActions.couleurPoliceMessageEtape=BtPoliceMessage.getForeground();
        Main.CreationActions.policeMessageEtape=BtPoliceMessage.getFont();
        Main.CreationActions.policeOptionsEtape=BtPoliceBouton.getFont();
        
        this.setVisible(false);
    }//GEN-LAST:event_BtValiderActionPerformed

    private void ListeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListeValueChanged
        if(Liste.getSelectedIndex()>=0)
        {
            if(messageAvantEtape)
            {
                if(indice!=-1)
                    choixMessagesAvantEtape[indice]=TxtMessageAvantEtape.getText();
                TxtMessageAvantEtape.setText(choixMessagesAvantEtape[Liste.getSelectedIndex()]);
            }
            
            if(demandeMessageAvantEtape)
            {
                TxtDemandeMessageAvantEtape.setText(Main.CreationActions.MessageAvantEtapeDemande);
            }
            
            if(messageApresEtape)
            {
                if(indice!=-1)
                    choixMessagesApresEtape[indice]=TxtMessageApresEtape.getText();
                TxtMessageApresEtape.setText(choixMessagesApresEtape[Liste.getSelectedIndex()]);
            }
            indice=Liste.getSelectedIndex();
        }
    }//GEN-LAST:event_ListeValueChanged

    private void BtPoliceMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPoliceMessageActionPerformed
        Main.ChoixPolice.chargerInterface();
        Main.ChoixPolice.chargerChoix(BtPoliceMessage);
        Main.ChoixPolice.setVisible(true);
    }//GEN-LAST:event_BtPoliceMessageActionPerformed

    private void BtCouleurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCouleurActionPerformed
        BtCouleur.setBackground(JColorChooser.showDialog(null, "Choisir une couleur", BtCouleur.getBackground()));
        this.repaint();
    }//GEN-LAST:event_BtCouleurActionPerformed

    private void BtPoliceBoutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPoliceBoutonActionPerformed
        Main.ChoixPolice.chargerInterface();
        Main.ChoixPolice.chargerChoix(BtPoliceBouton);
        Main.ChoixPolice.setVisible(true);
    }//GEN-LAST:event_BtPoliceBoutonActionPerformed

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
            java.util.logging.Logger.getLogger(PersonnalisationEtapes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonnalisationEtapes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonnalisationEtapes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonnalisationEtapes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PersonnalisationEtapes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAnnuler;
    private javax.swing.JButton BtApercu;
    private javax.swing.JButton BtCouleur;
    private javax.swing.JButton BtPoliceBouton;
    private javax.swing.JButton BtPoliceMessage;
    private javax.swing.JButton BtValider;
    private javax.swing.JCheckBox CheckDemandeMessageAvant;
    private javax.swing.JCheckBox CheckDemandeMessageAvantEtape;
    private javax.swing.JCheckBox CheckMessageApres;
    private javax.swing.JCheckBox CheckMessageApresEtape;
    private javax.swing.JCheckBox CheckMessageAvant;
    private javax.swing.JCheckBox CheckMessageAvantEtape;
    private javax.swing.JLabel LbCouleur;
    private javax.swing.JLabel LbEtapes;
    private javax.swing.JLabel LbPoliceBouton;
    private javax.swing.JLabel LbPoliceMessage;
    private javax.swing.JList Liste;
    private javax.swing.JPanel PanelMiseEnForme;
    private javax.swing.JPanel PanelModeAutomatise;
    private javax.swing.JScrollPane ScrollListe;
    private javax.swing.JScrollPane ScrollMessageApres;
    private javax.swing.JScrollPane ScrollMessageApresEtape;
    private javax.swing.JScrollPane ScrollMessageAvant;
    private javax.swing.JScrollPane ScrollMessageAvantEtape;
    private javax.swing.JTextField TxtDemandeMessageAvant;
    private javax.swing.JTextField TxtDemandeMessageAvantEtape;
    private javax.swing.JTextArea TxtMessageApres;
    private javax.swing.JTextArea TxtMessageApresEtape;
    private javax.swing.JTextArea TxtMessageAvant;
    private javax.swing.JTextArea TxtMessageAvantEtape;
    // End of variables declaration//GEN-END:variables
}
