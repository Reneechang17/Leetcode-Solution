from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
    
# Stack
# Time:O(n), Space:O(n)
class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        stack = []
        cur = head
        while cur:
            while stack and cur.val > stack[-1]:
                # stack's top should be remove
                stack.pop()
            stack.append(cur.val)
            cur = cur.next
        
        dummy = ListNode(0)
        cur = dummy
        for v in stack:
            cur.next = ListNode(v)
            cur = cur.next
            
        return dummy.next

# Recursion
class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        
        head.next = self.removeNodes(head.next)

        if head.next and head.val < head.next.val:
            return head.next
        
        return head

# Time:O(n), Space:O(1)
class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:

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

        dummy = ListNode(0)
        cur = dummy
        max_val = 0
        while head:
            if head.val >= max_val:
                cur.next = ListNode(head.val)
                cur = cur.next
                max_val = head.val
            head = head.next
        
        return reverse(dummy.next)
    