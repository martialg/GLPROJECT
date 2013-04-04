package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Cette classe est utilisée pour les différents parcours et recherches
 * dans le graph
 * @driver Martial
 * @observor Quentin
 */
public abstract class GraphSearch {
    protected Graph graph;
    protected HashMap edges;
    protected ArrayList<Node> marked_nodes;
    protected int level;
    
    public GraphSearch(Graph graph, HashMap<String,ArrayList<Edge>> edges, int level){
        this.graph = graph;
        this.edges = edges;
        this.marked_nodes = new ArrayList<Node>();
        this.level = level;
    }
    
    /**
     * Return current node's sons
     *
     * @param current_node current node
     * @return current node's sons
     */
    public ArrayList<Node> getSons(Node current_node) {
        ArrayList<Node> sons = new ArrayList<Node>();
        ArrayList<Edge> edges = new ArrayList<Edge>();
        if (this.graph.getEdges().containsKey(current_node.getName())) {
            edges = this.graph.getEdges().get(current_node.getName());
        }
        for (Edge edge : edges) {
            if (edge.getLeft().equals(current_node)) {
                sons.add(edge.getRight());
            } else {
                sons.add(edge.getLeft());
            }
        }
        return sons;
    }
    
    /**
     * Permet de savoir si un noeud est tagé
     * @param nd noeud a tester
     * @return vrai si le noeud est tagé faux sinon
     */
    public boolean isTagged(Node nd) {
        for (Node node : this.marked_nodes) {
            if (node.equals(nd)) {
                return true;
            }
        }
        return false;
    }
    
    public abstract void search(Node node);
}
