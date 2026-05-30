package LEETCODE.MEDIUM;

/* You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

 

Example 1:


Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
Example 2:

Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
 

Constraints:

1 <= n <= 200
n - 1 <= roads.length <= n * (n - 1) / 2
roads[i].length == 3
0 <= ui, vi <= n - 1
1 <= timei <= 109
ui != vi
There is at most one road connecting any two intersections.
You can reach any intersection from any other intersection.
*/
import java.util.*;

class Solution {

    static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {

        List<List<long[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            graph.get(u).add(new long[]{v, time});
            graph.get(v).add(new long[]{u, time});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        long[] ways = new long[n];

        // Min-heap: {distance, node}
        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a, b) ->
                Long.compare(a[0], b[0]));

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            long currDist = curr[0];
            int node = (int) curr[1];

            if (currDist > dist[node]) {
                continue;
            }

            for (long[] neighbor : graph.get(node)) {

                int next = (int) neighbor[0];
                long time = neighbor[1];

                long newDist = currDist + time;

                // Found shorter path
                if (newDist < dist[next]) {

                    dist[next] = newDist;

                    ways[next] = ways[node];

                    pq.offer(new long[]{
                        newDist,
                        next
                    });
                }

                // Found another shortest path
                else if (newDist == dist[next]) {

                    ways[next] =
                        (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}