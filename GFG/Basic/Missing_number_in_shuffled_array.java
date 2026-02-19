package GFG.Basic;

/* Given an array arr1. The contents of arr are copied into another array arr2 and numbers are shuffled. Also, one element is removed from arr2. The task is to find the missing element.

Examples:
Input: arr1[] = [4, 8, 1, 3, 7] and arr2[] = [7, 4, 3, 1]
Output: 8
Explanation: 8 is the only element missing from arr2.
Input: arr1[] = [12, 10, 15, 23, 11, 30] and arr2[] = [15, 12, 23, 11, 30]
Output: 10
Explanation: 10 is the only element missing from arr2.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
2 <= arr1.size() <= 106
arr2.size() = arr1.size() - 1
1 <= arr[i] <= 106

*/
// User function Template for Java

class Solution {

    public int findMissing(int[] arr1, int[] arr2) {
        int xor = 0;

        for (int x : arr1) {
            xor ^= x;
        }

        for (int x : arr2) {
            xor ^= x;
        }

        return xor;
    }
}