package GFG.Easy;

/* Given two integer arrays a and b, the task is to find the numbers which are present in the first array a, but not present in the second array b.

Note: Numbers to be returned should in order as they appear in array a.

Examples :

Input: a[] = [1, 2, 3, 4, 5, 10], b[] = [2, 3, 1, 0, 5]
Output: [4, 10]
Explanation: 4 and 10 are present in first array, but not in second array.
Input: a[] = [4, 3, 5, 9, 11], b[] = [4, 9, 3, 11, 10]
Output: [5]  
Explanation: Second array does not contain element 5.
Input: a[] = [9], b[] = [7, 9, 4, 9, 9, 9]
Output: []  
Constraints:
1 <= a.size(), b.size() <= 105
1 <= a[i] <= 105
1 <= b[i] <= 105

*/
import java.util.*;

class Solution {
    ArrayList<Integer> findMissing(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int x : b) {
            set.add(x);
        }

        for (int x : a) {
            if (!set.contains(x)) {
                res.add(x);
            }
        }

        return res;
    }
}
