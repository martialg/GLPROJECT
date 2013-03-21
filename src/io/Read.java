package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Line;
import model.Property;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @driver Etienne  
 * @observor Quentin
 */
public class Read {

    private ArrayList<Line> lines = new ArrayList<Line>();

    //construct
    public Read() {
    }

    //getter
    public ArrayList<Line> getLines() {
        return lines;
    }
    
    //Lecture du fichier
    public void read(File input_file) {
        String nameFile = input_file.getPath();
        if ("txt".equals(nameFile.substring(nameFile.length() - 3, nameFile.length()))) {
            try {
                FileInputStream fis = new FileInputStream(input_file);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader input_text = new BufferedReader(isr);
                String line;
                while ((line = input_text.readLine()) != null) {
                    System.out.println(line + " " + line.length());
                    if (!("".equals(line))) {
                        this.extractLine(line);
                    }
                }
                input_text.close();
                isr.close();
                fis.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Ceci n'est pas un fichier texte");
        }
    }

    //Creation du graphe
    public void extractLine(String line) {        
        /**
         * PARTIE TYPE RELATION
         */
        int type_relation = 0;
        int type_left;                                                           //Localisation du début de la relation
        if (line.indexOf("<") == -1) {
            type_relation = 1;
            type_left = line.indexOf("-");
        } else {
            type_relation = 2;
            type_left = line.indexOf("<");
        }
        int type_right = line.lastIndexOf(">");

        /**
         * PARTIE NOM
         */
        String first_name = line.substring(0, type_left);
        String last_name = line.substring(type_right + 1, line.length());

        /**
         * PARTIE ATTRIBUTS
         */
        HashMap<String,Property> property_map = null;
        boolean have_arg;                                                        //indique si la liaison est de type Avec ou Sans Arg
        int first_arg = line.indexOf("[");
        //si il y a un argument
        if (!(first_arg == -1)) {

            have_arg = true;
            int last_arg = line.indexOf("]");
            String args = line.substring(first_arg + 1, last_arg);                    //contient tous les arguments entre []

            int ending_arg = args.indexOf(",");
            if (!(ending_arg == -1)) {
                String[] arg = args.split(",");
                for (String s : arg) {
                    property_map = this.splitUpProperties(s);
                }
            } else {
                property_map = this.splitUpProperties(args);
            }

        } else {
            have_arg = false;
        }

        /**
         * PARTIE NOM RELATION
         */
        String name_relation = "";
        int start;
        if (type_relation == 1) {
            start = type_left + 2;
        } else {
            start = type_left + 3;
        }
        if (have_arg) {
            name_relation = line.substring(start, first_arg);
        } else {
            name_relation = line.substring(start, (type_right - 2));
        }

        this.lines.add(new Line(first_name, last_name, name_relation, type_relation, property_map));
        
    }

    //decoupe un argument proprement pour l'ajouter au type de relation du graph
    public HashMap<String,Property> splitUpProperties(String arg) {
        int separator = arg.indexOf("=");
        String[] tab_val = null;
        String argument_type = arg.substring(0, separator);
        String argument_values = arg.substring((separator + 1), arg.length());
        int iterator = 0;
        // Controle si il y a plusieurs valeurs (ex : objet1/objet2)
        if (argument_values.indexOf("/") == -1) {
            tab_val[iterator] = argument_values;
        } else {
            String[] value = argument_values.split("/");
            for (String current_value : value) {              
                tab_val[iterator] = current_value;
                iterator++;
            }
        }  
        HashMap<String,Property> property_map = new HashMap<String,Property>();
        Property properties = new Property(argument_type, tab_val);
        property_map.put(argument_type, properties);
        return property_map;
    }
}