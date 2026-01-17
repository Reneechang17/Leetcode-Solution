import heapq
from typing import List

# Time: O(nlog k), Space: O(k)
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        heap = []

        for x, y in points:
            dist = x * x + y * y
            heapq.heappush(heap, (-dist, x, y))
            if len(heap) > k:
                heapq.heappop(heap)
        
        return [[x, y] for _, x, y in heap]

# Time: O(nlog n), Space: O(1)
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        points.sort(key=lambda p: p[0] * p[0] + p[1] * p[1])
        return points[:k]

# Time:O(n) (worse:O(n²)), Space:O(1)
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        def dist(points):
            return points[0] * points[0] + points[1] * points[1]

        def partition(left, right):
            pivot_dist = dist(points[right])
            i = left
            for j in range(left, right):
                if dist(points[j]) < pivot_dist:
                    points[i], points[j] = points[j], points[i]
                    i += 1
            points[i], points[right] = points[right], points[i]
            return i

        def quick_select(left, right, k_idx):
            if left >= right:
                return

            pivot_idx = partition(left, right)
            if pivot_idx == k_idx:
                return
            elif pivot_idx < k_idx:
                quick_select(pivot_idx + 1, right, k_idx)
            else:
                quick_select(left, pivot_idx - 1, k_idx)

        quick_select(0, len(points) - 1, k - 1)
        return points[:k]
