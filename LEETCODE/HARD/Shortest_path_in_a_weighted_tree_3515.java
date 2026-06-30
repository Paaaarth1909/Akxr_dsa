package LEETCODE.HARD;

/* You are given an integer n and an undirected, weighted tree rooted at node 1 with n nodes numbered from 1 to n. This is represented by a 2D array edges of length n - 1, where edges[i] = [ui, vi, wi] indicates an undirected edge from node ui to vi with weight wi.

You are also given a 2D integer array queries of length q, where each queries[i] is either:

[1, u, v, w'] – Update the weight of the edge between nodes u and v to w', where (u, v) is guaranteed to be an edge present in edges.
[2, x] – Compute the shortest path distance from the root node 1 to node x.
Return an integer array answer, where answer[i] is the shortest path distance from node 1 to x for the ith query of [2, x].

 

Example 1:

Input: n = 2, edges = [[1,2,7]], queries = [[2,2],[1,1,2,4],[2,2]]

Output: [7,4]

Explanation:



Query [2,2]: The shortest path from root node 1 to node 2 is 7.
Query [1,1,2,4]: The weight of edge (1,2) changes from 7 to 4.
Query [2,2]: The shortest path from root node 1 to node 2 is 4.
Example 2:

Input: n = 3, edges = [[1,2,2],[1,3,4]], queries = [[2,1],[2,3],[1,1,3,7],[2,2],[2,3]]

Output: [0,4,2,7]

Explanation:



Query [2,1]: The shortest path from root node 1 to node 1 is 0.
Query [2,3]: The shortest path from root node 1 to node 3 is 4.
Query [1,1,3,7]: The weight of edge (1,3) changes from 4 to 7.
Query [2,2]: The shortest path from root node 1 to node 2 is 2.
Query [2,3]: The shortest path from root node 1 to node 3 is 7.
Example 3:

Input: n = 4, edges = [[1,2,2],[2,3,1],[3,4,5]], queries = [[2,4],[2,3],[1,2,3,3],[2,2],[2,3]]

Output: [8,3,2,5]

Explanation:



Query [2,4]: The shortest path from root node 1 to node 4 consists of edges (1,2), (2,3), and (3,4) with weights 2 + 1 + 5 = 8.
Query [2,3]: The shortest path from root node 1 to node 3 consists of edges (1,2) and (2,3) with weights 2 + 1 = 3.
Query [1,2,3,3]: The weight of edge (2,3) changes from 1 to 3.
Query [2,2]: The shortest path from root node 1 to node 2 is 2.
Query [2,3]: The shortest path from root node 1 to node 3 consists of edges (1,2) and (2,3) with updated weights 2 + 3 = 5.
 

Constraints:

1 <= n <= 105
edges.length == n - 1
edges[i] == [ui, vi, wi]
1 <= ui, vi <= n
1 <= wi <= 104
The input is generated such that edges represents a valid tree.
1 <= queries.length == q <= 105
queries[i].length == 2 or 4
queries[i] == [1, u, v, w'] or,
queries[i] == [2, x]
1 <= u, v, x <= n
(u, v) is always an edge from edges.
1 <= w' <= 104
*/
import java.util.*;

class Solution {

    List<int[]>[] g;
    int[] tin, tout, parent, edgeWeight;
    long[] dist;
    int timer = 0;

    public int[] treeQueries(int n, int[][] edges, int[][] queries) {

        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[]{v, w});
            g[v].add(new int[]{u, w});
        }

        tin = new int[n + 1];
        tout = new int[n + 1];
        parent = new int[n + 1];
        edgeWeight = new int[n + 1];
        dist = new long[n + 1];

        dfs(1, 0, 0);

        BIT bit = new BIT(n + 2);

        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {

            if (q[0] == 1) {

                int u = q[1], v = q[2], nw = q[3];

                int child = parent[u] == v ? u : v;

                long delta = (long) nw - edgeWeight[child];
                edgeWeight[child] = nw;

                bit.add(tin[child], delta);
                bit.add(tout[child] + 1, -delta);

            } else {

                int x = q[1];

                long cur = dist[x] + bit.query(tin[x]);

                ans.add((int) cur);
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);

        return res;
    }

    void dfs(int u, int p, long d) {

        parent[u] = p;
        dist[u] = d;
        tin[u] = ++timer;

        for (int[] e : g[u]) {

            int v = e[0], w = e[1];

            if (v == p) continue;

            edgeWeight[v] = w;

            dfs(v, u, d + w);
        }

        tout[u] = timer;
    }

    static class BIT {

        long[] bit;

        BIT(int n) {
            bit = new long[n + 2];
        }

        void add(int idx, long val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        long query(int idx) {
            long res = 0;
            while (idx > 0) {
                res += bit[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }
}