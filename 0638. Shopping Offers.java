// Medium
// DP, DFS
// Time:O(2^n * m),Space:O(2^n)
// https://leetcode.cn/problems/shopping-offers/

import java.util.*;

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // dp数组表示不同商品数量组合的最小花费
        Map<List<Integer>, Integer> dp = new HashMap<>();
        dp.put(new ArrayList<>(Collections.nCopies(needs.size(), 0)), 0);
        return dfs(price, special, needs, dp);
    }
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> dp) {
        if (dp.containsKey(needs)) {
            return dp.get(needs);
        }
        int minCost = 0;
        for (int i = 0; i < needs.size(); i++) {
            minCost += needs.get(i) * price.get(i);
        }

        // 尝试用每个优惠套餐
        for (List<Integer> offer : special) {
            // 检查当前套餐是否可以用
            List<Integer> newNeeds = new ArrayList<>(needs);
            boolean validOffer = true;
            // 检查是否满足使用优惠的条件:确保needs中的每个商品数量都足够使用该套餐
            for (int i = 0; i < needs.size(); i++) {
                if (newNeeds.get(i) < offer.get(i)) {
                    validOffer = false;
                    break;
                }
                newNeeds.set(i, newNeeds.get(i) - offer.get(i));
            }
            // 如果可以使用当前优惠套餐，递归计算更新后的花费
            if (validOffer) {
                minCost = Math.min(minCost, dfs(price, special, newNeeds, dp) + offer.get(offer.size() - 1));
            }
        }
        dp.put(needs, minCost);
        return minCost;
    }
}

/**
 * 比较好看出来是一个背包问题（但是好难的感觉...?
 * 题目整理：有一个商店，商店有若干商品，每种商品有一定价格，也可以选择一些优惠套餐来购买商品
 * 需要找到最小的花费来购买所有商品，可以使用一些优惠套餐，但不一定每个套餐都必须使用
 * => 可以将每个商品看作背包的物品，每个优惠套餐为一个选择，每个选择会消耗一部分资源（为商品数量）
 */
