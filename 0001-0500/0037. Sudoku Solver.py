# Time:O(9^m), Space:O(m)

from typing import List

class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]
        empty = [] 
    
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    empty.append((i, j))
                else:
                    num = board[i][j]
                    rows[i].add(num)
                    cols[j].add(num)
                    boxes[3 * (i // 3) + j // 3].add(num)
    
        def backtrack(idx):
            if idx == len(empty):
                return True
        
            i, j = empty[idx]
            box_idx = 3 * (i // 3) + j // 3
        
            for num in '123456789':
                if num not in rows[i] and num not in cols[j] and num not in boxes[box_idx]:
                    board[i][j] = num
                    rows[i].add(num)
                    cols[j].add(num)
                    boxes[box_idx].add(num)
                
                    if backtrack(idx + 1):
                        return True

                    board[i][j] = '.'
                    rows[i].remove(num)
                    cols[j].remove(num)
                    boxes[box_idx].remove(num)
        
            return False
    
        backtrack(0)
