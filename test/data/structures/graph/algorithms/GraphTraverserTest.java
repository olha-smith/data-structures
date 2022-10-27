package data.structures.graph.algorithms;

import data.structures.exceptions.IndexOutOfBoundsException;
import data.structures.traversable.graph.EdgeType;
import data.structures.traversable.graph.Vertex;
import data.structures.traversable.graph.WeightGraph;

import data.structures.traversable.algorithms.GraphTraverser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class GraphTraverserTest {

    private GraphTraverser<Integer> buildTraverser(WeightGraph<Integer> graph) {
        return new GraphTraverser<>(graph);
    }

    private Vertex<Integer> startVertex;

    private WeightGraph<Integer> buildGraph() {
        WeightGraph<Integer> graph = new WeightGraph<>();
        Double[] testWeights = {0.0, 1.1, 2.2, 3.3};

        Vertex<Integer> vertex1 = graph.createVertex(1);
        Vertex<Integer> vertex2 = graph.createVertex(2);
        Vertex<Integer> vertex3 = graph.createVertex(3);
        Vertex<Integer> vertex4 = graph.createVertex(4);
        Vertex<Integer> vertex5 = graph.createVertex(5);

        graph.add(EdgeType.UNDIRECTED, vertex1, vertex2, testWeights[0]);
        graph.add(EdgeType.UNDIRECTED, vertex1, vertex3, testWeights[1]);
        graph.add(EdgeType.UNDIRECTED, vertex2, vertex4, testWeights[2]);
        graph.add(EdgeType.UNDIRECTED, vertex2, vertex5, testWeights[3]);

        startVertex = vertex1;
        return graph;
    }

    @Test
    void testBreadthFirstSearch() throws IndexOutOfBoundsException {
        WeightGraph<Integer> graph = buildGraph();
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5);

        GraphTraverser<Integer> traverser = buildTraverser(graph);
        assertEquals(expectedList, traverser.breadthFirstSearch(startVertex));
    }

    @Test
    void testDepthFirstSearch() throws IndexOutOfBoundsException {
        WeightGraph<Integer> graph = buildGraph();
        List<Integer> expectedList = Arrays.asList(1, 2, 4, 5, 3);
//todo remove builder for traverser, just use new GraphTraverser(graph) instead
        GraphTraverser<Integer> traverser = buildTraverser(graph);
        assertEquals(expectedList, traverser.depthFirstSearch(startVertex));
    }
}
