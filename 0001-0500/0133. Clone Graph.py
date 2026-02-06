# Time:O(V+E), Space:O(V)

from typing import Optional

class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        
        vis = {}

        def dfs(n):
            if n in vis:
                return vis[n]
            
            copy = Node(n.val)
            vis[n] = copy

            for nei in n.neighbors:
                copy.neighbors.append(dfs(nei))
            
            return copy
        
        return dfs(node)
    