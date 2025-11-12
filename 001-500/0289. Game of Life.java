// Medium
// Simulation, Matrix
// Time:O(mn), Space:O(1)
// https://leetcode.cn/problems/game-of-life/

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1},
                              {0, -1}, {0, 1},
                { 1, -1 }, { 1, 0 }, { 1, 1 } };
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNodes = 0;
                for (int[] dir : directions) {
                    int ni = i + dir[0], nj = j + dir[1];

                    if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        if (board[ni][nj] == 1 || board[ni][nj] == 2) {
                            liveNodes++;
                        }
                    }
                }

                if (board[i][j] == 1) {
                    if (liveNodes < 2 || liveNodes > 3) {
                        board[i][j] = 2; // mark as set to dead
                    }
                } else {
                    if (liveNodes == 3) {
                        board[i][j] = -1; // mark as set to live
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
