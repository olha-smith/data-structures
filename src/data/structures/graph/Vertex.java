package data.structures.graph;

public class Vertex<T> {
    int index;
    T data;

    Vertex (int index, T data) {
        this.index = index;
        this.data = data;
    }
}
