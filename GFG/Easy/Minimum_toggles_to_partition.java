package GFG.Easy;

/* Given an array arr[] containing only 0 and 1. Find the minimum toggles (switch from 0 to 1 or vice-versa) required such the array become partitioned, i.e., it has first 0s then 1s.

Examples:

Input: arr = [1, 0, 1, 1, 0]
Output: 2
Explaination: The changed array will be [0, 0, 1, 1, 1]. So the number of toggles here required is 2.
Input: arr = [0, 1, 0, 0, 1, 1, 1]
Output: 1
Explaination: The changed array will be [0, 0, 0, 0, 1, 1, 1]. Required toggles are 1.
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 1

*/
class Solution {
    
    int minToggle(int[] arr) {
        
        int n = arr.length;
        
        int[] prefixOnes = new int[n];
        
        prefixOnes[0] = arr[0];
        
        for(int i = 1; i < n; i++) {
            prefixOnes[i] = prefixOnes[i - 1] + arr[i];
        }
        
        int[] suffixZeros = new int[n];
        
        suffixZeros[n - 1] = (arr[n - 1] == 0 ? 1 : 0);
        
        for(int i = n - 2; i >= 0; i--) {
            
            suffixZeros[i] =
                suffixZeros[i + 1] +
                (arr[i] == 0 ? 1 : 0);
        }
        
        int ans = Integer.MAX_VALUE;
        
        
        for(int i = 0; i < n; i++) {
            
            int leftToggles =
                prefixOnes[i]; 
            
            int rightToggles =
                (i + 1 < n) ? suffixZeros[i + 1] : 0;
            
            ans = Math.min(ans,
                           leftToggles + rightToggles);
        }
        
        ans = Math.min(ans, suffixZeros[0]);
        ans = Math.min(ans, prefixOnes[n - 1]);
        
        return ans;
    }
}