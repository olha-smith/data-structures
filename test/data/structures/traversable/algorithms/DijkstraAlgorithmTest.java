package data.structures.traversable.algorithms;

import algorithms.DijkstraAlgorithm;
import data.structures.exceptions.IndexOutOfBoundsException;
import data.structures.traversable.graph.EdgeType;
import data.structures.traversable.graph.Vertex;
import data.structures.traversable.graph.WeightedGraphImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DijkstraAlgorithmTest {
    private Vertex<String> source;
    private Vertex<String> destination;

    private WeightedGraphImpl<String> buildGraph() {
        WeightedGraphImpl<String> graph = new WeightedGraphImpl<>();
        Double[] testWeights = {3.0, 1.0, 1.0, 3.0, 3.0, 4.0, 1.0, 4.0};

        Vertex<String> vertexA = graph.createVertex("A");
        Vertex<String> vertexB = graph.createVertex("B");
        Vertex<String> vertexC = graph.createVertex("C");
        Vertex<String> vertexD = graph.createVertex("D");
        Vertex<String> vertexE = graph.createVertex("E");
        Vertex<String> vertexF = graph.createVertex("F");

        graph.add(EdgeType.UNDIRECTED, vertexA, vertexB, testWeights[0]);
        graph.add(EdgeType.UNDIRECTED, vertexA, vertexC, testWeights[1]);
        graph.add(EdgeType.UNDIRECTED, vertexB, vertexC, testWeights[2]);
        graph.add(EdgeType.UNDIRECTED, vertexB, vertexD, testWeights[3]);
        graph.add(EdgeType.UNDIRECTED, vertexB, vertexE, testWeights[4]);
        graph.add(EdgeType.UNDIRECTED, vertexC, vertexD, testWeights[5]);
        graph.add(EdgeType.UNDIRECTED, vertexD, vertexF, testWeights[6]);
        graph.add(EdgeType.UNDIRECTED, vertexE, vertexF, testWeights[7]);

        source = vertexA;
        destination = vertexF;

        return graph;
    }

    @Test
    void findShortestPathTest() throws IndexOutOfBoundsException {
        WeightedGraphImpl<String> graph = buildGraph();
        Double expectedWeight = 6.0;

        DijkstraAlgorithm<String> pathfinder = new DijkstraAlgorithm<>(graph);
        assertEquals(expectedWeight, pathfinder.findShortestPath(source, destination));
    }
}