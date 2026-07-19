package LEETCODE.HARD;

import java.util.HashSet;

/* You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.

 

Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: grid = [[1,1],[1,0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: grid = [[1,1],[1,1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 500
grid[i][j] is either 0 or 1.
 
*/
class Solution {

    int n;
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int largestIsland(int[][] grid) {

        n = grid.length;
        int id = 2;
        int[] size = new int[n * n + 2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    size[id] = dfs(grid, i, j, id);
                    id++;
                }
            }
        }

        int ans = 0;

        for (int x : size) ans = Math.max(ans, x);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {

                    HashSet<Integer> set = new HashSet<>();
                    int cur = 1;

                    for (int[] d : dir) {
                        int r = i + d[0];
                        int c = j + d[1];

                        if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] > 1) {
                            if (set.add(grid[r][c])) {
                                cur += size[grid[r][c]];
                            }
                        }
                    }

                    ans = Math.max(ans, cur);
                }
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, int i, int j, int id) {

        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = id;

        int cnt = 1;

        for (int[] d : dir) {
            cnt += dfs(grid, i + d[0], j + d[1], id);
        }

        return cnt;
    }
}