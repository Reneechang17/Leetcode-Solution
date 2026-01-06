# Time:O(n), Space:O(n)

class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        cur_num = 0
        cur_str = ""

        for c in s:
            if c.isdigit():
                cur_num = cur_num * 10 + int(c)
            elif c == "[":
                stack.append((cur_str, cur_num))
                cur_str = ""
                cur_num = 0
            elif c == "]":
                prev_str, num = stack.pop()
                cur_str = prev_str + cur_str * num
            else:
                cur_str += c

        return cur_str
    