# Time:O(len(n)), Space:O(len(s))

class Solution:
    def confusingNumber(self, n: int) -> bool:
        mapping = {'0':'0', '1':'1', '6':'9', '8':'8', '9':'6'}
        s = str(n)
        nums = []

        for c in s[::-1]:
            if c not in mapping:
                return False
            nums.append(mapping[c])
        
        new_n = int(''.join(nums))
        return new_n != n
    