# Time:O(n*m), Space:O(k)

from typing import List, Counter

class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        if not s or not words:
            return []

        word_len = len(words[0])
        word_count = len(words)
        total_len = word_len * word_count
        word_freq = Counter(words)
        res = []

        for i in range(word_len):
            left, right = i, i
            cur_freq = Counter()

            while right + word_len <= len(s):
                word = s[right : right + word_len]
                right += word_len

                if word in word_freq:
                    cur_freq[word] += 1

                    while cur_freq[word] > word_freq[word]:
                        left_word = s[left : left + word_len]
                        cur_freq[left_word] -= 1
                        left += word_len

                    if right - left == total_len:
                        res.append(left)
                else:
                    cur_freq.clear()
                    left = right

        return res
