# Time:O(n × 2^m), Space:O(m)

class Solution:
    def punishmentNumber(self, n: int) -> int:
        total = 0

        for i in range(1, n + 1):
            square_str = str(i * i)
            if self.can_partition(square_str, i):
                total += i * i
        
        return total
    
    def can_partition(self, s, target):

        def dfs(start, cur_sum):
            if start == len(s):
                return cur_sum == target
            
            num = 0
            for end in range(start, len(s)):
                num = num * 10 + int(s[end])
                if cur_sum + num > target:
                    break
                if dfs(end + 1, cur_sum + num):
                    return True

            return False

        return dfs(0, 0) # start, cur_sum
    