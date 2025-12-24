# Time:O(nlogn+nL), Space:O(n+C)

class Solution:
    def getKth(self, lo: int, hi: int, k: int) -> int:
        cache = {} # cache[x]=power of x

        def get_power(x):
            if x == 1:
                return 0
            if x in cache:
                return cache[x]
            
            # calculate power
            if x % 2 == 0:
                power = 1 + get_power(x // 2)
            else:
                power = 1 + get_power(3 * x + 1)
            
            cache[x] = power
            return power
        
        # array of (number, power)
        arr = []
        for num in range(lo, hi + 1):
            power = get_power(num)
            arr.append((num, power))
        
        # sort by power, if same, sort by number
        arr.sort(key=lambda x: (x[1], x[0]))
        return arr[k - 1][0] # 0-indexed
    