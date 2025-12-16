# Time:O(n), Space:O(n)

from typing import *
from collections import defaultdict

class Solution:
    def invalidTransactions(self, transactions: List[str]) -> List[str]:
        trans = []
        for t in transactions:
            parts = t.split(',')
            name, time, amount, city = parts[0], int(parts[1]), int(parts[2]), parts[3]
            trans.append((name, time, amount, city, t))
        
        group = defaultdict(list)
        for i, (name, time, amount, city, original) in enumerate(trans):
            group[name].append(i)
        
        invalid = set()

        for i, (name, time, amount, city, original) in enumerate(trans):
            if amount > 1000:
                invalid.add(i)
            
            for j in group[name]:
                if i != j:
                    _, time2, _, city2, _ = trans[j]
                    if abs(time - time2) <= 60 and city != city2:
                        invalid.add(i)
                        invalid.add(j)
                        
        return [trans[i][4] for i in invalid]
    