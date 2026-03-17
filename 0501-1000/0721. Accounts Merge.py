# Time:O(n² × k), Space:O(n × k)

from collections import defaultdict
from typing import List

class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        n = len(accounts)
        # acc-acc
        graph = [[] for _ in range(n)]
        email_to_ids = defaultdict(list)

        for i, acc in enumerate(accounts):
            for email in acc[1:]:
                email_to_ids[email].append(i)
        
        # if two accs shared same email -> link
        for email, ids in email_to_ids.items():
            for i in range(len(ids)):
                for j in range(i + 1, len(ids)):
                    graph[ids[i]].append(ids[j])
                    graph[ids[j]].append(ids[i])

        vis = [False] * n

        def dfs(i, emails):
            vis[i] = True
            for email in accounts[i][1:]:
                emails.add(email)
            for nei in graph[i]:
                if not vis[nei]:
                    dfs(nei, emails)

        res = []
        for i in range(n):
            if not vis[i]:
                emails = set()
                dfs(i, emails)
                res.append([accounts[i][0]] + sorted(emails))
        return res
    