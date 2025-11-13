# src: https://www.1point3acres.com/bbs/thread-1081447-1-1.html

from typing import *

class RevenueSys:

    def __init__(self):
        self.next = 1 # incre id
        self.own = {} # id -> own revenue
        self.total = {} # id -> total(own + direct refer)
        self.idx = [] # sorted list of (total, id) asc
        self.parent = {} # child -> referrer 

    # helper func: binary search, ins, del on sorted arr, O(logn)
    def binary_search(self, a: List[Tuple[int, int]], t: int, i: int) -> int:
        # find the first >= (total,index) position
        left, right = 0, len(a)
        key = (t, i)
        while left < right:
            mid = (left + right) // 2
            if a[mid] < key:
                left = mid + 1
            else:
                right = mid

        return left
    
    # O(n)
    def ins(self, t: int, i: int) -> None:
        p = self.binary_search(self.idx, t, i)
        self.idx.insert(p, (t, i))
    
    def rm(self, t: int, i: int) -> None:
        p = self.binary_search(self.idx, t, i)
        if p < len(self.idx) and self.idx[p] == (t, i):
            self.idx.pop(p)
    
    # O(n)
    def insert(self, rev: int, ref: Optional[int] = None) -> int:
        cid = self.next
        self.next += 1
        self.own[cid] = rev
        self.total[cid] = rev
        self.ins(rev, cid)

        if ref is not None:
            self.parent[cid] = ref
            old = self.total.get(ref, 0)
            self.rm(old, ref)
            new = old + rev
            self.total[ref] = new
            self.ins(new, ref)
        return cid
    

    # v1: top k with total < threshold, O(log n + k)
    def get_top_k_below(self, k: int, threshold: int) -> List[int]:
        res = []
        p = self.binary_search(self.idx, threshold, -1) # first >= threshold
        i = p - 1
        while i >= 0 and len(res) < k:
            res.append(self.idx[i][1])
            i -= 1
        return res
    
    # v2: top k with total >= min_rev, O(log n + k)
    def get_top_k_revenue(self, k: int, min_rev: int) -> List[int]:
        res = []
        p = self.binary_search(self.idx, min_rev, -1) # first >= min_rev
        i = len(self.idx) - 1
        while i >= p and len(res) < k:
            res.append(self.idx[i][1])
            i -= 1
        return res
