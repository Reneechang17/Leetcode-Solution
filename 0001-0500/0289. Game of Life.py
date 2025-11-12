# Medium
# Simulation, Matrix
# Time:O(mn), Space:O(1)
# https://leetcode.cn/problems/game-of-life/

from typing import *

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        m = len(board)
        n = len(board[0])

        directions = [(-1, -1), (-1, 0), (-1, 1),
                      (0, -1), (0, 1),
                      (1, -1,), (1, 0), (1, 1)]
        
        for i in range(m):
            for j in range(n):
                live_nodes = 0
                for dx, dy in directions:
                    ni, nj = i + dx, j + dy
                    
                    # Check boundary
                    if 0 <= ni < m and 0 <= nj < n:
                        if board[ni][nj] == 1 or board[ni][nj] == 2:
                            live_nodes += 1
                
                if board[i][j] == 1:
                    if live_nodes < 2 or live_nodes > 3:
                        board[i][j] = 2 # 1->0 dead
                else:
                    if live_nodes == 3:
                        board[i][j] = -1 # 0->reborn
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == -1:
                    board[i][j] = 1
