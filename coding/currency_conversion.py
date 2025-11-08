import unittest

# Common parser
# return { from_curr: [(to_curr, rate), ...], ... }
# each entry should have FROM:TO:RATE

def parse_conversion_rates(rates_str):
    if not rates_str:
        return "Error: empty input string"
    
    rate_map = {}
    for entry in rates_str.split(","):
        entry = entry.strip()
        if not entry:
            continue
        parts = entry.split(":")
        if len(parts) != 3:
            return f"Error: invalid entry format"
        
        from_curr, to_curr, rate_str = parts
        try:
            rate = float(rate_str)
        except ValueError:
            return f"Error: invalid rate value"
        
        if rate <= 0:
            return f"Error: non positive rate value"
        
        if from_curr not in rate_map:
            rate_map[from_curr] = []
        rate_map[from_curr].append((to_curr, rate))
    
    return rate_map

# Part 1: get direct conversion rate (from -> to)
def get_direct_conversion_rate(rates_str, from_currency, to_currency):
    parsed = parse_conversion_rates(rates_str)
    if isinstance(parsed, str):
        return parsed
    
    for to_curr, rate in parsed.get(from_currency, []):
        if to_curr == to_currency:
            return rate
    
    return "Error: direct conversion not found"

# Part 2: accept 0/1's transfer
# return all possible concurrency list
def get_single_hop_conversion_rate(rates_str, from_currency, to_currency):
    parsed = parse_conversion_rates(rates_str)
    if isinstance(parsed, str):
        return parsed
    
    rates = []

    # direct from -> to
    for to_curr, rate in parsed.get(from_currency, []):
        if to_curr == to_currency:
            rates.append(rate)
    
    # one mid: from -> mid -> to
    for mid_curr, r1 in parsed.get(from_currency, []):
        for to_curr, r2 in parsed.get(mid_curr, []):
            if to_curr == to_currency:
                rates.append(r1 * r2)
    
    return sorted(rates) if rates else "Error: no single-hop conversion found"

# Part 3: get best single-hop
def get_best_single_hop_conversion_rate(rates_str, from_currency, to_currency):
    parsed = parse_conversion_rates(rates_str)
    if isinstance(parsed, str):
        return parsed
    
    best = 0.0

    # direct
    for to_curr, rate in parsed.get(from_currency, []):
        if to_curr == to_currency:
            best = max(best, rate)

    # one hop
    for mid_curr, r1 in parsed.get(from_currency, []):
        for to_curr2, r2 in parsed.get(mid_curr, []):
            if to_curr2 == to_currency:
                best = max(best, r1 * r2)
    
    return best if best > 0 else "Error: no single-hop conversion found"

# Part 4: accept multiple times transfer -> use DFS to find the global optimal
def get_best_conversion_rate(rates_str, from_currency, to_currency):
    parsed = parse_conversion_rates(rates_str)
    if isinstance(parsed, str):
        return parsed
    
    vis = set()
    max_rate = [0.0]

    def dfs(curr, acc):
        if curr == to_currency:
            max_rate[0] = max(max_rate[0], acc)
            return 
        vis.add(curr)
        for next, rate in parsed.get(curr, []):
            if next not in vis:
                dfs(next, acc * rate)
        vis.remove(curr)

    dfs(from_currency, 1.0)

    return max_rate[0] if max_rate[0] > 0 else "Error: no conversion path found"

