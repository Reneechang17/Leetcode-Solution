"""
Binary String Permutations with Wildcard '?'

Given a binary string containing '0', '1', or '?' where '?' can be replaced by '0' or '1'.
Return all possible strings after replacing all wildcards.

Example:
"0?" -> ["00", "01"]
"0?1" -> ["001", "011"]
"0??1" -> ["0001", "0011", "0101", "0111"]
"""

# Time:O(2^k * n), Space:O(2^k * n)

from collections import deque

# BFS
def wildcard_permutations_bfs(s: str) -> list[str]:
    if not s:
        return []
    
    que = deque([''])
    for c in s:
        for _ in range(len(que)):
            cur = que.popleft()
            if cur == '?':
                que.append(cur + '0')
                que.append(cur + '1')
            else:
                que.append(cur + c)

    return list(que)

# DFS + backtracking
def wildcard_permutations_dfs(s: str) -> list[str]:
    res = []
    n = len(s)

    def backtracking(i, path):
        if i == n:
            res.append(''.join(path))
            return
        
        if s[i] == '?':
            path.append('0')
            backtracking(i + 1, path)
            path.pop()

            path.append('1')
            backtracking(i + 1, path)
            path.pop()
        else:
            path.append(s[i])
            backtracking(i + 1, path)
            path.pop()

    backtracking(0, [])
    return res
