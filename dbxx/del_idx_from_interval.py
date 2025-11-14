# core is find the pos of the idx in range and seg by this pos

from typing import *

def delete_index_from_intervals(intervals: List[Tuple[int, int]], idx: int) -> List[Tuple[int, int]]:
    if idx < 0:
        raise IndexError("idx must be >= 0")
    output = []

    for i, (L, R) in enumerate(intervals):
        seg_len = R - L + 1
        if idx >= seg_len:
            # idx not in this seg, reserve it
            output.append((L,R))
            idx -= seg_len # to next
            continue

        # idx in (L,R), actual val is L+idx
        val = L + idx

        # cases to seg
        if L == R == val:
            pass # delete entire seg
        elif val == L:
            output.append((L+1, R))
        elif val == R:
            output.append((L,R-1))
        else:
            output.append((L, val - 1))
            output.append((val+1, R))
        
        output.extend(intervals[i+1:])
        return output
    
    raise IndexError("idx exceeds total covered length")

# Test
if __name__ == "__main__":
    print(delete_index_from_intervals([(4,7),(10,11),(13,15)], 2))  # [(4,5),(7,7),(10,11),(13,15)]
    print(delete_index_from_intervals([(4,7)], 0))  # del 4 → [(5,7)]
    print(delete_index_from_intervals([(4,7)], 3))  # del 7 → [(4,6)]
    print(delete_index_from_intervals([(4,7)], 1))  # del 5 → [(4,4),(6,7)]
    print(delete_index_from_intervals([(5,5)], 0))  # del  → []
    print(delete_index_from_intervals([(1,2),(5,7)], 3))  # del 6 → [(1,2),(5,5),(7,7)]
