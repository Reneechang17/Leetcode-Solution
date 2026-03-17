# Time:O(logn),Space:O(1)

# class Solution:
#     def guessNumber(self, n: int) -> int:
#         left, right = 1, n
#         while left <= right:
#             mid = (left + right) // 2
#             res = guess(mid)
#             if res == 0:
#                 return mid
#             elif res == 1:
#                 left = mid + 1
#             else:
#                 right = mid - 1
#         return -1 # never execute

class GuessingGame:
    def __init__(self, pick):
        self.pick = pick

    def guess(self, num):
        if num > self.pick:
            return -1
        elif num < self.pick:
            return 1
        else:
            return 0
    
    def guessNumber(self, n):
        left, right = 1, n
        while left <= right:
            mid = (left + right) // 2
            res = self.guess(mid)
            if res == 0:
                return mid
            elif res == 1:
                left = mid + 1
            else:
                right = mid - 1
        return -1 # never execute      
    