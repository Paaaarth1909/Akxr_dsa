package GFG.Hard;

import java.util.*;

/* You are given the root of a binary tree. You have to perform Serialization and Deserialization. Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree back from the array. Complete the functions:

serialize() : stores the tree into an array and returns the array.
deSerialize() : deserializes the array to the tree and returns the root of the tree.
Note: Multiple nodes can have the same data and the node values are always positive integers. Your code will be correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree. Driver code will print the level order traversal of the tree returned by deSerialize(serialize(input_tree)).

Examples :

Input: root = [1, 2, 3]       

Output: [1, 2, 3]
Input: root = [10, 20, 30, 40, 60, N, N] 

Output: [10, 20, 30, 40, 60]
Constraints:
1 ≤ number of nodes ≤ 104
1 ≤ node->data ≤ 109 
*/
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    // Serialize using BFS
    public ArrayList<Integer> serialize(Node root) {
        
        ArrayList<Integer> res = new ArrayList<>();
        
        if(root == null) return res;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            Node curr = q.poll();
            
            if(curr == null){
                res.add(-1); // mark null
                continue;
            }
            
            res.add(curr.data);
            
            q.add(curr.left);
            q.add(curr.right);
        }
        
        return res;
    }

    // Deserialize using BFS
    public Node deSerialize(ArrayList<Integer> arr) {
        
        if(arr.size() == 0) return null;
        
        Node root = new Node(arr.get(0));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        int i = 1;
        
        while(!q.isEmpty() && i < arr.size()){
            
            Node curr = q.poll();
            
            // left child
            if(arr.get(i) != -1){
                curr.left = new Node(arr.get(i));
                q.add(curr.left);
            }
            i++;
            
            // right child
            if(i < arr.size() && arr.get(i) != -1){
                curr.right = new Node(arr.get(i));
                q.add(curr.right);
            }
            i++;
        }
        
        return root;
    }
};