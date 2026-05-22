package GFG.Medium;

/* Given an n × m binary matrix grid[][], find the total count of all cells containing 1 that are unable to move out of the grid through a path of adjacent 1s.

Adjacency means you can only move in four directions: Up, Down, Left, and Right. Diagonal moves are not allowed.
Assume that the space immediately outside the grid is an open path. Any 1 located directly on the outer boundary of the grid (first row, last row, first column, or last column) can immediately step out, and any 1 connected to it can follow and also step out of the grid.
Examples:

Input: grid[][] = [[0, 0, 0, 0],
		[1, 0, 1, 0],
		[0, 1, 1, 0],
		[0, 0, 0, 0]]
Output: 3
Explanation: The highlighted cells represent the land cells.
 
Input: grid[][] = [[1, 1, 0, 0, 0, 1]
		[0, 1, 1, 0, 1, 0],
		[0, 0, 0, 1, 1, 0],
		[0, 0, 0, 1, 1, 0],
		[0, 1, 0, 1, 0, 0],
		[1, 1, 0, 0, 0, 1]]
Output: 6
Explanation: The highlighted cells represent the land cells.
425537429
Constraints:
1 ≤ n, m ≤ 500
0 ≤ grid[i][j] ≤ 1 
*/
class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    int cntOnes(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // DFS from boundary cells
        for(int i = 0; i < n; i++) {

            if(grid[i][0] == 1) {
                dfs(grid, i, 0);
            }

            if(grid[i][m - 1] == 1) {
                dfs(grid, i, m - 1);
            }
        }

        for(int j = 0; j < m; j++) {

            if(grid[0][j] == 1) {
                dfs(grid, 0, j);
            }

            if(grid[n - 1][j] == 1) {
                dfs(grid, n - 1, j);
            }
        }

        // count remaining 1s
        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(int[][] grid, int r, int c) {

        int n = grid.length;
        int m = grid[0].length;

        // invalid
        if(r < 0 || c < 0 || r >= n || c >= m ||
           grid[r][c] == 0) {
            return;
        }

        // mark visited
        grid[r][c] = 0;

        for(int k = 0; k < 4; k++) {

            int nr = r + dr[k];
            int nc = c + dc[k];

            dfs(grid, nr, nc);
        }
    }
}