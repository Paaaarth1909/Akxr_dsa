package GFG.Medium;

/* Given an integer k and an array of points points[][], where each point is represented as points[i] = [xi, yi] on the X-Y plane. Return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance, defined as:
distance = sqrt( (x2 - x1)2 + (y2 - y1)2 )

Note: You can return the k closest points in any order, the driver code will print them in sorted order.
Test Cases are generated such that there will be a unique ans.

Examples:

Input: k = 2, points[] = [[1, 3], [-2, 2], [5, 8], [0, 1]]
Output: [[-2, 2], [0, 1]]
Explanation: The Euclidean distances from the origin are:
Point (1, 3) = sqrt(10)
Point (-2, 2) = sqrt(8)
Point (5, 8) = sqrt(89)
Point (0, 1) = sqrt(1)
The two closest points to the origin are [-2, 2] and [0, 1].
Input: k = 1, points = [[2, 4], [-1, -1], [0, 0]]
Output: [[0, 0]]
Explanation: The Euclidean distances from the origin are:
Point (2, 4) = sqrt(20)
Point (-1, -1) = sqrt(2)
Point (0, 0) = sqrt(0)
The closest point to origin is (0, 0).
Constraints:
1 ≤ k ≤ points.size() ≤ 105
-3*104 ≤ xi, yi ≤ 3*104
*/
import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                long d1 = 1L * a[0] * a[0] + 1L * a[1] * a[1];
                long d2 = 1L * b[0] * b[0] + 1L * b[1] * b[1];
                return Long.compare(d2, d1); // max heap
            }
        );
        
        for(int[] p : points){
            maxHeap.add(p);
            
            if(maxHeap.size() > k){
                maxHeap.poll(); // remove farthest
            }
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        while(!maxHeap.isEmpty()){
            int[] p = maxHeap.poll();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(p[0]);
            temp.add(p[1]);
            res.add(temp);
        }
        
        return res;
    }
}