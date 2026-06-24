package GFG.Medium;

/* Given a matrix mat[][] of size n × n, where mat[i][j] represents the maximum number of steps a rat can jump either forward (right) or downward from that cell, find a path for the rat to reach from the top-left cell (0, 0) to the bottom-right cell (n - 1, n - 1). A cell containing 0 is blocked and cannot be used in the path. It is guaranteed that the cell mat[n-1][n-1] is not 0.

Return an n × n matrix where 1 represents the cells included in the path and 0 represents the remaining cells. If no valid path exists, return [[-1]].

Note: If multiple valid paths exist, choose the path with the shortest possible jumps first. For the same jump length, moving forward (right) should be preferred over moving downward.

Example:

Input: mat[][] = [[2, 1, 0, 0], [3, 0, 0, 1], [0, 1, 0, 1], [0, 0, 0, 1]]
Output: [[1, 0, 0, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 1]]
Explanation: 

The rat starts from cell (0, 0) which contains value 2, so it can jump at most 2 steps either right or downward. 
Steps:
-> Moves downward to (1, 0) which contains value 3.
-> Jumps 3 steps right to reach (1, 3).
-> Moves downward through (2, 3) and reaches the destination cell (3, 3).
Input: mat[][] = [[2, 1, 0, 0], [2, 0, 0, 1], [0, 1, 0, 1], [0, 0, 0, 1]]
Output: [[-1]]
Explanation: The rat starts at (0, 0) with value 2, but every possible path from there eventually reaches a cell containing 0. Since no sequence of jumps can reach the destination cell (3, 3), no valid path exists and the output is [[-1]].
Constraints:
1 ≤ n ≤ 50
0 ≤ mat[i][j] ≤ 20

*/
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n = mat.length;
        
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sol.add(new ArrayList<>(Collections.nCopies(n, 0)));
        }

        boolean[][] visited = new boolean[n][n];

        if (solveMaze(mat, 0, 0, sol, visited, n)) {
            return sol;
        }

        ArrayList<ArrayList<Integer>> noPath = new ArrayList<>();
        ArrayList<Integer> errorRow = new ArrayList<>();
        errorRow.add(-1);
        noPath.add(errorRow);
        return noPath;
    }

    private boolean solveMaze(int[][] mat, int r, int c, ArrayList<ArrayList<Integer>> sol, boolean[][] visited, int n) {
        if (r == n - 1 && c == n - 1) {
            sol.get(r).set(c, 1);
            return true;
        }

        if (visited[r][c]) {
            return false;
        }

        sol.get(r).set(c, 1);
        int maxJumps = mat[r][c];

        for (int jump = 1; jump <= maxJumps; jump++) {
            
            if (c + jump < n && mat[r][c + jump] != 0) {
                if (solveMaze(mat, r, c + jump, sol, visited, n)) {
                    return true;
                }
            }

            if (r + jump < n && mat[r + jump][c] != 0) {
                if (solveMaze(mat, r + jump, c, sol, visited, n)) {
                    return true;
                }
            }
        }

        sol.get(r).set(c, 0);
        
        visited[r][c] = true;
        return false;
    }
}
