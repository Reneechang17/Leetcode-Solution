# Time:O(n), Space:O(n)

from typing import List, Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def nextLargerNodes(self, head: Optional[ListNode]) -> List[int]:
        # turn linkedlist to arr
        vals = []
        cur = head
        while cur:
            vals.append(cur.val)
            cur = cur.next
        
        n = len(vals)
        ans = [0] * n
        stack = []

        for i in range(n):
            # cur val > the val corresponding to stack top
            while stack and vals[stack[-1]] < vals[i]:
                idx = stack.pop()
                ans[idx] = vals[i]
            stack.append(i)
        
        return ans
    