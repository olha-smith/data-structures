package data.structures.traversable.graph;

public class WeightedEdge<T> {
    public Vertex<T> from;
    public Vertex<T> to;
    public Double weight;

    public WeightedEdge(Vertex<T> from, Vertex<T> to, Double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
