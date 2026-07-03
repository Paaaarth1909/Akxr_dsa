package LEETCODE.MEDIUM;

/* Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.

 

Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
 

Constraints:

1 <= nums.length <= 2000
-106 <= nums[i] <= 106
The answer is guaranteed to fit inside a 32-bit integer.
*/
class Solution {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        int[] len = new int[n];
        int[] cnt = new int[n];

        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            len[i] = 1;
            cnt[i] = 1;

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {

                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    } 
                    else if (len[j] + 1 == len[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }

            maxLen = Math.max(maxLen, len[i]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (len[i] == maxLen) {
                ans += cnt[i];
            }
        }

        return ans;
    }
}