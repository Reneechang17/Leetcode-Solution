# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        m1 = m2 = m3 = float('-inf')

        for num in nums:
            if num == m1 or num == m2 or num == m3:
                continue
            
            if num > m1:
                m3, m2, m1 = m2, m1, num
            elif num > m2:
                m3, m2 = m2, num
            elif num > m3:
                m3 = num
        
        return m3 if m3 != float('-inf') else m1
    
class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        dis = sorted(set(nums), reverse=True)
        return dis[2] if len(dis) >= 3 else dis[0]
    