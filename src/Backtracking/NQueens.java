package Backtracking;

public class NQueens {

    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        System.out.println(placeQueens(board,0));
    }


    static int placeQueens(boolean[][] board, int row) {
        if (board.length == row) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board[row].length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += placeQueens(board, row+1);
            }
            board[row][col] = false;
        }

        return count;
    }

    static void display(boolean [][] board) {
        for (int r = 0; r<board.length; r++) {
            for(int c =0; c<board[r].length; c++) {
                if(board[r][c]) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        //Check if a queen is placed in the same col
        for (int i = 0; i<row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

            //Check if a queen is diagonally left
            int min = Math.min(row, col);
            for (int i = 1; i <= min; i++) {
                if (board[row - i][col - i]) {
                    return false;
                }
            }

            //Check if a queen is diagnoally right

            min =Math.min(board.length-col-1, row);
            for (int i = 1; i <= min; i++) {
                if (board[row - i][col + i]) {
                    return false;
                }
            }
        return true;
    }
}
