/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.util.ArrayList;
import java.util.HashMap;
import model.Edge;
import model.Line;
import model.Node;
import model.Property;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Romain
 */
public class ReadTest {
    
    public ReadTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of read method, of class Read.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        String file_path = "test/io/GraphCreatorTest.txt";
        ArrayList expResult = new ArrayList<Line>();
        ArrayList result = Read.read(file_path);
        //assertEquals(expResult, result);
    }

    /**
     * Test of extractLine method, of class Read.
     */
    @Test
    public void testExtractLine() {
        System.out.println("extractLine");
        String line = "Anna<--friend[since=2003,share=CD/Jupe]-->Lucie";
        Line expResult = null;
        
        HashMap<String,Property> map = new HashMap<String,Property>();
        String [] pv1 = {"2003"};
        String [] pv2 = {"CD","Jupe"};
        Property property1 = new Property("since",pv1);
        Property property2 = new Property("share",pv2);
        map.put("share", property2);
        map.put("since", property1);

        expResult = new Line("Anna","Lucie","friend",2,map);
        
        Line result = Read.extractLine(line);
        
        System.out.println(expResult.toString());
        System.out.println(result.toString());
        
        assertEquals(expResult.getNode_name1(),result.getNode_name1());
        assertEquals(expResult.getNode_name2(),result.getNode_name2());
        assertEquals(expResult.getRelation_name(),result.getRelation_name());
        assertEquals(expResult.getRelation_type(),result.getRelation_type());
        for(String key : expResult.getProperties().keySet()) {
            assertEquals(expResult.getProperties().get(key),result.getProperties().get(key));
        }
    }

    /**
     * Test of splitUpProperties method, of class Read.
     */
    @Test
    public void testSplitUpProperties() {
        System.out.println("splitUpProperties");
        String arg = "share=CD/Jupe";
        String[] tabstring = {"CD","Jupe"};
        Property expResult = new Property("share",tabstring);
        Property result = Read.splitUpProperties(arg);
        assertEquals(expResult, result);
    }
}
