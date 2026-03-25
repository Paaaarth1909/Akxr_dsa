/* Given a binary tree, determine if it is height-balanced.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
*/

  public class Balanced_binary_tree_110 {
      int val;
      Balanced_binary_tree_110 left;
      Balanced_binary_tree_110 right;
      Balanced_binary_tree_110() {}
      Balanced_binary_tree_110(int val) { this.val = val; }
      Balanced_binary_tree_110(int val, Balanced_binary_tree_110 left, Balanced_binary_tree_110 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public boolean isBalanced(Balanced_binary_tree_110 root) {
        return height(root) != -1;
    }

    private int height(Balanced_binary_tree_110 node) {
        if (node == null) return 0;

        int left = height(node.left);
        if (left == -1) return -1;

        int right = height(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }
}