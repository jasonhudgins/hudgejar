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
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class for file operations.
 *
 * @author Jason Hudgins <jasonlee@spy.net>
 */
public class FileUtil {
    
    public static File resourceToFile(Object context, String resource) throws FileNotFoundException {
        URL fileURL = context.getClass().getClassLoader().getResource(resource);

        if (fileURL == null) {
            throw new FileNotFoundException("Couldn't locate resource: " 
                + resource);
        }
        try {
            return new File(fileURL.toURI());
        } catch (URISyntaxException ex) {
            throw new RuntimeException("URL syntax exception", ex);
        }
    }

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

    public static String resourceToString(Object context, String resource) 
        throws FileNotFoundException, IOException {

        return FileUtil.fileToString(
            FileUtil.resourceToFile(context, resource));
    }
}
