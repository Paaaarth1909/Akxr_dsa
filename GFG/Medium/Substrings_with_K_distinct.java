package GFG.Medium;

/* You are given a string s consisting of lowercase characters and an integer k, You have to count all possible substrings that have exactly k distinct characters.

Examples :

Input: s = "abc", k = 2
Output: 2
Explanation: Possible substrings are ["ab", "bc"]
Input: s = "aba", k = 2
Output: 3
Explanation: Possible substrings are ["ab", "ba", "aba"]
Input: s = "aa", k = 1
Output: 3
Explanation: Possible substrings are ["a", "a", "aa"]
Constraints:
1 ≤ s.size() ≤ 106
1 ≤ k ≤ 26

*/
class Solution {
    public int countSubstr(String s, int k) {
        if (k == 0) return 0;
        return atMostK(s, k) - atMostK(s, k - 1);
    }

    private int atMostK(String s, int k) {
        int[] freq = new int[26];
        int left = 0, distinct = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {
            int r = s.charAt(right) - 'a';
            if (freq[r] == 0) distinct++;
            freq[r]++;

            while (distinct > k) {
                int l = s.charAt(left) - 'a';
                freq[l]--;
                if (freq[l] == 0) distinct--;
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}
