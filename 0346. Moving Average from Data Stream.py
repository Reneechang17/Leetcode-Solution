
from collections import deque

class MovingAverage:

    def __init__(self, size: int):
        self.size = size
        self.que = deque()
        self.window_sum = 0
        
    def next(self, val: int) -> float:
        self.que.append(val)
        self.window_sum += val

        if len(self.que) > self.size:
            left = self.que.popleft()
            self.window_sum -= left
        
        return self.window_sum / len(self.que)
