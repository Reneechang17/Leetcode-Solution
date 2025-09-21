import java.util.*;
// 抄了没时间想

class MovieRentingSystem {
    
    // 使用 long 編碼避免數組比較
    private Map<Long, Integer> priceMap;  // (shop << 32 | movie) -> price
    private Map<Integer, TreeSet<Long>> available;  // movie -> set of (price << 40 | shop)
    private TreeSet<Long> rented;  // set of (price << 40 | shop << 20 | movie)
    
    public MovieRentingSystem(int n, int[][] entries) {
        priceMap = new HashMap<>();
        available = new HashMap<>();
        rented = new TreeSet<>();
        
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            
            long key = ((long)shop << 32) | movie;
            priceMap.put(key, price);
            
            available.computeIfAbsent(movie, k -> new TreeSet<>())
                    .add(((long)price << 40) | shop);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        
        TreeSet<Long> set = available.get(movie);
        if (set == null) return res;
        
        int count = 0;
        for (long encoded : set) {
            res.add((int)(encoded & 0xFFFFF));  // 提取 shop
            if (++count == 5) break;
        }
        
        return res;
    }
    
    public void rent(int shop, int movie) {
        long key = ((long)shop << 32) | movie;
        int price = priceMap.get(key);
        
        long availableKey = ((long)price << 40) | shop;
        available.get(movie).remove(availableKey);
        
        long rentedKey = ((long)price << 40) | ((long)shop << 20) | movie;
        rented.add(rentedKey);
    }
    
    public void drop(int shop, int movie) {
        long key = ((long)shop << 32) | movie;
        int price = priceMap.get(key);
        
        long rentedKey = ((long)price << 40) | ((long)shop << 20) | movie;
        rented.remove(rentedKey);
        
        long availableKey = ((long)price << 40) | shop;
        available.get(movie).add(availableKey);
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        
        int count = 0;
        for (long encoded : rented) {
            int shop = (int)((encoded >> 20) & 0xFFFFF);
            int movie = (int)(encoded & 0xFFFFF);
            res.add(Arrays.asList(shop, movie));
            if (++count == 5) break;
        }
        
        return res;
    }
}
