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
        ArrayList<NodeLevel> list_nodes = new ArrayList<NodeLevel>();        
        list_nodes.add(new NodeLevel(node, 1));
        this.marked_nodes.add(node);
        while (!(list_nodes.isEmpty())) {
            Node node_temp = list_nodes.get(0).getNode();
            int level_temp = list_nodes.remove(0).getLevel();
            if(level_temp < this.level_max){
                HashMap<Node, Edge> pairs_son_edge = this.getSonsApplyFilter(node_temp);
                for (Entry<Node, Edge> pair : pairs_son_edge.entrySet()) {
                    Node node_current = pair.getKey();
                    Edge temp_edge = pair.getValue();
                    if(this.uniqueness_type == 1 && !isTaggedNode(node_current) 
                            || this.uniqueness_type == 2 && !isTaggedEdge(temp_edge)){
                        if(!this.marked_nodes.contains(node_current))
                            this.marked_nodes.add(node_current);
                        if(!this.marked_edges.contains(temp_edge))
                            this.marked_edges.add(temp_edge);
                        list_nodes.add(new NodeLevel(node_current, level_temp++));
                    }
                }
            }
        }
    }
}
