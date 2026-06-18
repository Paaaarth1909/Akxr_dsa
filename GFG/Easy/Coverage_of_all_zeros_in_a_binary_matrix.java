/* Given a binary matrix mat[][] containing only 0s and 1s, find the total coverage of all 0's. The coverage of a particular 0 cell is defined by checking 1's in its four directions (left, right, up, and down). For each direction, if there is at least one 1 anywhere between the 0 and the boundary of the matrix, the coverage increases by one.

Return the sum of the coverage values for all 0 cells in the matrix.

Examples:

InInput : [1, 1, 1, 0
          1, 0, 0, 1]
Output : 8
Explanation: Coverage of first zero is 2. Coverages of other two zeros is 3 Total coverage = 2 + 3 + 3 = 8
2056958046
Input: matrix = [[0, 1, 0],
               [0, 1, 1],
               [0, 0, 0]]
Output: 6
Explanation: Total Coverage is 1 + 2 + 1 + 0 + 1 + 1 = 6   
Input: matrix = [[0, 1]]
Output: 1
Explanation: There are only 1 coverage. There fore answer for this test case is 5.
Constraints:
1 ≤ matrix.size, matrix[0].size ≤ 100
*/
class Solution {
    public int findCoverage(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;

        int total = 0;

        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < m; j++) {
                
                if (mat[i][j] == 1) continue;

                for (int k = j - 1; k >= 0; k--) {
                    if (mat[i][k] == 1) {
                        total++;
                        break;
                    }
                }

                for (int k = j + 1; k < m; k++) {
                    if (mat[i][k] == 1) {
                        total++;
                        break;
                    }
                }

                for (int k = i - 1; k >= 0; k--) {
                    if (mat[k][j] == 1) {
                        total++;
                        break;
                    }
                }

                for (int k = i + 1; k < n; k++) {
                    if (mat[k][j] == 1) {
                        total++;
                        break;
                    }
                }
            }
        }

        return total;
    }
}
