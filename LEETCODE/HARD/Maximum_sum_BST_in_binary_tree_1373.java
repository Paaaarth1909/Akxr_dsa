package LEETCODE.HARD;

/* Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:



Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
Output: 20
Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.
Example 2:



Input: root = [4,3,null,1,2]
Output: 2
Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.
Example 3:

Input: root = [-4,-2,-5]
Output: 0
Explanation: All values are negatives. Return an empty BST.
 

Constraints:

The number of nodes in the tree is in the range [1, 4 * 104].
-4 * 104 <= Node.val <= 4 * 104
 
*/

  public class Maximum_sum_BST_in_binary_tree_1373 {
      int val;
      Maximum_sum_BST_in_binary_tree_1373 left;
      Maximum_sum_BST_in_binary_tree_1373 right;
      Maximum_sum_BST_in_binary_tree_1373() {}
      Maximum_sum_BST_in_binary_tree_1373(int val) { this.val = val; }
      Maximum_sum_BST_in_binary_tree_1373(int val, Maximum_sum_BST_in_binary_tree_1373 left, Maximum_sum_BST_in_binary_tree_1373 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  
class Solution {

    int maxSum = 0;

    public int maxSumBST(Maximum_sum_BST_in_binary_tree_1373 root) {
        postOrder(root);
        return maxSum;
    }

    // returns: {isBST, min, max, sum}
    private int[] postOrder(Maximum_sum_BST_in_binary_tree_1373 node) {
        if (node == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);

        // Check BST validity
        if (left[0] == 1 && right[0] == 1 &&
            node.val > left[2] && node.val < right[1]) {

            int sum = left[3] + right[3] + node.val;
            maxSum = Math.max(maxSum, sum);

            int min = Math.min(node.val, left[1]);
            int max = Math.max(node.val, right[2]);

            return new int[]{1, min, max, sum};
        }

        // Not a BST
        return new int[]{0, 0, 0, 0};
    }
}