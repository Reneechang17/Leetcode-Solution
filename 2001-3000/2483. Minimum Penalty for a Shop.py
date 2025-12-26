# Time:O(n), Space:O(1)

class Solution:
    def bestClosingTime(self, customers: str) -> int:
        n = len(customers)

        min_penalty = float('inf')
        best_time = 0

        n_count = 0
        y_after = customers.count('Y')

        for i in range(n + 1):
            penalty = n_count + y_after
            
            if penalty < min_penalty:
                min_penalty = penalty
                best_time = i
            
            if i < n:
                if customers[i] == 'N':
                    n_count += 1
                else:
                    y_after -= 1
        return best_time
    