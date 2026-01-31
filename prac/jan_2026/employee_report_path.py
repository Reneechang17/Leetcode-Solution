"""
Problem: Reorder employees based on reporting hierarchy (titles only)

Given:
- employees: List[Tuple[name, title]]
- reports: Dict[subordinate_title -> boss_title]
  Meaning: subordinate_title reports to boss_title.

Goal:
Re-order employees from lowest to highest in the hierarchy.
Employees with the same title stay together; titles at the same level
(e.g., CTO and CFO both report to CEO) can be in either order.

Example:
employees = [(John, Manager), (Sally, CTO), (Sam, CEO), (Drax, Engineer), (Bob, CFO), (Daniel, Engineer)]
reports   = {CTO: CEO, Manager: CTO, Engineer: Manager, CFO: CEO}

One valid output:
[(Drax, Engineer), (Daniel, Engineer), (John, Manager), (Sally, CTO), (Bob, CFO), (Sam, CEO)]
"""


from typing import List, Tuple, Dict
from collections import defaultdict, deque

# Time:O(V+E), Space:O(V+E)
def solution(employees: List[Tuple[str, str]], report:Dict[str, str]) -> List[Tuple[str, str]]:
    # build title graph: boss->[sub]
    graph = defaultdict(list)
    indegree = {} # title -> indegree

    for sub, boss in report.items():
        graph[boss].append(sub)
        indegree.setdefault(sub, 0)
        indegree.setdefault(boss, 0)
        indegree[sub] += 1
    
    que = deque(t for t, d in indegree.items() if d == 0)
    level = {} # title -> level (0=highest)

    cur_level = 0
    while que:
        for _ in range(len(que)):
            t = que.popleft()
            level[t] = cur_level

            for sub in graph[t]:
                indegree[sub] -= 1
                if indegree[sub] == 0:
                    que.append(sub)
        cur_level += 1
    
    # sort employees: lower title first -> larger level first
    return sorted(employees, key=lambda x: -level.get(x[1]))

if __name__ == "__main__":
    employees = [
        ("John", "Manager"),
        ("Sally", "CTO"),
        ("Sam", "CEO"),
        ("Drax", "Engineer"),
        ("Bob", "CFO"),
        ("Daniel", "Engineer")
    ]
    
    reports = {
        "CTO": "CEO",
        "Manager": "CTO",
        "Engineer": "Manager",
        "CFO": "CEO"
    }
    
    result = solution(employees, reports)
    print("Sorted employees (lowest to highest):")
    for name, title in result:
        print(f"  {name}: {title}")
