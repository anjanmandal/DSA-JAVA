public class NKnight {
    public static void main(String[] args) {
        int n = 4; // Size of the board and number of knights
        boolean[][] board = new boolean[n][n];
        NKnightSolver(board, 0, 0, n);
    }

    static void NKnightSolver(boolean[][] board, int row, int col, int Knights) {
        if (Knights == 0) {
            printBoard(board);
            System.out.println();
            return;
        }

        if (row >= board.length) {
            return; // If all rows are traversed, return
        }

        int nextRow = col == board.length - 1 ? row + 1 : row;
        int nextCol = col == board.length - 1 ? 0 : col + 1;

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            NKnightSolver(board, nextRow, nextCol, Knights - 1);
            board[row][col] = false;
        }

        NKnightSolver(board, nextRow, nextCol, Knights);
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        int n = board.length;
        
        // Check "upper left" knight moves
        if (row - 2 >= 0 && col - 1 >= 0 && board[row - 2][col - 1]) {
            return false;
        }
        if (row - 1 >= 0 && col - 2 >= 0 && board[row - 1][col - 2]) {
            return false;
        }
        
        // Check "upper right" knight moves
        if (row - 2 >= 0 && col + 1 < n && board[row - 2][col + 1]) {
            return false;
        }
        if (row - 1 >= 0 && col + 2 < n && board[row - 1][col + 2]) {
            return false;
        }
        
        // (Optional) If you want to check all 8 directions, you can also do
        // lower-left / lower-right, but typically for "no-attacking knights",
        // we only need to check the squares "before" (row,col) in some consistent order.
        // For an exhaustive safe-check, you could include:
        //
        //   (row+1, col-2), (row+2, col-1), (row+1, col+2), (row+2, col+1) 
        //
        // if you are not placing knights in a strictly top-down manner.
        
        return true; // It's safe if no knight-move position contains a knight
    }

    public static void printBoard(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean cell : row) {
                System.out.print((cell ? "K" : ".") + " ");
            }
            System.out.println();
        }
    }
}
