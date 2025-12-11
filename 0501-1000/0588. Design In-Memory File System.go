package main
// Hard
// https://leetcode.cn/problems/design-in-memory-file-system/

import (
	"sort"
	"strings"
)
type FileSystem struct {
    root *Node
}

type Node struct {
    isFile bool
    content string
    children map[string]*Node
}

func Constructor() FileSystem {
    return FileSystem{
        root: &Node{
            children: make(map[string]*Node),
        },
    }
}

func (this *FileSystem) Ls(path string) []string {
    node := this.traverse(path)

    if node.isFile {
        parts := splitPath(path)
        return []string{parts[len(parts) - 1]}
    }

    res := []string{}
    for name := range node.children {
        res = append(res, name)
    }
    sort.Strings(res)
    return res
}

func (this *FileSystem) Mkdir(path string)  {
    parts := splitPath(path)
    cur := this.root

    for _, part := range parts {
        if cur.children[part] == nil {
            cur.children[part] = &Node{
                children: make(map[string]*Node),
            }
        }
        cur = cur.children[part]
    }
}

func (this *FileSystem) AddContentToFile(filePath string, content string)  {
    parts := splitPath(filePath)
    cur := this.root

    for i := 0; i < len(parts) - 1; i++ {
        if cur.children[parts[i]] == nil {
            cur.children[parts[i]] = &Node{
                children: make(map[string]*Node),
            }
        }
        cur = cur.children[parts[i]]
    }
    
    fileName := parts[len(parts) - 1]
    if cur.children[fileName] == nil {
        cur.children[fileName] = &Node{
            isFile: true,
            content: content,
            children: make(map[string]*Node),
        }
    } else {
        cur.children[fileName].content += content
    }
}

func (this *FileSystem) ReadContentFromFile(filePath string) string {
    node := this.traverse(filePath)
    return node.content
}

func (this *FileSystem) traverse(path string) *Node {
    if path == "/" {
        return this.root
    }

    parts := splitPath(path)
    cur := this.root

    for _, part := range parts {
        cur = cur.children[part]
    }
    return cur
}

func splitPath(path string) []string {
    if path == "/" {
        return []string{}
    }
    
    parts := []string{}
    for _, p := range strings.Split(path, "/") {
        if p != "" {
            parts = append(parts, p)
        }
    }
    return parts
}
