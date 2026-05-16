package GFG.Medium;

/* Given a array arr[] of positive integers, find the smallest positive integer such that it cannot be represented as the sum of elements of any subset of the given array set.

Examples:

Input: arr[] = [3, 1, 2]
Output: 7
Explanation: 7 is the smallest positive number for which no subset is there with sum 7.
Input: arr[] = [3, 10, 9, 6, 20, 28]
Output: 1
Explanation: 1 is the smallest positive number for which no subset is there with sum 1.
Constraints
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 103
*/
import java.util.*;

class Solution {
    public int findSmallest(int[] arr) {
        
        Arrays.sort(arr);
        
        long reachable = 1;
        
        for(int num : arr) {
            
            if(num > reachable) {
                return (int)reachable;
            }
            
            reachable += num;
        }
        
        return (int)reachable;
    }
}