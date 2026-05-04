package GFG.Easy;

/* Given an integer n, determine whether its binary representation forms a palindrome. Return true if the binary representation of n is a palindrome; otherwise, return false.

Note: A binary representation is considered a palindrome if it reads the same forward and backward.

Examples:

Input: n = 17
Output: true
Explanation: Binary representation of 17 is (10001)2, which reads the same forward and backward, so it is a palindrome. 
Input: n = 16
Output: false
Explanation: Binary representation of 16 is (10000)2, which is not a palindrome. 
Constraints:
1 ≤ n ≤ 109

*/
class Solution {
    public boolean isBinaryPalindrome(int n) {
        
        int left = 31; // max bit index
        
        // find highest set bit
        while(left >= 0 && ((n >> left) & 1) == 0){
            left--;
        }
        
        int right = 0;
        
        while(left > right){
            
            int leftBit = (n >> left) & 1;
            int rightBit = (n >> right) & 1;
            
            if(leftBit != rightBit){
                return false;
            }
            
            left--;
            right++;
        }
        
        return true;
    }
}