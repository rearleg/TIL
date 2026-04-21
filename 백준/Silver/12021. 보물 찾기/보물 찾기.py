import sys
from decimal import Decimal, getcontext

input = sys.stdin.readline

a, b = map(int, input().split())

getcontext().prec = 60

n = Decimal(a) * Decimal(b)
L = n.sqrt()

print(f"{L:.10f} {L:.10f}")