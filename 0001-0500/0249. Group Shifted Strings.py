# Time:O(n*k), Space:O(n*k)

from typing import List

class Solution:
    def groupStrings(self, strings: List[str]) -> List[List[str]]:
        groups = {}

        for s in strings:
            key = []
            for i in range(len(s) - 1):
                diff = (ord(s[i + 1]) - ord(s[i])) % 26
                key.append(diff)
            
            key = tuple(key)
            if key not in groups:
                groups[key] = []
            groups[key].append(s)
        
        return list(groups.values())
    