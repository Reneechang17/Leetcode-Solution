def calculate_shipping_cost(order, shipping_cost):
    country = order.get("country")
    if not country:
        return "Error: country missing"
    
    items = order.get("items") or order.get("product") or []

    c_costs = shipping_cost.get(country)
    if c_costs is None:
        return f"Error: country '{country}' not in shipping_cost"
    
    # product -> correspoding stuffs
    p_map = {p["product"]: p for p in c_costs}
    total = 0

    for it in items:
        name = it.get("product")
        qty = it.get("quantity", 0)

        if not name or qty <= 0:
            continue

        info = p_map.get(name)
        if info is None:
            return f"Error: product '{name}' not in shipping_cost for {country}"
        
        # Part 1: flat cost
        if "cost" in info and "costs" not in info:
            total += qty * info["cost"]
            continue

        # Part2/3: tiered costs
        if "costs" not in info:
            return f"Error: no 'cost' or 'costs' for product '{name}'"
        
        tiers = info["costs"]
        if not tiers:
            return f"Error: empty costs for product '{name}'"
        
        # sorted by minQuantity
        tiers = sorted(tiers, key=lambda t: t["minQuantity"])

        rem = qty
        
        for t in tiers:
            min_q = t.get("minQuantity", 0)
            max_q = t.get("maxQuantity", None)
            tier_cost = t.get("cost")
            t_type = t.get("type", "incremental") # default: incremental

            if tier_cost is None:
                return f"Error: missing cost in tier for product '{name}'"
            
            # calculate how many could be covered
            if max_q is None:
                use = rem
            else:
                cap = max_q - min_q
                if cap < 0:
                    cap = 0
                use = min(rem, cap)
            
            if use <= 0:
                continue

            if t_type == "incremental":
                total += use * tier_cost
            elif t_type == "fixed":
                total += tier_cost
            else:
                return f"Error: unknown cost type '{t_type}'"
            
            rem -= use
            if rem <= 0:
                break

    return total

# test
if __name__ == "__main__":
    order_us = {
        "country": "US",
        "items": [
            {"product": "mouse", "quantity": 20},
            {"product": "laptop", "quantity": 5},
        ],
    }

    order_ca = {
        "country": "CA",
        "items": [
            {"product": "mouse", "quantity": 20},
            {"product": "laptop", "quantity": 5},
        ],
    }

    # ---------- Part 1: flat cost ----------
    shipping_p1 = {
        "US": [
            {"product": "mouse", "cost": 550},
            {"product": "laptop", "cost": 1000},
        ],
        "CA": [
            {"product": "mouse", "cost": 750},
            {"product": "laptop", "cost": 1100},
        ],
    }

    print("Part 1")
    print("US:", calculate_shipping_cost(order_us, shipping_p1))  # 16000
    print("CA:", calculate_shipping_cost(order_ca, shipping_p1))  # 20500

    # ---------- Part 2: incremental tiers ----------
    shipping_p2 = {
        "US": [
            {
                "product": "mouse",
                "costs": [
                    {"minQuantity": 0, "maxQuantity": None, "cost": 550},
                ],
            },
            {
                "product": "laptop",
                "costs": [
                    {"minQuantity": 0, "maxQuantity": 2, "cost": 1000},
                    {"minQuantity": 3, "maxQuantity": None, "cost": 900},
                ],
            },
        ],
        "CA": [
            {
                "product": "mouse",
                "costs": [
                    {"minQuantity": 0, "maxQuantity": None, "cost": 750},
                ],
            },
            {
                "product": "laptop",
                "costs": [
                    {"minQuantity": 0, "maxQuantity": 2, "cost": 1100},
                    {"minQuantity": 3, "maxQuantity": None, "cost": 1000},
                ],
            },
        ],
    }

    print("\nPart 2")
    # US: 20 * 550 + 2 * 1000 + 3 * 900 = 15700
    print("US:", calculate_shipping_cost(order_us, shipping_p2))  # 15700
    # CA: 20 * 750 + 2 * 1100 + 3 * 1000 = 20200
    print("CA:", calculate_shipping_cost(order_ca, shipping_p2))  # 20200

    # ---------- Part 3: fixed + incremental ----------
    shipping_p3 = {
        "US": [
            {
                "product": "mouse",
                "costs": [
                    {
                        "type": "incremental",
                        "minQuantity": 0,
                        "maxQuantity": None,
                        "cost": 550,
                    }
                ],
            },
            {
                "product": "laptop",
                "costs": [
                    {
                        "type": "fixed",
                        "minQuantity": 0,
                        "maxQuantity": 2,
                        "cost": 1000,
                    },
                    {
                        "type": "incremental",
                        "minQuantity": 3,
                        "maxQuantity": None,
                        "cost": 900,
                    },
                ],
            },
        ],
        "CA": [
            {
                "product": "mouse",
                "costs": [
                    {
                        "type": "incremental",
                        "minQuantity": 0,
                        "maxQuantity": None,
                        "cost": 750,
                    }
                ],
            },
            {
                "product": "laptop",
                "costs": [
                    {
                        "type": "fixed",
                        "minQuantity": 0,
                        "maxQuantity": 2,
                        "cost": 1100,
                    },
                    {
                        "type": "incremental",
                        "minQuantity": 3,
                        "maxQuantity": None,
                        "cost": 1000,
                    },
                ],
            },
        ],
    }

    print("\nPart 3")
    # US: 20 * 550 + fixed(0-2)=1000 + 3 * 900 = 14700
    print("US:", calculate_shipping_cost(order_us, shipping_p3))  # 14700
    # CA: 20 * 750 + fixed(0-2)=1100 + 3 * 1000 = 19100
    print("CA:", calculate_shipping_cost(order_ca, shipping_p3))  # 19100

    print("\nExtra checks (US laptop only, Part 3 tiers):")
    for q in [1, 2, 3, 4]:
        test_order = {
            "country": "US",
            "items": [{"product": "laptop", "quantity": q}],
        }
        print(f"qty={q}: ", calculate_shipping_cost(test_order, shipping_p3))
        # 1 -> 1000 (fixed)
        # 2 -> 1000 (fixed)
        # 3 -> 1000 + 1*900 = 1900
        # 4 -> 1000 + 2*900 = 2800
