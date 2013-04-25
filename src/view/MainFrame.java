/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SaveFilter;
import io.GraphCreator;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.Graph;

/**
 *
 * @author Caedes
 */
public class MainFrame extends JFrame {
    
    private Graph graph;
    private javax.swing.JTextArea j_content;
    private boolean file_open = false;

    public MainFrame() {
        JPanel p_all = new javax.swing.JPanel();
        JButton b_graph_create = new javax.swing.JButton();
        JButton b_graph_display = new javax.swing.JButton();
        JButton  b_graph_request = new javax.swing.JButton();
        JPanel p_display = new javax.swing.JPanel();
        JScrollPane jscroll = new javax.swing.JScrollPane();
        j_content = new javax.swing.JTextArea();
        JMenuBar menu = new javax.swing.JMenuBar();
        JMenu menu_1 = new javax.swing.JMenu();
        JMenuItem choose_file = new javax.swing.JMenuItem();
        JMenuItem quit = new javax.swing.JMenuItem();
        JMenu menu_2 = new javax.swing.JMenu();

        b_graph_create.setText("Construire un graphe");
        b_graph_display.setText("Afficher le graphe");
        b_graph_request.setText("Faire une requête");
        j_content.setColumns(20);
        j_content.setRows(5);
        j_content.setText("Aucun graphe actuellement : en attente de fichier...");
        j_content.setLineWrap(true);
        j_content.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        j_content.setEnabled(false);
        jscroll.setViewportView(j_content);
        menu_1.setText("Ouvrir");
        choose_file.setText("Choisir un fichier");
        menu_1.add(choose_file);
        quit.setText("Quitter");
        menu_1.add(quit);
        menu.add(menu_1);
        menu_2.setText("A propos");
        menu.add(menu_2);
        setJMenuBar(menu);
        
        if(!this.file_open){
           b_graph_create.addActionListener(new java.awt.event.ActionListener() {
               @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    loadFile();
                }
            }); 
           choose_file.addActionListener(new java.awt.event.ActionListener() {
               @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    loadFile();
                }
            });
            b_graph_display.addActionListener(new java.awt.event.ActionListener() {
               @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    advertising();
                }
            }); 
            b_graph_request.addActionListener(new java.awt.event.ActionListener() {
               @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    advertising();
                }
            }); 
        }
        else if(this.file_open){
            b_graph_display.addActionListener(new java.awt.event.ActionListener() {
               @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    displayGraph();
                }
            }); 
            b_graph_request.addActionListener(new java.awt.event.ActionListener() {
               @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    launchRequestCreating();
                }
            });
        }
        quit.addActionListener(new java.awt.event.ActionListener() {
               @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                   closeWindow();
                }
        });

        javax.swing.GroupLayout p_displayLayout = new javax.swing.GroupLayout(p_display);
        p_display.setLayout(p_displayLayout);
        p_displayLayout.setHorizontalGroup(
            p_displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(p_displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jscroll, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
        );
        p_displayLayout.setVerticalGroup(
            p_displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
            .addGroup(p_displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jscroll, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout p_allLayout = new javax.swing.GroupLayout(p_all);
        p_all.setLayout(p_allLayout);
        p_allLayout.setHorizontalGroup(
            p_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_allLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(p_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_graph_request, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_graph_display, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_graph_create, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(p_allLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_display, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        p_allLayout.setVerticalGroup(
            p_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_allLayout.createSequentialGroup()
                .addComponent(p_display, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(b_graph_create)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_graph_display)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_graph_request)
                .addContainerGap())
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_all, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(p_all, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setVisible(true);
        setTitle("Programme");
        pack();
    }
    
    private void closeWindow() {                                      
        System.exit(0);
    }   
    
    public void loadFile(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new SaveFilter());

        int reponse = fileChooser.showOpenDialog(this);
        if (reponse == JFileChooser.APPROVE_OPTION) {
            File selection = fileChooser.getSelectedFile();
            String path = selection.getPath();
            try {
                this.graph = GraphCreator.GenerateGraph(path);
            } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void launchRequestCreating() {
        RequestCreating rc = new RequestCreating(this);
    }
    
    public void advertising() {
        String msg = "Charger un fichier en premier pour créer le graphe";
        JOptionPane.showMessageDialog(new JFrame(), msg);
    }
    
    public void displayGraph(){
        //a faire
    }

    public Graph getGraph() {
        return graph;
    }

    public JTextArea getJ_content() {
        return j_content;
    }

    public boolean isFile_open() {
        return file_open;
    }
    
    
}
