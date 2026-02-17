package GFG.Basic;

/* You are given an array arr[] having unique elements. Your task is to return the type of array.
Note: The array can be categorized into ascending, descending, descending rotated and ascending rotated followed by:

Return 1 if the array is in ascending order
Return 2 if the array is in descending order
Return 3 if the array is in descending rotated order
Return 4 if the array is in ascending rotated order
Examples:

Input: arr[] = [2, 1, 5, 4, 3]
Output: 3
Explanation: Descending rotated, rotate 2 times left.
Input: arr[] = [3, 4, 5, 1, 2]
Output: 4
Explanation: Ascending rotated, rotate 2 times right. 
Constraints:
3 <= arr.size() <= 105
1 <= arr[i] <= 106

*/
class Solution {
    int maxNtype(int arr[]) {
        int n = arr.length;
        int inc = 0, dec = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) inc++;
            else dec++;
        }

        if (dec == 0) return 1;   // ascending
        if (inc == 0) return 2;   // descending

        // Rotated cases
        if (dec == 1 && arr[n - 1] < arr[0]) return 4;  // ascending rotated
        if (inc == 1 && arr[n - 1] > arr[0]) return 3;  // descending rotated

        return -1; // fallback (shouldn't happen per constraints)
    }
}
