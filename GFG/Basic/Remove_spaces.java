package GFG.Basic;

/* Given a string s, remove all the spaces from the string and return the modified string.

Examples:

Input: s = "g eeks for ge eks"
Output: "geeksforgeeks"
Explanation: All space characters are removed from the given string while preserving the order of the remaining characters, resulting in the final string "geeksforgeeks".
Input: s = "abc d "
Output: "abcd"
Explanation:  All space characters are removed from the given string while preserving the order of the remaining characters, resulting in the final string "abcd".
Constraints:
1 ≤ |s| ≤ 105

*/
class Solution {
    String removeSpaces(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            if(ch != ' '){
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}