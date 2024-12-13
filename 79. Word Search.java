// Medium
// DFS
// Time:O(m*n* 4^L), Space:O(L)
// https://leetcode.cn/problems/word-search/

class Solution {
    // Use DFS to explore each cell as the start, check if the cell match to cur char,
    // temporarily mark vis and backtrack by restoring the cell value after DFS completed
    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // if all chars are matched
        if (index == word.length()) return true;
        // check bounds and char match
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#'; // mark as vis
        // find all 4 directions
        boolean found = dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i + 1, j, index + 1) || 
                        dfs(board, word, i, j - 1, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1);
        board[i][j] = temp; // restore the cell
        return found;
    }
}
