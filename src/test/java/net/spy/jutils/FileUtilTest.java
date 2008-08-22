/*
 * FileUtilTest.java
 * JUnit based test
 *
 * Created on October 7, 2007, 9:29 PM
 */

package net.spy.jutils;

import junit.framework.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

/**
 *
 * @author Jason Hudgins <jasonlee@spy.net>
 */
public class FileUtilTest extends TestCase {
    
    private final static String TEST_FILE = "testfile.txt";
    private final static String TEST_FILE_CONTENTS 
        = "This is some text in a file.\n";

    public FileUtilTest(String testName) {
        super(testName);
    }

    /**
     * Test of fileToString method, of class net.spy.jutils.FileUtil.
     */
    public void testFileToString() throws Exception {       
        URL fileURL = this.getClass().getClassLoader().getResource(TEST_FILE);
             
        assert fileURL != null : "Can't locate test file!";
        
        File file = new File(fileURL.toURI());
        
        String result = FileUtil.fileToString(file);
     
        assertEquals(TEST_FILE_CONTENTS, result);
    }

    public void testResourceToFile() throws Exception {
        File file = FileUtil.resourceToFile(this, TEST_FILE);
        assertEquals(TEST_FILE, file.getName());
    }

    public void testNullResourceToFile() throws Exception {
        try {
            File file = FileUtil.resourceToFile(this, "noexist.txt");
            fail("Should have thrown a FileNotFound exception");
        }
        catch(Exception e) { 
            assertTrue(e instanceof FileNotFoundException);
        }
    }

    public void testResourceToString() throws Exception {
        assertEquals(TEST_FILE_CONTENTS, 
            FileUtil.resourceToString(this, TEST_FILE));
    }
}
