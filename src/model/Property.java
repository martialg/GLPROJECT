/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @driver Romain
 * @observer Martial
 */
public class Property {
    
    /* Attributes */
    
    private String name;
    private String[] values;

    /**
     * Public constructor
     * @param name
     * @param values 
     */
    public Property(String name, String[] values) {
        this.name = name;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public String[] getValues() {
        return values;
    }
    public String toString(){
        String response = "";
        for(int i = 0; i < values.length - 1; i++)
            response += values[i] + ",";
        response += values[values.length-1];
        return response;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Property other = (Property) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Arrays.deepEquals(this.values, other.values)) {
            return false;
        }
        return true;
    }
}
