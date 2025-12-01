# Easy
# Simulation, Array
# Time:O(n), Space:O(1)
# https://leetcode.cn/problems/find-winner-on-a-tic-tac-toe-game/

from typing import *

class Solution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        board = [['' for _ in range(3)] for _ in range(3)]
        for i, (r, c) in enumerate(moves):
            board[r][c] = 'A' if i % 2 == 0 else 'B'
        
        def check_winner():
            for row in board:
                if row[0] == row[1] == row[2] != '':
                    return row[0]
            
            for c in range(3):
                if board[0][c] == board[1][c] == board[2][c] != '':
                    return board[0][c]
            
            if board[0][0] == board[1][1] == board[2][2] != '':
                return board[0][0]
            if board[0][2] == board[1][1] == board[2][0] != '':
                return board[0][2]
            
            return None
        
        winner = check_winner()
        if winner:
            return winner
        
        return "Draw" if len(moves) == 9 else "Pending"
