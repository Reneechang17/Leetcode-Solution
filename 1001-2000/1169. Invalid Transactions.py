# Time:O(n) worse:O(n²), Space:O(n)

from typing import List
from collections import defaultdict

class Solution:
    def invalidTransactions(self, transactions: List[str]) -> List[str]:
        # trans[i] = (name, time, amt, city, origin_str)
        trans = []
        for s in transactions:
            name, t, amt, city = s.split(',')
            trans.append((name, int(t), int(amt), city, s))
        
        group = defaultdict(list)
        for i, (name, _, _, _, _) in enumerate(trans):
            group[name].append(i)
        
        invalid = set()

        for i, (_, _, amt, _, _) in enumerate(trans):
            if amt > 1000:
                invalid.add(i)
            
        for name, idx in group.items():
            n = len(idx)
            for a in range(n):
                i = idx[a]
                _, t1, _, c1, _ = trans[i]

                # only check each pair once
                for b in range(a + 1, n):
                    j = idx[b]
                    _, t2, _, c2, _ = trans[j]

                    if abs(t1 - t2) <= 60 and c1 != c2:
                        invalid.add(i)
                        invalid.add(j)
        
        res = []
        for i in range(len(transactions)):
            if i in invalid:
                res.append(transactions[i])
        
        return res
    