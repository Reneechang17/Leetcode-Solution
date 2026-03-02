# Time:O(L) L = path length
# Space:O(N) N = node number

from typing import List

class TrieNode:
    def __init__(self):
        self.children = {}
        self.isFile = False # directory/file
        self.content = ""

class FileSystem:

    def __init__(self):
        self.root = TrieNode() 
    
    def _split(self, path):
        if path == "/":
            return []
        return path.split('/')[1:]

    def ls(self, path: str) -> List[str]:
        node = self.root 
        parts = self._split(path)
        for p in parts:
            if p not in node.children:
                return []
            node = node.children[p]
        
        if node.isFile:
            return [parts[-1]]
        else:
            return sorted(node.children.keys())

    def mkdir(self, path: str) -> None:
        node = self.root
        parts = self._split(path)
        for p in parts:
            if p not in node.children:
                node.children[p] = TrieNode()
            node = node.children[p]

    def addContentToFile(self, filePath: str, content: str) -> None:
        node = self.root
        parts = self._split(filePath)
        for p in parts[:-1]:
            if p not in node.children:
                node.children[p] = TrieNode()
            node = node.children[p]
        
        fileName = parts[-1]
        if fileName not in node.children:
            node.children[fileName] = TrieNode()
        fileNode = node.children[fileName]
        fileNode.isFile = True
        fileNode.content += content

    def readContentFromFile(self, filePath: str) -> str:
        node = self.root
        parts = self._split(filePath)
        for p in parts:
            node = node.children[p]
        return node.content
    