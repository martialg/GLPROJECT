/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class DFSSearch extends GraphSearch {

    public DFSSearch(Graph graph) {
        super(graph, null, 0);
    }
    
    public DFSSearch(Graph graph, HashMap<String, ArrayList<Edge>> edges, int level) {
        super(graph, edges, level);
    }
    
    @Override
    public void search(Node node) {
        this.marked_nodes.add(node);
        //obligé d'appeler la méthode comme cela car il faut marque le premier
        //noeud à l'appel de la méthode "search"
        this.searchRecursive(node);
    }
    
    public void searchRecursive(Node node){
        //permet de récupérer noeud et arc associé pour effectuer
        //la bonne unicité
        HashMap<Node, Edge> pairs_son_edge = this.getSonsApplyFilter(node);
        for (Entry<Node, Edge> pair : pairs_son_edge.entrySet()) {
            Node temp_node = pair.getKey();
            Edge temp_edge = pair.getValue();
            if(this.uniqueness_type == 1 && !isTaggedNode(temp_node) 
                    || this.uniqueness_type == 2 && !isTaggedEdge(temp_edge)){
                if(!this.marked_nodes.contains(temp_node))
                    this.marked_nodes.add(temp_node);
                if(!this.marked_edges.contains(temp_edge))
                    this.marked_edges.add(temp_edge);
                this.searchRecursive(temp_node);
            }
        }
    }
    
}
