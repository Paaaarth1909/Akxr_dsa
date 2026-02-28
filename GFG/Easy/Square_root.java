package GFG.Easy;

/* Given a positive integer n, find the square root of n. If n is not a perfect square, then return the floor value.

Floor value of any number is the greatest Integer which is less than or equal to that number.

Examples:

Input: n = 4
Output: 2
Explanation: Since, 4 is a perfect square, so its square root is 2.
Input: n = 11
Output: 3
Explanation: Since, 11 is not a perfect square, floor of square root of 11 is 3.
Input: n = 1
Output: 1
Explanation: 1 is a perfect sqaure, so its square root is 1.
Constraints:
1 ≤ n ≤ 3*104

*/
class Solution {
    int floorSqrt(int n) {
        int low = 1, high = n;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long sq = (long) mid * mid; // prevent overflow

            if (sq == n) {
                return mid;  // perfect square
            } else if (sq < n) {
                ans = mid;   // possible answer
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
