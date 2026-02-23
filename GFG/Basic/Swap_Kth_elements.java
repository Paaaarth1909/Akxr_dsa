package GFG.Basic;

/* Given an array arr[], swap the kth element from the beginning with the kth element from the end.

Note: 1-based indexing is followed.

Examples :

Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8], k = 3
Output: [1, 2, 6, 4, 5, 3, 7, 8]
Explanation: 3rd element from beginning is 3 and 3rd element from end is 6, so we replace 3 & 6.
Input: arr[] = [5, 3, 6, 1, 2], k = 2
Output: [5, 1, 6, 3, 2]
Explanation: 2nd element from beginning is 3 and from end is 1.
Constraints:
1 ≤ arr.size(), k ≤ 106
-109 ≤ arr[i] ≤ 109

*/

import java.util.List;

class Solution {
    public void swapKth(List<Integer> arr, int k) {
        
        int n = arr.size();
        
        // Invalid case
        if (k > n) return;
        
        int firstIndex = k - 1;
        int secondIndex = n - k;
        
        // If both indices are same, no need to swap
        if (firstIndex == secondIndex) return;
        
        // Swap
        int temp = arr.get(firstIndex);
        arr.set(firstIndex, arr.get(secondIndex));
        arr.set(secondIndex, temp);
    }
}