package io;

import java.io.BufferedReader;
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

public class Read {
    
    //Lecture du fichier
    public static ArrayList<Line> read(String file_path) throws Exception {
        ArrayList<Line> lines = new ArrayList<Line>();
        if ("txt".equals(file_path.substring(file_path.length() - 3, file_path.length()))) {
            String line;
            try {
                FileInputStream fis = new FileInputStream(file_path);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader input_text = new BufferedReader(isr);                
                while ((line = input_text.readLine()) != null) {
                    if (!("".equals(line))) {
                        lines.add(Read.extractLine(line));
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
            throw new Exception("Ceci n'est pas un fichier texte");
        }
        return lines;
    }

    //Creation du graphe
    public static Line extractLine(String line) {        
        /**
         * PARTIE TYPE RELATION
         */
        int type_relation = 0;
        int type_left;                                                          //Localisation du début de la relation
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
        HashMap<String,Property> property_map = new HashMap<String,Property>();
        boolean have_arg;                                                       //indique si la liaison est de type Avec ou Sans Arg
        int first_arg = line.indexOf("[");
        //si il y a un argument
        if (!(first_arg == -1)) {
            have_arg = true;
            int last_arg = line.indexOf("]");
            String args = line.substring(first_arg + 1, last_arg);              //contient tous les arguments entre []
            int ending_arg = args.indexOf(",");
            if (!(ending_arg == -1)) {
                String[] arg = args.split(",");
                for (String s : arg) {
                    Property temp = splitUpProperties(s);
                    property_map.put(temp.getName(),temp);
                }
            } else {
                Property temp = splitUpProperties(args);
                property_map.put(temp.getName(),temp);
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
        return (new Line(first_name, last_name, name_relation, type_relation, property_map));
    }

    //decoupe un argument proprement pour l'ajouter au type de relation du graph
    public static Property splitUpProperties(String arg) {
        int separator = arg.indexOf("=");
        String[] tab_val = null;
        String argument_type = arg.substring(0, separator);
        String argument_values = arg.substring((separator + 1), arg.length());
        int iterator = 0;
        // Controle si il y a plusieurs valeurs (ex : objet1/objet2)
        if (argument_values.indexOf("/") == -1) {
            tab_val = new String[1];
            tab_val[iterator] = argument_values;
        } else {
            String[] value = argument_values.split("/");
            tab_val = new String[value.length];
            for (String current_value : value) {              
                tab_val[iterator] = current_value;
                iterator++;
            }
        }
        return new Property(argument_type, tab_val);
    }
}
