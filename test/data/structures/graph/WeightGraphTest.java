package data.structures.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class  WeightGraphTest {

    @Test
    void createVertex() {
        WeightedGraph<String> graph = new WeightGraph<>();
        String testString = "Hello";

        Vertex<String> vertex = graph.createVertex(testString);
        Assertions.assertEquals(testString, vertex.data);
    }

    @Test
    void add() {
    }

    @Test
    void getEdges() {
    }

    @Test
    void weight() {
    }
}