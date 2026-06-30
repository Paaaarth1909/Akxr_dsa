package GFG.Hard;

/* Given two arrays a[] and b[] of size n and m respectively, find the minimum number of insertions and deletions on the array a[], required to make both the arrays identical.

Note: Array b[] is sorted and all its elements are distinct, operations can be performed at any index not necessarily at the end.

Examples :

Input: a[] = [1, 2, 5, 3, 1], b[] = [1, 3, 5]
Output: 4
Explanation:
Delete 2 from a: a[] = [1, 5, 3, 1]
Insert 3 after 1: a[] = [1, 3, 5, 3, 1]
Delete the last two elements: a[] = [1, 3, 5]
Total operations = 1 + 1 + 2 = 4.
Input: a[] = [1, 4], b[] = [1, 4]
Output : 0
Explanation: Both the Arrays are already identical.
 Constraints:
1 ≤ n, m ≤ 105
1 ≤ a[i], b[i] ≤ 105

*/
import java.util.*;

class Solution {
    public int minInsAndDel(int[] a, int[] b) {

        HashMap<Integer, Integer> pos = new HashMap<>();

        for (int i = 0; i < b.length; i++) {
            pos.put(b[i], i);
        }

        ArrayList<Integer> seq = new ArrayList<>();

        for (int x : a) {
            if (pos.containsKey(x)) {
                seq.add(pos.get(x));
            }
        }

        ArrayList<Integer> lis = new ArrayList<>();

        for (int x : seq) {

            int idx = Collections.binarySearch(lis, x);

            if (idx < 0) idx = -idx - 1;

            if (idx == lis.size()) {
                lis.add(x);
            } else {
                lis.set(idx, x);
            }
        }

        int lcs = lis.size();

        return a.length + b.length - 2 * lcs;
    }
}