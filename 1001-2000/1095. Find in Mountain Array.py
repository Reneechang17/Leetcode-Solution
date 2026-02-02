# Time:O(logn), Space:O(logn)

class Solution:
    def findInMountainArray(self, target: int, mountainArr: 'MountainArray') -> int:  # type: ignore
        # binary search find peak idx
        # then binary search to find target in [0..peak]
        # if can't find, find in [peak+1..n-1]

        n = mountainArr.length()

        cache = {}

        def get(i):
            if i in cache:
                return cache[i]
            cache[i] = mountainArr.get(i)
            return cache[i]

        l, r = 0, n - 1
        while l < r:
            mid = (l + r) // 2
            if get(mid) < get(mid + 1):
                l = mid + 1
            else:
                r = mid
        peak = l

        def binary_search(left, right, asc):
            l, r = left, right
            while l <= r:
                mid = (l + r) // 2
                val = get(mid)
                if val == target:
                    return mid
                
                if asc:
                    if val < target:
                        l = mid + 1
                    else:
                        r = mid - 1
                else:
                    if val < target:
                        r = mid - 1
                    else:
                        l = mid + 1
            return -1

        ans = binary_search(0, peak, True)
        if ans != -1:
            return ans
        
        return binary_search(peak + 1, n - 1, False)
