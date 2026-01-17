# Time:O(n^m), Space:O(m)

class Solution:
    def wordPatternMatch(self, pattern: str, s: str) -> bool:
        char_to_word = {}
        word_to_char = {}

        def backtracking(p_idx, s_idx):
            if p_idx == len(pattern) and s_idx == len(s):
                return True

            if p_idx == len(pattern) or s_idx == len(s):
                return False

            char = pattern[p_idx]

            if char in char_to_word:
                word = char_to_word[char]
                if s[s_idx:].startswith(word):
                    return backtracking(p_idx + 1, s_idx + len(word))
                return False

            for end in range(s_idx + 1, len(s) + 1):
                word = s[s_idx:end]

                if word in word_to_char:
                    continue

                char_to_word[char] = word
                word_to_char[word] = char

                if backtracking(p_idx + 1, end):
                    return True

                del char_to_word[char]
                del word_to_char[word]

            return False

        return backtracking(0, 0)
