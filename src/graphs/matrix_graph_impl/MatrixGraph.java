package graphs.matrix_graph_impl;

public interface MatrixGraph {
      boolean addEdge(int i, int j);

      boolean removeEdge(int i, int j);

      boolean isEdge(int i, int j);
}
