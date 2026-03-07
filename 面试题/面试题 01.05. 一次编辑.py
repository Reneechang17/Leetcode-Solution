# Time:O(n), Space:O(1)

class Solution:
    def oneEditAway(self, first: str, second: str) -> bool:
        if abs(len(first) - len(second)) > 1:
            return False
        
        # let first always longer
        if len(first) < len(second):
            first, second = second, first
        
        for i in range(len(second)):
            if first[i] != second[i]:
                # len are same -> replace
                if len(first) == len(second):
                    return first[i+1:] == second[i+1:]
                else:
                    # len diff is 1, del char in first
                    return first[i+1:] == second[i:]
        return True
    