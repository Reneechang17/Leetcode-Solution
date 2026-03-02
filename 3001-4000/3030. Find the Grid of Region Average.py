# Time:O(mn), Space:O(mn)

from typing import List

class Solution:
    def resultGrid(self, image: List[List[int]], threshold: int) -> List[List[int]]:
        m, n = len(image), len(image[0])
        cnt = [[0] * n for _ in range(m)]
        total = [[0] * n for _ in range(m)]

        for i in range(m - 2):
            for j in range(n - 2):
                valid = True
                for r in range(i, i + 3):
                    for c in range(j, j + 2):
                        if abs(image[r][c] - image[r][c + 1]) > threshold:
                            valid = False
                            break
                    if not valid:
                        break
                if not valid:
                    continue
                
                for c in range(j, j + 3):
                    for r in range(i, i + 2):
                        if abs(image[r][c] - image[r + 1][c]) > threshold:
                            valid = False
                            break
                    if not valid:
                        break
                if not valid:
                    continue
                
                region_sum = 0
                for r in range(i, i + 3):
                    for c in range(j, j + 3):
                        region_sum += image[r][c]
                avg = region_sum // 9

                for r in range(i, i + 3):
                    for c in range(j, j + 3):
                        cnt[r][c] += 1
                        total[r][c] += avg
        
        res = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if cnt[i][j] > 0:
                    res[i][j] = total[i][j] // cnt[i][j]
                else:
                    res[i][j] = image[i][j]
        
        return res
    