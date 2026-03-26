/* Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
*/

  public class Diameter_of_binary_tree_543 {
      int val;
      Diameter_of_binary_tree_543 left;
      Diameter_of_binary_tree_543 right;
      Diameter_of_binary_tree_543() {}
      Diameter_of_binary_tree_543(int val) { this.val = val; }
      Diameter_of_binary_tree_543(int val, Diameter_of_binary_tree_543 left, Diameter_of_binary_tree_543 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    int ans;
    public int diameterOfBinaryTree(Diameter_of_binary_tree_543 root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(Diameter_of_binary_tree_543 node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }
}