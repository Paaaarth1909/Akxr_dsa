package GFG.Medium;
/* Given two arrays pre[] and preMirror[] of size n containing unique elements, where pre[] represents the preorder traversal of a full binary tree and preMirror[] represents the preorder traversal of its mirror tree, construct the original full binary tree using these traversals.

Note: A general binary tree cannot be uniquely constructed using these two traversals. However, a full binary tree can be constructed uniquely from the given traversals without any ambiguity.

Examples:

Input: pre[] = [0,1,2], preMirror[] = [0,2,1] 
Output: [0, 1, 2]
Explanation: The tree will look like

       
Input: pre[] = [1, 2, 4, 5, 3, 6, 7], preMirror[] = [1, 3, 7, 6, 2, 5, 4]
Output: [1, 2, 4, 5, 3, 6, 7]
Explanation: The tree will look like


Constraints:

1 ≤ pre.size() ≤ 105
0 ≤ pre[i] ≤ 109
1 ≤ preMirror.size() ≤ 105
0 ≤ preMirror[i] ≤ 109
*/
/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

import java.util.*;

class Solution {
    int idx;

    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        int n = pre.length;
        idx = 0;

        HashMap<Integer, Integer> pos = new HashMap<>();

        for (int i = 0; i < n; i++) {
            pos.put(preMirror[i], i);
        }

        return build(pre, preMirror, 0, n - 1, pos);
    }

    private Node build(int[] pre, int[] preMirror, int l, int r,
                       HashMap<Integer, Integer> pos) {

        if (idx >= pre.length || l > r) {
            return null;
        }

        Node root = new Node(pre[idx++]);

        if (l == r || idx >= pre.length) {
            return root;
        }

        int p = pos.get(pre[idx]);

        if (p <= r) {
            root.left = build(pre, preMirror, p, r, pos);
            root.right = build(pre, preMirror, l + 1, p - 1, pos);
        }

        return root;
    }
}