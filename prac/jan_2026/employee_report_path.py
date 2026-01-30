'''
Problem: Reorder employees based on reporting hierarchy
Input: 
  - employees: list of (name, title)
  - reports: dict {subordinate: boss} showing reporting relationships
Output: employees sorted from lowest to highest in hierarchy

Approach:
1. Build graph: boss → subordinates (reverse of reports dict)
2. Topological sort starting from top-level (CEO, indegree=0)
3. Assign levels: higher position = smaller level number (CEO=0)
4. Sort employees by level (ascending, lowest first)

Example hierarchy:
       CEO (level 0)
      /           \
    CTO(1)       CFO(1)
     |
  Manager(2)
     |
 Engineer(3)
'''

from typing import List, Tuple, Dict
from collections import defaultdict, deque

# Time:O(V+E), Space:O(V+E)
def solution(employees: List[Tuple[str, str]], report:Dict[str, str]) -> List[Tuple[str, str]]:
    
    # graph: boss -> subordinates
    graph = defaultdict(list)
    indegree = defaultdict(int)

    for sub, boss in report.items():
        graph[boss].append(sub)
        indegree[sub] += 1
        indegree.setdefault(boss, 0)
    
    que = deque([title for title in indegree if indegree[title] == 0]) # find the top level

    level = {}
    cur_level = 0

    while que:
        for _ in range(len(que)):
            title = que.popleft()
            level[title] = cur_level

            # pass sub
            for sub in graph[title]:
                indegree[sub] -= 1
                if indegree[sub] == 0:
                    que.append(sub)
        cur_level += 1
    
    # sort by level desc
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
