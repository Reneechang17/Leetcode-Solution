// Hard
// Trie, DFS, Backtracking
// Trie => Time:O(m*n),Space:O(m*n)
// DFS => Time:O(m*n*4^L),Space:O(word.length)
// https://leetcode.cn/problems/word-search-ii/

import java.util.*;

class Solution {
    int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // down/up/right/left

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> res = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie, i, j, res); // perform dfs for each pos
            }
        }
        return new ArrayList<String>(res);
    }

    public void dfs(char[][] board, Trie cur, int i, int j, Set<String> res) {
        if (!cur.children.containsKey(board[i][j])) return;
        
        char c = board[i][j];
        cur = cur.children.get(c); // get the trie node of cur char
        // if cur node is the end of cur word
        if (!"".equals(cur.word)) {
            // add word to res
            res.add(cur.word);
        }
        
        board[i][j] = '#'; // mark as vis
        for (int[] dir : DIRS) {
            int i2 = i + dir[0], j2 = j + dir[1];
            if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) {
                dfs(board, cur, i2, j2, res);
            }
        }
        board[i][j] = c; // backtracking
    }
}

class Trie {
    String word;
    Map<Character, Trie> children; // 存储子节点

    public Trie() {
        this.word = "";
        this.children = new HashMap<Character, Trie>();
    }

    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Trie());
            }
            cur = cur.children.get(c);
        }
        cur.word = word;
    }
}
