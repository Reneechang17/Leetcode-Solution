import unittest

# Part 1: parse [len][AID][len][AID] to AID list
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

        if i + length > n:
            break

        aid = s[i:i+length]
        res.append(aid)
        i += length
    
    return res

# Part2: filter AIDs that system support
def filter_supported_aids(s, supported_aids):
    aids = parse_aids(s)
    if not aids or not supported_aids:
        return []
    
    sup_set = set(supported_aids)
    res = [a for a in aids if a in sup_set]
    return res

# Part3: add RID prefix
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

# ---------Test----------
class TestAID(unittest.TestCase):

    # ---- Phase 1 ----
    def test_phase1_basic(self):
        s = "18DS012345678987654310AI012345670"
        self.assertEqual(
            parse_aids(s),
            ["DS0123456789876543", "AI01234567"],
        )

    # ---- Phase 2 ----
    def test_phase2_basic(self):
        s = "18DS012345678987654310AI012345670"
        sup = ["DS0123456789876543"]
        self.assertEqual(
            filter_supported_aids(s, sup),
            ["DS0123456789876543"],
        )

    # ---- Phase 3 ----
    def test_phase3_basic(self):
        s = "18DS012345678987654310AI012345670"
        sup_a = ["DS0123456789876543"]
        sup_r = ["AI0"]  
        self.assertEqual(
            filter_supported_aids_with_rid(s, sup_a, sup_r),
            ["DS0123456789876543", "AI01234567"],
        )


if __name__ == "__main__":
    unittest.main()
