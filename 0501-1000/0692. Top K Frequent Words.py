# Time:O(nlogn), Space:O(n)

import heapq
from typing import Counter, List

class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        count = Counter(words)

        heap = []
        for word, freq in count.items():
            heapq.heappush(heap, (-freq, word))
        
        res = []
        for _ in range(k):
            freq, word = heapq.heappop(heap)
            res.append(word)
        
        return res
