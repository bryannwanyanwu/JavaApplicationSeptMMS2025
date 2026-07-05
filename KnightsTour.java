public class KnightsTour {
    private static final int SIZE = 8;
    private static int[][] board = new int[SIZE][SIZE];
    private static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
    
    public static void main(String[] args) {
        // Try starting from different positions
        int maxMoves = 0;
        int bestStartRow = 0;
        int bestStartCol = 0;
        
        for (int startRow = 0; startRow < SIZE; startRow++) {
            for (int startCol = 0; startCol < SIZE; startCol++) {
                int moves = runTour(startRow, startCol);
                if (moves > maxMoves) {
                    maxMoves = moves;
                    bestStartRow = startRow;
                    bestStartCol = startCol;
                }
            }
        }
        
        System.out.printf("Best tour started at (%d, %d) with %d moves%n", 
                         bestStartRow, bestStartCol, maxMoves);
        
        // Display best tour
        runTour(bestStartRow, bestStartCol);
        displayBoard();
    }
    
    private static int runTour(int startRow, int startCol) {
        // Initialize board
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = 0;
            }
        }
        
        int currentRow = startRow;
        int currentCol = startCol;
        board[currentRow][currentCol] = 1;
        int moveCount = 1;
        
        while (moveCount < SIZE * SIZE) {
            int nextMove = findNextMove(currentRow, currentCol);
            if (nextMove == -1) break;
            
            currentRow += vertical[nextMove];
            currentCol += horizontal[nextMove];
            board[currentRow][currentCol] = ++moveCount;
        }
        
        return moveCount;
    }
    
    private static int findNextMove(int row, int col) {
        int[] moveOptions = new int[8];
        int optionCount = 0;
        
        // Find all valid moves
        for (int i = 0; i < 8; i++) {
            int newRow = row + vertical[i];
            int newCol = col + horizontal[i];
            
            if (isValidMove(newRow, newCol)) {
                moveOptions[optionCount++] = i;
            }
        }
        
        if (optionCount == 0) return -1;
        
        // Use accessibility heuristic
        int[] accessibility = new int[optionCount];
        for (int i = 0; i < optionCount; i++) {
            int move = moveOptions[i];
            int newRow = row + vertical[move];
            int newCol = col + horizontal[move];
            accessibility[i] = countAccessibleSquares(newRow, newCol);
        }
        
        // Choose move with lowest accessibility
        int minAccessibility = accessibility[0];
        int bestIndex = 0;
        for (int i = 1; i < optionCount; i++) {
            if (accessibility[i] < minAccessibility) {
                minAccessibility = accessibility[i];
                bestIndex = i;
            }
        }
        
        return moveOptions[bestIndex];
    }
    
    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == 0;
    }
    
    private static int countAccessibleSquares(int row, int col) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int newRow = row + vertical[i];
            int newCol = col + horizontal[i];
            if (isValidMove(newRow, newCol)) {
                count++;
            }
        }
        return count;
    }
    
    private static void displayBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%3d", board[i][j]);
            }
            System.out.println();
        }
    }
}