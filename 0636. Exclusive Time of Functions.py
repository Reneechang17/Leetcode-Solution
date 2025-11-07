
from typing import *

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        res = [0] * n
        stack = [] # store (func_id, start time)
        prev_time = 0

        for log in logs:
            func_id, event, time = log.split(':')
            func_id = int(func_id)
            time = int(time)

            if event == 'start':
                if stack:
                    res[stack[-1]] += time - prev_time
                
                stack.append(func_id)
                prev_time = time
            
            else:
                res[stack[-1]] += time - prev_time + 1
                stack.pop()
                prev_time = time + 1
        
        return res
    