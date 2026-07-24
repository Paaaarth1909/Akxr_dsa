/* Given the root of a Binary Tree, find the length of the longest path consisting of connected nodes such that each next node has a value exactly 1 greater than its parent.

The path must move from parent to child only and follow increasing consecutive values.

If no such path exists, return -1.

Examples:

Input: root[] = [1, 2, 3]

                                
Output: 2
Explanation : Longest sequence is 1, 2. So answer for this test case is 2.
Input : root[] = [10, 20, 30, 40, N, 60, 90]

Output : -1
Explanation: For the above test case no sequence is possible. So output is -1.

Constraints:

1 ≤ no. of nodes in root ≤ 105
1 ≤ root.node->data ≤ 105
*/
