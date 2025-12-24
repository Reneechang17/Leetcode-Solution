# Time:O(n²), Space:O(n)

from collections import Counter

class Solution:
    def equalFrequency(self, word: str) -> bool:
        for i in range(len(word)):
            remaining = word[:i] + word[i+1:]
            freq = Counter(remaining)
            if len(set(freq.values())) <= 1:
                return True
        return False
    