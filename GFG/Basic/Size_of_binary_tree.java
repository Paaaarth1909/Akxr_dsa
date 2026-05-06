package GFG.Basic;

/* Given the root of a binary tree, return the size of the tree. The size of a binary tree is the total number of nodes in the tree.

Examples:

Input:      

Output:  3
Explanation: There are 3 nodes in the given binary tree, so its size is 3.
Input:

Output: 6
Explanation: There are 6 nodes in the given binary tree, so its size is 6.
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105

*/

class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    public int getSize(Node root) {
        
        // base case
        if(root == null){
            return 0;
        }
        
        // count current node + left + right
        return 1 + getSize(root.left) + getSize(root.right);
    }
}