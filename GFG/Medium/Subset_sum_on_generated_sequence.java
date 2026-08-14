package GFG.Medium;
/* There are n children standing in a queue, each assigned a number arr[i]. The teacher writes s on a paper and gives it to the first child.

Each child writes the sum of all numbers already on the paper and arr[i], then passes it to the next child.

Return true if x can be formed by adding some of the numbers written on the paper: else return false.

Input: arr[] = [1, 2, 4, 2], s = 1, x = 7
Output: true
Explanation: The first student gets 1 on paper and writes 2. The second student gets [1, 2] and writes 5. The third student gets [1, 2, 5] and writes 12. The final sequence of numbers on the paper is 1, 2, 5, 12, 22. Using 2 and 5 we can form 7. 
Input: arr[] = [51, 88], s = 100, x = 500
Output: false
Explanation: The final sequence of numbers on the paper is 100, 151, 339. Using these numbers we cannot form 500. 
Constraints:

1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 109
1 ≤ s ≤ 109
0 ≤ x ≤ 109
*/
import java.util.*;

 class Solution {
     public boolean isPossible(int[] arr, int s, int x) {

         ArrayList<Long> nums = new ArrayList<>();

         long sum = s;
         nums.add(sum);

         for (int a : arr) {
             long next = sum + a;

             if (next > x) {
                 break;
             }

             nums.add(next);
             sum += next;
         }

         if (x == 0) {
             return true;
         }

         int n = nums.size();
         int mid = n / 2;

         HashSet<Long> set = new HashSet<>();

         for (int mask = 0; mask < (1 << mid); mask++) {
             long sum1 = 0;

             for (int i = 0; i < mid; i++) {
                 if ((mask & (1 << i)) != 0) {
                     sum1 += nums.get(i);
                 }
             }

             if (sum1 == x) {
                 return true;
             }

             set.add(sum1);
         }

         int right = n - mid;

         for (int mask = 0; mask < (1 << right); mask++) {
             long sum2 = 0;

             for (int i = 0; i < right; i++) {
                 if ((mask & (1 << i)) != 0) {
                     sum2 += nums.get(mid + i);
                 }
             }

             if (set.contains((long) x - sum2)) {
                 return true;
             }
         }

         return false;
     }
 }