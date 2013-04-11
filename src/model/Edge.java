/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/**
 *
 * @driver Romain
 * @observer Martial
 */
public class Edge {

    /* Attributes */
    private String name;
    private Node left;
    private Node right;
    private Direction direction;
    private HashMap<String, Property> properties;

    /**
     * Public constructor
     *
     * @param name
     * @param left
     * @param right
     * @param property_name
     * @param properties
     */
    public Edge(String name, Node left, Node right, String direction) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.direction = Direction.valueOf(direction);
        this.properties = new HashMap<String, Property>();
    }

    /* Getters */
    public String getName() {
        return name;
    }
    
    public Node getLeft() {
        return left;
    }
    
    public Node getRight() {
        return right;
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    public HashMap<String, Property> getProperties() {
        return properties;
    }
    
    public Property getProperty(String property_name) {
        return properties.get(property_name);
    }

    /**
     * Add a property to the edge
     *
     * @param property_name
     * @param property_values
     */
    public void addProperty(Property property) {
        properties.put(property.getName(), property);
    }    
    
    public String toString(){
        String response = this.left.getName();
        
        String attributs = "";
        if(this.properties.size()>0){
            attributs = "[";
            for(Map.Entry property: this.properties.entrySet()) {        
                attributs += property.toString();
            }
            attributs += "]";
        }
        
        if(this.direction == Direction.LEFT) {
            response += "<--" + this.name + attributs + "--" + this.right.getName();
        }else if(this.direction == Direction.RIGHT){
            response += "--" + this.name + attributs + "-->" + this.right.getName();
        }else{
            response += "<--" + this.name + attributs + "-->" + this.right.getName();
        }
        return response + "\n";
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edge other = (Edge) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.left, other.left)) {
            return false;
        }
        if (!Objects.equals(this.right, other.right)) {
            return false;
        }
        if (this.direction != other.direction) {
            return false;
        }
        for (Entry<String, Property> entry : other.properties.entrySet()) {
            if (!Objects.equals(entry.getValue(), other.properties.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public Node extractSoonNode(Node current_node) {
        if(current_node.equals(this.left)){
            return this.right;
        }else{
            return this.left;
        }
    }
}
