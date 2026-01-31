'''
Problem: Card Draw Probability
Given a deck of cards (integer array, may contain duplicates), 
draw k cards without replacement. Player wins if sum equals target.
Return probability of winning.

Examples:
Input: deck = [1, 2, 3, 4], k = 2, target = 5
Output: 0.3333
Explanation:
All possible 2-card draws:
[1,2]=3, [1,3]=4, [1,4]=5, [2,3]=5, [2,4]=6, [3,4]=7
Favorable draws = {[1,4], [2,3]} → 2 out of 6
Probability = 2/6 = 0.3333

- Total combinations = C(n, k) = n! / (k! * (n-k)!)
  This counts all possible ways to choose k cards from n
- Probability = favorable_combinations / total_combinations
- DP counts favorable combinations without generating all combinations
'''

from typing import List
from collections import defaultdict
from math import comb


# Time:O(n*k*S), Space:O(k*S)
def winning_possibility(k: int, target: int, deck: List[int]) -> float:
    n = len(deck)

    if k < 0 or k > n:
        return 0.0

    # dp[c][s] number of ways to choose exactly c cards and their sum is s
    dp = [defaultdict(int) for _ in range(k + 1)]
    dp[0][0] = 1 # 0 card -> sum = 0

    # pass each card once
    for val in deck:
        # iterate backward to avoid using the same card
        # the new card can only consider match the card didn't use (each card only use once)
        for c in range(k, 0, -1):
            for s, cnt in list(dp[c - 1].items()):
                dp[c][s + val] += cnt

    fav = dp[k][target]
    total = comb(n, k)
    return fav / total if total > 0 else 0.0

if __name__ == "__main__":
    # Test 1: Basic example
    deck1 = [1, 2, 3, 4]
    result1 = winning_possibility(2, 5, deck1)
    print(f"Test 1: {result1:.4f} (expected: 0.3333)")
    
    # Test 2: Duplicate cards
    deck2 = [2, 2, 3]
    result2 = winning_possibility(2, 4, deck2)
    print(f"Test 2: {result2:.4f} (expected: 0.3333)")
    
    # Test 3: All same cards
    deck3 = [1, 1, 1, 1]
    result3 = winning_possibility(2, 2, deck3)
    print(f"Test 3: {result3:.4f} (expected: 1.0000)")
    
    # Test 4: Negative values
    deck4 = [5, -1, 2, 4]
    result4 = winning_possibility(2, 3, deck4)
    print(f"Test 4: {result4:.4f} (expected: 0.1667)")
