# Time:O(nlogn), Space:O(nL)

from typing import List

class AutocompleteSystem:

    def __init__(self, sentences: List[str], times: List[int]):
        # sentences -> freq
        self.freq = {}

        for i in range(len(sentences)):
            self.freq[sentences[i]] = times[i]
        
        self.current = ""

    def input(self, c: str) -> List[str]:
        if c == '#':
            if self.current in self.freq:
                self.freq[self.current] += 1
            else:
                self.freq[self.current] = 1
            
            self.current = ""
            return []
        
        self.current += c

        matches = []
        for sentence in self.freq:
            if sentence.startswith(self.current):
                matches.append((sentence, self.freq[sentence]))
        
        # sort by freq, then lexicographical
        matches.sort(key=lambda x: (-x[1], x[0]))

        res = []
        for i in range(min(3, len(matches))):
            res.append(matches[i][0])

        return res
    