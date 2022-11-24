package data.structures.traversable.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WeightedGraphImplTest {

    @Test
    void CreateVertex_ShouldCreateVertexAndEmptyListOfEdges() {
        WeightedGraphImpl<String> graph = new WeightedGraphImpl<>();
        String testString = "Hello";

        Vertex<String> vertex = graph.createVertex(testString);
        Assertions.assertEquals(testString, vertex.getData());
        assertTrue(graph.getEdges(vertex).isEmpty());
    }

    @Test
    void Add_WhenSetEdgeTypeUNDIRECTED_ShouldCreateUndirectedEdge() {
        WeightedGraphImpl<String> graph = new WeightedGraphImpl<>();
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
    void Add_WhenSetEdgeTypeDIRECTED_ShouldCreateDirectedEdge() {
        WeightedGraphImpl<String> graph = new WeightedGraphImpl<>();
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
    void GetEdges_WhenVertexHasNotEdges_ShouldReturnEmptyList() {
        WeightedGraphImpl<String> graph = new WeightedGraphImpl<>();
        String testString = "Hello";

        Vertex<String> vertex = graph.createVertex(testString);
        ArrayList<WeightedEdge<String>> edgeList = graph.getEdges(vertex);

        assertTrue(edgeList.isEmpty());
    }

    @Test
    void GetEdges_WhenVertexHasEdges_ShouldReturnEdgesOfVertex() {
        WeightedGraphImpl<String> graph = new WeightedGraphImpl<>();
        String[] values = {"Hello", ",", "World"};
        Double[] testWeights = {2.0, 1.3, 3.5};

        Vertex<String> vertex0 = graph.createVertex(values[0]);
        Vertex<String> vertex1 = graph.createVertex(values[1]);
        Vertex<String> vertex2 = graph.createVertex(values[2]);

        graph.add(EdgeType.UNDIRECTED, vertex0, vertex1, testWeights[0]);
        graph.add(EdgeType.UNDIRECTED, vertex0, vertex2, testWeights[1]);

        ArrayList<WeightedEdge<String>> edgeList = graph.getEdges(vertex0);

        assertEquals(vertex1, edgeList.get(0).to);
        assertEquals(vertex2, edgeList.get(1).to);
    }

    @Test
    void Weight_WhenHasTwoVertices_ShouldReturnWeight() {
        WeightedGraphImpl<String> graph = new WeightedGraphImpl<>();
        String testString1 = "Hello";
        String testString2 = "World";
        Double testWeight = 2.0;

        Vertex<String> vertex1 = graph.createVertex(testString1);
        Vertex<String> vertex2 = graph.createVertex(testString2);
        graph.add(EdgeType.UNDIRECTED, vertex1, vertex2, testWeight);

        assertEquals(testWeight, graph.weight(vertex1, vertex2));
    }
}
