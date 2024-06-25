package graphs.game_of_life;

public class GameOfLife {

    public static String nextGeneration(String input) {
        // Convert input string to 2D array
        String[] rows = input.split("_");
        int rowCount = rows.length;
        int colCount = rows[0].length();
        char[][] board = new char[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            board[i] = rows[i].toCharArray();
        }

        // Create a new board for the next generation
        char[][] newBoard = new char[rowCount][colCount];

        // Directions for neighboring cells (including diagonals)
        int[] rowDirs = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colDirs = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Iterate through each cell in the board
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                // Count live neighbors
                int liveNeighbors = 0;
                for (int d = 0; d < 8; d++) {
                    int ni = i + rowDirs[d];
                    int nj = j + colDirs[d];
                    if (ni >= 0 && ni < rowCount && nj >= 0 && nj < colCount && board[ni][nj] == '1') {
                        liveNeighbors++;
                    }
                }

                // Apply Game of Life rules
                if (board[i][j] == '1') {
                    // Live cell with fewer than two live neighbors dies (under-population)
                    if (liveNeighbors < 2) {
                        newBoard[i][j] = '0';
                    }
                    // Live cell with two or three live neighbors lives on to the next generation
                    else if (liveNeighbors == 2 || liveNeighbors == 3) {
                        newBoard[i][j] = '1';
                    }
                    // Live cell with more than three live neighbors dies (overcrowding)
                    else if (liveNeighbors > 3) {
                        newBoard[i][j] = '0';
                    }
                } else {
                    // Dead cell with exactly three live neighbors becomes alive (reproduction)
                    if (liveNeighbors == 3) {
                        newBoard[i][j] = '1';
                    } else {
                        newBoard[i][j] = '0';
                    }
                }
            }
        }

        // Convert new board to output string format
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                result.append(newBoard[i][j]);
            }
            if (i != rowCount - 1) {
                result.append("_");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Example usage
        String initialState = "000_111_000";
        String nextGenerationState = nextGeneration(initialState);
        System.out.println("Next generation: " + nextGenerationState);
    }
}