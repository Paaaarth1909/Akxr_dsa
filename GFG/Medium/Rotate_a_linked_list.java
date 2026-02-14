package GFG.Medium;

/* You are given the head of a singly linked list, you have to left rotate the linked list k times. Return the head of the modified linked list.

Examples:

Input: k = 4,
   
Output: 50 -> 10 -> 20 -> 30 -> 40
Explanation:
Rotate 1: 20 -> 30 -> 40 -> 50 -> 10
Rotate 2: 30 -> 40 -> 50 -> 10 -> 20
Rotate 3: 40 -> 50 -> 10 -> 20 -> 30
Rotate 4: 50 -> 10 -> 20 -> 30 -> 40
   
Input: k = 6,
   
Output: 30 -> 40 -> 10 -> 20 
   
Constraints:
1 ≤ number of nodes ≤ 105
0 ≤ k ≤ 109
0 ≤ node.data ≤ 109

*/
/*
class Node {
    int data;
    Node next;

    Node(int d){
        data=d;
        next=null;
   }
}
*/

class Solution {
    public Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find length and tail
        Node tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // Step 2: Reduce k
        k = k % len;
        if (k == 0) return head;

        // Step 3: Find kth node
        Node curr = head;
        for (int i = 1; i < k; i++) {
            curr = curr.next;
        }

        // Step 4: Rotate
        Node newHead = curr.next;
        curr.next = null;
        tail.next = head;

        return newHead;
    }
}
