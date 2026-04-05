/* Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:

Input: root = [1,2,3,null,5,null,4]

Output: [1,3,4]

Explanation:



Example 2:

Input: root = [1,2,3,4,null,null,null,5]

Output: [1,3,4,5]

Explanation:



Example 3:

Input: root = [1,null,3]

Output: [1,3]

Example 4:

Input: root = []

Output: []

 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_tree_right_side_view_199 {
      int val;
      Binary_tree_right_side_view_199 left;
      Binary_tree_right_side_view_199 right;
      Binary_tree_right_side_view_199() {}
      Binary_tree_right_side_view_199(int val) { this.val = val; }
      Binary_tree_right_side_view_199(int val, Binary_tree_right_side_view_199 left, Binary_tree_right_side_view_199 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public List<Integer> rightSideView(Binary_tree_right_side_view_199 root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Binary_tree_right_side_view_199> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Binary_tree_right_side_view_199 node = q.poll();

                if (i == size - 1) {
                    res.add(node.val); // rightmost node
                }

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }

        return res;
    }
}