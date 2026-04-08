/* Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
*/

import java.util.Stack;


  public class Kth_smallest_element_in_a_BST_230 {
      int val;
      Kth_smallest_element_in_a_BST_230 left;
      Kth_smallest_element_in_a_BST_230 right;
      Kth_smallest_element_in_a_BST_230() {}
      Kth_smallest_element_in_a_BST_230(int val) { this.val = val; }
      Kth_smallest_element_in_a_BST_230(int val, Kth_smallest_element_in_a_BST_230 left, Kth_smallest_element_in_a_BST_230 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public int kthSmallest(Kth_smallest_element_in_a_BST_230 root, int k) {
        Stack<Kth_smallest_element_in_a_BST_230> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (--k == 0) return root.val;

            root = root.right;
        }
    }
}