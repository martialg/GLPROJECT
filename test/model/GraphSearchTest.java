/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import io.GraphCreator;
import java.util.ArrayList;
import java.util.HashMap;
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
    * Test of isTaggedNode method, of class GraphSearch.
    */
    @Test
    public void testIsTaggedNode() {
        System.out.println("isTaggedNode");
        boolean exp_result_false = false;
        boolean exp_result_true = true;
        String file_path = "test/io/GraphCreatorTest.txt";
        try {
            Graph graph = GraphCreator.GenerateGraph(file_path);
            DFSSearch dfs = new DFSSearch(graph);
            Node test_node_false = graph.getNode("Henri");
            Node test_node_true = graph.getNode("Jean");
            dfs.search(test_node_true);
            boolean result_false = dfs.isTaggedNode(test_node_false);
            boolean result_true = dfs.isTaggedNode(test_node_true);
            assertEquals(result_false, exp_result_false);
            assertEquals(result_true, exp_result_true);
        } catch (Exception ex) {
            Logger.getLogger(GraphSearchTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of isTaggedEdge method, of class GraphSearch.
     */
    @Test
    public void testIsTaggedEdge() {
        System.out.println("isTaggedEdge");
        boolean exp_result_false = false;
        boolean exp_result_true = true;
        String file_path = "test/io/GraphCreatorTest.txt";
        try {
            Graph graph = GraphCreator.GenerateGraph(file_path);
            DFSSearch dfs = new DFSSearch(graph);
            Edge test_edge_false = graph.getEdges().get("henri").get(0);
            Edge test_edge_true = graph.getEdges().get("paul").get(0);
            Node node = graph.getNode("Jean");
            dfs.search(node);
            boolean result_false = dfs.isTaggedEdge(test_edge_false);
            boolean result_true = dfs.isTaggedEdge(test_edge_true);
            assertEquals(result_false, exp_result_false);
            assertEquals(result_true, exp_result_true);
        } catch (Exception ex) {
            Logger.getLogger(GraphSearchTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getSonsEdge method, of class GraphSearch.
     */
    @Test
    public void testGetSonsEdge() {
        System.out.println("getSonsEdge");
        String file_path = "test/io/GraphCreatorTest.txt";
        String[] exp_result = {"friend","friend","friend","friend","employee","employee"};
        ArrayList<Edge> result = null;
        int iterator = 0;
        try {
            Graph graph = GraphCreator.GenerateGraph(file_path);
            DFSSearch dfs = new DFSSearch(graph);
            Node test_node = graph.getNode("Barbara");
            result = dfs.getSonsEdge(test_node);
            for(Edge current_edge : result){
                assertEquals(exp_result[iterator], current_edge.getName());
                //System.out.println("LIENS : "+current_edge.toString());
                iterator++;
            }
            assertEquals(exp_result.length,result.size());
        } catch (Exception ex) {
            Logger.getLogger(GraphSearchTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of search method, of class GraphSearch.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        Node node = null;
        GraphSearch instance = null;
        instance.search(node);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSonsApplyFilter method, of class GraphSearch.
     */
    @Test
    public void testGetSonsApplyFilter() {
        System.out.println("getSonsApplyFilter");
        Node current_node = null;
        GraphSearch instance = null;
        HashMap expResult = null;
        HashMap result = instance.getSonsApplyFilter(current_node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of applyAllFilters method, of class GraphSearch.
     */
    @Test
    public void testApplyAllFilters() {
        System.out.println("applyAllFilters");
        Edge current_edge = null;
        GraphSearch instance = null;
        Edge expResult = null;
        Edge result = instance.applyAllFilters(current_edge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of applyFilterFiltre method, of class GraphSearch.
     */
    @Test
    public void testApplyFilterFiltre() {
        System.out.println("applyFilterFiltre");
        Edge current_edge = null;
        GraphSearch instance = null;
        Edge expResult = null;
        Edge result = instance.applyFilterFiltre(current_edge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of applyFilterExploreEdge method, of class GraphSearch.
     */
    @Test
    public void testApplyFilterExploreEdge() {
        System.out.println("applyFilterExploreEdge");
        Node node_left = new Node("Barbara");
        Node node_right = new Node("Paul");
        Edge expected_edge = new Edge("friend", node_left, node_right, "BOTH");
        String file_path = "test/io/GraphCreatorTest.txt";
        Edge edge_temp;
        Edge tested_edge;
        Edge test_edge;
        try {
            Graph graph = GraphCreator.GenerateGraph(file_path);
            DFSSearch dfs = new DFSSearch(graph);
            /*ArrayList<Edge> test_edge = graph.getEdges().get("Barbara");
            for(Edge current_edge : test_edge){
                System.out.println("ZeaeZEEZE : "+current_edge);
                edge_temp = dfs.applyFilterFiltre(current_edge);
                System.out.println("OOOOOOOOO : "+edge_temp);
            }*/
            test_edge = graph.getEdges().get("Barbara").get(0);
            System.out.println("########################");
            System.out.println("test_edge : "+test_edge);
            tested_edge = dfs.applyFilterExploreEdge(test_edge);
            System.out.println("expected_edge"+expected_edge);
            
            System.out.println("tested_edge"+tested_edge);
            System.out.println("############################");
            //assertEquals();
        } catch (Exception ex) {
            Logger.getLogger(GraphSearchTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public class GraphSearchImpl extends GraphSearch {

        public GraphSearchImpl() {
            super(null, null, 0);
        }

        public void search(Node node) {
        }
    }
}
