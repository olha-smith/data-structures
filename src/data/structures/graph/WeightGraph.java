package data.structures.graph;

import data.structures.list.ArrayList;

public class WeightGraph<T> implements WeightedGraph<T> {

    @Override
    public Vertex<T> createVertex(T data) {
        return null;
    }

    @Override
    public boolean add(EdgeType edgeType, Vertex<T> source, Vertex<T> destination, Double weight) {
        return false;
    }

    @Override
    public ArrayList<WeightedEdge<T>> getEdges(Vertex<T> source) {
        return null;
    }

    @Override
    public Double weight(Vertex<T> source, Vertex<T> destination) {
        return null;
    }
}
