# Time:O(nL), Space:O(n)

from typing import Counter, List

class Solution:
    def numOfPairs(self, nums: List[str], target: str) -> int:
        cnt = Counter(nums)
        ans = 0

        for s in list(cnt.keys()):
            if target.startswith(s):
                suffix = target[len(s):]
                if suffix in cnt:
                    if s == suffix:
                        ans += cnt[s] * (cnt[s] - 1)
                    else:
                        ans += cnt[s] * cnt[suffix]
        
        return ans
    