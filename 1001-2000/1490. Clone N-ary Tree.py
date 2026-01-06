# Time:O(n), Space:O(n)

from typing import Optional, List

class Node:
    def __init__(self, val: Optional[int] = None, children: Optional[List['Node']] = None):
        self.val = val
        self.children = children if children is not None else []

class Solution:
    def cloneTree(self, root: "Node") -> "Node":
        if not root:
            return None

        old_to_new = {}

        def dfs(node):
            if not node:
                return None

            if node in old_to_new:
                return old_to_new[node]

            new_node = Node(node.val)
            old_to_new[node] = new_node

            for child in node.children:
                new_node.children.append(dfs(child))

            return new_node

        return dfs(root)
