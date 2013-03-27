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
 * @driver Quentin
 * @observer Martial
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
     * Test of depthFirstSearch method, of class GraphSearch.
     */
    @Test
    public void testDepthFirstSearch() {
        System.out.println("depthFirstSearch");
        String[] exp_result = {"Barbara","Paul","Jean","Saucisse","Auchan","Henri","Findus"};
        String file_path = "test/io/GraphCreatorTest.txt";
        try {
            Graph graph = GraphCreator.GenerateGraph(file_path);
            Node test_node = graph.getNode("Barbara");
            GraphSearch instance = new GraphSearch(graph, test_node); 
            instance.depthFirstSearch();
            String node_name=null;
            int iterator = 0;
            for(Node current_tagged_node : instance.getTagged_nodes()){
                node_name = current_tagged_node.getName();
                assertEquals(node_name, exp_result[iterator]);
                iterator++;
            }
            assertEquals(iterator, 5);
        } catch (Exception ex) {
            Logger.getLogger(GraphSearchTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of isTagged method, of class GraphSearch.
     */
    @Test
    public void testIsTagged() {
        System.out.println("isTagged");
        boolean exp_result_false = false;
        boolean exp_result_true = true;
        String file_path = "test/io/GraphCreatorTest.txt";
        try {
            Graph graph = GraphCreator.GenerateGraph(file_path);
            Node test_node_false = graph.getNode("Jean");
            Node test_node_true = graph.getNode("Barbara");
            GraphSearch instance = new GraphSearch(graph, test_node_true);
            boolean result_false = instance.isTagged(test_node_false);
            boolean result_true = instance.isTagged(test_node_true);
            assertEquals(result_false, exp_result_false);
            assertEquals(result_true, exp_result_true);
        } catch (Exception ex) {
            Logger.getLogger(GraphSearchTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}