package model;

/**
 * Classe utilisée pour le BFS afin de stocker le noeud ainsi que le niveau correspondant dans le graphe
 */
public class NodeLevel {
    private Node node;
    private int level;
    
    public NodeLevel(Node node, int level){
        this.node = node;
        this.level = level;
    }
    
    public boolean equals(Object obj) {
        Node node_temp = (Node) obj;
        if(node.getName().compareTo(node_temp.getName()) == 0){
            return true;
        }else{
            return false;
        }
    }
    
    public Node getNode(){
        return this.node;
    }
    
    public int getLevel(){
        return this.level;
    }
}
