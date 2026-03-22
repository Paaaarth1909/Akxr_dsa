/* Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]

Output: [3,2,1]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [4,6,7,5,2,9,8,3,1]

Explanation:



Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]

 

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/

import java.util.ArrayList;
import java.util.List;





  public class Binary_tree_postorder_traversal_145 {
      int val;
      Binary_tree_postorder_traversal_145 left;
      Binary_tree_postorder_traversal_145 right;
      Binary_tree_postorder_traversal_145() {}
      Binary_tree_postorder_traversal_145(int val) { this.val = val; }
      Binary_tree_postorder_traversal_145(int val, Binary_tree_postorder_traversal_145 left, Binary_tree_postorder_traversal_145 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public List<Integer> postorderTraversal(Binary_tree_postorder_traversal_145 root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(Binary_tree_postorder_traversal_145 node, List<Integer> res) {
        if (node == null) return;

        postorder(node.left, res);
        postorder(node.right, res);
        res.add(node.val);
    }
}