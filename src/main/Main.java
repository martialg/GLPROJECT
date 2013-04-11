package main;

import io.GraphCreator;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Graph;
import io.Read;
import model.GraphSearch;
import model.Request;

public class Main {
    
    public static void main(String[] args){
        
        Graph graph = null;
        
        try {
            graph = GraphCreator.GenerateGraph("graph.txt");
            //System.out.println(graph.toString());
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s1 = "request -start Paul -level 3 -unicity on -mode BFS -link (friend[since=2002,share=produit])";
        String s2 = "request -start Henri -level 2 -unicity off -mode DFS -link (hired >|friend)";
        
        Request r1 = new Request();
        r1.create_request(graph, s1);
        System.out.println(r1.toString());
        
        Request r2 = new Request();
        r2.create_request(graph, s2);
        System.out.println(r2);
        
        
    }
}