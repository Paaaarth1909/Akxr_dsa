/* A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
 
*/

 
 public class Maximum_depth_of_binary_tree_104 {
      int val;
      Maximum_depth_of_binary_tree_104 left;
      Maximum_depth_of_binary_tree_104 right;
      Maximum_depth_of_binary_tree_104() {}
      Maximum_depth_of_binary_tree_104(int val) { this.val = val; }
      Maximum_depth_of_binary_tree_104(int val, Maximum_depth_of_binary_tree_104 left, Maximum_depth_of_binary_tree_104 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  
class Solution {
    public int maxDepth(Maximum_depth_of_binary_tree_104 root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}