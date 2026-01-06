# Time:O(n²), Space:O(n)

from typing import Counter

class Solution:
    def countOfAtoms(self, formula: str) -> str:
        stack = [Counter()]
        i = 0
        n = len(formula)

        while i < n:
            if formula[i] == "(":
                stack.append(Counter())
                i += 1
            elif formula[i] == ")":
                i += 1
                start = i
                while i < n and formula[i].isdigit():
                    i += 1
                multi = int(formula[start:i] or 1)

                top = stack.pop()
                for atom, count in top.items():
                    stack[-1][atom] += count * multi

            else:
                start = i
                i += 1
                while i < n and formula[i].islower():
                    i += 1
                atom = formula[start:i]

                start = i
                while i < n and formula[i].isdigit():
                    i += 1
                count = int(formula[start:i] or 1)

                stack[-1][atom] += count

        res = []
        for atom in sorted(stack[0].keys()):
            count = stack[0][atom]
            res.append(atom + (str(count) if count > 1 else ""))

        return "".join(res)
    