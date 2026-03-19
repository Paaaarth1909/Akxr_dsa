package GFG.Medium;

/* Given two arrays representing the inorder and preorder traversals of a binary tree, your task is to construct the binary tree and return its root.

Note: The inorder and preorder traversals contain unique values, and every value present in the preorder traversal is also found in the inorder traversal.

Examples:

Input: inorder[] = [3, 1, 4, 0, 5, 2], preorder[] = [0, 1, 3, 4, 2, 5]
Output: [0, 1, 2, 3, 4, 5]
Explanation: The tree will look like

Input: inorder[] = [2, 5, 4, 1, 3], preorder[] = [1, 4, 5, 2, 3]
Output: [1, 4, 3, 5, N, N, N, 2]
Explanation: The tree will look like

Constraints:
1 ≤ number of nodes ≤ 103
0 ≤ nodes -> data ≤ 103
Both the inorder and preorder arrays contain unique values.

*/
import java.util.*;


class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}



class Solution {

    static int preIndex = 0;
    static HashMap<Integer, Integer> map;

    public static Node buildTree(int inorder[], int preorder[]) {
        
        map = new HashMap<>();
        preIndex = 0;
        
        // store inorder indices
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return build(preorder, 0, inorder.length - 1);
    }

    static Node build(int[] preorder, int inStart, int inEnd) {
        
        if(inStart > inEnd)
            return null;
        
        // root from preorder
        int rootVal = preorder[preIndex++];
        Node root = new Node(rootVal);
        
        int inIndex = map.get(rootVal);
        
        // build left and right
        root.left = build(preorder, inStart, inIndex - 1);
        root.right = build(preorder, inIndex + 1, inEnd);
        
        return root;
    }
}