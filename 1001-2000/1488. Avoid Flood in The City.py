# Time:O(nlogn), Space:O(n)

from typing import List

class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        n = len(rains)
        res = [-1] * n
        full_lakes = {}  # (lake no.:prev raining day)
        dry_days = []

        for i in range(n):
            if rains[i] > 0:
                lake = rains[i]

                if lake in full_lakes:
                    # binary search find first > full_lakes[lake]
                    left, right = 0, len(dry_days)
                    while left < right:
                        mid = (left + right) // 2
                        if dry_days[mid] > full_lakes[lake]:
                            right = mid
                        else:
                            left = mid + 1

                    if left == len(dry_days):
                        return []

                    day = dry_days[left]
                    res[day] = lake
                    dry_days.pop(left)

                full_lakes[lake] = i

            else:
                dry_days.append(i)
                res[i] = 1

        return res
