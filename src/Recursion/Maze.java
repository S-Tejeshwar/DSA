package Recursion;

import java.awt.*;

public class Maze {

    public static void main(String[] args) {

     boolean[][] maze = {
             {true, true, true},
             {true,true,true},
             {true,true,true}
     };
//     System.out.println(count(2,2));
//     path("",2,2);
//     diagonalpath("",3,3);
//     diagonalpathWithObstacles("",0,0,maze);
       diagonalpathBacktracking("",0,0,maze);
    }

    static int count(int r, int c) {
        if (r == 1 || c ==1) {
            return 1;
        }
        int left = count(r-1, c);
        int right = count(r, c-1);
        return right + left;
    }

    static void path(String p, int r, int c) {
        if ( r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 1) {
            path(p+"D",r-1,c);
        }

        if (c > 1) {
            path(p+"R", r, c-1);
        }
    }

    static void diagonalpath(String p, int r, int c) {
        if ( r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r>1 && c>1) {
            diagonalpath(p+"D", r-1, c-1);
        }

        if (r > 1) {
            diagonalpath(p+"V",r-1,c);
        }

        if (c > 1) {
            diagonalpath(p+"C", r, c-1);
        }
    }

    static void diagonalpathWithObstacles(String p, int r, int c, boolean maze[][]) {
        if ( r == maze.length-1 && c == maze[0].length-1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        if (r< maze.length-1 && c < maze[0].length-1) {
            diagonalpathWithObstacles(p+"D", r+1, c+1, maze);
        }

        if (r< maze.length-1) {
            diagonalpathWithObstacles(p+"V",r+1,c,maze);
        }

        if (c < maze[0].length-1) {
            diagonalpathWithObstacles(p+"H", r, c+1,maze);
        }
    }

    static void diagonalpathBacktracking(String p, int r, int c, boolean maze[][]) {
        if ( r == maze.length-1 && c == maze[0].length-1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;
        if (r< maze.length-1 && c < maze[0].length-1) {
            diagonalpathBacktracking(p+"Diagonal ", r+1, c+1, maze);
        }

        if (r < maze.length-1) {
            diagonalpathBacktracking(p+"Down ",r+1,c,maze);
        }

        if (c < maze[0].length-1) {
            diagonalpathBacktracking(p+"Right ", r, c+1,maze);
        }

        if ( r > 0) {
            diagonalpathBacktracking(p+"Up ", r-1,c,maze);
        }

        if ( c > 0) {
            diagonalpathBacktracking(p+"Left ", r,c-1,maze);
        }
        maze[r][c] = true;
    }
}
