/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import model.Edge;
import model.Graph;
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
public class GraphCreatorTest {
    
    public GraphCreatorTest() {
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
     * Test of GenerateGraph method, of class GraphCreator.
     */
    @Test
    @SuppressWarnings("empty-statement")
    public void testGenerateGraph() throws Exception {
        System.out.println("GenerateGraph");
        String file_path = "test/io/GraphCreatorTest.txt";
        
        Graph expResult = new Graph();
        
        Node n1 = new Node("Barbara");
        Node n2 = new Node("Paul");
        Node n3 = new Node("Jean");
        Node n4 = new Node("Auchan");
        Node n5 = new Node("Saucisse");
        Node n6 = new Node("Henri");
        Node n7 = new Node("Findus");
        
        expResult.addNode(n1);
        expResult.addNode(n2);
        expResult.addNode(n3);
        expResult.addNode(n4);
        expResult.addNode(n5);
        expResult.addNode(n6);
        expResult.addNode(n7);
        
        Edge e11 = new Edge("friend",n1,n2,"BOTH");
        Edge e12 = new Edge("friend",n2,n1,"BOTH");
        
        Edge e21 = new Edge("friend",n1,n3,"BOTH");
        Edge e22 = new Edge("friend",n3,n1,"BOTH");
        
        Edge e31 = new Edge("employee",n1,n4,"RIGHT");
        Edge e32 = new Edge("employee",n4,n1,"LEFT");
        
        Edge e41 = new Edge("like",n3,n5,"RIGHT");
        Edge e42 = new Edge("like",n5,n3,"LEFT");
        
        Edge e51 = new Edge("like",n6,n7,"RIGHT");
        Edge e52 = new Edge("like",n7,n6,"LEFT");
        
        String [] pv1 = {"2002"};
        Property p1 = new Property("since",pv1);
        e11.addProperty(p1);
        e12.addProperty(p1);
        
        String [] pv2 = {"2001"};
        Property p2 = new Property("since",pv2);
        e21.addProperty(p2);
        e22.addProperty(p2);
        
        String [] pv31 = {"2007"};
        Property p31 = new Property("hired",pv31);
        e31.addProperty(p31);
        e32.addProperty(p31);
        String [] pv32 = {"laveur"};
        Property p32 = new Property("role",pv32);
        e31.addProperty(p32);
        e32.addProperty(p32);
        
        String [] pv4 = {"2000"};
        Property p4 = new Property("since",pv4);
        e41.addProperty(p4);
        e42.addProperty(p4);
        
        String [] pv5 = {"1999"};
        Property p5 = new Property("since",pv5);
        e51.addProperty(p5);
        e52.addProperty(p5);
        
        expResult.addEdge(e11);
        expResult.addEdge(e12);
        expResult.addEdge(e21);
        expResult.addEdge(e22);
        expResult.addEdge(e31);
        expResult.addEdge(e32);
        expResult.addEdge(e41);
        expResult.addEdge(e42);
        expResult.addEdge(e51);
        expResult.addEdge(e52);
        
        Graph result = GraphCreator.GenerateGraph(file_path);
        
        System.out.println(result.toString());
        System.out.println(expResult.toString());
        
        assertEquals(expResult,result);
        
        
    }
}
