/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Direction;
import model.Edge;
import model.GraphSearch;
import model.Node;
import model.Property;
import model.Request;

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
    private JTextField text_valR1;
    private JTextField text_valR2;
    
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
        JLabel l_1 = new javax.swing.JLabel();
        text_valR1 = new javax.swing.JTextField();
        JLabel l_2 = new javax.swing.JLabel();
        text_valR2 = new javax.swing.JTextField();
        JButton b_cancel = new javax.swing.JButton("Annuler");
        JButton b_valide = new javax.swing.JButton("Rechercher");
        
        l_tittle.setText("CHOIX DE LA RECHERCHE :");
        l_mode.setText("Mode de recherche");
        combo_mode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Largeur", "Profondeur" }));
        l_level.setText("Niveau de parcours");
        text_level.setText("");
        l_unicity.setText("Unicité");
        text_unicity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Oui", "Non" }));
        l_node.setText("Noeud debut");
        text_node.setText("");
        l_nomR1.setText("Nom relation");
        text_nomR1.setText("");
        l_prop1.setText("Propriété");
        R1.setText("RELATION 1 :");
        text_propR1.setText("");
        l_sensR1.setText("Sens");
        combo_sensR1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<>", ">", "<" }));
        combo_sensR2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<>", ">", "<" }));
        l_sensR2.setText("Sens");
        text_propR2.setText("");
        R2.setText("RELATION 2 :");
        l_propR2.setText("Propriété");
        text_nomR2.setText("");
        l_nomR2.setText("Nom relation");
        Attr.setText("ATTRIBUTS");
        l_1.setText("=");
        text_valR1.setText("");
        l_2.setText("=");
        text_valR2.setText("");

        b_valide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Request request = createRequest();
                GraphSearch graph_search = request.execute();
                //main_frame.setJ_content().add(new JLabel(graph_search.getResultats()));
                
            }
        });
        
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(combo_mode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(text_level, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(text_unicity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(text_node)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(b_valide, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(text_propR1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(l_1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(text_valR1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(text_nomR1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(combo_sensR1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(text_nomR2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(combo_sensR2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(text_propR2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(l_2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(text_valR2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
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
                    .addComponent(text_propR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_1)
                    .addComponent(text_valR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(text_propR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(l_2)
                        .addComponent(text_valR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
    
    public Request createRequest(){
        if((!"".equals(text_node.getText())) && (!"".equals(text_level.getText()))){
            Request rq = new Request();
            //graphe
            rq.setGraph(this.main_frame.getGraph());
            //noeud initial
            String name_node = this.text_node.getText();
            Node first_node = this.main_frame.getGraph().getNode(name_node);
            rq.setFisrt_node(first_node);
            //niveau
            int level_field = Integer.parseInt(this.text_level.getText());
            rq.setLevel(level_field);
            //mode
            String mode_choosed = "DFS";
            if("Largeur".equals(combo_mode.getSelectedItem().toString())){
               mode_choosed = "BFS";  
            }
            rq.setMode(mode_choosed);
            //unicity
            boolean bool_unicity = false;
            if("Oui".equals(text_unicity.getSelectedItem().toString())){
               bool_unicity = true;  
            }
            rq.setUnicity(bool_unicity);
            ArrayList<Edge> link = new ArrayList<Edge>();
            //ArrayList<Edge> link_list
            if(!"".equals(text_nomR1.getText())){
                Edge e = null;
                if(!"<>".equals(this.combo_sensR1.getSelectedItem().toString())){
                    e = new  Edge(text_nomR1.getText(), first_node, (Node) null, Direction.BOTH.toString());
                }
                else if(!">".equals(this.combo_sensR1.getSelectedItem().toString())){
                    e = new  Edge(text_nomR1.getText(), first_node, (Node) null, Direction.RIGHT.toString());
                }
                else if(!"<".equals(this.combo_sensR1.getSelectedItem().toString())){
                    e = new  Edge(text_nomR1.getText(), first_node, (Node) null, Direction.LEFT.toString());
                }
                if((!"".equals(this.text_propR1.getText())) && (!"".equals(this.text_valR1.getText()))){
                    String[] value = {text_valR1.getText()};
                    Property p = new Property(text_propR1.getText(), value);
                    e.addProperty(p);
                }
                link.add(e);
            }
            if(!"".equals(text_nomR2.getText())){
                Edge e = null;
                if(!"<>".equals(this.combo_sensR2.getSelectedItem().toString())){
                    e = new  Edge(text_nomR2.getText(), first_node, (Node) null, Direction.BOTH.toString());
                }
                else if(!">".equals(this.combo_sensR2.getSelectedItem().toString())){
                    e = new  Edge(text_nomR2.getText(), first_node, (Node) null, Direction.RIGHT.toString());
                }
                else if(!"<".equals(this.combo_sensR2.getSelectedItem().toString())){
                    e = new  Edge(text_nomR2.getText(), first_node, (Node) null, Direction.LEFT.toString());
                }
                if((!"".equals(this.text_propR2.getText())) && (!"".equals(this.text_valR2.getText()))){
                    String[] value = {text_valR2.getText()};
                    Property p = new Property(text_propR2.getText(), value);
                    e.addProperty(p);
                }
                link.add(e);
            }
            rq.setLink_list(link);  
            return rq;
        }
        else {
            return null;
        }
    }
}
