from typing import List

class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.word_map = {}

        for i, word in enumerate(wordsDict):
            if word not in self.word_map:
                self.word_map[word] = []
            self.word_map[word].append(i)
    
    def shortest(self, word1: str, word2: str) -> int:
        idx1 = self.word_map[word1]
        idx2 = self.word_map[word2]

        i = j = 0
        min_dist = float('inf')
        
        while i < len(idx1) and j < len(idx2):
            min_dist = min(min_dist, abs(idx1[i] - idx2[j]))

            if idx1[i] < idx2[j]: 
                i += 1
            else:
                j += 1

        return min_dist
    