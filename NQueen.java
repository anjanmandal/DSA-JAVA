import java.util.Arrays;

public class NQueen{
    public static void main(String[]args){
        int n = 4;  // Change this to set the board size
        String[][] path = new String[n][n];
        boolean[][] board = new boolean[n][n];
        for (boolean [] a : board){
            System.out.println(Arrays.toString(a));
        }
        
        // Initialize the board and the path representation
        for (int i = 0; i < n; i++) {
            Arrays.fill(path[i], "."); // Using "." to denote an empty cell
            for (int j = 0; j < n; j++) {
                board[i][j] = false;
            }
        }
        
        // Start the recursion at row 0
        NQueen(path, board, 0);

    }
    static void NQueen(String[][] path,boolean[][]board, int row){
        if(row==path.length){
            for(String[]ans:path){
                System.out.println(Arrays.toString(ans));
            }
            System.out.println();
        }
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]=true;
                path[row][col]="Q";
                NQueen(path, board, row+1);
                board[row][col]=false;
                path[row][col]="";
            }
        }
        return;
    }
    static boolean isSafe(boolean[][] board, int row, int col) {
        int n = board.length;
        
        // Check same column (only above the current row because queens are placed row by row)
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        
        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }
        
        // Check upper right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }
        
        return true;  // Safe to place the queen here
    }
    
}