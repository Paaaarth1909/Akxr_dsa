package GFG.Hard;

/* Given a binary string s consists only of 0s and 1s. Calculate the number of substrings that have more 1s than 0s.

Examples:

Input: s = "011"
Output: 4
Explanation: There are 4 substring which has more 1s than 0s. i.e "011","1","11" and "1"
Input: s = "0000"
Output: 0
Explanation: There is no substring with more 1s than 0s
Constraints:
1 < |s| <  6 * 104

*/
import java.util.*;

class Solution {
    public int countSubstring(String s) {
        
        int n = s.length();
        long[] pre = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (s.charAt(i) == '1' ? 1 : -1);
        }
        
        long[] temp = pre.clone();
        Arrays.sort(temp);
        
        Map<Long, Integer> map = new HashMap<>();
        int idx = 1;
        
        for (long x : temp) {
            if (!map.containsKey(x)) {
                map.put(x, idx++);
            }
        }
        
        Fenwick bit = new Fenwick(idx);
        long ans = 0;
        
        for (long x : pre) {
            int id = map.get(x);
            
            ans += bit.query(id - 1);
            bit.update(id, 1);
        }
        
        return (int) ans;
    }
    
    static class Fenwick {
        int[] bit;
        
        Fenwick(int n) {
            bit = new int[n + 1];
        }
        
        void update(int i, int val) {
            while (i < bit.length) {
                bit[i] += val;
                i += i & -i;
            }
        }
        
        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= i & -i;
            }
            return sum;
        }
    }
}