/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @driver Romain
 * @observer Martial
 */
public class Edge {
    
    private static enum Direction { LEFT, RIGHT, BOTH };

    /* Attributes */
    
    private String name;
    private Node left;
    private Node right;
    private Edge.Direction direction;
    private HashMap<String,Property> properties;
    
    /**
     * Public constructor
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
        this.direction = Edge.Direction.valueOf(direction);
        this.properties = new HashMap<String,Property>();
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

    public Edge.Direction getDirection() {
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
     * @param property_name
     * @param property_values 
     */
    public void addProperty(Property property) {
        properties.put(property.getName(), property);
    }    
}
