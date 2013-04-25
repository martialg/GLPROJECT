/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author caedes_
 */
public class SaveFilter extends FileFilter implements java.io.FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isFile()) {
            String n = f.getName();
            int ext = n.lastIndexOf(".");
            if (ext != -1) {
                n = n.substring(ext + 1);
            }
            return n.equalsIgnoreCase("txt");
        }
        return true;
    }

    @Override
    public String getDescription() {
        return "Fichiers de création (*.txt)";
    }
}
