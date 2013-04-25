package model;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        DFSSearch dfs = new DFSSearch(graph,-1);
        Node test_node_true = graph.getNode("Jean");
        dfs.marked_nodes.add(test_node_true);
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
        dfs.marked_edges.add(test_edge_true);
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
     * Test positif
     */
    @Test
    public void testApplyAllFilters() {
        System.out.println("applyAllFilters");
        DFSSearch dfs = new DFSSearch(graph,-1);
        dfs.addFilterNodeAuthorize("Barbara");
        dfs.addFilterNodeAuthorize("Paul");
        dfs.addFilterEdgeAuthorize("friend");
        dfs.addFilterEdgeDirection("friend", Direction.BOTH);
        String[] properties = {"2002"};
        dfs.addFilterEdgeProperties("friend", "since", properties);
        Edge result = dfs.applyAllFilters(this.graph.getEdges().get("Barbara").get(0), this.graph.getNode("Barbara"));
        assertNotNull(result);
    }
    
     
    /**
     * Test of applyAllFilters method, of class GraphSearch.
     * Test negatif
     */
    @Test
    public void testApplyAllFilters2() {
        System.out.println("applyAllFilters");
        DFSSearch dfs = new DFSSearch(graph,-1);
        dfs.addFilterNodeAuthorize("Barbara");
        dfs.addFilterNodeAuthorize("Paul");
        dfs.addFilterEdgeAuthorize("friend");
        dfs.addFilterEdgeDirection("friend", Direction.BOTH);
        String[] properties = {"2010"};
        dfs.addFilterEdgeProperties("friend", "since", properties);
        Edge result = dfs.applyAllFilters(this.graph.getEdges().get("Barbara").get(0), this.graph.getNode("Barbara"));
        assertNull(result);
    }
    

    /**
     * Test of applyFilterPredicate method, of class GraphSearch.
     * Le lien correspond au predicat
     */
    @Test
    public void testApplyFilterPredicate() {
        System.out.println("applyFilterPredicate");
        DFSSearch dfs = new DFSSearch(this.graph,-1);
        String[] properties = {"2001"};
        dfs.addFilterEdgeProperties("friend", "since", properties);
        Edge current_edge = this.graph.getEdges().get("Barbara").get(1);
        Edge test = dfs.applyFilterPredicate(current_edge);
        assertNotNull(test);
    }
   
    /**
     * Test of applyFilterPredicate method, of class GraphSearch.
     * Le lien ne correspond pas au predicat
     */
    @Test
    public void testApplyFilterPredicate2() {
        System.out.println("applyFilterPredicate");
        DFSSearch dfs = new DFSSearch(this.graph,-1);
        String[] properties = {"3000"};
        dfs.addFilterEdgeProperties("friend", "since", properties);
        Edge current_edge = this.graph.getEdges().get("Barbara").get(1);
        Edge test = dfs.applyFilterPredicate(current_edge);
        assertNull(test);
    }
    
    /**
     * Test of applyFilterPredicate method, of class GraphSearch.
     * Pas de restriction
     */
    @Test
    public void testApplyFilterPredicate3() {
        System.out.println("applyFilterPredicate3");
        DFSSearch dfs = new DFSSearch(this.graph,-1);
        Edge current_edge = this.graph.getEdges().get("Barbara").get(1);
        Edge test = dfs.applyFilterPredicate(current_edge);
        assertNotNull(test);
    }

     /**
     * Test of applyFilterPredicate method, of class GraphSearch.
     * Test avec plusieurs valeurs vraies dans les propriétés
     */
    @Test
    public void testApplyFilterPredicate4() {
        System.out.println("applyFilterPredicate4");
        DFSSearch dfs = new DFSSearch(this.graph,-1);
        String[] properties = {"2007"};
        dfs.addFilterEdgeProperties("employee", "hired", properties);
        String[] properties2 = {"laveur"};
        dfs.addFilterEdgeProperties("employee", "role", properties2);
        Edge current_edge = this.graph.getEdges().get("Barbara").get(2);
        Edge test = dfs.applyFilterPredicate(current_edge);
        assertNotNull(test);
    }
    
    /**
     * Test of applyFilterPredicate method, of class GraphSearch.
     * Test avec plusieurs valeurs vraies dans les propriétés
     */
    @Test
    public void testApplyFilterPredicate5() {
        System.out.println("applyFilterPredicate5");
        DFSSearch dfs = new DFSSearch(this.graph,-1);
        String[] properties = {"2007"};
        dfs.addFilterEdgeProperties("employee", "hired", properties);
        String[] properties2 = {"ingenieur"};
        dfs.addFilterEdgeProperties("employee", "role", properties2);
        Edge current_edge = this.graph.getEdges().get("Barbara").get(2);
        Edge test = dfs.applyFilterPredicate(current_edge);
        assertNull(test);
    }
    
    
    
    
    /**
     * Test of applyFilterAuthorizeEdge method, of class GraphSearch.
     * Le lien est autorisé
     */
    @Test
    public void testApplyFilterAuthorizeEdge() {
        System.out.println("applyFilterAuthorizeEdge");
        DFSSearch dfs = new DFSSearch(this.graph,-1);
        dfs.addFilterEdgeAuthorize("employee");
        Edge current_edge = this.graph.getEdges().get("Barbara").get(2);
        Edge test = dfs.applyFilterAuthorizeEdge(current_edge);
        assertNotNull(test);
    }
    
    /**
     * Test of applyFilterAuthorizeEdge method, of class GraphSearch.
     * Le lien n'est pas autorisé
     */
    @Test
    public void testApplyFilterAuthorizeEdge2() {
        System.out.println("applyFilterAuthorizeEdge2");
        DFSSearch dfs = new DFSSearch(this.graph,-1);
        dfs.addFilterEdgeAuthorize("pomme");
        Edge current_edge = this.graph.getEdges().get("Barbara").get(2);
        Edge test = dfs.applyFilterAuthorizeEdge(current_edge);
        assertNull(test);
    }

    /**
     * Test of applyFilterAuthorizeEdge method, of class GraphSearch.
     * Aucune restriction
     */
    @Test
    public void testApplyFilterAuthorizeEdge3() {
        System.out.println("applyFilterAuthorizeEdge2");
        DFSSearch dfs = new DFSSearch(this.graph,-1);
        Edge current_edge = this.graph.getEdges().get("Barbara").get(2);
        Edge test = dfs.applyFilterAuthorizeEdge(current_edge);
        assertNotNull(test);
    }
    
    /**
     * Test of applyFilterEdgeDirection method, of class GraphSearch.
     */
    @Test
    public void testApplyFilterEdgeDirection() {
        System.out.println("applyFilterEdgeDirection_true");
        DFSSearch dfs = new DFSSearch(graph,-1);
        Node current_node = this.graph.getNode("Jean");
        dfs.addFilterEdgeDirection("like", Direction.RIGHT);
        Edge current_edge = this.graph.getEdges().get("Jean").get(1);
        Edge test = dfs.applyFilterEdgeDirection(current_edge, current_node);
        assertNotNull(test);
    }

    /**
     * Test of applyFilterEdgeDirection method, of class GraphSearch.
     */
    @Test
    public void testApplyFilterEdgeDirection2() {
        System.out.println("applyFilterEdgeDirection_true");
        DFSSearch dfs = new DFSSearch(graph,-1);
        Node current_node = this.graph.getNode("Jean");
        dfs.addFilterEdgeDirection("like", Direction.BOTH);
        Edge current_edge = this.graph.getEdges().get("Jean").get(1);
        Edge test = dfs.applyFilterEdgeDirection(current_edge, current_node);
        assertNull(test);
    }
    
    /**
     * Test of applyFilterEdgeDirection method, of class GraphSearch.
     */
    @Test
    public void testApplyFilterEdgeDirection3() {
        System.out.println("applyFilterEdgeDirection_true");
        DFSSearch dfs = new DFSSearch(graph,-1);
        Node current_node = this.graph.getNode("Jean");
        Edge current_edge = this.graph.getEdges().get("Jean").get(1);
        Edge test = dfs.applyFilterEdgeDirection(current_edge, current_node);
        assertNotNull(test);
    }

    /**
     * Test of applyFilterAuthorizeNode method, of class GraphSearch.
     * Le noeud est autorisé
     */
    @Test
    public void testApplyFilterAuthorizeNode() {
        System.out.println("applyFilterAuthorizeNode");
        DFSSearch dfs = new DFSSearch(this.graph,-1);
        dfs.addFilterNodeAuthorize("Barbara");
        dfs.addFilterNodeAuthorize("Auchan");
        Node current_node = this.graph.getNode("Barbara");
        Edge current_edge = this.graph.getEdges().get("Barbara").get(2);
        Edge test = dfs.applyFilterAuthorizeNode(current_edge, current_node);
        assertNotNull(test);
    }
    
    /**
     * Test of applyFilterAuthorizeNode method, of class GraphSearch.
     * Le noeud n'est pas autorisé
     */
    @Test
    public void testApplyFilterAuthorizeNode2() {
        System.out.println("applyFilterAuthorizeNode2");
        DFSSearch dfs = new DFSSearch(this.graph,-1);
        dfs.addFilterNodeAuthorize("Barbara");
        dfs.addFilterNodeAuthorize("Pomme");
        Node current_node = this.graph.getNode("Barbara");
        Edge current_edge = this.graph.getEdges().get("Barbara").get(2);
        Edge test = dfs.applyFilterAuthorizeNode(current_edge, current_node);
        assertNull(test);
    }
    
    /**
     * Test of applyFilterAuthorizeNode method, of class GraphSearch.
     * Aucune restriction
     */
    @Test
    public void testApplyFilterAuthorizeNode3() {
        System.out.println("applyFilterAuthorizeNode2");
        DFSSearch dfs = new DFSSearch(this.graph,-1);
        Node current_node = this.graph.getNode("Barbara");
        Edge current_edge = this.graph.getEdges().get("Barbara").get(2);
        Edge test = dfs.applyFilterAuthorizeNode(current_edge, current_node);
        assertNotNull(test);
    }

    /**
     * Test of addFilterEdgeProperties method, of class GraphSearch.
     */
    @Test
    public void testAddFilterEdgeProperties() {
        System.out.println("addFilterEdgeProperties");
        DFSSearch dfs = new DFSSearch(this.graph,-1);
        String[] properties = {"2002"};
        dfs.addFilterEdgeProperties("friend", "since", properties);
        ArrayList<Property> result = dfs.edge_propreties.get("friend");
        Property p_test = new Property("since", properties);
        ArrayList<Property> test = new ArrayList<Property>();
        test.add(p_test);
        assertEquals(test, result);
    }

    /**
     * Test of addFilterEdgeDirection method, of class GraphSearch.
     */
    @Test
    public void testAddFilterEdgeDirection() {
        System.out.println("addFilterEdgeDirection");
        DFSSearch dfs = new DFSSearch(this.graph,-1);
        Direction direction = Direction.RIGHT;
        dfs.addFilterEdgeDirection("like", direction);
        HashMap<String, Direction> result = dfs.edge_direction;
        Direction d_test = Direction.RIGHT;
        HashMap<String, Direction> test = new HashMap<String, Direction>();
        test.put("like", d_test);
        assertEquals(test, result);
    }

    /**
     * Test of addFilterNodeAuthorize method, of class GraphSearch.
     */
    @Test
    public void testAddFilterNodeAuthorize() {
        System.out.println("addFilterNodeAuthorize");
        DFSSearch dfs = new DFSSearch(this.graph,-1);
        dfs.addFilterNodeAuthorize("Barbara");
        ArrayList<String> test = new ArrayList<String>();
        test.add("Barbara");
        assertEquals(dfs.nodes_authorize, test);
    }

    /**
     * Test of addFilterEdgeAuthorize method, of class GraphSearch.
     */
    @Test
    public void testAddFilterEdgeAuthorize() {
        System.out.println("addFilterEdgeAuthorize");
        DFSSearch dfs = new DFSSearch(this.graph,-1);
        dfs.addFilterEdgeAuthorize("friend");
        ArrayList<String> test = new ArrayList<String>();
        test.add("friend");
        assertEquals(dfs.edges_authorize, test);
    }

    /**
     * Test of setUniquenessType method, of class GraphSearch.
     */
    @Test
    public void testSetUniquenessType() {
        System.out.println("setUniquenessType");
        int type = 2;
        DFSSearch dfs = new DFSSearch(this.graph,-1);
        dfs.setUniquenessType(2);
        assertEquals(type, dfs.uniqueness_type);
    }
}
