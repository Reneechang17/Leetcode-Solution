# Easy
# Matrix
# Time:O(1), Space:O(1) 
# https://leetcode.cn/problems/available-captures-for-rook/

from typing import *

class Solution:
    def numRookCaptures(self, board: List[List[str]]) -> int:
        r, c = 0, 0
        for i in range(8):
            for j in range(8):
                if board[i][j] == 'R':
                    r, c = i, j
                    break
        
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        cap = 0

        for dr, dc in dirs:
            nr, nc = r + dr, c + dc
            while 0 <= nr < 8 and 0 <= nc < 8:
                if board[nr][nc] == 'B':
                    break
                if board[nr][nc] == 'p':
                    cap += 1
                    break
                nr += dr
                nc += dc
        return cap
