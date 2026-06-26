/* You are given an array of integers nums.

Your task is to find the length of the longest subsequence seq of nums, such that the absolute differences between consecutive elements form a non-increasing sequence of integers. In other words, for a subsequence seq0, seq1, seq2, ..., seqm of nums, |seq1 - seq0| >= |seq2 - seq1| >= ... >= |seqm - seqm - 1|.

Return the length of such a subsequence.

 

Example 1:

Input: nums = [16,6,3]

Output: 3

Explanation: 

The longest subsequence is [16, 6, 3] with the absolute adjacent differences [10, 3].

Example 2:

Input: nums = [6,5,3,4,2,1]

Output: 4

Explanation:

The longest subsequence is [6, 4, 2, 1] with the absolute adjacent differences [2, 2, 1].

Example 3:

Input: nums = [10,20,10,19,10,20]

Output: 5

Explanation: 

The longest subsequence is [10, 20, 10, 19, 10] with the absolute adjacent differences [10, 10, 9, 9].

 

Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 300
*/
class Solution {
    public int longestSubsequence(int[] nums) {

        int MAXV = 300;
        int MAXD = 299;

        int[][] dp = new int[MAXV + 1][MAXD + 1];
        int[][] suffix = new int[MAXV + 1][MAXD + 2];
        boolean[] seen = new boolean[MAXV + 1];

        int ans = 1;

        for (int x : nums) {

            int[] cur = new int[MAXD + 1];

            for (int v = 1; v <= MAXV; v++) {

                if (!seen[v]) continue;

                int d = Math.abs(x - v);

                int best = suffix[v][d];

                if (best > 0) {
                    cur[d] = Math.max(cur[d], best + 1);
                } else {
                    cur[d] = Math.max(cur[d], 2);
                }
            }

            for (int d = 0; d <= MAXD; d++) {
                if (cur[d] > dp[x][d]) {
                    dp[x][d] = cur[d];
                }
                ans = Math.max(ans, dp[x][d]);
            }

            seen[x] = true;

            suffix[x][MAXD] = dp[x][MAXD];
            for (int d = MAXD - 1; d >= 0; d--) {
                suffix[x][d] = Math.max(dp[x][d], suffix[x][d + 1]);
            }
        }

        return ans;
    }
}