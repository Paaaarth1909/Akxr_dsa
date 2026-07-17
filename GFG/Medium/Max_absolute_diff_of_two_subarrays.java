/* Given an array of integers arr[], find two non-overlapping contiguous sub-arrays such that the absolute difference between the sum of two sub-arrays is maximum.

Examples :

Input: arr[] = [-2, -3, 4, -1, -2, 1, 5, -3]
Output: 12
Explanation: Two subarrays are [-2, -3] and [4, -1, -2, 1, 5]
Input: arr[] = [2, -1, -2, 1, -4, 2, 8]
Output: 16
Explanation: Two subarrays are [-1, -2, 1, -4] and [2, 8] 
Constraints:
2 ≤ arr.size() ≤ 105
-103 ≤ arr[i] ≤ 103

*/
class Solution {
    public int maxDiffSubArrays(int[] arr) {

        int n = arr.length;

        int[] leftMax = new int[n];
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        int[] rightMin = new int[n];

        int curMax = arr[0];
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            curMax = Math.max(arr[i], curMax + arr[i]);
            leftMax[i] = Math.max(leftMax[i - 1], curMax);
        }

        int curMin = arr[0];
        leftMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            curMin = Math.min(arr[i], curMin + arr[i]);
            leftMin[i] = Math.min(leftMin[i - 1], curMin);
        }

        curMax = arr[n - 1];
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            curMax = Math.max(arr[i], curMax + arr[i]);
            rightMax[i] = Math.max(rightMax[i + 1], curMax);
        }

        curMin = arr[n - 1];
        rightMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            curMin = Math.min(arr[i], curMin + arr[i]);
            rightMin[i] = Math.min(rightMin[i + 1], curMin);
        }

        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, Math.abs(leftMax[i] - rightMin[i + 1]));
            ans = Math.max(ans, Math.abs(rightMax[i + 1] - leftMin[i]));
        }

        return ans;
    }
}