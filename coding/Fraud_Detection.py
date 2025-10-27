from typing import List, Dict, Tuple

def calculate_merchant_fraud_score(transaction_list: List[str], rules_list: List[str], merchants_list: List[str]) -> List[str]:
    # Init merchant's score
    scores: Dict[str, int] = {}
    merchants: List[str] = []
    for s in merchants_list:
        m_id, v = [x.strip() for x in s.split(',', 1)]
        scores[m_id] = int(v)
        merchants.append(m_id)

    # Pairs transactions and rules by index: (merchant, amount, customer, hour, min_amount, mul, add, penalty)
    records: List[Tuple[str, int, str, int, int, int, int, int]] = []
    for i in range(len(transaction_list)):
        m_id, amt, c_id, hour = [x.strip() for x in transaction_list[i].split(',')]
        r_min, r_mul, r_add, r_pen = [x.strip() for x in rules_list[i].split(',')]
        records.append((m_id, int(amt), c_id, int(hour), int(r_min), int(r_mul), int(r_add), int(r_pen)))
    
    # Part1
    for m_id, amt, c_id, hour, min_amt, mul, add, pen in records:
        if m_id in scores and amt > min_amt:
            scores[m_id] = scores[m_id] * mul
    
    # Part2
    pair_cnt: Dict[str, int] = {}
    pair_sum: Dict[str, int] = {}
    for m_id, amt, c_id, hour, min_amt, mul, add, pen in records:
        if m_id not in scores:
            continue
        key = f"{m_id}#{c_id}"
        pair_cnt[key] = pair_cnt.get(key, 0) + 1
        pair_sum[key] = pair_sum.get(key, 0) + add
    
    for key, cnt in pair_cnt.items():
        if cnt >= 3:
            m_id = key.split('#', 1)[0]
            scores[m_id] = scores.get(m_id, 0) + pair_sum.get(key, 0)
    
    # Part3
    hour_cnt: Dict[str, int] = {}
    pen_sum: Dict[str, int] = {}
    hour_lookup: Dict[str, int] = {}

    for m_id, amt, c_id, hour, min_amt, mul, add, pen in records:
        if m_id not in scores:
            continue
        key = f"{m_id}#{c_id}#{hour}"
        hour_cnt[key] = hour_cnt.get(key, 0) + 1
        pen_sum[key] = pen_sum.get(key, 0) + pen
        hour_lookup.setdefault(key, hour)
    
    for key, cnt in hour_cnt.items():
        if cnt >= 3:
            h = hour_lookup[key]
            s = 1 if 12 <= h <= 17 else (-1 if (9 <= h <= 11) or (18 <= h <= 21) else 0)
            if s:
                m_id = key.split('#', 1)[0]
                scores[m_id] = scores.get(m_id, 0) + s * pen_sum[key]
    
    merchants.sort()
    return [f"{m_id},{scores.get(m_id, 0)}" for m_id in merchants]
