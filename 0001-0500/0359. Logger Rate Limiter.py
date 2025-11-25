# Easy
# Map, Design
# Time:O(1), Space:O(n) 
# https://leetcode.cn/problems/logger-rate-limiter/

class Logger:
    def __init__(self):
        self.log_dict = {} # msg -> last_ts
    
    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        # if not in dict -> add and print
        if message not in self.log_dict:
            self.log_dict[message] = timestamp
            return True
        
        if timestamp - self.log_dict[message] >= 10:
            self.log_dict[message] = timestamp
            return True
        
        return False
