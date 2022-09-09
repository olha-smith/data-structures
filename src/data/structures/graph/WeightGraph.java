package data.structures.graph;

import data.structures.list.ArrayList;
import data.structures.list.LinkedList;

import java.util.HashMap;

public class WeightGraph<T> implements WeightedGraph<T> {

    HashMap<Vertex<T>, LinkedList<WeightedEdge<T>>> map = new HashMap<>();

    @Override
    public Vertex<T> createVertex(T data) {
        Vertex<T> vertex = new Vertex<T>(map.size(), data);
        LinkedList<WeightedEdge<T>> edgeList = new LinkedList<>();

        map.put(vertex, edgeList);
        return vertex;
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
