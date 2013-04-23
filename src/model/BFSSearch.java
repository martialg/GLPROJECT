package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class BFSSearch extends GraphSearch {

    public BFSSearch(Graph graph) {
        super(graph, null, 0);
    }
    
    public BFSSearch(Graph graph, HashMap<String, ArrayList<Edge>> edges, int level) {
        super(graph, edges, level);
    }

    @Override
    public void search(Node node) {
        /*
        ArrayList<Node> list_nodes = new ArrayList<Node>();
        list_nodes.add(node);
        this.marked_nodes.add(node);
        while (!(list_nodes.isEmpty())) {
            Node x = list_nodes.remove(0);
            ArrayList<Node> list_son = this.getSonsApplyFilter(x);
            for (int i = 0; i < list_son.size(); i++) {
                Node son = list_son.get(i);
                if (!isTagged(son)) {		//Si le fils est pas marqué ALORS    
                    this.marked_nodes.add(son);
                    list_nodes.add(son);
                }
            }
        }
        */
        ArrayList<Node> list_nodes = new ArrayList<Node>();        
        list_nodes.add(node);
        this.marked_nodes.add(node);
        while (!(list_nodes.isEmpty())) {
            Node x = list_nodes.remove(0);
            HashMap<Node, Edge> pairs_son_edge = this.getSonsApplyFilter(x);
            for (Entry<Node, Edge> pair : pairs_son_edge.entrySet()) {
                Node temp_node = pair.getKey();
                Edge temp_edge = pair.getValue();
                if(this.uniqueness_type == 1 && !isTaggedNode(temp_node) 
                        || this.uniqueness_type == 2 && !isTaggedEdge(temp_edge)){
                    if(!this.marked_nodes.contains(temp_node))
                        this.marked_nodes.add(temp_node);
                    if(!this.marked_edges.contains(temp_edge))
                        this.marked_edges.add(temp_edge);
                    list_nodes.add(temp_node);
                }
            }
        }
    }
}
