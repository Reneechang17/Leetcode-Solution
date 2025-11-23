# Hard
# Stack
# Time:O(n*log(max_num)), Space:O(n)
# https://leetcode.cn/problems/replace-non-coprime-numbers-in-array/

from typing import *

class Solution:
    def replaceNonCoprimes(self, nums: List[int]) -> List[int]:
        import math
        
        stack = []

        for num in nums:
            stack.append(num)

            while len(stack) >= 2:
                top = stack[-1]
                second = stack[-2]
                g = math.gcd(top, second)

                if g > 1:
                    stack.pop()
                    stack.pop()
                    lcm = top * second // g
                    stack.append(lcm)
                else:
                    break
        return stack
    