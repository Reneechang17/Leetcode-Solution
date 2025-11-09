# Medium
# Math
# Time:O(logn), Space:O(logn)
# https://leetcode.cn/problems/ip-to-cidr/

from typing import *

class Solution:
    def ipToCIDR(self, ip: str, n: int) -> List[str]:
        def ip_to_int(ip):
            parts = list(map(int, ip.split('.')))
            return parts[0] * 256**3 + parts[1] * 256**2 + parts[2] * 256 + parts[3]
        
        def int_to_ip(x):
            return f"{x // 256**3}.{(x // 256**2) % 256}.{(x // 256) % 256}.{x % 256}"
        
        start = ip_to_int(ip)
        res = []

        while n > 0:
            # (1,2,4,8,16...)
            max_size = 1

            while max_size * 2 <= n and start % (max_size * 2) == 0:
                max_size *= 2
            
            while max_size > n:
                max_size //= 2
            
            # CIDR: max_size = 2^k, CIDR suffix = 32-k
            k = 0
            tmp = max_size
            while tmp > 1:
                tmp //= 2
                k += 1
            length = 32 - k

            res.append(f"{int_to_ip(start)}/{length}")

            start += max_size # move to next uncovered IP
            n -= max_size # update covered numbers

        return res
