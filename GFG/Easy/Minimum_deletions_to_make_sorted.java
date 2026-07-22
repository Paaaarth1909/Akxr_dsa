package GFG.Easy;
/* Given an array arr[], find the minimum number of elements to delete so that the remaining elements form a strictly increasing sequence in the same order.

Examples:

Input: arr[] = [5, 6, 1, 7, 4]
Output: 2
Explanation: Removing 1 and 4 leaves [5, 6, 7] which is strictly increasing.
Input: arr[] = [1, 1, 1]
Output: 2
Explanation: Removing any 2 elements leaves [1] which is strictly increasing.
Constraints:
1 ≤ n ≤ 105 
1 ≤ arr[i] ≤ 105

*/
class Solution {
    public int minDeletions(int[] arr) {
        
        int n = arr.length;
        int[] tail = new int[n];
        int len = 0;
        
        for (int x : arr) {
            int l = 0;
            int r = len;
            
            while (l < r) {
                int m = (l + r) / 2;
                if (tail[m] < x) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            
            tail[l] = x;
            if (l == len) {
                len++;
            }
        }
        
        return n - len;
    }
}