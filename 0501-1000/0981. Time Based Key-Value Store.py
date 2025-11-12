# Medium
# Map, Binary search
# https://leetcode.cn/problems/time-based-key-value-store/

class TimeMap:

    def __init__(self):
        self.store = {} # {key: [(timestamp, value), ...]}
    
    # Time: O(1)
    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.store:
            self.store[key] = []
        self.store[key].append((timestamp, value))

    # Time: O(log n)
    def get(self, key: str, timestamp: int) -> str:
        if key not in self.store:
            return ""
        
        arr = self.store[key]
        # use binary search to find the max val <= timestamp
        left, right = 0, len(arr) - 1
        res = ""

        while left <= right:
            mid = (left + right) // 2
            if arr[mid][0] <= timestamp:
                res = arr[mid][1] # update res
                left = mid + 1
            else:
                right = mid - 1

        return res
