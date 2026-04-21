import sys
input = sys.stdin.readline

t = int(input())

a = 0

for i in range(t):
    n = int(input())
    for j in range(1, n + 1):
        a += j * ((j + 1) * (j + 2) // 2)
    print(a)
    a = 0
