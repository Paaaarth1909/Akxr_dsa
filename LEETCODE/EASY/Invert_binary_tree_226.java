/* Given the root of a binary tree, invert the tree, and return its root.

 

Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/

  public class Invert_binary_tree_226 {
      int val;
      Invert_binary_tree_226 left;
      Invert_binary_tree_226 right;
      Invert_binary_tree_226() {}
      Invert_binary_tree_226(int val) { this.val = val; }
      Invert_binary_tree_226(int val, Invert_binary_tree_226 left, Invert_binary_tree_226 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public Invert_binary_tree_226 invertTree(Invert_binary_tree_226 root) {
        if (root == null) return null;

        Invert_binary_tree_226 left = invertTree(root.left);
        Invert_binary_tree_226 right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}