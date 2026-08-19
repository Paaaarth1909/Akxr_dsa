/* Given an array arr[]  and a range from l to r, the task is to count the number of triplets having a sum in the range [l, r].

Examples :

Input: arr = [8, 3, 5, 2], l = 7, r = 11
Output: 1
Explanation: There is only one triplet [2, 3, 5] having sum 10 in range [7, 11].
Input: arr = [5, 1, 4, 3, 2], l = 2, r = 7
Output: 2
Explanation: There are two triplets having sum in range, [1,4,2] and [1,3,2].
Constraints:
1 ≤ arr.size≤ 103
1 ≤ arr[i] ≤ 103
1 ≤ l ≤ r ≤ 109

*/
import java.util.*;

 class Solution {

     public int countTriplets(int[] arr, int l, int r) {

         Arrays.sort(arr);

         return countAtMost(arr, r) - countAtMost(arr, l - 1);
     }

     int countAtMost(int[] arr, int sum) {

         int n = arr.length;
         int ans = 0;

         for (int i = 0; i < n - 2; i++) {

             int left = i + 1;
             int right = n - 1;

             while (left < right) {

                 if (arr[i] + arr[left] + arr[right] <= sum) {
                     ans += right - left;
                     left++;
                 } else {
                     right--;
                 }
             }
         }

         return ans;
     }
 }