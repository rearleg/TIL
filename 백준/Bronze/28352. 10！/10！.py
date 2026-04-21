import sys

input = sys.stdin.readline

n = int(input())
x = 1

for i in range(1, n + 1):
    x *= i

print(int(x / (7 * 24 * 60 * 60)))
