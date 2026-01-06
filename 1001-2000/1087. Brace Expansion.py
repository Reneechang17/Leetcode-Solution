# Time:O(n × k^m), Space:O(k^m)

from typing import List

class Solution:
    def expand(self, s: str) -> List[str]:
        groups = []
        i = 0

        while i < len(s):
            if s[i] == "{":
                i += 1
                options = []
                while s[i] != "}":
                    if s[i] != ",":
                        options.append(s[i])
                    i += 1
                groups.append(sorted(options))
                i += 1
            else:
                groups.append(s[i])
                i += 1

        res = []

        def backtracking(index, path):
            if index == len(groups):
                res.append("".join(path))
                return

            for char in groups[index]:
                backtracking(index + 1, path + [char])

        backtracking(0, [])
        return sorted(res)
    