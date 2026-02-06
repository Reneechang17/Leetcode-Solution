from collections import deque

class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

# Time:O(n), Space:O(1)
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return None
        
        cur = root

        while cur:
            dummy = Node(0)
            tail = dummy

            while cur:
                if cur.left:
                    tail.next = cur.left
                    tail = tail.next
                
                if cur.right:
                    tail.next = cur.right
                    tail = tail.next
                
                cur = cur.next
            
            cur = dummy.next
        
        return root

# Time:O(n), Space:O(n)
class Solution:
    def connect(self, root: "Node") -> "Node":
        if not root:
            return None

        que = deque([root])

        while que:
            size = len(que)
            prev = None

            for _ in range(size):
                node = que.popleft()
                if prev:
                    prev.next = node
                prev = node

                if node.left:
                    que.append(node.left)
                if node.right:
                    que.append(node.right)
            
            prev.next = None

        return root
