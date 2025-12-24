class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        if num <= 1:
            return False
        
        divisor_sum = 1 # 1 is always a divisor
        
        i = 2
        while i * i <= num:
            if num % i == 0:
                divisor_sum += i

                # num/i is also a divisor
                if i * i != num:
                    divisor_sum += num // i
            i += 1
        
        return divisor_sum == num
