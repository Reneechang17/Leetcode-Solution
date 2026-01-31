"""
Problem: Bus Tracking System (O(1) Operations)

You are given:
1. A sequence of stations in a fixed order (e.g., "A-B-C-D-E-F-G").
2. A dictionary bus_list mapping each bus_id to its initial station.

Rules:
- Buses only move from left to right.
- All buses move simultaneously.
- Each call to move() shifts every bus one station to the right.
- If a bus reaches the last station, it stays there permanently.

You must design a system supporting the following operations in O(1):

1. closest_bus(station_id) -> int
   Return the distance to the nearest bus that is currently
   at or to the left of the given station.
   If no such bus exists, return -1.

2. find_location_bus(bus_id) -> str
   Return the current station name of the given bus.

3. move() -> None
   Advance the system by one time step (all buses move right by one station).
"""

from typing import Dict, List

class BusSystem:
    def __init__(self, bus_list: Dict[int, str], station: str):
        self.stations: List[str] = station.split("-")
        self.n = len(self.stations)

        # station_name -> its idx
        self.idx = {name: i for i, name in enumerate(self.stations)}
        # bus_origin[bus_id] = its initial station idx
        self.bus_origin: Dict[int, int] = {}
        self.rightmost_origin = -1

        for bus_id, st in bus_list.items():
            origin_idx = self.idx[st]
            self.bus_origin[bus_id] = origin_idx
            self.rightmost_origin = max(self.rightmost_origin, origin_idx)

        # global offset to simulate the move
        self.time = 0
        
        has_bus = [False] * self.n
        for origin_index in self.bus_origin.values():
            has_bus[origin_index] = True
        
        # freeze in time=0 closest[i] = dist that i to the left close
        self.closest = [-1] * self.n
        last_bus = -1
        for i in range(self.n):
            if has_bus[i]:
                last_bus = i
            if last_bus != -1:
                self.closest[i] = i - last_bus


    def move(self) -> None:
        self.time += 1
    
    def find_location_bus(self, bus_id: int) -> str:
        origin_pos = self.bus_origin[bus_id]
        # last station or origin + time
        cur_idx = min(self.n - 1, origin_pos + self.time)
        return self.stations[cur_idx]
    
    def closest_bus(self, station_id: str) -> int:
        if self.rightmost_origin == -1:
            return -1
        
        j = self.idx[station_id]

        if j == self.n - 1:
            rightmost_pos = min(self.n - 1, self.rightmost_origin + self.time)
            return (self.n - 1) - rightmost_pos # if 0 -> a bus at last 
        
        lookup = j - self.time
        # cur car that <= j, their init pos should be <= (j - time)
        if lookup < 0:
            return -1
        
        return self.closest[lookup]

def run_test(desc: str, actual, expected) -> None:
    ok = "PASS" if actual == expected else "FAIL"
    print(f"{desc}: Expected={expected}, Actual={actual} -> {ok}")


if __name__ == "__main__":
    stations_str = "A-B-C-D-E-F-G"

    # Test 1: Original example
    print("=== Test 1: Bus 1 at B, Bus 3 at F ===")
    sys1 = BusSystem({1: "B", 3: "F"}, stations_str)
    run_test("closest_bus(A)", sys1.closest_bus("A"), -1)
    run_test("closest_bus(B)", sys1.closest_bus("B"), 0)
    run_test("closest_bus(C)", sys1.closest_bus("C"), 1)
    run_test("closest_bus(D)", sys1.closest_bus("D"), 2)
    run_test("closest_bus(E)", sys1.closest_bus("E"), 3)
    run_test("closest_bus(F)", sys1.closest_bus("F"), 0)
    run_test("bus 1 location", sys1.find_location_bus(1), "B")
    run_test("bus 3 location", sys1.find_location_bus(3), "F")

    # move twice
    sys1.move()
    sys1.move()
    run_test("after 2 moves, bus 1", sys1.find_location_bus(1), "D")
    run_test("after 2 moves, bus 3", sys1.find_location_bus(3), "G")
    run_test("after 2 moves, closest_bus(F)", sys1.closest_bus("F"), 2)

    # Test 2: Single bus starting at A
    print("\n=== Test 2: Single bus starting at A ===")
    sys2 = BusSystem({10: "A"}, stations_str)
    run_test("closest_bus(A)", sys2.closest_bus("A"), 0)
    run_test("closest_bus(B)", sys2.closest_bus("B"), 1)
    run_test("closest_bus(C)", sys2.closest_bus("C"), 2)
    run_test("bus 10 location", sys2.find_location_bus(10), "A")
    sys2.move()
    run_test("after 1 move, bus 10", sys2.find_location_bus(10), "B")

    # Test 3: Single bus starting at G (last station)
    print("\n=== Test 3: Single bus starting at G ===")
    sys3 = BusSystem({20: "G"}, stations_str)
    run_test("closest_bus(F)", sys3.closest_bus("F"), -1)
    run_test("closest_bus(G)", sys3.closest_bus("G"), 0)
    run_test("bus 20 location", sys3.find_location_bus(20), "G")
    sys3.move()
    run_test("after move, bus 20 still at G", sys3.find_location_bus(20), "G")

    # Test 4: Multiple buses at A, C, E
    print("\n=== Test 4: Multiple buses at A, C, E ===")
    sys4 = BusSystem({1: "A", 2: "C", 3: "E"}, stations_str)
    run_test("closest_bus(B)", sys4.closest_bus("B"), 1)
    run_test("closest_bus(C)", sys4.closest_bus("C"), 0)
    run_test("closest_bus(D)", sys4.closest_bus("D"), 1)
    run_test("closest_bus(E)", sys4.closest_bus("E"), 0)
    run_test("closest_bus(F)", sys4.closest_bus("F"), 1)
    sys4.move()
    run_test("after 1 move, bus 1", sys4.find_location_bus(1), "B")
    run_test("after 1 move, bus 2", sys4.find_location_bus(2), "D")
    run_test("after 1 move, bus 3", sys4.find_location_bus(3), "F")
    run_test("after 1 move, closest_bus(G)", sys4.closest_bus("G"), 1)

    # Test 5: No buses
    print("\n=== Test 5: No buses ===")
    sys5 = BusSystem({}, stations_str)
    run_test("closest_bus(A)", sys5.closest_bus("A"), -1)
    run_test("closest_bus(G)", sys5.closest_bus("G"), -1)

    # Test 6: Two buses starting at the same station C
    print("\n=== Test 6: Two buses starting at the same station C ===")
    sys6 = BusSystem({1: "C", 2: "C"}, stations_str)
    run_test("closest_bus(C)", sys6.closest_bus("C"), 0)
    run_test("closest_bus(D)", sys6.closest_bus("D"), 1)
    run_test("bus 1 location", sys6.find_location_bus(1), "C")
    run_test("bus 2 location", sys6.find_location_bus(2), "C")
    sys6.move()
    run_test("after 1 move, bus 1", sys6.find_location_bus(1), "D")
    run_test("after 1 move, bus 2", sys6.find_location_bus(2), "D")

    # Test 7: Many moves beyond last station
    print("\n=== Test 7: Many moves beyond last station ===")
    sys7 = BusSystem({99: "E"}, stations_str)
    for _ in range(10):
        sys7.move()
    run_test("bus 99 should remain at G", sys7.find_location_bus(99), "G")
    run_test("closest_bus(G) after many moves", sys7.closest_bus("G"), 0)
