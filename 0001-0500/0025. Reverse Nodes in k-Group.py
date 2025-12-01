from typing import *

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        def hasKNodes(node: Optional[ListNode], k: int) -> bool:
            count = 0
            while node and count < k:
                node = node.next
                count += 1
            return count == k
        
        def reverse(head: Optional[ListNode], k: int) -> Optional[ListNode]:
            pre = None
            cur = head
            for _ in range(k):
                next_node = cur.next
                cur.next = pre
                pre = cur
                cur = next_node
            return pre
        
        dummy = ListNode(0)
        dummy.next = head
        pre_group = dummy

        while hasKNodes(pre_group.next, k):
            group_start = pre_group.next
            group_end = group_start
            for _ in range(k - 1):
                group_end = group_end.next
            
            next_group = group_end.next
            new_head = reverse(group_start, k)

            pre_group.next = new_head
            group_start.next = next_group
            pre_group = group_start
        
        return dummy.next
            