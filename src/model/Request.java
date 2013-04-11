/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @driver Etienne
 * @observor Romain
 */
public class Request {
    
    private Graph graph;
    private Node fisrt_node;
    private int level;
    private String mode;
    private boolean unicity;
    private ArrayList<Edge> link_list;
    
    public Request(){};

    //Exemple : request -start nom -level level -unicity on/off -mode BFS/DFS -link (nom_relation[propriété=valeur,..] sens|nom_relation,...)
    public void create_request(Graph graph, String request){
        
        this.graph = graph;
        this.link_list = new ArrayList<Edge>();
        String[] tab_val = request.split("/");
        
        //FIRST_NODE
        String name = tab_val[2];
        Node res_node = this.graph.getNode(name);
        if(res_node != null){
           this.fisrt_node = res_node;
        }
        else {
            System.out.println("Le nom ne fait référence à rien");
        }
        
        //LEVEL
        this.level = Integer.parseInt(tab_val[4]);
        
        //UNICITY
        if("on".equals(tab_val[6])){
            this.unicity = true;
        }
        else if("off".equals(tab_val[6])){
            this.unicity = false;
        }
        
        //MODE
        if("DFS".equals(tab_val[8])){
            this.mode = "DFS";
        }
        else if("BFS".equals(tab_val[8])){
            this.mode = "BFS";
        }
        
        //LINK
        String link_valeur = "";
        for(int i = 10; i < tab_val.length; i++){
            link_valeur += tab_val[i];
        }
        String[] argument = link_valeur.split("|");
        for (int i = 0; i < argument.length; i++) {              
            if((i+1) == argument.length){
                createLinkList(tab_val[i].substring(0, tab_val[i].length()-1));
            }
            else if(i == 0){
                createLinkList(tab_val[1].substring(1));
            }
            else {                 
                createLinkList(tab_val[i]);
            }
        }
    }
    
    public void createLinkList(String arg){
        String name_relation = "";
        int location_first_arg = arg.indexOf("[");
        //Si il y a des criteres sur attributs
        if (!(location_first_arg == -1)) {
            arg = arg.substring(0, arg.length()-1);
            Property p;
            name_relation = arg.substring(0,location_first_arg);
            Edge e = new  Edge(name_relation, fisrt_node, null, null);
            String[] criteria = arg.split(",");
            for(int i = 0; i < criteria.length ; i++){
                String[] values = criteria[i].split("=");
                String title = values[1];
                String[] value =  {values[2]};
                p = new Property(title, value);
                e.addProperty(p);
            }
            this.link_list.add(e);
        }
        //Si il n'y a pas de crtiere sur attributs mais juste un sens sur les arcs  
        else {
            int location_space = arg.indexOf(" ");
            if(!(location_space == -1)){
                name_relation = arg;
                Edge e = new  Edge(name_relation, fisrt_node, null, Edge.Direction.BOTH);
                this.link_list.add(e);
            }
            else {
                name_relation = arg.substring(0,location_space);
                String sens = arg.substring(location_space+1, location_space+2);
                if (">".equals(sens)) {
                    Edge e = new  Edge(name_relation, fisrt_node, null, Edge.Direction.RIGHT);
                    this.link_list.add(e);
                }
                else if("<".equals(sens)) {
                    Edge e = new  Edge(name_relation, fisrt_node, null, Edge.Direction.LEFT);
                    this.link_list.add(e);
                }
            }
        }
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Node getFisrt_node() {
        return fisrt_node;
    }

    public void setFisrt_node(Node fisrt_node) {
        this.fisrt_node = fisrt_node;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isUnicity() {
        return unicity;
    }

    public void setUnicity(boolean unicity) {
        this.unicity = unicity;
    }

    public ArrayList<Edge> getLink_list() {
        return link_list;
    }

    public void setLink_list(ArrayList<Edge> link_list) {
        this.link_list = link_list;
    }
    
    @Override
    public String toString(){
        String res = "-----------------------\n";
        res += "Noeud de départ : " + this.fisrt_node +"\n";
        res += "Niveau : " + this.level + "\n";
        res += "Mode de recherche : " + this.mode + "\n";
        res += "Unicité ? : " + this.unicity + "\n";
        res += "Criteres : ";
        for(int i = 0; i < this.link_list.size(); i++){
            this.link_list.get(i).toString();
        } 
        return res;
    }
}
