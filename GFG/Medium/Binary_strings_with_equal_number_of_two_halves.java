package GFG.Medium;

/* Given a number n, find count of all binary sequences of length 2n such that sum of first n bits is same as sum of last n bits. 

Note: Since the anwer can be very large, so return the answer modulo 109+7.

Examples:

Input: n = 2
Output: 6
Explanation: There are 6 sequences of length 2*n, the sequences are 0101, 0110, 1010, 1001, 0000 and 1111.
Input: n = 1
Output: 2
Explanation: There are 2 sequence of length 2*n, the sequence are 00 and 11. 
Constraints:
1 ≤ n ≤ 105

*/
class Solution {

    static final long MOD = 1000000007L;

    public int computeValue(int n) {

        int N = 2 * n;

        long[] fact = new long[N + 1];
        long[] invFact = new long[N + 1];

        fact[0] = 1;

        for (int i = 1; i <= N; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        invFact[N] = power(fact[N], MOD - 2);

        for (int i = N - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }

        long ans = fact[N];
        ans = (ans * invFact[n]) % MOD;
        ans = (ans * invFact[n]) % MOD;

        return (int) ans;
    }

    private long power(long a, long b) {

        long res = 1;

        while (b > 0) {

            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }

            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }
}