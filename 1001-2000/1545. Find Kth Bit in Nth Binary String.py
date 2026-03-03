# Time:O(n), Space:O(n)

class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        if n == 1:
            return "0"
        
        prev_len = 1
        for _ in range(1, n - 1):
            prev_len = 2 * prev_len + 1
        
        mid = prev_len + 1

        if k == mid:
            return "1"
        elif k < mid:
            return self.findKthBit(n - 1, k)
        else:
            ch = self.findKthBit(n - 1, 2 * prev_len + 2 - k)
            return "1" if ch == "0" else "0"
        