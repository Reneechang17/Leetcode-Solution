import heapq
from typing import Counter, List

# When k is small, and n is bigger
# Time:O(nlog k)
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = Counter(nums)

        heap = []
        for num, freq in count.items():
            heapq.heappush(heap, (freq, num))
            if len(heap) > k:
                heapq.heappop(heap)

        return [num for _, num in heap]

# when k is close to n
# Time: O(nlog n)
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = Counter(nums)

        sorted_nums = sorted(count.items(), key=lambda x: -x[1])

        return [num for num, _ in sorted_nums[:k]]

# when k is close to n and the freqs are relatively concentrated
# Time: O(n) 
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = Counter(nums)
        n = len(nums)

        buckets = [[] for _ in range(n + 1)]
        for num, freq in count.items():
            buckets[freq].append(num)

        res = []
        for freq in range(n, -1, -1):
            for num in buckets[freq]:
                res.append(num)
                if len(res) == k:
                    return res

        return res

# when k is far small than n
# Time: O(n)
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = Counter(nums)
        items = list(count.items())

        def partition(left, right):
            pivot_freq = items[right][1]
            i = left
            for j in range(left, right):
                if items[j][1] > pivot_freq:
                    items[i], items[j] = items[j], items[i]
                    i += 1
            items[i], items[right] = items[right], items[i]
            return i

        def quick_select(left, right, k):
            if left >= right:
                return

            pivot_idx = partition(left, right)
            if pivot_idx == k:
                return
            elif pivot_idx < k:
                quick_select(pivot_idx + 1, right, k)
            else:
                quick_select(left, pivot_idx - 1, k)

        quick_select(0, len(items) - 1, k - 1)
        return [num for num, _ in items[:k]]
