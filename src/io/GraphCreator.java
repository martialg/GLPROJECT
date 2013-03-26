/*
 * Generate Graph : use the reader and the structure
 */
/**
 *
 * @driver Martial
 * @observor Romain
 */
package io;

import java.util.ArrayList;
import java.util.Map;
import model.Edge;
import model.Graph;
import model.Line;
import model.Node;
import model.Property;

public class GraphCreator {
    
    /**
     * Generate a graph from a file
     * @param file_path file with information
     * @return 
     * @throws Exception 
     */
    public static Graph GenerateGraph(String file_path) throws Exception{
        //recuperation des lignes
        ArrayList<Line> lines = Read.read(file_path);
        Graph graph = new Graph();
        for(Line line : lines)
        {
            //initialisation des deux noeud et ajout
            Node node1 = new Node(line.getNode_name1());
            Node node2 = new Node(line.getNode_name2());
            graph.addNode(node1);
            graph.addNode(node2);
            //generation des liens puis ajout des proprietes
            Edge edge1;
            Edge edge2;
            if(line.getRelation_type() == 1){
                edge1 = new Edge(line.getRelation_name(), node1, node2, "RIGHT");
                edge2 = new Edge(line.getRelation_name(), node2, node1, "LEFT");
            }else{
                edge1 = new Edge(line.getRelation_name(), node1, node2, "BOTH");
                edge2 = new Edge(line.getRelation_name(), node2, node1, "BOTH");
            }
            for(Map.Entry entry: line.getProperties().entrySet()) {        
                edge1.addProperty((Property)entry.getValue());      
                edge2.addProperty((Property)entry.getValue());
            }    
            graph.addEdge(edge1);
            graph.addEdge(edge2);
        }
        return graph;
    }
}
