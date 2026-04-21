import sys

input = sys.stdin.readline


def gcd(a, b):
    while b:
        a, b = b, a % b
    return a


t = int(input())
for _ in range(t):
    a, b = map(int, input().split())
    print(abs(a * b) // gcd(a, b))
