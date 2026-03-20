/* Given the root of a binary tree, return the preorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]

Output: [1,2,3]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [1,2,4,5,6,7,3,8,9]

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


  public class BInary_tree_preorder_traversal {
      int val;
      BInary_tree_preorder_traversal left;
      BInary_tree_preorder_traversal right;
      BInary_tree_preorder_traversal() {}
      BInary_tree_preorder_traversal(int val) { this.val = val; }
      BInary_tree_preorder_traversal(int val, BInary_tree_preorder_traversal left, BInary_tree_preorder_traversal right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public List<Integer> preorderTraversal(BInary_tree_preorder_traversal root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(BInary_tree_preorder_traversal node, List<Integer> res) {
        if (node == null) return;

        res.add(node.val);
        preorder(node.left, res);
        preorder(node.right, res);
    }
}
