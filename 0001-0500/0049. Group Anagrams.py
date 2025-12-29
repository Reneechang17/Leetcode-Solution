# Time:O(n*k), Space:O(n*k)

from typing import List

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagram = {}

        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1
            
            key = tuple(count)
            if key not in anagram:
                anagram[key] = []
            anagram[key].append(s)
        
        return list(anagram.values())
    