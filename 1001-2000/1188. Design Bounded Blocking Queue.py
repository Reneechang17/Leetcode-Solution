# Medium
# Concurrency
# Time:O(1), Space:O(capacity)
# https://leetcode.cn/problems/design-bounded-blocking-queue/

import threading

class BoundedBlockingQueue(object):

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.que = deque()
        self.lock = threading.Lock()
        self.not_full = threading.Condition(self.lock)
        self.not_empty = threading.Condition(self.lock)
        
    def enqueue(self, element: int) -> None:
        with self.not_full:
            while len(self.que) >= self.capacity:
                self.not_full.wait()
            
            self.que.append(element)
            self.not_empty.notify() # wake up dequeue

    def dequeue(self) -> int:
        with self.not_empty:
            while len(self.que) == 0:
                self.not_empty.wait()

            element = self.que.popleft()
            self.not_full.notify()
            return element

    def size(self) -> int:
        with self.lock:
            return len(self.que)
        