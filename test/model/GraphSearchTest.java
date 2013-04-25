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
        System.out.println("Liens de Barbara : "+g1.graph.getEdges().get("Barbara"));
        System.out.println("Liens de Paul : "+g1.graph.getEdges().get("Paul"));
        System.out.println("Liens de Jean : "+g1.graph.getEdges().get("Jean"));
        System.out.println("Liens de Auchan : "+g1.graph.getEdges().get("Auchan"));  
        System.out.println("Liens de Saucisse : "+g1.graph.getEdges().get("Saucisse"));
        System.out.println("Liens de Henri : "+g1.graph.getEdges().get("Henri"));      
        System.out.println("Liens de Findus : "+g1.graph.getEdges().get("Findus"));
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
        String[] exp_result = {"friend","friend","employee","3"};
        String[] tab_result = new String[4];
        DFSSearch dfs = new DFSSearch(graph,-1);
        int iterator = 0;
        Node test_node = graph.getNode("Barbara");
        ArrayList<Edge> result = dfs.getSonsEdge(test_node);
        for(Edge current_edge : result){
            tab_result[iterator] = current_edge.getName();
            iterator++;
        }
        tab_result[iterator] = String.valueOf(iterator);
        assertArrayEquals(exp_result, tab_result);
    }

    public class GraphSearchImpl extends GraphSearch {

        public GraphSearchImpl() {
            super(null, 0);
        }

        public void search(Node node) {
        }
    }

    /**
     * Test of getSonsApplyFilter method, of class GraphSearch.
     */
    @Test
    public void testGetSonsApplyFilter() {
        System.out.println("getSonsApplyFilter");
        DFSSearch dfs = new DFSSearch(graph,-1);
        HashMap<Node, Edge> result = new HashMap<Node, Edge>();
        Node test_node = graph.getNode("Barbara");
        result = dfs.getSonsApplyFilter(test_node);
        Edge[] tab_result = new Edge[3];
        Edge[] exp_result = new Edge[3];
        
        int i = 0;
        int j = 0;
        
        Node n1 = graph.getNode("Paul");
        Edge e1 = null;
        e1 = result.get(n1);
        Node n2 = graph.getNode("Jean");
        Edge e2 = null;
        e2 = result.get(n2);
        Node n3 = graph.getNode("Auchan");
        Edge e3 = null;
        e3 = result.get(n3);
        Edge[] tab_e = {e1,e2,e3};

        for(Edge res_edge : tab_e){
            tab_result[i] = res_edge;
            i++;
        }
        for(Edge exp_edge : dfs.getSonsEdge(test_node)){
            exp_result[j] = exp_edge;
            j++;
        }
        assertArrayEquals(exp_result, tab_result);
    }

    /**
     * Test of applyAllFilters method, of class GraphSearch.
     */
    @Test
    public void testApplyAllFilters() {
        System.out.println("applyAllFilters");
        Edge current_edge = null;
        Node current_node = null;
        GraphSearch instance = null;
        Edge expResult = null;
        Edge result = instance.applyAllFilters(current_edge, current_node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of applyFilterPredicate method, of class GraphSearch.
     */
    @Test
    public void testApplyFilterPredicate() {
        System.out.println("applyFilterPredicate");
        Edge current_edge = null;
        GraphSearch instance = null;
        Edge expResult = null;
        Edge result = instance.applyFilterPredicate(current_edge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of applyFilterAuthorizeEdge method, of class GraphSearch.
     */
    @Test
    public void testApplyFilterAuthorizeEdge() {
        System.out.println("applyFilterAuthorizeEdge");
        Edge current_edge = null;
        GraphSearch instance = null;
        Edge expResult = null;
        Edge result = instance.applyFilterAuthorizeEdge(current_edge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of applyFilterEdgeDirection method, of class GraphSearch.
     */
    @Test
    public void testApplyFilterEdgeDirection() {
        System.out.println("applyFilterEdgeDirection_true");
        DFSSearch dfs = new DFSSearch(graph,-1);
        String[] exp_result = {"BOTH","BOTH","RIGHT","3"};
        String[] tab_result = new String[4];
        Edge test_edge_true = null;
        int iterator = 0;
        for(int i = 0 ;i<graph.getEdges().get("Barbara").size(); i ++){
            test_edge_true = graph.getEdges().get("Barbara").get(i);
            Edge result = dfs.applyFilterEdgeDirection(test_edge_true);
            tab_result[i] = result.getDirection().toString();
            iterator = i;
        }
        tab_result[iterator+1] = String.valueOf(iterator+1);
        assertArrayEquals(exp_result, tab_result);
    }
    
    /**
     * Test of applyFilterEdgeDirection method, of class GraphSearch.
     */
    @Test
    public void testApplyFilterEdgeDirection2() {
        System.out.println("applyFilterEdgeDirection_false");
        DFSSearch dfs = new DFSSearch(graph,-1);
        Edge expResult = graph.getEdges().get("Henri").get(0);
        
        //modification faut lien (Left)
        Graph graph_false = new Graph();
        Node henri = new Node("Henri");
        graph_false.addNode(henri);
        Node findus = new Node("Findus");
        graph_false.addNode(findus);
        String[] valuesp5 = {"1999"};
        Property p5 = new Property("since", valuesp5);
        Edge e5 = new Edge("like", henri, findus, "LEFT");
        e5.addProperty(p5);
        graph_false.addEdge(e5);
        DFSSearch dfs_false = new DFSSearch(graph_false,-1);
        Edge test_edge_false = graph.getEdges().get("Henri").get(0);
        Edge result_false = dfs_false.applyFilterEdgeDirection(test_edge_false);
        
        assertEquals(expResult, result_false);
    }

    /**
     * Test of applyFilterAuthorizeNode method, of class GraphSearch.
     */
    @Test
    public void testApplyFilterAuthorizeNode() {
        System.out.println("applyFilterAuthorizeNode");
        Edge current_edge = null;
        Node current_node = null;
        GraphSearch instance = null;
        Edge expResult = null;
        Edge result = instance.applyFilterAuthorizeNode(current_edge, current_node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
