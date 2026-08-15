package GFG.Hard;
/* Given a number n, count the numbers from 1 to n that don’t contain digit d in their decimal representation.

Examples:

Input: n = 25, d = 3
Output: 22
Explanation: From 1 to 25, the numbers 3, 13, and 23 contain the digit 3, so the answer is 25 - 3 = 22.
Input: n = 5, d = 3
Output: 4
Explanation: From 1 to 5, only 3 contains the digit 3, so the count of numbers without digit 3 is 4.
Constraints:

0 ≤ n ≤ 109
0 ≤ d ≤ 9
*/
class Solution {
     public int countWithout(int n, int d) {

         if (n == 0) {
             return 0;
         }

         String s = String.valueOf(n);
         int len = s.length();

         long[][][] dp = new long[len + 1][2][2];
         dp[0][1][0] = 1;

         for (int i = 0; i < len; i++) {
             for (int tight = 0; tight <= 1; tight++) {
                 for (int started = 0; started <= 1; started++) {

                     long ways = dp[i][tight][started];

                     if (ways == 0) {
                         continue;
                     }

                     int limit = tight == 1 ? s.charAt(i) - '0' : 9;

                     for (int digit = 0; digit <= limit; digit++) {

                         int ntight = (tight == 1 && digit == limit) ? 1 : 0;
                         int nstarted = started;

                         if (digit != 0) {
                             nstarted = 1;
                         }

                         if (nstarted == 1 && digit == d) {
                             continue;
                         }

                         dp[i + 1][ntight][nstarted] += ways;
                     }
                 }
             }
         }

         long ans = dp[len][0][0] + dp[len][0][1]
                  + dp[len][1][0] + dp[len][1][1];

         return (int) (ans - 1);
     }
 }