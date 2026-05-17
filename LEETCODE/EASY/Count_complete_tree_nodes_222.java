/* Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

 

Example 1:


Input: root = [1,2,3,4,5,6]
Output: 6
Example 2:

Input: root = []
Output: 0
Example 3:

Input: root = [1]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [0, 5 * 104].
0 <= Node.val <= 5 * 104
The tree is guaranteed to be complete.
*/

  public class Count_complete_tree_nodes_222 {
      int val;
      Count_complete_tree_nodes_222 left;
      Count_complete_tree_nodes_222 right;
      Count_complete_tree_nodes_222() {}
      Count_complete_tree_nodes_222(int val) { this.val = val; }
      Count_complete_tree_nodes_222(int val, Count_complete_tree_nodes_222 left, Count_complete_tree_nodes_222 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public int countNodes(Count_complete_tree_nodes_222 root) {
        if (root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        // Perfect binary tree
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        // Otherwise recurse
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(Count_complete_tree_nodes_222 node) {
        int height = 0;

        while (node != null) {
            height++;
            node = node.left;
        }

        return height;
    }

    private int getRightHeight(Count_complete_tree_nodes_222 node) {
        int height = 0;

        while (node != null) {
            height++;
            node = node.right;
        }

        return height;
    }
}