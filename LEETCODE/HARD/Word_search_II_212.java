package LEETCODE.HARD;
/* Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
*/
import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }

    List<String> ans = new ArrayList<>();
    int m, n;

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.child[idx] == null) {
                    node.child[idx] = new TrieNode();
                }
                node = node.child[idx];
            }
            node.word = word;
        }

        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }

        return ans;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node) {

        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '#') {
            return;
        }

        char c = board[i][j];
        node = node.child[c - 'a'];

        if (node == null) {
            return;
        }

        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        dfs(board, i + 1, j, node);
        dfs(board, i - 1, j, node);
        dfs(board, i, j + 1, node);
        dfs(board, i, j - 1, node);

        board[i][j] = c;
    }
}