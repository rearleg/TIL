import sys

input = sys.stdin.readline

n, m, k = map(int, input().split())
close = n * m
lst = []

for _ in range(k):
    a, b = map(int, input().split())
    temp = (a - 1) + ((m + 1) - b)
    if temp < close:
        close = temp

    lst.append(temp)

print(lst.index(close) + 1)
