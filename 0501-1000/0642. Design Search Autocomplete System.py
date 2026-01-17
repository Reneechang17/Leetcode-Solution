# Time:O(nlogn), Space:O(nL)

from typing import List

class AutocompleteSystem:

    def __init__(self, sentences: List[str], times: List[int]):
        self.freq = {}
        for i in range(len(sentences)):
            self.freq[sentences[i]] = times[i]
        self.cur_prefix = ""

    def input(self, c: str) -> List[str]:
        if c == "#":
            if self.cur_prefix in self.freq:
                self.freq[self.cur_prefix] += 1
            else:
                self.freq[self.cur_prefix] = 1
            self.cur_prefix = ""
            return []

        self.cur_prefix += c

        matches = []
        for sentence in self.freq:
            if sentence.startswith(self.cur_prefix):
                matches.append((sentence, self.freq[sentence]))

        matches.sort(key=lambda x: (-x[1], x[0]))

        res = []
        for i in range(min(3, len(matches))):
            res.append(matches[i][0])
        return res
    