# Time:O(2ⁿ), Space:O(n)

class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        self.res = ""
        self.cnt = 0
        
        def backtracking(cur):
            # check if reach k
            if len(cur) == n:
                self.cnt += 1
                if self.cnt == k:
                    self.res = cur
                return

            # if not the same as prev, try it
            for c in ['a', 'b', 'c']:
                if not cur or c != cur[-1]:
                    backtracking(cur + c)
                    if self.res:
                        return
        
        backtracking("")
        return self.res
    