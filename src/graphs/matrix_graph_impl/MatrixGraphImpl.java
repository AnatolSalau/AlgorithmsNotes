package graphs.matrix_graph_impl;

public class MatrixGraphImpl implements MatrixGraph {
      private boolean[][] matrix;
      private int vertexQty;

      public MatrixGraphImpl(int vertexQty) {
            this.vertexQty = vertexQty;
            this.matrix = new boolean[vertexQty][vertexQty];
      }

      @Override
      public boolean addEdge(int i, int j) {
            matrix[i][j] = true;
            matrix[j][i] = true;
            return matrix[i][j] && matrix[j][i];
      }

      @Override
      public boolean removeEdge(int i, int j) {
            matrix[i][j] = false;
            matrix[j][i] = false;
            return matrix[i][j] && matrix[j][i];
      }

      @Override
      public boolean isEdge(int i, int j) {
            return matrix[i][j] && matrix[j][i];
      }

      @Override
      public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < vertexQty; i++) {
                  s.append(i).append(": ");
                  for (boolean j : matrix[i]) {
                        s.append(j ? 1 : 0).append(" ");
                  }
                  s.append("\n");
            }
            return s.toString();
      }

      public static void main(String[] args) {
            MatrixGraphImpl matrixGraph = new MatrixGraphImpl(5);
            matrixGraph.addEdge(0, 4);
            System.out.println(matrixGraph.toString());
      }
}
