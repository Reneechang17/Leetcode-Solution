# Time:O(n × L), Space:O(L)

from typing import List

class TrieNode:
    def __init__(self):
        self.children = {} # char -> TrieNode
        self.is_word = False

class MagicDictionary:

    def __init__(self):
        self.root = TrieNode()

    def buildDict(self, dictionary: List[str]) -> None:
        for word in dictionary:
            node = self.root

            for c in word:
                if c not in node.children:
                    node.children[c] = TrieNode()
                node = node.children[c]
            node.is_word = True

    def search(self, searchWord: str) -> bool:
        def dfs(node, index, count):
            if index == len(searchWord):
                # must have 1 mismatch and be a valid word
                return count == 1 and node.is_word
            
            cur_char = searchWord[index]
            
            # try all possible children
            for child_char, child_node in node.children.items():
                is_mismatch = (child_char != cur_char)
                new_mismatch = count + (1 if is_mismatch else 0)

                # prune
                if new_mismatch > 1:
                    continue
                
                if dfs(child_node, index + 1, new_mismatch):
                    return True
            return False
        
        return dfs(self.root, 0, 0)
    