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
