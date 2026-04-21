import sys

input = sys.stdin.readline

k, p, x = map(int, input().split())

m = 1
prev = x + k * p
min_cost = x + k * p

while True:
    cost = m * x + (k / m) * p
    min_cost = min(min_cost, cost)

    if cost > prev:
        break

    prev = cost
    m += 1

print(f"{min_cost:.3f}")
