// Hard
// Simulation
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/read-n-characters-given-read4-ii-call-multiple-times/

package main

var solution = func(read4 func([]byte) int) func([]byte, int) int {
	// implement read below.
	temp := make([]byte, 4)
	tempIndex := 0
	tempCount := 0

	return func(buf []byte, n int) int {
			index := 0
			for ; tempIndex < tempCount && index < n; tempIndex, index = tempIndex + 1, index + 1 {
					buf[index] = temp[tempIndex]
			}
			for index < n {
					tempCount = read4(temp)
					tempIndex = 0
					for tempIndex = 0; tempIndex < tempCount && index < n; tempIndex, index = tempIndex + 1, index + 1 {
							buf[index] = temp[tempIndex]
					}
					if tempCount < 4 {
							break
					}
			}
			if n < index {
					return n
			}
			return index
	}
}

// 用temp做缓存：大小为4，用于存储read4读取的数据
//   tempIndex为指向缓存区中当前字符的索引
//   tempCount是当前缓存区的有效字符数

// 第一个循环：从缓存读取数据
//   如果缓存中还有有效数据，就直接将数据temp复制到buf中，直到buf中填满n个字符或缓存数据用完
// 第二个循环：从read4读取新数据
//   如果缓存数据已经用完，调用read4读取新数据，将读取到的数据填充到buf中，直到填满n个字符或
//   read4返回的字符数少于4，表示文件已经结束
