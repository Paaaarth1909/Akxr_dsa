/* Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 

Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:


Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1
*/
class Solution {

    private int[][] dirs = {
        {1, 0}, {-1, 0},
        {0, 1}, {0, -1}
    };

    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int answer = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                answer = Math.max(
                    answer,
                    dfs(matrix, i, j, dp)
                );
            }
        }

        return answer;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] dp) {

        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int maxLen = 1;

        for (int[] d : dirs) {

            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nc >= 0 &&
                nr < matrix.length &&
                nc < matrix[0].length &&
                matrix[nr][nc] > matrix[r][c]) {

                maxLen = Math.max(
                    maxLen,
                    1 + dfs(matrix, nr, nc, dp)
                );
            }
        }

        dp[r][c] = maxLen;

        return maxLen;
    }
}