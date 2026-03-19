# Time:O(n), Space:O(1)
# Can also do with recursion I think

from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:

        def reverse(head):
            prev = None
            cur = head
            while cur:
                nxt = cur.next
                cur.next = prev
                prev = cur
                cur = nxt
            return prev

        head = reverse(head)

        carry = 0
        cur = head
        while cur:
            val = cur.val * 2 + carry
            cur.val = val % 10
            carry = val // 10
            if not cur.next and carry:
                cur.next = ListNode(carry)
                break
            cur = cur.next
        
        return reverse(head)
    