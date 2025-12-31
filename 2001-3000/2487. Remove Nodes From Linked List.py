# Time:O(n), Space:O(n)

from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        
        head.next = self.removeNodes(head.next)

        if head.next and head.val < head.next.val:
            return head.next
        
        return head
    
# or use stack
class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        vals = []
        cur = head
        while cur:
            vals.append(cur.val)
            cur = cur.next

        stack = []
        for v in vals:
            while stack and stack[-1] < v:
                stack.pop()
            stack.append(v)

        dummy = ListNode(0)
        cur = dummy
        for v in stack:
            cur.next = ListNode(v)
            cur = cur.next

        return dummy.next
    