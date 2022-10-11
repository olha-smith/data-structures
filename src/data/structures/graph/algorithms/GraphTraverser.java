package data.structures.graph.algorithms;

import data.structures.exceptions.IndexOutOfBoundsException;
import data.structures.graph.Vertex;
import data.structures.graph.WeightedEdge;
import data.structures.graph.WeightedGraph;
import data.structures.queue.Queue;
import data.structures.queue.Stack;

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

        while (!goingToVisitQueue.isEmpty()) {
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

    public List<T> depthFirstSearch(Vertex<T> start) throws IndexOutOfBoundsException {
        Stack<Vertex<T>> goingToVisitStack = new Stack<>();
        ArrayList<Vertex<T>> visitedVertices = new ArrayList<>();

        goingToVisitStack.push(start);

        while (!goingToVisitStack.isEmpty()) {
            Vertex<T> currentVertex = goingToVisitStack.top();
            ArrayList<WeightedEdge<T>> edges = graph.getEdges(currentVertex);

            if (!visitedVertices.contains(currentVertex)) {
                visitedVertices.add(currentVertex);
            }

            List<WeightedEdge<T>> unvisitedVertices =
                    edges.stream().filter(edge -> !visitedVertices.contains(edge.to)).toList();

            if (unvisitedVertices.size() == 0) {
                goingToVisitStack.pop();
            } else {
                goingToVisitStack.push(unvisitedVertices.get(0).to);
            }
        }

        return visitedVertices.stream().map(Vertex::getData).toList();
    }
}
