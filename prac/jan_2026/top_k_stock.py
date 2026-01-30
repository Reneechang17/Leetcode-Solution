"""
Design Stock Trading Volume Tracker

Support two operations:
1. addStocksVolume(stockSymbol, volume)
   - Add trading volume to a stock (cumulative)
   
2. topKstocks(k)
   - Return the k stock symbols with highest total volume
   - If fewer than k stocks, return all
   - Ties can be in any order

Requirements:
- Efficient for both frequent updates and queries

Example:
addStocksVolume("AAPL", 100)
addStocksVolume("GOOG", 200)
addStocksVolume("AAPL", 50)
topKstocks(1) -> ["GOOG"]
topKstocks(2) -> ["GOOG", "AAPL"]
"""

from collections import defaultdict
import heapq

class StockTrader:
    def __init__(self):
        # Map: stock -> total volume
        self.volumes = defaultdict(int)
    
    # Time:O(1)
    def addStocksVolume(self, stockSymbol: str, volume: int) -> None:
        self.volumes[stockSymbol] += volume
    
    # Time:(nlogk), Space:O(k)
    def topKStocks(self, k: int) -> list[str]:
        if k <= 0:
            return []
        
        if k >= len(self.volumes):
            return sorted(self.volumes.keys(), 
                          key=lambda x: self.volumes[x],
                          reverse=True)[:k]
        
        min_heap = []
        for stock, volume in self.volumes.items():
            heapq.heappush(min_heap, (volume, stock))
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        
        res = []
        while min_heap:
            _, stock = heapq.heappop(min_heap)
            res.append(stock)
        res.reverse()
        return res

if __name__ == "__main__":
    tracker = StockTrader()
    
    tracker.addStocksVolume("AAPL", 100)
    tracker.addStocksVolume("GOOG", 200)
    tracker.addStocksVolume("AAPL", 50)
    
    print(tracker.topKStocks(1))  # ["GOOG"]
    print(tracker.topKStocks(2))  # ["GOOG", "AAPL"]
    print(tracker.topKStocks(5))  # ["GOOG", "AAPL"]
