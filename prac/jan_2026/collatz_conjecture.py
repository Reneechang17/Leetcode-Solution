"""
Collatz Conjecture - Number of Steps to Reach 1

Rules:
1. If x is even: x = x / 2
2. If x is odd: x = 3 * x + 1

Count steps needed to transform x into 1.

Follow-up: Use memoization to optimize repeated calls.
"""

# Time:O(k), Space:O(k)

class CollatzConjecture:
    def __init__(self):
        self.memo = {1: 0}
    
    def count_steps(self, x: int) -> int:
        if x <= 0:
            raise ValueError("Input must be positive integer")
        
        path = []
        steps = 0
        cur = x

        while cur > 1:
            if cur in self.memo:
                steps += self.memo[cur]
                break

            path.append(cur)

            if cur % 2 == 0:
                cur //= 2
            else:
                cur = 3 * cur + 1
            
            steps += 1
        
        for i, num in enumerate(path):
            self.memo[num] = steps - i
        
        return steps

print("Test 1: n = 1")
calc = CollatzConjecture()
result1 = calc.count_steps(1)
print(f"Steps: {result1}")  # expect output: 0
print()

print("Test 2: n = 2")
result2 = calc.count_steps(2)
print(f"Steps: {result2}")  # expect output: 1 (2→1)
print()

print("Test 3: n = 3")
result3 = calc.count_steps(3)
print(f"Steps: {result3}")  # expect output: 7 (3→10→5→16→8→4→2→1)
print()

print("Test 4: n = 6")
result4 = calc.count_steps(6)
print(f"Steps: {result4}")  # expect output: 8
print()

print("Test 5: n = 27 (famous long chain)")
result5 = calc.count_steps(27)
print(f"Steps: {result5}")  # expect output: 111
