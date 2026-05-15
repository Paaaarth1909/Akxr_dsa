package GFG.Medium;

/* Given a special keyboard that contains only four keys:

Key 1: Prints a single character 'A' on the screen.
Key 2 (Ctrl + A): Selects all the characters currently present on the screen.
Key 3 (Ctrl + C): Copies the selected characters to a buffer.
Key 4 (Ctrl + V): Pastes the content of the buffer onto the screen, appending it to the existing text.
Initially, the screen is empty and the buffer is also empty.

Determine the maximum number of 'A' characters that can be displayed on the screen after performing exactly n key presses.

Examples :

Input: n = 3
Output: 3
Explanation: With only 3 key presses, the best option is to press Key 1 each time. So, the screen shows "AAA" and the total number of A’s is 3.
Input: n = 7
Output: 9
Explanation: An optimal sequence is: press Key 1 three times to get "AAA", then use Key 2 (select all) and Key 3 (copy), followed by Key 4 twice (paste). This results in "AAAAAAAAA", so the total number of A’s is 9.
Constraints:
1 ≤ n ≤ 70 
*/
class Solution {
    public int optimalKeys(int n) {
        
        if(n <= 6) return n;
        
        int[] dp = new int[n + 1];
        
        for(int i = 1; i <= 6; i++) {
            dp[i] = i;
        }
        
        for(int i = 7; i <= n; i++) {
            
            dp[i] = i;
            
            // try all breakpoints
            for(int j = i - 3; j >= 1; j--) {
                
                int curr = dp[j] * (i - j - 1);
                
                dp[i] = Math.max(dp[i], curr);
            }
        }
        
        return dp[n];
    }
}