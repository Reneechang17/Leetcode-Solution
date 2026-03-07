# Time:O(n), Space:O(1)
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        small = ListNode(0)
        large = ListNode(0)
        small_tail = small
        large_tail = large

        cur = head
        while cur:
            if cur.val < x:
                small_tail.next = cur
                small_tail = small_tail.next
            else:
                large_tail.next = cur
                large_tail = large_tail.next
            cur = cur.next
        
        small_tail.next = large.next
        large_tail.next = None

        return small.next
    