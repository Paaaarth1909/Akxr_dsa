package GFG.Hard;

/* The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other. Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.

Given an integer n, find all distinct solutions to the n-queens puzzle.
You can return your answer in any order but each solution should represent a distinct board configuration of the queen placements, where the solutions are represented as permutations of [1, 2, 3, ..., n].

In this representation, the number in the ith position denotes the column in which the queen is placed in the ith row.
For eg. below figure represents a chessboard [2, 4, 1, 3].


Examples:

Input: n = 1
Output: [1]
Explaination: Only one queen can be placed in the single cell available.
Input: n = 4
Output: [[2, 4, 1, 3], [3, 1, 4, 2]]
Explaination: There are 2 possible solutions for n = 4.

Input: n = 3
Output: []
Explaination: There are no possible solutions for n = 3.
Constraints:
1 ≤ n ≤ 10

*/
import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> ans;

    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ans = new ArrayList<>();

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // row - col + n - 1
        boolean[] diag2 = new boolean[2 * n - 1]; // row + col

        int[] board = new int[n]; // board[row] = col

        solve(0, n, board, cols, diag1, diag2);
        return ans;
    }

    private void solve(int row, int n, int[] board,
                       boolean[] cols, boolean[] diag1, boolean[] diag2) {

        if (row == n) {
            ArrayList<Integer> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(board[i] + 1); // convert to 1-based index
            }
            ans.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;

            if (!cols[col] && !diag1[d1] && !diag2[d2]) {
                board[row] = col;
                cols[col] = diag1[d1] = diag2[d2] = true;

                solve(row + 1, n, board, cols, diag1, diag2);

                cols[col] = diag1[d1] = diag2[d2] = false; // backtrack
            }
        }
    }
}
