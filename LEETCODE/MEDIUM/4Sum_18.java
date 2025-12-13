/* Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            long min1 = (long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
            if (min1 > target) break;

            long max1 = (long)nums[i] + nums[n-1] + nums[n-2] + nums[n-3];
            if (max1 < target) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                long min2 = (long)nums[i] + nums[j] + nums[j+1] + nums[j+2];
                if (min2 > target) break;

                long max2 = (long)nums[i] + nums[j] + nums[n-1] + nums[n-2];
                if (max2 < target) continue;

                int l = j + 1, r = n - 1;
                long newTarget = (long)target - nums[i] - nums[j];

                while (l < r) {
                    long sum = nums[l] + nums[r];
                    if (sum == newTarget) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (l < r && nums[r] == nums[r + 1]) r--;
                    } else if (sum < newTarget) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}