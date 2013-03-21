/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author Romain
 */
public class Line {
    
    private String node_name1;
    private String node_name2;
    private String relation_name;
    private int relation_type;
    private HashMap<String,Property> properties;

    public Line(String node_name1, String node_name2, String relation_name, int relation_type, HashMap<String, Property> properties) {
        this.node_name1 = node_name1;
        this.node_name2 = node_name2;
        this.relation_name = relation_name;
        this.relation_type = relation_type;
        this.properties = properties;
    }

    public String getNode_name1() {
        return node_name1;
    }

    public String getNode_name2() {
        return node_name2;
    }

    public String getRelation_name() {
        return relation_name;
    }

    public int getRelation_type() {
        return relation_type;
    }

    public HashMap<String, Property> getProperties() {
        return properties;
    }
}
