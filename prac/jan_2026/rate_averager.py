'''
Problem: Real-time FX Rate Tracker
Track currency rates from multiple banks, support updates, calculate averages efficiently.

Requirements:
1. add_rate(bank, currency, rate): Add/update rate
2. display_average_rates(): Return average rate per currency

Key points:
- Same bank can update rate for same currency (override)
- Maintain running sum and count for O(1) average calculation
- Handle new banks, new currencies, updates
'''

from collections import defaultdict

class FxRateTracker:
    def __init__(self):
        # bank[bank][currency]=latest rate from this bank
        self.bank_rates = defaultdict(dict)
        # currency -> [total_sum, bank_acc] 
        # use for running average
        self.currency_stats = defaultdict(lambda: [0.0, 0])
    
    # Time:O(1), Space:O(B*C)
    def add_rate(self, bank: str, currency: str, rate: float) -> None:
        if currency in self.bank_rates[bank]:
            old_rate = self.bank_rates[bank][currency]
            self.currency_stats[currency][0] -= old_rate
            # cnt stays the same(same bank)
        else:
            # new bank for this currency -> cnt + 1
            self.currency_stats[currency][1] += 1
        
        # update bank's rate
        self.bank_rates[bank][currency] = rate
        # add new rate to total
        self.currency_stats[currency][0] += rate
    
    # Time:O(C), Space:O(B*C)
    def display_ave_rates(self) -> dict:
        ave = {}
        for currency, (total, cnt) in self.currency_stats.items():
            if cnt > 0:
                ave[currency] = round(total / cnt, 2)
        return ave
    
if __name__ == "__main__":
    # Test 1: Basic example
    tracker = FxRateTracker()
    tracker.add_rate("BankA", "USD", 7.2)
    tracker.add_rate("BankB", "USD", 7.3)
    tracker.add_rate("BankC", "EUR", 8.0)
    tracker.add_rate("BankA", "USD", 7.5)  # Update
    
    result = tracker.display_ave_rates()
    print("Test 1 - Basic example:")
    print(f"  USD: {result.get('USD')} (expected: 7.4)")
    print(f"  EUR: {result.get('EUR')} (expected: 8.0)")
    
    # Test 2: New bank for existing currency
    tracker.add_rate("BankD", "USD", 7.1)
    result = tracker.display_ave_rates()
    print("\nTest 2 - Add new bank:")
    print(f"  USD: {result.get('USD')} (expected: (7.5+7.3+7.1)/3 = 7.3)")
    
    # Test 3: Same bank adds new currency
    tracker.add_rate("BankA", "JPY", 110.0)
    result = tracker.display_ave_rates()
    print("\nTest 3 - New currency from existing bank:")
    print(f"  JPY: {result.get('JPY')} (expected: 110.0)")
    
    # Test 4: Update existing rate
    tracker.add_rate("BankB", "USD", 7.6)
    result = tracker.display_ave_rates()
    print("\nTest 4 - Update existing rate:")
    print(f"  USD: {result.get('USD')} (expected: (7.5+7.6+7.1)/3 = 7.4)")
    
    # Test 5: Empty tracker
    empty_tracker = FxRateTracker()
    empty_result = empty_tracker.display_ave_rates()
    print("\nTest 5 - Empty tracker:")
    print(f"  Result: {empty_result} (expected: {{}})")
