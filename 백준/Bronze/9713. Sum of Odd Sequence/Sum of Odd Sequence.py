import sys

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    n = int(input())
    temp = 0
    for i in range(1, n + 1):
        if i % 2 == 1:
            temp += i
    print(temp)
