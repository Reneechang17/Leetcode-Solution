# Part 1: parse [len][AID][len][AID] -> List[str]
def parse_aids(s):
    res = []
    if not s:
        return res
    i = 0
    n = len(s)

    while i + 2 <= n:
        # read two parts
        parts = s[i:i+2]
        if not parts.isdigit():
            break
        length = int(parts)
        i += 2
        # check if remaining length is enough
        if i + length > n:
            break

        aid = s[i:i+length]
        res.append(aid)
        i += length
    return res

# Part 2: filter AIDs that system support
def filter_supported_aids(s, supported_aids):
    aids = parse_aids(s)
    if not aids or not supported_aids:
        return []
    sup_set = set(supported_aids)
    res = [a for a in aids if a in sup_set]
    return res

# Part 3: add RID prefix
def filter_supported_aids_with_rid(s, supported_aids, supported_rids):
    aids = parse_aids(s)
    if not aids:
        return []
    
    sup_set = set(supported_aids)
    rids = list(supported_rids)

    res = []
    seen = set()
    for aid in aids:
        if aid in seen:
            continue
        # exactly support
        if aid in sup_set:
            res.append(aid)
            seen.add(aid)
            continue
        # RID prefix match
        for rid in rids:
            if aid.startswith(rid):
                res.append(aid)
                seen.add(aid)
                break
    return res

# Test
if __name__ == "__main__":
    s = "18DS012345678987654310AI012345670"
    print("Phase 1")
    print(parse_aids(s))
    # Expected: ['DS0123456789876543', 'AI01234567']
    print(parse_aids("02AB02CD0"))
    # Expected: ['AB', 'CD']
    print(parse_aids(""))
    # Expected: []
    print(parse_aids("01A0"))
    # Expected: ['A']

    print("\nPhase 2")
    print(filter_supported_aids(s, ["DS0123456789876543"]))
    # Expected: ['DS0123456789876543']
    print(filter_supported_aids(s, ["AI01234567"]))
    # Expected: ['AI01234567']
    print(filter_supported_aids(s, ["DS0123456789876543", "AI01234567"]))
    # Expected: ['DS0123456789876543', 'AI01234567']
    print(filter_supported_aids(s, []))
    # Expected: []

    print("\nPhase 3")
    print(filter_supported_aids_with_rid(s,["DS0123456789876543"],["AI0"]))
    # Expected: ['DS0123456789876543', 'AI01234567']
    print(filter_supported_aids_with_rid(s,[],["AI0"]))
    # Expected: ['AI01234567']
    print(filter_supported_aids_with_rid(s,["DS0123456789876543"],[]))
    # Expected: ['DS0123456789876543']
    print(filter_supported_aids_with_rid(s,["AI01234567", "DS0123456789876543"],
                                        ["AI", "DS0"]))
    # Expected: ['DS0123456789876543', 'AI01234567']
    print(filter_supported_aids_with_rid(s,["ZZZ"],["XX"]))
    # Expected: []
