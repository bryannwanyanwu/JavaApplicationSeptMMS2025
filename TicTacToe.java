public class TicTacToe {
    public enum Cell { X, O, EMPTY }
    
    private Cell[][] board;
    private Cell currentPlayer;
    private int movesCount;
    
    public TicTacToe() {
        board = new Cell[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = Cell.EM