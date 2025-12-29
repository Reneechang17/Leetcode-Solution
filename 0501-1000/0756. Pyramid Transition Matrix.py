# Time:O(k^(n²)), Space:O(n²)

from typing import List

class Solution:
    def pyramidTransition(self, bottom: str, allowed: List[str]) -> bool:
        mapping = {}
        for triple in allowed:
            key = (triple[0], triple[1])
            if key not in mapping:
                mapping[key] = []
            mapping[key].append(triple[2])
        
        def build(cur_level):
            if len(cur_level) == 1:
                return True
            return dfs(cur_level, "", 0)
        
        def dfs(cur_level, next_level, pos):
            if pos == len(cur_level) - 1:
                return build(next_level)
            
            left = cur_level[pos]
            right = cur_level[pos + 1]

            if (left, right) in mapping:
                for top in mapping[(left, right)]:
                    if dfs(cur_level, next_level + top , pos + 1):
                        return True
            return False

        return build(bottom)
    