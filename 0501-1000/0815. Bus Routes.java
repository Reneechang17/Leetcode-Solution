// Hard
// BFS
// Time:O(routes+source),Space:O(routes+source)
// https://leetcode.cn/problems/bus-routes/

import java.util.*;

class Solution {
    // BFS: shortest path problem -> use Queue to go through
    // Map store each station and its list of routes passing through
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int station : routes[i]) {
                map.putIfAbsent(station, new ArrayList<>());
                map.get(station).add(i);
            }
        }
        boolean[] visStations = new boolean[100000], visRoutes = new boolean[routes.length];
        Queue<Integer> stationQue = new LinkedList<>();
        Queue<Integer> routeQue = new LinkedList<>();

        stationQue.add(source);
        routeQue.add(0);
        visStations[source] = true;
        int level = 0;

        while (!stationQue.isEmpty()) {
            int size = stationQue.size();
            for (int i = 0; i < size; i++) {
                int station = stationQue.poll();
                // check all the routes passing through this station
                // ensure cur station has routes before iterating over them
                List<Integer> routesForStation = map.get(station);
                if (routesForStation != null) {
                    for (int route : routesForStation) {
                        if (!visRoutes[route]) {
                            visRoutes[route] = true;
                            // add all stations in this route to queue
                            for (int nextStation : routes[route]) {
                                if (!visStations[nextStation]) {
                                    if (nextStation == target) {
                                        return level + 1;
                                    }
                                    stationQue.offer(nextStation);
                                    visStations[nextStation] = true;
                                }
                            }
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
