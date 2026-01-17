# Time:O(n), Space:O(d)

from typing import Optional

class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child

class Solution:
    def flatten(self, head: "Optional[Node]") -> "Optional[Node]":
        def dfs(node):
            if not node:
                return None, None  # new_head & tail

            cur = node
            tail = node

            while cur:
                next = cur.next
                if cur.child:
                    child_head, child_tail = dfs(cur.child)
                    cur.next = child_head
                    child_head.prev = cur
                    if next:
                        child_tail.next = next
                        next.prev = child_tail
                    else:
                        tail = child_tail
                    cur.child = None
                    cur = child_tail

                if cur:
                    tail = cur
                cur = next
            return node, tail

        new_head, _ = dfs(head)
        return new_head
    