# Time:O(n²), Space:O(n²)

from typing import List
class Solution:
    def unhappyFriends(self, n: int, preferences: List[List[int]], pairs: List[List[int]]) -> int:
        d = [[0] * n for _ in range(n)]

        # preference[0]=[1,2,3]
        # d[0][1]=0
        # d[0][2]=1
        # d[0][3]=2
        for i in range(n):
            for j in range(n - 1):
                friend = preferences[i][j]
                d[i][friend] = j

        # pairs=[[0,1],[2,3]]
        # p[0]=1, p[1]=0
        # p[2]=3, p[3]=2
        p = [0] * n
        for x, y in pairs:
            p[x] = y
            p[y] = x

        ans = 0

        for x in range(n):
            y = p[x]

            priority_y = d[x][y]

            for i in range(priority_y):
                u = preferences[x][i]
                v = p[u]

                if d[u][x] < d[u][v]:
                    ans += 1
                    break # x is unhappy
        return ans
        