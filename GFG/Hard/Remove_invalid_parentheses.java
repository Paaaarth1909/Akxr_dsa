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
