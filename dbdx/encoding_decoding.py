# rules: (default) RLE only when run len>=8; otherwise use BP(8).
# but for first example, if we accept the "last run may be short RLE" 
# we can have a toggle allow_last_short_rle=True if we want

# Time:O(n), Space:O(n)

RLE_MIN = 8
BP_BLOCK = 8

def encode(values, allow_last_short_rle=False):
    runs = []
    n = len(values)
    i = 0

    while i < n:
        j = i + 1
        while j < n and values[j] == values[i]:
            j += 1
        rep = j - i # equal-run length

        # decide RLE or BP
        use_rle = rep >= RLE_MIN
        if not use_rle and allow_last_short_rle:
            # if this is the tail of the input, we may allow a short RLE
            if j == n:
                use_rle = True
        
        if use_rle:
            runs.append(("R", values[i], rep))
            i = j
        else:
            # BP: take exactly 8 unless we're at the very end
            k = min(BP_BLOCK, n - i)
            runs.append(("B", values[i:i+k]))
            i += k
    return runs

def decode(runs):
    output = []
    for r in runs:
        if not r:
            continue
        t = r[0]
        if t == "R":
            _, v, cnt = r
            output.extend([v] * cnt)
        elif t == "B":
            _, arr = r
            output.extend(arr)
        else:
            raise ValueError(f"Unknown run type: {t}")
    return output

# Test
if __name__ == "__main__":
    cases = [
        [],                          # empty
        [1,1,1],                     # strict: BP([1,1,1]); relaxed: RLE(1,3)
        [1,1,1,1,2,3,4,5],           # one BP block (8 vals)
        [1]*8 + [2,3,4,5],           # RLE(1,8), BP([2,3,4,5])
        [1]*9 + [2,3,4,5],           # RLE(1,9), BP([2,3,4,5])
        [2,3,4,5,2,3,4,5],           # all BP
        [7]*7 + [8]*8 + [9]*7,       # BP(7), RLE(8), BP(7)
        [5]*20,                      # single long RLE
    ]

    print("=== Strict mode (default) ===")
    for arr in cases:
        enc = encode(arr, allow_last_short_rle=False)
        dec = decode(enc)
        print("in :", arr)
        print("enc:", enc)
        print("ok?:", dec == arr)
        print("-"*40)

    print("=== Relaxed: allow last short RLE ===")
    for arr in cases:
        enc = encode(arr, allow_last_short_rle=True)
        dec = decode(enc)
        print("in :", arr)
        print("enc:", enc)
        print("ok?:", dec == arr)
        print("-"*40)
