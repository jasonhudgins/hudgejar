/*
 * FileUtilTest.java
 * JUnit based test
 *
 * Created on October 7, 2007, 9:29 PM
 */

package net.spy.jutils;

import junit.framework.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author Jason Hudgins <jasonlee@spy.net>
 */
public class FileUtilTest extends TestCase {
    
    public FileUtilTest(String testName) {
        super(testName);
    }

    /**
     * Test of fileToString method, of class net.spy.jutils.FileUtil.
     */
    public void testFileToString() throws Exception {       
        URL fileURL = this.getClass().getClassLoader().getResource("testfile.txt");
             
        assert fileURL != null : "Can't locate test file!";
        
        File file = new File(fileURL.toURI());
        
        String expResult = "This is some text in a file.\n";
        String result = FileUtil.fileToString(file);
     
        assertEquals(expResult, result);
    }
}
