package GFG.Medium;

/* Given two strings s1 and s2 consisting of lowercase English letters of length n1 and n2 respectively, find the number of ways to insert exactly one character into string s1 such that the length of the Longest Common Subsequence (LCS) of both strings increases by exactly 1.

Examples :

Input: s1 = "abab", s2 = "abc"
Output: 3
Explanation: The LCS length of the given two strings is 2. There are 3 valid insertions in s1 which increase the LCS length to 3:
"abcab" -> LCS = 3
"abacb" -> LCS = 3
"ababc" -> LCS = 3
Input: s1 = "abcabc", s2 = "abcd"
Output: 4
Explanation: The LCS length of the given two strings is 3. There are 4 valid insertions in s1 which increase the LCS length to 4:
"abcdabc" -> LCS = 4
"abcadcb" -> LCS = 4
"abcabdc" -> LCS = 4
"abcabcd" -> LCS = 4
Constraints:
1<= n1, n2 <=100

*/
class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {
        
        int n = s1.length(), m = s2.length();
        
        int[][] pre = new int[n + 1][m + 1];
        int[][] suf = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    pre[i][j] = pre[i - 1][j - 1] + 1;
                else
                    pre[i][j] = Math.max(pre[i - 1][j], pre[i][j - 1]);
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    suf[i][j] = 1 + suf[i + 1][j + 1];
                else
                    suf[i][j] = Math.max(suf[i + 1][j], suf[i][j + 1]);
            }
        }
        
        int lcs = pre[n][m];
        int ans = 0;
        
        for (int i = 0; i <= n; i++) {
            
            boolean[] used = new boolean[26];
            
            for (int j = 0; j < m; j++) {
                
                int c = s2.charAt(j) - 'a';
                
                if (!used[c] && pre[i][j] + suf[i][j + 1] == lcs) {
                    used[c] = true;
                    ans++;
                }
            }
        }
        
        return ans;
    }
}