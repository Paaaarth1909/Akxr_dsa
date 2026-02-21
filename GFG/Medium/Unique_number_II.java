package GFG.Medium;

/* Given an array arr[] containing 2*n + 2 positive numbers, out of which 2*n numbers exist in pairs whereas only two number occur exactly once and are distinct. Find the other two numbers. Return the answer in increasing order.

Examples:

Input: arr[] = [1, 2, 3, 2, 1, 4]
Output: [3, 4] 
Explanation: 3 and 4 occur exactly once.
Input: arr[] = [2, 1, 3, 2]
Output: [1, 3]
Explanation: 1 and 3 occur exactly once.
Input: arr[] = [2, 1, 3, 3]
Output: [1, 2]
Explanation: 1 and 2 occur exactly once.
Constraints:
2 ≤ arr.size() ≤ 106 
1 ≤ arr[i] ≤ 5 * 106
arr.size() is even

*/
class Solution {
    public int[] singleNum(int[] arr) {
        
        int xor = 0;
        
        // Step 1: XOR all elements
        for (int num : arr) {
            xor ^= num;
        }
        
        // Step 2: Get rightmost set bit
        int diff = xor & (-xor);
        
        int num1 = 0, num2 = 0;
        
        // Step 3: Divide into two groups
        for (int num : arr) {
            if ((num & diff) != 0)
                num1 ^= num;
            else
                num2 ^= num;
        }
        
        // Return in increasing order
        if (num1 < num2)
            return new int[]{num1, num2};
        else
            return new int[]{num2, num1};
    }
}