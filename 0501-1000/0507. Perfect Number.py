# Time:O(sqrt(n)), Space:O(1)

class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        if num <= 1:
            return False

        divisors_sum = 1

        i = 2
        while i * i <= num:
            if num % i == 0:
                divisors_sum += i
                if i != num // i:
                    # num // i is also a divisor
                    divisors_sum += num // i
            i += 1

        return divisors_sum == num
