package GFG.Hard;

/* Given a string s consisting of lowercase letters and parentheses '(' and ')'.

A string is considered valid if:

Every opening parenthesis '(' has a corresponding closing parenthesis ')'.
Parentheses are properly nested.
Remove the minimum number of invalid parentheses from s so that the resulting string becomes valid.  Return all the possible distinct valid strings in lexicographically sorted order.

Examples :

Input:  = "()())()"
Output: ["(())()", "()()()"]
Explanation: 
The string "()())()" has one extra ')', making it invalid. By removing one ')', we can make it valid in two ways:
Remove the 3rd index ')' -> "(())()"
Remove the 4th index ')' -> "()()()"
Both are valid and require the minimum removals.
Input: s = "(a)())()"
Output: ["(a())()", "(a)()()"]
Explanation: 
We remove one ')' (minimum removals) to make it valid. Possible valid results:
Remove a ')' -> "(a())()"
Remove another ')' -> "(a)()()"
Input: s = ")("
Output: [""]
Explanation: The string ")(" is invalid. Removing both parentheses (minimum removals) gives an empty string "", which is valid.
Constraints:
1 ≤ |s| ≤ 20
s consists of lowercase English letters and parentheses '(' and ')'

*/
import java.util.*;

class Solution {
    
    public List<String> validParenthesis(String s) {
        
        List<String> res = new ArrayList<>();
        
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        
        q.offer(s);
        visited.add(s);
        
        boolean found = false;
        
        while(!q.isEmpty()){
            
            String curr = q.poll();
            
            // check valid
            if(isValid(curr)){
                res.add(curr);
                found = true;
            }
            
            // stop deeper levels once found
            if(found) continue;
            
            for(int i = 0; i < curr.length(); i++){
                
                char ch = curr.charAt(i);
                
                // remove only parentheses
                if(ch != '(' && ch != ')') continue;
                
                String next = curr.substring(0, i) +
                              curr.substring(i + 1);
                
                if(!visited.contains(next)){
                    visited.add(next);
                    q.offer(next);
                }
            }
        }
        
        Collections.sort(res);
        return res;
    }
    
    private boolean isValid(String s){
        
        int count = 0;
        
        for(char ch : s.toCharArray()){
            
            if(ch == '('){
                count++;
            }
            else if(ch == ')'){
                
                if(count == 0) return false;
                count--;
            }
        }
        
        return count == 0;
    }
}