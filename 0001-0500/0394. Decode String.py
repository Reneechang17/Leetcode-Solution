# Time:O(n), Space:O(n)

class Solution:
    def decodeString(self, s: str) -> str:
        stack = [] # (prev_str, repeat_k)
        cur = ""
        k = 0

        for c in s:
            if c.isdigit():
                k = k * 10 + int(c)
            
            elif c == '[':
                stack.append((cur, k))
                cur = "" # reset
                k = 0
            
            elif c == ']':
                prev, repeat = stack.pop()
                cur = prev + cur * repeat
            
            else:
                cur += c
        
        return cur
    