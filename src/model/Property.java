/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @driver Romain
 * @observer Martial
 */
public class Property {
    
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
}
