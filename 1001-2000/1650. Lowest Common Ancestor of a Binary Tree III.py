# Time:O(h), Space:O(h)

class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None

class Solution:
    def lowestCommonAncestor(self, p: "Node", q: "Node") -> "Node":
        anc = set()

        cur = p
        while cur:
            anc.add(cur)
            cur = cur.parent

        cur = q
        while cur:
            if cur in anc:
                return cur
            cur = cur.parent
