package LEETCODE.HARD;

/* Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

Note that operands in the returned expressions should not contain leading zeros.

Note that a number can contain multiple digits.

 

Example 1:

Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]
Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2","2+3*2"]
Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
Example 3:

Input: num = "3456237490", target = 9191
Output: []
Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.
 

Constraints:

1 <= num.length <= 10
num consists of only digits.
-231 <= target <= 231 - 1
 
*/
import java.util.*;

class Solution {

    public List<String> addOperators(String num, int target) {

        List<String> ans = new ArrayList<>();
        backtrack(ans, "", num, target, 0, 0, 0);
        return ans;
    }

    private void backtrack(List<String> ans, String expr, String num,
                           int target, int index, long value, long prev) {

        if (index == num.length()) {
            if (value == target) {
                ans.add(expr);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {

            if (i > index && num.charAt(index) == '0') {
                break;
            }

            String currStr = num.substring(index, i + 1);
            long curr = Long.parseLong(currStr);

            if (index == 0) {
                backtrack(ans, currStr, num, target, i + 1, curr, curr);
            } else {

                backtrack(ans, expr + "+" + currStr, num, target,
                        i + 1, value + curr, curr);

                backtrack(ans, expr + "-" + currStr, num, target,
                        i + 1, value - curr, -curr);

                backtrack(ans, expr + "*" + currStr, num, target,
                        i + 1,
                        value - prev + prev * curr,
                        prev * curr);
            }
        }
    }
}