/* Given an array arr[] and an integer k, find the maximum sum among all contiguous subarrays having a length greater than or equal to k.

Examples:

Input: arr[] = [1, -2, 2, -3], k = 3
Output: 1
Explanation: The sub-array of length at least 3 that produces greatest sum is [1, -2, 2]
Input: arr[] = [1, 1, 1, 1, 1, 1], k = 2
Output: 6
Explanation: The sub-array of length at least 2 that produces greatest sum is [1, 1, 1, 1, 1, 1]
Input: arr[] = [-4, -2, 1, -3], k = 2
Output: -1
Explanation: The sub-array of length at least 2 that produces greatest sum is [-2, 1]

Constraints:

1 ≤ arr.size() ≤ 105
-104 ≤ arr[i] ≤ 104
1 ≤ k ≤ arr.size()
*/
class Solution {
    public int maxSumWithK(int[] arr, int k) {

        int n = arr.length;

        int[] maxEnd = new int[n];
        maxEnd[0] = arr[0];

        for (int i = 1; i < n; i++) {
            maxEnd[i] = Math.max(arr[i], maxEnd[i - 1] + arr[i]);
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int ans = sum;

        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            ans = Math.max(ans, sum);
            ans = Math.max(ans, sum + maxEnd[i - k]);
        }

        return ans;
    }
}