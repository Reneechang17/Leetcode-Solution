# Easy
# Stack, String
# O(n)
# https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

class Solution:
    def removeDuplicates(self, s: str) -> str:
        result = list()
        
        for item in s:
            if result and result[-1] == item:
                result.pop()
            else:
                result.append(item)
        return "".join(result)

# 思路：棧
# 可以用棧來存放已經遍歷過的元素，當遍歷一個元素時，先去棧找一下有沒有出現過相同值的相鄰元素
# Note：由於棧的出棧順序是倒過來的，最後要把String反轉一下