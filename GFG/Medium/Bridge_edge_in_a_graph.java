package GFG.Medium;

/* Given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u,v] represents the edge between the vertices u and v. Determine whether a specific edge between two vertices (c, d) is a bridge.

Note:

An edge is called a bridge if removing it increases the number of connected components of the graph.
if there’s only one path between c and d (which is the edge itself), then that edge is a bridge.
Examples :

Input: V = 4, edges[][] = [[0, 1], [1, 2], [2, 3]], c = 1, d = 2

Output: true
Explanation: From the graph, we can clearly see that blocking the edge 1-2 will result in disconnection of the graph.
Hence, it is a Bridge.
Input: V = 5, edges[][] = [[0, 1], [0, 3], [1, 2], [2, 0], [3, 4]], c = 0, d = 2
 
Output: false
Explanation:
 
Blocking the edge between nodes 0 and 2 won't affect the connectivity of the graph.
So, it's not a Bridge Edge. All the Bridge Edges in the graph are marked with a green line in the above image.
Constraints:
1 ≤ V, E ≤ 105
0 ≤ c, d ≤ V-1

*/
import java.util.*;

class Solution {
    
    int time = 0;
    boolean isBridgeFound = false;

    public boolean isBridge(int V, int[][] edges, int c, int d) {
        
        // Step 1: build graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        
        // 🔥 FIX: run DFS for all components
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, -1, adj, tin, low, visited, c, d);
            }
        }
        
        return isBridgeFound;
    }
    
    void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj,
             int[] tin, int[] low, boolean[] visited, int c, int d){
        
        visited[node] = true;
        tin[node] = low[node] = time++;
        
        for(int neighbor : adj.get(node)){
            
            if(neighbor == parent) continue;
            
            if(!visited[neighbor]){
                
                dfs(neighbor, node, adj, tin, low, visited, c, d);
                
                low[node] = Math.min(low[node], low[neighbor]);
                
                // 🔥 Bridge condition
                if(low[neighbor] > tin[node]){
                    
                    if((node == c && neighbor == d) || 
                       (node == d && neighbor == c)){
                        isBridgeFound = true;
                    }
                }
            }
            else{
                low[node] = Math.min(low[node], tin[neighbor]);
            }
        }
    }
}