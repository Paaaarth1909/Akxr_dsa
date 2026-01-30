package GFG.Basic;

/* Given a number n, return an array containing the first n Fibonacci numbers.

Note: The first two numbers of the series are 0 and 1.

Examples:

Input: n = 5
Output: [0, 1, 1, 2, 3]
Input: n = 7
Output: [0, 1, 1, 2, 3, 5, 8]
Input: n = 2
Output: [0, 1]
Constraints:
1 <= n <= 30

*/
// User function Template for Java

class Solution {
    public static int[] fibonacciNumbers(int n) {
        int[] fib = new int[n];

        if (n >= 1) fib[0] = 0;
        if (n >= 2) fib[1] = 1;

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib;
    }
}
