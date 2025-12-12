/* Given two arrays a[] and b[] of equal size, the task is to find whether the elements in the arrays are equal.
Two arrays are said to be equal if both contain the same set of elements, arrangements (or permutations) of elements may be different though.
Note: If there are repetitions, then counts of repeated elements must also be the same for two arrays to be equal.

Examples:

Input: a[] = [1, 2, 5, 4, 0], b[] = [2, 4, 5, 0, 1]
Output: true
Explanation: Both the array can be rearranged to [0,1,2,4,5]
Input: a[] = [1, 2, 5], b[] = [2, 4, 15]
Output: false
Explanation: a[] and b[] have only one common value.
Constraints:
1 ≤ a.size(), b.size() ≤ 107
0 ≤ a[i], b[i] ≤ 109

*/
import java.util.*;

class Solution {
    public static boolean checkEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : a) 
            map.put(x, map.getOrDefault(x, 0) + 1);

        for (int x : b) {
            if (!map.containsKey(x)) return false;

            map.put(x, map.get(x) - 1);
            if (map.get(x) < 0) return false;
        }

        return true;
    }
}