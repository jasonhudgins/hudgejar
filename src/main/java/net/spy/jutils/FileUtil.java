/*
 * FileUtil.java
 *
 * Created on October 7, 2007, 8:45 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.spy.jutils;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Utility class for file operations.
 *
 * @author Jason Hudgins <jasonlee@spy.net>
 */
public class FileUtil {
    
    
    public static String fileToString(File file) throws FileNotFoundException, IOException {
        assert file != null : "fileToString called a null file";
        
        StringBuilder sb = new StringBuilder();
        FileReader reader = new FileReader(file);
        
        int i;
        while ((i = reader.read()) != -1) {
            char c = (char) i;
            sb.append(c);
        }
        
        return sb.toString();
    }
}
