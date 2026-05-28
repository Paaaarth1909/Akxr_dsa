package GFG.Medium;

/* Given a binary tree having n nodes, find the vertical sum of the nodes that are in the same vertical line. Return all sums through different vertical lines starting from the left-most vertical line to the right-most vertical line.

Examples:

Input:

  
Output: 
4 2 12 3 7
Explanation:

The tree has 5 vertical lines
Line 1 has only one node 4 => vertical sum is 4.
Line 2 has only one node 2 => vertical sum is 2.
Line-3 has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12.
Line-4 has only one node 3 => vertical sum is 3.
Line-5 has only one node 7 => vertical sum is 7.
Input:

Output: 
7 6 4 3 2 1
Explanation:
There are six vertical lines each having one node.
Constraints:
1<=n<=104
1<= Node value <= 105

*/
import java.util.*;

class Node{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}


class Solution {

    public ArrayList<Integer> verticalSum(Node root) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while(!q.isEmpty()) {

            Pair curr = q.poll();

            Node node = curr.node;
            int hd = curr.hd;

            map.put(hd, map.getOrDefault(hd, 0) + node.data);

            // left child
            if(node.left != null) {
                q.offer(new Pair(node.left, hd - 1));
            }

            // right child
            if(node.right != null) {
                q.offer(new Pair(node.right, hd + 1));
            }
        }

        return new ArrayList<>(map.values());
    }

    // helper class
    class Pair {

        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}