# test
if __name__ == "__main__":
    print("Part 1")
    # Test 1: basic conversion
    print(
        get_direct_conversion_rate("AUD:USD:0.7,AUD:JPY:100,USD:CAD:1.2", "AUD", "USD")
    )
    # Expected: 0.7

    # Test 2: direct conversion not found
    print(
        get_direct_conversion_rate("AUD:USD:0.7,AUD:JPY:100,USD:CAD:1.2", "AUD", "CAD")
    )
    # Expected: Error: direct conversion not found

    # Test 3: empty string
    print(get_direct_conversion_rate("", "AUD", "USD"))
    # Expected: Error: empty input string

    # Test 4: invalid rate format
    print(get_direct_conversion_rate("AUD:USD:abc", "AUD", "USD"))
    # Expected: Error: invalid rate value 'abc' in 'AUD:USD:abc'

    # Test 5: malformed entry
    print(get_direct_conversion_rate("AUD:USD:0.7,AUDJPY100", "AUD", "JPY"))
    # Expected: Error: malformed entry 'AUDJPY100'

    # Test 6: case sensitive currency mismatch
    print(get_direct_conversion_rate("aud:usd:0.7", "AUD", "USD"))
    # Expected: Error: direct conversion not found

    print("\nPart 2")
    # Test 1: direct only
    print(get_single_hop_conversion_rate("AUD:USD:0.7,USD:CAD:1.2", "AUD", "USD"))
    # Expected: [0.7]

    # Test 2: direct and one-hop (AUD->USD->CAD)
    print(
        get_single_hop_conversion_rate(
            "AUD:CAD:0.75,AUD:USD:0.7,USD:CAD:1.2", "AUD", "CAD"
        )
    )
    # Expected: [0.75, 0.84]

    # Test 3: multiple one-hop paths (AUD->EUR->CAD, AUD->USD->CAD)
    print(
        get_single_hop_conversion_rate(
            "AUD:USD:0.7,AUD:EUR:0.6,USD:CAD:1.2,EUR:CAD:1.5", "AUD", "CAD"
        )
    )
    # Expected: [0.84, 0.9]

    # Test 4: no direct or one-hop path
    print(get_single_hop_conversion_rate("AUD:JPY:100,USD:CAD:1.2", "AUD", "CAD"))
    # Expected: Error: no single-hop conversion found

    # Test 5: empty input
    print(get_single_hop_conversion_rate("", "AUD", "USD"))
    # Expected: Error: empty input string

    # Test 6: malformed entry
    print(get_single_hop_conversion_rate("AUD:USD:0.7,AUDJPY100", "AUD", "CAD"))
    # Expected: Error: malformed entry 'AUDJPY100'

    # Test 7: invalid rate
    print(get_single_hop_conversion_rate("AUD:USD:abc", "AUD", "USD"))
    # Expected: Error: invalid rate value 'abc' in 'AUD:USD:abc'

    # Test 8: case-sensitive mismatch
    print(get_single_hop_conversion_rate("aud:usd:0.7,usd:cad:1.2", "AUD", "CAD"))
    # Expected: Error: no single-hop conversion found

    print("\nPart 3 (best single hop: 0 or 1 conversion)")
    # Test 1: direct only
    print(get_best_single_hop_conversion_rate("AUD:USD:0.7", "AUD", "USD"))
    # Expected: 0.7

    # Test 2: two single-hop paths, pick better one (AUD->EUR->CAD is better)
    print(
        round(
            get_best_single_hop_conversion_rate(
                "AUD:USD:0.7,AUD:EUR:0.6,USD:CAD:1.2,EUR:CAD:1.5", "AUD", "CAD"
            ),
            2,
        )
    )
    # Expected: 0.9

    # Test 3: no single-hop path
    print(get_best_single_hop_conversion_rate("AUD:USD:0.7", "AUD", "CAD"))
    # Expected: Error: no single-hop conversion found

    print("\nPart 4 (best with any hops)")
    # Test 1: longer path, more hops
    print(get_best_conversion_rate("A:B:2,B:C:2,C:D:2,A:D:5", "A", "D"))
    # Expected: 8.0 (A→B→C→D)

    # Test 2: cycle present but not used
    print(get_best_conversion_rate("A:B:2,B:C:2,C:A:0.5,C:D:3", "A", "D"))
    # Expected: 12.0 (A→B→C→D)

    # Test 3: empty input
    print(get_best_conversion_rate("", "AUD", "USD"))
    # Expected: Error: empty input string

    # Test 4: malformed input
    print(get_best_conversion_rate("AUD:USD:0.7,AUDUSD1", "AUD", "USD"))
    # Expected: Error: malformed entry 'AUDUSD1'

    # Test 5: invalid rate
    print(get_best_conversion_rate("AUD:USD:abc", "AUD", "USD"))
    # Expected: Error: invalid rate value 'abc' in 'AUD:USD:abc'

    # Test 6: unreachable target
    print(get_best_conversion_rate("AUD:USD:0.7", "AUD", "CAD"))
    # Expected: Error: no conversion path found

    # Test 7: case-sensitive failure
    print(get_best_conversion_rate("aud:usd:0.7,usd:cad:1.2", "AUD", "CAD"))
    # Expected: Error: no conversion path found

    # Test 8: zero rate
    print(get_best_conversion_rate("AUD:USD:0", "AUD", "USD"))
    # Expected: Error: non-positive rate '0.0' in 'AUD:USD:0'

    # Test 9: negative rate
    print(get_best_conversion_rate("AUD:USD:-1.2", "AUD", "USD"))
    # Expected: Error: non-positive rate '-1.2' in 'AUD:USD:-1.2'
    