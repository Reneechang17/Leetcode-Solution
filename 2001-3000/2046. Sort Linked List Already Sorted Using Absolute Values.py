# Time:O(n), Space:O(1)

from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def sortLinkedList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head

        dummy = ListNode(0)
        tail = dummy

        cur = head
        while cur:
            nxt = cur.next
            if cur.val < 0:
                # insert @ head
                cur.next = dummy.next
                dummy.next = cur
                if tail == dummy:
                    tail = cur

            else:
                # insert following tail
                tail.next = cur
                tail = cur
                cur.next = None
            
            cur = nxt
        
        return dummy.next
    