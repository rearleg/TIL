import sys

input = sys.stdin.readline

h, m = map(int, input().rstrip().split(":"))

key_pad = {
    1: (0, 0),
    2: (1, 0),
    3: (2, 0),
    4: (0, 1),
    5: (1, 1),
    6: (2, 1),
    7: (0, 2),
    8: (1, 2),
    9: (2, 2),
    0: (1, 3),
}


def dist(a, b):
    (r1, c1), (r2, c2) = key_pad[a], key_pad[b]
    return abs(r1 - r2) + abs(c1 - c2)


best = 10**9
best_str = None

for hh in range(100):
    for mm in range(100):
        if (hh % 24) is not h or (mm % 60) is not m:
            continue

        a, b = divmod(hh, 10)
        c, d = divmod(mm, 10)
        cost = dist(a, b) + dist(b, c) + dist(c, d)

        cand = f"{hh:02d}:{mm:02d}"
        if cost < best:
            best = cost
            best_str = cand
        elif cost == best and cand < best_str:
            best_str = cand

print(best_str)
