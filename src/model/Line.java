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
public class Line {
    
    private String node_name1;
    private String node_name2;
    private int type_relation;
    private String relation_name;
    private HashMap<String,Property> properties;

    /**
     * Public constructor
     * @param node_name1
     * @param node_name2
     * @param type_relation
     * @param relation_name
     * @param properties 
     */
    public Line(String node_name1, String node_name2, int type_relation, String relation_name, HashMap<String, Property> properties) {
        this.node_name1 = node_name1;
        this.node_name2 = node_name2;
        this.type_relation = type_relation;
        this.relation_name = relation_name;
        this.properties = properties;
    }

    public String getNode_name1() {
        return node_name1;
    }

    public String getNode_name2() {
        return node_name2;
    }

    public int getType_relation() {
        return type_relation;
    }

    public String getRelation_name() {
        return relation_name;
    }

    public HashMap<String, Property> getProperties() {
        return properties;
    }
    
    
}
