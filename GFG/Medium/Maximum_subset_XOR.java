package GFG.Medium;
/* Given an array arr[], choose any subset of elements (possibly all elements) such that the XOR of the chosen elements is maximized.

Examples:

Input : arr[] = [2, 4, 5]
Output: 7
Explanation: The subset {2, 5} has the maximum XOR value.
Input : arr[] = [9, 8, 5]
Output: 13
Explanation: The subset {8, 5} has the maximum XOR value.
Constraints:

1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 106
*/
class Solution {
    public int maxSubsetXOR(int[] arr) {
        
        int[] basis = new int[31];

        for (int x : arr) {
            for (int i = 30; i >= 0; i--) {
                if ((x & (1 << i)) == 0) continue;

                if (basis[i] == 0) {
                    basis[i] = x;
                    break;
                }

                x ^= basis[i];
            }
        }

        int ans = 0;

        for (int i = 30; i >= 0; i--) {
            ans = Math.max(ans, ans ^ basis[i]);
        }

        return ans;
    }
}