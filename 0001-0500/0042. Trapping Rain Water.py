# Hard
# Two Pointers
# Time:O(n), Space:O(1)
# https://leetcode.cn/problems/trapping-rain-water/

from typing import *

class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        
        left, right = 0, len(height) - 1
        left_max, right_max = 0, 0
        water = 0

        while left < right:
            if height[left] < height[right]:
                if height[left] >= left_max:
                    left_max = height[left]
                else:
                    water += left_max - height[left]
                left += 1 
            else:
                if height[right] >= right_max:
                    right_max = height[right]
                else:
                    water += right_max - height[right]
                right -= 1
        
        return water

# Can use stack too. Time:O(n), Space:O(n)
class Solution:
    def trap(self, height: List[int]) -> int:
        stack = []
        water = 0

        for i in range(len(height)):
            while stack and height[i] > height[stack[-1]]:
                top = stack.pop()

                if not stack:
                    break

                left = stack[-1]
                width = i - left - 1
                h = min(height[left], height[i]) - height[top]
                water += width * h
            stack.append(i)
        return water
    