from typing import *

class SluggishArray:
    # map(fn): record the transform but do not apply it imeediately
    # getIndexOf(value): scan left to right, for each element apply all recorded transfroms in order
    # and stop at the first match

    def __init__(self, data):
        self._data = list(data) # original data, keep unchanged
        self._maps = [] # list of transform func reordered by map()
        # the list of transform func recorded by map()
        self._composed = None # None= not built yet or invalid

    def map(self, fn):
        # return self so the caller can chain: arr.map(f).map(g)
        self._maps.append(fn)
        # any time the pipeline changes, the prev cached composition -> outdated
        # we mark it invalid so getIndexOf() will rebuild it exactly once on demand
        self._composed = None
        return self
    
    def _ensure_composed(self):
        # compose all recorded maps into single func(cache in _composed)
        if self._composed is not None:
            return
        
        def composed(x):
            for f in self._maps:
                x = f(x) # preserve the order of map() calls
            return x
        
        self._composed = composed
    
    def getIndexOf(self, value):
        # find the first index i such that composed(data[i]) == value
        self._ensure_composed()
        comp = self._composed

        # if no maps were added, comp still works
        for i, x in enumerate(self._data):
            if comp(x) == value:
                return i
        return -1

# Test
if __name__ == "__main__":
    # 1) no maps
    arr = SluggishArray([1, 2, 3, 2])
    print(arr.getIndexOf(3))  # 2
    print(arr.getIndexOf(9))  # -1

    # 2) one map, lazy early stop:
    #    data [1,2,3,2], map(*2), find 4 -> only need to check index 0 and 1
    calls = {"cnt": 0}
    def times2(x):
        calls["cnt"] += 1
        return x * 2

    arr = SluggishArray([1, 2, 3, 2]).map(times2)
    print(arr.getIndexOf(4))     # 1
    print(calls["cnt"])          # should be 2 (lazy prefix only)

    # 3) chained maps, order matters: (x*2)+1 on single value [2] -> 5
    c1 = {"cnt": 0}
    def mul2(x):
        c1["cnt"] += 1
        return x * 2
    c2 = {"cnt": 0}
    def plus1(x):
        c2["cnt"] += 1
        return x + 1

    arr = SluggishArray([2]).map(mul2).map(plus1)
    print(arr.getIndexOf(5))     # 0
    print(c1["cnt"], c2["cnt"])  # 1 1

    # 4) not found -> must scan all
    calls = {"cnt": 0}
    def mul2_again(x):
        calls["cnt"] += 1
        return x * 2
    arr = SluggishArray([1, 2, 3]).map(mul2_again)
    print(arr.getIndexOf(7))     # -1
    print(calls["cnt"])          # 3 (scanned all)
