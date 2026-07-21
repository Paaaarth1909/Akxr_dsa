package GFG.Medium;
/* Given a string s containing lowercase English alphabets.

Start from any index containing the character 'a' and perform jump operations.
In each jump operation, move to any index on the right side whose character is the immediate next letter of the current character in the alphabet (i.e., 'a' to 'b', 'b' to 'c', 'c' to 'd', and so on). 
Continue performing jumps until no further jump is possible.
Find the maximum possible difference between the starting index and the ending index. If it is not possible to choose a starting index, return -1.

Examples :

Input: s = "aaabcb"
Output: 5
Explanation: Start at index 0 ('a'), jump to index 5 ('b'). Difference = 5 - 0 = 5.
Input: s = "xynjir"
Output: -1
Explanation: The string does not contain any character 'a'. So, the answer is -1.
Input: s = "abcbzzd"
Output: 6
Explanation: Start from index 0 ('a'). Jump to index 1 ('b') because 'b' is the next alphabet character. Jump to index 2 ('c') because 'c' is the next character after 'b'. Jump to index 6 ('d') because 'd' is the next character after 'c'.
Constraints:
1 ≤ s.size() ≤ 105 
*/
class Solution {
    public int maxIndexDifference(String s) {
        
        int n = s.length();
        int[] best = new int[26];
        
        for (int i = 0; i < 26; i++) {
            best[i] = -1;
        }
        
        int ans = -1;
        boolean hasA = false;
        
        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';
            
            int reach = i;
            if (c < 25 && best[c + 1] != -1) {
                reach = best[c + 1];
            }
            
            best[c] = Math.max(best[c], reach);
            
            if (c == 0) {
                hasA = true;
                ans = Math.max(ans, reach - i);
            }
        }
        
        return hasA ? ans : -1;
    }
} 