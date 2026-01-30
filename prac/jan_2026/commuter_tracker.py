"""
Commuter Cost Tracker for Branches

Design a system to track average travel times between company sites.
Support three operations:
1. checkIn(id, siteName, time) - employee starts trip at site
2. checkOut(id, siteName, time) - employee ends trip at site, calculate duration
3. getAverageTime(startSite, endSite) - return average duration between two sites

Example:
checkIn(1, "JFK", 1000)
checkOut(1, "Manhattan", 1060)  # duration = 60
checkIn(2, "JFK", 1100)
checkOut(2, "Manhattan", 1150)  # duration = 50
getAverageTime("JFK", "Manhattan") -> 55.0
"""

# Time:O(1), Space:O(n+m)

from typing import Dict, Tuple

class CommuterTracker:
    def __init__(self):
        # active trips: employee_id -> (start_site, start_time)
        self.active: Dict[int, Tuple[str, float]] = {}

        # completed trips: "route" -> (total_time, trip count)
        self.completed: Dict[str, Tuple[float, int]] = {}
    
    def checkIn(self, employee_id: int, site_name: str, time: float) -> None:
        if employee_id in self.active:
            raise ValueError(f"Employee already has active trip")
        
        self.active[employee_id] = (site_name, time)

    def checkOut(self, employee_id: int, site_name: str, time:float) -> None:
        if employee_id not in self.active:
            raise ValueError(f"Employee has no active trip")
        
        start_site, start_time = self.active.pop(employee_id)

        if time <= start_time:
            raise ValueError("Checkout must be after checkin")
        
        dur = time - start_time
        route = f"{start_site}->{site_name}"

        if route in self.completed:
            total, count = self.completed[route]
            self.completed[route] = (total + dur, count + 1)
        else:
            self.completed[route] = (dur, 1)
    
    def getAverageTime(self, start_site: str, end_site: str) -> float:
        route = f"{start_site}->{end_site}"

        if route not in self.completed:
            return 0.0
        
        total, count = self.completed[route]
        return total / count

print("Test 1: JFK -> Manhattan")
tracker = CommuterTracker()
tracker.checkIn(1, "JFK", 1000.0)
tracker.checkOut(1, "Manhattan", 1060.0)  # 60 min
tracker.checkIn(2, "JFK", 1100.0)
tracker.checkOut(2, "Manhattan", 1150.0)  # 50 min

avg1 = tracker.getAverageTime("JFK", "Manhattan")
print(f"Average time: {avg1}")  # expect output: 55.0
print()

print("Test 2: Boston -> NYC")
tracker.checkIn(3, "Boston", 1200.0)
tracker.checkOut(3, "NYC", 1500.0)  # 300 min

avg2 = tracker.getAverageTime("Boston", "NYC")
print(f"Average time: {avg2}")  # expect output: 300.0
print()

print("Test 3: NYC -> Boston (no trips)")
avg3 = tracker.getAverageTime("NYC", "Boston")
print(f"Average time: {avg3}")  # expect output: 0.0
