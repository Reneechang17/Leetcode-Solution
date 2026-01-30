"""
Employee Hierarchy Sorting (Similar to LeetCode 332)

Given:
1. List of employees: [(name, title), ...]
2. Reporting hierarchy: {subordinate_title: manager_title}

Reorder employees by hierarchy (lowest level first, highest last).
Same level titles can be in any order.

Example:
employees = [("John", "Manager"), ("Sally", "CTO"), ("Sam", "CEO"), ...]
reports = {"CTO": "CEO", "Manager": "CTO", "Engineer": "Manager", "CFO": "CEO"}

Output: [("Drax", "Engineer"), ("Daniel", "Engineer"), ("John", "Manager"),
         ("Sally", "CTO"), ("Bob", "CFO"), ("Sam", "CEO")]
"""

# Time:O(V+E), Space:O(V+E)

from typing import List, Tuple, Dict, Any
from collections import defaultdict, deque

def sort_employees_by_hierarchy(employees: List[Tuple[str, str]], reports: Dict[str, Any]) -> List[Tuple[str, str]]:
    graph = defaultdict(list)
    indegree = defaultdict(int)

    for _, title in employees:
        indegree[title] = 0
    
    for sub, mgr in reports.items():
        graph[mgr].append(sub)
        indegree[sub] += 1
        if mgr not in indegree:
            indegree[mgr] = 0
    
    que = deque([t for t, d in indegree.items() if d == 0])
    title_level = {}
    cur_level = len(indegree)

    while que:
        for _ in range(len(que)):
            title = que.popleft()
            title_level[title] = cur_level

            for sub in graph[title]:
                indegree[sub] -= 1
                if indegree[sub] == 0:
                    que.append(sub)
        cur_level -= 1
    
    return sorted(employees, key=lambda x:title_level[x[1]])

print("Test: Employee hierarchy sorting")
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

result = sort_employees_by_hierarchy(employees, reports)
print(f"Result: {result}")

# expect output: [('Drax', 'Engineer'), ('Daniel', 'Engineer'), ('John', 'Manager'), 
#                 ('Sally', 'CTO'), ('Bob', 'CFO'), ('Sam', 'CEO')]
