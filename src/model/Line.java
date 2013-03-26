/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Romain
 */
public class Line {

    private String node_name1;
    private String node_name2;
    private String relation_name;
    private int relation_type;
    private HashMap<String, Property> properties;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Line other = (Line) obj;
        if (!Objects.equals(this.node_name1, other.node_name1)) {
            return false;
        }
        if (!Objects.equals(this.node_name2, other.node_name2)) {
            return false;
        }
        if (!Objects.equals(this.relation_name, other.relation_name)) {
            return false;
        }
        if (this.relation_type != other.relation_type) {
            return false;
        }
        for (Map.Entry<String, Property> entry : other.properties.entrySet()) {
            if (!Objects.equals(entry.getValue(), other.properties.get(entry.getKey()))) {
                return false;
            }
        }
        
        return true;
    }
}
