# Time:O(n), Space:O(1)

class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        n = len(s)
        if n % 2 != 0:
            return False

        balance = 0
        flexible = 0

        for i in range(n):
            if locked[i] == "0":
                flexible += 1
            elif s[i] == "(":
                balance += 1
            else:
                if balance > 0:
                    balance -= 1
                elif flexible > 0:
                    flexible -= 1
                else:
                    return False

        balance = 0
        flexible = 0

        for i in range(n - 1, -1, -1):
            if locked[i] == "0":
                flexible += 1
            elif s[i] == ")":
                balance += 1
            else:
                if balance > 0:
                    balance -= 1
                elif flexible > 0:
                    flexible -= 1
                else:
                    return False

        return True
