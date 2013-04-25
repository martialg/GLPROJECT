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
public class BFSSearchTest {
    
    public BFSSearchTest() {
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
        String file_path = "test/io/GraphCreatorTest.txt";
        try {
            Graph graph = GraphCreator.GenerateGraph(file_path);
            Node test_node = graph.getNode("Barbara");
            BFSSearch bfs = new BFSSearch(graph,-1);
            bfs.search(test_node);
            
            String node_name=null;
            int iterator = 0;
            for(Node current_tagged_node : bfs.marked_nodes){
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
}
