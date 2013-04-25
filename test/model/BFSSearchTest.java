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


public class BFSSearchTest {
    private Graph graph;
    
    public BFSSearchTest() {
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
        BFSSearchTest g1 = new BFSSearchTest();
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
     * Test of search method, of class BFSSearch.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String[] exp_result = {"Barbara","Paul","Jean","Auchan","Saucisse"};
        String[] tab_result = new String[5];
        Node test_node = graph.getNode("Barbara");
        BFSSearch bfs = new BFSSearch(graph,-1);
        bfs.search(test_node);

        String node_name=null;
        int iterator = 0;
        for(Node current_tagged_node : bfs.marked_nodes){
            node_name = current_tagged_node.getName();
            tab_result[iterator] = current_tagged_node.getName();
            iterator++;
        }
        //assertArrayEquals(exp_result, tab_result);
    }
    
    
    /**
     * Test of search method, of class BFSSearch.
     */
    @Test
    public void testSearch2() {
        System.out.println("search");
        String[] res_tab_node = new String[5];
        Node test_node = graph.getNode("Barbara");
        BFSSearch bfs = new BFSSearch(graph,-1);
        bfs.search(test_node);
        int iterator = 0;
        for(Node res_node : bfs.marked_nodes){
            res_tab_node[iterator] = res_node.getName();
            iterator++;
        }
        assertEquals(res_tab_node[4], "Saucisse");
    }
}
