# Time:O(n), Space:O(n)

from collections import deque
from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def listOfDepth(self, tree: Optional[TreeNode]) -> List[Optional[ListNode]]:
        if not tree:
            return []
        
        res = []
        que = deque([tree])

        while que:
            size = len(que)
            dummy = ListNode(0)
            cur = dummy

            for _ in range(size):
                node = que.popleft()
                cur.next = ListNode(node.val)
                cur = cur.next

                if node.left:
                    que.append(node.left)
                if node.right:
                    que.append(node.right)
            
            res.append(dummy.next)
        return res
    