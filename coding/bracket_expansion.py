# Part 1/2: single brace

def expand_single_brace(s):
    # find '{'
    l = s.find("{")
    if l == -1:
        return [s]
    
    # find '}'
    r = s.find("}", l + 1)
    if r == -1:
        return [s]
    
    first_close = s.find("}")
    if first_close != -1 and first_close < 1:
        return [s]
    
    inside = s[l + 1: r]
    tokens = inside.split(",")
    tokens = [t for t in tokens if t != ""]

    if len(tokens) < 2:
        return [s]
    
    prefix = s[:l]
    suffix = s[r + 1:]

    res = []
    for t in tokens:
        res.append(prefix + t + suffix)
    return res

# Part 3: similar to lc 1087
def brace_expansion(s):
    segments = []
    i = 0
    n = len(s)

    literal = ""

    while i < n:
        c = s[i]
        if c == "{":
            if literal:
                segments.append([literal])
                literal = ""
            
            j = i + 1
            while j < n and s[j] != "}":
                j += 1
            if j == n:
                literal += s[i:]
                break

            inside = s[i + 1:j]
            opts = inside.split(",")
            opts = [t for t in opts if t != ""]
            opts.sort()

            if not opts:
                literal += s[i:j + 1]
            else:
                segments.append(opts)
            i = j + 1

        else:
            literal += c
            i += 1
    
    if literal:
        segments.append([literal])
    
    if not segments:
        return [s]
    
    res = []

    def backtracking(idx, path):
        if idx == len(segments):
            res.append(path)
            return
        for t in segments[idx]:
            backtracking(idx + 1, path + t)
    
    backtracking(0, "")
    return res

# test
if __name__ == "__main__":
    print("=== Part 1 + 2: expand_single_brace ===")

    # Part 1
    s1 = "/2022/{jan,feb,march}/report"
    print("Input:", s1)
    print("Output:")
    for x in expand_single_brace(s1):
        print(" ", x)
    # expect:
    # /2022/jan/report
    # /2022/feb/report
    # /2022/march/report

    print()

    # Part 2
    s2 = "pre{mid}suf"
    print("Input:", s2)
    print("Output:", expand_single_brace(s2))
    # expect: ["pre{mid}suf"]

    # invalid: empty
    s3 = "pre{}suf"
    print("Input:", s3)
    print("Output:", expand_single_brace(s3))
    # expect: ["pre{}suf"]

    # invalid: no brace
    s4 = "premidsuf"
    print("Input:", s4)
    print("Output:", expand_single_brace(s4))
    # expect: ["premidsuf"]

    # invalid
    s5 = "pre}abc{xyz"
    print("Input:", s5)
    print("Output:", expand_single_brace(s5))
    # expect: ["pre}abc{xyz"]

    print("\n=== Part 3: brace_expansion (LeetCode 1087 style) ===")

    s6 = "{a,b}c{d,e}f"
    print("Input:", s6)
    out6 = brace_expansion(s6)
    print("Output:", out6)
    # expect:
    # ["acdf","acef","bcdf","bcef"]

    s7 = "/2022/{jan,feb}/{x,y}/report"
    print("Input:", s7)
    out7 = brace_expansion(s7)
    print("Output:")
    for o in out7:
        print(" ", o)
    # expect: 
    # /2022/jan/x/report
    # /2022/jan/y/report
    # /2022/feb/x/report
    # /2022/feb/y/report

    s8 = "pre{a,b,c}suf"
    print("Input:", s8)
    print("Output:", brace_expansion(s8))
    # ["preasuf", "prebsuf", "precsuf"]
