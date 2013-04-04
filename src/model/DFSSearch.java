/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Romain
 */
public class DFSSearch extends GraphSearch {

    public DFSSearch(Graph graph) {
        super(graph, null, 0);
    }
    
    public DFSSearch(Graph graph, HashMap<String, ArrayList<Edge>> edges, int level) {
        super(graph, edges, level);
    }
    
    @Override
    public void search(Node node) {
        ArrayList<Node> sons = this.getSons(node);
        System.out.println(sons.size());
        if (!this.isTagged(node)) {
            this.marked_nodes.add(node);
        }
        
        for (Node son : sons) {
            if (!isTagged(son)) {
                this.marked_nodes.add(son);
                this.search(son);
            }
        }
    }
    
}
