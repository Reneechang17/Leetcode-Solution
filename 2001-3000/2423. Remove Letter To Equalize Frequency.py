# Time:O(1), Space:O(1)

from collections import Counter

class Solution:
    def equalFrequency(self, word: str) -> bool:
        count = Counter(word)

        for c in count:
            count[c] -= 1

            freq = [v for v in count.values() if v > 0]

            if len(set(freq)) == 1:
                return True
            
            count[c] += 1
        
        return False
    