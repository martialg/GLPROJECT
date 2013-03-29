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
     * Test of runDepthFirstSearch method, of class Graph.
     */
    @Test
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
    }
    
    /**
     * Test of depthFirstSearch method, of class Graph.
     */
    @Test
    public void testDepthFirstSearch() {
        System.out.println("depthFirstSearch");
        String[] exp_result = {"Barbara","Paul","Jean","Saucisse","Auchan"};
        String file_path = "test/io/GraphCreatorTest.txt";
        try {
            Graph graph = GraphCreator.GenerateGraph(file_path);
            Node test_node = graph.getNode("Barbara");
            ArrayList<Node> nodes_done = new ArrayList<Node>();
            nodes_done.add(test_node);
            graph.depthFirstSearch(test_node, nodes_done);
            
            String node_name=null;
            int iterator = 0;
            for(Node current_tagged_node : nodes_done){
                node_name = current_tagged_node.getName();
                assertEquals(node_name, exp_result[iterator]);
                iterator++;
            }
            assertEquals(iterator,5);
        } catch (Exception ex) {
            Logger.getLogger(GraphSearchTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of depthFirstSearch method, of class Graph.
     */
    @Test
    public void testBFSSearch() {
        System.out.println("BFSSearch");
        String[] exp_result = {"Barbara","Paul","Jean","Auchan","Saucisse"};
        String file_path = "test/io/GraphCreatorTest.txt";
        try {
            Graph graph = GraphCreator.GenerateGraph(file_path);
            Node test_node = graph.getNode("Barbara");
            ArrayList<Node> nodes_done = new ArrayList<Node>();
            graph.BFSSearch(test_node, nodes_done);
            
            String node_name=null;
            int iterator = 0;
            for(Node current_tagged_node : nodes_done){
                node_name = current_tagged_node.getName();
                System.out.println(node_name);
                assertEquals(exp_result[iterator],node_name);
                iterator++;
            }
            assertEquals(iterator,5);
        } catch (Exception ex) {
            Logger.getLogger(GraphSearchTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
            ArrayList<Node> marked_nodes = new ArrayList<Node>();
            Graph graph = GraphCreator.GenerateGraph(file_path);
            Node test_node_false = graph.getNode("Henri");
            Node test_node_true = graph.getNode("Jean");
            graph.depthFirstSearch(test_node_true, marked_nodes);
            boolean result_false = graph.isTagged(marked_nodes,test_node_false);
            boolean result_true = graph.isTagged(marked_nodes,test_node_true);
            assertEquals(result_false, exp_result_false);
            assertEquals(result_true, exp_result_true);
        } catch (Exception ex) {
            Logger.getLogger(GraphSearchTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}