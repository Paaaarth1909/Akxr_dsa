/* Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Serialize_and_deserialize_binary_tree_297 {
      int val;
      Serialize_and_deserialize_binary_tree_297 left;
      Serialize_and_deserialize_binary_tree_297 right;
      Serialize_and_deserialize_binary_tree_297(int x) { val = x; }
  }

class Codec {

    // Encodes a tree to a single string (Preorder)
    public String serialize(Serialize_and_deserialize_binary_tree_297 root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(Serialize_and_deserialize_binary_tree_297 node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree
    public Serialize_and_deserialize_binary_tree_297 deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(arr));
        return deserializeHelper(q);
    }

    private Serialize_and_deserialize_binary_tree_297 deserializeHelper(Queue<String> q) {
        String val = q.poll();
        if (val.equals("null")) return null;

        Serialize_and_deserialize_binary_tree_297 node = new Serialize_and_deserialize_binary_tree_297(Integer.parseInt(val));
        node.left = deserializeHelper(q);
        node.right = deserializeHelper(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));