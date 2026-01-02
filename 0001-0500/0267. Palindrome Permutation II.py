# Time:O((n/2)!), Space:O(n)

from typing import List, Counter

class Solution:
    def generatePalindromes(self, s: str) -> List[str]:
        count = Counter(s)

        odd_count = sum(1 for c in count.values() if c % 2 == 1)
        if odd_count > 1:
            return []

        mid = ""
        for char, c in count.items():
            if c % 2 == 1:
                mid = char
                count[char] -= 1

        half = []
        for char, c in count.items():
            half.extend([char] * (c // 2))

        res = []
        half.sort()
        vis = [False] * len(half)

        def backtracking(path):
            if len(path) == len(half):
                palindrome = "".join(path) + mid + "".join(path[::-1])
                res.append(palindrome)
                return

            for i in range(len(half)):
                if vis[i]:
                    continue

                if i > 0 and half[i] == half[i - 1] and not vis[i - 1]:
                    continue

                vis[i] = True
                path.append(half[i])
                backtracking(path)
                path.pop()
                vis[i] = False

        backtracking([])
        return res
