"""
- Implement a price tracker:
  - addPrice(company, price): append a new price for the company
  - getPrice(company, k): return the k-th most recent price for that company (1 = latest)

Follow-ups:
  1) If k is limited to 5, optimize storage using a fixed-size ring buffer per company.
  2) If past prices can be added with timestamps, support event analytics:
     - Given event start/end times, find the busiest time (max concurrent events) using sweep line.
"""

from typing import Optional, List, Tuple
from collections import defaultdict

# Basic tracker -> O(1)
class PriceTracker:
    def __init__(self):
        self.data = defaultdict(list)
        
    def addPrice(self, company: str, price: float) -> None:
        self.data[company].append(price)
    
    def getPrice(self, company: str, k: int) -> Optional[float]:
        arr = self.data.get(company)
        if not arr or k <= 0 or k > len(arr):
            return None
        return arr[-k]

# Follow-up - using Ring Buffer: store latest 5 data
# Time:O(1), Space:O(cpy number * 5)
class PriceTrackerK5:
    def __init__(self, limit: int = 5):
        self.limit = limit
        self.buf = defaultdict(lambda: [None] * limit)
        self.size = defaultdict(int)
        self.write = defaultdict(int)
        
    def addPrice(self, company: str, price: float) -> None:
        i = self.write[company]
        self.buf[company][i] = price
        self.write[company] = (i + 1) % self.limit
        if self.size[company] < self.limit:
            self.size[company] += 1
    
    def getPrice(self, company: str, k: int) -> Optional[float]:
        n = self.size.get(company, 0)
        if n == 0 or k <= 0 or k > n:
            return None
        latest = (self.write[company] - 1) % self.limit
        idx = (latest - (k - 1)) % self.limit
        return self.buf[company][idx]

# busiest time (sweep line) -> O(nlogn)
def busiest_time(events: List[Tuple[int, int]]) -> Tuple[Optional[int], int]:
    diff = defaultdict(int)
    for start, end in events:
        diff[start] += 1
        diff[end] -= 1
    
    cur = best = 0
    best_time = None
    for t in sorted(diff):
        cur += diff[t]
        if cur > best:
            best = cur
            best_time = t
    return best_time, best

if __name__ == "__main__":
    pt = PriceTracker()
    pt.addPrice("TSLA", 100)
    pt.addPrice("TSLA", 150)
    pt.addPrice("TSLA", 120)
    print(pt.getPrice("TSLA", 2))  # 150

    pt5 = PriceTrackerK5()
    for p in [1,2,3,4,5,6]:
        pt5.addPrice("AAPL", p)
    print(pt5.getPrice("AAPL", 5))  # 2

    events = [(1,5), (2,6), (4,7)]
    print(busiest_time(events))  # (4, 3)
