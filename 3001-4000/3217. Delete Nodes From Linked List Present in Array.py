# Time:O(n+m), Space:O(m)

from typing import List, Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def modifiedList(self, nums: List[int], head: Optional[ListNode]) -> Optional[ListNode]:
        num_set = set(nums)

        dummy = ListNode(0, head)
        prev = dummy
        cur = head

        while cur:
            if cur.val in num_set:
                prev.next = cur.next
            else:
                prev = cur
            cur = cur.next
        
        return dummy.next
    