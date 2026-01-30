'''
Tesla Equity Price Tracker System
Requirements:
1. Trader can update daily price or remove latest price (O(1))
2. Analyst can retrieve latest, max and average prices (O(1))
3. All operations O(1)

Follow-up: Similar to Leetcode 295 (Find Median from Data Stream)
Approach: Use two heaps for median, plus tracking for other stats
'''

class Equity:
    # stock add/remove
    def __init__(self, name: str):
        self.name = name
        self.prices = []
        self.max_stack = []
        self.price_sum = 0.0

    def add_price(self, price: float) -> None:
        self.prices.append(price)
        self.price_sum += price
        if not self.max_stack:
            self.max_stack.append(price)
        else:
            self.max_stack.append(max(self.max_stack[-1], price))

    def remove_latest(self) -> bool:
        if not self.prices:
            return False
        p = self.prices.pop()
        self.max_stack.pop()
        self.price_sum -= p
        return True
    
    def get_latest(self):
        return self.prices[-1] if self.prices else None

    def get_max(self):
        return self.max_stack[-1] if self.max_stack else None
    
    def get_average(self):
        return (self.price_sum / len(self.prices)) if self.prices else None
    
class Trader:
    def __init__(self, equity: Equity):
        self.equity = equity
    
    def update_price(self, price: float) -> None:
        self.equity.add_price(price)
    
    def remove_latest_price(self) -> bool:
        return self.equity.remove_latest()

class Analyst:
    def __init__(self, equity: Equity):
        self.equity = equity
    
    def get_report(self) -> dict:
        return {
            "latest": self.equity.get_latest(),
            "max": self.equity.get_max(),
            "average": self.equity.get_average(),
        }
        
if __name__ == "__main__":
    tesla = Equity("TSLA")
    trader = Trader(tesla)
    analyst = Analyst(tesla)

    print("=== Test 1: Basic operations ===")
    trader.update_price(100.0)
    trader.update_price(150.0)
    trader.update_price(120.0)

    report = analyst.get_report()
    print("After adding 100, 150, 120:")
    print(f"  Latest: {report['latest']} (expected: 120)")
    print(f"  Max: {report['max']} (expected: 150)")
    print(f"  Average: {report['average']:.2f} (expected: 123.33)")

    print("\n=== Test 2: Remove latest ===")
    trader.remove_latest_price()  # Remove 120
    report = analyst.get_report()
    print("After removing latest (120):")
    print(f"  Latest: {report['latest']} (expected: 150)")
    print(f"  Max: {report['max']} (expected: 150)")
    print(f"  Average: {report['average']:.2f} (expected: 125.00)")

    print("\n=== Test 3: Add more prices ===")
    trader.update_price(200.0)
    trader.update_price(180.0)
    report = analyst.get_report()
    print("After adding 200, 180:")
    print(f"  Latest: {report['latest']} (expected: 180)")
    print(f"  Max: {report['max']} (expected: 200)")
    print(f"  Average: {report['average']:.2f} (expected: 157.50)")

    print("\n=== Test 4: Remove multiple ===")
    trader.remove_latest_price()  # Remove 180
    trader.remove_latest_price()  # Remove 200
    report = analyst.get_report()
    print("After removing 180 and 200:")
    print(f"  Latest: {report['latest']} (expected: 150)")
    print(f"  Max: {report['max']} (expected: 150)")
    print(f"  Average: {report['average']:.2f} (expected: 125.00)")
      