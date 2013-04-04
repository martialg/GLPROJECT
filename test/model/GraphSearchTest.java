/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import io.GraphCreator;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class GraphSearchTest {
    
    public GraphSearchTest() {
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
     * Test of getSons method, of class GraphSearch.
     */
    @Test
    public void testGetSons() {
        System.out.println("getSons");
        Node current_node = null;
        GraphSearch instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getSons(current_node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of runDepthFirstSearch method, of class Graph.
     */
    /*@Test
    public void testRunDepthFirstSearch() {
        System.out.println("runDepthFirstSearch");
        String[] exp_result = {"Barbara","Paul","Jean","Saucisse","Auchan","Henri","Findus"};
        ArrayList<Node> result = null;
        String file_path = "test/io/GraphCreatorTest.txt";
        try {
            Graph graph = GraphCreator.GenerateGraph(file_path);
            Node test_node = graph.getNode("Barbara");
            result = graph.runDepthFirstSearch(test_node);
            
            String node_name=null;
            int iterator = 0;
            for(Node current_tagged_node : result){
                node_name = current_tagged_node.getName();
                assertEquals(exp_result[iterator], node_name);
                iterator++;
            }
            assertEquals(iterator,result.size());
        } catch (Exception ex) {
            Logger.getLogger(GraphSearchTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    /**
     * Test of isTagged method, of class Graph.
     */
    @Test
    public void testIsTagged() {
        System.out.println("isTagged");
        boolean exp_result_false = false;
        boolean exp_result_true = true;
        String file_path = "test/io/GraphCreatorTest.txt";
        try {
            Graph graph = GraphCreator.GenerateGraph(file_path);
            DFSSearch dfs = new DFSSearch(graph);
            
            Node test_node_false = graph.getNode("Henri");
            Node test_node_true = graph.getNode("Jean");
            dfs.search(test_node_true);
            boolean result_false = dfs.isTagged(test_node_false);
            boolean result_true = dfs.isTagged(test_node_true);
            assertEquals(result_false, exp_result_false);
            assertEquals(result_true, exp_result_true);
        } catch (Exception ex) {
            Logger.getLogger(GraphSearchTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
