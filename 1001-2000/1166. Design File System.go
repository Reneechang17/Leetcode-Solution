package main
// Medium
// HashMap, String
// https://leetcode.cn/problems/design-file-system/


import "strings"

type FileSystem struct {
    paths map[string]int
}

func Constructor() FileSystem {
    return FileSystem{
        paths: make(map[string]int),
    }
}

// Time:O(L), Space:O(n * L)
func (this *FileSystem) CreatePath(path string, value int) bool {
    if path == "/" {
        return false
    }

    if _, exists := this.paths[path]; exists {
        return false
    }

    // check if parent path exists
    parent := this.getParent(path)
    if parent != "" && !this.exists(parent) {
        return false
    }

    this.paths[path] = value
    return true
}

// Time:O(1), Space:O(n * L)
func (this *FileSystem) Get(path string) int {
    if val, exists := this.paths[path]; exists {
        return val
    }
    return -1
}

func (this *FileSystem) getParent(path string) string {
    lastSlash := strings.LastIndex(path, "/")
    if lastSlash <= 0 {
        return ""
    }
    return path[:lastSlash]
}

func (this *FileSystem) exists(path string) bool {
    _, exists := this.paths[path]
    return exists
}
