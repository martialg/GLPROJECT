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
    private Graph graph;
    
    public GraphSearchTest() {
        this.graph = new Graph();
        
        Node barbara = new Node("Barbara");
        this.graph.addNode(barbara);
        
        Node paul = new Node("Paul");
        this.graph.addNode(paul);
        
        Node auchan = new Node("Auchan");
        this.graph.addNode(auchan);
        
        Node jean = new Node("Jean");
        this.graph.addNode(jean);
        
        Node findus = new Node("Findus");
        this.graph.addNode(findus);
        
        Node saucisse = new Node("Saucisse");
        this.graph.addNode(saucisse);
        
        Node henri = new Node("Henri");
        this.graph.addNode(henri);
        
        String[] valuesp1 = {"2002"};
        Property p1 = new Property("since",valuesp1);
        Edge e1 = new Edge("friend", barbara, paul, "BOTH");
        e1.addProperty(p1);
        this.graph.addEdge(e1);
        
        String[] valuesp2 = {"2001"};
        Property p2 = new Property("since",valuesp2);
        Edge e2 = new Edge("friend", barbara, jean, "BOTH");
        e2.addProperty(p2);
        this.graph.addEdge(e2);
        
        String[] valuesp3a = {"2007"};
        String[] valuesp3b = {"laveur"};
        Property p3a = new Property("hired",valuesp3a);
        Property p3b = new Property("role",valuesp3b);
        Edge e3 = new Edge("employee", barbara, auchan, "RIGHT");
        e3.addProperty(p3a);
        e3.addProperty(p3b);
        this.graph.addEdge(e3);
        
        String[] valuesp4 = {"2000"};
        Property p4 = new Property("since", valuesp4);
        Edge e4 = new Edge("like", jean, saucisse, "RIGHT");
        e4.addProperty(p4);
        this.graph.addEdge(e4);
        
        String[] valuesp5 = {"1999"};
        Property p5 = new Property("since", valuesp5);
        Edge e5 = new Edge("like", henri, findus, "RIGHT");
        e5.addProperty(p5);
        this.graph.addEdge(e5);
        
        
    }
    
    public void testPrintGraph(){
        GraphSearchTest g1 = new GraphSearchTest();
        System.out.println("GRAPH : ");
        System.out.println("Liens de Barbara : "+g1.getGraph().getEdges().get("Barbara"));
        System.out.println("Liens de Paul : "+g1.getGraph().getEdges().get("Paul"));
        System.out.println("Liens de Jean : "+g1.getGraph().getEdges().get("Jean"));
        System.out.println("Liens de Auchan : "+g1.getGraph().getEdges().get("Auchan"));  
        System.out.println("Liens de Saucisse : "+g1.getGraph().getEdges().get("Saucisse"));
        System.out.println("Liens de Henri : "+g1.getGraph().getEdges().get("Henri"));      
        System.out.println("Liens de Findus : "+g1.getGraph().getEdges().get("Findus"));
    }
    
    public Graph getGraph(){
        return this.graph;
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
    * Test of isTaggedNode method, of class GraphSearch.
    */
    @Test
    public void testIsTaggedNode() {
        System.out.println("isTaggedNodeTrue");
        boolean exp_result_true = true;
        //g1.testPrintGraph();
        DFSSearch dfs = new DFSSearch(graph,-1);
        Node test_node_true = graph.getNode("Jean");
        dfs.search(test_node_true);
        boolean result_true = dfs.isTaggedNode(test_node_true);
        assertEquals(result_true, exp_result_true);
    }
    
    /**
    * Test of isTaggedNode method, of class GraphSearch.
    */
    @Test
    public void testIsTaggedNode2() {
        System.out.println("isTaggedNodeFalse");
        boolean exp_result_false = false;
        DFSSearch dfs = new DFSSearch(graph,-1);
        Node test_node_false = graph.getNode("Henri");
        Node test_node_true = graph.getNode("Jean");
        dfs.search(test_node_true);
        boolean result_false = dfs.isTaggedNode(test_node_false);
        assertEquals(result_false, exp_result_false);
    }

    /**
     * Test of isTaggedEdge method, of class GraphSearch.
     */
    @Test
    public void testIsTaggedEdge() {
        System.out.println("isTaggedEdgeTrue");
        boolean exp_result_true = true;
        DFSSearch dfs = new DFSSearch(graph,-1);
        Edge test_edge_true = graph.getEdges().get("Paul").get(0);
        Node node = graph.getNode("Jean");
        dfs.search(node);
        boolean result_true = dfs.isTaggedEdge(test_edge_true);
        assertEquals(result_true, exp_result_true);
    }

    /**
     * Test of isTaggedEdge method, of class GraphSearch.
     */
    @Test
    public void testIsTaggedEdge2() {
        System.out.println("isTaggedEdgeFalse");
        boolean exp_result_false = false;
        DFSSearch dfs = new DFSSearch(graph,-1);
        Edge test_edge_false = graph.getEdges().get("Henri").get(0);
        Node node = graph.getNode("Jean");
        dfs.search(node);
        boolean result_false = dfs.isTaggedEdge(test_edge_false);
        assertEquals(result_false, exp_result_false);
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
            DFSSearch dfs = new DFSSearch(graph,-1);
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
        //Edge result = instance.applyAllFilters(current_edge);
        //assertEquals(expResult, result);
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
        //Edge result = instance.applyFilterFiltre(current_edge);
        //assertEquals(expResult, result);
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
        String[] value = {"2002"};
        Property property = new Property("since", value);
        Edge expected_edge = new Edge("friend", node_left, node_right, "BOTH");
        expected_edge.addProperty(property);
        String file_path = "test/io/GraphCreatorTest.txt";
        Edge edge_temp;
        Edge tested_edge;
        Edge test_edge;
        
        try {
            Graph graph = GraphCreator.GenerateGraph(file_path);
            DFSSearch dfs = new DFSSearch(graph,-1);
            /*ArrayList<Edge> test_edge = graph.getEdges().get("Barbara");
            for(Edge current_edge : test_edge){
                System.out.println("ZeaeZEEZE : "+current_edge);
                edge_temp = dfs.applyFilterFiltre(current_edge);
                System.out.println("OOOOOOOOO : "+edge_temp);
            }*/
            test_edge = graph.getEdges().get("Barbara").get(0);
            System.out.println("########################");
            System.out.println("test_edge : "+test_edge);
            //tested_edge = dfs.applyFilterExploreEdge(test_edge);
            System.out.println("expected_edge : "+expected_edge);
            //System.out.println("tested_edge"+tested_edge);
            System.out.println("############################");
            //assertEquals();
        } catch (Exception ex) {
            Logger.getLogger(GraphSearchTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public class GraphSearchImpl extends GraphSearch {

        public GraphSearchImpl() {
            super(null, 0);
        }

        public void search(Node node) {
        }
    }
}
