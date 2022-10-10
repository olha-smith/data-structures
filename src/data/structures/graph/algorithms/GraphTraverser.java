package data.structures.graph.algorithms;

import data.structures.exceptions.IndexOutOfBoundsException;
import data.structures.graph.Vertex;
import data.structures.graph.WeightedEdge;
import data.structures.graph.WeightedGraph;
import data.structures.queue.Queue;

import java.util.ArrayList;
import java.util.List;

public class GraphTraverser<T> {

    private final WeightedGraph<T> graph;

    GraphTraverser(WeightedGraph<T> graph) {
        this.graph = graph;
    }

    public List<T> breadthFirstSearch(Vertex<T> start) throws IndexOutOfBoundsException {
        Queue<Vertex<T>> goingToVisitQueue = new Queue<>();
        ArrayList<Vertex<T>> visitedVertices = new ArrayList<>();
        goingToVisitQueue.enqueue(start);

        while(!goingToVisitQueue.isEmpty()) {
            Vertex<T> currentVertex = goingToVisitQueue.dequeue();
            visitedVertices.add(currentVertex);
            ArrayList<WeightedEdge<T>> edges = graph.getEdges(currentVertex);

            for (WeightedEdge<T> edge : edges) {
                if (!visitedVertices.contains(edge.to)) {
                    goingToVisitQueue.enqueue(edge.to);
                }
            }
        }

        return visitedVertices.stream().map(Vertex::getData).toList();
    }

    public List<T> depthFirstSearch() {
        // todo implement
        return null;
    }

}
