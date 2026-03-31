/* Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_tree_zigzag_level_order_traversal_103 {
      int val;
      Binary_tree_zigzag_level_order_traversal_103 left;
      Binary_tree_zigzag_level_order_traversal_103 right;
      Binary_tree_zigzag_level_order_traversal_103() {}
      Binary_tree_zigzag_level_order_traversal_103(int val) { this.val = val; }
      Binary_tree_zigzag_level_order_traversal_103(int val, Binary_tree_zigzag_level_order_traversal_103 left, Binary_tree_zigzag_level_order_traversal_103 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public List<List<Integer>> zigzagLevelOrder(Binary_tree_zigzag_level_order_traversal_103 root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Binary_tree_zigzag_level_order_traversal_103> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                Binary_tree_zigzag_level_order_traversal_103 node = q.poll();

                if (leftToRight) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            res.add(level);
            leftToRight = !leftToRight;
        }

        return res;
    }
}