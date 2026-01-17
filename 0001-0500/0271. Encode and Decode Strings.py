# Time:O(n), Space:O(n)

from typing import List

class Codec:
    def encode(self, strs: List[str]) -> str:
        """Encodes a list of strings to a single string."""
        res = []
        for s in strs:
            res.append(str(len(s)) + ":" + s)
        return "".join(res)

    def decode(self, s: str) -> List[str]:
        """Decodes a single string to a list of strings."""
        res = []
        i = 0
        while i < len(s):
            j = i
            while s[j] != ":":
                j += 1
            length = int(s[i:j])
            i = j + 1  # skip ':'
            res.append(s[i : i + length])
            i += length

        return res
