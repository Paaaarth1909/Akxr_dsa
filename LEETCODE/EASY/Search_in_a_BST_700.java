/* You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

 

Example 1:


Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
Example 2:


Input: root = [4,2,7,1,3], val = 5
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 107
root is a binary search tree.
1 <= val <= 107
*/

  public class Search_in_a_BST_700 {
      int val;
      Search_in_a_BST_700 left;
      Search_in_a_BST_700 right;
      Search_in_a_BST_700() {}
      Search_in_a_BST_700(int val) { this.val = val; }
      Search_in_a_BST_700(int val, Search_in_a_BST_700 left, Search_in_a_BST_700 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public Search_in_a_BST_700 searchBST(Search_in_a_BST_700 root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
} 
