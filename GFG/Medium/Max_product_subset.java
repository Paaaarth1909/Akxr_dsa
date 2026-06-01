package GFG.Medium;

/* Given an array arr[], find and return the maximum product possible with the subset of elements present in the array.

Note:

The maximum product can be of a single element also.
Since the product can be large, return it modulo 109 + 7.
Examples:

Input: arr[] = [-1, 0, -2, 4, 3]
Output: 24
Explanation: Maximum product will be ( -1 * -2 * 4 * 3 ) = 24
Input: arr[] = [-1, 0]
Output: 0
Explanation: Maximum product will be ( -1 * 0) = 0
Input: arr[] = [5]
Output: 5
Explanation: Maximum product will be 5.
Constraints:
1 ≤ arr.size() ≤ 2 * 104
-10 ≤ arr[i] ≤ 10

*/
class Solution {

    static final long MOD = 1000000007;

    public int findMaxProduct(int[] arr) {

        int n = arr.length;

        if(n == 1) {
            return arr[0];
        }

        long product = 1;

        int negativeCount = 0;
        int zeroCount = 0;

        int maxNegative = Integer.MIN_VALUE;

        for(int num : arr) {

            if(num == 0) {
                zeroCount++;
                continue;
            }

            if(num < 0) {
                negativeCount++;
                maxNegative = Math.max(maxNegative, num);
            }

            product = (product * num) % MOD;
        }

        if(zeroCount == n) {
            return 0;
        }

        if((negativeCount & 1) == 1) {

            if(negativeCount == 1 &&
               zeroCount + negativeCount == n) {
                return 0;
            }

            product =
                (product * modInverse(maxNegative, MOD)) % MOD;
        }

        if(product < 0) {
            product += MOD;
        }

        return (int) product;
    }

    long power(long a, long b, long mod) {

        long res = 1;

        a = ((a % mod) + mod) % mod;

        while(b > 0) {

            if((b & 1) == 1) {
                res = (res * a) % mod;
            }

            a = (a * a) % mod;

            b >>= 1;
        }

        return res;
    }

    long modInverse(long a, long mod) {
        return power(a, mod - 2, mod);
    }
}