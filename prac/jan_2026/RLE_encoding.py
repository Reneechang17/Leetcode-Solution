"""
Run-Length Encoding (RLE) for Digits

Encode: Compress consecutive identical digits into "count + digit"
Decode: Expand "count + digit" back to original string

Example:
Input: 11122333455
Segments: 111, 22, 333, 4, 55
Count+Digit: 3 1, 2 2, 3 3, 1 4, 2 5
Output: 3122331425

Special case: "12345" -> "1112131415" (each count is 1)
"""
# Time:O(n), Space:O(n)

def rle_encoding(s: str) -> str:
    if not s:
        return ""
    
    res = []
    i = 0
    n = len(s)

    while i < n:
        count = 1
        while i + count < n and s[i] == s[i + count]:
            count += 1
        
        res.append(str(count))
        res.append(s[i])

        i += count
    
    return ''.join(res)

def rle_decoding(s: str) -> str:
    if not s:
        return ""
    
    res = []
    i = 0
    n = len(s)

    while i < n:
        count = int(s[i])
        digit = s[i + 1]
        res.append(digit * count)
        i += 2

    return ''.join(res)

print("=== Encode Tests ===")
print(rle_encoding("11122333455"))   # 3122331425
print(rle_encoding("12345"))         # 1112131415
print(rle_encoding("1111"))          # 41
print(rle_encoding(""))              # ""

print("\n=== Decode Tests ===")
print(rle_decoding("3122331425"))    # 11122333455
print(rle_decoding("1112131415"))    # 12345
print(rle_decoding("41"))            # 1111
print(rle_decoding(""))              # ""
