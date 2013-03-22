package main;

import io.GraphCreator;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Graph;
import io.Read;

public class Main {
    
    public static void main(String[] args){
        try {
            Graph graph = GraphCreator.GenerateGraph("graph.txt");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
