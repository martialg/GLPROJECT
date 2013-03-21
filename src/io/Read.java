package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    //Lecture du fichier
    public void read(File inputFile) {
        String nameFile = inputFile.getPath();
        if ("txt".equals(nameFile.substring(nameFile.length() - 3, nameFile.length()))) {
            try {
                FileInputStream fis = new FileInputStream(inputFile);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader inputText = new BufferedReader(isr);
                String line;
                while ((line = inputText.readLine()) != null) {
                    System.out.println(line + " " + line.length());
                    if (!("".equals(line))) {
                        this.graphCreation(line);
                    }
                }
                inputText.close();
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
    public void graphCreation(String line) {
        /**
         * PARTIE TYPE RELATION
         */
        int typeRelation = 0;
        int typeLeft;                                                           //Localisation du début de la relation
        if (line.indexOf("<") == -1) {
            typeRelation = 1;
            typeLeft = line.indexOf("-");
        } else {
            typeRelation = 2;
            typeLeft = line.indexOf("<");
        }
        int typeRight = line.lastIndexOf(">");

        /**
         * PARTIE NOM
         */
        String firstName = line.substring(0, typeLeft);
        String lastName = line.substring(typeRight + 1, line.length());

        /**
         * PARTIE ATTRIBUTS
         */
        boolean haveArg;                                                        //indique si la liaison est de type Avec ou Sans Arg
        int firstArg = line.indexOf("[");
        //si il y a un argument
        if (!(firstArg == -1)) {

            haveArg = true;
            int lastArg = line.indexOf("]");
            String args = line.substring(firstArg + 1, lastArg);                    //contient tous les arguments entre []

            int endingArg = args.indexOf(",");
            if (!(endingArg == -1)) {
                String[] arg = args.split(",");
                for (String s : arg) {
                    this.decomposeArgument(s);
                }
            } else {
                this.decomposeArgument(args);
            }

        } else {
            haveArg = false;
        }

        /**
         * PARTIE NOM RELATION
         */
        String nameRelation = "";
        int start;
        if (typeRelation == 1) {
            start = typeLeft + 2;
        } else {
            start = typeLeft + 3;
        }
        if (haveArg) {
            nameRelation = line.substring(start, firstArg);
        } else {
            nameRelation = line.substring(start, (typeRight - 2));
        }

        //Creer le graphe avec les fonctions du graphe qui seront coder
        /**
         * Rappel des variables : - typeRelation : 1 si un seul sens / 2 si
         * double - firstName : Premier nom de l'association - lastName :
         * Deuxieme nom de l'assocation - nameRelation : Nom de l'association -
         * type / val sont dans la fonction decomposeArgument
         */
        System.out.println(" resultat = " + typeRelation + "," + nameRelation + "," + firstName + "," + lastName);
        System.out.println("--------------------------------------------------");
    }

    //decoupe un argument proprement pour l'ajouter au type de relation du graph
    public void decomposeArgument(String arg) {
        int separator = arg.indexOf("=");

        ArrayList<String> val = new ArrayList<String>();
        String type = arg.substring(0, separator);

        String values = arg.substring((separator + 1), arg.length());

        // Controle si il y a plusieurs valeurs (ex : objet1/objet2)
        if (values.indexOf("/") == -1) {
            val.add(values);
        } else {
            String[] value = values.split("/");
            for (String s : value) {
                val.add(s);
            }
        }
        //ajouter le type et la valeur de l'argument au graph
    }
}
