package GFG.Medium;

/* Given a bag of size w kg and you are provided costs of packets different weights of oranges in array cost[], find the minimum total cost to buy exactly w kg oranges

The cost of 1 kg orange is present at index 0 and in general arr[i] has cost of (i+1) kg orange.
cost[i] = -1 means that 'i+1' kg packet of orange is unavailable.
If it is not possible to buy exactly w kg oranges then return -1. It may be assumed that there is an infinite supply of all available packet types.
Examples:

Input: cost[] = [20, 10, 4, 50, 100], w = 5
Output: 14
Explanation: The minimum cost is 14 by purchasing a 2kg packet for 10 and a 3kg packet for 4.
Input: cost[] = [-1, -1, 4, 3, -1], w = 5
Output: -1
Explanation: It is not possible to buy 5 kgs.
Constraints:
1 ≤ cost.size(), w ≤ 2*103
1 ≤ cost[i] ≤ 105 
*/
import java.util.*;

class Solution {
    public int minimumCost(int[] cost, int w) {
        
        int INF = Integer.MAX_VALUE / 2;
        
        int[] dp = new int[w + 1];
        Arrays.fill(dp, INF);
        
        dp[0] = 0;
        
        int n = cost.length;
        
        for (int weight = 1; weight <= w; weight++) {
            
            for (int j = 0; j < n; j++) {
                
                int packetWeight = j + 1;
                
                if (cost[j] == -1 || packetWeight > weight) {
                    continue;
                }
                
                dp[weight] = Math.min(
                    dp[weight],
                    dp[weight - packetWeight] + cost[j]
                );
            }
        }
        
        return dp[w] >= INF ? -1 : dp[w];
    }
}