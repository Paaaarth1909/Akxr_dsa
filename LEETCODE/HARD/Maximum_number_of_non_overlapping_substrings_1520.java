/* Given a string s of lowercase letters, you need to find the maximum number of non-empty substrings of s that meet the following conditions:

The substrings do not overlap, that is for any two substrings s[i..j] and s[x..y], either j < x or i > y is true.
A substring that contains a certain character c must also contain all occurrences of c.
Find the maximum number of substrings that meet the above conditions. If there are multiple solutions with the same number of substrings, return the one with minimum total length. It can be shown that there exists a unique solution of minimum total length.

Notice that you can return the substrings in any order.

 

Example 1:

Input: s = "adefaddaccc"
Output: ["e","f","ccc"]
Explanation: The following are all the possible substrings that meet the conditions:
[
  "adefaddaccc"
  "adefadda",
  "ef",
  "e",
  "f",
  "ccc",
]
If we choose the first string, we cannot choose anything else and we'd get only 1. If we choose "adefadda", we are left with "ccc" which is the only one that doesn't overlap, thus obtaining 2 substrings. Notice also, that it's not optimal to choose "ef" since it can be split into two. Therefore, the optimal way is to choose ["e","f","ccc"] which gives us 3 substrings. No other solution of the same number of substrings exist.
Example 2:

Input: s = "abbaccd"
Output: ["d","bb","cc"]
Explanation: Notice that while the set of substrings ["d","abba","cc"] also has length 3, it's considered incorrect since it has larger total length.
 

Constraints:

1 <= s.length <= 105
s contains only lowercase English letters.
*/
import java.util.*;

class Solution {

    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        List<int[]> list = new ArrayList<>();

        for (int c = 0; c < 26; c++) {

            if (last[c] == -1) continue;

            int l = first[c];
            int r = last[c];
            boolean ok = true;

            for (int i = l; i <= r && ok; i++) {
                int x = s.charAt(i) - 'a';
                if (first[x] < l) {
                    ok = false;
                    break;
                }
                r = Math.max(r, last[x]);
            }

            if (ok) {
                list.add(new int[]{l, r});
            }
        }

        Collections.sort(list, (a, b) -> a[1] - b[1]);

        List<String> ans = new ArrayList<>();
        int end = -1;

        for (int[] cur : list) {
            if (cur[0] > end) {
                ans.add(s.substring(cur[0], cur[1] + 1));
                end = cur[1];
            }
        }

        return ans;
    }
}