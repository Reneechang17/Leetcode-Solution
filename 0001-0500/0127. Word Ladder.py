# Time:O(n * m * 26) , Space:O(n)

from collections import deque
from typing import List

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        word_set = set(wordList)
        if endWord not in word_set:
            return 0

        que = deque([(beginWord, 1)])
        vis = {beginWord}

        while que:
            word, steps = que.popleft()

            if word == endWord:
                return steps

            for i in range(len(word)):
                for c in "abcdefghijklmnopqrstuvwxyz":
                    new_word = word[:i] + c + word[i + 1 :]

                    if new_word in word_set and new_word not in vis:
                        vis.add(new_word)
                        que.append((new_word, steps + 1))

        return 0
