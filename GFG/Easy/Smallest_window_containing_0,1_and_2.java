package GFG.Easy;

/* Given a string s consisting only of the characters '0', '1' and '2', determine the length of the smallest substring that contains all three characters at least once.

If no such substring exists, return -1.

Examples :

Input: s = "10212"
Output: 3
Explanation: The substring "102" is the shortest substring that contains all three characters '0', '1', and '2', so the answer is 3.
Input: s = "12121"
Output: -1
Explanation: The character '0' is not present in the string, so no substring can contain all three characters '0', '1', and '2'. Hence, the answer is -1.
Constraints:
1 ≤ s.size() ≤ 105

*/
class Solution {
    public int smallestSubstring(String s) {
        
        int[] count = new int[3]; // for '0','1','2'
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        
        for(int right = 0; right < s.length(); right++){
            
            count[s.charAt(right) - '0']++;
            
            // check if window is valid
            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                
                minLen = Math.min(minLen, right - left + 1);
                
                // shrink window
                count[s.charAt(left) - '0']--;
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}