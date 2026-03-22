package GFG.Medium;

/* Given the root of a binary tree, your task is to find the maximum path sum. The path may start and end at any node in the tree.

Examples:

Input: root[] = [10, 2, 10, 20, 1, N, -25, N, N, N, N, 3, 4]
Output: 42
Explanation: Max path sum is represented using green colour nodes in the above binary tree.

Input: root[] = [-17, 11, 4, 20, -2, 10]
Output: 31
Explanation: Max path sum is represented using green colour nodes in the above binary tree.

Constraints:
1 ≤ number of nodes ≤ 103
-104 ≤ node->data ≤ 104

*/
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
    
    int maxSum = Integer.MIN_VALUE;
    
    int findMaxSum(Node root) {
        dfs(root);
        return maxSum;
    }
    
    int dfs(Node node){
        
        if(node == null)
            return 0;
        
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        
        // update global answer
        maxSum = Math.max(maxSum, node.data + left + right);
        
        // return one side only
        return node.data + Math.max(left, right);
    }
}