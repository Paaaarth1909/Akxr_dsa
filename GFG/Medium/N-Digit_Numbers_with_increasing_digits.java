package GFG.Medium;

/* Given an integer n, return all the n digit numbers in increasing order, such that their digits are in strictly increasing order(from left to right).

Examples :

Input: n = 1
Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
Explanation: Single digit numbers are considered to be strictly increasing order.
Input: n = 2
Output: [12, 13, 14, 15, 16, 17, 18, 19, 23....79, 89]
Explanation: For n = 2, the correct sequence is 12 13 14 15 16 17 18 19 23 and so on up to 89.
Input: n = 15
Output: []
Explanation: No such number exist. 
Constraints:
1 ≤ n ≤ 105

*/
import java.util.*;

class Solution {

    public static ArrayList<Integer> increasingNumbers(int n) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (n > 10) return ans;

        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                ans.add(i);
            }
            return ans;
        }

        generate(1, n, 0, ans);

        return ans;
    }

    static void generate(int start, int n, int num, ArrayList<Integer> ans) {

        if (n == 0) {
            ans.add(num);
            return;
        }

        for (int d = start; d <= 9; d++) {
            generate(d + 1, n - 1, num * 10 + d, ans);
        }
    }
}