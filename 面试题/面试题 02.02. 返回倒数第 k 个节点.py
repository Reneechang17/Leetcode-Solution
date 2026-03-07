# Time:O(n), Space:O(1)

from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def kthToLast(self, head: Optional[ListNode], k: int) -> int:
        fast = slow = head

        for _ in range(k):
            fast = fast.next
        
        while fast:
            fast = fast.next
            slow = slow.next
        
        return slow.val
    