'''
Josephus Problem:
n numbers 0 to n-1 in a circle, remove the m-th number each time,
starting from 0. Find the last remaining number.

Recurrence relation:
f(n, m) = (f(n-1, m) + m) % n <-- +m mapping back to old index
f(1, m) = 0

everytime del one -> left n-1, but the index relation changed. ex. n=5, m=3
ori: 0,1,2,3,4
aft: 3,4,0,1

ori: 3,4,0,1
aft: 1,3,4

ori: 1,3,4
aft: 1,3

ori: 1,3,(1)
aft: 3

'''

# recursion(call stack)
# Time:O(n), Space:O(n)
def josephus_problem_rec(n: int, m: int) -> int:
    if n == 1:
        return 0
    return (josephus_problem_rec(n - 1, m) + m) % n

# iteration
# Time:O(1), Space:O(1)
def josephus_problem_iter(n: int, m: int) -> int:
    res = 0 # base case: f(1, m)=0
    
    for i in range(2, n + 1):
        res = (res + m) % i
    
    return res


# Test cases
if __name__ == "__main__":
    # Test 1: n=5, m=3
    # Sequence: 0,1,2,3,4 (remove every 3rd)
    # Deleted: 2, 0, 4, 1 → remaining: 3
    result1 = josephus_problem_iter(5, 3)
    print(f"Test 1 (iterative): n=5, m=3 → {result1} (expected: 3)")
    
    result2 = josephus_problem_rec(5, 3)
    print(f"Test 1 (recursive): n=5, m=3 → {result2} (expected: 3)")
    
    # Test 2: n=10, m=3
    result3 = josephus_problem_iter(10, 3)
    print(f"\nTest 2: n=10, m=3 → {result3}")
    
    # Test 3: Edge case n=1
    result4 = josephus_problem_iter(1, 5)
    print(f"Test 3: n=1, m=5 → {result4} (expected: 0)")
    
    # If numbers are 1-based instead of 0-based, just add 1:
    n, m = 5, 3
    result = josephus_problem_iter(n, m)
    print(f"\n1-based numbering (1 to {n}), m={m}: last = {result + 1}")
