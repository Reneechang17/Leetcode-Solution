# Time:O(query_row²), Space:O(query_row)

class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        dp = [poured]

        for row in range(query_row + 1):
            next_row = [0.0] * (row + 2)
            for col in range(len(dp)):
                if dp[col] > 1:
                    overflow = (dp[col] - 1) / 2.0
                    next_row[col] += overflow
                    next_row[col + 1] += overflow
                    dp[col] = 1
            if row < query_row:
                dp = next_row
            else:
                return min(1.0, dp[query_glass])
        
        return 0.0
    