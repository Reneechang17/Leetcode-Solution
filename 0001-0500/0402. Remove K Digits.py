# Time:O(n), Space:O(n)

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []

        for d in num:
            while stack and k > 0 and stack[-1] > d:
                stack.pop()
                k -= 1

            stack.append(d)

        while k > 0:
            stack.pop()
            k -= 1

        res = "".join(stack).lstrip("0")

        return res if res else "0"
