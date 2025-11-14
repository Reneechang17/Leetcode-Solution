from typing import *

def ipv4_to_int(ip: str) -> int:
    a, b, c, d = map(int, ip.split('.'))
    return a*256**3 + b*256**2 + c*256 + d

def parse_cidr(s: str) -> Tuple[int, int, int, int]:
    # return (start, end, block, p)
    # block = 2^(32-p)
    # start = base - (base%block)
    # end = start + block - 1
    if '/' in s:
        ip, p_str = s.split('/')
        p = int(p_str)
    else:
        ip, p = s, 32
    base = ipv4_to_int(ip)
    block = int(pow(2, 32 - p))
    start = base - (base % block) # 对齐block边界
    end = start + block - 1
    return start, end, block, p

def ip_in_cidr(ip: str, cidr: str) -> bool:
    # check if ip in given cidr
    x = ipv4_to_int(ip)
    start, end, block, _ = parse_cidr(cidr)
    return (x // block) == (start // block) # start <= x <= end

# v1: check single ip
def is_ip_allowed(rules: List[Tuple[str, str]], ip: str, default_deny: bool = True) -> bool:
    for action, pattern in rules:
        if ip_in_cidr(ip, pattern):
            return action.upper() == "ALLOW"
    return not default_deny

# v2: check if all allow for the CIDR seg
def substract_segment(segL: int, segR: int, cutL: int, cutR: int):
    L, R= segL, segR
    CL, CR = max(L, cutL), min(R, cutR)
    if CL > CR: # no intersection
        return [(L, R)]
    output = []
    if L <= CL - 1:
        output.append((L, CL - 1))
    if CR + 1 <= R:
        output.append((CR + 1, R))
    return output

def is_cidr_all_allowed(rules: List[Tuple[str, str]], query_cidr: str, default_deny: bool = True) -> bool:
    qS, qE, _, _ = parse_cidr(query_cidr)
    pending = [(qS, qE)]

    for action, pat in rules:
        rS, rE, _, _ = parse_cidr(pat)
        new_pending = []
        for L, R in pending:
            # intersection with current rule
            cL, cR = max(L, rS), min(R, rE)
            if cL <= cR:
                if action.upper() == "DENY":
                    return False
                remain = substract_segment(L, R, cL, cR)
                new_pending.extend(remain)
            else:
                new_pending.append((L, R))
        
        pending = new_pending
        if not pending:
            return True # fully covered by allow
    
    if pending:
        return False if default_deny else True
    return True
