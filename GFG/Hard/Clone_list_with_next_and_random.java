package GFG.Hard;

/* You are given a special linked list with n nodes where each node has two pointers a next pointer that points to the next node of the singly linked list, and a random pointer that points to the random node of the linked list.

Construct a copy of this linked list. The copy should consist of the same number of new nodes, where each new node has the value corresponding to its original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list, such that it also represent the same list state. None of the pointers in the new list should point to nodes in the original list.

Return the head of the copied linked list.

NOTE : Original linked list should remain unchanged.
Each node of the linked list is represented as a pair of [val, random_index] where:

val represents node.data.
random_index (1-based index) represents the index of the node that the random pointer of the current node points to, or NULL if it does not point to any node.
Examples:

Input: head = [[1, 3], [3, 3], [5, NULL], [9, 3]] 
   
Output: [[1, 3], [3, 3], [5, NULL], [9, 3]]
Explanation: 
Node 1 points to Node 3 as its NEXT and Node 5 as its RANDOM.
Node 3 points to Node 5 as its NEXT and Node 5 as its RANDOM.
Node 5 points to Node 9 as its NEXT and NULL as its RANDOM.
Node 9 points to NULL as its NEXT and Node 5 as its RANDOM.
Input: head = [[1, 3], [2, 1], [3, 5], [4, 3], [5, 2]]
  
Output: [[1, 3], [2, 1], [3, 5], [4, 3], [5, 2]]
Explanation: 
Node 1 points to Node 2 as its NEXT and Node 3 as its RANDOM.
Node 2 points to Node 3 as its NEXT and Node 1 as its RANDOM.
Node 3 points to Node 4 as its NEXT and Node 5 as its RANDOM.
Node 4 points to Node 5 as its NEXT and Node 3 as its RANDOM.
Node 5 points to NULL as its NEXT and Node 2 as its RANDOM.
Input: head = [[7, NULL], [7, NULL]]
Output: head = [[7, NULL], [7, NULL]]
Explanation: 
Node 7 points to Node 7 as its NEXT and NULL as its RANDOM.
Node 7 points to NULL as its NEXT and NULL as its RANDOM.
Constraints:
1 ≤ n ≤ 100
0 ≤ node->data ≤ 1000

*/

class Node {
    int data;
    Node next;
    Node arb;
    

    Node(int x) {
        data = x;
        next = null;
        arb = null;
        
    }
}

class Solution {
    public Node cloneLinkedList(Node head) {
        if (head == null) return null;

        Node curr = head;

        // Step 1: Insert cloned nodes
        while (curr != null) {
            Node copy = new Node(curr.data);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Set random pointers of cloned nodes
        curr = head;
        while (curr != null) {
    if (curr.arb != null) {
        curr.next.arb = curr.arb.next;
    } else {
        curr.next.arb = null;
    }
    curr = curr.next.next;
}


        // Step 3: Separate original and cloned list
        curr = head;
        Node cloneHead = head.next;
        Node cloneCurr = cloneHead;

        while (curr != null) {
            curr.next = curr.next.next;
            if (cloneCurr.next != null) {
                cloneCurr.next = cloneCurr.next.next;
            }
            curr = curr.next;
            cloneCurr = cloneCurr.next;
        }

        return cloneHead;
    }
}
