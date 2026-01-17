# Time:O(n), Space:O(1)

class Solution:
    def checkZeroOnes(self, s: str) -> bool:
        max_one = max_zero = 0
        cur_one = cur_zero = 0

        for c in s:
            if c == '1':
                cur_one += 1
                max_one = max(max_one, cur_one)
                cur_zero = 0
            else:
                cur_zero += 1
                max_zero = max(max_zero, cur_zero)
                cur_one = 0
        
        return max_one > max_zero
    