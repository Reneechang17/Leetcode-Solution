# Hard
# Stack, Map
# Time:O(1), Space:O(n)
# https://leetcode.cn/problems/maximum-frequency-stack/

class FreqStack:

    def __init__(self):
        self.freq = {} # element -> freq
        self.group = {} # freq -> it's freq stack
        self.max_freq = 0
        
    def push(self, val: int) -> None:
        # update freq
        self.freq[val] = self.freq.get(val, 0) + 1
        f = self.freq[val]

        # add to corresponding stack
        if f not in self.group:
            self.group[f] = []
        self.group[f].append(val)

        # update max freq
        self.max_freq = max(self.max_freq, f)

    def pop(self) -> int:
        val = self.group[self.max_freq].pop()
        self.freq[val] -= 1
        
        if not self.group[self.max_freq]:
            self.max_freq -= 1
        
        return val    
