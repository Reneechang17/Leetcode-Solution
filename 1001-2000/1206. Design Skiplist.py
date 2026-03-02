# Time:O(logn), Space:O(n)

import random

class SkiplistNode:
    def __init__(self, val: int, level: int):
        self.val = val
        # forward[i]指当前节点在第i层的下一个节点
        self.forward = [None] * level

class Skiplist:
    MAX_LEVEL = 16
    P_FACTOR = 0.5

    def __init__(self):
        self.head = SkiplistNode(-1, self.MAX_LEVEL) # placeholder
        self.level = 0

    def _random_level(self) -> int:
        level = 1
        while random.random() < self.P_FACTOR and level < self.MAX_LEVEL:
            level += 1
        return level

    def _find(self, target: int):
        # 返回数组update，update[i]表示在第i层，小于target的最后一个节点
        update = [None] * self.MAX_LEVEL
        cur = self.head

        # 从高往低找
        for i in range(self.level - 1, -1, -1):
            while cur.forward[i] and cur.forward[i].val < target:
                cur = cur.forward[i]
            update[i] = cur
        return update

    def search(self, target: int) -> bool:
        # 指的就是最底层的下一个节点就是target
        update = self._find(target)
        node = update[0].forward[0] if update[0] else None
        return node is not None and node.val == target

    def add(self, num: int) -> None:
        update = self._find(num)
        lv = self._random_level()

        # 更新跳表的最高层数
        if lv > self.level:
            for i in range(self.level, lv):
                self.head.forward[i] = None
                update[i] = self.head
            self.level = lv

        new_node = SkiplistNode(num, lv)
        # 从低往高层插入节点
        for i in range(lv):
            new_node.forward[i] = update[i].forward[i]
            update[i].forward[i] = new_node

    def erase(self, num: int) -> bool:
        update = self._find(num)
        node = update[0].forward[0] if update[0] else None
        if node is None or node.val != num:
            return False

        for i in range(self.level):
            if update[i].forward[i] != node:
                break
            update[i].forward[i] = node.forward[i]
        
        # 如果最高层空了，更新最高层数
        while self.level > 1 and self.head.forward[self.level - 1] is None:
            self.level -= 1
        return True
    