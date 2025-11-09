# lc 348: https://leetcode.cn/problems/design-tic-tac-toe/

# On M×N board, after each move just check from that cell in four directions for a contiguous K-in-a-row.
# Time: O(k) per move(4 dirs, each k steps)
# Space: O(mn)

class TicTacToeK:
    
    def __init__(self, m: int, n: int, k: int):
        self.m = m
        self.n = n
        self.k = k
        self.board = [[0] * n for _ in range(m)]

    def move(self, row: int, col: int, player: int) -> int:
        self.board[row][col] = player
        dirs = [(0,1), (1,0), (1,1), (1,-1)]

        for dr, dc in dirs:
            cnt = 1
            r, c = row + dr, col + dc
            while 0 <= r < self.m and 0 <= c < self.n and self.board[r][c] == player:
                cnt += 1
                if cnt >= self.k:
                    return player
                r += dr
                c += dc
            
            r, c = row - dr, col - dc
            while 0 <= r < self.m and 0 <= c < self.n and self.board[r][c] == player:
                cnt += 1
                if cnt >= self.k:
                    return player
                r -= dr
                c -= dc

        return 0

# Original question 
# Time:O(1) per move
# Space:O(M)

class TicTacToe:

    def __init__(self, n: int):
        self.n = n
        self.rows = [0] * n
        self.cols = [0] * n
        self.diag = 0
        self.anti_diag = 0
    
    def move(self, row: int, col: int, player: int) -> int:
        val = 1 if player == 1 else -1

        self.rows[row] += val
        self.cols[col] += val

        if row == col:
            self.diag += val
        
        if row + col == self.n - 1:
            self.anti_diag += val
        
        # check who wins
        if (abs(self.rows[row]) == self.n or
            abs(self.cols[col]) == self.n or
            abs(self.diag) == self.n or
            abs(self.anti_diag) == self.n):
            return player
        
        return 0
        