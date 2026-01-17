# Time:O(4^n), Space:O(n)

from typing import List

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res = []

        def backtracking(idx, path, cur, prev):
            if idx == len(num):
                if cur == target:
                    res.append("".join(path))
                return

            for i in range(idx, len(num)):
                if num[idx] == "0" and i > idx:
                    break

                val_str = num[idx : i + 1]
                val = int(val_str)

                if idx == 0:
                    backtracking(i + 1, [val_str], val, val)
                else:
                    path.append("+")
                    path.append(val_str)
                    backtracking(i + 1, path, cur + val, val)
                    path.pop()
                    path.pop()

                    path.append("-")
                    path.append(val_str)
                    backtracking(i + 1, path, cur - val, -val)
                    path.pop()
                    path.pop()

                    path.append("*")
                    path.append(val_str)
                    backtracking(i + 1, path, cur - prev + prev * val, prev * val)
                    path.pop()
                    path.pop()

        backtracking(0, [], 0, 0)
        return res
    