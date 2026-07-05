package GFG.Easy;

/* Given a string s consisting of lowercase English letters, find the maximum number of characters between any two identical characters. If no character repeats, return -1.

Examples :

Input: s = "socks"
Output: 3
Explanation: There are 3 characters between the two occurrences of 's'.
Input: s = "for"
Output: -1
Explanation: No repeating character present.
Constraints:
1 ≤ |s| ≤ 105

*/
class Solution {
    public int maxCharGap(String s) {
        
        int[] first = new int[26];
        
        for (int i = 0; i < 26; i++) {
            first[i] = -1;
        }
        
        int ans = -1;
        
        for (int i = 0; i < s.length(); i++) {
            
            int idx = s.charAt(i) - 'a';
            
            if (first[idx] == -1) {
                first[idx] = i;
            } else {
                ans = Math.max(ans, i - first[idx] - 1);
            }
        }
        
        return ans;
    }
}