# Time:O(n * m * 26) , Space:O(n)

from typing import List

class Solution:
    def findLadders(
        self, beginWord: str, endWord: str, wordList: List[str]
    ) -> List[List[str]]:
        word_set = set(wordList)
        if endWord not in word_set:
            return []

        def get_neighbors(word):
            neighbors = []
            for i in range(len(word)):
                for c in "abcdefghijklmnopqrstuvwxyz":
                    if c != word[i]:
                        neighbors.append(word[:i] + c + word[i + 1 :])
            return neighbors

        layer = {beginWord}
        parents = {beginWord: []}

        while layer and endWord not in parents:
            next_layer = set()
            for word in layer:
                for neighbor in get_neighbors(word):
                    if neighbor in word_set:
                        if neighbor not in parents:
                            next_layer.add(neighbor)
                            parents[neighbor] = [word]
                        elif neighbor in next_layer:
                            parents[neighbor].append(word)

            layer = next_layer
            word_set -= next_layer

        if endWord not in parents:
            return []

        result = []

        def dfs(word, path):
            if word == beginWord:
                result.append(path[::-1])
                return

            for parent in parents[word]:
                dfs(parent, path + [parent])

        dfs(endWord, [endWord])
        return result
