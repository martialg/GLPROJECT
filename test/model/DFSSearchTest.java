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
public class DFSSearchTest {

    public DFSSearchTest() {
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
        String[] exp_result = {"Barbara", "Paul", "Jean", "Saucisse", "Auchan"};
        String file_path = "test/io/GraphCreatorTest.txt";
        try {
            Graph graph = GraphCreator.GenerateGraph(file_path);
            Node test_node = graph.getNode("Barbara");
            DFSSearch dfs = new DFSSearch(graph);
            dfs.search(test_node);

            String node_name = null;
            int iterator = 0;
            for (Node current_tagged_node : dfs.marked_nodes) {
                node_name = current_tagged_node.getName();
                assertEquals(node_name, exp_result[iterator]);
                iterator++;
            }
            assertEquals(iterator, 5);
        } catch (Exception ex) {
            Logger.getLogger(GraphSearchTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
