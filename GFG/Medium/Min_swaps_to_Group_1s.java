package GFG.Medium;

/* You are given a binary array arr[] consisting only of 0s and 1s. Determine the minimum number of swaps required to group all the 1s together in a contiguous subarray.

A swap operation allows you to choose any two indices i and j and exchange their values (i.e., swap(arr[i], arr[j])).

If the array contains no 1s, return -1.

Examples:

Input: arr[] = [1, 0, 1, 0, 1]
Output: 1
Explanation: Only 1 swap is required to group all 1's together. Swapping index 1 and 4 will give arr[] = [1, 1, 1, 0, 0].
Input: arr[] = [1, 0, 1, 0, 1, 1] 
Output: 1
Explanation: Only 1 swap is required to group all 1's together. Swapping index 0 and 3 will give arr[] = [0, 0, 1, 1, 1, 1].
Input: arr[] = [0, 0, 0]
Output: -1
Explanation: No 1s are present in the array, so return -1.
Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 1

*/
class Solution {
    public int minSwaps(int[] arr) {
        
        int n = arr.length;
        
        // Step 1: count total 1s
        int k = 0;
        for(int num : arr){
            if(num == 1) k++;
        }
        
        // if no 1s
        if(k == 0) return -1;
        
        // Step 2: sliding window
        int currOnes = 0;
        
        // first window
        for(int i = 0; i < k; i++){
            if(arr[i] == 1) currOnes++;
        }
        
        int maxOnes = currOnes;
        
        // slide window
        for(int i = k; i < n; i++){
            
            if(arr[i] == 1) currOnes++;
            if(arr[i - k] == 1) currOnes--;
            
            maxOnes = Math.max(maxOnes, currOnes);
        }
        
        // Step 3: result
        return k - maxOnes;
    }
}