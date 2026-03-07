# Time:O(n), Space:O(n)
# 如果题目限制在S上修改（也就是space:O(1))的话
# 原则上在py实现不了因为str不可变，如果硬要实现只能模拟
# 把str转成list，用双指针模拟写入

class Solution:
    def replaceSpaces(self, S: str, length: int) -> str:
        return S[:length].replace(' ', '%20')
    