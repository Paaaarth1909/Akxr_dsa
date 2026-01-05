/* Given two arrays a[] and b[], your task is to determine whether b[] is a subset of a[].

Examples:

Input: a[] = [11, 7, 1, 13, 21, 3, 7, 3], b[] = [11, 3, 7, 1, 7]
Output: true
Explanation: b[] is a subset of a[]
Input: a[] = [1, 2, 3, 4, 4, 5, 6], b[] = [1, 2, 4]
Output: true
Explanation: b[] is a subset of a[]
Input: a[] = [10, 5, 2, 23, 19], b[] = [19, 5, 3]
Output: false
Explanation: b[] is not a subset of a[]
Constraints:
1 <= a.size(), b.size() <= 105
1 <= a[i], b[j] <= 106

*/
import java.util.*;

class Solution {
    public boolean isSubset(int a[], int b[]) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int x : a) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for (int x : b) {
            if (!freq.containsKey(x) || freq.get(x) == 0) {
                return false;
            }
            freq.put(x, freq.get(x) - 1);
        }

        return true;
    }
}
