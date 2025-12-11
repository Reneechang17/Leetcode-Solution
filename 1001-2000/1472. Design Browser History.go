package main
// Medium
// Array
// Time:O(1), Space:O(n)
// https://leetcode.cn/problems/design-browser-history/

type BrowserHistory struct {
    history []string
    cur int
}

func Constructor(homepage string) BrowserHistory {
    return BrowserHistory{
        history: []string{homepage},
        cur: 0,
    }
}

func (this *BrowserHistory) Visit(url string)  {
    this.history = this.history[:this.cur + 1]
    this.history = append(this.history, url)
    this.cur++
}

func (this *BrowserHistory) Back(steps int) string {
    this.cur = max(0, this.cur - steps)
    return this.history[this.cur]
}

func (this *BrowserHistory) Forward(steps int) string {
    this.cur = min(len(this.history) - 1, this.cur + steps)
    return this.history[this.cur]
}
