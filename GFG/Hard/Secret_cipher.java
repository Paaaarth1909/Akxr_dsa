/* Geek wants to send a secret message to his friend Keeg. Instead of sending the original message directly, he encrypts it by inserting the character '*'.

Keeg decodes the message as follows:

Traverse the encoded string from left to right and initialize the original string as empty.
Whenever a normal character appears, append it to the current original string.
Whenever '*' is encountered, remove it and append all characters before it to the end of the current original string.
Repeat until no '*' remains.

Given the original string s, find the lexicographically smallest encrypted string that decodes to s.

Examples :

Input: s = "ababcababcd"
Output: ab*c*d
Explanation: We can encrypt the string in following way : "ababcababcd" -> "ababc*d" -> "ab*c*d"
Input: s = "zzzzzzz"
Output: z*z*z
Explanation: The string can be encrypted in 2 ways: "z*z*z" and "z**zzz". Out of the two "z*z*z" is smaller in length.
Constraints: 
1 ≤ |s| ≤ 105

*/

class Solution {
    public String compress(String s) {

        int n = s.length();

        int[] z = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }

            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        String[] dp = new String[n + 1];
        int[] len = new int[n + 1];

        dp[0] = "";
        len[0] = 0;

        for (int i = 1; i <= n; i++) {

            dp[i] = dp[i - 1] + s.charAt(i - 1);
            len[i] = len[i - 1] + 1;

            if (i % 2 == 0) {
                int half = i / 2;

                if (z[half] >= half) {
                    String candidate = dp[half] + "*";

                    if (candidate.length() < dp[i].length()
                            || (candidate.length() == dp[i].length()
                            && candidate.compareTo(dp[i]) < 0)) {
                        dp[i] = candidate;
                        len[i] = candidate.length();
                    }
                }
            }
        }

        return dp[n];
    }
}