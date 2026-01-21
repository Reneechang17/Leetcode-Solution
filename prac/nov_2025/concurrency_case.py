import threading

# Coarse-grained lock

class CircularQueue:
    def __init__(self, k: int):
        self.capacity = k
        self.que = [0] * k
        self.front = 0 # front pointer-> earliest element
        self.rear = -1 # rear pointer -> latest element
        self.size = 0
        self.lock = threading.Lock()

    def enqueue(self, value: int) -> bool:
        with self.lock:
            if self.is_full():
                return False
        
            # move rear pointer to insert new element
            self.rear = (self.rear + 1) % self.capacity
            self.que[self.rear] = value
            self.size += 1
            return True
    
    def dequeue(self) -> int:
        with self.lock:
            if self.is_empty():
                return False
        
            # get the earliest value(front pointer)
            value = self.que[self.front]
            self.front = (self.front + 1) % self.capacity
            self.size -= 1
            return value
    
    def peek_front(self) -> int:
        with self.lock:
            if self.is_empty():
                return -1
            return self.que[self.front]
    
    def peek_rear(self) -> int:
        with self.lock:
            if self.is_empty():
                return -1
            return self.que[self.rear]

    def is_empty(self):
        with self.lock:
            return self.size == 0
    
    def is_full(self):
        with self.lock:
            return self.size == self.capacity
    
class Writer:
    def __init__(self, queue: CircularQueue):
        self.queue = queue

    def write(self, value: int) -> bool:
        return self.queue.enqueue(value)

class Reader:
    def __init__(self, queue: CircularQueue):
        self.queue = queue
    
    def read(self) -> int:
        # read and return front value(FIFO)
        return self.queue.dequeue()
    
    def get_front(self) -> int:
        return self.queue.peek_front()

    def get_rear(self) -> int:
        return self.queue.peek_rear()