# Time:O(dlogd), Space:O(d)

class Solution:
    def splitNum(self, num: int) -> int:
        # split num -> arr ["1","2","3","4"]
        # alternately assign values to the two num 
        digits = sorted(str(num))
        num1 = num2 = 0
        for i, d in enumerate(digits):
            if i % 2 == 0:
                num1 = num1 * 10 + int(d)
            else:
                num2 = num2 * 10 + int(d)
            
        return num1 + num2
    