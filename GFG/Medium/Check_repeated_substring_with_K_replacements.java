package GFG.Medium;

/* Given a string s and an integer k, check if it is possible to convert s to a string that is repetition of a substring with k characters else returns false. In order to convert we can replace one substring of length k with any k characters.

Examples:

Input: s = "abcbedabcabc",  k = 3
Output: true
Explanation: Replace "bed" with "abc" so that the whole string becomes repetition of "abc".
Input: s = "bdac", k = 2
Output: true
Explanation: The string can be divided into substrings of length k: ["bd", "ac"]. 
Since there are exactly two substrings and both are different, we can make them identical by replacing one substring with the other. Hence, the result is true.
Input: s = "abcdabcd", k = 2
Output: false
Explanation: Since we are allowed to change only one instance, we cannot covert.
Constraints:
2 ≤ k ≤ s.size() ≤ 105

*/
import java.util.*;

class Solution {
    public boolean kSubstr(String s, int k) {

        int n = s.length();

        if (n % k != 0) {
            return false;
        }

        HashMap<String, Integer> map = new HashMap<>();

        int blocks = n / k;
        int maxFreq = 0;

        for (int i = 0; i < n; i += k) {

            String part = s.substring(i, i + k);

            int freq = map.getOrDefault(part, 0) + 1;
            map.put(part, freq);

            maxFreq = Math.max(maxFreq, freq);
        }

        return maxFreq >= blocks - 1;
    }
}