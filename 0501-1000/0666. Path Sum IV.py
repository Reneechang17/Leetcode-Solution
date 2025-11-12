from typing import List

class Solution:
    def pathSum(self, nums: List[int]) -> int:
        map = {} # {key=depth, val=node value}
        for x in nums:
            k = x // 10 # depth and pos
            v = x % 10 # node value
            map[k] = v

        return self.dfs(map, nums[0] // 10, 0)
    
    def dfs(self, map: dict, node: int, path_sum: int) -> int:
        depth = node // 10
        pos = node % 10

        left_child = (depth + 1) * 10 + pos * 2 - 1
        right_child = (depth + 1) * 10 + pos * 2

        cur_sum = path_sum + map[node]

        if left_child not in map and right_child not in map:
            return cur_sum
        
        total = 0
        if left_child in map:
            total += self.dfs(map, left_child, cur_sum)
        
        if right_child in map:
            total += self.dfs(map, right_child, cur_sum)
        
        
        return total
