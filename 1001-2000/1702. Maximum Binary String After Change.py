# Time:O(n), Space:O(n1727. Largest Submatrix With Rearrangements)

class Solution:
    def maximumBinaryString(self, binary: str) -> str:
        n = len(binary)
        zeros = binary.count('0')

        if zeros <= 1:
            return binary
        
        first_zero = binary.find('0')

        res = ['1'] * n
        res[first_zero + zeros - 1] = '0'

        return ''.join(res)
    