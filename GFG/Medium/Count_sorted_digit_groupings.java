package GFG.Medium;

/* Given a string s consisting of digits, you can split it into contiguous substrings (sub-groups). For example, the string "112" can be split as: ["1","1","2"], ["11","2"], ["1","12"], and ["112"].

A grouping is considered valid if the sums of digits of the sub-groups form a non-decreasing sequence from left to right.

Determine the total number of such valid groupings for the given string.

Examples: 

Input: s = "1119"
Output: 7
Explanation: 
One valid grouping is ["1", "11", "9"].
The sum of digits of the first sub-group ("1") is 1,
for the second sub-group ("11"), it is 2,
and for the third sub-group ("9"), it is 9.
Since the sums are in non-decreasing order (1 ≤ 2 ≤ 9), this is a valid grouping.
The other valid groupings are:
["1", "119"], ["1", "1", "19"], ["1", "1", "1", "9"], ["11", "19"], ["111", "9"], and ["1119"].
Thus, the total number of valid groupings is 7.
Input: s = "12"
Output: 2
Explanation: 
["1","2"] and ["12"] are two valid groupings.
Constraints:
1 ≤ s.size() ≤ 100
s[i] ∈ {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}

*/
class Solution {

    int[][] dp;
    int[] prefix;

    public int validGroups(String s) {

        int n = s.length();

        // prefix sum of digits
        prefix = new int[n + 1];

        for(int i = 0; i < n; i++) {
            prefix[i + 1] =
                prefix[i] + (s.charAt(i) - '0');
        }

        // max possible digit sum = 9 * 100 = 900
        dp = new int[n][901];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= 900; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(s, 0, 0);
    }

    private int solve(String s, int idx, int prevSum) {

        int n = s.length();

        // reached end
        if(idx == n) {
            return 1;
        }

        if(dp[idx][prevSum] != -1) {
            return dp[idx][prevSum];
        }

        int ways = 0;

        // try every possible partition
        for(int end = idx; end < n; end++) {

            int currSum =
                prefix[end + 1] - prefix[idx];

            // non-decreasing condition
            if(currSum >= prevSum) {

                ways += solve(s, end + 1, currSum);
            }
        }

        return dp[idx][prevSum] = ways;
    }
}