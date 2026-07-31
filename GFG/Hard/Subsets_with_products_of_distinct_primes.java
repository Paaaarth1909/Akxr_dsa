package GFG.Hard;
/* Given an integer array arr[], count the number of different subsets whose product can be represented as a product of one or more distinct prime numbers.  Two subsets are considered different if the set of chosen array indexes are not same.

Return the count modulo 109 + 7.

Examples:

Input: arr[] = [1, 2, 3, 4]
Output: 6
Explanation: 
The subsets are:
[2], product = 2 = 2
[3], product = 3 = 3
[1, 2], product = 2 = 2
[1, 3], product = 3 = 3
[2, 3], product = 6 = 2 × 3
[1, 2, 3], product = 6 = 2 × 3
All these products can be expressed as a product of one or more distinct prime numbers. Hence, the count is 6.
Note that [4] or any other subset with 4 are not chosen because prducts having 4 have repeated primes 2.
Input: arr[] = [2, 2, 3]
Output: 5
Explanation: 
Since subsets formed using different indices are considered different, the chosen subsets are:
[2] (using the first 2)
[2] (using the second 2)
[3]
[2, 3] (using the first 2)
[2, 3] (using the second 2)
Each subset has a product that can be expressed as a product of one or more distinct prime numbers. 
Therefore, the answer is 5.

Constraints:

1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 30
 */
class Solution {
    public int countSubsets(int[] arr) {
        int MOD = 1000000007;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[] freq = new int[31];

        for (int x : arr) {
            freq[x]++;
        }

        long[] dp = new long[1 << 10];
        dp[0] = 1;

        for (int x = 2; x <= 30; x++) {
            if (freq[x] == 0) continue;

            int num = x;
            int mask = 0;
            boolean valid = true;

            for (int i = 0; i < 10; i++) {
                int cnt = 0;

                while (num % primes[i] == 0) {
                    num /= primes[i];
                    cnt++;
                }

                if (cnt > 1) {
                    valid = false;
                    break;
                }

                if (cnt == 1) {
                    mask |= 1 << i;
                }
            }

            if (!valid) continue;

            long[] next = dp.clone();

            for (int m = 0; m < (1 << 10); m++) {
                if ((m & mask) == 0) {
                    int nm = m | mask;
                    next[nm] = (next[nm] + dp[m] * freq[x]) % MOD;
                }
            }

            dp = next;
        }

        long ans = 0;

        for (int m = 1; m < (1 << 10); m++) {
            ans = (ans + dp[m]) % MOD;
        }

        long ones = 1;

        for (int i = 0; i < freq[1]; i++) {
            ones = (ones * 2) % MOD;
        }

        ans = (ans * ones) % MOD;

        return (int) ans;
    }
}