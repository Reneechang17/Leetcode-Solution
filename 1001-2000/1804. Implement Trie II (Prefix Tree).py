# Time:O(L), Space:O(c*26)

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.cnt = 0
        self.prefix_cnt = 0

class Trie:

    def __init__(self):
        self.root = TrieNode()
    
    def get_idx(self, c: str) -> int:
        return ord(c) - ord('a')
        
    def insert(self, word: str) -> None:
        node = self.root
        for c in word:
            idx = self.get_idx(c)
            if not node.children[idx]:
                node.children[idx] = TrieNode()
            node = node.children[idx]
            node.prefix_cnt += 1
        node.cnt += 1
        
    def countWordsEqualTo(self, word: str) -> int:
        node = self.root
        for c in word:
            idx = self.get_idx(c)
            if not node.children[idx]:
                return 0
            node = node.children[idx]
        
        return node.cnt

    def countWordsStartingWith(self, prefix: str) -> int:
        node = self.root
        for c in prefix:
            idx = self.get_idx(c)
            if not node.children[idx]:
                return 0
            node = node.children[idx]
        
        return node.prefix_cnt

    def erase(self, word: str) -> None:
        node = self.root
        for c in word:
            idx = self.get_idx(c)
            node = node.children[idx]
            node.prefix_cnt -= 1
        node.cnt -= 1
