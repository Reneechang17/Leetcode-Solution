"""
Currency Price Tracker

Track currency prices from different banks.
Support adding/updating prices and calculating average price per currency.

Data format: (bank, currency, price)
If same bank and currency appears again, it overwrites previous price.

Example:
Input: 
    ("BankA", "USD", 7.2),
    ("BankB", "USD", 7.3),
    ("BankC", "EUR", 8.0),
    ("BankA", "USD", 7.5)  # Overwrites BankA USD price

Average:
    USD: (7.5 + 7.3) / 2 = 7.4
    EUR: 8.0 / 1 = 8.0
"""

from collections import defaultdict
from typing import Dict, Tuple

class CurrencyPriceTracker:
    def __init__(self):
        # data[currency][bank] = cur price for this bank
        self.data = defaultdict(dict)
        # currency -> (total_price, bank_count)
        self.stats = defaultdict(lambda: [0.0, 0])
    
    # Time:O(1)
    def add_data(self, entry: Tuple[str, str, float]) -> None:
        bank, currency, price = entry

        if bank in self.data[currency]:
            old_price = self.data[currency][bank]
            self.stats[currency][0] += price - old_price
        else:
            self.stats[currency][0] += price
            self.stats[currency][1] += 1
        
        self.data[currency][bank] = price
    
    # Time:O(C)
    def average_price(self) -> Dict[str, float]:
        res = {}
        for currency, (total, count) in self.stats.items():
            if count > 0:
                res[currency] = total / count
        
        return res

print("Test: Basic example from prompt")
tracker = CurrencyPriceTracker()

data_list = [
    ("BankA", "USD", 7.2),
    ("BankB", "USD", 7.3),
    ("BankC", "EUR", 8.0),
    ("BankA", "USD", 7.5),  # Overwrites BankA USD price
]

for data in data_list:
    tracker.add_data(data)

result = tracker.average_price()
print(f"Average prices: {result}")  # expect output: {'USD': 7.4, 'EUR': 8.0}

print("\nDetailed check:")
print(f"USD average: (7.5 + 7.3) / 2 = {(7.5 + 7.3) / 2}")
print(f"EUR average: 8.0 / 1 = 8.0")
