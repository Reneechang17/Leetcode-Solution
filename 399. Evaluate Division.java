// Medium
// DFS, Graph, Hash Table
// O(n)
// https://leetcode.com/problems/evaluate-division/

import java.util.*;

class Solution {
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
      Map<String, Map<String, Double>> graph = new HashMap<>();
      for (int i = 0; i < equations.size(); i++) {
          String a = equations.get(i).get(0);
          String b = equations.get(i).get(1);
          double value = values[i];

          graph.putIfAbsent(a, new HashMap<>());
          graph.putIfAbsent(b, new HashMap<>());
          graph.get(a).put(b, value);
          graph.get(b).put(a, 1.0 / value);
      }

      double[] res = new double[queries.size()];
      for (int i = 0; i < queries.size(); i++) {
          String x = queries.get(i).get(0);
          String y = queries.get(i).get(1);

          if (!graph.containsKey(x) || !graph.containsKey(y)) {
              res[i] = -1.0;
          } else if (x.equals(y)) {
              res[i] = 1.0;
          } else {
              Set<String> visited = new HashSet<>();
              res[i] = dfs(graph, x, y, 1.0, visited);
          }
      }
      return res;
  }

  private double dfs (Map<String, Map<String, Double>> graph, String current, String target, double value, Set<String> visited) {
      visited.add(current);

      if (graph.get(current).containsKey(target)) {
          return value * graph.get(current).get(target);
      }

      for (Map.Entry<String, Double> n : graph.get(current).entrySet()) {
          if (!visited.contains(n.getKey())) {
              double res = dfs(graph, n.getKey(), target, value * n.getValue(), visited);
              if (res != -1.0) {
                  return res;
              }
          }
      }
      return -1.0;
  }
}
