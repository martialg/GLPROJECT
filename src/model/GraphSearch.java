package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

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
    
    //Les attributs suivants servent aux filtres
    /** Type d'unicité 1 : noeud / 2 : arc. Par défaut à 1*/
    protected int uniqueness_type;
    /** liste des liens que nous avons le droit de parcourir*/
    protected ArrayList<String> list_connection;
    /** HashMap nom du lien et de la direction qui doit prendre*/
    protected HashMap<String, Direction> edge_direction;
    /** HashMap nom du lien et les propriétés qui lui sont associés*/
    protected HashMap<String, ArrayList<Property>> edge_propreties;
    /** niveau max lors du parcours de graph */
    protected int level_max;
    /** nom des noeuds autorisés */
    protected ArrayList<String> nodes_authorize;
    
    public GraphSearch(Graph graph, int level) {
        this.graph = graph;
        this.marked_nodes = new ArrayList<Node>();
        this.marked_edges = new ArrayList<Edge>();
        this.uniqueness_type = 1;
        this.level_max = level;
        this.list_connection = new ArrayList<String>();
        this.edge_direction = new HashMap<String, Direction>();
        this.edge_propreties = new HashMap<String, ArrayList<Property>>();
        this.nodes_authorize = new ArrayList<String>();
    }
    
    public GraphSearch(Graph graph, boolean uniquess_type, int level, ArrayList<Edge> edges) {
        this.graph = graph;
        this.marked_nodes = new ArrayList<Node>();
        this.marked_edges = new ArrayList<Edge>();
        this.uniqueness_type = (uniquess_type) ? 1 : 2;
        this.level_max = level;
        
        this.list_connection = new ArrayList<String>();
        this.edge_direction = new HashMap<String, Direction>();
        this.edge_propreties = new HashMap<String, ArrayList<Property>>();
        this.nodes_authorize = new ArrayList<String>();
        
        
        
        for(Edge edge : edges) {
            this.list_connection.add(edge.getName());
            this.edge_direction.put(edge.getName(),edge.getDirection());
            
            ArrayList<Property> properties = new ArrayList<Property>();
            for(Entry property : edge.getProperties().entrySet()) {
                properties.add((Property) property);
            }
            this.edge_propreties.put(edge.getName(), properties);
        }
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

    /**
     * Retourne les fils (association noeud, lien utilisé pour y parvenir) après
     * les avoirs filtrés
     * @param current_node
     * @return 
     */
    public HashMap<Node, Edge> getSonsApplyFilter(Node current_node) {
        HashMap<Node, Edge> pairs_node_edge = new HashMap<Node, Edge>();
        ArrayList<Edge> list_edges = new ArrayList<Edge>();
        Edge edge_temp;
        list_edges = getSonsEdge(current_node);
        for (Edge current_edge : list_edges) {
            edge_temp = applyAllFilters(current_edge, current_node);
            if (edge_temp != null)
                pairs_node_edge.put(edge_temp.extractSoonNode(current_node), edge_temp);
        }
        return pairs_node_edge;
    }


    /**
     * Méthode pour appliquer les filtres. On appelle dans cette méthode chaque filtre
     * @param current_edge
     * @return null si le lien ne correspond pas au filtre, le lien sinon
     */
    public Edge applyAllFilters(Edge current_edge, Node current_node) {
        Edge temp_edge;
        temp_edge = applyFilterAuthorizeNode(current_edge, current_node);
        if(temp_edge != null) temp_edge = applyFilterAuthorizeEdge(current_edge);
        if(temp_edge != null) temp_edge = applyFilterEdgeDirection(current_edge);
        if(temp_edge != null) temp_edge = applyFilterPredicate(temp_edge);
        return temp_edge;
    }

    /**
     * Vérification des prédicats pour un lien
     * @param current_edge
     * @return null si le lien ne correspond pas au filtre, le lien sinon
     */
    public Edge applyFilterPredicate(Edge current_edge){
        HashMap<String, Property> current_edge_properties = current_edge.getProperties();
        
        ArrayList<Property> edge_properties_required = this.edge_propreties.get(current_edge.getName());
        if(edge_properties_required != null){
            for(Property property_required : edge_properties_required){
                Property temp_current_property = current_edge_properties.get(property_required.getName());
                if(temp_current_property != null){
                    for(String value_required : property_required.getValues()){
                        boolean exist_value = false;
                        for(String value_current : temp_current_property.getValues()){
                            if(value_current.compareTo(value_required) == 0){
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
        }else{
            return current_edge;
        }
        
    }
    
    /**
     * On vérifie si le lien courant est autorisé dans la liste de liens
     * @param current_edge
     * @return null si le lien ne remplie pas les conditions vrai sinon
     */
    public Edge applyFilterAuthorizeEdge(Edge current_edge){
        if(this.list_connection.isEmpty()){ 
            return current_edge;
        }else if(this.list_connection.contains(current_edge.getName())){
            return current_edge;
        }else{
            return null;
        }
    }
    
    /**
     * On vérifie si la direction du lien courant est correcte
     * @param current_edge
     * @return null si le lien ne remplie pas les conditions vrai sinon
     */
    public Edge applyFilterEdgeDirection(Edge current_edge){
        if(this.edge_direction.isEmpty()){
            return current_edge;
        }else if(this.edge_direction.get(current_edge.getName()) == null){
            return current_edge;
        }else if(this.edge_direction.get(current_edge.getName()) == current_edge.getDirection()){
            return current_edge;
        }else{
            return null;
        }
    }
    
    /**
     * On vérifie si les noeuds sont filtrés
     * @param current_edge
     * @param current_node
     * @return null si le noeud ne remplie pas les conditions, vrai sinon
     */
    public Edge applyFilterAuthorizeNode(Edge current_edge, Node current_node){
        if(this.nodes_authorize.isEmpty()){
            return current_edge;
        }else if(this.nodes_authorize.contains(current_edge.extractSoonNode(current_node).getName())){
            return current_edge;
        }else{
            return null;
        }
    }
    
    public String getResultats() {
        String resultats = "";
        for(Node node : marked_nodes) {
            resultats += node.toString();
        }
        return resultats;
    }
}
