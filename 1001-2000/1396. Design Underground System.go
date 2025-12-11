package main
// Medium
// HashMap
// Time:O(1),Space:O(P + S²)
// https://leetcode.cn/problems/design-underground-system/

type CheckInInfo struct {
    station string
    time int
}

type RouteInfo struct {
    totalTime int
    count int
}

type UndergroundSystem struct {
    checkIns map[int]CheckInInfo
    routeStats map[string]RouteInfo
}

func Constructor() UndergroundSystem {
    return UndergroundSystem{
        checkIns: make(map[int]CheckInInfo),
        routeStats: make(map[string]RouteInfo),
    }
}

func (this *UndergroundSystem) CheckIn(id int, stationName string, t int)  {
    this.checkIns[id] = CheckInInfo{
        station: stationName,
        time: t,
    }
}

func (this *UndergroundSystem) CheckOut(id int, stationName string, t int)  {
    checkIn := this.checkIns[id]
    duration := t - checkIn.time
    route := checkIn.station + "->" + stationName

    stats := this.routeStats[route]
    stats.totalTime += duration
    stats.count++
    this.routeStats[route] = stats

    delete(this.checkIns, id)
}

func (this *UndergroundSystem) GetAverageTime(startStation string, endStation string) float64 {
    route := startStation + "->" + endStation
    stats := this.routeStats[route]
    return float64(stats.totalTime) / float64(stats.count)
}
