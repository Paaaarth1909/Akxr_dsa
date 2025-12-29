/* Given an unsorted array arr[] of size n, containing elements from the range 1 to n, it is known that one number in this range is missing, and another number occurs twice in the array, find both the duplicate number and the missing number.

Examples:

Input: arr[] = [2, 2]
Output: [2, 1]
Explanation: Repeating number is 2 and the missing number is 1.
Input: arr[] = [1, 3, 3] 
Output: [3, 2]
Explanation: Repeating number is 3 and the missing number is 2.
Input: arr[] = [4, 3, 6, 2, 1, 1]
Output: [1, 5]
Explanation: Repeating number is 1 and the missing number is 5.
Constraints:
2 ≤ n ≤ 106
1 ≤ arr[i] ≤ n

 */
import java.util.*;

class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int repeating = -1, missing = -1;

        for (int i = 0; i < arr.length; i++) {
            int idx = Math.abs(arr[i]) - 1;
            if (arr[idx] < 0) {
                repeating = Math.abs(arr[i]);
            } else {
                arr[idx] = -arr[idx];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        res.add(repeating);
        res.add(missing);
        return res;
    }
}
