package GFG.Medium;

/* Given the root of a binary tree and an integer k, determine the number of downward-only paths where the sum of the node values in the path equals k.

Note: A path can start and end at any node within the tree but must always move downward (from parent to child).

Examples:

Input: root = [8, 4, 5, 3, 2, N, 2, 3, -2, N, 1], k = 7

Output: 3
Explanation: The following paths sum to k
 
Input: root = [1, 2, 3], k = 3

Output: 2 
Explanation: The following paths sum to k

Constraints:
1 ≤ number of nodes ≤ 104
-100 ≤ node value ≤ 100
-109 ≤ k ≤ 109

*/
import java.util.*;
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    
    int count = 0;
    
    public int countAllPaths(Node root, int k) {
        
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1); // base case
        
        dfs(root, 0, k, map);
        
        return count;
    }
    
    void dfs(Node node, long currSum, int k, HashMap<Long, Integer> map) {
        
        if(node == null)
            return;
        
        currSum += node.data;
        
        // check if there exists a path ending here
        if(map.containsKey(currSum - k)) {
            count += map.get(currSum - k);
        }
        
        // add current sum
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        
        // recurse
        dfs(node.left, currSum, k, map);
        dfs(node.right, currSum, k, map);
        
        // backtrack
        map.put(currSum, map.get(currSum) - 1);
    }
}