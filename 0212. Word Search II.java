// Hard
// Trie, DFS, Backtracking
// Time:O(k·L + m·n·4^L),Space:O(k·L)
// https://leetcode.cn/problems/word-search-ii/

import java.util.*;

class Solution {
    int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }

        Set<String> res = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie, i, j, res);
            }
        }
        return new ArrayList<String>(res);
    }

    private void dfs(char[][] board, Trie cur, int i, int j, Set<String> res) {
        if (!cur.child.containsKey(board[i][j])) return;

        char c = board[i][j];
        cur = cur.child.get(c); // get the cur char's trie node 
        if (!"".equals(cur.word)) {
            res.add(cur.word);
        }

        board[i][j] = '#';
        for (int[] dir : DIRS) {
            int i2 = i + dir[0], j2 = j + dir[1];
            if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) {
                dfs(board, cur, i2, j2, res);
            }
        }
        board[i][j] = c;
    }
}

class Trie {
    // Time:O(m*n),Space:O(m*n)
    String word;
    Map<Character, Trie> child;

    public Trie() {
        this.word = "";
        this.child = new HashMap<Character, Trie>();
    }

    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.child.containsKey(c)) {
                cur.child.put(c, new Trie());
            }
            cur = cur.child.get(c);
        }
        cur.word = word;
    }
}
