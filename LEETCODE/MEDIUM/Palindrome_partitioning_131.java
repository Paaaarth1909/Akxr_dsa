/* Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(0, s, new ArrayList<>(), res);
        return res;
    }

    void dfs(int idx, String s, List<String> cur, List<List<String>> res) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPal(s, idx, i)) {
                cur.add(s.substring(idx, i + 1));
                dfs(i + 1, s, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    boolean isPal(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}