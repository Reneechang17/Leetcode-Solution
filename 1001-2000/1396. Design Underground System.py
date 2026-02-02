# Time:O(1)

class UndergroundSystem:
    # one store active -> (startStation, startTime)
    # one store stat: route -> (totalTime, tripCount)

    def __init__(self):
        self.active = {}
        self.stats = {}
        
    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.active[id] = (stationName, t)

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        startStation, startTime = self.active.pop(id)
        dur = t - startTime

        key = (startStation, stationName)
        if key in self.stats:
            total, cnt = self.stats[key]
            self.stats[key] = (total + dur, cnt + 1)
        else:
            self.stats[key] = (dur, 1)
        
    def getAverageTime(self, startStation: str, endStation: str) -> float:
        total, cnt = self.stats[(startStation, endStation)]
        return total / cnt
    