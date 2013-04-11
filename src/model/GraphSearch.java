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
    protected ArrayList<Edge> marked_edges;
    /** Type d'unicité 1 : noeud / 2 : arc. Par défaut à 1*/
    protected int uniqueness_type;
    protected ArrayList<String> list_connection;
    protected HashMap<String, Direction> edge_direction;
    protected HashMap<String, ArrayList<Property>> edge_propreties;
    protected int level;

    public GraphSearch(Graph graph, HashMap<String, ArrayList<Edge>> edges, int level) {
        this.graph = graph;
        this.marked_nodes = new ArrayList<Node>();
        this.marked_edges = new ArrayList<Edge>();
        this.uniqueness_type = 1;
        this.level = level;
    }
    
    public void setUniquenessType(int type){
        this.uniqueness_type = type;
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
    public boolean isTaggedNode(Node nd) {
        for (Node node : this.marked_nodes) {
            if (node.equals(nd)) {
                return true;
            }
        }
        return false;
    }

    /**
    * Permet de savoir si un arc est tagé
    *
    * @param edge arc a tester
    * @return vrai si le arc est tagé faux sinon
    */
    public boolean isTaggedEdge(Edge ed) {
        for (Edge edge : this.marked_edges) {
            if (edge.equals(ed)) {
                return true;
            }
        }
        return false;
    }
    
    public abstract void search(Node node);

    public HashMap<Node, Edge> getSonsApplyFilter(Node current_node) {
        HashMap<Node, Edge> pairs_node_edge = new HashMap<Node, Edge>();
        ArrayList<Edge> list_edges = new ArrayList<Edge>();
        Edge edge_temp;
        list_edges = getSonsEdge(current_node);
        for (Edge current_edge : list_edges) {
            edge_temp = applyAllFilters(current_edge);
            if (edge_temp != null)
                pairs_node_edge.put(edge_temp.extractSoonNode(current_node), edge_temp);
        }
        return pairs_node_edge;
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
