package GFG.Medium;

/* Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target. 

Examples:

Input: root = [7, 3, 8, 2, 4, N, 9], target = 12
       bst
Output: True
Explanation: In the binary tree above, there are two nodes (8 and 4) that add up to 12.
Input: root = [9, 5, 10, 2, 6, N, 12], target = 23
          bst-3
Output: False
Explanation: In the binary tree above, there are no such two nodes exists that add up to 23.
Constraints:

1 ≤ Number of Nodes ≤ 105
1 ≤ target ≤ 106

*/
import java.util.*;

class Solution {
    
    HashSet<Integer> set = new HashSet<>();
    
    boolean findTarget(Node root, int target) {
        return dfs(root, target);
    }
    
    boolean dfs(Node node, int target){
        
        if(node == null)
            return false;
        
        if(set.contains(target - node.data))
            return true;
        
        set.add(node.data);
        
        return dfs(node.left, target) || dfs(node.right, target);
    }
}