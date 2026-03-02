package GFG.Basic;

/* Given an array arr of integers, the task is to count the number of elements of the array which are Fibonacci numbers

Examples:

Input: arr[] = [4, 2, 8, 5, 20, 1, 40, 13, 23]
Output: 5
Explanation: Fibonacci Numbers that are present in array are 2, 8, 5, 1, 13
Input: arr[] = [4, 7, 6, 25]
Output: 0
Explanation: No Fibonacci number in this array.
Expected Time Complexity: O(n*log(maxElement))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105

*/
class Solution {
    
    // Function to check perfect square
    private boolean isPerfectSquare(long num) {
        long sqrt = (long)Math.sqrt(num);
        return sqrt * sqrt == num;
    }
    
    // Function to check Fibonacci number
    private boolean isFibonacci(long n) {
        long val1 = 5 * n * n + 4;
        long val2 = 5 * n * n - 4;
        
        return isPerfectSquare(val1) || isPerfectSquare(val2);
    }
    
    public int countFibonacciNumbers(long[] arr) {
        
        int count = 0;
        
        for (long num : arr) {
            if (isFibonacci(num)) {
                count++;
            }
        }
        
        return count;
    }
}