"""
Currency Conversion Rate

Given list of conversion rates: [from_currency, to_currency, rate]
Meaning: 1 from_currency = rate * to_currency

Given query: [from_currency, to_currency]
Return conversion rate from 'from' to 'to'.
Return -1 if no conversion path exists.

Example:
Rates: ['USD', 'JPY', 110], ['USD', 'AUD', 1.45], ['JPY', 'GBP', 0.0070]
Query: ['GBP', 'AUD']
Output: 1.89
"""

# Time:O(V+E), Space:O(V+E)

from collections import defaultdict, deque

def currency_conversion(rates, query):
    graph = defaultdict(list)
    for src, dst, rate in rates:
        graph[src].append((dst, rate))
        graph[dst].append((src, 1.0 / rate))
    
    start, end = query[0], query[1]
    if start not in graph or end not in graph:
        return -1.0
    
    que = deque([(start, 1.0)])
    vis = set([start])

    while que:
        cur, rate = que.popleft()
        if cur == end:
            return rate
        for next, r in graph[cur]:
            if next not in vis:
                vis.add(next)
                que.append((next, rate * r))
    
    return -1.0

rates = [['USD', 'JPY', 110], ['USD', 'AUD', 1.45], ['JPY', 'GBP', 0.0070]]

print("Test 1: GBP -> AUD")
result1 = currency_conversion(rates, ['GBP', 'AUD'])
print(f"Result: {result1:.2f}")  # expect output: 1.89
print()

print("Test 2: GBP -> EUR (no path)")
result2 = currency_conversion(rates, ['GBP', 'EUR'])
print(f"Result: {result2}")  # expect output: -1
