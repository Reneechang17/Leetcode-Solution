// Medium
// DFS, Graph, Hash Table
// O(n)
// https://leetcode.cn/problems/evaluate-division/

import java.util.*;

class Solution {
    // equations: a / b = 2.0, 2.0 will be the value
    // queries: a / c, we need to calculate the outcome
    // output: answers to all queries
    // graph??? we can seen abc as the node in g, and the value be the credit 
    // a -> b, credit: 2.0, b -> a, credit: 1/2.0
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // build the graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0 ; i < equations.size(); i++) {
            String a = equations.get(i).get(0); // 0 is index in list
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, value);
            graph.get(b).put(a, 1 / value);
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
                Set<String> vis = new HashSet<>();
                res[i] = dfs(graph, x, y, 1.0, vis);
            }
        }
        return res;
    }

    // dfs 會從圖中的cur節點一直搜索到target節點
    // value表示從起點到當前節點的累計權重，如果找到了cur到target的路徑，就返回路徑上的權重積
    private double dfs(Map<String, Map<String, Double>> graph, String cur, String tar, double value, Set<String> vis) {
        // 如果當前已經是target節點的話，返回當前路徑的累計值
        if (cur.equals(tar)) {
            return value;
        }
        // mark cur as vis
        vis.add(cur);

        // 遍歷當前節點的鄰居，鄰居存在graph中
        for (Map.Entry<String, Double> n : graph.get(cur).entrySet()) {
            String nextNeighbor = n.getKey();
            double nextNeighborValue = n.getValue();

            if (!vis.contains(nextNeighbor)) {
                // 繼續dfs:搜索鄰居節點到target節點的路徑
                // value * nextNeighborValue用於累積路徑上的乘積
                double res = dfs(graph, nextNeighbor, tar, value * nextNeighborValue, vis);

                // 如果dfs返回的不是-1，表示這個路徑上找到了有效的結果
                if (res != -1.0) {
                    return res;
                }
            }
        }
        // 如果所有鄰居都沒有通往目標節點的路徑，返回-1.0，表示找不到路徑
        return -1.0;
    }
}
