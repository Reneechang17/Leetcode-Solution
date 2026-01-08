# Time:O(n), Space:O(n)

class Solution:
    def areNumbersAscending(self, s: str) -> bool:
        tokens = s.split()
        prev = -1

        for t in tokens:
            if t.isdigit():
                num = int(t)
                if num <= prev:
                    return False
                prev = num

        return True
