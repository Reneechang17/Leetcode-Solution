'''
Minimum Steps to Reach Target
Start: n = 1
Operations: 1. n = n × 2  2. n = n ÷ 3 (integer division)
Find: Min steps to reach target t

Approach: BFS from 1 to t
Why BFS? BFS finds shortest path in unweighted graph
Graph nodes: integers, edges: ×2 and ÷3 operations
'''

from collections import deque

# Time:O(t), Space:O(t)

def min_steps_to_target(t: int) -> int:
    if t == 1:
        return 0
    
    que = deque([(1, 0)]) # (cur, steps)
    vis = {1}

    while que:
        cur, steps = que.popleft()

        # ops - *2 
        next = cur * 2
        if next == t:
            return steps + 1
        # don't go too far
        if next not in vis:
            vis.add(next)
            que.append((next, steps + 1))

        # ops - /3
        next = cur // 3
        if next > 0:
            if next == t:
                return steps + 1
            if next > 0 and next not in vis:
                vis.add(next)
                que.append((next, steps + 1))
    
    return -1 # never

if __name__ == "__main__":
    print("Test 1: t=1 →", min_steps_to_target(1), "(expected: 0)")
    print("Test 2: t=2 →", min_steps_to_target(2), "(expected: 1)")
    print("Test 3: t=10 →", min_steps_to_target(10), "(expected: 6)")
    print("Test 4: t=3 →", min_steps_to_target(3), "(expected: 7)")
    print("Test 5: t=6 →", min_steps_to_target(6), "(expected: 8)")
