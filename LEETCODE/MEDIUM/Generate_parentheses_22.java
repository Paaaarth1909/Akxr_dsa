/* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
 
*/

import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    void dfs(List<String> res, StringBuilder sb, int open, int close, int n) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            dfs(res, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            dfs(res, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
