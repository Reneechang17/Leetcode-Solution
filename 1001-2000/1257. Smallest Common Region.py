# Time:O(n),Space:O(n)

from typing import List

class Solution:
    def findSmallestRegion(
        self, regions: List[List[str]], region1: str, region2: str
    ) -> str:
        parent = {}

        for region in regions:
            parent_region = region[0]
            for i in range(1, len(region)):
                parent[region[i]] = parent_region

        anc = set()
        cur = region1

        while cur in parent:
            anc.add(cur)
            cur = parent[cur]
        anc.add(cur)

        cur = region2
        while cur:
            if cur in anc:
                return cur
            cur = parent.get(cur)
