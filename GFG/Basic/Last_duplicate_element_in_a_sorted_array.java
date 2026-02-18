package GFG.Basic;

/* You are given a sorted array arr[] that may contain duplicate elements. Your task is to find the index of the last occurrence of any duplicate element and return the index along with the value of that element. If no duplicate element is found, return [-1, -1].

Examples :

Input: arr[] = [1, 5, 5, 6, 6, 7]
Output: [4, 6]
Explanation: Last duplicate element is 6 having index 4.
Input: arr[] = [1, 2, 3, 4, 5]
Output: [-1, -1]
Explanation: No duplicate elements are present in the array.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 106

*/
class Solution {
    public int[] dupLastIndex(int[] arr) {
        int n = arr.length;

        for (int i = n - 1; i > 0; i--) {
            if (arr[i] == arr[i - 1]) {
                return new int[]{i, arr[i]};
            }
        }

        return new int[]{-1, -1};
    }
}
