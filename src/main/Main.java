package main;

import view.MainFrame;

public class Main {
    
    public static void main(String[] args){
       /* try {
            Graph graph = GraphCreator.GenerateGraph("graph.txt");
            System.out.println(graph.toString());
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        * */
        new MainFrame();
    }
}
