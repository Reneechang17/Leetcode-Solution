# Time: O(3⁴ × n), Space:O(4)

from typing import List

class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        res = []
        path = []

        def backtracking(start):
            if len(path) == 4 and start == len(s):
                res.append('.'.join(path))
                return
            
            # pruning: already 4 seg OR no number can use
            if len(path) == 4 or start == len(s):
                return

            for length in range(1, 4):
                if start + length > len(s):
                    break
                
                segment = s[start:start+length]

                if len(segment) > 1 and segment[0] == '0':
                    continue
                if int(segment) > 255:
                    continue
                
                path.append(segment)
                backtracking(start + length)
                path.pop()

        backtracking(0)
        return res
    