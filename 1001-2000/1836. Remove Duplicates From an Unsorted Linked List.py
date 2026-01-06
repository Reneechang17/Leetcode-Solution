# Time:O(n), Space:O(n)

from typing import Optional, Counter

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def deleteDuplicatesUnsorted(self, head: Optional[ListNode]) -> Optional[ListNode]:
        freq = Counter()
        cur = head
        while cur:
            freq[cur.val] += 1
            cur = cur.next

        dummy = ListNode(0)
        dummy.next = head
        prev = dummy
        cur = head

        while cur:
            if freq[cur.val] > 1:
                prev.next = cur.next
            else:
                prev = cur
            cur = cur.next

        return dummy.next
    