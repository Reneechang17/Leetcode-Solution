# Time:O(n), Space:O(1)

from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head

        # find the Node at left - 1
        prev = dummy
        for _ in range(left - 1):
            prev = prev.next
        
        # reverse [left, right]
        start = prev.next

        for _ in range(right - left):
            # every time insert the start.next to prev.next
            tmp = start.next
            start.next = tmp.next
            tmp.next = prev.next
            prev.next = tmp
        
        return dummy.next
    