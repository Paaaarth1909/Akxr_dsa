package GFG.Medium;

/* Given an array arr[] of n integers and a 2D array queries[][] representing q queries, where each queries[i] consists of three integers: l, r, and x. For each query determine how many times the element x appears in the arr[] from index l to r (both inclusive).

Return a list of integers where the i-th value represents the answer to the i-th query.

Examples: 

Input: arr[] = [1, 2, 1, 3, 1, 2, 3], queries[][] = [[0, 4, 1], [2, 5, 2], [1, 6, 3], [0, 6, 5]]
Output: [3, 1, 2, 0]
Explanation:
query [0, 4, 1] -> Subarray = [1, 2, 1, 3, 1], 1 appears 3 times
query [2, 5, 2] -> Subarray = [1, 3, 1, 2], 2 appears 1 time
query [1, 6, 3] -> Subarray = [2, 1, 3, 1, 2, 3] 3 appears 2 times
query [0, 6, 5] -> Subarray = [1, 2, 1, 3, 1, 2, 3],  5 appears 0 times
Input: arr[] = [11, 21, 51, 101, 11, 51], queries[][] = [[0, 4, 11], [2, 5, 51]]
Output: [2, 2]
Explanation:
query [0, 4, 11] -> Subarray = [11, 21, 51, 101, 11], 11 appears 2 times
query [2, 5, 51] -> Subarray = [51, 101, 11, 51], 51 appears 2 times
Constraints:
1 ≤ arr.size(), queries.size() ≤ 105
1 ≤ arr[i], queries[i][2] ≤ 105
0 ≤ queries[i][0] ≤ queries[i][1] < arr.size()

*/
import java.util.*;

class Solution {

    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {

         HashMap<Integer, ArrayList<Integer>> map =
            new HashMap<>();

        int n = arr.length;

        for(int i = 0; i < n; i++) {

            map.putIfAbsent(arr[i], new ArrayList<>());

            map.get(arr[i]).add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(int[] q : queries) {

            int l = q[0];
            int r = q[1];
            int x = q[2];

            if(!map.containsKey(x)) {
                ans.add(0);
                continue;
            }

            ArrayList<Integer> list = map.get(x);

            int left = lowerBound(list, l);
            int right = upperBound(list, r);

            ans.add(right - left);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> list,
                           int target) {

        int low = 0, high = list.size();

        while(low < high) {

            int mid = low + (high - low) / 2;

            if(list.get(mid) < target) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        return low;
    }

    private int upperBound(ArrayList<Integer> list,
                           int target) {

        int low = 0, high = list.size();

        while(low < high) {

            int mid = low + (high - low) / 2;

            if(list.get(mid) <= target) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        return low;
    }
}