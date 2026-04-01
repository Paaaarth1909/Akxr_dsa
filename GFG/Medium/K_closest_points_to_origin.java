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
    public static ArrayList<ArrayList<Integer>> kClosest(
        ArrayList<ArrayList<Integer>> points, int K) {
        
        PriorityQueue<ArrayList<Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                long d1 = 1L * a.get(0) * a.get(0) + 1L * a.get(1) * a.get(1);
                long d2 = 1L * b.get(0) * b.get(0) + 1L * b.get(1) * b.get(1);
                
                if(d1 != d2)
                    return Long.compare(d2, d1); // reverse (max heap)
                
                if(!a.get(0).equals(b.get(0)))
                    return Integer.compare(b.get(0), a.get(0));
                
                return Integer.compare(b.get(1), a.get(1));
            }
        );
        
        for(ArrayList<Integer> p : points){
            maxHeap.add(p);
            
            if(maxHeap.size() > K){
                maxHeap.poll();
            }
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(maxHeap);
        
        // FINAL SORT (required for output format)
        Collections.sort(res, (a, b) -> {
            long d1 = 1L * a.get(0) * a.get(0) + 1L * a.get(1) * a.get(1);
            long d2 = 1L * b.get(0) * b.get(0) + 1L * b.get(1) * b.get(1);
            
            if(d1 != d2)
                return Long.compare(d1, d2);
            
            if(!a.get(0).equals(b.get(0)))
                return Integer.compare(a.get(0), b.get(0));
            
            return Integer.compare(a.get(1), b.get(1));
        });
        
        return res;
    }
}