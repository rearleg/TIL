import sys
input = sys.stdin.readline

n = int(input())
y = 2024
m = 8

m = m + 7 * (n - 1)
y = y + (m - 1) // 12
m = (m - 1) % 12 + 1

print(y, m)