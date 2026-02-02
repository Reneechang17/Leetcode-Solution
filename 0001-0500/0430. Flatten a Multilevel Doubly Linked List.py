# Time:O(n), Space:O(n)

from typing import Optional

class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child

# DFS
class Solution:
    def flatten(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return head

        def dfs(node):
            cur = node
            last = node

            while cur:
                next = cur.next

                if cur.child:
                    child_head = cur.child
                    child_tail = dfs(child_head)

                    cur.next = child_head
                    child_head.prev = cur
                    cur.child = None # cleanup child

                    if next:
                        child_tail.next = next
                        next.prev = child_tail
                    
                    last = child_tail
                    cur = child_tail
                else:
                    last = cur
                cur = cur.next
                
            return last
        
        dfs(head)
        return head

# Stack
class Solution:
    def flatten(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return head
        
        stack = []
        cur = head

        while cur:
            if cur.child:
                if cur.next:
                    # use stack to store the origin cur.next
                    stack.append(cur.next)
                
                # handle child first, let it be cur.next
                cur.next = cur.child
                cur.child.prev = cur
                cur.child = None

            if not cur.next and stack:
                nxt = stack.pop()
                cur.next = nxt
                nxt.prev = cur
            
            cur = cur.next
        
        return head
    