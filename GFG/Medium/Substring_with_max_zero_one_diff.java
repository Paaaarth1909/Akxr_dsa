package GFG.Medium;

/* Given a binary string s consisting of 0s and 1s. Find the maximum difference of the number of 0s and the number of 1s (number of 0s – number of 1s) in a substring of the string.

Note: In the case of all 1s, the answer will be -1.

Examples:

Input : s = "11000010001" 
Output : 6 
Explanatio: From index 2 to index 9, there are 7 0s and 1 1s, so number of 0s - number of 1s is 6. 
Input: s = "111111"
Output: -1
Explanation: s contains 1s only 
Constraints:
1 ≤ s.size() ≤ 105

*/
class Solution {
    int maxSubstring(String s) {
        
        int maxSoFar = -1;
        int currSum = 0;
        
        for (char ch : s.toCharArray()) {
            
            int val = (ch == '0') ? 1 : -1;
            
            currSum = Math.max(val, currSum + val);
            maxSoFar = Math.max(maxSoFar, currSum);
        }
        
        return maxSoFar;
    }
}