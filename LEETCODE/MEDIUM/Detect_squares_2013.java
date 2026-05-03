package LEETCODE.MEDIUM;

/* You are given a stream of points on the X-Y plane. Design an algorithm that:

Adds new points from the stream into a data structure. Duplicate points are allowed and should be treated as different points.
Given a query point, counts the number of ways to choose three points from the data structure such that the three points and the query point form an axis-aligned square with positive area.
An axis-aligned square is a square whose edges are all the same length and are either parallel or perpendicular to the x-axis and y-axis.

Implement the DetectSquares class:

DetectSquares() Initializes the object with an empty data structure.
void add(int[] point) Adds a new point point = [x, y] to the data structure.
int count(int[] point) Counts the number of ways to form axis-aligned squares with point point = [x, y] as described above.
 

Example 1:


Input
["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
[[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10]]]
Output
[null, null, null, null, 1, 0, null, 2]

Explanation
DetectSquares detectSquares = new DetectSquares();
detectSquares.add([3, 10]);
detectSquares.add([11, 2]);
detectSquares.add([3, 2]);
detectSquares.count([11, 10]); // return 1. You can choose:
                               //   - The first, second, and third points
detectSquares.count([14, 8]);  // return 0. The query point cannot form a square with any points in the data structure.
detectSquares.add([11, 2]);    // Adding duplicate points is allowed.
detectSquares.count([11, 10]); // return 2. You can choose:
                               //   - The first, second, and third points
                               //   - The first, third, and fourth points
 

Constraints:

point.length == 2
0 <= x, y <= 1000
At most 3000 calls in total will be made to add and count.
 
*/

import java.util.HashMap;
import java.util.Map;

class DetectSquares {

    // Map<x, Map<y, count>>
    private Map<Integer, Map<Integer, Integer>> map;

    public DetectSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        map.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = map.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }
    
    public int count(int[] point) {
        int x = point[0], y = point[1];
        if (!map.containsKey(x)) return 0;

        int res = 0;

        // Iterate all possible y' on same x (vertical alignment)
        for (int colY : map.get(x).keySet()) {
            if (colY == y) continue;

            int side = colY - y;

            // Check right square (x + side)
            res += map.get(x).get(colY) *
                   map.getOrDefault(x + side, new HashMap<>()).getOrDefault(y, 0) *
                   map.getOrDefault(x + side, new HashMap<>()).getOrDefault(colY, 0);

            // Check left square (x - side)
            res += map.get(x).get(colY) *
                   map.getOrDefault(x - side, new HashMap<>()).getOrDefault(y, 0) *
                   map.getOrDefault(x - side, new HashMap<>()).getOrDefault(colY, 0);
        }

        return res;
    }
}