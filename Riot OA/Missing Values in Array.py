"""
  Given an array of Integer, including 1-9, 
  some of the numbers are replaced with 0, return the missing numbers

  1. convert the input array to a set, range from 1 to 9, which can achieve O(1) lookup
  2. iterate from 1 to 9, find the missing number and add it to the result list

"""

def missing(nums):
  ans = []
  st = set(nums)

  for i in range(1, 10):
    if i not in st:
      ans.append(i)
    return ans

# Time: O(n)
# Space: O(1)
