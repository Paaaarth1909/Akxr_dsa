package GFG.Medium;

/* You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.

Note : If no such substring exists, return -1. 

Examples:

Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters.
Input: s = "aabaaab", k = 2
Output: 7
Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.
Constraints:
1 ≤ s.size() ≤ 105
1 ≤ k ≤ 26

*/
import java.util.*;

class Solution {
    public int longestKSubstr(String s, int k) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        int maxLen = -1;
        
        for (int right = 0; right < s.length(); right++) {
            
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            // Shrink window if distinct chars > k
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                
                if (map.get(leftChar) == 0)
                    map.remove(leftChar);
                
                left++;
            }
            
            // Update answer if exactly k distinct
            if (map.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen;
    }
}