package GFG.Hard;

/* You are given the head of a Singly linked list. You have to reverse every k node in the linked list and return the head of the modified list.
Note: If the number of nodes is not a multiple of k then the left-out nodes at the end, should be considered as a group and must be reversed.

Examples:

Input: k = 2,
   

Output: 2 -> 1 -> 4 -> 3 -> 6 -> 5
Explanation: Linked List is reversed in a group of size k = 2.


Input: k = 4,   

Output: 4 -> 3 -> 2 -> 1 -> 6 -> 5
Explanation: Linked List is reversed in a group of size k = 4.


Constraints:
1 ≤ size of linked list ≤ 105
0 ≤ node->data ≤ 106
1 ≤ k ≤ size of linked list 
*/

class Node
{
    int data;
    Node next;
    public Object random;
    public Object arb;
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class Solution {
    public Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node curr = head;
        Node prev = null;
        Node next = null;

        int count = 0;

        // Reverse first k nodes (or remaining nodes if < k)
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // head is now the last node of this reversed group
        // connect it with the result of next groups
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        // prev is the new head of this group
        return prev;
    }
}