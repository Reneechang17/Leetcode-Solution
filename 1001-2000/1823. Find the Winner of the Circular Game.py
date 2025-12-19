# Time:O(n*k), Space:O(n)

from collections import deque

class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        que = deque(range(1, n + 1))

        while len(que) > 1:
            for _ in range(k - 1):
                que.append(que.popleft())
            que.popleft()
        return que[0]

# Recommended: Time:O(n), Space:O(1)
class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        winner = 0
        for i in range(2, n + 1):
            winner = (winner + k) % i
        return winner + 1 # 1-indexed
    