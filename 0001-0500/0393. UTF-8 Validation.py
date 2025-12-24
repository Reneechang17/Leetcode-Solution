# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def validUtf8(self, data: List[int]) -> bool:
        n_bytes = 0

        # masks to check specific bit patterns
        mask1 = 1 << 7 # 10000000 - check if bit 7 is 1 
        mask2 = 1 << 6 # 01000000 - check if bit 6 is 1

        for num in data:
            # only look at the last 8 bits
            byte = num & 0xFF # 0xFF=11111111

            if n_bytes == 0:
                mask = 1 << 7 
                while mask & byte:
                    n_bytes += 1
                    mask >>= 1
                
                # case1: 1-byte character (0xxxxxxx)
                if n_bytes == 0:
                    continue

                # case2: Invalid patterns
                # - n_bytes == 1: cannot start with 10xxxxxx 
                # - n_bytes > 4: UTF-8 supports max 4 bytes
                if n_bytes == 1 or n_bytes > 4:
                    return False
                
                n_bytes -= 1
            else:
                if not (byte & mask1 and not (byte & mask2)):
                    return False
                
                n_bytes -= 1
        
        return n_bytes == 0
    