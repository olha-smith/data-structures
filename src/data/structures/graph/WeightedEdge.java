package data.structures.graph;

public class WeightedEdge<T> {
    Vertex<T> from;
    Vertex<T> to;
    Double weight;

    public WeightedEdge(Vertex<T> from, Vertex<T> to, Double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
