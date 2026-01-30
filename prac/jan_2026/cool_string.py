"""
Cool String Validator

A string is "cool" if either:
1. All characters have the same frequency
2. OR we can remove exactly one character to make all frequencies equal

Examples:
"aaabbb" -> True (a:3, b:3)
"aaabbbcccc" -> True (remove 1 'c': a:3, b:3, c:3)
"aaabbbccccdddd" -> False (would need to remove 1 c AND 1 d)
"aabbcccdddeeee" -> False (would need multiple removals)
"""

from collections import Counter

# Time:O(n, Space:O(k)
def is_cool_str(s: str) -> bool:
    if not s:
        return True
    
    freq = Counter(s)
    count_freq = Counter(freq.values()) # {freq: how many char has this freq}

    if len(count_freq) == 1:
        return True
    
    if len(count_freq) > 2:
        return False
    
    # now we have two freq
    (f1, c1), (f2, c2) = count_freq.items()

    # only one char appear once
    if (f1 == 1 and c1 == 1) or (f2 == 1 and c2 == 1):
        return True
    
    # one char occurs one more than the others
    # and it appears only once
    if abs(f1 - f2) == 1:
        if (f1 > f2 and c1 == 1) or (f2 > f1 and c2 == 1):
            return True
    
    return False

print("Test 1: 'aaabbb'")
print(f"Result: {is_cool_str('aaabbb')}")  # expect output: True
print()

print("Test 2: 'aaabbbcccc'") 
print(f"Result: {is_cool_str('aaabbbcccc')}")  # expect output: True
print()

print("Test 3: 'aaabbbccccdddd'")
print(f"Result: {is_cool_str('aaabbbccccdddd')}")  # expect output: False
print()

print("Test 4: 'aabbcccdddeeee'")
print(f"Result: {is_cool_str('aabbcccdddeeee')}")  # expect output: False
