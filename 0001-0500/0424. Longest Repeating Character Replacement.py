# Time:O(n), Space:O(1)

class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        left = 0
        max_freq = 0
        count = {}
        max_len = 0

        for right in range(len(s)):
            count[s[right]] = count.get(s[right], 0) + 1
            max_freq = max(max_freq, count[s[right]])

            while (right - left + 1) - max_freq > k:
                count[s[left]] -= 1
                left += 1

            max_len = max(max_len, right - left + 1)

        return max_len
    
class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        count = [0] * 26
        left = 0
        max_count = 0
        res = 0

        for right in range(len(s)):
            idx = ord(s[right]) - ord("A")
            count[idx] += 1
            max_count = max(max_count, count[idx])

            if (right - left + 1) - max_count > k:
                left_idx = ord(s[left]) - ord("A")
                count[left_idx] -= 1
                left += 1

            res = max(res, right - left + 1)

        return res
