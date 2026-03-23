package LEETCODE.MEDIUM;

/* Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



     public class Binary_tree_level_order_traversal_102 {
      int val;
      Binary_tree_level_order_traversal_102 left;
      Binary_tree_level_order_traversal_102 right;
      Binary_tree_level_order_traversal_102() {}
      Binary_tree_level_order_traversal_102(int val) { this.val = val; }
      Binary_tree_level_order_traversal_102(int val, Binary_tree_level_order_traversal_102 left, Binary_tree_level_order_traversal_102 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public List<List<Integer>> levelOrder(Binary_tree_level_order_traversal_102 root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Binary_tree_level_order_traversal_102> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Binary_tree_level_order_traversal_102 node = q.poll();
                level.add(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            res.add(level);
        }

        return res;
    }
}