// Medium
// Greedy, Simulation
// Time:O(n*m + friendships.length), Space:O(m* avg lang numbers)
// https://leetcode.cn/problems/minimum-number-of-people-to-teach/


class Solution {
    public String sortVowels(String s) {
        int[] cnt = new int[128]; // ASCII size
        String vowels = "aeiouAEIOU";

        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                cnt[c]++;
            }
        }

        StringBuilder sortedVowels = new StringBuilder();
        for (char c : "AEIOUaeiou".toCharArray()) {
            while (cnt[c]-- > 0) {
                sortedVowels.append(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                sb.append(sortedVowels.charAt(index++));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

// class Solution {
//     // Time:O(nlogn), Space:O(n)
//     public String sortVowels(String s) {
//         List<Character> vowels = new ArrayList<>();
//         Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

//         for (char c : s.toCharArray()) {
//             if (set.contains(c)) {
//                 vowels.add(c);
//             }
//         }

//         Collections.sort(vowels);

//         StringBuilder sb = new StringBuilder();
//         int index = 0;

//         for (char c : s.toCharArray()) {
//             if (vowels.contains(c)) {
//                 sb.append(vowels.get(index++));
//             } else {
//                 sb.append(c);
//             }
//         }
//         return sb.toString();
//     }
// }
