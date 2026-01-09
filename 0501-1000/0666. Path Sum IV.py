# Time:O(m), Space:O(n)

from typing import List

class Solution:
    def pathSum(self, nums: List[int]) -> int:
        map = {}  # {key:(depth, pos), val:node val}
        for num in nums:
            k = num // 10
            v = num % 10
            map[k] = v

        def dfs(node, path_sum):
            depth = node // 10
            pos = node % 10

            left_child = (depth + 1) * 10 + pos * 2 - 1
            right_child = (depth + 1) * 10 + pos * 2

            cur_sum = path_sum + map[node]

            if left_child not in map and right_child not in map:
                return cur_sum

            total = 0
            if left_child in map:
                total += dfs(left_child, cur_sum)
            if right_child in map:
                total += dfs(right_child, cur_sum)

            return total

        return dfs(nums[0] // 10, 0)
