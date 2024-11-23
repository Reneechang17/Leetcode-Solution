"""
  Give an Integer Array, which includes number from 1 to 9, 
  but some numbers are replaced with 0, return the missing numbers.

  1. turn array to a set, range from 1 to 9, which can achieve O(1) lookup
  2. iterate from 1 to 9, if the num is not found in set, that is the missing value

"""

def missing(nums):
  ans = []
  st = set(nums)

  for i in range(1, 10):
    if i not in st:
      ans.append(i)
    return ans

# Time:O(9)=>O(1), n only has 9 numbers
# Space:O(9)=>O(1), set only store 9 numbers, the duplicate will be filtered out
