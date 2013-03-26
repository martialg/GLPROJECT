package model;

import java.util.ArrayList;

/**
 * Cette classe est utilisée pour les différents parcours et recherches
 * dans le graph
 * @driver Martial
 * @observor Quentin
 */
public class GraphSearch {
    private Graph graph;
    private Node current_node;
    private ArrayList<Node> tagged_nodes;
    
    public GraphSearch(Graph graph, Node node){
        this.graph = graph;
        this.current_node = node;
        this.tagged_nodes = new ArrayList<Node>();
        this.tagged_nodes.add(node);
    }
    
    /**
     * Recherche en profondeur à partir du noeud courant
     */
    public void depthFirstSearch(){
        ArrayList<Node> sons = graph.getSons(current_node);
        System.out.println(sons.size());
        for(Node son : sons){
            if(!this.isTagged(son)){
                this.current_node = son;
                this.tagged_nodes.add(son);
                this.depthFirstSearch();
            }
        }
    }
    
    /**
     * Permet de savoir si un noeud est tagé
     * @param node_search
     * @return vrai si le noeud est tagé faux sinon
     */
    public boolean isTagged(Node node_search){
        for(Node node : this.tagged_nodes)
            if(node.equals(node_search))
                return true;
        return false;
    }
    
    
    public ArrayList<Node> getTagged_nodes(){
        return this.tagged_nodes;
    }
}
