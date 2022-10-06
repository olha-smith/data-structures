package data.structures.graph;


import java.util.ArrayList;
import java.util.HashMap;

public class WeightGraph<T> implements WeightedGraph<T> {

    HashMap<Vertex<T>, ArrayList<WeightedEdge<T>>> map = new HashMap<>();

    @Override
    public Vertex<T> createVertex(T data) {
        Vertex<T> vertex = new Vertex<T>(map.size(), data);
        ArrayList<WeightedEdge<T>> edgeList = new ArrayList<>();

        map.put(vertex, edgeList);
        return vertex;
    }

    @Override
    public boolean add(EdgeType edgeType, Vertex<T> source, Vertex<T> destination, Double weight) {
        switch (edgeType) {
            case UNDIRECTED -> {
                addDirectedEdge(source, destination, weight);
                addDirectedEdge(destination, source, weight);
            }
            case DIRECTED -> addDirectedEdge(source, destination, weight);
        }
        return true;
    }

    private void addDirectedEdge(Vertex<T> source, Vertex<T> destination, Double weight) {
        WeightedEdge<T> edge = new WeightedEdge<>(source, destination, weight);
        map.get(source).add(edge);
    }

    @Override
    public ArrayList<WeightedEdge<T>> getEdges(Vertex<T> source) {
        return map.get(source);
    }

    @Override
    public Double weight(Vertex<T> source, Vertex<T> destination) {
        ArrayList<WeightedEdge<T>> edges = getEdges(source);
        for (WeightedEdge<T> edge : edges) {
            if (edge.to.equals(destination)) {
                return edge.weight;
            }
        }
        return null;
    }
}
