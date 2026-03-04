package GFG.Basic;

/* Consider an integer array arr of length n. Find the number of distinct special integers in the arr. An integer i is called as a special integer if all of i-1, i and i+1 are present in the arr.

Example 1:
Input:
n = 5
arr = {1,2,3,3,4}
Output: 2
Explanation: 
The special integers in this arr are 2 and 3.
Example 2:
Input:
n = 4
arr = {2,3,5,7}
Output: 0
Explanation: 
There is no special integer in this arr.

Your Task: You have to complete the function specialIntegers() which takes integer n and an array arr of length n as input, and return the number of distinct special integers in the arr.
Constraints:
1 <= n <= 105
-109 <= arr[i] <= 109 
*/
import java.util.*;

class Solution {
    public static int specialIntegers(int n, int[] arr) {
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : arr) {
            set.add(num);
        }
        
        int count = 0;
        
        for (int num : set) {
            if (set.contains(num - 1) && set.contains(num + 1)) {
                count++;
            }
        }
        
        return count;
    }
}