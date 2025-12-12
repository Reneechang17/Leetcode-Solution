package main
// Medium
// https://leetcode.cn/problems/web-crawler-multithreaded/

import (
	// "math/rand"
	"net/url"
	"sync"
	// "time"
)

// duplicate: multi goroutine might crawl the same URL
// -> need a thread-safe vis set
// task distribution: how to distribute the new URL to
// a goroutine
// counter: know all URLs done.

/*
 This is HtmlParser's API interface.
 You should not implement it, or speculate about its implementation
    type HtmlParser struct {
        maps  map[string]int
        imaps map[int]string
        a     map[int][]int
    }
*/
func crawl(startUrl string, htmlParser *HtmlParser) []string {
    hostname := getHostname(startUrl)
    vis := sync.Map{}
    res := []string{}
    resMu := sync.Mutex{}

    var wg sync.WaitGroup

    var dfs func(url string)
    dfs = func(urlStr string) {
        defer wg.Done()

        if _, loaded := vis.LoadOrStore(urlStr, true); loaded {
            return
        }
        // equal to
        // if vis[url] {return}
        // vis[url] = true

        resMu.Lock()
        res = append(res, urlStr)
        resMu.Unlock()

        urls := htmlParser.GetUrls(urlStr)

        for _, u := range urls {
            if getHostname(u) == hostname {
                if _, exists := vis.Load(u); !exists {
                    wg.Add(1)
                    go dfs(u)
                }
            }
        }
    }

    wg.Add(1)
    go dfs(startUrl)

    wg.Wait()
    return res
}

func getHostname(urlStr string) string {
    u, _ := url.Parse(urlStr)
    return u.Hostname()
}
