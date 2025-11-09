# use arr to record the count for each row/col/diag. +1 for player1, -1 for player2.
# when we hit +-n means winning.

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
        