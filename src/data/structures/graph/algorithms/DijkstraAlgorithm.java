package data.structures.graph.algorithms;

import data.structures.exceptions.IndexOutOfBoundsException;
import data.structures.graph.Vertex;
import data.structures.graph.WeightedEdge;
import data.structures.graph.WeightedGraph;
import data.structures.queue.Queue;

import java.util.ArrayList;
import java.util.HashMap;

public class DijkstraAlgorithm<T> {
    private final WeightedGraph<T> graph;

    DijkstraAlgorithm(WeightedGraph<T> graph) {
        this.graph = graph;
    }

    public Double findShortestPath(Vertex<T> source, Vertex<T> destination) throws IndexOutOfBoundsException {
        Queue<Vertex<T>> goingToVisitQueue = new Queue<>();
        goingToVisitQueue.enqueue(source);

        HashMap<Vertex<T>, Double> pathTable = new HashMap<>();
        pathTable.put(source, 0.0);

        while (!goingToVisitQueue.isEmpty()) {
            Vertex<T> currentVertex = goingToVisitQueue.dequeue();
            ArrayList<WeightedEdge<T>> edges = graph.getEdges(currentVertex);

            for (WeightedEdge<T> edge : edges) {
                Vertex<T> targetVertex = edge.to;

                Double currentPathWeight = pathTable.get(currentVertex);
                Double potentialPathWeight = currentPathWeight + edge.weight;

                if (!pathTable.containsKey(targetVertex) || potentialPathWeight < pathTable.get(targetVertex)) {
                    pathTable.put(targetVertex, potentialPathWeight);
                    goingToVisitQueue.enqueue(targetVertex);
                }
            }
        }
        return pathTable.get(destination);
    }
}
