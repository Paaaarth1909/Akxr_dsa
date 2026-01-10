package GFG.Easy;

/* Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a ≤ b whose sum is closest to target.
Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.

Examples:

Input: arr[] = [10, 30, 20, 5], target = 25
Output: [5, 20]
Explanation: As 5 + 20 = 25 is closest to 25.
Input: arr[] = [5, 2, 7, 1, 4], target = 10
Output: [2, 7]
Explanation: As (4, 5), (2, 7) and (4, 7) both are closest to 10, but absolute difference of (4, 5) is 1, (2, 7) is 5 and (4, 7) is 3. Hence, [2, 7] has maximum absolute difference and closest to target. 
Input: arr[] = [10], target = 10
Output: []
Explanation: As the input array has only 1 element, return an empty array.
Constraints:
1 ≤ arr.size() ≤ 2*105
0 ≤ target ≤ 2*105
0 ≤ arr[i] ≤ 105

*/
import java.util.*;

class Solution {
    public ArrayList<Integer> sumClosest(int[] arr, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        if (n < 2) return res;

        Arrays.sort(arr);

        int l = 0, r = n - 1;
        int bestDiff = Integer.MAX_VALUE;
        int bestA = 0, bestB = 0;

        while (l < r) {
            int sum = arr[l] + arr[r];
            int diff = Math.abs(sum - target);

            if (diff < bestDiff ||
               (diff == bestDiff && Math.abs(arr[r] - arr[l]) > Math.abs(bestB - bestA))) {
                bestDiff = diff;
                bestA = arr[l];
                bestB = arr[r];
            }

            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        res.add(bestA);
        res.add(bestB);
        return res;
    }
}
