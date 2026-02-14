# Time:O(n), Space:O(1)

class Solution:
    def secondsToRemoveOccurrences(self, s: str) -> int:
        time = 0
        zeros = 0
        for c in s:
            if c == '0':
                zeros += 1
            else:
                if zeros > 0:
                    time = max(time + 1, zeros)
        
        return time
    