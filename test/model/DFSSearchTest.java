/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DFSSearchTest {
    private Graph graph;
    
    public DFSSearchTest() {
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
        DFSSearchTest g1 = new DFSSearchTest();
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
     * Test of search method, of class DFSSearch.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        DFSSearch dfs = new DFSSearch(graph, -1);
        Node test_node = graph.getNode("Barbara");
        dfs.search(test_node);
        String[] res_tab_node = new String[5];
        int iterator = 0;
        for(Node res_node : dfs.marked_nodes){
            res_tab_node[iterator] = res_node.getName();
            iterator++;
        }
        for(int i = 0; i<iterator;i++){
            if(res_tab_node[i] == "Jean"){
                assertEquals(res_tab_node[i+1], "Saucisse");
            }
        }
    }
    
    /**
     * Test of search method, of class DFSSearch.
     */
    @Test
    public void testSearch2() {
        System.out.println("search");
        DFSSearch dfs = new DFSSearch(graph, -1);
        Node test_node = graph.getNode("Barbara");
        dfs.search(test_node);
        String[] res_tab_node = new String[5];
        int iterator = 0;
        for(Node res_node : dfs.marked_nodes){
            res_tab_node[iterator] = res_node.getName();
            iterator++;
        }
        for(int i = 0; i < iterator ; i++){
            System.out.println("Poire : "+res_tab_node[i]);
            if(res_tab_node[i] == "Saucisse"){
               assertNotSame(res_tab_node[i-2], "Jean");
            }
        }
    }
}
