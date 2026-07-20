package GFG.Hard;
/* Given an array of strings arr[ ], find the shortest prefix of each string that uniquely identifies it among all strings in the array. A prefix is unique if it is not a prefix of any other string in the array.

Note: No string in the given array is a prefix of another string.

Examples :

Input: arr[] = ["zebra", "dog", "duck", "dove"]
Output: ["z", "dog", "du", "dov"]
Explanation: z => zebra, dog => dog, duck => du, dove => dov 
Input: arr[] = ["geeksgeeks", "geeksquiz", "geeksforgeeks"]
Output: ["geeksg", "geeksq", "geeksf"]
Explanation: geeksgeeks => geeksg, geeksquiz => geeksq, geeksforgeeks => geeksf
Constraints:

1 ≤ |arr| ≤ 1000
1 ≤ |arr[i]| ≤ 1000
*/

import java.util.ArrayList;

class Solution {
    
    class Node {
        Node[] next = new Node[26];
        int count = 0;
    }
    
    public ArrayList<String> findPrefixes(String[] arr) {
        
        Node root = new Node();
        
        for (String s : arr) {
            Node cur = root;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (cur.next[idx] == null) {
                    cur.next[idx] = new Node();
                }
                cur = cur.next[idx];
                cur.count++;
            }
        }
        
        ArrayList<String> ans = new ArrayList<>();
        
        for (String s : arr) {
            Node cur = root;
            StringBuilder sb = new StringBuilder();
            
            for (char c : s.toCharArray()) {
                cur = cur.next[c - 'a'];
                sb.append(c);
                if (cur.count == 1) {
                    break;
                }
            }
            
            ans.add(sb.toString());
        }
        
        return ans;
    }
}