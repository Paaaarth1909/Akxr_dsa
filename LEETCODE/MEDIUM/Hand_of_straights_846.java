package LEETCODE.MEDIUM;

import java.util.TreeMap;

/* Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

 

Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
Example 2:

Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.

 

Constraints:

1 <= hand.length <= 104
0 <= hand[i] <= 109
1 <= groupSize <= hand.length
*/
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int h : hand) map.put(h, map.getOrDefault(h, 0) + 1);

        while (!map.isEmpty()) {
            int first = map.firstKey();

            for (int i = 0; i < groupSize; i++) {
                int card = first + i;
                if (!map.containsKey(card)) return false;

                map.put(card, map.get(card) - 1);
                if (map.get(card) == 0) map.remove(card);
            }
        }

        return true;
    }
}