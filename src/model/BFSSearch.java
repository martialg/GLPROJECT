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
public class BFSSearch extends GraphSearch {

    public BFSSearch(Graph graph) {
        super(graph, null, 0);
    }
    
    public BFSSearch(Graph graph, HashMap<String, ArrayList<Edge>> edges, int level) {
        super(graph, edges, level);
    }

    @Override
    public void search(Node node) {
        ArrayList<Node> list_nodes = new ArrayList<Node>();
        list_nodes.add(node);
        this.marked_nodes.add(node);
        while (!(list_nodes.isEmpty())) {
            Node x = list_nodes.remove(0);
            ArrayList<Node> list_son = this.getSons(x);
            for (int i = 0; i < list_son.size(); i++) {
                Node son = list_son.get(i);
                if (!isTagged(son)) {		//Si le fils est pas marqué ALORS    
                    this.marked_nodes.add(son);
                    list_nodes.add(son);
                }
            }
        }
    }
}
