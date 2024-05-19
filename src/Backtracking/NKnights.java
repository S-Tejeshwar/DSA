package Backtracking;

public class NKnights {

    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        nKnights(0,0,4,board);
    }

    static void nKnights(int row, int col, int knights, boolean[][] board) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }

        if (row >= board.length-1 && col == board.length) {
            return;
        }

        if (col == board.length) {
            nKnights(row+1,0,knights,board);
            return;
        }

        if (col < board.length && row < board.length) {
            if(isSafe(board,row,col)) {
                board[row][col] =  true;
                nKnights(row, col+1, knights-1,board);
                board[row][col] = false;
            }
        }
        nKnights(row, col+1,knights,board);
    }

    static void display(boolean [][] board) {
        for (int r = 0; r<board.length; r++) {
            for(int c =0; c<board[r].length; c++) {
                if(board[r][c]) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        if(isValid(board, row+2, col-1)) {
            if(board[row+2][col-1] == true) {
                return false;
            }
        }
        if(isValid(board, row+2, col+1)) {
            if(board[row+2][col+1] == true) {
                return false;
            }
        }
        if(isValid(board, row-1, col+2)) {
            if(board[row-1][col+2] == true) {
                return false;
            }
        }
        if(isValid(board, row-1, col-2)) {
            if(board[row-1][col-2] == true) {
                return false;
            }
        }
        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col) {
        if(row < board.length && row >=0 && col < board.length && col>=0) {
            return true;
        }
        return false;
    }
}
