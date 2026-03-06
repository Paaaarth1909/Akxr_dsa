package GFG.Hard;

/* Given two strings s and p. Find the smallest substring in s consisting of all the characters (including duplicates) of the string p. Return empty string in case no such substring is present.
If there are multiple such substring of the same length found, return the one with the least starting index.

Examples:

Input: s = "timetopractice", p = "toc"
Output: "toprac"
Explanation: "toprac" is the smallest substring in which "toc" can be found.
Input: s = "zoomlazapzo", p = "oza"
Output: "apzo"
Explanation: "apzo" is the smallest substring in which "oza" can be found.
Input: s = "zoom", p = "zooe"
Output: ""
Explanation: No substring is present containing all characters of p.
Constraints: 
1 ≤ s.length(), p.length() ≤ 106
s, p consists of lowercase english letters

*/
class Solution {
    public static String minWindow(String s, String p) {
        
        int[] freq = new int[26];
        
        // Count characters of p
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int left = 0;
        int count = p.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        
        for (int right = 0; right < s.length(); right++) {
            
            char c = s.charAt(right);
            
            if (freq[c - 'a'] > 0)
                count--;
            
            freq[c - 'a']--;
            
            // When all characters matched
            while (count == 0) {
                
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']++;
                
                if (freq[leftChar - 'a'] > 0)
                    count++;
                
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}