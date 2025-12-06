package main
// Medium
// Time:O(nm), Space:O(nm)
// https://leetcode.cn/problems/subdomain-visit-count/

import (
	"strconv"
	"strings"
)
func subdomainVisits(cpdomains []string) []string {
    count := make(map[string]int)

    for _, cpdomain := range cpdomains {
        parts := strings.Split(cpdomain, " ")
        num, _ := strconv.Atoi(parts[0]) // str to int
        domain := parts[1]

        for {
            count[domain] += num
            idx := strings.Index(domain, ".")
            if idx == -1 {
                break
            }
            domain = domain[idx+1:]
        }
    }

    res := []string{}
    for domain, cnt := range count {
        res = append(res, strconv.Itoa(cnt) + " " + domain)
    }
    return res
}
