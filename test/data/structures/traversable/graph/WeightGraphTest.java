package data.structures.traversable.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class  WeightGraphTest {

    @Test
    void testCreateVertex() {
        WeightedGraph<String> graph = new WeightGraph<>();
        String testString = "Hello";

        Vertex<String> vertex = graph.createVertex(testString);
        Assertions.assertEquals(testString, vertex.getData());
    }

    @Test
    void testEdgeType_when_UNDIRECTED() {
        WeightedGraph<String> graph = new WeightGraph<>();
        String testString1 = "Hello";
        String testString2 = "World";
        Double testWeight = 2.0;

        Vertex<String> vertex1 = graph.createVertex(testString1);
        Vertex<String> vertex2 = graph.createVertex(testString2);

        graph.add(EdgeType.UNDIRECTED, vertex1, vertex2, testWeight);

        assertEquals(graph.getEdges(vertex1).get(0).to, vertex2);
        assertEquals(graph.getEdges(vertex2).get(0).to, vertex1);
    }

    @Test
    void testEdgeType_when_DIRECTED() {
        WeightedGraph<String> graph = new WeightGraph<>();
        String testString1 = "Hello";
        String testString2 = "World";
        Double testWeight = 2.0;

        Vertex<String> vertex1 = graph.createVertex(testString1);
        Vertex<String> vertex2 = graph.createVertex(testString2);

        graph.add(EdgeType.DIRECTED, vertex1, vertex2, testWeight);

        assertEquals(graph.getEdges(vertex1).get(0).to, vertex2);
        assertTrue(graph.getEdges(vertex2).isEmpty());
    }

    @Test
    void testGetEdges_when_noEdgesForVertex() {
        WeightedGraph<String> graph = new WeightGraph<>();
        String testString = "Hello";

        Vertex<String> vertex = graph.createVertex(testString);
        ArrayList<WeightedEdge<String>> edgeList = graph.getEdges(vertex);

        assertTrue(edgeList.isEmpty());
    }

    @Test
    void testGetEdges_happyPath() {
        WeightedGraph<String> graph = new WeightGraph<>();
        String testString = "Hello";
        String testString2 = ",";
        String testString3 = "World";
        Double[] testWeights = {2.0, 1.3, 3.5};

        Vertex<String> vertex = graph.createVertex(testString);
        Vertex<String> vertex2 = graph.createVertex(testString2);
        Vertex<String> vertex3 = graph.createVertex(testString3);

        graph.add(EdgeType.UNDIRECTED, vertex, vertex2, testWeights[0]);
        graph.add(EdgeType.UNDIRECTED, vertex, vertex3, testWeights[1]);

        ArrayList<WeightedEdge<String>> edgeList = graph.getEdges(vertex);

        assertEquals(vertex2, edgeList.get(0).to);
        assertEquals(vertex3, edgeList.get(1).to);
    }

    @Test
    void testWeight() {
        WeightedGraph<String> graph = new WeightGraph<>();
        String testString1 = "Hello";
        String testString2 = "World";
        Double testWeight = 2.0;

        Vertex<String> vertex1 = graph.createVertex(testString1);
        Vertex<String> vertex2 = graph.createVertex(testString2);
        graph.add(EdgeType.UNDIRECTED, vertex1, vertex2, testWeight);

        assertEquals(testWeight, graph.weight(vertex1, vertex2));
    }
}
