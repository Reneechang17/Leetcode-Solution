# Time:O(nlogn), Space:O(m)

class Solution:
    def getKth(self, lo: int, hi: int, k: int) -> int:
        memo = {}

        def get_power(x):
            if x == 1:
                return 0
            
            if x in memo:
                return memo[x]
            
            if x % 2 == 0:
                # 1 is cur step
                # x -> next_x 
                # + recursion to get power
                power = 1 + get_power(x // 2)
            else:
                power = 1 + get_power(3 * x + 1)
            
            memo[x] = power
            return power

        arr = []
        for num in range(lo, hi + 1):
            power = get_power(num)
            arr.append((num, power))
        
        # sort
        arr.sort(key=lambda x: (x[1], x[0]))
        
        return arr[k - 1][0]
    