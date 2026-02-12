package GFG.Hard;

/* You are given a histogram represented by an array arr[ ], where each element of the array denotes the height of the bars in the histogram. All bars have the same width of 1 unit.

Your task is to find the largest rectangular area possible in the given histogram, where the rectangle can be formed using a number of contiguous bars.

Examples:

Input: arr[] = [60, 20, 50, 40, 10, 50, 60]
 Largest-Rectangular-Area-in-a-Histogram
Output: 100
Explanation: We get the maximum by picking bars highlighted above in green (50, and 60). The area is computed (smallest height) * (no. of the picked bars) = 50 * 2 = 100.
Input: arr[] = [3, 5, 1, 7, 5, 9]
Output: 15
Explanation:  We get the maximum by picking bars 7, 5 and 9. The area is computed (smallest height) * (no. of the picked bars) = 5 * 3 = 15.
Input: arr[] = [3]
Output: 3
Explanation: In this example the largest area would be 3 of height 3 and width 1.
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 104

*/
import java.util.*;

class Solution {
    public static int getMaxArea(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = arr.length;

        for (int i = 0; i <= n; i++) {

            // Treat end as height 0 to empty stack
            int currHeight = (i == n) ? 0 : arr[i];

            while (!stack.isEmpty() && currHeight < arr[stack.peek()]) {
                int height = arr[stack.pop()];

                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
