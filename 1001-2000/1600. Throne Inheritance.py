# Space:O(n)

from typing import List

class ThroneInheritance:

    def __init__(self, kingName: str):
        self.king = kingName
        self.children = {}
        self.dead = set()
        self.children[kingName] = []
    
    # O(1)
    def birth(self, parentName: str, childName: str) -> None:
        if parentName not in self.children:
            self.children[parentName] = []
        self.children[parentName].append(childName)
        if childName not in self.children:
            self.children[childName] = []
    
    # O(1)
    def death(self, name: str) -> None:
        self.dead.add(name)

    # O(n)
    def getInheritanceOrder(self) -> List[str]:
        res = []

        def dfs(name):
            if name not in self.dead:
                res.append(name)
            for child in self.children.get(name, []):
                dfs(child)

        dfs(self.king)
        return res
    