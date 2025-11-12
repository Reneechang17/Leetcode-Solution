class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        
        from collections import Counter
        c1 = Counter(s1)
        window = Counter()

        for i in range(len(s2)):
            window[s2[i]] += 1

            # if window size over len(s1), remove left
            if i >= len(s1):
                left = s2[i - len(s1)]
                window[left] -= 1
                if window[left] == 0:
                    del window[left]

            if window == c1:
                return True
        
        return False
