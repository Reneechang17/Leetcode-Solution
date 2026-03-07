from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# Time:O(n), Space:O(n)
class Solution:
    def removeDuplicateNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head
        
        vis = {head.val}
        cur = head

        while cur.next:
            if cur.next.val in vis:
                cur.next = cur.next.next
            else:
                vis.add(cur.next.val)
                cur = cur.next
        return head
    
# No temp buffer
# Time:O(N^2), Space:O(1)
class Solution:
    def removeDuplicateNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur = head
        while cur:
            # go through all the nodes after the cur node
            runner = cur
            while runner.next:
                if runner.next.val == cur.val:
                    runner.next = runner.next.next
                else:
                    runner = runner.next
            cur = cur.next
        return head
    