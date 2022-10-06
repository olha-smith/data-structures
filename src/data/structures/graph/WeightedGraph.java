package data.structures.graph;

import java.util.ArrayList;

public interface WeightedGraph<T> {

    Vertex<T> createVertex(T data);

    boolean add(EdgeType edgeType, Vertex<T> source, Vertex<T> destination, Double weight);

    ArrayList<WeightedEdge<T>> getEdges(Vertex<T> source);

    Double weight(Vertex<T> source, Vertex<T> destination);

}
