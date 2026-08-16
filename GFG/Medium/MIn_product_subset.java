/* Given an integer array arr[], find the minimum possible product that can be obtained by multiplying the elements of any non-empty subset of the array.

Examples:

Input: arr[] = [1, 2, 3]
Output: 1
Explanation: The possible subset products are 1, 2, 3, 2, 3, 6, and 6. The minimum product is 1, obtained by selecting the subset [1].
Input: arr[] = [4, -2, 5]
Output: -40
Explanation: The minimum product is -40, obtained by selecting the subset [4, -2, 5].

Constraints:

1 ≤ arr.size() ≤ 10
-10 ≤ arr[i] ≤ 10
*/
class Solution {
    public int minProd(int[] arr) {

        int n = arr.length;
        long ans = Long.MAX_VALUE;

        for (int mask = 1; mask < (1 << n); mask++) {

            long product = 1;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    product *= arr[i];
                }
            }

            ans = Math.min(ans, product);
        }

        return (int) ans;
    }
}