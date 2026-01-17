# Time:O(1)

class UndergroundSystem:

    def __init__(self):
        self.check_ins = {} # id -> (start_station, start_time)
        self.travel_data = {} # (start, end) -> [total_time, count]

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.check_ins[id] = (stationName, t)

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        start_sta, start_time = self.check_ins.pop(id)
        key = (start_sta, stationName)
        travel_time = t - start_time

        if key not in self.travel_data:
            self.travel_data[key] = [0, 0]
        self.travel_data[key][0] += travel_time
        self.travel_data[key][1] += 1

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        total, count = self.travel_data[(startStation, endStation)]
        return total / count
    