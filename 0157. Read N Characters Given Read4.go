// Easy
// Simulation
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/read-n-characters-given-read4/

package main

var readNCharactersGivenRead4 = func(read4 func([]byte) int) func([]byte, int) int {
	// implement read below.
	return func(buf []byte, n int) int {
			total := 0
			tmp := make([]byte, 4)
			for total < n {
					count := read4(tmp)
					if count == 0 {
							break
					}
					
					remain := min(count, n - total)
					copy(buf[total:], tmp[:remain])
					total += remain

					if count < 4 {
							break
					}
			}
			return total
	}
}
