import unittest

# Part 1: exact match only

def parse_accept_language(header, supported_languages):
    if not header or not header.strip():
        return "header is not valid"
    if not supported_languages:
        return "supported_languages is not valid"
    
    pref_list = [item.strip() for item in header.split(",") if item.strip()]
    sup_set = set(supported_languages)

    res = [tag for tag in pref_list if tag in sup_set]
    return res

# Part 2: add generic tags like "fr"
def parse_accept_language_v2(header, supported_languages):
    if not header or not header.strip():
        return "header is not valid"
    if not supported_languages:
        return "supported_languages is not valid"
    
    pref_list = [item.strip() for item in header.split(",") if item.strip()]
    sup = list(supported_languages)
    sup_set = set(supported_languages)

    res = []
    seen = set()

    for tag in pref_list:
        # exact match
        if tag in sup_set and tag not in seen:
            res.append(tag)
            seen.add(tag)
            continue

        # generic match, eg "fr" -> "fr-CA", "fr-FR"
        if "-" not in tag and tag != "*":
            prefix = tag + "-"
            for s in sup:
                if s.startswith(prefix) and s not in seen:
                    res.append(s)
                    seen.add(s)
    return res

# Part 3: extend with wildcard
def parse_accept_language_ordered(header, supported_languages):
    if not header or not header.strip():
        return "header is not valid"
    if not supported_languages:
        return "supported_languages is not valid"
    
    pref_list = [item.strip() for item in header.split(",") if item.strip()]
    sup = list(supported_languages)
    sup_set = set(supported_languages)

    res = []
    seen = set()

    for tag in pref_list:
        if tag == "*":
            # add all remaining supported languages
            for s in sup:
                if s not in seen:
                    res.append(s)
                    seen.add(s)
        elif tag in sup_set:
            # exact match
            if tag not in seen:
                res.append(tag)
                seen.add(tag)
        else:
            # generic
            if "-" not in tag:
                prefix = tag + "-"
                for s in sup:
                    if s.startswith(prefix) and s not in seen:
                        res.append(s)
                        seen.add(s)
    return res

# Part 4: add q-factors
def parse_accept_language_qfactor(header, supported_languages):
    if not header or not header.strip():
        return "header is not valid"
    if not supported_languages:
        return "supported_languages is not valid"
    
    sup = list(supported_languages)

    # parse header to (tag, q, index)
    entries = []
    for idx, raw in enumerate(header.split(",")):
        raw = raw.strip()
        if not raw:
            continue
        parts = [p.strip() for p in raw.split(";")]
        tag = parts[0]
        q = 1.0
        if len(parts) >= 2 and parts[1].startswith("q="):
            try:
                q = float(parts[1][2:])
            except ValueError:
                q = 1.0
        entries.append((tag, q, idx))
    
    def match_spec(entry_tag, sup_tag):
        if entry_tag == "*":
            return 0
        if entry_tag == sup_tag:
            return 2
        if "-" not in entry_tag and sup_tag.startswith(entry_tag + "-"):
            return 1
        return None
    
    # best[lang] = (q, spec, entry_idx)
    best = {}

    for entry_tag, q, idx in entries:
        for s in sup:
            spec = match_spec(entry_tag, s)
            if spec is None:
                continue
            if s not in best:
                best[s] = (q, spec, idx)
            else:
                cur_q, cur_spec, cur_idx = best[s]
                if spec > cur_spec: 
                    best[s] = (q, spec, idx)
                elif spec == cur_spec and q > cur_q:
                    best[s] = (q, spec, idx)
    
    # only keep match supported
    items = []
    for sup_idx, s in enumerate(sup):
        if s in best:
            q, spec, idx = best[s]
            items.append((s, q, spec, idx, sup_idx))
        
    # sort 
    items.sort(key=lambda x: (-x[1], -x[2], x[3], x[4]))

    return [s for (s, _, _, _, _) in items]

class TestAcceptLanguage(unittest.TestCase):

    # ----- Part 1 -----
    def test_part1_examples(self):
        self.assertEqual(
            parse_accept_language("en-US, fr-CA, fr-FR", ["fr-FR", "en-US"]),
            ["en-US", "fr-FR"],
        )
        self.assertEqual(
            parse_accept_language("fr-CA, fr-FR", ["en-US", "fr-FR"]),
            ["fr-FR"],
        )
        self.assertEqual(
            parse_accept_language("en-US", ["en-US", "fr-CA"]),
            ["en-US"],
        )

    # ----- Part 2 -----
    def test_part2_examples(self):
        self.assertEqual(
            parse_accept_language_v2("en", ["en-US", "fr-CA", "fr-FR"]),
            ["en-US"],
        )
        self.assertEqual(
            parse_accept_language_v2("fr", ["en-US", "fr-CA", "fr-FR"]),
            ["fr-CA", "fr-FR"],
        )
        self.assertEqual(
            parse_accept_language_v2("fr-FR, fr", ["en-US", "fr-CA", "fr-FR"]),
            ["fr-FR", "fr-CA"],
        )

    # ----- Part 3 -----
    def test_part3_examples(self):
        self.assertEqual(
            parse_accept_language_ordered("en-US, *", ["en-US", "fr-CA", "fr-FR"]),
            ["en-US", "fr-CA", "fr-FR"],
        )
        self.assertEqual(
            parse_accept_language_ordered("fr-FR, fr, *", ["en-US", "fr-CA", "fr-FR"]),
            ["fr-FR", "fr-CA", "en-US"],
        )

    # ----- Part 4 -----
    def test_part4_examples(self):
        self.assertEqual(
            parse_accept_language_qfactor(
                "fr-FR;q=1, fr-CA;q=0, fr;q=0.5",
                ["fr-FR", "fr-CA", "fr-BG"],
            ),
            ["fr-FR", "fr-BG", "fr-CA"],
        )
        self.assertEqual(
            parse_accept_language_qfactor(
                "fr-FR;q=1, fr-CA;q=0, *;q=0.5",
                ["fr-FR", "fr-CA", "fr-BG", "en-US"],
            ),
            ["fr-FR", "fr-BG", "en-US", "fr-CA"],
        )
        self.assertEqual(
            parse_accept_language_qfactor(
                "fr-FR;q=1, fr-CA;q=0.8, *;q=0.5",
                ["fr-FR", "fr-CA", "fr-BG", "en-US"],
            ),
            ["fr-FR", "fr-CA", "fr-BG", "en-US"],
        )

    def test_part4_compat_simple(self):
        self.assertEqual(
            parse_accept_language_qfactor(
                "en-US, *",
                ["en-US", "fr-CA", "fr-FR"],
            ),
            ["en-US", "fr-CA", "fr-FR"],
        )
        self.assertEqual(
            parse_accept_language_qfactor(
                "fr-FR, fr, *",
                ["en-US", "fr-CA", "fr-FR"],
            ),
            ["fr-FR", "fr-CA", "en-US"],
        )

if __name__ == "__main__":
    unittest.main()
