from collections import defaultdict

def calculate_fraud_scores(n, transactions_list, rules_list, m, merchants_list):
    # Parse transactions list
    transactions = []
    for trans in transactions_list:
        parts = trans.split(',')
        transactions.append({
            'merchant_id': parts[0],
            'amount': int(parts[1]),
            'customer_id': parts[2],
            'hour': int(parts[3])
        })
    
    # Parse rules list
    rules = []
    for r in rules_list:
        parts = r.split(',')
        rules.append({
            'min_amount': int(parts[0]),
            'multiplicative': float(parts[1]),
            'additive': int(parts[2]),
            'penalty': int(parts[3])
        })

    # Init merchant scores dict
    merchant_scores = {}
    for mer in merchants_list:
        parts = mer.split(',')
        merchant_id = parts[0]
        base_score = int(parts[1])
        merchant_scores[merchant_id] = float(base_score)

    tlim = min(n, len(transactions), len(rules))
    
    # Part1
    for i in range(tlim):
        trans = transactions[i]
        rule = rules[i]
        merchant_id = trans['merchant_id']
        amount = trans['amount']

        if amount > rule['min_amount']:
            merchant_scores[merchant_id] *= rule['multiplicative']
    
    # Part2
    cus_mer_add = defaultdict(list) # key=(cus_id, mer_id) -> [additive1, additive2, ..]
    for i in range(tlim):
        trans = transactions[i]
        rule = rules[i]
        key = (trans['customer_id'], trans['merchant_id'])
        cus_mer_add[key].append(rule['additive'])
        k = len(cus_mer_add[key])

        if k == 3:
            merchant_scores[trans['merchant_id']] += sum(cus_mer_add[key])
        elif k > 3:
            merchant_scores[trans['merchant_id']] += rule['additive']

    # Part3
    groups = defaultdict(list) # key=(customer_id, merchant_id, hour) -> [idx0, idx1, ...]
    for i in range(tlim):
        t = transactions[i]
        groups[(t['customer_id'], t['merchant_id'], t['hour'])].append(i)

    def time_sign(h):
        if 12 <= h <= 17:
            return +1
        if (9 <= h <= 11) or (18 <= h <= 21):
            return -1
        return 0
    
    for (cus, mer, h), idxs in groups.items():
        if len(idxs) >= 3:
            sgn = time_sign(h)
            if sgn != 0:
                for i in idxs:
                    pen = rules[i]['penalty']
                    merchant_scores[mer] += sgn * pen

    # Output
    res = []
    for merchant_id in sorted(merchant_scores.keys()):
        score = int(round(merchant_scores[merchant_id]))
        res.append(f"{merchant_id},{score}")
    
    return res

# Test case
if __name__ == "__main__":
    n = 6
    transactions_list = [
        "merchant1,1200,customer1,10",
        "merchant1,500,customer1,10",
        "merchant2,2400,customer1,15",
        "merchant1,800,customer1,16",
        "merchant1,1000,customer2,17",
        "merchant1,1400,customer1,10"
    ]
    rules_list = [
        "1000,2,8,15",
        "1400,5,3,19",
        "2300,3,17,3",
        "1800,2,9,6",
        "1000,4,8,2",
        "1200,3,11,7"
    ]
    m = 2
    merchants_list = [
        "merchant1,10",
        "merchant2,20"
    ]

    result = calculate_fraud_scores(n, transactions_list, rules_list, m, merchants_list)

    print("Output:")
    for line in result:
        print(line)

    print("\nExpected:")
    print("merchant1,50")
    print("merchant2,60")

    print("\nPassed or not:", result == ["merchant1,50", "merchant2,60"])
