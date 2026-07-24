/* Given the root of a Binary Tree, find the length of the longest path consisting of connected nodes such that each next node has a value exactly 1 greater than its parent.

The path must move from parent to child only and follow increasing consecutive values.

If no such path exists, return -1.

Examples:

Input: root[] = [1, 2, 3]

                                
Output: 2
Explanation : Longest sequence is 1, 2. So answer for this test case is 2.
Input : root[] = [10, 20, 30, 40, N, 60, 90]

Output : -1
Explanation: For the above test case no sequence is possible. So output is -1.

Constraints:

1 ≤ no. of nodes in root ≤ 105
1 ≤ root.node->data ≤ 105
*/
/* Structure of Binary Tree Node
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
}*/
class Solution {
    
    int ans = 1;
    
    public int longestConsecutive(Node root) {
        
        if (root == null) {
            return -1;
        }
        
        dfs(root, 1);
        
        return ans == 1 ? -1 : ans;
    }
    
    void dfs(Node node, int len) {
        
        ans = Math.max(ans, len);
        
        if (node.left != null) {
            if (node.left.data == node.data + 1) {
                dfs(node.left, len + 1);
            } else {
                dfs(node.left, 1);
            }
        }
        
        if (node.right != null) {
            if (node.right.data == node.data + 1) {
                dfs(node.right, len + 1);
            } else {
                dfs(node.right, 1);
            }
        }
    }
}