package GFG.Medium;

/* Given the root of a BST and an integer k, the task is to find the kth smallest element in the BST. If there is no kth smallest element present then return -1.

Examples:

Input: root = [20, 8, 22, 4, 12, N, N, N, N, 10, 14], k = 3
    
Output: 10
Explanation: 10 is the 3rd smallest element in the BST.
Input: root = [2, 1, 3], k = 5
    
Output: -1
Explanation: There is no 5th smallest element in the BST as the size of BST is 3.
Constraints:
1 ≤ number of nodes, k ≤ 104
1 ≤ node->data ≤ 104

*/
import java.util.*;

class Solution {
    public int kthSmallest(Node root, int k) {
        
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        
        int count = 0;
        
        while(curr != null || !stack.isEmpty()){
            
            // go left
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            count++;
            
            if(count == k)
                return curr.data;
            
            curr = curr.right;
        }
        
        return -1; // if k > number of nodes
    }
}