import sys

input = sys.stdin.readline
T = int(input())

for _ in range(T):
    a, b = map(int, input().split())
    temp = 1
    x, y = a, b
    while y > 0:
        x, y = y, x % y

    answer = (a * b) / x
    print(int(answer))
