package GFG.Easy;

/* Give a n * n square matrix mat[][], return all the elements of its anti-diagonals from top to bottom.

Examples :

Input: n = 2, mat[][] = [[1, 2],
                        [3, 4]]
Output: [1, 2, 3, 4]
Explanation: 

Input: n = 3, mat[][] = [[1, 2, 3],
                       [4, 5, 6],
                       [7, 8, 9]]
Output: [1, 2, 4, 3, 5, 7, 6, 8, 9]
Explanation: 

Constraints:
1 ≤ n ≤ 103
0 ≤ mat[i][j] ≤ 106

*/
import java.util.*;

class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        
        int n = mat.length;
        ArrayList<Integer> res = new ArrayList<>();
        
        // start from top row
        for(int col = 0; col < n; col++){
            
            int i = 0;
            int j = col;
            
            while(i < n && j >= 0){
                res.add(mat[i][j]);
                i++;
                j--;
            }
        }
        
        // start from last column (excluding first row)
        for(int row = 1; row < n; row++){
            
            int i = row;
            int j = n - 1;
            
            while(i < n && j >= 0){
                res.add(mat[i][j]);
                i++;
                j--;
            }
        }
        
        return res;
    }
}