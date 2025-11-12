# Lc 1146

class SnapshotArray:

    def __init__(self, length: int):
        # each index store history version [(snap_id, value)]
        self.history = [[(0, 0)] for _ in range(length)]
        self.snap_id = 0

    def set(self, index: int, value: int) -> None:
        # if cur snap_id has record -> update, otherwise -> append
        if self.history[index][-1][0] == self.snap_id:
            self.history[index][-1] = (self.snap_id, value)
        else:
            self.history[index].append((self.snap_id, value))

    def snap(self) -> int:
        self.snap_id += 1
        return self.snap_id - 1
    
    def get(self, index: int, snap_id: int) -> int:
        # binary search to find the biggest version which <= snap_id
        arr = self.history[index]
        left, right = 0, len(arr) - 1

        while left < right:
            mid = (left + right + 1) // 2
            if arr[mid][0] <= snap_id:
                left = mid
            else:
                right = mid - 1
        
        return arr[left][1]
