# Queue -> FIFO

class CircularQueue:
    def __init__(self, k: int):
        self.capacity = k
        self.que = [0] * k
        self.front = 0 # front pointer-> earliest element
        self.rear = -1 # rear pointer -> latest element
        self.size = 0

    def enqueue(self, value: int) -> bool:
        if self.is_full():
            return False
        
        # move rear pointer to insert new element
        self.rear = (self.rear + 1) % self.capacity
        self.que[self.rear] = value
        self.size += 1
        return True
    
    def dequeue(self) -> int:
        if self.is_empty():
            return False
        
        # get the earliest value(front pointer)
        value = self.que[self.front]
        self.front = (self.front + 1) % self.capacity
        self.size -= 1
        return value
    
    def peek_front(self) -> int:
        if self.is_empty():
            return -1
        return self.que[self.front]
    
    def peek_rear(self) -> int:
        if self.is_empty():
            return -1
        return self.que[self.rear]

    def is_empty(self):
        return self.size == 0
    
    def is_full(self):
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
    
# Test cases
if __name__ == "__main__":
    # Test 1: Basic operations
    print("Test 1: Basic operations")
    q = CircularQueue(3)
    writer = Writer(q)
    reader = Reader(q)
    
    print(writer.write(1))  # True
    print(writer.write(2))  # True
    print(writer.write(3))  # True
    print(writer.write(4))  # False (full)
    print(reader.get_front())  # 1
    print(reader.get_rear())  # 3
    print(reader.read())  # 1
    print(writer.write(4))  # True
    print(reader.get_rear())  # 4
    print()
    
    # Test 2: Empty queue
    print("Test 2: Empty queue")
    q2 = CircularQueue(2)
    writer2 = Writer(q2)
    reader2 = Reader(q2)
    
    print(q2.is_empty())  # True
    print(reader2.read())  # False
    print(reader2.get_front())  # -1
    print()
    
    # Test 3: Circular behavior
    print("Test 3: Circular behavior")
    q3 = CircularQueue(3)
    writer3 = Writer(q3)
    reader3 = Reader(q3)
    
    writer3.write(1)
    writer3.write(2)
    writer3.write(3)
    print(reader3.read())  # 1
    print(reader3.read())  # 2
    writer3.write(4)
    writer3.write(5)
    print(reader3.get_front())  # 3
    print(reader3.get_rear())  # 5
    print(q3.is_full())  # True
    print()
    
    # Test 4: Single element
    print("Test 4: Single element")
    q4 = CircularQueue(1)
    writer4 = Writer(q4)
    reader4 = Reader(q4)
    
    print(writer4.write(100))  # True
    print(q4.is_full())  # True
    print(reader4.get_front())  # 100
    print(reader4.get_rear())  # 100
    print(reader4.read())  # 100
    print(q4.is_empty())  # True
    