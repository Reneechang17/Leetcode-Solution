// Easy
// Hash Table, Array
// Time:O(1), Space:O(n)
// https://leetcode.cn/problems/design-hashmap/

import java.util.Arrays;

class MyHashMap {
    // Implement a simple HashMap using an array
    // - HashMap fundamentally relies on an array-based structure, so we can directly use an array to simulate it
    // - Use an array of size 1,000,001 to cover all possible key values (0 to 1,000,000)
    // - Initialize the array with -1 to represent "no value"
    private int[] arr = new int[1000001];

    public MyHashMap() {
        Arrays.fill(arr, -1);
    }
    
    public void put(int key, int value) {
        arr[key] = value;
    }
    
    public int get(int key) {
        return arr[key];
    }
    
    public void remove(int key) {
        arr[key] = -1;
    }
}
