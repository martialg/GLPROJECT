package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Cette classe est utilisée pour les différents parcours et recherches dans le
 * graph
 * 
 * Sprint 2
 * @driver Martial
 * @observor Quentin
 * 
 * Sprint 3
 * @driver Quentin
 * @observor Martial
 */
public abstract class GraphSearch {

    protected Graph graph;
    protected ArrayList<Node> marked_nodes;
    protected ArrayList<String> list_connection;
    protected HashMap<String, Direction> edge_direction;
    protected HashMap<String, ArrayList<Property>> edge_propreties;
    protected int level;

    public GraphSearch(Graph graph, HashMap<String, ArrayList<Edge>> edges, int level) {
        this.graph = graph;
        this.marked_nodes = new ArrayList<Node>();
        this.level = level;
    }

    /**
     * Return current node's sons
     *
     * @param current_node current node
     * @return current egde's sons
     */
    public ArrayList<Edge> getSonsEdge(Node current_node) {
        ArrayList<Edge> list_edges = new ArrayList<Edge>();
        if (this.graph.getEdges().containsKey(current_node.getName())) {
            list_edges = this.graph.getEdges().get(current_node.getName());
        }
        return list_edges;
    }

    /**
     * Permet de savoir si un noeud est tagé
     *
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

    public ArrayList<Node> getSonsApplyFilter(Node current_node) {
        ArrayList<Edge> list_edges = new ArrayList<Edge>();
        ArrayList<Node> list_nodes = new ArrayList<Node>();
        Edge edge_temp;
        list_edges = getSonsEdge(current_node);
        ArrayList<Edge> list_edges_filtered = new ArrayList<Edge>();
        for (Edge current_edge : list_edges) {
            edge_temp = applyAllFilters(current_edge);
            if (edge_temp != null)
                list_edges_filtered.add(edge_temp);
        }
        for (Edge current_edge_filtered : list_edges_filtered) {
            list_nodes.add(current_edge_filtered.extractSoonNode(current_node));
        }
        return list_nodes;
    }


    public Edge applyAllFilters(Edge current_edge) {
        Edge temp_edge;
        temp_edge = applyFilterExploreEdge(current_edge);
        if(temp_edge != null) temp_edge = applyFilterFiltre(temp_edge);
        return temp_edge;
    }

    public Edge applyFilterFiltre(Edge current_edge){
        HashMap<String, Property> current_edge_properties = current_edge.getProperties();
        ArrayList<Property> edge_properties_required = this.edge_propreties.get(current_edge.getName());
        for(Property property_required : edge_properties_required){
            Property temp_current_property = current_edge_properties.get(property_required.getName());
            if(temp_current_property == null){ 
                return null;
            }else{
                for(String value_required : property_required.getValues()){
                    boolean exist_value = false;
                    for(String value_current : temp_current_property.getValues()){
                        if(value_current.compareTo(value_current) == 0){
                            exist_value = true;
                        }
                    }
                    if(exist_value == false){
                        return null;
                    }
                }
            }
        }
        return current_edge;
    }
    
    public Edge applyFilterExploreEdge(Edge current_edge){
        if(this.list_connection.contains(current_edge.getName()))
            if(this.edge_direction.get(current_edge.getName()) == current_edge.getDirection()) 
                return current_edge;
        return null;
    }
    
}
