/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Caedes
 */
public class RequestCreating extends JDialog {
    
    private MainFrame main_frame;
    private JLabel l_mode;
    private JComboBox combo_mode;
    private JTextField text_level;
    private JComboBox text_unicity;
    private JTextField text_node;
    private JTextField text_nomR1;
    private JTextField text_propR1;
    private JComboBox combo_sensR1;
    private JComboBox combo_sensR2;
    private JTextField text_propR2;
    private JTextField text_nomR2;
    
    //Exemple : request -start nom -level level -unicity on/off -mode BFS/DFS -link (nom_relation[propriété=valeur,..] sens|nom_relation,...)
    public RequestCreating(MainFrame f) {
        super();
        this.main_frame = f;
        JLabel l_tittle = new javax.swing.JLabel();
        l_mode = new javax.swing.JLabel();
        combo_mode = new javax.swing.JComboBox();
        JLabel l_level = new javax.swing.JLabel();
        text_level = new javax.swing.JTextField();
        JLabel l_unicity = new javax.swing.JLabel();
        text_unicity = new javax.swing.JComboBox();
        JLabel l_node = new javax.swing.JLabel();
        text_node = new javax.swing.JTextField();
        JLabel l_nomR1 = new javax.swing.JLabel();
        text_nomR1 = new javax.swing.JTextField();
        JLabel l_prop1 = new javax.swing.JLabel();
        JLabel R1 = new javax.swing.JLabel();
        text_propR1 = new javax.swing.JTextField();
        JLabel l_sensR1 = new javax.swing.JLabel();
        combo_sensR1 = new javax.swing.JComboBox();
        combo_sensR2 = new javax.swing.JComboBox();
        JLabel l_sensR2 = new javax.swing.JLabel();
        text_propR2 = new javax.swing.JTextField();
        JLabel R2 = new javax.swing.JLabel();
        JLabel l_propR2 = new javax.swing.JLabel();
        text_nomR2 = new javax.swing.JTextField();
        JLabel l_nomR2 = new javax.swing.JLabel();
        JLabel Attr = new javax.swing.JLabel();
        JButton b_cancel = new javax.swing.JButton();
        JButton b_valide = new javax.swing.JButton();
        
        l_tittle.setText("CHOIX DE LA RECHERCHE :");
        l_mode.setText("Mode de recherche");
        combo_mode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Largeur", "Profondeur" }));
        l_level.setText("Niveau de parcours");
        text_level.setText("jTextField1");
        l_unicity.setText("Unicité");
        text_unicity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Oui", "Non" }));
        l_node.setText("Noeud debut");
        text_node.setText("jTextField2");
        l_nomR1.setText("Nom relation");
        text_nomR1.setText("jTextField3");
        l_prop1.setText("Propriété");
        R1.setText("RELATION 1 :");
        text_propR1.setText("jTextField4");
        l_sensR1.setText("Sens");
        combo_sensR1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", ">", "<", "<>" }));
        combo_sensR2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", ">", "<", "<>" }));
        l_sensR2.setText("Sens");
        text_propR2.setText("jTextField4");
        R2.setText("RELATION 2 :");
        l_propR2.setText("Propriété");
        text_nomR2.setText("jTextField3");
        l_nomR2.setText("Nom relation");
        Attr.setText("ATTRIBUTS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(Attr))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(l_tittle))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l_level)
                                    .addComponent(l_mode)
                                    .addComponent(l_unicity)
                                    .addComponent(l_node)
                                    .addComponent(l_nomR1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(l_sensR1)
                                        .addComponent(R1))
                                    .addComponent(l_nomR2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(l_sensR2)
                                        .addComponent(R2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(l_prop1)
                                            .addComponent(l_propR2)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(b_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(combo_mode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(text_level, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(text_unicity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(text_node)
                                    .addComponent(text_nomR1)
                                    .addComponent(text_propR1)
                                    .addComponent(combo_sensR1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(text_nomR2)
                                    .addComponent(text_propR2)
                                    .addComponent(combo_sensR2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(b_valide, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_tittle)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_mode)
                    .addComponent(combo_mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_level)
                    .addComponent(text_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_unicity)
                    .addComponent(text_unicity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_node)
                    .addComponent(text_node, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(Attr)
                .addGap(24, 24, 24)
                .addComponent(R1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_nomR1)
                    .addComponent(text_nomR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_prop1)
                    .addComponent(text_propR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_sensR1)
                    .addComponent(combo_sensR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(R2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_nomR2)
                    .addComponent(text_nomR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_propR2)
                    .addComponent(text_propR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_sensR2)
                    .addComponent(combo_sensR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancel)
                    .addComponent(b_valide))
                .addContainerGap())
        );

        setVisible(true);
        pack();
    }
    
    /*
    public Request createRequest(){
        Request rq = new Request();
        //graphe
        rq.setGraph(this.main_frame.getGraph());
        
        //noeud initial
        rq.setFirstNode()
        
        //niveau
        
        rq.setLevel();
        
        //mode
        rq.setMode(this.combo_mode.getSelectedItem().toString());
        
        //unicity
        boolean bool_unicity = false;
        if("oui".equals(colorChoosed)){
           bool_unicity = true;  
        }
        rq.setUnicity(bool_unicity);
        
        
        //ArrayList<Edge> link_list
        
        return rq;
    }*/
}
