package graphs.matrix_graph_search_in_width;

import java.util.*;

/**
 * Print path from one vertex of graph to another by search in width
 */
public class MatrixGraphSearchInWidth {
      public static void main(String[] args) {
            MatrixGraphSearchInWidth matrixGraph = new MatrixGraphSearchInWidth();
            matrixGraph.testFrom1To5();
            matrixGraph.testFrom1To8();
      }

      private List<Integer> findVertexBySearchInWidth(MatrixGraphImpl matrixGraph, int startVertexNumber, int endVertexNumber) {
            boolean[][] matrix = matrixGraph.getMatrix();

            Queue<Integer> vertexQueue = new LinkedList<>();
            Set<Integer> visitedVertexes = new LinkedHashSet<>();

            vertexQueue.add(startVertexNumber);

            while (!vertexQueue.isEmpty()) {
                  Integer currNumberVertex = vertexQueue.poll();
                  visitedVertexes.add(currNumberVertex);

                  if (currNumberVertex == endVertexNumber) {
                        return visitedVertexes.stream().toList();
                  }

                  boolean[] linksWithOtherVertex = matrix[currNumberVertex];

                  for (int j = 0; j < linksWithOtherVertex.length; j++) {
                        int numberVertex = j;
                        boolean hasLink = linksWithOtherVertex[j];
                        if (!visitedVertexes.contains(numberVertex) && hasLink) {
                              vertexQueue.add(numberVertex);
                        }
                  }
            }

            return null;
      }

      private void testFrom1To5() {
            MatrixGraphImpl g = new MatrixGraphImpl(9);
            g.addEdge(0, 1);
            g.addEdge(0, 3);

            g.addEdge(1, 0);

            g.addEdge(1, 2);
            g.addEdge(1, 4);

            g.addEdge(2, 1);
            g.addEdge(2, 5);

            g.addEdge(3, 0);
            g.addEdge(3, 6);

            g.addEdge(4, 1);
            g.addEdge(4, 7);

            g.addEdge(5, 2);
            g.addEdge(5, 8);

            g.addEdge(6, 3);
            g.addEdge(6, 7);

            g.addEdge(7, 4);
            g.addEdge(7, 6);
            g.addEdge(7, 8);

            g.addEdge(8, 5);
            g.addEdge(8, 7);

            System.out.println(g.toString());

            List<Integer> path = findVertexBySearchInWidth(g, 1, 5);
            System.out.println("Result (from 1 to 5) : " + path);
            System.out.println("Expected Result : 1, 0, 2, 4, 3, 5");
            System.out.println();
      }

      private void testFrom1To8() {
            MatrixGraphImpl g = new MatrixGraphImpl(9);
            g.addEdge(0, 1);
            g.addEdge(0, 3);

            g.addEdge(1, 0);

            g.addEdge(1, 2);
            g.addEdge(1, 4);

            g.addEdge(2, 1);
            g.addEdge(2, 5);

            g.addEdge(3, 0);
            g.addEdge(3, 6);

            g.addEdge(4, 1);
            g.addEdge(4, 7);

            g.addEdge(5, 2);
            g.addEdge(5, 8);

            g.addEdge(6, 3);
            g.addEdge(6, 7);

            g.addEdge(7, 4);
            g.addEdge(7, 6);
            g.addEdge(7, 8);

            g.addEdge(8, 5);
            g.addEdge(8, 7);

            System.out.println(g.toString());

            List<Integer> path = findVertexBySearchInWidth(g, 1, 8);
            System.out.println("Result (from 1 to 8) : " + path);
            System.out.println("Expected Result : 1, 0, 2, 4, 3, 5, 7, 6, 8");
            System.out.println();
      }
}
