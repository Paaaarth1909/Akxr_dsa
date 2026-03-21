/* Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]

Output: [1,3,2]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [4,2,6,5,7,1,3,9,8]

Explanation:



Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]

 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

*/

import java.util.ArrayList;
import java.util.List;
public class Binary_tree_inorder_traversal_94 {
      int val;
      Binary_tree_inorder_traversal_94 left;
      Binary_tree_inorder_traversal_94 right;
      Binary_tree_inorder_traversal_94() {}
      Binary_tree_inorder_traversal_94(int val) { this.val = val; }
      Binary_tree_inorder_traversal_94(int val, Binary_tree_inorder_traversal_94 left, Binary_tree_inorder_traversal_94 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public List<Integer> inorderTraversal(Binary_tree_inorder_traversal_94 root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(Binary_tree_inorder_traversal_94 node, List<Integer> res) {
        if (node == null) return;

        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
}