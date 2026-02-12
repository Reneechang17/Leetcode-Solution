# Time:O(n logn), Space:O(n)

from typing import List

class Solution:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        folder.sort()
        res = []
        prev = None

        for path in folder:
            # skip sub-folders
            if not prev or not path.startswith(prev + '/'):
                res.append(path)
                prev = path
        
        return res
    