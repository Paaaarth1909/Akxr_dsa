/* Given the root of a binary tree, your task is to return its Preorder traversal.

Note: A preorder traversal first visits the node, then visits the left child (including its entire subtree), and finally visits the right child (including its entire subtree).

Examples:

Input: root = [1, 4, N, 4, 2]
   
Output: [1, 4, 4, 2]
Explanation: The preorder traversal of the given binary tree is [1, 4, 4, 2]
Input: root = [6, 3, 2, N, 1, 2, N]
    
Output: [6, 3, 1, 2, 2] 
Explanation: The preorder traversal of the given binary tree is [6, 3, 1, 2, 2] 
Constraints:
1 ≤ number of nodes ≤ 3*104
0 ≤ node->data ≤ 105

*/
import java.util.ArrayList;
import java.util.Stack;

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
    public ArrayList<Integer> preOrder(Node root) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        if (root == null) {
            return ans;
        }
        
        Stack<Node> st = new Stack<>();
        st.push(root);
        
        while (!st.isEmpty()) {
            Node node = st.pop();
            ans.add(node.data);
            
            if (node.right != null) {
                st.push(node.right);
            }
            
            if (node.left != null) {
                st.push(node.left);
            }
        }
        
        return ans;
    }
}