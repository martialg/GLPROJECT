package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class Graph {

    /* Attributes */
    /* Map of nodes */
    private HashMap<String, Node> nodes;
    /* Map of edges, by node 
     * For each node in the graph, we store a list of all the adjacent edges
     */
    private HashMap<String, ArrayList<Edge>> edges;

    /**
     * Public constructor
     */
    public Graph() {
        this.nodes = new HashMap<String, Node>();
        this.edges = new HashMap<String, ArrayList<Edge>>();
    }

    /* Getters */
    public HashMap<String, Node> getNodes() {
        return nodes;
    }

    public Node getNode(String name) {
        if (this.nodes.containsKey(name)) {
            return this.nodes.get(name);
        } else {
            return null;
        }
    }

    public HashMap<String, ArrayList<Edge>> getEdges() {
        return edges;
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
        if (this.edges.containsKey(current_node.getName())) {
            edges = this.edges.get(current_node.getName());
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
     * Add a node to the graph
     *
     * @param node
     */
    public void addNode(Node node) {
        nodes.put(node.getName(), node);
    }

    /**
     * Add an edge to the graph
     *
     * @param edge
     */
    public void addEdge(Edge edge) {
        // Getting the list of adjacent edges for the left node and the right node of the current edge
        ArrayList<Edge> left_edges = edges.get(edge.getLeft().getName());
        ArrayList<Edge> right_edges = edges.get(edge.getRight().getName());
        // Initialize the list of edges if empty
        if (left_edges == null) {
            left_edges = new ArrayList<Edge>();
        }
        if (right_edges == null) {
            right_edges = new ArrayList<Edge>();
        }
        // Add the edge to the lists of edges
        left_edges.add(edge);
        right_edges.add(edge);
        // Replace the old list of edges by the new one
        edges.put(edge.getLeft().getName(), left_edges);
        edges.put(edge.getRight().getName(), right_edges);
    }

    public String toString() {
        String chaine = "Graph : \n";
        for (Map.Entry entry : edges.entrySet()) {
            chaine += entry.toString() + "\n";
        }
        return chaine;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Graph other = (Graph) obj;
        for (Entry<String, Node> entry : other.nodes.entrySet()) {
            if (!Objects.equals(this.nodes.get(entry.getKey()), other.nodes.get(entry.getKey()))) {
                return false;
            }
        }
        for (Entry<String, ArrayList<Edge>> entry : other.edges.entrySet()) {
            ArrayList<Edge> t = entry.getValue();
            for (Edge edge : t) {
                if (!Objects.equals(edge, edges.get(entry.getKey()).get(edges.get(entry.getKey()).indexOf(edge)))) {
                    return false;
                }
            }
        }
        return true;
    }
}
