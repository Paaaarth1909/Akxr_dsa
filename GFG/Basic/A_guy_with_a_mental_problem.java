package GFG.Basic;

/* A person needs to reach home by train but compulsively switches trains at every station. If they start with train arr1 at the first station, they will switch to train arr2 at the next station, and then switch back to train arr1 at the following station, and so on. Similarly, if they start with train arr2, they will switch to train arr1 at the next station, and continue alternating.

Given two arrays, arr1 and arr2, where:

arr1[i] represents the time taken by train arr1 at station i.
arr2[i] represents the time taken by train arr2 at station i.
Determine the minimum total time required to reach home starting from either train arr1 or train arr2, with the switching pattern maintained.

Examples:
Input: arr1 = [2, 1, 2], arr2 = [3, 2, 1]
Output: 5
Explanation: Starting with train arr2 yields the minimum total time of 5.
Input: arr1 = [1, 3, 1, 2] arr2 = [2, 2, 3, 1]
Output: 5
Explanation: Starting with train arr1 yields the minimum total time of 5.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints
1 ≤ arr1.size(), arr2.size() ≤ 106
1 ≤ arr1[i], arr2[i] ≤ 106

*/
class Solution {
    public int minTime(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        
        long startWithArr1 = 0;
        long startWithArr2 = 0;
        
        for (int i = 0; i < n; i++) {
            
            if (i % 2 == 0) {
                startWithArr1 += arr1[i];
                startWithArr2 += arr2[i];
            } else {
                startWithArr1 += arr2[i];
                startWithArr2 += arr1[i];
            }
        }
        
        return (int)Math.min(startWithArr1, startWithArr2);
    }
}