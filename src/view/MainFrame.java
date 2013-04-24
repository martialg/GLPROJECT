/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Caedes
 */
public class MainFrame extends JFrame {
    
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        b_graph_create.setText("Construire un graphe");

        b_graph_display.setText("Afficher le graphe");

        b_graph_request.setText("Faire une requête");

        j_content.setColumns(20);
        j_content.setRows(5);
        jscroll.setViewportView(j_content);

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

        menu_1.setText("Ouvrir");

        choose_file.setText("Choisir un fichier");
        menu_1.add(choose_file);

        quit.setText("Quitter");
        menu_1.add(quit);

        menu.add(menu_1);

        menu_2.setText("A propos");
        menu.add(menu_2);

        setJMenuBar(menu);

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

        pack();
    }
    
    
    
}