package data.structures.traversable.graph;

public class Vertex<T> {
    int index;
    T data;

    public T getData() {
        return data;
    }

    Vertex (int index, T data) {
        this.index = index;
        this.data = data;
    }
}
