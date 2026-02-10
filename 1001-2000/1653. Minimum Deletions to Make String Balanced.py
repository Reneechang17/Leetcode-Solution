# Time:O(n), Space:O(1)

class Solution:
    def minimumDeletions(self, s: str) -> int:
        n = len(s)
        total_a = s.count('a')
        a_right = total_a
        b_left = 0
        min_del = n

        for i in range(n + 1):
            dels = b_left + a_right
            min_del = min(min_del, dels)

            if i < n:
                if s[i] == 'a':
                    a_right -= 1
                else:
                    b_left += 1
        
        return min_del
    