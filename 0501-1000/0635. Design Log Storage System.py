# Time:O(n), Space:O(n)

from typing import List

class LogSystem:

    def __init__(self):
        self.logs = []
        self.index = {
            "Year": 4,
            "Month": 7,
            "Day": 10,
            "Hour": 13,
            "Minute": 16,
            "Second": 19
        } 

    def put(self, id: int, timestamp: str) -> None:
        self.logs.append((timestamp, id))

    def retrieve(self, start: str, end: str, granularity: str) -> List[int]:
        idx = self.index[granularity]
        s = start[:idx]
        e = end[:idx]
        res = []
        for ts, logId in self.logs:
            if s <= ts[:idx] <= e:
                res.append(logId)
        
        return res
    