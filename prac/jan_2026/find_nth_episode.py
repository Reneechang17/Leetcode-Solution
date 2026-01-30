"""
We have 10 TV episodes. After each episode, some users churn.
Given retention rate per episode r[i] (probability user continues),
find the earliest episode n such that users who pass episode n
still have >= 70% chance to finish episode 10.

Follow-ups:
1) All users drop after episode 1
2) All users watch all episodes
3) Remove explicit if-logic via functional style
"""

from typing import Optional, List
import math

# TODO
# basic
def find_episode(retention: List[float], threshold: float = 0.7) -> Optional[int]:
    prod = 1.0
    for i in range(len(retention) - 1, -1, -1):
        if prod >= threshold:
            return i + 1
        prod *= retention[i]
    return 1 if prod >= threshold else None

# follow-up 1
def case_full_drop_first():
    r = [0.0] + [0.9] * 9
    return find_episode(r)

# follow-up 2
def case_all_watch():
    r = [1.0] * 10
    return find_episode(r)

# follow-up 3
def find_episode_no_if(retention: List[float], threshold: float = 0.7) -> Optional[int]:
    logs = []
    prod = 1.0
    for x in reversed(retention):
        prod *= x
        logs.append(math.log(prod))
    logs.reverse()
    th = math.log(threshold)
    return next((i + 1 for i, v in enumerate(logs) if v >= th), None)

if __name__ == "__main__":
    print("=== Normal Case ===")
    r = [0.95,0.92,0.90,0.88,0.85,0.83,0.82,0.80,0.78,0.75]
    print(find_episode(r))          # expected: some middle episode

    print("\n=== Follow-up 1 ===")
    print(case_full_drop_first())   # expected: None

    print("\n=== Follow-up 2 ===")
    print(case_all_watch())         # expected: 10

    print("\n=== Follow-up 3 ===")
    print(find_episode_no_if(r))    # same as main result
