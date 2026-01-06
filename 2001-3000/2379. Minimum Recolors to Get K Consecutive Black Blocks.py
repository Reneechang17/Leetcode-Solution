# Time:O(n), Space:O(1)

class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        w_count = blocks[:k].count("W")
        min_ops = w_count

        for i in range(k, len(blocks)):
            if blocks[i - k] == "W":
                w_count -= 1
            if blocks[i] == "W":
                w_count += 1

            min_ops = min(min_ops, w_count)

        return min_ops
